/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.cursors;

public interface SourceAnswersDataSetInfo {
/*
 * CURSOR cur_sra(p_qst_id bawaweb_questions.qst_id%TYPE,
                   p_rps_id bawaweb_report_sources.rps_id%TYPE,
				   p_decimal VARCHAR2) -- p-decimal     .,
// maps to cursor cur_sra
*/
    public String getAnswer();

    public void setAnswer(String ans);
    
    public String getSra_Answer_text();

    public void setSra_answer_text(String ans_txt);
    
    public String getSra_color();

    public void setSra_color(String colr);
    
    public String getSra_comment();
    
    public void setSra_comment(String cmmnt);
    
    public int getRps_id();
    
    public void setRps_id(int id);
    
    public int getQst_id();
    
    public void setQst_id(int id);
    
    public String getQmq_number();
    
    public void setQmq_number(String nmbr);
    
    public int getSrc_id();
        
    public void setSrc_id(int src_id);
    
    public String getScv_name();
    
    public void setScv_name(String srtcrtv);
    
    public String getQst_type();
    
    public void setQst_type(String type);
    
    public String toString();
    
    public String toXML();
    
    public boolean isEmpty();
    
    public boolean isValid();
    
    public void setQmq_Qst_Type(String qtype);
    
    public String getQmq_Qst_Type();
    
    public int getRav_Id ();
    
    public void setRav_Id(int id);
    
    public int getSra_Id ();
    
    public void setSra_Id(int id);
    
    public int getSma_sra_id();
    
    public void setSma_sra_id(int id);
    
    public void setScv_Id(int id );
    
    public int getScv_Id();
    
    public int getQmq_id();
    
    public void setQmq_id(int id);
    
    public int getQmq_Qst_Id();
    public void setQmq_Qst_Id(int id);    
    
    public void setEmpl_Id(int id );
    public int getEmpl_Id();
    
    public int getAsv_Id();
    public void setAsv_Id(int i);
    
    public void setSraExcludeYN(String yn);
    public String getSraExcludeYN();
    
    public void setRavDisplaySeq(int seq);
    
    public int getRavDisplaySeq();
    
    public void setRavDeleteYN(String del);
    public String getRavDeleteYN();
    
    public double getSraWeightMultiplier();
    public void setSraWeightMultiplier(double mult);


    public void setRas_Id(int rasId);
    public int getRas_Id();
    
    
    
    
    public void setOld_Scv_Id(int id );
    public int getOld_Scv_Id();
    
    public void setOld_Rav_Id(int id );
    
    public int getOld_Rav_Id();
    
    public boolean isForDelete();
    public void setIsForDelete( boolean todelete );
}
