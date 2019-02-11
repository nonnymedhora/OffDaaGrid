/**
 * @author Nonny Medhora
 */
package com.bawaweb.services;

import com.bawaweb.appmodule.PlatformAppModuleImpl;
import com.bawaweb.core.ApplicationException;
import com.bawaweb.grid.templates.data.ReportTemplateInfo;
import com.bawaweb.grid.templates.data.ReportTemplateInfoDataSet;
import com.bawaweb.grid.templates.data.cursors.EditorGeneralInfo;
import com.bawaweb.grid.templates.data.cursors.LeadReporterGeneralInfo;
import com.bawaweb.grid.templates.data.cursors.MultiQuestionDataSetInfo;
import com.bawaweb.grid.templates.data.cursors.QuestionDataSetInfo;
import com.bawaweb.grid.templates.data.cursors.ReportGeneralInfo;
import com.bawaweb.grid.templates.data.cursors.ReportGeneralInfoDataSet;
import com.bawaweb.grid.templates.data.cursors.ReporterGeneralInfo;
import com.bawaweb.grid.templates.data.cursors.ReporterGeneralInfoDataSet;
import com.bawaweb.grid.templates.data.cursors.RoleScopeInfo;
import com.bawaweb.grid.templates.data.cursors.RoleScopeInfoDataSet;
import com.bawaweb.grid.templates.data.cursors.SourceAnswersDataSet;
import com.bawaweb.grid.templates.data.cursors.SourceAnswersDataSetInfo;
import com.bawaweb.grid.templates.data.tables.AnswerSetValuesDataSet;
import com.bawaweb.grid.templates.data.tables.AnswerSetValuesDataSetComparator;
import com.bawaweb.grid.templates.data.tables.AnswerSetValuesDataSetInfo;
import com.bawaweb.grid.templates.data.tables.AnswerSetsDataSetInfo;
import com.bawaweb.grid.templates.data.tables.ReportAnswerSetValuesDataSet;
import com.bawaweb.grid.templates.data.tables.ReportAnswerSetValuesDataSetComparator;
import com.bawaweb.grid.templates.data.tables.ReportAnswerSetValuesDataSetInfo;
import com.bawaweb.grid.templates.data.tables.ReportSourcesDataSet;
import com.bawaweb.grid.templates.data.tables.ReportSourcesDataSetInfo;
import com.bawaweb.grid.templates.data.tables.ReporterSourcesDataSet;
import com.bawaweb.grid.templates.data.tables.ReporterSourcesDataSetInfo;
import com.bawaweb.grid.templates.data.tables.SortingCriteriaValuesDataSetInfo;
import com.bawaweb.grid.templates.data.tables.SourceDataSetInfo;
import com.bawaweb.grid.templates.data.tables.TallyRangeLimitsValuesDataSetInfo;
import com.bawaweb.lifecycle.DBInstanceVO;
import com.bawaweb.lifecycle.EditorInfoVO;
import com.bawaweb.lifecycle.LeadReporterInfoVO;

import com.bawaweb.lifecycle.EmployeeInfoVO;
import com.bawaweb.lifecycle.MultiQuestionsInfoVO;
import com.bawaweb.lifecycle.OtlTabLocksVO;
import com.bawaweb.lifecycle.QuestionsInfoVO;
import com.bawaweb.lifecycle.RoleScopeVO;
import com.bawaweb.lifecycle.SingleAnswerSetInfoVO;
import com.bawaweb.lifecycle.SortCriteriaInfoVO;
import com.bawaweb.lifecycle.SourceMultiAnswerInfoVO;
import com.bawaweb.lifecycle.SourcesAnswerInfoVO;
import com.bawaweb.lifecycle.SourcesInfoVO;
import com.bawaweb.lifecycle.SourcesSingleQuestionAnswersVO;
import com.bawaweb.lifecycle.SourcesSortingCriteriaSetInfoVO;
import com.bawaweb.lifecycle.TallyRangeLimitsVO;
import com.bawaweb.lifecycle.model.AnswerSetsVO;
import com.bawaweb.lifecycle.model.OtlAnswerSetValuesVO;
import com.bawaweb.lifecycle.model.OtlReportAnswerSetValuesVO;
import com.bawaweb.lifecycle.model.ReportSourcesVO;
import com.bawaweb.lifecycle.model.ReporterSourcesVO;
import com.bawaweb.lifecycle.model.SourceIndustriesVO;
import com.bawaweb.servlets.AnswersGridServlet;
import com.bawaweb.utils.Pair;
import com.bawaweb.views.DBInstanceImpl;
import com.bawaweb.views.common.DBInstanceRow;
import com.bawaweb.views.gridcursors.LeadReporterInfoImpl;

import com.bawaweb.views.gridcursors.LeadReporterInfoRowImpl;

import com.bawaweb.views.gridcursors.QuestionsListImpl;

import com.bawaweb.views.gridcursors.QuestionsListRowImpl;

import com.bawaweb.views.gridcursors.SourcesListImpl;

import com.bawaweb.views.gridcursors.common.AnsGridErrFileInfo;
import com.bawaweb.views.gridcursors.common.AnsGridErrFileInfoRow;
import com.bawaweb.views.gridcursors.common.AnswerSetsInfo;
import com.bawaweb.views.gridcursors.common.AnswerSetsInfoRow;
import com.bawaweb.views.gridcursors.common.EditorInfo;
import com.bawaweb.views.gridcursors.common.EditorInfoRow;
import com.bawaweb.views.gridcursors.common.EmployeeInfo;
import com.bawaweb.views.gridcursors.common.LeadReporterInfoRow;
import com.bawaweb.views.gridcursors.common.EmployeeInfoRow;
import com.bawaweb.views.gridcursors.common.LeadReporterInfo;
import com.bawaweb.views.gridcursors.common.MultiAnswerSets;
import com.bawaweb.views.gridcursors.common.MultiAnswerSetsRow;
import com.bawaweb.views.gridcursors.common.MultiQuestionsList;
import com.bawaweb.views.gridcursors.common.MultiQuestionsListRow;
import com.bawaweb.views.gridcursors.common.QuestionsList;
import com.bawaweb.views.gridcursors.common.QuestionsListRow;
import com.bawaweb.views.gridcursors.common.ReportGeneralInfoRow;
import com.bawaweb.views.gridcursors.common.RoleScope;
import com.bawaweb.views.gridcursors.common.RoleScopeRow;
import com.bawaweb.views.gridcursors.common.SingleAnswerSets;
import com.bawaweb.views.gridcursors.common.SingleAnswerSetsRow;
import com.bawaweb.views.gridcursors.common.SortCriteriaSets;
import com.bawaweb.views.gridcursors.common.SortCriteriaSetsRow;
import com.bawaweb.views.gridcursors.common.SourceMultiAnswerSets;
import com.bawaweb.views.gridcursors.common.SourceMultiAnswerSetsRow;
import com.bawaweb.views.gridcursors.common.SourcesAnswerSets;
import com.bawaweb.views.gridcursors.common.SourcesAnswerSetsRow;
import com.bawaweb.views.gridcursors.common.SourcesList;
import com.bawaweb.views.gridcursors.common.SourcesListRow;

import com.bawaweb.views.gridcursors.common.SourcesSingleQuestionAnswers;
import com.bawaweb.views.gridcursors.common.SourcesSortingCriteriaSets;

import com.bawaweb.views.gridcursors.common.SourcesSortingCriteriaSetsRow;

import com.bawaweb.views.gridcursors.common.TableLocksInfo;

import com.bawaweb.views.gridcursors.common.TableLocksInfoRow;
import com.bawaweb.views.gridcursors.common.TallyRangeSets;

import com.bawaweb.views.gridcursors.common.TallyRangeSetsRow;

import com.bawaweb.views.gridcursors.views.common.AllSourcesListView;
import com.bawaweb.views.gridcursors.views.common.AllSourcesListViewRow;
import com.bawaweb.views.gridcursors.views.common.QuestionsListView;
import com.bawaweb.views.gridcursors.views.common.QuestionsListViewRow;
import com.bawaweb.views.gridcursors.views.common.SourceNumReportsReportersLastDateView;
import com.bawaweb.views.gridcursors.views.common.SourceNumReportsReportersLastDateViewRow;
import com.bawaweb.views.gridcursors.views.common.SourcesAnswerSetsView;
import com.bawaweb.views.gridcursors.views.common.SourcesAnswerSetsViewRow;
import com.bawaweb.views.gridcursors.views.common.SourcesListView;
import com.bawaweb.views.gridcursors.views.common.SourcesListViewRow;
import com.bawaweb.views.identify.common.ASVAnswerValues;
import com.bawaweb.views.identify.common.ASVAnswerValuesRow;
import com.bawaweb.views.identify.common.AddAnswerSetForQstn;
import com.bawaweb.views.identify.common.AddAnswerSetForQstnRow;
import com.bawaweb.views.identify.common.DoesSourceAnswerExist;
import com.bawaweb.views.identify.common.DoesSourceAnswerExistRow;
import com.bawaweb.views.identify.common.DoesSourceMultiAnswerExist;
import com.bawaweb.views.identify.common.DoesSourceMultiAnswerExistRow;
import com.bawaweb.views.identify.common.ExtraQstnsAnswerSetValues;
import com.bawaweb.views.identify.common.ExtraQstnsAnswerSetValuesRow;
import com.bawaweb.views.identify.common.ExtraQstnsReportAnswerSetValues;
import com.bawaweb.views.identify.common.ExtraQstnsReportAnswerSetValuesRow;
import com.bawaweb.views.identify.common.GetBestSourceId;
import com.bawaweb.views.identify.common.GetBestSourceIdRow;
import com.bawaweb.views.identify.common.GetErrXLFileInfo;
import com.bawaweb.views.identify.common.GetErrXLFileInfoRow;
import com.bawaweb.views.identify.common.MaxRpsId;
import com.bawaweb.views.identify.common.MaxRpsIdRow;
import com.bawaweb.views.identify.common.MaxAsvId;
import com.bawaweb.views.identify.common.MaxAsvIdRow;
import com.bawaweb.views.identify.common.MaxRavId;
import com.bawaweb.views.identify.common.MaxRavIdRow;
import com.bawaweb.views.identify.common.RAVInfo;

import com.bawaweb.views.identify.common.RAVInfoRow;

import com.bawaweb.views.identify.common.SSCInfo;

import com.bawaweb.views.identify.common.SSCInfoRow;

import com.bawaweb.views.identify.common.ReportLockInfo;
import com.bawaweb.views.identify.common.ReportLockInfoRow;
import com.bawaweb.views.identify.common.SrcAnsUniqueInfo;
import com.bawaweb.views.identify.common.SrcAnsUniqueInfoRow;
import com.bawaweb.views.model.common.AnswerSetValues;
import com.bawaweb.views.model.common.AnswerSetValuesRow;
import com.bawaweb.views.model.common.AnswerSets;
import com.bawaweb.views.model.common.AnswerSetsRow;
import com.bawaweb.views.model.common.CountriesList;
import com.bawaweb.views.model.common.CountriesListRow;
import com.bawaweb.views.model.common.OtlAnswerSetValues;
import com.bawaweb.views.model.common.OtlAnswerSetValuesRow;
import com.bawaweb.views.model.common.OtlReportAnswerSetValues;
import com.bawaweb.views.model.common.OtlReportAnswerSetValuesRow;
import com.bawaweb.views.model.common.ReportAnswerSetValuesRow;
import com.bawaweb.views.model.common.ReporterSources;
import com.bawaweb.views.model.common.Sources;
import com.bawaweb.views.utils.common.CourtesyTitles;
import com.bawaweb.views.utils.common.CourtesyTitlesRow;
import com.bawaweb.views.model.common.Questions;
import com.bawaweb.views.model.common.QuestionsRow;
import com.bawaweb.views.model.common.ReportAnswerSetValues;
import com.bawaweb.views.model.common.ReportSources;
import com.bawaweb.views.model.common.ReportSourcesRow;
import com.bawaweb.views.model.common.SourceAnswers;
import com.bawaweb.views.model.common.SourceAnswersRow;
import com.bawaweb.views.model.common.SourceIndustries;
import com.bawaweb.views.model.common.SourceMultiAnswers;
import com.bawaweb.views.model.common.SourceMultiAnswersRow;
import com.bawaweb.views.model.common.SourceSortingCriteria;

import com.bawaweb.views.model.common.SourceSortingCriteriaRow;

import com.bawaweb.views.model.common.SourcesRow;
import com.bawaweb.views.utils.common.IndustryViews;
import com.bawaweb.views.utils.common.IndustryViewsRow;
import com.bawaweb.views.utils.common.QualityRatings;
import com.bawaweb.views.utils.common.QualityRatingsRow;
import com.bawaweb.views.utils.common.SourceDistributionPreferences;
import com.bawaweb.views.utils.common.SourceDistributionPreferencesRow;
import com.bawaweb.views.utils.common.SuffixTitles;

import com.bawaweb.views.utils.common.SuffixTitlesRow;

import com.bawaweb.views.utils.common.TimeZones;

import com.bawaweb.views.utils.common.TimeZonesRow;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.InputStream;

import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import java.lang.reflect.Field;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jxl.Workbook;

import jxl.read.biff.BiffException;

import jxl.write.WritableWorkbook;

import jxl.write.WriteException;

import oracle.jbo.CSMessageBundle;
import oracle.jbo.SQLStmtException;
import oracle.jbo.domain.Number;

import oracle.jbo.client.Configuration;
import oracle.jbo.domain.Array;
import oracle.jbo.domain.BlobDomain;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Sequence;

import oracle.jbo.server.DBTransaction;

import org.apache.log4j.Logger;

/**
 * The main workshorse implementation behind PlatformAppModuleService.
 * <p>This class should be <b><u>stateless</u></b> as far as possible.
 * <p>This class follows the Singleton, Command and the Front Controller pattern.
 * <p>It is the single point of entry to the database which it interacts with via the <i>PlatformAppModule</i>.
 * <p>PlatformAppModuleImpl implenets this interface for the application module which 
 * <p>is basically a logical container for coordinated adf-bc objects for interacting with the database.
 * <p>
 *  <li>
 *      <ul>It is responsible for constructing the composite ReportTemplateInfo objects.</ul>
 *      <ul>It interacts with the database for the creation and update of objects.</ul>
 *      <ul>It validates the presence of records in the database prior to DML to determine inserts or updates</ul>
 *  </li>
 * <p>For inserts and updates to the database; the general format is as follows:
 * <p>
 *  <p><b><i>create(ObjectVO)</i></b> 
 *  <p><b><i>update(ObjectVO)</i></b> --- the objects are generally from the <b>com.bawaweb.lifecycle</b> package
 * <p>or they may be from the <i>com.bawaweb.grid.templates.data.**</i> and its sub-packages.
 * <p><p>Currently the logic was failing with using ADF-BC when Answers needed to be posted [after extrasources and extraanswers have been posted] 
 * <p>-- so as a workaround
 * <p> i have used prepared-statements instead.
 * 
 */
public final class PlatformAppModuleServiceImpl implements PlatformAppModuleService {

    private PlatformAppModuleImpl platform;
    private static PlatformAppModuleServiceImpl _instance = null;
    private static final Logger LOG = Logger.getLogger(PlatformAppModuleServiceImpl.class);
    private final PlatformApplicationConfig config;
    
    public PlatformApplicationConfig getPlatformApplicationConfig() {
        return config;
    }


    public Configuration getConfigurationInfo() {
        return null;
    }
    
    /**
     * Main constructor -- initializes the ADF-BC Configuration and PlatformAppModule instance which
     * <p> servces as the basis for the RootApplicationModule.
     * <p>It also initializes and stores a reference to the external environment configuration -- PlatformApplicationConfig
     * Note that the constructor is private
     */
    private PlatformAppModuleServiceImpl() {
        Configuration conInfo = new Configuration();
        Class cClass = conInfo.getClass();
        Field[] fields = cClass.getDeclaredFields();
LOG.info("CONFIG INFO");        
        for ( int i = 0; i < fields.length; i++) {
            try {
                LOG.info(fields[i].getName() + " ==> " + fields[i].get(conInfo));
            } catch (IllegalAccessException e) {
                // TODO
            }
        }
        String[] nameConfigs = conInfo.getConfigurationNameList();
        for (int i = 0; i < nameConfigs.length; i++) {
            LOG.info("namedConfig["+i+"] " + nameConfigs[i]);
        }
        
//LOG.info("APPSERVER_CONNECTION_NAME " + Configuration.APPSERVER_CONNECTION_NAME);
//LOG.info("COMMON " + Configuration.COMMON);
// this.platform = (PlatformAppModuleImpl)Configuration.createRootApplicationModule("com.bawaweb.appmodule.PlatformAppModule", "PlatformAppModuleLocal");
        this.platform = (PlatformAppModuleImpl)conInfo.createRootApplicationModule("com.bawaweb.appmodule.PlatformAppModule", "PlatformAppModuleLocal");
        this.config = PlatformApplicationConfig.getApplicationConfig();
        LOG.info("\n****************\n"+ getDBInstance());
    }
    
    /**
     * The convenience method to retrieve the singular instance of this class
     * @return _instance -- the singluar instance of PlatformAppModuleServiceImpl
     */
    public static synchronized PlatformAppModuleServiceImpl getInstance() {
        if (_instance == null) {
            _instance = new PlatformAppModuleServiceImpl();
        }
        return _instance;
    }
    
       
//     public static String capitalize(String s) {  
//         if (s.length() == 0) return s;  
//         return s.substring(0, 1).toUpperCase() + s.substring(1);  
//     }  

     /**
     * Retrieves the complete information for Questions for the report
     * @param rprtId    -- the report id for the report
     * @return qMap -- a LinkedHashMap connecting the question id to its QuestionDataSetInfo object
     */
     public LinkedHashMap<Integer, QuestionDataSetInfo> getQuestions(Number rprtId) {
         LinkedHashMap<Integer, QuestionDataSetInfo> qMap = new LinkedHashMap<Integer, QuestionDataSetInfo>();
         QuestionsInfoVO quest = new QuestionsInfoVO();
         
         QuestionsListView questView = platform.getQuestionsListView();
         questView.setrprt_id(rprtId);
         questView.executeQuery();
         
    LOG.info("QnsCount is " + questView.getEstimatedRowCount());     
         
         while ( questView.hasNext() ) {
             QuestionsListViewRow row = (QuestionsListViewRow) questView.next();
             QuestionDataSetInfo qInfo = quest.transform(quest.transform( row ));  
             
             Number qstId = new oracle.jbo.domain.Number( qInfo.getQst_id() );
             String qType = qInfo.getQst_type();
             
             if ( !qType.equalsIgnoreCase("SORT") ) {
                 AnswerSetsDataSetInfo ansSetInfo = getAnswerSetInfo( qstId );
                 qInfo.setAnswerSetInfo( ansSetInfo );
             }
             
             
             if ( qType.equalsIgnoreCase("SINGLE") ) {
                 List<ReportAnswerSetValuesDataSetInfo> ans = getSingleAnswers(qstId );
    //LOG.info("for single q " + qstId + " list or reportanswersetvalues is " + ans);             
                 qInfo.setSingleAnswerSetsInfo( ans );                
             } else if ( qType.equalsIgnoreCase("MULTI") ) {
                 List<MultiQuestionDataSetInfo> mqList = getMultiQuestionInfo(qstId);
                 qInfo.setMultiQuestionDataSetInfo(mqList);
                 for ( Iterator<MultiQuestionDataSetInfo> mt = mqList.iterator(); mt.hasNext(); ) {
                    MultiQuestionDataSetInfo mds = mt.next();
                    if ( mds.getQmq_type().equalsIgnoreCase("SINGLE") ) {
                        List<ReportAnswerSetValuesDataSetInfo> ans = getSingleAnswers(qstId );
    //LOG.info("for multi q " + qstId + " list or reportanswersetvalues is " + ans);                    
                        qInfo.setSingleAnswerSetsInfo( ans );  
                    }
                 }
                 
             } else if (qType.equalsIgnoreCase("SORT") ) {
                 List<SortingCriteriaValuesDataSetInfo> srtInfo = getSortInfo(rprtId, qstId);
                 qInfo.setSortCriteriaDataSetInfo(srtInfo);
             } else if ( qType.equalsIgnoreCase( "DATA" ) ) {
                 qInfo.setDataTallyOptions(DATA_TALLY_OPTIONS);
                 int qst_tly_id = qInfo.getQst_tly_id();
                 qInfo.setTallyRangeLimitsValuesDataSetInfo(getTallyRangeLimitsValuesDataSetInfoForQstn(qst_tly_id));
             } else if ( qType.equalsIgnoreCase( "WEIGHT" ) ) {
                 qInfo.setDataTallyOptions(DATA_TALLY_OPTIONS);
                 int qst_tly_id = qInfo.getQst_tly_id();
                 qInfo.setTallyRangeLimitsValuesDataSetInfo(getTallyRangeLimitsValuesDataSetInfoForQstn(qst_tly_id));
             }
             
             
             
             
             
             
             qMap.put( row.getQstId().intValue(), qInfo );
             
         }
         
         return qMap;
     }
    
    
    private List<TallyRangeLimitsValuesDataSetInfo> getTallyRangeLimitsValuesDataSetInfoForQstn(int qst_tly_id) {
        List<TallyRangeLimitsValuesDataSetInfo> tInfo = new ArrayList<TallyRangeLimitsValuesDataSetInfo>();
        TallyRangeLimitsVO tallyInfo = new TallyRangeLimitsVO();
        
        TallyRangeSets tView = platform.getTallyRangeSets();
        tView.settly_id( new Number( qst_tly_id ) );
        
        tView.executeQuery();
        
        while ( tView.hasNext() ) {
            TallyRangeSetsRow row = (TallyRangeSetsRow) tView.next();
            tInfo.add( tallyInfo.transform( tallyInfo.transform( row )) );
        }
        return tInfo;
    }
    
    /**
     * Retrieves the complete information for Sources for the report
     * @param rprtId    -- the report id for the report
     * @param rprtrId   -- the reporter's id -- the set of sources is dependant on the reporter id
     * @param editors   -- the list of editors for the report [comprising both lead-reporters and editors]
     * @return sMap -- aLinkedHashMap connecting the ReportSourceId [rps id] to the SourceDataSetInfo object
     */
    public LinkedHashMap<Integer, SourceDataSetInfo> getSources(Number rprtId, Number rprtrId, List<Integer> editors) {
    LOG.info("in getSourcesgetSources rprtid is " + rprtId + " and reprotrid is " + rprtrId);     
    LOG.info("editorids is " + editors);
    
        LinkedHashMap<Integer, SourceDataSetInfo> sMap = new LinkedHashMap<Integer, SourceDataSetInfo>();
        SourcesInfoVO src = new SourcesInfoVO();
        // show all srcs if is an editir
        if ( editors.contains( rprtrId.intValue() ) ) {
LOG.info( "rprtr is an editor ");        
            AllSourcesListView srcView = platform.getAllSourcesListView();
            srcView.setrprt_id( rprtId );
            srcView.executeQuery();
            
LOG.info("query to get allsources was >>|" + srcView.getQuery() + "<<|");
            
            while ( srcView.hasNext() ) {
                AllSourcesListViewRow row = (AllSourcesListViewRow) srcView.next();
                sMap.put( row.getRpsId().intValue(), src.transform(src.transform(row)));
            }
LOG.info( " for rprtid " + rprtId + " and for reporterid " + rprtrId + " --> getSources Found: " + sMap.size() + " sources -- the map of sources found is: ");
            printMap( sMap );
        } else {
            // only show the reporters assigned sources
            SourcesListView srcView = platform.getSourcesListView();
            srcView.setrprt_id( rprtId );
            srcView.setrprtr_id( rprtrId );
            srcView.executeQuery();
            
LOG.info("query to get sources was >>|" + srcView.getQuery() + "<<|");
    
            while ( srcView.hasNext() ) {
                SourcesListViewRow row = (SourcesListViewRow) srcView.next();
                sMap.put( row.getRpsId().intValue(), src.transform(src.transform(row)));
            }
    LOG.info( " for rprtid " + rprtId + " and for reporterid " + rprtrId + " --> getSources Found: " + sMap.size() + " sources -- the map of sources found is: ");
    printMap( sMap );
            
        }
        
        return sMap;
    }
    /**
     * Retrieves the MultiQuestion Info for a particular question id
     * @param qstId -- the question id
     * @return qmqList -- a list of MultiQuestionDataSetInfo objects belonging to the said question id
     * NOTE that the table BAwaWEb_MULTI_QUESTIONS is a child table of BAwaWEb_QUESTIONS and are related as follows:
     * BAwaWEb_MULTI_QUESTIONS.QMQ_QST_ID = BAwaWEb_QUESTIONS.QST_ID
     */
    public List<MultiQuestionDataSetInfo> getMultiQuestionInfo(Number qstId) {
        List<MultiQuestionDataSetInfo> qmqList = new ArrayList<MultiQuestionDataSetInfo>();
        MultiQuestionsInfoVO mqInfo = new MultiQuestionsInfoVO();
        
        MultiQuestionsList mqListView = platform.getMultiQuestionsListView();
        mqListView.setqst_id(qstId);
        
        mqListView.executeQuery();
        
        while ( mqListView.hasNext() ) {
            MultiQuestionsListRow row = (MultiQuestionsListRow) mqListView.next();
            
            if ( row.getQmqType().equalsIgnoreCase("SINGLE") ) {
                List<ReportAnswerSetValuesDataSetInfo> ans = getMultiSingleAnswerSets(qstId );
                row.setSingleAnswerSetsInfo(ans);
            } else if (row.getQmqType().equalsIgnoreCase("DATA") ) {
                row.setDataTallyOptions(DATA_TALLY_OPTIONS);
                int qst_tly_id = row.getQmqTlyId().intValue();
                row.setTallyRangeLimitsValuesDataSetInfo(getTallyRangeLimitsValuesDataSetInfoForQstn(qst_tly_id));
            } 
           
            
            qmqList.add(mqInfo.transform(mqInfo.transform(row)));
        }
        return qmqList;
    }
    
    /**
     * Retrieves the SortingCriteriaValues information given the question id and the answer / sort-criteron
     * @param qstId -- the question id [ note that in the grid this value is negative ], here it is positive
     * @param answer -- the sort-criterion
     * @return scvId -- the scv id  from the BAwaWEb_SORTING_CRITERIA_VALUES table ( if zero then it is invalid )
     */
    public int getSSCInfo(int qstId, String answer) {
        SSCInfo sscView = platform.getSSCInfo();
        
        
        qstId =  qstId < 0 ? ( -1 * qstId ) : qstId; 
                
        sscView.setqst_id( new Number ( qstId ) );
        sscView.setanswer( answer );
        
        sscView.executeQuery();
        
        while ( sscView.hasNext() ) {
            SSCInfoRow row = ( SSCInfoRow ) sscView.next();
            
            return row.getScvId().intValue();
        }
        
        return 0;
    }
    
    /**
     * Retrieves the ReportAnswerSetValues informationf for the report-answer-set id and the answer provided
     * @param rasId -- the report answer set id
     * @param answer -- the answer
     * @return ravId -- the report answer set values id from the BAwaWEb_REPORT_ANSWER_SET_VALUES table ( if zero then it is invalid )
     */
    public int getRavInfo(int rasId, String answer) { 
            RAVInfo ravView = platform.getRAVInfo();
            
            ravView.setras_id( new Number ( rasId ) );
            ravView.setanswer( answer );
            
            ravView.executeQuery();
            
            while ( ravView.hasNext() ) {
                RAVInfoRow row = ( RAVInfoRow ) ravView.next();
                
                return row.getRavId().intValue();
            }
        return 0;
    }
    
    
    /**
     * Retrieves the list of existing report-answer-set-values for a particular question;
     * these are used to populate the drop-downs for <b>single</b>-part questions
     * @param qstId -- the question id
     * @return ansList -- a list of ReportAnswerSetValuesDataSetInfo objects pertaining to that question
     */
    public List<ReportAnswerSetValuesDataSetInfo> getSingleAnswers(Number qstId) {
        List<ReportAnswerSetValuesDataSetInfo> ansList = new ArrayList<ReportAnswerSetValuesDataSetInfo>();
        SingleAnswerSetInfoVO ans = new SingleAnswerSetInfoVO();
        
        
        SingleAnswerSets ansView = platform.getSingleAnswerSetsView();
        ansView.setqst_id( qstId );
        
        ansView.executeQuery();
//LOG.info( "qst id id " + qstId + " and ansView.executeQuery() s " + ansView.getQuery()  );      
        while ( ansView.hasNext() ) {
            SingleAnswerSetsRow row =(SingleAnswerSetsRow) ansView.next();
            ansList.add( ans.transform( ans.transform(row) ) );
        }
        
        return ansList;
    }
    
    
    /**
     * Retrieves the AnswerSetsDataSetInfo information (BAwaWEb_ANSWER_SETS) for a particular question
     * it is not being used now to populate the drop-downs; because the ANS_ID is null in some cases
     * for SINGLE type questions; we are now using RAS_ID instead
     * @param qstId -- the question id
     * @return ans -- the AnswerSetsDataSetInfo in connection with the question id -- null if invalid 
     */
    public AnswerSetsDataSetInfo getAnswerSetInfo(Number qstId) {
        AnswerSetsVO ans = new AnswerSetsVO();
        
        AnswerSetsInfo ansInfoView = platform.getAnswerSetsInfo();
        ansInfoView.setqst_id( qstId );
        ansInfoView.executeQuery();
        
        if ( ansInfoView.hasNext() ) {
            AnswerSetsInfoRow row = (AnswerSetsInfoRow) ansInfoView.next();
            return  ans.transform( ans.transform(row) );
         }
         
         return null;
    }
    
    
    /**
     * Retrieves the list of existing report-answer-set-values for a particular question;
     * these are used to populate the drop-downs for the <b>single</b>-part portion of multi-questions
     * @param qstId
     * @returnansList -- a list of ReportAnswerSetValuesDataSetInfo objects pertaining to that question
     */
    public List<ReportAnswerSetValuesDataSetInfo> getMultiSingleAnswerSets(Number qstId) {
        List<ReportAnswerSetValuesDataSetInfo> ansList = new ArrayList<ReportAnswerSetValuesDataSetInfo>();
        SingleAnswerSetInfoVO ans = new SingleAnswerSetInfoVO();
        
        MultiAnswerSets ansView = platform.getMultiAnswerSetsView();
        ansView.setqst_id( qstId );
        
        ansView.executeQuery();
        
        while ( ansView.hasNext() ) {
            MultiAnswerSetsRow row =(MultiAnswerSetsRow) ansView.next();
            ansList.add( ans.transform( ans.transform(row) ) );
        }
        
        return ansList;
    }
    
    
    
    /**
     * Retrieves a list of SortingCriteriaValues [ BAwaWEb_SORTING_CRITERIA_VALUES ] for a report given the sorting criteria  
     * @param rprtId -- the report id
     * @param qstId --  the question id, here it refers to the SCV_SRT_ID in the BAwaWEb_SORTING_CRITERIA_VALUES table
     * <p> which is a fk to the BAwaWEb_SORTING_CRITERIA table
     * @return srtInfoList --  a List of SortingCriteriaValuesDataSetInfo objects 
     */
    public List<SortingCriteriaValuesDataSetInfo> getSortInfo(Number rprtId, Number qstId) {
        List<SortingCriteriaValuesDataSetInfo> srtInfoList = new ArrayList<SortingCriteriaValuesDataSetInfo>();
        SortCriteriaInfoVO srt = new SortCriteriaInfoVO();
        
        SortCriteriaSets srtView = platform.getSortCriteriaSetsView();
        srtView.setrprt_id( rprtId );
        qstId = qstId.intValue() < 0 ? new Number((-1*qstId.intValue())) : qstId;
        srtView.setqst_id( qstId );
        
        
        srtView.executeQuery();
               
        while ( srtView.hasNext() ) {
            SortCriteriaSetsRow row = (SortCriteriaSetsRow) srtView.next();
            srtInfoList.add( srt.transform( srt.transform( row ) ) );
            
        }
        
        return srtInfoList;
    }
    
    
    /**
     * Retrieves the collection of all source answers for a report for a particular question from all sources
     * @param qnInfo    -- the QuestionDataSetInfo object
     * @param rprtid    -- the report id
     * @param rpsIds    -- the set of report-source-id's -- the collection of sources for a report
     * @return srcAnsMap -- a LinkedHashMap connecting the report-source-id [rps] to the SourceAnswersDataSetInfo information for the Source.
     * NOTE that for MULTI questions the rps is constructed as : <i>rps + 00 + qmqNumber</i>
     */
    public LinkedHashMap<Integer, SourceAnswersDataSetInfo> getQuestionAnswersDataSet(QuestionDataSetInfo qnInfo, Number rprtid, Set<Integer> rpsIds) {
        LinkedHashMap<Integer, SourceAnswersDataSetInfo> srcAnsMap = new LinkedHashMap<Integer, SourceAnswersDataSetInfo>();
        
        String qType = qnInfo.getQst_type();
LOG.info("\n__________________________________________\nqType in getQuestionAnswersDataSet is " + qType);        
        int qst_id  = qnInfo.getQst_id();
        
        int rasId = qnInfo.getQst_ras_id();
LOG.info( "qst_id is " + qst_id);
LOG.info( "rprt_id is " + rprtid);
        SourcesAnswerInfoVO srcAnsInfo;
        
        Map<Integer, SourceAnswersDataSetInfo> sads = new LinkedHashMap<Integer, SourceAnswersDataSetInfo>();
        
        if ( qType.equalsIgnoreCase( "MULTI") ) {
            srcAnsInfo = new SourcesAnswerInfoVO();
            
            srcAnsInfo.setQstType( qType);
            srcAnsInfo.setSraQstId( new Number ( qst_id ) );
            SourceMultiAnswerSets smaView = platform.getSourceMultiAnswerSetsView();
            
            smaView.setqst_id( new Number(qst_id) );
LOG.info("qst_id is " + qst_id);            
            smaView.setrprt_id( rprtid );
            
            smaView.executeQuery();
            while ( smaView.hasNext() ) {
                SourceMultiAnswerSetsRow row = (SourceMultiAnswerSetsRow) smaView.next();      
                String qmq_qst_type = row.getQmqType();
                String qmq_number = row.getQmqNumber();
                Number qmq_id = row.getQmqId();
                Number qmq_qst_id = row.getQmqQstId();
                String qstType = row.getQstType();
LOG.info("from row - qstType is " + qstType + "qmq_number is " + qmq_number + " qmq_id is " + qmq_id +"qst_id is " + qst_id);
                
                int rps_id = row.getSraRpsId() != null ? row.getSraRpsId().intValue() : 0;
LOG.info("rps_id is " + rps_id);   
LOG.info("rav_id val is " + row.getRavId());

                Number sra_id = row.getSraId();
                Number sma_sra_id = row.getSmaSraId();

                // we only want the collection of answers from the sources
                // the reporter goes to
                if ( row.getSraRpsId() != null && rpsIds.contains( rps_id ) ) {
                    srcAnsInfo.setQmqId( qmq_id );
                    srcAnsInfo.setSraRpsId( new Number( rps_id ) );
                    
                    
                    srcAnsInfo.setQmqNumber( qmq_number );
                    srcAnsInfo.setSraId( sra_id );
                    srcAnsInfo.setSmaSraId( sma_sra_id );
                    srcAnsInfo.setQmqQstType( qmq_qst_type );
                    srcAnsInfo.setRavId( row.getRavId() );          // null if qmq_qst_type is data for the mq
                    srcAnsInfo.setQstType( qstType );//( qType );
                    srcAnsInfo.setQmqQstId( qmq_qst_id );
                    srcAnsInfo.setSraQstId( qmq_qst_id );
                    
                    
                    
                    
                    String key = rps_id + "00" + qmq_number;
    LOG.info("INITIAL multi to map   srcAnsINfo  is \n " + srcAnsInfo + "\n*****************************\n");   
                    SourceAnswersDataSetInfo sad = srcAnsInfo.transform( row );
    LOG.info("ADDING multi to map   key is " + key + " [mod] ans is \n " + sad + "\n------------=====================-----------\n");                
                    srcAnsMap.put( Integer.parseInt(key), sad );//srcAnsInfo.transform(row) );
                }
                
            }
            
            
        } else if (    qType.equalsIgnoreCase( "DATA" )    || 
                    qType.equalsIgnoreCase( "WEIGHT" )  || 
                    qType.equalsIgnoreCase( "TEXT" )    || 
                    qType.equalsIgnoreCase( "SINGLE")   || 
                    qType.equalsIgnoreCase( "RATING" )   ) {
            
            srcAnsInfo = new SourcesAnswerInfoVO();
            srcAnsInfo.setQstType( qType);
            
            SourcesAnswerSetsView sraView = platform.getSourcesAnswerSetsView();
            
            sraView.setqst_id( new Number(qst_id) );
            sraView.setrprt_id( rprtid );
            
            sraView.executeQuery();
LOG.info("generic SourcesAnswerSetsView query size is " + sraView.getEstimatedRowCount());

            while ( sraView.hasNext() ) {
                SourcesAnswerSetsViewRow row = (SourcesAnswerSetsViewRow) sraView.next();
                
                int rps_id = row.getSraRpsId().intValue();
                
LOG.info( "rps_id in other qstns is " + rps_id + " for qst_id " + qst_id );

                // we only want the collection of answers from the sources
                // the reporter goes to
                if ( rpsIds.contains( rps_id ) ) {
                    int sra_id = row.getSraId().intValue();
                    
                    srcAnsInfo.setSraId( new Number( sra_id ) );
                    srcAnsInfo.setSraRpsId( new Number( rps_id ) );
                    
                    
                    srcAnsInfo.setQstType( qType );
                    
                    SourceAnswersDataSetInfo theSrcAnsInfo = srcAnsInfo.transform( srcAnsInfo.transform( row ) );
                        srcAnsMap.put(rps_id, theSrcAnsInfo);
                }
                
            }
            
            
            
        } else if ( qType.equalsIgnoreCase( "SORT") ) {
            srcAnsInfo = new SourcesAnswerInfoVO();
            srcAnsInfo.setQstType( qType);
            srcAnsInfo.setSraQstId( new Number( qst_id )  );
            SourcesSortingCriteriaSets srcSrtView = platform.getSourcesSortingCriteriaSetsView();
            
            srcSrtView.setqst_id( new Number(qst_id) );
            srcSrtView.setrprt_id( rprtid );
            
            srcSrtView.executeQuery();
            
            while ( srcSrtView.hasNext() ) {
                SourcesSortingCriteriaSetsRow row = (SourcesSortingCriteriaSetsRow) srcSrtView.next();
                int scv_id = row.getScvId().intValue();
                int rps_id = row.getSscRpsId().intValue();
LOG.info("rps_id for sort is " + rps_id );
                // we only want the collection of answers from the sources
                // the reporter goes to
                if ( rpsIds.contains( rps_id ) ) {
                    srcAnsInfo.setSraId( new Number( scv_id ) );
                    srcAnsInfo.setSraRpsId( new Number( rps_id ) );
                    
                    
                    srcAnsMap.put(rps_id, srcAnsInfo.transform( row ) );
                }
            }
        }
        
        
        
        
        return srcAnsMap;
    }
    
    
    
    /**
     * Retrieves the List of LeadReporters associated to a report
     * @param rprtId -- the report id
     * @return leadRepList -- a list of LeadReporterGeneralInfo objects
     */
    public List<LeadReporterGeneralInfo> getLeadReporters(Number rprtId) {
        List<LeadReporterGeneralInfo> leadRepList = new ArrayList<LeadReporterGeneralInfo>();
        LeadReporterInfoVO leadRepInfo = new LeadReporterInfoVO();
        LeadReporterInfo leadRepView = platform.getLeadReporterInfo();
        leadRepView.setrprt_id(rprtId);
        
        leadRepView.executeQuery();
        while ( leadRepView.hasNext() ) {
            LeadReporterInfoRow row = (LeadReporterInfoRow) leadRepView.next();
            leadRepList.add( leadRepInfo.transform( leadRepInfo.transform(row) ) );
        }
        
        return leadRepList;
    }
    
    
    
    /**
     * Retrieves the List of Editors associated to a report
     * @param rprtId -- the report id
     * @return edList -- a list of EditorGeneralInfo objects
     * NOTE -- the size of this should always be 1 since each report has only 1 editor
     */    
    public List<EditorGeneralInfo> getEditors(Number rprtId) {
        List<EditorGeneralInfo> edList = new ArrayList<EditorGeneralInfo>();
        EditorInfoVO edInfo = new EditorInfoVO();
        EditorInfo edView = platform.getEditorInfo();
        edView.setrprtId( rprtId );
        
        edView.executeQuery();
        while ( edView.hasNext() ) {
            EditorInfoRow row = (EditorInfoRow) edView.next();
            edList.add( edInfo.transform( edInfo.transform(row) ) );
        }
        
        return edList;
    }
    
    /**
     * Creates and returns a  LeadReporterInfoVO object
     * @param leadRepInfo   -- the LeadReporterInfoVO object to be created
     * @return leadRepInfo  -- the same object information after it has been created in the database
     * Inserts a record into the table 
     */
    public LeadReporterInfoVO create(LeadReporterInfoVO leadRepInfo) {
        LeadReporterInfo leadRepView = platform.getLeadReporterInfo();
        LeadReporterInfoVO leadRep = new LeadReporterInfoVO();
        
        leadRepView.insertRow( leadRep.transform(leadRepView,leadRepInfo) );
        
        
        return leadRepInfo;
    }
    
    
    
    /**
     * Creates and returns a  EditorInfoVO object
     * @param editorInfo   -- the EditorInfoVO object to be created
     * @return editorInfo  -- the same object information after it has been created in the database
     * Inserts a record into the table
     */
    public EditorInfoVO create(EditorInfoVO editorInfo) {
        EditorInfo edView = platform.getEditorInfo();
        EditorInfoVO eddy = new EditorInfoVO();
        
        edView.insertRow( eddy.transform(edView,editorInfo) );
        
        
        return editorInfo;
    }
    
    
    
    /**
     * Creates and returns a  TallyRangeLimitsVO object
     * @param tInfo   -- the TallyRangeLimitsVO object to be created
     * @return tInfo  -- the same object information after it has been created in the database
     */
    public TallyRangeLimitsVO create(TallyRangeLimitsVO tInfo) {
        TallyRangeSets tView = platform.getTallyRangeSets();        
        TallyRangeLimitsVO tally = new TallyRangeLimitsVO();
        
        tView.insertRow( tally.transform(tView,tInfo) );
        
        
        return tInfo;
    }
    

        
        
    
    /**
     * Creates and returns a  TallyRangeLimitsVO object
     * @param lockInfo   -- the TallyRangeLimitsVO object to be created
     * @return lockInfo  -- the same object information after it has been created in the database
     * Inserts a record into the BAwaWEb_TAB_LOCKS table
     */
    public OtlTabLocksVO create(OtlTabLocksVO lockInfo) {
        TableLocksInfo tabView = platform.getTableLocksInfo();
        OtlTabLocksVO theLock = new OtlTabLocksVO();
        TableLocksInfoRow row = theLock.transform(tabView, lockInfo, platform);
        tabView.insertRow( row );
        return theLock.transform( row );
    }
    
    
    /**
     * Retrieves the OtlTabLocksVO information in connection with a given lockid, reportid and reporter id
     * from the BAwaWEb_TAB_LOCKS table. Is invalid if null or if the lockid is zero.
     * @param lockId    -- the id in the bawaweb_tab_locks tables
     * @param reportId  -- the report id
     * @param reporterId -- the reporter id
     * @return OtlTabLocksVO -- the information pertaining to the lockid
     */
    public OtlTabLocksVO getLockInfo(int lockId, int reportId, int reporterId) {
        if ( lockId == 0 ) throw new IllegalArgumentException("Error lock id is zero");
        TableLocksInfo tabView = platform.getTableLocksInfo();
        tabView.setotl_id( new Number( lockId ) );
        tabView.setemp_id( String.valueOf(reporterId) );
        tabView.settab_id( new Number( reportId ) );
        tabView.settab_name("RPRT_REPORTS");
        
//LOG.info("TABLOCKS Q is \n" + tabView.getQuery() );  

        try {
            tabView.executeQuery();
            if ( tabView.hasNext() && tabView.getEstimatedRowCount() > 0 ) {
                TableLocksInfoRow row = ( TableLocksInfoRow ) tabView.next();
                OtlTabLocksVO thelock = new OtlTabLocksVO();
                return thelock.transform( row );
            }
        }
        catch (Exception e) {
            LOG.error(e);
        }
        
        return null;
    }
    
    
    /**
     * Determines whether a report has been 'locked'. A report is considered LOCKED when 
     * <p> its OTL_STATUS is 'IN_PROCESS' in the table BAwaWEb_TAB_LOCKS
     * @param rprtId    -- the report id -- maps to the column OTL_TAB_ID
     * @return isLocked -- a boolean indicating whether the report is locked.
     * <b>NOTE</b> In some cases the trigger which is supposed to revert the lock [BAwaWEb_TAB_LOCKS]
     * status every 15 minutes if it is IN_PROCESS may fail -- contact the DBA to deal with this problem
     */
    public boolean isReportLocked(int rprtId) {
        ReportLockInfo tabInfo = platform.getReportLockInfo();
        boolean isLocked = false;
        
        tabInfo.settab_id( new Number ( rprtId ));
        tabInfo.settab_name( "RPRT_REPORTS" );
        
        tabInfo.executeQuery();
        
        while ( tabInfo.hasNext() ) {
            ReportLockInfoRow tabRow = (ReportLockInfoRow) tabInfo.next();
            if ( tabRow.getOtlStatus().equalsIgnoreCase(IN_PROCESS_STATUS) ) {
                return isLocked = true;
            }
        }
        
        return isLocked;
        
    }
    
    /**
     * NOT being used
     * @param sanInfo   -- a SourcesAnswerInfoVO object
     * @param reportid  -- a report id
     * @deprecated
     */
    public void create(SourcesAnswerInfoVO sanInfo, int reportid) {
        if ( reportid == 0 ) throw new IllegalArgumentException("Error reportid is zero.....");
        
        String qstType = sanInfo.getQstType();
        try {
            if ( qstType.equalsIgnoreCase("SINGLE") ) {
                SourcesSingleQuestionAnswers singAnsView = platform.getSourcesSingleQuestionAnswers();
                
                SourcesSingleQuestionAnswersVO srcAnsInfo = new SourcesSingleQuestionAnswersVO();
                singAnsView.insertRow( srcAnsInfo.transform( singAnsView, sanInfo, platform));
            }
        
            
        } catch (Exception e) {
            LOG.error("Error", e);  //e.printStackTrace();
        }
    }


    /**
     * NOT being used
     * @param smanInfo  -- a SourceMultiAnswerInfoVO object
     * @return sman -- SourceMultiAnswerInfoVO object
     */
    public SourceMultiAnswerInfoVO create(SourceMultiAnswerInfoVO smanInfo) {
        SourceMultiAnswerSets smanView = platform.getSourceMultiAnswerSetsView();
        SourceMultiAnswerInfoVO sman = new SourceMultiAnswerInfoVO();
        
        smanView.insertRow( sman.transform( smanView, smanInfo, platform ));
        
        return sman;
        
    }
        
    
    /**
     * Utility method which capitalizes the first letter and returns the string input
     * So for example --> capitalize("bcggcbggcb") returns "Bcggcbggcb"
     * @param s -- the string to be capitalized
     * @return  S -- the 'capitalized' string
     */
    public String capitalize(String s) {
        if (s.length() == 0)
            return s;
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
    /**
     * NOT being used
     * @param smanInfo  -- a SourceMultiAnswerInfoVO object
     * @return sman -- SourceMultiAnswerInfoVO object
     */
    
    /**
     * NOT being used
     * @param editorInfo    -- the EditorInfoVO to be updated
     * @param changes   -- the list of its changes
     * @return  a boolean indicating whether the update was successful
     */
    public boolean update(EditorInfoVO editorInfo, List changes) {
        EditorInfo edView = platform.getEditorInfo();
        edView.setrprtId(editorInfo.getRprtId());    
        boolean found = false;
        edView.executeQuery();
        
        while ( edView.hasNext() ) {
            EmployeeInfoRow row = (EmployeeInfoRow) edView.next();
            if ( row.getEmplId().equals( editorInfo.getEmplId() ) ) {
                found = true;
                for (int i = 0; i < changes.size(); i++) {
                    String attribute = changes.get(i).toString();
                    Object value = editorInfo.getAttribute(attribute);
                    row.setAttribute(attribute, value);
                }
            }
        }
        
        if ( found ) {
            edView.setrprtId(null);
            edView.executeQuery();
            
            return true;
        } else {
            edView.setrprtId(null);
            edView.executeQuery();
            
            return false;
        }
    }



    /**
     * NOT being used
     * @param leadRepInfo    -- the LeadReporterInfoVO to be updated
     * @param changes   -- the list of its changes
     * @return  a boolean indicating whether the update was successful
     */ 
    public boolean update(LeadReporterInfoVO leadRepInfo, List changes) {
        com.bawaweb.views.gridcursors.common.LeadReporterInfo leadRepView = platform.getLeadReporterInfo();
        leadRepView.setrprt_id(leadRepInfo.getRprtId());    
        boolean found = false;
        leadRepView.executeQuery();
        
        while ( leadRepView.hasNext() ) {
            LeadReporterInfoRow row = (LeadReporterInfoRow) leadRepView.next();
            if ( row.getEmplId().equals( leadRepInfo.getEmplId() ) ) {
                found = true;
                for (int i = 0; i < changes.size(); i++) {
                    String attribute = changes.get(i).toString();
                    Object value = leadRepInfo.getAttribute(attribute);
                    row.setAttribute(attribute, value);
                }
            }
        }
        
        if ( found ) { 
            leadRepView.setrprt_id(null);
            leadRepView.executeQuery();
            
            return true;
        } else {
            leadRepView.setrprt_id(null);
            leadRepView.executeQuery();
            
            return false;
        }
    }
    
    /**
     * Updates the information in the BAwaWEb_TAB_LOCKS table for the said OtlTabLocksVO object     * 
     * @param theLock   -- the OtlTabLocksVO object whose information needs updating
     * @return a boolean indicating whteher the lock update worked
     */
    public boolean update(OtlTabLocksVO theLock) {
    LOG.info(" in update(OtlTabLocksVO theLock");
        Class theLockClass = theLock.getClass();
        Field[] fields = theLockClass.getDeclaredFields();
        TableLocksInfo lockView = platform.getTableLocksInfo();
        
        boolean found = false;
LOG.info("theLock.getOtlId()  is " +  theLock.getOtlId() );
LOG.info("theLock.getOtlTabName() is " + theLock.getOtlTabName() );
LOG.info("theLock.getOtlTabId() is " + theLock.getOtlTabId() );
LOG.info("theLock.getOtlEmplId() is " + theLock.getOtlEmplId() );

        lockView.setotl_id( theLock.getOtlId() );
        lockView.settab_name( theLock.getOtlTabName() );
        lockView.settab_id( theLock.getOtlTabId() );
        lockView.setemp_id( theLock.getOtlEmplId() );
        
        lockView.executeQuery();
        
LOG.info(lockView.getQuery());
        
        if ( lockView.hasNext() ) {
            TableLocksInfoRow row = ( TableLocksInfoRow ) lockView.next();
LOG.info("LOCKROW is \n" + row);            
            if ( row.getOtlId().equals( theLock.getOtlId() )) {
                found = true;
                
                for (int i = 0; i < fields.length; i++) {
                    String attribute = fields[i].getName();
                    Object value = theLock.getAttribute(attribute);
LOG.info("UPD LOCK -- attr is " + attribute + " val is " + value + " capitalized attr is  " + capitalize( attribute) );                    
                    row.setAttribute( capitalize(attribute), value);
                }
            } else {
                LOG.info("NO lockView.hasNext() for row.getOtlId() is " +  row.getOtlId() + " and theLock.getOtlId()  is  " + theLock.getOtlId() );                
            }
        }
        
        return found;
        
    }
    
    /**
     * NOT being used
     * @param sanInfo    -- the SourcesAnswerInfoVO to be updated
     * @param reportId   -- the id of the report
     * @return  a boolean indicating whether the update was successful
     */ 
    public boolean update(SourcesAnswerInfoVO sanInfo, int reportId) {
        if ( reportId == 0 ) throw new IllegalArgumentException("Error reportid is zero"); 
        boolean found = false;
        String qstType = sanInfo.getQstType();
        try {
            if ( qstType.equalsIgnoreCase("SORT")) {
                SourcesSortingCriteriaSets sortView = platform.getSourcesSortingCriteriaSetsView();
                
                sortView.setqst_id( sanInfo.getQstId() );
                sortView.setrprt_id( new Number( reportId ));
                
                sortView.executeQuery();
                
                while ( sortView.hasNext() ) {
                    SourcesSortingCriteriaSetsRow sortRow = ( SourcesSortingCriteriaSetsRow ) sortView.next();
                    
                    if ( sortRow.getScvId().equals( sanInfo.getScvId() ) && sortRow.getSscRpsId().equals( sanInfo.getSraRpsId() ) ) {
                        found = true;
                        
                        sortRow.setScvId( sanInfo.getScvId() );
                        sortRow.setSscRpsId( sanInfo.getSraRpsId() );
                        sortRow.setScvName( sanInfo.getScvName() );
                        
                        break;
                    }
                    
                    
                }
                
                
                return found;
                
                
            } else if ( qstType.equalsIgnoreCase("MULTI")) {
                SourceMultiAnswerSets smansView = platform.getSourceMultiAnswerSetsView();
                
                smansView.setqst_id( sanInfo.getQstId() );
                smansView.setrprt_id( new Number( reportId ));
                
                smansView.executeQuery();
                
                String qmqQstType = sanInfo.getQmqQstType();
                
                while ( smansView.hasNext() ) {
                    SourceMultiAnswerSetsRow smansRow = ( SourceMultiAnswerSetsRow ) smansView.next();
                    if ( qmqQstType.equalsIgnoreCase("DATA") || qmqQstType.equalsIgnoreCase("TEXT")) {
                        if (    smansRow.getSraId().equals( sanInfo.getSraId() ) && 
                                smansRow.getSraRpsId().equals( sanInfo.getSraRpsId() ) &&
                                smansRow.getQmqId().equals( sanInfo.getQmqId() )
                            ) {
                            found = true;
                            
                            
                            smansRow.setAnswer( sanInfo.getAnswer() );
                            smansRow.setSraAnswerText( sanInfo.getSraAnswerText() );
                            smansRow.setSraColor( sanInfo.getSraColor() );
                            smansRow.setSraComment( sanInfo.getSraComment() );
                            
                            break;
                        }
                        
                        return found;
                    } else if ( qmqQstType.equalsIgnoreCase("SINGLE")) {
                        if (    smansRow.getRavId().equals( sanInfo.getRavId() ) && 
                                smansRow.getSraId().equals( sanInfo.getSraId() ) && 
                                smansRow.getSraRpsId().equals( sanInfo.getSraRpsId() ) &&
                                smansRow.getQmqId().equals( sanInfo.getQmqId()) ) {
                            found = true;
                            
                            
                            smansRow.setAnswer( sanInfo.getAnswer() );
                            smansRow.setSraAnswerText( sanInfo.getSraAnswerText() );
                            smansRow.setSraColor( sanInfo.getSraColor() );
                            smansRow.setSraComment( sanInfo.getSraComment() );
                            
                            break;
                            
                            
                        }
                        
                        return found;
                    }
                    
                }
            } else {        
                SourcesAnswerSetsView srcAnsView = platform.getSourcesAnswerSetsView();
            
                srcAnsView.setqst_id( sanInfo.getSraQstId() );
                srcAnsView.setrprt_id( new Number( reportId ) );
                
                srcAnsView.executeQuery();
                
                while( srcAnsView.hasNext() ) {
                    SourcesAnswerSetsRow  row = ( SourcesAnswerSetsRow ) srcAnsView.next();
                    if ( qstType.equalsIgnoreCase("SINGLE")) {
                        if (    row.getRavId().equals( sanInfo.getRavId() )  ) { 
                            // above getravid is required for single
                            
                              if (  row.getSraId().equals( sanInfo.getSraId() ) && 
                                    row.getSraRpsId().equals( sanInfo.getSraRpsId() ) &&
                                    row.getSraQstId().equals( sanInfo.getSraQstId() ) ) {
                                
                                    found = true;
                                    
                                    
                                    row.setAnswer( sanInfo.getAnswer() );
                                    row.setSraAnswerText( sanInfo.getSraAnswerText() );
                                    row.setSraColor( sanInfo.getSraColor() );
                                    row.setSraComment( sanInfo.getSraComment() );
                                    
                                    break;
                            
                            }
                            
                            return found;
                        } 
                    }
                }      
            } // ends
        } catch ( Exception e) {
            LOG.error("Error", e); 
        }
        
        return found;
        
    }
    
    
    /**
     * NOT being used
     * @param sanInfo    -- the SourcesAnswerInfoVO to be updated
     * @param changes   -- the list of its changes
     * @return  a boolean indicating whether the update was successful
     */ 
    public boolean update(SourcesAnswerInfoVO sanInfo, List changes) {
        SourcesAnswerSetsView sanView = platform.getSourcesAnswerSetsView();
        
        sanView.setqst_id( sanInfo.getSraQstId() );
        
        boolean found = false;
        
        sanView.executeQuery();
        
        while ( sanView.hasNext() ) {
            SourcesAnswerSetsRow  row = ( SourcesAnswerSetsRow ) sanView.next();
            if ( row.getSraRpsId().equals( sanInfo.getSraRpsId()) &&
                 row.getSraQstId().equals( sanInfo.getSraQstId() )) {
                     
                    found = true;
                    
                    for (int i = 0; i < changes.size(); i++) {
                        String attribute = changes.get(i).toString();
                        Object value = sanInfo.getAttribute(attribute);
                        row.setAttribute(attribute, value);
                    }
                    
                    
            }
        }
        
        if ( found ) {
            sanView.setrprt_id(null);
            sanView.executeQuery();
            
            return true;
        } else {
            sanView.setrprt_id(null);
            sanView.executeQuery();
            
            return false;
        }
        
    }
    
    // change refactor names later
     /**
      * NOT being used
      * @param leadRepInfo    -- the LeadReporterInfoVO to be deleted
      * @return  a boolean indicating whether the delete was successful
      */ 
    public boolean delete(LeadReporterInfoVO leadRepInfo) {
        com.bawaweb.views.gridcursors.common.LeadReporterInfo edView = platform.getLeadReporterInfo();
        edView.setrprt_id(leadRepInfo.getRprtId());    
        edView.executeQuery();
        edView.setrprt_id(null);
        boolean found = false;
        while ( edView.hasNext() ) {
            LeadReporterInfoRow row = (LeadReporterInfoRow) edView.next();
            if ( row.getEmplId().equals( leadRepInfo.getEmplId() ) ) {
                found = true;
                row.remove();
                break;
            }
        }
        if ( found ) {
            edView.setrprt_id(null);
            edView.executeQuery();
            
            return true;
        } else {
            edView.setrprt_id(null);
            edView.executeQuery();
            
            return false;
        }
    }
    
    
    
    
    
    
    
    /**
     * Returns information regarding the reporter
     * @param rptrId    -- the id of the reporter
     * @return rptr -- a ReporterGeneralInfo object
     */
    public ReporterGeneralInfo getReporterInfo(Number rptrId) {
        ReporterGeneralInfo rptr = new ReporterGeneralInfoDataSet();
        EmployeeInfoVO empInf = new EmployeeInfoVO();
        EmployeeInfo emplView = platform.getEmployeeInfoView();
        
        emplView.setempl_id( rptrId );
        
        emplView.executeQuery();
        
        if ( emplView.hasNext() ) {
            EmployeeInfoRow row = (EmployeeInfoRow) emplView.next();
            rptr = empInf.transform( empInf.transform(row) );
        }
        return rptr;
    }
    
    
    /**
     * The main workhorse mnethod that populates and returns a ReportTemplateInfo object.
     * <p>The ReportTemplateInfo object contains <b>ALL</b> data necessary for the Answers-Grid
     * @param rprt_id   -- the report id
     * @param reporter_id   -- the reporter id
     * @return reportTemplateInfo --  the ReportTemplateInfo for the said report and reporter
     * <p><b>Retrieves in the following order:</b>
     * <p><li>
     *      <ul>    --  ReportGeneralInfo [ via getReportGeneralInfo() from which information regarding the LeadReporters and Editors are extracted ]</ul>
     *      <ul>    --  the Questions [ via getQuestions() contains all the information regarding the questions in the report ]</ul>
     *      <ul>    --  the Sources [ via getSources() contains all the information regarding the sources applicable for the report and assigned to the reporter ]</ul>
     *      <ul>    --  the Sources Answers [ via getQuestionAnswersDataSet() contains all the answers information]</ul>
     *      <ul>Other utility information which is either applicable only to this or to all reports in general including
     *              <li>
     *                  <ul>SourceDisplayNameStyle -- applicable for a particular report, retrieved from ReportGeneralInfo</ul>
     *                  <ul>CourtesyTitles -- applicable to ALL reports</ul>
     *                  <ul>SuffixTitles -- applicable to ALL reports</ul>
     *                  <ul>Countries -- applicable to ALL reports</ul>
     *                  <ul>TimeZones -- applicable to ALL reports</ul>
     *                  <ul>IndustryViews -- applicable to ALL reports</ul>
     *                  <ul>QualityRatings -- applicable to ALL reports</ul>
     *                  <ul>SourceDistributionPreferences -- applicable to ALL reports</ul>
     *                  
     *              </li>
     *          </ul>
     * </li>
     */
    public ReportTemplateInfo getReportInfo(int rprt_id, int reporter_id) {
        ReportTemplateInfo reportTemplateInfo = new ReportTemplateInfoDataSet();
        
        /**************** removing for v2********************************
        if ( ! getRoleScope(reporter_id) ) {
            LOG.info("You dont have the privileges to see the report");
            return null;//throw new Exception("bbbbbbbbbbbbbbbbbbbb" ); //System.exit(1);
        }
        ****************ends removing for v2 ********************************/
        
        Number rprtId = new Number( rprt_id );
        Number rprtrId = new Number ( reporter_id );
        
        reportTemplateInfo.setReportId(rprt_id);
        reportTemplateInfo.setReporterId(reporter_id);
        
        ReportGeneralInfo reportGeneralInfo = getReportGeneralInfo(reportTemplateInfo);
        
        if ( reportGeneralInfo.getReportType() == null ) {
           LOG.info("Error no data for general info for the report -- returning null ");
           System.out.println("Error no data for general info for the report -- returning null ");
           return null;
        }
        if (reportGeneralInfo.getReportType().equals("81") || 
            reportGeneralInfo.getReportType().equals("82") || 
            reportGeneralInfo.getReportType().equals("85") || 
            reportGeneralInfo.getReportType().equals("86")) {
                    LOG.info("Error invalid report type " +  reportGeneralInfo.getReportType());
                    return null;//System.exit(1);
        }
    
        reportTemplateInfo.setReportGeneralInfo( reportGeneralInfo );
        
        List<Integer> editrIds = new ArrayList<Integer>();
        
        List<LeadReporterGeneralInfo> ledRs = reportGeneralInfo.getTheLeadReporterGeneralInfo();
        for ( LeadReporterGeneralInfo ledRptr : ledRs ) {
            if ( !editrIds.contains( ledRptr.getEditorId() ) )
                editrIds.add( ledRptr.getEditorId() );
            
        }
        // should be one but using list
        List<EditorGeneralInfo> eds = reportGeneralInfo.getTheEditorInfo();
        for (EditorGeneralInfo ed : eds ) {
            if ( !editrIds.contains( ed.getEditorId() ) )
                editrIds.add( ed.getEditorId() );
        }
        
        LinkedHashMap<Integer, QuestionDataSetInfo> questionsDataMap = getQuestions( rprtId );
        
        LinkedHashMap<Integer, SourceDataSetInfo> rpsIdSourcesDataMap =  getSources( rprtId, rprtrId, editrIds );
LOG.info("getsources returned the map size is " + rpsIdSourcesDataMap.size());        
        reportTemplateInfo.setSourcesDataSetMap( rpsIdSourcesDataMap );
        
        
        Set<Integer> rpsIds = rpsIdSourcesDataMap.keySet();
        
        List<SourceDataSetInfo> listOfSources = new ArrayList<SourceDataSetInfo>();
        List<QuestionDataSetInfo> listOfQuestions = new ArrayList<QuestionDataSetInfo>();
        Set<Integer> questionIds = questionsDataMap.keySet();
        
//        Map<Integer, Integer> mpRepSrcIdSrcId = reportTemplateInfo.getMap_RepSrcId_SrcId();
        
        List<SourceAnswersDataSetInfo> li_theAnswers = new ArrayList<SourceAnswersDataSetInfo>();
        
        
        List<QuestionDataSetInfo> li_QuestionsForAdditionalAnswers = new ArrayList<QuestionDataSetInfo> ();
        
        for (Iterator<Integer> it = questionIds.iterator(); it.hasNext(); ) {        
            int qst_id = it.next();
            QuestionDataSetInfo qnInfo = questionsDataMap.get(qst_id);
            
            LinkedHashMap<Integer, SourceAnswersDataSetInfo> questionAnswers = getQuestionAnswersDataSet(qnInfo, rprtId, rpsIds);
            qnInfo.setSourceAnswersDataSets(questionAnswers);
            
            Collection<SourceAnswersDataSetInfo> theQnAnswers = questionAnswers.values();

LOG.info("for qstid " + qst_id + " with type " + qnInfo.getQst_type() + " thqQnAnswers.size is " + theQnAnswers.size());

            li_theAnswers.addAll( theQnAnswers );
            
            if ( canAddAnswerSetsToQuestion( new Number( qst_id) ) ) {
                li_QuestionsForAdditionalAnswers.add( qnInfo );
            }
            
            listOfQuestions.add(qnInfo);
            
LOG.info("li_theAnswers size " + li_theAnswers.size());
LOG.info("listOfQuestions size " + listOfQuestions.size());
        }
        
        reportTemplateInfo.setListOfQuestionsForAdditionalAnswers( li_QuestionsForAdditionalAnswers );
        reportTemplateInfo.setListOfQuestions(listOfQuestions);
        
        reportTemplateInfo.setQuestionsDataSetMap( questionsDataMap );
        
        reportTemplateInfo.setListOfSourceAnswers(li_theAnswers);
        
//        List<Integer> srcRepIds = new ArrayList<Integer>();
        
//        String theSources = "(";                    // will build the query for using sra_rps_id instead of src_id
        for ( Iterator<Integer> it = rpsIds.iterator(); it.hasNext(); ) {        
            int rps_id = it.next();
            SourceDataSetInfo srcInfo = rpsIdSourcesDataMap.get(rps_id);
            listOfSources.add(srcInfo);
//            int rps_id = srcInfo.getRps_id();
            
//            srcRepIds.add(rps_id);
            
            
//            if ( it.hasNext() ) 
//                theSources += rps_id + ", ";
//            else
//                theSources += rps_id + ")";
        }

/**
        SourceDataSetInfo aSource = listOfSources.get(0);
        String style = aSource.getSrc_display_name();
        reportTemplateInfo.setSourceDisplayNameStyle( style );
        **/
LOG.info("( reportGeneralInfo.getRprtSourceDisplayField()); is " +  reportGeneralInfo.getRprtSourceDisplayField());        
        reportTemplateInfo.setSourceDisplayNameStyle( reportGeneralInfo.getRprtSourceDisplayField());

LOG.info("Setting the list of sources for reportid " + rprt_id + " and reporterid " + reporter_id + " to \n___");
this.printList( listOfSources );

        reportTemplateInfo.setListOfSources(listOfSources);
        
        reportTemplateInfo.setCourtesyTitles( getCourtesyTitles() );
        reportTemplateInfo.setSuffixTitles( getSuffixTitles() );
        reportTemplateInfo.setCountriesMap( getCountriesListings() );
        reportTemplateInfo.setTimeZonesMap( getTimeZonesMap() );
        reportTemplateInfo.setIndustryViewsMap( getIndustryViewsMap() );
        reportTemplateInfo.setQualityRatingsMap( getQualityRatingsMap() );
        reportTemplateInfo.setSourceDistributionPreferencesMap( getSourceDistributionPreferencesMap() );
        
        
        
        return reportTemplateInfo;
    }
    
    
    
    /**
     * Retrieves the ReportGeneralInfo object in connection to a report
     * @param reportTemplateInfo    -- the ReportTemplateInfo comprising all the information of a report
     * @return reportGeneralInfo -- the ReportGeneralInfo object
     */
    public ReportGeneralInfo getReportGeneralInfo(final ReportTemplateInfo reportTemplateInfo) {
        com.bawaweb.grid.templates.data.cursors.ReportGeneralInfo reportGeneralInfo = new com.bawaweb.grid.templates.data.cursors.ReportGeneralInfoDataSet();
        com.bawaweb.lifecycle.ReportGeneralInfoVO rgInfo = new com.bawaweb.lifecycle.ReportGeneralInfoVO();
        
        int rprtId = reportTemplateInfo.getReportId();
        int rptrId = reportTemplateInfo.getReporterId();
        
        com.bawaweb.views.gridcursors.common.ReportGeneralInfo rgInfoView = platform.getReportGeneralInfo();
        rgInfoView.setrprt_id( new Number( rprtId ) ) ;
        
        rgInfoView.executeQuery();
        
        if ( rgInfoView.hasNext() ) {
            ReportGeneralInfoRow row = (ReportGeneralInfoRow) rgInfoView.next();
            rgInfo = rgInfo.transform( row );
        }
        
        ReporterGeneralInfo rptrInfo = getReporterInfo(new Number(rptrId)); 
        rgInfo.setRptrGenInfo( rptrInfo );
        
        List<LeadReporterGeneralInfo> leadreporters = getLeadReporters(new Number( rprtId ) );
        rgInfo.setTheLeadReporters( leadreporters );
        
        List<EditorGeneralInfo> editors = getEditors( new Number ( rprtId ) );
        rgInfo.setTheEditors( editors );
        
        reportGeneralInfo = rgInfo.transform( rgInfo );
        
        return reportGeneralInfo;
    }


    
    
    /**
     * NOT being used -- was needed for v1
     * @param emplId -- the employee
     * @return aboolean determining whether the the reporter may view / or edit the report 
     */
    public boolean getRoleScope(int emplId) {
        RoleScopeInfo roleInfo = new RoleScopeInfoDataSet();
        RoleScopeVO role = new RoleScopeVO();
        RoleScope roleView = platform.getRoleScopeView();
        
        roleView.setp_empl_id(new Number(emplId));
        
        roleView.executeQuery();
        
        if ( roleView.hasNext() ) {
            RoleScopeRow row = (RoleScopeRow) roleView.next();
            
            if ( row.getRolRprtIndYn().equalsIgnoreCase("Y") ) {
                return true;
            }
        }
        return false;
    }
    
    
    public boolean lockSourceAnswers(List<Integer> sraIds) {
        return false;   
    }
    
    public boolean lockReportAnswerSetValues(List<Integer> sraIds) {
        return false;   
    }
    
    public DBTransaction getDBTransaction() {
        return platform.getDBTransaction();
    }
    
    
    
    
    /**
     * Utility method that <b>posts and commits</b> all pending open transactions of the DBTransaction
     * to the database.
     * @throws ApplicationException 
     */
    public void commitAll() throws ApplicationException {
LOG.info("Exectuing platform.getDBTransaction().commit()");
        DBTransaction tr = platform.getDBTransaction();
        LOG.info( "tr.isLockOptimistic() is " + tr.isLockOptimistic() );
        LOG.info( "tr.isDirty is " + tr.isDirty() );
        LOG.info( "tr is " + tr.toString() );
        try {
            platform.getDBTransaction().commit();
        } catch (Exception e) {
            LOG.error("Error in commiting ", e );
            throw new ApplicationException( "Error in committing the data to the database", e );
        }
    }
    
    
    
    
    
    /**
     * Utility method that <b>reverts</b> all posted uncommitted transactions of the DBTransaction
     * <p>from the database till the last / previous commit was made. 
     * @throws ApplicationException 
     * <p>NOTE -- it does not roll back everything. So in our process we post extra sources to bawaweb_sources, etc
     * <p> then we post in additional report-answer-set-values etc,
     * <p> and last we post in the source answers. So if a failure / an error were to occur while answers were being posted
     * <p> then only the answers would be rolled back -- <b> but the extra-sources and the additional report-answer-set-values having been already committed would not</b>
     * Subsequently the additioanl sources and the extra report-answer-set-values will be in the database and be connected to the report
     * @TODO -- look into save points
     */
    public void rollbackAll() {
        platform.getDBTransaction().rollback();
    }
    
    
    /**
     * Retrieves the database information that the application is connected to.
     * @return dbVO -- a DBInstanceVO which has information on the database, null if none found
     */
    public DBInstanceVO getDBInstance() {
        DBInstanceImpl dbView = platform.getDBInstance();
        DBInstanceVO dbVO = new DBInstanceVO();
        dbView.executeQuery();
        
        if ( dbView.hasNext() ) {
            DBInstanceRow row = (DBInstanceRow) dbView.next();
            dbVO = dbVO.transform(row);
            
            return dbVO;
        }
        return null;
    }


    public void setPlatform(PlatformAppModuleImpl platform) {
        this.platform = platform;
    }

    public PlatformAppModuleImpl getPlatform() {
        return platform;
    }
    
    
    /**
     * Updates the BAwaWEb_ANSWER_SET_VALUES table given the OtlAnswerSetValuesVO object 
     * @param asvVo -- the OtlAnswerSetValuesVO to be updated
     * @return  a boolean indicating whether the BAwaWEb_ANSWER_SET_VALUES table was updated
     */
    public boolean update( OtlAnswerSetValuesVO asvVo ) {
        OtlAnswerSetValues asvView = platform.getOtlAnswerSetValues();
        boolean found = false;
        
        Number asvVoAsvId = new Number( asvVo.getAsvId() );
        Number asvVoAnsId = new Number( asvVo.getAsvAnsId() );
        String asvVoAnswer = asvVo.getAsvAnswer();
        String asvVoDeleteYn = asvVo.getAsvDeleteYN(); 
        Number asvVoDisplaySeq = asvVo.getAsvDisplaySeq();
        
        asvView.setasv_id( asvVoAsvId );
        asvView.executeQuery();
        
        if ( asvView.hasNext() ) {
            OtlAnswerSetValuesRow asvRow = (OtlAnswerSetValuesRow) asvView.next();
            Number asvId = asvRow.getAsvId();
            
            if ( asvVoAsvId.equals( asvId) ) {
                found = true;
                
                asvRow.setAsvId( asvId );
                asvRow.setAsvAnsId( asvVoAnsId );
                asvRow.setAsvAnswer( asvVoAnswer );
                asvRow.setAsvDisplaySeq( asvVoDisplaySeq );
                asvRow.setAsvDeleteYn( asvVoDeleteYn );
                
                // can use either style above or below btw
        //                row.setAttribute( "AsvId", asvId );
        //                row.setAttribute( "AsvAnsId", asvVoAnsId );
        //                row.setAttribute( "AsvAnswer", asvVoAnswer );
        //                row.setAttribute( "AsvDisplaySeq", asvVoDisplaySeq );
        //                row.setAttribute( "AsvDeleteYn", asvVoDeleteYn );
            }
            
        }
        
        asvView.setasv_id( null );
        asvView.executeQuery();
        
        LOG.info("***RETURNING update asvVo ****\n" + asvVo + "\n****************\n");
        
        return found;
    }

        
        
    /**
     * Updates the BAwaWEb_REPORT_ANSWER_SET_VALUES table given the OtlReportAnswerSetValuesVO object 
     * @param ravVo -- the OtlReportAnswerSetValuesVO to be updated
     * @return  a boolean indicating whether the BAwaWEb_REPORT_ANSWER_SET_VALUES table was updated
     */   

     public boolean update(OtlReportAnswerSetValuesVO ravVo) {     
         OtlReportAnswerSetValues ravView = platform.getOtlReportAnswerSetValues();
         
         boolean found = false;
         
         Number ravVoId = new Number( ravVo.getRavId() );
         Number ravVoRasId = new Number( ravVo.getRavRasId() );
         String ravVoAnswer = ravVo.getRavAnswer();
         String ravVoDeleteYn = ravVo.getRavDeleteYN(); 
         Number ravVoDisplaySeq = ravVo.getRavDisplaySeq();
         Number ravVoAsvId = new Number( ravVo.getRavAsvId() );
         
         ravView.setrav_id( ravVoId );
         ravView.executeQuery();
         
         if ( ravView.hasNext() ) {
             OtlReportAnswerSetValuesRow ravRow = (OtlReportAnswerSetValuesRow) ravView.next();
             Number ravId = ravRow.getRavId();
             
             if ( ravVoId.equals( ravId) ) {
                 found = true;
                 
                 ravRow.setRavId( ravId );
                 ravRow.setRavRasId( ravVoRasId );
                 ravRow.setRavAnswer( ravVoAnswer );
                 ravRow.setRavDisplaySeq( ravVoDisplaySeq );
                 ravRow.setRavDeleteYn( ravVoDeleteYn );
                 ravRow.setRavAsvId( ravVoAsvId );
     LOG.info("***RETURNING update RAVRow ****\n" + ravRow + " with id " + ravRow.getRavId() + "\n****************\n");
     LOG.info("***RETURNING update RAVvo ****\n" + ravVo + "\n****************\n");
                 
     //                row.setAttribute( "RavId", ravId );
     //                row.setAttribute( "RavRasId", ravVoRasId );
     //                row.setAttribute( "RavAnswer", ravVoAnswer );
     //                row.setAttribute( "RavDisplaySeq", ravVoDisplaySeq );
     //                row.setAttribute( "RavDeleteYn", ravVoDeleteYn );
     //                row.setAttribute( "RavAsvId", ravVoAsvId );
                 
             }
         }
         
         ravView.setrav_id( null );
         ravView.executeQuery();
    
         return found;
     }
     
     
    /**
     * Updates and returns the updated contents of a SourceAnswersDataSetInfo object
     * @param sad   -- a SourceAnswersDataSetInfo to be updated in the BAwaWEb_SOURCE_ANSWERS / BAwaWEb_SOURCE_MULTI_ANSWERS / BAwaWEb_SOURCE_SORTING_SRITERIA table
     * @return sad -- the updated SourceAnswersDataSetInfo object from the database
     * @throws Exception    -- when things go wrong
     */
    public SourceAnswersDataSetInfo update(SourceAnswersDataSetInfo sad) throws Exception {
        if ( sad == null ) throw new IllegalArgumentException("Error sad is null for update");  // OR DO RETURN NULL
        boolean found = false;
        boolean isForDelete = false;
        
        String qType = sad.getQst_type();
        Number qstId = new Number( sad.getQst_id() );
        Number rpsId = new Number( sad.getRps_id() );
        Number srcId = new Number( sad.getSrc_id() );
        
        if ( qType.equalsIgnoreCase("SORT")) {
            return updateSortAnswer(sad, rpsId);
             
            
            
            
        } else if ( qType.equalsIgnoreCase("SINGLE") ) {
            return updateSingleAnswer(sad, qstId, rpsId);
            
            
        } else if ( qType.equalsIgnoreCase("MULTI") ) {
            return updateMultiAnswer(sad, qstId, rpsId);
            
            
        } else {
            return updateGenericAnswer(sad, qstId, rpsId);
             
             
        }
        
        
    }

    private SourceAnswersDataSetInfo updateGenericAnswer(SourceAnswersDataSetInfo sad, 
                                        Number qstId, Number rpsId) {
        boolean found = false;
        boolean updated = false;
        boolean isForDelete = false;
        String qType = sad.getQst_type();
        
        // data, weight, text
         Number sraId = new Number( sad.getSra_Id() );
         String answer = sad.getAnswer();
         String ansText = sad.getSra_Answer_text();
         String color = sad.getSra_color();
         String comment = sad.getSra_comment();
         
         if ( ( answer == null || answer.equals("") ) &&
              ( ansText == null || ansText.equals("") ) &&
              ( color == null || color.equals("") ) &&
              ( comment == null || comment.equals("") ) 
         ) {
             // set for delete
             isForDelete = true;
             sad.setIsForDelete( isForDelete );
         }
        LOG.info("isForDELETE is " + isForDelete + " for sraId " + sraId + " and qstId " + qstId + " with type = " + qType + " with rpsId " + rpsId );
         SourceAnswers sraView = platform.getSourceAnswers();
         
         sraView.setsra_id( sraId  );
         
         sraView.executeQuery();
         
         if ( sraView.hasNext() ) {
             SourceAnswersRow row = (SourceAnswersRow) sraView.next();
             
             if (    row.getSraId().equals( sraId ) && 
                     row.getSraQstId().equals( qstId ) &&
                     row.getSraRpsId().equals( rpsId ) ) {
                 found = true;
                 
                 if ( !isForDelete ) {
                     row.setAttribute( "SraId", sraId);
                     row.setAttribute( "SraQstId", qstId );
                     row.setAttribute( "SraRpsId", rpsId );
                     row.setAttribute( "SraAnswer", answer );
                     row.setAttribute( "SraAnswerText", ansText );
                     row.setAttribute( "SraExcludeYn", "N");
                     row.setAttribute( "SraColor", color );
                     row.setAttribute( "SraComment", comment );
                 } else {
//                    row.remove();
                 
                // for now we wont delete

                    row.setAttribute( "SraId", sraId);
                    row.setAttribute( "SraQstId", qstId );
                    row.setAttribute( "SraRpsId", rpsId );
                    row.setAttribute( "SraAnswer", null );
                    row.setAttribute( "SraAnswerText", null );
                    row.setAttribute( "SraExcludeYn", "N");
                    row.setAttribute( "SraRavId", null );
                    row.setAttribute( "SraColor", null );
                    row.setAttribute( "SraComment", null );
                 }
                 updated = true;
             }
         }
         
         return found && updated ? sad : null;
    }

    private SourceAnswersDataSetInfo updateMultiAnswer(SourceAnswersDataSetInfo sad, 
                                      Number qstId, Number rpsId) {
        boolean isForDelete = false;
        String qType = sad.getQst_type();
        
        // affects bawaweb_source-answers and bawaweb_source_multi_answers
        boolean isMasterFound = false;
        boolean isChildFound = false;
        
        boolean isMasterChanged = false;
        boolean isChildChanged = false;
        
        boolean isMulti_Single = false;
        
        String qmqType = sad.getQmq_Qst_Type();
        Number qmqId = new Number( sad.getQmq_id() );
        
        Number sraId = new Number( sad.getSra_Id() );
        Number smaSraId = new Number( sad.getSma_sra_id() );
        LOG.info("for update multi sraid is " + sraId + " and smaSraid is " + smaSraId);
        String answer = sad.getAnswer();
        String ansText = sad.getSra_Answer_text();
        String color = sad.getSra_color();
        String comment = sad.getSra_comment();
        
        Number oldRavId = new Number( 0 );
        Number ravId = new Number( 0 );
        
        if ( qmqType.equalsIgnoreCase("SINGLE") ) {
            isMulti_Single = true;
            oldRavId = new Number( sad.getOld_Rav_Id() );
            ravId = new Number( sad.getRav_Id() );
            if ( ( answer == null || answer.equals("") ) &&
                 ( ansText == null || ansText.equals("") ) &&
        //                     ( color == null || color.equals("") ) &&
                 ( comment == null || comment.equals("") ) &&
                 ( ravId == null || ravId.intValue() <= 0 )
            ) {
                // set for delete
                isForDelete = true;
                sad.setIsForDelete( isForDelete );
            }
            
        } else {
            // data, txt
             isMulti_Single = false;
             if ( ( answer == null || answer.equals("") ) &&
                  ( ansText == null || ansText.equals("") ) &&
        //                      ( color == null || color.equals("") ) &&
                  ( comment == null || comment.equals("") )
             ) {
                 // set for delete
                 isForDelete = true;
                sad.setIsForDelete( isForDelete );
             }
        }
        LOG.info("isForDELETE is " + isForDelete + " for sraId " + sraId + " and qstId " + qstId + " with type = " + qType + " and qmqtype is " + qmqType +" with rpsId " + rpsId );            
         // first make changes to the bawaweb_source_multi_answer (child) records
         // for update / delete
        SourceMultiAnswers smaView = platform.getSourceMultiAnswers();
        
        smaView.setsra_id( sraId );
        smaView.setqmq_id( qmqId );
        //                    int numRecsFound = 0;
        
        smaView.executeQuery();
        
        if ( smaView.hasNext() ) {
            SourceMultiAnswersRow srcMultAnsRow = (SourceMultiAnswersRow) smaView.next();
            if ( srcMultAnsRow.getSmaSraId().equals( smaSraId ) &&
                 srcMultAnsRow.getSmaQmqId().equals( qmqId )
            ) 
              { 
                isChildFound = true;  
                if ( isForDelete ) {
                    srcMultAnsRow.remove();
                    isChildChanged = true;
                } else {
                    
                    srcMultAnsRow.setAttribute( "SmaSraId", sraId );
                    if ( isMulti_Single ) {
            
                        if ( ravId != null ) {
                            if ( ravId.intValue() <= 0 )
                                ravId = null;
                        }
                        
                        Number theRavId = (ravId != null) ? new Number( ravId ) : null;
                        
                        srcMultAnsRow.setAttribute( "SmaRavId", theRavId );
                        srcMultAnsRow.setAttribute( "SmaAnswer", null );
                    } else {
                        srcMultAnsRow.setAttribute( "SmaRavId", null );
                        srcMultAnsRow.setAttribute( "SmaAnswer", answer );
                    }
                    srcMultAnsRow.setAttribute( "SmaQmqId", qmqId);
                    srcMultAnsRow.setAttribute( "SmaExcludeYn", "N");
                    
                    isChildChanged = true;
                }
            }
            
        
        }
        
        
        
        
        
        
        
        LOG.info(" isChildFound && isChildChanged is " + (isChildFound && isChildChanged) + " for qmqId " + qmqId + " for rpsId " + rpsId + " and qstid " + qstId + " with sraId " + sraId);
        // next make changes to the parent bawaweb_source_answers
         if ( isChildFound && isChildChanged ) {
            SourceAnswers sraView = platform.getSourceAnswers();
            sraView.setsra_id( sraId );
            
            sraView.executeQuery();
            
        LOG.info("sraView.setsra_id to " + sraId);
            if ( sraView.hasNext() ) {
                SourceAnswersRow srcAnsRow = (SourceAnswersRow) sraView.next();
        LOG.info("sraId is " + sraId + " rows_sraId is " + srcAnsRow.getSraId() + " srcAnsRow.getSraId().equals( sraId )  is " + ( srcAnsRow.getSraId().equals( sraId ) ));
        LOG.info("qstId is " + qstId + " rows_qstId is " + srcAnsRow.getSraQstId() + " srcAnsRow.getSraQstId().equals( qstId )  is " + (srcAnsRow.getSraQstId().equals( qstId )));
        LOG.info("rpsId is " + rpsId + " rows_rpsId is " + srcAnsRow.getSraRpsId() + " srcAnsRow.getSraRpsId().equals( rpsId )  is " + ( srcAnsRow.getSraRpsId().equals(rpsId) ));
        LOG.info("ALL TRUE is " + (    srcAnsRow.getSraId().equals( sraId ) &&
                            srcAnsRow.getSraQstId().equals( qstId ) && 
                            srcAnsRow.getSraRpsId().equals(rpsId)/*  && 
                            srcAnsRow.getSraRavId().equals( oldRavId ) */));
                if ( isMulti_Single ) {
                    if (    srcAnsRow.getSraId().equals( sraId ) && 
                            srcAnsRow.getSraQstId().equals( qstId ) && 
                            srcAnsRow.getSraRpsId().equals(rpsId)/*  && 
                            srcAnsRow.getSraRavId().equals( oldRavId ) */) {
                            
                        isMasterFound = true;
        LOG.info("[single-multi] isMasterFound " + isMasterFound);
                        if ( isMasterFound && isForDelete ) {
        //fn no remove                  srcAnsRow.remove();
                            
                            srcAnsRow.setAttribute( "SraId", sraId );
                            srcAnsRow.setAttribute( "SraQstId", qstId );
                            srcAnsRow.setAttribute( "SraRpsId", rpsId );
                            srcAnsRow.setAttribute( "SraAnswer", null);
                            srcAnsRow.setAttribute( "SraAnswerText", null );
                            srcAnsRow.setAttribute( "SraExcludeYn", "N");
                            srcAnsRow.setAttribute( "SraRavId", null );
                            srcAnsRow.setAttribute( "SraColor", null ); 
                            srcAnsRow.setAttribute( "SraComment", null );
                            
                            isMasterChanged = true;
                            
                        } else if ( isMasterFound && !isForDelete ) {
                            srcAnsRow.setAttribute( "SraId", sraId );
                            srcAnsRow.setAttribute( "SraQstId", qstId );
                            srcAnsRow.setAttribute( "SraRpsId", rpsId );
                            srcAnsRow.setAttribute( "SraAnswer", null);
                            srcAnsRow.setAttribute( "SraAnswerText", ansText );
                            srcAnsRow.setAttribute( "SraExcludeYn", "N");
                            srcAnsRow.setAttribute( "SraRavId", null );       // none for multi in bawaweb_sources
                            

                                                         
                            if ( ( answer == null || answer.equalsIgnoreCase("") ) && 
                                 ( ansText == null || ansText.equalsIgnoreCase("") ) &&
                                 ( ravId == null || ravId.intValue() == 0 ) )  {
                             
                                srcAnsRow.setAttribute( "SraColor", null );                                    
                             } else {
                                srcAnsRow.setAttribute( "SraColor", color );
                             }
                             
                             srcAnsRow.setAttribute( "SraComment", comment );
                             
                             isMasterChanged = true;
                            
                        }
                    }
                } else {    // not single for multi - either data/txt
                    if (    srcAnsRow.getSraId().equals( sraId ) && 
                            srcAnsRow.getSraQstId().equals( qstId ) && 
                            srcAnsRow.getSraRpsId().equals(rpsId) ) {
                            
                        isMasterFound = true;
        LOG.info(" [notsingle-multi]isMasterFound " + isMasterFound);
                        
                        if ( isMasterFound && isForDelete ) {
        //fn no remove                  srcAnsRow.remove();
                            
                            srcAnsRow.setAttribute( "SraId", sraId );
                            srcAnsRow.setAttribute( "SraQstId", qstId );
                            srcAnsRow.setAttribute( "SraRpsId", rpsId );
                            srcAnsRow.setAttribute( "SraAnswer", null);
                            srcAnsRow.setAttribute( "SraAnswerText", null );
                            srcAnsRow.setAttribute( "SraExcludeYn", "N");
                            srcAnsRow.setAttribute( "SraRavId", null );
                            srcAnsRow.setAttribute( "SraColor", null ); 
                            srcAnsRow.setAttribute( "SraComment", null );
                            
                            isMasterChanged = true;
                            
                        } else if ( isMasterFound && !isForDelete ) {
                            srcAnsRow.setAttribute( "SraId", sraId );
                            srcAnsRow.setAttribute( "SraQstId", qstId );
                            srcAnsRow.setAttribute( "SraRpsId", rpsId );
                            srcAnsRow.setAttribute( "SraAnswer", null);
                            srcAnsRow.setAttribute( "SraAnswerText", ansText );
                            srcAnsRow.setAttribute( "SraExcludeYn", "N");
                            srcAnsRow.setAttribute( "SraRavId", null );       // none for multi in bawaweb_sources
                             
                            if ( ( answer == null || answer.equalsIgnoreCase("") ) &&
                                ( ansText == null || ansText.equalsIgnoreCase("") ) &&
                                ( ravId == null || ravId.intValue() == 0 ) )  {
                         
                                    srcAnsRow.setAttribute( "SraColor", null );
                            } else {
                                    srcAnsRow.setAttribute( "SraColor", color );
                            }
                            
                            
                            srcAnsRow.setAttribute( "SraComment", comment );
                            
                            isMasterChanged = true;
                            
                        }
                    }
                }
           }
        }
        return isMasterChanged ? sad : null;
    }

    private SourceAnswersDataSetInfo updateSingleAnswer(SourceAnswersDataSetInfo sad, 
                                       Number qstId, Number rpsId) {
        boolean found = false;
        boolean updated = false;
        boolean isForDelete = false;
        String qType = sad.getQst_type();
        
        Number oldRavId = new Number( sad.getOld_Rav_Id() );
        Number ravId = new Number( sad.getRav_Id() );
        Number sraId = new Number( sad.getSra_Id() );
        String answer = sad.getAnswer();
        String ansText = sad.getSra_Answer_text();
        String color = sad.getSra_color();
        String comment = sad.getSra_comment();
        
        if ( ( answer == null || answer.equals("") ) &&
             ( ansText == null || ansText.equals("") ) &&
        //                 ( color == null || color.equals("") ) &&
             ( comment == null || comment.equals("") ) &&
             ( ravId == null || ravId.intValue() == 0 )
        ) {
            // set for delete
            isForDelete = true;
            sad.setIsForDelete( isForDelete );
        }
        LOG.info("updateSingleAnswer isForDELETE is " + isForDelete + " for sraId " + sraId + " and qstId " + qstId + " with type = " + qType + " with rpsId " + rpsId );
        SourceAnswers sraView = platform.getSourceAnswers();
        
        sraView.setsra_id( sraId  );
        
        sraView.executeQuery();
        
        if ( sraView.hasNext() ) {
            SourceAnswersRow row = (SourceAnswersRow) sraView.next();
            
        LOG.info(" row.getSraRavId() " + row.getSraRavId() + " oldravid " + oldRavId + " and ravId is " + ravId);
            if (    row.getSraId().equals( sraId ) && 
                    row.getSraQstId().equals( qstId ) &&
                    row.getSraRpsId().equals( rpsId ) /*&&
                    row.getSraRavId().equals(oldRavId)*/ ) {
                    
                if ( ( row.getSraRavId() == null && oldRavId.equals(new Number(0)) ) || 
                      ( row.getSraRavId().equals(oldRavId) ) ) {
                    
                    found = true;
                    
                    if ( !isForDelete ) {
                        if ( ravId != null ) {
                            if ( ravId.intValue() <= 0 )
                                ravId = null;
                        }
                        row.setAttribute( "SraId", sraId);
                        row.setAttribute( "SraQstId", qstId );
                        row.setAttribute( "SraRpsId", rpsId );
                        row.setAttribute( "SraAnswer", answer );
                        row.setAttribute( "SraAnswerText", ansText );
                        row.setAttribute( "SraExcludeYn", "N");
                        row.setAttribute( "SraRavId", ravId );
                        
                        if ( ( answer == null || answer.equalsIgnoreCase("") ) && 
                                ( ansText == null || ansText.equalsIgnoreCase("") ) &&
                                ( ravId == null || ravId.intValue() == 0 ) )  {
                            
                            row.setAttribute( "SraColor", null );                                    
                         } else {
                            row.setAttribute( "SraColor", color );
                         }
                        row.setAttribute( "SraComment", comment );
                        
                        
                    } else {
//                     row.remove();
                        // for now we wont delete
                        

                        row.setAttribute( "SraId", sraId);
                        row.setAttribute( "SraQstId", qstId );
                        row.setAttribute( "SraRpsId", rpsId );
                        row.setAttribute( "SraAnswer", null );
                        row.setAttribute( "SraAnswerText", null );
                        row.setAttribute( "SraExcludeYn", "N");
                        row.setAttribute( "SraRavId", null );
                        row.setAttribute( "SraColor", null );
                        row.setAttribute( "SraComment", null );
                    }
                    updated = true;
                }
            }
        }
        
        return found && updated ? sad : null;
    }

    private SourceAnswersDataSetInfo updateSortAnswer(SourceAnswersDataSetInfo sad, 
                                     Number rpsId) {
        boolean found = false;
        boolean updated = false;
        boolean isForDelete = false;
        Number oldScvId = new Number( sad.getOld_Scv_Id() );
        Number scvId = new Number( sad.getScv_Id() );
        String scvName = sad.getScv_name();
        
        if ( scvName == null || scvName.equalsIgnoreCase(" ") || scvName.equalsIgnoreCase("") && 
            ( ( scvId == null || scvId.intValue() <= 0 )  )) {
            isForDelete = true;
        }
        
        
LOG.info("in update-sort-answer scvid is " + scvId + " and scvname is |" + scvName + "| and isfordelete is " + isForDelete);        
        
        SourceSortingCriteria sscView = platform.getSourceSortingCriteria();
        
        sscView.setscv_id( oldScvId );
        sscView.setrps_id( rpsId );
        
        sscView.executeQuery();
        
        if ( sscView.hasNext() ) {
            SourceSortingCriteriaRow sscRow = (SourceSortingCriteriaRow) sscView.next();
            found = true;
            if ( isForDelete ) {
                sscRow.remove();  
                sad.setIsForDelete( isForDelete );
            } else {
                sscRow.setAttribute( "SscRpsId", rpsId );
                sscRow.setAttribute( "SscScvId", scvId );
            }
            updated = true;
            
            
            
            
            
            
//            if ( scvName == null || scvName.equalsIgnoreCase(" ") && sscRow.getSscRpsId().equals( rpsId )  ) {
//                found = true;
//                sscRow.remove();
//            }
//            if ( sscRow.getSscRpsId().equals( rpsId ) && sscRow.getSscScvId().equals(oldScvId) ) {
//                found = true;
//                if ( !( scvId == null || scvId.intValue() <= 0 ) ) {
//                    sscRow.setAttribute( "SscRpsId", rpsId );
//                    sscRow.setAttribute( "SscScvId", scvId );
//                } else {
//                    sscRow.remove();
//                }
//            }
        }
        
        return found && updated ? sad : null ;
    }
    
    /**
     * Creates and Inserts a record <b>only in </b> the BAwaWEb_SOURCE_MULTI_ANSWERS table
     * @param sad   -- the SourceAnswersDataSetInfo object which needs to be created
     * @return created -- a boolean indicating whether the record was created
     */
    public boolean createMultiAnswerRecord(SourceAnswersDataSetInfo sad) {
        LOG.info("in createMultiAnswerRecord -- sad is " + sad);  
System.out.println("in createMultiAnswerRecord -- sad is " + sad);          
        if ( sad == null )  throw new IllegalArgumentException("Error sad is null");
        boolean created = false;
        
        Number smaSraId = new Number( sad.getSma_sra_id() );
        String qmqtype = sad.getQmq_Qst_Type();
        String answer = sad.getAnswer();                    // if qmqtype <> single
        Number smaAsvId = new Number( sad.getAsv_Id() );    // if qmqtype = single
        Number qmqId = new Number( sad.getQmq_id() );
System.out.println("in createMultiAnswerRecord -- qmqid is " + qmqId + " samASVid is " + smaAsvId + " and samRAVID is " + sad.getRav_Id());        
        String smaExcludeYn = "N";
        Number smaRavId = new Number( sad.getRav_Id() );    // if qmqtype = single
        
        SourceMultiAnswers smaView = platform.getSourceMultiAnswers();
        SourceMultiAnswersRow smaRow = (SourceMultiAnswersRow) smaView.createRow();
        
        smaRow.setAttribute( "SmaSraId", smaSraId );
        if ( qmqtype.equalsIgnoreCase( "SINGLE" ) ) {
            // no answer here
            if ( smaAsvId != null && smaAsvId.intValue() > 0 ) smaRow.setAttribute( "SmaAsvId", smaAsvId );
            int ravId = PlatformAppModuleServiceImpl.getInstance().getRavInfo( sad.getRas_Id(), answer );
            if ( smaRavId != null  && smaRavId.intValue() > 0 ) {
                smaRow.setAttribute( "SmaRavId", smaRavId );
            } else {
                smaRow.setAttribute( "SmaRavId", new Number( ravId ) );
            }
            
        } else {
            smaRow.setAttribute( "SmaAnswer", answer );
        }
        
        smaRow.setAttribute( "SmaExcludeYn", smaExcludeYn );
        smaRow.setAttribute( "SmaQmqId", qmqId );
        
        created = true;
        return created;
    }
    
    
    /**
     * Updates and returns the updated contents of a SourceAnswersDataSetInfo object
     * @param sad   -- a SourceAnswersDataSetInfo to be updated in the BAwaWEb_SOURCE_ANSWERS / BAwaWEb_SOURCE_MULTI_ANSWERS / BAwaWEb_SOURCE_SORTING_SRITERIA table
     * @return sad -- the updated SourceAnswersDataSetInfo object from the database
     * @throws Exception    -- when things go wrong
     * NOTE -- if the question type here is MULTI then it will create the record in the BAwaWEb_SOURCE_ANSWERS table first
     * <p>(if required) and then add a record to BAwaWEb_SOURCE_MULTI_ANSWERS
     */
    public SourceAnswersDataSetInfo create(SourceAnswersDataSetInfo sad) throws Exception {
LOG.info("in create - SourceAnswersDataSetInfo -- sad is " + sad);    
        if ( sad == null )  throw new IllegalArgumentException("Error sad is null");
        
        String qType = sad.getQst_type();
        //qstid should always be positive
        Number qstId = sad.getQst_id() < 0 ? 
                                new Number( sad.getQst_id()  ) :        
                                new Number( sad.getQst_id() );
        Number rpsId = new Number( sad.getRps_id() );
        Number srcId = new Number( sad.getSrc_id() );

LOG.info("IN CREATE  SRCID IS " + srcId + " AND RPSID IS " + rpsId + " and qstid is " + qstId + " and qtype = " + qType);

        // add dble blind in case the calling set of creates had dupslicat
        if ( !qType.equalsIgnoreCase("MULTI") && this.doesSourceAnswerExist( qstId.intValue(), rpsId.intValue()  ) ) {
LOG.info("IN CREATE  sad --- but doesSourceAnswerExist is TRUE, qsttype NOT multi  --> RPSID " + rpsId + " AND SRCID IS " + srcId + " and qstid is " + qstId + " and qtype = " + qType + "\n and SAD is___*****_\n" + sad + "\n___********____\nNOW CALLING UPDATE");
System.out.println("IN CREATE  sad --- but doesSourceAnswerExist is TRUE, qsttype NOT multi  --> RPSID " + rpsId + " AND SRCID IS " + srcId + " and qstid is " + qstId + " and qtype = " + qType + "\n and SAD is___*****_\n" + sad + "\n___********____\nNOW CALLING UPDATE");        
            if ( sad != null && sad.getSra_Id() >= 0 ) {
/*********
//                this.update( sad );
*********/
            } else {
                LOG.info("AAARGH whats going on -- call to create - answer exists -- sad is null");
                System.out.println("AAARGH whats going on -- call to create - answer exists -- sad is null");                
            }
        }





        if ( qType.equalsIgnoreCase("SORT")) {
            return createSortAnswer(sad, qstId, rpsId);
            
        } else if ( qType.equalsIgnoreCase("SINGLE") ) {
        
            return createSingleAnswer(sad, qstId, rpsId);
            
        } else if ( qType.equalsIgnoreCase("MULTI") ) {
        
            return createMultiAnswer(sad, qstId, rpsId);
            
        } else {
            return createGenericAnswer(sad, qstId, rpsId);
        }
        
        
    }

    private SourceAnswersDataSetInfo createGenericAnswer(SourceAnswersDataSetInfo sad, 
                                        Number qstId, Number rpsId) {
        boolean created = false;
        String qType = sad.getQst_type();
        // data, weight, text
        Sequence sraSeq = new Sequence("BAwaWEb_SRA_SEQ", platform);
        String nxtSraIdVal = sraSeq.getData().toString();
        Number nxtSraId = null;
        try {
            nxtSraId = new Number( nxtSraIdVal);
        } catch (SQLException e) { 
            created = false;
            LOG.error("Error", e);  //e.printStackTrace();
        } 
        Number sraId = nxtSraId;//new Number( sad.getSra_Id() );
        String answer = sad.getAnswer();
        String ansText = sad.getSra_Answer_text();
        String color = sad.getSra_color();
        String comment = sad.getSra_comment();
        LOG.info("qtype is " + qType + " sraId is " + sraId + " answer is " + answer + " qstId is " + qstId + " rpsId is " + rpsId);
         
        SourceAnswers sraView = platform.getSourceAnswers();
        SourceAnswersRow srcAnsRow = (SourceAnswersRow) sraView.createRow();
        srcAnsRow.setAttribute( "SraId", sraId);
        srcAnsRow.setAttribute( "SraQstId", qstId );
        srcAnsRow.setAttribute( "SraRpsId", rpsId );
        srcAnsRow.setAttribute( "SraAnswer", answer );
        srcAnsRow.setAttribute( "SraAnswerText", ansText );
        srcAnsRow.setAttribute( "SraExcludeYn", "N");
        srcAnsRow.setAttribute( "SraRavId", null );
        srcAnsRow.setAttribute( "SraColor", color );
        srcAnsRow.setAttribute( "SraComment", comment );
         
        created = true;
        if ( nxtSraId != null && created ) {
            sad.setSra_Id( nxtSraId.intValue() );
            sad.setRps_id( rpsId.intValue() );
            sad.setQst_id( qstId.intValue() );            
        }
        
        return created ? sad : null;
    }
    
    

    private SourceAnswersDataSetInfo createMultiAnswer(SourceAnswersDataSetInfo sad, 
                                      Number qstId, Number rpsId) {
LOG.info("in createMultiAnswer sad is\n_____________"+sad+"\n_____________\n");
        boolean created = false;
        Number existingSraId = null;
        Number theSmaSraId = null;
        String answer = sad.getAnswer();
        Number qmqId = new Number( sad.getQmq_id() );
        String qmqType = sad.getQmq_Qst_Type();
//        Number qmqNumber = new Number( sad.getQmq_number() );
        Number oldRavId = new Number( sad.getOld_Rav_Id() ); //new Number( 0 );
        Number ravId = new Number( sad.getRav_Id() );//new Number( 0 );
        boolean doesMasterExist = false; 
        Number nxtSraId = null;
            
        String ansText = sad.getSra_Answer_text();
        String color = sad.getSra_color();
        String comment = sad.getSra_comment();
        
        Number sraId = new Number( sad.getSra_Id() );
        
        if ( ravId.intValue() <= 0 ) {
             ravId = null;
        }
        
        boolean doesUniqueSrcAnswerExist = this.doesSourceAnswerExist( qstId.intValue(), rpsId.intValue() );
        boolean doesUniqueSrcMultiAnswerExist = false;
        
        
LOG.info("in START MULTI create sad is for qstid " + qstId + " and rpsid " + rpsId + " and doesUniqueSrcAnswerExist is " + doesUniqueSrcAnswerExist);        

        if ( doesUniqueSrcAnswerExist ) {
            // qstid and rpsid cobo exist for bawaweb_source_answers
            // just update the master then
            doesMasterExist = true; 
            existingSraId = getSraIdFromSrcAnswers( qstId, rpsId );
            
            doesUniqueSrcMultiAnswerExist = this.doesSourceMultiAnswerExist( existingSraId, qmqId );
            
//            SourceAnswers sraView = platform.getSourceAnswers();            
//            sraView.setsra_id( existingSraId  );            
//            sraView.executeQuery();
//            SourceAnswersRow srcAnsRow;
//            
//            if ( existingSraId.intValue() != 0 && sraView.hasNext() ) {
//                srcAnsRow = (SourceAnswersRow) sraView.next();
//                srcAnsRow.setAttribute( "SraAnswerText", ansText );
//                srcAnsRow.setAttribute( "SraExcludeYn", "N");
//                srcAnsRow.setAttribute( "SraColor", color );
//                srcAnsRow.setAttribute( "SraComment", comment );
//                
//                
//            }
            
            
        } else {        // here no records were found so we create one for bawaweb_source_answers
        
            
            doesMasterExist = false; 
            
             
            SourceAnswers sraView = platform.getSourceAnswers();            
            
            
            SourceAnswersRow srcAnsRow = (SourceAnswersRow) sraView.createRow();
            
            Sequence sraSeq = new Sequence("BAwaWEb_SRA_SEQ", platform);
            
            String nxtSraIdVal = sraSeq.getData().toString();
            
            try {
                nxtSraId = new Number( nxtSraIdVal);
LOG.info("CREATED NEW sraid attribute of src_ans to " + nxtSraId);
            } catch (SQLException e) { 
                created = false;
                LOG.error("Error", e);  //e.printStackTrace();
            } 
            
            srcAnsRow.setAttribute( "SraId",  nxtSraId );
//            }
            
            srcAnsRow.setAttribute( "SraQstId", qstId );
            srcAnsRow.setAttribute( "SraRpsId", rpsId );
            srcAnsRow.setAttribute( "SraAnswer", null );
            srcAnsRow.setAttribute( "SraAnswerText", ansText );
            srcAnsRow.setAttribute( "SraExcludeYn", "N");
            srcAnsRow.setAttribute( "SraColor", color );
            srcAnsRow.setAttribute( "SraComment", comment );
        } // ends doesUniqueSrcAnswerExist
            
            theSmaSraId = doesMasterExist ? existingSraId : nxtSraId;// (Number) srcAnsRow.getAttribute("SraId");
        LOG.info("theSmaSraId  is " + theSmaSraId + " and doesMasterExist is " + doesMasterExist);

        if ( theSmaSraId == null ) {
            theSmaSraId = existingSraId;
        }
LOG.info("ATTR CHECK: " + "theSmaSraId  is " + theSmaSraId + " and qmqid is " + qmqId + " and doesMasterExist is " + doesMasterExist);


        if ( !doesUniqueSrcMultiAnswerExist ) {
            // now create ans_multi row
            SourceMultiAnswers srcMultiAnsView = platform.getSourceMultiAnswers();
            SourceMultiAnswersRow srcMultiAnsRow = (SourceMultiAnswersRow) srcMultiAnsView.createRow();
    
            srcMultiAnsRow.setAttribute( "SmaSraId",  theSmaSraId );
            
            if ( qmqType.equalsIgnoreCase("SINGLE") ) {
                srcMultiAnsRow.setAttribute( "SmaRavId", ravId );
                srcMultiAnsRow.setAttribute( "SmaAnswer", null );
            } else {
                // data, txt
                 srcMultiAnsRow.setAttribute( "SmaRavId", null );
                srcMultiAnsRow.setAttribute( "SmaAnswer", answer );
            }
            
            srcMultiAnsRow.setAttribute( "SmaQmqId", qmqId );
            srcMultiAnsRow.setAttribute( "SmaExcludeYn", "N");
            
            created = true;
            
            if ( theSmaSraId != null && created ) {
                sad.setSra_Id( theSmaSraId.intValue() );
                sad.setSma_sra_id( theSmaSraId.intValue() );
            }
        }
        
        
        return created ? sad : null ;
    }
    
    
    
    

    private SourceAnswersDataSetInfo createSingleAnswer(SourceAnswersDataSetInfo sad, 
                                       Number qstId, 
                                       Number rpsId) throws Exception {
LOG.info("increatesingleanswer -- sad is " + sad);        
        boolean created = false;
        boolean doesUniqueSrcAnswerExist = this.doesSourceAnswerExist( qstId.intValue(), rpsId.intValue() );         //checkUniqueConstraint_SourceAnswers( qstId, rpsId);
        
//        SrcAnsUniqueInfoRow existingSourcercAnswersRow = checkUniqueConstraint_SourceAnswers( qstId, rpsId);
        
LOG.info("in START single create sad is for qstid " + qstId + " and rpsid " + rpsId + " and doesUniqueSrcAnswerExist is " + doesUniqueSrcAnswerExist);

//if (!doesUniqueSrcAnswerExist) {//if (existingSourcercAnswersRow != null) { 
//    LOG.info(" and existingsraid is " + existingSourcercAnswersRow.getSraId() + " failed uniqueconstraint for qstid " + qstId + " and rpsid " + rpsId + " \nSO WONT CREATE FOR\n");
//    LOG.info("existingSourcercAnswersRow.getSraId() is " + existingSourcercAnswersRow.getSraId());
//    LOG.info("existingSourcercAnswersRow.getAnswer() is " + existingSourcercAnswersRow.getSraAnswer());
//    LOG.info("existingSourcercAnswersRow.getSraAsvId() is " + existingSourcercAnswersRow.getSraAsvId());
//    LOG.info("existingSourcercAnswersRow.getSraRavId() is " + existingSourcercAnswersRow.getSraRavId());
//    LOG.info("existingSourcercAnswersRow.getSraRpsId() is " + existingSourcercAnswersRow.getSraRpsId());
//    LOG.info("existingSourcercAnswersRow.getSraQstId() is " + existingSourcercAnswersRow.getSraQstId());
//}

        if ( !doesUniqueSrcAnswerExist ) {
        
            Number oldRavId = new Number( sad.getOld_Rav_Id() );
            Number  ravId        = new Number( sad.getRav_Id() );
            
            if ( ravId.intValue() <= 0 ) {
                ravId = null;
            }
            
            Number nxtSraId = null;
            Number  sraId        = new Number( sad.getSra_Id() );
            Sequence sraSeq = new Sequence("BAwaWEb_SRA_SEQ", platform);
            String nxtSraIdVal = sraSeq.getData().toString();
            
            try {
                nxtSraId = new Number( nxtSraIdVal);
            } catch (SQLException e) { 
                created = false;
                LOG.error("Error", e);  //e.printStackTrace();
                throw new Exception(e);
            } 
            
            
            String  answer       = sad.getAnswer();
            String  ansText      = sad.getSra_Answer_text();
            String  color        = sad.getSra_color();
            String  comment      = sad.getSra_comment();
            
            SourceAnswers sraView   = platform.getSourceAnswers();
            SourceAnswersRow srcAnsRow = (SourceAnswersRow) sraView.createRow();            
            
            srcAnsRow.setAttribute( "SraId",        nxtSraId);//sraId);
            srcAnsRow.setAttribute( "SraQstId",     qstId );
            srcAnsRow.setAttribute( "SraRpsId",     rpsId );
            srcAnsRow.setAttribute( "SraAnswer",    null );
            srcAnsRow.setAttribute( "SraAnswerText", ansText );
            srcAnsRow.setAttribute( "SraExcludeYn", "N");
            srcAnsRow.setAttribute( "SraRavId",     ravId );
            srcAnsRow.setAttribute( "SraColor",     color );
            srcAnsRow.setAttribute( "SraComment",   comment );
            
LOG.info("srcAnsRow created for qstId " + qstId + " rpsId " + rpsId + " and it is______\n");
LOG.info("sraid is " + srcAnsRow.getSraId());
LOG.info("sraqstid is " + srcAnsRow.getSraQstId());
LOG.info("srarpsid is " + srcAnsRow.getSraRpsId());
LOG.info("sraRavid is " + srcAnsRow.getSraRavId());
LOG.info("sraanswer is " + srcAnsRow.getSraAnswer());
LOG.info("sraanswertxt is " + srcAnsRow.getSraAnswerText());
LOG.info("sracolor is " + srcAnsRow.getSraColor());
LOG.info("sracomment is " + srcAnsRow.getSraComment());
LOG.info("end info for srcAnsRow");            
            created = true;

            if ( nxtSraId != null && created ) {
                sad.setSra_Id( nxtSraId.intValue() );
                sad.setRps_id( rpsId.intValue() );
                sad.setQst_id( qstId.intValue() );
            }
            

            
        }
        
        return created ? sad : null ;
    }

    private SourceAnswersDataSetInfo createSortAnswer(SourceAnswersDataSetInfo sad, 
                                     Number qstId, Number rpsId) {
        if ( rpsId == null || rpsId.intValue() <= 0 ) return null;
        if ( qstId == null || qstId.intValue() <= 0 ) return null;
        if ( sad == null ) return null;
        
        boolean created = false;
        Number scvId = new Number( sad.getScv_Id() );
        String scvName = sad.getScv_name();
        
        LOG.info("scvId is " + scvId + " scvName is " + scvName  + " qstid is " + qstId + " rpsis is " + rpsId);
        if ( scvId.intValue() == getSSCInfo( qstId.intValue(), scvName) &&  scvId.intValue() > 0 ) {
            SourceSortingCriteria sscView = platform.getSourceSortingCriteria();
            SourceSortingCriteriaRow sscRow = (SourceSortingCriteriaRow) sscView.createRow();
            sscRow.setAttribute( "SscRpsId", rpsId );
            sscRow.setAttribute( "SscScvId", scvId);
            
            created = true;
        }
        if ( created ) {    // just putting here for now may be redundant
            sad.setRps_id( rpsId.intValue() );
        }
        return created ? sad : null ;
    }
    
    
    public int getNumQnsMultiQnsInfo(Number qstId) {
        if ( qstId.intValue() == 0 ) throw new IllegalArgumentException("Error qstid invalid");
        Questions theQstnView = platform.getQuestions();
        
        theQstnView.setqst_id( qstId );
        
        theQstnView.executeQuery();
        
        if ( theQstnView.hasNext() ) {
            QuestionsRow qstn = (QuestionsRow) theQstnView.next();
            if ( qstn.getQstType().equalsIgnoreCase("MULTI") ) {
                int numQstns = qstn.getQstMultiAnswers().intValue();
                if ( numQstns >  0 ) {
                    return numQstns;
                }
            }
        }
        return -1;
    }
    
    public void updateRepeatSourceDataPST(List<SourceDataSetInfo> sources) throws Exception {
        if ( sources ==  null || sources.size() == 0 ) throw new IllegalArgumentException("No sources");
    }
    
    public void updateRepeatSourceData(List<SourceDataSetInfo> sources, int reportId, int reporterId) throws Exception {
        if ( sources ==  null || sources.size() == 0 ) throw new IllegalArgumentException("No sources");
        if ( reportId <= 0 ) throw new IllegalArgumentException("Invalid reportId");
        if ( reporterId <= 0 ) throw new IllegalArgumentException("Invalid reporterId");
        
        ReportSources rpsView = platform.getReportSources();
        
        try {
            for ( Iterator<SourceDataSetInfo> it = sources.iterator(); it.hasNext(); ) {
                SourceDataSetInfo sad = it.next();
                Number rpsId = new Number( sad.getRps_id() );
                String repeat = null;//sad.getReportSourceInfo().getRps_repeat_source_yn();//sad.getRps_repeat_source_yn();
                if ( sad.getReportSourceInfo() != null ) {
LOG.info("sad.getReportSourceInfo() != null for rpsid " + rpsId );                
                    repeat = sad.getReportSourceInfo().getRps_repeat_source_yn();
                } else {
LOG.info("sad.getReportSourceInfo() IS null for rpsid " + rpsId );
                    repeat = sad.getRps_repeat_source_yn();
                }
LOG.info("repeat is " + repeat + " for source " + sad.getSrc_id() + " and rps " + rpsId + " with rprtid " + reportId + " and rptrId " + reporterId );  


                rpsView.setrps_id( rpsId );
                rpsView.setrprt_id( new Number( reportId ) );
                rpsView.setrprtr_id( new Number( reporterId ) );
                
                
                
                rpsView.executeQuery();
                
                if ( rpsView.hasNext() ) {
                    ReportSourcesRow rpsRow = (ReportSourcesRow) rpsView.next();
LOG.info("rpsRow --> " + rpsRow.getRpsId() + " existing repeatinfo " + rpsRow.getRpsRepeatSourceYn() + " now changing to " + repeat );                    
                    rpsRow.setAttribute( "RpsRepeatSourceYn", repeat);
                }
                
            }
        }
        catch (Exception e) {
            LOG.error("Couldnt update rps",e);
            throw new Exception(e);
        }
    }
 
/*******
    private boolean checkUniqueConstraint_SourceAnswers(Number qstId,  Number rpsId) {
        LOG.info("checking unique src-answer constraint for  qstid " + qstId + " and rpsid is " + rpsId);

        if ( qstId == null || qstId.intValue() <= 0 ) { throw new IllegalArgumentException("Incorrect or null qstid"); }
        if ( rpsId == null || rpsId.intValue() <= 0 ) { throw new IllegalArgumentException("Incorrect or null rpsId"); }
        
        SrcAnsUniqueInfoRow srcAnsRow = null;
        boolean isRecordUnique = false;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "select * from bawaweb_source_answers where sra_rps_id = ? and sra_qst_id = ?";
        
        pst = platform.getDBTransaction().createPreparedStatement( sql, 0 );
        
        try {
            pst.setInt( 1, rpsId.intValue() );
            pst.setInt( 2, qstId.intValue() );
            
            rs = pst.executeQuery();
            
            if ( rs.next() ) {
                LOG.info("FOUND SRA for rpsId " + rpsId + " and qstid " + qstId );
                int sra_id = rs.getInt( "SRA_ID" );
                LOG.info( "found sra_id is " + sra_id );
                
                int sra_qst_id = rs.getInt( "SRA_QST_ID" );
                LOG.info( "found qstId is " + sra_qst_id );
                
                int rps_id = rs.getInt( "SRA_RPS_ID" );
                LOG.info( "found rps_id is " + rps_id );
                
                String answer = rs.getString( "SRA_ANSWER" );
                LOG.info( "found ans is " + answer );
                
                String answerText = rs.getString( "SRA_ANSWER_TEXT" );
                LOG.info( "found answerText is " + answerText );
                
                int asv_id = rs.getInt( "SRA_ASV_ID" );
                LOG.info( "found asv_id " + asv_id );
                
                String excludeYn = rs.getString( "SRA_EXCLUDE_YN" );
                LOG.info("found excludeYN is " + excludeYn );
                
                int weightMult =  rs.getInt( "SRA_WEIGHT_MULTIPLER" );
                LOG.info("found weightMult is " + weightMult );
                
                int rav_id = rs.getInt( "SRA_RAV_ID" );
                LOG.info( " founfd rav_id " + rav_id );
                
                String sraColor = rs.getString( "SRA_COLOR" );
                LOG.info(" found sraColor " + sraColor );
                
                String sraComment = rs.getString( "SRA_COMMENT" );
                LOG.info(" found sraComment " + sraComment );
                
                return isRecordUnique = false;

            }
            
            return isRecordUnique = true;
            
            
        } catch ( SQLException se) {
            LOG.error("Error", se);  //e.printStackTrace();
        }
        
        finally {
            try {
                if ( rs != null ) rs.close();
                if ( pst != null ) pst.close();
            }
            catch (SQLException e) {
                LOG.error("Error", e);  //e.printStackTrace();
            }
        }
        

    }
*********/    
    
    /*
    private SrcAnsUniqueInfoRow checkUniqueConstraint_SourceAnswers(Number qstId,  Number rpsId) {
LOG.info("checking unique src-answer constraint for  qstid " + qstId + " and rpsid is " + rpsId);

        if ( qstId == null || qstId.intValue() <= 0 ) { throw new IllegalArgumentException("Incorrect or null qstid"); }
        if ( rpsId == null || rpsId.intValue() <= 0 ) { throw new IllegalArgumentException("Incorrect or null rpsId"); }
        
        boolean isRecordUnique = true;
        SrcAnsUniqueInfoRow srcAnsRow = null;
        SrcAnsUniqueInfo srcAnsInfoView = platform.getSrcAnsUniqueInfo();
        
        srcAnsInfoView.setqst_id( qstId );
        srcAnsInfoView.setrps_id( rpsId );
        
        srcAnsInfoView.executeQuery();

LOG.info("srcAnsInfoView.getEstimatedRowCount() IS " + srcAnsInfoView.getEstimatedRowCount() + " FOR RPSID " + rpsId + " AND QSTID " + qstId);

        if ( srcAnsInfoView.hasNext() && srcAnsInfoView.getEstimatedRowCount() > 0L ) {
            isRecordUnique = false;
            srcAnsRow = (SrcAnsUniqueInfoRow) srcAnsInfoView.next();
            
            if ( 
                srcAnsRow.getSraAnswer() == null && 
                srcAnsRow.getSraAnswerText() == null && 
                srcAnsRow.getSraAsvId() == null && 
                srcAnsRow.getSraRavId() == null &&
                srcAnsRow.getSraColor() == null &&
                srcAnsRow.getSraComment() == null
            ) {
                srcAnsRow = null;
            }
                            
        }
        
        return srcAnsRow;
    }
    
    */
    public List<String> getSimilarSources(String fName, 
                                          String lName, 
                                          String city,
                                          int ctryId,
                                          String company,
                                          String phone) {   //6 params
            CallableStatement cs = null;
            String csBegin = "begin ? := ";
            String csEnd = " end;";
            String csStatement = " getsimilarsources(?,?,?,?,?,?);";    // 6?s
            String csCall = csBegin + csStatement + csEnd;
            
            String srcsReturned = null;
            
            try {
            
                cs = platform.getDBTransaction().createCallableStatement(csCall, 0);
                
                cs.registerOutParameter( 1, Types.VARCHAR );
                
                cs.setString( 2, fName );
                cs.setString( 3, lName );
                cs.setString( 4, city);
                cs.setString( 5, String.valueOf(ctryId) );
                cs.setString( 6, company );
                cs.setString( 7, phone );
                
//                ResultSet rs = cs.executeQuery();
                cs.execute();
                
                srcsReturned = cs.getString(1);
                
                String[] srcIds = srcsReturned.split(",");
                
                cs.close();
                
                return Arrays.asList( srcIds );
                
                
            } catch ( SQLException e) {
                LOG.error("Error", e);  //e.printStackTrace();
                LOG.error("Error in getting similar sources", e);
            }
            
            finally {
                try {
                    if ( cs != null ) cs.close();
                } catch ( SQLException se) {
                    LOG.error("Error", se);  //e.printStackTrace();
                }
            }
            
            return null;
        
    }
    
    public int getBestSourceId(int[] sourceIds, int rprtId) {
        if ( sourceIds.length <= 0 ) return 0;
        if ( sourceIds.length == 1 ) return sourceIds[0];
        
LOG.info("in getBestSourceId");        
        SourceNumReportsReportersLastDateView view = platform.getSourceNumReportsReportersLastDateView();
        List<SourceNumReportsReportersLastDateViewRow> srcsList = new ArrayList<SourceNumReportsReportersLastDateViewRow>();
        Map<Number, SourceNumReportsReportersLastDateViewRow> srcsMaps = new HashMap<Number, SourceNumReportsReportersLastDateViewRow>();
        for ( int i = 0; i < sourceIds.length; i++ ) {
            Number srcIdNum = new Number( sourceIds[i]);
        
            view.setsrc_id( srcIdNum );
        
            view.executeQuery();
            if ( view.hasNext() ) {
                SourceNumReportsReportersLastDateViewRow row = (SourceNumReportsReportersLastDateViewRow) view.next();
                srcsList.add( row );
                srcsMaps.put( row.getSrcId(), row );
            }
        }
    
//        int maxReports = 0;
//        int srcIdMaxReports = 0;
//
//        int maxReporters = 0;
//        int srcIdMaxReporters = 0;

        Calendar cal = Calendar.getInstance();
        cal.set(1980, 1, 1);//setTimeInMillis(1000);
        long aLong = 0L;        //cal.getTimeInMillis();
LOG.info( "aLong is " + aLong);
        
        Date lastReportDate = null;     //new oracle.jbo.domain.Date( new Timestamp( aLong ) );
    
    //
    //            java.util.Date utilDate = cal.getTime();//new Date("1000");
    //            java.sql.Date sqlDate = new java.sql.Date( utilDate.getTime() );
    //            Date lastReportDate = new oracle.jbo.domain.Date( sqlDate );
        int srcIdLastDate = 0;
        Date lastDate = null;
        int i = 0;

        for (Iterator<SourceNumReportsReportersLastDateViewRow> it = srcsList.iterator(); it.hasNext(); ) {
        i++;
        LOG.info(" is is " + i);
            SourceNumReportsReportersLastDateViewRow row = it.next();
            int srcId           = row.getSrcId().intValue();        LOG.info("srcId is " + srcId);
            int numReports      = row.getReports().intValue();        LOG.info("numReports is " + numReports);
            int numReporters    = row.getReporters().intValue();        LOG.info("numReporters is " + numReporters);
            lastDate       = row.getLastduedate();        LOG.info("lastDate is " + lastDate);

//                    if ( maxReports < numReports ) {
//                        maxReports = numReports;
//                        srcIdMaxReports = srcId;
//                    }
//    
//    
//                    if ( maxReporters < numReporters ) {
//                        maxReporters = numReporters;
//                        srcIdMaxReporters = srcId;
//                    }
    
                    if ( lastDate != null ) {
    //LOG.info("lastReportDate.longValue() is " + lastReportDate.toNumber().longValue());
    //LOG.info("lastDate.longValue() is " + lastDate.toNumber().longValue());
    
                        if ( aLong  < lastDate.getValue().getTime() ) {
                            lastReportDate = lastDate;
                            srcIdLastDate = srcId;
                            
                            aLong = lastDate.getValue().getTime();
                        }
                    }
    
                }
    
//                LOG.info("srcIdMaxReports is " + srcIdMaxReports + " maxReports is " + maxReports);
//                LOG.info("srcIdMaxReporters is " + srcIdMaxReporters + " maxReporterss is " + maxReporters);
                LOG.info("srcIdLastDate is " + srcIdLastDate + " lastDate is " + lastReportDate);
    
    
    
//            } catch (SQLException e) {
//                LOG.error("Error", e);  //e.printStackTrace();
//                LOG.error("Error in idientifying the correct source", e);
//            }
            
        return srcIdLastDate;//0;
    }
    
    
    public int getBestSourceId2(int[] sourceIds, int rprtId) {
        if ( sourceIds.length <= 0 ) return 0;
        if ( sourceIds.length == 1 ) return sourceIds[0];
        
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql =  "SELECT * FROM src_rprt_rprtr_date_view WHERE\n" + 
                                "TO_CHAR( src_id ) in ( ? )\n" + 
                            "AND\n" + 
                            " lastduedate = (\n" + 
                            "    SELECT MAX( lastduedate ) FROM src_rprt_rprtr_date_view\n" + 
                            "    WHERE TO_CHAR( src_id ) in ( ? )\n" + 
                            ")";
        
        
//        GetBestSourceId sView = platform.getGetBestSourceId();
        String[] theIds = new String[sourceIds.length];

        String srcs = "";// "(";
        for ( int i = 0; i < sourceIds.length; i++ ) {
            theIds[i] = String.valueOf( sourceIds[i] );
            
            srcs += "'" + String.valueOf( sourceIds[i] ) + "'";
            
            if ( i != sourceIds.length - 1 ) {
                srcs += ", ";
            }
        }
//        srcs += ")";
        pst = platform.getDBTransaction().createPreparedStatement( sql, 0 );
        
        try {
            pst.setString( 1, srcs );
            pst.setString( 2, srcs );
            
            rs = pst.executeQuery();
            
            // make sure only one record came back
            rs.last();
            int count = rs.getRow();
            if ( count != 1 ) return 0;
            rs.beforeFirst();
            
            // go to that record
            rs.next();
            int src_id = rs.getInt("SRC_ID");
            
            rs.close();
            pst.close();
            
            return src_id;
            
        } catch ( SQLException se) {
            LOG.error("Error", se);  //e.printStackTrace();
        }
        
        finally {
            try {
                if ( rs != null ) rs.close();
                if ( pst != null ) pst.close();
            }
            catch (SQLException e) {
                LOG.error("Error", e);  //e.printStackTrace();
            }
        }
        
//       --- arrrgh 
//        final List<String> lst_SrcIds = Arrays.asList( theIds );
//LOG.info("lst_SrcIdsis " + lst_SrcIds);
//        
//       
////            SourceNumReportsReportersLastDateView view = platform.getSourceNumReportsReportersLastDateView();
////            List<SourceNumReportsReportersLastDateViewRow> srcsList = new ArrayList<SourceNumReportsReportersLastDateViewRow>();
////            Map<Number, SourceNumReportsReportersLastDateViewRow> srcsMaps = new HashMap<Number, SourceNumReportsReportersLastDateViewRow>();
//        
//        
////            Array srcs;// = new Array();
////            srcs = new Array( lst_SrcIds );
//        LOG.info("srcs is " + srcs);
//        
//        
////        sView.setlist_ids(srcs);
////        sView.executeQuery();
////        LOG.info("query is " + sView.getQuery());//.replaceAll(":list_ids", srcs) );
////LOG.info(" sView.getEstimatedRowCount()  is " +  sView.getEstimatedRowCount() );
////        if ( sView.getEstimatedRowCount() > 1 ) return 0;
////        
////        if ( sView.hasNext() ) {
////            GetBestSourceIdRow row = (GetBestSourceIdRow) sView.next();
////            Number srcId = row.getSrcId();
////            return srcId.intValue();
////        }
////
//        
///********
////            for ( int i = 0; i < sourceIds.length; i++ ) {
////                Number srcIdNum = new Number( sourceIds[i]);
////
////                view.setsrc_id( srcIdNum );
////
////                view.executeQuery();
////                if ( view.hasNext() ) {
////                    SourceNumReportsReportersLastDateViewRow row = (SourceNumReportsReportersLastDateViewRow) view.next();
////                    srcsList.add( row );
////                    srcsMaps.put( row.getSrcId(), row );
////                }
////            }
////
////            int maxReports = 0;
////            int srcIdMaxReports = 0;
////
////            int maxReporters = 0;
////            int srcIdMaxReporters = 0;
////
////            Calendar cal = Calendar.getInstance();
////            cal.set(1980, 1, 1);//setTimeInMillis(1000);
////            long aLong = cal.getTimeInMillis();
////LOG.info( "aLong is " + aLong);
////
////            Date lastReportDate = null;     //new oracle.jbo.domain.Date( new Timestamp( aLong ) );
////
//////
//////            java.util.Date utilDate = cal.getTime();//new Date("1000");
//////            java.sql.Date sqlDate = new java.sql.Date( utilDate.getTime() );
//////            Date lastReportDate = new oracle.jbo.domain.Date( sqlDate );
////            int srcIdLastDate = 0;
////            Date lastDate = null;
////            int i = 0;
////
////            for (Iterator<SourceNumReportsReportersLastDateViewRow> it = srcsList.iterator(); it.hasNext(); ) {
////            i++;
////            LOG.info(" is is " + i);
////                SourceNumReportsReportersLastDateViewRow row = it.next();
////                int srcId           = row.getSrcId().intValue();        LOG.info("srcId is " + srcId);
////                int numReports      = row.getReports().intValue();        LOG.info("numReports is " + numReports);
////                int numReporters    = row.getReporters().intValue();        LOG.info("numReporters is " + numReporters);
////                lastDate       = row.getLastduedate();        LOG.info("lastDate is " + lastDate);
////
////                if ( maxReports < numReports ) {
////                    maxReports = numReports;
////                    srcIdMaxReports = srcId;
////                }
////
////
////                if ( maxReporters < numReporters ) {
////                    maxReporters = numReporters;
////                    srcIdMaxReporters = srcId;
////                }
////
////                if ( lastDate != null ) {
//////LOG.info("lastReportDate.longValue() is " + lastReportDate.toNumber().longValue());
//////LOG.info("lastDate.longValue() is " + lastDate.toNumber().longValue());
////
////                    if ( aLong  < lastDate.getValue().getTime() ) {
////                        lastReportDate = lastDate;
////                        srcIdLastDate = srcId;
////                    }
////                }
////
////            }
////
////            LOG.info("srcIdMaxReports is " + srcIdMaxReports + " maxReports is " + maxReports);
////            LOG.info("srcIdMaxReporters is " + srcIdMaxReporters + " maxReporterss is " + maxReporters);
////            LOG.info("srcIdLastDate is " + srcIdLastDate + " lastDate is " + lastReportDate);
////
////
//************/
//        
////        } catch (SQLException e) {
////            LOG.error("Error", e);  //e.printStackTrace();
////            LOG.error("Error in idientifying the correct source", e);
////        }
//   --- argh 
    return 0;
}
    
    public int getBestSourceId_o(int[] sourceIds, int rprtId) {
//        try {
            if ( sourceIds.length <= 0 ) return 0;
            if ( sourceIds.length == 1 ) return sourceIds[0];
            
            GetBestSourceId sView = platform.getGetBestSourceId();
            String[] theIds = new String[sourceIds.length];

            String srcs = "(";
            for ( int i = 0; i < sourceIds.length; i++ ) {
                theIds[i] = String.valueOf( sourceIds[i] );
                
                srcs += "'" + String.valueOf( sourceIds[i] ) + "'";
                
                if ( i != sourceIds.length - 1 ) {
                    srcs += ", ";
                }
            }
            srcs += ")";
            
            final List<String> lst_SrcIds = Arrays.asList( theIds );
LOG.info("lst_SrcIdsis " + lst_SrcIds);            
            
           
//            SourceNumReportsReportersLastDateView view = platform.getSourceNumReportsReportersLastDateView();
//            List<SourceNumReportsReportersLastDateViewRow> srcsList = new ArrayList<SourceNumReportsReportersLastDateViewRow>();
//            Map<Number, SourceNumReportsReportersLastDateViewRow> srcsMaps = new HashMap<Number, SourceNumReportsReportersLastDateViewRow>();
            
            
//            Array srcs;// = new Array();
//            srcs = new Array( lst_SrcIds );
            LOG.info("srcs is " + srcs);
            
            
            sView.setlist_ids(srcs);
            sView.executeQuery();
            LOG.info("query is " + sView.getQuery());//.replaceAll(":list_ids", srcs) );
LOG.info(" sView.getEstimatedRowCount()  is " +  sView.getEstimatedRowCount() );            
            if ( sView.getEstimatedRowCount() > 1 ) return 0;
            
            if ( sView.hasNext() ) {
                GetBestSourceIdRow row = (GetBestSourceIdRow) sView.next();
                Number srcId = row.getSrcId();
                return srcId.intValue();
            }
            
/********            
//            for ( int i = 0; i < sourceIds.length; i++ ) {
//                Number srcIdNum = new Number( sourceIds[i]);
//                
//                view.setsrc_id( srcIdNum );
//                
//                view.executeQuery();
//                if ( view.hasNext() ) {
//                    SourceNumReportsReportersLastDateViewRow row = (SourceNumReportsReportersLastDateViewRow) view.next();
//                    srcsList.add( row );
//                    srcsMaps.put( row.getSrcId(), row );
//                }
//            }
//            
//            int maxReports = 0;
//            int srcIdMaxReports = 0;
//            
//            int maxReporters = 0;
//            int srcIdMaxReporters = 0;
//            
//            Calendar cal = Calendar.getInstance();
//            cal.set(1980, 1, 1);//setTimeInMillis(1000);
//            long aLong = cal.getTimeInMillis();
//LOG.info( "aLong is " + aLong);            
//
//            Date lastReportDate = null;     //new oracle.jbo.domain.Date( new Timestamp( aLong ) );
//            
////            
////            java.util.Date utilDate = cal.getTime();//new Date("1000");
////            java.sql.Date sqlDate = new java.sql.Date( utilDate.getTime() );
////            Date lastReportDate = new oracle.jbo.domain.Date( sqlDate ); 
//            int srcIdLastDate = 0;
//            Date lastDate = null; 
//            int i = 0;
//            
//            for (Iterator<SourceNumReportsReportersLastDateViewRow> it = srcsList.iterator(); it.hasNext(); ) {
//            i++;
//            LOG.info(" is is " + i);
//                SourceNumReportsReportersLastDateViewRow row = it.next();
//                int srcId           = row.getSrcId().intValue();        LOG.info("srcId is " + srcId);
//                int numReports      = row.getReports().intValue();        LOG.info("numReports is " + numReports);
//                int numReporters    = row.getReporters().intValue();        LOG.info("numReporters is " + numReporters);
//                lastDate       = row.getLastduedate();        LOG.info("lastDate is " + lastDate);
//                
//                if ( maxReports < numReports ) {
//                    maxReports = numReports;
//                    srcIdMaxReports = srcId;
//                }
//                
//                
//                if ( maxReporters < numReporters ) {
//                    maxReporters = numReporters;
//                    srcIdMaxReporters = srcId;
//                }
//                
//                if ( lastDate != null ) {
////LOG.info("lastReportDate.longValue() is " + lastReportDate.toNumber().longValue());
////LOG.info("lastDate.longValue() is " + lastDate.toNumber().longValue());
//
//                    if ( aLong  < lastDate.getValue().getTime() ) {
//                        lastReportDate = lastDate;
//                        srcIdLastDate = srcId;
//                    }
//                }
//                
//            }
//            
//            LOG.info("srcIdMaxReports is " + srcIdMaxReports + " maxReports is " + maxReports);
//            LOG.info("srcIdMaxReporters is " + srcIdMaxReporters + " maxReporterss is " + maxReporters);
//            LOG.info("srcIdLastDate is " + srcIdLastDate + " lastDate is " + lastReportDate);
//            
//            
 ************/           
            
//        } catch (SQLException e) {
//            LOG.error("Error", e);  //e.printStackTrace();
//            LOG.error("Error in idientifying the correct source", e);
//        }
        
        return 0;
    }
    
    
    public void setCollectorName(String rptrId) {
        PreparedStatement pstmtBlock = null;
        String statement = "BEGIN Collector.set_nam(:1); END;";
        pstmtBlock = platform.getDBTransaction().createPreparedStatement( statement, 0 );
        
        try {
            pstmtBlock.setString( 1, rptrId );
            pstmtBlock.execute();
            LOG.info("Setting collectorname to " + rptrId);
            pstmtBlock.close();
        } catch ( SQLException se) {
            LOG.error("Error", se);  //e.printStackTrace();
            LOG.error("Could not set collector name for reporter " + rptrId, se);
            throw new SQLStmtException ( CSMessageBundle.class, CSMessageBundle.EXC_SQL_EXECUTE_COMMAND, statement, se);
        } finally {
            try {
                pstmtBlock.close();
            } catch ( SQLException sqe) {
                LOG.error("Couldn close pstmnt block");
                LOG.error("Error", sqe);  //e.printStackTrace();
            }
        }
        
        
    }
    
    public Number uploadAnswerGridErrorFile(Workbook w, int reportId, int reporterId) {
    LOG.info("uploadAnswerGridErrorFile --> reportId " + reportId + " and reporterId " + reporterId + " and w is " + w + " is w null --> " + (w == null));    
        PreparedStatement pstmtBlock = null;
        String sql = "INSERT INTO BAwaWEb_ANSWER_GRID_ERROR_FILES( AGEF_ID, AGEF_FILE_NAME, AGEF_FILE_FORMAT_TYPE, AGEF_RPRT_ID, CREATION_DATE, CREATED_BY, AGEF_FILE ) " + 
                        " values (?, ?, ?, ?, ?, ?, ?)";    // 7 ?'s
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutput out = null;
        System.out.println("buff size [initila is " + baos.toByteArray().length);
        LOG.info("buff size [initila is " + baos.toByteArray().length);
        WritableWorkbook ww;
        try {
           /* out = new ObjectOutputStream( baos );
            out.writeObject( w );
            out.close();
        */
            ww = Workbook.createWorkbook( baos, w );
            w.close();
            ww.close();
            
LOG.info("ww[numsheets] is " + ww.getNumberOfSheets());            
LOG.info("ww[numsheets] is " + ww.getNumberOfSheets());

        } catch (IOException e) {
            e.printStackTrace();
            LOG.error("Could not generate writable workbook for reportid " + reportId + " and reporter " + reporterId, e);
            LOG.info("Could not generate writable workbook for reportid " + reportId + " and reporter " + reporterId);
            return null;
        } catch (WriteException e) {
             LOG.error("Could not WRITE OUT writable workbook for reportid " + reportId + " and reporter " + reporterId, e);
             return null;
        }

        byte[] buff = baos.toByteArray();
        System.out.println("buff [in uploadAnswerGridErrorFile ] size is " + buff.length);
LOG.info("buff size is " + buff.length);
        LOG.info("buff size is " + buff.length);
        
        // write it toa file
         FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("\\\\san-filer1\\nmedhora$\\my documents\\jxlTesting\\UPLOAD_" + + reportId + "_" + reporterId + ".xls" );
            fos.write( buff );
            fos.close(); 
        } catch (Exception e ) { e.printStackTrace(); }

        pstmtBlock = platform.getDBTransaction().createPreparedStatement( sql, 0 );
        
        Sequence otrSeq = new Sequence("BAwaWEb_SEQ", platform);
        String nxtSeqIdVal = otrSeq.getData().toString();
        Number nxtSeqId = null;           
        try {
            nxtSeqId = new Number( nxtSeqIdVal);
        } catch (SQLException e) { 
            LOG.error("Could not create sequence", e);
            LOG.info("Could not create sequence");
            return null;
        }

        Timestamp uploadDate =  new Timestamp(Calendar.getInstance().getTimeInMillis());
            
        try {
            pstmtBlock.setInt( 1, nxtSeqId.intValue() );
            
            
            
            pstmtBlock.setString( 2, String.valueOf( reportId) + "_" + String.valueOf( reporterId ) + uploadDate.toString() + ".xls");
            
            pstmtBlock.setString( 3, "XLS");

            pstmtBlock.setInt( 4, reportId  );
            pstmtBlock.setTimestamp( 5, uploadDate );
            pstmtBlock.setString( 6, String.valueOf( reporterId ) );
            
            pstmtBlock.setBytes( 7, buff );
            
            pstmtBlock.executeUpdate();
            pstmtBlock.close();
            
            return nxtSeqId;
            
        } catch (SQLException se) {
            LOG.error( "Could not insert xl file to db -- reportid " + reportId + " for reporter " + reporterId + " time --> " + uploadDate, se);
            LOG.info( "Could not insert xl file to db -- reportid " + reportId + " for reporter " + reporterId + " time --> " + uploadDate);
            throw new SQLStmtException ( CSMessageBundle.class, CSMessageBundle.EXC_SQL_EXECUTE_COMMAND, sql, se);
        } finally {
            try {
                pstmtBlock.close();
            } catch ( SQLException sqe) {
                LOG.error("Couldn close pstmnt block");
                LOG.info("Couldn close pstmnt block");
                LOG.error("Error", sqe);  //e.printStackTrace();
            }
        }
        
    }    
    
    public void getErrorXLFile(int id) {
        if ( id == 0 ) throw new IllegalArgumentException("Error id is 0");
        // generates the xl file from the bawaweb_answer_grid_file
        GetErrXLFileInfo errFilesView = platform.getGetErrXLFile();
            
        
        Workbook www;
        WritableWorkbook w2;
        
        
        GetErrXLFileInfoRow row = null;// = (GetErrXLFileInfoRow) errFilesView
        
        errFilesView.setagef_id( new Number(id) );
        
        errFilesView.executeQuery();
        
        if ( errFilesView.hasNext() ) {
            row = (GetErrXLFileInfoRow) errFilesView.next();
            
            row.lock();
            
            String fileName = row.getAgefFileName();
            
            fileName = fileName.replaceAll(" ", "_");
            fileName = fileName.replaceAll(":", "_");
            
            
            String format = row.getAgefFileFormatType();
            BlobDomain theblob = row.getAgefFile();
            byte[] theBytes = theblob.toByteArray();
            
            System.out.println("thebytes size is " + theBytes.length );
            FileOutputStream fos = null;
//            // Create the decompressor and give it the data to compress
//            Inflater decompressor = new Inflater();
//            decompressor.setInput(compressedData);
            try {
                fos = new FileOutputStream("\\\\san-filer1\\nmedhora$\\my documents\\jxlTesting\\ERROR_" + fileName );
                fos.write( theBytes );
                fos.close(); 
            } catch (Exception e ) { e.printStackTrace(); }
            
        }    
        
    }
    
    
    public void getErrorXLFileA(int id) {
        if ( id == 0 ) throw new IllegalArgumentException("Error id is 0");
        // generates the xl file from the bawaweb_answer_grid_file
        GetErrXLFileInfo errFilesView = platform.getGetErrXLFile();
            
        
        Workbook www;
        WritableWorkbook w2;
        
        
        GetErrXLFileInfoRow row = null;// = (GetErrXLFileInfoRow) errFilesView
        
        errFilesView.setagef_id( new Number(id) );
        
        errFilesView.executeQuery();
        
        if ( errFilesView.hasNext() ) {
            row = (GetErrXLFileInfoRow) errFilesView.next();
            
            row.lock();
            
            String fileName = row.getAgefFileName();
            
            fileName = fileName.replaceAll(" ", "_");
            fileName = fileName.replaceAll(":", "_");
            
            
            String format = row.getAgefFileFormatType();
            BlobDomain theblob = row.getAgefFile();
            byte[] theBytes = theblob.toByteArray();
System.out.println("the bytes size is "  + theBytes.length );            
            ByteArrayInputStream bais = new ByteArrayInputStream( theBytes );


            try {
                www = Workbook.getWorkbook( bais );
                
                ByteArrayOutputStream boos = new ByteArrayOutputStream();
                w2 = Workbook.createWorkbook( boos, www);
                w2.setOutputFile( new File("\\\\san-filer1\\nmedhora$\\my documents\\jxlTesting\\ERROR_" + fileName) );
                
                
                w2.write();
                
                w2.close();
                
            } catch (BiffException e) {
                LOG.error("Error", e);  //e.printStackTrace();
                LOG.error("Could not read input stream", e);
            } catch (IOException e) {
                LOG.error("Error", e);  //e.printStackTrace();
                LOG.error("Error in getting inputstream", e);
            } catch (WriteException e) {
                LOG.error("Error", e);  //e.printStackTrace();
                LOG.error("Error in writing to file", e);
            }


            LOG.info("in getErrorXLFile thebytes.length is " + theBytes.length);
LOG.info("in getErrorXLFile theblob.getStorageByteArray is " + theblob.getStorageByteArray().length);
            /***********************
            InputStream in = theblob.getInputStream();
            
            ByteArrayOutputStream bos = new ByteArrayOutputStream();// theBytes.length );
            byte[] buff = new byte[1024];


            try {
                www = Workbook.getWorkbook( in );// new ByteArrayInputStream(buff) );
                ByteArrayOutputStream boos = new ByteArrayOutputStream();
                w2 = Workbook.createWorkbook( boos, www);
                w2.setOutputFile( new File("\\\\san-sv-filer\\nmedhora$\\my documents\\jxlTesting\\ERROR_" + fileName) );
                
                
                w2.write();
                
                w2.close();
                
            } catch (BiffException e) {
                LOG.error("Error", e);  //e.printStackTrace();
            } catch (IOException e) {
                LOG.error("Error", e);  //e.printStackTrace();
            } catch (WriteException e) {
                LOG.error("Error", e);  //e.printStackTrace();
            }
            ************************/
            
        }    
        
    }
    
    public String getAnswerSetName(int ans_id) {
        if ( ans_id <= 0 ) return null;
        
        AnswerSets ansView = platform.getAnswerSets();
        ansView.setans_id( new Number( ans_id ) );
        
        ansView.executeQuery();
        
        if ( ansView.hasNext() ) {
            AnswerSetsRow row = (AnswerSetsRow) ansView.next();
            if ( row.getAnsAddAnswerYn().equalsIgnoreCase("Y") && row.getAnsDeleteYn().equalsIgnoreCase("N") )
                return row.getAnsName();
        }
        return null;
    }
    
    public boolean canAddAnswerSetsToQuestion(Number qstnId) {
        boolean canAddAnswerSet = false;
        // its still not certain which to use
        // bawaweb_answer_sets
        // bawaweb_report_answer_sets
        // but since this is for the particular report
        // better to use bawaweb_report_answer_sets
        AddAnswerSetForQstn addAnsView = platform.getAddAnswerSetForQstn();        
        addAnsView.setqst_id( qstnId );        
        addAnsView.executeQuery();
        
        if ( addAnsView.hasNext() ) {
            AddAnswerSetForQstnRow addAnsRow = (AddAnswerSetForQstnRow) addAnsView.next();
            String canAdd = addAnsRow.getRasAddAnswerYn();
            
            if ( canAdd.equalsIgnoreCase("Y") ) {
                canAddAnswerSet = true;
            }
        }
LOG.info("in canAddAnswerSetsToQuestion -- for qstnid " + qstnId + " returning ==> " + canAddAnswerSet);        
        return canAddAnswerSet;
    }


    private List<String> getCourtesyTitles() {
        List<String> theList = new ArrayList<String>();
        CourtesyTitles titles = platform.getCourtesyTitles();
        titles.executeQuery();
        while ( titles.hasNext() ) {
            CourtesyTitlesRow courtRow = (CourtesyTitlesRow) titles.next();
            String title = courtRow.getCtlCode();
            theList.add( title );
        }       
        return theList;
    }
    
    
    private List<String> getSuffixTitles() {
        List<String> theList = new ArrayList<String>();
        SuffixTitles titles = platform.getSuffixTitles();
        titles.executeQuery();
        while ( titles.hasNext() ) {
            SuffixTitlesRow courtRow = (SuffixTitlesRow) titles.next();
            String title = courtRow.getCtlCode();
            theList.add( title );
        }
        
        return theList;
    }
    
    public LinkedHashMap<String, String> getSourceDistributionPreferencesMap() {
        LinkedHashMap<String, String> sourceDistributionPreferencesMap = new LinkedHashMap<String, String>();
        SourceDistributionPreferences preferences = platform.getSourceDistributionPreferences();
        preferences.executeQuery();
        while ( preferences.hasNext() ) {
            SourceDistributionPreferencesRow row = (SourceDistributionPreferencesRow) preferences.next();
            String code = row.getLkdCode();
            String desc = row.getLkdDescription();
            
            sourceDistributionPreferencesMap.put( desc, code);
            
        }        
        return sourceDistributionPreferencesMap;
        
    }
    
    
    public LinkedHashMap<String, String> getQualityRatingsMap() {
        LinkedHashMap<String, String> qltyRatingsMap = new LinkedHashMap<String, String>();
        QualityRatings ratings = platform.getQualityRatings();
        ratings.executeQuery();
        while ( ratings.hasNext() ) {
            QualityRatingsRow row = (QualityRatingsRow) ratings.next();
            String code = row.getLkdCode();
            String desc = row.getLkdDescription();
            
            qltyRatingsMap.put( desc, code);
            
        }        
        return qltyRatingsMap;
        
    }
    
    public LinkedHashMap<String, String> getIndustryViewsMap() {
        LinkedHashMap<String, String> indViewMap = new LinkedHashMap<String, String>();
        
        IndustryViews indViews = platform.getIndustryViews();
        indViews.executeQuery();
        
        while ( indViews.hasNext() ) {
            IndustryViewsRow row = (IndustryViewsRow) indViews.next();
            String code = row.getLkdCode();
            String desc = row.getLkdDescription();
            
            indViewMap.put( desc, code);
        }
        return indViewMap;
    }
    
    public LinkedHashMap<String, Integer> getTimeZonesMap() {
        LinkedHashMap<String, Integer> tmzMap = new LinkedHashMap<String, Integer>();
        
        TimeZones theTimeZones = platform.getTimeZones();
        theTimeZones.executeQuery();
        
        while ( theTimeZones.hasNext() ) {
            TimeZonesRow row = (TimeZonesRow) theTimeZones.next();
            Number tmzId = row.getTmzId();
            String tmzNameDesc = row.getTmzNameDescription();
            
            tmzMap.put(  tmzNameDesc, tmzId.intValue());
        }
        
        return tmzMap;
    }
    
    
    public Map<String, Integer> getCountriesListings() {
        Map<String, Integer> mp_CtryName_CtryIds = new HashMap<String, Integer>();
        
        CountriesList theCountries = platform.getCountriesList();
        theCountries.executeQuery();
        
        while ( theCountries.hasNext() ) {
            CountriesListRow row = (CountriesListRow) theCountries.next();
            mp_CtryName_CtryIds.put( row.getCtryName(), row.getCtryId().intValue() );
        }
        
        return mp_CtryName_CtryIds;
    }
    
    public List<String> getAllASVValues() {
        ASVAnswerValues asvValues = platform.getASVAnswerValues();
        
        asvValues.executeQuery();
        List<String> theValues = new ArrayList<String>();
        int count = 0;
        while ( asvValues.hasNext() ) {
            count++;
            ASVAnswerValuesRow row = (ASVAnswerValuesRow) asvValues.next(); 
            String val = row.getAsvAnswer();
LOG.info(count + "  |" + val + "|");            
            theValues.add( val );
        }
        
        return theValues;
    }
    
    public Map<Integer, List<AnswerSetValuesDataSetInfo>> getExtraQuestionsAnswerSetValuesMap(int reportId) {
        Map<Integer, List<AnswerSetValuesDataSetInfo>> map = new HashMap<Integer, List<AnswerSetValuesDataSetInfo>>();
        List<Integer> theQstnIds = new ArrayList<Integer>();
        ExtraQstnsAnswerSetValues xQ = platform.getExtraQstnsAnswerSetValues();
        xQ.setrprt_id( new Number( reportId ));
        
        xQ.executeQuery();
        
        while ( xQ.hasNext() ) {
            ExtraQstnsAnswerSetValuesRow row = (ExtraQstnsAnswerSetValuesRow) xQ.next();
            int qstId = row.getQstId().intValue();
            
            int asvId = row.getAsvId().intValue();
            int ansId = row.getAsvAnsId().intValue();
            String asvAnswer = row.getAsvAnswer();
            int asvDisplaySeq = row.getAsvDisplaySeq().intValue();
            String asvDeleteYn = row.getAsvDeleteYn();
            
            
            AnswerSetValuesDataSetInfo rec = new AnswerSetValuesDataSet();
            rec.setAsv_id( asvId );
            rec.setAsv_ans_id( ansId );
            rec.setAsv_answer( asvAnswer.trim() );
            rec.setAsv_display_seq( asvDisplaySeq );
            rec.setAsv_delete_yn( asvDeleteYn );
            
            
            List<AnswerSetValuesDataSetInfo> aList;
            
            if ( !map.containsKey( qstId )) {
                aList = new ArrayList<AnswerSetValuesDataSetInfo>();
                
            } else {
                aList = map.get( qstId );
            }
            
            aList.add( rec );
            map.put( qstId, aList );
        }
        
        
        return map;
    }
    
    
    public Map<Integer, List<ReportAnswerSetValuesDataSetInfo>> getExtraQuestionsReportAnswerSetValuesMap(int reportId) {
        Map<Integer, List<ReportAnswerSetValuesDataSetInfo>> map = new HashMap<Integer, List<ReportAnswerSetValuesDataSetInfo>>();
        List<Integer> theQstnIds = new ArrayList<Integer>();
        ExtraQstnsReportAnswerSetValues xQ = platform.getExtraQstnsReportAnswerSetValues();
        xQ.setrprt_id( new Number( reportId ));
        
        xQ.executeQuery();
        
        while ( xQ.hasNext() ) {
            ExtraQstnsReportAnswerSetValuesRow row = (ExtraQstnsReportAnswerSetValuesRow) xQ.next();
            int qstId = row.getQstId().intValue();
            
            int ravRasId = row.getRavRasId().intValue();
            int ansId = row.getAnsId().intValue();
            int ravId = row.getRavId().intValue();
            String ravAnswer = row.getRavAnswer().trim();
            int ravDisplaySeq = row.getRavDisplaySeq().intValue();
            int ravAsvId = row.getRavAsvId().intValue();
            String ravDeleteYn = row.getRavDeleteYn();
            
            
            ReportAnswerSetValuesDataSetInfo rec = new ReportAnswerSetValuesDataSet();
            rec.setRav_ras_id( ravRasId );
            rec.setAns_id( ansId );
            rec.setRav_id( ravId );
            rec.setRav_answer( ravAnswer );
            rec.setRav_display_seq( ravDisplaySeq );
            rec.setRav_asv_id( ravAsvId );
            rec.setRav_delete_yn( ravDeleteYn );
            
            
            List<ReportAnswerSetValuesDataSetInfo> aList;
            
            if ( !map.containsKey( qstId )) {
                aList = new ArrayList<ReportAnswerSetValuesDataSetInfo>();
                
            } else {
                aList = map.get( qstId );
            }
            
            aList.add( rec );
            map.put( qstId, aList );
        }
        
        
        return map;
    }
    
    // receives all the report ans info
    // and not for the 1 question
    public void addAnswerSetValues(int qstnId, 
                                   List<AnswerSetValuesDataSetInfo> liExistingAnsSetVals, 
                                   List<ReportAnswerSetValuesDataSetInfo> liExistingReportAnsSetVals, 
                                   List<String> extraAnsVals) {
//    LOG.info("STARTin addAnswerSetValues qstid is  " + qstnId);
//LOG.info("liExASV size is is " + liExistingAnsSetVals.size());
//printList( liExistingAnsSetVals);

        final Number  ansId = new Number( liExistingAnsSetVals.get(0).getAsv_ans_id() );    // all asv belong to same as
        final Number rasId = new Number( liExistingReportAnsSetVals.get(0).getRav_ras_id() );   // all rasv belong to same ras
        
        final int numExtraVals = extraAnsVals.size();
        
        final String[] mandArrVals = new String[] { "Don't know", "No reponse", "Not applicable", "Other" };
        
        final List<String> mandatoryVals = Arrays.asList( mandArrVals );
        
//        liExistingAnsSetVals = processAsvDisplaySeq( liExistingAnsSetVals, ansId );
//        liExistingReportAnsSetVals = processRavDisplaySeq( liExistingReportAnsSetVals, rasId );
//        
//        Collections.sort( liExistingAnsSetVals, new AnswerSetValuesDataSetComparator() );
//        
//        Collections.sort( liExistingReportAnsSetVals, new ReportAnswerSetValuesDataSetComparator() );
        
        
    
        if ( numExtraVals > 0 ) {
            
    LOG.info("ansid is " + ansId);
    LOG.info("rasId is " + rasId);
    LOG.info("numExtraVals is " + numExtraVals);
            
//            Pair pair_asvDonktKnowInfo = getASVDontKnowDisplaySequenceInfo( liExistingAnsSetVals );
//            Pair pair_ravDonktKnowInfo = getRAVDontKnowDisplaySequenceInfo( liExistingReportAnsSetVals );
//            
//            
//            
//            final int asvFromIndex = pair_asvDonktKnowInfo.getX() - 1;
//            LOG.info("asvFromIndex is " + asvFromIndex);
//            
//            final int asvDontKnowSeqNum = pair_asvDonktKnowInfo.getY();
//            LOG.info("asvDontKnowSeqNum is " + asvDontKnowSeqNum);            
//            
//            //final int asvDontKnowSeqNum = getASVDontKnowDisplaySequenceNum( liExistingAnsSetVals );            
//
//            //final int asvFromIndex = getASVDontKnowDisplaySequenceIndex( liExistingAnsSetVals, asvDontKnowSeqNum ) - 1;//asvDontKnowSeqNum - 1;            
//    
//            final int asvToIndex = asvFromIndex + 4;//liExistingAnsSetVals.size();            
//    LOG.info("asvToIndex is " + asvToIndex);
            final int asvFromDisplaySeq = getASVDontKnowDisplaySequenceNum( liExistingAnsSetVals, ansId );//liExistingAnsSetVals.get( asvFromIndex ).getAsv_display_seq();            
//    LOG.info("asvFromDisplaySeq is " + asvFromDisplaySeq);
            List<AnswerSetValuesDataSetInfo> liAsvUpdateableValues = getMandatoryASVValsList( liExistingAnsSetVals, mandatoryVals );//liExistingAnsSetVals.subList( asvFromIndex, asvToIndex );            
//    LOG.info("liAsvUpdateableValues is \n" + liAsvUpdateableValues );
    
            
            
//            final int ravFromIndex = pair_ravDonktKnowInfo.getX() - 1;
//            LOG.info("ravFromIndex is " + ravFromIndex);        
//            
//            final int ravDontKnowSeqNum = pair_ravDonktKnowInfo.getY();
//            LOG.info("ravDontKnowSeqNum is " + ravDontKnowSeqNum);
            
//            final int ravDontKnowSeqNum = getRAVDontKnowDisplaySequenceNum( liExistingReportAnsSetVals );            
//    
//            final int ravFromIndex = getRAVDontKnowDisplaySequenceIndex( liExistingReportAnsSetVals, ravDontKnowSeqNum ) - 1;//ravDontKnowSeqNum - 1;            
    
//            final int ravToIndex = ravFromIndex + 4;//liExistingReportAnsSetVals.size();            
//    LOG.info("ravToIndex is " + ravToIndex);
            final int ravFromDisplaySeq = getRAVDontKnowDisplaySequenceNum( liExistingReportAnsSetVals, rasId );// liExistingReportAnsSetVals.get( ravFromIndex ).getRav_display_seq();            
//    LOG.info("ravFromDisplaySeq is " + ravFromDisplaySeq);
            List<ReportAnswerSetValuesDataSetInfo> liRavUpdateableValues = getMandatoryRAVValsList(liExistingReportAnsSetVals, mandatoryVals);  //liExistingReportAnsSetVals.subList( ravFromIndex, ravToIndex );            
//    LOG.info("liRavUpdateableValues is \n" + liRavUpdateableValues );
    
            

//    LOG.info(" START UPDATING ASV -- IN MEMORY ");
            for ( AnswerSetValuesDataSetInfo asv : liAsvUpdateableValues ) {
                if ( asv.getAsv_ans_id() == ansId.intValue() ) {
                    OtlAnswerSetValuesVO asvVo = new OtlAnswerSetValuesVO();
                    Number asvId = new Number( asv.getAsv_id() );
                    asvVo.setAsvId( asvId );
                    asvVo.setAsvAnsId( ansId  );
                    asvVo.setAsvAnswer( asv.getAsv_answer().trim() );
                    asvVo.setAsvDeleteYN("N");
                    Number updAsvDisplaySeq = new Number( asv.getAsv_display_seq() + numExtraVals ) ;
//    LOG.info("updAsvDisplaySeq is " + updAsvDisplaySeq + " for answer " + asv.getAsv_answer());
                    asvVo.setAsvDisplaySeq( updAsvDisplaySeq );
                    
                    update( asvVo );
                }
                
            }
            
//LOG.info("ALL UPDATES ENDED -- in memory");
           
            
//LOG.info(" START UPDATING RASV -- in memory");
            for ( ReportAnswerSetValuesDataSetInfo rav : liRavUpdateableValues ) {
                
                if ( rav.getRav_ras_id() == rasId.intValue() ) {
                    OtlReportAnswerSetValuesVO ravVo = new OtlReportAnswerSetValuesVO();
                    ravVo.setRavId( new Number( rav.getRav_id() ) );
                    ravVo.setRavAsvId( new Number( rav.getRav_asv_id() ) );
                    ravVo.setAnsId( ansId );
                    ravVo.setRavAnswer( rav.getRav_answer().trim() );
                    ravVo.setRavRasId( rasId );
                    ravVo.setRavDeleteYN( "N" );
                    Number updRavDisplaySeq = new Number( rav.getRav_display_seq() + numExtraVals );
//        LOG.info("updRavDisplaySeq is " + updRavDisplaySeq + " for answer " + rav.getRav_answer() );            
                    ravVo.setRavDisplaySeq( updRavDisplaySeq );
                    
                    update( ravVo );
                    
                }
            }
            
//    LOG.info("START CREATING ");        
                           
            for ( int i = 0; i < numExtraVals; i++ ) {
                OtlAnswerSetValuesVO asvVo = new OtlAnswerSetValuesVO();
                asvVo.setAsvAnsId( ansId );
                asvVo.setAsvAnswer( extraAnsVals.get(i).trim() );
                asvVo.setAsvDeleteYN( "N" );
                Number crtAsvDisplaySeq = new Number( asvFromDisplaySeq + i  );
//    LOG.info("crtAsvDisplaySeq is " + crtAsvDisplaySeq + " for answer " + liAsvUpdateableValues.get(i).getAsv_answer() );            
                asvVo.setAsvDisplaySeq( crtAsvDisplaySeq );
                
                Number nxtAsvId = new Number( getMaxAsvId() + i + 1 );
                
                Number asvId = nxtAsvId;
//    LOG.info("CREATED ASVID is " + asvId );
                asvVo.setAsvId( asvId );
                
                
                asvVo = create( asvVo );
                
                OtlReportAnswerSetValuesVO ravVo = new OtlReportAnswerSetValuesVO();
                ravVo.setRavAsvId( asvVo.getAsvId() );
                ravVo.setRavAnswer( extraAnsVals.get(i).trim() );
                ravVo.setRavRasId( rasId );
                ravVo.setAnsId( ansId );
                ravVo.setRavDeleteYN( "N" );
                Number crtRavDisplaySeq = new Number( ravFromDisplaySeq + i  );
//    LOG.info("crtRavDisplaySeq is " + crtRavDisplaySeq + " for answer " + liRavUpdateableValues.get(i).getRav_answer());            
                ravVo.setRavDisplaySeq( crtRavDisplaySeq );
                
                Number nxtRavId = new Number( getMaxRavId() + i + 1 );
                Number ravId = nxtRavId;
//                LOG.info("CREATED RAVID is " + ravId );
    
                ravVo.setRavId( ravId );
                
                ravVo = create( ravVo );
            }
            
//            LOG.info("END CREATING "); 
        }   // ends if numExtraVals > 0
        
    }                                       
    
    
    


    
/***************** rem fn *************************
    public void addAnswerSetValues(int qstnId, 
                                   List<AnswerSetValuesDataSetInfo> liExistingAnsSetVals, 
                                   int dontKnowSeqNum, 
                                   List<ReportAnswerSetValuesDataSetInfo> liExistingReportAnsSetVals, 
                                   int repdontKnowSeqNum, 
                                   List<String> extraAnsVals) {
                                   
            Number ansId = new Number( liExistingReportAnsSetVals.get(0).getAns_id() );
            Number rasId = new Number( liExistingReportAnsSetVals.get(0).getRav_ras_id() );   
            
            int fromIndex = dontKnowSeqNum - 1;
            int toIndex = liExistingReportAnsSetVals.size();            
            int fromDisplaySeq = liExistingReportAnsSetVals.get( fromIndex ).getRav_display_seq();
        
LOG.info("from " + liExistingReportAnsSetVals.get( fromIndex ));
LOG.info("to " + liExistingReportAnsSetVals.get( toIndex ));
LOG.info("fromDisplaySeq " + fromDisplaySeq);
            
            List<ReportAnswerSetValuesDataSetInfo> liUpdateableValues = liExistingReportAnsSetVals.subList( fromIndex, toIndex );
            
    }
    
    
    public void addAnswerSetValues(int qstnId, 
                                   List<ReportAnswerSetValuesDataSetInfo> liExistingReportAnsSetVals,
                                   int dontKnowSeqNum,
                                   String ansVal) {
LOG.info("\n***in addAnswerSetValues - liExistingReportAnsSetVals is " + liExistingReportAnsSetVals + "\n***");
LOG.info("\n** in in addAnswerSetValues - ansVal to add is " + ansVal);
        
        Number ansId = new Number( liExistingReportAnsSetVals.get(0).getAns_id() );
        Number rasId = new Number( liExistingReportAnsSetVals.get(0).getRav_ras_id() );
        
LOG.info("ansId is " + ansId + " and rasId is " + rasId);
        
        
        
        int fromIndex = dontKnowSeqNum - 1;
        int toIndex = liExistingReportAnsSetVals.size() - 1;
        
        int fromDisplaySeq = liExistingReportAnsSetVals.get( fromIndex ).getRav_display_seq();
        
LOG.info("from " + liExistingReportAnsSetVals.get( fromIndex ));
LOG.info("to " + liExistingReportAnsSetVals.get( toIndex ));
LOG.info("fromDisplaySeq " + fromDisplaySeq);
        
        List<ReportAnswerSetValuesDataSetInfo> liUpdateableValues = liExistingReportAnsSetVals.subList( fromIndex, toIndex+1 );
LOG.info("\n*****liUpdateableValues is ***\n " + liUpdateableValues); 


LOG.info("UPDATING");

        for ( ReportAnswerSetValuesDataSetInfo rav : liUpdateableValues ) {
            
             OtlAnswerSetValuesVO asvVo = new OtlAnswerSetValuesVO();
             Number asvId = new Number(rav.getRav_asv_id() );
             asvVo.setAsvId( asvId );
             asvVo.setAsvAnsId( ansId  );
             asvVo.setAsvAnswer( rav.getRav_answer() );
             asvVo.setAsvDeleteYN("N");
             asvVo.setAsvDisplaySeq(new Number( rav.getRav_display_seq() + 1 ) );
             
             
            
            OtlReportAnswerSetValuesVO ravVo = new OtlReportAnswerSetValuesVO();
            ravVo.setRavId( new Number( rav.getRav_id() ) );
            ravVo.setRavAsvId( asvId );
            ravVo.setRavAsvId( ansId );
            ravVo.setRavAnswer( rav.getRav_answer() );
            ravVo.setRavRasId( rasId );
            ravVo.setRavDeleteYN( "N" );
            ravVo.setRavDisplaySeq(new Number( rav.getRav_display_seq() + 1 ) );
            
            
            
            update( asvVo );
            update( ravVo );
            
        }
LOG.info("CREATING");        
        OtlAnswerSetValuesVO asvVo = new OtlAnswerSetValuesVO();
        asvVo.setAsvAnsId( ansId );
        asvVo.setAsvAnswer( ansVal );
        asvVo.setAsvDeleteYN( "N" );
        asvVo.setAsvDisplaySeq( new Number( fromDisplaySeq ) );
        
        asvVo = create( asvVo );
        
        OtlReportAnswerSetValuesVO ravVo = new OtlReportAnswerSetValuesVO();
        ravVo.setRavAsvId( asvVo.getAsvId() );
        ravVo.setRavAnswer( ansVal );
        ravVo.setRavRasId( rasId );
        ravVo.setRavDeleteYN( "N" );
        ravVo.setRavDisplaySeq( new Number( fromDisplaySeq ) );
        
        ravVo = create( ravVo );
        
        
                                           
    }
***************** rem fn *************************/
/**
//    public void addAnswerSetValues(int qstnId, 
//                                   List<ReportAnswerSetValuesDataSetInfo> liExistingReportAnsSetVals,
//                                   int dontKnowSeqNum,
//                                   String ansVal) {
//LOG.info("\n***in addAnswerSetValues - liExistingReportAnsSetVals is " + liExistingReportAnsSetVals + "\n***");
//LOG.info("\n** in in addAnswerSetValues - ansVal to add is " + ansVal);
//        
//        int ansId = liExistingReportAnsSetVals.get(0).getAns_id();
//        int rasId = liExistingReportAnsSetVals.get(0).getRav_ras_id();
//        
//LOG.info("ansId is " + ansId + " and rasId is " + rasId);
//        int dontKnowSequence = getDontKnowDisplaySeq( liExistingReportAnsSetVals );
//        
//        
//        if ( dontKnowSequence != 0 ) {
//            OtlAnswerSetValuesVO asvVo = new OtlAnswerSetValuesVO();
//            OtlReportAnswerSetValuesVO ravVo = new OtlReportAnswerSetValuesVO();
//            
//            for ( ReportAnswerSetValuesDataSetInfo rav : liExistingReportAnsSetVals ) {
//                int displaySeqId = rav.getRav_display_seq();
//                
//                
//            }
//            
//            
//            
//            
//            
//            
////            asvVo.setAsvAnswer( ansVal );
////            asvVo.setAsv
////            ravVo.setRavAnswer( ansVal );
//        }
//                                           
//    }
**/

    private int getDontKnowDisplaySeq(List<ReportAnswerSetValuesDataSetInfo> liExistingReportAnsSetVals) {
        for ( ReportAnswerSetValuesDataSetInfo rav : liExistingReportAnsSetVals ) {
            String ansVal = rav.getRav_answer();
            if ( ansVal.equalsIgnoreCase("Don't know") ) {
                return rav.getRav_display_seq();
            }
        }
        return 0;
    }
    
    private int getMaxAsvId() {
        MaxAsvId maxAsvIdVw = platform.getMaxAsvId();
        maxAsvIdVw.executeQuery();
        if ( maxAsvIdVw.hasNext() ) {
            MaxAsvIdRow row = (MaxAsvIdRow) maxAsvIdVw.next();
            Number id = row.getMaxAsvId();
            return id.intValue();
        }
        return 0;
    }
    
    
    private int getMaxRavId() {
        MaxRavId maxRavIdVw = platform.getMaxRavId();
        maxRavIdVw.executeQuery();
        if ( maxRavIdVw.hasNext() ) {
            MaxRavIdRow row = (MaxRavIdRow) maxRavIdVw.next();
            Number id = row.getMaxRavId();
            return id.intValue();
        }
        return 0;
    }
    

    private ReportSourcesVO createADF(ReportSourcesVO rps) {
        if ( rps == null ) throw new IllegalArgumentException("error asvVo is null");
        boolean created = false;
        ReportSources rpsView = platform.getReportSources();
        ReportSourcesVO rpsVo = new ReportSourcesVO();
        
        rps.setRpsRepeatSourceYn( rps.getRpsRepeatSourceYn().toUpperCase() );
        rps.setRpsCompedYn( rps.getRpsCompedYn().toUpperCase() );
        rps.setRpsDeleteYn( rps.getRpsDeleteYn().toUpperCase() );
        
        rpsView.insertRow( rpsVo.transform( rpsView, rps ) );
        commitAll();
        return rps;//Vo;
        
    }
    
    /**
     * -- Change 8/30/2005, IJP
            -- Made to replicate Rob's emergency change to avoid ORA-0001 error caused by using BAwaWEb_RPS_SEQ here
            -- but MAX+1 method in bawaweb_reports_screens.prc_copy_report_data.
            -- NOTE: It would be preferable to change both to use the sequence when time permits.
            SELECT NVL(MAX(rps_id), 0) + 1
            INTO   lt_rps_id
            FROM   bawaweb_report_sources;

            INSERT INTO bawaweb_report_sources
             (rps_id, rps_src_id, rps_rprt_id, rps_rptr_id,
              rps_repeat_source_yn, rps_comped_yn, rps_delete_yn)
            VALUES
             (lt_rps_id, parameters.src_id, parameters.rprt_id, bawaweb_utils.gr_user_info.empl_id,
              NVL(parameters.p_repeat, 'N'), NVL(parameters.p_comped, 'N'), 'N');
     */

     private ReportSourcesVO create(ReportSourcesVO rps) {
         if ( rps == null ) throw new IllegalArgumentException("error asvVo is null");
         boolean created = false;
         PreparedStatement pst = null;
         ResultSet rs = null;
         String sql = "INSERT INTO bawaweb_report_sources (rps_id, rps_src_id, rps_rprt_id, rps_rptr_id, rps_repeat_source_yn, rps_comped_yn, rps_delete_yn) " + 
                         "  VALUES (?, ?, ?, ?, ?, ?, ?)";
         
         pst = platform.getDBTransaction().createPreparedStatement( sql, 0 );
         
         try {
            pst.setInt( 1, rps.getRpsId().intValue() );
            pst.setInt( 2, rps.getRpsSrcId().intValue() );
            pst.setInt( 3, rps.getRpsRprtId().intValue() );
            pst.setInt( 4, rps.getRpsRprtrId().intValue() );
            pst.setString( 5, rps.getRpsRepeatSourceYn().toUpperCase() );
            pst.setString( 6, rps.getRpsCompedYn().toUpperCase() );
            pst.setString( 7, rps.getRpsDeleteYn().toUpperCase() );
            
            int rowCount = pst.executeUpdate();
             
            if ( rowCount != 1 ) 
                rps = null;
                 
         } catch ( SQLException e ) {
            LOG.error("Error", e);  //e.printStackTrace();;
         }
         finally {
             try {
                 if ( rs != null ) rs.close();
                if ( pst != null ) pst.close();
            }
            catch (SQLException e) {
                LOG.error("Error", e);  //e.printStackTrace();
            }
        }
        
        return rps;
     }
    
    private ReporterSourcesVO create(ReporterSourcesVO rps) {
        if ( rps == null ) throw new IllegalArgumentException("error asvVo is null");
        boolean created = false;
        ReporterSources rpsView = platform.getReporterSources();
        ReporterSourcesVO rpsVo = new ReporterSourcesVO();
        rpsView.insertRow( rpsVo.transform( rpsView, rps ) );
        commitAll();
        return rps;//Vo;
        
    }

     public OtlAnswerSetValuesVO create(OtlAnswerSetValuesVO asvVo) {
        LOG.info("\n_______CREATE ASVO STARTED_____________");    
        if ( asvVo ==  null ) throw new IllegalArgumentException("error asvVo is null");
        boolean created = false;
        PreparedStatement pstmtBlock = null;
         
        String sql = "INSERT INTO BAwaWEb_ANSWER_SET_VALUES (ASV_ID, ASV_ANS_ID, ASV_ANSWER, ASV_DISPLAY_SEQ, ASV_DELETE_YN)  " + 
                         " VALUES (?, ?, ?, ?, ?)";    // 5 ?'s
                         
        pstmtBlock = platform.getDBTransaction().createPreparedStatement( sql, 0 );
        
        try {
            String answer = asvVo.getAsvAnswer();                       LOG.info(" in createASV ans is " + asvVo.getAsvAnswer() );
            
            if ( answer != null && !answer.equals("0") && !answer.equals("") ) {
                pstmtBlock.setString( 3, answer ); 
                
                pstmtBlock.setInt( 1, asvVo.getAsvId().intValue() );        LOG.info(" in createASV asvid " + asvVo.getAsvId() );
                pstmtBlock.setInt( 2, asvVo.getAsvAnsId().intValue() );     LOG.info(" in createASV asv_ans_id " + asvVo.getAsvAnsId() );
                pstmtBlock.setInt( 4, asvVo.getAsvDisplaySeq().intValue() );
                pstmtBlock.setString( 5, asvVo.getAsvDeleteYN() );
                
                pstmtBlock.executeUpdate();
                pstmtBlock.close();
                
                
            }
            
        } catch (SQLException se) {
            LOG.error( "Could not create ASVVO " + asvVo, se);
            throw new SQLStmtException ( CSMessageBundle.class, CSMessageBundle.EXC_SQL_EXECUTE_COMMAND, sql, se);
        } finally {
            try {
                pstmtBlock.close();
            } catch ( SQLException sqe) {
                LOG.error("Couldn close pstmnt block");
                LOG.info("Couldn close pstmnt block");
                LOG.error("Error", sqe);  //e.printStackTrace();
            }
        }
        
        LOG.info("***RETURNING create asvVo ****\n" + asvVo + "\n****************\n");
        
        commitAll();
        
        LOG.info("\n___________________CREATE ASVO ENDED___________________");
        
        return asvVo;
                  
     }

    public OtlAnswerSetValuesVO createADF(OtlAnswerSetValuesVO asvVo) {
LOG.info("\n_______CREATE ASVO STARTED_____________");    
        if ( asvVo ==  null ) throw new IllegalArgumentException("error asvVo is null");
        boolean created = false;
        
        OtlAnswerSetValues asvView = platform.getOtlAnswerSetValues();
        OtlAnswerSetValuesVO asv = new OtlAnswerSetValuesVO();
//        Number nxtAsvId = new Number( getMaxAsvId() + 1 );
//        
//        Number asvId = nxtAsvId;
//        LOG.info("in create ASVID is " + asvId );
//        asvVo.setAsvId( asvId );
        
        asvView.insertRow( asv.transform( asvView, asvVo ));
        
/**********************************************************        
//        Sequence asvSeq = new Sequence("BAwaWEb_ASV_SEQ", platform);
//        String nxtAsvSeqVal = asvSeq.getData().toString();
//        Number nxtAsvId = null;
//        try {
//            nxtAsvId = new Number( nxtAsvSeqVal ); 
//        } catch (SQLException e) { 
//            created = false;
//            LOG.error("Error", e);  //e.printStackTrace();
//        }

        Number nxtAsvId = new Number( getMaxAsvId() + 1 );
        
        Number asvId = nxtAsvId;
LOG.info("in create ASVID is " + asvId );        
        Number ansId = asvVo.getAsvAnsId();
        String answer = asvVo.getAsvAnswer();
        Number asvDispSeq = asvVo.getAsvDisplaySeq();
        String asvDeleteYn = asvVo.getAsvDeleteYN();
        
        OtlAnswerSetValues asvView = platform.getOtlAnswerSetValues();
        OtlAnswerSetValuesRow asvRow = (OtlAnswerSetValuesRow) asvView.createRow();
        asvRow.setAsvId( asvId );
        asvRow.setAsvAnsId( ansId );
        asvRow.setAsvAnswer( answer );
        asvRow.setAsvDisplaySeq( asvDispSeq );
        asvRow.setAsvDeleteYn( asvDeleteYn );
        
    //        ansRow.setAttribute( "AsvId", asvId );
    //        ansRow.setAttribute( "AsvAnsId", ansId );
    //        ansRow.setAttribute( "AsvAnswer", answer );
    //        ansRow.setAttribute( "AsvDisplaySeq", asvDispSeq );
    //        ansRow.setAttribute( "AsvDeleteYn", asvDeleteYn );
        
        asvView.insertRow( asvRow );
        
        created = true;
        
        asvVo.setAsvId( asvId );
  *********************************************/
  
//LOG.info("***RETURNING create asvRow ****\n" + asvRow + " with asvid " + asvRow.getAsvId() + "\n****************\n");
LOG.info("***RETURNING create asvVo ****\n" + asvVo + "\n****************\n");

        commitAll();
LOG.info("\n___________________CREATE ASVO ENDED___________________");        
        return asvVo;
        
    }
/****************************************        
    public OtlAnswerSetValuesVO create(OtlAnswerSetValuesVO asvVo) {
        if ( asvVo ==  null ) throw new IllegalArgumentException("error asvVo is null");
        boolean created = false;
        Sequence asvSeq = new Sequence("BAwaWEb_ASV_SEQ", platform);
        String nxtAsvSeqVal = asvSeq.getData().toString();
        Number nxtAsvId = null;
        try {
            nxtAsvId = new Number( nxtAsvSeqVal ); 
        } catch (SQLException e) { 
            created = false;
            LOG.error("Error", e);  //e.printStackTrace();
        }
        
        Number asvId = nxtAsvId;
        Number ansId = asvVo.getAsvAnsId();
        String answer = asvVo.getAsvAnswer();
        Number asvDispSeq = asvVo.getAsvDisplaySeq();
        String asvDeleteYn = asvVo.getAsvDeleteYN();
        
        AnswerSetValues asvView = platform.getAnswerSetValues();
        AnswerSetValuesRow asvRow = (AnswerSetValuesRow) asvView.createRow();
        asvRow.setAsvId( asvId );
        asvRow.setAsvAnsId( ansId );
        asvRow.setAsvAnswer( answer );
        asvRow.setAsvDisplaySeq( asvDispSeq );
        asvRow.setAsvDeleteYn( asvDeleteYn );
        
//        ansRow.setAttribute( "AsvId", asvId );
//        ansRow.setAttribute( "AsvAnsId", ansId );
//        ansRow.setAttribute( "AsvAnswer", answer );
//        ansRow.setAttribute( "AsvDisplaySeq", asvDispSeq );
//        ansRow.setAttribute( "AsvDeleteYn", asvDeleteYn );
        
        asvView.insertRow( asvRow );
        
        created = true;
        
        asvVo.setAsvId( asvId );
        
LOG.info("***RETURNING create asvRow ****\n" + asvRow + " with asvid " + asvRow.getAsvId() + "\n****************\n");
LOG.info("***RETURNING create asvVo ****\n" + asvVo + "\n****************\n");    
        return asvVo;
        
    }
************************************/
    
     public OtlReportAnswerSetValuesVO create(OtlReportAnswerSetValuesVO ravVo) {
LOG.info("\n****************CREATE RASVO STARTED******************");     
         if ( ravVo ==  null ) throw new IllegalArgumentException("error ravVo is null");
         boolean created = false;
         
         OtlReportAnswerSetValues ravView = platform.getOtlReportAnswerSetValues();
         OtlReportAnswerSetValuesVO rav = new OtlReportAnswerSetValuesVO();
         
//         Number nxtRavId = new Number( getMaxRavId() + 1 );
//         Number ravId = nxtRavId;
//LOG.info("in create RAVID is " + ravId );
//
//        ravVo.setRavId( ravId );
        
        ravView.insertRow( rav.transform( ravView, ravVo));
  /**       
         
         
         
//         Sequence ravSeq = new Sequence("BAwaWEb_RAV_SEQ", platform);
//         String nxtRavSeqVal = ravSeq.getData().toString();
//         Number nxtRavId = null;
//         try {
//             nxtRavId = new Number( nxtRavSeqVal ); 
//         } catch (SQLException e) { 
//             created = false;
//             LOG.error("Error", e);  //e.printStackTrace();
//         }
//         
         Number nxtRavId = new Number( getMaxRavId() + 1 );
         Number ravId = nxtRavId;

LOG.info("in create RAVID is " + ravId );
         Number rasId = ravVo.getRavRasId();
         String answer = ravVo.getRavAnswer();
         Number ravDispSeq = ravVo.getRavDisplaySeq();
         String ravDeleteYn = ravVo.getRavDeleteYN();
         Number ravAsvId = ravVo.getRavAsvId();
         
         OtlReportAnswerSetValues ravView = platform.getOtlReportAnswerSetValues();
         
         OtlReportAnswerSetValuesRow ravRow = (OtlReportAnswerSetValuesRow) ravView.createRow();
         ravRow.setRavId( ravId );
         ravRow.setRavRasId( rasId );
         ravRow.setRavAnswer( answer );
         ravRow.setRavDisplaySeq( ravDispSeq );
         ravRow.setRavDeleteYn( ravDeleteYn );
         ravRow.setRavAsvId( ravAsvId );
         
     //        ansRow.setAttribute( "RavId", ravId );
     //        ansRow.setAttribute( "RavRasId", rasId );
     //        ansRow.setAttribute( "RavAnswer", answer );
     //        ansRow.setAttribute( "RavDisplaySeq", ravDispSeq );
     //        ansRow.setAttribute( "RavDeleteYn", ravDeleteYn );
         
         ravView.insertRow( ravRow );
         
         created = true;
         
         ravVo.setRavId( ravId );
         
****/         
//     LOG.info("***RETURNING create ravRow ****\n" + ravRow + " with ravid " + ravRow.getRavId() + "\n****************\n");
     LOG.info("***RETURNING create ravVo ****\n" + ravVo + "\n****************\n");
     
         commitAll();
LOG.info("\n**********CREATE RASVO ENDED**********************");         
         return ravVo;
     }
 
 
 /********************************
    public OtlReportAnswerSetValuesVO create(OtlReportAnswerSetValuesVO ravVo) {
        if ( ravVo ==  null ) throw new IllegalArgumentException("error ravVo is null");
        boolean created = false;
        Sequence ravSeq = new Sequence("BAwaWEb_RAV_SEQ", platform);
        String nxtRavSeqVal = ravSeq.getData().toString();
        Number nxtRavId = null;
        try {
            nxtRavId = new Number( nxtRavSeqVal ); 
        } catch (SQLException e) { 
            created = false;
            LOG.error("Error", e);  //e.printStackTrace();
        }
        
        Number ravId = nxtRavId;
        Number rasId = ravVo.getRavRasId();
        String answer = ravVo.getRavAnswer();
        Number ravDispSeq = ravVo.getRavDisplaySeq();
        String ravDeleteYn = ravVo.getRavDeleteYN();
        Number ravAsvId = ravVo.getRavAsvId();
        
        ReportAnswerSetValues ravView = platform.getReportAnswerSetValues();
        
        ReportAnswerSetValuesRow ravRow = (ReportAnswerSetValuesRow) ravView.createRow();
        ravRow.setRavId( ravId );
        ravRow.setRavRasId( rasId );
        ravRow.setRavAnswer( answer );
        ravRow.setRavDisplaySeq( ravDispSeq );
        ravRow.setRavDeleteYn( ravDeleteYn );
        ravRow.setRavAsvId( ravAsvId );
        
//        ansRow.setAttribute( "RavId", ravId );
//        ansRow.setAttribute( "RavRasId", rasId );
//        ansRow.setAttribute( "RavAnswer", answer );
//        ansRow.setAttribute( "RavDisplaySeq", ravDispSeq );
//        ansRow.setAttribute( "RavDeleteYn", ravDeleteYn );
        
        ravView.insertRow( ravRow );
        
        created = true;
        
        ravVo.setRavId( ravId );
        
        
LOG.info("***RETURNING create ravRow ****\n" + ravRow + " with ravid " + ravRow.getRavId() + "\n****************\n");
LOG.info("***RETURNING create ravVo ****\n" + ravVo + "\n****************\n");        
        return ravVo;
    }
    
    *********************************/
    
  private boolean doesSourceMultiAnswerExist(Number sraId, Number qmqId) {
      LOG.info("in doesSourceMultiAnswerExist for qmqid " + qmqId + " and sraid " + sraId );
      
      boolean doesSrcMultiAnswerExist = false;
      PreparedStatement pst = null;
      ResultSet rs = null;
      String sql = "SELECT OtlSourceMultiAnswers.SMA_SRA_ID,   " + 
                  "       OtlSourceMultiAnswers.SMA_ANSWER,  " + 
                  "       OtlSourceMultiAnswers.SMA_ASV_ID,  " + 
                  "       OtlSourceMultiAnswers.SMA_QMQ_ID,  " + 
                  "       OtlSourceMultiAnswers.SMA_EXCLUDE_YN,  " + 
                  "       OtlSourceMultiAnswers.SMA_WEIGHT_MULTIPLIER,  " + 
                  "       OtlSourceMultiAnswers.SMA_RAV_ID  " + 
                  "FROM BAwaWEb_SOURCE_MULTI_ANSWERS OtlSourceMultiAnswers  " + 
                  "WHERE OtlSourceMultiAnswers.SMA_SRA_ID = ?  " + 
                  "AND  OtlSourceMultiAnswers.SMA_QMQ_ID = ?  " + 
                  "AND OtlSourceMultiAnswers.SMA_EXCLUDE_YN = 'N' ";
                        
      
      pst = platform.getDBTransaction().createPreparedStatement( sql, 0 );
      
      try {
          pst.setInt( 1, sraId.intValue() );
          pst.setInt( 2, qmqId.intValue() );
          
          rs = pst.executeQuery();
          
          if ( rs.next() ) {
              doesSrcMultiAnswerExist = true;
              LOG.info("SMASRAID found is " + rs.getInt( "SMA_SRA_ID" ) );
          }
      } catch ( SQLException e ) {
                  LOG.error("Error", e);  //e.printStackTrace();;
      }
      finally {
          try {
              if ( rs != null ) rs.close();
              if ( pst != null ) pst.close();
          }
          catch (SQLException e) {
              LOG.error("Error", e);  //e.printStackTrace();
          }
      }
      return doesSrcMultiAnswerExist;
  }
  
  
  
  public boolean doesSourceAnswerExist(int qstId, int repSrcId) {
      LOG.info("in doesSourceAnswerExist for qstid " + qstId + " and rpsid " + repSrcId );
      
      boolean doesSrcAnswerExist = false;
      PreparedStatement pst = null;
      ResultSet rs = null;
      String sql = "SELECT OtlSourceAnswers.SRA_ID, " + 
                          " OtlSourceAnswers.SRA_QST_ID, " + 
                          " OtlSourceAnswers.SRA_RPS_ID, " + 
                          " OtlSourceAnswers.SRA_ANSWER, " + 
                          " OtlSourceAnswers.SRA_ANSWER_TEXT, " + 
                          " OtlSourceAnswers.SRA_ASV_ID, " + 
                          " OtlSourceAnswers.SRA_RAV_ID, " + 
                          " OtlSourceAnswers.SRA_COLOR, " + 
                          " OtlSourceAnswers.SRA_COMMENT, " + 
                          " OtlSourceAnswers.SRA_EXCLUDE_YN, " + 
                          " OtlSourceAnswers.SRA_WEIGHT_MULTIPLIER " + 
                  " FROM BAwaWEb_SOURCE_ANSWERS OtlSourceAnswers " + 
                  " WHERE OtlSourceAnswers.SRA_QST_ID = ?  " + 
                  " AND OtlSourceAnswers.SRA_RPS_ID = ? " + 
                  " AND OtlSourceAnswers.SRA_EXCLUDE_YN = 'N' ";
                        
      
      pst = platform.getDBTransaction().createPreparedStatement( sql, 0 );
      
      try {
          pst.setInt( 1, qstId );
          pst.setInt( 2, repSrcId );
          
          rs = pst.executeQuery();
          
          if ( rs.next() ) {
              doesSrcAnswerExist = true;
              LOG.info("SRAID found is " + rs.getInt( "SRA_ID" ) );
          }
      } catch ( SQLException e ) {
                  LOG.error("Error", e);  //e.printStackTrace();;
      }
      finally {
          try {
              if ( rs != null ) rs.close();
              if ( pst != null ) pst.close();
          }
          catch (SQLException e) {
              LOG.error("Error", e);  //e.printStackTrace();
          }
      }
      return doesSrcAnswerExist;
  }
    
    public boolean doesSourceAnswerExistADF(int qstId, int repSrcId) {
    LOG.info("in doesSourceAnswerExist for qstid " + qstId + " and rpsid " + repSrcId );
    
        DoesSourceAnswerExist doesSrcAnsExistView = platform.getDoesSourceAnswerExist();
        
        doesSrcAnsExistView.setqst_id( new Number( qstId ) );
        doesSrcAnsExistView.setrps_id( new Number( repSrcId ) );
        
        doesSrcAnsExistView.executeQuery();
LOG.info("query is |" + doesSrcAnsExistView.getQuery() + "|" );
LOG.info("count is " + doesSrcAnsExistView.getEstimatedRowCount() );

        if ( doesSrcAnsExistView.hasNext() ) {
            DoesSourceAnswerExistRow row = (DoesSourceAnswerExistRow) doesSrcAnsExistView.next();
            String answer = row.getSraAnswer();
LOG.info("1 answer is |" + answer + "|");

            String ansText = row.getSraAnswerText();
LOG.info("2 answertext is |" + ansText + "|"); 

            Number asvId = row.getSraAsvId();
LOG.info("3 asvid is |" + asvId + "|" );     

            String color = row.getSraColor();
LOG.info("4 color is |" + color + "|");     

            String comment = row.getSraComment();
LOG.info("5 comment is |" + comment + "|");   
            
            Number ravId = row.getSraRavId();
LOG.info("6 ravId is |" + ravId + "|");  
            
            if (    ( answer != null || !answer.equals("") ) && 
                    ( ansText != null || !ansText.equals("") ) && 
                    ( asvId != null || !asvId.equals( new Number( 0 ) ) ) &&
                    ( color != null || !color.equals("") ) &&
                    ( comment != null || !comment.equals("") ) &&
                    ( ravId != null || !ravId.equals( new Number( 0 ) ) )
            ) {
LOG.info("doesSourceAnswerExist returns true  for rpsid " + repSrcId + " and qstid " + qstId );
LOG.info("answer is |" + answer + "|");
LOG.info("answerText is |" + ansText + "|");
LOG.info("asvid is |" + asvId + "|");
LOG.info("ravid is |" + ravId + "|");

                return true;
            }
            
        }
        
LOG.info("doesSourceAnswerExist returns false  for rpsid " + repSrcId + " and qstid " + qstId );
        return false;
    }
    
    
//    private int getRAVDontKnowDisplaySequenceIndex(List<ReportAnswerSetValuesDataSetInfo> listRavs, int dontKnowIndex) {
//        for ( ReportAnswerSetValuesDataSetInfo rav : listRavs ) {
//            String ansVal = rav.getRav_answer();
//            if ( ansVal.equalsIgnoreCase("Don't know") ) { // && rav.getRav_display_seq() == dontKnowIndex ) {
//LOG.info("RAV returning dont-know index at " + listRavs.indexOf( rav ) );            
//                return listRavs.indexOf( rav ); //return rav.getRav_display_seq();
//            }
//        }
//        return 0;
//    }
    
    
    // Pair -- index with the list and the sequence number
    private Pair getRAVDontKnowDisplaySequenceInfo(List<ReportAnswerSetValuesDataSetInfo> listRavs) {
        Pair p;
        for ( ReportAnswerSetValuesDataSetInfo rav : listRavs ) {
            String ansVal = rav.getRav_answer();
            if ( ansVal.equalsIgnoreCase("Don't know") ) {
LOG.info("RAV found dont know seqNum is " + rav.getRav_display_seq() + " and its elementindex is " + listRavs.indexOf( rav ) );            
                int displaySeqNum = rav.getRav_display_seq();
                int index = listRavs.indexOf( rav );
                p =  new Pair<Integer, Integer>( index, displaySeqNum );
                
                return p;
            }
        }
        return null;
    }
    
//    private int getASVDontKnowDisplaySequenceIndex(List<AnswerSetValuesDataSetInfo> liAsvs, int dontKnowIndex) {
//        for ( AnswerSetValuesDataSetInfo asv : liAsvs ) {
//            String ansVal = asv.getAsv_answer();
//            if ( ansVal.equalsIgnoreCase("Don't know") ) { // && asv.getAsv_display_seq() == dontKnowIndex ) {
//LOG.info("ASV returning dont-know index at " + liAsvs.indexOf( ansVal ) );       
//                return liAsvs.indexOf( ansVal );              //asv.getAsv_display_seq();
//            }
//        }
//        return 0;
//    }
//    


    private Pair getASVDontKnowDisplaySequenceInfo(List<AnswerSetValuesDataSetInfo> liAsvs) {
        Pair p;
        for ( AnswerSetValuesDataSetInfo asv : liAsvs ) {
            String ansVal = asv.getAsv_answer();
            if ( ansVal.equalsIgnoreCase("Don't know") ) {
LOG.info("ASV found dont know seqNum is " + asv.getAsv_display_seq() + " and its elemetindex is " + liAsvs.indexOf( asv ) );
                int displaySeqNum = asv.getAsv_display_seq();
                int index = liAsvs.indexOf( asv );
                p = new Pair<Integer, Integer>( index, displaySeqNum );
                
                return p;
            }
        }
        return null;
    }
//    public ReportSourcesDataSetInfo create(ReportSourcesDataSetInfo rps) {
//        if ( rps == null ) return null;
//        
//    }
    public SourceDataSetInfo createADF(SourceDataSetInfo s) {
        if ( s == null ) return null;
        
        int rprtId = s.getSrc_rprt_id();
        
        SourcesInfoVO src = new SourcesInfoVO();
        
        Number nxtSrcId = getNextSequence("BAwaWEb_SRC_SEQ");
        if ( s.getSrc_id() <= 0 ) {
            s.setSrc_id( nxtSrcId.intValue() );
        } else {
        LOG.info("error cannot CREATE a src with a src id already existing");
            return null;
        }
        
        src = src.transform( s );
LOG.info("SVO transformed is " + src);        
        SourcesInfoVO aSrc = new SourcesInfoVO();
        
        Sources srcsView = platform.getSources();
        SourcesRow row = aSrc.transform( srcsView, src );
        srcsView.insertRow( row );
LOG.info("srcid " + s.getSrc_id() + " cREATED for src " + s.getSrc_first_name() + " " + s.getSrc_last_name());
LOG.info("ROW INFO " + row.getSrcId() + " | " + row.getSrcFirstName() + " " + row.getSrcLastName() );

        commitAll();
        
        return s;
    }
    
    
    
    public SourceDataSetInfo create(SourceDataSetInfo s) {
        if ( s == null ) return null;
        Number nxtSrcId = getNextSequence("BAwaWEb_SRC_SEQ");
        if ( s.getSrc_id() <= 0 ) {
            s.setSrc_id( nxtSrcId.intValue() );
        }
        /* else {
        LOG.info("error cannot CREATE a src with a src id already existing");
            return null;
        }*/
        
        PreparedStatement pst = null;
        ResultSet rs = null;
        /*
         * INSERT INTO bawaweb_sources
           (src_id, src_last_name, src_first_name, src_courtesy_title,src_suffix_title,
            src_job_title, src_job_description, src_company,
            src_address1, src_address2, src_address3,
            src_city, src_state, src_zip, src_ctry_id, src_tmz_id,
            src_email, src_phone, src_phone_ext, src_cell_phone, src_fax,
            src_status, src_exclusive_source_yn, src_dont_contact_yn,
            src_company_type, src_area_of_expertise, src_industry_sector,
            src_industry_view, src_vendors, src_company_size,
            src_distribution_preference, src_distribution_notes,
            src_informed_of_website, src_offered_report,
            src_special_requests, src_reporters_notes, src_quality_rating,
            src_modified_date, src_modified_by)
          VALUES
           (parameters.src_id, parameters.p_lname, parameters.p_fname, parameters.p_courtesy_list,parameters.p_suffix_list,
            parameters.p_jobtitle, parameters.p_jobdesc, parameters.p_co_name,
            parameters.p_address1, parameters.p_address2, parameters.p_address3,
--            parameters.p_city, parameters.p_state, 
-- removed nm see above 1/20
            lc_city, lc_state,
            parameters.p_zip, parameters.p_ctry_id, parameters.p_tmz_id,
            parameters.p_email, parameters.p_phone, parameters.p_phone_ext, parameters.p_cell, parameters.p_fax,
            parameters.p_status, NVL(parameters.p_excl_src, 'N'), NVL(parameters.p_contact, 'N'),
            parameters.p_co_type, parameters.p_expertise, parameters.p_indsector,
            parameters.p_indview, parameters.p_vendors, parameters.p_co_size,
            parameters.p_distpref, parameters.p_distnotes,
            parameters.p_informed, NVL(parameters.p_offered_rpt, 'N'),
            parameters.p_special, parameters.p_notes, parameters.p_quality,
            SYSDATE, bawaweb_utils.gr_user_info.userid)
            39 ?s
         */
         
        String sql = "INSERT INTO bawaweb_sources " + 
                    "           (src_id, src_last_name, src_first_name, src_courtesy_title,src_suffix_title, " + 
                    "            src_job_title, src_job_description, src_company, " + 
                    "            src_address1, src_address2, src_address3, " + 
                    "            src_city, src_state, src_zip, src_ctry_id, src_tmz_id, " + 
                    "            src_email, src_phone, src_phone_ext, src_cell_phone, src_fax, " + 
                    "            src_status, src_exclusive_source_yn, src_dont_contact_yn, " + 
                    "            src_company_type, src_area_of_expertise, src_industry_sector, " + 
                    "            src_industry_view, src_vendors, src_company_size, " + 
                    "            src_distribution_preference, src_distribution_notes, " + 
                    "            src_informed_of_website, src_offered_report, " + 
                    "            src_special_requests, src_reporters_notes, src_quality_rating, " + 
                    "            src_modified_date, src_modified_by) " + 
                    "          VALUES " + 
                    "           (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        pst = platform.getDBTransaction().createPreparedStatement( sql, 0 );
        
        try {
        
                pst.setInt( 1, s.getSrc_id() );
                pst.setString( 2, s.getSrc_last_name() );
                pst.setString( 3, s.getSrc_first_name() );
                
                if ( s.getSrc_courtesy_title() != null ) {
                    pst.setString( 4, s.getSrc_courtesy_title() );
                }
                else {
                    pst.setNull( 4, Types.VARCHAR );
                }
                
                if ( s.getSrc_suffix_title() != null ) {
                    pst.setString( 5, s.getSrc_suffix_title() );
                }
                else {
                    pst.setNull( 5, Types.VARCHAR );
                }
                
                if ( s.getSrc_job_title() != null ) {
                    pst.setString( 6, s.getSrc_job_title() );
                }
                else {
                    pst.setNull( 6, Types.VARCHAR );
                }
                
                if ( s.getSrc_job_description() != null ) {
                    pst.setString( 7, s.getSrc_job_description() );
                }
                else {
                    pst.setNull( 7, Types.VARCHAR );
                }
                
                if ( s.getSrc_company() != null ) {
                    pst.setString( 8, s.getSrc_company() );
                }
                else {
                    pst.setNull( 8, Types.VARCHAR );
                }
                
                if ( s.getSrc_address1() != null ) {
                    pst.setString( 9, s.getSrc_address1() );
                }
                else {
                    pst.setNull( 9, Types.VARCHAR );
                }
                    
                if ( s.getSrc_address2() != null ) {
                    pst.setString( 10, s.getSrc_address2() );
                }
                else {
                    pst.setNull( 10, Types.VARCHAR );
                }
                
                if ( s.getSrc_address3() != null ) {
                    pst.setString( 11, s.getSrc_address3() );
                }
                else {
                    pst.setNull( 11, Types.VARCHAR );
                }
                
                pst.setString( 12, s.getSrc_city() );
                
                if ( s.getSrc_state() != null ) {
                    pst.setString( 13, s.getSrc_state() );
                }
                else {
                    pst.setNull( 13, Types.VARCHAR );
                }
                
                if ( s.getSrc_zip() != null ) {
                    pst.setString( 14, s.getSrc_zip() );
                }
                else {
                    pst.setNull( 14, Types.VARCHAR );
                }
                
                pst.setInt( 15, s.getSrc_ctry_id() );
                
                if ( s.getSrc_tmz_id() > 0 ) {
                    pst.setInt( 16, s.getSrc_tmz_id() );
                } else {
                    pst.setNull(16, Types.INTEGER);
                }
                
                if ( s.getSrc_email() != null ) {
                    pst.setString( 17, s.getSrc_email() );
                }
                else {
                    pst.setNull( 17, Types.VARCHAR );
                }
                
                pst.setString( 18, s.getSrc_phone() );
                
                if ( s.getSrc_phone_ext() != null ) {
                    pst.setString( 19, s.getSrc_phone_ext() );
                }
                else {
                    pst.setNull( 19, Types.VARCHAR );
                }
                
                if ( s.getSrc_cell_phone() != null ) {
                    pst.setString( 20, s.getSrc_cell_phone() );
                }
                else {
                    pst.setNull( 20, Types.VARCHAR );
                }
                
                if ( s.getSrc_fax() != null ) {
                    pst.setString( 21, s.getSrc_fax() );
                }
                else {
                    pst.setNull( 21, Types.VARCHAR );
                }
                
                pst.setString( 22, s.getSrc_status().toUpperCase() );
                
                String exclSrc = ( s.getSrc_exclusive_source_yn().equalsIgnoreCase("Y") || s.getSrc_exclusive_source_yn().equalsIgnoreCase("YES") ) ? "Y" : "N";                
                pst.setString( 23, exclSrc );
                
                String dontContact = ( s.getSrc_dont_contact_yn().equalsIgnoreCase("Y") || s.getSrc_dont_contact_yn().equalsIgnoreCase("YES")) ?  "Y" : "N";
                pst.setString( 24, dontContact );
                
                if ( s.getSrc_company_type() != null ) {
                    pst.setString( 25, s.getSrc_company_type() );
                }
                else {
                    pst.setNull( 25, Types.VARCHAR );
                }
                
                if ( s.getSrc_area_of_expertise() != null ) {
                    pst.setString( 26, s.getSrc_area_of_expertise() );
                }
                else {
                    pst.setNull( 26, Types.VARCHAR );
                }
                
                if ( s.getSrc_industry_sector() != null ) {
                    pst.setString( 27, s.getSrc_industry_sector() );
                }
                else {
                    pst.setNull( 27, Types.VARCHAR );
                }
                
                if ( s.getSrc_industry_view().toUpperCase() != null ) {
                    pst.setString( 28, getIndustryViewsMap().get( s.getSrc_industry_view().toUpperCase() ) );
                }
                else {
                    pst.setNull( 28, Types.VARCHAR );
                }
                
                if ( s.getSrc_vendors() != null ) {
                    pst.setString( 29, s.getSrc_vendors() );
                }
                else {
                    pst.setNull( 29, Types.VARCHAR );
                }
                
                if ( s.getSrc_company_size() != null ) {
                    pst.setString( 30, s.getSrc_company_size() );
                }
                else {
                    pst.setNull( 30, Types.VARCHAR );
                }
                
                if ( s.getSrc_distribution_preference() != null ) {
                
                    
                    pst.setString( 31, getSourceDistributionPreferencesMap().get( s.getSrc_distribution_preference().toUpperCase() ) );
                }
                else {
                    pst.setNull( 31, Types.VARCHAR );
                }
                
                if ( s.getSrc_distribution_notes() != null ) {
                    pst.setString( 32, s.getSrc_distribution_notes() );
                }
                else {
                    pst.setNull( 32, Types.VARCHAR );
                }
                
                if ( s.getSrc_informed_of_website() != null ) {
                    String ss = s.getSrc_informed_of_website().equalsIgnoreCase("Y") || s.getSrc_informed_of_website().equalsIgnoreCase("YES") ? "Y" : "N";
                    pst.setString( 33, ss );
                }
                else {
                    pst.setString( 33, "N" );
                }
                
                if ( s.getSrc_offered_report() != null ) {
                    String so = ( s.getSrc_offered_report().equalsIgnoreCase("Y") || s.getSrc_offered_report().equalsIgnoreCase("YES") ) ? "Y" : "N"; 
                    pst.setString( 34, so );
                }
                else {
                    pst.setString( 34, "N" );
                }
                
                if ( s.getSrc_special_requests() != null ) {
                    pst.setString( 35, s.getSrc_special_requests() );
                }
                else {
                    pst.setNull( 35, Types.VARCHAR );    
                }
                
                if ( s.getSrc_reporters_notes() != null ) {
                    pst.setString( 36, s.getSrc_reporters_notes() );
                }
                else {
                    pst.setNull( 36, Types.VARCHAR );
                }
                
                if ( s.getSrc_quality_rating() != null ) {
                    pst.setString( 37, getQualityRatingsMap().get( s.getSrc_quality_rating().toUpperCase() ) );
                }
                else {
                    pst.setNull( 37, Types.VARCHAR );
                }
                
                Calendar cal = Calendar.getInstance();
                Timestamp t = new Timestamp( cal.getTimeInMillis() );
 LOG.info( "t is " + t);
                pst.setTimestamp( 38, t );
                
                int reporterId = s.getReporterSourceInfo().getRsc_empl_id();
LOG.info("reporterId for src " + s.getSrc_id() + " is " + reporterId );                
                pst.setString( 39, String.valueOf( reporterId ) );
        
        
                int rowCount = pst.executeUpdate();
                
                if ( rowCount != 1 ) 
                    s = null;
                    
        } catch ( SQLException e ) {
            LOG.error("Error in creating source " + s.getSrc_id(), e);  //e.printStackTrace();;
        }
        finally {
            try {
                if ( rs != null ) rs.close();
                if ( pst != null ) pst.close();
            }
            catch (SQLException e) {
                LOG.error("Error", e);  //e.printStackTrace();
            }
        }
        
        return s;
    }
    
    
    /*
    public SourceDataSetInfo createNewSource(SourceDataSetInfo s) {
        if ( s == null ) return null;
        
        int rprtId = s.getSrc_rprt_id();
        
        SourcesInfoVO src = new SourcesInfoVO();
        
        Number nxtSrcId = getNextSequence("BAwaWEb_SRC_SEQ");
        if ( s.getSrc_id() <= 0 ) {
            s.setSrc_id( nxtSrcId.intValue() );
        } else {
LOG.info("error cannot CREATE a src with a src id already existing");        
            return null;
        }
        
        src = src.transform( s );
        
        SourcesInfoVO aSrc = new SourcesInfoVO();
        
        Sources srcsView = platform.getSources();
        
        srcsView.insertRow( aSrc.transform( srcsView, src ) );
        
        commitAll();
LOG.info("Created src with id " + src.getSrcId());        
        ReportSourcesVO rps = createNewReportSource( s );
        
        commitAll();
        s.setReportSourceInfo( rps.transform( rps ) );
        
        return s;
        
    }
    */
    public ReportSourcesVO createNewReportSource(SourceDataSetInfo s) {
        int rprt_id = s.getSrc_rprt_id();
        if ( rprt_id != 0 ) {
            return this.createNewReportSource( s, rprt_id );
        }        
        return null;
    }

    private ReportSourcesVO createNewReportSource(SourceDataSetInfo s, int rprt_id) {
        if ( s == null || rprt_id <= 0 ) return null;
LOG.info("in createNewReportSource srcinfo -- rpsid is \n__\n" + s.getRps_id() + "\n__\n");        
        ReportSourcesVO rps = new ReportSourcesVO();
        
//        Number nxtRpsId = getNextRpsId();//getNextId("BAwaWEb_REPORT_SOURCES", "RPS_ID");//getNextSequence("BAwaWEb_RPS_SEQ");
//        if ( s.getRps_id() <= 0 ) {
//            s.setRps_id( nxtRpsId.intValue() );
//        } else {
//        LOG.info("error cannot CREATE a rps with a rpssrc id already existing");
//            return null;
//        }
//LOG.info("nxtRpsId is " + nxtRpsId);        
//        rps.setRpsId( nxtRpsId );
//        
        rps.setRpsId( new Number( s.getRps_id() ) );
        
        ReportSourcesDataSetInfo rsInfo = s.getReportSourceInfo();
        rsInfo.setRps_id( s.getRps_id() ); // nxtRpsId.intValue()
        rsInfo.setRps_src_id( s.getSrc_id() );
        
LOG.info("rsInfo Rps_id is \n" + rsInfo.getRps_id());        
        rps = rps.transform( rsInfo );
        
        rps = create( rps );
        
//        commitAll();
        
        return rps;
    }
    
//    private Number getNextId(String table, String col) {
//        if ( table == null || col == null ) return null;
//        
//        Statement st = null;   // cannot use preparedstatement since that is precompiled
//        ResultSet rs = null;
//        
//        String sql = "SELECT ( NVL( MAX(" + col + "), 0 ) + 1 ) maxid FROM " + table;
//        st = platform.getDBTransaction().createStatement( 1 );
//        
//        
//        try {
//            rs = st.executeQuery( sql );
//            rs.next();
//            
//            Number maxId = new Number( rs.getInt("maxid") );
//            
//            rs.close();
//            st.close();
//LOG.info("returning from getnextid " + maxId );            
//            return maxId;
//            
//        } catch(SQLException e) {
//            LOG.error("Error", e);  //e.printStackTrace();
//        }
//        finally {
//            try {
//                if ( rs != null ) rs.close();
//                if ( st != null ) st.close();
//            }
//            catch (SQLException e) {
//                LOG.error("Error", e);  //e.printStackTrace();
//            }
//        }
//        return null;
//    }

    private Number getNextSequence(String sqnc) {
        Sequence seq = new Sequence(sqnc, platform );
        String nxtSeqVal = seq.getData().toString();
        Number nxtSeqId = null;
        try {
            nxtSeqId = new Number( nxtSeqVal ); 
        } catch (SQLException e) { 
            LOG.error("Error", e);  //e.printStackTrace();
        }
        return nxtSeqId;
    }
    
    
    private String getEmpInitials( int rprtrId ) {
        if ( rprtrId <= 0 ) return null;
        
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        String sql = " select empl_init from empl_bawaweb_employees where empl_id = ?";
        pst = platform.getDBTransaction().createPreparedStatement( sql, 0 );
        
        try {
            pst.setInt( 1, rprtrId );
            
            rs = pst.executeQuery();
            rs.next();
            
            String emplInit = rs.getString("EMPL_INIT");
            
            rs.close();
            pst.close();
            
            return emplInit;
        } catch ( SQLException e ) {
            LOG.error("Error", e);  //e.printStackTrace();;
        }
        finally {
            try {
                if ( rs != null ) rs.close();
                if ( pst != null ) pst.close();
            }
            catch (SQLException e) {
                LOG.error("Error", e);  //e.printStackTrace();
            }
        }
        return null;
        
    }

    private Number getNextRpsId() {
        MaxRpsId view = platform.getGetNxtRpsId();
        view.executeQuery();
        if ( view.hasNext() ) {
            MaxRpsIdRow row = (MaxRpsIdRow) view.next();
            
            return new Number(row.getMaxRpsId().intValue() + 1 );
        }
        return null;
    }
    
    public Map<Integer, SourceDataSetInfo> addExtraSources(List<SourceDataSetInfo> newSources, 
                                List<SourceDataSetInfo> newReportSources, 
                                Map<Integer, SourceDataSetInfo> mp_internalId_src) {
        /*
         * newSources -- we add src, reprtSrc, rprtrrSrc, srcInds
         * newRepSrcs -- we check if [reprtSrc, rprtrrSrc, srcInds] exists first b4 we add
         * 
         */
System.out.println("in P-addExtraSrcs --> mp_internalId_src is " + mp_internalId_src);         
         List<Integer> rprtrIndustries = ( newSources.size() > 0 ) ? getIndustryListForReporter( newSources.get(0).getRps_rptr_id() ) :
                                         ( newReportSources.size() > 0 ) ? getIndustryListForReporter( newReportSources.get(0).getRps_rptr_id() ) : null;
         
         
         Number nxtRpsId = getNextRpsId();
            
         int numRpsRecsAdded = 0;
LOG.info("newSources.size() is " + newSources.size() );

         if ( newSources.size() > 0 ) {
            
             for ( SourceDataSetInfo s : newSources ) {
                LOG.info("newSources  " + s.getSrc_first_name() + " " + s.getSrc_last_name());
             }
            
            
            
            
            
            for ( SourceDataSetInfo s : newSources ) {
                s = create ( s );
LOG.info("Created Source \n" + s);

                commitAll();
LOG.info("After CREATE srcid is " + s.getSrc_id() );     
                /*
                if ( !this.checkSourceLocation( s.getSrc_id() ) ) {
                    s.setIsSrcLocationValid( false );
                } else {
                    s.setIsSrcLocationValid( true );
                }
                */
                numRpsRecsAdded++;
                s.setRps_id( nxtRpsId.intValue() + numRpsRecsAdded );
                ReportSourcesVO rps = createNewReportSource( s );
LOG.info("After CREATE rpsid is " + rps.getRpsId() );                
                commitAll();
                ReportSourcesDataSetInfo rpsInf = rps.transform( rps );
                s.setReportSourceInfo( rpsInf );
                
                
                
                ReporterSourcesVO rprtr = createNewReporterSource( s );
LOG.info("After CREATE rptrid is " + rprtr.getRscEmplId() );                
                commitAll();
                ReporterSourcesDataSetInfo rptrInf = rprtr.transform( rprtr );
                s.setReporterSourceInfo( rptrInf );
                
                if ( rprtrIndustries != null  ) {
                    if ( !this.checkSourceIndustries(s, rprtrIndustries) ) {
                        createSourceIndustries( s, rprtrIndustries );
                        commitAll();
                    }
                }
                
                mp_internalId_src.put( s.getXlInternalId(), s );
                
            } // for newsources
         }
         
         
         
LOG.info("newReportSources.size() is " + newReportSources.size() );
         if ( newReportSources.size() > 0 ) {  
            for ( SourceDataSetInfo s : newReportSources ) {
                ReportSourcesDataSetInfo rps = this.checkReportSourceExist( s );
                if (  rps != null ) {
LOG.info("ReportSource " +  rps.getRps_id() + " EXISTS for s " + s.getSrc_first_name() + " " + s.getSrc_last_name() );                
                    // rps exists for the src
                    s.setRps_id( rps.getRps_id() );
                    
                    s.setReportSourceInfo( rps );
                    
                } else {
LOG.info("CREATING ReportSource for s " + s.getSrc_first_name() + " " + s.getSrc_last_name() );
                    // add new rps
                     numRpsRecsAdded++;
                     s.setRps_id( nxtRpsId.intValue() + numRpsRecsAdded );
                     
                     
                     ReportSourcesVO rpsVo = createNewReportSource( s );
                     s.setReportSourceInfo( rpsVo.transform( rpsVo ) );
                     
                     commitAll();
                }// ends ReportSourcesDataSetInfo
                
                
                ReporterSourcesDataSetInfo rptr = this.checkReporterSourceExist( s ); 
                if ( rptr != null ) {
LOG.info("ReporterSource " +  rptr.getRsc_empl_id() + " EXISTS for s " + s.getSrc_first_name() + " " + s.getSrc_last_name() );                
                    // rptr exists for src
                    s.setRps_rptr_id( rptr.getRsc_empl_id() );
                    
                    s.setReporterSourceInfo( rptr );
                } else {
LOG.info("CREATING ReporterSource for s " + s.getSrc_first_name() + " " + s.getSrc_last_name() );                
                    ReporterSourcesVO rptsVo = createNewReporterSource( s );
LOG.info("rptsVo is " + rptsVo );

                    s.setRps_rptr_id( rptsVo.getRscEmplId().intValue() );
                    
                    s.setReporterSourceInfo( rptsVo.transform( rptsVo ) );
                    
                    commitAll();
                }// ends ReporterSourcesDataSetInfo
                
                
                if ( rprtrIndustries != null  ) {
                    if ( !this.checkSourceIndustries(s, rprtrIndustries) ) {
                        createSourceIndustries( s, rprtrIndustries );
                    }
                }
                
                commitAll();
                
                mp_internalId_src.put( s.getXlInternalId(), s );
            } // for reportsources
         }
         
         return mp_internalId_src;                           
    }
    
    private ReporterSourcesDataSetInfo checkReporterSourceExist(SourceDataSetInfo s) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "select * from bawaweb_reporter_sources \n" + 
                        "where  rsc_src_id = ? and rsc_empl_id = ? and rsc_delete_yn = 'N'";
        pst = platform.getDBTransaction().createPreparedStatement( sql, 0 );
        
        ReporterSourcesDataSetInfo rptr = null;
        
        try {
            pst.setInt( 1, s.getSrc_id() );
            pst.setInt( 2, s.getRps_rptr_id() );
            
            rs = pst.executeQuery();
            
            if ( rs.next() ) {
                rptr = new ReporterSourcesDataSet();
                
                rptr.setRsc_src_id( rs.getInt( "RSC_SRC_ID" ) );
                rptr.setRsc_empl_id( rs.getInt( "RSC_EMPL_ID" ) );
                rptr.setRsc_delete_yn( rs.getString( "RSC_DELETE_YN" ) );
                
            } else {
                rptr = null;
            }
            
//            // make sure only one record came back
//            rs.last();
//            int count = rs.getRow();
//            if ( count != 1 ) return 0;
//            rs.beforeFirst();
//            
//            // go to that record
//            rs.next();
//            int rsc_src_id = rs.getInt("RSC_SRC_ID");
//            
            rs.close();
            pst.close();
            
            return rptr;
            
        } catch (SQLException e) {
            LOG.error("Error", e);  //e.printStackTrace();
        }
        
        finally {
            try {
                if ( rs != null ) rs.close();
                if ( pst != null ) pst.close();
            }
            catch (SQLException e) {
                LOG.error("Error", e);  //e.printStackTrace();
            }
        }
        
        return rptr;                        
    }
    

    // will return rps_id if it exists
    private ReportSourcesDataSetInfo checkReportSourceExist(SourceDataSetInfo s) {
        boolean doesRpsExist = false;
        
        ReportSourcesDataSetInfo rps = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql =  "SELECT * \n" + 
                    "  FROM bawaweb_report_sources\n" + 
                    "  WHERE rps_src_id = ? AND rps_rprt_id = ? " +
                    "  AND rps_rptr_id = ? AND rps_delete_yn = 'N'";
        
        pst = platform.getDBTransaction().createPreparedStatement( sql, 0 );
        
        int rps_id = 0;
        int rps_src_id = 0;
        int rps_rprt_id = 0;
        int rps_rptr_id = 0;
        
        try {
            pst.setInt( 1, s.getSrc_id() );
            pst.setInt( 2, s.getSrc_rprt_id() );
            pst.setInt( 3, s.getRps_rptr_id() );
            
            rs = pst.executeQuery();
            if ( rs.next() ) {
                rps = new ReportSourcesDataSet();
                
                rps.setRps_id( rs.getInt( "RPS_ID" ) );
                rps.setRps_src_id( rs.getInt( "RPS_SRC_ID" ) );
                rps.setRps_rprt_id( rs.getInt( "RPS_RPRT_ID" ) );
                rps.setRps_rptr_id( rs.getInt( "RPS_RPTR_ID" ) );
                rps.setRps_comped_yn( rs.getString( "RPS_COMPED_YN" ) );
                rps.setRps_delete_yn( rs.getString( "RPS_DELETE_YN" ) );
                
                doesRpsExist = true;
            } else {
                rps = null;
            }
            
            
            
            
            
            
//            // make sure only one record came back
//            rs.last();
//            int count = rs.getRow();
//            if ( count != 1 ) return 0;
//            rs.beforeFirst();
//            
//            // go to that record
//            rs.next();
//            int rps_id = rs.getInt("RPS_ID");
            
            rs.close();
            pst.close();
            
        } catch (SQLException e) {
            LOG.error("Error", e);  //e.printStackTrace();
        }
        finally {
            try {
                if ( rs != null ) rs.close();
                if ( pst != null ) pst.close();
            }
            catch (SQLException e) {
                LOG.error("Error", e);  //e.printStackTrace();
            }
        }
LOG.info("for srcid " + s.getSrc_id() + " rprtid " + s.getSrc_rprt_id() + " and reporterid " + s.getRps_rptr_id() + " doesRpsExist is " + doesRpsExist);        
        return rps;
    }

    private ReporterSourcesVO createNewReporterSource(SourceDataSetInfo s) {
        int rprtr_id = s.getRps_rptr_id() ;
        if ( rprtr_id != 0 ) {
            return this.createNewReporterSource( s, rprtr_id );
        }        
        return null;
    }

    private ReporterSourcesVO createNewReporterSource(SourceDataSetInfo s, int rprtr_id) {
        if ( s == null || rprtr_id <= 0 ) return null;
        LOG.info("in createNewReporterSource srcinfo is \n__\n" + s + "\n__\n");
        ReporterSourcesVO rptrSrcVo = new ReporterSourcesVO();

LOG.info("s.getRps_rptr_id() is " + s.getRps_rptr_id());

        rptrSrcVo.setRscEmplId( new Number( s.getRps_rptr_id() ) );
        
        ReporterSourcesDataSetInfo rsInfo = s.getReporterSourceInfo();
        rsInfo.setRsc_empl_id( rprtr_id ); 
        rsInfo.setRsc_src_id( s.getSrc_id() );
        rsInfo.setRsc_delete_yn( "N" );
        
        LOG.info("reprtrSInfo Rsc_src_id is \n" + s.getSrc_id());
LOG.info("rsInfo b4transformed is " + rsInfo);        
        rptrSrcVo = rptrSrcVo.transform( rsInfo );
LOG.info("rptr transformed is " + rptrSrcVo);        
        rptrSrcVo = create( rptrSrcVo );
        
        //        commitAll();
        
        return rptrSrcVo;
    }
    
    
    private List<Integer> getIndustryListForReporter(int rprtrId) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "SELECT igm_frid_id FROM bawaweb_industry_group_members WHERE igm_empl_id = ? ORDER BY igm_frid_id";
        pst = platform.getDBTransaction().createPreparedStatement( sql, 0 );
        List<Integer> theIndustryIds = new ArrayList<Integer>();
        
        try {
            pst.setInt( 1, rprtrId );
            
            rs = pst.executeQuery();
            while ( rs.next() ) {
                int id = rs.getInt( "IGM_FRID_ID" );
                theIndustryIds.add( id );
            }
            
            pst.close();
            rs.close();
        } catch (SQLException e) {
            LOG.error("Error", e);  //e.printStackTrace();
        }
        finally {
            try {
                if ( rs != null ) rs.close();
                if ( pst != null ) pst.close();
            }
            catch (SQLException e) {
                LOG.error("Error", e);  //e.printStackTrace();
            }
        }
        
        return theIndustryIds;

    }

    private void createSourceIndustries(SourceDataSetInfo s, List<Integer> rprtrIndustries) {
        SourceIndustries srcVIndiew = platform.getSourceIndustries();
        SourceIndustriesVO si = new SourceIndustriesVO();
        
        si.setSciDeleteYn( "N" );
        si.setSciSrcId( new Number( s.getSrc_id() ) );
        
        for ( int i : rprtrIndustries ) {
            si.setSciFridId( new Number( i ) );
            
            srcVIndiew.insertRow( si.transform( srcVIndiew, si ) );
        }
        
        
    }

    // later on if you can like check for each and then add the ones missing
    // am assuming all is ok for now
    private boolean checkSourceIndustries(SourceDataSetInfo s, 
                                          List<Integer> rprtrIndustries) {
        if ( rprtrIndustries.size() <= 0 ) return false;
        
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        String sql = "select * from bawaweb_source_industries where sci_src_id  = ? and sci_frid_id in ( ";
        for ( int i = 0; i < rprtrIndustries.size(); i++) {
            sql += rprtrIndustries.get(i);
            if ( i != rprtrIndustries.size() - 1 ) {
                sql += ", ";
            }
        }
        sql += ")";
        
        pst = platform.getDBTransaction().createPreparedStatement( sql, 0 );
        boolean found = false;
        
        try {
            pst.setInt( 1, s.getSrc_id() );
            
            rs = pst.executeQuery();
            // make sure records exist
            if ( rs.next() ){
                found = true;
            }
        
            pst.close();
            rs.close();
        } catch (SQLException e) {
            LOG.error("Error", e);  //e.printStackTrace();
        }
        finally {
            try {
                if ( rs != null ) rs.close();
                if ( pst != null ) pst.close();
            }
            catch (SQLException e) {
                LOG.error("Error", e);  //e.printStackTrace();
            }
        }
        
        return found;
    }
    
    
    public boolean checkSourceLocation( int srcId ) {
        boolean isLocValid = false;
LOG.info("in checkSrcLocation srcid is " + srcId );        
        CallableStatement cs = null;
        String csBegin = "begin ? := ";
        String csEnd = " end;";
        String csStatement = " BAwaWEb_MAPPING_UTILS.check_source_location(?);";    // 6?s
        String csCall = csBegin + csStatement + csEnd;
        String locReturned = null;
        
        try {
            cs = platform.getDBTransaction().createCallableStatement(csCall, 0);
            
            cs.registerOutParameter( 1, Types.VARCHAR );
            
            cs.setInt( 2, srcId );
            
            cs.execute();
            
            locReturned =  cs.getString( 1 );
            
LOG.info("for srcId " + srcId + " the proc returns " + locReturned );            
            
            if ( locReturned.equalsIgnoreCase( "Y" ) ) {
                isLocValid = true;
            }
            
            cs.close();
            
        } catch ( SQLException e) {
            LOG.error("Error", e);  //e.printStackTrace();
            LOG.error("Error in checking location for the source", e);
        }
        

        
        finally {
            try {
                if ( cs != null ) cs.close();
            } catch ( SQLException se) {
                LOG.error("Error", se);  //e.printStackTrace();
            }
        }
LOG.info("returning isLocValid " + isLocValid + " for srcid " + srcId );        
        return isLocValid;
    }


     public void printSet(Set aSet) {
         if ( aSet == null ) { LOG.info("aSet is null"); return; }
         Iterator it = aSet.iterator();
         while ( it.hasNext() ) 
             LOG.info("|"+ it.next()+"|" );
     }  

    public void printList(List alist) {
        if ( alist == null ) { LOG.info("alist is null"); return; }
        Iterator it = alist.iterator();
        while ( it.hasNext() ) 
            LOG.info("|"+ it.next()+"|" );
    }    
    
    public void printMap(Map aMap) {
        if ( aMap == null ) { LOG.info("amap is null"); return; }
        Set aSet = aMap.keySet();
        for ( Iterator it = aSet.iterator(); it.hasNext(); ) {
            Object key = it.next();
            LOG.info(key + " ==> " + aMap.get(key));
        }
    }

    private List<AnswerSetValuesDataSetInfo> processAsvDisplaySeq(List<AnswerSetValuesDataSetInfo> liAnsv) {
        List<AnswerSetValuesDataSetInfo> asvs = new ArrayList<AnswerSetValuesDataSetInfo>( liAnsv.size() );
        List<Integer> displaySeqNums = new ArrayList<Integer> ( liAnsv.size() );
        
        for ( AnswerSetValuesDataSetInfo asv : liAnsv ) {
            displaySeqNums.add( asv.getAsv_display_seq() );
        }
        
        Collections.sort( displaySeqNums );
        for ( Integer i : displaySeqNums ) {
            for ( AnswerSetValuesDataSetInfo asv : liAnsv ) {
                if ( asv.getAsv_display_seq() == i ) {
                    asvs.add( asv );
                }
            }
        }
        
        return asvs;
    }
    


    private List<ReportAnswerSetValuesDataSetInfo> processRavDisplaySeq(List<ReportAnswerSetValuesDataSetInfo> liRav) {
        List<ReportAnswerSetValuesDataSetInfo> ravs = new ArrayList<ReportAnswerSetValuesDataSetInfo>( liRav.size() );
        List<Integer> displaySeqNums = new ArrayList<Integer> ( liRav.size() );
        
        for ( ReportAnswerSetValuesDataSetInfo rav : liRav ) {
            displaySeqNums.add( rav.getRav_display_seq() );
        }
        
        Collections.sort( displaySeqNums );
        for ( Integer i : displaySeqNums ) {
            for ( ReportAnswerSetValuesDataSetInfo rav : liRav ) {
                if ( rav.getRav_display_seq() == i ) {
                    ravs.add( rav );
                }
            }
        }
        
        return ravs;
    }

    private List<ReportAnswerSetValuesDataSetInfo> getMandatoryRAVValsList(List<ReportAnswerSetValuesDataSetInfo> liExistingRprtAnsSetVals, 
                                                                     List<String> mandatoryVals) {
                                                                     
        List<ReportAnswerSetValuesDataSetInfo> theList = new ArrayList<ReportAnswerSetValuesDataSetInfo>( mandatoryVals.size() );
        for ( ReportAnswerSetValuesDataSetInfo rav : liExistingRprtAnsSetVals ) {
            if ( mandatoryVals.contains( rav.getRav_answer().trim() ) ) {
                theList.add( rav );
            }
        }
        
        return theList;
    }

    private List<AnswerSetValuesDataSetInfo> getMandatoryASVValsList(List<AnswerSetValuesDataSetInfo> liExistingAnswerSetVals, 
                                                                     List<String> mandatoryVals) {
                                                                     
        List<AnswerSetValuesDataSetInfo> theList = new ArrayList<AnswerSetValuesDataSetInfo>( mandatoryVals.size() );
        for ( AnswerSetValuesDataSetInfo asv : liExistingAnswerSetVals ) {
            if ( mandatoryVals.contains( asv.getAsv_answer().trim() ) ) {
                theList.add( asv );
            }
        }
        
        return theList;
    }
    


    private int getRAVDontKnowDisplaySequenceNum(List<ReportAnswerSetValuesDataSetInfo> listRAVVals) {
        for ( ReportAnswerSetValuesDataSetInfo rav : listRAVVals ) {
            String ansVal = rav.getRav_answer();
            if ( ansVal.equalsIgnoreCase("Don't know") ) {
LOG.info("RAV found dont know seqNum is " + rav.getRav_display_seq() + " and its elemetindex is " + listRAVVals.indexOf( rav ) );
                int displaySeqNum = rav.getRav_display_seq();
                
                return displaySeqNum;
            }
        }
        return 0;
    }

    private int getASVDontKnowDisplaySequenceNum(List<AnswerSetValuesDataSetInfo> listASVVals) {
        for ( AnswerSetValuesDataSetInfo asv : listASVVals ) {
            String ansVal = asv.getAsv_answer();
            if ( ansVal.equalsIgnoreCase("Don't know") ) {
LOG.info("ASV found dont know seqNum is " + asv.getAsv_display_seq() + " and its elemetindex is " + listASVVals.indexOf( asv ) );
                int displaySeqNum = asv.getAsv_display_seq();
                
                return displaySeqNum;
            }
        }
        return 0;
    }

//    private List<AnswerSetValuesDataSetInfo> processAsvDisplaySeq(List<AnswerSetValuesDataSetInfo> liAnsv, 
//                                                                  Number ansId) {
//        List<AnswerSetValuesDataSetInfo> asvs = new ArrayList<AnswerSetValuesDataSetInfo>( liAnsv.size() );
//        List<Pair> displaySeqNumsPairs = new ArrayList<Integer> ( liAnsv.size() );
//        
//        for ( AnswerSetValuesDataSetInfo asv : liAnsv ) {
//            displaySeqNumsPairs.add( new Pair( asv.getAsv_ans_id(), asv.getAsv_display_seq() ) );
//        }
//        
//        for ( Pair p : displaySeqNumsPairs ) {
//            
//        }
//        
////        Collections.sort( displaySeqNums );
////        for ( Integer i : displaySeqNums ) {
////            for ( AnswerSetValuesDataSetInfo asv : liAnsv ) {
////                if ( asv.getAsv_display_seq() == i ) {
////                    asvs.add( asv );
////                }
////            }
////        }
////        
//        return asvs;
//    }

    private int getASVDontKnowDisplaySequenceNum(List<AnswerSetValuesDataSetInfo> listASVVals, 
                                                 Number ansId) {
        for ( AnswerSetValuesDataSetInfo asv : listASVVals ) {
            String ansVal = asv.getAsv_answer().trim();
            if ( ansVal.equalsIgnoreCase("Don't know") && asv.getAsv_ans_id() == ansId.intValue() ) {
LOG.info("ASV found dont know seqNum is " + asv.getAsv_display_seq() + " and its elemetindex is " + listASVVals.indexOf( asv ) );
                int displaySeqNum = asv.getAsv_display_seq();
                
                return displaySeqNum;
            }
        }
        return 0;
    }

    private int getRAVDontKnowDisplaySequenceNum(List<ReportAnswerSetValuesDataSetInfo> listRAVVals, 
                                                 Number rasId) {
        for ( ReportAnswerSetValuesDataSetInfo rav : listRAVVals ) {
            String ansVal = rav.getRav_answer().trim();
            if ( ansVal.equalsIgnoreCase("Don't know") && rav.getRav_ras_id() == rasId.intValue() ) {
        LOG.info("RAV found dont know seqNum is " + rav.getRav_display_seq() + " and its elemetindex is " + listRAVVals.indexOf( rav ) );
                int displaySeqNum = rav.getRav_display_seq();
                
                return displaySeqNum;
            }
        }
        return 0;
    }


    private boolean doesSourceMultiAnswerExistADF(Number sraId, Number qmqId) {
        if ( sraId == null ) { return false; }
        
LOG.info("in doesSourceMultiAnswerExist for sraId " + sraId + " and qmqId " + qmqId );
        DoesSourceMultiAnswerExist doesSrcMultiAnsExistView = platform.getDoesSourceMultiAnswerExist();
        
        doesSrcMultiAnsExistView.setqmq_id( qmqId );
        doesSrcMultiAnsExistView.setsma_sra_id( sraId );
        
        doesSrcMultiAnsExistView.executeQuery();
        
        if ( doesSrcMultiAnsExistView.hasNext() ) {
            DoesSourceMultiAnswerExistRow row = (DoesSourceMultiAnswerExistRow) doesSrcMultiAnsExistView.next();
            String answer = row.getSmaAnswer();
            answer = answer != null ? answer.trim() : null;
            Number asvId = row.getSmaAsvId();
            Number ravId = row.getSmaRavId();
            
            if (    ( answer != null || !answer.equals("") ) && 
                    ( asvId != null || !asvId.equals( new Number( 0 ) ) ) &&
                    ( ravId != null || !ravId.equals( new Number( 0 ) ) )
            ) {
LOG.info("doesSourceMultiAnswerExist returns true  for sraId " + sraId + " and qmqid " + qmqId );
LOG.info("answer is |" + answer + "|");
LOG.info("asvid is |" + asvId + "|");
LOG.info("ravid is |" + ravId + "|");

                return true;
            }
            
        }
LOG.info("doesSourceMultiAnswerExist returns false  for sraId " + sraId + " and qmqid " + qmqId );
        return false;
    
    
    }

    private Number getSraIdFromSrcAnswers(Number qstId, Number rpsId) {
LOG.info(" in getSraIdFromSrcAnswers qstid is " + qstId + " and rpsid is " + rpsId );    
        if ( qstId == null || qstId.intValue() <= 0 ) { throw new IllegalArgumentException("Incorrect or null qstid"); }
        if ( rpsId == null || rpsId.intValue() <= 0 ) { throw new IllegalArgumentException("Incorrect or null rpsId"); }
                
        SrcAnsUniqueInfoRow srcAnsRow = null;
        
        SrcAnsUniqueInfo srcAnsUniqueInfoView = platform.getSrcAnsUniqueInfo();
                
        srcAnsUniqueInfoView.setqst_id( qstId );
        srcAnsUniqueInfoView.setrps_id( rpsId );
        
        srcAnsUniqueInfoView.executeQuery();
        
        if ( srcAnsUniqueInfoView.hasNext() ) {
            srcAnsRow = (SrcAnsUniqueInfoRow) srcAnsUniqueInfoView.next();
LOG.info("returninf sraId " + srcAnsRow.getSraId() );            
            return srcAnsRow.getSraId();
        }
        
        return null;

        
    }
//    
//    
//    public Map<Integer, Integer> getQstIdRasIdMap(int rprtId) {
//    }

    public Map<Integer, List<Integer>> getRasIdQstIdsMap(int rprtId) {
        if ( rprtId <= 0 ) return null;
        
        Map<Integer, List<Integer>> amap = new HashMap<Integer, List<Integer>>();
        
        LinkedHashMap<Integer, QuestionDataSetInfo> qnMap = getQuestions( new Number( rprtId) );
        Set<Integer> theQstnIds = qnMap.keySet();
        List<Integer> theQnIds = null;
        
        for ( int qstId : theQstnIds ) {
            int rasId = qnMap.get( qstId ).getQst_ras_id();
            
            if ( rasId >= 0 ) {
                if ( amap.get( rasId ) == null ) {
                    theQnIds  = new ArrayList<Integer>();
                } else {
                    theQnIds  =   amap.get( rasId );
                }
                
                theQnIds.add( qstId );
                
                amap.put( rasId, theQnIds );
            }
        }
        
        return amap;
    }
}
