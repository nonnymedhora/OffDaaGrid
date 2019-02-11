/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.sheets;

import com.bawaweb.grid.templates.AnswersGridTemplateRangeConstants;

import com.bawaweb.grid.templates.data.ReportTemplateInfo;

import java.util.Arrays;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import java.util.Set;

import jxl.CellView;

import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.VerticalAlignment;

import jxl.write.Blank;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.NumberFormats;
import jxl.write.WritableCellFeatures;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.log4j.Logger;

/**
 * Generates the 'Extra Sources' Sheet.
 */
public class ExtraSourcesSheet {

    private static final Logger LOG = Logger.getLogger(ExtraSourcesSheet.class);

    private WritableSheet ss;
    private ReportTemplateInfo reportTemplateInfoDataSet;
    /**
     * Constructor -- generates the 'Extra Sources' sheet given the sheet reference to write to and the 
     * ReportTemplateInfo object containing the report info data
     * @param s -- the sheet to write to
     * @param ris   -- the report info
     */
    public ExtraSourcesSheet(WritableSheet  s, ReportTemplateInfo ris) {
            this.ss = s;
            this.reportTemplateInfoDataSet = ris;
    }
    
    private WritableCellFormat boldRedInYellow() throws WriteException {
            WritableFont boldRedFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD); 	
            boldRedFont.setColour(AnswersGridTemplateRangeConstants.RED_COLOR);
            WritableCellFormat boldRed = new WritableCellFormat(boldRedFont);
            boldRed.setBackground(AnswersGridTemplateRangeConstants.YELLOW_COLOR);
            boldRed.setLocked(false);
            return boldRed;
    }
    
    private WritableCellFormat boldBlackInWhite() throws WriteException {
            WritableFont boldRedFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD); 	
            boldRedFont.setColour(AnswersGridTemplateRangeConstants.BLACK_COLOR);
            WritableCellFormat boldRed = new WritableCellFormat(boldRedFont);
            boldRed.setBackground(AnswersGridTemplateRangeConstants.WHITE_COLOR);
            boldRed.setLocked(false);
            return boldRed;
    }
    
    
    private WritableCellFormat boldBlueInWhite() throws WriteException {
            WritableFont boldRedFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD); 	
            boldRedFont.setColour(AnswersGridTemplateRangeConstants.BLUE_COLOR);
            WritableCellFormat boldRed = new WritableCellFormat(boldRedFont);
            boldRed.setBackground(AnswersGridTemplateRangeConstants.WHITE_COLOR);
            boldRed.setLocked(false);
            return boldRed;
    }
        
    
    private  WritableCellFormat _numericAnswerFormat() {
        WritableCellFormat decimalFormat = null;
        try {
            WritableFont normalFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD);
            decimalFormat = new WritableCellFormat(NumberFormats.DEFAULT);
            decimalFormat.setBackground(AnswersGridTemplateRangeConstants.NUMERIC_COLOR);
            decimalFormat.setFont(normalFont);
            decimalFormat.setBorder(Border.TOP, BorderLineStyle.THIN);
            decimalFormat.setBorder(Border.BOTTOM, BorderLineStyle.THIN);
            decimalFormat.setBorder(Border.RIGHT, BorderLineStyle.THIN);
            decimalFormat.setWrap(true);
            decimalFormat.setAlignment(Alignment.CENTRE);
            decimalFormat.setVerticalAlignment(VerticalAlignment.TOP);
        } catch (WriteException e) { e.printStackTrace(); LOG.error("error in creating _numericAnswerFormat"); }
        return decimalFormat;
    }
    
    
    public final WritableCellFormat FRMT_NUMERIC_CELL = _numericAnswerFormat();
    
    private final WritableCellFeatures getCourtesyFeatures(ReportTemplateInfo reportTemplateInfo) {
        WritableCellFeatures wcf = new WritableCellFeatures();
        List<String> theCourtesyTitles = reportTemplateInfo.getCourtesyTitles();
        wcf.setDataValidationList( theCourtesyTitles );
        return wcf;
    }
    
    private final WritableCellFeatures getSuffixFeatures(ReportTemplateInfo reportTemplateInfo) {
        WritableCellFeatures wcf = new WritableCellFeatures();
        List<String> theSuffixTitles = reportTemplateInfo.getSuffixTitles();
        wcf.setDataValidationList( theSuffixTitles );
        return wcf;
    }
    
    private final WritableCellFeatures getCountryFeatures() {
         WritableCellFeatures wcf = new WritableCellFeatures();
         wcf.setDataValidationRange(AnswersGridTemplateRangeConstants.RANGE_NAME_COUNTRIES);
         return wcf;
    }
    private final WritableCellFeatures COUNTRY_FEATURES = getCountryFeatures();
    
    
    private final WritableCellFeatures getTimeZoneFeatures() {
        WritableCellFeatures wcf = new WritableCellFeatures();
        wcf.setDataValidationRange(AnswersGridTemplateRangeConstants.RANGE_NAME_TIMEZONES);
        return wcf;
    }
    private final WritableCellFeatures TIMEZONE_FEATURES = getTimeZoneFeatures();
     
    private final WritableCellFeatures getStatusFeatures() {
        WritableCellFeatures wcf = new WritableCellFeatures();
        final String[] statuses = new String[] { "ACTIVE", "INACTIVE" };
        List<String> thestatuses = Arrays.asList( statuses );
        wcf.setDataValidationList( thestatuses );
        return wcf;
    }
    public final WritableCellFeatures STATUS_FEATURES = getStatusFeatures();
    
    private final WritableCellFeatures getYNFeatures() {
        WritableCellFeatures wcf = new WritableCellFeatures();
        final String[] ynS = new String[] { "No", "Yes" };
        List<String> ynList = Arrays.asList( ynS );
        wcf.setDataValidationList( ynList );
        return wcf;
    }
    public final WritableCellFeatures YN_FEATURES = getYNFeatures();
    
    private final WritableCellFeatures getIndustryViewFeatures(ReportTemplateInfo reportInfo) {
        WritableCellFeatures wcf = new WritableCellFeatures();
        Map<String, String> mp_IndView = reportInfo.getIndustryViewsMap();
        Set<String> indDescs = mp_IndView.keySet();
        wcf.setDataValidationList( indDescs );
        return wcf;
    }
    
    private final WritableCellFeatures getQualityRatingsFeatures(ReportTemplateInfo reportInfo) {
        WritableCellFeatures wcf = new WritableCellFeatures();
        Map<String, String> mp_QltyRatingsView = reportInfo.getQualityRatingsMap();
        Set<String> qltyRatingsDescs = mp_QltyRatingsView.keySet();
        wcf.setDataValidationList( qltyRatingsDescs );
        return wcf;
    }
    
    private final WritableCellFeatures getSourceDistributionPreferencesFeatures(ReportTemplateInfo reportInfo) {
        WritableCellFeatures wcf = new WritableCellFeatures();
        Map<String, String> srcDistPrefMap = reportInfo.getSourceDistributionPreferencesMap();
        Set<String> srcDistPrefDesc = srcDistPrefMap.keySet();
        wcf.setDataValidationList( srcDistPrefDesc );
        return wcf;
    }
    
    

    
    private static final String EXTRA_SRC_LABEL = AnswersGridTemplateRangeConstants.EXTRA_SRC_LABEL;

    /**
     * generates the extra sources sheet
     * @return ss -- the extra sources sheet with its contents filled in
     */
    public WritableSheet createExtraSourcesSheet() {
            int col = 1;
            int row = 1;
                        
            try {
            
                WritableCellFormat boldRed = boldRedInYellow();
                WritableCellFormat boldBlue = boldBlueInWhite();
                WritableCellFormat boldBlack = boldBlackInWhite();
                
                Label lbl = new Label(col, row, "Use this worksheet to add in the details for extra sources" );
                this.ss.addCell(lbl);			
                lbl.setCellFormat(boldRed);
                
                col = AnswersGridTemplateRangeConstants.RANGE_EXTRA_SOURCEFIELDS_TOP_COL;
                row = AnswersGridTemplateRangeConstants.RANGE_EXTRA_SOURCEFIELDS_TOP_ROW;
                
                // first col will store internal labels
                col++;
                
                lbl = new Label(col, row, processStringForWrap("Seq", col) );
                this.ss.addCell(lbl);			
                lbl.setCellFormat(boldBlack);
                
                col++;
                lbl = new Label(col, row, processStringForWrap("Courtesy Title", col));
                this.ss.addCell(lbl);			
                lbl.setCellFormat(boldBlack);
                
                col++;
                lbl = new Label(col, row, processStringForWrap("First Name", col));
                this.ss.addCell(lbl);			
                lbl.setCellFormat(boldBlack);
                
                col++;
                lbl = new Label(col, row, processStringForWrap("Last Name", col));
                this.ss.addCell(lbl);			
                lbl.setCellFormat(boldBlack);
                
                col++;
                lbl = new Label(col, row, processStringForWrap("Suffix", col) );
                this.ss.addCell(lbl);			
                lbl.setCellFormat(boldBlack);
                
                col++;
                lbl = new Label(col, row, processStringForWrap("Phone*", col) );
                this.ss.addCell(lbl);			
                lbl.setCellFormat(boldBlack);
                
                col++;
                lbl = new Label(col, row, processStringForWrap("Extension", col) );
                this.ss.addCell(lbl);			
                lbl.setCellFormat(boldBlack);
                
                col++;
                lbl = new Label(col, row, processStringForWrap("Company*", col) );
                this.ss.addCell(lbl);			
                lbl.setCellFormat(boldBlack);
                
                col++;
                lbl = new Label(col, row, processStringForWrap("Job Title", col) );
                this.ss.addCell(lbl);			
                lbl.setCellFormat(boldBlack);
                
                col++;
                lbl = new Label(col, row, processStringForWrap("Distribution Preference", col) );
                this.ss.addCell(lbl);			
                lbl.setCellFormat(boldBlack);
                
                col++;
                lbl = new Label(col, row, processStringForWrap("Email", col) );
                this.ss.addCell(lbl);			
                lbl.setCellFormat(boldBlack);
                
                col++;
                lbl = new Label(col, row, processStringForWrap("CellPhone", col) );
                this.ss.addCell(lbl);			
                lbl.setCellFormat(boldBlack);
                
                col++;
                lbl = new Label(col, row, processStringForWrap("Fax", col) );
                this.ss.addCell(lbl);			
                lbl.setCellFormat(boldBlack);
                
                col++;
                lbl = new Label(col, row, processStringForWrap("Address", col) );
                this.ss.addCell(lbl);			
                lbl.setCellFormat(boldBlack);
                
                col++;
                lbl = new Label(col, row, processStringForWrap("Address 2", col) );
                this.ss.addCell(lbl);			
                lbl.setCellFormat(boldBlack);
                
                col++;
                lbl = new Label(col, row, processStringForWrap("Address 3", col) );
                this.ss.addCell(lbl);			
                lbl.setCellFormat(boldBlack);
                
                col++;
                lbl = new Label(col, row, processStringForWrap("Country*", col) );
                this.ss.addCell(lbl);			
                lbl.setCellFormat(boldBlack);
                
                col++;
                lbl = new Label(col, row, processStringForWrap("City*", col) );
                this.ss.addCell(lbl);			
                lbl.setCellFormat(boldBlack);
                
                col++;
                lbl = new Label(col, row, processStringForWrap("State", col) );
                this.ss.addCell(lbl);			
                lbl.setCellFormat(boldBlack);
                
                col++;
                lbl = new Label(col, row, processStringForWrap("Zip", col) );
                this.ss.addCell(lbl);			
                lbl.setCellFormat(boldBlack);
                
                col++;
                lbl = new Label(col, row, processStringForWrap("Timezone", col) );
                this.ss.addCell(lbl);			
                lbl.setCellFormat(boldBlack);
                
                col++;
                lbl = new Label(col, row, processStringForWrap("Job Description", col) );
                this.ss.addCell(lbl);			
                lbl.setCellFormat(boldBlack);
                
                col++;
                lbl = new Label(col, row, processStringForWrap("Company Type", col) );
                this.ss.addCell(lbl);			
                lbl.setCellFormat(boldBlack);
                
                col++;
                lbl = new Label(col, row, processStringForWrap("Company Size", col) );
                this.ss.addCell(lbl);			
                lbl.setCellFormat(boldBlack);
                
                col++;
                lbl = new Label(col, row, processStringForWrap("Industry View", col) );
                this.ss.addCell(lbl);			
                lbl.setCellFormat(boldBlack);
                
                col++;
                lbl = new Label(col, row, processStringForWrap("Industry Sector", col) );
                this.ss.addCell(lbl);			
                lbl.setCellFormat(boldBlack);
                
                col++;
                lbl = new Label(col, row, processStringForWrap("Quality Rating", col) );
                this.ss.addCell(lbl);			
                lbl.setCellFormat(boldBlack);
                
                col++;
                lbl = new Label(col, row, processStringForWrap("Exclusive Source", col) );
                this.ss.addCell(lbl);			
                lbl.setCellFormat(boldBlack);
                
                col++;
                lbl = new Label(col, row, processStringForWrap("Don't Contact", col) );
                this.ss.addCell(lbl);			
                lbl.setCellFormat(boldBlack);
   
                col++;
                lbl = new Label(col, row, processStringForWrap("Area of Expertise", col) );
                this.ss.addCell(lbl);			
                lbl.setCellFormat(boldBlack);
                
                col++;
                lbl = new Label(col, row, processStringForWrap("Vendors", col) );
                this.ss.addCell(lbl);			
                lbl.setCellFormat(boldBlack);
                
                col++;
                lbl = new Label(col, row, processStringForWrap("Notes", col) );
                this.ss.addCell(lbl);			
                lbl.setCellFormat(boldBlack);

                col++;
                lbl = new Label(col, row, processStringForWrap("Distribution Notes", col) );
                this.ss.addCell(lbl);			
                lbl.setCellFormat(boldBlack);
                
                col++;
                lbl = new Label( col, row, processStringForWrap("Offered Report", col));
                this.ss.addCell(lbl);
                lbl.setCellFormat(boldBlack);
                
                col++;
                lbl = new Label( col, row, processStringForWrap("Informed of Website", col));
                this.ss.addCell(lbl);
                lbl.setCellFormat(boldBlack);
                
                
                col = AnswersGridTemplateRangeConstants.RANGE_EXTRA_SOURCEFIELDS_TOP_COL;
                row = AnswersGridTemplateRangeConstants.RANGE_EXTRA_SOURCEFIELDS_TOP_ROW + 1;

                int seqNo = 1;
                Number nm;
                Blank aBlank;
                
                for ( int i = 0; i < AnswersGridTemplateRangeConstants.NUM_EXTRA_SOURCES; i++,row++,seqNo++) {
                    col = AnswersGridTemplateRangeConstants.RANGE_EXTRA_SOURCEFIELDS_TOP_COL;
                    
                    // internal label
                     Label xtraSrcLabel = new Label( col, row, EXTRA_SRC_LABEL + "_" + (i+1)  );
                     
                     CellView hideView = new CellView();
                     hideView.setHidden(true);
                     this.ss.addCell( xtraSrcLabel );
                     this.ss.setColumnView(col, hideView);
                     
                     col++;
                    
                    // seq
                    nm = new Number( col, row, seqNo );
                    this.ss.addCell( nm );
                    
                    // ctsy title
                    col++;
                    aBlank = new Blank(col, row);                    
                    aBlank.setCellFeatures( getCourtesyFeatures( this.reportTemplateInfoDataSet ) );
                    this.ss.addCell( aBlank );

                    // blank for first name
                    col++;
                    
                    // blank for last_name
                    col++;
                    
                    // suffix title
                    col++;
                    aBlank = new Blank(col, row);
                    aBlank.setCellFeatures( getSuffixFeatures( this.reportTemplateInfoDataSet ) );
                    this.ss.addCell( aBlank );
                    
                    // blank for phone
                    col++;
                    
                    // blank for phone extn
                    col++;
   
                    // blank for company
                    col++;
                    
                    // blank for job title
                    col++; 
                    
                    // distribution prefs
                    col++;
                    Label distPrefLbl = new Label(col, row, "Email");
                    distPrefLbl.setCellFeatures( getSourceDistributionPreferencesFeatures( this.reportTemplateInfoDataSet ) );
                    this.ss.addCell( distPrefLbl );
                    
                    // blank for email
                    col++;
                    
                    // blank for cell phone
                    col++;
                    
                    // blank for fax
                    col++;
                    
                    // blank for address
                    col++;
                    
                    // blank for address2
                    col++;
                    
                    // blank for address3
                    col++;
                    
                    // country
                    col++;
                    aBlank = new Blank(col, row);
                    aBlank.setCellFeatures( getCountryFeatures() );
                    this.ss.addCell( aBlank );
                    
                    // blank for city
                    col++;
                    
                    // blank for state
                    col++;
                    
                    // blank for zip
                    col++;
                    
                    // timezone
                    col++;
                    aBlank = new Blank(col, row);
                    aBlank.setCellFeatures( getTimeZoneFeatures() ); 
                    this.ss.addCell( aBlank );     
                    
                    // blank or job description
                    col++;
                    
                    // blank for company type
                    col++;
                    
                    // blank for compny size
                    col++;
                    
                    // industry view 
                    col++;
                    Map<String, String> mp_IndView = this.reportTemplateInfoDataSet.getIndustryViewsMap();
                    Set<String> indDescs = mp_IndView.keySet();
                    String[] indVieVals = indDescs.toArray(new String[indDescs.size()]);
                    Label indViewLbl = new Label( col, row, indVieVals[0] );
                    indViewLbl.setCellFeatures( getIndustryViewFeatures( this.reportTemplateInfoDataSet ) );
                    this.ss.addCell( indViewLbl );
                    
                    // blank for industry sector
                    col++;
                                        
                    // quality rating 
                    col++;
                    Map<String, String> mp_QltyRatingsView = this.reportTemplateInfoDataSet.getQualityRatingsMap();
                    Set<String> qltyRatingsDescs = mp_QltyRatingsView.keySet();
                    String[] qltyRatingsVals = qltyRatingsDescs.toArray(new String[indDescs.size()]);
                    Label qltyRatingsLbl = new Label( col, row, qltyRatingsVals[0] );
                    qltyRatingsLbl.setCellFeatures( getQualityRatingsFeatures( this.reportTemplateInfoDataSet ) );
                    this.ss.addCell( qltyRatingsLbl );
                    
                    // blank for exclusive src -- with checkbox y/n
                    col++;
                    Label ynLbl = new Label( col, row, "No" );
                    ynLbl.setCellFeatures( getYNFeatures() );
                    this.ss.addCell( ynLbl );
                    
                    // blank for dont contact is checkbox put in y/n
                    col++;
                    ynLbl = new Label( col, row, "No" );
                    ynLbl.setCellFeatures( getYNFeatures() );
                    this.ss.addCell( ynLbl );
                    
                    
                    /**  
                    blanks for area of expertise, vendors, notes,distin notes, offered copy
                    **/  
                    // area of exp
                    col++;  
                      
                    // vendors
                    col++;
                      
                    // notes
                    col++;
                      
                    // distn notes
                    col++;
                      
                    // offered copy
                    col++;
                    ynLbl = new Label( col, row, "No" );
                    ynLbl.setCellFeatures( getYNFeatures() );
                    this.ss.addCell( ynLbl );
                      
                    // informed of website
                    col++;
                    ynLbl = new Label( col, row, "No" );
                    ynLbl.setCellFeatures( getYNFeatures() );
                    this.ss.addCell( ynLbl );
                    
                    
                }
                    
                    
            } catch (RowsExceededException e) {
                    e.printStackTrace();
            } catch (WriteException e) {
                    e.printStackTrace();
            }	
            
            
            this.ss.getSettings().setHorizontalFreeze(5);//(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_COL);
            this.ss.getSettings().setVerticalFreeze(5);//(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW);
        
            formatColumns();

            this.ss.getSettings().setZoomFactor(75);
            
            // hide first column
            return this.ss;
    }
	
    private Map<Integer, Integer> hsh_maxColumnWidth = new Hashtable<Integer, Integer>();
    // sets the max length of the string in a col to the colwidth hash hsh_maxColumnWidth
    // and then returns the string.
    // the createAnswersGridSheet will call the formatColumns method which will
    // use the values off the hsh_maxColumnWidth to set the column's width
    private String processStringForWrap(String text, int col) {
    
    if ( text == null ) { System.out.println("ex___processStringForWrap --- text is null for col " + col); }
    else { System.out.println("ex___processStringForWrap text is -->" + text + "<-- col is " + col); }
        int existingMax = this.hsh_maxColumnWidth.get(col) != null ? this.hsh_maxColumnWidth.get(col) : 0;
System.out.println("existingMax is " + existingMax);        
        if ( text != null ) {
            if ( text.length() > existingMax ) {
System.out.println("Adding to hash  [col " + col + "]  length " + text.length());            
                this.hsh_maxColumnWidth.put(col, text.length());
            }
        }
System.out.println("returninng txt " + text);

        return text != null ? text : "";
    }

    public void setSs(WritableSheet ss) {
        this.ss = ss;
    }

    public WritableSheet getSs() {
        return ss;
    }

    public void setReportTemplateInfoDataSet(ReportTemplateInfo reportTemplateInfoDataSet) {
        this.reportTemplateInfoDataSet = reportTemplateInfoDataSet;
    }

    public ReportTemplateInfo getReportTemplateInfoDataSet() {
        return reportTemplateInfoDataSet;
    }
    
    private void formatColumns() {
        Set<Integer> cols = this.hsh_maxColumnWidth.keySet();
System.out.println("ex__hash size " + this.hsh_maxColumnWidth.size());
        for( Iterator<Integer> it = cols.iterator(); it.hasNext(); ) {
            int thecol = it.next();
            int maxLength = this.hsh_maxColumnWidth.get(thecol);
System.out.println("thecol is " + thecol + " maxlength is " + maxLength);            
            int width = 0;
            if ( maxLength != 0 ) {
System.out.println("maxLength is not 0");            
                if ( maxLength <= 10 ) width = 15;
                else if ( maxLength > 10 && maxLength <= 15 ) width = 25;   //50
                else if ( maxLength > 15 && maxLength <= 20 ) width = 30;  //50 300
                else if ( maxLength > 20 ) width = 35;
            }
System.out.println("ex__setting col " + thecol + " with " + width);
            this.ss.setColumnView( thecol, width);
        }
    }

    
}
