/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data;

import com.bawaweb.grid.templates.data.cursors.QuestionDataSetInfo;
import com.bawaweb.grid.templates.data.cursors.ReportGeneralInfo;
import com.bawaweb.grid.templates.data.cursors.SourceAnswersDataSet;
import com.bawaweb.grid.templates.data.cursors.SourceAnswersDataSetInfo;
import com.bawaweb.grid.templates.data.tables.SourceDataSetInfo;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import oracle.jbo.domain.Number;

public interface ReportTemplateInfo {

    public List getDataQuestions();

    public void setDataQuestions(List dataQuestions);

    public List<QuestionDataSetInfo> getListOfQuestions();

    public void setListOfQuestions(List<QuestionDataSetInfo> listOfQuestions);

    public List<SourceDataSetInfo> getListOfSources();

    public void setListOfSources(List<SourceDataSetInfo> listOfSources);

    public List<SourceDataSetInfo> getListOfAdditionalSources();

    public void setListOfAdditionalSources(List<SourceDataSetInfo> listOfSources);

    public List getMultiQuestions();

    public void setMultiQuestions(List multiQuestions);

    public List getRatingQuestions();

    public void setRatingQuestions(List ratingQuestions);

    public List getRequiredQuestions();

    public void setRequiredQuestions(List requiredQuestions);

    public List getSingleQuestions();

    public void setSingleQuestions(List singleQuestions);

    public List getSortQuestions();

    public void setSortQuestions(List sortQuestions);

    public List getTextQuestions();

    public void setTextQuestions(List textQuestions);

    public List getWeightedQuestions();

    public void setWeightedQuestions(List weightedQuestions);

    public List getReportSortingCriterias();

    public void setReportSortingCriterias(List reportSortingCriterias);

    public void setListOfSourceAnswers(List<SourceAnswersDataSetInfo> listOfSourceAnswers);

    public List<SourceAnswersDataSetInfo> getListOfSourceAnswers();

    public void setListOfAdditionalSourceAnswers(List<SourceAnswersDataSetInfo> listOfSourceAnswers);

    public List<SourceAnswersDataSetInfo> getListOfAdditionalSourceAnswers();

    public void setQuestionsDataSetMap(LinkedHashMap<Integer, QuestionDataSetInfo> questionsDataMap);
    
    public LinkedHashMap<Integer, QuestionDataSetInfo> getQuestionsDataSetMap();

    public void setSourcesDataSetMap(LinkedHashMap<Integer, SourceDataSetInfo> sourcesDataMap);
    
    public LinkedHashMap<Integer, SourceDataSetInfo> getSourcesDataSetMap();

    public ReportGeneralInfo getReportGeneralInfo();
    
    public void setReportGeneralInfo(ReportGeneralInfo info);    
    
    public int getReportId();
    public void setReportId(int id);

    public int getReporterId();
    public void setReporterId(int reporter_id);
    
    public void setLi_questionTags(List<String> tags);    
    public List<String> getLi_questionTags();
    
    public List<String> buildQuestionTags();
    public Map<String, String> buildQuestionTypeMap();
    
    public List<Integer> getLi_sourceIds();
    public List<Integer> getLi_questionIds();
    public List<String> getLi_SourceNames();
    public List<Integer> getLi_RepSourceIds();
    
    public Map<Integer, Integer> getMap_RepSrcId_SrcId();
    public Map<String, Integer> buildRprtrInit_RprtrIdMap();
    /*
    public Set<Integer> getOfSourceSortingCriteriaLocks();                  // for table bawaweb_source_sorting_criteria
    public void setSetOfSourceSortingCriteriaLocks(Set<Integer> theSet);    
    
    public Set<Integer> getSetOfSortingCriteriaValueLocks();                // for table bawaweb_sorting_criteria_values
    public void setSetOfSortingCriteriaValueLocks(Set<Integer> theSet);
    
    public Set<Integer> getSetOfReportAnswerSetValuesLocks();               // for table bawaweb_report_answer_set_values
    public void setSetOfReportAnswerSetValuesLocks(Set<Integer> theList); 
    
    public Set<Integer> getSetOfSourceAnswersLocks();                       // for table bawaweb_source_answers
    public void setSetOfSourceAnswersLocks(Set<Integer> theList);
    
    public Set<Integer> buildReportAnswerSetValuesLocks();                  // for table bawaweb_report_answer_set_values
    public Set<Integer> buildSourceAnswersLocks();                          // for table bawaweb_source_answers
     public Set<Integer> buildSourceSortingCriteriaLocks();           // for table bawaweb_source_sorting_criteria
     public Set<Integer>  buildSortingCriteriaValuesLocks();                // for table bawaweb_sorting_criteria_values
     */
     
     

          
      //    ssc_rps_id ( and ssc_scv_id?)     BAwaWEb_SOURCE_SORTING_CRITERIA

          public Set<Integer> getSetOfSourceSortingCriteriaLocks();
          public void setSetOfSourceSortingCriteriaLocks(Set<Integer> theSet);

      //    scv_id            BAwaWEb_SORTING_CRITERIA_VALUES
          public Set<Integer> getSetOfSortingCriteriaValueLocks();
          public void setSetOfSortingCriteriaValueLocks(Set<Integer> theSet) ;

      //    rav_id          BAwaWEb_REPORT_ANSWER_SET_VALUES     
          public Set<Integer> getSetOfReportAnswerSetValuesLocks();
          public void setSetOfReportAnswerSetValuesLocks(Set<Integer> theSet);
          
      //    sra_id          BAwaWEb_SOURCE_ANSWERS
          public Set<Integer> getSetOfSourceAnswersLocks();
          public void setSetOfSourceAnswersLocks(Set<Integer> theSet);
          
      //    sma_sra_id      BAwaWEb_SOURCE_MULTI_ANSWERS
          public Set<Integer> getSetOfSourceMultiAnswersLocks();
          public void setSetOfSourceMultiAnswersLocks(Set<Integer> theSet);

      //    qmq_qst_id      BAwaWEb_QUESTIONS
          public Set<Integer> getSetOfQuestionsLocks();
          public void setSetOfQuestionsLocks(Set<Integer> theSet);
          
      //    qmq_id          BAwaWEb_MULTI_QUESTIONS
          public Set<Integer> getSetOfMultiQuestionsLocks();
          public void setSetOfMultiQuestionsLocks(Set<Integer> theSet);
    
    //public Set<Integer> buildSourceSortingCriteriaValuesLocks();
    
     public void buildLocks();
     
    public void setMp_QstId_RASId(Map<Integer, Integer> mp_);
    public Map<Integer, Integer> getMp_QstId_RASId();
    public Map<Integer, Integer> buildMp_QstId_RASIdMap();
    
    public  List<QuestionDataSetInfo> getListOfQuestionsForAdditionalAnswers();
    public void setListOfQuestionsForAdditionalAnswers( List<QuestionDataSetInfo> qstns); 
    
    
    public void setSourceDisplayNameStyle(String style);
    public String getSourceDisplayNameStyle();
    
    public List<String> getCourtesyTitles();
    public void setCourtesyTitles(List<String> alist);


    
    public List<String> getSuffixTitles();
    public void setSuffixTitles(List<String> alist);

    public Map<String, Integer>  getCountriesMap();
    public void setCountriesMap(Map<String, Integer> map);


    public void setTimeZonesMap(LinkedHashMap<String, Integer> aMap);
    public LinkedHashMap<String, Integer> getTimeZonesMap();

    public void setIndustryViewsMap(LinkedHashMap<String, String> aMap);
    public LinkedHashMap<String, String> getIndustryViewsMap();
    

    public void setQualityRatingsMap(LinkedHashMap<String, String> aMap);
    public LinkedHashMap<String, String> getQualityRatingsMap();

    public void setSourceDistributionPreferencesMap(LinkedHashMap<String, String> aMap);
    public LinkedHashMap<String, String> getSourceDistributionPreferencesMap();
}
