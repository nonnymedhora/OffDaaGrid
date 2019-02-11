package com.bawaweb.grid.templates.reader;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import jxl.Workbook;

import com.bawaweb.grid.templates.data.ReportTemplateInfo;
import com.bawaweb.grid.templates.data.ReportTemplateInfoDataSet;
import com.bawaweb.grid.templates.data.cursors.QuestionDataSetInfo;
import com.bawaweb.grid.templates.data.cursors.SourceAnswersDataSet;
import com.bawaweb.grid.templates.data.cursors.SourceAnswersDataSetInfo;
import com.bawaweb.grid.templates.data.tables.AnswerSetValuesDataSetInfo;
import com.bawaweb.grid.templates.data.tables.ReportAnswerSetValuesDataSetInfo;
import com.bawaweb.grid.templates.data.tables.SourceDataSet;
import com.bawaweb.grid.templates.data.tables.SourceDataSetInfo;
import com.bawaweb.grid.templates.sheets.AnswersGridSheetReader;
import com.bawaweb.grid.templates.sheets.AnswersGridSheetReaderImpl;

import com.bawaweb.grid.templates.sheets.ExtraAnswerSetsSheetReader;
import com.bawaweb.grid.templates.sheets.ExtraAnswerSetsSheetReaderImpl;
import com.bawaweb.grid.templates.sheets.ExtraSourceSheetReader;
import com.bawaweb.grid.templates.sheets.ExtraSourceSheetReaderImpl;
import com.bawaweb.lifecycle.OtlTabLocksVO;

import com.bawaweb.lifecycle.SourcesAnswerInfoVO;
import com.bawaweb.services.PlatformAppModuleService;
import com.bawaweb.services.PlatformAppModuleServiceImpl;

import com.bawaweb.utils.Pair;

import com.bawaweb.utils.Triplet;

import java.awt.BorderLayout;

import java.io.File;

import java.io.PrintStream;

import java.io.PrintWriter;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import java.util.Locale;
import java.util.Map;

import java.util.Set;

import javax.servlet.ServletException;

import jxl.Workbook;
import jxl.CellType;
import jxl.Sheet;

import oracle.jbo.ApplicationModule;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;

import org.apache.log4j.Logger;

public class V2TestAnswersSheetReader {

    public final static int REPORTER_ID = 2045;//54054;
    private static final Logger LOG = Logger.getLogger(V2TestAnswersSheetReader.class);
    public static final  String EXCEL_FILE = "C:\\jdevstudio10132\\jdev\\mywork\\PlatformBAwaWEb\\Model\\dist\\1v2test_all.xls"; 
    //v2.getTheFile();//"\\\\san-sv-filer\\nmedhora$\\my documents\\jxlTesting\\test_latest.xls";
        
    private ReportTemplateInfo existingReportTemplate;      // built through cursors - existing
    private ReportTemplateInfo reportInfo;                  // built from the spreadsheet
    
    public static void main(String[] args) throws Exception {
         System.out.println("START  ==> " + Calendar.getInstance().getTime());
        PlatformAppModuleService platform = PlatformAppModuleServiceImpl.getInstance();
        V2TestAnswersSheetReader v2 = new V2TestAnswersSheetReader();
       
                int reportId = 0;
                int reporterId = 0;
        boolean isRolledBack = false;            
        AnswersGridSheetReader reader = AnswersGridSheetReaderImpl.getInstance();
        File theFile = new File(EXCEL_FILE);
        reader.setTheFile(theFile);
        PrintStream pt = System.out;
        OtlTabLocksVO theLockInfo = null;
        Locale locale = Locale.getDefault(); //request.getLocale();
        Workbook w = null;
         

        
        try { 
        
            w = reader.extractWorkbook(new File(EXCEL_FILE));
        
            reportId = reader.getReportId(w);
            reporterId = reader.getReporterId(w);
            if ( reportId == 0 ) { 
                LOG.error("Invalid report id - 0" ); 
                v2.exit(pt); 
                return;
            }
            
            reporterId = reader.getReporterId(w);        
            if ( reporterId == 0 ) { 
                LOG.error("Invalid reporter id - 0" ); 
                v2.exit(pt); 
                return; 
            }
            
                
            LOG.info("reporter id is " + reporterId + " and report id is " + reportId);            
            Sheet answersSheet = reader.extractAnswersSheet(w);
            Sheet introSheet = reader.extractIntroSheet(w);
            Sheet extraSourcesSheet = reader.extractExtraSourcesSheet(w);            
            Sheet extraQuestionAnswersSheet = reader.extractExtraQuestionAnswersSheet(w);
            
            boolean hasPostedEarlier = false;
            int lockId = 0;
            
            theLockInfo = v2.processLockInfo(introSheet,theLockInfo, reportId, reporterId, platform, pt ); //lockId, 
            boolean isLockingOk = ( theLockInfo == null ) ? false : true;
            if ( !isLockingOk ) { 
                return;
            }
            
            
            // first add in the extra source info
            ExtraSourceSheetReader xtraSrcSheetReader = new ExtraSourceSheetReaderImpl(extraSourcesSheet, reportId, reporterId );
            List<SourceDataSetInfo> extraSources = xtraSrcSheetReader.getExtraSources(  extraSourcesSheet );
            
            
        
            Map<Integer, Integer> mp_extraRepSrcIdSrcId = null;
            Map<Integer, SourceDataSetInfo> mp_internalsrcid_src = null;
            List<SourceDataSetInfo> xtraNewSrcs = null;
            List<SourceDataSetInfo> xtraRepSrcs = null;
            Map<Integer, SourceDataSetInfo> mp_extraRpsIdSrcDataInfo = null;
            
            if ( extraSources.size() > 0 ) {
                
                xtraSrcSheetReader.processExtraSources( extraSources );
                mp_extraRepSrcIdSrcId = xtraSrcSheetReader.getMp_extraRepSrcIdSrcId();
                
                
                xtraNewSrcs = xtraSrcSheetReader.getLi_newSrcs();
                xtraRepSrcs = xtraSrcSheetReader.getLi_newRepSrcs();
                mp_internalsrcid_src = xtraSrcSheetReader.getMp_internalsrcid_src();
    System.out.println("1   mp_internalsrcid_src is " + mp_internalsrcid_src);            
                LOG.info("printing MAP mp_internalsrcid_src");
                xtraSrcSheetReader.printMap(mp_internalsrcid_src);
                LOG.info("printing xtraSrcSheetReader.getAll_errors()");
                xtraSrcSheetReader.printList( xtraSrcSheetReader.getAll_errors() );
                
                mp_internalsrcid_src = platform.addExtraSources( xtraNewSrcs, xtraRepSrcs, mp_internalsrcid_src );//extraSources, xtraRepSrcs, mp_internalsrcid_src );
                
                try {
                   platform.commitAll();
                } catch ( Exception e) {
                    LOG.error("Error in updating REPORT SOURCES", e);
                    platform.rollbackAll();
                    pt.println("<font color='red'>Error in updating REPORT SOURCES........... exiting!!!</font>");
                    pt.println("</body></html>");
                    pt.close();
                    return;
                }
                
                mp_extraRpsIdSrcDataInfo = xtraSrcSheetReader.getRpsSourceDataMap(xtraNewSrcs, xtraRepSrcs );
                
                
            }
            
            // these are for new report-sources [but existing sources ]
            if ( xtraSrcSheetReader.getLi_warnings().size() >  0 ) {
                for ( String warning : xtraSrcSheetReader.getLi_warnings() ) {
                    pt.println( warning + "<br/>");
                }
            }
            
            
            // then add in extra answer-sets info
            ExtraAnswerSetsSheetReader xtraAnsSetsSheetReader = new ExtraAnswerSetsSheetReaderImpl(extraQuestionAnswersSheet, reportId, reporterId );
            Map<Integer, List<ReportAnswerSetValuesDataSetInfo>> mp_qstnId_rprtAnsSetValues = platform.getExtraQuestionsReportAnswerSetValuesMap(reportId);
            LOG.info("mp_qstnId_rprtAnsSetValues is size " + mp_qstnId_rprtAnsSetValues.size());
            System.out.println("mp_qstnId_rprtAnsSetValues is size " + mp_qstnId_rprtAnsSetValues.size());
            v2.printMap( mp_qstnId_rprtAnsSetValues );
            
            
            if ( mp_qstnId_rprtAnsSetValues.size() > 0 ) {
                
                Map<Integer, List<AnswerSetValuesDataSetInfo>>   mp_qstnId_ansSetValues =  platform.getExtraQuestionsAnswerSetValuesMap(reportId);
                LOG.info("mp_qstnId_ansSetValues is size " + mp_qstnId_ansSetValues.size());
                System.out.println("mp_qstnId_ansSetValues is size " + mp_qstnId_ansSetValues.size());
                v2.printMap( mp_qstnId_ansSetValues );
                
                List<QuestionDataSetInfo> li_extraQuestions = xtraAnsSetsSheetReader.getExtraQuestions(extraQuestionAnswersSheet, reportId, mp_qstnId_rprtAnsSetValues );
                xtraAnsSetsSheetReader.addExtraAnswerSetValues( li_extraQuestions, mp_qstnId_ansSetValues, mp_qstnId_rprtAnsSetValues, platform );
                
                try {
                   platform.commitAll();
                } catch ( Exception e) {
                    LOG.error("Error in updating ANSWER VALUES", e);
                    platform.rollbackAll();
                    pt.println("<font color='red'>Error in updating ANSWER VALUES........... exiting!!!</font>");
                    pt.println("</body></html>");
                    pt.close();
                    return;
                }
                
            
            }
System.out.println("ENDS EXTRA ANS ADDED 2");  
LOG.info("ENDS EXTRA ANS ADDED 2");
            if ( xtraAnsSetsSheetReader.getLi_warnings().size() >  0 ) {
                for ( String warning : xtraAnsSetsSheetReader.getLi_warnings() ) {
                    pt.println( warning + "<br/>");
                }
            }
            
            
            
            
            
            
            
            

            // start processing the answers grid sheet by
            // start with null ReportTemplateInfo and build up
            ReportTemplateInfo reportInfo = new ReportTemplateInfoDataSet();
            if ( reportId != 0 ) reportInfo.setReportId(reportId);
            else {
                pt.println("<font color='red'>ReportId was invalid as 0</font>");
                pt.println("</body></html>");
                pt.close();
                return;
            }
            reader.setReportInfo(reportInfo);
            
            
            
            // read answers sheet
System.out.println("mp_internalsrcid_srcis " + mp_internalsrcid_src);            
            List<Integer>   li_repSourceIds                 = reader.extractTheReportSourceInfo(answersSheet, mp_internalsrcid_src);
            Map<Integer, Integer>   mp_repSrcIdRows         = reader.getMp_RepSourceIds_Rows();
            List<String>    li_questionIds                  = reader.extractTheQuestionsInfo(answersSheet);
            
            List<Integer>   li_repSrcIds                    = reader.getLi_RepSourceIds();     // maybe redundant -- sourceids
            List<String>    li_qstnids                      = reader.getLi_questionInfos();    // maybe redundant -- questionIds
            Map<Integer, Integer>   mp_qstnIdCol            = reader.getMp_QuestionId_Col();
            
            Map<String, Integer>    mp_qstnTagCol           = reader.getMp_QuestionTag_Col();
            List<String>            li_qstnTags             = reader.getLi_QuestionTags();
            //            List<String>            li_srcNames             = reader.extractSourceNames(answersSheet, mp_repSrcIdRows);
            
            int start_col   = reader.getStart_ans_col();
            int start_row   = reader.getStart_ans_row();
            int end_col     = reader.getEnd_ans_col();
            int end_row     = reader.getEnd_ans_row();
            
            Map<Integer, Integer> mp_qstnHintCol                = reader.getMp_QuestionHint_Col();
            List li_baseQuestionIds = v2.extractKeysList(mp_qstnIdCol);
            
            ReportTemplateInfo existingReportTemplate   = reader.buildExistingReportTemplate(reportId, reporterId);
            LinkedHashMap<Integer, QuestionDataSetInfo> existingQstns       = existingReportTemplate.getQuestionsDataSetMap();
            Map<Pair, Integer>                mpExisting_QstIdQmqNum_QmqId  = reader.getQstIdQmqNum_QmqIdMap( existingQstns );//( existingQstns );
System.out.println("mpE_qstIdQmqNum__Qmqid is ______________\n" + mpExisting_QstIdQmqNum_QmqId + "\n____________\n");            
            LinkedHashMap<Integer, SourceDataSetInfo>   existingSrcs        = existingReportTemplate.getSourcesDataSetMap();
            List<String>                                existingQstnTags    = existingReportTemplate.buildQuestionTags();
            List<SourceAnswersDataSetInfo>              existingSrcAnswers  = existingReportTemplate.getListOfSourceAnswers();
            Map<String, String>                         existingQtypeMap    = existingReportTemplate.buildQuestionTypeMap();
            reader.printMap(existingQtypeMap);
            List<Integer>                               existingRepSrcIds      = existingReportTemplate.getLi_RepSourceIds();
            List<Integer>                               existingQuestionIds = existingReportTemplate.getLi_questionIds();
            List<String>                                existingSrcNames    = existingReportTemplate.getLi_SourceNames();
            Map<Integer, Integer>                         existingRepSrcIdSrcIdMap = existingReportTemplate.getMap_RepSrcId_SrcId();
            LOG.info("existingRepSrcIdSrcIdMap size is " + existingRepSrcIdSrcIdMap.size() + " and the map is");
            reader.printMap( existingRepSrcIdSrcIdMap );
            Map<String, Integer>                        existingRprtInit_RprtIdMap = existingReportTemplate.buildRprtrInit_RprtrIdMap();
            
            //            boolean allSrcsOk       = reader.compareLists(existingRepSrcIds, li_repSrcIds);
            boolean allQstnIdsOk    = reader.compareLists(existingQuestionIds, li_baseQuestionIds);
            boolean allQstnTagsOk   = reader.compareLists(existingQstnTags, li_qstnTags);
            //            boolean allSrcNamesOk   = reader.compareLists(existingSrcNames, li_srcNames);
            
            pt.println("existingRepSrcIds sz " + existingRepSrcIds.size());
            pt.println("li_repSrcIds sz " + li_repSrcIds.size());
            
            //            pt.println("<br/>**** all Sources Ok " + allSrcsOk);
            //            LOG.info(" **** all Sources Ok " + allSrcsOk);
            //            if (!allSrcsOk) {
            //                LOG.info("existingRepSrcIds:");
            //                printLogList(LOG, existingRepSrcIds, "ERROR");
            //                LOG.info("li_repSrcIds:");
            //                printLogList(LOG, li_repSrcIds, "ERROR");
            //            }
                
            pt.println("<br/>**** all QstnIds Ok " + allQstnIdsOk);   
            LOG.info(" **** all QstnIds Ok " + allQstnIdsOk); 
            if (!allQstnIdsOk) { 
                LOG.info("<br>***existingQstnIds<p>"); 
                v2.printLogList(LOG, existingQuestionIds, "ERROR"); 
                LOG.info("<br>***li_baseQuestionIds<p>"); 
                v2.printLogList(LOG, li_baseQuestionIds, "ERROR"); 
                
                pt.println("<br>***existingQstnIds\n");
                pt.println(existingQuestionIds);
                
                pt.println("<br>***li_baseQuestionIds\n");
                pt.println(li_baseQuestionIds);
            }
            
            pt.println("<br/>**** all Qstn Tags Ok " + allQstnTagsOk);   
            LOG.info(" **** all Qstn Tags Ok " + allQstnTagsOk); 
            if (!allQstnTagsOk) { 
                LOG.info("<br>***existingQstnTags<p>"); 
                v2.printLogList(LOG, existingQstnTags, "ERROR"); 
                LOG.info("<br>***li_qstnTags<p>"); 
                v2.printLogList(LOG, li_qstnTags, "ERROR"); 
            }
            /**
            pt.println("<br/>**** all Source NamesOk " + allSrcNamesOk);   
            LOG.info(" **** all Source NamesOk " + allSrcNamesOk); 
            if (!allSrcNamesOk) { pt.println("<br>***existingSrcNames<p>"); printList(out, existingSrcNames); pt.println("<br>***li_srcNames<p>"); printList(out, li_srcNames); }
            
            //System.pt.println("\n***existingSrcNames");reader.printList(existingSrcNames);System.pt.println("\n***li_srcNames");reader.printList(li_srcNames);
            **/
            boolean isValid = /*allSrcsOk && */allQstnIdsOk && allQstnTagsOk;// && allSrcNamesOk;
            pt.println("<br/>****isValid " + isValid);   LOG.info("****isValid " + isValid);
            
            List<Integer> allSrcIds = new ArrayList<Integer>();
            Map<Integer, SourceDataSetInfo> allSrcsMap = new HashMap<Integer, SourceDataSetInfo>();
            
            //xtraNewSrcs, xtraRepSrcs, existingSrcs
            Collection<SourceDataSetInfo> theExistingSRcs = existingSrcs.values();
            for ( SourceDataSetInfo s : theExistingSRcs ) {
                int srcId = s.getSrc_id();
                if ( !allSrcIds.contains( srcId ) ) {
                    allSrcIds.add( srcId );
                    allSrcsMap.put( srcId, s);
                }
            }
            if ( xtraNewSrcs != null ) {
                for ( SourceDataSetInfo s : xtraNewSrcs ) {
                    int srcId = s.getSrc_id();
                    if ( !allSrcIds.contains( srcId ) ) {
                        allSrcIds.add( srcId );
                        allSrcsMap.put( srcId, s);
                    }
                }
                for ( SourceDataSetInfo s : xtraRepSrcs ) {
                    int srcId = s.getSrc_id();
                    if ( !allSrcIds.contains( srcId ) ) {
                        allSrcIds.add( srcId );
                        allSrcsMap.put( srcId, s);
                    }
                }
                
            }
            for ( Integer srcId : allSrcIds ) {
                if ( !platform.checkSourceLocation( srcId ) ) {
                    String warning = "<br>SRC_NAME_INFO with src id " + srcId + " has an invalid location entered please correct it <a target='_blank' href='http://portaldev.bawaweb.com/portal/page/portal/BaWaWEB/BAwaWEb_SOURCES_PAGE?fnc_id=20&rprt_id=" +  reportId + "&src_id=SRC_ID'>here</a>";
                    LOG.warn( warning );
                    SourceDataSetInfo s = allSrcsMap.get( srcId );
                    String srcNameInfo = s.getSrc_first_name() + " " + s.getSrc_last_name();
                    warning = warning.replaceAll("SRC_NAME_INFO", srcNameInfo );
                    warning = warning.replaceAll("SRC_ID", String.valueOf( srcId ) );
                    
                    pt.println( warning + "<br/>");
                }
            }
            
            
            if (!isValid) {
                pt.println("<p><b><font color='red'>We found inconsistencies in the table data which are preventing the import from completing</font></b></p>");
                
                /***********************
                // upload the file to the error tables
                platform.uploadAnswerGridErrorFile(w, reportId, reporterId);

                *************************/
                theLockInfo.setOtlStatus( PlatformAppModuleService.PENDING_STATUS);
                platform.update( theLockInfo );
                platform.commitAll();
                
            //                pt.println("<p><font color='red' face='bold'>AAAA We encountered validation errors but we have stored your file for investigating -- sorry </font>");
                pt.println("</body></html>");
                pt.close();
                return; 
                
            } else {    // huge else here for valid--- ends at end of method way bl
                // get and set the locking
                 existingReportTemplate.buildLocks();
                 
                 Set<Integer> set_existingReportAnswerSetValuesLocks        = existingReportTemplate.getSetOfReportAnswerSetValuesLocks();
                 Set<Integer> set_existingSourceAnswersLocks                = existingReportTemplate.getSetOfSourceAnswersLocks();
                 Set<Integer> set_existingSortingCriteriaValueLocks         = existingReportTemplate.getSetOfSortingCriteriaValueLocks();
                 Set<Integer> set_existingSourceSortingCriteriaLocks        = existingReportTemplate.getSetOfSourceSortingCriteriaLocks();
               
               
                 
                 
            LOG.info("mp_extraRepSrcIdSrcId is--> " + mp_extraRepSrcIdSrcId);
System.out.println("mp_extraRepSrcIdSrcId is--> " + mp_extraRepSrcIdSrcId + "\nSTARTING CALL TO buildSourceInfo");
                List<SourceDataSetInfo> sources = reader.buildSourceInfo(answersSheet, 
                                                                          //  existingSrcs, 
                                                                            existingRepSrcIdSrcIdMap, 
                                                                            existingRprtInit_RprtIdMap,
                                                                            mp_extraRepSrcIdSrcId,
                                                                            mp_extraRpsIdSrcDataInfo
                                                                            );
                
                
                Map<Pair<Integer, Integer>,Pair<Integer, Integer>> mp_existingRpsQstToSraRavMap = new HashMap<Pair<Integer, Integer>, Pair<Integer, Integer>>();    
                Map<Triplet<Integer, Integer, Integer>,Pair<Integer, Integer>> mp_existingRpsQstToSraRav_QMQMap = new HashMap<Triplet<Integer, Integer, Integer>, Pair<Integer, Integer>>();
                Map<Pair<Integer, Integer>, Pair<Integer, Integer>> mp_existingRpsQstToSortAnsMap  = new HashMap<Pair<Integer, Integer>, Pair<Integer, Integer>>();
System.out.println("STARTING CALL TO setUpExistingIDMaps");                
                v2.setUpExistingIDMaps(    existingSrcAnswers, 
                                        mp_existingRpsQstToSraRavMap, 
                                        mp_existingRpsQstToSraRav_QMQMap, 
                                        mp_existingRpsQstToSortAnsMap);
            //                Map<Integer, SourceDataSetInfo> mp_internalsrcid_src = null;

System.out.println("STARTING CALL TO buildSourceAnswersList");
                List<SourceAnswersDataSetInfo> srcAnswers =  reader.buildSourceAnswersList(answersSheet, 
                                                                                            existingQstns, 
                                                                                            existingRepSrcIdSrcIdMap, 
                                                                                            mp_internalsrcid_src,
                                                                                            mp_extraRepSrcIdSrcId,
                                                                                            mp_qstnId_rprtAnsSetValues);


            LOG.info("reader.getAll_errors().size() is " + reader.getAll_errors().size());
                if ( reader.getAll_errors().size() > 0 ) {
                    pt.println("<br/><font color='red' face='bold'>ERRORS</font><br/>");
                    v2.printList(pt, reader.getLi_errors());
                    
                    // flush out the errors
                    reader.flushErrors();
                    
                    /******************************
                     * 
                    // upload the file to the error tables
                    platform.uploadAnswerGridErrorFile(w, reportId, reporterId);
                ************************************/
                
                    theLockInfo.setOtlStatus( PlatformAppModuleService.PENDING_STATUS);
                    platform.update( theLockInfo );
                    platform.commitAll();
                    
                    pt.println("<font color='red' face='bold'>We encountered validation errors but we have stored your file for investigating -- sorry </font>");
                    pt.println("</body></html>");
                    pt.close();
                    return; 
                    
                } else if ( reader.getAll_errors().size() == 0 ) {
                    
                    if ( sources.size() > 0 ) {
                        platform.updateRepeatSourceData( sources, reportId, reporterId );
                    }
                    
                    List<SourceAnswersDataSetInfo> updateableSrcAnswers = new ArrayList<SourceAnswersDataSetInfo>();
                    List<SourceAnswersDataSetInfo> insertableSrcAnswers = new ArrayList<SourceAnswersDataSetInfo>();
                    
                    
                    v2.buildSrcAnswersForDML(  set_existingReportAnswerSetValuesLocks, 
                                            set_existingSourceAnswersLocks, 
                                            set_existingSortingCriteriaValueLocks, 
                                            set_existingSourceSortingCriteriaLocks, 
                                            mp_existingRpsQstToSraRavMap, 
                                            mp_existingRpsQstToSraRav_QMQMap, 
                                            mp_existingRpsQstToSortAnsMap, 
                                            srcAnswers, 
                                            updateableSrcAnswers, 
                                            insertableSrcAnswers);
                        
System.out.println("updateableSrcAnswers size si " + updateableSrcAnswers.size() );
System.out.println("insertableSrcAnswers size si " + insertableSrcAnswers.size() );

                    List<SourceAnswersDataSetInfo> li_xtraSrcsInsertableAnswers = v2.getListOfExtraSourcesInsertableAnswers( insertableSrcAnswers, xtraNewSrcs );
                    pt.println( "li_xtraSrcsInsertableAnswers is _____\n" + li_xtraSrcsInsertableAnswers + "\\n________*_*_*_\n");
                   if (! v2.postSourceAnswers(  pt, 
                                        platform, 
                                        isRolledBack, 
            //                                        hasPostedEarlier,
                                        theLockInfo, 
                                        updateableSrcAnswers, 
                                        insertableSrcAnswers,
                                        mpExisting_QstIdQmqNum_QmqId) ) {
                       if ( theLockInfo != null ) {
                           theLockInfo.setOtlStatus(PlatformAppModuleService.PENDING_STATUS);
                           platform.update( theLockInfo );
                           platform.commitAll();
                       }                    
                        // upload the file to the error tables
                        platform.uploadAnswerGridErrorFile(w, reportId, reporterId);
                        pt.println("<font color='red' face='bold'>We could not update the information to the database but we have stored your file for investigating -- sorry </font>");
                        pt.println("</body></html>");
                        pt.close();
                        return; 
                   }
                    
                }   // if reader.getAll_errors().size() == 0
            
            } // ends else for isValid
            
                pt.println("</body></html>");
                pt.close();
            
            } // ends try
            catch (Exception e) {
            platform.rollbackAll();
            
            e.printStackTrace();
            LOG.error("error occurred in big try-catch",e);
            if ( w != null && reportId != 0 && reporterId != 0) {
                    platform.uploadAnswerGridErrorFile(w, reportId, reporterId);                        
                    pt.println("<font color='red' face='bold'>We couldn't update the information to the database but we have stored your file for investigating -- sorry about that </font>");
                    pt.println("</body></html>");
                    pt.close();
            } else {
                pt.println("<font color='red' face='bold'>An unknown error occured during the process -- sorry </font>");
                pt.println("</body></html>");
                pt.close();
            }
            
            if ( theLockInfo != null ) {
                theLockInfo.setOtlStatus(PlatformAppModuleService.PENDING_STATUS);
                platform.update( theLockInfo );
                platform.commitAll();
            }
                
            }
            
            System.out.println("END ==> " + Calendar.getInstance().getTime());
    }
    

        
        
        private List extractKeysList(final Map aMap) {
            List aList = null;
            if ( aMap != null && aMap.size() != 0) {
                aList = new ArrayList();
                
                Set aSet = aMap.keySet();
                for( Iterator it =  aSet.iterator(); it.hasNext(); ) {
                    aList.add( it.next() );
                }
            }
            
            return aList;
        }
        
        private void printList(PrintStream pt, List aList) {
        
            for (Iterator it = aList.iterator(); it.hasNext(); ) {
                pt.println("<p>|" + it.next()+ "|</p>" );
            }
        }
        
        private void printList(PrintStream pt, List aList, String style) {
            if ( style == null ) {
                printList( pt, aList );
                return;
            }
            boolean isErrorStyle = false;
            if ( style.equalsIgnoreCase("ERROR") ) {
                isErrorStyle = true;
            }
            for (Iterator it = aList.iterator(); it.hasNext(); ) {
                String formStyle = isErrorStyle ? "<font color='red'>" : "";
                String endFormStyle = isErrorStyle ? "</font>" : "";
                String line = "<p>|" + formStyle + it.next()+ endFormStyle + "|</p>" ;
                pt.println( line );
            }
        }
        
        
        
        private void printLogList(Logger LOG, List aList, String level) {
            boolean isError = false;
            if ( level == null || level.equalsIgnoreCase("ERROR") ) {
                isError = true;
            }
            for (Iterator it = aList.iterator(); it.hasNext(); ) {
                if (isError) {
                    LOG.info("|" + it.next()+ "|" );
                } else {
                    LOG.info("|" + it.next()+ "|" );
                }
            }
        }
        
        
    //
    //        
    //    private void printList(PrintWriter out, List<Integer> aList) {
    //        for (Iterator<Integer> it = aList.iterator(); it.hasNext(); ) {
    //            pt.println("<p>" + it.next()+ "</p>" );
    //        }
    //    }
    //    
    //    
    //    
    //
    //    
    //    private void printList(PrintWriter out, List<Integer> aList) {
    //        for (Iterator<Integer> it = aList.iterator(); it.hasNext(); ) {
    //            pt.println("<p>" + it.next()+ "</p>" );
    //        }
    //    }

        private OtlTabLocksVO processLockInfo(Sheet introSheet,// int lockId, 
                                        OtlTabLocksVO theLockInfo, int reportId, 
                                        int reporterId, 
                                        PlatformAppModuleService platform, PrintStream pt) {
            try {
                int lockId = 0;
                if (introSheet.getCell(0, 65500) != null && introSheet.getCell(0, 65500).getType().equals(CellType.EMPTY) ) {
                    lockId = 0;
                    theLockInfo = null;
                } else {
                    if (!introSheet.getCell(0, 65500).getType().equals(CellType.EMPTY)) {
                        lockId =  Integer.parseInt( introSheet.getCell(0, 65500).getContents() );
                        theLockInfo = platform.getLockInfo(lockId, reportId, reporterId);
                    }
                }
                if ( theLockInfo == null || lockId <= 0) {
                    pt.println("<p><b><font color='red'>There seems to be a piece of logging data missing from this excel file</font></b></p>");
                    LOG.error("Error no lock exists" );              
                    
                    pt.println("</body></html>");
                    pt.close();
                    return null;//false;
                }
                String status = theLockInfo.getOtlStatus();
                if ( status.equalsIgnoreCase(PlatformAppModuleService.STALE_STATUS) ) { 
                    pt.println("<p><b><font color='red'>Error status " + status + ".....exiting!!!</font></b></p>");
                    LOG.error("Error status " + status );              
                    
                    pt.println("</body></html>");
                    pt.close();
                    return null;//false;
                }
    //            removed fn
    //            if ( status.equalsIgnoreCase(PlatformAppModuleService.POSTED_STATUS) ) {
    //                hasPostedEarlier = true;
    //            }
    //              removed fn

                if ( platform.isReportLocked( reportId ) ) {
                    pt.println("<p><b><font color='red'>Error report is locked by another user for reportid " + reportId + ".....exiting!!!   Try again in a few minutes</font></b></p>");
                    LOG.error("Error report is locked by another user for reportid " + reportId);              
                    
                    pt.println("</body></html>");
                    pt.close();
                    return null;//false;
                }
                    
                // change to inprocess
                 theLockInfo.setOtlStatus(PlatformAppModuleService.IN_PROCESS_STATUS);
                 boolean isLockUpdated = platform.update( theLockInfo );
                 
                 if ( ! isLockUpdated ) {
                     pt.println("<p><b><font color='red'>We had a problem updating our logging data</font></b></p>");
                     LOG.error("Error in updating lock to IN_PROCESS_STATUS for lockid " + theLockInfo.getOtlId() );
                     
                       
                     pt.println("</body></html>");
                     pt.close();
                     return null;//false;
                 }
                 
                 try {
                    platform.commitAll();
                 } catch ( Exception e) {
                     e.printStackTrace();
                     LOG.error("Error in updating lock COMMIT to IN_PROCESS_STATUS for lockid " + theLockInfo.getOtlId() );                 
                     platform.rollbackAll();
    //                 isRolledBack = true;
                     pt.println("<p><b><font color='red'>Error in updating lock to IN_PROCESS_STATUS to database ........... exiting!!!</font></b></p>");              
                    
                     pt.println("</body></html>");
                     pt.close();
                     return null;//false;
                 }
                    
                // set up the collector name variable
                String rptrId = theLockInfo.getOtlEmplId();
    //check
    if( Integer.parseInt( rptrId ) != reporterId ) 
    LOG.warn( "AHAAAAH rporterid is " + reporterId + " and from the lockinfo rptrId is " + rptrId);
                try {
                    platform.setCollectorName( rptrId );
                    return theLockInfo;
                } catch (Exception e) {
                    LOG.error("Could not set the user-in-session name", e);
                    
                    platform.rollbackAll();
                    
                    theLockInfo.setOtlStatus(PlatformAppModuleService.PENDING_STATUS);
                    platform.update( theLockInfo );
                    platform.commitAll();              
                    
                    pt.println("</body></html>");
                    pt.close();
                    return null;//false;
                }
                
                    
            
            } catch (NumberFormatException e) {
                e.printStackTrace();
                LOG.error("NumberFormatExcepion for getting lockinfo ", e );
                pt.println("<p><b><font color='red'>There seems to be a piece of logging data missing from this excel file</font></b></p>");
                pt.println("</body></html>");
                pt.close();
                return null;//false;
            } catch (Exception e) {
                e.printStackTrace();
                LOG.error("Excepion for getting lockinfo ", e );
                pt.println("<p><b><font color='red'>Error in finding lock and status.....exiting!!! There seems to be a piece of logging data missing from this excel file</font></b></p>");
                pt.println("</body></html>");
                pt.close();
                return null;//false; 
            }
                                                
        }
                 
         public void printMap(Map aMap) {
             if ( aMap == null ) { LOG.info("amap is null"); return; }
             Set aSet = aMap.keySet();
             for ( Iterator it = aSet.iterator(); it.hasNext(); ) {
                 Object key = it.next();
                 LOG.info(key + " ==> " + aMap.get(key));
             }
         }

        private void exit(PrintStream pt) {
            pt.println("</body></html>");
            pt.close();
        }
        

        private void exit(PrintStream pt, String errMessage) {
            pt.println("<br/><font color='red'>" + errMessage + "</font><br/>");
            pt.println("</body></html>");
            pt.close();
        }
        
    private void buildSrcAnswersForDML(Set<Integer> set_existingReportAnswerSetValuesLocks, 
                                       Set<Integer> set_existingSourceAnswersLocks, 
                                       Set<Integer> set_existingSortingCriteriaValueLocks, 
                                       Set<Integer> set_existingSourceSortingCriteriaLocks, 
                                       Map<Pair<Integer, Integer>, Pair<Integer, Integer>> mp_existingRpsQstToSraRavMap, 
                                       Map<Triplet<Integer, Integer, Integer>, Pair<Integer, Integer>> mp_existingRpsQstToSraRav_QMQMap, 
                                       Map<Pair<Integer, Integer>, Pair<Integer, Integer>> mp_existingRpsQstToSortAnsMap, 
                                       List<SourceAnswersDataSetInfo> srcAnswers, 
                                       List<SourceAnswersDataSetInfo> updateableSrcAnswers, 
                                       List<SourceAnswersDataSetInfo> insertableSrcAnswers) {
        for ( Iterator<SourceAnswersDataSetInfo> it = srcAnswers.iterator(); it.hasNext();  ) {
            SourceAnswersDataSetInfo sad = it.next();
            
            String qstType = sad.getQst_type();
            
            int qstid = sad.getQst_id();
            int rpsid = sad.getRps_id();
            
            Pair<Integer, Integer> rpsQstPair;
            Triplet<Integer, Integer, Integer> rpsQmqQstTriplet;
            
            if ( qstType.equalsIgnoreCase("SORT")) {
                rpsQstPair = new Pair<Integer, Integer>( rpsid, qstid);
                
                if ( mp_existingRpsQstToSortAnsMap.containsKey( rpsQstPair ) ) {
                
                    Pair<Integer, Integer> scvRavPair = mp_existingRpsQstToSortAnsMap.get( rpsQstPair );
                    int scv_id =  scvRavPair.getX();
                    int check1 =  scvRavPair.getY();
                    
        
                    sad.setRps_id( rpsid );
                    
                    if (set_existingSortingCriteriaValueLocks.contains(scv_id) && set_existingSourceSortingCriteriaLocks.contains(rpsid) && check1 == 1) {
                        
                            sad.setOld_Scv_Id( scv_id );
                            LOG.info("updateableSrcAnswers.add \n" + sad + "\n___\n");
                            updateableSrcAnswers.add( sad );
                    }
                    
                } else {
                    if ( !sad.isEmpty() ) {      // chn from isv
                        LOG.info("insertableSrcAnswers.add \n" + sad + "\n___\n");
                        insertableSrcAnswers.add( sad );
                        
                    } //else { System.out.println("SAD EMPTY insert-sort \n" + sad);}
                }
            } else if ( qstType.equalsIgnoreCase("MULTI") ) {
                int qmqnumber = Integer.parseInt( sad.getQmq_number() );
                String qmqType = sad.getQmq_Qst_Type();
                rpsQmqQstTriplet = new Triplet<Integer, Integer, Integer>( rpsid, qstid, qmqnumber );
                
                Set<Triplet<Integer, Integer, Integer>> qmqTripletKeys = mp_existingRpsQstToSraRav_QMQMap.keySet();
        
                if ( mp_existingRpsQstToSraRav_QMQMap.containsKey( rpsQmqQstTriplet ) ) {
                    Pair<Integer, Integer> sraRavPair = mp_existingRpsQstToSraRav_QMQMap.get( rpsQmqQstTriplet );
                    int sra_id = sraRavPair.getX();
                    sad.setSra_Id( sra_id );
                    sad.setSma_sra_id( sra_id );
                    int rav_id;
                    boolean proceed = true;
                    if ( qmqType.equalsIgnoreCase("SINGLE") ) {
                        rav_id =  sraRavPair.getY();
                        sad.setOld_Rav_Id( rav_id );
                        if ( ! set_existingReportAnswerSetValuesLocks.contains(rav_id) ) {
                            proceed = false;
                        }
                    } 
                    
                    
                    if ( proceed && set_existingSourceAnswersLocks.contains(sra_id) ) {
                            LOG.info("updateableSrcAnswers.add \n" + sad + "\n___\n");
                    
                            updateableSrcAnswers.add( sad );
                    } 
                    
                } else {
                    if ( !sad.isEmpty() ) {      // chn from isv
                        LOG.info("insertableSrcAnswers.add \n" + sad + "\n___\n");
                        insertableSrcAnswers.add( sad );
                        
                    } 
                }
            } else if ( qstType.equalsIgnoreCase( "WEIGHT" )  || 
                               qstType.equalsIgnoreCase( "TEXT" )    || 
                               qstType.equalsIgnoreCase( "DATA" )    || 
                               qstType.equalsIgnoreCase( "RATING" )  ) {
        
                rpsQstPair = new Pair<Integer, Integer>( rpsid, qstid);
                
                Set<Pair<Integer, Integer>> theRpsQstPairKeySet = mp_existingRpsQstToSraRavMap.keySet();
        
        
                if ( mp_existingRpsQstToSraRavMap.containsKey( rpsQstPair ) ) {
                    Pair<Integer, Integer> sraCh1Pair = mp_existingRpsQstToSraRavMap.get( rpsQstPair );
                    int sra_id = sraCh1Pair.getX();
                    int check1 = sraCh1Pair.getY();
                    
                    if ( set_existingSourceAnswersLocks.contains(sra_id) && check1 == 1) {
                        
                        sad.setSra_Id( sra_id );
                        LOG.info("updateableSrcAnswers.add \n" + sad + "\n___\n");
                        updateableSrcAnswers.add( sad );
                        
                    }   
                } else {
                
                    if ( !sad.isEmpty() ) {      // chn from isv
                        LOG.info("insertableSrcAnswers.add \n" + sad + "\n___\n");
                        insertableSrcAnswers.add( sad );
                        
                    }
                }
                
            } else if ( qstType.equalsIgnoreCase( "SINGLE" )) {            
                rpsQstPair = new Pair<Integer, Integer>( rpsid, qstid);  
                
                if ( mp_existingRpsQstToSraRavMap.containsKey( rpsQstPair ) ) {
                    Pair sraRavPair = mp_existingRpsQstToSraRavMap.get( rpsQstPair );
                    int sra_id = (Integer) sraRavPair.getX();
                    int rav_id = (Integer) sraRavPair.getY();
                    sad.setOld_Rav_Id( rav_id );
                    
                    if ( set_existingReportAnswerSetValuesLocks.contains(rav_id) && set_existingSourceAnswersLocks.contains(sra_id) ) {
                        
                        sad.setSra_Id( sra_id );
                        LOG.info("updateableSrcAnswers.add \n" + sad + "\n___\n");
                        updateableSrcAnswers.add( sad );           
                    }
                    
                    
                } else {
                    if ( !sad.isEmpty() ) {      // chn from isv
                        LOG.info("insertableSrcAnswers.add \n" + sad + "\n___\n");
                        insertableSrcAnswers.add( sad );
                        
                    }
                }
            }
        }   // ends for
    }
    
    
         private void setUpExistingIDMaps(List<SourceAnswersDataSetInfo> existingSrcAnswers, 
                                Map<Pair<Integer, Integer>, Pair<Integer, Integer>> mp_existingRpsQstToSraRavMap, 
                                Map<Triplet<Integer, Integer, Integer>, Pair<Integer, Integer>> mp_existingRpsQstToSraRav_QMQMap, 
                                Map<Pair<Integer, Integer>, Pair<Integer, Integer>> mp_existingRpsQstToSortAnsMap) {
                                
             for ( Iterator<SourceAnswersDataSetInfo> it = existingSrcAnswers.iterator(); it.hasNext(); ) {
                 SourceAnswersDataSetInfo sn = it.next();
                 
                 String  qstType         = sn.getQst_type();
                 
                 Integer qstId           = sn.getQst_id();
                 Integer rpsId           = sn.getRps_id();
                 
                 Pair<Integer, Integer> key;
                 Triplet<Integer, Integer, Integer> qmqKey;
                 
                 Pair<Integer, Integer> value;
                 
                 if ( qstType.equalsIgnoreCase("MULTI")) {
                     
                     Integer sraId = sn.getSra_Id();                
                     Integer smaSraId = sn.getSma_sra_id();      //.. both sra_id and sma_id should be equal
             //        if (!smaSraId.equals(sraId))  System.out.println("Error sraId != smaSraId    sraId is " + sraId + " and smaSraId is " + smaSraId );
             //        else System.out.println("Cool multi put -- existing multiANS IS " + sn) ;

                     String qmqNmbr = sn.getQmq_number();
                     
                     qmqKey = new Triplet<Integer, Integer, Integer>(rpsId, qstId, Integer.parseInt(qmqNmbr));
                     
                     String qmqType = sn.getQmq_Qst_Type();
                     if ( qmqType.equalsIgnoreCase("SINGLE")) {
                         Integer ravId = sn.getRav_Id();

                         value = new Pair<Integer, Integer>( sraId, ravId );
                         
                     } else {
                         value = new Pair<Integer, Integer>( sraId, 1);
                     }

                     mp_existingRpsQstToSraRav_QMQMap.put( qmqKey, value );
                  
                     
                 } else if ( qstType.equalsIgnoreCase("SORT")) {                
                     key = new Pair <Integer, Integer> ( rpsId, qstId);
                     
                     Integer scvId = sn.getScv_Id();
                     
                     value = new Pair<Integer, Integer>( scvId, 1 );          // just putting in 1 for all
                     
                     mp_existingRpsQstToSortAnsMap.put( key, value );
                 
                 } else if ( qstType.equalsIgnoreCase( "WEIGHT" )  || 
                                    qstType.equalsIgnoreCase( "TEXT" )    || 
                                    qstType.equalsIgnoreCase( "DATA" )    || 
                                    qstType.equalsIgnoreCase( "RATING" )  ) {
                     
                     key = new Pair <Integer, Integer>( rpsId, qstId );
                     
                     Integer sraId = sn.getSra_Id();
                     
                     value = new Pair<Integer, Integer>( sraId, 1);         // just putting in 1 for all
                 
                     mp_existingRpsQstToSraRavMap.put( key, value );
                     
                 } else if ( qstType.equalsIgnoreCase( "SINGLE" )){
                     
                     key = new Pair <Integer, Integer>( rpsId, qstId);
                     
                     Integer sraId = sn.getSra_Id();
                     Integer ravId = sn.getRav_Id();
                     
                     value = new Pair<Integer, Integer>( sraId, ravId );
                     
                     mp_existingRpsQstToSraRavMap.put( key, value );
                 }
             }
         }



    private boolean postSourceAnswers(PrintStream out, 
                                   PlatformAppModuleService platform, 
                                   boolean isRolledBack, 
    //                                   boolean hasPostedEarlier,
                                   OtlTabLocksVO theLockInfo, 
                                   List<SourceAnswersDataSetInfo> updateableSrcAnswers, 
                                   List<SourceAnswersDataSetInfo> insertableSrcAnswers,
                                   Map<Pair, Integer> mpExisting_QstIdQmqNum_QmqId) throws ServletException {
System.out.println("mpExisting_QstIdQmqNum_QmqId is |||\n " + mpExisting_QstIdQmqNum_QmqId + "\n|||||||||||||||||||||||||");                                   
                                   
        boolean isAllDataPosted = false;               
        boolean isDataUnitPosted = false;
        // this is the list of source multi answers that will be used to determine
        // which of the sads gets directly inserted to bawaweb_source_answers ( for comment & color and ans_text )
        // and which will be bypassed for bawaweb_source_answers and be inserted into bawaweb_source_multi_answers
        // the pair here stores rps_id and qst_id
        
        List<Pair> listOfMultiSrcAnswerInfo = new ArrayList<Pair>();
        Map<Pair, SourceAnswersDataSetInfo> listOfMultiSrcAnswers = new HashMap<Pair,SourceAnswersDataSetInfo>();
        Map<Pair, SourceAnswersDataSetInfo> listOfRevQstIdRpsIdMultiSrcAnswers = new HashMap<Pair,SourceAnswersDataSetInfo>();
        if ( !isRolledBack ) {
            if ( updateableSrcAnswers != null && updateableSrcAnswers.size() > 0 ) {
                for ( Iterator<SourceAnswersDataSetInfo> it = updateableSrcAnswers.iterator(); it.hasNext(); ) {
                    SourceAnswersDataSetInfo sad = it.next();
                    try {
                        sad = platform.update( sad );
                        isDataUnitPosted = ( sad != null );
        //                    isAllDataPosted = isAllDataPosted || isDataUnitPosted;    changed nm 2009-17-2
                        isAllDataPosted = isDataUnitPosted && ( isAllDataPosted || isDataUnitPosted);
                        
                        
                        if ( isAllDataPosted && sad.getQst_type().equalsIgnoreCase("MULTI") && !sad.isForDelete() ) {
                            Pair<Integer, Integer> sadRpsIdQstIdInfo = new Pair<Integer, Integer>( sad.getRps_id(), sad.getQst_id() );
                            listOfMultiSrcAnswerInfo.add( sadRpsIdQstIdInfo );
                            
                            int qstId = sad.getQst_id();
                            int qmqNumber = Integer.parseInt( sad.getQmq_number() );
                            int qmqId = mpExisting_QstIdQmqNum_QmqId.get( new Pair<Integer, Integer>( qstId, qmqNumber ) );
                            
                            sad.setQmq_id( qmqId );
                            
                            listOfMultiSrcAnswers.put( new Pair<Integer, Integer>( sad.getSra_Id(), qmqId ), sad );
                            listOfRevQstIdRpsIdMultiSrcAnswers.put( sadRpsIdQstIdInfo, sad );
                        }
                        
                        
                        
                        
                        
                    } catch (Exception e) {
                        isDataUnitPosted = false;
                        isAllDataPosted = false;
                        e.printStackTrace();
                        LOG.error("error in updating\n " + sad + "\n" + e.getMessage() );
                        platform.rollbackAll();
                        isRolledBack = true;
                        
                        theLockInfo.setOtlStatus(PlatformAppModuleService.PENDING_STATUS);
                        platform.update( theLockInfo );
                        platform.commitAll();
                        
                        return isAllDataPosted = false;//throw new ServletException(e.getMessage() );
                    }
                }
                LOG.info(" Updated " + updateableSrcAnswers.size() + " answers");
            }
        }
        
        
        
        if ( updateableSrcAnswers == null || updateableSrcAnswers.size() <= 0 ) {
        
            isRolledBack = false;
            isAllDataPosted = true;
            
        }
        
    LOG.info("isRolledBack1 is " + isRolledBack);
    LOG.info("isAllDataPosted1 is " + isAllDataPosted);

        if ( !isRolledBack && isAllDataPosted ) {
            if ( insertableSrcAnswers == null || insertableSrcAnswers.size() <= 0 ) {
                isRolledBack = false;
                isAllDataPosted = true;
            } else {    
            
        // done see above        
//                // first deal with the ones we updated
//                if ( updateableSrcAnswers.size() > 0 ) {
//                    for( SourceAnswersDataSetInfo sad: updateableSrcAnswers ) {
//                        String qType = sad.getQst_type();
//                        if ( qType.equalsIgnoreCase( "MULTI" ) ) {
//                            int rpsId = sad.getRps_id();
//                            int qstId = sad.getQst_id();
//                            
//                            listOfMultiSrcAnswerInfo.add(new Pair( rpsId, qstId ));
//                            listOfMultiSrcAnswers.add( sad );
//                        }
//                    }
//                }
                
                
                
                
                // next we deal with the new create for multi
                // here isFordelete is false -- so not cyheciking
                Pair<Integer, Integer> sadRpsIdQstIdInfo = null;
                for ( Iterator<SourceAnswersDataSetInfo> it = insertableSrcAnswers.iterator(); it.hasNext();  ) {
                    SourceAnswersDataSetInfo sad = it.next();
    LOG.info("sad is \n" + sad);
                    int qst_id = sad.getQst_id();
                    int rps_id = sad.getRps_id();
                    String qType = sad.getQst_type();
                    try {
                        
                        if ( qType.equalsIgnoreCase("MULTI") ) { 
                            sadRpsIdQstIdInfo = new Pair<Integer, Integer>( rps_id, qst_id );
                            if ( listOfMultiSrcAnswerInfo.contains( sadRpsIdQstIdInfo ) ) {
                            
                                int sma_sra_id =  listOfRevQstIdRpsIdMultiSrcAnswers.get( sadRpsIdQstIdInfo ).getSma_sra_id(); 
                                sad.setSra_Id( sma_sra_id );
                                sad.setSma_sra_id( sma_sra_id );
                                
                                
                                int qmqNumber = Integer.parseInt( sad.getQmq_number() );
                                
                                sad.setQmq_id( mpExisting_QstIdQmqNum_QmqId.get( new Pair<Integer, Integer>( qst_id, qmqNumber) ) );
                                isDataUnitPosted = platform.createMultiAnswerRecord( sad );
                            } else {
                                listOfMultiSrcAnswerInfo.add( sadRpsIdQstIdInfo );
                                sad = platform.create( sad );
                                isDataUnitPosted = ( sad != null ) ;
                                
                                int qstId = sad.getQst_id();
                                int qmqNumber = Integer.parseInt( sad.getQmq_number() );
System.out.println("qstId is " + qstId + " qmqnumber is " + qmqNumber);                                
                                int qmqId = mpExisting_QstIdQmqNum_QmqId.get( new Pair<Integer, Integer>( qstId, qmqNumber ) );
                                
                                sad.setQmq_id( qmqId );
                                
                                listOfMultiSrcAnswers.put( new Pair<Integer, Integer>( sad.getSra_Id(), qmqId ), sad );
                                listOfRevQstIdRpsIdMultiSrcAnswers.put( sadRpsIdQstIdInfo, sad );
                                
                            }
                        } else {
                    
                            isDataUnitPosted = platform.create( sad ) != null ;
                        }
    //                    isAllDataPosted = isAllDataPosted || isDataUnitPosted;
                        isAllDataPosted = isDataUnitPosted && ( isAllDataPosted || isDataUnitPosted);
                    } catch (Exception e) {
                        isDataUnitPosted = false;
                        isAllDataPosted = false;
                        e.printStackTrace();
                        LOG.error("error in inserting\n " + sad + "\n" + e.getMessage() , e );
                        platform.rollbackAll();
                        isRolledBack = true;
                        
                        theLockInfo.setOtlStatus(PlatformAppModuleService.PENDING_STATUS);
                        platform.update( theLockInfo );
                        platform.commitAll();
                        
                        return isAllDataPosted = false;//throw new ServletException(e.getMessage() );
                    }
                }
            }
            LOG.info(" CREATED " + insertableSrcAnswers.size() + " answers");
        } else {
            platform.rollbackAll();
            isRolledBack = true;
            
            theLockInfo.setOtlStatus(PlatformAppModuleService.PENDING_STATUS);            
            platform.update( theLockInfo );
            platform.commitAll();
            
            return isAllDataPosted = false;
        }   
        
        LOG.info("isRolledBack2 is " + isRolledBack);
        LOG.info("isAllDataPosted2 is " + isAllDataPosted);
        
        if ( isAllDataPosted ) {
            
            try {
                platform.commitAll();
            } catch (Exception e) {
                isAllDataPosted = false;
                e.printStackTrace();
                LOG.error("ERROR in finalCommint111\n" + e.getMessage() );
                platform.rollbackAll();
                isRolledBack = true;
                
                theLockInfo.setOtlStatus(PlatformAppModuleService.PENDING_STATUS);
                platform.update( theLockInfo );
                platform.commitAll();
                
                return isAllDataPosted = false;//throw new ServletException(e.getMessage() );
            }
            
            boolean hasPostedEarlier = ( theLockInfo.getOtlStatus().equalsIgnoreCase(PlatformAppModuleService.POSTED_STATUS) || 
                                         theLockInfo.getOtlStatus().equalsIgnoreCase(PlatformAppModuleService.REPOSTED_STATUS) ) ?
                                         true : false;
            
            // change lock status from pending to posted -- or posted to reposted
            if ( hasPostedEarlier ) {
                theLockInfo.setOtlStatus(PlatformAppModuleService.REPOSTED_STATUS);    
            } else {
                theLockInfo.setOtlStatus(PlatformAppModuleService.POSTED_STATUS);
            }
            
            try {
                boolean isLockUpdated = platform.update( theLockInfo );
                isAllDataPosted = isAllDataPosted && isLockUpdated;
    LOG.info( "isAllDataPosted is " + isAllDataPosted);

                platform.commitAll();
                if ( isAllDataPosted ) {
                    try {
                        platform.commitAll();
                        out.println("<p><font color='blue'>CONGRATULATIONS you have uploaded data from your Excel file to the Answers Grid!!!");
                        return isAllDataPosted = true;//
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                        LOG.error("Error in final commit222", e);                    
                        platform.rollbackAll();
                        isRolledBack = true;
                        if ( theLockInfo != null ) {
                            theLockInfo.setOtlStatus(PlatformAppModuleService.PENDING_STATUS);
                            platform.update( theLockInfo );
                            platform.commitAll();
                        }
                        return isAllDataPosted = false;
                    }
                }
                else {

                    out.println("<p><font color='red'>We had a problem updating our logging data!!!</font></p>");
    LOG.error("Lock not released back --- problem :(( ");
                    return isAllDataPosted = false;//
                }
            } catch (Exception e) {
                e.printStackTrace();
                LOG.error("Error in updating lock " + theLockInfo , e);
                platform.rollbackAll();
                isRolledBack = true;
                    
                theLockInfo.setOtlStatus(PlatformAppModuleService.PENDING_STATUS);
                platform.update( theLockInfo );
                platform.commitAll();
                return isAllDataPosted = false;
                
            }
        } else {
            platform.rollbackAll();
            isRolledBack = true;
            
            theLockInfo.setOtlStatus(PlatformAppModuleService.PENDING_STATUS);            
            platform.update( theLockInfo );
            platform.commitAll();
        }
        
        return isAllDataPosted = false;
        
    }

    public static String getTheFile() {
    
        JFrame frame = new JFrame();
            
            // Create a file chooser
            String filename = File.separator+"tmp";
            JFileChooser fc = new JFileChooser(new File(filename));
            
            // Create the actions
            OpenFileAction openAction = new OpenFileAction(frame, fc);
            
            // Create buttons for the actions
            JButton openButton = new JButton(openAction);
            
            // Add the buttons to the frame and show the frame
            frame.getContentPane().add(openButton, BorderLayout.NORTH);
            frame.pack();
            frame.setVisible(true);
            
            File f = openAction.getAFile();
            
            return f.getAbsolutePath();

    
    
    
    }

    private List<SourceAnswersDataSetInfo> getListOfExtraSourcesInsertableAnswers(List<SourceAnswersDataSetInfo> insAns, List<SourceDataSetInfo> xtraSrcs) {
        if ( xtraSrcs == null || xtraSrcs.size() == 0 ) return null;
        
        List<SourceAnswersDataSetInfo> theList = new ArrayList<SourceAnswersDataSetInfo>();
        
        for ( SourceDataSetInfo s : xtraSrcs ) {
            if ( s.getXlInternalId() >= 0 ) {
                int rpsId = s.getRps_id();
                
                for ( SourceAnswersDataSetInfo sad : insAns ) {
                    if ( sad.getRps_id() == rpsId ) {
                        theList.add( sad );
                    }
                }
            }
        }
        return theList;
    }


    // This action creates and shows a modal open-file dialog.
       static class OpenFileAction extends AbstractAction {
            JFrame frame;
            JFileChooser chooser;
            File aFile;
        
            public OpenFileAction(JFrame frame, JFileChooser chooser) {
                super("Open...");
                this.chooser = chooser;
                this.frame = frame;
            }
        
            public void actionPerformed(ActionEvent evt) {
                // Show dialog; this method does not return until dialog is closed
                chooser.showOpenDialog(frame);
        
                // Get the selected file
                File file = chooser.getSelectedFile();
                this.aFile = file;
            }
            
            public File getAFile() {
                return this.aFile;
            }
        }
        

}
