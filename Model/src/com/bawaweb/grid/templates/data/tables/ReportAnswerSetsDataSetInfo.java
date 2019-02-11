/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.tables;

public interface ReportAnswerSetsDataSetInfo {
    // maps to table bawaweb_report_answer_sets
    
     public void setRas_id(int _ras_id);

     public int getRas_id();

     public void setRas_rprt_id(int _ras_rprt_id);

     public int getRas_rprt_id();

     public void setRas_ans_id(int _ras_ans_id);

     public int getRas_ans_id();

     public void setRas_name(String _ras_name);

     public String getRas_name();

     public void setRas_frid_id(int _ras_frid_id);

     public int getRas_frid_id();
     
     public void setRas_order_by_name_yn(String _ras_order_by_name_yn);

     public String getRas_order_by_name_yn();

     public void setRas_add_answer_yn(String _ras_add_answer_yn);

     public String getRas_add_answer_yn();

     public void setRas_delete_yn(String _ras_delete_yn);

     public String getRas_delete_yn();

}
