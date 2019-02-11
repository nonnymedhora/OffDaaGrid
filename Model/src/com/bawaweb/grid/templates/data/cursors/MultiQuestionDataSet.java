/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.cursors;

import com.bawaweb.grid.templates.data.tables.AnswerSetValuesDataSetInfo;

import com.bawaweb.grid.templates.data.tables.ReportAnswerSetValuesDataSetInfo;
import com.bawaweb.grid.templates.data.tables.TallyRangeLimitsValuesDataSetInfo;

import java.util.List;

public class MultiQuestionDataSet implements MultiQuestionDataSetInfo {
	/*maps to
	-- Cursor to find details of multi-question parts
    CURSOR cur_qmq(p_qst_id bawaweb_questions.qst_id%TYPE) IS
    */  
	
	private int		qmq_id;
	private String	        qmq_type;
	private String	        qmq_hint;
	private int		qmq_ras_id;
	private int		qmq_tly_id;
	private int		ras_frid_id;
        private String          qmq_number;
        private int             qmq_qst_id;     // qst-id in bawaweb_questions
        
        private String[]        dataTallyOptions;
        
    
        private List<ReportAnswerSetValuesDataSetInfo> singleAnswerSetsInfo;
        
        private List<TallyRangeLimitsValuesDataSetInfo> tallyRangeLimitsValuesDataSetInfo;
	
        
        public MultiQuestionDataSet() {}
        
	public MultiQuestionDataSet(int qmq_id, int qmq_qst_id, String qmqnumber, String qmq_type, String qmq_hint, int qmq_ras_id, int qmq_tly_id, int ras_frid_id) {
		super();
		this.qmq_id = qmq_id;
                this.qmq_qst_id = qmq_qst_id;
		this.qmq_type = qmq_type;
		this.qmq_hint = qmq_hint;
		this.qmq_ras_id = qmq_ras_id;
		this.qmq_tly_id = qmq_tly_id;
		this.ras_frid_id = ras_frid_id;
                this.qmq_number = qmqnumber;
	}

	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.MultiQuestionDataSetInfo#getQmq_hint()
	 */
	public String getQmq_hint() {
		return qmq_hint;
	}

	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.MultiQuestionDataSetInfo#setQmq_hint(java.lang.String)
	 */
	public void setQmq_hint(String qmq_hint) {
		this.qmq_hint = qmq_hint;
	}

	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.MultiQuestionDataSetInfo#getQmq_id()
	 */
	public int getQmq_id() {
		return qmq_id;
	}

	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.MultiQuestionDataSetInfo#setQmq_id(int)
	 */
	public void setQmq_id(int qmq_id) {
		this.qmq_id = qmq_id;
	}

	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.MultiQuestionDataSetInfo#getQmq_ras_id()
	 */
	public int getQmq_ras_id() {
		return qmq_ras_id;
	}

	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.MultiQuestionDataSetInfo#setQmq_ras_id(int)
	 */
	public void setQmq_ras_id(int qmq_ras_id) {
		this.qmq_ras_id = qmq_ras_id;
	}

	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.MultiQuestionDataSetInfo#getQmq_tly_id()
	 */
	public int getQmq_tly_id() {
		return qmq_tly_id;
	}

	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.MultiQuestionDataSetInfo#setQmq_tly_id(int)
	 */
	public void setQmq_tly_id(int qmq_tly_id) {
		this.qmq_tly_id = qmq_tly_id;
	}

	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.MultiQuestionDataSetInfo#getQmq_type()
	 */
	public String getQmq_type() {
		return qmq_type;
	}

	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.MultiQuestionDataSetInfo#setQmq_type(java.lang.String)
	 */
	public void setQmq_type(String qmq_type) {
		this.qmq_type = qmq_type;
	}

	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.MultiQuestionDataSetInfo#getRas_frid_id()
	 */
	public int getRas_frid_id() {
		return ras_frid_id;
	}

	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.MultiQuestionDataSetInfo#setRas_frid_id(int)
	 */
	public void setRas_frid_id(int ras_frid_id) {
		this.ras_frid_id = ras_frid_id;
	}
	

        
        public String getQmq_number() {
            return this.qmq_number;
        }
        
        public void setQmq_number(String number) {
            this.qmq_number = number;
        }
        
        
        public int getQmq_qst_id() {
                return qmq_qst_id;
        }
    
        /* (non-Javadoc)
         * @see com.bawaweb.grid.templates.data.MultiQuestionDataSetInfo#setQmq_id(int)
         */
        public void setQmq__qst_id(int qmq_id) {
                this.qmq_qst_id = qmq_id;
        }
        
    
        public List<ReportAnswerSetValuesDataSetInfo> getSingleAnswerSetsInfo() {
            return this.singleAnswerSetsInfo;
        }
        
        public void setSingleAnswerSetsInfo (List<ReportAnswerSetValuesDataSetInfo> info) {
            this.singleAnswerSetsInfo = info;
        }
        
        
        public List<TallyRangeLimitsValuesDataSetInfo> getTallyRangeLimitsValuesDataSetInfo() {
            return this.tallyRangeLimitsValuesDataSetInfo;
        }
        
        public void setTallyRangeLimitsValuesDataSetInfo(List<TallyRangeLimitsValuesDataSetInfo> tally) {
            this.tallyRangeLimitsValuesDataSetInfo = tally;
        }
        
        
        public void setDataTallyOptions(String[] options) {
            this.dataTallyOptions = options;
        }
        
        
        public String[] getDataTallyOptions() {
            return this.dataTallyOptions;
        }
        
        
        public String toString() {
            StringBuffer buff = new StringBuffer();
            buff.append("qmq_id --> " + this.qmq_id + "\n");
            buff.append("qmq_type --> " + this.qmq_type + "\n");
            buff.append("qmq_hint --> " + this.qmq_hint + "\n");
            buff.append("qmq_ras_id --> " + this.qmq_ras_id + "\n");
            buff.append("qmq_tly_id --> " + this.qmq_tly_id + "\n");
            buff.append("ras_frid_id --> " + this.ras_frid_id + "\n");
            buff.append("qmq_number --> " + this.qmq_number + "\n");
            buff.append("qmq_qst_id --> " + this.qmq_qst_id + "\n");
            
            if ( this.dataTallyOptions != null ) {
                for ( int i = 0 ; i < this.dataTallyOptions.length; i++ ) {
                    buff.append("dataTallyoption [" + i + "] --> " + this.dataTallyOptions[i] + "\n");
                }
            }
            
            return buff.toString();
        }
        

}
