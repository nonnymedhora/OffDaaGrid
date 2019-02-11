/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data;

public class ReportReporterData implements ReportReporterDataInfo {
	
	private int	rprt_id;
	private int	rptr_id;
	private int	rpty_id;
	private String	distribution_notes;
	
	public ReportReporterData(int rprt_id, int rptr_id, int rpty_id, String distribution_notes) {
		super();
		this.rprt_id = rprt_id;
		this.rptr_id = rptr_id;
		this.rpty_id = rpty_id;
		this.distribution_notes = distribution_notes;
	}

	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.ReportReporterDataInfo#getDistribution_notes()
	 */
	public String getDistribution_notes() {
		return distribution_notes;
	}

	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.ReportReporterDataInfo#setDistribution_notes(java.lang.String)
	 */
	public void setDistribution_notes(String distribution_notes) {
		this.distribution_notes = distribution_notes;
	}

	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.ReportReporterDataInfo#getRprt_id()
	 */
	public int getRprt_id() {
		return rprt_id;
	}

	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.ReportReporterDataInfo#setRprt_id(int)
	 */
	public void setRprt_id(int rprt_id) {
		this.rprt_id = rprt_id;
	}

	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.ReportReporterDataInfo#getRptr_id()
	 */
	public int getRptr_id() {
		return rptr_id;
	}

	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.ReportReporterDataInfo#setRptr_id(int)
	 */
	public void setRptr_id(int rptr_id) {
		this.rptr_id = rptr_id;
	}

	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.ReportReporterDataInfo#getRpty_id()
	 */
	public int getRpty_id() {
		return rpty_id;
	}

	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.ReportReporterDataInfo#setRpty_id(int)
	 */
	public void setRpty_id(int rpty_id) {
		this.rpty_id = rpty_id;
	}
	
	


}
