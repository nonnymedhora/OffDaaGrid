/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.tables;

public class ReportInfoDataSet {
	// maps to table rprt_reports
	
	private int	rprt_id;
	private String	rprt_desc;
	private String	rprt_pdf;
	private int	rpst_id;
	private int	rtyp_id;
	private int	rptr_id;
	private int	edtr_id;
	private int	rprt_isproprietary;
	private java.sql.Timestamp	rprt_reportdate;
	private java.sql.Timestamp	rprt_duedate;
	private java.sql.Timestamp	rprt_completeddate;
	private String	rprt_prodcode;
	private String	rprt_mktcap;
	private int	rprt_iscofocus;
	private int	rprt_issmallcap;
	private String	rprt_isthumbsup;
	private String	rprt_lastisthumbsup;
	private String	rprt_accuracyindex;
	private String	rprt_highlights;
	private java.sql.Timestamp	last_update_date;
	private int	last_update_by;
	private int	oldid;
	private String	rprt_notes;
	private int	indr_code;
	private String	industry;
	private int	flash_parent;
	private int	rprt_aha;
	private int	is_deleted;
	private int	ivst_id;
	private int	rprt_isclassified;
	private int	frid_id;
	private java.sql.Timestamp	rprt_researchin;
	private java.sql.Timestamp	rprt_intl_duedate;
	private int	rprt_importance_rating;
	private int	rprt_rd_person;
	private int	rprt_prop_appr;
	private int	pan_id;
	private int	rprt_idea_gen_ind;
	private String	rprt_hit_bonus;
	private java.sql.Timestamp	rprt_top_story_off_date;
	private String	rprt_source_display_field;
	private String	rprt_reporters_view_all_yn;
	private String	rprt_source_report;
	private String	rprt_scheduling_notes;
	private String	rprt_group_notes;
	private int	rprt_parent_id;
	private int	rprt_prop_cost;
	private java.sql.Timestamp	rprt_launch_date;
	private int	rprt_hold_source_dist;
	private int	rprt_sources;
	private int	rprt_repeat_srcs;
	private int	rprt_field_force_visits;
	private int	scst_id;
	private int	rprt_late_rsched;
	private String	rprt_hide_from_schedule_yn;
	
	public int getEdtr_id() {
		return edtr_id;
	}
	public void setEdtr_id(int edtr_id) {
		this.edtr_id = edtr_id;
	}
	public int getFlash_parent() {
		return flash_parent;
	}
	public void setFlash_parent(int flash_parent) {
		this.flash_parent = flash_parent;
	}
	public int getFrid_id() {
		return frid_id;
	}
	public void setFrid_id(int frid_id) {
		this.frid_id = frid_id;
	}
	public int getIndr_code() {
		return indr_code;
	}
	public void setIndr_code(int indr_code) {
		this.indr_code = indr_code;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public int getIs_deleted() {
		return is_deleted;
	}
	public void setIs_deleted(int is_deleted) {
		this.is_deleted = is_deleted;
	}
	public int getIvst_id() {
		return ivst_id;
	}
	public void setIvst_id(int ivst_id) {
		this.ivst_id = ivst_id;
	}
	public int getLast_update_by() {
		return last_update_by;
	}
	public void setLast_update_by(int last_update_by) {
		this.last_update_by = last_update_by;
	}
	public java.sql.Timestamp getLast_update_date() {
		return last_update_date;
	}
	public void setLast_update_date(java.sql.Timestamp last_update_date) {
		this.last_update_date = last_update_date;
	}
	public int getOldid() {
		return oldid;
	}
	public void setOldid(int oldid) {
		this.oldid = oldid;
	}
	public int getPan_id() {
		return pan_id;
	}
	public void setPan_id(int pan_id) {
		this.pan_id = pan_id;
	}
	public String getRprt_accuracyindex() {
		return rprt_accuracyindex;
	}
	public void setRprt_accuracyindex(String rprt_accuracyindex) {
		this.rprt_accuracyindex = rprt_accuracyindex;
	}
	public int getRprt_aha() {
		return rprt_aha;
	}
	public void setRprt_aha(int rprt_aha) {
		this.rprt_aha = rprt_aha;
	}
	public java.sql.Timestamp getRprt_completeddate() {
		return rprt_completeddate;
	}
	public void setRprt_completeddate(java.sql.Timestamp rprt_completeddate) {
		this.rprt_completeddate = rprt_completeddate;
	}
	public String getRprt_desc() {
		return rprt_desc;
	}
	public void setRprt_desc(String rprt_desc) {
		this.rprt_desc = rprt_desc;
	}
	public java.sql.Timestamp getRprt_duedate() {
		return rprt_duedate;
	}
	public void setRprt_duedate(java.sql.Timestamp rprt_duedate) {
		this.rprt_duedate = rprt_duedate;
	}
	public int getRprt_field_force_visits() {
		return rprt_field_force_visits;
	}
	public void setRprt_field_force_visits(int rprt_field_force_visits) {
		this.rprt_field_force_visits = rprt_field_force_visits;
	}
	public String getRprt_group_notes() {
		return rprt_group_notes;
	}
	public void setRprt_group_notes(String rprt_group_notes) {
		this.rprt_group_notes = rprt_group_notes;
	}
	public String getRprt_hide_from_schedule_yn() {
		return rprt_hide_from_schedule_yn;
	}
	public void setRprt_hide_from_schedule_yn(String rprt_hide_from_schedule_yn) {
		this.rprt_hide_from_schedule_yn = rprt_hide_from_schedule_yn;
	}
	public String getRprt_highlights() {
		return rprt_highlights;
	}
	public void setRprt_highlights(String rprt_highlights) {
		this.rprt_highlights = rprt_highlights;
	}
	public String getRprt_hit_bonus() {
		return rprt_hit_bonus;
	}
	public void setRprt_hit_bonus(String rprt_hit_bonus) {
		this.rprt_hit_bonus = rprt_hit_bonus;
	}
	public int getRprt_hold_source_dist() {
		return rprt_hold_source_dist;
	}
	public void setRprt_hold_source_dist(int rprt_hold_source_dist) {
		this.rprt_hold_source_dist = rprt_hold_source_dist;
	}
	public int getRprt_id() {
		return rprt_id;
	}
	public void setRprt_id(int rprt_id) {
		this.rprt_id = rprt_id;
	}
	public int getRprt_idea_gen_ind() {
		return rprt_idea_gen_ind;
	}
	public void setRprt_idea_gen_ind(int rprt_idea_gen_ind) {
		this.rprt_idea_gen_ind = rprt_idea_gen_ind;
	}
	public int getRprt_importance_rating() {
		return rprt_importance_rating;
	}
	public void setRprt_importance_rating(int rprt_importance_rating) {
		this.rprt_importance_rating = rprt_importance_rating;
	}
	public java.sql.Timestamp getRprt_intl_duedate() {
		return rprt_intl_duedate;
	}
	public void setRprt_intl_duedate(java.sql.Timestamp rprt_intl_duedate) {
		this.rprt_intl_duedate = rprt_intl_duedate;
	}
	public int getRprt_isclassified() {
		return rprt_isclassified;
	}
	public void setRprt_isclassified(int rprt_isclassified) {
		this.rprt_isclassified = rprt_isclassified;
	}
	public int getRprt_iscofocus() {
		return rprt_iscofocus;
	}
	public void setRprt_iscofocus(int rprt_iscofocus) {
		this.rprt_iscofocus = rprt_iscofocus;
	}
	public int getRprt_isproprietary() {
		return rprt_isproprietary;
	}
	public void setRprt_isproprietary(int rprt_isproprietary) {
		this.rprt_isproprietary = rprt_isproprietary;
	}
	public int getRprt_issmallcap() {
		return rprt_issmallcap;
	}
	public void setRprt_issmallcap(int rprt_issmallcap) {
		this.rprt_issmallcap = rprt_issmallcap;
	}
	public String getRprt_isthumbsup() {
		return rprt_isthumbsup;
	}
	public void setRprt_isthumbsup(String rprt_isthumbsup) {
		this.rprt_isthumbsup = rprt_isthumbsup;
	}
	public String getRprt_lastisthumbsup() {
		return rprt_lastisthumbsup;
	}
	public void setRprt_lastisthumbsup(String rprt_lastisthumbsup) {
		this.rprt_lastisthumbsup = rprt_lastisthumbsup;
	}
	public int getRprt_late_rsched() {
		return rprt_late_rsched;
	}
	public void setRprt_late_rsched(int rprt_late_rsched) {
		this.rprt_late_rsched = rprt_late_rsched;
	}
	public java.sql.Timestamp getRprt_launch_date() {
		return rprt_launch_date;
	}
	public void setRprt_launch_date(java.sql.Timestamp rprt_launch_date) {
		this.rprt_launch_date = rprt_launch_date;
	}
	public String getRprt_mktcap() {
		return rprt_mktcap;
	}
	public void setRprt_mktcap(String rprt_mktcap) {
		this.rprt_mktcap = rprt_mktcap;
	}
	public String getRprt_notes() {
		return rprt_notes;
	}
	public void setRprt_notes(String rprt_notes) {
		this.rprt_notes = rprt_notes;
	}
	public int getRprt_parent_id() {
		return rprt_parent_id;
	}
	public void setRprt_parent_id(int rprt_parent_id) {
		this.rprt_parent_id = rprt_parent_id;
	}
	public String getRprt_pdf() {
		return rprt_pdf;
	}
	public void setRprt_pdf(String rprt_pdf) {
		this.rprt_pdf = rprt_pdf;
	}
	public String getRprt_prodcode() {
		return rprt_prodcode;
	}
	public void setRprt_prodcode(String rprt_prodcode) {
		this.rprt_prodcode = rprt_prodcode;
	}
	public int getRprt_prop_appr() {
		return rprt_prop_appr;
	}
	public void setRprt_prop_appr(int rprt_prop_appr) {
		this.rprt_prop_appr = rprt_prop_appr;
	}
	public int getRprt_prop_cost() {
		return rprt_prop_cost;
	}
	public void setRprt_prop_cost(int rprt_prop_cost) {
		this.rprt_prop_cost = rprt_prop_cost;
	}
	public int getRprt_rd_person() {
		return rprt_rd_person;
	}
	public void setRprt_rd_person(int rprt_rd_person) {
		this.rprt_rd_person = rprt_rd_person;
	}
	public int getRprt_repeat_srcs() {
		return rprt_repeat_srcs;
	}
	public void setRprt_repeat_srcs(int rprt_repeat_srcs) {
		this.rprt_repeat_srcs = rprt_repeat_srcs;
	}
	public java.sql.Timestamp getRprt_reportdate() {
		return rprt_reportdate;
	}
	public void setRprt_reportdate(java.sql.Timestamp rprt_reportdate) {
		this.rprt_reportdate = rprt_reportdate;
	}
	public String getRprt_reporters_view_all_yn() {
		return rprt_reporters_view_all_yn;
	}
	public void setRprt_reporters_view_all_yn(String rprt_reporters_view_all_yn) {
		this.rprt_reporters_view_all_yn = rprt_reporters_view_all_yn;
	}
	public java.sql.Timestamp getRprt_researchin() {
		return rprt_researchin;
	}
	public void setRprt_researchin(java.sql.Timestamp rprt_researchin) {
		this.rprt_researchin = rprt_researchin;
	}
	public String getRprt_scheduling_notes() {
		return rprt_scheduling_notes;
	}
	public void setRprt_scheduling_notes(String rprt_scheduling_notes) {
		this.rprt_scheduling_notes = rprt_scheduling_notes;
	}
	public String getRprt_source_display_field() {
		return rprt_source_display_field;
	}
	public void setRprt_source_display_field(String rprt_source_display_field) {
		this.rprt_source_display_field = rprt_source_display_field;
	}
	public String getRprt_source_report() {
		return rprt_source_report;
	}
	public void setRprt_source_report(String rprt_source_report) {
		this.rprt_source_report = rprt_source_report;
	}
	public int getRprt_sources() {
		return rprt_sources;
	}
	public void setRprt_sources(int rprt_sources) {
		this.rprt_sources = rprt_sources;
	}
	public java.sql.Timestamp getRprt_top_story_off_date() {
		return rprt_top_story_off_date;
	}
	public void setRprt_top_story_off_date(
			java.sql.Timestamp rprt_top_story_off_date) {
		this.rprt_top_story_off_date = rprt_top_story_off_date;
	}
	public int getRpst_id() {
		return rpst_id;
	}
	public void setRpst_id(int rpst_id) {
		this.rpst_id = rpst_id;
	}
	public int getRptr_id() {
		return rptr_id;
	}
	public void setRptr_id(int rptr_id) {
		this.rptr_id = rptr_id;
	}
	public int getRtyp_id() {
		return rtyp_id;
	}
	public void setRtyp_id(int rtyp_id) {
		this.rtyp_id = rtyp_id;
	}
	public int getScst_id() {
		return scst_id;
	}
	public void setScst_id(int scst_id) {
		this.scst_id = scst_id;
	}
	
	


}
