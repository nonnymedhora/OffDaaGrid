/**
 * @author Nonny Medhora
 */
package com.bawaweb.services;

import com.bawaweb.appmodule.PlatformAppModuleImpl;
import com.bawaweb.grid.templates.data.ReportTemplateInfo;
import com.bawaweb.grid.templates.data.cursors.EditorGeneralInfo;
import com.bawaweb.grid.templates.data.cursors.LeadReporterGeneralInfo;
import com.bawaweb.grid.templates.data.cursors.MultiQuestionDataSetInfo;
import com.bawaweb.grid.templates.data.cursors.QuestionDataSetInfo;
import com.bawaweb.grid.templates.data.cursors.ReportGeneralInfo;
import com.bawaweb.grid.templates.data.cursors.ReporterGeneralInfo;
import com.bawaweb.grid.templates.data.cursors.SourceAnswersDataSetInfo;
import com.bawaweb.grid.templates.data.tables.AnswerSetValuesDataSetInfo;
import com.bawaweb.grid.templates.data.tables.ReportAnswerSetValuesDataSetInfo;
import com.bawaweb.grid.templates.data.tables.SortingCriteriaValuesDataSetInfo;
import com.bawaweb.grid.templates.data.tables.SourceDataSetInfo;
import com.bawaweb.lifecycle.DBInstanceVO;
import com.bawaweb.lifecycle.EditorInfoVO;
import com.bawaweb.lifecycle.LeadReporterInfoVO;

import com.bawaweb.lifecycle.OtlTabLocksVO;
import com.bawaweb.lifecycle.SourcesAnswerInfoVO;

import com.bawaweb.lifecycle.model.OtlAnswerSetValuesVO;
import com.bawaweb.lifecycle.model.OtlReportAnswerSetValuesVO;
import com.bawaweb.lifecycle.model.ReportSourcesVO;
import com.bawaweb.views.DBInstanceImpl;

import com.bawaweb.views.model.common.ReportAnswerSetValues;

import java.util.LinkedHashMap;
import java.util.List;

import java.util.Map;

import java.util.Set;

import javax.jms.Connection;

import jxl.Workbook;

import oracle.jbo.client.Configuration;
import oracle.jbo.domain.Number;
import oracle.jbo.server.DBTransaction;

public interface PlatformAppModuleService {
    public static final String[] DATA_TALLY_OPTIONS = 
        new String[] { "", "Up", "Down", "No response", "Not applicable", 
                       "Don't know", "Other" };
                       
    public final static String PENDING_STATUS = "PENDING"; 
    public final static String IN_PROCESS_STATUS = "IN_PROCESS";
    public final static String POSTED_STATUS = "POSTED";
    public final static String REPOSTED_STATUS = "REPOSTED";
    public final static String STALE_STATUS = "STALE";
    

    public LinkedHashMap<Integer, QuestionDataSetInfo> getQuestions(Number rprtId);

    public LinkedHashMap<Integer, SourceDataSetInfo> getSources(Number rprtId, Number rprtrId, List<Integer> editorIds);

    public List<MultiQuestionDataSetInfo> getMultiQuestionInfo(Number qstId);

    public List<ReportAnswerSetValuesDataSetInfo> getSingleAnswers(Number qstId);

    public List<ReportAnswerSetValuesDataSetInfo> getMultiSingleAnswerSets(Number qstId);

    public List<SortingCriteriaValuesDataSetInfo> getSortInfo(Number rprtId, 
                                                              Number qstId);

    public LinkedHashMap<Integer, SourceAnswersDataSetInfo> getQuestionAnswersDataSet(QuestionDataSetInfo qnInfo, 
                                                                                      Number rprtid,
                                                                                      Set<Integer> rpsIds);

    public List<LeadReporterGeneralInfo> getLeadReporters(Number rprtId);
    public List<EditorGeneralInfo> getEditors(Number rprtId);
    public DBInstanceVO getDBInstance();

    public EditorInfoVO create(EditorInfoVO edInfo);
    public LeadReporterInfoVO create(LeadReporterInfoVO leadRepInfo);
    public OtlTabLocksVO create(OtlTabLocksVO lockInfo);
    public void create( SourcesAnswerInfoVO sanInfo, int reportId );//SourcesAnswerInfoVO
    public OtlAnswerSetValuesVO create(OtlAnswerSetValuesVO asvVo);
    public OtlReportAnswerSetValuesVO create(OtlReportAnswerSetValuesVO ravVo);
    public boolean update(OtlAnswerSetValuesVO asvVo);
    public boolean update(OtlReportAnswerSetValuesVO ravVo);
    public boolean update(EditorInfoVO edInfo, List changes);
    public boolean update(LeadReporterInfoVO leadRepInfo, List changes);
    
//    public boolean update(SourcesAnswerInfoVO sanInfo, List changes);
    public boolean update(SourcesAnswerInfoVO sanInfo, int reportId);
    public boolean delete(LeadReporterInfoVO edInfo);
    
    public boolean update(OtlTabLocksVO theLock);
    public Configuration getConfigurationInfo();
    public ReporterGeneralInfo getReporterInfo(Number rptrId);

    /** steps from answersgridcursorsimpl
     * public ReportTemplateInfo getReportInfo(int rprt_id, int reporter_id) {
     * ReportTemplateInfo reportTemplateInfo = new ReportTemplateInfoDataSet();
     * reportTemplateInfo.setReportId(rprt_id);
     * reportTemplateInfo.setReporterId(reporter_id);
     * //1
     * ReportGeneralInfo reportGeneralInfo = getReportGeneralInfo(reportTemplateInfo);
     * if ( reportGeneralInfo.getReportType().equals("81") || reportGeneralInfo.getReportType().equals("82") || reportGeneralInfo.getReportType().equals("85") || reportGeneralInfo.getReportType().equals("86") ) {
     * System.out.println("Error invalid report type " + reportGeneralInfo.getReportType());
     * System.exit(1);
     * }
     * 
     * reportTemplateInfo.setReportGeneralInfo(reportGeneralInfo);
     * //2
     * LinkedHashMap<Integer, SourceDataSetInfo> sourcesDataMap = getSourcesDataSet(rprt_id);//, reporter_id);
     * 
     * LinkedHashMap<Integer, QuestionDataSetInfo> questionsDataMap;
     * 
     * List<SourceDataSetInfo> listOfSources = new ArrayList<SourceDataSetInfo>();
     * List<QuestionDataSetInfo> listOfQuestions = new ArrayList<QuestionDataSetInfo>();
     * 
     * Set<Integer> sourceIds = sourcesDataMap.keySet();
     * List<Integer> srcRepIds = new ArrayList<Integer>();
     * 
     * String theSources = "(";                    // will build the query for using sra_rps_id instead of src_id
     * for ( Iterator<Integer> it = sourceIds.iterator(); it.hasNext(); ) {        
     * int src_id = it.next();
     * SourceDataSetInfo srcInfo = sourcesDataMap.get(src_id);
     * listOfSources.add(srcInfo);
     * int rps_id = srcInfo.getRps_id();
     * 
     * srcRepIds.add(rps_id);
     * 
     * 
     * if ( it.hasNext() ) 
     * theSources += rps_id + ", ";
     * else
     * theSources += rps_id + ")";
     * }
     * 
     * 
     * 
     * 
     * reportTemplateInfo.setListOfSources(listOfSources);
     * //3
     * questionsDataMap = getQuestionsDataSet(rprt_id);//, reporter_id);
     * Set<Integer> questionIds = questionsDataMap.keySet();
     * 
     * 
     * List<SourceAnswersDataSetInfo> srcAnsDataList = new ArrayList<SourceAnswersDataSetInfo>();
     * 
     * for ( Iterator<Integer> it = questionIds.iterator(); it.hasNext(); ) {        
     * int qst_id = it.next();
     * QuestionDataSetInfo qnInfo = questionsDataMap.get(qst_id);
     * 
     * LinkedHashMap<Integer, SourceAnswersDataSetInfo> questionAnswers = getQuestionAnswersDataSet(qnInfo, srcRepIds, rprt_id);//, srcAnsDataList);
     * qnInfo.setSourceAnswersDataSets(questionAnswers);
     * 
     * listOfQuestions.add(qnInfo);
     * 
     * }
     * 
     * reportTemplateInfo.setListOfQuestions(listOfQuestions);
     * 
     * reportTemplateInfo.setQuestionsDataSetMap(questionsDataMap);
     * reportTemplateInfo.setSourcesDataSetMap(sourcesDataMap);
     * 
     * for ( Iterator<Integer> it = questionIds.iterator(); it.hasNext(); ) {        
     * int qst_id = it.next();
     * QuestionDataSetInfo qnInfo = questionsDataMap.get(qst_id);
     * LinkedHashMap<Integer, SourceAnswersDataSetInfo> questionAnswers = qnInfo.getSourceAnswersDataSets();
     * srcAnsDataList.addAll(questionAnswers.values());
     * }
     * 
     * reportTemplateInfo.setListOfSourceAnswers(srcAnsDataList);
     * //    System.out.println("List of srcanswerssize is " + reportTemplateInfo.getListOfSourceAnswers().size());
     * return reportTemplateInfo;
     * }
     */
    public ReportTemplateInfo getReportInfo(int rprt_id, int reporter_id);

    public ReportGeneralInfo getReportGeneralInfo(final ReportTemplateInfo reportTemplateInfo);
    
    public boolean getRoleScope(int emplId);
    public DBTransaction getDBTransaction();
    public void commitAll();
    
    public void rollbackAll();

    public OtlTabLocksVO getLockInfo(int lockId, int reportId, int reporterId);
    
    public int getRavInfo(int rasId, String answer/*, String type*/);
    
     public int getSSCInfo(int qstId, String answer);
     
     public String capitalize(String s);

    public SourceAnswersDataSetInfo update(SourceAnswersDataSetInfo sad) throws Exception;

    public SourceAnswersDataSetInfo create(SourceAnswersDataSetInfo sad) throws Exception;

    public void updateRepeatSourceData(List<SourceDataSetInfo> sources, int reportId, int reporterId) throws Exception;
    
    public boolean isReportLocked(int rprtId);

    public void setCollectorName(String rptrId);

    public Number uploadAnswerGridErrorFile(Workbook w, int reportId, int reporterId);

    public void getErrorXLFile(int i);
    
    public boolean canAddAnswerSetsToQuestion(Number qstnId);
    
    public List<String> getSimilarSources(String fName, 
                                          String lName, 
                                          String city,
                                          int ctryId,
                                          String company,
                                          String phone);
                                          
    public int getBestSourceId(int[] sourceIds, int rprtId);
    
    public PlatformAppModuleImpl getPlatform();
    
    public List<String> getAllASVValues();

    public Map<Integer, List<ReportAnswerSetValuesDataSetInfo>> getExtraQuestionsReportAnswerSetValuesMap(int reportId);
    public Map<Integer, List<AnswerSetValuesDataSetInfo>> getExtraQuestionsAnswerSetValuesMap(int reportId);

//    public void addAnswerSetValues(int qstnId, 
//                                   List<ReportAnswerSetValuesDataSetInfo> liExistingReportAnsSetVals, 
//                                   int dontKnowSeqNum,
//                                   String ansVal);
                                   
    public boolean doesSourceAnswerExist(int qstId, int repSrcId);

//    public void addAnswerSetValues(int qstnId, 
//                                   List<AnswerSetValuesDataSetInfo> liExistingAnsSetVals, 
//                                   int dontKnowSeqNum, 
//                                   List<ReportAnswerSetValuesDataSetInfo> liExistingReportAnsSetVals, 
//                                   int repdontKnowSeqNum, 
//                                   List<String> extraAnsVals);

    public void addAnswerSetValues(int qstnId, 
                                   List<AnswerSetValuesDataSetInfo> liExistingAnsSetVals, 
                                   List<ReportAnswerSetValuesDataSetInfo> liExistingReportAnsSetVals, 
                                   List<String> extraAnsVals);

    //public SourceDataSetInfo createNewSource(SourceDataSetInfo s);
    public SourceDataSetInfo create(SourceDataSetInfo s);
    public ReportSourcesVO createNewReportSource(SourceDataSetInfo s);

    public Map<Integer, SourceDataSetInfo> addExtraSources(List<SourceDataSetInfo> newSources, 
                                List<SourceDataSetInfo> newReportSources, 
                                Map<Integer, SourceDataSetInfo> mp_internalId_src);
    public boolean checkSourceLocation( int srcId );

    public String getAnswerSetName(int ans_id);
    
    public Map<Integer, List<Integer>> getRasIdQstIdsMap(int rprtId);

    public boolean createMultiAnswerRecord(SourceAnswersDataSetInfo sad);

    public PlatformApplicationConfig getPlatformApplicationConfig();
}
