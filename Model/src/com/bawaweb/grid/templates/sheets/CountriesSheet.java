/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.sheets;


import com.bawaweb.grid.templates.AnswersGridTemplateRangeConstants;
import com.bawaweb.grid.templates.data.ReportTemplateInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
/**
 * This class creates the 'Countries_Timezones' sheet.
 * <p>The contents are stored in the Named Ranges 'CountryNames'
 * <p> and 'TimeZones'
 * <p> Data from these ranges are used to populate the Country
 * <p> and the TimeZone drop-downs in the 'Source_Details' and 
 * <p> 'Extra Sources' sheets.
 * <p>The class may be renamed if desired
 */
public class CountriesSheet {


    private WritableSheet ss;
    private ReportTemplateInfo reportTemplateInfoDataSet;

    public CountriesSheet(WritableSheet s, ReportTemplateInfo ris) {
        this.ss = s;
        this.reportTemplateInfoDataSet = ris;
    }


    public WritableSheet createCountriesSheet() {
        Map<String, Integer> mp_countries = this.reportTemplateInfoDataSet.getCountriesMap();
        Set<String> theCountries = mp_countries.keySet();
        

        Map<String, Integer> mp_timeZones = this.reportTemplateInfoDataSet.getTimeZonesMap();
        Set<String> theTimeZones = mp_timeZones.keySet();
        
        // countrys
        int col = AnswersGridTemplateRangeConstants.RANGE_START_COUNTRIES_TOP_COL;
        int row = AnswersGridTemplateRangeConstants.RANGE_START_COUNTRIES_TOP_ROW;
        
        Label lbl;
        lbl = new Label(col, row-2, "COUNTRIES");
        try {
            this.ss.addCell( lbl );
        } catch (RowsExceededException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        }
        
//        String[] theC = (String[]) theCountries.toArray();
        List<String> theCList = new ArrayList<String>(theCountries);//Arrays.asList( theC );
        Collections.sort( theCList );
        
        for(Iterator<String> it = theCList.iterator(); it.hasNext(); row++) {
            String theCtry = it.next();
            lbl = new Label(col, row, theCtry);
            try {
                this.ss.addCell( lbl );
            } catch (RowsExceededException e) {
                e.printStackTrace();
            } catch (WriteException e) {
                e.printStackTrace();
            }
        }
        
        
        // timezones
         col = AnswersGridTemplateRangeConstants.RANGE_START_TIMEZONES_TOP_COL;
         row = AnswersGridTemplateRangeConstants.RANGE_START_TIMEZONES_TOP_ROW;
         
         lbl = new Label(col, row-2, "TIME ZONES");
         try {
             this.ss.addCell( lbl );
         } catch (RowsExceededException e) {
             e.printStackTrace();
         } catch (WriteException e) {
             e.printStackTrace();
         }
         
         for(Iterator<String> it = theTimeZones.iterator(); it.hasNext(); row++) {
             String theTimeZone = it.next();
             lbl = new Label(col, row, theTimeZone);
             try {
                 this.ss.addCell( lbl );
             } catch (RowsExceededException e) {
                 e.printStackTrace();
             } catch (WriteException e) {
                 e.printStackTrace();
             }
         }
        
        this.ss.getSettings().setProtected( true );
         
        return this.ss;
    }
}
