/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.cursors;

public class SortingCriteriaValuesDataSet implements SortingCriteriaValuesDataSetInfo {
    /**
     * maps to cursor
     * -- Cursor to fetch sorting criteria values for source
    CURSOR cur_scv(p_rps_id bawaweb_source_sorting_criteria.ssc_rps_id%TYPE,
    p_srt_id bawaweb_sorting_criteria.srt_id%TYPE) IS
     */

    private String scv_name;
    
    private int ssc_rps_id;
    private int scv_srt_id;
    
    public SortingCriteriaValuesDataSet() {
    }
    
    

    public String getScv_name() {
        return this.scv_name;
    }

    public void setScv_name(String scv_name) {
    }
    
    public int getScv_rps_id() {
        return this.ssc_rps_id;
    }
    
    public void setScv_rps_id(int id) {
        this.ssc_rps_id = id;
    }
    
    
    public int getScv_srt_id() {
        return this.scv_srt_id;
    }
    
    public void setScv_srt_id(int id) {
        this.scv_srt_id = id;
    }
}
