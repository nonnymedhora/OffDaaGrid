/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.tables;

public interface SortingCriteriaValuesDataSetInfo {
    // maps to table bawaweb_sorting_criteria_values 
    public void setScv_id(int _scv_id);

    public int getScv_id();

    public void setScv_srt_id(int _scv_srt_id);

    public int getScv_srt_id();

    public void setScv_scv_id(int _scv_scv_id);

    public int getScv_scv_id();

    public void setScv_display_seq(int _scv_display_seq);

    public int getScv_display_seq();

    public void setSvc_name(String svc_name);

    public String getSvc_name();

    public void setScv_data_level_yn(String _scv_data_level_yn);

    public String getScv_data_level_yn();

    public void setScv_delete_yn(String _scv_delete_yn);

    public String getScv_delete_yn();
    
    public String toString();

}
