/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.sheets;

import com.bawaweb.grid.templates.data.ReportTemplateInfo;

import com.bawaweb.grid.templates.data.cursors.QuestionDataSetInfo;
import com.bawaweb.grid.templates.data.cursors.SourceAnswersDataSetInfo;

import com.bawaweb.grid.templates.data.tables.ReportAnswerSetValuesDataSetInfo;
import com.bawaweb.grid.templates.data.tables.SourceDataSetInfo;

import com.bawaweb.utils.Pair;

import java.io.File;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import java.util.Map;

import java.util.Set;

import jxl.Sheet;
import jxl.Workbook;

import jxl.write.WritableSheet;

public interface AnswersGridSheetReader {
    public void setWorkbook(Workbook workbook);
    public Workbook getWorkbook();
    public Workbook extractWorkbook(File aFile);
    public Sheet extractAnswersSheet(Workbook wbook);
    public Sheet get_answersSheet();
    public void setTheFile(File file);
    public int getReportId(Workbook wbook);
    public int getReporterId(Workbook wbook);
    public void setReportInfo(ReportTemplateInfo reportInfo);
    public List<Integer> extractTheReportSourceInfo(Sheet ansSheet, Map<Integer, SourceDataSetInfo> mp_internalsrcid_src);
    public List<String> extractTheQuestionsInfo(Sheet ansSheet);
    public ReportTemplateInfo buildExistingReportTemplate(int reportId, int reporterId) throws IOException;
    public List<Integer> getLi_RepSourceIds();
    public List<String> getLi_questionInfos();
    public Map<Integer, Integer> getMp_QuestionId_Col();
    public Map<String, Integer> getMp_QuestionTag_Col();
//    public Map<Integer, Integer> getMp_SourceIds_Rows();
    public Map<Integer, Integer> getMp_RepSourceIds_Rows();
    public Map<Integer, Integer> getMp_ExtraRepSourceIds_Rows();
    public int getStart_ans_col();
    public int getStart_ans_row();
    public int getEnd_ans_col();
    public int getEnd_ans_row();
    public Map<Integer, Integer> getMp_QuestionHint_Col();
    public Map<Integer, ArrayList<Integer>> getMp_Question_ColumnList();
    
    public List<SourceAnswersDataSetInfo> buildSourceAnswersList(Sheet sheet, 
                                                                LinkedHashMap<Integer, QuestionDataSetInfo> existingQstns, 
                                                                Map<Integer, Integer> mpRepSrcIdSrcId, 
                                                                Map<Integer, SourceDataSetInfo> mp_internalsrcid_src,
                                                                Map<Integer, Integer> mp_extraRepSrcIdSrcId,
                                                                Map<Integer, List<ReportAnswerSetValuesDataSetInfo>> mp_qstnId_rprtAnsSetValues);
                                                                
                                                                
    public boolean compareMapKeys(Map<String, String> a, Map<String, String> b);/*
    public boolean compareLists(List<String> a, List<String> b);    
    public boolean compareLists(List<Integer> a, List<Integer> b);*/
    public boolean compareLists(List<?> a, List<?>  b);
//    public boolean compareLists(List a, List b);
    public List<String> getLi_QuestionTags();
    public List<String> extractSourceNames(Sheet ansSheet, Map<Integer, Integer> mapOfSourceIdRows);    
    public void printList(List alist);
    public void printSet(Set aSet);
    public void printMap(Map aMap);
    public List<String> getLi_errors();
    public List<String> getLi_warnings();
    public List<SourceDataSetInfo> buildSourceInfo(Sheet sheet, //LinkedHashMap<Integer, SourceDataSetInfo> existingSrcs, 
                                                    Map<Integer, Integer> mpRepSrcIdSrcId, 
                                                    Map<String, Integer> existingRprtInit_RprtIdMap,
                                                    Map<Integer, Integer> mp_extraRepSrcIdSrcId,
                                                    Map<Integer, SourceDataSetInfo> mp_extraRpsIdSrcDataInfo
                                                    );

    public Sheet extractIntroSheet(Workbook w);
    public Sheet extractExtraQuestionAnswersSheet(Workbook w);
    public Sheet extractExtraSourcesSheet(Workbook wbook);

//    public Map<Integer, String> buildRepeatSourcesMap();

    public List<String> getAll_errors();

    public void flushErrors();
    
    
    public Sheet getExtraQstnAnswersSheet();
    public void setExtraQstnAnswersSheet(WritableSheet sheet);
    public Map<Integer, Integer> getMp_ExtraQuestionsAnswersId_Col();
    public void setMp_ExtraQuestionsAnswersId_Col(Map<Integer, Integer> map);
    
    public Sheet getExtraSourcesSheet();
    public void setExtraSourcesSheet(WritableSheet s);

    public Map<Pair, Integer> getQstIdQmqNum_QmqIdMap( LinkedHashMap<Integer, QuestionDataSetInfo> existingQstns );
}
