/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.tables;

public class ReportTypesDataSet {
	// maps to table rtyp_report_types
	
	private int rtyp_id;
	private String	rtyp_desc;
	private String	rtyp_limit_number;
	private int	rtyp_display_seq;
	private int	rtyp_interview_days;
	private int	rtyp_tally_days;
	
	public String getRtyp_desc() {
		return rtyp_desc;
	}
	public void setRtyp_desc(String rtyp_desc) {
		this.rtyp_desc = rtyp_desc;
	}
	public int getRtyp_display_seq() {
		return rtyp_display_seq;
	}
	public void setRtyp_display_seq(int rtyp_display_seq) {
		this.rtyp_display_seq = rtyp_display_seq;
	}
	public int getRtyp_id() {
		return rtyp_id;
	}
	public void setRtyp_id(int rtyp_id) {
		this.rtyp_id = rtyp_id;
	}
	public int getRtyp_interview_days() {
		return rtyp_interview_days;
	}
	public void setRtyp_interview_days(int rtyp_interview_days) {
		this.rtyp_interview_days = rtyp_interview_days;
	}
	public String getRtyp_limit_number() {
		return rtyp_limit_number;
	}
	public void setRtyp_limit_number(String rtyp_limit_number) {
		this.rtyp_limit_number = rtyp_limit_number;
	}
	public int getRtyp_tally_days() {
		return rtyp_tally_days;
	}
	public void setRtyp_tally_days(int rtyp_tally_days) {
		this.rtyp_tally_days = rtyp_tally_days;
	}
	
	

}
