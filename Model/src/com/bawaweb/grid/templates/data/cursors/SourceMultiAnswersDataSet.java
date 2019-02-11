/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.cursors;

public class SourceMultiAnswersDataSet implements SourceMultiAnswersDataSetInfo {
/**
     * -- Cursor to collect multi-response answers for a source
    -- Including unanswered pieces
    CURSOR cur_sma(p_qst_id bawaweb_questions.qst_id%TYPE,
                   p_rps_id bawaweb_report_sources.rps_id%TYPE,
				   p_decimal VARCHAR2) IS
     */

    private int     qmq_id;
    private String  qmq_number;
    private String  answer;
    private String  sra_color;
    private String  sra_answer_text;
    private String  sra_comment;    
    private int     sra_rps_id;
    private String  qmq_type;
    
    
    private int rav_id;             // xtra for bawaweb_report_answer_set_values rav
    private int sra_id;              // xtra for bawaweb_source_answers sra
    private int sma_sra_id;         // xtra for bawaweb_source_multi_answers???
    
//    private boolean isForDelete;
    
    
    
    public SourceMultiAnswersDataSet() {
    }
    
    public String toString() {
        StringBuffer buf = new StringBuffer("****SMA****\n");
        buf.append(" qmq_id ==>  " + this.qmq_id + "\n");
        buf.append(" qmq_number ==>  " + this.qmq_number + "\n");
        buf.append(" answer ==>  " + this.answer + "\n");
        buf.append(" sra_color ==>  " + this.qmq_id + "\n");
        buf.append(" qmq_id ==>  " + this.qmq_id + "\n");
        // etc
        return buf.toString();
    }
    
    public int getRav_Id () {
        return this.rav_id;
    }
    
    public void setRav_Id(int id) {
        this.rav_id = id;
    }
    public int getSra_Id () {
        return this.sra_id;
    }
    
    public void setSra_Id(int id) {
        this.sra_id = id;
    }
    

    
    public int getSma_sra_id() {
        return this.sma_sra_id;
    }
    
    public void setSma_sra_id(int id) {
        this.sma_sra_id = id;
    }
    

    public int getQmq_id() {
        return this.qmq_id;
    }

    public void setQmq_id(int qmqid) {
        this.qmq_id = qmq_id;
    }

    public String getQmq_number() {
        return this.qmq_number;
    }

    public void setQmq_number(String qmqnmbr) {
        this.qmq_number = qmqnmbr;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setAnswer(String ans) {
        this.answer = ans;
    }

    public String getSra_Answer_text() {
        return this.sra_answer_text;
    }

    public void setSra_answer_text(String ans_txt) {
        this.sra_answer_text = ans_txt;
    }

    public String getSra_color() {
        return this.sra_color;
    }

    public void setSra_color(String colr) {
        this.sra_color = colr;
    }

    public String getSra_comment() {
        return this.sra_comment;
    }

    public void setSra_comment(String cmmnt) {
        this.sra_comment = cmmnt;
    }
    
    public int getSra_rps_id() {
        return this.sra_rps_id;
    }
    
    public void setSra_rps_id(int id) {
        this.sra_rps_id = id;
    }
    
    public String getQmq_type() {
        return this.qmq_type;
    }
    
    public void setQmq_type(String type) {
        this.qmq_type = type;
    }

    public String toXML() {
        return null;
    }
    
//    
//    public boolean isForDelete() {
//        return this.isForDelete;
//    }
//    
//    public void setIsForDelete( boolean todelete ) {
//        this.isForDelete = todelete;
//    }
}
