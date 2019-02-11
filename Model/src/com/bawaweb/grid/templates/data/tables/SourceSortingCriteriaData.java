/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.tables;

public class SourceSortingCriteriaData implements SourceSortingCriteriaDataInfo {
	// maps to table bawaweb_source_sorting_criteria
	private int ssc_rps_id;//	SSC_RPS_ID
	private int ssc_scv_id;
	
	public SourceSortingCriteriaData(int ssc_rps_id, int ssc_scv_id) {
		super();
		this.ssc_rps_id = ssc_rps_id;
		this.ssc_scv_id = ssc_scv_id;
	}
	
	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.SourceSortingCriteriaDataInfo#getSsc_rps_id()
	 */
	public int getSsc_rps_id() {
		return ssc_rps_id;
	}
	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.SourceSortingCriteriaDataInfo#setSsc_rps_id(int)
	 */
	public void setSsc_rps_id(int ssc_rps_id) {
		this.ssc_rps_id = ssc_rps_id;
	}
	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.SourceSortingCriteriaDataInfo#getSsc_scv_id()
	 */
	public int getSsc_scv_id() {
		return ssc_scv_id;
	}
	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.SourceSortingCriteriaDataInfo#setSsc_scv_id(int)
	 */
	public void setSsc_scv_id(int ssc_scv_id) {
		this.ssc_scv_id = ssc_scv_id;
	}
	
	

}
