/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.cursors;

public interface LeadReporterGeneralInfo {

    public void setEditorId(int editorId);

    public int getEditorId();

    public void setFname(String fname);

    public String getFname();

    public void setLname(String lname);

    public String getLname();

    public void setDesc(String desc);

    public String getDesc();
    
    public String toString();
    
    public int getRprtId();
    
    public void setRprtId(int rptId);
}
