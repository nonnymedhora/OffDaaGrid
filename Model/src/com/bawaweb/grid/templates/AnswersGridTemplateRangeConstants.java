/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates;

import jxl.format.Colour;
/**
 * ALL constants used by the spread sheets and some constants for logical uses by the application
 */
public interface AnswersGridTemplateRangeConstants {


                public static final String INTRO_SHEET_NAME = "READ_THIS";
		public static final int INTRO_SHEET_NUMBER = 0;
		
		
		public static final String ANSWERS_GRID_SHEET_NAME = "Answers_Grid";
		public static final int ANSWERS_GRID_SHEET_NUMBER = 1;
		
		public static final int RANGE_META_TOP_ROW = 0;
		public static final int RANGE_META_TOP_COL = 0;		
		public static final int RANGE_META_BOT_ROW = 2;
		public static final int RANGE_META_BOT_COL = 10;
		
		public static final int RANGE_QUESTIONS_TOP_ROW = 0;
		public static final int RANGE_QUESTIONS_TOP_COL = 4;
		public static final int RANGE_QUESTIONS_BOT_ROW = 3;	//RANGE_QUESTIONS_BOT_COL = 	RANGE_QUESTIONS_TOP_COL + numQuestions
		
		public static final int RANGE_SOURCES_TOP_ROW = 3;
		public static final int RANGE_SOURCES_TOP_COL = 0;
		public static final int RANGE_SOURCES_BOT_COL = 3;		//RANGE_SOURCES_BOT_ROW = RANGE_SOURCES_TOP_ROW + numSources
		
		public static final int RANGE_ANSWERS_TOP_ROW = 3;
		public static final int RANGE_ANSWERS_TOP_COL = 5; 		//RANGE_ANSWERS_BOT_ROW = RANGE_ANSWERS_TOP_ROW + numSources
																//RANGE_ANSWERS_BOT_COL = RANGE_ANSWERS_TOP_COL + unmQuestions
		
		public static final String REPORT_CALCS_SHEET_NAME = "Report Calcs";
		public static final int REPORT_CALCS_SHEET_NUMBER = 2;
		
		public static final String REPORT_SUMMARY_SHEET_NAME = "Summary";
		public static final int REPORT_SUMMARY_SHEET_NUMBER = 3;
		
		public static final String EXTRA_SOURCES_SHEET_NAME = "Extra Sources";
		public static final int EXTRA_SOURCES_SHEET_NUMBER = 4;
                
                
                public static final String EXTRA_QUESTION_ANS_SHEET_NAME = "Extra Answers";
                public static final int EXTRA_QUESTION_ANS_SHEET_NUMBER = 4;
                public static final String XTRA_QSTNANS_SHEET_FORMULA_NAME = "'Extra Answers'!";
		
		public static final String RANGE_NAME_NUM_EXTRA_SOURCES = "NumberOfExtraSources";
		public static final int RANGE_NUM_EXTRA_SOURCES_TOP_ROW = 3;
		public static final int RANGE_NUM_EXTRA_SOURCES_TOP_COL = 2;
		public static final int RANGE_NUM_EXTRA_SOURCES_BOT_ROW = 3;
		public static final int RANGE_NUM_EXTRA_SOURCES_BOT_COL = 2;
		
		public static final String RANGE_NAME_EXTRA_SOURCEDETAILS = "SourceDetailFields";
		public static final String RANGE_NAME_EXTRA_SOURCEFIELDS = "ExtraSourceFields";
		public static final int RANGE_EXTRA_SOURCEFIELDS_TOP_ROW = 4;
		public static final int RANGE_EXTRA_SOURCEFIELDS_TOP_COL = 0;
		public static final int RANGE_EXTRA_SOURCEFIELDS_BOT_ROW = 4;
		public static final int RANGE_EXTRA_SOURCEFIELDS_BOT_COL = 39;
                public static final int NUM_EXTRA_SOURCEFIELDS = 34;
                public static final String XTRA_SRC_SHEET_FORMULA_NAME = "'Extra Sources'!";
                
		

		
		public static final String RANGE_NAME_START_EXTRA_SOURCES = "StartExtraSources";
		public static final int RANGE_START_EXTRA_SOURCES_TOP_ROW = RANGE_EXTRA_SOURCEFIELDS_BOT_ROW+1;
		public static final int RANGE_START_EXTRA_SOURCES_TOP_COL = 0;
		public static final int RANGE_START_EXTRA_SOURCES_BOT_ROW = RANGE_EXTRA_SOURCEFIELDS_BOT_ROW+1;
		public static final int RANGE_START_EXTRA_SOURCES_BOT_COL = 0;
		
		
		
		public static final String SOURCE_DETAILS_SHEET_NAME = "Source_Details";
		public static final int SOURCE_DETAILS_SHEET_NUMBER = 5;
                
                
                public static final String COUNTRIES_SHEET_NAME = "Countries_TimeZones";
                public static final int COUNTRIES_SHEET_NUMBER = 6;
                
                public static final int RANGE_START_COUNTRIES_TOP_COL = 0;
                public static final int RANGE_START_COUNTRIES_TOP_ROW = 3;
                public static final int RANGE_START_COUNTRIES_BOT_COL = 0;
                public static final String RANGE_NAME_COUNTRIES = "CountryNames";
                
                    
                public static final int RANGE_START_TIMEZONES_TOP_COL = 4;
                public static final int RANGE_START_TIMEZONES_TOP_ROW = 3;
                public static final int RANGE_START_TIMEZONES_BOT_COL = 0;
                public static final String RANGE_NAME_TIMEZONES = "TimeZones";

                
		
		/** range names sheet 1**/
//		public static final jxl.Range SOURCE_RANGE =  
//			abstract  void 	addNameArea(java.lang.String name, WritableSheet sheet, int firstCol, int firstRow, int lastCol, int lastRow) 
		
		/** colours **/
		public static final jxl.format.Colour RED_COLOR =  jxl.format.Colour.RED;
		public static final jxl.format.Colour AQUA_COLOR =  jxl.format.Colour.AQUA;
		public static final jxl.format.Colour YELLOW_COLOR =  jxl.format.Colour.YELLOW;
		public static final jxl.format.Colour WHITE_COLOR =  jxl.format.Colour.WHITE;
		public static final jxl.format.Colour BLUE_COLOR =  jxl.format.Colour.BLUE;
		public static final jxl.format.Colour BLACK_COLOR =  jxl.format.Colour.BLACK;
		
		/** cell highlight colours **/
		public static final jxl.format.Colour WGHTD_COLOR =  jxl.format.Colour.LIGHT_GREEN;//LIME;
		public static final jxl.format.Colour REPEAT_COLOR =  jxl.format.Colour.BLACK;
		public static final jxl.format.Colour QSTNS_COLOR =  jxl.format.Colour.AQUA;
		public static final jxl.format.Colour SORT_COLOR =  Colour.GRAY_25;
                public static final jxl.format.Colour SINGLE_COLOR =  Colour.LIGHT_TURQUOISE2;	    
                public static final jxl.format.Colour MULTI_COLOR =  Colour.PALE_BLUE;//jxl.format.Colour.TURQUOISE;
                public static final jxl.format.Colour COMMENT_COLOR =  jxl.format.Colour.GOLD;
//		public static final jxl.format.Colour NUMERIC_ANSTEXT_COLOR =  Colour.VERY_LIGHT_YELLOW;//.LIGHT_ORANGE;
                public static final jxl.format.Colour NUMERIC_COLOR =  Colour.LIGHT_GREEN;//.SKY_BLUE;//VIOLET;
//		public static final jxl.format.Colour SRCS_COLOR =  jxl.format.Colour.LIGHT_TURQUOISE;
                public static final jxl.format.Colour GENERIC_QSTNS_COLOR =  Colour.WHITE;

		
                public static final String PLS_DONT_CHANGE_ROW_COL =  "Please dont change anything in this hidden column or row";
                
                public static final int NUM_EXTRA_SOURCES = 20;
                public static final int NUM_EXTRA_ANSWERS = 5;
                public static final String EXTRA_SRC_LABEL = "xtraSrc";
                
                // background colors for QuestionAnswerSetsDataSheet
                public static final Colour DUP_ANSID_QSTN_LBL = Colour.SKY_BLUE;
                public static final Colour DUP_ANSID_ANSVALUE_LBL = Colour.GRAY_25;
                public static final Colour DUP_ANSID_EXTRAANSVALUE_LBL = Colour.ROSE;
		
	}