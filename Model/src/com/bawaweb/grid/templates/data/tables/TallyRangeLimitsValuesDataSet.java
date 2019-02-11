/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.tables;

import oracle.jbo.domain.Number;
// note combining both tables
// bawaweb_tally_ranges
// and bawaweb_tally_range_limits
public class TallyRangeLimitsValuesDataSet implements TallyRangeLimitsValuesDataSetInfo {

    private int     trl_id;
    private int     trl_tly_id;
    private String  trl_from;
    private String  trl_to;
    private int     trl_display_seq;
    private String  trl_type;
    private String  trl_delete_yn;
    private int tly_id;
    private String tly_name;
    private String tly_prefix;
    private String tly_suffix;
    private String tly_delete_yn;

    public TallyRangeLimitsValuesDataSet() {
    }

    public void setTrl_id(int trl_id) {
        this.trl_id = trl_id;
    }

    public int getTrl_id() {
        return trl_id;
    }

    public void setTrl_tly_id(int trl_tly_id) {
        this.trl_tly_id = trl_tly_id;
    }

    public int getTrl_tly_id() {
        return trl_tly_id;
    }

    public void setTrl_from(String trl_from) {
        this.trl_from = trl_from;
    }

    public String getTrl_from() {
        return trl_from;
    }

    public void setTrl_to(String trl_to) {
        this.trl_to = trl_to;
    }

    public String getTrl_to() {
        return trl_to;
    }

    public void setTrl_display_seq(int trl_display_seq) {
        this.trl_display_seq = trl_display_seq;
    }

    public int getTrl_display_seq() {
        return trl_display_seq;
    }

    public void setTrl_type(String trl_type) {
        this.trl_type = trl_type;
    }

    public String getTrl_type() {
        return trl_type;
    }

    public void setTrl_delete_yn(String trl_delete_yn) {
        this.trl_delete_yn = trl_delete_yn;
    }

    public String getTrl_delete_yn() {
        return trl_delete_yn;
    }
    
    
    

        public void setTly_id(int tly_id) {
            this.tly_id = tly_id;
        }

        public int getTly_id() {
            return tly_id;
        }

        public void setTly_name(String tly_name) {
            this.tly_name = tly_name;
        }

        public String getTly_name() {
            return tly_name;
        }

        public void setTly_prefix(String tly_prefix) {
            this.tly_prefix = tly_prefix;
        }

        public String getTly_prefix() {
            return tly_prefix;
        }

        public void setTly_suffix(String tly_suffix) {
            this.tly_suffix = tly_suffix;
        }

        public String getTly_suffix() {
            return tly_suffix;
        }

        public void setTly_delete_yn(String tly_delete_yn) {
            this.tly_delete_yn = tly_delete_yn;
        }

        public String getTly_delete_yn() {
            return tly_delete_yn;
        }

}
