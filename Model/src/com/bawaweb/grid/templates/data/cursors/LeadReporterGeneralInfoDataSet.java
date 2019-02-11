/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.cursors;

public class LeadReporterGeneralInfoDataSet implements LeadReporterGeneralInfo {

    private int editorId;        // empl id
    private String fname;
    private String lname;
    private String desc;
    private int rprtId;
    
    public LeadReporterGeneralInfoDataSet() {
    }

    public void setEditorId(int editorId) {
        this.editorId = editorId;
    }

    public int getEditorId() {
        return this.editorId;
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

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }
    
    public int getRprtId() {
        return this.rprtId;
    }
    
    public void setRprtId(int id) {
        this.rprtId = id;
    }
    
    public String toString() {
        StringBuilder build = new StringBuilder();
        build.append("editorId ->> " + this.editorId + "\n");
        build.append("fname ->> " + this.fname + "\n");
        build.append("lname ->> " + this.lname + "\n");
        build.append("desc ->> " + this.desc + "\n");
        build.append("rprtid ->> " + this.rprtId + "\n");
        return build.toString();
    }
}
