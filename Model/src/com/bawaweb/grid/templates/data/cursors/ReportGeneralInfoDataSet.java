/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.cursors;

import java.sql.Timestamp;

import java.util.Iterator;
import java.util.List;

public class ReportGeneralInfoDataSet implements ReportGeneralInfo {
/**
 * CUR_RPRT_INFO = 
                "select r.rprt_id, t.rtyp_id, r.rprt_desc, r.rprt_duedate, t.rtyp_desc " +
                " from rprt_reports r, rtyp_report_types t" + 
                " where r.rprt_id = ? and " + 
                " r.rtyp_id = t.rtyp_id";



 */
 
 
 /**
  * 
  * changed
  * ReportGeneralInfoDataSet now contains a list of editorgeneralinfo object (list size is one)
  * and it contains a list of leadreportergeneralinfo object
  * 
  */
 

    public ReportGeneralInfoDataSet() {
    }
    
    private int     reportId;
    private int     reporterId;
    private int     reportTypeId;
    private String reportDesc;
    private String reportType;
    private Timestamp reportDueDate;
    private int editorId;
    private List<LeadReporterGeneralInfo> theLeadReporterGeneralInfo;
    private List<EditorGeneralInfo> theEditorInfo;
    private ReporterGeneralInfo reporterInfo;
    private String rprtSourceDisplayField;
    
    public String getReportDesc() {
        return this.reportDesc;
    }
    public String getReportType() {
        return this.reportType;
    }
    public Timestamp getReportDueDate() {
        return this.reportDueDate;
    }  

    public String getRprtSourceDisplayField() {
        return this.rprtSourceDisplayField;
    }
    
    public void setRprtSourceDisplayField(String fld) {
        this.rprtSourceDisplayField = fld;
    }
    
    public void setReportDesc(String name) {
        this.reportDesc = name;
    }
    public void setReportType(String type) {
        this.reportType = type;
    }
    public void setReportDueDate(Timestamp stamp) {
        this.reportDueDate = stamp;
    }
    
    public int getReportId() {
        return this.reportId;
    }
    
    public void setReportId(int id) {
        this.reportId = id;
    }
    
    public int getReportTypeId() {
        return this.reportTypeId;
    }
    
    public void setReportTypeId(int id) {
        this.reportTypeId = id;
    }
    
    public int getReporterId() {
        return this.reporterId;
    }
    
    public void setReporterId(int id) {
        this.reporterId = id;
    }

    public void setEditorId(int editorId) {
        this.editorId = editorId;
    }
    public int getEditorId() {
        return this.editorId;
    }

    public void setReporterGeneralInfo(ReporterGeneralInfo repInfo) {
        this.reporterInfo = repInfo;
    }

    public ReporterGeneralInfo getReporterGeneralInfo() {
        return this.reporterInfo;
    }
    
    public String toString() {
        StringBuilder build = new StringBuilder();
        build.append("Report General Info\nreportId -> " + this.reportId + "\n");
        build.append("reporterId -> " + this.reporterId + "\n");
        build.append("reportDesc -> " + this.reportDesc + "\n");
        build.append("reportType -> " + this.reportType + "\n");
        build.append("reportDueDate -> " + this.reportDueDate + "\n");
        build.append("editorId -> " + this.editorId + "\n");
        build.append("reporterInfo -> " + this.reporterInfo + "\n");
        build.append("rprtSourceDisplayField -> " + this.rprtSourceDisplayField + "\n");
        
        for ( Iterator<LeadReporterGeneralInfo> it = theLeadReporterGeneralInfo.iterator(); it.hasNext(); ) {
            build.append( it.next() + "\n");
        }
        
        for ( Iterator<EditorGeneralInfo> it = theEditorInfo.iterator(); it.hasNext(); ) {
            build.append( it.next() + "\n");
        }
        
        return build.toString();
    }
    
    


        public void setTheEditorInfo(List<EditorGeneralInfo> theEditors) {
            this.theEditorInfo = theEditors;
        }

        public List<EditorGeneralInfo> getTheEditorInfo() {
            return this.theEditorInfo;
        }    


        public void setTheLeadReporterGeneralInfo(List<LeadReporterGeneralInfo> theLeadReporters) {
            this.theLeadReporterGeneralInfo = theLeadReporters;
        }

        public List<LeadReporterGeneralInfo> getTheLeadReporterGeneralInfo() {
            return this.theLeadReporterGeneralInfo;
        }
        
}
