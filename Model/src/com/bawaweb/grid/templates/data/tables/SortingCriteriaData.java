/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.tables;

public class SortingCriteriaData {
	// maps to table bawaweb_sorting_criteria
	private int srt_id;
	private String srt_name;
	private int srt_frid_id;
	private String srt_delete_yn;
	
	public String getSrt_delete_yn() {
		return srt_delete_yn;
	}
	public void setSrt_delete_yn(String srt_delete_yn) {
		this.srt_delete_yn = srt_delete_yn;
	}
	public int getSrt_frid_id() {
		return srt_frid_id;
	}
	public void setSrt_frid_id(int srt_frid_id) {
		this.srt_frid_id = srt_frid_id;
	}
	public int getSrt_id() {
		return srt_id;
	}
	public void setSrt_id(int srt_id) {
		this.srt_id = srt_id;
	}
	public String getSrt_name() {
		return srt_name;
	}
	public void setSrt_name(String srt_name) {
		this.srt_name = srt_name;
	}
	
	
}
