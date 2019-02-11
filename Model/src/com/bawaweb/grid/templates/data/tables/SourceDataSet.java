/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.tables;

import com.bawaweb.grid.templates.data.cursors.SourceAnswersDataSetInfo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import java.util.Set;

import jxl.Range;
import jxl.Sheet;

import jxl.write.WritableSheet;

import com.bawaweb.grid.templates.data.SourceDisplayMap;
import com.bawaweb.grid.templates.data.cursors.SourceAnswersDataSet;
import com.bawaweb.services.PlatformAppModuleServiceImpl;
import com.bawaweb.utils.HashCodeUtil;

import java.util.LinkedHashMap;

import jxl.Cell;
import jxl.CellType;

public class SourceDataSet implements Comparable, 
                                      SourceDataSetInfo {//, Comparator {
	// maps to table bawaweb_sources
        // plus additional information for the applicable report in sub class
	private int	src_id;
	private String	src_last_name;
	private String	src_first_name;
	private String	src_courtesy_title;
	private String	src_job_title;
	private String	src_job_description;
	private String	src_company;
	private String	src_address1;
	private String	src_address2;
	private String	src_address3;
	private String	src_city;
	private String	src_state;
	private String	src_zip;
	private int	src_ctry_id;
	private int	src_tmz_id;
	private String	src_email;
	private String	src_phone;
	private String	src_phone_ext;
	private String	src_cell_phone;
	private String	src_fax;
	private String	src_status;
	private String	src_exclusive_source_yn;
	private String	src_dont_contact_yn;
	private String	src_company_type;
	private String	src_area_of_expertise;
	private String	src_industry_sector;
	private String	src_industry_view;
	private String	src_vendors;
	private String	src_company_size;
	private String	src_distribution_preference;
	private String	src_distribution_notes;
	private String	src_special_requests;
	private String	src_reporters_notes;
	private String	src_quality_rating;
	private java.sql.Timestamp	src_modified_date;
	private String	src_modified_by;
	private String	src_suffix_title;
	
	private String src_display_name;	//matches to rprt_source_display_field in rprt_reports// bawaweb_sources
        
        // rps info for the source --
        //these will later be pushed into an object if ncssy
        private int rps_id;             // reprt src id in bawaweb_report_sources
        private int rps_rptr_id;        // reporter's in bawaweb_report_sources
        private String emp_init;       // initials for the reporter in empl_ota-employees
        private String rps_repeat_source_yn;    // wheteher the sources is a repeat source from bawaweb_report_sources
        private String rps_comped_yn;
        private String rps_delete_yn;
        
        private LinkedHashMap<Integer, SourceAnswersDataSetInfo> sourceAnswersDataSets = new LinkedHashMap<Integer, SourceAnswersDataSetInfo>();
        
        private String src_country_name;
        
        private String style;
        private String src_offered_report;
        private String src_informed_of_website;
        private int src_rprt_id;    // the id of the report -- note this is only applicable for a single run
	private ReportSourcesDataSetInfo reportSourceInfo;
        private ReporterSourcesDataSetInfo reporterSourceInfo;
        
        private int xlInternalId;   // id from extrsourcessheetreader
        private boolean isSrcLocationValid;
        
	public SourceDataSet() {
        }
	

        // this ctor is used for recreating the SourceDataSet from the
        // ExtraSources worksheet and uses the ordering there
        // see the end of this file for the column sequence used
         public SourceDataSet(Sheet s, Range sRange, String direction) {
             int top_col = sRange.getTopLeft().getColumn();//System.out.println("topcol " +top_col);
             int top_row = sRange.getTopLeft().getRow();//System.out.println("toprowl " +top_row);
             
             int bot_col = sRange.getBottomRight().getColumn();//System.out.println("botcol " +bot_col);
             int bot_row = sRange.getBottomRight().getRow();//System.out.println("botrow " +bot_row);


             if (direction.equalsIgnoreCase("vertical")) {
                     while ( top_row <= bot_row) {
                             top_row++;
                     }
                     
             
             } else if (direction.equalsIgnoreCase("horizontal")) {
             
                     while ( top_col <= bot_col) {
                         // 1st is sequence -- skip
                         top_col++;
                        
//System.out.println("courtesy title cell contents " + s.getCell(top_col, top_row).getContents());
                         this.setSrc_courtesy_title(s.getCell(top_col, top_row).getContents());
                         top_col++;
                         
                         Cell aCell = s.getCell(top_col, top_row);
                         
                         if ( aCell.getType() != CellType.EMPTY ) {
                            String srcFName = aCell.getContents();
                            if ( srcFName != null && !srcFName.equals("")) {
                                this.setSrc_first_name(srcFName);
                            } else {
//                                this = null;
                                return;
                            }
                         } else {
//                             this = null;
                             return;
                         }
                         top_col++;
                         
                         aCell = s.getCell(top_col, top_row);
                         if ( aCell.getType() != CellType.EMPTY ) {
                            String srcLName = aCell.getContents();
                            if ( srcLName != null && !srcLName.equals("")) {
                                this.setSrc_last_name(srcLName);
                            } else {
//                                this = null;
                                return;
                            }
                         } else {
//                             this = null;
                             return;
                         }
                         top_col++;
                         
                         this.setSrc_suffix_title(s.getCell(top_col, top_row).getContents());
                         top_col++;
                         
                         aCell = s.getCell(top_col, top_row);
                         if ( aCell.getType() != CellType.EMPTY ) {
                            String srcPhone = aCell.getContents();
                            if ( srcPhone != null && !srcPhone.equals("")) {
                                this.setSrc_phone(srcPhone);
                            } else {
//                                this = null;
                                return;
                            }
                         } else {
//                             this = null;
                             return;
                         } 
                         top_col++;
                         
                         this.setSrc_phone_ext(s.getCell(top_col, top_row).getContents());
                         top_col++;
                         
                         this.setSrc_company(s.getCell(top_col, top_row).getContents());
                         top_col++;
                         
                         this.setSrc_job_title(s.getCell(top_col, top_row).getContents());
                         top_col++;
                         
                         this.setSrc_distribution_preference(s.getCell(top_col, top_row).getContents());
                         top_col++;
                         
                         this.setSrc_email(s.getCell(top_col, top_row).getContents());
                         top_col++;
                         
                         this.setSrc_cell_phone(s.getCell(top_col, top_row).getContents());
                         top_col++;
                         
                         this.setSrc_fax(s.getCell(top_col, top_row).getContents());
                         top_col++;
                         
                         this.setSrc_address1(s.getCell(top_col, top_row).getContents());
                         top_col++;
                         
                         this.setSrc_address2(s.getCell(top_col, top_row).getContents());
                         top_col++;
                         
                         this.setSrc_address3(s.getCell(top_col, top_row).getContents());
                         top_col++;                         
                         
                         aCell = s.getCell(top_col, top_row);
                         if ( aCell.getType() != CellType.EMPTY ) {
                             String ctryName = aCell.getContents();
//System.out.println("ctryname is >>" + ctryName + "<<");        
                             if (!ctryName.equals("") && ctryName != null) {
                                 
                                 int src_ctry_id = PlatformAppModuleServiceImpl.getInstance().getCountriesListings().get( ctryName );
                                 this.setSrc_ctry_id(src_ctry_id);
                             } else {
//                                 this = null;
                                 return;
                             }
                         } else {
//                             this = null;
                             return;
                         }
                         top_col++;                         
                         
                         aCell = s.getCell(top_col, top_row);
                         if ( aCell.getType() != CellType.EMPTY ) {
                            String srcCity = aCell.getContents();
                            if ( srcCity != null && !srcCity.equals("")) {
                                this.setSrc_city(srcCity);
                            } else {
//                                this = null;
                                return;
                            }
                         } else {
//                             this = null;
                             return;
                         }
                         top_col++;
                         
                         this.setSrc_state(s.getCell(top_col, top_row).getContents());
                         top_col++;
                         
                         this.setSrc_zip(s.getCell(top_col, top_row).getContents());
                         top_col++;
                         
                         aCell = s.getCell(top_col, top_row);
                         if ( aCell.getType() != CellType.EMPTY ) {
                             String tmZone = aCell.getContents();
                             if (!tmZone.equals("") || tmZone != null ) {
                                 int thesrc_tmz_id = PlatformAppModuleServiceImpl.getInstance().getTimeZonesMap().get( tmZone );                         
                                 this.setSrc_tmz_id(thesrc_tmz_id);
                             }
                         }
                         top_col++;
                         
                         this.setSrc_job_description(s.getCell(top_col, top_row).getContents());
                         top_col++;
                         
                         this.setSrc_company_type(s.getCell(top_col, top_row).getContents());
                         top_col++;
                         
                         this.setSrc_company_size(s.getCell(top_col, top_row).getContents());
                         top_col++;
                         
                         this.setSrc_industry_view(s.getCell(top_col, top_row).getContents());
                         top_col++;
                         
                         this.setSrc_industry_sector(s.getCell(top_col, top_row).getContents());
                         top_col++;
                         
                         this.setSrc_quality_rating(s.getCell(top_col, top_row).getContents());
                         top_col++;                         
                         
                         this.setSrc_exclusive_source_yn(s.getCell(top_col, top_row).getContents());
                         top_col++;
                         
                         this.setSrc_dont_contact_yn(s.getCell(top_col, top_row).getContents());
                         top_col++;
                         
                         this.setSrc_area_of_expertise(s.getCell(top_col, top_row).getContents());
                         top_col++;
                         
                         this.setSrc_vendors(s.getCell(top_col, top_row).getContents());
                         top_col++;
                         
                         this.setSrc_reporters_notes(s.getCell(top_col, top_row).getContents());
                         top_col++;
                         
                         this.setSrc_distribution_notes(s.getCell(top_col, top_row).getContents());
                         top_col++;
                         
                         this.setSrc_offered_report(s.getCell(top_col, top_row).getContents());
                         top_col++;
                         
                         
                         this.setSrc_informed_of_website(s.getCell(top_col, top_row).getContents());
                         top_col++;
                         
                         this.setSrc_status("ACTIVE");                          
                         
                         
                         
                         top_col++;
                     }
             }
                 
         }
/**
     * public SourceDataSet(WritableSheet s, Range sRange, String direction) {
     * int top_col = sRange.getTopLeft().getColumn();System.out.println("topcol " +top_col);
     * int top_row = sRange.getTopLeft().getRow();System.out.println("toprowl " +top_row);
     * 
     * int bot_col = sRange.getBottomRight().getColumn();System.out.println("botcol " +bot_col);
     * int bot_row = sRange.getBottomRight().getRow();System.out.println("botrow " +bot_row);
     * 
     * 
     * if (direction.equalsIgnoreCase("vertical")) {
     * while ( top_row <= bot_row) {
     * top_row++;
     * }
     * 
     * 
     * } else if (direction.equalsIgnoreCase("horizontal")) {
     * 
     * while ( top_col <= bot_col) {
     * 
     * System.out.println("displayname cell contents " + sRange.getTopLeft().getContents());
     * this.setSrc_display_name(sRange.getTopLeft().getContents());
     * System.out.println("in ctor this.srcDisplayName " + this.srcDisplayName);
     * top_col++;
     * 
     * System.out.println("courtesy title cell contents " + s.getCell(top_col, top_row).getContents());
     * this.setSrc_courtesy_title(s.getCell(top_col, top_row).getContents());
     * top_col++;
     * 
     * String courtesyTitleText = s.getCell(top_col, top_row).getContents();
     * top_col++;
     * 
     * this.setSrc_first_name(s.getCell(top_col, top_row).getContents());
     * top_col++;
     * 
     * this.setSrc_last_name(s.getCell(top_col, top_row).getContents());
     * top_col++;
     * 
     * this.setSrc_suffix_title(s.getCell(top_col, top_row).getContents());
     * top_col++;
     * 
     * String suffixText = s.getCell(top_col, top_row).getContents();
     * top_col++;
     * 
     * this.setSrc_phone(s.getCell(top_col, top_row).getContents());
     * top_col++;
     * 
     * this.setSrc_phone_ext(s.getCell(top_col, top_row).getContents());
     * top_col++;
     * 
     * this.setSrc_status(s.getCell(top_col, top_row).getContents());
     * top_col++;
     * 
     * this.setSrc_company(s.getCell(top_col, top_row).getContents());
     * top_col++;
     * 
     * this.setSrc_job_title(s.getCell(top_col, top_row).getContents());
     * top_col++;
     * 
     * this.setSrc_job_description(s.getCell(top_col, top_row).getContents());
     * top_col++;
     * 
     * this.setSrc_company_type(s.getCell(top_col, top_row).getContents());
     * top_col++;
     * 
     * this.setSrc_company_size(s.getCell(top_col, top_row).getContents());
     * top_col++;
     * 
     * this.setSrc_industry_view(s.getCell(top_col, top_row).getContents());
     * top_col++;
     * 
     * this.setSrc_industry_sector(s.getCell(top_col, top_row).getContents());
     * top_col++;
     * 
     * this.setSrc_quality_rating(s.getCell(top_col, top_row).getContents());
     * top_col++;
     * 
     * this.setSrc_email(s.getCell(top_col, top_row).getContents());
     * top_col++;
     * 
     * this.setSrc_cell_phone(s.getCell(top_col, top_row).getContents());
     * top_col++;
     * 
     * this.setSrc_fax(s.getCell(top_col, top_row).getContents());
     * top_col++;
     * 
     * this.setSrc_address1(s.getCell(top_col, top_row).getContents());
     * top_col++;
     * 
     * this.setSrc_address2(s.getCell(top_col, top_row).getContents());
     * top_col++;
     * 
     * this.setSrc_address3(s.getCell(top_col, top_row).getContents());
     * top_col++;
     * 
     * 
     * int thesrc_ctry_id  = (s.getCell(top_col, top_row).getContents() != null && s.getCell(top_col, top_row).getContents() != "") ?
     * Integer.parseInt(s.getCell(top_col, top_row).getContents()) :
     * 0;
     * this.setSrc_ctry_id(thesrc_ctry_id);
     * top_col++;
     * 
     * this.setSrc_city(s.getCell(top_col, top_row).getContents());
     * top_col++;
     * 
     * this.setSrc_state(s.getCell(top_col, top_row).getContents());
     * top_col++;
     * 
     * this.setSrc_zip(s.getCell(top_col, top_row).getContents());
     * top_col++;
     * 
     * int thesrc_tmz_id = (s.getCell(top_col, top_row).getContents() != null && s.getCell(top_col, top_row).getContents() != "") ?
     * Integer.parseInt(s.getCell(top_col, top_row).getContents()) :
     * 0;
     * this.setSrc_tmz_id(thesrc_tmz_id);
     * top_col++;
     * 
     * this.setSrc_exclusive_source_yn(s.getCell(top_col, top_row).getContents());
     * top_col++;
     * 
     * this.setSrc_dont_contact_yn(s.getCell(top_col, top_row).getContents());
     * top_col++;
     * 
     * this.setSrc_distribution_preference(s.getCell(top_col, top_row).getContents());
     * top_col++;
     * 
     * this.setSrc_reporters_notes(s.getCell(top_col, top_row).getContents());
     * top_col++;
     * 
     * String industries = s.getCell(top_col, top_row).getContents();
     * top_col++;
     * 
     * this.setSrc_area_of_expertise(s.getCell(top_col, top_row).getContents());
     * top_col++;
     * 
     * this.setSrc_vendors(s.getCell(top_col, top_row).getContents());
     * top_col++;
     * 
     * String notes  = s.getCell(top_col, top_row).getContents();
     * top_col++;
     * 
     * this.setSrc_special_requests(s.getCell(top_col, top_row).getContents());
     * top_col++;				
     * 
     * this.setSrc_distribution_notes(s.getCell(top_col, top_row).getContents());
     * top_col++;
     * 
     * top_col++;
     * }
     * }
     * 
     * }
     */


	/*private  Map map_sourceDisplays = new HashMap();
	
		map_sourceDisplays.put("NAME", getSrcName());
		map_sourceDisplays.put("JOB TITLE", getSrc_job_title());
		map_sourceDisplays.put("COMPANY", getSrc_company());
		map_sourceDisplays.put("CITY", getSrc_city() + " " + getSrc_state());
		map_sourceDisplays.put("CO,NAME", getSrc_company() + " " + getSrcName());
		map_sourceDisplays.put("CO,JOB", getSrc_company() + " " + getSrc_job_title());
		map_sourceDisplays.put("NAME,JOB", getSrcName() + " " + getSrc_job_title());
		map_sourceDisplays.put("CO,JOB,N", getSrc_company() + " " + getSrc_job_title() + " " + getSrcName());
		map_sourceDisplays.put("CO,JOB,C,S", getSrc_company() + " " + getSrc_job_title() + " " + getSrc_city() + " " + getSrc_state());
		map_sourceDisplays.put("CO,C,S", getSrc_company() + " " + getSrc_city() + " " + getSrc_state());
		map_sourceDisplays.put("CO,C,S,N", getSrc_company() + " " + getSrc_city() + " " + getSrc_state() + " " + getSrcName());
		map_sourceDisplays.put("CO,C,S,J,N", getSrc_company() + " " + getSrc_city() + " " + getSrc_state() + " " + getSrc_job_title()  + " " + getSrcName());
		map_sourceDisplays.put("IS,CO,N", getSrc_industry_sector() + " " + getSrc_company() + " " + getSrcName());
		map_sourceDisplays.put("IS,CO,J,N", getSrc_industry_sector() + " " + getSrc_company() + " " + getSrc_job_title() + " " + getSrcName());
		map_sourceDisplays.put("N,JOB,IS", getSrcName() + " " + getSrc_job_title() + " " + getSrc_industry_sector());
		
	*/
	
	public String getSrcName() {
		return (this.getSrc_courtesy_title() + " " + this.getSrc_first_name() + " " + this.getSrc_last_name());
	}
	
	public String getSrc_address1() {
		return src_address1;
	}
	public void setSrc_address1(String src_address1) {
		this.src_address1 = src_address1;
	}
	public String getSrc_address2() {
		return src_address2;
	}
	public void setSrc_address2(String src_address2) {
		this.src_address2 = src_address2;
	}
	public String getSrc_address3() {
		return src_address3;
	}
	public void setSrc_address3(String src_address3) {
		this.src_address3 = src_address3;
	}
	public String getSrc_area_of_expertise() {
		return src_area_of_expertise;
	}
	public void setSrc_area_of_expertise(String src_area_of_expertise) {
		this.src_area_of_expertise = src_area_of_expertise;
	}
	public String getSrc_cell_phone() {
		return src_cell_phone;
	}
	public void setSrc_cell_phone(String src_cell_phone) {
		this.src_cell_phone = src_cell_phone;
	}
	public String getSrc_city() {
		return src_city;
	}
	public void setSrc_city(String src_city) {
		this.src_city = src_city;
	}
	public String getSrc_company() {
		return src_company;
	}
	public void setSrc_company(String src_company) {
		this.src_company = src_company;
	}
	public String getSrc_company_size() {
		return src_company_size;
	}
	public void setSrc_company_size(String src_company_size) {
		this.src_company_size = src_company_size;
	}
	public String getSrc_company_type() {
		return src_company_type;
	}
	public void setSrc_company_type(String src_company_type) {
		this.src_company_type = src_company_type;
	}
	public String getSrc_courtesy_title() {
		return src_courtesy_title;
	}
	public void setSrc_courtesy_title(String src_courtesy_title) {
		this.src_courtesy_title = src_courtesy_title;
	}
	public int getSrc_ctry_id() {
		return src_ctry_id;
	}
	public void setSrc_ctry_id(int src_ctry_id) {
		this.src_ctry_id = src_ctry_id;
	}
	public String getSrc_distribution_notes() {
		return src_distribution_notes;
	}
	public void setSrc_distribution_notes(String src_distribution_notes) {
		this.src_distribution_notes = src_distribution_notes;
	}
	public String getSrc_distribution_preference() {
		return src_distribution_preference;
	}
	public void setSrc_distribution_preference(String src_distribution_preference) {
		this.src_distribution_preference = src_distribution_preference;
	}
	public String getSrc_dont_contact_yn() {
		return src_dont_contact_yn;
	}
	public void setSrc_dont_contact_yn(String src_dont_contact_yn) {
		this.src_dont_contact_yn = src_dont_contact_yn;
	}
	public String getSrc_email() {
		return src_email;
	}
	public void setSrc_email(String src_email) {
		this.src_email = src_email;
	}
	public String getSrc_exclusive_source_yn() {
		return src_exclusive_source_yn;
	}
	public void setSrc_exclusive_source_yn(String src_exclusive_source_yn) {
		this.src_exclusive_source_yn = src_exclusive_source_yn;
	}
	public String getSrc_fax() {
		return src_fax;
	}
	public void setSrc_fax(String src_fax) {
		this.src_fax = src_fax;
	}
	public String getSrc_first_name() {
		return src_first_name;
	}
	public void setSrc_first_name(String src_first_name) {
		this.src_first_name = src_first_name;
	}
	public int getSrc_id() {
		return src_id;
	}
	public void setSrc_id(int src_id) {
		this.src_id = src_id;
	}
	public String getSrc_industry_sector() {
		return src_industry_sector;
	}
	public void setSrc_industry_sector(String src_industry_sector) {
		this.src_industry_sector = src_industry_sector;
	}
	public String getSrc_industry_view() {
		return src_industry_view;
	}
	public void setSrc_industry_view(String src_industry_view) {
		this.src_industry_view = src_industry_view;
	}
	public String getSrc_job_description() {
		return src_job_description;
	}
	public void setSrc_job_description(String src_job_description) {
		this.src_job_description = src_job_description;
	}
	public String getSrc_job_title() {
		return src_job_title;
	}
	public void setSrc_job_title(String src_job_title) {
		this.src_job_title = src_job_title;
	}
	public String getSrc_last_name() {
		return src_last_name;
	}
	public void setSrc_last_name(String src_last_name) {
		this.src_last_name = src_last_name;
	}
	public String getSrc_modified_by() {
		return src_modified_by;
	}
	public void setSrc_modified_by(String src_modified_by) {
		this.src_modified_by = src_modified_by;
	}
	public java.sql.Timestamp getSrc_modified_date() {
		return src_modified_date;
	}
	public void setSrc_modified_date(java.sql.Timestamp src_modified_date) {
		this.src_modified_date = src_modified_date;
	}
	public String getSrc_phone() {
		return src_phone;
	}
	public void setSrc_phone(String src_phone) {
		this.src_phone = src_phone;
	}
	public String getSrc_phone_ext() {
		return src_phone_ext;
	}
	public void setSrc_phone_ext(String src_phone_ext) {
		this.src_phone_ext = src_phone_ext;
	}
	public String getSrc_quality_rating() {
		return src_quality_rating;
	}
	public void setSrc_quality_rating(String src_quality_rating) {
		this.src_quality_rating = src_quality_rating;
	}
	public String getSrc_reporters_notes() {
		return src_reporters_notes;
	}
	public void setSrc_reporters_notes(String src_reporters_notes) {
		this.src_reporters_notes = src_reporters_notes;
	}
	public String getSrc_special_requests() {
		return src_special_requests;
	}
	public void setSrc_special_requests(String src_special_requests) {
		this.src_special_requests = src_special_requests;
	}
	public String getSrc_state() {
		return src_state;
	}
	public void setSrc_state(String src_state) {
		this.src_state = src_state;
	}
	public String getSrc_status() {
		return src_status;
	}
	public void setSrc_status(String src_status) {
		this.src_status = src_status;
	}
	public String getSrc_suffix_title() {
		return src_suffix_title;
	}
	public void setSrc_suffix_title(String src_suffix_title) {
		this.src_suffix_title = src_suffix_title;
	}
	public int getSrc_tmz_id() {
		return src_tmz_id;
	}
	public void setSrc_tmz_id(int src_tmz_id) {
		this.src_tmz_id = src_tmz_id;
	}
	public String getSrc_vendors() {
		return src_vendors;
	}
	public void setSrc_vendors(String src_vendors) {
		this.src_vendors = src_vendors;
	}
	public String getSrc_zip() {
		return src_zip;
	}
	public void setSrc_zip(String src_zip) {
		this.src_zip = src_zip;
	}
	public String getSrc_display_name() {
		String displayName = this.src_display_name != null ? this.src_display_name : this.src_courtesy_title + " " + this.src_first_name + " " + this.src_last_name;
                return displayName.replaceAll("null", "");
	}
	public void setSrc_display_name(String style) {
                this.setSrcDisplayNameStyle( style );
		this.src_display_name = (String) new SourceDisplayMap(this).get(style);// map_sourceDisplays.get(style);
	}
        
        public String getSrcDisplayNameStyle() {
            return this.style;
        }
        
        public void setSrcDisplayNameStyle(String st) {
            this.style = st;
        }
        
        public void setSourceAnswersDataSets(LinkedHashMap<Integer, SourceAnswersDataSetInfo> srcAnswersDataSets) {
            this.sourceAnswersDataSets = srcAnswersDataSets;
        }
        
        public LinkedHashMap<Integer, SourceAnswersDataSetInfo> getSourceAnswersDataSets() {
            return this.sourceAnswersDataSets;
        }
	
	public String toString() {
		StringBuilder buff = new StringBuilder("\n___SourceDataSet___\n");
		buff.append("\n	src_id		 " +	this.getSrc_id()	 );
		buff.append("\n	src_last_name		 " +	this.getSrc_last_name()	 );
		buff.append("\n	src_first_name		 " +	this.getSrc_first_name()	 );
		buff.append("\n	src_courtesy_title		 " +	this.getSrc_courtesy_title()	 );
		buff.append("\n	src_job_title		 " +	this.getSrc_job_title()	 );
		buff.append("\n	src_job_description		 " +	this.getSrc_job_description()	 );
		buff.append("\n	src_company		 " +	this.getSrc_company()	 );
		buff.append("\n	src_address1		 " +	this.getSrc_address1()	 );
		buff.append("\n	src_address2		 " +	this.getSrc_address2()	 );
		buff.append("\n	src_address3		 " +	this.getSrc_address3()	 );
		buff.append("\n	src_city		 " +	this.getSrc_city()	 );
		buff.append("\n	src_state		 " +	this.getSrc_state()	 );
		buff.append("\n	src_zip		 " +	this.getSrc_zip()	 );
		buff.append("\n	src_ctry_id		 " +	this.getSrc_ctry_id()	 );
		buff.append("\n	src_tmz_id		 " +	this.getSrc_tmz_id()	 );
		buff.append("\n	src_email		 " +	this.getSrc_email()	 );
		buff.append("\n	src_phone		 " +	this.getSrc_phone()	 );
		buff.append("\n	src_phone_ext		 " +	this.getSrc_phone_ext()	 );
		buff.append("\n	src_cell_phone		 " +	this.getSrc_cell_phone()	 );
		buff.append("\n	src_fax		 " +	this.getSrc_fax()	 );
		buff.append("\n	src_status		 " +	this.getSrc_status()	 );
		buff.append("\n	src_exclusive_source_yn		 " +	this.getSrc_exclusive_source_yn()	 );
		buff.append("\n	src_dont_contact_yn		 " +	this.getSrc_dont_contact_yn()	 );
		buff.append("\n	src_company_type		 " +	this.getSrc_company_type()	 );
		buff.append("\n	src_area_of_expertise		 " +	this.getSrc_area_of_expertise()	 );
		buff.append("\n	src_industry_sector		 " +	this.getSrc_industry_sector()	 );
		buff.append("\n	src_industry_view		 " +	this.getSrc_industry_view()	 );
		buff.append("\n	src_vendors		 " +	this.getSrc_vendors()	 );
		buff.append("\n	src_company_size		 " +	this.getSrc_company_size()	 );
		buff.append("\n	src_distribution_preference		 " +	this.getSrc_distribution_preference()	 );
		buff.append("\n	src_distribution_notes		 " +	this.getSrc_distribution_notes()	 );
		buff.append("\n	src_special_requests		 " +	this.getSrc_special_requests()	 );
		buff.append("\n	src_reporters_notes		 " +	this.getSrc_reporters_notes()	 );
		buff.append("\n	src_quality_rating		 " +	this.getSrc_quality_rating()	 );
		buff.append("\n	src_modified_date		 " +	this.getSrc_modified_date()	 );
		buff.append("\n	src_modified_by		 " +	this.getSrc_modified_by()	 );
		buff.append("\n	src_suffix_title		 " +	this.getSrc_suffix_title()	 );
		buff.append("\n src_display_name		 " +	this.getSrc_display_name()	 );
                buff.append("\n src_offered_report                 " +    this.getSrc_offered_report()       );
	        
                buff.append("\n rps_id                 " +    this.getRps_id()       );
	        buff.append("\n rps_rptr_id                 " +    this.getRps_rptr_id()       );
	        buff.append("\n emp_init                 " +    this.getEmp_init()       );
	        buff.append("\n rps_repeat_source_yn                 " +    this.getRps_repeat_source_yn()       );
                
                
	    buff.append("\n xlInternalId                 " +    this.getXlInternalId()       );
	    buff.append("\n isSrcLocationValid                 " +    this.isSrcLocationValid()       );

                System.out.println("\n\n*******Src answers\n\nsize "+this.getSourceAnswersDataSets().size());
                Set<Integer> qstIds = this.getSourceAnswersDataSets().keySet();
                for (Iterator<Integer> it = qstIds.iterator(); it.hasNext(); ) {
                    int qstId = it.next();
                    SourceAnswersDataSetInfo sad = this.getSourceAnswersDataSets().get(qstId);
                    System.out.println(sad);
                }
                buff.append( "\n___ReportSourceInfo___\n" + this.getReportSourceInfo() );
                buff.append( "\n___ReporterSourceInfo___\n" + this.getReporterSourceInfo() );
		return buff.toString();
	}
    
        public int getRps_id() {
            return this.rps_id;
        }
    
        public void setRps_id(int id) {
            this.rps_id = id;
        }



        public int getRps_rptr_id() {
            return this.rps_rptr_id;
        }

        public void setRps_rptr_id(int id) {
            this.rps_rptr_id = id;
        }

        public void setEmp_init(String init) {
            this.emp_init = init;
        }

        public String getEmp_init() {
            return this.emp_init;
        }
        
        public String getRps_repeat_source_yn() {
            return this.rps_repeat_source_yn;
        }
        
        public void setRps_repeat_source_yn(String repeat) {
            this.rps_repeat_source_yn = repeat;
        }

        


        
    public int compareTo (Object o) {
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;
        
        if ( o == null ) return AFTER;
        
        
        if ( o instanceof SourceDataSetInfo ) {
            if ( this == o ) return EQUAL;
            /*int comparison = this.getSrc_display_name().compareTo(( (SourceInfoDataSet) o ).getSrc_display_name() );
            if ( comparison != EQUAL ) return comparison;*/
            if ( this.getSrc_display_name() == null ) return BEFORE;
            if ( ((SourceDataSetInfo)o).getSrc_display_name() == null ) return AFTER;
            
            return this.getSrc_display_name().compareTo( ((SourceDataSetInfo)o).getSrc_display_name() ); 
        }
        assert(this.equals(o)) : "compareTo inconsistent with equals.";
        return EQUAL;
    }
    
    
    public boolean isNullSrc() {
        // not including values from drop downs for some
        // distribution prefc, 
        String cTitle = this.getSrc_courtesy_title();
        boolean iscTitleNull = (cTitle == null || cTitle.equals(""));
        
        String fName = this.getSrc_first_name();
        boolean isFnameNull = (fName == null || fName.equals(""));
        
        String lName = this.getSrc_last_name();
        boolean isLNameNull = (lName == null || lName.equals(""));
        
        String suffix = this.getSrc_suffix_title();
        boolean isSuffixNull = (suffix == null || suffix.equals(""));
        
        String company = this.getSrc_company();
        boolean isCoNull = (company == null || company.equals(""));
        
        String jTitle = this.getSrc_job_title();
        boolean isjTitleNull = (jTitle == null || jTitle.equals(""));
        
        String city = this.getSrc_city();
        boolean isCityNull = (city == null || city.equals(""));
        
        String state = this.getSrc_state();
        boolean isStateNull = (state == null || state.equals(""));
        
        String zip = this.getSrc_zip();
        boolean isZipNull = (zip == null || zip.equals(""));
        
        int tz = this.getSrc_tmz_id();
        boolean isTzNull = (tz <= 0);
        
        String jDesc = this.getSrc_job_description();
        boolean isJDescNull = (jDesc == null || jDesc.equals(""));
        
        String cType = this.getSrc_company_type();
        boolean isCTypeNull = (cType == null || cType.equals(""));
        
        String cSize = this.getSrc_company_size();
        boolean isCSizeNull = (cSize == null || cSize.equals(""));
        
        String indView = this.getSrc_industry_view();
        boolean isIndViewNull = (indView == null || indView.equals(""));
        
        String indSector = this.getSrc_industry_sector();
        boolean isIndSectorNull = (indSector == null || indSector.equals(""));
        
        String qltyRating = this.getSrc_quality_rating();
        boolean isQltyratingNull = (qltyRating == null || qltyRating.equals(""));
        
        String phone = this.getSrc_phone();
        boolean isPhNull = (phone == null || phone.equals(""));
        
        String extn = this.getSrc_phone_ext();
        boolean isExtnNull = (extn == null || extn.equals(""));
        
        String email = this.getSrc_email();
        boolean isEmailNull = ( email == null || email.equals(""));
        
        String cellPhone = this.getSrc_cell_phone();
        boolean isCellNull = ( cellPhone == null || cellPhone.equals(""));
        
        String fax = this.getSrc_fax();
        boolean isFaxNull = ( fax == null || fax.equals(""));
        
        String address1 = this.getSrc_address1();
        boolean isAddress1Null = ( address1 == null || address1.equals(""));
        
        String address2 = this.getSrc_address2();
        boolean isAddress2Null = ( address2 == null || address2.equals(""));
                
        String address3 = this.getSrc_address3();
        boolean isAddress3Null = ( address3 == null || address3.equals(""));
        
        int ctryId = this.getSrc_ctry_id();
        boolean isCtryIdNull = (ctryId <= 0);
        
        return (iscTitleNull && isFnameNull && isLNameNull && isSuffixNull && isCoNull && isjTitleNull
                && isCityNull && isStateNull && isZipNull && isTzNull && isJDescNull && isCTypeNull && isCSizeNull 
                && isIndViewNull && isIndSectorNull && isQltyratingNull && isPhNull && isExtnNull && isEmailNull
                && isCellNull && isFaxNull && isAddress1Null && isAddress2Null && isAddress3Null
                && isCtryIdNull );
    }
    
    public boolean isValid() {
        // fname, lname, company, city, phone, ctry
        String fName = this.getSrc_first_name();
        boolean isFnameOk = (fName != null && !fName.equals(""));
        
        String lName = this.getSrc_last_name();
        boolean isLNameOk = (lName != null && !lName.equals(""));
        
        String company = this.getSrc_company();
        boolean isCoOk = (company != null && !company.equals(""));
        
        String city = this.getSrc_city();
        boolean isCityOk = (city != null && !city.equals(""));
        
        String phone = this.getSrc_phone();
        boolean isPhOk = (phone != null && !phone.equals(""));
        
        int ctryId = this.getSrc_ctry_id();
        boolean isCtryIdOK = (ctryId != 0);
        
        return (isFnameOk && isLNameOk && isCoOk && isCityOk && isPhOk && isCtryIdOK);
        
    }
    
    public boolean equals( Object o) {
        if ( this == o ) return true;
        if ( !(o instanceof SourceDataSetInfo) ) return false;
        
        SourceDataSetInfo s = (SourceDataSetInfo) o;
        
        return 
            ( this.getSrc_last_name().equals(s.getSrc_last_name()) ) &&
            ( this.getSrc_first_name().equals(s.getSrc_first_name()) ) &&
            ( this.getSrc_company().equals(s.getSrc_company()) ) &&
            ( this.getSrc_job_title().equals(s.getSrc_job_title()) ) &&
            ( this.getSrc_city().equals(s.getSrc_city()) ) &&          
            ( this.getSrc_industry_sector().equals(s.getSrc_industry_sector()) ) 
        ;
    }
    
    public int hashCode() {    
         int result = HashCodeUtil.SEED;
         result = HashCodeUtil.hash(result, this.getSrc_first_name());
         result = HashCodeUtil.hash(result, this.getSrc_last_name());
         result = HashCodeUtil.hash(result, this.getSrc_company());
         result = HashCodeUtil.hash(result, this.getSrc_job_title());
         result = HashCodeUtil.hash(result, this.getSrc_city());
         result = HashCodeUtil.hash(result, this.getSrc_industry_sector());
         return result;
    }
    
    public String getSrc_country_name() {
        return this.src_country_name;
    }
    
    public void setSrc_country_name(String na) {
        this.src_country_name = na;
    }
    
    
    public String getSrc_offered_report() {
        return this.src_offered_report;
    }
    
    public void setSrc_offered_report(String off) {
        this.src_offered_report = off;
    }
    
    public int getSrc_rprt_id() {
        return this.src_rprt_id;
    }
    
    public void setSrc_rprt_id(int id) {
        this.src_rprt_id = id;
    }
    
    public String getRps_comped_yn() {
        return this.rps_comped_yn;
    }
    
    public void setRps_comped_yn(String comp) {
        this.rps_comped_yn = comp;
    }
    
    public String getRps_delete_yn() {
        return this.rps_delete_yn;
    }
    
    public void setRps_delete_yn(String delete) {
        this.rps_delete_yn = delete;
    }
    
    
    public ReportSourcesDataSetInfo getReportSourceInfo() {
        return this.reportSourceInfo;
    }
    
    public void setReportSourceInfo(ReportSourcesDataSetInfo inf) {
        this.reportSourceInfo = inf;
    }
    

    public ReporterSourcesDataSetInfo getReporterSourceInfo() {
        return this.reporterSourceInfo;
    }
    public void setReporterSourceInfo( ReporterSourcesDataSetInfo inf ) {
        this.reporterSourceInfo = inf;
    }
    
    public int getXlInternalId() {
        return this.xlInternalId;
    }
    
    public void setXlInternalId(int id) {
        this.xlInternalId = id;
    }
    
    
    public String getSrc_informed_of_website() {
        return this.src_informed_of_website;
    }
    
    public void setSrc_informed_of_website(String inf) {
        this.src_informed_of_website = inf;
    }
    
    public boolean isSrcLocationValid() {
        return isSrcLocationValid;
    }
    
    public void setIsSrcLocationValid(boolean valid) {
        this.isSrcLocationValid = valid;
    }


//    public int compare(SourceInfoDataSet o1, SourceInfoDataSet o2) {
//        
//        return o1.compareTo(o2);
//    }
}


/**
Seq	
Courtesy Title	
First Name	
Last Name	
Suffix	
Phone*	
Extension	
Company*	
Job Title	
Distribution Preference	
Email	
CellPhone	
Fax	
Address	
Address 2	
Address 3	
Country	
City*	
State	
Zip	
Timezone	
Job Description	
Company Type	
Company Size	
Industry View	
Industry Sector	
Quality Rating	
Exclusive Source	
Don't Contact	
Area of Expertise	
Vendors	Notes	
Distribution Notes	
Offered Report

 */