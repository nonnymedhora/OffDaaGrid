/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.tables;

import oracle.jbo.domain.Number;
// note combining both tables
// bawaweb_tally_ranges
// and bawaweb_tally_range_limits

public interface TallyRangeLimitsValuesDataSetInfo {

    public void setTrl_id(int trl_id);

    public int getTrl_id();

    public void setTrl_tly_id(int trl_tly_id);

    public int getTrl_tly_id();

    public void setTrl_from(String trl_from);

    public String getTrl_from();

    public void setTrl_to(String trl_to);

    public String getTrl_to();

    public void setTrl_display_seq(int trl_display_seq);

    public int getTrl_display_seq();

    public void setTrl_type(String trl_type);

    public String getTrl_type();

    public void setTrl_delete_yn(String trl_delete_yn);

    public String getTrl_delete_yn();
    
    
    
    // bawaweb_tally_ranges

         public void setTly_id(int tly_id);
         public int getTly_id();

         public void setTly_name(String tly_name);
         public String getTly_name();

         public void setTly_prefix(String tly_prefix);
         public String getTly_prefix();
         public void setTly_suffix(String tly_suffix);
         public String getTly_suffix();

         public void setTly_delete_yn(String tly_delete_yn);
         public String getTly_delete_yn();

    
}
