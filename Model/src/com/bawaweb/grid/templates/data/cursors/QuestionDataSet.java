/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.cursors;

import com.bawaweb.grid.templates.data.tables.AnswerSetValuesDataSetInfo;

import com.bawaweb.grid.templates.data.tables.AnswerSetsDataSetInfo;
import com.bawaweb.grid.templates.data.tables.ReportAnswerSetValuesDataSetInfo;
import com.bawaweb.grid.templates.data.tables.SortingCriteriaValuesDataSetInfo;

import com.bawaweb.grid.templates.data.tables.TallyRangeLimitsValuesDataSetInfo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

import java.util.List;

import java.util.Map;
import java.util.Set;

import jxl.Range;


public class QuestionDataSet implements QuestionDataSetInfo {

	// maps to CURSOR cur_qst(p_rprt_id rprt_reports.rprt_id%TYPE) IS
        // in ota-excel answers_grid
	
	public QuestionDataSet() {}
        
        private List<MultiQuestionDataSetInfo> multiQuestionInfo;
        
        private List<ReportAnswerSetValuesDataSetInfo> singleAnswerSetsInfo;
        
        private List<SortingCriteriaValuesDataSetInfo> sortCriteriaDataSetInfo;
        
        // for numeric questions apart from the usual data tally options
        private List<TallyRangeLimitsValuesDataSetInfo> tallyRangeLimitsValuesDataSetInfo;
        
        private String[] dataTallyOptions;
        
        private AnswerSetsDataSetInfo ansSetInfo;
        
        private List<String> extraAnswerSetValues;

//	public MultiQuestionDataSetInfo getQmqDataSet() {
//		return qmqDataSet;
//	}
//
//	public void setQmqDataSet(MultiQuestionDataSetInfo qmqDataSet) {
//		this.qmqDataSet = qmqDataSet;
//	}
	
	public QuestionDataSet(Range qRange, String direction) {
		int top_col = qRange.getTopLeft().getColumn();
		int top_row = qRange.getTopLeft().getRow();
		
		int bot_col = qRange.getBottomRight().getColumn();
		int bot_row = qRange.getBottomRight().getRow();
		
		if (direction.equalsIgnoreCase("vertical")) {
			
		} else if (direction.equalsIgnoreCase("horizontal")) {
			
		}
	}

	public QuestionDataSet(int qst_id, String qst_number, String order_by, int qst_numeric, String qst_alpha, String qst_question, String qst_type, int qst_multi_answers, String qst_question_hint, String qst_text_hint, String qst_text_required_yn, int qst_ras_id, int ras_frid_id, int qst_tly_id, int num_cols, List<MultiQuestionDataSetInfo> mQuestionInfo, List <ReportAnswerSetValuesDataSetInfo> sAnswerSetsInfo) { //MultiQuestionDataSetInfo qmqDataSet) {
//		super();
		this.qst_id = qst_id;//System.out.println(this.qst_id);
//		this.qst_number = qst_number;
		this.order_by = order_by;
		this.qst_numeric = qst_numeric;
		this.qst_alpha = qst_alpha;
		this.qst_question = qst_question;//System.out.println(this.qst_question);
		this.qst_type = qst_type;
		this.qst_multi_answers = qst_multi_answers;
		this.qst_question_hint = qst_question_hint;
		this.qst_text_hint = qst_text_hint;
		this.qst_text_required_yn = qst_text_required_yn;
		this.qst_ras_id = qst_ras_id;
		this.ras_frid_id = ras_frid_id;
		this.qst_tly_id = qst_tly_id;
		this.num_cols = num_cols;		
		this.multiQuestionInfo = mQuestionInfo;
                this.singleAnswerSetsInfo  = sAnswerSetsInfo;
	}
	
	public QuestionDataSet(int qst_id, String qst_number, String order_by, int qst_numeric, String qst_alpha, String qst_question, String qst_type, int qst_multi_answers, String qst_question_hint, String qst_text_hint, String qst_text_required_yn, int qst_ras_id, int ras_frid_id, int qst_tly_id, int num_cols) {
		//super();
		this(qst_id, qst_number, order_by, qst_numeric, qst_alpha, qst_question,
				qst_type, qst_multi_answers, qst_question_hint, qst_text_hint, qst_text_required_yn,
				qst_ras_id, ras_frid_id , qst_tly_id, num_cols, null, null);
	}
	
	
    private int qst_id;
//    private String qst_number;
    private String order_by;//qst_type
    private int qst_numeric;   // 1a = 2
    private String qst_alpha;
    private String qst_question;
    private String qst_type;
    private int qst_multi_answers;
    private String qst_question_hint;
    private String qst_text_hint;
    private String qst_text_required_yn;
    private int qst_ras_id;
    private int ras_frid_id;
    private int qst_tly_id;
    private int num_cols;
    
    private int qst_ans_id;
    
    private LinkedHashMap<Integer, SourceAnswersDataSetInfo> sourceAnswersDataSets;
    private Map<String, String> mp_QmqNo_QmqType = new HashMap<String, String>();
    
//    private MultiQuestionDataSetInfo qmqDataSet;
    public int getQst_ans_id() {
        return this.qst_ans_id;
    }
    
    public void setQst_ans_id( int i) {
        this.qst_ans_id = i;
    }
    public int getNum_cols() {
            return num_cols;
    }
    public void setNum_cols(int num_cols) {
            this.num_cols = num_cols;
    }
    public String getOrder_by() {
            return order_by;
    }
    public void setOrder_by(String order_by) {
            this.order_by = order_by;
    }
    public String getQst_alpha() {
            return qst_alpha;
    }
    public void setQst_alpha(String qst_alpha) {
            this.qst_alpha = qst_alpha;
    }
    public int getQst_id() {
            return qst_id;
    }
    public void setQst_id(int qst_id) {
            this.qst_id = qst_id;
    }
    public int getQst_multi_answers() {
            return qst_multi_answers;
    }
    public void setQst_multi_answers(int qst_multi_answers) {
            this.qst_multi_answers = qst_multi_answers;
    }
//    public String getQst_number() {
//            return qst_number;
//    }
//    public void setQst_number(String qst_number) {
//            this.qst_number = qst_number;
//    }
    public int getQst_numeric() {
            return qst_numeric;
    }
    public void setQst_numeric(int qst_numeric) {
            this.qst_numeric = qst_numeric;
    }
    public String getQst_question() {
            return qst_question;
    }
    public void setQst_question(String qst_question) {
            this.qst_question = qst_question;
    }
    public String getQst_question_hint() {
            return qst_question_hint;
    }
    public void setQst_question_hint(String qst_question_hint) {
            this.qst_question_hint = qst_question_hint;
    }
    public String getQst_text_required_yn() {
            return qst_text_required_yn;
    }
    public void setQst_text_required_yn(String qst_text_required_yn) {
            this.qst_text_required_yn = qst_text_required_yn;
    }
    public int getQst_ras_id() {
            return qst_ras_id;
    }
    public void setQst_ras_id(int qst_ras_id) {
            this.qst_ras_id = qst_ras_id;
    }
    public String getQst_text_hint() {
            return qst_text_hint;
    }
    public void setQst_text_hint(String qst_text_hint) {
            this.qst_text_hint = qst_text_hint;
    }
    public int getQst_tly_id() {
            return qst_tly_id;
    }
    public void setQst_tly_id(int qst_tly_id) {
            this.qst_tly_id = qst_tly_id;
    }
    public String getQst_type() {
            return qst_type;
    }
    public void setQst_type(String qst_type) {
            this.qst_type = qst_type;
    }
    public int getRas_frid_id() {
            return ras_frid_id;
    }
    public void setRas_frid_id(int ras_frid_id) {
            this.ras_frid_id = ras_frid_id;
    }

    public void setSourceAnswersDataSets(LinkedHashMap<Integer, SourceAnswersDataSetInfo> _sourceAnswersDataSets) {
        this.sourceAnswersDataSets = _sourceAnswersDataSets;
    }

    public LinkedHashMap<Integer, SourceAnswersDataSetInfo> getSourceAnswersDataSets() {
        return this.sourceAnswersDataSets;
    }
    
    public List<MultiQuestionDataSetInfo> getMultiQuestionInfo() {
        return this.multiQuestionInfo;
    }
    
    public void setMultiQuestionDataSetInfo(List<MultiQuestionDataSetInfo> info) {
        this.multiQuestionInfo = info;
    }
    
    public List<ReportAnswerSetValuesDataSetInfo> getSingleAnswerSetsInfo() {
        return this.singleAnswerSetsInfo;
    }
    
    public void setSingleAnswerSetsInfo (List<ReportAnswerSetValuesDataSetInfo> info) {
        this.singleAnswerSetsInfo = info;
    }
        
    public List<SortingCriteriaValuesDataSetInfo> getSortCriteriaDataSetInfo() {
        return this.sortCriteriaDataSetInfo;
    }
    
    
    public void setSortCriteriaDataSetInfo(List<SortingCriteriaValuesDataSetInfo> _sortCriteriaDataSetInfo) {
        this.sortCriteriaDataSetInfo = _sortCriteriaDataSetInfo;
    }
    
    
    public List<TallyRangeLimitsValuesDataSetInfo> getTallyRangeLimitsValuesDataSetInfo() {
        return this.tallyRangeLimitsValuesDataSetInfo;
    }
    public void setTallyRangeLimitsValuesDataSetInfo(List<TallyRangeLimitsValuesDataSetInfo> _tallyRangeLimitsValuesDataSetInfo) {
        this.tallyRangeLimitsValuesDataSetInfo = _tallyRangeLimitsValuesDataSetInfo;
    }
    

    public void setDataTallyOptions(String[] options) {
        this.dataTallyOptions = options;
    }
    public String[] getDataTallyOptions() {
        return this.dataTallyOptions;
    }
    
    
    public AnswerSetsDataSetInfo getAnswerSetInfo() {
        return this.ansSetInfo;
    }
    
    public void setAnswerSetInfo(AnswerSetsDataSetInfo info) {
        this.ansSetInfo = info;    
    }
    
    
    public void setMpQmqNo_QmqType(Map<String, String> aMap)  {
        if ( this.qst_type.equalsIgnoreCase("MULTI") ) {
            this.mp_QmqNo_QmqType = aMap;
        }
    }
    public Map<String, String> getMpQmqNo_QmqType() {
        if ( this.qst_type.equalsIgnoreCase("MULTI")) {
            Map<String, String> aMap = new HashMap<String, String>();
            List<MultiQuestionDataSetInfo> mQstns = getMultiQuestionInfo();
            for ( Iterator<MultiQuestionDataSetInfo> mt = mQstns.iterator(); mt.hasNext(); ) {
                MultiQuestionDataSetInfo m = mt.next();
                if ( m != null ) {
                    aMap.put( m.getQmq_number(), m.getQmq_type() );
                }
            }
            return aMap;
        }
        return null;
    }
    
    public String toString() {
        StringBuffer buff = new StringBuffer();
        buff.append( "qst_id --> " + this.qst_id + "\n");
        buff.append( "order_by --> " + this.order_by + "\n");
        buff.append( "qst_numeric --> " + this.qst_numeric + "\n");
        buff.append( "qst_alpha --> " + this.qst_alpha + "\n");
        buff.append( "qst_question --> " + this.qst_question + "\n");
        buff.append( "qst_type --> " + this.qst_type + "\n");
        buff.append( "qst_multi_answers --> " + this.qst_multi_answers + "\n");
        buff.append( "qst_question_hint --> " + this.qst_question_hint + "\n");
        buff.append( "qst_text_hint --> " + this.qst_text_hint + "\n");
        buff.append( "qst_text_required_yn --> " + this.qst_text_required_yn + "\n");
        buff.append( "qst_ras_id --> " + this.qst_ras_id + "\n");
        buff.append( "ras_frid_id --> " + this.ras_frid_id + "\n");
        buff.append( "qst_tly_id --> " + this.qst_tly_id + "\n");
        buff.append( "num_cols --> " + this.num_cols + "\n");
        buff.append( "answer set info --> " + this.ansSetInfo + "\n");
        buff.append(" extraAnswerSetValues --> " + this.extraAnswerSetValues + "\n");
        
        if ( this.singleAnswerSetsInfo != null ) {
            for ( Iterator<ReportAnswerSetValuesDataSetInfo> it = this.singleAnswerSetsInfo.iterator(); it.hasNext(); ) {
                ReportAnswerSetValuesDataSetInfo ans = it.next();
                buff.append(ans.toString());
            }
        }
        if (this.sourceAnswersDataSets != null ) {
            Set<Integer> keys = this.sourceAnswersDataSets.keySet();
            for ( Iterator<Integer> it = keys.iterator(); it.hasNext(); ) {
                int srcrepid = it.next();
                SourceAnswersDataSetInfo sad = this.sourceAnswersDataSets.get( srcrepid );
                buff.append("\n\nAns for SrcRepId " + srcrepid + " and qstid " + this.qst_id + " is \n" + sad.toString()+ "\n\n");
            }
        }
        return buff.toString();
    }
    
    
    public List<String> getExtraAnswerSetValues() {
        return this.extraAnswerSetValues;       
    }
    
    public void setExtraAnswerSetValues(List<String> val) {
        this.extraAnswerSetValues = val;
    }
}