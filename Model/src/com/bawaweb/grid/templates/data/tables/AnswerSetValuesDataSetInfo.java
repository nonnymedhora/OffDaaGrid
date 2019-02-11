/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.tables;

public interface AnswerSetValuesDataSetInfo {
    // maps to table bawaweb_answer_set_values
     public void setAsv_id(int _asv_id);
     
     public int getAsv_id();

     public void setAsv_ans_id(int _asv_ans_id);

     public int getAsv_ans_id();

     public void setAsv_answer(String _asv_answer);

     public String getAsv_answer();

     public void setAsv_display_seq(int _asv_display_seq);
     
     public int getAsv_display_seq();

     public void setAsv_delete_yn(String _asv_delete_yn);

     public String getAsv_delete_yn();
     
     public String toString();
     
     public boolean equals(Object a);
     public int hashCode();

}
