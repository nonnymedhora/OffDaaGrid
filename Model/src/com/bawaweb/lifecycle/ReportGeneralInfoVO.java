/**
 * @author Nonny Medhora
 */
package com.bawaweb.lifecycle;

import com.bawaweb.grid.templates.data.cursors.EditorGeneralInfo;
import com.bawaweb.grid.templates.data.cursors.LeadReporterGeneralInfo;
import com.bawaweb.grid.templates.data.cursors.ReportGeneralInfoDataSet;
import com.bawaweb.grid.templates.data.cursors.ReporterGeneralInfo;
import com.bawaweb.views.gridcursors.common.ReportGeneralInfoRow;

import java.util.List;

import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;

public class ReportGeneralInfoVO {

    private Number rprtId;
    private Number edtrId;
    private Number rtypId;
    private String rprtDesc;
    private Date rprtDuedate;
    private String rprtSourceDisplayField;
    
    
    private ReporterGeneralInfo rptrGenInfo;
    private List<LeadReporterGeneralInfo> theLeadReporters;
    private List<EditorGeneralInfo> theEditors;
    

    public ReportGeneralInfoVO() {
    }

    public static void main(String[] args) {
        ReportGeneralInfoVO reportGeneralInfo = new ReportGeneralInfoVO();
    }
    
    public Object getAttribute(String attribute) {
        if ( attribute.equalsIgnoreCase("rprtId"))  return rprtId;
        if ( attribute.equalsIgnoreCase("edtrId"))  return edtrId;
        if ( attribute.equalsIgnoreCase("rtypId"))  return rtypId;
        if ( attribute.equalsIgnoreCase("rprtDesc"))  return rprtDesc;
        if ( attribute.equalsIgnoreCase("rprtDuedate"))  return rprtDuedate;
        if ( attribute.equalsIgnoreCase("rprtSourceDisplayField"))  return rprtSourceDisplayField;
        
        return null;
    }
    
    
    public ReportGeneralInfoVO transform(ReportGeneralInfoRow row) {
        ReportGeneralInfoVO rptGenInfo = new ReportGeneralInfoVO();
        
        rptGenInfo.setRprtId( row.getRprtId() );
        rptGenInfo.setEdtrId( row.getEdtrId() );
        rptGenInfo.setRtypId( row.getRtypId() );
        rptGenInfo.setRprtDesc( row.getRprtDesc() );
        rptGenInfo.setRprtDuedate( row.getRprtDuedate() );
        rptGenInfo.setRprtSourceDisplayField( row.getRprtSourceDisplayField() );
        return rptGenInfo;
    }

    public ReportGeneralInfoRow transform(com.bawaweb.views.gridcursors.common.ReportGeneralInfo view,  ReportGeneralInfoVO rptGenInfo) {
        ReportGeneralInfoRow row = ( ReportGeneralInfoRow ) view.createRow();
        
        row.setRprtId( rptGenInfo.getRprtId() );
        row.setEdtrId( rptGenInfo.getEdtrId() );
        row.setRtypId( rptGenInfo.getRtypId() );
        row.setRprtDesc( rptGenInfo.getRprtDesc() );
        row.setRprtDuedate( rptGenInfo.getRprtDuedate() );
        row.setRprtSourceDisplayField( rptGenInfo.getRprtSourceDisplayField() );
        
        return row;
    }
    
    
    public com.bawaweb.grid.templates.data.cursors.ReportGeneralInfo transform(ReportGeneralInfoVO inf) {
        com.bawaweb.grid.templates.data.cursors.ReportGeneralInfo rgi = new ReportGeneralInfoDataSet();
        
        if ( inf.getRprtId() != null)       rgi.setReportId(inf.getRprtId().intValue());
        if ( inf.getEdtrId() != null )      rgi.setEditorId(inf.getEdtrId().intValue());
        if ( inf.getRtypId() != null )      rgi.setReportTypeId( inf.getRtypId().intValue() );
        rgi.setReportDesc( inf.getRprtDesc() );
        rgi.setReportType( inf.getRprtDesc() );
        if ( inf.getRprtDuedate() != null ) rgi.setReportDueDate(inf.getRprtDuedate().timestampValue());
        
        rgi.setTheLeadReporterGeneralInfo( inf.getTheLeadReporters() );
        rgi.setTheEditorInfo( inf.getTheEditors() );
        rgi.setReporterGeneralInfo( inf.getRptrGenInfo() );
        rgi.setRprtSourceDisplayField( inf.getRprtSourceDisplayField() );
        return rgi;
    }
    
    
    public ReportGeneralInfoVO transform(com.bawaweb.grid.templates.data.cursors.ReportGeneralInfo rgi) {
        ReportGeneralInfoVO rgInfo = new ReportGeneralInfoVO();
        
        rgInfo.setRprtId( new Number( rgi.getReportId() ) );        
        rgInfo.setEdtrId( new Number( rgi.getEditorId() ) );
        rgInfo.setRtypId( new Number( rgi.getReportTypeId() ) );
        rgInfo.setRprtDesc( rgi.getReportDesc() );
        rgInfo.setRprtDuedate( new Date( rgi.getReportDueDate() ) );
        rgInfo.setTheLeadReporters( rgi.getTheLeadReporterGeneralInfo() );
        rgInfo.setTheEditors( rgi.getTheEditorInfo() );
        rgInfo.setRptrGenInfo( rgi.getReporterGeneralInfo() );
        rgInfo.setRprtSourceDisplayField( rgi.getRprtSourceDisplayField() );
        return rgInfo;
    }
    
    public void setRprtId(Number rprtId) {
        this.rprtId = rprtId;
    }

    public Number getRprtId() {
        return rprtId;
    }

    public void setEdtrId(Number edtrId) {
        this.edtrId = edtrId;
    }

    public Number getEdtrId() {
        return edtrId;
    }

    public void setRtypId(Number rtypId) {
        this.rtypId = rtypId;
    }

    public Number getRtypId() {
        return rtypId;
    }

    public void setRprtDesc(String rprtDesc) {
        this.rprtDesc = rprtDesc;
    }

    public String getRprtDesc() {
        return rprtDesc;
    }

    public void setRprtDuedate(Date rprtDuedate) {
        this.rprtDuedate = rprtDuedate;
    }

    public Date getRprtDuedate() {
        return rprtDuedate;
    }

    public void setRptrGenInfo(ReporterGeneralInfo rptrInfo) {
        this.rptrGenInfo = rptrInfo;
    }

    public ReporterGeneralInfo getRptrGenInfo() {
        return rptrGenInfo;
    }

    public void setTheLeadReporters(List<LeadReporterGeneralInfo> theEditors) {
        this.theLeadReporters = theEditors;
    }

    public List<LeadReporterGeneralInfo> getTheLeadReporters() {
        return theLeadReporters;
    }

    public void setTheEditors(List<EditorGeneralInfo> theEditors) {
        this.theEditors = theEditors;
    }

    public List<EditorGeneralInfo> getTheEditors() {
        return theEditors;
    }

    public void setRprtSourceDisplayField(String rprtSourceDisplayField) {
        this.rprtSourceDisplayField = rprtSourceDisplayField;
    }

    public String getRprtSourceDisplayField() {
        return rprtSourceDisplayField;
    }
}
