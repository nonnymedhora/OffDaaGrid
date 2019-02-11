/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.tables;

public class SourceIndustriesDataSet implements SourceIndustriesDataSetInfo {
    // maps to table bawaweb_source_industries
    private int sci_src_id;
    private int sci_frid_id;
    private String sci_delete_yn;
    
    public SourceIndustriesDataSet(int srcid, int fridid, String del) {
        this.sci_src_id = srcid;
        this.sci_frid_id = fridid;
        this.sci_delete_yn = del;
    }
    
    public SourceIndustriesDataSet() {
    }

    public void setSci_src_id(int sci_src_id) {
        this.sci_src_id = sci_src_id;
    }

    public int getSci_src_id() {
        return sci_src_id;
    }

    public void setSci_frid_id(int sci_frid_id) {
        this.sci_frid_id = sci_frid_id;
    }

    public int getSci_frid_id() {
        return sci_frid_id;
    }

    public void setSci_delete_yn(String sci_delete_yn) {
        this.sci_delete_yn = sci_delete_yn;
    }

    public String getSci_delete_yn() {
        return sci_delete_yn;
    }
}
