/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.cursors;

import com.bawaweb.grid.templates.data.tables.AnswerSetValuesDataSetInfo;

import com.bawaweb.grid.templates.data.tables.ReportAnswerSetValuesDataSetInfo;
import com.bawaweb.grid.templates.data.tables.TallyRangeLimitsValuesDataSetInfo;

import java.util.List;

public interface MultiQuestionDataSetInfo{
	/*maps to
	-- Cursor to find details of multi-question parts
    CURSOR cur_qmq(p_qst_id bawaweb_questions.qst_id%TYPE) IS
    */  
	
	public abstract String getQmq_hint();

	public abstract void setQmq_hint(String qmq_hint);

	public abstract int getQmq_id();

	public abstract void setQmq_id(int qmq_id);

	public abstract int getQmq_ras_id();

	public abstract void setQmq_ras_id(int qmq_ras_id);

	public abstract int getQmq_tly_id();

	public abstract void setQmq_tly_id(int qmq_tly_id);

	public abstract String getQmq_type();

	public abstract void setQmq_type(String qmq_type);

	public abstract int getRas_frid_id();

	public abstract void setRas_frid_id(int ras_frid_id);
        
        public abstract String getQmq_number();
        
        public abstract void setQmq_number(String number);
        
        
        public int getQmq_qst_id();
        public void setQmq__qst_id(int qmq_id);
        
        public List<ReportAnswerSetValuesDataSetInfo> getSingleAnswerSetsInfo();
        
        public void setSingleAnswerSetsInfo (List<ReportAnswerSetValuesDataSetInfo> info);
        
        public List<TallyRangeLimitsValuesDataSetInfo> getTallyRangeLimitsValuesDataSetInfo();
        public void setTallyRangeLimitsValuesDataSetInfo(List<TallyRangeLimitsValuesDataSetInfo> tally);

        public void setDataTallyOptions(String[] dataTallyOptions);
        public String[] getDataTallyOptions();
        
        public String toString();
    
}
