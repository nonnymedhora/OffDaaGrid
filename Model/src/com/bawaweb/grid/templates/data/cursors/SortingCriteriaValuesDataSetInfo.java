/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.cursors;

public interface SortingCriteriaValuesDataSetInfo {
    /**
     * maps to cursor
     * -- Cursor to fetch sorting criteria values for source
    CURSOR cur_scv(p_rps_id bawaweb_source_sorting_criteria.ssc_rps_id%TYPE,
    p_srt_id bawaweb_sorting_criteria.srt_id%TYPE) IS
     */
     
     
     public String getScv_name();
     public void setScv_name(String scv_name);
     
     

}
