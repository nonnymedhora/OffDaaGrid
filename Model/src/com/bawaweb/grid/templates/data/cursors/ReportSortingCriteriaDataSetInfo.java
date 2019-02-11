/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.cursors;

public interface ReportSortingCriteriaDataSetInfo {
//	 maps with -- Cursor to set up the Group By pulldown
//    CURSOR cur_srt(p_rprt_id rprt_reports.rprt_id%TYPE) IS

	public abstract int getRso_srt_id();

	public abstract void setRso_srt_id(int rso_srt_id);

	public abstract int getScv_id();

	public abstract void setScv_id(int scv_id);

	public abstract String getScv_name();

	public abstract void setScv_name(String scv_name);

	public abstract String getSrt_name();

	public abstract void setSrt_name(String srt_name);

}