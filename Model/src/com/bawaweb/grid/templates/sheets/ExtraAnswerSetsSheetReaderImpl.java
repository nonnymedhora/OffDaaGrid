/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.sheets;

import com.bawaweb.grid.templates.AnswersGridTemplateRangeConstants;
import com.bawaweb.grid.templates.data.cursors.QuestionDataSet;
import com.bawaweb.grid.templates.data.cursors.QuestionDataSetInfo;

import com.bawaweb.grid.templates.data.tables.AnswerSetValuesDataSetInfo;
import com.bawaweb.grid.templates.data.tables.ReportAnswerSetValuesDataSetInfo;
import com.bawaweb.services.PlatformAppModuleService;
import com.bawaweb.services.PlatformAppModuleServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import java.util.Set;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;

import org.apache.log4j.Logger;
/**
 * This class reads in the 'Extra Answers' worksheet.
 * 
 */
public class ExtraAnswerSetsSheetReaderImpl implements ExtraAnswerSetsSheetReader {
    
    private static final Logger LOG = Logger.getLogger(ExtraAnswerSetsSheetReaderImpl.class);
    
    private int reportId;
    private int reporterId;
    
    
    
    /** list of warning messages **/
    private List<String> li_warnings;
    
    /** list of error messages **/
    private List<String> li_errors;
    
    /** maps col# to question   **/
    private Map<Integer, QuestionDataSetInfo> mp_col_qstn;
    
    /** maps qstn to col#   **/
     private Map<QuestionDataSetInfo, Integer> mp_qstn_col;
     
    /**  maps internal id to question   **/
    private Map<Integer, QuestionDataSetInfo> mp_internalqstnid_qstn;

    /**  maps question to internal id   **/    
    private Map<QuestionDataSetInfo, Integer> mp_qstn_interalqstnid;
    /**  the extra answer-sets sheet   **/
    private Sheet extraAnsSetsSheet;
    /** list of questions which may have additional report-answer-set values **/
    private List<QuestionDataSetInfo> li_extraQuestions;
    
    /**
     * Constructor --- reads in the contents of the given 'Extra Answers' sheet.
     * <p> It internally builds up the maps connecting report-answer-set ids to question ids
     * <p> and vice-versa
     * @param xtraAnsSetsSheet  --  The 'Extra Answers' Sheet
     * @param rprtId    -- the report id
     * @param rprtrId   -- the reporter id
     */
    public ExtraAnswerSetsSheetReaderImpl(Sheet xtraAnsSetsSheet, int rprtId, int rprtrId ) {
        this.extraAnsSetsSheet = xtraAnsSetsSheet;
        this.reportId = rprtId;
        this.reporterId = rprtrId;
        this.mp_col_qstn = new HashMap<Integer, QuestionDataSetInfo>();
        this.mp_qstn_col = new HashMap<QuestionDataSetInfo, Integer>();
        this.mp_internalqstnid_qstn = new HashMap<Integer, QuestionDataSetInfo>();
        this.mp_qstn_interalqstnid = new HashMap<QuestionDataSetInfo, Integer>();
        this.li_warnings = new ArrayList<String>();
        this.li_errors = new ArrayList<String>();
        this.mp_rasId_qstIds = buildRasIdQstIdsMap( this.reportId );
        this.mp_qstId_rasId = buildQstIdRasIdMap( this.mp_rasId_qstIds );
    }
    /** maps question id to its corresponding ras [ report-answerr-set] id **/
    private Map<Integer, Integer> mp_qstId_rasId = new HashMap<Integer, Integer>();
    
    /** maps ras-id to a list of corresponding question ids **/
    private Map<Integer, List<Integer>> mp_rasId_qstIds = new HashMap<Integer, List<Integer>>();
 
    /**
     * Retrieves a list of questions which enable the addition of report-answer-set-values.
     * 
     * @param extraQuestionAnswersSheet -- the sheet to read from 'Extra Answer'
     * @param reportId  -- the report id
     * @param mp_qstnId_rprtAnsSetValues    -- map connecting question id to its corresponding list of report-answer-set-values
     * @return theQuestions -- a List of QuestionDataSetInfo objects
     */
    public List<QuestionDataSetInfo> getExtraQuestions(Sheet extraQuestionAnswersSheet, int reportId, Map<Integer, List<ReportAnswerSetValuesDataSetInfo>> mp_qstnId_rprtAnsSetValues) {
        List<QuestionDataSetInfo> theQuestions = new ArrayList<QuestionDataSetInfo>();
        List<Integer> li_uniqeRasIds = new ArrayList<Integer>();
        
        int top_col = AnswersGridTemplateRangeConstants.RANGE_QUESTIONS_TOP_COL;
        int top_row = AnswersGridTemplateRangeConstants.RANGE_QUESTIONS_TOP_ROW + 4;
        
        Set<Integer> extraQstnIds = mp_qstnId_rprtAnsSetValues.keySet();

        for (Iterator<Integer> it = extraQstnIds.iterator(); it.hasNext(); ) {
            QuestionDataSetInfo theQuestionInfo = new QuestionDataSet();
            List<String> extraAnswerSetValues = new ArrayList<String>();
            
            int qstnId = it.next();
            
            int rasId = mp_qstId_rasId.get( qstnId );
            
            if ( li_uniqeRasIds.contains( rasId ) ) {          
                continue;
            }
            
            li_uniqeRasIds.add( rasId );
            
            String theQstnId = String.valueOf( qstnId );
            theQuestionInfo.setQst_id( qstnId );
            
            List<String> existingAnswerSetValues = getExistingAnswerSetValues( mp_qstnId_rprtAnsSetValues.get( qstnId ) );
            
            Cell qstnIdCell = extraQuestionAnswersSheet.findCell( theQstnId );
            int col = qstnIdCell.getColumn() + 1;
            int row = qstnIdCell.getRow();
                
            int numRepvalues = mp_qstnId_rprtAnsSetValues.get( qstnId ).size();
            
            numRepvalues += AnswersGridTemplateRangeConstants.NUM_EXTRA_ANSWERS;
            
            int startRow = top_row;    
            Cell ansCell = null;
            int i = 0;
            String ansVal = null;
            try {
                for (  ; i < numRepvalues; i++, startRow++ ) {
                    ansCell = extraQuestionAnswersSheet.getCell(col, startRow );
                    if ( ! ansCell.getType().equals( CellType.EMPTY ) ) {
                        ansVal = ansCell.getContents();
                        if ( !existingAnswerSetValues.contains(ansVal)  && !ansVal.equals("0") && !ansVal.equals("") ) {
                            extraAnswerSetValues.add( ansVal );
                        }
                    }
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                LOG.error("*****Error B4**** for qstnId " + qstnId + " anscell " + ansCell + " col " + col + " startTow " + startRow + " with ansVal " + ansVal); 
                LOG.error("ArrayIndexOutOfBoundsException in getextraQ ", e);                
                this.li_warnings.add("<br/><font color='red>Answer Set Values changed since last download -- please download the latest grid<p>");
                continue;
            }
            
            theQuestionInfo.setExtraAnswerSetValues( extraAnswerSetValues );
            
            theQuestions.add( theQuestionInfo );
        }
        
       return theQuestions;
    
    }
    
    /**
     * Sets up the list of answer-set-values and report-answer-set-values for addition / update
     * <p> into the database
     * 
     * @param li_extraQuestions --  the list of questions to which report-answer-set-values may be added
     * <p> generally this list is made with a call to getExtraQuestions()
     * @param mp_qstnId_ansSetValues -- the map connecting question ids to their corresponding answer-set-values AnswerSetValuesDataSetInfo
     * @param mp_qstnId_rprtAnsSetValues    -- the map connecting question ids to their corresponding report-answer-set-values ReportAnswerSetValuesDataSetInfo
     * @param platform  -- the service interfacing with the database and the application
     * @throws Exception -- if the data cannot be inserted / updated into the database for these tables
     * @see AnswerSetValuesDataSetInfo
     * @see ReportAnswerSetValuesDataSetInfo
     * @see PlatformAppModuleService
     */
    public void addExtraAnswerSetValues(List<QuestionDataSetInfo> li_extraQuestions, 
                                        Map<Integer, List<AnswerSetValuesDataSetInfo>>  mp_qstnId_ansSetValues, 
                                        Map<Integer, List<ReportAnswerSetValuesDataSetInfo>> mp_qstnId_rprtAnsSetValues, 
                                        PlatformAppModuleService platform) throws Exception { 
        if ( li_extraQuestions == null || li_extraQuestions.size() == 0 ) return;
        
        for( QuestionDataSetInfo qstn : li_extraQuestions ) {
            int qstnId = qstn.getQst_id();
            
            List<ReportAnswerSetValuesDataSetInfo> liExistingReportAnsSetVals = mp_qstnId_rprtAnsSetValues.get( qstnId );
            Map<Integer, ReportAnswerSetValuesDataSetInfo> mp_ravseqNum_ravInfo = new HashMap<Integer, ReportAnswerSetValuesDataSetInfo>();
            
            for ( ReportAnswerSetValuesDataSetInfo rav : liExistingReportAnsSetVals ) {
                mp_ravseqNum_ravInfo.put( rav.getRav_display_seq(), rav );
            }
            
            
            List<AnswerSetValuesDataSetInfo> liExistingAnsSetVals = mp_qstnId_ansSetValues.get( qstnId );
            Map<Integer, AnswerSetValuesDataSetInfo> mp_asvseqNum_ravInfo = new HashMap<Integer, AnswerSetValuesDataSetInfo>();
            
            for ( AnswerSetValuesDataSetInfo asv : liExistingAnsSetVals ) {
                mp_asvseqNum_ravInfo.put( asv.getAsv_display_seq(), asv );
            }
            
            
            List<String> extraAnsVals = qstn.getExtraAnswerSetValues();
            
            platform.addAnswerSetValues( qstnId, liExistingAnsSetVals, liExistingReportAnsSetVals, extraAnsVals );
            
        }
        
        
        try {
            platform.commitAll();
        } catch ( Exception e) {
            LOG.error("Error in updating ANSWER VALUES.", e);
            platform.rollbackAll();
            LOG.info("Error in updating ANSWER VALUES........... exiting!!!");
            throw new Exception ( "Error in updating ANSWER VALUES." );
        }
    }
    
    /**
     * Gets the list of existing answer values from a list of ReportAnswerSetValuesDataSetInfo objects 
     * @param reportAnswerSetValuesDataSetInfo  -- the list of ReportAnswerSetValuesDataSetInfo
     * @return existingAnswerValues -- a list of strings containing the answers gleaned from the list reportAnswerSetValuesDataSetInfo
     * @see ReportAnswerSetValuesDataSetInfo
     */
    private List<String> getExistingAnswerSetValues(List<ReportAnswerSetValuesDataSetInfo> reportAnswerSetValuesDataSetInfo) {
        List<String> existingAnswerValues = new ArrayList<String>(reportAnswerSetValuesDataSetInfo.size());
        for ( ReportAnswerSetValuesDataSetInfo r :  reportAnswerSetValuesDataSetInfo ) {
            String answer = r.getRav_answer().trim();
            existingAnswerValues.add( answer );
        }
        return existingAnswerValues;
        
    }

    public void setMp_col_qstn(Map<Integer, QuestionDataSetInfo> mp_col_qstn) {
        this.mp_col_qstn = mp_col_qstn;
    }

    public Map<Integer, QuestionDataSetInfo> getMp_col_qstn() {
        return mp_col_qstn;
    }

    public void setMp_qstn_col(Map<QuestionDataSetInfo, Integer> mp_qstn_col) {
        this.mp_qstn_col = mp_qstn_col;
    }

    public Map<QuestionDataSetInfo, Integer> getMp_qstn_col() {
        return mp_qstn_col;
    }

    public void setMp_internalqstnid_qstn(Map<Integer, QuestionDataSetInfo> mp_internalqstnid_qstn) {
        this.mp_internalqstnid_qstn = mp_internalqstnid_qstn;
    }

    public Map<Integer, QuestionDataSetInfo> getMp_internalqstnid_qstn() {
        return mp_internalqstnid_qstn;
    }

    public void setMp_qstn_interalqstnid(Map<QuestionDataSetInfo, Integer> mp_qstn_interalqstnid) {
        this.mp_qstn_interalqstnid = mp_qstn_interalqstnid;
    }

    public Map<QuestionDataSetInfo, Integer> getMp_qstn_interalqstnid() {
        return mp_qstn_interalqstnid;
    }

    public void setExtraAnsSetsSheet(Sheet extraAnsSetsSheet) {
        this.extraAnsSetsSheet = extraAnsSetsSheet;
    }

    public Sheet getExtraAnsSetsSheet() {
        return extraAnsSetsSheet;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReporterId(int reporterId) {
        this.reporterId = reporterId;
    }

    public int getReporterId() {
        return reporterId;
    }

    public void setLi_warnings(List<String> li_warnings) {
        this.li_warnings = li_warnings;
    }

    public List<String> getLi_warnings() {
        return li_warnings;
    }

    public void setLi_errors(List<String> li_errors) {
        this.li_errors = li_errors;
    }

    public List<String> getLi_errors() {
        return li_errors;
    }

    public void setLi_extraQuestions(List<QuestionDataSetInfo> li_extraQuestions) {
        this.li_extraQuestions = li_extraQuestions;
    }

    public List<QuestionDataSetInfo> getLi_extraQuestions() {
        return li_extraQuestions;
    }

    /**
     * returns a map connecting each report-answer-set to a list of potential question ids for a particular report
     * 
     * @param rprtId -- the report id
     * @return a map, via PlatformAppModuleServiceImpl, connecting report-answer-set ids to a list
     * of question ids
     * @see PlatformAppModuleServiceImpl
     */
    private Map<Integer, List<Integer>> buildRasIdQstIdsMap(int rprtId) {
        return PlatformAppModuleServiceImpl.getInstance().getRasIdQstIdsMap( rprtId );
    }

    public void setMp_rasId_qstIds(Map<Integer, List<Integer>> map) {
        this.mp_rasId_qstIds = map;
    }

    public Map<Integer, List<Integer>> getMp_rasId_qstIds() {
        return mp_rasId_qstIds;
    }


    /**
     * returns a 'reverse' map connecting a question id to its report-answer-set id
     * @param mpRasId_QstnIds
     * @return aMap -- the map connecting question-id to its corresponding report-answer-set id
     */
    private Map<Integer, Integer> buildQstIdRasIdMap(Map<Integer, List<Integer>> mpRasId_QstnIds ) {
        Map<Integer, Integer> aMap = new HashMap<Integer, Integer>();
        for (int rasId : mpRasId_QstnIds.keySet() ) {
            List<Integer> theQstnIds = mpRasId_QstnIds.get( rasId );
            for ( int aQstnId : theQstnIds ) {
                aMap.put( aQstnId, rasId );
            }
        }
        return aMap;
        
    }

    public void setMp_qstId_rasId(Map<Integer, Integer> amap) {
        this.mp_qstId_rasId = amap;
    }

    public Map<Integer, Integer> getMp_qstId_rasId() {
        return mp_qstId_rasId;
    }
}
