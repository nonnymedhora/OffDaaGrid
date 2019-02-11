/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.tables;

public class SortingCriteriaValuesDataSet implements SortingCriteriaValuesDataSetInfo{

    // maps to table bawaweb_sorting_criteria_values 
    private int     scv_id;
    private int     scv_srt_id;
    private int     scv_scv_id;
    private int     scv_display_seq;
    private String  svc_name;
    private String  scv_data_level_yn;
    private String  scv_delete_yn;
    
    public SortingCriteriaValuesDataSet() {
    }

    public void setScv_id(int _scv_id) {
        this.scv_id = _scv_id;
    }

    public int getScv_id() {
        return this.scv_id;
    }

    public void setScv_srt_id(int _scv_srt_id) {
        this.scv_srt_id = _scv_srt_id;
    }

    public int getScv_srt_id() {
        return this.scv_srt_id;
    }

    public void setScv_scv_id(int _scv_scv_id) {
        this.scv_scv_id = _scv_scv_id;
    }

    public int getScv_scv_id() {
        return this.scv_scv_id;
    }

    public void setScv_display_seq(int _scv_display_seq) {
        this.scv_display_seq = _scv_display_seq;
    }

    public int getScv_display_seq() {
        return this.scv_display_seq;
    }

    public void setSvc_name(String svc_name) {
        this.svc_name = svc_name;
    }

    public String getSvc_name() {
        return svc_name;
    }

    public void setScv_data_level_yn(String _scv_data_level_yn) {
        this.scv_data_level_yn = _scv_data_level_yn;
    }

    public String getScv_data_level_yn() {
        return this.scv_data_level_yn;
    }

    public void setScv_delete_yn(String _scv_delete_yn) {
        this.scv_delete_yn = _scv_delete_yn;
    }

    public String getScv_delete_yn() {
        return this.scv_delete_yn;
    }
    
    public String toString() {
        StringBuilder build = new StringBuilder();
        build.append("scv_id --> " + scv_id + "\n");
        build.append("scv_srt_id --> " + scv_srt_id + "\n");
        build.append("scv_scv_id --> " + scv_scv_id + "\n");
        build.append("scv_display_seq --> " + scv_display_seq + "\n");
        build.append("svc_name --> " + svc_name + "\n");
        build.append("scv_data_level_yn --> " + scv_data_level_yn + "\n");
        build.append("scv_delete_yn --> " + scv_delete_yn + "\n");
        
        return build.toString();
    }
}
