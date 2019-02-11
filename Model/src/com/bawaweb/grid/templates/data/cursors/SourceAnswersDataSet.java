/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.cursors;



public class SourceAnswersDataSet implements SourceAnswersDataSetInfo {
    /*
     * CURSOR cur_sra(p_qst_id bawaweb_questions.qst_id%TYPE,
                       p_rps_id bawaweb_report_sources.rps_id%TYPE,
                                       p_decimal VARCHAR2) -- p-decimal     .,
    // maps to cursor cur_sra   -- see end too
    */
     /*
      * -- Cursor to collect multi-response answers for a source
     -- Including unanswered pieces
      * CURSOR cur_sma(p_qst_id bawaweb_questions.qst_id%TYPE,
                     p_rps_id bawaweb_report_sources.rps_id%TYPE,
                     p_decimal VARCHAR2) IS
      */
    private String answer;
    private String sra_answer_text;
    private String sra_color;
    private String sra_comment;
    
    private int src_id;             // bawaweb_sources
    private int rps_id;             // bawaweb_report_sources
    private int qst_id; 
    private String qmq_number;      // for multi if it exists
    private String qst_type;          // for q_type
    private String scv_name;
    private String qmq_qst_type;
    private int qmq_qst_id;
    private int rav_id;             // xtra for bawaweb_report_answer_set_values rav
    private int sra_id;              // xtra for bawaweb_source_answers sra
    private int sma_sra_id;         // xtra for bawaweb_source_multi_answers???
    private int qmq_id;
    private int scv_id;             // extra for sourcesortingcriteriasets
    private int old_scv_id;
    private int old_rav_id;
    private int empl_id;
    
    private String sraExcludeYN;
    private int asv_id;
    
    
    public int ravDisplaySeq;
    public String ravDeleteYN;
    
    public double sraWeightMultiplier;
    
    private int rasId;
    
    private boolean isForDelete;
    
    public SourceAnswersDataSet() {
    }    
    
    public void setOld_Rav_Id(int id ) {
        this.old_rav_id = id;
    }
    
    public int getOld_Rav_Id() {
        return this.old_rav_id;
      
    }
    
    public void setOld_Scv_Id(int id ) {
        this.old_scv_id = id;
    }
    
    public int getOld_Scv_Id() {
        return this.old_scv_id;
      
    }

    public void setRas_Id(int ras_Id) {
        this.rasId = ras_Id;
    }
    public int getRas_Id() {
        return this.rasId;
    }
    
    public double getSraWeightMultiplier() {
        return sraWeightMultiplier;
    }
    public void setSraWeightMultiplier(double mult) {
        sraWeightMultiplier = mult;
    }
    
    public void setRavDisplaySeq(int seq) {
        this.ravDisplaySeq = seq;
    }
    
    public int getRavDisplaySeq() {
        return ravDisplaySeq;
    }
    
    public void setRavDeleteYN(String del) {
        this.ravDeleteYN = del;
    }
    
    public String getRavDeleteYN() {
        return ravDeleteYN;
    }
    
    public void setSraExcludeYN(String yn) {
        sraExcludeYN = yn;        
    }
    
    public String getSraExcludeYN() {
        return sraExcludeYN;        
    }
    
    public void setAsv_Id(int id ) {
        this.asv_id = id;
    }
    
    public int getAsv_Id() {
        return this.asv_id;
      
    }
    
    public void setScv_Id(int id ) {
        this.scv_id = id;
    }
    
    public int getScv_Id() {
        return this.scv_id;
      
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
    
    public String getQmq_Qst_Type() {
        return this.qmq_qst_type;
    }
    
    public void setQmq_Qst_Type(String qtype) {
        this.qmq_qst_type = qtype;
    }
    

    
    public int getQmq_Qst_Id() {
        return this.qmq_qst_id;
    }
    
    public void setQmq_Qst_Id(int id) {
        this.qmq_qst_id = id;
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
    
    public int getRps_id() {
        return this.rps_id;
    }
    
    public void setRps_id(int id) {
        this.rps_id = id;
    }
    
    public int getQst_id() {
        return this.qst_id;
    }
    
    public void setQst_id(int id) {
        this.qst_id = id;
    }
    
    public int getQmq_id() {
        return this.qmq_id;
    }
    
    public void setQmq_id(int id) {
        this.qmq_id = id;
    }
    
    
    public String getQmq_number() {
        return this.qmq_number;
    }
    
    public void setQmq_number(String nmbr) {
        this.qmq_number = nmbr;
    }


    public int getSrc_id() {
            return src_id;
    }
    public void setSrc_id(int src_id) {
            this.src_id = src_id;
    }
    
    
    public String getScv_name() {
        return this.scv_name;
    }
    
    public void setScv_name(String srtcrtv) {
        this.scv_name = srtcrtv;
    }
    
    public String getQst_type() {
        return this.qst_type;
    }
    
    public void setQst_type(String type) {
        this.qst_type = type;
    }    
    
    public void setEmpl_Id(int id ) {
        this.empl_id = id;
    }
    
    public int getEmpl_Id() {
        return this.empl_id;
    }
    



    public String toXML() {
        StringBuilder bld = new StringBuilder("<SourceAnswersDataSet>");
            bld.append("    <rps_id>" + this.rps_id + "</rps_id>");
            bld.append("    <src_id>" + this.src_id + "</src_id>");
            bld.append("    <qst_id>" + this.qst_id + "</qst_id>");
            bld.append("    <qmq_number>" + this.qmq_number + "</qmq_number>");
            bld.append("    <qst_type>" + this.qst_type + "</qst_type>");
            bld.append("    <scv_name>" + this.scv_name + "</scv_name>");
            bld.append("    <answer>" + this.answer + "</answer>");
            bld.append("    <sra_answer_text>" + this.sra_answer_text + "</sra_answer_text>");
            bld.append("    <sra_color>" + this.sra_color + "</sra_color>");
            bld.append("    <sra_comment>" + this.sra_comment + "</sra_comment>");        
            bld.append("    <qmq_qst_type>" + this.qmq_qst_type + "</qmq_qst_type>");
            bld.append("    <qmq_qst_id>" + this.qmq_qst_id + "</qmq_qst_id>");
        bld.append("</SourceAnswersDataSet>");
        return bld.toString();
    }
    
    
    public String toString() {
        StringBuilder bld = new StringBuilder();
bld.append("\n --  SourceAnswersDataSet  -- \n");
        bld.append("rav_id => " + this.rav_id + "\n");        
        bld.append("sra_id => " + this.sra_id + "\n");
        bld.append("sma_sra_id => " + this.sma_sra_id + "\n");
        bld.append("ras_id => " + this.rasId + "\n");
        bld.append("rpsId => " + this.rps_id + "\n");
        bld.append("srcId => " + this.src_id + "\n");
        bld.append("qmq_id => " + this.qmq_id + "\n");
        bld.append("qst_id => " + this.qst_id + "\n");
        bld.append("qmq_number => " + this.qmq_number + "\n");
        bld.append("qst_type => " + this.qst_type + "\n");
        bld.append("scv_id => " + this.scv_id + "\n");
        bld.append("scv_name => " + this.scv_name + "\n");
        bld.append("answer => |" + this.answer + "|\n");
        bld.append("sra_answer_text => |" + this.sra_answer_text + "|\n");
        bld.append("sra_color => " + this.sra_color + "\n");        
        bld.append("sra_comment => " + this.sra_comment + "\n");
        bld.append("qmq_qst_type => " + this.qmq_qst_type + "\n");
        bld.append("qmq_qst_id => " + this.qmq_qst_id + "\n");
        bld.append("old_rav_id => " + this.old_rav_id + "\n");
        bld.append("old_scv_id => " + this.old_scv_id + "\n");
        bld.append("asv_id => " + this.asv_id + "\n");
        bld.append("isForDelete ==> " + this.isForDelete + "\n__*********_____***\n");
        return bld.toString();
    }
    
    public boolean isForDelete() {
        return this.isForDelete;
    }
    
    public void setIsForDelete( boolean todelete ) {
        this.isForDelete = todelete;
    }
    
    public boolean isEmpty() {
        // if all the fields apart from qst_id, rps_id and src_id are null - it returns true
        // removing sra_color
//         return (this.answer == null && this.sra_answer_text == null && this.sra_color == null && this.sra_comment == null);
        return ( ( this.answer == null || this.answer == "" )
                &&
                 ( this.sra_answer_text == null || this.sra_answer_text == "" )
                &&
                 ( this.sra_comment == null || this.sra_comment == "" )
            );
//        return ((this.answer == null && this.answer == "" && this.sra_answer_text == null && this.sra_answer_text == "" && this.sra_comment == null && this.sra_comment != ""));
    }
    
    public boolean isValid() {
        if ( this.qst_type.equalsIgnoreCase("MULTI")) {
            if ( this.qmq_qst_type.equalsIgnoreCase("SINGLE")) {
                return ( this.rps_id != 0 && this.qmq_id != 0 && this.sma_sra_id != 0 && this.rav_id != 0 );
            } else {
                return ( this.rps_id != 0 && this.qmq_id != 0 && this.sma_sra_id != 0 );
            }
        } else if ( this.qst_type.equalsIgnoreCase("SORT")) {
            return ( this.rps_id != 0 && this.qst_id < 0 && this.scv_id != 0  );
        } else if ( this.qst_type.equalsIgnoreCase("SINGLE")) {
            return ( this.rps_id != 0 && this.qst_id != 0 && this.sra_id != 0 && this.rav_id != 0 );
        } else {
            return ( this.rps_id != 0 && this.qst_id != 0 && this.sra_id != 0 );
        }
    }
}


/**
 * 
http://portal.bawaweb.com/pls/reporter/bawaweb_reports_screens.edit_answers?
p_rprt_id=87493&
p_rps_id=177788&
p_src_id=29296&
p_qst_id=36572&
p_qmq_id=&p_format=ANSWER



ANSWER				
Slight negative for PMP sales	
SRA_ANSWER_TEXT
especially young people do rather get mobiles with more functions and do not buy additional device.	
SRA_COLOR	
<null>
SRA_COMMENT
<null>
 */