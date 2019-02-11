/**
 * @author Nonny Medhora
 */
package com.bawaweb.lifecycle;


import com.bawaweb.grid.templates.data.cursors.LeadReporterGeneralInfo;
import com.bawaweb.grid.templates.data.cursors.LeadReporterGeneralInfoDataSet;
import com.bawaweb.views.gridcursors.common.LeadReporterInfo;
import com.bawaweb.views.gridcursors.common.LeadReporterInfoRow;

import oracle.jbo.domain.Number;

public class LeadReporterInfoVO {

    private Number emplId;
    private String emplFName;
    private String emplLName;
    private Number rptyId;
    private String rptyDesc;
    private String distributionNotes;
    private Number rprtId;
    
    
    public LeadReporterInfoVO() {
    }

    public static void main(String[] args) {
        LeadReporterInfoVO editorInfo = new LeadReporterInfoVO();
    }

    public void setEmplId(Number emplId) {
        this.emplId = emplId;
    }

    public Number getEmplId() {
        return emplId;
    }

    public void setEmplFName(String emplFName) {
        this.emplFName = emplFName;
    }

    public String getEmplFName() {
        return emplFName;
    }

    public void setEmplLName(String emplLName) {
        this.emplLName = emplLName;
    }

    public String getEmplLName() {
        return emplLName;
    }

    public void setRptyId(Number rptyId) {
        this.rptyId = rptyId;
    }

    public Number getRptyId() {
        return rptyId;
    }

    public void setRptyDesc(String rptyDesc) {
        this.rptyDesc = rptyDesc;
    }

    public String getRptyDesc() {
        return rptyDesc;
    }

    public void setDistributionNotes(String distributionNotes) {
        this.distributionNotes = distributionNotes;
    }

    public String getDistributionNotes() {
        return distributionNotes;
    }
    
    public Object getAttribute(String attribute) {
        if ( attribute.equalsIgnoreCase("emplId") ) return emplId;
        if ( attribute.equalsIgnoreCase("emplFName") ) return emplFName;
        if ( attribute.equalsIgnoreCase("emplLName") ) return emplFName;
        if ( attribute.equalsIgnoreCase("rptyId") ) return rptyId;
        if ( attribute.equalsIgnoreCase("rptyDesc") ) return rptyDesc;
        if ( attribute.equalsIgnoreCase("distributionNotes") ) return distributionNotes;
        if ( attribute.equalsIgnoreCase("rprtId") ) return rprtId;
        return null;
    }
    
    public LeadReporterInfoVO transform(LeadReporterInfoRow row) {
        LeadReporterInfoVO edInfo = new LeadReporterInfoVO();
        
        edInfo.setEmplId(row.getEmplId());
        edInfo.setEmplFName(row.getEmplFname());
        edInfo.setEmplLName(row.getEmplLname());
        
        edInfo.setRptyId(row.getRptyId());
        edInfo.setRptyDesc(row.getRptyDesc());
        edInfo.setRprtId( row.getRprtId() );
        edInfo.setDistributionNotes(row.getDistributionNotes());
        
        return edInfo;
        
    }
      
    public LeadReporterInfoRow transform(LeadReporterInfo view, LeadReporterInfoVO leadRepInfo) {
        LeadReporterInfoRow row = (LeadReporterInfoRow) view.createRow();
        
        row.setEmplId(leadRepInfo.getEmplId());
        row.setEmplFname(leadRepInfo.getEmplFName());
        row.setEmplLname(leadRepInfo.getEmplLName());
        row.setRptyId(leadRepInfo.getRptyId());
        row.setRptyDesc(leadRepInfo.getRptyDesc());
        row.setRprtId(leadRepInfo.getRprtId());
        row.setDistributionNotes(leadRepInfo.getDistributionNotes());
        
        return row;
    }
    
    public LeadReporterGeneralInfo transform(LeadReporterInfoVO edInf) {
        LeadReporterGeneralInfo info = new LeadReporterGeneralInfoDataSet();
        if ( edInf.getEmplId() != null ) info.setEditorId(edInf.getEmplId().intValue());
        info.setFname(edInf.getEmplFName());
        info.setLname(edInf.getEmplLName());
        info.setRprtId( edInf.getRprtId().intValue());
        return info;
    }
    
    
    public String toString() {
        StringBuilder build = new StringBuilder();
        build.append("rprtid --> " + rprtId + "\n");
        build.append("emplId  --> " + emplId + "\n");
        build.append("emplFName  --> " + emplFName + "\n");
        build.append("emplLName  --> " + emplLName + "\n");
        build.append("rptyId  --> " + rptyId + "\n");
        build.append("rptyDesc  --> " + rptyDesc + "\n");
        build.append("distributionNotes  --> " + distributionNotes + "\n");
        
        return build.toString();
    }

    public void setRprtId(Number rprtId) {
        this.rprtId = rprtId;
    }

    public Number getRprtId() {
        return rprtId;
    }
}
