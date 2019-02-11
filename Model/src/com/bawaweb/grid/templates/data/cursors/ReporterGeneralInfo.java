/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.cursors;

public interface ReporterGeneralInfo {    
    public int getReporterId();
    public void setReporterId(int reporter_id);
    
    public void setFname(String fname);
    public String getFname();

    public void setLname(String lname);
    public String getLname();
    
    public String toString();
}
