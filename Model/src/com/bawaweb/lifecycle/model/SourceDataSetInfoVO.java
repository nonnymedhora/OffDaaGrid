/**
 * @author Nonny Medhora
 */
package com.bawaweb.lifecycle.model;

import com.bawaweb.grid.templates.data.tables.SourceDataSetInfo;
import java.sql.SQLException;

import java.sql.Timestamp;

import oracle.jbo.ApplicationModule;
import oracle.jbo.domain.Number;
import oracle.jbo.domain.Sequence;
 
public class SourceDataSetInfoVO {

    private Number  srcId;
    private String  srcLastName;
    private String  srcFirstName;
    private String  srcCourtesyTitle;
    private String  srcJobTitle;
    private String  srcJobDescription;
    private String  srcCompany;
    private String  srcAddress1;
    private String  srcAddress2;
    private String  srcAddress3;
    private String  srcCity;
    private String  srcState;
    private String  src_zip;
    private Number  srcCtryId;
    private Number  srcTmzId;
    private String  srcEmail;
    private String  srcPhone;
    private String  srcPhoneExt;
    private String  srcCellPhone;
    private String  srcFax;
    private String  srcStatus;
    private String  srcExclusiveSourceYn;
    private String  srcDontContactYn;
    private String  srcCompanyType;
    private String  srcAreaOfExpertise;
    private String  srcIndustrySector;
    private String  srcIndustryView;
    private String  srcVendors;
    private String  srcCompanySize;
    private String  srcDistributionPreference;
    private String  srcDistributionNotes;
    private String  srcSpecialRequests;
    private String  srcReportersNotes;
    private String  srcQualityRating;
    private Timestamp      srcModifiedDate;
    private String  srcModifiedBy;
    private String  srcSuffixTitle;
    
    private String srcDisplayName;        //  matches to rprtSourceDisplayField in rprtReports// otaSources
    

    private Number rpsId;                  // reprt src id in otaReportSources
    private Number rpsRptrId;             // reporter's in otaReportSources
    private String empInit;                // initials for the reporter in emplOtl-employees
    private String rpsRepeatSourceYn;    // wheteher the sources is a repeat source from otaReportSources
    
    private String srcCountryName;
    
    private String style;
    private String srcOfferedReport;
    private String srcInformedOfWebsite;

    public SourceDataSetInfoVO() {
    }
    
    public Object getAttribute(String attribute) {
        if ( attribute.equalsIgnoreCase("srcId") ) return srcId;
        if ( attribute.equalsIgnoreCase("srcLastName") ) return srcLastName;
        if ( attribute.equalsIgnoreCase("srcFirstName") ) return srcFirstName;
        if ( attribute.equalsIgnoreCase("srcCourtesyTitle") ) return srcCourtesyTitle;
        if ( attribute.equalsIgnoreCase("srcJobTitle") ) return srcJobTitle;
        if ( attribute.equalsIgnoreCase("srcJobDescription") ) return srcJobDescription;
        if ( attribute.equalsIgnoreCase("srcCompany") ) return srcCompany;
        if ( attribute.equalsIgnoreCase("srcAddress1") ) return srcAddress1;
        if ( attribute.equalsIgnoreCase("srcAddress2") ) return srcAddress2;
        if ( attribute.equalsIgnoreCase("srcAddress3") ) return srcAddress3;
        if ( attribute.equalsIgnoreCase("srcCity") ) return srcCity;
        if ( attribute.equalsIgnoreCase("srcState") ) return srcState;
        if ( attribute.equalsIgnoreCase("src_zip") ) return src_zip;
        if ( attribute.equalsIgnoreCase("srcCtryId") ) return srcCtryId;
        if ( attribute.equalsIgnoreCase("srcTmzId") ) return srcTmzId;
        if ( attribute.equalsIgnoreCase("srcEmail") ) return srcEmail;
        if ( attribute.equalsIgnoreCase("srcPhone") ) return srcPhone;
        if ( attribute.equalsIgnoreCase("srcPhoneExt") ) return srcPhoneExt;
        if ( attribute.equalsIgnoreCase("srcCellPhone") ) return srcCellPhone;
        if ( attribute.equalsIgnoreCase("srcFax") ) return srcFax;
        if ( attribute.equalsIgnoreCase("srcStatus") ) return srcStatus;
        if ( attribute.equalsIgnoreCase("srcExclusiveSourceYn") ) return srcExclusiveSourceYn;
        if ( attribute.equalsIgnoreCase("srcDontContactYn") ) return srcDontContactYn;
        if ( attribute.equalsIgnoreCase("srcCompanyType") ) return srcCompanyType;
        if ( attribute.equalsIgnoreCase("srcAreaOfExpertise") ) return srcAreaOfExpertise;
        if ( attribute.equalsIgnoreCase("srcIndustrySector") ) return srcIndustrySector;
        if ( attribute.equalsIgnoreCase("srcIndustryView") ) return srcIndustryView;
        if ( attribute.equalsIgnoreCase("srcVendors") ) return srcVendors;
        if ( attribute.equalsIgnoreCase("srcCompanySize") ) return srcCompanySize;
        if ( attribute.equalsIgnoreCase("srcDistributionPreference") ) return srcDistributionPreference;
        if ( attribute.equalsIgnoreCase("srcDistributionNotes") ) return srcDistributionNotes;
        if ( attribute.equalsIgnoreCase("srcSpecialRequests") ) return srcSpecialRequests;
        if ( attribute.equalsIgnoreCase("srcReportersNotes") ) return srcReportersNotes;
        if ( attribute.equalsIgnoreCase("srcQualityRating") ) return srcQualityRating;
        if ( attribute.equalsIgnoreCase("    srcModifiedDate") ) return srcModifiedDate;
        if ( attribute.equalsIgnoreCase("srcModifiedBy") ) return srcModifiedBy;
        if ( attribute.equalsIgnoreCase("srcSuffixTitle") ) return srcSuffixTitle;
        if ( attribute.equalsIgnoreCase("srcDisplayName") ) return srcDisplayName;
        if ( attribute.equalsIgnoreCase("rpsId") ) return rpsId;
        if ( attribute.equalsIgnoreCase("rpsRptrId") ) return rpsRptrId;
        if ( attribute.equalsIgnoreCase("empInit") ) return empInit;
        if ( attribute.equalsIgnoreCase("rpsRepeatSourceYn") ) return rpsRepeatSourceYn;
        if ( attribute.equalsIgnoreCase("srcCountryName") ) return srcCountryName;
        if ( attribute.equalsIgnoreCase("style") ) return style;
        if ( attribute.equalsIgnoreCase("srcOfferedReport") ) return srcOfferedReport;
        if ( attribute.equalsIgnoreCase("srcInformedOfWebsite") ) return srcInformedOfWebsite;
        
        return null;

    }

    public static void main(String[] args) {
        SourceDataSetInfoVO sourceDataSetInfoVO = new SourceDataSetInfoVO();
    }

    public void setSrcId(Number srcId) {
        this.srcId = srcId;
    }

    public Number getSrcId() {
        return srcId;
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

    public void setSrc_zip(String src_zip) {
        this.src_zip = src_zip;
    }

    public String getSrc_zip() {
        return src_zip;
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

    public void setSrcModifiedDate(Timestamp srcModifiedDate) {
        this.srcModifiedDate = srcModifiedDate;
    }

    public Timestamp getSrcModifiedDate() {
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

    public void setSrcDisplayName(String srcDisplayName) {
        this.srcDisplayName = srcDisplayName;
    }

    public String getSrcDisplayName() {
        return srcDisplayName;
    }

    public void setRpsId(Number rpsId) {
        this.rpsId = rpsId;
    }

    public Number getRpsId() {
        return rpsId;
    }

    public void setRpsRptrId(Number rpsRptrId) {
        this.rpsRptrId = rpsRptrId;
    }

    public Number getRpsRptrId() {
        return rpsRptrId;
    }

    public void setEmpInit(String empInit) {
        this.empInit = empInit;
    }

    public String getEmpInit() {
        return empInit;
    }

    public void setRpsRepeatSourceYn(String rpsRepeatSourceYn) {
        this.rpsRepeatSourceYn = rpsRepeatSourceYn;
    }

    public String getRpsRepeatSourceYn() {
        return rpsRepeatSourceYn;
    }

    public void setSrcCountryName(String srcCountryName) {
        this.srcCountryName = srcCountryName;
    }

    public String getSrcCountryName() {
        return srcCountryName;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getStyle() {
        return style;
    }

    public void setSrcOfferedReport(String srcOfferedReport) {
        this.srcOfferedReport = srcOfferedReport;
    }

    public String getSrcOfferedReport() {
        return srcOfferedReport;
    }

    public void setSrcInformedOfWebsite(String srcInformedOfWebsite) {
        this.srcInformedOfWebsite = srcInformedOfWebsite;
    }

    public String getSrcInformedOfWebsite() {
        return srcInformedOfWebsite;
    }
}
