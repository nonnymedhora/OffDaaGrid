/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.cursors;

import java.sql.Timestamp;

import java.util.List;

/**
 * CUR_RPRT_INFO = 
                "select r.rprt_id, t.rtyp_id, r.rprt_desc, r.rprt_duedate, t.rtyp_desc " +
                " from rprt_reports r, rtyp_report_types t" + 
                " where r.rprt_id = ? and " + 
                " r.rtyp_id = t.rtyp_id";
 */
public interface ReportGeneralInfo {

    public int getReportId();
    public void setReportId(int i);
    
    public String getReportDesc();
    public void setReportDesc(String name);
    
    public String getReportType();
    public void setReportType(String type);
    
    public Timestamp getReportDueDate();
    public void setReportDueDate(Timestamp stamp);

    public int getReportTypeId();
    public void setReportTypeId(int id);
    
    public int getReporterId();
    public void setReporterId(int id);

    public void setEditorId(int editorId);
    public int getEditorId();


    // note there is only one editor per report
    public void setTheEditorInfo(List<EditorGeneralInfo> theEditors);
    public List<EditorGeneralInfo> getTheEditorInfo();
    
    // there may be several lead reporters
    public void setTheLeadReporterGeneralInfo(List<LeadReporterGeneralInfo> theEditors);
    public List<LeadReporterGeneralInfo> getTheLeadReporterGeneralInfo();

    public String getRprtSourceDisplayField();
    public void setRprtSourceDisplayField(String fld);

    public void setReporterGeneralInfo(ReporterGeneralInfo repInfo);
    public ReporterGeneralInfo getReporterGeneralInfo();
    
    public String toString();
}
