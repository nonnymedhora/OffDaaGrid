/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.cursors;

public class TallySingleListStandardAnsSet implements TallySingleListStandardAnsSetInfo {

/**
 * -- Cursor to find tally results for single list responses using standard answer sets.
    lc_cur_tally_single_std VARCHAR2(4048) :=
    
 */

    private String      rav_answer;
    private int         rav_display_seq;
    private int         tally;



    public TallySingleListStandardAnsSet() {
    }

    public String getRav_answer() {
        return this.rav_answer;
    }

    public void setRav_answer(String ans) {
        this.rav_answer = ans;
    }

    public int getRav_display_sequence() {
        return this.rav_display_seq;
    }

    public void setRav_display_sequence(int seq) {
        this.rav_display_seq = seq;
    }

    public int getTally() {
        return this.tally;
    }

    public void setTally(int tal) {
         this.tally = tal;
    }
}
