//package com.bawaweb.grid.templates.reader;
//
//import com.bawaweb.grid.templates.data.ReportTemplateInfo;
//import com.bawaweb.grid.templates.data.ReportTemplateInfoDataSet;
//import com.bawaweb.grid.templates.data.cursors.QuestionDataSetInfo;
//import com.bawaweb.grid.templates.data.cursors.SourceAnswersDataSet;
//import com.bawaweb.grid.templates.data.cursors.SourceAnswersDataSetInfo;
//import com.bawaweb.grid.templates.data.tables.AnswerSetValuesDataSetInfo;
//import com.bawaweb.grid.templates.data.tables.ReportAnswerSetValuesDataSetInfo;
//import com.bawaweb.grid.templates.data.tables.SourceDataSet;
//import com.bawaweb.grid.templates.data.tables.SourceDataSetInfo;
//import com.bawaweb.grid.templates.sheets.AnswersGridSheetReader;
//import com.bawaweb.grid.templates.sheets.AnswersGridSheetReaderImpl;
//
//import com.bawaweb.grid.templates.sheets.ExtraAnswerSetsSheetReader;
//import com.bawaweb.grid.templates.sheets.ExtraAnswerSetsSheetReaderImpl;
//import com.bawaweb.grid.templates.sheets.ExtraSourceSheetReader;
//import com.bawaweb.grid.templates.sheets.ExtraSourceSheetReaderImpl;
//import com.bawaweb.lifecycle.OtlTabLocksVO;
//
//import com.bawaweb.lifecycle.SourcesAnswerInfoVO;
//import com.bawaweb.services.PlatformAppModuleService;
//import com.bawaweb.services.PlatformAppModuleServiceImpl;
//
//import com.bawaweb.utils.Pair;
//
//import com.bawaweb.utils.Triplet;
//
//import java.io.File;
//
//import java.sql.Timestamp;
//
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.LinkedHashMap;
//import java.util.List;
//
//import java.util.Map;
//
//import java.util.Set;
//
//import jxl.Sheet;
//import jxl.Workbook;
//
//import oracle.jbo.ApplicationModule;
//import oracle.jbo.domain.Date;
//import oracle.jbo.domain.Number;
//
//public class TestAnswersSheetReader {
//
//    public final static int REPORTER_ID = 2045;//54054;
//    public final static String EXCEL_FILE = "\\\\san-sv-filer\\nmedhora$\\my documents\\jxlTesting\\test_latest.xls";
//    
//    
//    private ReportTemplateInfo existingReportTemplate;      // built through cursors - existing
//    private ReportTemplateInfo reportInfo;                  // built from the spreadsheet
//    
//    public static void main(String[] args) throws Exception {
//    
//        PlatformAppModuleService platform = PlatformAppModuleServiceImpl.getInstance();
//        
//        AnswersGridSheetReader reader = AnswersGridSheetReaderImpl.getInstance();
//        File theFile = new File(EXCEL_FILE);
//        reader.setTheFile(theFile);
//        
//        Workbook w = reader.extractWorkbook(new File(EXCEL_FILE));
//        int reportId = reader.getReportId(w);
//        
//        if ( reportId == 0 ) {
//            throw new Exception("Invalid report id - 0" );
////            System.exit(100);
//        }
//        
//        int reporterId = reader.getReporterId(w);        
//        if ( reporterId == 0 ) {
//            throw new Exception("Invalid reporter id - 0" );
////            System.exit(100);
//        }
//        
//
//        Sheet introSheet = reader.extractIntroSheet(w);
//        boolean hasPostedEarlier = false;
//        OtlTabLocksVO theLockInfo = null;
//        int lockId = 0;
//        try {
//            lockId =  Integer.parseInt( introSheet.getCell(0, 65500).getContents() );
//System.out.println("lockid is " + lockId + " reportId is " + reportId + " and reporterId is " + reporterId);            
//            theLockInfo = platform.getLockInfo(lockId, reportId, reporterId);
//System.out.println("thelockinfo is \n " + theLockInfo);            
//            if ( theLockInfo == null ) {
//                System.out.println("Error no lock .....exiting!!!");
//                System.exit(2);
//            }
//            String status = theLockInfo.getOtlStatus();
//            if ( status.equalsIgnoreCase(PlatformAppModuleService.STALE_STATUS) ) { //!PENDING_STATUS) ) {
//                System.out.println("Error status " + status + ".....exiting!!!");
//                System.exit(3);
//            }
//            
//            if ( status.equalsIgnoreCase(PlatformAppModuleService.POSTED_STATUS) || status.equalsIgnoreCase(PlatformAppModuleService.REPOSTED_STATUS)) {
//                hasPostedEarlier = true;
//            }
//            
//            if ( platform.isReportLocked( reportId ) ) {
//                System.out.println("Error report is locked by another user for reportid " + reportId + " and lockid " + lockId + ".....exiting!!!");
//                System.exit(31);
//            }
//                
//            // change to inprocess
//             theLockInfo.setOtlStatus(PlatformAppModuleService.IN_PROCESS_STATUS);
//             boolean isLockUpdated = platform.update( theLockInfo );
//             
//             if ( ! isLockUpdated ) {
//                 System.out.println("Error in updating lock to IN_PROCESS_STATUS........... exiting!!!"); 
//                 System.exit(4);
//             }
//             
//             try {
//                platform.commitAll();
//             } catch ( Exception e) {
//                 platform.rollbackAll();
//                 System.out.println("Error in updating lock to IN_PROCESS_STATUS........... exiting!!!");
//                 System.exit(4);
//             }
//                
//            // set up the collector name variable
//            String rptrId = theLockInfo.getOtlEmplId();
//            try {
//                platform.setCollectorName( rptrId );
//            } catch (Exception e) {
//                System.out.println("Could not set the user name");
//                System.exit(5);
//                
//                platform.rollbackAll();
//                
//                theLockInfo.setOtlStatus(PlatformAppModuleService.PENDING_STATUS);
//                
//                platform.commitAll();
//            }
//            
//                
//                
//        
//        } catch (NumberFormatException e) {
//            System.out.println("Error in finding lock and status.....exiting!!!"); 
//            System.exit(4);
//        }
//        // start with null and build up
//        ReportTemplateInfo reportInfo = new ReportTemplateInfoDataSet();
//        if ( reportId != 0 ) reportInfo.setReportId(reportId);
//        else throw new Exception ("ReportId was invalid as 0");
//        
//        reader.setReportInfo(reportInfo);
//        
//        
//        
//        Sheet extraSourcesSheet = reader.extractExtraSourcesSheet(w);
//        
//        Sheet extraQuestionAnswersSheet = reader.extractExtraQuestionAnswersSheet(w);
//        Sheet answersSheet = reader.extractAnswersSheet(w);
//        
//        
//        // first add in the extra source info
//        ExtraSourceSheetReader xtraSrcSheetReader = new ExtraSourceSheetReaderImpl(extraSourcesSheet, reportId, reporterId );
//        List<SourceDataSetInfo> extraSources = xtraSrcSheetReader.getExtraSources(  extraSourcesSheet );
//        xtraSrcSheetReader.processExtraSources( extraSources );
//        List<SourceDataSetInfo> xtraRepSrcs = xtraSrcSheetReader.getLi_newRepSrcs();
//        Map<Integer, SourceDataSetInfo> mp_internalsrcid_src = xtraSrcSheetReader.getMp_internalsrcid_src();
//        
//        
//        xtraSrcSheetReader.printList( xtraSrcSheetReader.getAll_errors() );
//        
//        mp_internalsrcid_src = platform.addExtraSources( extraSources, xtraRepSrcs, mp_internalsrcid_src );
//         
//        // then add in extra answer-sets info
//        ExtraAnswerSetsSheetReader xtraAnsSetsSheetReader = new ExtraAnswerSetsSheetReaderImpl(extraQuestionAnswersSheet, reportId, reporterId );
//        Map<Integer, List<ReportAnswerSetValuesDataSetInfo>> mp_qstnId_rprtAnsSetValues = platform.getExtraQuestionsReportAnswerSetValuesMap(reportId);
//        Map<Integer, List<AnswerSetValuesDataSetInfo>>   mp_qstnId_ansSetValues =  platform.getExtraQuestionsAnswerSetValuesMap(reportId);
//         
//        List<QuestionDataSetInfo> li_extraQuestions = xtraAnsSetsSheetReader.getExtraQuestions(extraQuestionAnswersSheet, reportId, mp_qstnId_rprtAnsSetValues );
//        xtraAnsSetsSheetReader.addExtraAnswerSetValues( li_extraQuestions, mp_qstnId_ansSetValues, mp_qstnId_rprtAnsSetValues, platform );
//        
//        try {
//           platform.commitAll();
//        } catch ( Exception e) {
//            platform.rollbackAll();
//            System.out.println("Error in updating ANSWER VALUES........... exiting!!!");
//            System.exit(4);
//        }
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        // then read answers sheet
//        List<Integer>   li_sourceIds                    = reader.extractTheReportSourceInfo(answersSheet);
//        Map<Integer, Integer>   mp_repSrcIdRows         = reader.getMp_RepSourceIds_Rows();
//        Map<Integer, Integer> mp_ExtraRepSrcIdRows =    reader.getMp_ExtraRepSourceIds_Rows();
//System.out.println("mp_ExtraRepSrcIdRows is \n");
//reader.printMap( mp_ExtraRepSrcIdRows );
//
//        List<String>    li_questionIds                  = reader.extractTheQuestionsInfo(answersSheet);
//        
//        List<Integer>   li_repSrcIds                    = reader.getLi_RepSourceIds();     // maybe redundant -- sourceids
//        List<String>    li_qstnids                      = reader.getLi_questionInfos();    // maybe redundant -- questionIds
//        Map<Integer, Integer>   mp_qstnIdCol            = reader.getMp_QuestionId_Col();
//        
//        Map<String, Integer>    mp_qstnTagCol           = reader.getMp_QuestionTag_Col();
//        List<String>            li_qstnTags             = reader.getLi_QuestionTags();
//        List<String>            li_srcNames             = reader.extractSourceNames(answersSheet, mp_repSrcIdRows);
//        
//        int start_col   = reader.getStart_ans_col();
//        int start_row   = reader.getStart_ans_row();
//        int end_col     = reader.getEnd_ans_col();
//        int end_row     = reader.getEnd_ans_row();
//        
//        Map<Integer, Integer> mp_qstnHintCol                = reader.getMp_QuestionHint_Col();
//        List li_baseQuestionIds = extractKeysList(mp_qstnIdCol);
//        
//        ReportTemplateInfo existingReportTemplate   = reader.buildExistingReportTemplate(reportId);
//        //--
//        
//        LinkedHashMap<Integer, QuestionDataSetInfo> existingQstns       = existingReportTemplate.getQuestionsDataSetMap();
//        LinkedHashMap<Integer, SourceDataSetInfo>   existingSrcs        = existingReportTemplate.getSourcesDataSetMap();
//        List<String>                                existingQstnTags    = existingReportTemplate.buildQuestionTags();
//        List<SourceAnswersDataSetInfo>              existingSrcAnswers  = existingReportTemplate.getListOfSourceAnswers();
//        Map<String, String>                         existingQtypeMap    = existingReportTemplate.buildQuestionTypeMap();
//        reader.printMap(existingQtypeMap);
//        List<Integer>                               existingRepSrcIds      = existingReportTemplate.getLi_RepSourceIds();
//        List<Integer>                               existingQuestionIds = existingReportTemplate.getLi_questionIds();
//        List<String>                                existingSrcNames    = existingReportTemplate.getLi_SourceNames();
//        Map<Integer, Integer>                         existingRepSrcIdSrcIdMap = existingReportTemplate.getMap_RepSrcId_SrcId();
//        
//        Map<String, Integer>                        existingRprtInit_RprtIdMap = existingReportTemplate.buildRprtrInit_RprtrIdMap();
//        
//        boolean allSrcsOk       = reader.compareLists(existingRepSrcIds, li_repSrcIds);
//        boolean allQstnIdsOk    = reader.compareLists(existingQuestionIds, li_baseQuestionIds);
//        boolean allQstnTagsOk   = reader.compareLists(existingQstnTags, li_qstnTags);
//        boolean allSrcNamesOk   = reader.compareLists(existingSrcNames, li_srcNames);
//        System.out.println("existingRepSrcIds sz " + existingRepSrcIds.size());
//        System.out.println("li_repSrcIds sz " + li_repSrcIds.size());
//        System.out.println("\n***allSrcsOk " + allSrcsOk);
//        System.out.println("\n***existingRepSrcIds");
//        reader.printList(existingRepSrcIds);
//        System.out.println("\n***li_repSrcIds");
//        reader.printList(li_repSrcIds);
//        System.out.println("\n***allQstnIdsOk " + allQstnIdsOk);
//        System.out.println("\n***allQstnTagsOk " + allQstnTagsOk);
//        System.out.println("\n***allSrcNamesOk " + allSrcNamesOk);
//        System.out.println("\n***existingSrcNames");
//        reader.printList(existingSrcNames);
//        System.out.println("\n***li_srcNames");
//        reader.printList(li_srcNames);
//
//        boolean isValid = allSrcsOk && allQstnIdsOk && allQstnTagsOk && allSrcNamesOk;
//
//        if (!isValid) {
//            System.out.println("There is an error in the grid.... aborting");
//            
//            theLockInfo.setOtlStatus( PlatformAppModuleService.PENDING_STATUS);
//            
//            platform.commitAll();
//            
////            System.exit(0);
//        } else {    // huge else here for valid--- ends at end of method way bl
//            // get and set the locking
////             Set<Integer> set_existingReportAnswerSetValuesLocks = existingReportTemplate.buildReportAnswerSetValuesLocks();
////             Set<Integer> set_existingSourceAnswersLocks         = existingReportTemplate.buildSourceAnswersLocks();
////             Set<Integer> set_existingSortingCriteriaValueLocks  = existingReportTemplate.buildSortingCriteriaValuesLocks();
////             Set<Integer> set_existingSourceSortingCriteriaLocks  = existingReportTemplate.buildSourceSortingCriteriaLocks();
//             
//             
//             existingReportTemplate.buildLocks();
//             Set<Integer> set_existingReportAnswerSetValuesLocks        = existingReportTemplate.getSetOfReportAnswerSetValuesLocks();
//             Set<Integer> set_existingSourceAnswersLocks                = existingReportTemplate.getSetOfSourceAnswersLocks();
//             Set<Integer> set_existingSortingCriteriaValueLocks         = existingReportTemplate.getSetOfSortingCriteriaValueLocks();
//             Set<Integer> set_existingSourceSortingCriteriaLocks        = existingReportTemplate.getSetOfSourceSortingCriteriaLocks();
//             Set<Integer> set_existingSourceMultiAnswerLocks            = existingReportTemplate.getSetOfSourceMultiAnswersLocks();
//             Set<Integer> set_existingQuestionsLocks                    = existingReportTemplate.getSetOfQuestionsLocks();
//             Set<Integer> set_existingMultiQuestionsLocks               = existingReportTemplate.getSetOfMultiQuestionsLocks();
//             
//           
//                   
//System.out.println("\n*******************\nBUILDING SOURCES\n***********");            
//            List<SourceDataSetInfo> sources = reader.buildSourceInfo(answersSheet, //existingSrcs, 
//                                                        existingRepSrcIdSrcIdMap, existingRprtInit_RprtIdMap);
//            platform.updateRepeatSourceData( sources );
//            
//
//            Map<Pair,Pair> mp_existingRpsQstToSraRavMap = new HashMap<Pair, Pair>();    
//            Map<Triplet,Pair> mp_existingRpsQstToSraRav_QMQMap = new HashMap<Triplet, Pair>();
//            Map<Pair, Pair> mp_existingRpsQstToSortAnsMap  = new HashMap<Pair, Pair>();
//            
//    System.out.println("\n***********existingSrcAnswers***********************\n");
//    //            reader.printList( existingSrcAnswers );
//    System.out.println("\n***********ENDS existingSrcAnswers*********************** size is " + existingSrcAnswers.size() + "\n");            
//            for ( Iterator<SourceAnswersDataSetInfo> it = existingSrcAnswers.iterator(); it.hasNext(); ) {
//                SourceAnswersDataSetInfo sn = it.next();
//                
//                String  qstType         = sn.getQst_type();
//    System.out.println("existingSrcAnswers qsttype is " + qstType + " qstid is " + sn.getQst_id());            
//                Integer qstId           = sn.getQst_id();
//                Integer rpsId           = sn.getRps_id();
//                
//                Pair key;// = new Pair( rpsId, qstId);
//                Triplet qmqKey;
//                
//                Pair value;
//                
//                if ( qstType.equalsIgnoreCase("MULTI")) {
//                    
//                    Integer sraId = sn.getSra_Id();                
//                    Integer smaSraId = sn.getSma_sra_id();      //.. both sra_id and sma_id should be equal
//    if (!smaSraId.equals(sraId))  System.out.println("Error sraId != smaSraId    sraId is " + sraId + " and smaSraId is " + smaSraId ); 
//    else System.out.println("Cool multi put -- existing multiANS IS " + sn) ;
//    
//                    String qmqNmbr = sn.getQmq_number();
//    System.out.println("qmqNmbr is |" + qmqNmbr + "|");                
//                    qmqKey = new Triplet(rpsId, qstId, Integer.parseInt(qmqNmbr));
//    //                key = new Pair ( rpsId, qstId);
//                    String qmqType = sn.getQmq_Qst_Type();
//                    if ( qmqType.equalsIgnoreCase("SINGLE")) {
//                        Integer ravId = sn.getRav_Id();
//    System.out.println("inserting ravId " + ravId); 
//    
//                        value = new Pair( sraId, ravId );
//                        
//                    } else {
//                        value = new Pair( sraId, 1);
//                    }
//    System.out.println("qmqKey triplet PUTTING is " + qmqKey);     
//    
//                    mp_existingRpsQstToSraRav_QMQMap.put( qmqKey, value );
//                 
//                    
//                } else if ( qstType.equalsIgnoreCase("SORT")) {                
//                    key = new Pair ( rpsId, qstId);
//                    
//                    Integer scvId = sn.getScv_Id();
//                    
//                    value = new Pair( scvId, 1 );          // just putting in 1 for all
//                    
//                    mp_existingRpsQstToSortAnsMap.put( key, value );
//                
//                } else if ( qstType.equalsIgnoreCase( "WEIGHT" )  || 
//                                   qstType.equalsIgnoreCase( "TEXT" )    || 
//                                   qstType.equalsIgnoreCase( "DATA" )    || 
//                                   qstType.equalsIgnoreCase( "RATING" )  ) {
//                    
//                    key = new Pair ( rpsId, qstId );
//                    
//                    Integer sraId = sn.getSra_Id();
//    System.out.println("Adding for sraId into map_exi " + sraId);                
//                    value = new Pair( sraId, 1);         // just putting in 1 for all
//    System.out.println("Adding/putting pair KEY " + key);
//    System.out.println("Adding/putting pair VALUE " + value);
//                
//                    mp_existingRpsQstToSraRavMap.put( key, value );
//                    
//                } else if ( qstType.equalsIgnoreCase( "SINGLE" )){
//                    
//                    key = new Pair ( rpsId, qstId);
//                    
//                    Integer sraId = sn.getSra_Id();
//                    Integer ravId = sn.getRav_Id();
//                    
//                    value = new Pair( sraId, ravId );
//                    
//                    mp_existingRpsQstToSraRavMap.put( key, value );
//                }
//            }
//            
//            System.out.println("\n*******************\nREADER SRC ANSWERS\n***********\n");        
//            List<SourceAnswersDataSetInfo> srcAnswers =  reader.buildSourceAnswersList(answersSheet, existingQstns, existingRepSrcIdSrcIdMap, mp_internalsrcid_src);
//            
////            reader.printList(srcAnswers);  
//            System.out.println("\n*******************\nENDS READER SRC ANSWERS\n*********** size "  + srcAnswers.size());  
//            
//            System.out.println("\nErrors ");
//                    reader.printList(reader.getLi_errors());
//            System.out.println("\nEndsErrors ");
//            
//            if ( reader.getAll_errors().size() == 0 ) {
//                
//    ////////////////////////////////////////////////////////////////////////            
//                System.out.println("\n*******************\nTEST SRC ANSW  + srcAnswers.size()");  
//                int numTotAns = 0;
//                int numSingleAns = 0;
//                int numWeightAns = 0;
//                int numMultAns = 0;
//                int numSortAns = 0;
//                int numNumAns = 0;
//                int numTextAns = 0;
//                int numMultSingAns = 0;
//                int numMultNumAns = 0;
//                int numMultTextAns = 0;
//                
//                for ( Iterator<SourceAnswersDataSetInfo> r = srcAnswers.iterator(); r.hasNext(); ) {
//                    SourceAnswersDataSetInfo sad = r.next();
//                    numTotAns++;
//                    String qType = sad.getQst_type();
//                    if ( qType.equalsIgnoreCase("WEIGHT")) numWeightAns++;
//                    else if ( qType.equalsIgnoreCase("SORT")) numSortAns++;
//                    else if ( qType.equalsIgnoreCase("MULTI")) {
//                        numMultAns++;
//        
//                        String qmqQstType = sad.getQmq_Qst_Type();
//                        if ( qmqQstType.equalsIgnoreCase("SINGLE")) {
//                            numMultSingAns++;
//        System.out.println("FOUND MULTI_SINGLE_ SAD } " + sad);                        
//        //                    
//        //if ( sad.getAnswer() == null ||  sad.getAnswer() == "" ) System.out.println("SINGLE SAD } " + sad);
//        //if ( ( sad.getQst_id() == 36570 || sad.getQst_id() == 36575 || sad.getQst_id() == 36566 || sad.getQst_id() == 36572 || sad.getQst_id() == 36574 ) 
//        //    &&
//        //    ( sad.getRps_id() == 194922 || sad.getRps_id() == 194682 || sad.getRps_id() == 194680 )
//        //    )
//        //    System.out.println("SINGLE SAD } " + sad);
//        //
//        
//        
//                        } else if ( qmqQstType.equalsIgnoreCase("DATA")) {
//        System.out.println("FOUND MULTI_DATA_ SAD } " + sad);                
//                            numMultNumAns++;
//                        } else if ( qmqQstType.equalsIgnoreCase("TEXT")) {
//                            numMultTextAns++;
//                        }
//                    }
//                    else if ( qType.equalsIgnoreCase("DATA")) numNumAns++;
//                    else if ( qType.equalsIgnoreCase("TEXT")) numTextAns++;
//                    else if ( qType.equalsIgnoreCase("SINGLE")) numSingleAns++;
//                }
//                System.out.println("\n*******************\nREADER SRC ANSWERS BREAKUP\n***********");
//                System.out.println("numSingleAns ==> " + numSingleAns);
//                    System.out.println("numWeightAns ==> " + numWeightAns);
//                    System.out.println("numMultAns ==> " + numMultAns);
//                    System.out.println("        numMultSingAns ==> " + numMultSingAns);
//                    System.out.println("        numMultNumAns ==> " + numMultNumAns);
//                    System.out.println("        numMultTextAns ==> " + numMultTextAns);
//                    System.out.println("numSortAns ==> " + numSortAns);
//                    System.out.println("numNumAns ==> " + numNumAns);
//                    System.out.println("numTextAns ==> " + numTextAns);
//                    System.out.println("Total R Ans  ==> " + numTotAns);
//                    
//                    int numETotAns = 0;
//                    int numESingleAns = 0;
//                    int numEWeightAns = 0;
//                    int numEMultAns = 0;
//                    int numESortAns = 0;
//                    int numENumAns = 0;
//                    int numETextAns = 0;
//                    int numEMultSingAns = 0;
//                    int numEMultNumAns = 0;
//                    int numEMultTextAns = 0;
//                    
//                    for ( Iterator<SourceAnswersDataSetInfo> e = existingSrcAnswers.iterator(); e.hasNext(); ) {
//                        SourceAnswersDataSetInfo sad = e.next();
//                        numETotAns++;
//                        String qType = sad.getQst_type();
//                        if ( qType.equalsIgnoreCase("WEIGHT")) numEWeightAns++;
//                        else if ( qType.equalsIgnoreCase("SORT")) numESortAns++;
//                        else if ( qType.equalsIgnoreCase("MULTI"))  { 
//                            numEMultAns++; 
//                            String qmqQstType = sad.getQmq_Qst_Type();
//                            if ( qmqQstType.equalsIgnoreCase("SINGLE")) {
//                                numEMultSingAns++;
//                            } else if ( qmqQstType.equalsIgnoreCase("DATA")) {
//                                numEMultNumAns++;
//                            } else if ( qmqQstType.equalsIgnoreCase("TEXT")) {
//                                numEMultTextAns++;
//                            }
//                        }
//                        else if ( qType.equalsIgnoreCase("DATA")) numENumAns++;
//                        else if ( qType.equalsIgnoreCase("TEXT")) numETextAns++;
//                        else if ( qType.equalsIgnoreCase("SINGLE")) numESingleAns++;
//                    }
//                    System.out.println("\n*******************\nEXISTING SRC ANSWERS BREAKUP\n***********");
//                    System.out.println("numESingleAns ==> " + numESingleAns);
//                        System.out.println("numEWeightAns ==> " + numEWeightAns);
//                        System.out.println("numEMultAns ==> " + numEMultAns);
//                        System.out.println("        numEMultSingAns ==> " + numEMultSingAns);
//                        System.out.println("        numEMultNumAns ==> " + numEMultNumAns);
//                        System.out.println("        numEMultTextAns ==> " + numEMultTextAns);
//                        System.out.println("numESortAns ==> " + numESortAns);
//                        System.out.println("numENumAns ==> " + numENumAns);
//                        System.out.println("numETextAns ==> " + numETextAns);            
//                        System.out.println("TBaWaWEBL E ANS  ==> " + numETotAns);
//                        
//                        
//                        
//                        
//                        
//                        
//                        
//                        
//                        
//                        
//                        
//                        
//                
//                List<SourceAnswersDataSetInfo> updateableSrcAnswers = new ArrayList<SourceAnswersDataSetInfo>();
//                List<SourceAnswersDataSetInfo> insertableSrcAnswers = new ArrayList<SourceAnswersDataSetInfo>();
//        System.out.println("srcAnswers size is " + srcAnswers.size() );        
//                
//                for ( Iterator<SourceAnswersDataSetInfo> it = srcAnswers.iterator(); it.hasNext();  ) {
//                    SourceAnswersDataSetInfo sad = it.next();
//                    
//                    String qstType = sad.getQst_type();
//                    
//                    int qstid = sad.getQst_id();
//                    int rpsid = sad.getRps_id();
//                    
//                    Pair rpsQstPair;// = new Pair( rpsid, qstid);
//                    Triplet rpsQmqQstTriplet;
//                    
//                    if ( qstType.equalsIgnoreCase("SORT")) {
//                        rpsQstPair = new Pair( rpsid, qstid);
//                        
//                        if ( mp_existingRpsQstToSortAnsMap.containsKey( rpsQstPair ) ) {
//                        
//                            Pair scvRavPair = mp_existingRpsQstToSortAnsMap.get( rpsQstPair );
//                            int scv_id =  scvRavPair.getX();
//                            int check1 =  scvRavPair.getY();
//        if ( check1 != 1 )  System.out.println("Error checkI != 1"); 
//        else System.out.println("Cool sort read") ;
//        
//        //                    sad.setScv_Id( scv_id );
//                            sad.setRps_id( rpsid );
//                            // remove this now
//                            if (set_existingSortingCriteriaValueLocks.contains(scv_id) && set_existingSourceSortingCriteriaLocks.contains(rpsid) && check1 == 1) {
//                                
//                                    sad.setOld_Scv_Id( scv_id );
//        //                        if ( sad.isValid() ) {
//                                    updateableSrcAnswers.add( sad );
//                                System.out.println("UPDATE[SORT] sad is \n" + sad );
//        //                        } else { System.out.println("SAD INVALID update-sort \n" + sad);}
//                            }
//                            
//                        } else {
//                            if ( !sad.isEmpty() ) {      // chn from isv
//                                insertableSrcAnswers.add( sad );
//        System.out.println("INSERT [SORT] sad is \n" + sad );
//                            } else { System.out.println("SAD EMPTY insert-sort \n" + sad);}
//                        }
//                    } else if ( qstType.equalsIgnoreCase("MULTI") ) {
//                        int qmqnumber = Integer.parseInt( sad.getQmq_number() );
//                        String qmqType = sad.getQmq_Qst_Type();
//                        rpsQmqQstTriplet = new Triplet( rpsid, qstid, qmqnumber );
//        System.out.println("IN MULTI_READ triplet si " + rpsQmqQstTriplet);                
//        // to remove
//        Set<Triplet> qmqTripletKeys = mp_existingRpsQstToSraRav_QMQMap.keySet();
//        System.out.println("qmqTripletKeys contains key rpsQmqQstTriplet " + qmqTripletKeys.contains(rpsQmqQstTriplet));
//                        if ( mp_existingRpsQstToSraRav_QMQMap.containsKey( rpsQmqQstTriplet ) ) {
//                            Pair sraRavPair = mp_existingRpsQstToSraRav_QMQMap.get( rpsQmqQstTriplet );
//                            int sra_id = sraRavPair.getX();
//                            sad.setSra_Id( sra_id );
//                            sad.setSma_sra_id( sra_id );
//                            int rav_id;
//                            boolean proceed = true;
//                            if ( qmqType.equalsIgnoreCase("SINGLE") ) {
//                                rav_id =  sraRavPair.getY();
//                                sad.setOld_Rav_Id( rav_id );
//                                if ( ! set_existingReportAnswerSetValuesLocks.contains(rav_id) ) {
//                                    proceed = false;
//                                }
//                            } 
//                            
//                            
//                            if ( proceed && set_existingSourceAnswersLocks.contains(sra_id) ) {
//                            
//                                
//        //                        if ( sad.isValid() ) {
//                                    updateableSrcAnswers.add( sad );
//                        System.out.println("UPDATE[MULTI] sad is \n" + sad );
//        //                        } else { System.out.println("SAD INVALID update-multi \n" + sad);}
//                            } 
//                            else {
//        //                        System.out.println("set_existingReportAnswerSetValuesLocks.contains(rav_id) for rav_id " + rav_id + " is " + set_existingReportAnswerSetValuesLocks.contains(rav_id));
//                                System.out.println("set_existingSourceAnswersLocks.contains(sra_id) for sra_id " + sra_id + " is " + set_existingSourceAnswersLocks.contains(sra_id));                        
//                            }
//                            
//                        } else {
//                            if ( !sad.isEmpty() ) {      // chn from isv
//                                insertableSrcAnswers.add( sad );
//        System.out.println("INSERT[MULTI] sad is \n" + sad );
//                            } else { System.out.println("SAD EMPTY insert-multi \n" + sad);}
//                        }
//                    } else if ( qstType.equalsIgnoreCase( "WEIGHT" )  || 
//                                       qstType.equalsIgnoreCase( "TEXT" )    || 
//                                       qstType.equalsIgnoreCase( "DATA" )    || 
//                                       qstType.equalsIgnoreCase( "RATING" )  ) {
//        
//                        rpsQstPair = new Pair( rpsid, qstid);
//        System.out.println("finding pair rpsQstPair " + rpsQstPair);
//        Set<Pair> theRpsQstPairKeySet = mp_existingRpsQstToSraRavMap.keySet();
//        System.out.println("Is pair in the keyset " + theRpsQstPairKeySet.contains(rpsQstPair));
//        
//                        if ( mp_existingRpsQstToSraRavMap.containsKey( rpsQstPair ) ) {
//                            Pair sraCh1Pair = mp_existingRpsQstToSraRavMap.get( rpsQstPair );
//                            int sra_id = sraCh1Pair.getX();
//                            int check1 = sraCh1Pair.getY();
//        if ( check1 != 1 )  System.out.println("Error checkI != 1"); 
//        else System.out.println("Cool others read") ;
//                            if ( set_existingSourceAnswersLocks.contains(sra_id) && check1 == 1) {
//                                
//        //                        if ( sad.isValid() ) {
//                            sad.setSra_Id( sra_id );
//                                    updateableSrcAnswers.add( sad );
//                                System.out.println("UPDATE[" +qstType + "] sad is \n" + sad );
//        //                        } else { System.out.println("SAD INVALID update-" + qstType + "\n" + sad);}
//                            }   
//                        } else {
//        System.out.println("pair rpsQstPair not found for " + rpsQstPair);                
//                            if ( !sad.isEmpty() ) {      // chn from isv
//                                insertableSrcAnswers.add( sad );
//        System.out.println("INSERT [" +qstType + "] sad is \n" + sad );
//                            } else { System.out.println("SAD EMPTY insert-" + qstType + "\n" + sad);}
//                        }
//                        
//                    } else if ( qstType.equalsIgnoreCase( "SINGLE" )) {            
//                        rpsQstPair = new Pair( rpsid, qstid);  
//                        
//                        if ( mp_existingRpsQstToSraRavMap.containsKey( rpsQstPair ) ) {
//                            Pair sraRavPair = mp_existingRpsQstToSraRavMap.get( rpsQstPair );
//                            int sra_id = (Integer) sraRavPair.getX();
//                            int rav_id = (Integer) sraRavPair.getY();
//                            sad.setOld_Rav_Id( rav_id );
//                            
//                            if ( set_existingReportAnswerSetValuesLocks.contains(rav_id) && set_existingSourceAnswersLocks.contains(sra_id) ) {
//                            
//                                
//        //                        if ( sad.isValid() ) {
//                            sad.setSra_Id( sra_id );
//                                    updateableSrcAnswers.add( sad );
//        System.out.println("UPDATE[" + qstType + "]sad is \n" + sad );
//        //                        }
//                            }
//                            
//                        } else {
//                            if ( !sad.isEmpty() ) {      // chn from isv
//                                insertableSrcAnswers.add( sad );
//        System.out.println("INSERT[" + qstType + "]sad is \n" + sad );
//                            }
//                        }
//                    }
//                }   // ends for
//        //            System.out.println("\n__updateableSrcAnswers__\n");
//        ////            reader.printList(updateableSrcAnswers);
//        //            System.out.println("\n___insertableSrcAnswers__\n");
//        ////            reader.printList(insertableSrcAnswers);
//        System.out.println("\n__updateableSrcAnswers__ size = " + updateableSrcAnswers.size() );
//        System.out.println("\n___insertableSrcAnswers__ size = " + insertableSrcAnswers.size() );
//                System.out.println("\n*******************\nCOMMITTING ANSWERS\n***********");  
//        System.out.println("___UPDATESS___\n");;
//                
//                for ( Iterator<SourceAnswersDataSetInfo> it = updateableSrcAnswers.iterator(); it.hasNext(); ) {
//                    SourceAnswersDataSetInfo sad = it.next();
//        System.out.println("updating sad \n" + sad);            
//                    platform.update( sad );
//                }
//        
//        System.out.println("___CREATESS___\n");;        
//                for ( Iterator<SourceAnswersDataSetInfo> it = insertableSrcAnswers.iterator(); it.hasNext();  ) {
//                    SourceAnswersDataSetInfo sad = it.next();
//        System.out.println("creatting sad \n" + sad);
//                    platform.create( sad );
//                }
//                
//                // change lock status from pending to posted -- or posted to reposted
//                if ( hasPostedEarlier ) {
//                    theLockInfo.setOtlStatus(PlatformAppModuleService.REPOSTED_STATUS);    
//                } else {
//                    theLockInfo.setOtlStatus(PlatformAppModuleService.POSTED_STATUS);
//                }
//                
//                platform.update( theLockInfo );
//                
//        /** rem for now **        
////                try {
////                    platform.commitAll();
////                }
////                catch (Exception e) {
////                    platform.rollbackAll();
////                    if ( theLockInfo != null ) {
////                        theLockInfo.setOtlStatus(PlatformAppModuleService.PENDING_STATUS);
////                        platform.update( theLockInfo );
////                        platform.commitAll();
////                    }
////                }
//    ** rem for now **/            
//                
//                
//                
//                
//                
//                
//                
//                
//                
//                
//                int pp = 0;
//                for ( Iterator<SourceAnswersDataSetInfo> it = updateableSrcAnswers.iterator(); it.hasNext(); pp++) {
//                    SourceAnswersDataSetInfo sad = it.next();
//                    SourcesAnswerInfoVO sanInfo = new SourcesAnswerInfoVO();            
//                    int sra_id = sad.getSra_Id();
//                    int rav_id = sad.getRav_Id();
//                    
//                    if ( set_existingReportAnswerSetValuesLocks.contains(rav_id) && set_existingSourceAnswersLocks.contains(sra_id) ) {
//        // now moved to the end of the method using a list approach ---platform.updateAnswers(); ok maybe later
//        //                platform.update( sanInfo.transform( sad ), reportId );
//        System.out.println("UPDATE " + pp);
//                    }
//                }   
//        
//        System.out.println("___INSERTS___\n");;        
//                for ( Iterator<SourceAnswersDataSetInfo> it = insertableSrcAnswers.iterator(); it.hasNext(); pp++) {
//                    SourceAnswersDataSetInfo sad = it.next();
//                    SourcesAnswerInfoVO sanInfo = new SourcesAnswerInfoVO();
//                    
//        //            platform.create( sanInfo.transform( sad ), reportId  );
//         System.out.println("INSERT " + pp);
//                    
//                }
//                
//                System.out.println("insertableSrcAnswers size is " + insertableSrcAnswers.size());
//                System.out.println("updateableSrcAnswers size is " + updateableSrcAnswers.size());
//                System.out.println("TBaWaWEBL size is " + ( updateableSrcAnswers.size() + insertableSrcAnswers.size() ) );
//                
//                int numUTotAns = 0;
//                int numUSortAns = 0;
//                int numUWeightAns = 0;
//                int numUSingleAns = 0;
//                int numUNumAns = 0;
//                int numUTextAns = 0;
//                int numUMultAns = 0;
//                int numUMultTextAns = 0;
//                int numUMultSingAns = 0;
//                int numUMultNumAns = 0;
//                    
//                for ( Iterator<SourceAnswersDataSetInfo> u = updateableSrcAnswers.iterator(); u.hasNext(); ) {
//                    SourceAnswersDataSetInfo sad = u.next();
//                    numUTotAns++;
//                    String qType = sad.getQst_type();
//                    if ( qType.equalsIgnoreCase("WEIGHT")) numUWeightAns++;
//                    else if ( qType.equalsIgnoreCase("SORT")) numUSortAns++;
//                    else if ( qType.equalsIgnoreCase("MULTI"))  { 
//                        numUMultAns++; 
//                        String qmqQstType = sad.getQmq_Qst_Type();
//                        if ( qmqQstType.equalsIgnoreCase("SINGLE")) {
//                            numUMultSingAns++;
//                        } else if ( qmqQstType.equalsIgnoreCase("DATA")) {
//                            numUMultNumAns++;
//                        } else if ( qmqQstType.equalsIgnoreCase("TEXT")) {
//                            numUMultTextAns++;
//                        }
//                    }
//                    else if ( qType.equalsIgnoreCase("DATA")) numUNumAns++;
//                    else if ( qType.equalsIgnoreCase("TEXT")) numUTextAns++;
//                    else if ( qType.equalsIgnoreCase("SINGLE")) numUSingleAns++;
//                }
//                int numITotAns = 0;
//                int numISortAns = 0;
//                int numIWeightAns = 0;
//                int numISingleAns = 0;
//                int numINumAns = 0;
//                int numITextAns = 0;
//                int numIMultAns = 0;
//                int numIMultTextAns = 0;
//                int numIMultSingAns = 0;
//                int numIMultNumAns = 0;
//                    
//                for ( Iterator<SourceAnswersDataSetInfo> i = insertableSrcAnswers.iterator(); i.hasNext(); ) {
//                    SourceAnswersDataSetInfo sad = i.next();
//                    numITotAns++;
//                    String qType = sad.getQst_type();
//                    if ( qType.equalsIgnoreCase("WEIGHT")) numIWeightAns++;
//                    else if ( qType.equalsIgnoreCase("SORT")) numISortAns++;
//                    else if ( qType.equalsIgnoreCase("MULTI"))  { 
//                        numIMultAns++; 
//                        String qmqQstType = sad.getQmq_Qst_Type();
//                        if ( qmqQstType.equalsIgnoreCase("SINGLE")) {
//                            numIMultSingAns++;
//                        } else if ( qmqQstType.equalsIgnoreCase("DATA")) {
//                            numIMultNumAns++;
//                        } else if ( qmqQstType.equalsIgnoreCase("TEXT")) {
//                            numIMultTextAns++;
//                        }
//                    }
//                    else if ( qType.equalsIgnoreCase("DATA")) numINumAns++;
//                    else if ( qType.equalsIgnoreCase("TEXT")) numITextAns++;
//                    else if ( qType.equalsIgnoreCase("SINGLE")) numISingleAns++;
//                }
//        
//        
//                System.out.println("\n*******************\nUPDATEABLE SRC ANSWERS BREAKUP\n***********");
//                System.out.println("numUSingleAns ==> " + numUSingleAns);
//                System.out.println("numUWeightAns ==> " + numUWeightAns);
//                System.out.println("numUMultAns ==> " + numUMultAns);
//                System.out.println("        numUMultSingAns ==> " + numUMultSingAns);
//                System.out.println("        numUMultNumAns ==> " + numUMultNumAns);
//                System.out.println("        numUMultTextAns ==> " + numUMultTextAns);
//                System.out.println("numUSortAns ==> " + numUSortAns);
//                System.out.println("numUNumAns ==> " + numUNumAns);
//                System.out.println("numUTextAns ==> " + numUTextAns);            
//                System.out.println("TBaWaWEBL U ANS  ==> " + numUTotAns);
//                
//                    
//                System.out.println("\n*******************\nINSERTEABLE SRC ANSWERS BREAKUP\n***********");
//                System.out.println("numISingleAns ==> " + numISingleAns);
//                System.out.println("numIWeightAns ==> " + numIWeightAns);
//                System.out.println("numIMultAns ==> " + numIMultAns);
//                System.out.println("        numIMultSingAns ==> " + numIMultSingAns);
//                System.out.println("        numIMultNumAns ==> " + numIMultNumAns);
//                System.out.println("        numIMultTextAns ==> " + numIMultTextAns);
//                System.out.println("numISortAns ==> " + numISortAns);
//                System.out.println("numINumAns ==> " + numINumAns);
//                System.out.println("numITextAns ==> " + numITextAns);            
//                System.out.println("TBaWaWEBL I ANS  ==> " + numITotAns);
//                
//            } else {
//                // errors exist revert existing lock
//                
//                theLockInfo.setOtlStatus(PlatformAppModuleService.PENDING_STATUS);
//                
//                platform.update( theLockInfo );
//                
//                platform.commitAll();
//                
//            }
//        
//        
//        } // ends else for if (!isValid) 
//        
//        
//    }
//
//    private static List extractKeysList(final Map aMap) { //(Map<Integer, ArrayList<Integer>> mp_qstnInfoCols) {
//        List aList = null;
//        if ( aMap != null && aMap.size() != 0) {
//            aList = new ArrayList();
//            
//            Set aSet = aMap.keySet();
//            for( Iterator it =  aSet.iterator(); it.hasNext(); ) {
//                aList.add( it.next() );
//            }
//        }
//        
//        return aList;
//    }
//   
//}
