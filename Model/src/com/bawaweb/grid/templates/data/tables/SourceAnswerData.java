/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.tables;

public class SourceAnswerData implements SourceAnswerDataInfo {
	// maps to table bawaweb_source_answers
	private int	sra_id;
	private int	sra_qst_id;
	private int	sra_rps_id;
	private String	sra_answer;
	private String	sra_answer_text;
	private int	sra_asv_id;
	private String	sra_exclude_yn;
	private int	sra_weight_multiplier;
	private int	sra_rav_id;
	private String	sra_color;
	private String	sra_comment;
	
	public SourceAnswerData() {}
	
	
	public SourceAnswerData(int sra_id, int sra_qst_id, int sra_rps_id, String sra_answer, String sra_answer_text, int sra_asv_id, String sra_exclude_yn, int sra_weight_multiplier, int sra_rav_id, String sra_color, String sra_comment) {
		this.sra_id = sra_id;
		this.sra_qst_id = sra_qst_id;
		this.sra_rps_id = sra_rps_id;
		this.sra_answer = sra_answer;
		this.sra_answer_text = sra_answer_text;
		this.sra_asv_id = sra_asv_id;
		this.sra_exclude_yn = sra_exclude_yn;
		this.sra_weight_multiplier = sra_weight_multiplier;
		this.sra_rav_id = sra_rav_id;
		this.sra_color = sra_color;
		this.sra_comment = sra_comment;
	}


	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.SourceAnswerDataInfo#getSra_answer()
	 */
	public String getSra_answer() {
		return sra_answer;
	}


	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.SourceAnswerDataInfo#setSra_answer(java.lang.String)
	 */
	public void setSra_answer(String sra_answer) {
		this.sra_answer = sra_answer;
	}


	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.SourceAnswerDataInfo#getSra_answer_text()
	 */
	public String getSra_answer_text() {
		return sra_answer_text;
	}


	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.SourceAnswerDataInfo#setSra_answer_text(java.lang.String)
	 */
	public void setSra_answer_text(String sra_answer_text) {
		this.sra_answer_text = sra_answer_text;
	}


	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.SourceAnswerDataInfo#getSra_asv_id()
	 */
	public int getSra_asv_id() {
		return sra_asv_id;
	}


	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.SourceAnswerDataInfo#setSra_asv_id(int)
	 */
	public void setSra_asv_id(int sra_asv_id) {
		this.sra_asv_id = sra_asv_id;
	}


	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.SourceAnswerDataInfo#getSra_color()
	 */
	public String getSra_color() {
		return sra_color;
	}


	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.SourceAnswerDataInfo#setSra_color(java.lang.String)
	 */
	public void setSra_color(String sra_color) {
		this.sra_color = sra_color;
	}


	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.SourceAnswerDataInfo#getSra_comment()
	 */
	public String getSra_comment() {
		return sra_comment;
	}


	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.SourceAnswerDataInfo#setSra_comment(java.lang.String)
	 */
	public void setSra_comment(String sra_comment) {
		this.sra_comment = sra_comment;
	}


	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.SourceAnswerDataInfo#getSra_exclude_yn()
	 */
	public String getSra_exclude_yn() {
		return sra_exclude_yn;
	}


	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.SourceAnswerDataInfo#setSra_exclude_yn(java.lang.String)
	 */
	public void setSra_exclude_yn(String sra_exclude_yn) {
		this.sra_exclude_yn = sra_exclude_yn;
	}


	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.SourceAnswerDataInfo#getSra_id()
	 */
	public int getSra_id() {
		return sra_id;
	}


	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.SourceAnswerDataInfo#setSra_id(int)
	 */
	public void setSra_id(int sra_id) {
		this.sra_id = sra_id;
	}


	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.SourceAnswerDataInfo#getSra_qst_id()
	 */
	public int getSra_qst_id() {
		return sra_qst_id;
	}


	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.SourceAnswerDataInfo#setSra_qst_id(int)
	 */
	public void setSra_qst_id(int sra_qst_id) {
		this.sra_qst_id = sra_qst_id;
	}


	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.SourceAnswerDataInfo#getSra_rav_id()
	 */
	public int getSra_rav_id() {
		return sra_rav_id;
	}


	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.SourceAnswerDataInfo#setSra_rav_id(int)
	 */
	public void setSra_rav_id(int sra_rav_id) {
		this.sra_rav_id = sra_rav_id;
	}


	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.SourceAnswerDataInfo#getSra_rps_id()
	 */
	public int getSra_rps_id() {
		return sra_rps_id;
	}


	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.SourceAnswerDataInfo#setSra_rps_id(int)
	 */
	public void setSra_rps_id(int sra_rps_id) {
		this.sra_rps_id = sra_rps_id;
	}


	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.SourceAnswerDataInfo#getSra_weight_multiplier()
	 */
	public int getSra_weight_multiplier() {
		return sra_weight_multiplier;
	}


	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.SourceAnswerDataInfo#setSra_weight_multiplier(int)
	 */
	public void setSra_weight_multiplier(int sra_weight_multiplier) {
		this.sra_weight_multiplier = sra_weight_multiplier;
	}
	
	
	
	

	

}
