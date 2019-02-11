/**
 * @author Nonny Medhora
 */
package com.bawaweb.services;

import com.bawaweb.grid.templates.AnswersGridTempInfo;
import com.bawaweb.grid.templates.AnswersGridTemplate;
import com.bawaweb.grid.templates.data.ReportTemplateInfo;

import com.bawaweb.grid.templates.sheets.ExtraSourcesSheet;
import com.bawaweb.grid.templates.sheets.QuestionAnswerSetsDataSheet;
import com.bawaweb.lifecycle.OtlTabLocksVO;

import java.sql.Timestamp;

import java.util.Calendar;

import java.util.Locale;

import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;

public class PlatformAppModuleServiceDriver {

    

    public static void main(String[] args) {
        
        long rightNowNanoTime = System.nanoTime();
        /**
        int rprtId = 77507;//89520;//87493;//77507;//89014;//87493;//90056;//87493;
        int rprtrId = 2045;//56053;//30181;// 30181 is mh for 87493// 56053;//  RK is 56053, nm is 54054;
        **/
        // 77507 --- 2045
        // 89520 -- 56053
        
        int rprtId = 90724;//88791;//90724;//91025;//89087;//90908;//87288;//88902;//91019;//90894;// 84273 -- no report type id;//90930;//91250 -- dupl rasid;//90961;//87493;//90961;//91237;//90961;//91250;//91237;//91250;//91027;// 91250;//77507;//89574;//77507;//80230;
        int rprtrId = 54054;//2045;//32394;//54054;//;//54054;//2045;//40221;//2045;//12056;
        generateAnswersGridWorkBook(rprtId, rprtrId);
         
         // create the lock info
         
        System.out.println("Done");
        long endNowNanoTime = System.nanoTime();
        System.out.println("Duration nanoseconds " + (endNowNanoTime - rightNowNanoTime));
        System.out.println("Duration Seconds " +  ((endNowNanoTime - rightNowNanoTime)/(.000000001)));
        System.exit(0);
    }

    private static void generateAnswersGridWorkBook(int rprtId, int rprtrId) {
        PlatformAppModuleService platform = PlatformAppModuleServiceImpl.getInstance();
        
        System.out.println( platform.getDBInstance() );
        
        ReportTemplateInfo ris = platform.getReportInfo(rprtId, rprtrId);
        if ( ris == null ) {
            System.err.println("RIS is null for " + rprtId);
            return;
        }
        System.out.println("rprtrId is " + ris.getReporterId());
        //        ReportTemplateInfo ris = platform.getReportInfo(89861, 14265);
        //        ReportTemplateInfo ris = platform.getReportInfo(86340, 54054);  // nasty 1
        //        ReportTemplateInfo ris = platform.getReportInfo(90055, 54054); // test qmq_hints
        //System.out.println("SourceAnswers\n_______________\n" + ris.getListOfSourceAnswers());
        
         Locale locale = Locale.getDefault();
        AnswersGridTempInfo ansGridInfo = new AnswersGridTemplate(locale);
        ansGridInfo.setReportTemplateInfoDataSet(ris);
        
        WritableWorkbook  ansGridWorkbook = ansGridInfo.getAnswersGridWorkbook();
        
        
//        ansGridInfo.setAnswersGridWorkbook( ansGridWorkbook );
        
        /*ansGridInfo.generateAnswersGridWorkBook( ansGridWorkbook );*/

//        moved into generateAnswersGridWorkBook        
        ansGridInfo.initializeSheets( ansGridWorkbook );
        
        ansGridInfo.createIntroDataSheet( ansGridWorkbook );
        ansGridInfo.createSourceDetailsDataSheet( ansGridWorkbook );
        ansGridInfo.createCountriesDataSheet( ansGridWorkbook );
        /********* rem for v1, put back in for v2 ******************/
        ExtraSourcesSheet extraSrcsSheet = ansGridInfo.createExtraSourcesDataSheet( ansGridWorkbook );
        QuestionAnswerSetsDataSheet extraQnsAnsSetsSheet = null; 
        if ( ris.getListOfQuestionsForAdditionalAnswers().size() > 0 ) {    
            extraQnsAnsSetsSheet = ansGridInfo.createExtraQuestionAnsDataSheet( ansGridWorkbook );
        }  
         /********* ends rem for v1, put back in for v2 ******************/
        ansGridInfo.createAnswerGridDataSheet(ansGridWorkbook, extraSrcsSheet, extraQnsAnsSetsSheet);
        
        ansGridInfo.createSummaryDataSheet();
//        moved into generateAnswersGridWorkBook
        
        addLockInfoToWorkbook(rprtId, rprtrId, platform, ansGridInfo);
System.out.println("calling end");

        ansGridInfo.end();
    }

    private static void addLockInfoToWorkbook(int rprtId, int rprtrId, 
                                              PlatformAppModuleService platform, 
                                              AnswersGridTempInfo ansGridInfo) {
        OtlTabLocksVO theLock = new OtlTabLocksVO();
        
        theLock.setOtlEmplId( String.valueOf ( rprtrId) );
        theLock.setOtlCreatedDt( new Date( new Timestamp(Calendar.getInstance().getTimeInMillis())));        
        theLock.setOtlStatus(PlatformAppModuleService.PENDING_STATUS);
        theLock.setOtlTabName("RPRT_REPORTS");
        theLock.setOtlTabId(new Number(rprtId));
        
         OtlTabLocksVO theNewLock = platform.create( theLock );
         System.out.println("\n*******************\nCOMMITTING LOCKS\n***********");          
         platform.commitAll();
        
        System.out.println("newlock\n" + theNewLock);
        int otlId = theNewLock.getOtlId().intValue();
        ansGridInfo.addOtlLock(otlId);
    }
}
