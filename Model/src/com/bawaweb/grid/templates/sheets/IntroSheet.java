/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.sheets;

import com.bawaweb.grid.templates.AnswersGridTemplateRangeConstants;

import com.bawaweb.grid.templates.data.ReportTemplateInfo;

import com.bawaweb.grid.templates.data.cursors.EditorGeneralInfo;
import com.bawaweb.grid.templates.data.cursors.LeadReporterGeneralInfo;
import com.bawaweb.grid.templates.data.cursors.ReportGeneralInfo;

import com.bawaweb.grid.templates.data.cursors.ReporterGeneralInfo;

import com.bawaweb.services.PlatformAppModuleServiceImpl;

import com.bawaweb.services.PlatformApplicationConfig;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.VerticalAlignment;

import jxl.write.Blank;
import jxl.write.DateFormat;
import jxl.write.DateTime;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.NumberFormats;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
/**
 * Used to generate the first sheet in the answers grid workbook.
 * <p>it is title 'READ_THIS'
 * <p>It contains the basic general information of the report:
 *  <p>-   report id
 *  <p>-   reporter id
 *  <p>-   report type -- //if this is null then the application may be discontinued if desired
 *  <p>-   report due date 
 *  <p>-   reporter name
 *  <p>-   editor for the report
 *  <p>-   lead reporters for the report
 *  <p>-   url destination for uploading the report -- tweak this url later
 *  <p>-   number of sources
 *  <p>-   number of questions
 *  <p>
 *  <p>-- questions color legend
 *  <p>
 * <p>Note:-- The worksheet generated is subsequently used by the application
 * <p>to store the lock id information in the cell A65501
 * 
 * @see com.bawaweb.servlets.AnswersGridServlet
 */
public class IntroSheet {
	
        /** The Sheet containing the introductory data for the report */
	private WritableSheet ss;
        
        /** The ReportTemplate information for the particular report*/
        private ReportTemplateInfo reportTemplateInfoDataSet;
        
	/** Constructor.
         * @param s -- The WritableSheet which will form the worksheet 
         *      for the Introduction Sheet 'READ_THIS
         * @param ris -- The ReportTemplateInfo object containing all necessary information
         *      for the report
         */
        public IntroSheet(WritableSheet  s, ReportTemplateInfo ris) {
		this.ss = s;
                this.reportTemplateInfoDataSet = ris;
	}
	
        /**
         * Method that generates the Intro Sheet.
         * It is dependant on the reporttemplate info instance variable
         * instantiated by the ctor
         */
	public WritableSheet createIntroDataSheet() {
		int row = 0;
		int col = 0;
                ReportGeneralInfo reportInfo = this.reportTemplateInfoDataSet.getReportGeneralInfo();
                ReporterGeneralInfo reporterInfo = reportInfo.getReporterGeneralInfo();
                
                List<EditorGeneralInfo> edinfo = reportInfo.getTheEditorInfo();
                List<LeadReporterGeneralInfo> leadReportersInfo = reportInfo.getTheLeadReporterGeneralInfo();
		try {
			
//			WritableCellFormat boldRed = boldRedInYellow();
//			WritableCellFormat boldBlue = boldBlueInWhite();

                        Label lbl = new Label(col, row, "Report Id");
                        this.ss.addCell(lbl);
                        
                        lbl = new Label(col+1, row, String.valueOf(reportInfo.getReportId()));
                        this.ss.addCell(lbl);
                        
                        
                        row++;    
                        lbl = new Label(col, row, "Reporter Id");
                        this.ss.addCell(lbl);

		    System.out.println("rprtrId-createIntroDataSheet- is " + this.reportTemplateInfoDataSet);                             
                        lbl = new Label(col+1, row, String.valueOf(this.reportTemplateInfoDataSet.getReporterId()));
                        this.ss.addCell(lbl);
                        
                        
                        row++;    
                        lbl = new Label(col, row, "Report Type");
                        this.ss.addCell(lbl);                   
//                        lbl.setCellFormat(boldBlue);
                        
			lbl = new Label(col+1, row, reportInfo.getReportType());
			this.ss.addCell(lbl);			
//			lbl.setCellFormat(boldRed);	

                        row++;
                        lbl = new Label(col, row, "Report Name");
                        this.ss.addCell(lbl);                   
//                        lbl.setCellFormat(boldBlue);
                        
			lbl = new Label(col+1, row, reportInfo.getReportDesc());
			this.ss.addCell(lbl);			
//			lbl.setCellFormat(boldRed);	

                        row++;
                        lbl = new Label(col, row, "Report Due Date");
                        this.ss.addCell(lbl);                   
//                        lbl.setCellFormat(boldBlue);
                        
System.out.println("REPORTDUEDATE " + reportInfo.getReportDueDate());//.getYear() + "_" + reportInfo.getReportDueDate().getMonth() + "_"  + reportInfo.getReportDueDate().getDay()  );
                        if ( reportInfo.getReportDueDate() != null ) {
                            DateFormat df = new DateFormat("yyyy-MM-dd");       // "MM/dd/YYYY"
                            Calendar cal = Calendar.getInstance();
                            cal.setTime( reportInfo.getReportDueDate() );
                            Date d = cal.getTime();
                            WritableCellFormat cf = new WritableCellFormat(df);
                            
                            
                            DateTime dateLabel = new DateTime(col+1, row, d, cf);//new DateTime(col+1, row, new Date( reportInfo.getReportDueDate().getTime() ) );
                            this.ss.addCell(dateLabel);                   
    //                        dateLabel.setCellFormat(boldRed);
                        }

			row++;
                        lbl = new Label(col, row, "Reporter");
                        this.ss.addCell(lbl);                   
//                        lbl.setCellFormat(boldBlue);
                        
			lbl = new Label(col+1, row, reporterInfo.getFname() + " " + reporterInfo.getLname());
			this.ss.addCell(lbl);			
//			lbl.setCellFormat(boldRed);
                        
                        row++;
                        lbl = new Label(col, row, "Editor");
                        this.ss.addCell(lbl); 
                        EditorGeneralInfo edInfo = edinfo.get(0);
                        lbl = new Label(col+1, row, edInfo.getFname() + " " + edInfo.getLname());
                        this.ss.addCell(lbl);
                        
                        /********************** editor size is 1*******************
//                        lbl.setCellFormat(boldBlue);
System.out.println("EDITORS SIZE IS " + edinfo.size());
			for ( Iterator<EditorGeneralInfo> et = edinfo.iterator(); et.hasNext(); ) {
                            EditorGeneralInfo edInfo = et.next();
                            row++;			
                            lbl = new Label(col+1, row, edInfo.getFname() + " " + edInfo.getLname());
                            this.ss.addCell(lbl);			
//                            lbl.setCellFormat(boldRed);	
                        }

			********************** editor size is 1*******************/
			row++;		
                        

                        lbl = new Label(col, row, "Lead Reporters");
                        this.ss.addCell(lbl);                   
//                        lbl.setCellFormat(boldBlue);

			for ( Iterator<LeadReporterGeneralInfo> lt = leadReportersInfo.iterator(); lt.hasNext(); row++) {
                            LeadReporterGeneralInfo leadRepInfo = lt.next();
//  putting back on same line moved to last portion of the for loop
//                            row++;			
                            lbl = new Label(col+1, row, leadRepInfo.getFname() + " " + leadRepInfo.getLname());
                            this.ss.addCell(lbl);			
//                            lbl.setCellFormat(boldRed);	
                        }

			
			row++;	
                        PlatformApplicationConfig platformConfig = PlatformAppModuleServiceImpl.getInstance().getPlatformApplicationConfig();
                        String ansGridHref = platformConfig.getProperty("portal.answersgrid.base") + "?fnc_id="  + platformConfig.getProperty("portal.sourcedetails.functionid");
                        String repUrl = ansGridHref + "&rprt_id=" + reportInfo.getReportId();
                        String hyperUrl = "HYPERLINK(\"" + repUrl + "\", \"" + repUrl+ "\")";
                      System.out.println(hyperUrl);  
			Formula formula = new Formula(col, row, hyperUrl);
			this.ss.addCell(formula);
//			formula.setCellFormat(boldBlackInWhite());
/*			
			row+=10;
			lbl = new Label(col, row, "While you may have the capability to sort, filter and group as on the grid. ");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldRed);	
			
			row++;
			lbl = new Label(col, row, "Plese DO NOT CHANGE the file name to fool the portal.");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldRed);	
			
			

			row++;
			lbl = new Label(col, row, "If we detect this then we will start deleting files off your hard drive");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldRed);	
			
			

			row++;
			lbl = new Label(col, row, "If there are errors while saving your file you will be alerted. We will store the file and post process ourselves");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldRed);  

			row++;
			lbl = new Label(col, row, "For questions please don’t call…. Yada yada yada");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldRed);
*/			
			
			row++;
			lbl = new Label(col, row, "DETAILS");
			this.ss.addCell(lbl);			
//			lbl.setCellFormat(boldBlue);


			
			row++;
			lbl = new Label(col, row, "SOURCES");
			this.ss.addCell(lbl);			
//			lbl.setCellFormat(boldBlue);
			
			col++;
			lbl = new Label(col, row, String.valueOf(this.reportTemplateInfoDataSet.getListOfSources().size()));
			this.ss.addCell(lbl);			
//			lbl.setCellFormat(boldBlue);
			
			col--;
			row++;
			lbl = new Label(col, row, "QUESTIONS");
			this.ss.addCell(lbl);			
//			lbl.setCellFormat(boldBlue);
			
			col++;
			lbl = new Label(col, row, String.valueOf(this.reportTemplateInfoDataSet.getListOfQuestions().size()));
			this.ss.addCell(lbl);			
//			lbl.setCellFormat(boldBlue);
                        
                        
                        
                        
                        col = 0;
                        row = row + 10;
                        
                        buildQuestionInfoCells(this.ss, col, row);
                        
                        
                        this.ss.setColumnView(0, 25);
                        this.ss.setColumnView(1, 35);
			
			
		} catch (RowsExceededException e) {
                    e.printStackTrace();
		} catch (WriteException e) {
                    e.printStackTrace();
		}
                
                this.ss.getSettings().setProtected( true );
		
		return this.ss;
	}

    private void buildQuestionInfoCells(WritableSheet s, int col, int row) throws WriteException, 
                                                        RowsExceededException {
        final int start_col = col;
        
        Label qstnInfo = new Label(start_col, row, "QUESTION LEGEND");
        s.addCell( qstnInfo );
        
        row++;
        qstnInfo = new Label(start_col, row, "SORT");
        s.addCell( qstnInfo );
        
        col++;
        qstnInfo = new Label(col, row, "Sort Qn", FRMT_SORT_QSTN_ANSINFO_DATA_CELL);
        s.addCell( qstnInfo );
        
        col++;
        qstnInfo = new Label(col, row, "Choose from the drop-down options for the sorting criteria");
        s.addCell( qstnInfo );
        
        col = start_col;
        row++;
        
        qstnInfo = new Label(start_col, row, "WEIGHT");
        s.addCell( qstnInfo );
        
        col++;
        Blank empty = new Blank(col, row, FRMT_WGTD_QSTN_INFO_DATA_CELL);
        s.addCell( empty );
        
        col++;
        qstnInfo = new Label(col, row, "Enter numeric values for these questions");
        s.addCell( qstnInfo ); 
        
        col = start_col;
        row++;
        
        qstnInfo = new Label(start_col, row, "DATA");
        s.addCell( qstnInfo );
        
        col++;
        empty = new Blank(col, row, FRMT_NUMERIC_CELL);
        s.addCell( empty );
        
        col++;
        qstnInfo = new Label(col, row, "Data questions have two columns. EITHER enter in a numeric value in the first column");
        s.addCell( qstnInfo );
        row++;
        qstnInfo = new Label(col, row, "OR select an option from the drop-down in the second column");
        s.addCell( qstnInfo ); 
        
        col = start_col;
        row++;
        
        qstnInfo = new Label(start_col, row, "LIST");
        s.addCell( qstnInfo );
        
        col++;
        empty = new Blank(col, row, FRMT_SINGLE_ANS_DATA_CELL);
        s.addCell( empty );
        
        col++;
        qstnInfo = new Label(col, row, "Select an option from the drop-down for these questions");
        s.addCell( qstnInfo ); 
        
        col = start_col;
        row++;
        
        qstnInfo = new Label(start_col, row, "MULTI");
        s.addCell( qstnInfo );
        
        col++;
        empty = new Blank(col, row, FRMT_MULTI_QSTN_INFO_DATA_CELL);
        s.addCell( empty );
        
        col++;
        qstnInfo = new Label(col, row, "Multi Questions may have combinations of List or Data questions");
        s.addCell( qstnInfo );
        
        col = start_col;
        row += 2;
        qstnInfo = new Label(col, row, "A column for additional text is available for applicable questions.");
        s.addCell( qstnInfo );
    /**    
        row++;
        qstnInfo = new Label(col, row, "In these cells you may add free-flowing answer-text.");
        s.addCell( qstnInfo );
    **/    
        row++;
        qstnInfo = new Label(col, row, "Editorial Comments may be added using Excel's 'Insert Comment' feature in these cells");
        s.addCell( qstnInfo );
        
        row++;
        qstnInfo = new Label(col, row, "You can also add a background colour to these cells to be reflected in the Answers Grid.");
        s.addCell( qstnInfo );
        
        
        
        
    }
    
    private  WritableCellFormat _numericAnswerFormat() {
        WritableCellFormat decimalFormat = null;
        try {
            WritableFont normalFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD);
            decimalFormat = new WritableCellFormat(NumberFormats.DEFAULT);//FLOAT
            decimalFormat.setBackground(AnswersGridTemplateRangeConstants.NUMERIC_COLOR);
            decimalFormat.setFont(normalFont);
            
            /*decimalFormat.setBorder(Border.LEFT, BorderLineStyle.THIN);*/
            decimalFormat.setBorder(Border.TOP, BorderLineStyle.THIN);
            decimalFormat.setBorder(Border.BOTTOM, BorderLineStyle.THIN);
            decimalFormat.setBorder(Border.RIGHT, BorderLineStyle.THIN);
            decimalFormat.setWrap(true);
            decimalFormat.setAlignment(Alignment.CENTRE);
            decimalFormat.setVerticalAlignment(VerticalAlignment.TOP);
        } catch (WriteException e) { e.printStackTrace();  }
        return decimalFormat;
    }
    
    
    public  final WritableCellFormat FRMT_NUMERIC_CELL = _numericAnswerFormat();
    
    private  WritableCellFormat _wrapNormalAnswerFormat() {
        WritableCellFormat wrapNormalAnswerFormat = null;
        try {
            WritableFont normalFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD);
            wrapNormalAnswerFormat = new WritableCellFormat(normalFont);
            wrapNormalAnswerFormat.setBorder(Border.TOP, BorderLineStyle.THIN);
            wrapNormalAnswerFormat.setBorder(Border.BOTTOM, BorderLineStyle.THIN);
            wrapNormalAnswerFormat.setBorder(Border.LEFT, BorderLineStyle.THIN);
            wrapNormalAnswerFormat.setBorder(Border.RIGHT, BorderLineStyle.THIN); 
            wrapNormalAnswerFormat.setWrap(true);
            wrapNormalAnswerFormat.setAlignment(Alignment.CENTRE);
            wrapNormalAnswerFormat.setVerticalAlignment(VerticalAlignment.TOP);
            wrapNormalAnswerFormat.setLocked(true);
            wrapNormalAnswerFormat.setShrinkToFit(true);
        } catch (WriteException e) { e.printStackTrace();  }
        return wrapNormalAnswerFormat;
    }
    
    public final WritableCellFormat FRMT_WRAP_NORMAL_ANS_CELL = _wrapNormalAnswerFormat();
    
    
    
    private WritableCellFormat _wghtdQstnInfoDataCellFormat() {
        WritableCellFormat boldBlack = null;
        try {
            WritableFont boldBlackFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD);       
            boldBlackFont.setColour(AnswersGridTemplateRangeConstants.BLACK_COLOR);
            boldBlack = new WritableCellFormat(boldBlackFont, NumberFormats.DEFAULT);//FLOAT
            boldBlack.setBackground(AnswersGridTemplateRangeConstants.WGHTD_COLOR);
            boldBlack.setBorder(Border.TOP, BorderLineStyle.THIN);
            boldBlack.setBorder(Border.BOTTOM, BorderLineStyle.THIN);
            boldBlack.setBorder(Border.RIGHT, BorderLineStyle.THIN);
            boldBlack.setWrap(true);
            boldBlack.setAlignment(Alignment.CENTRE);
            boldBlack.setVerticalAlignment(VerticalAlignment.TOP);
            boldBlack.setLocked(true);
            boldBlack.setShrinkToFit(true);
        } catch (WriteException e) { e.printStackTrace(); }
        return boldBlack;
    }
    
    public final WritableCellFormat FRMT_WGTD_QSTN_INFO_DATA_CELL = _wghtdQstnInfoDataCellFormat();
    
    private WritableCellFormat _multiQstnInfoDataCellFormat() {
        WritableCellFormat boldBlack = null;
        try {
            WritableFont boldBlackFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD);       
            boldBlackFont.setColour(AnswersGridTemplateRangeConstants.BLACK_COLOR);
            boldBlack = new WritableCellFormat(boldBlackFont);
            boldBlack.setBackground(AnswersGridTemplateRangeConstants.MULTI_COLOR);
            boldBlack.setBorder(Border.TOP, BorderLineStyle.THIN);
            boldBlack.setBorder(Border.BOTTOM, BorderLineStyle.THIN);
            boldBlack.setBorder(Border.RIGHT, BorderLineStyle.THIN);
            boldBlack.setWrap(true);
            boldBlack.setAlignment(Alignment.CENTRE);
            boldBlack.setVerticalAlignment(VerticalAlignment.TOP);       //JUSTIFY);
            boldBlack.setLocked(true);
            boldBlack.setShrinkToFit(true);
        } catch (WriteException e) { e.printStackTrace(); }
        return boldBlack;
    }
    
    public final WritableCellFormat FRMT_MULTI_QSTN_INFO_DATA_CELL = _multiQstnInfoDataCellFormat();
    
    
    private WritableCellFormat _singleAnsDataCellFormat() {
        WritableCellFormat singleAnsCellFormat = null;
        try {
            WritableFont singleAnsFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD);       
            singleAnsFont.setColour(AnswersGridTemplateRangeConstants.BLACK_COLOR);
            singleAnsCellFormat = new WritableCellFormat(singleAnsFont);
            singleAnsCellFormat.setBackground(AnswersGridTemplateRangeConstants.SINGLE_COLOR);
            singleAnsCellFormat.setWrap(true);
            singleAnsCellFormat.setBorder(Border.TOP, BorderLineStyle.THIN);
            singleAnsCellFormat.setBorder(Border.BOTTOM, BorderLineStyle.THIN);
            singleAnsCellFormat.setBorder(Border.RIGHT, BorderLineStyle.THIN);
            singleAnsCellFormat.setAlignment(Alignment.CENTRE);
            singleAnsCellFormat.setVerticalAlignment(VerticalAlignment.TOP);       //JUSTIFY);
            singleAnsCellFormat.setLocked(true);
            singleAnsCellFormat.setShrinkToFit(true);
        } catch (WriteException e) { e.printStackTrace(); }
        return singleAnsCellFormat;
    }
    
    
    public final WritableCellFormat FRMT_SINGLE_ANS_DATA_CELL = _singleAnsDataCellFormat();
    
    
    
    
    private  WritableCellFormat _sortedQstnAnsInfoDataCellFormat() {
        WritableCellFormat boldBlue = null;
        try {
            WritableFont boldBlueFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD);       
            boldBlueFont.setColour(AnswersGridTemplateRangeConstants.BLUE_COLOR);
            boldBlue = new WritableCellFormat(boldBlueFont);
            boldBlue.setBackground(AnswersGridTemplateRangeConstants.SORT_COLOR);
            boldBlue.setBorder(Border.TOP, BorderLineStyle.THIN);
            boldBlue.setBorder(Border.BOTTOM, BorderLineStyle.THIN);
            boldBlue.setBorder(Border.RIGHT, BorderLineStyle.THIN);
            boldBlue.setWrap(true);
            boldBlue.setAlignment(Alignment.CENTRE);
            boldBlue.setVerticalAlignment(VerticalAlignment.TOP);       //JUSTIFY);
            boldBlue.setLocked(true);
            boldBlue.setShrinkToFit(true);
        } catch (WriteException e) { e.printStackTrace(); }
        return boldBlue;
    }
    
    public  final WritableCellFormat FRMT_SORT_QSTN_ANSINFO_DATA_CELL = _sortedQstnAnsInfoDataCellFormat();
    
    

}
