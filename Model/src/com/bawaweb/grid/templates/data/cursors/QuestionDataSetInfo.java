/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.cursors;

import com.bawaweb.grid.templates.data.tables.AnswerSetValuesDataSetInfo;

import com.bawaweb.grid.templates.data.tables.AnswerSetsDataSetInfo;
import com.bawaweb.grid.templates.data.tables.ReportAnswerSetValuesDataSetInfo;
import com.bawaweb.grid.templates.data.tables.SortingCriteriaValuesDataSetInfo;

import com.bawaweb.grid.templates.data.tables.TallyRangeLimitsValuesDataSetInfo;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface QuestionDataSetInfo {
	
	// maps to CURSOR cur_qst(p_rprt_id rprt_reports.rprt_id%TYPE) IS
    // in ota-excel answers_grid
    
     public int getNum_cols();
     public void setNum_cols(int num_cols);
     public String getOrder_by();
     public void setOrder_by(String order_by);
     public String getQst_alpha();
     public void setQst_alpha(String qst_alpha);
     public int getQst_id();
     public void setQst_id(int qst_id);
     public int getQst_multi_answers();
     public void setQst_multi_answers(int qst_multi_answers);
//     public String getQst_number();
//     public void setQst_number(String qst_number);
     public int getQst_numeric();
     public void setQst_numeric(int qst_numeric);
     public String getQst_question();
     public void setQst_question(String qst_question);
     public String getQst_question_hint();
     public void setQst_question_hint(String qst_question_hint);
     public String getQst_text_required_yn();
     public void setQst_text_required_yn(String qst_text_required_yn);
     public int getQst_ras_id();
     public void setQst_ras_id(int qst_ras_id);
     public String getQst_text_hint();
     public void setQst_text_hint(String qst_text_hint);
     public int getQst_tly_id();
     public void setQst_tly_id(int qst_tly_id);
     public String getQst_type();
     public void setQst_type(String qst_type);
     public int getRas_frid_id();
     public void setRas_frid_id(int ras_frid_id);
     public String toString();
     
//     public MultiQuestionDataSetInfo getQmqDataSet();
//     public void setQmqDataSet(MultiQuestionDataSetInfo qmqDataSet);
     
     public List<MultiQuestionDataSetInfo> getMultiQuestionInfo();
     public void setMultiQuestionDataSetInfo(List<MultiQuestionDataSetInfo> info);
     
     public void setSourceAnswersDataSets(LinkedHashMap<Integer, SourceAnswersDataSetInfo> _sourceAnswersDataSets);
     public LinkedHashMap<Integer, SourceAnswersDataSetInfo> getSourceAnswersDataSets();
     
    public List<ReportAnswerSetValuesDataSetInfo> getSingleAnswerSetsInfo();    
    public void setSingleAnswerSetsInfo (List<ReportAnswerSetValuesDataSetInfo> info);
    
    
    public AnswerSetsDataSetInfo getAnswerSetInfo();
    public void setAnswerSetInfo(AnswerSetsDataSetInfo info);

//     
//    public List<AnswerSetValuesDataSetInfo> getAnswerSetsInfo();    
//    public void setAnswerSetsInfo (List<AnswerSetValuesDataSetInfo> info);
    
    public List<SortingCriteriaValuesDataSetInfo> getSortCriteriaDataSetInfo();
    public void setSortCriteriaDataSetInfo(List<SortingCriteriaValuesDataSetInfo> sortCriteriaDataSetInfo);
    
    
    public List<TallyRangeLimitsValuesDataSetInfo> getTallyRangeLimitsValuesDataSetInfo();
    public void setTallyRangeLimitsValuesDataSetInfo(List<TallyRangeLimitsValuesDataSetInfo> TallyRangeLimitsValuesDataSetInfo);
    

    public void setDataTallyOptions(String[] dataTallyOptions);
    public String[] getDataTallyOptions();
    
    public int getQst_ans_id();
    public void setQst_ans_id( int i);
    
    public void setMpQmqNo_QmqType(Map<String, String> aMap);
    public Map<String, String> getMpQmqNo_QmqType();
    
    public List<String> getExtraAnswerSetValues();
    public void setExtraAnswerSetValues(List<String> val);

}