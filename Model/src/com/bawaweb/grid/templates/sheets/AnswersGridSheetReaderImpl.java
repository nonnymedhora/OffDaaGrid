/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.sheets;


import com.bawaweb.grid.templates.AnswersGridTemplateRangeConstants;
import com.bawaweb.grid.templates.data.ReportTemplateInfo;
import com.bawaweb.grid.templates.data.ReportTemplateInfoDataSet;
import com.bawaweb.grid.templates.data.cursors.MultiQuestionDataSetInfo;
import com.bawaweb.grid.templates.data.cursors.QuestionDataSetInfo;
import com.bawaweb.grid.templates.data.cursors.SourceAnswersDataSet;
import com.bawaweb.grid.templates.data.cursors.SourceAnswersDataSetInfo;
import com.bawaweb.grid.templates.data.tables.AnswerSetValuesDataSetInfo;
import com.bawaweb.grid.templates.data.tables.ReportAnswerSetValuesDataSetInfo;
import com.bawaweb.grid.templates.data.tables.ReportSourcesDataSet;
import com.bawaweb.grid.templates.data.tables.ReportSourcesDataSetInfo;
import com.bawaweb.grid.templates.data.tables.SortingCriteriaValuesDataSetInfo;
import com.bawaweb.grid.templates.data.tables.SourceDataSet;
import com.bawaweb.grid.templates.data.tables.SourceDataSetInfo;
import com.bawaweb.services.PlatformAppModuleService;
import com.bawaweb.services.PlatformAppModuleServiceImpl;
import com.bawaweb.utils.Pair;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import jxl.Cell;
import jxl.CellFeatures;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.CellFormat;
import jxl.format.Colour;
import jxl.format.RGB;
import jxl.read.biff.BiffException;
import jxl.write.Blank;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.NumberFormat;
import jxl.write.NumberFormats;
import jxl.write.WritableCell;
import jxl.write.WritableCellFeatures;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableHyperlink;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.log4j.Logger;


/**
 * This class will read in the AnswersSheet and re-construct the 
 * ReportTemplateInfo object therein --- it will also validate the data
 */
public class AnswersGridSheetReaderImpl implements AnswersGridSheetReader {
    private static final Logger LOG = Logger.getLogger(AnswersGridSheetReaderImpl.class);

    private static AnswersGridSheetReaderImpl _instance = null;

//    public final static int REPORTER_ID = 54054;

    public final static String EXCEL_FILE = "\\\\san-sv-filer\\nmedhora$\\my documents\\jxlTesting\\test_latest.xls";
//    public final static String EXCEL_FILE = "\\\\san-sv-filer\\nmedhora$\\my documents\\jxlTesting\\test_latest_adf.xls";
//    public final static String EXCEL_FILE = "\\\\san-sv-filer\\nmedhora$\\my documents\\jxlTesting\\test_latest_adf_upd.xls";
//    public final static String EXCEL_FILE = "\\\\san-sv-filer\\nmedhora$\\my documents\\jxlTesting\\test123_SINGLE.xls";
    
    
    // the .xls file containing the answers grid 
    private File theFile;
    
    // the workbook object within the xls file
    private Workbook workbook;
    
    // the answers_sheet worksheet
    private Sheet answersSheet;
    
    // the intro worksheet
    private Sheet introSheet;
    
    // the questions with additonal answer-sets sheet
    private Sheet extraQstnAnswersSheet;
    
    // the extra sources sheet
    private Sheet extraSourcesSheet;;
    
    // the underlying report-template object which will be persisted
    // to the database using adf-bc
    private ReportTemplateInfo reportInfo;      
    
    
    // the list of sources withihn the report-template object
    private List<SourceDataSetInfo> theSources;
    
    // the list of questions of the report-template object
    // which also contains the source-answer data
    private List<QuestionDataSetInfo> theQuestions;
    
    // all maps will have the format of key - questioninfo data value - column in answers sheet
    // the map of rows and their source info -- row 6 sourc xyz
    private Map<Integer, SourceDataSetInfo> mp_Row_Sources;
    
    // the map of sourceid and the corresponding rows
    private Map<Integer, Integer> mp_RepSourceIds_Rows;
    private Map<Integer, Integer> mp_ExtraRepSourceIds_Rows;
    
    // the list of sourceids -- which can also be got as a set from mp_Row_SourceIds.values()
    private List<Integer> li_RepSourceIds;
    
    // the map of columns to the questions data --- col 7 string colhdr- 36571_M_1_S, etc 
    // the map is generated from the first hidden row which contains the tag info of the questions
    // the mp_Col_QuestionTags -- key qstnHdrInfo, value columns,  36568_M_1_D ==> 30
    private Map<String, Integer> mp_QuestionTag_Col; 
    
    // the map of columns and the corresponding questionIds key - qstnid, value column-- , 36567 ==> 47
    private Map<Integer, Integer> mp_QuestionId_Col;
    
    // the map of questionIds and the corresponding column for hintscolumns key - column, value -- qstnid, 47 ==> 36567
    private Map<Integer, Integer> mp_QuestionHint_Col;  // maps qstid and hintcols, 36567 ==> 49
    
    // the map of questionIds and the list of all columns to be covered for that question
    // 36567 ==> [49, 50]...
    private Map<Integer, ArrayList<Integer>> mp_Question_ColumnList;
    
    // the list of question id strings - can also be got as a set from mp_Col_QuestionIdInfo.values()
    private List<String> li_questionInfos;
    
    private List<Integer> li_baseQstIds;
    
    
    // list of warning messages
    private List<String> li_warnings;
    
    // list of error messages
    private List<String> li_errors;
    
       //  maps question ids which can have additional ans sets to the cols in the Extra_Questions Sheets
    private Map<Integer, Integer> mp_ExtraQuestionsAnswersId_Col;
    
    
    private boolean isAllClear = false;
    
    private int start_ans_col = 0;
    private int start_ans_row = 0;
    private int end_ans_col = 0;
    private int end_ans_row = 0;
    
    /*private*/ public AnswersGridSheetReaderImpl() {
        this.theSources = new ArrayList<SourceDataSetInfo>();
        this.theQuestions = new ArrayList<QuestionDataSetInfo>();
        this.mp_Row_Sources = new HashMap<Integer, SourceDataSetInfo>();
        this.mp_QuestionTag_Col = new HashMap<String, Integer>();
        
        this.li_errors = new ArrayList<String>();
        this.li_warnings = new ArrayList<String>();
        this.mp_RepSourceIds_Rows = new HashMap<Integer, Integer>();
        this.mp_ExtraRepSourceIds_Rows = new HashMap<Integer, Integer>();
        this.li_RepSourceIds = new ArrayList<Integer>();
        
        this.li_questionInfos = new ArrayList<String>();
        this.li_baseQstIds = new ArrayList<Integer>();
        this.mp_QuestionId_Col = new HashMap<Integer, Integer>();
        this.mp_Row_Sources = new HashMap<Integer, SourceDataSetInfo>();
        this.mp_QuestionHint_Col = new HashMap<Integer, Integer>();
        this.mp_Question_ColumnList = new HashMap<Integer, ArrayList<Integer>>();
        
        this.mp_R1C1Map = buildMp_R1C1Map();
        
        this.mp_ExtraQuestionsAnswersId_Col = new HashMap<Integer, Integer>();
    }
    
    public static synchronized AnswersGridSheetReaderImpl getInstance() {
//        if (_instance == null) {
            _instance = new AnswersGridSheetReaderImpl();
//        }
        return _instance;
    } 

    public void setTheFile(File file) {
        if ( file == null ) throw new IllegalArgumentException("File path is invalid");
        if ( !file.getName().endsWith(".xls") ) throw new IllegalArgumentException("Invalid file sent - must be an XLS file");
        if ( file.length() == 0 )  throw new IllegalArgumentException("Invalid file size -- is empty");
        this.theFile =  file;
    }

    public File getTheFile() {
        return this.theFile;
    }

    public void setWorkbook(Workbook workbook) {
        this.workbook = workbook;
    }

    public Workbook getWorkbook() {
        return this.workbook;
    }

    public void setAnswersSheet(WritableSheet answersSheet) {
        this.answersSheet = answersSheet;
    }

    public void setIntroSheet(WritableSheet sheet) {
        this.introSheet = sheet;
    }
    
    public void setExtraQstnAnswersSheet(WritableSheet sheet) {
        this.extraQstnAnswersSheet = sheet;
    }
    
    public void setExtraSourcesSheet(WritableSheet s) {
        this.extraSourcesSheet = s;
    }

    public Sheet getAnswersSheet() {
        return this.answersSheet;
    }

    public Sheet getIntroSheet() {
        return this.introSheet;
    }
    
    public Sheet getExtraQstnAnswersSheet() {
        return this.extraQstnAnswersSheet;
    }
    
    public Sheet getExtraSourcesSheet() {
        return this.extraSourcesSheet;
    }

    public void setReportInfo(ReportTemplateInfo reportInfo) {
        this.reportInfo = reportInfo;
    }

    public ReportTemplateInfo getReportInfo() {
        return reportInfo;
    }

    public void setTheSources(List<SourceDataSetInfo> theSources) {
        this.theSources = theSources;
    }

    public List<SourceDataSetInfo> getTheSources() {
        return this.theSources;
    }

    public void setTheQuestions(List<QuestionDataSetInfo> theQuestions) {
        this.theQuestions = theQuestions;
    }

    public List<QuestionDataSetInfo> getTheQuestions() {
        return this.theQuestions;
    }

    public void setMp_Row_Sources(Map<Integer, SourceDataSetInfo> mp_Row_Sources) {
        this.mp_Row_Sources = mp_Row_Sources;
    }

    public Map<Integer, SourceDataSetInfo> getMp_Row_Sources() {
        return this.mp_Row_Sources;
    }

    public void setMp_QuestionTag_Col(Map<String, Integer> mp_Col_Questions) {
        this.mp_QuestionTag_Col = mp_Col_Questions;
    }

    public Map<String, Integer> getMp_QuestionTag_Col() {
        return this.mp_QuestionTag_Col;
    }
    
    public Map<Integer, Integer> getMp_ExtraQuestionsAnswersId_Col() {
        return this.mp_ExtraQuestionsAnswersId_Col;
    }
    
    public void setMp_ExtraQuestionsAnswersId_Col(Map<Integer, Integer> map) {
        this.mp_ExtraQuestionsAnswersId_Col = map;
    }
    
    public List<String> getLi_QuestionTags() {
        List qstnTags = null;
        
        if ( this.getMp_QuestionTag_Col() != null ) {
            qstnTags = new ArrayList<String>();
            Set<String> keys = this.getMp_QuestionTag_Col().keySet();
            for ( Iterator<String> it = keys.iterator(); it.hasNext(); ) {
                qstnTags.add(it.next());
            }
            
            Collections.sort(qstnTags);
        }
        return qstnTags;
    }
    
    public void setMp_ExtraRepSourceIds_Rows(Map<Integer, Integer> mp) {
        this.mp_ExtraRepSourceIds_Rows = mp;
    }
    
    public Map<Integer, Integer> getMp_ExtraRepSourceIds_Rows() {
        return this.mp_ExtraRepSourceIds_Rows;
    }


    public void setMp_RepSourceIds_Rows(Map<Integer, Integer> mp_Row_SourceIds) {
        this.mp_RepSourceIds_Rows = mp_Row_SourceIds;
    }

    public Map<Integer, Integer> getMp_RepSourceIds_Rows() {
        return this.mp_RepSourceIds_Rows;
    }

    public void setLi_RepSourceIds(List<Integer> li_sourceIds) {
        this.li_RepSourceIds = li_sourceIds;
    }

    public List<Integer> getLi_RepSourceIds() {
        return this.li_RepSourceIds;
    }

    public File get_theFile() {
        return this.theFile;
    }

    public Workbook get_workbook() {
        return this.workbook;
    }

    public Sheet get_answersSheet() {
        return this.answersSheet;
    }

    public List<SourceDataSetInfo> get_theSources() {
        return this.theSources;
    }

    public List<QuestionDataSetInfo> get_theQuestions() {
        return this.theQuestions;
    }

    public Map<Integer, SourceDataSetInfo> get_mp_Row_Sources() {
        return mp_Row_Sources;
    }

    public Map<String, Integer> get_mp_Col_Questions() {
        return this.mp_QuestionTag_Col;
    }

    public void setMp_QuestionId_Col(Map<Integer, Integer> mp_Col_QuestionInfo) {
        this.mp_QuestionId_Col = mp_Col_QuestionInfo;
    }

    public Map<Integer, Integer> getMp_QuestionId_Col() {
        return this.mp_QuestionId_Col;
    }

    public void setLi_questionInfos(List<String> li_questionInfos) {
        this.li_questionInfos = li_questionInfos;
    }

    public List<String> getLi_questionInfos() {
        return this.li_questionInfos;
    }

    public void setLi_baseQstIds(List<Integer> li_baseQstIds) {
        this.li_baseQstIds = li_baseQstIds;
    }

    public List<Integer> getLi_baseQstIds() {
        return this.li_baseQstIds;
    }

    public void setLi_warnings(List<String> li_warnings) {
        this.li_warnings = li_warnings;
    }

    public List<String> getLi_warnings() {
        return this.li_warnings;
    }

    public void setLi_errors(List<String> li_errors) {
        this.li_errors = li_errors;
    }

    public List<String> getLi_errors() {
        return this.li_errors;
    }

    public void setIsAllClear(boolean isAllClear) {
        this.isAllClear = isAllClear;
    }

    public boolean isIsAllClear() {
        return this.isAllClear;
    }

    public void setStart_ans_col(int start_ans_col) {
        this.start_ans_col = start_ans_col;
    }

    public int getStart_ans_col() {
        return this.start_ans_col;
    }

    public void setStart_ans_row(int start_ans_row) {
        this.start_ans_row = start_ans_row;
    }

    public int getStart_ans_row() {
        return this.start_ans_row;
    }

    public void setEnd_ans_col(int end_ans_col) {
        this.end_ans_col = end_ans_col;
    }

    public int getEnd_ans_col() {
        return this.end_ans_col;
    }

    public void setEnd_ans_row(int end_ans_row) {
        this.end_ans_row = end_ans_row;
    }

    public int getEnd_ans_row() {
        return this.end_ans_row;
    }
    
    public Map<Integer, Integer> get_mp_Row_SourceIds() {
        return this.mp_RepSourceIds_Rows;
    }
    
    public Map<Integer, Integer> get_mp_Row_ExtraRepSourceIds() {
        return this.mp_ExtraRepSourceIds_Rows;
    }

    public List<Integer> get_li_sourceIds() {
        return this.li_RepSourceIds;
    }

    public Map<Integer, Integer> get_mp_Col_QuestionInfo() {
        return this.mp_QuestionId_Col;
    }

    public void setMp_QuestionHint_Col(Map<Integer, Integer> mp_Col_QuestionHint) {
        this.mp_QuestionHint_Col = mp_Col_QuestionHint;
    }

    public Map<Integer, Integer> getMp_QuestionHint_Col() {
        return this.mp_QuestionHint_Col;
    }

    public void setMp_Question_ColumnList(Map<Integer, ArrayList<Integer>> mp_Question_ColList) {
        this.mp_Question_ColumnList = mp_Question_ColList;
    }

    public Map<Integer, ArrayList<Integer>> getMp_Question_ColumnList() {
        return this.mp_Question_ColumnList;
    }

    public List<String> get_li_questionInfos() {
        return this.li_questionInfos;
    }

    public List<Integer> get_li_baseQstIds() {
        return this.li_baseQstIds;
    }

    public List<String> get_li_warnings() {
        return this.li_warnings;
    }

    public List<String> get_li_errors() {
        return this.li_errors;
    }

    public boolean is_isAllClear() {
        return this.isAllClear;
    }

    public int get_start_ans_col() {
        return this.start_ans_col;
    }

    public int get_start_ans_row() {
        return this.start_ans_row;
    }

    public int get_end_ans_col() {
        return this.end_ans_col;
    }

    public int get_end_ans_row() {
        return this.end_ans_row;
    }
    
//    
//    public static void main(String[] args) throws Exception {
//    
//        long rightNowNanoTime = System.nanoTime();  
//        
//        AnswersGridSheetReaderImpl answersGridSheetReaderImpl = new AnswersGridSheetReaderImpl();
//        File aFile = new java.io.File(EXCEL_FILE);
//        answersGridSheetReaderImpl.setTheFile( aFile );
//        
//        Workbook wbook = answersGridSheetReaderImpl.extractWorkbook(aFile);
//        
//        int reportId = answersGridSheetReaderImpl.getReportId(wbook);
//        if ( reportId == 0 ) throw new Exception("Invalid report id - 0" );
//        
//        Sheet answersSheet = answersGridSheetReaderImpl.extractAnswersSheet(wbook);
//        
//        // start with null and build up
//        ReportTemplateInfo reportInfo = new ReportTemplateInfoDataSet();
//        if ( reportId != 0 ) reportInfo.setReportId(reportId);
//        else throw new Exception ("ReportId was invalid as 0");
//        
//        answersGridSheetReaderImpl.setReportInfo(reportInfo);
//        
//        List<Integer> sourceIds = answersGridSheetReaderImpl.extractTheSourceIds(answersSheet);
//        
//        List<String> questionIds = answersGridSheetReaderImpl.extractTheQuestionsInfo(answersSheet);
//        
//        
//        
//        /******fn*******/
//        ReportTemplateInfo existingReportTemplate = answersGridSheetReaderImpl.buildExistingReportTemplate(reportId);
//        //fn******fn********/
//        
//        LinkedHashMap<Integer, QuestionDataSetInfo> existingQstns       = existingReportTemplate.getQuestionsDataSetMap();
//        LinkedHashMap<Integer, SourceDataSetInfo>   existingSrcs        = existingReportTemplate.getSourcesDataSetMap();
//        List<String>                                existingQstnTags    = existingReportTemplate.buildQuestionTags();
//        List<SourceAnswersDataSetInfo>              existingSrcAnswers  = existingReportTemplate.getListOfSourceAnswers();
//        Map<String, String>                         existingQtypeMap    = existingReportTemplate.buildQuestionTypeMap();
//        
//        
//        LOG.info("\n****************\nExisting qstn tags\n***********");
//        answersGridSheetReaderImpl.printList(existingQstnTags);
//        
//        
//        LOG.info("\n__________\nExisting Qtype Map \n___________");
//        answersGridSheetReaderImpl.printMap(existingQtypeMap);
//        
////rem1        LOG.info("\n__________\nExisting Questions linkedmap \n___________");
////rem1        printQMap(existingQstns);
////rem1        LOG.info("\n__________\nExisting Srcs \n___________");
////rem1        printSrcMap(existingSrcs);  
//        
//        
//        
//        
//        
//        LOG.info("\n\nLi_sourceIds \n\n\n" + answersGridSheetReaderImpl.getLi_RepSourceIds());
//        LOG.info("\n\nLi_questionInfos \n\n\n" + answersGridSheetReaderImpl.getLi_questionInfos());
//        
//        LOG.info("\n\n\n*******mp_Col_QuestionIdInfo******");
//        answersGridSheetReaderImpl.printMap(answersGridSheetReaderImpl.getMp_QuestionId_Col());
//        
//        LOG.info("\n\n\n******mp_Col_QuestionTags***");
//        answersGridSheetReaderImpl.printMap(answersGridSheetReaderImpl.getMp_QuestionTag_Col());
//        
//        LOG.info("\n\n\n*****mp_Row_SourceIds****");
//        answersGridSheetReaderImpl.printMap(answersGridSheetReaderImpl.getMp_RepSourceIds_Rows());
//        
//        LOG.info("\n\n\n**********col row coood********");
//        LOG.info("start_ans_col " + answersGridSheetReaderImpl.getStart_ans_col());
//        LOG.info("start_ans_row " + answersGridSheetReaderImpl.getStart_ans_row());
//        LOG.info("end_ans_col " + answersGridSheetReaderImpl.getEnd_ans_col());
//        LOG.info("end_ans_row " + answersGridSheetReaderImpl.getEnd_ans_row());
//        
//        LOG.info("\n\n*******QstnId, HintCol Map");
//        answersGridSheetReaderImpl.printMap(answersGridSheetReaderImpl.getMp_QuestionHint_Col());
//        
//        LOG.info("\n\n*******QstnId, mp_Question_ColList Map");
//        answersGridSheetReaderImpl.printMap(answersGridSheetReaderImpl.getMp_Question_ColumnList());
//        
//        Map<Integer, Integer> mpRepSrcIdSrcId = existingReportTemplate.getMap_RepSrcId_SrcId();
//        
////        LOG.info("\n\n\n*******mp_Row_Sources**");
////        printMap(answersGridSheetReaderImpl.mp_Row_Sources);
//          List<SourceAnswersDataSetInfo> srcAnswers =  answersGridSheetReaderImpl.buildSourceAnswersMap(answersGridSheetReaderImpl.get_answersSheet(), existingQstns, mpRepSrcIdSrcId);//, existingQstns, existingSrcs);
////        List<SourceAnswersDataSetInfo> srcAnswers =  answersGridSheetReaderImpl.buildSourceAnswersMap(answersGridSheetReaderImpl.getStart_ans_col(), answersGridSheetReaderImpl.getStart_ans_row(), answersGridSheetReaderImpl.getEnd_ans_col(), answersGridSheetReaderImpl.getEnd_ans_row(), answersGridSheetReaderImpl.get_answersSheet());
//
// LOG.info("\n\n*******srcAnswers");        
//         answersGridSheetReaderImpl.printList(srcAnswers);
//        
//         long endNowNanoTime = System.nanoTime();
//         LOG.info("Duration nanoseconds " + (endNowNanoTime - rightNowNanoTime));
//         LOG.info("Duration Seconds " +  ((endNowNanoTime - rightNowNanoTime)/(.0000000001)));
//         System.exit(0);
//        
//        
//    }

    // builds  / generates the existing report info from the database
    public ReportTemplateInfo buildExistingReportTemplate(int reportId, int reporterId) throws IOException {
        ReportTemplateInfo existingReportTemplate = null;
        
        PlatformAppModuleService service = PlatformAppModuleServiceImpl.getInstance();
        existingReportTemplate = service.getReportInfo(reportId, reporterId);
        return existingReportTemplate;
    }

    // returns the workbook within the file and sets the workbook instance variable
    public Workbook extractWorkbook(File aFile) {
        Workbook wbook = null;
        try {
            wbook = Workbook.getWorkbook(new FileInputStream(aFile));
        } catch (BiffException e) {
            System.err.println("Error in getting workbook");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("IO Error in getting workbook");
            e.printStackTrace();
        }
        
        return this.workbook = wbook;
    }
    
    public int getReporterId(Workbook wbook) {
        int reporterid = 0;
        Sheet intro = wbook.getSheet(AnswersGridTemplateRangeConstants.INTRO_SHEET_NAME);
        if ( intro == null ) { LOG.info("Couldn't find sheet " + AnswersGridTemplateRangeConstants.INTRO_SHEET_NAME); return reporterid;}
     
        if ( intro.getCell(0,1).getContents().equals("Reporter Id") ) {
        
            if ( intro.getCell(1,1).getContents() != "" || intro.getCell(1,1).getType() != CellType.EMPTY ) {
                try {
                    reporterid = Integer.parseInt(intro.getCell(1,1).getContents());

                } catch (NumberFormatException nfe) {
                    this.li_errors.add("Error Reporter Id is invalid in sheet " + 
                        AnswersGridTemplateRangeConstants.INTRO_SHEET_NAME + 
                        " in col B row 1 -- found " + intro.getCell(1,1).getContents());
                    LOG.error("Error Reporter Id is invalid in sheet " + 
                        AnswersGridTemplateRangeConstants.INTRO_SHEET_NAME + 
                        " in col B row 1 -- found " + intro.getCell(1,1).getContents(), nfe);
//                    nfe.printStackTrace();
                }
            }
        }
        return reporterid;
    }

    public int getReportId(Workbook wbook) {
        int reportid = 0;
        Sheet intro = wbook.getSheet(AnswersGridTemplateRangeConstants.INTRO_SHEET_NAME);
        if ( intro == null ) { LOG.info("Couldn't find sheet " + AnswersGridTemplateRangeConstants.INTRO_SHEET_NAME); return reportid;}
     
        if ( intro.getCell(0,0).getContents().equals("Report Id") ) {
        
            if ( intro.getCell(1,0).getContents() != "" || intro.getCell(1,0).getType() != CellType.EMPTY ) {
                try {
                    reportid = Integer.parseInt(intro.getCell(1,0).getContents());

                } catch (NumberFormatException nfe) {
                    this.li_errors.add("Error Report Id is invalid in sheet " + 
                        AnswersGridTemplateRangeConstants.INTRO_SHEET_NAME + 
                        " in col B row 1 -- found " + intro.getCell(1,0).getContents());
                    LOG.error("Error Report Id is invalid in sheet " + 
                        AnswersGridTemplateRangeConstants.INTRO_SHEET_NAME + 
                        " in col B row 1 -- found " + intro.getCell(1,0).getContents(), nfe);                        
//                    nfe.printStackTrace();
                }
            }
        }
        return reportid;
    }
    
    // returns the answers-grid sheet within the file and sets the answers_grid sheet instance variable
    public Sheet extractAnswersSheet(Workbook wbook) {
        Sheet sheet = null;        
        sheet = wbook.getSheet(AnswersGridTemplateRangeConstants.ANSWERS_GRID_SHEET_NAME);
        return this.answersSheet = sheet;
    }
    
    public Sheet extractIntroSheet(Workbook wbook) {
        Sheet sheet = null;        
        sheet = wbook.getSheet(AnswersGridTemplateRangeConstants.INTRO_SHEET_NAME);
        return this.introSheet = sheet;
    }
    
    public Sheet extractExtraQuestionAnswersSheet(Workbook w) {
        Sheet sheet = null;
        sheet = w.getSheet(AnswersGridTemplateRangeConstants.EXTRA_QUESTION_ANS_SHEET_NAME);
        return this.extraQstnAnswersSheet = sheet;
    }
    
    public Sheet extractExtraSourcesSheet(Workbook wbook) {
        Sheet sheet = null;
        sheet = wbook.getSheet(AnswersGridTemplateRangeConstants.EXTRA_SOURCES_SHEET_NAME);
        return this.extraSourcesSheet = sheet;
    }

    /**
     * Extracts and retrieves the report sources information from the AnswersSheet.
     * <p>The list also includes the information for valid additional sources from the ExtraSourcesSheet
     * <p>It also builds up the map connecting the [existing] report source ids to the rows in the AnswersSheet
     * <p> as well as for the extra sources based on the internal ids 
     * @param ansSheet  -- the Answers Grid worksheet
     * @param mp_internalsrcid_src  -- the map connecting the internal-source-ids of the ExtraSourcesSheet to the extra sources data objects
     * @return li_RepSourceIds -- a list of report source ids combining both existing and extra sources
     */
    public List<Integer> extractTheReportSourceInfo(Sheet ansSheet, Map<Integer, SourceDataSetInfo> mp_internalsrcid_src) { 
System.out.println("In A extraReportSrcInfo --- mp_internalsrcid_src is " + mp_internalsrcid_src);    
        if ( ansSheet != null ) {
            try {
                Sheet s = ansSheet;
                // check for plz dont change
                if ( ! s.getCell(0,0).getContents().equals(AnswersGridTemplateRangeConstants.PLS_DONT_CHANGE_ROW_COL) ) {
                    LOG.info(s.getCell(0,0).getContents());
                    this.li_warnings.add("Contents in hidden col and row changes :((");
                    this.li_errors.add("Contents in hidden col and row changes :((");
                    LOG.error("Contents in hidden col and row changes :((");
                    return null;
                }
                
                // src ids are in 0 col.
                // srcs are along the row
                // set start_ans_row and end_ans_row using the min and max row values
                final int col = 0;
                int start_row = 0;
                int end_row = 0;
                
                Cell[] theSrcCells = s.getColumn(col);
                
                for ( int i = 0; i < theSrcCells.length; i++ ) {
                    Cell theSrcCell = theSrcCells[i];
                    String theContents = theSrcCell.getContents();
                    int row = theSrcCell.getRow();
                    if ( theContents.equals(AnswersGridTemplateRangeConstants.PLS_DONT_CHANGE_ROW_COL) || theContents.equals("") ) continue;
                    
                    // labels for extraSrcs
                    if ( theContents.startsWith( AnswersGridTemplateRangeConstants.EXTRA_SRC_LABEL ) )  {
                        int extraSrcIntrnalId = Integer.parseInt( theContents.substring( theContents.indexOf('_') + 1 ) );
System.out.println("in a  -- extraSrcInternalId is " + extraSrcIntrnalId );
                         
                        if (  mp_internalsrcid_src != null && mp_internalsrcid_src.get(extraSrcIntrnalId) != null ) {
                            this.mp_ExtraRepSourceIds_Rows.put( mp_internalsrcid_src.get(extraSrcIntrnalId).getRps_id(), row );
                        }
                    } else { 
                        try {
                            int rep_srcId = Integer.parseInt(theContents);
                            
                            this.mp_RepSourceIds_Rows.put(rep_srcId, row );
                            
                            if ( row > end_row )        end_row = row;
                            if ( start_row == 0 )       start_row = row;
                            if ( row < start_row )      start_row = row;
                            
                            if (!this.li_RepSourceIds.contains(rep_srcId) ) 
                                this.li_RepSourceIds.add(rep_srcId);
                            
                        } catch (NumberFormatException nfe) {
                        
                            this.li_errors.add("Error in col " + col + " and row " + theSrcCells[i].getRow() + " number expected found " + theContents);
                            LOG.error("Error in col " + col + " and row " + theSrcCells[i].getRow() + " number expected found " + theContents, nfe);    //                        nfe.printStackTrace();
                        }
                    }
                }
                
                this.setStart_ans_row(start_row);
                this.setEnd_ans_row(end_row);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
LOG.info("tBaWaWEBLL " + this.li_RepSourceIds.size() + " SOURCES");        
        return this.li_RepSourceIds;
    }
    
    
    public List<String> extractSourceNames(Sheet ansSheet, Map<Integer, Integer> mapOfSourceIdRows) {
        List<String> l_srcNames = new ArrayList<String>();
        
        if ( ansSheet != null &&  mapOfSourceIdRows != null) {
            Sheet s = ansSheet;
            Collection<Integer> rows = mapOfSourceIdRows.values();
            for ( Iterator<Integer> it = rows.iterator(); it.hasNext(); ) {
                l_srcNames.add(s.getCell(2, it.next()).getContents());
            }
        }
        
        return l_srcNames;
    }
    


    public List<String> extractTheQuestionsInfo(Sheet ansSheet) {
        List<String> l_questions = new ArrayList<String>();
        if ( ansSheet != null ) {
            try {
                Sheet s = ansSheet;
                
                //qstn info is in 0 row
                // qstns are along the columns
                // set start_ans_col and end_ans_col using the min and max of the col values
                final int row = 0;
                int start_col = 0;
                int end_col = 0;
                Cell[] theQstnInfoCells = s.getRow(row);
                
                for ( int i = 0; i < theQstnInfoCells.length; i++ ) {
                    Cell theQstnCell = theQstnInfoCells[i];
                    String theContents = theQstnCell.getContents();
                    int col = theQstnCell.getColumn();
                    if ( theContents.equals(AnswersGridTemplateRangeConstants.PLS_DONT_CHANGE_ROW_COL) || theContents.equals("") ) continue;
                    
                    if ( theContents.equals("Repeat") || theContents.equals("") ) continue;
                    
                    this.mp_QuestionTag_Col.put(theContents, col);
                    this.li_questionInfos.add( theContents );
                    l_questions.add( theContents );
                    
                    
                    try {
                        if ( col > end_col )        end_col = col;
                        if ( start_col == 0 )        start_col = col;
                        if ( col < start_col )      start_col = col;
                    
/*
                        if ( theContents.equals("Repeat")) {
                            this.mp_QuestionId_Col.put(0, col);
                            continue;
                        }
*/                        
                        if ( theContents.indexOf("_M") > -1 ) {
                            int qmqid = Integer.parseInt(theContents.substring(0,theContents.indexOf("_M")));   
//LOG.info("qmqid " + qmqid);                            
                            if ( ! this.mp_QuestionId_Col.containsValue(qmqid) ) {
                                this.li_baseQstIds.add(qmqid);
                                this.mp_QuestionId_Col.put(qmqid, col);
                            }
                            if ( theContents.indexOf("_H") > -1 ) {
                                this.mp_QuestionHint_Col.put(qmqid, col);
                            }
                            continue;
                        }
                        
                        if ( theContents.indexOf("_") == -1) {
                            int qstId = Integer.parseInt(theContents);  // will give all but multi
                            this.li_baseQstIds.add(qstId);
                            this.mp_QuestionId_Col.put(qstId, col);
                        }
                        
                        if ( theContents.indexOf("_H") > -1 ) {
                            int qstid = Integer.parseInt(theContents.substring(0,theContents.indexOf("_H")));
                            this.mp_QuestionHint_Col.put(qstid, col);
                        }
                    } catch (NumberFormatException nfe) { 
                        nfe.printStackTrace();
                        continue; 
                    }
                    
                }
                
                this.setStart_ans_col(start_col);
                this.setEnd_ans_col(end_col);
                
                Set<Integer> qsntIds = this.mp_QuestionId_Col.keySet();
                Set<String> qstnTags = this.mp_QuestionTag_Col.keySet();
                
                for ( Iterator<Integer> it = qsntIds.iterator(); it.hasNext(); ) {
                    ArrayList<Integer> qstnlist = new ArrayList<Integer>();
                    String qstnId = String.valueOf(it.next());
//                    LOG.info("***************" + qstnId + "**************\n\n");
                    
                    for ( Iterator<String> tt = qstnTags.iterator(); tt.hasNext(); ) {
                        String qstnTag = tt.next();
//                        LOG.info("qstId " + qstnId + " qstnTg " + qstnTag); 
                        if ( qstnTag.startsWith(qstnId) ) {
                            qstnlist.add(this.mp_QuestionTag_Col.get(qstnTag));
                        }
                    }
                    
                    this.mp_Question_ColumnList.put(Integer.parseInt(qstnId), qstnlist);
                    
                }
            } catch ( Exception e) {
                e.printStackTrace();
            }
        }
        
        return l_questions;
    }
    
    public boolean compareMapKeys(Map<String, String> a, Map<String, String> b) {
        boolean isEqual = false;
        
        if ( a.size() != b.size() ) return isEqual = false;
        
        Set<String> aSet = a.keySet();
        Set<String> bSet = b.keySet();
        
        for ( Iterator<String> it = aSet.iterator(); it.hasNext(); ) {
            String aStr = it.next();
            if ( ! bSet.contains(aStr) ) {
                return isEqual = false;
            }
        }
        
        return true;
    }
    
    /*
    // http://java.sun.com/developer/technicalArticles/J2SE/generics/
    //  generics method that uses wildcards to sort a list into ascending order. 
    // Basically, all elements in the list must implement the Comparable interface.
     public <T extends Comparable<? super T>> List<T> sortList(List<T> list) {
        Object a[] = list.toArray();
        Arrays.sort(a);
        ListIterator<T> i = list.listIterator();
        for(int j=0; j<a.length; j++) {
           i.nextIndex();
           i.set((T)a[j]);
        }
        
        return Arrays.asList(a);
     }
    
   */ 
    
    public boolean compareLists(List<?> a, List<?>  b) {
        boolean isEqual = false;
        if ( a.size() != b.size() ) return isEqual = false;
        
        for ( int i = 0; i < a.size(); i++ ) {
            if (! b.contains( a.get(i) )  )   {//if (!( a.get(i).equals(b.get(i)) ) ) {
                LOG.info("a.getI not in b " + a.get(i));
                return isEqual = false;
            }
        }
        
        for ( int i = 0; i < b.size(); i++ ) {
            if (! a.contains( b.get(i) )  )   {//if (!( a.get(i).equals(b.get(i)) ) ) {
                LOG.info("b.getI not in a " + b.get(i));
                return isEqual = false;
            }
        }
        
        return isEqual = true;
    }
    

     public void printSet(Set aSet) {
         if ( aSet == null ) { LOG.info("aSet is null"); return; }
         Iterator it = aSet.iterator();
         while ( it.hasNext() ) 
             LOG.info("|"+ it.next()+"|" );
     }  

    public void printList(List alist) {
        if ( alist == null ) { LOG.info("alist is null"); return; }
        Iterator it = alist.iterator();
        while ( it.hasNext() ) 
            LOG.info("|"+ it.next()+"|" );
    }    
    
    public void printMap(Map aMap) {
        if ( aMap == null ) { LOG.info("amap is null"); return; }
        Set aSet = aMap.keySet();
        for ( Iterator it = aSet.iterator(); it.hasNext(); ) {
            Object key = it.next();
            LOG.info(key + " ==> " + aMap.get(key));
        }
    }

    private static void printQMap(LinkedHashMap<Integer, QuestionDataSetInfo> qis) {
        if ( qis == null ) throw new IllegalArgumentException("qs is null");
        
        Set<Integer> qSet = qis.keySet();
        LOG.info("\n\n*******QuestionsDataMap");
        LOG.info("Size is " + qSet.size());
        for ( Iterator<Integer> it = qSet.iterator(); it.hasNext(); ) {
            int qstId = it.next();
            QuestionDataSetInfo qst = qis.get(qstId);
            String qType = qst.getQst_type();
            
            LOG.info(qstId + " ==> " + qType );
            
        }
    }

    private static void printSrcMap(LinkedHashMap<Integer, SourceDataSetInfo> srcs) {
        if ( srcs == null ) throw new IllegalArgumentException("srcs is null");
        
        Set<Integer> srcSet = srcs.keySet();
        LOG.info("\n\n*******SourceDataSetInfoDataMap");
        LOG.info("Size is " + srcSet.size());
        for ( Iterator<Integer> it = srcSet.iterator(); it.hasNext(); ) {
            int srcId = it.next();
            SourceDataSetInfo src = srcs.get(srcId);
            String srcDisplayName = src.getSrc_display_name();
            
            LOG.info(srcId + " ==> " + srcDisplayName );
            LOG.info(src);
            
        }
        
        
    }
    
    
    public List<SourceAnswersDataSetInfo> buildSourceAnswersList(Sheet sheet,  
                                                                 LinkedHashMap<Integer, QuestionDataSetInfo> existingQstns, 
                                                                 Map<Integer, Integer> mpRepSrcIdSrcId, 
                                                                 Map<Integer, SourceDataSetInfo> mp_internalsrcid_src,
                                                                Map<Integer, Integer> mp_extraRepSrcIdSrcId,
                                                                Map<Integer, List<ReportAnswerSetValuesDataSetInfo>> mp_qstnId_rprtAnsSetValues) {
        
        
        
        
        
        List<SourceAnswersDataSetInfo> theList = new ArrayList<SourceAnswersDataSetInfo>();
        
        Set<Integer> repSrcIds = this.mp_RepSourceIds_Rows.keySet();
        Map<Integer, SourceDataSetInfo> xrtraRepSrcIds =  this.getMapRepSourceIds( mp_internalsrcid_src );//                     this.mp_ExtraRepSourceIds_Rows.keySet();
        
        Set<Integer> qsntIds = this.mp_QuestionId_Col.keySet();
        Set<Integer> qstnAddnlCols = this.mp_Question_ColumnList.keySet();
        Set<String> qstnTags = this.mp_QuestionTag_Col.keySet();
        
        
        Set<Integer> extraRepSrcIds = this.mp_ExtraRepSourceIds_Rows.keySet();
        // col headers
        // single --- id and hint ---> 45541, 45541_H -- 2 cols max
        // data   --- id, d and hint --> 45542, 45542_D, 45542_H -- 3 cols max
        // multi  --- id_M_qmqnum_S, (id_M_qmqnum_N with id_M_qmqnum_D), id_M_qmqnum_T, id_M_H
        // text --- has id only
        // sort --- has id only
        // weight --- has id and hint -- 2 cols max 36576, 36576_H
        
        //for each existing source        
        // for each source -- row
         for ( Iterator<Integer> st = repSrcIds.iterator(); st.hasNext(); ) {
             int repSrcId = st.next();
             int row = this.mp_RepSourceIds_Rows.get(repSrcId);
             
             // for each question
             for ( Iterator<Integer> qt = qsntIds.iterator(); qt.hasNext(); ) {
                 Integer qstnId = qt.next();
                 int col = this.mp_QuestionId_Col.get(qstnId);
LOG.info("repSrcId " + repSrcId + " row " + row + " qstnId " + qstnId + " col " + col);

                 QuestionDataSetInfo theQInfo = existingQstns.get( qstnId );
                 
                 if ( theQInfo != null ) {
                     String qType = theQInfo.getQst_type();
                     int rasId =  theQInfo.getQst_ras_id();
                     String qNumInfo = getQuestionNumberInfo( theQInfo );
                     
//LOG.info("In AGSRImpl -- buildSourceAnswersList qType is " + qType);                     
                     boolean needsHint = theQInfo.getQst_text_required_yn().equals("Y") ? true : false;
                     
                     SourceAnswersDataSetInfo sad = new SourceAnswersDataSet();
                     String answer = null;                              
                     String ansText = null;
                     String ansComment = null;
                     sad.setRps_id(repSrcId);
//LOG.info("in buildSourceAnswersList mpRepSrcIdSrcId.get(repSrcId) is |" + mpRepSrcIdSrcId.get(repSrcId) + "|");   

                    if ( mpRepSrcIdSrcId.get(repSrcId) != null && mpRepSrcIdSrcId.get(repSrcId) > 0 ) {
                         int srcId = mpRepSrcIdSrcId.get(repSrcId);
                         sad.setSrc_id( srcId );
                         sad.setQst_id(qstnId);
                         sad.setQst_type(qType);
                         
                         
                         if ( qType.equals("SINGLE") ) {
                             sad.setRas_Id( rasId );
                             processSingleQuestion(sheet, theList, row, col, qstnId, qNumInfo,theQInfo, needsHint, sad, mp_qstnId_rprtAnsSetValues);
                         } else if ( qType.equals("DATA") ) {
                             processNumericQuestion(sheet, theList, row, col, qstnId, qNumInfo, theQInfo, needsHint, sad);
                         } else if ( qType.equals("TEXT") ) {
                             processTextQuestion(sheet, theList, row, col, sad);                         
                         } else if ( qType.equals("MULTI") ) {
                             processMultiQuestion(sheet, theList, row, col, qstnId, qNumInfo, theQInfo, needsHint, repSrcId, srcId, mp_qstnId_rprtAnsSetValues);//, qstnId.intValue());
                         } else if ( qType.equals("SORT") ) {
                            processSortQuestion(sheet, theList, row, col, qstnId, qNumInfo, theQInfo, sad);                         
                         } else if ( qType.equals("WEIGHT") ) {
                            processWeightQuestion(sheet, theList, row, col, qstnId, qNumInfo, needsHint, sad);
                             
                         } else if ( qType.equals("REPEAT")) {
                            continue;
                         }
                     }
                       
                 }
             }
         }
         
         
         if ( xrtraRepSrcIds != null ) {
            // for each extra src
             Set<Integer> xrtraRepSrcIdKeys = xrtraRepSrcIds.keySet(); 
             if ( xrtraRepSrcIdKeys.size() > 0 ) {
                 // for each extrSourceRow
                 
        LOG.info("xrtraRepSrcIdKeys size is " + xrtraRepSrcIdKeys.size() + " and it is__\n");   
        printSet(xrtraRepSrcIdKeys);
                  for ( Iterator<Integer> st = xrtraRepSrcIdKeys.iterator(); st.hasNext(); ) {
                      int xtraRepSrcId = st.next();
                   /*   
                      if ( mpRepSrcIdSrcId.containsKey( xtraRepSrcId ) ) {
                          continue;
                      }
                   */   
                      
        LOG.info("xtrarep src id is " + xtraRepSrcId );              
                      SourceDataSetInfo s = xrtraRepSrcIds.get( xtraRepSrcId );//     mp_internalsrcid_src.get( mpRepSrcIdSrcId.get( repSrcId ) );
        LOG.info("s.getXlInternalId() is " + s.getXlInternalId());  
        LOG.info("******/\nthis.mp_ExtraRepSourceIds_Rows is " + this.mp_ExtraRepSourceIds_Rows + "\n********\n");
                      int row = this.mp_ExtraRepSourceIds_Rows.get(xtraRepSrcId);//s.getXlInternalId()
                      
                      // for each question
                      for ( Iterator<Integer> qt = qsntIds.iterator(); qt.hasNext(); ) {
                          Integer qstnId = qt.next();
                          int col = this.mp_QuestionId_Col.get(qstnId);
                      //LOG.info("srcId " + srcId + " row " + row + " qstnId " + qstnId + " col " + col);
        
                          QuestionDataSetInfo theQInfo = existingQstns.get( qstnId );
                          
                          if ( theQInfo != null ) {
                              String qType = theQInfo.getQst_type();
                              int rasId =  theQInfo.getQst_ras_id();
                              String qNumInfo = getQuestionNumberInfo( theQInfo );
                              
                      //LOG.info("In AGSRImpl -- buildSourceAnswersList qType is " + qType);
                              boolean needsHint = theQInfo.getQst_text_required_yn().equals("Y") ? true : false;
                              
                              SourceAnswersDataSetInfo sad = new SourceAnswersDataSet();
                              String answer = null;                              
                              String ansText = null;
                              String ansComment = null;
                              sad.setRps_id(xtraRepSrcId);
                              
                              if ( mpRepSrcIdSrcId.get(xtraRepSrcId) != null ) { //mp_extraRepSrcIdSrcId
                                LOG.info("mpRepSrcIdSrcId.get(xtraRepSrcId) != null for " + xtraRepSrcId);
                              } else {
                                LOG.info("mpRepSrcIdSrcId.get(xtraRepSrcId) == IS null for xtraRepSrcId " + xtraRepSrcId);
                              }
                              
//LOG.info("mp_extraRepSrcIdSrcId.get(repSrcId) is |" + mp_extraRepSrcIdSrcId.get(xtraRepSrcId) + "|");
                              if ( mpRepSrcIdSrcId.get(xtraRepSrcId) != null && mpRepSrcIdSrcId.get(xtraRepSrcId) > 0 ) {
    
                                  int srcId = mpRepSrcIdSrcId.get(xtraRepSrcId);//mp_extraRepSrcIdSrcId
                                  
                                  
                                  sad.setSrc_id( srcId );
                                  sad.setQst_id(qstnId);
                                  sad.setQst_type(qType);
                                  
                                  
                                  if ( qType.equals("SINGLE") ) {
                                      sad.setRas_Id( rasId );
                                      processSingleQuestion(sheet, theList, row, col, qstnId, qNumInfo,theQInfo, needsHint, sad, mp_qstnId_rprtAnsSetValues);
                                  } else if ( qType.equals("DATA") ) {
                                      processNumericQuestion(sheet, theList, row, col, qstnId, qNumInfo, theQInfo, needsHint, sad);
                                  } else if ( qType.equals("TEXT") ) {
                                      processTextQuestion(sheet, theList, row, col, sad);                         
                                  } else if ( qType.equals("MULTI") ) {
                                      processMultiQuestion(sheet, theList, row, col, qstnId, qNumInfo, theQInfo, needsHint, xtraRepSrcId, srcId, mp_qstnId_rprtAnsSetValues);//, qstnId.intValue());
                                  } else if ( qType.equals("SORT") ) {
                                     processSortQuestion(sheet, theList, row, col, qstnId, qNumInfo, theQInfo, sad);                         
                                  } else if ( qType.equals("WEIGHT") ) {
                                     processWeightQuestion(sheet, theList, row, col, qstnId, qNumInfo, needsHint, sad);
                                      
                                  } else if ( qType.equals("REPEAT")) {
                                     continue;
                                  }
                              }
                                
                          }
                      }
                  }
             }
         }
        return theList;
    }

    private void processWeightQuestion(Sheet sheet, 
                                       List<SourceAnswersDataSetInfo> theList, 
                                       int row, int col,  Integer qstnId, String qNumInfo,
                                       boolean needsHint, 
                                       SourceAnswersDataSetInfo sad) {
        String answer;
        String ansText;
        String ansComment;
        // weight --- has id and hint -- 2 cols max 36576, 36576_H
        // numeric answer
        boolean hasError = false;
        answer = null;
        ansText = null;
        ansComment = null;
        
        
        Cell ansCell = sheet.getCell(col, row);
        if ( ansCell != null  && !ansCell.getType().equals(CellType.EMPTY) ) {
        LOG.info("in data -- cell type is " + ansCell.getType());
            String numAns = ansCell.getContents();
            try {
                Double.parseDouble(numAns);
                sad.setAnswer(numAns);
            } catch ( NumberFormatException nfe) {
                hasError = true;
                this.li_errors.add( "Error for WEIGHT  Question " + qstnId +  " in col " + (col+1) + " and row " + (row+1) + " [cell " + this.mp_R1C1Map.get(col+1) + (row+1)+"] answer invalid, should be a number, found " + numAns );
                LOG.error( "Error for WEIGHT  Qstn " + qNumInfo +  " in col " + (col+1) + " and row " + (row+1) + " answer invalid should be a number found " + numAns, nfe );
                
                return;
            }
        }
         
         if ( needsHint ) {
             int hintCol = this.mp_QuestionTag_Col.get(qstnId+"_H");
             Cell txtHintCell = sheet.getCell(hintCol, row);
             
             if ( txtHintCell != null ) {
               ansText = txtHintCell.getContents();
               sad.setSra_answer_text( ansText );
               
               CellFeatures cf = txtHintCell.getCellFeatures();
               if ( cf != null ) {
                   ansComment = cf.getComment();
                   sad.setSra_comment( ansComment );
               }
             }
             
             
             CellFormat cfo = txtHintCell.getCellFormat();
             if ( cfo != null ) {
                 if ( cfo.getBackgroundColour() != null ) {
                     
                     Colour clr = cfo.getBackgroundColour();
                     if ( ! ( clr.equals(Colour.GRAY_25) ||  clr.equals(Colour.DEFAULT_BACKGROUND)  ) ) {
                     
                         
                         RGB rgb = clr.getDefaultRGB();
                         String r = Integer.toHexString(rgb.getRed());
                         String g = Integer.toHexString(rgb.getGreen());
                         String b = Integer.toHexString(rgb.getBlue());
                         
                         sad.setSra_color("#"+r+g+b);
                     }
                     
                 }
             }
         }
         
         
         if ( /*! sad.isEmpty() && */!hasError ) {
//          LOG.info( sad );
            theList.add( sad );
         }
    }

    private void processSortQuestion(Sheet sheet, 
                                     List<SourceAnswersDataSetInfo> theList, 
                                     int row, int col, Integer qstnId, String qNumInfo,
                                     QuestionDataSetInfo theQInfo, 
                                     SourceAnswersDataSetInfo sad) {
        String answer;
        String ansText;
        String ansComment;
        // sort has id only
        // ans have validation
        answer = null;
        ansText = null;
        ansComment = null;
        boolean hasError = false;
        Cell ansCell = sheet.getCell(col, row);
        if (  ansCell != null && !ansCell.getType().equals(CellType.EMPTY) ) {
            answer = ansCell.getContents();
            CellFeatures cf = ansCell.getCellFeatures();
            if ( cf != null ) {
                if ( cf != null && !cf.hasDataValidation() ) {
                    hasError = true;
                    this.li_errors.add( "Error for SORT Question " + qNumInfo +  " in col " + (col+1) + " and row " + (row+1) + " [cell " + this.mp_R1C1Map.get(col+1) + (row+1) + "] answer is not in a validation list");
                    LOG.error( "1111 Error for SORT Qstn " + qstnId +  " in col " + (col+1) + " and row " + (row+1) + " answer is not in a validation list");
                    
                    return;
                }
                ansComment = cf.getComment();
                sad.setSra_comment(ansComment);
                
                List<SortingCriteriaValuesDataSetInfo> sortCriteriaDataSetInfo = theQInfo.getSortCriteriaDataSetInfo(); 
                List<String> sortCrtiteriasList = new ArrayList<String>();
//                Map<String, Integer> mp_ScvName_ScvId = new HashMap<String, Integer>();
                for ( Iterator<SortingCriteriaValuesDataSetInfo> sorts = sortCriteriaDataSetInfo.iterator(); sorts.hasNext(); ) {
                    SortingCriteriaValuesDataSetInfo si = sorts.next();
                    String sortCriteriaName = si.getSvc_name();
                    sortCrtiteriasList.add(sortCriteriaName);
//                    mp_ScvName_ScvId.put( si.getSvc_name(), si.getScv_id());
                }
                
                // add one for blankness
                final String blankSpace = " ";
                sortCrtiteriasList.add(blankSpace);
                
                if ( sortCrtiteriasList.contains( answer) ) {
                  sad.setAnswer( answer );
                  sad.setScv_name( answer );
                  int scvId;
                  if ( !answer.equals(blankSpace) || !answer.equals("")) {
                    scvId = PlatformAppModuleServiceImpl.getInstance().getSSCInfo( qstnId, answer );
//LOG.info("in [processSortQuestion] scvid is " + scvId + " qstid is " + qstnId + " answer is " + answer );                    
                  } else {
                      scvId = 0;
                  }
                  
                  sad.setScv_Id( scvId );//mp_ScvName_ScvId.get(answer) );
                } else {
                  if ( answer != null && !answer.equals("") ) {
                    hasError = true;
                    this.li_errors.add( "Error for SORT Question " + qNumInfo +  " in col " + (col+1) + " and row " + (row+1) + " [cell " + this.mp_R1C1Map.get(col+1) + (row+1) +  " answer is not in valid list --- found " + answer);
                    LOG.error( "2222 Error for SORT Qstn " + qstnId +  " in col " + (col+1) + " and row " + (row+1) + " answer is not in valid list --- found " + answer);
                    return;
                  }
                }
                
                if ( /*! sad.isEmpty() && */!hasError ) {
//                  LOG.info( sad );
                    theList.add( sad );
                }
            }
        } else if (  ansCell != null && ansCell.getType().equals(CellType.EMPTY) ) {
            sad.setAnswer( null );
            sad.setScv_name( null );
            sad.setScv_Id( 0 );
            
            theList.add( sad );
            
        }
    }
    

        private void processMultiQuestion(Sheet sheet, 
                                          List<SourceAnswersDataSetInfo> theList, 
                                          int row, int col, Integer qstnId, String qNumInfo,
                                          QuestionDataSetInfo theQInfo, 
                                          boolean needsHint, int repSrcId, 
                                          int srcId,
                                          Map<Integer, List<ReportAnswerSetValuesDataSetInfo>> mp_qstnId_rprtAnsSetValues) { //, int qstnId1) {
            String answer;
            String ansText;
            String ansComment;
            // multi  --- id_M_qmqnum_S, (id_M_qmqnum_N with id_M_qmqnum_D), id_M_qmqnum_T, id_M_H
            boolean hasErrors = false;
            answer = null;
            ansComment = null;
        
         
            boolean isNumAnsCellFilled   = false; 
            boolean isDropAnsCellFilled  = false;
            LOG.info("in processMultiQuestion theQInfo qtype is " + theQInfo.getQst_type());
            List<MultiQuestionDataSetInfo> qmqInfo = theQInfo.getMultiQuestionInfo();
            for (Iterator<MultiQuestionDataSetInfo> qmqt = qmqInfo.iterator(); qmqt.hasNext(); ) {
                MultiQuestionDataSetInfo qmq = qmqt.next();
                int qmqId = qmq.getQmq_id();
                String nmbr = qmq.getQmq_number();
                String qmqType = qmq.getQmq_type();
                int rasId = qmq.getQmq_ras_id();
                
                SourceAnswersDataSetInfo sad = new SourceAnswersDataSet();
                sad.setQst_id(qstnId);
                sad.setSrc_id(srcId);
                sad.setQst_type("MULTI");
                sad.setQmq_id( qmqId );
                sad.setQmq_number(nmbr);
                sad.setQmq_Qst_Type(qmqType);
                sad.setRps_id(repSrcId);
                
//            LOG.info("in processMultiQuestion qmqtype is " + sad.getQmq_Qst_Type());
                if ( qmqType.equals("TEXT")) {
//            LOG.info("in processMultiQuestion qmqtype -- TEXT");
                    sad.setQmq_Qst_Type(qmqType);
                    int txtCol =  this.mp_QuestionTag_Col.get(qstnId + "_" + nmbr + "_T");//this.mp_QuestionTag_Col.get(qstnId + "_M_" + nmbr + "_T");
                    Cell txtCell = sheet.getCell(txtCol, row);
                    if ( txtCell != null ) {
                      answer = txtCell.getContents();
                      sad.setAnswer( answer );
                    }
                    
                } else if ( qmqType.equals("DATA")) {
//            LOG.info("in processMultiQuestion qmqtype -- DATA");
                    sad.setQmq_Qst_Type(qmqType);
                    
                    final String[] tallyOptions = new String[] {"", "Up", "Down", "No response", "Not applicable", "Don't know", "Other"}; 
                    List<String> liOptions = Arrays.asList( tallyOptions );
                    //numeric
                    int numCol = this.mp_QuestionTag_Col.get(qstnId + "_M_" + nmbr + "_N");
                    Cell numAnsCell = sheet.getCell(numCol, row);
                    
                    String numAns = null;
                    if ( numAnsCell != null  && !numAnsCell.getType().equals(CellType.EMPTY) ) {
//LOG.info("in qmq data -- cell type is " + numAnsCell.getType());
                        isNumAnsCellFilled = true;
                        numAns = numAnsCell.getContents();
//LOG.info("numAns is |"  + numAns + "|");
                    }
                    //drop
                    int dropCol = this.mp_QuestionTag_Col.get(qstnId + "_M_" + nmbr + "_D");
                    Cell dropCell = sheet.getCell(dropCol, row);
                    String dropAns = null;
                    if (  dropCell != null && !dropCell.getType().equals(CellType.EMPTY) ) {
                        isDropAnsCellFilled = true;
                        dropAns = dropCell.getContents().trim();
                        CellFeatures df = dropCell.getCellFeatures();
                        if ( df != null && !df.hasDataValidation() ) {
                            hasErrors = true;
                            this.li_errors.add( "Error for Multi-part Question " + qNumInfo +  " in col " + (col+1) + " and row " + (row+1) + " [cell " + this.mp_R1C1Map.get(col+1) + (row+1) +  "] answer is not in a validation list");
                            LOG.error( "RETURNING_1__Error for MULTI_DATA Qstn " + qstnId +  " in col " + (col+1) + " and row " + (row+1) + " answer is not in a validation list");
                                                    
                          return;
                      }
                      
                      if ( ! liOptions.contains( dropAns ) && dropAns != "" ) {//dropAns == "" ) {
                          hasErrors = true;
                         this.li_errors.add( "Error for Multi-part Question " + qNumInfo +  " in col " + (col+1) + " and row " + (row+1)  + " [cell " + this.mp_R1C1Map.get(col+1) + (row+1) +  "] answer is not in valid list");
                         LOG.error( "RETURNING_2__Error for MULTI_ DATA  Qstn " + qstnId +  " in col " + (col+1) + " and row " + (row+1) + " answer is not in valid list");
                                                  
                         return;
                      }
                    }
                    
            LOG.info( "MULTI__DATA  numAms isnull XOR dropAns isnull -->  " + (numAns != null ^ dropAns != null));
                    // either numeric or drop not both

  /**rem no need                            
 LOG.info("isNumAnsCellFilled ==> " + isNumAnsCellFilled + " <==|| isDropAnsCellFilled ==> " + isDropAnsCellFilled + " <==");         
 LOG.info("( isNumAnsCellFilled ^ isDropAnsCellFilled ) ==> " + ( isNumAnsCellFilled ^ isDropAnsCellFilled )); 
 LOG.info("( isNumAnsCellFilled && isDropAnsCellFilled ) ==>" + ( isNumAnsCellFilled && isDropAnsCellFilled ));
 **/
                      if ( isNumAnsCellFilled ^ isDropAnsCellFilled ) {
                          if ( isNumAnsCellFilled ) {
                              try {
                                  Double.parseDouble( numAns );
                                  sad.setAnswer( numAns );
                              } catch (NumberFormatException e) {
                                  hasErrors = true;
                                  this.li_errors.add( "Error for Multi-part  Question " + qNumInfo +  " in col " + (col+1) + " and row " + (row+1)  + " [cell " + this.mp_R1C1Map.get(col+1) + (row+1) +  "] answer invalid should be a number,  found " + numAns );
                                  LOG.error( "Error for MULTI_DATA  Qstn " + qstnId +  " in col " + (col+1) + " and row " + (row+1) + " answer invalid should be numeric found " + numAns );
                                  
                                  return;
                                  
                              }
                          }
                          
                          if ( isDropAnsCellFilled ) {
                              sad.setAnswer( dropAns );
                          }
                          
                      } else if ( !(isNumAnsCellFilled || isDropAnsCellFilled) ) {
                          sad.setAnswer( null );
                      } else if ( isNumAnsCellFilled && isDropAnsCellFilled ) {
/** rem no need                      
 LOG.info("here in both numans is -->" + numAns + "<--         dropAns is -->" +dropAns + "<--");     
 LOG.info("dropAns != \"\" --> " + dropAns != "");    
 LOG.info("dropAns == \"\" --> " + dropAns == "");  
// LOG.info("dropAns.equ\"\" ==> " + dropAns.equals(""));
// LOG.info("!dropAns.equ\"\" ==> " + !dropAns.equals(""));

 LOG.info("numAns != \"\" --> " + numAns != "");    
 LOG.info("numAns == \"\" --> " + numAns == ""); 
// LOG.info("numAns.equ\"\" ==> " + numAns.equals(""));
// LOG.info("!numAns.equ\"\" ==> " + !numAns.equals(""));
    
 rem no need**/    
    
                          if (  ( numAns != null && numAns != "" && numAns != " "/* && !numAns.equals("") && !numAns.equals(" ")*/ )
                             && ( dropAns != null && dropAns != "" && dropAns != " "/* && !dropAns.equals("") && !dropAns.equals(" ")*/)    
                          ) {
                              hasErrors = true;
                              
                              this.li_errors.add( "Error for Multi-part   Question " + qNumInfo +  " in col " + (col+1) + " and row " + (row+1)  + " [cell " + this.mp_R1C1Map.get(col+1) + (row+1) +  "]. Both number and dropdown selection found. Please enter either number, or choose response from dropdown");     
                              LOG.error( "RETUERNING__3__Error for MULTI_DATA   Qstn " + qstnId +  " in col " + (col+1) + " and row " + (row+1) + " answer  can be either numeric  or text found both --> numeric |" + numAns + "| and text from drop-down |" + dropAns + "|");
                              
                              return;
                          } else {
                              if (  ( numAns != null && numAns != "" && numAns != " " /*&& !numAns.equals("") && !numAns.equals(" ")*/ ) ) {
                                  sad.setAnswer( numAns );
                              } else if (( dropAns != null && dropAns != "" && dropAns != " " /*&& !dropAns.equals("") && !dropAns.equals(" ")*/)  ) {
                                  sad.setAnswer( dropAns );
                              } else {
//             LOG.info("ARRRRRRRRRRRGH");       
                                 sad.setAnswer( null );
                              }
                          }
                      }
                              
                              
/*****************************                    
                    boolean isNumAnsNull = (numAns != null && !( numAns == "" || numAns == " " || numAns != "null"));
                    boolean isDropAnsNull = (dropAns != null && !( dropAns == "" || dropAns == " " || dropAns != "null"));
             LOG.info("isNumAnsNull " + isNumAnsNull + " and isDropAnsNull " + isDropAnsNull) ;        
             LOG.info(" isNumAns ^ isdropans " + (isNumAnsNull ^ isDropAnsNull) );
                    LOG.info(" isNumAns && isdropans " + (isNumAnsNull && isDropAnsNull) );
                    LOG.info(" !isNumAns && !isdropans " + (!isNumAnsNull && !isDropAnsNull) );
                      
                      if ( isNumAnsNull ^ isDropAnsNull ) {
                          if ( isDropAnsNull ) {
                              answer = dropCell.getContents();
                              sad.setAnswer( answer );
                          } else if (isNumAnsNull  ) {
                              try {
                              //                                    int theAns = Integer.parseInt(numAns);
                                  Double.parseDouble(numAns);
                                  sad.setAnswer(numAns);
                              } catch ( NumberFormatException nfe ) {
                                  hasErrors = true;
                                  this.li_errors.add( "Error for MULTI_DATA  Qstn " + qstnId +  " in col " + (col+1) + " and row " + (row+1) + " answer invalid should be numeric found " + numAns );
                              LOG.info( "Error for MULTI_DATA  Qstn " + qstnId +  " in col " + (col+1) + " and row " + (row+1) + " answer invalid should be numeric found " + numAns );
                              }
                          }
                      } else if ( isNumAnsNull && isDropAnsNull ) {
                          sad.setAnswer( null );   
                      } else if ( !isNumAnsNull && !isDropAnsNull ) {
                          hasErrors = true;
             //             sad.setAnswer( null ); 
                          this.li_errors.add( "Error for MULTI_DATA   Qstn " + qstnId +  " in col " + (col+1) + " and row " + (row+1) + " answer  can be either numeric  or text found both --> numeric " + numAns + " and text from drop-down " + dropAns);     
LOG.info( "Error for MULTI_DATA   Qstn " + qstnId +  " in col " + (col+1) + " and row " + (row+1) + " answer  can be either numeric  or text found both --> numeric |" + numAns + "| and text from drop-down |" + dropAns + "|");
                          
                      }
                        \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\*/      
                    /*************************
                    if ( (numAns != null ^ dropAns != null) ) {
                        if ( (numAns == null &&  ( dropAns != null && dropAns != "") ) && !hasErrors ) {
                            // numeric null, drop not null
                            answer = dropAns;//dropCell.getContents();
                            sad.setAnswer( answer );
                        } else if ( (numAns != null && ( dropAns == null || dropAns == "" ) ) && !hasErrors ) {
                            // numeric not null, drop null
                            try {
                                Double.parseDouble(numAns);
                                sad.setAnswer(numAns);
                            } catch ( NumberFormatException nfe ) {
                                hasErrors = true;
                                this.li_errors.add( "Error for MULTI_DATA  Qstn " + qstnId +  " in col " + (col+1) + " and row " + (row+1) + " answer invalid should be numeric found " + numAns );
                            }
                        }
                    } else if ( ( numAns == null && dropAns == null ) ) {
                        sad.setAnswer( null );             
                    } else if ( (numAns != null && dropAns != null) ) {
LOG.info("[(numAns != null && dropAns != null) ]  numAns is |" + numAns + "| and dropAns is " + dropAns);
                        hasErrors = true;
        //             sad.setAnswer( null ); 
                        this.li_errors.add("ERROR for MULTI_DATA  Qstn " + qstnId +  " in col " + (col+1) + " and row " + (row+1) + " answer invalid can only have one numeric or text" );     
LOG.info("ERROR for MULTI_DATA  Qstn " + qstnId +  " in col " + (col+1) + " and row " + (row+1) + " answer invalid can only have one numeric or text" );             
                    }
           ***************/         
                    
                } else if ( qmqType.equals("SINGLE")) {
                    
                    PlatformAppModuleService service = PlatformAppModuleServiceImpl.getInstance();                    
                    boolean canAddAnswers = false;
                    List<String> liExtraAnsVals = new ArrayList<String>();
                    try {
                        canAddAnswers = service.canAddAnswerSetsToQuestion( new oracle.jbo.domain.Number( qstnId ) );
                    } catch (SQLException e) {
                        LOG.error("error in finding canaddanswer for qstn", e);
                    }
                    
                    if ( canAddAnswers ) {
                        List<ReportAnswerSetValuesDataSetInfo> qnsRavList = mp_qstnId_rprtAnsSetValues.get( qstnId );
                        for ( ReportAnswerSetValuesDataSetInfo rav : qnsRavList ) {
                            liExtraAnsVals.add( rav.getRav_answer() );
                        }
                    }
                    
                    
//            LOG.info("in processMultiQuestion qmqtype -- SINGLE");
                    sad.setQmq_Qst_Type(qmqType);
                    sad.setRas_Id( rasId );
                    
                    List<ReportAnswerSetValuesDataSetInfo> mqAnsInfo = qmq.getSingleAnswerSetsInfo();
                    List<String> liOptions = new ArrayList<String>();
                    for ( Iterator<ReportAnswerSetValuesDataSetInfo> mmtt = mqAnsInfo.iterator(); mmtt.hasNext(); ) {
                        liOptions.add(mmtt.next().getRav_answer().trim());
                    }
                    
                    int singleCol = this.mp_QuestionTag_Col.get(qstnId + "_M_" + nmbr + "_S");
                    Cell singCell = sheet.getCell(singleCol, row);
                    if ( singCell != null && !singCell.getType().equals(CellType.EMPTY) ) {
                        answer = singCell.getContents().trim();
                        
                        
                        
                        CellFeatures cf = singCell.getCellFeatures();
                        if ( cf != null && !cf.hasDataValidation() ) {
                            hasErrors = true;
                            this.li_errors.add( "Error for Multi-part Question " + qNumInfo +  " in col " + (col+1) + " and row " + (row+1)  + " [cell " + this.mp_R1C1Map.get(col+1) + (row+1) +  "] answer is not in a validation list --- found " + answer);
                            LOG.error( "1111 Error for Multi-part Question " + qstnId +  " in col " + (col+1) + " and row " + (row+1) + " answer is not in a validation list --- found " + answer);
                            
                            return;
                        }
                        if ( cf != null ) {
                            
                            if ( canAddAnswers ) {
                                for ( String val : liExtraAnsVals) {
                                    liOptions.add( val.trim() );
                                }
//                                boolean isExtraAnsValsAdded = liOptions.addAll( liExtraAnsVals );
//                                if ( !isExtraAnsValsAdded  ) {
//                                    hasErrors = true;
//                                    this.li_errors.add( "Error for MULTI Qstn " + qNumInfo +  " in col " + (col+1) + " and row " + (row+1)  + " [cell " + this.mp_R1C1Map.get(col+1) + (row+1) +  "]  could not add answer to the valid list");
//                                    LOG.error( "221122 Error for MULTI Qstn " + qNumInfo +  " in col " + (col+1) + " and row " + (row+1)  + " [cell " + this.mp_R1C1Map.get(col+1) + (row+1) +  "]  could not add answer to the valid list");
//                                }
                            }
                            
                            if ( liOptions.contains( answer ) ) { //&& !answer.equals("")  ) {
                                if ( answer != null || answer != "") {
                                    sad.setAnswer( answer );                        
                                    int ravId = PlatformAppModuleServiceImpl.getInstance().getRavInfo( rasId, answer );
//                                    LOG.info("[ansgridreader - multi-single] ravId is " + ravId + " rasid is " + rasId + " answer is |" + answer + "|");                                
 System.out.println("[ansgridreader - multi-single] ravId is " + ravId + " rasid is " + rasId + " answer is |" + answer + "|");
                                    sad.setRav_Id(  ravId );
                                } else {
                                    sad.setAnswer( null );
                                    sad.setRav_Id( 0 );
                                }
                        
                            } else {
                               if ( answer != null && !answer.equals("") ) {
                                 hasErrors = true;
                                 this.li_errors.add( "Error for Multi-part Question " + qNumInfo +  " in col " + (col+1) + " and row " + (row+1)  + " [cell " + this.mp_R1C1Map.get(col+1) + (row+1) +  "] answer is not in valid list --- found " + answer);
                                 LOG.error( "2222 Error for Multi-part Question " + qstnId +  " in col " + (col+1) + " and row " + (row+1) + " answer is not in valid list --- found " + answer);
                                 
                                 return;
                               }
                           }
                        }
                    } else if ( singCell != null && singCell.getType().equals(CellType.EMPTY) ) {
                        sad.setAnswer( null );
                        sad.setRav_Id( 0 );
                    }
                }
//            LOG.info("qmqType is " + qmqType + " answer is " + answer);
                
                if ( needsHint ) {
                    int hintCol = this.mp_QuestionTag_Col.get(qstnId+"_H");
                    Cell txtHintCell = sheet.getCell(hintCol, row);
                    
                    if ( txtHintCell != null ) {
                      ansText = txtHintCell.getContents();
                      sad.setSra_answer_text( ansText );
                      
                      CellFeatures cf = txtHintCell.getCellFeatures();
                      if ( cf != null ) {
                          ansComment = cf.getComment();
                          sad.setSra_comment( ansComment );
                      }
                    }
                    
                    
                    CellFormat cfo = txtHintCell.getCellFormat();
                    if ( cfo != null ) {
                        if ( cfo.getBackgroundColour() != null ) {
                            
                            Colour clr = cfo.getBackgroundColour();
                            if ( ! ( clr.equals(Colour.GRAY_25) ||  clr.equals(Colour.DEFAULT_BACKGROUND)  ) ) {
                            
                                
                                RGB rgb = clr.getDefaultRGB();
                                String r = Integer.toHexString(rgb.getRed());
                                String g = Integer.toHexString(rgb.getGreen());
                                String b = Integer.toHexString(rgb.getBlue());
                                
                                sad.setSra_color("#"+r+g+b);
                            }
                            
                        }
                    }
                }
                
                if ( /*! sad.isEmpty() && */!hasErrors ) {
            //              LOG.info( sad );
                    theList.add( sad );
                }
                
            }                                          
        }



    private void processTextQuestion(Sheet sheet, 
                                     List<SourceAnswersDataSetInfo> theList, 
                                     int row, int col, 
                                     SourceAnswersDataSetInfo sad) {
//LOG.info("in processTextQns");                                     
        String answer;
        String ansComment;
        // text has id only
        answer = null;
        ansComment = null;
        boolean hasError = false;
        Cell ansCell = sheet.getCell(col, row);
         if (  ansCell != null && !ansCell.getType().equals(CellType.EMPTY) ) {
             answer = ansCell.getContents();
             sad.setAnswer( answer );
             
             CellFeatures cf = ansCell.getCellFeatures();
             if ( cf != null ) {
               ansComment = cf.getComment();
               sad.setSra_comment( ansComment );
             }
             
             
             CellFormat cfo = ansCell.getCellFormat();
             if ( cfo != null ) {
                 if ( cfo.getBackgroundColour() != null ) {
                     
                     Colour clr = cfo.getBackgroundColour();
                     if ( ! ( clr.equals(Colour.GRAY_25) ||  clr.equals(Colour.DEFAULT_BACKGROUND)  ) ) {
                     
                         
                         RGB rgb = clr.getDefaultRGB();
                         String r = Integer.toHexString(rgb.getRed());
                         String g = Integer.toHexString(rgb.getGreen());
                         String b = Integer.toHexString(rgb.getBlue());
                         
                         sad.setSra_color("#"+r+g+b);
                     }
                     
                 }
             }
             
             
             if ( /*! sad.isEmpty() && */!hasError ) {
//               LOG.info( "IN PROCESS TEXT " + sad );
                 theList.add( sad );
             }
         } else if (  ansCell != null && ansCell.getType().equals(CellType.EMPTY) ) {
            sad.setAnswer( null );
            sad.setRav_Id( 0 );
            sad.setSra_comment( null );
            sad.setSra_color( null );
             theList.add( sad );
         }
    }

    private void processNumericQuestion(Sheet sheet, 
                                         List<SourceAnswersDataSetInfo> theList, 
                                         int row, int col, Integer qstnId, String qNumInfo,
                                         QuestionDataSetInfo theQInfo, 
                                         boolean needsHint, 
                                         SourceAnswersDataSetInfo sad) {
        String answer;
        String ansText;
        String ansComment;
        // data   --- id, d and hint --> 45542, 45542_D, 45542_H -- 3 cols max
        // can have either numeric or option --- XOR
        boolean hasError = false;
        answer = null;
        ansText = null;
        ansComment = null;
        
         
        boolean isNumAnsCellFilled   = false; 
        boolean isDropAnsCellFilled  = false;
        
            // numeric
         Cell numAnsCell = sheet.getCell(col, row);
         String numAns = null;
         if ( numAnsCell != null  && !numAnsCell.getType().equals(CellType.EMPTY) ) {
//LOG.info("in data -- cell type is " + numAnsCell.getType());
            isNumAnsCellFilled = true;
            numAns = numAnsCell.getContents();
//LOG.info("numAns is |"  + numAns + "|");           
         }
            // drop
         int dropCol = this.mp_QuestionTag_Col.get(qstnId+"_D");
         Cell dropCell = sheet.getCell(dropCol, row);
         String dropAns = null;
         
         if (  dropCell != null && !dropCell.getType().equals(CellType.EMPTY) ) {
           isDropAnsCellFilled = true;
           dropAns = dropCell.getContents();
//LOG.info("dropAns is |"  + dropAns + "|");  
           CellFeatures df = dropCell.getCellFeatures();
           if ( df != null && !df.hasDataValidation() ) {
               hasError = true;
               this.li_errors.add( "Error for DATA Question " + qNumInfo +  " in col " + (col+1) + " and row " + (row+1)  + " [cell " + this.mp_R1C1Map.get(col+1) + (row+1) +  "] answer is not in a validation list --- found " + answer);
               LOG.error( "RETURNING_1__Error for DATA Qstn " + qstnId +  " in col " + (col+1) + " and row " + (row+1) + " answer is not in a validation list --- found " + answer);
               
               return;
           }
           
           String[] singleOptions = theQInfo.getDataTallyOptions();
           List<String> liOptions = Arrays.asList(singleOptions);
           if ( ! liOptions.contains( dropAns ) && dropAns != "") {
               hasError = true;
               this.li_errors.add( "Error for DATA  Question " + qNumInfo +  " in col " + (col+1) + " and row " + (row+1)  + " [cell " + this.mp_R1C1Map.get(col+1) + (row+1) +  "] answer is not in valid list --- found " + answer);
               LOG.error( "RETURNING_2__Error for DATA  Question " + qstnId +  " in col " + (col+1) + " and row " + (row+1) + " answer is not in valid list --- found " + answer);              
                
               return;
           }
         }
/**         
LOG.info("isNumAnsCellFilled ==> " + isNumAnsCellFilled + " <==|| isDropAnsCellFilled ==> " + isDropAnsCellFilled + " <==");         
LOG.info("( isNumAnsCellFilled ^ isDropAnsCellFilled ) ==> " + ( isNumAnsCellFilled ^ isDropAnsCellFilled )); 
LOG.info("( isNumAnsCellFilled && isDropAnsCellFilled ) ==>" + ( isNumAnsCellFilled && isDropAnsCellFilled ));
**/
         if ( isNumAnsCellFilled ^ isDropAnsCellFilled ) {
             if ( isNumAnsCellFilled ) {
                 try {
                     Double.parseDouble( numAns );
                     sad.setAnswer( numAns );
                 } catch (NumberFormatException e) {
                     hasError = true;
                     this.li_errors.add( "Error for DATA  Question " + qNumInfo +  " in col " + (col+1) + " and row " + (row+1)  + " [cell " + this.mp_R1C1Map.get(col+1) + (row+1) +  "] answer invalid should be a number found " + numAns );
                     LOG.error( "Error for DATA  Qstn " + qstnId +  " in col " + (col+1) + " and row " + (row+1) + " answer invalid should be numeric found " + numAns );
                     
                     return;
                     
                 }
             }
             
             if ( isDropAnsCellFilled ) {
                 sad.setAnswer( dropAns );
             }
             
         } else if ( !(isNumAnsCellFilled || isDropAnsCellFilled) ) {
             sad.setAnswer( null );
         } else if ( isNumAnsCellFilled && isDropAnsCellFilled ) {
/** rem no need         
LOG.info("here in both numans is -->" + numAns + "<--         dropAns is -->" +dropAns + "<--");     
LOG.info("dropAns != \"\" --> " + dropAns != "");    
LOG.info("dropAns == \"\" --> " + dropAns == "");  
//LOG.info("dropAns.equ\"\" ==> " + dropAns.equals(""));
//LOG.info("!dropAns.equ\"\" ==> " + !dropAns.equals(""));

LOG.info("numAns != \"\" --> " + numAns != "");    
LOG.info("numAns == \"\" --> " + numAns == ""); 
//LOG.info("numAns.equ\"\" ==> " + numAns.equals(""));
//LOG.info("!numAns.equ\"\" ==> " + !numAns.equals(""));

rem no need **/

             if (  ( numAns != null && numAns != "" && numAns != " " /*&& !numAns.equals("") && !numAns.equals(" ") */)
                && ( dropAns != null && dropAns != "" && dropAns != " "/* && !dropAns.equals("") && !dropAns.equals(" ")*/)    
             ) {
                 hasError = true;
                 
                 this.li_errors.add( "Error for DATA Question " + qNumInfo +  " in col " + (col+1) + " and row " + (row+1)  + " [cell " + this.mp_R1C1Map.get(col+1) + (row+1) +  "]. Both number and dropdown selection found. Please enter either number, or choose response from dropdown");//" answer  can be either numeric  or text found both --> numeric " + numAns + " and text from drop-down " + dropAns);     
                 LOG.info( "RETUERNING__3__Error for DATA   Qstn " + qstnId +  " in col " + (col+1) + " and row " + (row+1) + " answer  can be either numeric  or text found both --> numeric |" + numAns + "| and text from drop-down |" + dropAns + "|");
                 
                 return;
             } else {
                 if (  ( numAns != null && numAns != "" && numAns != " " /*&& !numAns.equals("") && !numAns.equals(" ")*/ ) ) {
                     sad.setAnswer( numAns );
                 } else if (( dropAns != null && dropAns != "" && dropAns != " "/* && !dropAns.equals("") && !dropAns.equals(" ")*/)  ) {
                     sad.setAnswer( dropAns );
                 } else {
//LOG.info("ARRRRRRRRRRRGH");       
                    sad.setAnswer( null );
                 }
             }
         }
         
         
         
         
         
         
         
         
         
         
//         LOG.info("qstid " + qstnId + " numAns is |" + numAns + " and dropAns is |" + dropAns + "|");
/****************************************         
         boolean isNumAnsNull = (numAns != null && !( numAns == "" || numAns == " " || numAns != "null"));
         boolean isDropAnsNull = (dropAns != null && !( dropAns == "" || dropAns == " " || dropAns != "null"));
LOG.info("isNumAnsNull " + isNumAnsNull + " and isDropAnsNull " + isDropAnsNull) ;        
LOG.info(" isNumAns ^ isdropans " + (isNumAnsNull ^ isDropAnsNull) );
        LOG.info(" isNumAns && isdropans " + (isNumAnsNull && isDropAnsNull) );
        LOG.info(" !isNumAns && !isdropans " + (!isNumAnsNull && !isDropAnsNull) );
         
         if ( isNumAnsNull ^ isDropAnsNull ) {
             if ( isDropAnsNull ) {
                 answer = dropCell.getContents();
                 sad.setAnswer( answer );
             } else if ( isNumAnsNull ) {
                 try {
                 //                                    int theAns = Integer.parseInt(numAns);
                     Double.parseDouble(numAns);
                     sad.setAnswer(numAns);
                 } catch ( NumberFormatException nfe ) {
                     hasError = true;
                     this.li_errors.add( "Error for DATA  Qstn " + qstnId +  " in col " + (col+1) + " and row " + (row+1) + " answer invalid should be numeric found " + numAns );
                 LOG.info( "Error for DATA  Qstn " + qstnId +  " in col " + (col+1) + " and row " + (row+1) + " answer invalid should be numeric found " + numAns );
                 }
             }
         } else if ( isNumAnsNull && isDropAnsNull ) {
             sad.setAnswer( null );   
         } else if ( !isNumAnsNull && !isDropAnsNull ) {
             hasError = true;
//             sad.setAnswer( null ); 
             this.li_errors.add( "Error for DATA   Qstn " + qstnId +  " in col " + (col+1) + " and row " + (row+1) + " answer  can be either numeric  or text found both --> numeric " + numAns + " and text from drop-down " + dropAns);     
LOG.info( "Error for DATA   Qstn " + qstnId +  " in col " + (col+1) + " and row " + (row+1) + " answer  can be either numeric  or text found both --> numeric |" + numAns + "| and text from drop-down |" + dropAns + "|");
             
         }
    ///////////////////////////////////////
    ***************************************/     
         /****************
         if ( ( numAns != null && (numAns != "" || numAns != " ") ) ^ ( dropAns != null && ( dropAns != "" || dropAns != " ") ) ) {
             if ( ((numAns == null || (numAns == "" || numAns == " ") ) &&  ( dropAns != null || ( dropAns != "" || dropAns != " ") ) ) && !hasError ) {
                 answer = dropCell.getContents();
                 sad.setAnswer( answer );
             } else if ( ((numAns != null && (numAns != "" || numAns != " ") )  && ( dropAns == null || dropAns == "" || dropAns == " " ) ) && !hasError ) {
                 try {
        //                                    int theAns = Integer.parseInt(numAns);
                     Double.parseDouble(numAns);
                     sad.setAnswer(numAns);
                 } catch ( NumberFormatException nfe ) {
                     hasError = true;
                     this.li_errors.add( "Error for DATA  Qstn " + qstnId +  " in col " + (col+1) + " and row " + (row+1) + " answer invalid should be numeric found " + numAns );
LOG.info( "Error for DATA  Qstn " + qstnId +  " in col " + (col+1) + " and row " + (row+1) + " answer invalid should be numeric found " + numAns );                     
                 }
             }
         } else if ( ( (numAns == null || numAns == "" || numAns == " ") && (dropAns == null || dropAns == ""  || dropAns == " ")) ) {
                sad.setAnswer( null );             
         } else if ( (numAns != null || numAns != "" || numAns != " ") && (dropAns != null || dropAns != "" || dropAns != " ") ) {
             hasError = true;
//             sad.setAnswer( null ); 
             this.li_errors.add( "Error for DATA   Qstn " + qstnId +  " in col " + (col+1) + " and row " + (row+1) + " answer  can be either numeric  or text found both --> numeric " + numAns + " and text from drop-down " + dropAns);     
LOG.info( "Error for DATA   Qstn " + qstnId +  " in col " + (col+1) + " and row " + (row+1) + " answer  can be either numeric  or text found both --> numeric |" + numAns + "| and text from drop-down |" + dropAns + "|");             
         }
         **************/
//   LOG.info("in processSingle post 1 answer is |" + sad.getAnswer() + "|");
   
         if ( needsHint ) {
             int hintCol = this.mp_QuestionTag_Col.get(qstnId+"_H");
             Cell txtHintCell = sheet.getCell(hintCol, row);
             
             if ( txtHintCell != null ) {
               ansText = txtHintCell.getContents();
               sad.setSra_answer_text( ansText );
               
               CellFeatures cf = txtHintCell.getCellFeatures();
               if ( cf != null ) {
                   ansComment = cf.getComment();
                   sad.setSra_comment( ansComment );
               }
             }
             
             
             CellFormat cfo = txtHintCell.getCellFormat();
             if ( cfo != null ) {
                 if ( cfo.getBackgroundColour() != null ) {
                     
                     Colour clr = cfo.getBackgroundColour();
                     if ( ! ( clr.equals(Colour.GRAY_25) ||  clr.equals(Colour.DEFAULT_BACKGROUND)  ) ) {
                     
                         
                         RGB rgb = clr.getDefaultRGB();
                         String r = Integer.toHexString(rgb.getRed());
                         String g = Integer.toHexString(rgb.getGreen());
                         String b = Integer.toHexString(rgb.getBlue());
                         
                         sad.setSra_color("#"+r+g+b);
                     }
                     
                 }
             }
         }
         
        
        if ( /*! sad.isEmpty() && */!hasError ) {
            theList.add( sad );
        }
        else {
            LOG.error( "ERROR IN PROCESSNUMERIC " + sad );
        }
    }

    private void processSingleQuestion(Sheet sheet, 
                                       List<SourceAnswersDataSetInfo> theList, 
                                       int row, int col, Integer qstnId, String qNumInfo,
                                       QuestionDataSetInfo theQInfo, 
                                       boolean needsHint, 
                                       SourceAnswersDataSetInfo sad,
                                       Map<Integer, List<ReportAnswerSetValuesDataSetInfo>> mp_qstnId_rprtAnsSetValues) {
        String answer;
        String ansText;
        String ansComment;
        // single --- id and hint ---> 45541, 45541_H -- 2 cols max
        answer = null;
        ansText = null;
        ansComment = null;
        
        PlatformAppModuleService service = PlatformAppModuleServiceImpl.getInstance();
        boolean canAddAnswers = false;
        List<String> liExtraAnsVals = new ArrayList<String>();
        try {
            canAddAnswers = service.canAddAnswerSetsToQuestion( new oracle.jbo.domain.Number( qstnId ) );
        } catch (SQLException e) {
            LOG.error("error in finding canaddanswer for qstn", e);
        }
        
        if ( canAddAnswers ) {
            List<ReportAnswerSetValuesDataSetInfo> qnsRavList = mp_qstnId_rprtAnsSetValues.get( qstnId );
            for ( ReportAnswerSetValuesDataSetInfo rav : qnsRavList ) {
                liExtraAnsVals.add( rav.getRav_answer() );
            }
        }
        
        boolean hasError = false;
         Cell ansCell = sheet.getCell(col, row);
         if (  ansCell != null && !ansCell.getType().equals(CellType.EMPTY) ) {
             answer = ansCell.getContents().trim();
             CellFeatures cf = ansCell.getCellFeatures();
             if ( cf != null && !cf.hasDataValidation() ) {
                 hasError = true;
                 this.li_errors.add( "Error for SINGLE Question " + qNumInfo +  " in col " + (col+1) + " and row " + (row+1)  + " [cell " + this.mp_R1C1Map.get(col+1) + (row+1) +  "] answer is not in a validation list");
                 LOG.error( "1111 Error for SINGLE Question " + qstnId +  " in col " + (col+1) + " and row " + (row+1) + " answer is not in a validation list");
                 return;
             }
             
             List<ReportAnswerSetValuesDataSetInfo> singleAnswerSetsInfo = theQInfo.getSingleAnswerSetsInfo();
             List<String> liOptions = new ArrayList<String>();  
//             Map<String, Integer> mp_Answer_ASVID = new HashMap<String, Integer>();
//             Map<String, Integer> mp_Answer_RAVID = new HashMap<String, Integer>();
             for ( Iterator<ReportAnswerSetValuesDataSetInfo> it = singleAnswerSetsInfo.iterator(); it.hasNext(); ) {
                 ReportAnswerSetValuesDataSetInfo asvInfo = it.next();
                 String asvAnswer = asvInfo.getRav_answer().trim();                 
                 liOptions.add(asvAnswer);
//                 mp_Answer_ASVID.put(asvAnswer, asvInfo.getAsv_id() );
//                 mp_Answer_RAVID.put(asvAnswer, )
             }
//rem no need
//LOG.info("options--singleQ");
//for (int i = 0; i < liOptions.size(); i++) {
//    LOG.info("|" + liOptions.get(i) + "|");
//} rem no need

             
             if ( canAddAnswers ) {
             
                for ( String val : liExtraAnsVals) {
                    liOptions.add( val );
                }
//                 boolean isExtraAnsValsAdded = liOptions.addAll( liExtraAnsVals );
//                 if ( !isExtraAnsValsAdded  ) {
//                     hasError = true;
//                     this.li_errors.add( "Error for SINGLE Qstn " + qNumInfo +  " in col " + (col+1) + " and row " + (row+1)  + " [cell " + this.mp_R1C1Map.get(col+1) + (row+1) +  "]  could not add answer to the valid list");
//                     LOG.error( "221122 Error for SINGLE Qstn " + qNumInfo +  " in col " + (col+1) + " and row " + (row+1)  + " [cell " + this.mp_R1C1Map.get(col+1) + (row+1) +  "]  could not add answer to the valid list");
//                 }
             }
             
LOG.info("sINGLE RAEDER ANS IS |" + answer + "| for qstid " + sad.getQst_id() + " and rpsid " + sad.getRps_id());           
             answer = answer.trim();
             
             if ( liOptions.contains( answer ) ) {
               sad.setAnswer( answer );
//               int asvId = mp_Answer_ASVID.get( answer );
               if ( answer != null || answer != "") {
                   int rasId = sad.getRas_Id();
                   int ravId = PlatformAppModuleServiceImpl.getInstance().getRavInfo( rasId, answer/*, theQInfo.getQst_type()*/ );
                   
                   sad.setRav_Id( ravId );
               } else {
                   sad.setAnswer( null );
                   sad.setRav_Id( 0 );
               }
               
               //sad.setAsv_Id( mp_Answer_ASVID.get( answer ));
             } else {
               if ( answer != null && !answer.equals("") ) {
                 hasError = true;
                 this.li_errors.add( "Error for SINGLE Qstn " + qNumInfo +  " in col " + (col+1) + " and row " + (row+1)  + " [cell " + this.mp_R1C1Map.get(col+1) + (row+1) +  "] answer is not in valid list --- found " + answer);
                 LOG.error( "2222 Error for SINGLE Qstn " + qstnId +  " in col " + (col+1) + " and row " + (row+1) + " answer is not in valid list --- found " + answer);
               }
             }
         } else if (  ansCell != null && ansCell.getType().equals(CellType.EMPTY) ) {
            sad.setAnswer( null );
            sad.setRav_Id( 0 );
         }
         
         if ( needsHint ) {
             int hintCol = this.mp_QuestionTag_Col.get(qstnId+"_H");
             Cell txtHintCell = sheet.getCell(hintCol, row);
             
             if ( txtHintCell != null ) {
               ansText = txtHintCell.getContents();
               sad.setSra_answer_text( ansText );
               
               CellFeatures cf = txtHintCell.getCellFeatures();
               if ( cf != null ) {
                   ansComment = cf.getComment();
                   sad.setSra_comment( ansComment );
               }
               
                CellFormat cfo = txtHintCell.getCellFormat();
                if ( cfo != null ) {
                     if ( cfo.getBackgroundColour() != null ) {
                         
                         Colour clr = cfo.getBackgroundColour();
                         if ( ! ( clr.equals(Colour.GRAY_25) ||  clr.equals(Colour.DEFAULT_BACKGROUND)  ) ) {
                         
                             
                             RGB rgb = clr.getDefaultRGB();
                             String r = Integer.toHexString(rgb.getRed());
                             String g = Integer.toHexString(rgb.getGreen());
                             String b = Integer.toHexString(rgb.getBlue());
                             
                             sad.setSra_color("#"+r+g+b);
                         }
                     } 
                 }
             }
         }  
         
         if ( /*! sad.isEmpty() && */!hasError ) {
//               LOG.info( sad );
             theList.add( sad );
         }
             
         
    }
    
    /**
     * Returns a list of sources including extra sources to be used in processing the answers
     * @param sheet == the answers grid sheet
     * @param mpRepSrcIdSrcId   == the map connecting report source ids to the source ids
     * @param existingRprtInit_RprtIdMap == the map connecting reporter's ids to their initials
     * @param mp_extraRepSrcIdSrcId == the map connecting report source ids to the source ids for <b>additonal valid sources </b>
     * @param mp_extraRpsIdSrcDataInfo == the map connecting report source ids to the source data objects for <b>additonal valid sources </b>
     * @return list_sources -- a list of SourceDataSetInfo objects including the valid additional sources from the Extra_Sources sheet
     */
    public List<SourceDataSetInfo> buildSourceInfo(Sheet sheet, 
                                                   //LinkedHashMap<Integer, SourceDataSetInfo> existingSrcs, 
                                                   Map<Integer, Integer> mpRepSrcIdSrcId, 
                                                   Map<String, Integer> existingRprtInit_RprtIdMap,
                                                   Map<Integer, Integer> mp_extraRepSrcIdSrcId,
                                                   Map<Integer, SourceDataSetInfo> mp_extraRpsIdSrcDataInfo
                                                   ) {
        List<SourceDataSetInfo> list_sources = new ArrayList<SourceDataSetInfo>();
        int repSrc_YN_Col = AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_COL-1;
        int reptrInitCol =  AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_COL-2;
        Cell[] repSrc_yn_Col = sheet.getColumn(repSrc_YN_Col);
        Cell[] repSrcIdCol = sheet.getColumn(0);
        
System.out.println("mp_extraRepSrcIdSrcId is " + mp_extraRepSrcIdSrcId);
System.out.println("mp_extraRpsIdSrcDataInfo is " + mp_extraRpsIdSrcDataInfo);

LOG.info("this.mp_RepSourceIds_Rows size is " + this.mp_RepSourceIds_Rows.size() + " in buildSourceInfo anmd it is\n");
this.printMap( this.mp_RepSourceIds_Rows );

        Set<Integer> repSrcIds = this.mp_RepSourceIds_Rows.keySet();
        Set<Integer> extraRepSrcIds = this.mp_ExtraRepSourceIds_Rows.keySet();
System.out.println("extraRepsrcIds is " + extraRepSrcIds);        
        
LOG.info("size of mpRepSrcIdSrcId " + mpRepSrcIdSrcId.size() + " in buildSourceInfo; and mpRepSrcIdSrcId is is \n");        
this.printMap(mpRepSrcIdSrcId );   

LOG.info("size of repSrcIds " + repSrcIds.size() + " in buildSourceInfo; and repSrcIds is is \n");        
this.printSet(repSrcIds );   

        for ( Iterator<Integer> it = repSrcIds.iterator(); it.hasNext(); ) {
            SourceDataSetInfo s = new SourceDataSet();
                      
            int repSrcId = it.next();
            
LOG.info("repSrcId inside forloop in buildSourceInfo " + repSrcId );  
            s.setRps_id(repSrcId);
            // added check for npe here
            // this is not good coding practise but is defensive coding in a way
            if ( mpRepSrcIdSrcId.get(repSrcId) != null ) {
LOG.info("mpRepSrcIdSrcId.get(repSrcId) != null for repSrcId " + repSrcId);
System.out.println("mpRepSrcIdSrcId.get(repSrcId) != null for repSrcId " + repSrcId);
                s.setSrc_id(mpRepSrcIdSrcId.get(repSrcId));
                String repContents = null;
                boolean isRepSrc_YN = false;
                int row = this.mp_RepSourceIds_Rows.get(repSrcId);
                Cell repSrcCell = sheet.getCell(repSrc_YN_Col, row);
                if ( repSrcCell.getType().equals(CellType.EMPTY)) {
                    // cell was empty set repeat flag to no
                     repContents = "N";
                    s.setRps_repeat_source_yn(repContents);
                } else {                
                    CellFeatures repSrcCellFeatures = repSrcCell.getCellFeatures();
                    if ( repSrcCellFeatures.hasDataValidation() ) {
                        repContents = repSrcCell.getContents();
    System.out.println("repContents IS " + repContents + " FOR COL " + repSrc_YN_Col + " AND ROW " + row);                    
                        if ( repContents.equalsIgnoreCase("Yes") ) repContents = "Y";
                        else if ( repContents.equalsIgnoreCase("No") ) repContents = "N";
                        else {
                            this.li_errors.add("Error -- invalid answer for Repeat Source at col " + (repSrc_YN_Col+1) + " and row " + (row+1)  + " [cell " + this.mp_R1C1Map.get(repSrc_YN_Col+1) + (row+1) + "]." );
                            continue;
                        }
                        s.setRps_repeat_source_yn(repContents);
                        
                        
                        
    //                    s.getReportSourceInfo().setRps_repeat_source_yn(repContents);
                    } else {
                        // cell was not empty but didnot have validation set repeat flag to no
                         repContents = "N";
                        s.setRps_repeat_source_yn(repContents);
                    }
                    
                }
                
                ReportSourcesDataSetInfo rpsInf;
                if ( s.getReportSourceInfo() != null ) {
                    rpsInf = s.getReportSourceInfo();
                } else {
                    rpsInf = new ReportSourcesDataSet();                        
                }
                
                rpsInf.setRps_repeat_source_yn( repContents );
                
                // set it back double blind it
                s.setReportSourceInfo( rpsInf );
                
                Cell reprterInitCell = sheet.getCell(reptrInitCol, row);
                String repInit = reprterInitCell.getContents();
                
                s.setEmp_init(repInit);
                s.setRps_rptr_id(existingRprtInit_RprtIdMap.get(repInit)); 
                
                list_sources.add(s);   
            } else {
LOG.info("mpRepSrcIdSrcId.get(repSrcId) IS  null for repSrcId " + repSrcId);
System.out.println("mpRepSrcIdSrcId.get(repSrcId) IS null for repSrcId " + repSrcId);
System.out.println("TRYING in else");
                if ( mp_extraRepSrcIdSrcId != null && mp_extraRepSrcIdSrcId.get(repSrcId) != null ) {
                    s.setSrc_id(mp_extraRepSrcIdSrcId.get(repSrcId));
                    String repContents = null;
                    boolean isRepSrc_YN = false;
                    int row = this.mp_ExtraRepSourceIds_Rows.get(repSrcId);
                    Cell repSrcCell = sheet.getCell(repSrc_YN_Col, row);
                    if ( repSrcCell.getType().equals(CellType.EMPTY)) {
                        // cell was empty set repeat flag to no
                         repContents = "N";
                        s.setRps_repeat_source_yn(repContents);
                    } else {  
                    CellFeatures repSrcCellFeatures = repSrcCell.getCellFeatures();
                    if ( repSrcCellFeatures.hasDataValidation() ) {
                        repContents = repSrcCell.getContents();
System.out.println("mp_extraRepSrcIdSrcId--repContents IS " + repContents + " FOR COL " + repSrc_YN_Col + " AND ROW " + row);   
                        if ( repContents.equalsIgnoreCase("Yes") ) repContents = "Y";
                        else if ( repContents.equalsIgnoreCase("No") ) repContents = "N";
                        else {
                            this.li_errors.add("Error -- invalid answer for Repeat Source at col " + (repSrc_YN_Col+1) + " and row " + (row+1)  + " [cell " + this.mp_R1C1Map.get(repSrc_YN_Col+1) + (row+1) + "]." );
                            continue;
                        }
                        s.setRps_repeat_source_yn(repContents);
                    }  
                }    
                ReportSourcesDataSetInfo rpsInf;
                if ( s.getReportSourceInfo() != null ) {
                    rpsInf = s.getReportSourceInfo();
                } else {
                    rpsInf = new ReportSourcesDataSet();                        
                }
                
                rpsInf.setRps_repeat_source_yn( repContents );
                
                // set it back double blind it
                s.setReportSourceInfo( rpsInf );
                        
                    
//                        s.getReportSourceInfo().setRps_repeat_source_yn(repContents);
                   
                    
                    Cell reprterInitCell = sheet.getCell(reptrInitCol, row);
                    String repInit = reprterInitCell.getContents();
                    
                    s.setEmp_init(repInit);
                    s.setRps_rptr_id(existingRprtInit_RprtIdMap.get(repInit)); 
                    
                    list_sources.add(s); 
                }
            }
        }
        
        if ( extraRepSrcIds != null && extraRepSrcIds.size() > 0 ) {
            for ( Iterator<Integer> it = extraRepSrcIds.iterator(); it.hasNext(); ) {
    //            SourceDataSetInfo s = new SourceDataSet();
                          
                int extraRepSrcId = it.next();
    System.out.println("extraRepSrcId is " + extraRepSrcId);            
                LOG.info("extraRepSrcIds--repSrcId inside forloop in buildSourceInfo " + extraRepSrcId );
                
                if ( mp_extraRpsIdSrcDataInfo != null ) {
    //            s.setRps_id(extraRepSrcId);
                // added check for npe here
                // this is not good coding practise but is defensive coding in a way
                    if ( mp_extraRpsIdSrcDataInfo.get(extraRepSrcId) != null ) {
                        SourceDataSetInfo s = mp_extraRpsIdSrcDataInfo.get(extraRepSrcId);
                        
                    LOG.info("mp_extraRepSrcIdSrcId--mpRepSrcIdSrcId.get(repSrcId) != null for repSrcId " + extraRepSrcId);
                    System.out.println("mp_extraRepSrcIdSrcId--mpRepSrcIdSrcId.get(repSrcId) != null for repSrcId " + extraRepSrcId);
                        s.setSrc_id(mpRepSrcIdSrcId.get(extraRepSrcId));
                        
                        boolean isRepSrc_YN = false;
                        int row = this.mp_ExtraRepSourceIds_Rows.get(extraRepSrcId);
                        Cell repSrcCell = sheet.getCell(repSrc_YN_Col, row);
                        CellFeatures repSrcCellFeatures = repSrcCell.getCellFeatures();
                        if ( repSrcCellFeatures.hasDataValidation() ) {
                            String repContents = repSrcCell.getContents();
                    System.out.println("repContents IS " + repContents + " FOR COL " + repSrc_YN_Col + " AND ROW " + row);
                            if ( repContents.equals("Yes") ) repContents = "Y";
                            else if ( repContents.equals("No") ) repContents = "N";
                            else {
                                this.li_errors.add("Error -- invalid answer for Repeat Source at col " + (repSrc_YN_Col+1) + " and row " + (row+1)  + " [cell " + this.mp_R1C1Map.get(repSrc_YN_Col+1) + (row+1) + "]." );
                                continue;
                            }
                            s.setRps_repeat_source_yn(repContents);
                            
                            
                            ReportSourcesDataSetInfo rpsInf;
                            if ( s.getReportSourceInfo() != null ) {
                                rpsInf = s.getReportSourceInfo();
                            } else {
                                rpsInf = new ReportSourcesDataSet();                        
                            }
                            
                            rpsInf.setRps_repeat_source_yn( repContents );
                            
                            // set it back double blind it
                            s.setReportSourceInfo( rpsInf );
                            
                            
        //                    s.getReportSourceInfo().setRps_repeat_source_yn(repContents);
                        }
                        
                        Cell reprterInitCell = sheet.getCell(reptrInitCol, row);
                        String repInit = reprterInitCell.getContents();
                        
                        s.setEmp_init(repInit);
                        //s.setRps_rptr_id(existingRprtInit_RprtIdMap.get(repInit)); 
        System.out.println("adding extra s to list_sources " + s);                
                        list_sources.add(s);   
                    }
                }
            }
            
        }
        return list_sources;
        
    }
    
    public List<String> getAll_errors() {
        return this.li_errors;
    }
    
    public void flushErrors() {
        this.li_errors  = new ArrayList<String>();
        this.li_warnings = new ArrayList<String>();
    }
    
    public static boolean xor(boolean a, boolean b) {    return (a && !b) || (b && !a);         }
    
    
    
//    public Map<Integer, String> buildRepeatSourcesMap() {
//        
//    }
/*
    private List<SourceAnswersDataSetInfo> buildSourceAnswersMap(final int start_ans_col,
                                                                        final int start_ans_row,
                                                                        final int end_ans_col,
                                                                        final int end_ans_row,
                                                                        final Sheet sheet) {

            List<SourceAnswersDataSetInfo> theList = new ArrayList<SourceAnswersDataSetInfo>();




            for ( int col = start_ans_col; col <= end_ans_col; col++  ) {
                for ( int row = start_ans_row; row <= end_ans_row; row++ ) {
                    String qstId = sheet.getCell(col, 0).getContents();
                    String srcId = sheet.getCell(0, row).getContents();



                    if ( qstId.equals("Repeat") ) {

                        String ans = sheet.getCell(col, row).getContents();
                        if ( ! ( ans.equals("Yes") || ans.equals("No") ) ) {
                            li_errors.add("Invalid repeat value for src in row " + row);
                        } else {
                            LOG.info("repeat " + ans + " for srcId " + srcId);
    //                        SourceAnswersDataSetInfo sad = new SourceAnswersDataSet();
    //                        sad.set
                        }
                    }













                }
            }















            return theList;
    }
*/

    private String getQuestionNumberInfo(QuestionDataSetInfo qis) {
        int qNum = qis.getQst_numeric();
        if ( qNum == 0 ) {
            return qis.getQst_question();
        }
        String qAlpha = qis.getQst_alpha();
        String qstn = qis.getQst_question();
        if ( qis.getQst_type().equalsIgnoreCase("SORT") ) 
            return qstn;
            
        try {
            if ( qAlpha != null ) {
                Integer.parseInt(qAlpha);
                return  String.valueOf(qNum); 
            }
        } catch (NumberFormatException e) { /*swallow it - do nothing */ }
        
        return qNum + qAlpha;
    }
    
    
    private Map<Integer, String> mp_R1C1Map;
    public Map<Integer, String> getMp_R1C1Map() {
        return this.mp_R1C1Map;
    }
    
    public final Map<Integer, String> buildMp_R1C1Map() {
        Map<Integer, String> mp = new HashMap<Integer, String>();
        
        final int last = 255;
        final int chCount = 25;
        final int startChA = 65;
        final int endChZ = 90;
        
        int thecol = 0;
        
        while ( thecol <= last ) {
            int times = thecol / chCount;
            
            if ( times > 0 ) {
                int pref = startChA + times - 1;
                
                for ( int count = 0; count <= chCount; count++) {
                    mp.put(thecol, String.valueOf((char)(pref)) + "" + String.valueOf((char)(count+startChA)));
                    thecol++;// += count;
                }
                
            } else {
                for ( int count = 0; count <= chCount; count++) {
                    mp.put(thecol, String.valueOf((char)(count+startChA)));
                    thecol++;
                }
            }
            
            
        }
            thecol++;
        
        
        
        return this.mp_R1C1Map = mp;
    }

    private Map<Integer, SourceDataSetInfo> getMapRepSourceIds(Map<Integer, SourceDataSetInfo> mp_internalsrcid_src) {
    if ( mp_internalsrcid_src == null ) {
        LOG.info("mp_internalsrcid_src IS NULL");
        return null; 
    }
    LOG.info("mp_internalsrcid_src.size() in getMapRepSourceIds " + mp_internalsrcid_src.size());
        if ( mp_internalsrcid_src.size() == 0 ) return null;
        
        Map<Integer, SourceDataSetInfo> mp_repSrcIds =  new HashMap<Integer, SourceDataSetInfo>();
        Set<Integer> internalIds = mp_internalsrcid_src.keySet();
        
        for ( Integer i : internalIds ) {
            SourceDataSetInfo s = mp_internalsrcid_src.get( i );
            int rpsId = s.getRps_id();
            mp_repSrcIds.put( rpsId, s );
        }
LOG.info("Printing mp_repSrcIds");        
this.printMap(mp_repSrcIds);        
        return mp_repSrcIds;
    }
    
    
    public Map<Pair, Integer> getQstIdQmqNum_QmqIdMap( LinkedHashMap<Integer, QuestionDataSetInfo> existingQstns ) {
        if ( existingQstns == null || existingQstns.size() == 0 ) { System.out.println("existingQstns is null or its size is zero"); return null; }
        Map<Pair, Integer> theMap = new HashMap<Pair, Integer>();    // stores x --> pair( qstid, qstnum)   y --> qmqid
        Collection<QuestionDataSetInfo> collectionOfQuestions = existingQstns.values();
        for( QuestionDataSetInfo qn : collectionOfQuestions ) {
            if ( qn.getQst_type().equalsIgnoreCase("MULTI") ) {
                List<MultiQuestionDataSetInfo> qnQmqInfo = qn.getMultiQuestionInfo();
System.out.println("qnQmqInfo size is " + qnQmqInfo.size() + " for qstnid " + qn.getQst_id() );                
                if ( qnQmqInfo.size() > 0 ) {
                    
                    for ( MultiQuestionDataSetInfo qmq : qnQmqInfo ) {
                        int qstid = qn.getQst_id();
System.out.println( "qst_id is " + qstid );                        
                        int qmq_qst_id = qmq.getQmq_qst_id();
System.out.println( "qmq_qst_id is " + qmq_qst_id );
                        //if ( qmq_qst_id == qstid ) {
                            int qstNum = Integer.parseInt( qmq.getQmq_number() );
                            int qmqId = qmq.getQmq_id();
                            
                            theMap.put( new Pair<Integer, Integer>( qstid, qstNum), qmqId );
                        //}
                        
                    }
                }
            }
        }
System.out.println("returning themap " + theMap );        
        return theMap;
    }
}
