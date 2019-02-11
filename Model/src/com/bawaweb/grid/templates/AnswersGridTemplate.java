/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates;

/**
 * Used for creating or reading in Excel workbook 
 */
import com.bawaweb.grid.templates.AnswersGridTempInfo;
import com.bawaweb.grid.templates.AnswersGridTemplateRangeConstants;
import com.bawaweb.grid.templates.sheets.AnswersGridSheet;

import com.bawaweb.grid.templates.sheets.CountriesSheet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;



import com.bawaweb.grid.templates.data.ReportTemplateInfo;
import com.bawaweb.grid.templates.data.cursors.MultiQuestionDataSetInfo;
import com.bawaweb.grid.templates.data.cursors.SourceAnswersDataSetInfo;
import com.bawaweb.grid.templates.data.cursors.QuestionDataSetInfo;

import com.bawaweb.grid.templates.data.tables.SourceDataSetInfo;
import com.bawaweb.grid.templates.sheets.ExtraSourcesSheet;
import com.bawaweb.grid.templates.sheets.IntroSheet;
import com.bawaweb.grid.templates.sheets.QuestionAnswerSetsDataSheet;
import com.bawaweb.grid.templates.sheets.SourceDetailsSheet;
import com.bawaweb.utils.SourcesComparator;
import java.util.LinkedHashMap;
import java.util.Set;

import jxl.NumberCell;

import jxl.format.Colour;
import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;

import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFeatures;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableHyperlink;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class AnswersGridTemplate implements AnswersGridTempInfo {
    public static int formats = 0;
    private File answersGridTempFile;

    private WritableWorkbook answersGridWorkbook;
    
    private ReportTemplateInfo reportTemplateInfoDataSet;
    
    private int getNumQuestions() {
            return getRis().getListOfQuestions().size();
    }
    
    private int getNumSources() {
            return getRis().getListOfSources().size();
    }
    
    private static Map<String, WritableSheet> sheetMap = new HashMap<String, WritableSheet>();
    
    public Map<String, WritableSheet> getMap() {
            return sheetMap;
    }
    public static Map<String, WritableSheet> getSheetMap() {
            return sheetMap;
    }

    public static void setSheetMap(Map<String, WritableSheet> sheetMap) {
            AnswersGridTemplate.sheetMap = sheetMap;
    }
    
    private Locale preferredLocale;

    // called by local app    
    public AnswersGridTemplate(Locale theLoc) {		
            try {
            this.answersGridTempFile = 
                    new File("\\\\san-filer1\\nmedhora$\\my documents\\jxlTesting\\test123_" + 
                             System.currentTimeMillis() + ".xls");  
            this.setPreferredLocale( theLoc );
            
            WorkbookSettings wbSettings = getWbSettings( theLoc );
            this.answersGridWorkbook = 
                    Workbook.createWorkbook(new FileOutputStream(this.answersGridTempFile), wbSettings );
                    
            this.setAnswersGridWorkbook( this.answersGridWorkbook );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // called by servlet
    public AnswersGridTemplate(String filePath, Locale theLoc) {
        try {
            String basePath = "/WEB-INF/fridFiles/";
            answersGridTempFile = new File(basePath+filePath);
            this.setPreferredLocale( theLoc );
            WorkbookSettings wbSettings = getWbSettings( theLoc );
            
//            answersGridWorkbook = 
//                    Workbook.createWorkbook(new FileOutputStream(answersGridTempFile));
//            this.setPreferredLocale( theLoc );
        } catch (Exception e) {
            e.printStackTrace();
        }	
    }
    
    public void addOtlLock(int otlId) {
        WritableSheet introSheet = sheetMap.get(AnswersGridTemplateRangeConstants.INTRO_SHEET_NAME);
        try {
            Label lockCell = new Label(0, 65500, String.valueOf(otlId));
            WritableCellFormat lockFormat = null;
            try {
                WritableFont blackFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD);       
                blackFont.setColour(AnswersGridTemplateRangeConstants.BLACK_COLOR);
                lockFormat = new WritableCellFormat(blackFont);
                lockFormat.setBackground(AnswersGridTemplateRangeConstants.RED_COLOR);
                lockFormat.setBorder(Border.TOP, BorderLineStyle.THIN);
                lockFormat.setBorder(Border.BOTTOM, BorderLineStyle.THIN);
                lockFormat.setBorder(Border.RIGHT, BorderLineStyle.THIN);
                lockFormat.setWrap(true);
                lockFormat.setAlignment(Alignment.CENTRE);
                lockFormat.setVerticalAlignment(VerticalAlignment.TOP);       //JUSTIFY);
                lockFormat.setLocked(true);
                lockFormat.setShrinkToFit(true);
            } catch (WriteException we) {}
            
            lockCell.setCellFormat( lockFormat );
            
            WritableCellFeatures addedAnsTextfeatures = new WritableCellFeatures();
            addedAnsTextfeatures.setComment("PLEASE DO NOT DELETE OR MODIFY THIS CELL");
            lockCell.setCellFeatures(addedAnsTextfeatures);
            
            
            introSheet.addCell( lockCell );
        } catch (WriteException e) {
            e.printStackTrace();
        }
    }
    
    public void end() {
    if ( this.answersGridWorkbook == null ) 
    System.out.println("answersgridworkbook is null");
            try {
                this.answersGridWorkbook.write();
                this.answersGridWorkbook.close();
            } catch (WriteException e) {
                    e.printStackTrace();
            } catch (IOException e) {
                    e.printStackTrace();
            }
    }
    
    public void generateAnswersGridWorkBook(WritableWorkbook ansGridWorkbook) {
        this.initializeSheets( ansGridWorkbook );
                    
        this.createIntroDataSheet( ansGridWorkbook );
        this.createSourceDetailsDataSheet( ansGridWorkbook );
        
        /********* rem for v1, put back in for v2 ******************/
        
        ExtraSourcesSheet xtraSrcsSheet = this.createExtraSourcesDataSheet( ansGridWorkbook );
        QuestionAnswerSetsDataSheet xtraQnsAnsSetsSheet = null;
        if ( this.reportTemplateInfoDataSet.getListOfQuestionsForAdditionalAnswers().size() > 0 ) { 
            xtraQnsAnsSetsSheet =  this.createExtraQuestionAnsDataSheet( ansGridWorkbook );
        }   
        
        /********* ends rem for v1, put back in for v2 ******************/
        this.createAnswerGridDataSheet(ansGridWorkbook, xtraSrcsSheet, xtraQnsAnsSetsSheet);
        
        this.createSummaryDataSheet();
        
        
        
        this.end();
    }
    
    
    public WritableSheet createIntroDataSheet(WritableWorkbook  w) {
        return new IntroSheet( sheetMap.get(AnswersGridTemplateRangeConstants.INTRO_SHEET_NAME), reportTemplateInfoDataSet).createIntroDataSheet();
    }
    
    public WritableSheet createCalcsDataSheet() {
        return sheetMap.get(AnswersGridTemplateRangeConstants.REPORT_CALCS_SHEET_NAME);
    }
    
    public WritableSheet createSummaryDataSheet() {
        return sheetMap.get(AnswersGridTemplateRangeConstants.REPORT_SUMMARY_SHEET_NAME);
    }
    
    public ExtraSourcesSheet createExtraSourcesDataSheet(WritableWorkbook w) {
    
            WritableSheet s = sheetMap.get(AnswersGridTemplateRangeConstants.EXTRA_SOURCES_SHEET_NAME);
            
            w.addNameArea(AnswersGridTemplateRangeConstants.RANGE_NAME_NUM_EXTRA_SOURCES, 
                            s, 
                            AnswersGridTemplateRangeConstants.RANGE_NUM_EXTRA_SOURCES_TOP_COL, 
                            AnswersGridTemplateRangeConstants.RANGE_NUM_EXTRA_SOURCES_TOP_ROW, 
                            AnswersGridTemplateRangeConstants.RANGE_NUM_EXTRA_SOURCES_BOT_COL, 
                            AnswersGridTemplateRangeConstants.RANGE_NUM_EXTRA_SOURCES_BOT_ROW);
            
            w.addNameArea(AnswersGridTemplateRangeConstants.RANGE_NAME_EXTRA_SOURCEFIELDS,
                            s, 
                            AnswersGridTemplateRangeConstants.RANGE_EXTRA_SOURCEFIELDS_TOP_COL, 
                            AnswersGridTemplateRangeConstants.RANGE_EXTRA_SOURCEFIELDS_TOP_ROW, 
                            AnswersGridTemplateRangeConstants.RANGE_EXTRA_SOURCEFIELDS_BOT_COL, 
                            AnswersGridTemplateRangeConstants.RANGE_EXTRA_SOURCEFIELDS_BOT_ROW);
            
            w.addNameArea(AnswersGridTemplateRangeConstants.RANGE_NAME_START_EXTRA_SOURCES, 
                            s, 
                            AnswersGridTemplateRangeConstants.RANGE_START_EXTRA_SOURCES_TOP_COL, 
                            AnswersGridTemplateRangeConstants.RANGE_START_EXTRA_SOURCES_TOP_ROW, 
                            AnswersGridTemplateRangeConstants.RANGE_START_EXTRA_SOURCES_BOT_COL, 
                            AnswersGridTemplateRangeConstants.RANGE_START_EXTRA_SOURCES_BOT_ROW);
            ExtraSourcesSheet xtraSourcesSheet = new ExtraSourcesSheet(s, reportTemplateInfoDataSet);                           
            xtraSourcesSheet.createExtraSourcesSheet();
            
            return xtraSourcesSheet;

    }
    
    public WritableSheet createSourceDetailsDataSheet(WritableWorkbook w) {
            WritableSheet s = sheetMap.get(AnswersGridTemplateRangeConstants.SOURCE_DETAILS_SHEET_NAME);
            
            
            w.addNameArea(AnswersGridTemplateRangeConstants.RANGE_NAME_EXTRA_SOURCEDETAILS,
                            s, 
                            AnswersGridTemplateRangeConstants.RANGE_EXTRA_SOURCEFIELDS_TOP_COL, 
                            AnswersGridTemplateRangeConstants.RANGE_EXTRA_SOURCEFIELDS_TOP_ROW, 
                            AnswersGridTemplateRangeConstants.RANGE_EXTRA_SOURCEFIELDS_BOT_COL, 
                            AnswersGridTemplateRangeConstants.RANGE_EXTRA_SOURCEFIELDS_BOT_ROW);
                            
            return new SourceDetailsSheet(s, reportTemplateInfoDataSet).createSourceDetailsSheet();
    }
    
    


    public QuestionAnswerSetsDataSheet createExtraQuestionAnsDataSheet(WritableWorkbook ansGridWorkbook) {
        WritableSheet s = sheetMap.get(AnswersGridTemplateRangeConstants.EXTRA_QUESTION_ANS_SHEET_NAME);
        QuestionAnswerSetsDataSheet xtraQnsAnsSetsSheet = new QuestionAnswerSetsDataSheet(s, reportTemplateInfoDataSet);
        xtraQnsAnsSetsSheet.createExtraQuestionAnswerSetsDataSheet();
        return xtraQnsAnsSetsSheet;
    }
    

    public WritableSheet createCountriesDataSheet(WritableWorkbook w) {
        WritableSheet s = sheetMap.get(AnswersGridTemplateRangeConstants.COUNTRIES_SHEET_NAME);
        
        w.addNameArea(AnswersGridTemplateRangeConstants.RANGE_NAME_COUNTRIES, 
                        s, 
                        AnswersGridTemplateRangeConstants.RANGE_START_COUNTRIES_TOP_COL, 
                        AnswersGridTemplateRangeConstants.RANGE_START_COUNTRIES_TOP_ROW, 
                        AnswersGridTemplateRangeConstants.RANGE_START_COUNTRIES_BOT_COL, 
                        AnswersGridTemplateRangeConstants.RANGE_START_COUNTRIES_TOP_ROW + reportTemplateInfoDataSet.getCountriesMap().size() - 1);
        
        
        w.addNameArea(AnswersGridTemplateRangeConstants.RANGE_NAME_TIMEZONES, 
                        s, 
                        AnswersGridTemplateRangeConstants.RANGE_START_TIMEZONES_TOP_COL, 
                        AnswersGridTemplateRangeConstants.RANGE_START_TIMEZONES_TOP_ROW, 
                        AnswersGridTemplateRangeConstants.RANGE_START_TIMEZONES_TOP_COL, 
                        AnswersGridTemplateRangeConstants.RANGE_START_TIMEZONES_TOP_ROW + reportTemplateInfoDataSet.getTimeZonesMap().size() - 1);
        
        
        return new CountriesSheet( sheetMap.get(AnswersGridTemplateRangeConstants.COUNTRIES_SHEET_NAME), reportTemplateInfoDataSet).createCountriesSheet();
    }
    
    
//    
//    private WritableCellFormat boldRedInYellow() throws WriteException {
//            WritableFont boldRedFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD); 	
//            boldRedFont.setColour(AnswersGridTemplateRangeConstants.RED_COLOR);
//            WritableCellFormat boldRed = new WritableCellFormat(boldRedFont);
//            boldRed.setBackground(AnswersGridTemplateRangeConstants.YELLOW_COLOR);
//            boldRed.setLocked(false);
//            return boldRed;
//    }
//    
//    private WritableCellFormat srcInfoDataCellFormat() throws WriteException {
//            WritableFont boldBlackFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD); 	
//            boldBlackFont.setColour(AnswersGridTemplateRangeConstants.BLACK_COLOR);
//            WritableCellFormat boldBlack = new WritableCellFormat(boldBlackFont);
//            boldBlack.setBackground(AnswersGridTemplateRangeConstants.WHITE_COLOR);
//            boldBlack.setWrap(true);
//            boldBlack.setAlignment(Alignment.LEFT);
//            boldBlack.setVerticalAlignment(VerticalAlignment.CENTRE);	//JUSTIFY);
//            boldBlack.setLocked(true);
//            boldBlack.setShrinkToFit(true);
//            return boldBlack;
//    }
//
//
//    
//    private WritableCellFormat repSrcInfoDataCellFormat() throws WriteException {
//        WritableFont redFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD);       
//        redFont.setColour(AnswersGridTemplateRangeConstants.REPEAT_COLOR);
//        WritableCellFormat justRed = new WritableCellFormat(redFont);
//        justRed.setWrap(true);
//        justRed.setAlignment(Alignment.LEFT);
//        justRed.setVerticalAlignment(VerticalAlignment.CENTRE);       //JUSTIFY);
//        justRed.setLocked(true);
//        justRed.setShrinkToFit(true);
//        return justRed;
//    }
//    
//    private WritableCellFormat wrapNormalAnswerFormat() throws WriteException {
//        WritableFont normalFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD);
//        WritableCellFormat wrapNormalAnswerFormat = new WritableCellFormat(normalFont);        
//        wrapNormalAnswerFormat.setWrap(true);
//        wrapNormalAnswerFormat.setAlignment(Alignment.CENTRE);
//        wrapNormalAnswerFormat.setVerticalAlignment(VerticalAlignment.TOP);
//        return wrapNormalAnswerFormat;
//    }
//	
//    private WritableCellFormat qstnInfoDataCellFormat() throws WriteException {
//        WritableFont boldBlackFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);       
//        boldBlackFont.setColour(AnswersGridTemplateRangeConstants.BLACK_COLOR);
//        WritableCellFormat boldBlack = new WritableCellFormat(boldBlackFont);
//        boldBlack.setBackground(AnswersGridTemplateRangeConstants.QSTNS_COLOR);
//        boldBlack.setWrap(true);
//        boldBlack.setAlignment(Alignment.LEFT);
//        boldBlack.setVerticalAlignment(VerticalAlignment.CENTRE);       //JUSTIFY);
//        boldBlack.setLocked(true);
//        boldBlack.setShrinkToFit(true);
//        return boldBlack;
//    }
//    
//    private WritableCellFormat wghtdQstnInfoDataCellFormat() throws WriteException {
//        WritableFont boldBlackFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);       
//        boldBlackFont.setColour(AnswersGridTemplateRangeConstants.BLACK_COLOR);
//        WritableCellFormat boldBlack = new WritableCellFormat(boldBlackFont);
//        boldBlack.setBackground(AnswersGridTemplateRangeConstants.WGHTD_COLOR);
//        boldBlack.setWrap(true);
//        boldBlack.setAlignment(Alignment.CENTRE);
//        boldBlack.setVerticalAlignment(VerticalAlignment.TOP);       //JUSTIFY);
//        boldBlack.setLocked(true);
//        boldBlack.setShrinkToFit(true);
//        return boldBlack;
//    }
//    
//    private WritableCellFormat sortedQstnInfoDataCellFormat() throws WriteException {
//        WritableFont boldBlackFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);       
//        boldBlackFont.setColour(AnswersGridTemplateRangeConstants.BLACK_COLOR);
//        WritableCellFormat boldBlack = new WritableCellFormat(boldBlackFont);
//        boldBlack.setBackground(AnswersGridTemplateRangeConstants.SORT_COLOR);
//        boldBlack.setWrap(true);
//        boldBlack.setAlignment(Alignment.CENTRE);
//        boldBlack.setVerticalAlignment(VerticalAlignment.TOP);       //JUSTIFY);
//        boldBlack.setLocked(true);
//        boldBlack.setShrinkToFit(true);
//        return boldBlack;
//    }
//    
//    private WritableCellFormat multiQstnInfoDataCellFormat() throws WriteException {
//        WritableFont boldBlackFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);       
//        boldBlackFont.setColour(AnswersGridTemplateRangeConstants.BLACK_COLOR);
//        WritableCellFormat boldBlack = new WritableCellFormat(boldBlackFont);
//        boldBlack.setBackground(AnswersGridTemplateRangeConstants.MULTI_COLOR);
//        boldBlack.setWrap(true);
//        boldBlack.setAlignment(Alignment.CENTRE);
//        boldBlack.setVerticalAlignment(VerticalAlignment.TOP);       //JUSTIFY);
//        boldBlack.setLocked(true);
//        boldBlack.setShrinkToFit(true);
//        return boldBlack;
//    }
//    
//    private WritableCellFormat boldBlueInWhite() throws WriteException {
//        WritableFont boldRedFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD); 	
//        boldRedFont.setColour(AnswersGridTemplateRangeConstants.BLUE_COLOR);
//        WritableCellFormat boldRed = new WritableCellFormat(boldRedFont);
//        boldRed.setBackground(AnswersGridTemplateRangeConstants.WHITE_COLOR);
//        boldRed.setLocked(false);
//        return boldRed;
//    }
//        
    public WritableSheet createAnswerGridDataSheet(WritableWorkbook ansBook, ExtraSourcesSheet xtraSrcsSheet, QuestionAnswerSetsDataSheet xtraQnsAnsSheet) {
            WritableWorkbook  w = ansBook;
            WritableSheet s = sheetMap.get(AnswersGridTemplateRangeConstants.ANSWERS_GRID_SHEET_NAME);
            /*
            // first setup the named ranges
            w.addNameArea("Questions", 
                                            s, 
                                            AnswersGridTemplateRangeConstants.RANGE_QUESTIONS_TOP_COL, 
                                            AnswersGridTemplateRangeConstants.RANGE_QUESTIONS_TOP_ROW,
                                            AnswersGridTemplateRangeConstants.RANGE_QUESTIONS_TOP_COL +  getNumQuestions (),
                                            AnswersGridTemplateRangeConstants.RANGE_QUESTIONS_BOT_ROW-1 );
            
            w.addNameArea("Sources", 
                                            s, 
                                            AnswersGridTemplateRangeConstants.RANGE_SOURCES_TOP_COL, 
                                            AnswersGridTemplateRangeConstants.RANGE_SOURCES_TOP_ROW, 
                                            AnswersGridTemplateRangeConstants.RANGE_SOURCES_BOT_COL, 
                                            AnswersGridTemplateRangeConstants.RANGE_SOURCES_TOP_ROW + getNumSources());
            
            w.addNameArea("Answers",
                                            s,
                                            AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_COL,
                                            AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW,
                                            AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_COL + getNumQuestions(),
                                            AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW + getNumSources());
                                            
            */         
            Locale loc = this.getPreferredLocale();
            return new AnswersGridSheet( loc, w, s, this.getRis()).createAnswersGridSheet(xtraSrcsSheet, xtraQnsAnsSheet);                                
 /*                                           
            fillGeneralReportInfo(s);
            
            
            fillSourcesData(s, 
                                            AnswersGridTemplateRangeConstants.RANGE_SOURCES_TOP_COL, 
                                            AnswersGridTemplateRangeConstants.RANGE_SOURCES_TOP_ROW, 
                                            AnswersGridTemplateRangeConstants.RANGE_SOURCES_BOT_COL,//AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_COL + getNumQuestions(),//AnswersGridTemplateRangeConstants.RANGE_SOURCES_BOT_COL, 
                                            AnswersGridTemplateRangeConstants.RANGE_SOURCES_TOP_ROW + getNumSources());
          // questions contain the source answer data sets
          fillQuestionsData(s, 
                                            AnswersGridTemplateRangeConstants.RANGE_QUESTIONS_TOP_COL, 
                                            AnswersGridTemplateRangeConstants.RANGE_QUESTIONS_TOP_ROW,
                                            AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_COL + getNumQuestions(),
                                            AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW + getNumSources());
//		fillQuestionsData(s, 
//						AnswersGridTemplateRangeConstants.RANGE_QUESTIONS_TOP_COL, 
//						AnswersGridTemplateRangeConstants.RANGE_QUESTIONS_TOP_ROW,
//						AnswersGridTemplateRangeConstants.RANGE_QUESTIONS_TOP_COL +  getNumQuestions (),
//						AnswersGridTemplateRangeConstants.RANGE_QUESTIONS_BOT_ROW );

//fn -- adding ans within above fillSourceData		
//		fillAnswersData(s,
//						AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_COL,
//						AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW,
//						AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_COL + getNumQuestions(),
//						AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW + getNumSources());
            
                                            
            
            s.getSettings().setHorizontalFreeze(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW);
            s.getSettings().setVerticalFreeze(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_COL);
            s.getSettings().setProtected(false);
            s.getSettings().setZoomFactor(75);
            return s;
*/            
            
    }
    
//    private void fillAnswersData(WritableSheet s, int top_col, int top_row, int bot_col, int bot_row) {
//            int col = top_col;
//            int row = top_row;
//            int srcSeq = 1;
//
//                                            
//            // color is stored in db as hex #4455AA etc so convert to get
//            // rgb for color
//            // so we have #FF23BB 
//            // we convert to FF23BB
//            // we split to FF 23 BB
//            // then we have rgb(r,g,b)
//            // get its int
//            // get the colr
//            Colour theCellCommentColor = Colour.GOLD;
//            WritableCellFormat fmt = new WritableCellFormat();
//                try {
//                    fmt.setBackground(theCellCommentColor);
//                } catch (WriteException e) { e.printStackTrace(); }
//                           
//            List<SourceDataSetInfo> sources = this.reportTemplateInfoDataSet.getListOfSources();
//            Collections.sort( sources, new SourcesComparator() );
//            for ( Iterator it = sources.iterator(); it.hasNext(); row++) {
//                col = top_col;  // start at top_col
//                    SourceDataSetInfo sis = (SourceDataSetInfo) it.next();
//                            
//                    System.out.println("\n_____________*******************_____________________\n\nFor src id in AnswersGridTemplate[fillAnswersData] " + sis.getSrc_id());
//                    LinkedHashMap<Integer, SourceAnswersDataSetInfo>  mapAllSourceAnswers = sis.getSourceAnswersDataSets();
//                    Set<Integer> keys = mapAllSourceAnswers.keySet();
////                        List<SourceAnswersDataSet> sourceAnswersDataSets = sis.getSourceAnswersDataSets();
////                        System.out.println("For src id SIZE IS " + sourceAnswersDataSets.size());
//                    //for ( Iterator<SourceAnswersDataSet> st = sourceAnswersDataSets.iterator(); st.hasNext(); ) {
//                     for ( Iterator<Integer> st = keys.iterator(); st.hasNext(); ) {
////                            boolean found = false;
//                        try {
//                            SourceAnswersDataSetInfo sads = mapAllSourceAnswers.get(st.next());
//                            
//                            if ( sads != null ) {
//                                
//                                String answer =         sads.getAnswer() != null ? sads.getAnswer() : "";//"AAAAAAAAA";
//                                String ansText =        sads.getSra_Answer_text() != null ? sads.getSra_Answer_text() : "";//"TTTTTTTTT";
//                                String comment =        sads.getSra_comment() != null ? sads.getSra_comment() : "";//"CCCCCCCCCC";
//                                String color =          sads.getSra_color();// != null ? sads.getSra_color().substring(1) : "";
//
//                                System.out.println("srcId " + sads.getSrc_id());
//                                System.out.println("rps_id " + sads.getRps_id());
//                                System.out.println("NAME " + sis.getSrc_display_name());
//                                System.out.println("ans is " + answer);
//                                System.out.println("ansText is " + ansText);                            
//                                System.out.println("comment is " + comment);
//                                System.out.println("color is " + color);                                
//                                
//                                System.out.println("Label ansLabel = new Label(" +col + " " + row + " " + answer + ") \n- LENGTH  " + answer.length());
//                                Label ansLabel = new Label(col, row, answer);
//                                s.addCell(ansLabel);
//                                col++;
//                                
//                                System.out.println("Label ansTextLabel = new Label(" +col + " " + row + " " + ansText + ")\n - LENGTH " + ansText.length());
//                                Label ansTextLabel = new Label(col, row, ansText);
//                                WritableCellFeatures cF = new WritableCellFeatures();
//                                cF.setComment(comment);
//                                ansTextLabel.setCellFeatures(cF);
//                                
//                                // color is stored in db as hex #4455AA etc so convert to get
//                                // rgb for color
//                                // so we have #FF23BB 
//                                // we convert to FF23BB
//                                // we split to FF 23 BB
//                                // then we have rgb(r,g,b)
//                                // get its int
//                                // get the colr
////                                    Colour theColor = Colour.GOLD;//(color);
////
////                                    System.out.println("RGB resolved theColor is " + theColor );
//                                if ( color != null ) {
//                                    ansTextLabel.setCellFormat(fmt);
//                                }
//                                
//                                s.addCell(ansTextLabel);
//
//                            }
//                            
//                            col++;
////                            } catch (Exception e) { e.printStackTrace();   
//                        } 
//                        catch (RowsExceededException e) {
//                                        e.printStackTrace();
//                                } catch (WriteException e) {
//                                        e.printStackTrace();
//                                }
////                            if ( found ) row++;
//                    }
//                    col = top_col;
//            }
//    }
    


//    private void fillSourcesData(WritableSheet s, int top_col, int top_row, int bot_col, int bot_row) {
//            int col = top_col;
//            int row = top_row;
//            int srcSeq = 1;
//            List<SourceDataSetInfo> sources = this.reportTemplateInfoDataSet.getListOfSources();
//            Collections.sort( sources, new SourcesComparator() );
//
//
//        try {
//            s.addCell(new Label(top_col+1, top_row-1,"Seq."));
//            s.addCell(new Label(top_col+2, top_row-1, "SourceName"));
//            s.addCell(new Label(top_col+3, top_row-1, "Reporter"));
//        } catch (WriteException e) {
//            e.printStackTrace();
//        }
//        for ( Iterator it = sources.iterator(); it.hasNext(); srcSeq++,row++) {   // for each src
//            
//                    col = top_col;  //reset to first col
//                    SourceDataSetInfo sis = (SourceDataSetInfo) it.next();
//                    
////                        LinkedHashMap<Integer, SourceAnswersDataSetInfo>  mapAllSourceAnswers = sis.getSourceAnswersDataSets();
////                        Set<Integer> keys = mapAllSourceAnswers.keySet();
//                    
//                    boolean found = false;
//                    try {
//                            jxl.write.Number  srcIdCell = new jxl.write.Number (col, row, sis.getRps_id());
//System.out.println("??? Adding src getRps_id [sis.getRps_id()] " + sis.getRps_id() + " or sis.getSrc_id " + sis.getSrc_id() + " in cell (" + col + ", " + row + ")");
//                            CellView hideView = new CellView();
//                            hideView.setHidden(true);
//                            s.addCell( srcIdCell );
//                            s.setColumnView(col, hideView);
//System.out.println("Cell contents for 0,row 0,"+row+ " -->  "  + ((Number)s.getCell(0, row)).getValue());
//                            col++;
//                            
//                            Label srcSeqLabel = new Label(col, row, String.valueOf(srcSeq));
//                            s.addCell( srcSeqLabel );
//                            col++;
//                            
//                            Label srcLabel = new Label(col, row,  sis.getSrc_display_name().replaceAll("null", ""));
//                            
//                            WritableHyperlink whl = new WritableHyperlink(col, row, sis.getSrc_display_name().replaceAll("null", ""), 
//                                                    (WritableSheet) sheetMap.get(AnswersGridTemplateRangeConstants.SOURCE_DETAILS_SHEET_NAME), 0, row+2);
//                            s.addHyperlink(whl);
//                            
//                           
//                            srcLabel.setCellFormat(srcInfoDataCellFormat());
//                            
//                            CellView view = new CellView();
//                            view.setSize(25*256);
//                            s.addCell( srcLabel );
//                            s.setColumnView(col, view);
//                            s.setRowView(row, 3*256);
//
//                            //reporter initials
//                            col++;  
//                            Label reporterInitLabel = new Label(col, row, sis.getEmp_init());
//System.out.println("Added reporterInitLabel " + sis.getEmp_init() + " in " + col + ", " + row );                            
//                            s.addCell(reporterInitLabel);
//                            
//                            
//                            // repeat info
//                            col++;
//                            Label repSrcLabel = new Label(col, row, sis.getRps_repeat_source_yn());
//                            repSrcLabel.setCellFormat(repSrcInfoDataCellFormat());
//                            s.addCell(repSrcLabel);
//                            
//                            // add ans data
////                                col++;/*
////                                for ( Iterator<Integer> st = keys.iterator(); st.hasNext(); ) { // starts for srcansdata
////                                    SourceAnswersDataSet sads = mapAllSourceAnswers.get(st.next());
////                                    
////                                    if ( sads != null ) {
////                                        
////                                        String answer =         sads.getAnswer() != null ? sads.getAnswer() : "";
////                                        boolean isEmptyCell = (answer == "" || answer.equals("")) ?  true : false;
////                                        
////                                        if ( !isEmptyCell ) {
////                                        
////                                        String ansText =        sads.getSra_Answer_text() != null ? sads.getSra_Answer_text() : "";
////                                        String comment =        sads.getSra_comment() != null ? sads.getSra_comment() : "";
////                                        String color =          sads.getSra_color() != null ? sads.getSra_color().substring(1) : "";
////    
////                                        System.out.println("srcId " + sads.getSrc_id());
////                                        System.out.println("rps_id " + sads.getRps_id());
////                                        System.out.println("NAME " + sis.getSrc_display_name());
////                                        System.out.println("ans is " + answer);
////                                        System.out.println("ansText is " + ansText);
////                                        System.out.println("comment is " + comment);
////                                        System.out.println("color is " + color);                                
////                                        
////                                        System.out.println("Label ansLabel = new Label(" +col + " " + row + " " + answer + ") \n- LENGTH  " + answer.length());
////                                        
//////  fn                                      Label ansLabel = new Label(col, row, answer);
//////  fn                                      s.addCell(ansLabel);
////                                        
////                                        col++;
////                                        
////                                        System.out.println("Label ansTextLabel = new Label(" +col + " " + row + " " + ansText + ")\n - LENGTH " + ansText.length());
////// fn                                       Label ansTextLabel = new Label(col, row, ansText);
////                                        // color is stored in db as hex #4455AA etc so convert to get
////                                        // rgb for color
////                                        // so we have #FF23BB 
////                                        // we convert to FF23BB
////                                        // we split to FF 23 BB
////                                        // then we have rgb(r,g,b)
////                                        // get its int
////                                        // get the colr
//////fn                                                        Colour theColor = resolveRGBColor(color);
////    
//////                                                        System.out.println("RGB resolved theColor is " + theColor )                                    ;
//////                                                        if ( theColor != null && theColor instanceof Colour) {
//////                                                            WritableCellFormat fmt = new WritableCellFormat();                
//////                                                            fmt.setBackground(theColor);
//////                                                            ansTextLabel.setCellFormat(fmt);
//////                                                        }
//////fn           
////
//////   fn                                    s.addCell(ansTextLabel);
////    
////                                    }
////                                }   // ends for srcansdata
////                                col++;
////                        }*/
//                    
//            } catch (RowsExceededException e) {
//                    e.printStackTrace();
//            } catch (WriteException e) {
//                    e.printStackTrace();
//            }
//            
//            col = top_col;
//        }   // ends for
//    }
//
//    private void fillQuestionsData(WritableSheet s, int top_col, int top_row, int bot_col, int bot_row) {
//            int col = top_col;
//            int row = top_row;
//     System.out.println("Entering fillQuestionsData -- numSources " + getNumSources() + " numQuestions " + getNumQuestions()) ;
//     
//     System.out.println("fillQuestionsData topcol " + top_col  + " top_row " + top_row + " bot_col " + bot_col + " bot_row " + bot_row);
//        System.out.println("size Qns is " + this.reportTemplateInfoDataSet.getListOfQuestions().size());          
//        
////            
////                    for ( int i = 0; i < getNumQuestions(); i++ ) {
////                    //                for ( Iterator<QuestionDataSetInfo> mt = this.reportTemplateInfoDataSet.getListOfQuestions().iterator(); mt.hasNext(); col++) {
////                    try {
//////                        mt.next();  // just a call to traverse
////                        System.out.println("merging col " + col + " row " + row + " col+1 " + (col+1) + " row " + row);
////                        s.mergeCells(col, row, col+1, row);
//////                        s.mergeCells(col, row+1, col+1, row+1);
////                        col++;
////                        
////                        if ( col+1 == 256 ) { System.out.println("[256] qis  ");    break; }
////                    } 
////                    catch (WriteException e) { e.printStackTrace(); }
////                }
////                
//            col = top_col;
//            row = top_row;
//
////            WritableCellFormat wrapNormalAnswerFormat = new WritableCellFormat();
////
////            try {
////                wrapNormalAnswerFormat.setWrap(true);
////                wrapNormalAnswerFormat.setAlignment(Alignment.CENTRE);
////                wrapNormalAnswerFormat.setVerticalAlignment(VerticalAlignment.TOP);
////                wrapNormalAnswerFormat.setFont(new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD));
////            } catch (WriteException e) {
////                e.printStackTrace();
////            }
//
//            for (Iterator<QuestionDataSetInfo> it = this.reportTemplateInfoDataSet.getListOfQuestions().iterator(); it.hasNext(); col++) {                
//                    
//                    row = top_row;
//                    QuestionDataSetInfo qis = it.next();
//                    LinkedHashMap<Integer, SourceAnswersDataSetInfo> sadMap = qis.getSourceAnswersDataSets();
////Set<Integer> theKeys = sadMap.keySet();
////System.out.println("The keys for Q qid " + qis.getQst_id() + " mapsize " + sadMap.size() );
////for ( Iterator<Integer> kt = theKeys.iterator(); kt.hasNext(); ) {
////System.out.println(kt.next());
////}
//                    if ( sadMap == null ) { System.err.println("Uh-oh");System.exit(1); }
//            if ( col == 256 ) { System.out.println("[256] qis  qid" + qis.getQst_id());    break; }
//                    try {
//                            // qstnid label  
//                            jxl.write.Number qstIdCell = new jxl.write.Number(col, row, qis.getQst_id());				
//                            CellView hideView = new CellView();
//                            hideView.setHidden(true);
//                            s.addCell( qstIdCell );
//                            s.setRowView(row, hideView);
//                            
//                            row = row+1;//row++;
//                            
//                            // qstn label 
//                             if ( qis.getQst_type() ==  "WEIGHT" || qis.getQst_type().equals("WEIGHT")) {// || qis.getQst_type() == "MULTI" ) {
//                              System.out.println("merging col, row, col+1, row " + col + ", " + row + ", " + col+1 + ", " + row);
//                                 s.mergeCells(col, row, col+1, row);
//                             } else if ( qis.getQst_type() == "MULTI" || qis.getQst_type().equals("MULTI")) {
//                             //                                MultiQuestionDataSetInfo mqds = qis.get
//                                     int qNums = qis.getMultiQuestionInfo().size();
//                                     System.out.println("qNums is " + qNums);
//                                     System.out.println("merging col, row, col+qNums, row " + col + ", " + row + ", " + col+qNums + ", " + row);
//                                     s.mergeCells(col, row, col+qNums, row);
//                             }
//                            String theQuestion = qis.getQst_numeric() != 0 ? qis.getQst_numeric() + ". " + qis.getQst_question() : qis.getQst_question();
//                            Label qstLabel = new Label(col, row, theQuestion);
//System.out.println("qnCol is " + col + " and row is " + row)				;
//                            WritableFont boldBlackFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD); 	
//                            boldBlackFont.setColour(Colour.BLACK);
//                            WritableCellFormat boldBlack = new WritableCellFormat(boldBlackFont);
//                            boldBlack.setWrap(true);
//                            boldBlack.setAlignment(Alignment.LEFT);
//                            boldBlack.setVerticalAlignment(VerticalAlignment.TOP);
//                            boldBlack.setBorder(Border.ALL, BorderLineStyle.THICK);
//                            boldBlack.setBackground(AnswersGridTemplateRangeConstants.QSTNS_COLOR);
//                            boldBlack.setLocked(true);
//                            qstLabel.setCellFormat(boldBlack);
//                            CellView view = new CellView();
//                            view.setSize(45*256);
//                            s.addCell( qstLabel );
//                            s.setColumnView(col, view);
//                            
//                            row = row+1;//row++;
//                            
//                            /*if ( !qis.getQst_question().equalsIgnoreCase("Repeat Sources") )
//                                    s.mergeCells(col, row, col+1, row);
//                            */
//                            // qstnhint part label
//                            Label qstTextHintLabel = new Label(col, row, qis.getQst_text_hint());
//                            WritableFont boldRedFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD); 	
//                            boldRedFont.setColour(Colour.RED);
//                            WritableCellFormat boldRed = new WritableCellFormat(boldRedFont);
//                            boldRed.setBackground(AnswersGridTemplateRangeConstants.QSTNS_COLOR);
//                            boldRed.setLocked(true);
//                            qstTextHintLabel.setCellFormat(boldRed);
//                            s.addCell( qstTextHintLabel );
//                            
//                            Label qstHintLabel = new Label(col+1, row, qis.getQst_question_hint());
//                            WritableFont redFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD); 	
//                            redFont.setColour(Colour.RED);
//                            WritableCellFormat justRed = new WritableCellFormat(redFont);
//                            justRed.setBackground(AnswersGridTemplateRangeConstants.QSTNS_COLOR);
//                            justRed.setLocked(true);
//                            qstHintLabel.setCellFormat(justRed);
//                            s.addCell( qstHintLabel );
//                            
//                            
//                            //lookup on src id for each source
//                            for ( int i = 0; i < getNumSources(); i++ ) {                                
//                                // start populating sad map.
//                                row = row+1;//row++;
//
//System.out.println("for ans in cell col " + col + " and row " + row + " and 0thcol cell contents is (0," + row + ")  ---> " + s.getCell(0,row).getContents());
//                                // answer
//                                int srcRepId = Integer.parseInt(s.getCell(0,row).getContents());//(int)((Number)s.getCell(0,row)).getValue();//.getContents();//long srcId = Long.parseLong(s.getCell(0,row).getContents());
//System.out.println("found src_id " + srcRepId);
//                                if ( qis.getQst_type() == "MULTI" || qis.getQst_type().equals("MULTI")) {
//                                    int qNums = qis.getMultiQuestionInfo().size();
//                                    for ( int qmq = 1; qmq <=qNums; qmq++ ) {
//                                        String key = srcRepId + "00" + qmq;     // key == rps_id + 00 + numofmultiqn --- so for 3 parts 17774 becomes 17774001, 17774002, 17774003
//                                        if ( sadMap.get(Integer.parseInt(key)) != null)  {
//                                            String theAnswer = sadMap.get(srcRepId+qmq).getAnswer().trim();
//                                            Label ansLabel = new Label(col, row, processStingForWrap(theAnswer, 45));
//                                            ansLabel.setCellFormat(multiQstnInfoDataCellFormat());
//                                            s.addCell( ansLabel );
//                                            col++;
//                                        }
//                                    }
//                                    col++;
//                                    
//                                    // all answer texts are the same so we just take for first one only
//                                    String theAnswerText = sadMap.get(Integer.parseInt(srcRepId + "00" + 1)).getSra_Answer_text().trim();
//                                    Label ansTextLabel = new Label(col, row, processStingForWrap(theAnswerText, 45));
//                                    ansTextLabel.setCellFormat(wrapNormalAnswerFormat());
//                                    CellView ansTextView = new CellView();
//                                    view.setSize((theAnswerText.length()/45)*(1/20));
//                                    s.addCell( ansTextLabel );
//                                } else {
//                                if ( sadMap.get(srcRepId) != null)  {
//System.out.println("COOOOOOL Map is NOT NULL for qid " + qis.getQst_id());
//                                    if ( sadMap.get(srcRepId).getAnswer() != null ) {
//System.out.println("For rpsid " + srcRepId + " ans is " + sadMap.get(srcRepId).getAnswer() + "\n adding it to cell col-row [" + col + ", " + row + "]");
//                                            String theAnswer = sadMap.get(srcRepId).getAnswer().trim();
//                                            Label ansLabel = new Label(col, row, processStingForWrap(theAnswer, 45));
//                                           
//                                            if ( qis.getQst_type() == "WEIGHT" || qis.getQst_type().equals("WEIGHT")) {
//System.out.println("WEIGHT  col,row " + col + ", " + row);                                            
//                                                ansLabel.setCellFormat(wghtdQstnInfoDataCellFormat());//wrapNormalAnswerFormat.setBackground(AnswersGridTemplateRangeConstants.WGHTD_COLOR);
//                                            } else if ( qis.getQst_type() == "SORT" || qis.getQst_type().equals("SORT")) {
//System.out.println("SORT  col,row " + col + ", " + row);                                            
//                                                ansLabel.setCellFormat(sortedQstnInfoDataCellFormat());//.setBackground(AnswersGridTemplateRangeConstants.SORT_COLOR);
//                                                
//                                            } else {
//                                          
//                                                ansLabel.setCellFormat(wrapNormalAnswerFormat());
//                                            }
////                                                CellView ansView = new CellView();
////                                                view.setSize((theAnswer.length()/45)*(1/20));
//                                            s.addCell( ansLabel );
////                                                s.setRowView(row, ansView);
//
//System.out.println("For rpsid " + srcRepId + " anstxt is " + sadMap.get(srcRepId).getSra_Answer_text() + "\n adding it to cell col-row [" + (col+1) + ", " + row + "]");
//                                            String theAnswerText = sadMap.get(srcRepId).getAnswer().trim();
//                                            Label ansTextLabel = new Label(col+1, row, processStingForWrap(theAnswerText, 45));
//                                            ansTextLabel.setCellFormat(wrapNormalAnswerFormat());
//                                                CellView ansTextView = new CellView();
//                                                view.setSize((theAnswerText.length()/45)*(1/20));
//                                            s.addCell( ansTextLabel );
////                                                s.setRowView(row, ansTextView);
//                                    } else {
//                                
//                                    }
//                                } else {
//System.out.println("ARGHHHH Map is NULL for qid " + qis.getQst_id() + " and src");
//                                }
//                            }
//                            }
//                        
//                            //if ( qis.getQst_type() ==  "WEIGHT" || qis.getQst_type() == "MULTI" ) {
//                                row++;
//                                Label mqWq = new Label(col, row, qis.getQst_type());
//                                s.addCell(mqWq);
//                                col = col+1;
//                            //}
//                            
//                            row = top_row;
//                            
//                    } catch (RowsExceededException e) {
//                            e.printStackTrace();
//                    } catch (WriteException e) {
//                            e.printStackTrace();
//                    } catch (Exception e) {
//                            e.printStackTrace();
//                    }
//            }
//    }

    private Colour resolveRGBColor(String color) {
        if ( color != null ) {
          if ( color.length() == 6 ) {          //if ( color.startsWith("#") && color.length() == 7 ) {
//                  color = color.substring(1);       // remove the # color.length = 6
              
              String r = color.substring(0,2);
              String g = color.substring(2,4);
              String b = color.substring(4,6);
              
              int theR = Integer.parseInt(r, 16);
              int theG = Integer.parseInt(g, 16);
              int theB = Integer.parseInt(b, 16);
              
              return getClosestIndexColor(theR, theG, theB) != null ?  getClosestIndexColor(theR, theG, theB) : Colour.DEFAULT_BACKGROUND;
              //RGB theRGB = new RGB(theR, theG, theB);
//                  int 
              
          }
        }
        return Colour.DEFAULT_BACKGROUND;
    }
        
    private Colour getClosestIndexColor(int r, int g, int b) {
        Colour[] indexColors = Colour.getAllColours();
        int sDiff = Integer.MAX_VALUE;
        Colour selected = null;
        boolean found = false;
        int val;
        for (int i = 0; i < indexColors.length; i++) {
            int cDiff = Math.abs(indexColors[i].getDefaultRGB().getRed() - r)
                            + Math.abs(indexColors[i].getDefaultRGB().getGreen() - g) 
                            + Math.abs(indexColors[i].getDefaultRGB().getBlue() - b);
            if (cDiff < sDiff) {
                sDiff = cDiff;
                selected = indexColors[i];
                found = true;
            }
        }
        val = (selected != null) ? selected.getValue() : 9999;
    System.out.println("getClosestIndexColor found " + found + " color value " + val );
        return selected;
    }

//    private String processStingForWrap(String text, int limit) {
//        if ( text.length() < limit ) return text;
//        else {
//            String retVal = "";// = text.substring(0,limit);
//            String bal = text;//text.substring(limit);
//            int total = text.length();
//            int times = total / limit;  System.out.println("times is " + times);
//            for ( int i = 0; i <= times; i++) {
//                if ( bal.length() > limit) {
//                    retVal += bal.substring(0,limit) + "\n";
//                    bal = bal.substring(limit);
//                } else {
//                    retVal += bal;
//                }
//            }
//            return retVal;
//        }
//    }
//
//    private void fillGeneralReportInfo(WritableSheet s) {
//        try {
//            
//            WritableCellFormat wrapNormalFormat = new WritableCellFormat();
//            wrapNormalFormat.setWrap(true);
//            wrapNormalFormat.setAlignment(Alignment.CENTRE);
//            wrapNormalFormat.setVerticalAlignment(VerticalAlignment.TOP);
//            wrapNormalFormat.setFont(new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD));
//            Label rName = new Label(1,1,this.reportTemplateInfoDataSet.getReportGeneralInfo().getReportDesc());
//            rName.setCellFormat(wrapNormalFormat);
//            s.addCell( rName );
//            
//            Label rType = new Label(2,1, this.reportTemplateInfoDataSet.getReportGeneralInfo().getReportType());
//            s.addCell( rType );
//            
//            jxl.write.DateTime dateLabel = new jxl.write.DateTime(3,1,this.reportTemplateInfoDataSet.getReportGeneralInfo().getReportDueDate());
//            s.addCell(dateLabel);
//            
//        } catch (WriteException e) {
//            e.printStackTrace();
//        }
//    }


//    public interface AnswersGridTemplateRangeConstants {
//				
//		public static final String INTRO_SHEET_NAME = "READ_THIS";
//		public static final int INTRO_SHEET_NUMBER = 0;
//		
//		
//		public static final String ANSWERS_GRID_SHEET_NAME = "Answers_Grid";
//		public static final int ANSWERS_GRID_SHEET_NUMBER = 1;
//		
//		public static final int RANGE_META_TOP_ROW = 0;
//		public static final int RANGE_META_TOP_COL = 0;		
//		public static final int RANGE_META_BOT_ROW = 2;
//		public static final int RANGE_META_BOT_COL = 10;
//		
//		public static final int RANGE_QUESTIONS_TOP_ROW = 0;
//		public static final int RANGE_QUESTIONS_TOP_COL = 4;
//		public static final int RANGE_QUESTIONS_BOT_ROW = 3;	//RANGE_QUESTIONS_BOT_COL = 	RANGE_QUESTIONS_TOP_COL + numQuestions
//		
//		public static final int RANGE_SOURCES_TOP_ROW = 3;
//		public static final int RANGE_SOURCES_TOP_COL = 0;
//		public static final int RANGE_SOURCES_BOT_COL = 3;		//RANGE_SOURCES_BOT_ROW = RANGE_SOURCES_TOP_ROW + numSources
//		
//		public static final int RANGE_ANSWERS_TOP_ROW = 4;
//		public static final int RANGE_ANSWERS_TOP_COL = 5; 		//RANGE_ANSWERS_BOT_ROW = RANGE_ANSWERS_TOP_ROW + numSources
//																//RANGE_ANSWERS_BOT_COL = RANGE_ANSWERS_TOP_COL + unmQuestions
//		
//		public static final String REPORT_CALCS_SHEET_NAME = "Report Calcs";
//		public static final int REPORT_CALCS_SHEET_NUMBER = 2;
//		
//		public static final String REPORT_SUMMARY_SHEET_NAME = "Summary";
//		public static final int REPORT_SUMMARY_SHEET_NUMBER = 3;
//		
//		public static final String EXTRA_SOURCES_SHEET_NAME = "Extra Sources";
//		public static final int EXTRA_SOURCES_SHEET_NUMBER = 4;
//		
//		public static final String RANGE_NAME_NUM_EXTRA_SOURCES = "NumberOfExtraSources";
//		public static final int RANGE_NUM_EXTRA_SOURCES_TOP_ROW = 2;
//		public static final int RANGE_NUM_EXTRA_SOURCES_TOP_COL = 2;
//		public static final int RANGE_NUM_EXTRA_SOURCES_BOT_ROW = 2;
//		public static final int RANGE_NUM_EXTRA_SOURCES_BOT_COL = 2;
//		
//		public static final String RANGE_NAME_EXTRA_SOURCEDETAILS = "SourceDetailFields";
//		public static final String RANGE_NAME_EXTRA_SOURCEFIELDS = "ExtraSourceFields";
//		public static final int RANGE_EXTRA_SOURCEFIELDS_TOP_ROW = 4;
//		public static final int RANGE_EXTRA_SOURCEFIELDS_TOP_COL = 0;
//		public static final int RANGE_EXTRA_SOURCEFIELDS_BOT_ROW = 5;
//		public static final int RANGE_EXTRA_SOURCEFIELDS_BOT_COL = 39;
//		
//
//		
//		public static final String RANGE_NAME_START_EXTRA_SOURCES = "StartExtraSources";
//		public static final int RANGE_START_EXTRA_SOURCES_TOP_ROW = RANGE_EXTRA_SOURCEFIELDS_BOT_ROW+1;
//		public static final int RANGE_START_EXTRA_SOURCES_TOP_COL = 0;
//		public static final int RANGE_START_EXTRA_SOURCES_BOT_ROW = RANGE_EXTRA_SOURCEFIELDS_BOT_ROW+1;
//		public static final int RANGE_START_EXTRA_SOURCES_BOT_COL = 0;
//		
//		
//		
//		public static final String SOURCE_DETAILS_SHEET_NAME = "Source_Details";
//		public static final int SOURCE_DETAILS_SHEET_NUMBER = 5;
//		
//		/** range names sheet 1**/
////		public static final jxl.Range SOURCE_RANGE =  
////			abstract  void 	addNameArea(java.lang.String name, WritableSheet sheet, int firstCol, int firstRow, int lastCol, int lastRow) 
//		
//		/** colours **/
//		public static final jxl.format.Colour RED_COLOR =  jxl.format.Colour.RED;
//		public static final jxl.format.Colour AQUA_COLOR =  jxl.format.Colour.AQUA;
//		public static final jxl.format.Colour YELLOW_COLOR =  jxl.format.Colour.YELLOW;
//		public static final jxl.format.Colour WHITE_COLOR =  jxl.format.Colour.WHITE;
//		public static final jxl.format.Colour BLUE_COLOR =  jxl.format.Colour.BLUE;
//		public static final jxl.format.Colour BLACK_COLOR =  jxl.format.Colour.BLACK;
//		
//		/** cell highlight colours **/
//		public static final jxl.format.Colour WGHTD_COLOR =  jxl.format.Colour.LIME;
//		public static final jxl.format.Colour REPEAT_COLOR =  jxl.format.Colour.RED;
//		public static final jxl.format.Colour QSTNS_COLOR =  jxl.format.Colour.AQUA;
//		public static final jxl.format.Colour SORT_COLOR =  jxl.format.Colour.BLUE;
//                public static final jxl.format.Colour MULTI_COLOR =  jxl.format.Colour.TEAL;
////		public static final jxl.format.Colour SRCS_COLOR =  jxl.format.Colour.LIGHT_TURQUOISE;
//		
//		
//		
//		
//	}

	public File getAnswersGridTempFile() {
		return answersGridTempFile;
	}

	public void setAnswersGridTempFile(File answersGridTempFile) {
		this.answersGridTempFile = answersGridTempFile;
	}

	public WritableWorkbook getAnswersGridWorkbook() {
		return this.answersGridWorkbook;
	}

	public void setAnswersGridWorkbook(WritableWorkbook answersGridWorkbook) {
		this.answersGridWorkbook = answersGridWorkbook;
	}

	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.AnswersGridTempInfo#getRis()
	 */
	public ReportTemplateInfo getRis() {
		return this.reportTemplateInfoDataSet;
	}

	public void setReportTemplateInfoDataSet(ReportTemplateInfo ris) {
		this.reportTemplateInfoDataSet = ris;
	}

        public ReportTemplateInfo getReportTemplateInfoDataSet() {
                return this.reportTemplateInfoDataSet;
        }
        
        
	public void initializeSheets(WritableWorkbook w) {
		WritableSheet s = w.createSheet(AnswersGridTemplateRangeConstants.INTRO_SHEET_NAME, 
										AnswersGridTemplateRangeConstants.INTRO_SHEET_NUMBER);

		sheetMap.put(AnswersGridTemplateRangeConstants.INTRO_SHEET_NAME, s);
		
		s = w.createSheet(AnswersGridTemplateRangeConstants.ANSWERS_GRID_SHEET_NAME, 
										AnswersGridTemplateRangeConstants.ANSWERS_GRID_SHEET_NUMBER);

		s.getSettings().setProtected(true);
		sheetMap.put(AnswersGridTemplateRangeConstants.ANSWERS_GRID_SHEET_NAME, s);
/********************		
		s = w.createSheet(AnswersGridTemplateRangeConstants.REPORT_CALCS_SHEET_NAME, 
										AnswersGridTemplateRangeConstants.REPORT_CALCS_SHEET_NUMBER);
		sheetMap.put(AnswersGridTemplateRangeConstants.REPORT_CALCS_SHEET_NAME, s);
**********************/
		
                
                /************* rem for v1 put back in for v2.***************************/
                
		s = w.createSheet(AnswersGridTemplateRangeConstants.EXTRA_SOURCES_SHEET_NAME, 
				AnswersGridTemplateRangeConstants.EXTRA_SOURCES_SHEET_NUMBER);
		
		sheetMap.put(AnswersGridTemplateRangeConstants.EXTRA_SOURCES_SHEET_NAME, s);
		
                if ( this.reportTemplateInfoDataSet.getListOfQuestionsForAdditionalAnswers().size() > 0 ) { 
                    s = w.createSheet(AnswersGridTemplateRangeConstants.EXTRA_QUESTION_ANS_SHEET_NAME, 
                                    AnswersGridTemplateRangeConstants.EXTRA_QUESTION_ANS_SHEET_NUMBER);
                    
                    sheetMap.put(AnswersGridTemplateRangeConstants.EXTRA_QUESTION_ANS_SHEET_NAME, s);
                    
                }
                
                /************* ends rem for v1 put back in for v2.**************************/
		s = w.createSheet(AnswersGridTemplateRangeConstants.SOURCE_DETAILS_SHEET_NAME, 
				AnswersGridTemplateRangeConstants.SOURCE_DETAILS_SHEET_NUMBER);
		
		sheetMap.put(AnswersGridTemplateRangeConstants.SOURCE_DETAILS_SHEET_NAME, s);
                
                s = w.createSheet(AnswersGridTemplateRangeConstants.COUNTRIES_SHEET_NAME,
                                AnswersGridTemplateRangeConstants.COUNTRIES_SHEET_NUMBER);
                                
                sheetMap.put(AnswersGridTemplateRangeConstants.COUNTRIES_SHEET_NAME, s);
		
	}
        
        
    public void setPreferredLocale(Locale loc) {
        this.preferredLocale = loc;
    }
    
    public Locale getPreferredLocale() {
        return this.preferredLocale;
    }

    private WorkbookSettings getWbSettings(Locale theLoc) {
        WorkbookSettings wbS = new WorkbookSettings();
        String language = theLoc.getLanguage();
        String country = theLoc.getCountry();   
System.out.println("language is " + language + " and country is " + country);        
        wbS.setLocale( theLoc );
//        wbS.setExcelDisplayLanguage( language );
        wbS.setExcelRegionalSettings( country );
        wbS.setEncoding("cp1252");
        return wbS;
        
    }
}


