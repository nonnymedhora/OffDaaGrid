/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.tables;

import com.bawaweb.utils.Pair;

public class AnswerSetValuesDataSet implements AnswerSetValuesDataSetInfo, Comparable<AnswerSetValuesDataSetInfo>{
// maps to table bawaweb_answer_set_values
    private int     asv_id;
    private int     asv_ans_id;
    private String  asv_answer;
    private int     asv_display_seq;
    private String  asv_delete_yn;
    
    public AnswerSetValuesDataSet() {
    }
    
    public boolean equals(Object a) {
        if ( a == null ) { System.out.println("NULLLLLLLL AnswerSetValuesDataSet?$@^@$@"); return false; }
        if ( this == a ) return true;
        if ( ! ( a instanceof AnswerSetValuesDataSet ) ) System.out.println("IS NOT ANSWERSETVALUESDATASET");
        if ( ! ( a instanceof AnswerSetValuesDataSetInfo ) ) return false;
        if ( a instanceof AnswerSetValuesDataSetInfo ) {
            AnswerSetValuesDataSet other = (AnswerSetValuesDataSet) a;
    //            return EqualsUtil.areEqual(this.x, other.x) &&
    //                   EqualsUtil.areEqual(this.y, other.y);
    //            return ( this.x.intValue() == other.getX().intValue() && this.y.intValue() == other.getY().intValue() );
    
    
            return ( 
                this.asv_id == other.getAsv_id() && 
                this.asv_ans_id == other.getAsv_ans_id() && 
                this.asv_display_seq == other.getAsv_display_seq() &&
                this.asv_answer.equalsIgnoreCase( other.getAsv_answer() ) &&
                this.asv_delete_yn.equalsIgnoreCase( other.getAsv_delete_yn() ) 
            );
        }
    System.out.println("IS NOT ANSWERSETVALUESDATASET");
        return false;
    }
    
    public int hashCode() {
        return 31*this.asv_id + 
                41*this.asv_ans_id + 
                17*this.asv_answer.hashCode() -
                15*this.asv_display_seq +
                2*this.asv_delete_yn.hashCode();
    }

    public void setAsv_id(int _asv_id) {
        this.asv_id = _asv_id;
    }

    public int getAsv_id() {
        return this.asv_id;
    }

    public void setAsv_ans_id(int _asv_ans_id) {
        this.asv_ans_id = _asv_ans_id;
    }

    public int getAsv_ans_id() {
        return this.asv_ans_id;
    }

    public void setAsv_answer(String _asv_answer) {
        this.asv_answer = _asv_answer;
    }

    public String getAsv_answer() {
        return this.asv_answer;
    }

    public void setAsv_display_seq(int _asv_display_seq) {
        this.asv_display_seq = _asv_display_seq;
    }

    public int getAsv_display_seq() {
        return this.asv_display_seq;
    }

    public void setAsv_delete_yn(String _asv_delete_yn) {
        this.asv_delete_yn = _asv_delete_yn;
    }

    public String getAsv_delete_yn() {
        return this.asv_delete_yn;
    }
    
    public String toString() {
        StringBuffer buff = new StringBuffer();
        buff.append("asv_id --> " + this.asv_id + "\n");
        buff.append("asv_ans_id --> " + this.asv_ans_id + "\n");
        buff.append("asv_answer --> " + this.asv_answer + "\n");
        buff.append("asv_display_seq --> " + this.asv_display_seq + "\n");
        buff.append("asv_delete_yn --> " + this.asv_delete_yn + "\n");
        
        return buff.toString();
    }
    
    public int compareTo(AnswerSetValuesDataSet asv) {
        Integer asvDisp = asv.getAsv_display_seq();
        Integer ourDisp = new java.lang.Integer( this.getAsv_display_seq() );
        return ourDisp.compareTo( asvDisp );
    }
    
    public int compareTo(AnswerSetValuesDataSetInfo asv) {
        Integer asvDisp = asv.getAsv_display_seq();
        Integer ourDisp = new java.lang.Integer( this.getAsv_display_seq() );
        return ourDisp.compareTo( asvDisp );
    }
    
}
