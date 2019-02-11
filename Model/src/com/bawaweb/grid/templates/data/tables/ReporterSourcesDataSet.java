/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.tables;

public class ReporterSourcesDataSet implements ReporterSourcesDataSetInfo {
	// maps to table ota-reporter_sources
	private int	rsc_src_id;
	private int	rsc_empl_id;
	private String	rsc_delete_yn;
        
        public ReporterSourcesDataSet() {}
	
	public ReporterSourcesDataSet(int rsc_src_id, int rsc_empl_id, String rsc_delete_yn) {	
		this.rsc_src_id = rsc_src_id;
		this.rsc_empl_id = rsc_empl_id;
		this.rsc_delete_yn = rsc_delete_yn;
	}

	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.ReporterSourcesDataInfo#getRsc_delete_yn()
	 */
	public String getRsc_delete_yn() {
		return rsc_delete_yn;
	}

	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.ReporterSourcesDataInfo#setRsc_delete_yn(java.lang.String)
	 */
	public void setRsc_delete_yn(String rsc_delete_yn) {
		this.rsc_delete_yn = rsc_delete_yn;
	}

	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.ReporterSourcesDataInfo#getRsc_empl_id()
	 */
	public int getRsc_empl_id() {
		return rsc_empl_id;
	}

	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.ReporterSourcesDataInfo#setRsc_empl_id(int)
	 */
	public void setRsc_empl_id(int rsc_empl_id) {
		this.rsc_empl_id = rsc_empl_id;
	}

	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.ReporterSourcesDataInfo#getRsc_src_id()
	 */
	public int getRsc_src_id() {
		return rsc_src_id;
	}

	/* (non-Javadoc)
	 * @see com.bawaweb.grid.templates.data.ReporterSourcesDataInfo#setRsc_src_id(int)
	 */
	public void setRsc_src_id(int rsc_src_id) {
		this.rsc_src_id = rsc_src_id;
	}
        
        public String toString() {
            StringBuffer buff = new StringBuffer("\n___ReporterSourcesDataSet___\n");
            buff.append(" rsc_src_id | " + this.rsc_src_id + "|\n");
            buff.append(" rsc_empl_id | " + this.rsc_empl_id + "|\n");
            buff.append(" rsc_delete_yn | " + this.rsc_delete_yn + "|\n");
            return buff.toString();
        }
	
	
	
	

}
