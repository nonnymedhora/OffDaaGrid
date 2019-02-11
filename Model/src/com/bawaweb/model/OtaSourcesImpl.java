package com.bawaweb.model;

import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class OtlSourcesImpl extends EntityImpl {
    public static final int SRCID = 0;
    public static final int SRCLASTNAME = 1;
    public static final int SRCFIRSTNAME = 2;
    public static final int SRCCOURTESYTITLE = 3;
    public static final int SRCJOBTITLE = 4;
    public static final int SRCJOBDESCRIPTION = 5;
    public static final int SRCCOMPANY = 6;
    public static final int SRCADDRESS1 = 7;
    public static final int SRCADDRESS2 = 8;
    public static final int SRCADDRESS3 = 9;
    public static final int SRCCITY = 10;
    public static final int SRCSTATE = 11;
    public static final int SRCZIP = 12;
    public static final int SRCCTRYID = 13;
    public static final int SRCTMZID = 14;
    public static final int SRCEMAIL = 15;
    public static final int SRCPHONE = 16;
    public static final int SRCPHONEEXT = 17;
    public static final int SRCCELLPHONE = 18;
    public static final int SRCFAX = 19;
    public static final int SRCSTATUS = 20;
    public static final int SRCEXCLUSIVESOURCEYN = 21;
    public static final int SRCDONTCONTACTYN = 22;
    public static final int SRCCOMPANYTYPE = 23;
    public static final int SRCAREAOFEXPERTISE = 24;
    public static final int SRCINDUSTRYSECTOR = 25;
    public static final int SRCINDUSTRYVIEW = 26;
    public static final int SRCVENDORS = 27;
    public static final int SRCCOMPANYSIZE = 28;
    public static final int SRCDISTRIBUTIONPREFERENCE = 29;
    public static final int SRCDISTRIBUTIONNOTES = 30;
    public static final int SRCSPECIALREQUESTS = 31;
    public static final int SRCREPORTERSNOTES = 32;
    public static final int SRCQUALITYRATING = 33;
    public static final int SRCMODIFIEDDATE = 34;
    public static final int SRCMODIFIEDBY = 35;
    public static final int SRCSUFFIXTITLE = 36;
    public static final int SRCINFORMEDOFWEBSITE = 37;
    public static final int SRCOFFEREDREPORT = 38;
    public static final int CTRYCOUNTRIES = 39;
    public static final int BaWaWEBREPORTSOURCES = 40;
    public static final int BaWaWEBTIMEZONES = 41;
    public static final int BaWaWEBREPORTERSOURCES = 42;
    public static final int BaWaWEBSOURCEINDUSTRIES = 43;
    private static OtlSourcesDefImpl mDefinitionObject;

    /**This is the default constructor (do not remove)
     */
    public OtlSourcesImpl() {
    }


    /**Retrieves the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = (OtlSourcesDefImpl)EntityDefImpl.findDefObject("com.bawaweb.model.OtlSources");
        }
        return mDefinitionObject;
    }

    /**Gets the attribute value for SrcId, using the alias name SrcId
     */
    public Number getSrcId() {
        return (Number)getAttributeInternal(SRCID);
    }

    /**Sets <code>value</code> as the attribute value for SrcId
     */
    public void setSrcId(Number value) {
        setAttributeInternal(SRCID, value);
    }

    /**Gets the attribute value for SrcLastName, using the alias name SrcLastName
     */
    public String getSrcLastName() {
        return (String)getAttributeInternal(SRCLASTNAME);
    }

    /**Sets <code>value</code> as the attribute value for SrcLastName
     */
    public void setSrcLastName(String value) {
        setAttributeInternal(SRCLASTNAME, value);
    }

    /**Gets the attribute value for SrcFirstName, using the alias name SrcFirstName
     */
    public String getSrcFirstName() {
        return (String)getAttributeInternal(SRCFIRSTNAME);
    }

    /**Sets <code>value</code> as the attribute value for SrcFirstName
     */
    public void setSrcFirstName(String value) {
        setAttributeInternal(SRCFIRSTNAME, value);
    }

    /**Gets the attribute value for SrcCourtesyTitle, using the alias name SrcCourtesyTitle
     */
    public String getSrcCourtesyTitle() {
        return (String)getAttributeInternal(SRCCOURTESYTITLE);
    }

    /**Sets <code>value</code> as the attribute value for SrcCourtesyTitle
     */
    public void setSrcCourtesyTitle(String value) {
        setAttributeInternal(SRCCOURTESYTITLE, value);
    }

    /**Gets the attribute value for SrcJobTitle, using the alias name SrcJobTitle
     */
    public String getSrcJobTitle() {
        return (String)getAttributeInternal(SRCJOBTITLE);
    }

    /**Sets <code>value</code> as the attribute value for SrcJobTitle
     */
    public void setSrcJobTitle(String value) {
        setAttributeInternal(SRCJOBTITLE, value);
    }

    /**Gets the attribute value for SrcJobDescription, using the alias name SrcJobDescription
     */
    public String getSrcJobDescription() {
        return (String)getAttributeInternal(SRCJOBDESCRIPTION);
    }

    /**Sets <code>value</code> as the attribute value for SrcJobDescription
     */
    public void setSrcJobDescription(String value) {
        setAttributeInternal(SRCJOBDESCRIPTION, value);
    }

    /**Gets the attribute value for SrcCompany, using the alias name SrcCompany
     */
    public String getSrcCompany() {
        return (String)getAttributeInternal(SRCCOMPANY);
    }

    /**Sets <code>value</code> as the attribute value for SrcCompany
     */
    public void setSrcCompany(String value) {
        setAttributeInternal(SRCCOMPANY, value);
    }

    /**Gets the attribute value for SrcAddress1, using the alias name SrcAddress1
     */
    public String getSrcAddress1() {
        return (String)getAttributeInternal(SRCADDRESS1);
    }

    /**Sets <code>value</code> as the attribute value for SrcAddress1
     */
    public void setSrcAddress1(String value) {
        setAttributeInternal(SRCADDRESS1, value);
    }

    /**Gets the attribute value for SrcAddress2, using the alias name SrcAddress2
     */
    public String getSrcAddress2() {
        return (String)getAttributeInternal(SRCADDRESS2);
    }

    /**Sets <code>value</code> as the attribute value for SrcAddress2
     */
    public void setSrcAddress2(String value) {
        setAttributeInternal(SRCADDRESS2, value);
    }

    /**Gets the attribute value for SrcAddress3, using the alias name SrcAddress3
     */
    public String getSrcAddress3() {
        return (String)getAttributeInternal(SRCADDRESS3);
    }

    /**Sets <code>value</code> as the attribute value for SrcAddress3
     */
    public void setSrcAddress3(String value) {
        setAttributeInternal(SRCADDRESS3, value);
    }

    /**Gets the attribute value for SrcCity, using the alias name SrcCity
     */
    public String getSrcCity() {
        return (String)getAttributeInternal(SRCCITY);
    }

    /**Sets <code>value</code> as the attribute value for SrcCity
     */
    public void setSrcCity(String value) {
        setAttributeInternal(SRCCITY, value);
    }

    /**Gets the attribute value for SrcState, using the alias name SrcState
     */
    public String getSrcState() {
        return (String)getAttributeInternal(SRCSTATE);
    }

    /**Sets <code>value</code> as the attribute value for SrcState
     */
    public void setSrcState(String value) {
        setAttributeInternal(SRCSTATE, value);
    }

    /**Gets the attribute value for SrcZip, using the alias name SrcZip
     */
    public String getSrcZip() {
        return (String)getAttributeInternal(SRCZIP);
    }

    /**Sets <code>value</code> as the attribute value for SrcZip
     */
    public void setSrcZip(String value) {
        setAttributeInternal(SRCZIP, value);
    }

    /**Gets the attribute value for SrcCtryId, using the alias name SrcCtryId
     */
    public Number getSrcCtryId() {
        return (Number)getAttributeInternal(SRCCTRYID);
    }

    /**Sets <code>value</code> as the attribute value for SrcCtryId
     */
    public void setSrcCtryId(Number value) {
        setAttributeInternal(SRCCTRYID, value);
    }

    /**Gets the attribute value for SrcTmzId, using the alias name SrcTmzId
     */
    public Number getSrcTmzId() {
        return (Number)getAttributeInternal(SRCTMZID);
    }

    /**Sets <code>value</code> as the attribute value for SrcTmzId
     */
    public void setSrcTmzId(Number value) {
        setAttributeInternal(SRCTMZID, value);
    }

    /**Gets the attribute value for SrcEmail, using the alias name SrcEmail
     */
    public String getSrcEmail() {
        return (String)getAttributeInternal(SRCEMAIL);
    }

    /**Sets <code>value</code> as the attribute value for SrcEmail
     */
    public void setSrcEmail(String value) {
        setAttributeInternal(SRCEMAIL, value);
    }

    /**Gets the attribute value for SrcPhone, using the alias name SrcPhone
     */
    public String getSrcPhone() {
        return (String)getAttributeInternal(SRCPHONE);
    }

    /**Sets <code>value</code> as the attribute value for SrcPhone
     */
    public void setSrcPhone(String value) {
        setAttributeInternal(SRCPHONE, value);
    }

    /**Gets the attribute value for SrcPhoneExt, using the alias name SrcPhoneExt
     */
    public String getSrcPhoneExt() {
        return (String)getAttributeInternal(SRCPHONEEXT);
    }

    /**Sets <code>value</code> as the attribute value for SrcPhoneExt
     */
    public void setSrcPhoneExt(String value) {
        setAttributeInternal(SRCPHONEEXT, value);
    }

    /**Gets the attribute value for SrcCellPhone, using the alias name SrcCellPhone
     */
    public String getSrcCellPhone() {
        return (String)getAttributeInternal(SRCCELLPHONE);
    }

    /**Sets <code>value</code> as the attribute value for SrcCellPhone
     */
    public void setSrcCellPhone(String value) {
        setAttributeInternal(SRCCELLPHONE, value);
    }

    /**Gets the attribute value for SrcFax, using the alias name SrcFax
     */
    public String getSrcFax() {
        return (String)getAttributeInternal(SRCFAX);
    }

    /**Sets <code>value</code> as the attribute value for SrcFax
     */
    public void setSrcFax(String value) {
        setAttributeInternal(SRCFAX, value);
    }

    /**Gets the attribute value for SrcStatus, using the alias name SrcStatus
     */
    public String getSrcStatus() {
        return (String)getAttributeInternal(SRCSTATUS);
    }

    /**Sets <code>value</code> as the attribute value for SrcStatus
     */
    public void setSrcStatus(String value) {
        setAttributeInternal(SRCSTATUS, value);
    }

    /**Gets the attribute value for SrcExclusiveSourceYn, using the alias name SrcExclusiveSourceYn
     */
    public String getSrcExclusiveSourceYn() {
        return (String)getAttributeInternal(SRCEXCLUSIVESOURCEYN);
    }

    /**Sets <code>value</code> as the attribute value for SrcExclusiveSourceYn
     */
    public void setSrcExclusiveSourceYn(String value) {
        setAttributeInternal(SRCEXCLUSIVESOURCEYN, value);
    }

    /**Gets the attribute value for SrcDontContactYn, using the alias name SrcDontContactYn
     */
    public String getSrcDontContactYn() {
        return (String)getAttributeInternal(SRCDONTCONTACTYN);
    }

    /**Sets <code>value</code> as the attribute value for SrcDontContactYn
     */
    public void setSrcDontContactYn(String value) {
        setAttributeInternal(SRCDONTCONTACTYN, value);
    }

    /**Gets the attribute value for SrcCompanyType, using the alias name SrcCompanyType
     */
    public String getSrcCompanyType() {
        return (String)getAttributeInternal(SRCCOMPANYTYPE);
    }

    /**Sets <code>value</code> as the attribute value for SrcCompanyType
     */
    public void setSrcCompanyType(String value) {
        setAttributeInternal(SRCCOMPANYTYPE, value);
    }

    /**Gets the attribute value for SrcAreaOfExpertise, using the alias name SrcAreaOfExpertise
     */
    public String getSrcAreaOfExpertise() {
        return (String)getAttributeInternal(SRCAREAOFEXPERTISE);
    }

    /**Sets <code>value</code> as the attribute value for SrcAreaOfExpertise
     */
    public void setSrcAreaOfExpertise(String value) {
        setAttributeInternal(SRCAREAOFEXPERTISE, value);
    }

    /**Gets the attribute value for SrcIndustrySector, using the alias name SrcIndustrySector
     */
    public String getSrcIndustrySector() {
        return (String)getAttributeInternal(SRCINDUSTRYSECTOR);
    }

    /**Sets <code>value</code> as the attribute value for SrcIndustrySector
     */
    public void setSrcIndustrySector(String value) {
        setAttributeInternal(SRCINDUSTRYSECTOR, value);
    }

    /**Gets the attribute value for SrcIndustryView, using the alias name SrcIndustryView
     */
    public String getSrcIndustryView() {
        return (String)getAttributeInternal(SRCINDUSTRYVIEW);
    }

    /**Sets <code>value</code> as the attribute value for SrcIndustryView
     */
    public void setSrcIndustryView(String value) {
        setAttributeInternal(SRCINDUSTRYVIEW, value);
    }

    /**Gets the attribute value for SrcVendors, using the alias name SrcVendors
     */
    public String getSrcVendors() {
        return (String)getAttributeInternal(SRCVENDORS);
    }

    /**Sets <code>value</code> as the attribute value for SrcVendors
     */
    public void setSrcVendors(String value) {
        setAttributeInternal(SRCVENDORS, value);
    }

    /**Gets the attribute value for SrcCompanySize, using the alias name SrcCompanySize
     */
    public String getSrcCompanySize() {
        return (String)getAttributeInternal(SRCCOMPANYSIZE);
    }

    /**Sets <code>value</code> as the attribute value for SrcCompanySize
     */
    public void setSrcCompanySize(String value) {
        setAttributeInternal(SRCCOMPANYSIZE, value);
    }

    /**Gets the attribute value for SrcDistributionPreference, using the alias name SrcDistributionPreference
     */
    public String getSrcDistributionPreference() {
        return (String)getAttributeInternal(SRCDISTRIBUTIONPREFERENCE);
    }

    /**Sets <code>value</code> as the attribute value for SrcDistributionPreference
     */
    public void setSrcDistributionPreference(String value) {
        setAttributeInternal(SRCDISTRIBUTIONPREFERENCE, value);
    }

    /**Gets the attribute value for SrcDistributionNotes, using the alias name SrcDistributionNotes
     */
    public String getSrcDistributionNotes() {
        return (String)getAttributeInternal(SRCDISTRIBUTIONNOTES);
    }

    /**Sets <code>value</code> as the attribute value for SrcDistributionNotes
     */
    public void setSrcDistributionNotes(String value) {
        setAttributeInternal(SRCDISTRIBUTIONNOTES, value);
    }

    /**Gets the attribute value for SrcSpecialRequests, using the alias name SrcSpecialRequests
     */
    public String getSrcSpecialRequests() {
        return (String)getAttributeInternal(SRCSPECIALREQUESTS);
    }

    /**Sets <code>value</code> as the attribute value for SrcSpecialRequests
     */
    public void setSrcSpecialRequests(String value) {
        setAttributeInternal(SRCSPECIALREQUESTS, value);
    }

    /**Gets the attribute value for SrcReportersNotes, using the alias name SrcReportersNotes
     */
    public String getSrcReportersNotes() {
        return (String)getAttributeInternal(SRCREPORTERSNOTES);
    }

    /**Sets <code>value</code> as the attribute value for SrcReportersNotes
     */
    public void setSrcReportersNotes(String value) {
        setAttributeInternal(SRCREPORTERSNOTES, value);
    }

    /**Gets the attribute value for SrcQualityRating, using the alias name SrcQualityRating
     */
    public String getSrcQualityRating() {
        return (String)getAttributeInternal(SRCQUALITYRATING);
    }

    /**Sets <code>value</code> as the attribute value for SrcQualityRating
     */
    public void setSrcQualityRating(String value) {
        setAttributeInternal(SRCQUALITYRATING, value);
    }

    /**Gets the attribute value for SrcModifiedDate, using the alias name SrcModifiedDate
     */
    public Date getSrcModifiedDate() {
        return (Date)getAttributeInternal(SRCMODIFIEDDATE);
    }

    /**Sets <code>value</code> as the attribute value for SrcModifiedDate
     */
    public void setSrcModifiedDate(Date value) {
        setAttributeInternal(SRCMODIFIEDDATE, value);
    }

    /**Gets the attribute value for SrcModifiedBy, using the alias name SrcModifiedBy
     */
    public String getSrcModifiedBy() {
        return (String)getAttributeInternal(SRCMODIFIEDBY);
    }

    /**Sets <code>value</code> as the attribute value for SrcModifiedBy
     */
    public void setSrcModifiedBy(String value) {
        setAttributeInternal(SRCMODIFIEDBY, value);
    }

    /**Gets the attribute value for SrcSuffixTitle, using the alias name SrcSuffixTitle
     */
    public String getSrcSuffixTitle() {
        return (String)getAttributeInternal(SRCSUFFIXTITLE);
    }

    /**Sets <code>value</code> as the attribute value for SrcSuffixTitle
     */
    public void setSrcSuffixTitle(String value) {
        setAttributeInternal(SRCSUFFIXTITLE, value);
    }

    /**Gets the attribute value for SrcInformedOfWebsite, using the alias name SrcInformedOfWebsite
     */
    public String getSrcInformedOfWebsite() {
        return (String)getAttributeInternal(SRCINFORMEDOFWEBSITE);
    }

    /**Sets <code>value</code> as the attribute value for SrcInformedOfWebsite
     */
    public void setSrcInformedOfWebsite(String value) {
        setAttributeInternal(SRCINFORMEDOFWEBSITE, value);
    }

    /**Gets the attribute value for SrcOfferedReport, using the alias name SrcOfferedReport
     */
    public String getSrcOfferedReport() {
        return (String)getAttributeInternal(SRCOFFEREDREPORT);
    }

    /**Sets <code>value</code> as the attribute value for SrcOfferedReport
     */
    public void setSrcOfferedReport(String value) {
        setAttributeInternal(SRCOFFEREDREPORT, value);
    }

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case SRCID:
            return getSrcId();
        case SRCLASTNAME:
            return getSrcLastName();
        case SRCFIRSTNAME:
            return getSrcFirstName();
        case SRCCOURTESYTITLE:
            return getSrcCourtesyTitle();
        case SRCJOBTITLE:
            return getSrcJobTitle();
        case SRCJOBDESCRIPTION:
            return getSrcJobDescription();
        case SRCCOMPANY:
            return getSrcCompany();
        case SRCADDRESS1:
            return getSrcAddress1();
        case SRCADDRESS2:
            return getSrcAddress2();
        case SRCADDRESS3:
            return getSrcAddress3();
        case SRCCITY:
            return getSrcCity();
        case SRCSTATE:
            return getSrcState();
        case SRCZIP:
            return getSrcZip();
        case SRCCTRYID:
            return getSrcCtryId();
        case SRCTMZID:
            return getSrcTmzId();
        case SRCEMAIL:
            return getSrcEmail();
        case SRCPHONE:
            return getSrcPhone();
        case SRCPHONEEXT:
            return getSrcPhoneExt();
        case SRCCELLPHONE:
            return getSrcCellPhone();
        case SRCFAX:
            return getSrcFax();
        case SRCSTATUS:
            return getSrcStatus();
        case SRCEXCLUSIVESOURCEYN:
            return getSrcExclusiveSourceYn();
        case SRCDONTCONTACTYN:
            return getSrcDontContactYn();
        case SRCCOMPANYTYPE:
            return getSrcCompanyType();
        case SRCAREAOFEXPERTISE:
            return getSrcAreaOfExpertise();
        case SRCINDUSTRYSECTOR:
            return getSrcIndustrySector();
        case SRCINDUSTRYVIEW:
            return getSrcIndustryView();
        case SRCVENDORS:
            return getSrcVendors();
        case SRCCOMPANYSIZE:
            return getSrcCompanySize();
        case SRCDISTRIBUTIONPREFERENCE:
            return getSrcDistributionPreference();
        case SRCDISTRIBUTIONNOTES:
            return getSrcDistributionNotes();
        case SRCSPECIALREQUESTS:
            return getSrcSpecialRequests();
        case SRCREPORTERSNOTES:
            return getSrcReportersNotes();
        case SRCQUALITYRATING:
            return getSrcQualityRating();
        case SRCMODIFIEDDATE:
            return getSrcModifiedDate();
        case SRCMODIFIEDBY:
            return getSrcModifiedBy();
        case SRCSUFFIXTITLE:
            return getSrcSuffixTitle();
        case SRCINFORMEDOFWEBSITE:
            return getSrcInformedOfWebsite();
        case SRCOFFEREDREPORT:
            return getSrcOfferedReport();
        case BaWaWEBREPORTSOURCES:
            return getOtlReportSources();
        case BaWaWEBREPORTERSOURCES:
            return getOtlReporterSources();
        case BaWaWEBSOURCEINDUSTRIES:
            return getOtlSourceIndustries();
        case CTRYCOUNTRIES:
            return getCtryCountries();
        case BaWaWEBTIMEZONES:
            return getOtlTimeZones();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value, 
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case SRCID:
            setSrcId((Number)value);
            return;
        case SRCLASTNAME:
            setSrcLastName((String)value);
            return;
        case SRCFIRSTNAME:
            setSrcFirstName((String)value);
            return;
        case SRCCOURTESYTITLE:
            setSrcCourtesyTitle((String)value);
            return;
        case SRCJOBTITLE:
            setSrcJobTitle((String)value);
            return;
        case SRCJOBDESCRIPTION:
            setSrcJobDescription((String)value);
            return;
        case SRCCOMPANY:
            setSrcCompany((String)value);
            return;
        case SRCADDRESS1:
            setSrcAddress1((String)value);
            return;
        case SRCADDRESS2:
            setSrcAddress2((String)value);
            return;
        case SRCADDRESS3:
            setSrcAddress3((String)value);
            return;
        case SRCCITY:
            setSrcCity((String)value);
            return;
        case SRCSTATE:
            setSrcState((String)value);
            return;
        case SRCZIP:
            setSrcZip((String)value);
            return;
        case SRCCTRYID:
            setSrcCtryId((Number)value);
            return;
        case SRCTMZID:
            setSrcTmzId((Number)value);
            return;
        case SRCEMAIL:
            setSrcEmail((String)value);
            return;
        case SRCPHONE:
            setSrcPhone((String)value);
            return;
        case SRCPHONEEXT:
            setSrcPhoneExt((String)value);
            return;
        case SRCCELLPHONE:
            setSrcCellPhone((String)value);
            return;
        case SRCFAX:
            setSrcFax((String)value);
            return;
        case SRCSTATUS:
            setSrcStatus((String)value);
            return;
        case SRCEXCLUSIVESOURCEYN:
            setSrcExclusiveSourceYn((String)value);
            return;
        case SRCDONTCONTACTYN:
            setSrcDontContactYn((String)value);
            return;
        case SRCCOMPANYTYPE:
            setSrcCompanyType((String)value);
            return;
        case SRCAREAOFEXPERTISE:
            setSrcAreaOfExpertise((String)value);
            return;
        case SRCINDUSTRYSECTOR:
            setSrcIndustrySector((String)value);
            return;
        case SRCINDUSTRYVIEW:
            setSrcIndustryView((String)value);
            return;
        case SRCVENDORS:
            setSrcVendors((String)value);
            return;
        case SRCCOMPANYSIZE:
            setSrcCompanySize((String)value);
            return;
        case SRCDISTRIBUTIONPREFERENCE:
            setSrcDistributionPreference((String)value);
            return;
        case SRCDISTRIBUTIONNOTES:
            setSrcDistributionNotes((String)value);
            return;
        case SRCSPECIALREQUESTS:
            setSrcSpecialRequests((String)value);
            return;
        case SRCREPORTERSNOTES:
            setSrcReportersNotes((String)value);
            return;
        case SRCQUALITYRATING:
            setSrcQualityRating((String)value);
            return;
        case SRCMODIFIEDDATE:
            setSrcModifiedDate((Date)value);
            return;
        case SRCMODIFIEDBY:
            setSrcModifiedBy((String)value);
            return;
        case SRCSUFFIXTITLE:
            setSrcSuffixTitle((String)value);
            return;
        case SRCINFORMEDOFWEBSITE:
            setSrcInformedOfWebsite((String)value);
            return;
        case SRCOFFEREDREPORT:
            setSrcOfferedReport((String)value);
            return;
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }

    /**Gets the associated entity CtryCountriesImpl
     */
    public CtryCountriesImpl getCtryCountries() {
        return (CtryCountriesImpl)getAttributeInternal(CTRYCOUNTRIES);
    }

    /**Sets <code>value</code> as the associated entity CtryCountriesImpl
     */
    public void setCtryCountries(CtryCountriesImpl value) {
        setAttributeInternal(CTRYCOUNTRIES, value);
    }

    /**Gets the associated entity oracle.jbo.RowIterator
     */
    public RowIterator getOtlReportSources() {
        return (RowIterator)getAttributeInternal(BaWaWEBREPORTSOURCES);
    }

    /**Gets the associated entity OtlTimeZonesImpl
     */
    public OtlTimeZonesImpl getOtlTimeZones() {
        return (OtlTimeZonesImpl)getAttributeInternal(BaWaWEBTIMEZONES);
    }

    /**Sets <code>value</code> as the associated entity OtlTimeZonesImpl
     */
    public void setOtlTimeZones(OtlTimeZonesImpl value) {
        setAttributeInternal(BaWaWEBTIMEZONES, value);
    }

    /**Gets the associated entity oracle.jbo.RowIterator
     */
    public RowIterator getOtlReporterSources() {
        return (RowIterator)getAttributeInternal(BaWaWEBREPORTERSOURCES);
    }

    /**Gets the associated entity oracle.jbo.RowIterator
     */
    public RowIterator getOtlSourceIndustries() {
        return (RowIterator)getAttributeInternal(BaWaWEBSOURCEINDUSTRIES);
    }

    /**Creates a Key object based on given key constituents
     */
    public static Key createPrimaryKey(Number srcId) {
        return new Key(new Object[]{srcId});
    }
}
