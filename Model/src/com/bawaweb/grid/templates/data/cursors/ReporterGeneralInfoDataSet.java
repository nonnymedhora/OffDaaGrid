/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.cursors;

public class ReporterGeneralInfoDataSet implements ReporterGeneralInfo {

    private int reporter_id;
    private String fname;
    private String lname;
    public ReporterGeneralInfoDataSet() {
    }
    
    public int getReporterId() {
        return this.reporter_id;
    }
    public void setReporterId(int reporter_id) {
        this.reporter_id = reporter_id;
    }
    
    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFname() {
        return this.fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getLname() {
        return this.lname;
    }
    
    
    public String toString() {
        StringBuffer buff = new StringBuffer();
        buff.append("reporter_id -> " + this.reporter_id + "\n");
        buff.append("fname -> " + this.fname + "\n");
        buff.append("lname -> " + this.lname + "\n");
        return buff.toString();
    }
}
