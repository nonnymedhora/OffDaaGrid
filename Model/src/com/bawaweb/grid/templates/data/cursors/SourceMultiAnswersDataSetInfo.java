/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.cursors;

public interface SourceMultiAnswersDataSetInfo {
/**
     * -- Cursor to collect multi-response answers for a source
    -- Including unanswered pieces
    CURSOR cur_sma(p_qst_id bawaweb_questions.qst_id%TYPE,
                   p_rps_id bawaweb_report_sources.rps_id%TYPE,
				   p_decimal VARCHAR2) IS
     */

    public int getQmq_id();
    
    public void setQmq_id(int qmqid);

    public String getQmq_number();
    
    public void setQmq_number(String qmqnmbr);
    
    public String getAnswer();

    public void setAnswer(String ans);
    
    public String getSra_Answer_text();

    public void setSra_answer_text(String ans_txt);
    
    public String getSra_color();

    public void setSra_color(String colr);
    
    public String getSra_comment();
    
    public void setSra_comment(String cmmnt);
    
    public String toString();
    
    public String toXML();
    
    public int getSra_rps_id();
    public void setSra_rps_id(int id);
    
    public String getQmq_type();
    public void setQmq_type(String type);
    
    public int getRav_Id ();
    
    public void setRav_Id(int id);
    
    public int getSra_Id ();
    
    public void setSra_Id(int id);
    
    public int getSma_sra_id();
    
    public void setSma_sra_id(int id);
    
//    
//    public boolean isForDelete();
//    
//    public void setIsForDelete( boolean todelete );
    
}


