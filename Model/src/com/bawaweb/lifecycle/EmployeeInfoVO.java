/**
 * @author Nonny Medhora
 */
package com.bawaweb.lifecycle;

import com.bawaweb.grid.templates.data.cursors.ReporterGeneralInfo;
import com.bawaweb.grid.templates.data.cursors.ReporterGeneralInfoDataSet;
import com.bawaweb.views.gridcursors.common.EmployeeInfoRow;

import oracle.jbo.domain.Number;

public class EmployeeInfoVO {

    private Number emplId;
    private String emplFname;
    private String emplLname;
    

    public EmployeeInfoVO() {
    }
    
    
    public Object getAttribute(String attribute) { 
        if ( attribute.equalsIgnoreCase("emplId")) return emplId;
        if ( attribute.equalsIgnoreCase("emplFname")) return emplFname;
        if ( attribute.equalsIgnoreCase("emplLname")) return emplLname;
        
        return null;
    }
    
    
    public EmployeeInfoVO transform(EmployeeInfoRow row) {
        EmployeeInfoVO emplInfo = new EmployeeInfoVO();
        emplInfo.setEmplId(row.getEmplId());
        emplInfo.setEmplFname(row.getEmplFname());
        emplInfo.setEmplLname(row.getEmplLname());
        return emplInfo;
    }
    
    public EmployeeInfoRow transform(com.bawaweb.views.gridcursors.common.EmployeeInfo view, EmployeeInfoVO empInfo) {
        EmployeeInfoRow row = (EmployeeInfoRow) view.createRow();
        
        
        row.setEmplId( empInfo.getEmplId());
        row.setEmplFname( empInfo.getEmplFname());
        row.setEmplLname( empInfo.getEmplLname());
        
        return row;
    }
    
    public ReporterGeneralInfo transform(EmployeeInfoVO empInfo) {
        ReporterGeneralInfo repInfo = new ReporterGeneralInfoDataSet();
        if ( empInfo.getEmplId() != null )    repInfo.setReporterId(empInfo.getEmplId().intValue());
        repInfo.setFname(empInfo.getEmplFname());
        repInfo.setLname(empInfo.getEmplLname());
        return repInfo;
    }

    public static void main(String[] args) {
        EmployeeInfoVO employeeInfo = new EmployeeInfoVO();
    }

    public void setEmplId(Number emplId) {
        this.emplId = emplId;
    }

    public Number getEmplId() {
        return emplId;
    }

    public void setEmplFname(String emplFname) {
        this.emplFname = emplFname;
    }

    public String getEmplFname() {
        return emplFname;
    }

    public void setEmplLname(String emplLname) {
        this.emplLname = emplLname;
    }

    public String getEmplLname() {
        return emplLname;
    }
}
