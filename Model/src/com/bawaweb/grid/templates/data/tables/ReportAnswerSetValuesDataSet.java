/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.tables;

public class ReportAnswerSetValuesDataSet implements ReportAnswerSetValuesDataSetInfo, Comparable<ReportAnswerSetValuesDataSetInfo> {
    // maps to table bawaweb_report_answer_set_values
    public ReportAnswerSetValuesDataSet() {
    }
    
    private int     rav_id;
    private int     rav_ras_id;
    private String  rav_answer;
    private int     rav_display_seq;
    private int     rav_asv_id;
    private String  rav_delete_yn;
    private int     ans_id;
    
    
    public String toString() {
        StringBuffer buff = new StringBuffer("\n--ReportAnswerSetValuesDataSet--\n");
        buff.append("rav_id " + this.rav_id + "\n");
        buff.append("rav_ras_id " + this.rav_ras_id + "\n");
        buff.append("rav_answer " + this.rav_answer + "\n");
        buff.append("rav_display_seq " + this.rav_display_seq + "\n");
        buff.append("rav_asv_id " + this.rav_asv_id + "\n");
        buff.append("rav_delete_yn " + this.rav_delete_yn + "\n");
        buff.append("ans_id " + this.ans_id + "\n");
        
        return buff.toString();
    }
    
    
    public int getAns_id() {
        return this.ans_id;
    }
    
    public void setAns_id(int id) {
        this.ans_id = id;
    }


    public void setRav_id(int _rav_id) {
        this.rav_id = _rav_id;
    }

    public int getRav_id() {
        return this.rav_id;
    }

    public void setRav_ras_id(int _rav_ras_id) {
        this.rav_ras_id = _rav_ras_id;
    }

    public int getRav_ras_id() {
        return this.rav_ras_id;
    }

    public void setRav_answer(String _rav_answer) {
        this.rav_answer = _rav_answer;
    }

    public String getRav_answer() {
        return this.rav_answer;
    }

    public void setRav_display_seq(int _rav_display_seq) {
        this.rav_display_seq = _rav_display_seq;
    }

    public int getRav_display_seq() {
        return this.rav_display_seq;
    }

    public void setRav_asv_id(int _rav_asv_id) {
        this.rav_asv_id = _rav_asv_id;
    }

    public int getRav_asv_id() {
        return this.rav_asv_id;
    }

    public void setRav_delete_yn(String _rav_delete_yn) {
        this.rav_delete_yn = _rav_delete_yn;
    }

    public String getRav_delete_yn() {
        return this.rav_delete_yn;
    }
    
    public boolean equals(Object a) {
        if ( a == null ) { System.out.println("NULLLLLLLL ReportAnswerSetValuesDataSet?$@^@$@"); return false; }
        if ( this == a ) return true;
        if ( ! ( a instanceof ReportAnswerSetValuesDataSet ) ) System.out.println("IS NOT REPORTANSWERSETVALUESDATASET");
        if ( ! ( a instanceof ReportAnswerSetValuesDataSetInfo ) ) return false;
        if ( a instanceof ReportAnswerSetValuesDataSetInfo ) {
            ReportAnswerSetValuesDataSet other = (ReportAnswerSetValuesDataSet) a;
    //            return EqualsUtil.areEqual(this.x, other.x) &&
    //                   EqualsUtil.areEqual(this.y, other.y);
    //            return ( this.x.intValue() == other.getX().intValue() && this.y.intValue() == other.getY().intValue() );
            
            return ( 
                this.rav_id == other.getRav_id() && 
                this.rav_ras_id == other.getRav_ras_id() && 
                this.rav_display_seq == other.getRav_display_seq() &&
                this.rav_answer.equalsIgnoreCase( other.getRav_answer() ) 
            );
        }
    System.out.println("IS NOT REPORTANSWERSETVALUESDATASET");
        return false;
    }
    
    public int hashCode() {
        return 31*this.rav_id + 
                41*this.rav_ras_id + 
                17*this.rav_answer.hashCode() -
                15*this.rav_display_seq +
                2*this.rav_delete_yn.hashCode() +
                7*this.ans_id+
                13*this.rav_asv_id;
    }

    
    public int compareTo(ReportAnswerSetValuesDataSet rav) {
        Integer ravDisp = rav.getRav_display_seq();
        Integer ourDisp = new java.lang.Integer( this.getRav_display_seq() );
        return ourDisp.compareTo( ravDisp );
    }
    
    

    
    public int compareTo(ReportAnswerSetValuesDataSetInfo rav) {
        Integer ravDisp = rav.getRav_display_seq();
        Integer ourDisp = new java.lang.Integer( this.getRav_display_seq() );
        return ourDisp.compareTo( ravDisp );
    }
}
