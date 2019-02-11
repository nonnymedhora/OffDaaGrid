package com.bawaweb.grid.templates.reader;

import com.bawaweb.grid.templates.AnswersGridTemplateRangeConstants;
import com.bawaweb.grid.templates.data.cursors.QuestionDataSet;
import com.bawaweb.grid.templates.data.cursors.QuestionDataSetInfo;

import com.bawaweb.grid.templates.data.tables.AnswerSetValuesDataSetInfo;
import com.bawaweb.grid.templates.data.tables.ReportAnswerSetValuesDataSetInfo;
import com.bawaweb.grid.templates.data.tables.SourceDataSetInfo;
import com.bawaweb.grid.templates.sheets.AnswersGridSheetReader;
import com.bawaweb.grid.templates.sheets.AnswersGridSheetReaderImpl;
import com.bawaweb.services.PlatformAppModuleService;
import com.bawaweb.services.PlatformAppModuleServiceImpl;

import com.bawaweb.views.model.common.ReportAnswerSetValues;

import java.io.File;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import java.util.Set;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;

public class TestExtraQuestionsAnswerSetsSheetReader {  
    public final static int REPORTER_ID = 54054;
    public final static String EXCEL_FILE = "\\\\san-sv-filer\\nmedhora$\\my documents\\jxlTesting\\test_extra_qstns_all.xls";
    
    
    // maps col# to question
    private Map<Integer, QuestionDataSetInfo> mp_col_qstn = new HashMap<Integer, QuestionDataSetInfo>();
    
    // maps qstn to col#
     private Map<QuestionDataSetInfo, Integer> mp_qstn_col = new HashMap<QuestionDataSetInfo, Integer>();
     
    // maps internal id to question
    private Map<Integer, QuestionDataSetInfo> mp_internalqstnid_qstn = new HashMap<Integer, QuestionDataSetInfo>();

    // maps question to internal id    
    private Map<QuestionDataSetInfo, Integer> mp_qstn_interalqstnid = new HashMap<QuestionDataSetInfo, Integer>();
    
    
    public TestExtraQuestionsAnswerSetsSheetReader() {
    }

    public static void main(String[] args) throws Exception {
        TestExtraQuestionsAnswerSetsSheetReader xtraReader = new TestExtraQuestionsAnswerSetsSheetReader();
        
        PlatformAppModuleService platform = PlatformAppModuleServiceImpl.getInstance();
        
        AnswersGridSheetReader reader = AnswersGridSheetReaderImpl.getInstance();
        File theFile = new File(EXCEL_FILE);
        reader.setTheFile(theFile);
System.out.println("READING FILE " + EXCEL_FILE) ;       
        Workbook w = reader.extractWorkbook(new File(EXCEL_FILE));
        int reportId = reader.getReportId(w);
        
        if ( reportId == 0 ) {
            throw new Exception("Invalid report id - 0" );
        //            System.exit(100);
        }
        
        int reporterId = reader.getReporterId(w);        
        if ( reporterId == 0 ) {
            throw new Exception("Invalid reporter id - 0" );
        //            System.exit(100);
        }
        
        Sheet extraQuestionAnswersSheet = reader.extractExtraQuestionAnswersSheet(w);
        
        Map<Integer, List<ReportAnswerSetValuesDataSetInfo>> mp_qstnId_rprtAnsSetValues = platform.getExtraQuestionsReportAnswerSetValuesMap(reportId);
        Map<Integer, List<AnswerSetValuesDataSetInfo>>  mp_qstnId_ansSetValues = platform.getExtraQuestionsAnswerSetValuesMap(reportId);
        
        xtraReader.printMap( mp_qstnId_rprtAnsSetValues );
        
        
        
        
        List<QuestionDataSetInfo> extraQuestions = xtraReader.getExtraQuestions(extraQuestionAnswersSheet, reportId, mp_qstnId_rprtAnsSetValues);
        xtraReader.printList( extraQuestions );
        
        
        xtraReader.addExtraAnswerSetValues( extraQuestions, mp_qstnId_ansSetValues, mp_qstnId_rprtAnsSetValues, platform );
        
        try {
           platform.commitAll();
        } catch ( Exception e) {
            platform.rollbackAll();
            System.out.println("Error in updating ANSWER VALUES........... exiting!!!");
            System.exit(4);
        }
           
        
    }
    
    
    
    
    

    private List<QuestionDataSetInfo> getExtraQuestions(Sheet extraQuestionAnswersSheet, int reportId, Map<Integer, List<ReportAnswerSetValuesDataSetInfo>> mp_qstnId_rprtAnsSetValues) {
        List<QuestionDataSetInfo> theQuestions = new ArrayList<QuestionDataSetInfo>();
        
        int top_col = AnswersGridTemplateRangeConstants.RANGE_QUESTIONS_TOP_COL;
        int top_row = AnswersGridTemplateRangeConstants.RANGE_QUESTIONS_TOP_ROW + 4;
        
        Set<Integer> extraQstnIds = mp_qstnId_rprtAnsSetValues.keySet();
System.out.println("size is " + extraQstnIds.size());        

        for (Iterator<Integer> it = extraQstnIds.iterator(); it.hasNext(); ) {
            QuestionDataSetInfo theQuestionInfo = new QuestionDataSet();
            List<String> extraAnswerSetValues = new ArrayList<String>();
            
            int qstnId = it.next();
            String theQstnId = String.valueOf( qstnId );
            theQuestionInfo.setQst_id( qstnId );
            
            List<String> existingAnswerSetValues = getExistingAnswerSetValues( mp_qstnId_rprtAnsSetValues.get( qstnId ) );
System.out.println("qstnid is " + qstnId );            
            Cell qstnIdCell = extraQuestionAnswersSheet.findCell( theQstnId );
            int col = qstnIdCell.getColumn() + 1;
            int row = qstnIdCell.getRow();
            
System.out.println("For qstnId " + theQstnId + " col is " + col + " row is " + row);          
            int numRepvalues = mp_qstnId_rprtAnsSetValues.get( qstnId ).size();
            int startRow = top_row;//row + 4 + numRepvalues;
System.out.println("For qstnId " + theQstnId + " col is " + col + " startRow is " + startRow);            
            
            for ( int i = 0; i < numRepvalues+AnswersGridTemplateRangeConstants.NUM_EXTRA_ANSWERS; i++, startRow++ ) {
                Cell ansCell = extraQuestionAnswersSheet.getCell(col, startRow );
                if ( ! ansCell.getType().equals( CellType.EMPTY ) ) {
                    String ansVal = ansCell.getContents();
                    if ( !existingAnswerSetValues.contains(ansVal)) {
System.out.println("Adding extraAnswer " + ansVal + " for qstnid " + theQstnId);                        
                        extraAnswerSetValues.add( ansVal );
                    }
                }
            }
            
            theQuestionInfo.setExtraAnswerSetValues( extraAnswerSetValues );
            
            theQuestions.add( theQuestionInfo );
        }
        
        
        
        
        
        
        
        
        
        
        return theQuestions;
    
    }
    
    public void printMap(Map aMap) {
        if ( aMap == null ) { System.out.println("amap is null"); return; }
        Set aSet = aMap.keySet();
System.out.println("map size is " + aSet.size());        
        for ( Iterator it = aSet.iterator(); it.hasNext(); ) {
            Object key = it.next();
            System.out.println(key + " ==> " + aMap.get(key));
        }
    }
    
    
    public void printList(List alist) {
        if ( alist == null ) { System.out.println("alist is null"); return; }
System.out.println("alist size is " + alist.size());
        Iterator it = alist.iterator();
        while ( it.hasNext() ) 
            System.out.println("|"+ it.next()+"|" );
    }


    private void addExtraAnswerSetValues(List<QuestionDataSetInfo> li_extraQuestions, 
                                        Map<Integer, List<AnswerSetValuesDataSetInfo>>  mp_qstnId_ansSetValues, 
                                        Map<Integer, List<ReportAnswerSetValuesDataSetInfo>> mp_qstnId_rprtAnsSetValues, 
                                        PlatformAppModuleService platform) { 
        if ( li_extraQuestions == null || li_extraQuestions.size() == 0 ) return;
        
        for( QuestionDataSetInfo qstn : li_extraQuestions ) {
            int qstnId = qstn.getQst_id();
            
            List<ReportAnswerSetValuesDataSetInfo> liExistingReportAnsSetVals = mp_qstnId_rprtAnsSetValues.get( qstnId );
            List<AnswerSetValuesDataSetInfo> liExistingAnsSetVals = mp_qstnId_ansSetValues.get( qstnId );
            
//            int ravDontKnowSeqNum = getRAVDontKnowSequenceNum( liExistingReportAnsSetVals );
//            int asvDontKnowSeqNum = getASVDontKnowSequenceNum( liExistingAnsSetVals );
            List<String> extraAnsVals = qstn.getExtraAnswerSetValues();
            
            
//            platform.addAnswerSetValues( qstnId, liExistingAnsSetVals, asvDontKnowSeqNum, liExistingReportAnsSetVals, ravDontKnowSeqNum, extraAnsVals);
            
            platform.addAnswerSetValues( qstnId, liExistingAnsSetVals, liExistingReportAnsSetVals, extraAnsVals );
//            
//            for ( String ansVal : extraAnsVals ) {
//               platform.addAnswerSetValues( qstnId, liExistingReportAnsSetVals, repdontKnowSeqNum, ansVal); 
//            }
        }
        
        
        try {
           platform.commitAll();
        } catch ( Exception e) {
            platform.rollbackAll();
            System.out.println("Error in updating ANSWER VALUES........... exiting!!!");
            System.exit(4);
        }
    }

    private List<String> getExistingAnswerSetValues(List<ReportAnswerSetValuesDataSetInfo> reportAnswerSetValuesDataSetInfo) {
        List<String> existingAnswerValues = new ArrayList<String>(reportAnswerSetValuesDataSetInfo.size());
        for ( ReportAnswerSetValuesDataSetInfo r :  reportAnswerSetValuesDataSetInfo ) {
            String answer = r.getRav_answer();
            existingAnswerValues.add( answer );
        }
        return existingAnswerValues;
        
    }

    private int getRAVDontKnowSequenceNum(List<ReportAnswerSetValuesDataSetInfo> liExistingReportAnsSetVals) {
        for ( ReportAnswerSetValuesDataSetInfo rav : liExistingReportAnsSetVals ) {
            String ansVal = rav.getRav_answer();
            if ( ansVal.equalsIgnoreCase("Don't know") ) {
                return rav.getRav_display_seq();
            }
        }
        return 0;
    }
    


    private int getASVDontKnowSequenceNum(List<AnswerSetValuesDataSetInfo> liExistingAnsSetVals) {
        for ( AnswerSetValuesDataSetInfo asv : liExistingAnsSetVals ) {
            String ansVal = asv.getAsv_answer();
            if ( ansVal.equalsIgnoreCase("Don't know") ) {
                return asv.getAsv_display_seq();
            }
        }
        return 0;
    }
    
}
