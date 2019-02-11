/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.tables;

public class PanelInfoDataSet {
	// maps to table pan_panel
	private int pan_id;
	private String pan_desc;
	private int frid_id;
	private String pan_multi_national_yn;
	private int pan_status;
	private String pan_european_yn;
	private String pan_enhanced_yn;
	private String pan_is_proprietary_yn;
	
	public int getFrid_id() {
		return frid_id;
	}
	public void setFrid_id(int frid_id) {
		this.frid_id = frid_id;
	}
	public String getPan_desc() {
		return pan_desc;
	}
	public void setPan_desc(String pan_desc) {
		this.pan_desc = pan_desc;
	}
	public String getPan_enhanced_yn() {
		return pan_enhanced_yn;
	}
	public void setPan_enhanced_yn(String pan_enhanced_yn) {
		this.pan_enhanced_yn = pan_enhanced_yn;
	}
	public String getPan_european_yn() {
		return pan_european_yn;
	}
	public void setPan_european_yn(String pan_european_yn) {
		this.pan_european_yn = pan_european_yn;
	}
	public int getPan_id() {
		return pan_id;
	}
	public void setPan_id(int pan_id) {
		this.pan_id = pan_id;
	}
	public String getPan_is_proprietary_yn() {
		return pan_is_proprietary_yn;
	}
	public void setPan_is_proprietary_yn(String pan_is_proprietary_yn) {
		this.pan_is_proprietary_yn = pan_is_proprietary_yn;
	}
	public String getPan_multi_national_yn() {
		return pan_multi_national_yn;
	}
	public void setPan_multi_national_yn(String pan_multi_national_yn) {
		this.pan_multi_national_yn = pan_multi_national_yn;
	}
	public int getPan_status() {
		return pan_status;
	}
	public void setPan_status(int pan_status) {
		this.pan_status = pan_status;
	}
	
	
}
