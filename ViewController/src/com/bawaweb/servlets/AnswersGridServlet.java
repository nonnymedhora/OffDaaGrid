/**
 * @author Nonny Medhora
 */
package com.bawaweb.servlets;

import com.bawaweb.grid.templates.AnswersGridTempInfo;
import com.bawaweb.grid.templates.AnswersGridTemplate;
import com.bawaweb.grid.templates.data.ReportTemplateInfo;
import com.bawaweb.grid.templates.sheets.ExtraSourcesSheet;
import com.bawaweb.grid.templates.sheets.QuestionAnswerSetsDataSheet;
import com.bawaweb.lifecycle.OtlTabLocksVO;
import com.bawaweb.services.PlatformAppModuleService;
import com.bawaweb.services.PlatformAppModuleServiceImpl;


import java.io.IOException;
import java.io.OutputStream;

import java.io.PrintWriter;

import java.sql.Timestamp;

import java.util.Calendar;

import java.util.Locale;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.WorkbookSettings;

import jxl.write.WritableWorkbook;

import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;

import org.apache.log4j.Logger;
/**
 * Generates the workbook
 */
public class AnswersGridServlet extends HttpServlet { 
    private static final String CONTENT_TYPE = "application/vnd.ms-excel";
    private static final Logger LOG = Logger.getLogger(AnswersGridServlet.class);
    
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
    
    public void doGet(HttpServletRequest request, 
                      HttpServletResponse response) throws ServletException, IOException {response.setContentType(CONTENT_TYPE);
        OutputStream out = null;
        String fileName = null;
        
        try {
            Locale preferredLocale = request.getLocale();
            String language = preferredLocale.getLanguage();
            String country = preferredLocale.getCountry();
            
            WorkbookSettings wbSettings = new WorkbookSettings();
            wbSettings.setLocale( preferredLocale );
            wbSettings.setExcelDisplayLanguage( language );
            wbSettings.setExcelRegionalSettings( country );
            
            int rprtId = Integer.parseInt( request.getParameter("rprtId") );
            int rprtrId = Integer.parseInt( request.getParameter("rprtrId") );
LOG.info("processing for report id " + rprtId + " for reporter " + rprtrId);            
            response.setContentType(CONTENT_TYPE);
            PlatformAppModuleService platform = PlatformAppModuleServiceImpl.getInstance(); //new PlatformAppModuleServiceImpl();//.getInstance();
            
            ReportTemplateInfo ris = platform.getReportInfo(rprtId, rprtrId);
            
            if ( ris == null ) {
                LOG.warn("The data existing for this report is incomplete " + rprtId);
                response.setContentType( "text/html; charset=windows-1252");
                PrintWriter pt = response.getWriter();
                exit(pt, "<font color='red'><b> The data existing for this report is incomplete " + rprtId + "</b></font>");
                return;
                
            }              
                fileName = rprtId + "_" + rprtrId + "_" + ris.getReportGeneralInfo().getReportDesc() + "_" + System.currentTimeMillis() + ".xls";
                fileName = fileName.replaceAll(" ", "_");
            
            
            response.setHeader("Content-Disposition", 
                               "attachment; filename=" + fileName);
                               
            
            out = response.getOutputStream();
            WritableWorkbook  ansGridWorkbook = Workbook.createWorkbook(response.getOutputStream(), wbSettings);
            
            AnswersGridTempInfo ansGridInfo = new AnswersGridTemplate(fileName, preferredLocale);
            ansGridInfo.setAnswersGridWorkbook( ansGridWorkbook );
            ansGridInfo.setReportTemplateInfoDataSet(ris);
            
            ansGridInfo.initializeSheets( ansGridWorkbook );
            
            ansGridInfo.createIntroDataSheet( ansGridWorkbook );
            ansGridInfo.createSourceDetailsDataSheet( ansGridWorkbook );
            ansGridInfo.createCountriesDataSheet( ansGridWorkbook );
            
            ExtraSourcesSheet extraSrcsSheet = ansGridInfo.createExtraSourcesDataSheet( ansGridWorkbook );
            QuestionAnswerSetsDataSheet extraQnsAnsSetsSheet = null; 
            if ( ris.getListOfQuestionsForAdditionalAnswers().size() > 0 ) {    
                extraQnsAnsSetsSheet = ansGridInfo.createExtraQuestionAnsDataSheet( ansGridWorkbook );
            }  
            
            ansGridInfo.createAnswerGridDataSheet(ansGridWorkbook, extraSrcsSheet, extraQnsAnsSetsSheet);
             
//            ansGridInfo.createSummaryDataSheet();
            
            addLockInfoToWorkbook(rprtId, rprtrId, platform, ansGridInfo);
LOG.info("AnswersGrid generated report id " + rprtId + " for reporter " + rprtrId);               
            
            ansGridInfo.end();
           
//            ansGridInfo.generateAnswersGridWorkBook( ansGridWorkbook );
   
        
            
            
            
            out.close();
            
        } catch (Exception e) {
            LOG.error("error in generating the spreadsheet\n" + e.getMessage(), e);
            return;//throw new ServletException("Exception in Excel Sample Servlet", e);
            // to do catch this
        } finally {
            if (out != null)
                out.close();
        }
        
    }


    private void exit(PrintWriter out) {
        out.println("</body></html>");
        out.close();
    }
        
    private void exit(PrintWriter out, String errMessage) {
        out.println("<br/><font color='red'>" + errMessage + "</font><br/>");
        out.println("</body></html>");
        out.close();
    }
    
    private void addLockInfoToWorkbook(int rprtId, int rprtrId, 
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

         LOG.info("AnswersGrid LOCK for  report id " + rprtId + " for reporter " + rprtrId + " is  --> " + otlId);        
    }
}
