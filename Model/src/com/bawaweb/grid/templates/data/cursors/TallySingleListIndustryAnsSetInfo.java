/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.cursors;

public interface TallySingleListIndustryAnsSetInfo {

/**
 * -- Cursor to find tally results for single list responses using standard answer sets.
    lc_cur_tally_single_std VARCHAR2(4048) :=
    
 */
 
    public String getRav_answer();
    public void setRav_answer(String ans);
    
    public int getRav_display_sequence();
    public void setRav_display_sequence(int seq);
    
    public int getTally();       // count(sra-rav-id)
    public void setTally(int tal);
}
