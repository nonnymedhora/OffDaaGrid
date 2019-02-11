/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.tables;

public class ReportSourcesDataSet implements ReportSourcesDataSetInfo {
	// maps to table bawaweb_report_sources
	private int	rps_id;
	private int	rps_src_id;
	private int	rps_rprt_id;
	private int	rps_rptr_id;
	private String	rps_comped_yn;
	private String	rps_repeat_source_yn;
	private String	rps_delete_yn;
        
        public ReportSourcesDataSet() {}
	
        
        public ReportSourcesDataSet(int rps_id, int rps_src_id, int rps_rprt_id, int rps_rptr_id, String rps_comped_yn, String rps_repeat_source_yn, String rps_delete_yn) {
		super();
		this.rps_id = rps_id;
		this.rps_src_id = rps_src_id;
		this.rps_rprt_id = rps_rprt_id;
		this.rps_rptr_id = rps_rptr_id;
		this.rps_comped_yn = rps_comped_yn;
		this.rps_repeat_source_yn = rps_repeat_source_yn;
		this.rps_delete_yn = rps_delete_yn;
	}
        
        public ReportSourcesDataSet( int rps_rprt_id, int rps_rptr_id, String rps_comped_yn, String rps_repeat_source_yn, String rps_delete_yn) {
                super();
                this.rps_rprt_id = rps_rprt_id;
                this.rps_rptr_id = rps_rptr_id;
                this.rps_comped_yn = rps_comped_yn;
                this.rps_repeat_source_yn = rps_repeat_source_yn;
                this.rps_delete_yn = rps_delete_yn;
        }


	public String getRps_comped_yn() {
		return rps_comped_yn;
	}

	public void setRps_comped_yn(String rps_comped_yn) {
		this.rps_comped_yn = rps_comped_yn;
	}

	public String getRps_delete_yn() {
		return rps_delete_yn;
	}

	public void setRps_delete_yn(String rps_delete_yn) {
		this.rps_delete_yn = rps_delete_yn;
	}

	public int getRps_id() {
		return rps_id;
	}

	public void setRps_id(int rps_id) {
		this.rps_id = rps_id;
	}

	public String getRps_repeat_source_yn() {
		return rps_repeat_source_yn;
	}

	public void setRps_repeat_source_yn(String rps_repeat_source_yn) {
		this.rps_repeat_source_yn = rps_repeat_source_yn;
	}

	public int getRps_rprt_id() {
		return rps_rprt_id;
	}

	public void setRps_rprt_id(int rps_rprt_id) {
		this.rps_rprt_id = rps_rprt_id;
	}

	public int getRps_rptr_id() {
		return rps_rptr_id;
	}

	public void setRps_rptr_id(int rps_rptr_id) {
		this.rps_rptr_id = rps_rptr_id;
	}

	public int getRps_src_id() {
		return rps_src_id;
	}

	public void setRps_src_id(int rps_src_id) {
		this.rps_src_id = rps_src_id;
	}
	
        public String toString() {
            StringBuffer buff = new StringBuffer("RPS Info is\n");
            buff.append("rps_id " + rps_id + "\n");
            buff.append("rps_src_id " + rps_src_id + "\n");
            buff.append("rps_rprt_id " + rps_rprt_id + "\n");
            buff.append("rps_rptr_id " + rps_rptr_id + "\n");
            buff.append("rps_comped_yn " + rps_comped_yn + "\n");
            buff.append("rps_repeat_source_yn " + rps_repeat_source_yn + "\n");
            buff.append("rps_delete_yn " + rps_delete_yn + "\n____________\n");
            return buff.toString();
        }
	


}
