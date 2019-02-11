/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.tables;

public interface ReportAnswerSetValuesDataSetInfo {
    // maps to table bawaweb_report_answer_set_values
    
     public void setRav_id(int _rav_id);

     public int getRav_id();

     public void setRav_ras_id(int _rav_ras_id);

     public int getRav_ras_id();

     public void setRav_answer(String _rav_answer);

     public String getRav_answer();
     
     public void setRav_display_seq(int _rav_display_seq);

     public int getRav_display_seq();

     public void setRav_asv_id(int _rav_asv_id);

     public int getRav_asv_id();

     public void setRav_delete_yn(String _rav_delete_yn);

     public String getRav_delete_yn();
     
     // added v2
     public int getAns_id();
     
     public void setAns_id(int id);
     
}
