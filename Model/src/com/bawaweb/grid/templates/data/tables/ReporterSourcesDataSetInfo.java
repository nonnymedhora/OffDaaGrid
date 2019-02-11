/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.tables;

public interface ReporterSourcesDataSetInfo {
	// maps to table ota-reporter_sources

	public abstract String getRsc_delete_yn();

	public abstract void setRsc_delete_yn(String rsc_delete_yn);

	public abstract int getRsc_empl_id();

	public abstract void setRsc_empl_id(int rsc_empl_id);

	public abstract int getRsc_src_id();

	public abstract void setRsc_src_id(int rsc_src_id);
        
	public String toString();

}