/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.sheets;

import com.bawaweb.grid.templates.data.cursors.QuestionDataSetInfo;

import com.bawaweb.grid.templates.data.tables.AnswerSetValuesDataSetInfo;
import com.bawaweb.grid.templates.data.tables.ReportAnswerSetValuesDataSetInfo;
import com.bawaweb.services.PlatformAppModuleService;

import java.util.List;
import java.util.Map;

import jxl.Sheet;

public interface ExtraAnswerSetsSheetReader {

    public void setMp_col_qstn(Map<Integer, QuestionDataSetInfo> mp_col_qstn);

    public Map<Integer, QuestionDataSetInfo> getMp_col_qstn();

    public void setMp_qstn_col(Map<QuestionDataSetInfo, Integer> mp_qstn_col);

    public Map<QuestionDataSetInfo, Integer> getMp_qstn_col();

    public void setMp_internalqstnid_qstn(Map<Integer, QuestionDataSetInfo> mp_internalqstnid_qstn);

    public Map<Integer, QuestionDataSetInfo> getMp_internalqstnid_qstn();

    public void setMp_qstn_interalqstnid(Map<QuestionDataSetInfo, Integer> mp_qstn_interalqstnid);

    public Map<QuestionDataSetInfo, Integer> getMp_qstn_interalqstnid();

    public void setExtraAnsSetsSheet(Sheet extraAnsSetsSheet);

    public Sheet getExtraAnsSetsSheet();

    List<QuestionDataSetInfo> getExtraQuestions(Sheet extraQuestionAnswersSheet, 
                                                int reportId, 
                                                Map<Integer, List<ReportAnswerSetValuesDataSetInfo>> mp_qstnId_rprtAnsSetValues);

    void addExtraAnswerSetValues(List<QuestionDataSetInfo> li_extraQuestions, 
                                 Map<Integer, List<AnswerSetValuesDataSetInfo>> mp_qstnId_ansSetValues, 
                                 Map<Integer, List<ReportAnswerSetValuesDataSetInfo>> mp_qstnId_rprtAnsSetValues, 
                                 PlatformAppModuleService platform) throws Exception;
                                 
                                 

        public void setLi_warnings(List<String> li_warnings);

        public List<String> getLi_warnings();

        public void setLi_errors(List<String> li_errors);

        public List<String> getLi_errors();

        public void setLi_extraQuestions(List<QuestionDataSetInfo> li_extraQuestions);

        public List<QuestionDataSetInfo> getLi_extraQuestions();                                 
}
