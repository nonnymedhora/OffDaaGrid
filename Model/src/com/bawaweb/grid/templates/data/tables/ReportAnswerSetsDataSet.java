/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.tables;

public class ReportAnswerSetsDataSet implements ReportAnswerSetsDataSetInfo {
    // maps to table bawaweb_report_answer_sets
    
     private int     ras_id;
     private int     ras_rprt_id;
     private int     ras_ans_id;
     private String  ras_name;
     private int     ras_frid_id;
     private String  ras_order_by_name_yn;
     private String  ras_add_answer_yn;
     private String  ras_delete_yn;
     
    public ReportAnswerSetsDataSet() {
    }

    public void setRas_id(int _ras_id) {
        this.ras_id = _ras_id;
    }

    public int getRas_id() {
        return this.ras_id;
    }

    public void setRas_rprt_id(int _ras_rprt_id) {
        this.ras_rprt_id = _ras_rprt_id;
    }

    public int getRas_rprt_id() {
        return this.ras_rprt_id;
    }

    public void setRas_ans_id(int _ras_ans_id) {
        this.ras_ans_id = _ras_ans_id;
    }

    public int getRas_ans_id() {
        return this.ras_ans_id;
    }

    public void setRas_name(String _ras_name) {
        this.ras_name = _ras_name;
    }

    public String getRas_name() {
        return this.ras_name;
    }

    public void setRas_frid_id(int _ras_frid_id) {
        this.ras_frid_id = _ras_frid_id;
    }

    public int getRas_frid_id() {
        return this.ras_frid_id;
    }

    public void setRas_order_by_name_yn(String _ras_order_by_name_yn) {
        this.ras_order_by_name_yn = _ras_order_by_name_yn;
    }

    public String getRas_order_by_name_yn() {
        return this.ras_order_by_name_yn;
    }

    public void setRas_add_answer_yn(String _ras_add_answer_yn) {
        this.ras_add_answer_yn = _ras_add_answer_yn;
    }

    public String getRas_add_answer_yn() {
        return this.ras_add_answer_yn;
    }

    public void setRas_delete_yn(String _ras_delete_yn) {
        this.ras_delete_yn = _ras_delete_yn;
    }

    public String getRas_delete_yn() {
        return this.ras_delete_yn;
    }
}
