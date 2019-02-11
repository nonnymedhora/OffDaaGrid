/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates;

import com.bawaweb.grid.templates.data.ReportTemplateInfo;

import com.bawaweb.grid.templates.sheets.ExtraSourcesSheet;
import com.bawaweb.grid.templates.sheets.QuestionAnswerSetsDataSheet;

import java.util.Locale;
import java.util.Map;

import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public interface AnswersGridTempInfo {
        
        public WritableSheet createAnswerGridDataSheet(WritableWorkbook ansBook, ExtraSourcesSheet xtraSrcsSheet, QuestionAnswerSetsDataSheet xtraQnsAnsSheet);	
	public WritableSheet createIntroDataSheet(WritableWorkbook w);
	public WritableSheet createCalcsDataSheet();	
	public WritableSheet createSummaryDataSheet();
	public ExtraSourcesSheet createExtraSourcesDataSheet(WritableWorkbook w);
	public WritableSheet createSourceDetailsDataSheet(WritableWorkbook w);
	public WritableSheet createCountriesDataSheet(WritableWorkbook w);
	public ReportTemplateInfo getRis();
	public WritableWorkbook getAnswersGridWorkbook();
	public void setAnswersGridWorkbook(WritableWorkbook answersGridWorkbook);
	public void setReportTemplateInfoDataSet(ReportTemplateInfo r);
	public Map getMap();
	public void end();
	public void initializeSheets(WritableWorkbook w);

        public void generateAnswersGridWorkBook(WritableWorkbook ansGridWorkbook);

        public void addOtlLock(int otlId);

        public QuestionAnswerSetsDataSheet createExtraQuestionAnsDataSheet(WritableWorkbook ansGridWorkbook);
}
