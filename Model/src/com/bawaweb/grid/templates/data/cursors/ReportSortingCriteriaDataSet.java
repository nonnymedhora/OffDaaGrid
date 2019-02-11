/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.cursors;

public class ReportSortingCriteriaDataSet implements ReportSortingCriteriaDataSetInfo {
//	 maps with -- Cursor to set up the Group By pulldown
//    CURSOR cur_srt(p_rprt_id rprt_reports.rprt_id%TYPE) IS
	
	private int rso_srt_id;		//report sorting criteria id/value
	private String srt_name; 	//report sorting criteria name
	private int scv_id;			//ota sorting criteria value
	private String scv_name;	//ota sorting criteria name
        
	 
	 public ReportSortingCriteriaDataSet() {
         }
	
	public ReportSortingCriteriaDataSet(int rso_srt_id, String srt_name, int scv_id, String scv_name) {
		//super();
		this.rso_srt_id = rso_srt_id;
		this.srt_name = srt_name;
		this.scv_id = scv_id;
		this.scv_name = scv_name;
	}

	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.ReportSortingCriteriaDataInfo#getRso_srt_id()
	 */
	public int getRso_srt_id() {
		return rso_srt_id;
	}

	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.ReportSortingCriteriaDataInfo#setRso_srt_id(int)
	 */
	public void setRso_srt_id(int rso_srt_id) {
		this.rso_srt_id = rso_srt_id;
	}

	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.ReportSortingCriteriaDataInfo#getScv_id()
	 */
	public int getScv_id() {
		return scv_id;
	}

	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.ReportSortingCriteriaDataInfo#setScv_id(int)
	 */
	public void setScv_id(int scv_id) {
		this.scv_id = scv_id;
	}

	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.ReportSortingCriteriaDataInfo#getScv_name()
	 */
	public String getScv_name() {
		return scv_name;
	}

	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.ReportSortingCriteriaDataInfo#setScv_name(java.lang.String)
	 */
	public void setScv_name(String scv_name) {
		this.scv_name = scv_name;
	}

	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.ReportSortingCriteriaDataInfo#getSrt_name()
	 */
	public String getSrt_name() {
		return srt_name;
	}

	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.ReportSortingCriteriaDataInfo#setSrt_name(java.lang.String)
	 */
	public void setSrt_name(String srt_name) {
		this.srt_name = srt_name;
	}
	

}
