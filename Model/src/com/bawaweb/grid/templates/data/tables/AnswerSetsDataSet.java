/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.tables;

// maps to table bawaweb_answer_sets
public class AnswerSetsDataSet implements AnswerSetsDataSetInfo {
    // maps to table bawaweb_answer_sets
    private int     ans_id;
    private String  ans_name;
    private int     ans_frid_id;
    private String  ans_order_by_name_yn;
    private String  ans_add_answer_yn;
    private String  ans_delete_yn;
    
    
    public AnswerSetsDataSet() {
    }

    public void setAns_id(int _ans_id) {
        this.ans_id = _ans_id;
    }

    public int getAns_id() {
        return this.ans_id;
    }

    public void setAns_name(String _ans_name) {
        this.ans_name = _ans_name;
    }

    public String getAns_name() {
        return ans_name;
    }

    public void setAns_frid_id(int ans_frid_id) {
        this.ans_frid_id = ans_frid_id;
    }

    public int getAns_frid_id() {
        return this.ans_frid_id;
    }

    public void setAns_order_by_name_yn(String _ans_order_by_name_yn) {
        this.ans_order_by_name_yn = _ans_order_by_name_yn;
    }

    public String getAns_order_by_name_yn() {
        return this.ans_order_by_name_yn;
    }

    public void setAns_add_answer_yn(String _ans_add_answer_yn) {
        this.ans_add_answer_yn = _ans_add_answer_yn;
    }

    public String getAns_add_answer_yn() {
        return this.ans_add_answer_yn;
    }

    public void setAns_delete_yn(String _ans_delete_yn) {
        this.ans_delete_yn = _ans_delete_yn;
    }

    public String getAns_delete_yn() {
        return this.ans_delete_yn;
    }
    
    public String toString() {
        StringBuilder buff = new StringBuilder("AnswerSetsDataSet Info\n");
        
        buff.append("ans_id --> " + ans_id + "\n");
        buff.append("ans_name --> " + ans_name + "\n");
        buff.append("ans_frid_id --> " + ans_frid_id + "\n");
        buff.append("ans_order_by_name_yn --> " + ans_order_by_name_yn + "\n");
        buff.append("ans_add_answer_yn --> " + ans_add_answer_yn + "\n");
        buff.append("ans_delete_yn --> " + ans_delete_yn + "\n");
        return buff.toString();
    }
}
