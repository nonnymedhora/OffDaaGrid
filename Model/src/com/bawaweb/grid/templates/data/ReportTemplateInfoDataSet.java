/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data;

import com.bawaweb.grid.templates.data.cursors.MultiQuestionDataSetInfo;
import com.bawaweb.grid.templates.data.cursors.QuestionDataSetInfo;
import com.bawaweb.grid.templates.data.cursors.ReportGeneralInfo;
import com.bawaweb.grid.templates.data.cursors.SourceAnswersDataSet;

import com.bawaweb.grid.templates.data.cursors.SourceAnswersDataSetInfo;
import com.bawaweb.grid.templates.data.tables.SourceDataSetInfo;

import com.bawaweb.servlets.FileUploadServlet;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import oracle.jbo.domain.Number;

import org.apache.log4j.Logger;

public class ReportTemplateInfoDataSet implements ReportTemplateInfo {
    private static final Logger LOG = Logger.getLogger(ReportTemplateInfoDataSet.class);

    private List<QuestionDataSetInfo> listOfQuestions;  		//                      list of QuestionDataSet objects
    private List<SourceDataSetInfo> listOfSources;			// 		        list of SourceInfoDataSet objects
    //private Map listMapOfSourceAnswers;           //                      map of (key "qid, srcid" val SourceAnswersDataSetInfo)
    private List<SourceAnswersDataSetInfo> listOfSourceAnswers;           //                      map of (key "qid, srcid" val SourceAnswersDataSetInfo)
    private List weightedQuestions;		//			list of question ids
    private List singleQuestions;		//			list of question ids
    private List multiQuestions;		//			list of question ids
    private List ratingQuestions;		//			list of question ids
    private List dataQuestions;			//			list of question ids
    private List sortQuestions;			//			list of question ids
    private List textQuestions;			//			list of question ids
    private List requiredQuestions;		//			list of question ids    
    
    private LinkedHashMap<Integer, QuestionDataSetInfo> questionsDataSetMap;
    private LinkedHashMap<Integer, SourceDataSetInfo> sourcesDataSetMap;
    
    private ReportGeneralInfo reportGeneralInfo;
    
    private List reportSortingCriterias;        
    private int report_id;      
    private int reporter_id;
    
    private List<String> li_questionTags;           // the list of qstn headers which will be in the answers grid sheet
    private Map<String, String> mp_qTypeMap;        // the map of qstn id to the type
    private Map<String, Integer> mp_ReprtrInit_ReprtrIdMap ;    // map of reporter initials to reporter ids
    
    
    
     private List<SourceDataSetInfo> listOfAdditionalSources;                      //                      list of SourceInfoDataSet objects
     private List<SourceAnswersDataSetInfo> listOfAdditionalSourceAnswers;           //                      map of (key "qid, srcid" val SourceAnswersDataSetInfo)
     
     private List<QuestionDataSetInfo> listOfQuestionsForAdditionalAnswers;

     private String sourceDisplayNameStyle;
     private List<String> courtesyTitles;
     private List<String> suffixTitles;
     private Map<String, Integer> mp_ctryName_CtryIds;
     
     private LinkedHashMap<String, Integer> mp_tmzId_tmzNameDesc;
     private LinkedHashMap<String, String> mp_indDesc_indCode;
     private LinkedHashMap<String, String> mp_QualityRatingDesc_Code;
     private LinkedHashMap<String, String> mp_SourceDistributionPrefsDesc_Code;

    
    
	public List getDataQuestions() {
		return this.dataQuestions;
	}
	public void setDataQuestions(List dataQuestions) {
		this.dataQuestions = dataQuestions;
	}
	public List<QuestionDataSetInfo> getListOfQuestions() {
		return this.listOfQuestions;
	}
	public void setListOfQuestions(List<QuestionDataSetInfo> listOfQuestions) {
		this.listOfQuestions = listOfQuestions;
	}
	public List<SourceDataSetInfo> getListOfSources() {
		return this.listOfSources;
	}
	public void setListOfSources(List<SourceDataSetInfo> listOfSources) {
LOG.info("setlist of sources called in the reporttemplate to size " + listOfSources.size());
LOG.info(listOfSources);
		this.listOfSources = listOfSources;
	}

        public List<SourceDataSetInfo> getListOfAdditionalSources() {
                return this.listOfAdditionalSources;
        }
        public void setListOfAdditionalSources(List<SourceDataSetInfo> listOfSources) {
                this.listOfAdditionalSources = listOfSources;
        }
	public List getMultiQuestions() {
		return this.multiQuestions;
	}
	public void setMultiQuestions(List multiQuestions) {
		this.multiQuestions = multiQuestions;
	}
	public List getRatingQuestions() {
		return this.ratingQuestions;
	}
	public void setRatingQuestions(List ratingQuestions) {
		this.ratingQuestions = ratingQuestions;
	}
	public List getRequiredQuestions() {
		return this.requiredQuestions;
	}
	public void setRequiredQuestions(List requiredQuestions) {
		this.requiredQuestions = requiredQuestions;
	}
	public List getSingleQuestions() {
		return this.singleQuestions;
	}
	public void setSingleQuestions(List singleQuestions) {
		this.singleQuestions = singleQuestions;
	}
	public List getSortQuestions() {
		return this.sortQuestions;
	}
	public void setSortQuestions(List sortQuestions) {
		this.sortQuestions = sortQuestions;
	}
	public List getTextQuestions() {
		return this.textQuestions;
	}
	public void setTextQuestions(List textQuestions) {
		this.textQuestions = textQuestions;
	}
	public List getWeightedQuestions() {
		return this.weightedQuestions;
	}
	public void setWeightedQuestions(List weightedQuestions) {
		this.weightedQuestions = weightedQuestions;
	}
	public List getReportSortingCriterias() {
		return this.reportSortingCriterias;
	}
	public void setReportSortingCriterias(List reportSortingCriterias) {
		this.reportSortingCriterias = reportSortingCriterias;
	}
        

        public void setListOfSourceAnswers(List<SourceAnswersDataSetInfo> listOfSourceAnswers) {
            this.listOfSourceAnswers = listOfSourceAnswers;
        }

        public List<SourceAnswersDataSetInfo> getListOfSourceAnswers() {
            return this.listOfSourceAnswers;
        }

        public void setListOfAdditionalSourceAnswers(List<SourceAnswersDataSetInfo> listOfSourceAnswers) {
            this.listOfAdditionalSourceAnswers = listOfSourceAnswers;
        }

        public List<SourceAnswersDataSetInfo> getListOfAdditionalSourceAnswers() {
            return this.listOfAdditionalSourceAnswers;
        }
        public LinkedHashMap<Integer, QuestionDataSetInfo> getQuestionsDataSetMap() {
            return this.questionsDataSetMap;
        }
        
        public void setQuestionsDataSetMap(LinkedHashMap<Integer, QuestionDataSetInfo> theQuestionsDataSetMap) {
            this.questionsDataSetMap = theQuestionsDataSetMap;
        }
        
        public LinkedHashMap<Integer, SourceDataSetInfo> getSourcesDataSetMap() {
            return this.sourcesDataSetMap;
        }
        
        public void setSourcesDataSetMap(LinkedHashMap<Integer, SourceDataSetInfo> theSourcesDataSetMap) {
            this.sourcesDataSetMap = theSourcesDataSetMap;
        }
        
        public ReportGeneralInfo getReportGeneralInfo() {
            return this.reportGeneralInfo;
        }
        
        public void setReportGeneralInfo(ReportGeneralInfo info) {
            this.reportGeneralInfo = info;
        }
        
        public int getReportId() {
            return this.report_id;
        }
        
        public void setReportId(int id) {
            this.report_id = id;
        }
        
        public int getReporterId() {
            return this.reporter_id;
        }
        
        public void setReporterId(int id) {
            this.reporter_id = id;
        }
        
        public void setLi_questionTags(List<String> tags) {
            this.li_questionTags = tags;
        }
        
        public List<String> getLi_questionTags() {
            return this.li_questionTags;
        }
        
        
        public Map<String, String> getMp_qTypeMap() {
            return this.mp_qTypeMap;
        }
        
        public void setMp_qTypeMap(Map<String, String> map) {
            this.mp_qTypeMap = map;
        }
        
        
        public List<String> buildQuestionTags() {
            List<QuestionDataSetInfo> qns = this.getListOfQuestions();
            List<String> qstnIds = new ArrayList<String>();
            List<String> qstnTags = new ArrayList<String>();
            for ( Iterator<QuestionDataSetInfo> qt = qns.iterator(); qt.hasNext(); ) {
                QuestionDataSetInfo qn = qt.next();
                String qType = qn.getQst_type();
                String qstnId = String.valueOf(qn.getQst_id());
                
                if ( qType.equals("WEIGHT") || qType.equals("SINGLE") || qType.equals("TEXT") || qType.equals("RATING")) {
                    qstnTags.add( qstnId );
                    if ( qn.getQst_text_required_yn().equalsIgnoreCase("Y") ) {
                        qstnTags.add(qstnId + "_H");
                    }
                    
                } else if ( qType.equals("REPEAT") ) {
                    qstnTags.add( "Repeat" );
                    
                } else if ( qType.equals("DATA") ) {
                    qstnTags.add( qstnId );             // will hold numeric content
                    qstnTags.add( qstnId + "_D");       // will hold drop down contents
                    if ( qn.getQst_text_required_yn().equalsIgnoreCase("Y") ) {
                         qstnTags.add(qstnId + "_H");
                    }
                    
                } else if ( qType.equals("MULTI") ) {
                    if ( qn.getQst_text_required_yn().equalsIgnoreCase("Y") ) {
                         qstnTags.add(qstnId + "_H");
                    }
                    List<MultiQuestionDataSetInfo> mqInfo = qn.getMultiQuestionInfo();
                    for (Iterator<MultiQuestionDataSetInfo> mt = mqInfo.iterator(); mt.hasNext(); ) {
                        MultiQuestionDataSetInfo qmqInfo = mt.next();
                        String qmqNumber = qmqInfo.getQmq_number();
                        String qmqType = qmqInfo.getQmq_type();
                        if ( qmqType.equals("TEXT") ) {
                            qstnTags.add(qstnId + "_M_" + qmqNumber + "_" + "T");//qstnTags.add(qstnId + "_M_" + qmqNumber + "_" + "T");
                        } else if ( qmqType.equals("SINGLE") ) {
                            qstnTags.add(qstnId + "_M_" + qmqNumber + "_" + "S");
                        } else if ( qmqType.equals("DATA") ) {
                            qstnTags.add(qstnId + "_M_" + qmqNumber + "_" + "N");         // to holdnumeric portion
                            qstnTags.add(qstnId + "_M_" + qmqNumber + "_" + "D");         // to hold drop-down portion
                        }
                    }
                } else if ( qType.equals("SORT") ) {
                    qstnTags.add( qstnId );
                }
            }
            
            return this.li_questionTags = qstnTags;
        }
        
        public Map<String, String> buildQuestionTypeMap() {
            Map<String, String> qtypeMap = new HashMap<String, String>();
            
            List<QuestionDataSetInfo> qns = this.getListOfQuestions();
            for ( Iterator<QuestionDataSetInfo> qt = qns.iterator(); qt.hasNext(); ) {
                QuestionDataSetInfo qn = qt.next();
                String qType = qn.getQst_type();
                String qstnId = String.valueOf(qn.getQst_id());
                qtypeMap.put(qstnId, qType);
                
                if ( qType.equals("MULTI") ) {
                    List<MultiQuestionDataSetInfo> mqInfo = qn.getMultiQuestionInfo();
                    for (Iterator<MultiQuestionDataSetInfo> mt = mqInfo.iterator(); mt.hasNext(); ) {
                        MultiQuestionDataSetInfo qmqInfo = mt.next();
                        String qmqNumber = qmqInfo.getQmq_number();
                        String qmqType = qmqInfo.getQmq_type();
                        qtypeMap.put(qstnId + "_" + qmqNumber, qmqType);
                    }
                }
            }
            return this.mp_qTypeMap = qtypeMap;
        }
        
        
        public List<Integer> getLi_sourceIds() {
            List<Integer> srcs = null;
            
            if ( this.getSourcesDataSetMap() != null ) {
                srcs = new ArrayList<Integer>();
                Set<Integer> sIdsSet = this.getSourcesDataSetMap().keySet();
                for ( Iterator<Integer> it = sIdsSet.iterator(); it.hasNext(); ) {
                    srcs.add(it.next());
                }
                Collections.sort(srcs);
            }
            
            return srcs;
        }
        
        public List<String> getLi_SourceNames() {
            List<String> srcNames = null;
            if ( this.getSourcesDataSetMap() != null ) {
                srcNames = new ArrayList<String>();
                Collection<SourceDataSetInfo> sset = this.getSourcesDataSetMap().values();
                for ( Iterator<SourceDataSetInfo> it = sset.iterator(); it.hasNext(); ) {
                   srcNames.add( it.next().getSrc_display_name() );
                }
            }
            
            return srcNames;
        }
        
        
        public List<Integer> getLi_questionIds() {
            List<Integer> qstnIds = null;
            
            if ( this.getListOfQuestions() != null ) {
                qstnIds = new ArrayList<Integer>();
                List<QuestionDataSetInfo> qInfo = this.getListOfQuestions();
                
                for ( Iterator<QuestionDataSetInfo> it = qInfo.iterator(); it.hasNext(); ) {
                    QuestionDataSetInfo q = it.next();
                    int qId =  q.getQst_id();
                    qstnIds.add( qId );
                }
                
                Collections.sort(qstnIds);
            }
            
            return qstnIds;
        }
        
        public List<Integer> getLi_RepSourceIds() {
            List<Integer> repSrcIds = null;
            
            if ( this.getListOfSources() != null ) {
                repSrcIds = new ArrayList<Integer>();
                List<SourceDataSetInfo> srcs = this.getListOfSources();
                for ( Iterator<SourceDataSetInfo> it = srcs.iterator(); it.hasNext(); ) {
                    SourceDataSetInfo src = it.next();
                    if ( src != null )
                        repSrcIds.add(src.getRps_id());
                }
            }
            
            return repSrcIds;
        }
        
        
        public Map<Integer, Integer> getMap_RepSrcId_SrcId() {
            Map<Integer, Integer> theMap = new HashMap<Integer, Integer>();
            if ( this.listOfSources != null && this.listOfSources.size() > 0 ) {
LOG.info("in getMap_RepSrcId_SrcId this.listOfSources size is " + this.listOfSources.size());            
                for ( Iterator<SourceDataSetInfo> it = this.listOfSources.iterator(); it.hasNext(); ) {
                    SourceDataSetInfo sid = it.next();
                    LOG.info("theMap.put(sid.getRps_id(), sid.getSrc_id() ==> " + sid.getRps_id() + ", "  + sid.getSrc_id());                    
                    theMap.put( sid.getRps_id(), sid.getSrc_id() );
                }
            }
            return theMap;
        }
        
        
        
    public Map<String, Integer> getMp_ReprtrInit_ReprtrIdMap() {
        return this.mp_ReprtrInit_ReprtrIdMap;
    }
    
    
    public void setMp_ReprtrInit_ReprtrIdMap(Map<String, Integer> map_ReprtrInit_ReprtrIdMap) {
        this.mp_ReprtrInit_ReprtrIdMap = map_ReprtrInit_ReprtrIdMap;
    }
    
    
    public Map<String, Integer> buildRprtrInit_RprtrIdMap() {
        Map<String, Integer> theMap = new HashMap<String, Integer>();
        if ( this.listOfSources != null && this.listOfSources.size() > 0 ) {
            for ( Iterator<SourceDataSetInfo> it = this.listOfSources.iterator(); it.hasNext(); ) {
                SourceDataSetInfo sid = it.next();
                LOG.info("theMap.put(sid.getRps_id(), sid.getSrc_id() ==> " + sid.getRps_id() + ", "  + sid.getSrc_id());                    
                theMap.put( sid.getEmp_init(), sid.getRps_rptr_id()  );
            }
        }
        return theMap;
    }
    
//    ssc_rps_id ( and ssc_scv_id?)     BAwaWEb_SOURCE_SORTING_CRITERIA
    public Set<Integer> setOfSourceSortingCriteriaLocks = new TreeSet<Integer>();
    public Set<Integer> getSetOfSourceSortingCriteriaLocks() {
        return this.setOfSourceSortingCriteriaLocks;
    }
    public void setSetOfSourceSortingCriteriaLocks(Set<Integer> theSet) {
        this.setOfSourceSortingCriteriaLocks = theSet;
    }
    
//    scv_id		BAwaWEb_SORTING_CRITERIA_VALUES
    public Set<Integer> setOfSortingCriteriaValueLocks = new TreeSet<Integer>();
    public Set<Integer> getSetOfSortingCriteriaValueLocks() {
        return this.setOfSortingCriteriaValueLocks;
    }
    public void setSetOfSortingCriteriaValueLocks(Set<Integer> theSet) {
        this.setOfSortingCriteriaValueLocks = theSet;
    }
    
//    rav_id          BAwaWEb_REPORT_ANSWER_SET_VALUES    
    private Set<Integer> setOfReportAnswerSetValuesLocks = new TreeSet<Integer>(); 
    public Set<Integer> getSetOfReportAnswerSetValuesLocks() {
        return this.setOfReportAnswerSetValuesLocks;
    }
    public void setSetOfReportAnswerSetValuesLocks(Set<Integer> theSet) {
        this.setOfReportAnswerSetValuesLocks = theSet;
    }
    
//    sra_id          BAwaWEb_SOURCE_ANSWERS      
    private Set<Integer> setOfSourceAnswersLocks = new TreeSet<Integer>(); 
    public Set<Integer> getSetOfSourceAnswersLocks() {
        return this.setOfSourceAnswersLocks;
    }
    public void setSetOfSourceAnswersLocks(Set<Integer> theSet) {
        this.setOfSourceAnswersLocks = theSet;
    }
    
//    sma_sra_id      BAwaWEb_SOURCE_MULTI_ANSWERS
    private Set<Integer> setOfSourceMultiAnswersLocks = new TreeSet<Integer>(); 
    public Set<Integer> getSetOfSourceMultiAnswersLocks() {
        return this.setOfSourceMultiAnswersLocks;
    }
    public void setSetOfSourceMultiAnswersLocks(Set<Integer> theSet) {
        this.setOfSourceMultiAnswersLocks = theSet;
    }
//    qmq_qst_id      BAwaWEb_QUESTIONS
    private Set<Integer> setOfQuestionsLocks = new TreeSet<Integer>();
    public Set<Integer> getSetOfQuestionsLocks() {
        return this.setOfQuestionsLocks;
    }
    public void setSetOfQuestionsLocks(Set<Integer> theSet) {
        this.setOfQuestionsLocks = theSet;
    }
    
//    qmq_id          BAwaWEb_MULTI_QUESTIONS
    private Set<Integer> setOfMultiQuestionsLocks = new TreeSet<Integer>();
    public Set<Integer> getSetOfMultiQuestionsLocks() {
        return this.setOfMultiQuestionsLocks;
    }
    public void setSetOfMultiQuestionsLocks(Set<Integer> theSet) {
        this.setOfMultiQuestionsLocks = theSet;
    }
    
    
    public void buildLocks() {
        if (this.listOfSourceAnswers != null) {
            for (Iterator<SourceAnswersDataSetInfo> it =  this.listOfSourceAnswers.iterator(); it.hasNext(); ) {
                SourceAnswersDataSetInfo sad = it.next();
                int qstid = sad.getQst_id();
                String qstType = sad.getQst_type();
                
                if ( qstType.equalsIgnoreCase( "MULTI" )) {
                    String qmqtype = sad.getQmq_Qst_Type();
                    /**
                     * AND (
    rav_id not in ( select otl_tab_id from bawaweb_tab_locks where otl_tab_name = 'BAwaWEb_REPORT_ANSWER_SET_VALUES' and otl_empl_id = :empl_id )
 AND q2.qmq_id not in ( select otl_tab_id from bawaweb_tab_locks where otl_tab_name = 'BAwaWEb_MULTI_QUESTIONS' and otl_empl_id = :empl_id )
 AND sma_sra_id not in ( select otl_tab_id from bawaweb_tab_locks where otl_tab_name = 'BAwaWEb_SOURCE_MULTI_ANSWERS' and otl_empl_id = :empl_id )
 AND sra_id not in   ( select otl_tab_id from bawaweb_tab_locks where otl_tab_name = 'BAwaWEb_SOURCE_ANSWERS' and otl_empl_id = :empl_id )
 AND q1.qmq_qst_id not in ( select otl_tab_id from bawaweb_tab_locks where otl_tab_name = 'BAwaWEb_QUESTIONS' and otl_empl_id = :empl_id )    
) 
                     */
                     if ( qmqtype.equalsIgnoreCase("SINGLE")) {
                         int rav_id = sad.getRav_Id();
                         if ( rav_id != 0 )
                         this.setOfReportAnswerSetValuesLocks.add(rav_id);
                     }
                    
                     int qmq_id = sad.getQmq_id();
                     this.setOfMultiQuestionsLocks.add( qmq_id );
                     
                     int sma_sra_id = sad.getSma_sra_id();                     
                     int sra_id = sad.getSra_Id();
                     if ( sra_id == sma_sra_id ) {
                        this.setOfSourceMultiAnswersLocks.add( sma_sra_id );
                        this.setOfSourceAnswersLocks.add( sra_id );
                     } else {LOG.info("ERRRR sra_id <> sma_sra_id sra_id is " + sra_id + " and sma_sra_id is " + sma_sra_id); }
                     
                     int qmq_qst_id = sad.getQmq_Qst_Id();
                     if ( qstid == qmq_qst_id ) {
                        this.setOfQuestionsLocks.add( qmq_qst_id );
                     } else {LOG.info("ERRRR qstid <> qmq_qst_id qstid is " + qstid + " and qmq_qst_id is " + qmq_qst_id); }
                     
                } else if ( qstType.equalsIgnoreCase( "SORT" )) {
                    /**
                     * AND ( scv.scv_id not in ( select otl_tab_id from bawaweb_tab_locks where otl_tab_name = 'BAwaWEb_SORTING_CRITERIA_VALUES' and otl_empl_id = :empl_id )
    AND ssc.ssc_rps_id not in (select otl_tab_id from bawaweb_tab_locks where otl_tab_name = 'BAwaWEb_SOURCE_SORTING_CRITERIA' and otl_empl_id = :empl_id )
) 
                     */
                     int scv_id = sad.getScv_Id();
                     this.setOfSortingCriteriaValueLocks.add( scv_id );
                     
                     int ssc_rps_id = sad.getRps_id();
                     this.setOfSourceSortingCriteriaLocks.add( ssc_rps_id );
                     
                } else if ( qstType.equalsIgnoreCase( "SINGLE") ) {
                               
                       /**
                        * 
                        * AND (
    rav.rav_id not in ( select otl_tab_id from bawaweb_tab_locks where otl_tab_name = 'BAwaWEb_REPORT_ANSWER_SET_VALUES' and otl_empl_id = :empl_id)
    AND sra.sra_id not in ( select otl_tab_id from bawaweb_tab_locks where otl_tab_name = 'BAwaWEb_SOURCE_ANSWERS' and otl_empl_id = :empl_id)
) 
                        */
                        // no rav_id for data, text and weight
                        int rav_id = sad.getRav_Id();
                        this.setOfReportAnswerSetValuesLocks.add(rav_id);
                         
                        int sra_id = sad.getSra_Id();
                        this.setOfSourceAnswersLocks.add( sra_id );
                         
                        
                        
                        
                } else if ( qstType.equalsIgnoreCase( "WEIGHT" )  || 
                               qstType.equalsIgnoreCase( "TEXT" )    || 
                               qstType.equalsIgnoreCase( "DATA" )    || 
                               qstType.equalsIgnoreCase( "RATING" )  ) {
                    // no rav_id for data, text and weight
                          
                        int sra_id = sad.getSra_Id();
                        this.setOfSourceAnswersLocks.add( sra_id );
                }
        
            }
        }
    }
    
    private Map<Integer, Integer> mp_QstId_RASId = new HashMap<Integer, Integer>();
    public void setMp_QstId_RASId(Map<Integer, Integer> mp_) {
        this.mp_QstId_RASId = mp_;
    }
    public Map<Integer, Integer> getMp_QstId_RASId() {
        return this.mp_QstId_RASId;
    }
    
    public Map<Integer, Integer> buildMp_QstId_RASIdMap() {
        Map<Integer, Integer> qstIdRASMap = new HashMap<Integer, Integer>();
        
        List<QuestionDataSetInfo> qns = this.getListOfQuestions();
        for ( Iterator<QuestionDataSetInfo> qt = qns.iterator(); qt.hasNext(); ) {
            QuestionDataSetInfo qn = qt.next();
            String qType = qn.getQst_type();
            if ( qType.equalsIgnoreCase("SINGLE")) {
                int qstId = qn.getQst_id();
                int rasId = qn.getQst_ras_id();
                qstIdRASMap.put( qstId, rasId );
            }
        }
        return this.mp_QstId_RASId = qstIdRASMap;
    }
    
    // l8r make it to build locks combine buildReportAnswerSetValuesLocks & buildSourceAnswersLocks
    public Set<Integer> buildSourceSortingCriteriaLocks() {
        if (this.listOfSourceAnswers != null) {
            for (Iterator<SourceAnswersDataSetInfo> it = this.listOfSourceAnswers.iterator(); it.hasNext(); ) {
                SourceAnswersDataSetInfo sad = it.next();
                int scvId = sad.getScv_Id();
                if (scvId != 0 && !this.setOfSourceSortingCriteriaLocks.contains(scvId))
                    this.setOfSourceSortingCriteriaLocks.add(scvId);
            }

        }
        return this.setOfSourceSortingCriteriaLocks;
    }
    
    public Set<Integer>  buildSortingCriteriaValuesLocks() {
        if (this.listOfSourceAnswers != null) {
            for (Iterator<SourceAnswersDataSetInfo> it =  this.listOfSourceAnswers.iterator(); it.hasNext(); ) {
                SourceAnswersDataSetInfo sad = it.next();
                int ssc_rps_id = sad.getRps_id();//.getScv_Id();
                if (ssc_rps_id != 0 && !this.setOfSortingCriteriaValueLocks.contains(ssc_rps_id))
                    this.setOfSortingCriteriaValueLocks.add(ssc_rps_id);
            }

        }
        return this.setOfSortingCriteriaValueLocks;
    }

//    rav_id          BAwaWEb_REPORT_ANSWER_SET_VALUES    
    public Set<Integer> buildReportAnswerSetValuesLocks() {
        if ( this.listOfSourceAnswers != null ) {
            for ( Iterator<SourceAnswersDataSetInfo> it = this.listOfSourceAnswers.iterator(); it.hasNext(); ) {
                SourceAnswersDataSetInfo sad = it.next();
                int ravId = sad.getRav_Id();
                if ( ravId != 0  && !this.setOfReportAnswerSetValuesLocks.contains( ravId ) )       
                    this.setOfReportAnswerSetValuesLocks.add( ravId );
            }
            
        }
        return this.setOfReportAnswerSetValuesLocks;
    }
    
    public Set<Integer> buildSourceAnswersLocks() {
        if ( this.listOfSourceAnswers != null ) {
            for ( Iterator<SourceAnswersDataSetInfo> it = this.listOfSourceAnswers.iterator(); it.hasNext(); ) {
                SourceAnswersDataSetInfo sad = it.next();
                int sraId = sad.getSra_Id();
                if ( sraId != 0 && !this.setOfSourceAnswersLocks.contains( sraId ))   
                    this.setOfSourceAnswersLocks.add( sraId );
            }
            
        }
        return this.setOfSourceAnswersLocks;
    }
    
    
    
    public  List<QuestionDataSetInfo> getListOfQuestionsForAdditionalAnswers() {
        return this.listOfQuestionsForAdditionalAnswers;
    }
    
    public void setListOfQuestionsForAdditionalAnswers( List<QuestionDataSetInfo> qstns) {
        this.listOfQuestionsForAdditionalAnswers = qstns;
    }
    
    

    public void setSourceDisplayNameStyle(String style) {
        this.sourceDisplayNameStyle = style;
    }
    
    public String getSourceDisplayNameStyle() {
        return this.sourceDisplayNameStyle;
    }
    
    
    public List<String> getCourtesyTitles() {
        return this.courtesyTitles;
    }
    
    public void setCourtesyTitles(List<String> alist) {
        this.courtesyTitles = alist;
    }
    
    
    public List<String> getSuffixTitles() {
        return this.suffixTitles;
    }
    
    public void setSuffixTitles(List<String> alist) {
        this.suffixTitles = alist;
    }
    

    public Map<String, Integer>  getCountriesMap() {
        return this.mp_ctryName_CtryIds;
    }
    public void setCountriesMap(Map<String, Integer> map) {
        this.mp_ctryName_CtryIds = map;
    }


    public void setTimeZonesMap(LinkedHashMap<String, Integer> aMap) {
        this.mp_tmzId_tmzNameDesc = aMap;
    }
    public LinkedHashMap<String, Integer> getTimeZonesMap() {
        return this.mp_tmzId_tmzNameDesc;
    }
    

    public void setIndustryViewsMap(LinkedHashMap<String, String> aMap) {
        this.mp_indDesc_indCode = aMap;
    }
    public LinkedHashMap<String, String> getIndustryViewsMap() {
        return this.mp_indDesc_indCode;
    }
    
    public void setQualityRatingsMap(LinkedHashMap<String, String> aMap) {
        this.mp_QualityRatingDesc_Code = aMap;
    }
    
    public LinkedHashMap<String, String> getQualityRatingsMap() {
        return this.mp_QualityRatingDesc_Code;
    }
    

    public void setSourceDistributionPreferencesMap(LinkedHashMap<String, String> aMap) {
        this.mp_SourceDistributionPrefsDesc_Code= aMap;
    }
    
    public LinkedHashMap<String, String> getSourceDistributionPreferencesMap() {
        return this.mp_SourceDistributionPrefsDesc_Code;
    }
 
        
}
