/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.tables;

public interface SourceAnswerDataInfo {
	// maps to table bawaweb_source_answers

	public abstract String getSra_answer();

	public abstract void setSra_answer(String sra_answer);

	public abstract String getSra_answer_text();

	public abstract void setSra_answer_text(String sra_answer_text);

	public abstract int getSra_asv_id();

	public abstract void setSra_asv_id(int sra_asv_id);

	public abstract String getSra_color();

	public abstract void setSra_color(String sra_color);

	public abstract String getSra_comment();

	public abstract void setSra_comment(String sra_comment);

	public abstract String getSra_exclude_yn();

	public abstract void setSra_exclude_yn(String sra_exclude_yn);

	public abstract int getSra_id();

	public abstract void setSra_id(int sra_id);

	public abstract int getSra_qst_id();

	public abstract void setSra_qst_id(int sra_qst_id);

	public abstract int getSra_rav_id();

	public abstract void setSra_rav_id(int sra_rav_id);

	public abstract int getSra_rps_id();

	public abstract void setSra_rps_id(int sra_rps_id);

	public abstract int getSra_weight_multiplier();

	public abstract void setSra_weight_multiplier(int sra_weight_multiplier);

}