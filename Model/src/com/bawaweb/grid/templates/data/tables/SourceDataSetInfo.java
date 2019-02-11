/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.tables;

import com.bawaweb.grid.templates.data.cursors.SourceAnswersDataSet;

import com.bawaweb.grid.templates.data.cursors.SourceAnswersDataSetInfo;

import java.sql.Timestamp;

import java.util.LinkedHashMap;

public interface SourceDataSetInfo{

    public String getSrcName();

    public String getSrc_address1();

    public void setSrc_address1(String src_address1);

    public String getSrc_address2();

    public void setSrc_address2(String src_address2);

    public String getSrc_address3();

    public void setSrc_address3(String src_address3);

    public String getSrc_area_of_expertise();

    public void setSrc_area_of_expertise(String src_area_of_expertise);

    public String getSrc_cell_phone();

    public void setSrc_cell_phone(String src_cell_phone);

    public String getSrc_city();

    public void setSrc_city(String src_city);

    public String getSrc_company();

    public void setSrc_company(String src_company);

    public String getSrc_company_size();

    public void setSrc_company_size(String src_company_size);

    public String getSrc_company_type();

    public void setSrc_company_type(String src_company_type);

    public String getSrc_courtesy_title();

    public void setSrc_courtesy_title(String src_courtesy_title);

    public int getSrc_ctry_id();

    public void setSrc_ctry_id(int src_ctry_id);

    public String getSrc_distribution_notes();

    public void setSrc_distribution_notes(String src_distribution_notes);

    public String getSrc_distribution_preference();

    public void setSrc_distribution_preference(String src_distribution_preference);

    public String getSrc_dont_contact_yn();

    public void setSrc_dont_contact_yn(String src_dont_contact_yn);

    public String getSrc_email();

    public void setSrc_email(String src_email);

    public String getSrc_exclusive_source_yn();

    public void setSrc_exclusive_source_yn(String src_exclusive_source_yn);

    public String getSrc_fax();

    public void setSrc_fax(String src_fax);

    public String getSrc_first_name();

    public void setSrc_first_name(String src_first_name);

    public int getSrc_id();

    public void setSrc_id(int src_id);

    public String getSrc_industry_sector();

    public void setSrc_industry_sector(String src_industry_sector);

    public String getSrc_industry_view();

    public void setSrc_industry_view(String src_industry_view);

    public String getSrc_job_description();

    public void setSrc_job_description(String src_job_description);

    public String getSrc_job_title();

    public void setSrc_job_title(String src_job_title);

    public String getSrc_last_name();

    public void setSrc_last_name(String src_last_name);

    public String getSrc_modified_by();

    public void setSrc_modified_by(String src_modified_by);

    public Timestamp getSrc_modified_date();

    public void setSrc_modified_date(Timestamp src_modified_date);

    public String getSrc_phone();

    public void setSrc_phone(String src_phone);

    public String getSrc_phone_ext();

    public void setSrc_phone_ext(String src_phone_ext);

    public String getSrc_quality_rating();

    public void setSrc_quality_rating(String src_quality_rating);

    public String getSrc_reporters_notes();

    public void setSrc_reporters_notes(String src_reporters_notes);

    public String getSrc_special_requests();

    public void setSrc_special_requests(String src_special_requests);

    public String getSrc_state();

    public void setSrc_state(String src_state);

    public String getSrc_status();

    public void setSrc_status(String src_status);

    public String getSrc_suffix_title();

    public void setSrc_suffix_title(String src_suffix_title);

    public int getSrc_tmz_id();

    public void setSrc_tmz_id(int src_tmz_id);

    public String getSrc_vendors();

    public void setSrc_vendors(String src_vendors);

    public String getSrc_zip();

    public void setSrc_zip(String src_zip);

    public String getSrc_display_name();

    public void setSrc_display_name(String style);

    public void setSourceAnswersDataSets(LinkedHashMap<Integer, SourceAnswersDataSetInfo> srcAnswersDataSets);

    public LinkedHashMap<Integer, SourceAnswersDataSetInfo> getSourceAnswersDataSets();
    
    public int getRps_id();     // report_source_id    
    public void setRps_id(int id);      
    
    public int getRps_rptr_id();
    public void setRps_rptr_id(int id);     // reporters id asking the source these qns 

    public void setEmp_init(String init);      // initials for the reporter
    public String getEmp_init();
    
    
    public String getRps_repeat_source_yn();            // repeat source from bawaweb_report_sources
    public void setRps_repeat_source_yn(String repeat);

    public String toString();

    public int compareTo(Object o);

    public boolean equals(Object o);

    public int hashCode();
    
    public String getSrc_country_name();
    public void setSrc_country_name(String na);
    
    public String getSrc_offered_report();
    public void setSrc_offered_report(String off);
    
    public boolean isValid();
    
    public int getSrc_rprt_id();
    public void setSrc_rprt_id(int id);
    
    public String getRps_comped_yn();       
    public void setRps_comped_yn(String comp);
    
    public String getRps_delete_yn();
    public void setRps_delete_yn(String delete);
    
    
    public ReportSourcesDataSetInfo getReportSourceInfo();    
    public void setReportSourceInfo(ReportSourcesDataSetInfo inf);
    
    public int getXlInternalId();
    public void setXlInternalId(int id);

    public ReporterSourcesDataSetInfo getReporterSourceInfo();
    public void setReporterSourceInfo( ReporterSourcesDataSetInfo inf );
    
    public String getSrc_informed_of_website();
    public void setSrc_informed_of_website(String inf);
    
    public boolean isSrcLocationValid();    
    public void setIsSrcLocationValid(boolean valid);
    
    public boolean isNullSrc();
}
