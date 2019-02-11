/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.tables;

// maps to table bawaweb_answer_sets
public interface AnswerSetsDataSetInfo {

    public void setAns_id(int _ans_id);

    public int getAns_id();
    
    public void setAns_name(String _ans_name);
    
    public String getAns_name();

    public void setAns_frid_id(int ans_frid_id);

    public int getAns_frid_id();

    public void setAns_order_by_name_yn(String _ans_order_by_name_yn);

    public String getAns_order_by_name_yn();

    public void setAns_add_answer_yn(String _ans_add_answer_yn);

    public String getAns_add_answer_yn();

    public void setAns_delete_yn(String _ans_delete_yn);

    public String getAns_delete_yn();
    
    public String toString();
}
