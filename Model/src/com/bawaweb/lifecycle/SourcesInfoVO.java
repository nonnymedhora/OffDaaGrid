/**
 * @author Nonny Medhora
 */
package com.bawaweb.lifecycle;

import com.bawaweb.grid.templates.data.SourceDisplayMap;
import com.bawaweb.grid.templates.data.tables.SourceDataSet;
import com.bawaweb.grid.templates.data.tables.SourceDataSetInfo;
import com.bawaweb.views.gridcursors.common.SourcesList;
import com.bawaweb.views.gridcursors.common.SourcesListRow;

import com.bawaweb.views.gridcursors.views.common.AllSourcesListViewRow;
import com.bawaweb.views.gridcursors.views.common.SourcesListView;
import com.bawaweb.views.gridcursors.views.common.SourcesListViewRow;

import com.bawaweb.views.model.common.Sources;
import com.bawaweb.views.model.common.SourcesRow;

import oracle.jbo.domain.Number;
import oracle.jbo.domain.Date;

public class SourcesInfoVO {

    private Number srcId;
    private Number rpsId;
    private String srcLastName;
    private String srcFirstName;
    private String srcCourtesyTitle;
    private String srcJobTitle;
    private String srcJobDescription;
    private String srcCompany;
    private String srcAddress1;
    private String srcAddress2;
    private String srcAddress3;
    private String srcCity;
    private String srcState;
    private String srcZip;
    private Number srcCtryId;
    private Number srcTmzId;
    private String srcEmail;
    private String srcPhone;
    private String srcPhoneExt;
    private String srcCellPhone;
    private String srcFax;
    private String srcStatus;
    private String srcExclusiveSourceYn;
    private String srcDontContactYn;
    private String srcCompanyType;
    private String srcAreaOfExpertise;
    private String srcIndustrySector;
    private String srcIndustryView;
    private String srcVendors;
    private String srcCompanySize;
    private String srcDistributionPreference;
    private String srcDistributionNotes;
    private String srcSpecialRequests;
    private String srcReportersNotes;
    private String srcQualityRating;
    private Date srcModifiedDate;
    private String srcModifiedBy;
    private String srcSuffixTitle;
    private String rprtSourceDisplayField;
    private Number rpsRptrId;
    private String rpsRepeatSourceYn;
    private String emplInit;
    private String srcOfferedReport;
    private String srcInformedOfWebsite;
    
    
    private String srcDisplayName;
    

    public SourcesInfoVO() {
    }

    public static void main(String[] args) {
        SourcesInfoVO sourcesInfo = new SourcesInfoVO();
    }
    
    public Object getAttribute(String attribute) {
        if ( attribute.equalsIgnoreCase("srcId" ) ) return srcId;
        if ( attribute.equalsIgnoreCase("rpsId" ) ) return rpsId;
        if ( attribute.equalsIgnoreCase("srcLastName" ) ) return srcLastName;
        if ( attribute.equalsIgnoreCase("srcFirstName" ) ) return srcFirstName;
        if ( attribute.equalsIgnoreCase("srcCourtesyTitle" ) ) return srcCourtesyTitle;
        if ( attribute.equalsIgnoreCase("srcJobTitle" ) ) return srcJobTitle;
        if ( attribute.equalsIgnoreCase("srcJobDescription" ) ) return srcJobDescription;        
        if ( attribute.equalsIgnoreCase("srcCompany" ) ) return srcCompany;
        if ( attribute.equalsIgnoreCase("srcAddress1" ) ) return srcAddress1;
        if ( attribute.equalsIgnoreCase("srcAddress2" ) ) return srcAddress2;
        if ( attribute.equalsIgnoreCase("srcAddress3" ) ) return srcAddress3;
        if ( attribute.equalsIgnoreCase("srcCity" ) ) return srcCity;
        if ( attribute.equalsIgnoreCase("srcState" ) ) return srcState;
        if ( attribute.equalsIgnoreCase("srcZip" ) ) return srcZip;
        if ( attribute.equalsIgnoreCase("srcCtryId" ) ) return srcCtryId;
        if ( attribute.equalsIgnoreCase("srcTmzId" ) ) return srcTmzId;
        if ( attribute.equalsIgnoreCase("srcEmail" ) ) return srcEmail;
        if ( attribute.equalsIgnoreCase("srcPhone" ) ) return srcPhone;
        if ( attribute.equalsIgnoreCase("srcPhoneExt" ) ) return srcPhoneExt;
        if ( attribute.equalsIgnoreCase("srcCellPhone" ) ) return srcCellPhone;
        if ( attribute.equalsIgnoreCase("srcFax" ) ) return srcFax;
        if ( attribute.equalsIgnoreCase("srcStatus" ) ) return srcStatus;
        if ( attribute.equalsIgnoreCase("srcExclusiveSourceYn" ) ) return srcExclusiveSourceYn;
        if ( attribute.equalsIgnoreCase("srcDontContactYn" ) ) return srcDontContactYn;
        if ( attribute.equalsIgnoreCase("srcCompanyType" ) ) return srcCompanyType;
        if ( attribute.equalsIgnoreCase("srcAreaOfExpertise" ) ) return srcAreaOfExpertise;
        if ( attribute.equalsIgnoreCase("srcIndustrySector" ) ) return srcIndustrySector;
        if ( attribute.equalsIgnoreCase("srcIndustryView" ) ) return srcIndustryView;
        if ( attribute.equalsIgnoreCase("srcVendors" ) ) return srcVendors;
        if ( attribute.equalsIgnoreCase("srcCompanySize" ) ) return srcCompanySize;
        if ( attribute.equalsIgnoreCase("srcDistributionPreference" ) ) return srcDistributionPreference;
        if ( attribute.equalsIgnoreCase("srcDistributionNotes" ) ) return srcDistributionNotes;
        if ( attribute.equalsIgnoreCase("srcSpecialRequests" ) ) return srcSpecialRequests;
        if ( attribute.equalsIgnoreCase("srcReportersNotes" ) ) return srcReportersNotes;
        if ( attribute.equalsIgnoreCase("srcQualityRating" ) ) return srcQualityRating;
        if ( attribute.equalsIgnoreCase("srcModifiedDate" ) ) return srcModifiedDate;
        if ( attribute.equalsIgnoreCase("srcModifiedBy" ) ) return srcModifiedBy;
        if ( attribute.equalsIgnoreCase("srcSuffixTitle" ) ) return srcSuffixTitle;
        if ( attribute.equalsIgnoreCase("rprtSourceDisplayField" ) ) return rprtSourceDisplayField;
        if ( attribute.equalsIgnoreCase("rpsRptrId" ) ) return rpsRptrId;
        if ( attribute.equalsIgnoreCase("rpsRepeatSourceYn" ) ) return rpsRepeatSourceYn;
        if ( attribute.equalsIgnoreCase("emplInit" ) ) return emplInit;
        if ( attribute.equalsIgnoreCase("src_display_name" ) ) return srcDisplayName;
        if ( attribute.equalsIgnoreCase("srcOfferedReport" ) ) return srcOfferedReport;
        if ( attribute.equalsIgnoreCase("srcInformedOfWebsite" ) ) return srcInformedOfWebsite;
        return null;
    }
    
    
    public SourcesInfoVO transform(SourceDataSetInfo inf) {
        SourcesInfoVO src = new SourcesInfoVO();
        if ( inf.getSrc_id() >= 0 )          src.setSrcId( new Number( inf.getSrc_id() ) );
        if ( inf.getRps_id() >= 0 )          src.setRpsId( new Number( inf.getRps_id() ) );
        
        src.setSrcLastName( inf.getSrc_last_name() );
        src.setSrcFirstName( inf.getSrc_first_name() );
        src.setSrcCourtesyTitle( inf.getSrc_courtesy_title() );
        src.setSrcJobTitle( inf.getSrc_job_title() );
        src.setSrcJobDescription( inf.getSrc_job_description() );
        src.setSrcCompany( inf.getSrc_company() );
        src.setSrcAddress1( inf.getSrc_address1() );
        src.setSrcAddress2( inf.getSrc_address2() );
        src.setSrcAddress3( inf.getSrc_address3() );
        src.setSrcCity( inf.getSrc_city() );
        src.setSrcState( inf.getSrc_state() );
        src.setSrcZip( inf.getSrc_zip() );
        if ( inf.getSrc_ctry_id() >= 0 )      src.setSrcCtryId( new Number( inf.getSrc_ctry_id() ) );
        if ( inf.getSrc_tmz_id() >= 0 )       src.setSrcTmzId( new Number( inf.getSrc_tmz_id( )) );
        src.setSrcEmail( inf.getSrc_email() );
        src.setSrcPhone( inf.getSrc_phone() );
        src.setSrcPhoneExt( inf.getSrc_phone_ext() );
        src.setSrcCellPhone( inf.getSrc_cell_phone() );
        src.setSrcFax( inf.getSrc_fax() );
        src.setSrcStatus( inf.getSrc_status() );
        src.setSrcExclusiveSourceYn( inf.getSrc_exclusive_source_yn() );
        src.setSrcDontContactYn( inf.getSrc_dont_contact_yn() );
        src.setSrcCompanyType( inf.getSrc_company_type() );
        src.setSrcAreaOfExpertise( inf.getSrc_area_of_expertise() );
        src.setSrcIndustrySector( inf.getSrc_industry_sector() );
        src.setSrcIndustryView( inf.getSrc_industry_view() );
        src.setSrcVendors( inf.getSrc_vendors() );
        src.setSrcCompanySize( inf.getSrc_company_size() );
        src.setSrcDistributionPreference( inf.getSrc_distribution_preference() );
        src.setSrcSpecialRequests( inf.getSrc_special_requests());
        src.setSrcReportersNotes( inf.getSrc_reporters_notes() );
        src.setSrcQualityRating( inf.getSrc_quality_rating() );
        if ( inf.getSrc_modified_date() != null )                src.setSrcModifiedDate( new Date( inf.getSrc_modified_date() ) );
        src.setSrcModifiedBy( inf.getSrc_modified_by() );
        src.setSrcSuffixTitle( inf.getSrc_suffix_title() );
        src.setRprtSourceDisplayField( inf.getSrc_display_name());
        if ( inf.getRps_rptr_id() >= 0 )                      src.setRpsRptrId( new Number( inf.getRps_rptr_id() ) );
        src.setRpsRepeatSourceYn( inf.getRps_repeat_source_yn() );
        src.setSrcOfferedReport( inf.getSrc_offered_report() );
        src.setSrcInformedOfWebsite( inf.getSrc_informed_of_website() );
        src.setEmplInit( inf.getEmp_init() );
        return src;
    }
    
    
    public SourceDataSetInfo transform(SourcesInfoVO info) {
        SourceDataSetInfo src = new SourceDataSet();
        
        if ( info.getSrcId() != null )          src.setSrc_id( info.getSrcId().intValue() );
        if ( info.getRpsId() != null )          src.setRps_id( info.getRpsId().intValue() );
        
        src.setSrc_last_name( info.getSrcLastName() );
        src.setSrc_first_name( info.getSrcFirstName() );
        src.setSrc_courtesy_title( info.getSrcCourtesyTitle() );
        src.setSrc_job_title( info.getSrcJobTitle() );
        src.setSrc_job_description( info.getSrcJobDescription() );
        src.setSrc_company( info.getSrcCompany() );
        src.setSrc_address1( info.getSrcAddress1() );
        src.setSrc_address2( info.getSrcAddress2() );
        src.setSrc_address3( info.getSrcAddress3() );
        src.setSrc_city( info.getSrcCity() );
        src.setSrc_state( info.getSrcState() );
        src.setSrc_zip( info.getSrcZip() );
        if ( info.getSrcCtryId() != null )      src.setSrc_ctry_id( info.getSrcCtryId().intValue() );
        if ( info.getSrcTmzId() != null )       src.setSrc_tmz_id( info.getSrcTmzId().intValue());
        src.setSrc_email( info.getSrcEmail() );
        src.setSrc_phone( info.getSrcPhone() );
        src.setSrc_phone_ext( info.getSrcPhoneExt() );
        src.setSrc_cell_phone( info.getSrcCellPhone() );
        src.setSrc_fax( info.getSrcFax() );
        src.setSrc_status( info.getSrcStatus() );
        src.setSrc_exclusive_source_yn( info.getSrcExclusiveSourceYn() );
        src.setSrc_dont_contact_yn( info.getSrcDontContactYn() );
        src.setSrc_company_type( info.getSrcCompanyType() );
        src.setSrc_area_of_expertise( info.getSrcAreaOfExpertise() );
        src.setSrc_industry_sector( info.getSrcIndustrySector() );
        src.setSrc_industry_view( info.getSrcIndustryView() );
        src.setSrc_vendors( info.getSrcVendors() );
        src.setSrc_company_size( info.getSrcCompanySize() );
        src.setSrc_distribution_preference( info.getSrcDistributionPreference() );
        src.setSrc_special_requests( info.getSrcSpecialRequests());
        src.setSrc_reporters_notes( info.getSrcReportersNotes() );
        src.setSrc_quality_rating( info.getSrcQualityRating() );
        if ( info.getSrcModifiedDate() != null )                src.setSrc_modified_date( info.getSrcModifiedDate().timestampValue() );
        src.setSrc_modified_by( info.getSrcModifiedBy() );
        src.setSrc_suffix_title( info.getSrcSuffixTitle() );
        src.setSrc_display_name( info.getRprtSourceDisplayField());
        if ( info.getRpsRptrId() != null )                      src.setRps_rptr_id( info.getRpsRptrId().intValue() );
        src.setRps_repeat_source_yn( info.getRpsRepeatSourceYn() );
        src.setSrc_offered_report( info.getSrcOfferedReport() );
        src.setSrc_informed_of_website( info.getSrcInformedOfWebsite() );
        src.setEmp_init( info.getEmplInit() );
        
        return src;
        
    }
    
    public SourcesInfoVO transform(AllSourcesListViewRow row) {
        SourcesInfoVO src = new SourcesInfoVO();
        
        src.setSrcId( row.getSrcId() );
        src.setRpsId( row.getRpsId() );
        src.setSrcLastName( row.getSrcLastName() );
        src.setSrcFirstName( row.getSrcFirstName() );
        src.setSrcCourtesyTitle( row.getSrcCourtesyTitle() );
        src.setSrcJobTitle( row.getSrcJobTitle() );
        src.setSrcJobDescription( row.getSrcJobDescription() );
        src.setSrcCompany( row.getSrcCompany() );
        src.setSrcAddress1( row.getSrcAddress1() );
        src.setSrcAddress2( row.getSrcAddress2() );
        src.setSrcAddress3( row.getSrcAddress3() );
        src.setSrcCity( row.getSrcCity() );
        src.setSrcState( row.getSrcState() );
        src.setSrcZip( row.getSrcZip() );
        src.setSrcCtryId( row.getSrcCtryId() );
        src.setSrcTmzId( row.getSrcTmzId() );
        src.setSrcEmail( row.getSrcEmail() );
        src.setSrcPhone( row.getSrcPhone() );
        src.setSrcPhoneExt( row.getSrcPhoneExt() );
        src.setSrcCellPhone( row.getSrcCellPhone() );
        src.setSrcFax( row.getSrcFax() );
        src.setSrcStatus( row.getSrcStatus() );
        src.setSrcExclusiveSourceYn( row.getSrcExclusiveSourceYn() );
        src.setSrcDontContactYn( row.getSrcDontContactYn() );
        src.setSrcCompanyType( row.getSrcCompanyType() );
        src.setSrcAreaOfExpertise( row.getSrcAreaOfExpertise() );
        src.setSrcIndustrySector( row.getSrcIndustrySector() );
        src.setSrcIndustryView( row.getSrcIndustryView() );
        src.setSrcVendors( row.getSrcVendors() );
        src.setSrcCompanySize( row.getSrcCompanySize() );
        src.setSrcDistributionPreference( row.getSrcDistributionPreference() );
        src.setSrcDistributionNotes( row.getSrcDistributionNotes() );
        src.setSrcSpecialRequests( row.getSrcSpecialRequests() );
        src.setSrcReportersNotes( row.getSrcReportersNotes() );
        src.setSrcQualityRating( row.getSrcQualityRating() );
        src.setSrcModifiedDate( row.getSrcModifiedDate() );
        src.setSrcModifiedBy( row.getSrcModifiedBy() );
        src.setSrcSuffixTitle( row.getSrcSuffixTitle() );
        src.setRprtSourceDisplayField( row.getRprtSourceDisplayField() );
        src.setRpsRptrId( row.getRpsRptrId() );
        src.setRpsRepeatSourceYn( row.getRpsRepeatSourceYn() );
        src.setEmplInit( row.getEmplInit() );
        src.setSrcOfferedReport( row.getSrcOfferedReport() );
        src.setSrcInformedOfWebsite( row.getSrcInformedOfWebsite() );
    //        src.setSrc_display_name( row.getSrc_display_name() );
        
        return src;
    }
    
    
    
    public SourcesInfoVO transform(SourcesListViewRow row) {
        SourcesInfoVO src = new SourcesInfoVO();
        
        src.setSrcId( row.getSrcId() );
        src.setRpsId( row.getRpsId() );
        src.setSrcLastName( row.getSrcLastName() );
        src.setSrcFirstName( row.getSrcFirstName() );
        src.setSrcCourtesyTitle( row.getSrcCourtesyTitle() );
        src.setSrcJobTitle( row.getSrcJobTitle() );
        src.setSrcJobDescription( row.getSrcJobDescription() );
        src.setSrcCompany( row.getSrcCompany() );
        src.setSrcAddress1( row.getSrcAddress1() );
        src.setSrcAddress2( row.getSrcAddress2() );
        src.setSrcAddress3( row.getSrcAddress3() );
        src.setSrcCity( row.getSrcCity() );
        src.setSrcState( row.getSrcState() );
        src.setSrcZip( row.getSrcZip() );
        src.setSrcCtryId( row.getSrcCtryId() );
        src.setSrcTmzId( row.getSrcTmzId() );
        src.setSrcEmail( row.getSrcEmail() );
        src.setSrcPhone( row.getSrcPhone() );
        src.setSrcPhoneExt( row.getSrcPhoneExt() );
        src.setSrcCellPhone( row.getSrcCellPhone() );
        src.setSrcFax( row.getSrcFax() );
        src.setSrcStatus( row.getSrcStatus() );
        src.setSrcExclusiveSourceYn( row.getSrcExclusiveSourceYn() );
        src.setSrcDontContactYn( row.getSrcDontContactYn() );
        src.setSrcCompanyType( row.getSrcCompanyType() );
        src.setSrcAreaOfExpertise( row.getSrcAreaOfExpertise() );
        src.setSrcIndustrySector( row.getSrcIndustrySector() );
        src.setSrcIndustryView( row.getSrcIndustryView() );
        src.setSrcVendors( row.getSrcVendors() );
        src.setSrcCompanySize( row.getSrcCompanySize() );
        src.setSrcDistributionPreference( row.getSrcDistributionPreference() );
        src.setSrcDistributionNotes( row.getSrcDistributionNotes() );
        src.setSrcSpecialRequests( row.getSrcSpecialRequests() );
        src.setSrcReportersNotes( row.getSrcReportersNotes() );
        src.setSrcQualityRating( row.getSrcQualityRating() );
        src.setSrcModifiedDate( row.getSrcModifiedDate() );
        src.setSrcModifiedBy( row.getSrcModifiedBy() );
        src.setSrcSuffixTitle( row.getSrcSuffixTitle() );
        src.setRprtSourceDisplayField( row.getRprtSourceDisplayField() );
        src.setRpsRptrId( row.getRpsRptrId() );
        src.setRpsRepeatSourceYn( row.getRpsRepeatSourceYn() );
        src.setEmplInit( row.getEmplInit() );
        src.setSrcOfferedReport( row.getSrcOfferedReport() );
        src.setSrcInformedOfWebsite( row.getSrcInformedOfWebsite() );
//        src.setSrc_display_name( row.getSrc_display_name() );
        
        return src;
    }
    
    public SourcesInfoVO transform(SourcesListRow row) {
        SourcesInfoVO src = new SourcesInfoVO();
        
        src.setSrcId( row.getSrcId() );
        src.setRpsId( row.getRpsId() );
        src.setSrcLastName( row.getSrcLastName() );
        src.setSrcFirstName( row.getSrcFirstName() );
        src.setSrcCourtesyTitle( row.getSrcCourtesyTitle() );
        src.setSrcJobTitle( row.getSrcJobTitle() );
        src.setSrcJobDescription( row.getSrcJobDescription() );
        src.setSrcCompany( row.getSrcCompany() );
        src.setSrcAddress1( row.getSrcAddress1() );
        src.setSrcAddress2( row.getSrcAddress2() );
        src.setSrcAddress3( row.getSrcAddress3() );
        src.setSrcCity( row.getSrcCity() );
        src.setSrcState( row.getSrcState() );
        src.setSrcZip( row.getSrcZip() );
        src.setSrcCtryId( row.getSrcCtryId() );
        src.setSrcTmzId( row.getSrcTmzId() );
        src.setSrcEmail( row.getSrcEmail() );
        src.setSrcPhone( row.getSrcPhone() );
        src.setSrcPhoneExt( row.getSrcPhoneExt() );
        src.setSrcCellPhone( row.getSrcCellPhone() );
        src.setSrcFax( row.getSrcFax() );
        src.setSrcStatus( row.getSrcStatus() );
        src.setSrcExclusiveSourceYn( row.getSrcExclusiveSourceYn() );
        src.setSrcDontContactYn( row.getSrcDontContactYn() );
        src.setSrcCompanyType( row.getSrcCompanyType() );
        src.setSrcAreaOfExpertise( row.getSrcAreaOfExpertise() );
        src.setSrcIndustrySector( row.getSrcIndustrySector() );
        src.setSrcIndustryView( row.getSrcIndustryView() );
        src.setSrcVendors( row.getSrcVendors() );
        src.setSrcCompanySize( row.getSrcCompanySize() );
        src.setSrcDistributionPreference( row.getSrcDistributionPreference() );
        src.setSrcDistributionNotes( row.getSrcDistributionNotes() );
        src.setSrcSpecialRequests( row.getSrcSpecialRequests() );
        src.setSrcReportersNotes( row.getSrcReportersNotes() );
        src.setSrcQualityRating( row.getSrcQualityRating() );
        src.setSrcModifiedDate( row.getSrcModifiedDate() );
        src.setSrcModifiedBy( row.getSrcModifiedBy() );
        src.setSrcSuffixTitle( row.getSrcSuffixTitle() );
        src.setRprtSourceDisplayField( row.getRprtSourceDisplayField() );
        src.setRpsRptrId( row.getRpsRptrId() );
        src.setRpsRepeatSourceYn( row.getRpsRepeatSourceYn() );
        src.setEmplInit( row.getEmplInit() );
        src.setSrcOfferedReport( row.getSrcOfferedReport() );
        src.setSrcInformedOfWebsite( row.getSrcInformedOfWebsite() );
        src.setSrcDisplayName( row.getSrc_display_name() );
        
        return src;
    }
    
    public SourcesListViewRow transform(SourcesListView view, SourcesInfoVO src) {
        SourcesListViewRow row = (SourcesListViewRow) view.createRow();
        row.setSrcId( src.getSrcId() );
        row.setRpsId( src.getRpsId() );
        row.setSrcLastName( src.getSrcLastName() );
        row.setSrcFirstName( src.getSrcFirstName() );
        row.setSrcCourtesyTitle( src.getSrcCourtesyTitle() );
        row.setSrcJobTitle( src.getSrcJobTitle() );
        row.setSrcJobDescription( src.getSrcJobDescription() );
        row.setSrcCompany( src.getSrcCompany() );
        row.setSrcAddress1( src.getSrcAddress1() );
        row.setSrcAddress2( src.getSrcAddress2() );
        row.setSrcAddress3( src.getSrcAddress3() );
        row.setSrcCity( src.getSrcCity() );
        row.setSrcState( src.getSrcState() );
        row.setSrcZip( src.getSrcZip() );
        row.setSrcCtryId( src.getSrcCtryId() );
        row.setSrcTmzId( src.getSrcTmzId() );
        row.setSrcEmail( src.getSrcEmail() );
        row.setSrcPhone( src.getSrcPhone() );
        row.setSrcPhoneExt( src.getSrcPhoneExt() );
        row.setSrcCellPhone( src.getSrcCellPhone() );
        row.setSrcFax( src.getSrcFax() );
        row.setSrcStatus( src.getSrcStatus() );
        row.setSrcExclusiveSourceYn( src.getSrcExclusiveSourceYn() );
        row.setSrcDontContactYn( src.getSrcDontContactYn() );
        row.setSrcCompanyType( src.getSrcCompanyType() );
        row.setSrcAreaOfExpertise( src.getSrcAreaOfExpertise() );
        row.setSrcIndustrySector( src.getSrcIndustrySector() );
        row.setSrcIndustryView( src.getSrcIndustryView() );
        row.setSrcVendors( src.getSrcVendors() );
        row.setSrcCompanySize( src.getSrcCompanySize() );
        row.setSrcDistributionPreference( src.getSrcDistributionPreference() );
        row.setSrcDistributionNotes( src.getSrcDistributionNotes() );
        row.setSrcSpecialRequests( src.getSrcSpecialRequests() );
        row.setSrcReportersNotes( src.getSrcReportersNotes() );
        row.setSrcQualityRating( src.getSrcQualityRating() );
        row.setSrcModifiedDate( src.getSrcModifiedDate() );
        row.setSrcModifiedBy( src.getSrcModifiedBy() );
        row.setSrcSuffixTitle( src.getSrcSuffixTitle() );
        row.setRprtSourceDisplayField( src.getRprtSourceDisplayField() );
        row.setRpsRptrId( src.getRpsRptrId() );
        row.setRpsRepeatSourceYn( src.getRpsRepeatSourceYn() );
        row.setEmplInit( src.getEmplInit() );
        row.setSrcOfferedReport( src.getSrcOfferedReport() );
        row.setSrcInformedOfWebsite( src.getSrcInformedOfWebsite() );
//        row.setSrc_display_name( src.getSrc_display_name() );
        
        return row;
    }
    
    public SourcesListRow transform(SourcesList view, SourcesInfoVO src) {
        SourcesListRow row = (SourcesListRow) view.createRow();
        row.setSrcId( src.getSrcId() );
        row.setRpsId( src.getRpsId() );
        row.setSrcLastName( src.getSrcLastName() );
        row.setSrcFirstName( src.getSrcFirstName() );
        row.setSrcCourtesyTitle( src.getSrcCourtesyTitle() );
        row.setSrcJobTitle( src.getSrcJobTitle() );
        row.setSrcJobDescription( src.getSrcJobDescription() );
        row.setSrcCompany( src.getSrcCompany() );
        row.setSrcAddress1( src.getSrcAddress1() );
        row.setSrcAddress2( src.getSrcAddress2() );
        row.setSrcAddress3( src.getSrcAddress3() );
        row.setSrcCity( src.getSrcCity() );
        row.setSrcState( src.getSrcState() );
        row.setSrcZip( src.getSrcZip() );
        row.setSrcCtryId( src.getSrcCtryId() );
        row.setSrcTmzId( src.getSrcTmzId() );
        row.setSrcEmail( src.getSrcEmail() );
        row.setSrcPhone( src.getSrcPhone() );
        row.setSrcPhoneExt( src.getSrcPhoneExt() );
        row.setSrcCellPhone( src.getSrcCellPhone() );
        row.setSrcFax( src.getSrcFax() );
        row.setSrcStatus( src.getSrcStatus() );
        row.setSrcExclusiveSourceYn( src.getSrcExclusiveSourceYn() );
        row.setSrcDontContactYn( src.getSrcDontContactYn() );
        row.setSrcCompanyType( src.getSrcCompanyType() );
        row.setSrcAreaOfExpertise( src.getSrcAreaOfExpertise() );
        row.setSrcIndustrySector( src.getSrcIndustrySector() );
        row.setSrcIndustryView( src.getSrcIndustryView() );
        row.setSrcVendors( src.getSrcVendors() );
        row.setSrcCompanySize( src.getSrcCompanySize() );
        row.setSrcDistributionPreference( src.getSrcDistributionPreference() );
        row.setSrcDistributionNotes( src.getSrcDistributionNotes() );
        row.setSrcSpecialRequests( src.getSrcSpecialRequests() );
        row.setSrcReportersNotes( src.getSrcReportersNotes() );
        row.setSrcQualityRating( src.getSrcQualityRating() );
        row.setSrcModifiedDate( src.getSrcModifiedDate() );
        row.setSrcModifiedBy( src.getSrcModifiedBy() );
        row.setSrcSuffixTitle( src.getSrcSuffixTitle() );
        row.setRprtSourceDisplayField( src.getRprtSourceDisplayField() );
        row.setRpsRptrId( src.getRpsRptrId() );
        row.setRpsRepeatSourceYn( src.getRpsRepeatSourceYn() );
        row.setEmplInit( src.getEmplInit() );
        row.setSrcOfferedReport( src.getSrcOfferedReport() );
        row.setSrcInformedOfWebsite( src.getSrcInformedOfWebsite() );
        row.setSrc_display_name( src.getSrcDisplayName() );
        
        return row;
    }
    
    
    public SourcesInfoVO transform(SourcesRow row) {
        SourcesInfoVO src = new SourcesInfoVO();
        
        src.setSrcId( row.getSrcId() );
        src.setSrcLastName( row.getSrcLastName() );
        src.setSrcFirstName( row.getSrcFirstName() );
        src.setSrcCourtesyTitle( row.getSrcCourtesyTitle() );
        src.setSrcJobTitle( row.getSrcJobTitle() );
        src.setSrcJobDescription( row.getSrcJobDescription() );
        src.setSrcCompany( row.getSrcCompany() );
        src.setSrcAddress1( row.getSrcAddress1() );
        src.setSrcAddress2( row.getSrcAddress2() );
        src.setSrcAddress3( row.getSrcAddress3() );
        src.setSrcCity( row.getSrcCity() );
        src.setSrcState( row.getSrcState() );
        src.setSrcZip( row.getSrcZip() );
        src.setSrcCtryId( row.getSrcCtryId() );
        src.setSrcTmzId( row.getSrcTmzId() );
        src.setSrcEmail( row.getSrcEmail() );
        src.setSrcPhone( row.getSrcPhone() );
        src.setSrcPhoneExt( row.getSrcPhoneExt() );
        src.setSrcCellPhone( row.getSrcCellPhone() );
        src.setSrcFax( row.getSrcFax() );
        src.setSrcStatus( row.getSrcStatus() );
        src.setSrcExclusiveSourceYn( row.getSrcExclusiveSourceYn() );
        src.setSrcDontContactYn( row.getSrcDontContactYn() );
        src.setSrcCompanyType( row.getSrcCompanyType() );
        src.setSrcAreaOfExpertise( row.getSrcAreaOfExpertise() );
        src.setSrcIndustrySector( row.getSrcIndustrySector() );
        src.setSrcIndustryView( row.getSrcIndustryView() );
        src.setSrcVendors( row.getSrcVendors() );
        src.setSrcCompanySize( row.getSrcCompanySize() );
        src.setSrcDistributionPreference( row.getSrcDistributionPreference() );
        src.setSrcDistributionNotes( row.getSrcDistributionNotes() );
        src.setSrcSpecialRequests( row.getSrcSpecialRequests() );
        src.setSrcReportersNotes( row.getSrcReportersNotes() );
        src.setSrcQualityRating( row.getSrcQualityRating() );
        src.setSrcModifiedDate( row.getSrcModifiedDate() );
        src.setSrcModifiedBy( row.getSrcModifiedBy() );
        src.setSrcSuffixTitle( row.getSrcSuffixTitle() );
        src.setSrcOfferedReport( row.getSrcOfferedReport() );
        src.setSrcInformedOfWebsite( row.getSrcInformedOfWebsite() );
        
        return src;
    }
    
    public SourcesRow transform(Sources view, SourcesInfoVO src) {
        SourcesRow row = (SourcesRow) view.createRow();
        row.setSrcId( src.getSrcId() );
        row.setSrcLastName( src.getSrcLastName() );
        row.setSrcFirstName( src.getSrcFirstName() );
        row.setSrcCourtesyTitle( src.getSrcCourtesyTitle() );
        row.setSrcJobTitle( src.getSrcJobTitle() );
        row.setSrcJobDescription( src.getSrcJobDescription() );
        row.setSrcCompany( src.getSrcCompany() );
        row.setSrcAddress1( src.getSrcAddress1() );
        row.setSrcAddress2( src.getSrcAddress2() );
        row.setSrcAddress3( src.getSrcAddress3() );
        row.setSrcCity( src.getSrcCity() );
        row.setSrcState( src.getSrcState() );
        row.setSrcZip( src.getSrcZip() );
        row.setSrcCtryId( src.getSrcCtryId() );
        row.setSrcTmzId( src.getSrcTmzId() );
        row.setSrcEmail( src.getSrcEmail() );
        row.setSrcPhone( src.getSrcPhone() );
        row.setSrcPhoneExt( src.getSrcPhoneExt() );
        row.setSrcCellPhone( src.getSrcCellPhone() );
        row.setSrcFax( src.getSrcFax() );
        row.setSrcStatus( src.getSrcStatus() );
        row.setSrcExclusiveSourceYn( src.getSrcExclusiveSourceYn() );
        row.setSrcDontContactYn( src.getSrcDontContactYn() );
        row.setSrcCompanyType( src.getSrcCompanyType() );
        row.setSrcAreaOfExpertise( src.getSrcAreaOfExpertise() );
        row.setSrcIndustrySector( src.getSrcIndustrySector() );
        row.setSrcIndustryView( src.getSrcIndustryView() );
        row.setSrcVendors( src.getSrcVendors() );
        row.setSrcCompanySize( src.getSrcCompanySize() );
        row.setSrcDistributionPreference( src.getSrcDistributionPreference() );
        row.setSrcDistributionNotes( src.getSrcDistributionNotes() );
        row.setSrcSpecialRequests( src.getSrcSpecialRequests() );
        row.setSrcReportersNotes( src.getSrcReportersNotes() );
        row.setSrcQualityRating( src.getSrcQualityRating() );
        row.setSrcModifiedDate( src.getSrcModifiedDate() );
        row.setSrcModifiedBy( src.getSrcModifiedBy() );
        row.setSrcSuffixTitle( src.getSrcSuffixTitle() );
        row.setSrcOfferedReport( src.getSrcOfferedReport() );
        row.setSrcInformedOfWebsite( src.getSrcInformedOfWebsite() );
        return row;
    }

    public void setSrcId(Number srcId) {
        this.srcId = srcId;
    }

    public Number getSrcId() {
        return srcId;
    }

    public void setRpsId(Number rpsId) {
        this.rpsId = rpsId;
    }

    public Number getRpsId() {
        return rpsId;
    }

    public void setSrcLastName(String srcLastName) {
        this.srcLastName = srcLastName;
    }

    public String getSrcLastName() {
        return srcLastName;
    }

    public void setSrcFirstName(String srcFirstName) {
        this.srcFirstName = srcFirstName;
    }

    public String getSrcFirstName() {
        return srcFirstName;
    }

    public void setSrcCourtesyTitle(String srcCourtesyTitle) {
        this.srcCourtesyTitle = srcCourtesyTitle;
    }

    public String getSrcCourtesyTitle() {
        return srcCourtesyTitle;
    }

    public void setSrcJobTitle(String srcJobTitle) {
        this.srcJobTitle = srcJobTitle;
    }

    public String getSrcJobTitle() {
        return srcJobTitle;
    }

    public void setSrcJobDescription(String srcJobDescription) {
        this.srcJobDescription = srcJobDescription;
    }

    public String getSrcJobDescription() {
        return srcJobDescription;
    }

    public void setSrcCompany(String srcCompany) {
        this.srcCompany = srcCompany;
    }

    public String getSrcCompany() {
        return srcCompany;
    }

    public void setSrcAddress1(String srcAddress1) {
        this.srcAddress1 = srcAddress1;
    }

    public String getSrcAddress1() {
        return srcAddress1;
    }

    public void setSrcAddress2(String srcAddress2) {
        this.srcAddress2 = srcAddress2;
    }

    public String getSrcAddress2() {
        return srcAddress2;
    }

    public void setSrcAddress3(String srcAddress3) {
        this.srcAddress3 = srcAddress3;
    }

    public String getSrcAddress3() {
        return srcAddress3;
    }

    public void setSrcCity(String srcCity) {
        this.srcCity = srcCity;
    }

    public String getSrcCity() {
        return srcCity;
    }

    public void setSrcState(String srcState) {
        this.srcState = srcState;
    }

    public String getSrcState() {
        return srcState;
    }

    public void setSrcZip(String srcZip) {
        this.srcZip = srcZip;
    }

    public String getSrcZip() {
        return srcZip;
    }

    public void setSrcCtryId(Number srcCtryId) {
        this.srcCtryId = srcCtryId;
    }

    public Number getSrcCtryId() {
        return srcCtryId;
    }

    public void setSrcTmzId(Number srcTmzId) {
        this.srcTmzId = srcTmzId;
    }

    public Number getSrcTmzId() {
        return srcTmzId;
    }

    public void setSrcEmail(String srcEmail) {
        this.srcEmail = srcEmail;
    }

    public String getSrcEmail() {
        return srcEmail;
    }

    public void setSrcPhone(String srcPhone) {
        this.srcPhone = srcPhone;
    }

    public String getSrcPhone() {
        return srcPhone;
    }

    public void setSrcPhoneExt(String srcPhoneExt) {
        this.srcPhoneExt = srcPhoneExt;
    }

    public String getSrcPhoneExt() {
        return srcPhoneExt;
    }

    public void setSrcCellPhone(String srcCellPhone) {
        this.srcCellPhone = srcCellPhone;
    }

    public String getSrcCellPhone() {
        return srcCellPhone;
    }

    public void setSrcFax(String srcFax) {
        this.srcFax = srcFax;
    }

    public String getSrcFax() {
        return srcFax;
    }

    public void setSrcStatus(String srcStatus) {
        this.srcStatus = srcStatus;
    }

    public String getSrcStatus() {
        return srcStatus;
    }

    public void setSrcExclusiveSourceYn(String srcExclusiveSourceYn) {
        this.srcExclusiveSourceYn = srcExclusiveSourceYn;
    }

    public String getSrcExclusiveSourceYn() {
        return srcExclusiveSourceYn;
    }

    public void setSrcDontContactYn(String srcDontContactYn) {
        this.srcDontContactYn = srcDontContactYn;
    }

    public String getSrcDontContactYn() {
        return srcDontContactYn;
    }

    public void setSrcCompanyType(String srcCompanyType) {
        this.srcCompanyType = srcCompanyType;
    }

    public String getSrcCompanyType() {
        return srcCompanyType;
    }

    public void setSrcAreaOfExpertise(String srcAreaOfExpertise) {
        this.srcAreaOfExpertise = srcAreaOfExpertise;
    }

    public String getSrcAreaOfExpertise() {
        return srcAreaOfExpertise;
    }

    public void setSrcIndustrySector(String srcIndustrySector) {
        this.srcIndustrySector = srcIndustrySector;
    }

    public String getSrcIndustrySector() {
        return srcIndustrySector;
    }

    public void setSrcIndustryView(String srcIndustryView) {
        this.srcIndustryView = srcIndustryView;
    }

    public String getSrcIndustryView() {
        return srcIndustryView;
    }

    public void setSrcVendors(String srcVendors) {
        this.srcVendors = srcVendors;
    }

    public String getSrcVendors() {
        return srcVendors;
    }

    public void setSrcCompanySize(String srcCompanySize) {
        this.srcCompanySize = srcCompanySize;
    }

    public String getSrcCompanySize() {
        return srcCompanySize;
    }

    public void setSrcDistributionPreference(String srcDistributionPreference) {
        this.srcDistributionPreference = srcDistributionPreference;
    }

    public String getSrcDistributionPreference() {
        return srcDistributionPreference;
    }

    public void setSrcDistributionNotes(String srcDistributionNotes) {
        this.srcDistributionNotes = srcDistributionNotes;
    }

    public String getSrcDistributionNotes() {
        return srcDistributionNotes;
    }

    public void setSrcSpecialRequests(String srcSpecialRequests) {
        this.srcSpecialRequests = srcSpecialRequests;
    }

    public String getSrcSpecialRequests() {
        return srcSpecialRequests;
    }

    public void setSrcReportersNotes(String srcReportersNotes) {
        this.srcReportersNotes = srcReportersNotes;
    }

    public String getSrcReportersNotes() {
        return srcReportersNotes;
    }

    public void setSrcQualityRating(String srcQualityRating) {
        this.srcQualityRating = srcQualityRating;
    }

    public String getSrcQualityRating() {
        return srcQualityRating;
    }

    public void setSrcModifiedDate(Date srcModifiedDate) {
        this.srcModifiedDate = srcModifiedDate;
    }

    public Date getSrcModifiedDate() {
        return srcModifiedDate;
    }

    public void setSrcModifiedBy(String srcModifiedBy) {
        this.srcModifiedBy = srcModifiedBy;
    }

    public String getSrcModifiedBy() {
        return srcModifiedBy;
    }

    public void setSrcSuffixTitle(String srcSuffixTitle) {
        this.srcSuffixTitle = srcSuffixTitle;
    }

    public String getSrcSuffixTitle() {
        return srcSuffixTitle;
    }

    public void setRprtSourceDisplayField(String rprtSourceDisplayField) {
        this.rprtSourceDisplayField = rprtSourceDisplayField;
    }

    public String getRprtSourceDisplayField() {
        return rprtSourceDisplayField;
    }

    public void setRpsRptrId(Number rpsRptrId) {
        this.rpsRptrId = rpsRptrId;
    }

    public Number getRpsRptrId() {
        return rpsRptrId;
    }

    public void setRpsRepeatSourceYn(String rpsRepeatSourceYn) {
        this.rpsRepeatSourceYn = rpsRepeatSourceYn;
    }

    public String getRpsRepeatSourceYn() {
        return rpsRepeatSourceYn;
    }

    public void setEmplInit(String emplInit) {
        this.emplInit = emplInit;
    }

    public String getEmplInit() {
        return emplInit;
    }

    public void setSrcDisplayName(String style) {
        this.srcDisplayName = (String) new SourceDisplayMap(transform(this)).get(style);// map_sourceDisplays.get(style);
    }

    public String getSrcDisplayName() {
        String displayName = this.srcDisplayName != null ? this.srcDisplayName : this.srcCourtesyTitle + " " + this.srcFirstName + " " + this.srcLastName;
        return displayName.replaceAll("null", "");
    }
    
    
    public String toString() {
        StringBuffer buff = new StringBuffer("\n__SourcesInfoVO___\n");
        buff.append("         srcId       " + this.srcId         + "\n");
        buff.append("         rpsId       " + this.rpsId         + "\n");
        buff.append("         srcLastName         " + this.srcLastName   + "\n");
        buff.append("         srcFirstName        " + this.srcFirstName  + "\n");
        buff.append("         srcCourtesyTitle    " + this.srcCourtesyTitle      + "\n");
        buff.append("         srcJobTitle         " + this.srcJobTitle   + "\n");
        buff.append("         srcJobDescription   " + this.srcJobDescription     + "\n");
        buff.append("         srcCompany          " + this.srcCompany    + "\n");
        buff.append("         srcAddress1         " + this.srcAddress1   + "\n");
        buff.append("         srcAddress2         " + this.srcAddress2   + "\n");
        buff.append("         srcAddress3         " + this.srcAddress3   + "\n");
        buff.append("         srcCity     " + this.srcCity       + "\n");
        buff.append("         srcState    " + this.srcState      + "\n");
        buff.append("         srcZip      " + this.srcZip        + "\n");
        buff.append("         srcCtryId   " + this.srcCtryId     + "\n");
        buff.append("         srcTmzId    " + this.srcTmzId      + "\n");
        buff.append("         srcEmail    " + this.srcEmail      + "\n");
        buff.append("         srcPhone    " + this.srcPhone      + "\n");
        buff.append("         srcPhoneExt         " + this.srcPhoneExt   + "\n");
        buff.append("         srcCellPhone        " + this.srcCellPhone  + "\n");
        buff.append("         srcFax      " + this.srcFax        + "\n");
        buff.append("         srcStatus   " + this.srcStatus     + "\n");
        buff.append("         srcExclusiveSourceYn        " + this.srcExclusiveSourceYn  + "\n");
        buff.append("         srcDontContactYn    " + this.srcDontContactYn      + "\n");
        buff.append("         srcCompanyType      " + this.srcCompanyType        + "\n");
        buff.append("         srcAreaOfExpertise          " + this.srcAreaOfExpertise    + "\n");
        buff.append("         srcIndustrySector   " + this.srcIndustrySector     + "\n");
        buff.append("         srcIndustryView     " + this.srcIndustryView       + "\n");
        buff.append("         srcVendors          " + this.srcVendors    + "\n");
        buff.append("         srcCompanySize      " + this.srcCompanySize        + "\n");
        buff.append("         srcDistributionPreference   " + this.srcDistributionPreference     + "\n");
        buff.append("         srcDistributionNotes        " + this.srcDistributionNotes  + "\n");
        buff.append("         srcSpecialRequests          " + this.srcSpecialRequests    + "\n");
        buff.append("         srcReportersNotes   " + this.srcReportersNotes     + "\n");
        buff.append("         srcQualityRating    " + this.srcQualityRating      + "\n");
        buff.append("         srcModifiedDate     " + this.srcModifiedDate       + "\n");
        buff.append("         srcModifiedBy       " + this.srcModifiedBy         + "\n");
        buff.append("         srcSuffixTitle      " + this.srcSuffixTitle        + "\n");
        buff.append("         rprtSourceDisplayField      " + this.rprtSourceDisplayField        + "\n");
        buff.append("         rpsRptrId   " + this.rpsRptrId     + "\n");
        buff.append("         rpsRepeatSourceYn   " + this.rpsRepeatSourceYn     + "\n");
        buff.append("         emplInit    " + this.emplInit      + "\n");
        buff.append("         src_display_name    " + this.srcDisplayName      + "\n");
        
        return buff.toString();

    }

    public void setSrcInformedOfWebsite(String srcInformedOfWebsite) {
        this.srcInformedOfWebsite = srcInformedOfWebsite;
    }

    public String getSrcInformedOfWebsite() {
        return srcInformedOfWebsite;
    }

    public String get_src_display_name() {
        return srcDisplayName;
    }

    public void setSrcOfferedReport(String srcOfferedReport) {
        this.srcOfferedReport = srcOfferedReport;
    }

    public String getSrcOfferedReport() {
        return srcOfferedReport;
    }

    public String get_srcDisplayName() {
        return srcDisplayName;
    }
}
