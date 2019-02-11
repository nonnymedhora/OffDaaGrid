package com.bawaweb.model;

import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class OtlReportSourcesImpl extends EntityImpl {
    public static final int RPSID = 0;
    public static final int RPSSRCID = 1;
    public static final int RPSRPRTID = 2;
    public static final int RPSRPTRID = 3;
    public static final int RPSCOMPEDYN = 4;
    public static final int RPSREPEATSOURCEYN = 5;
    public static final int RPSDELETEYN = 6;
    public static final int BaWaWEBSOURCES = 7;
    public static final int BaWaWEBSOURCEANSWERS = 8;
    public static final int BaWaWEBSOURCESORTINGCRITERIA = 9;
    public static final int RPRTREPORTS = 10;
    private static OtlReportSourcesDefImpl mDefinitionObject;

    /**This is the default constructor (do not remove)
     */
    public OtlReportSourcesImpl() {
    }


    /**Retrieves the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = (OtlReportSourcesDefImpl)EntityDefImpl.findDefObject("com.bawaweb.model.OtlReportSources");
        }
        return mDefinitionObject;
    }

    /**Gets the attribute value for RpsId, using the alias name RpsId
     */
    public Number getRpsId() {
        return (Number)getAttributeInternal(RPSID);
    }

    /**Sets <code>value</code> as the attribute value for RpsId
     */
    public void setRpsId(Number value) {
        setAttributeInternal(RPSID, value);
    }

    /**Gets the attribute value for RpsSrcId, using the alias name RpsSrcId
     */
    public Number getRpsSrcId() {
        return (Number)getAttributeInternal(RPSSRCID);
    }

    /**Sets <code>value</code> as the attribute value for RpsSrcId
     */
    public void setRpsSrcId(Number value) {
        setAttributeInternal(RPSSRCID, value);
    }

    /**Gets the attribute value for RpsRprtId, using the alias name RpsRprtId
     */
    public Number getRpsRprtId() {
        return (Number)getAttributeInternal(RPSRPRTID);
    }

    /**Sets <code>value</code> as the attribute value for RpsRprtId
     */
    public void setRpsRprtId(Number value) {
        setAttributeInternal(RPSRPRTID, value);
    }

    /**Gets the attribute value for RpsRptrId, using the alias name RpsRptrId
     */
    public Number getRpsRptrId() {
        return (Number)getAttributeInternal(RPSRPTRID);
    }

    /**Sets <code>value</code> as the attribute value for RpsRptrId
     */
    public void setRpsRptrId(Number value) {
        setAttributeInternal(RPSRPTRID, value);
    }

    /**Gets the attribute value for RpsCompedYn, using the alias name RpsCompedYn
     */
    public String getRpsCompedYn() {
        return (String)getAttributeInternal(RPSCOMPEDYN);
    }

    /**Sets <code>value</code> as the attribute value for RpsCompedYn
     */
    public void setRpsCompedYn(String value) {
        setAttributeInternal(RPSCOMPEDYN, value);
    }

    /**Gets the attribute value for RpsRepeatSourceYn, using the alias name RpsRepeatSourceYn
     */
    public String getRpsRepeatSourceYn() {
        return (String)getAttributeInternal(RPSREPEATSOURCEYN);
    }

    /**Sets <code>value</code> as the attribute value for RpsRepeatSourceYn
     */
    public void setRpsRepeatSourceYn(String value) {
        setAttributeInternal(RPSREPEATSOURCEYN, value);
    }

    /**Gets the attribute value for RpsDeleteYn, using the alias name RpsDeleteYn
     */
    public String getRpsDeleteYn() {
        return (String)getAttributeInternal(RPSDELETEYN);
    }

    /**Sets <code>value</code> as the attribute value for RpsDeleteYn
     */
    public void setRpsDeleteYn(String value) {
        setAttributeInternal(RPSDELETEYN, value);
    }

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case RPSID:
            return getRpsId();
        case RPSSRCID:
            return getRpsSrcId();
        case RPSRPRTID:
            return getRpsRprtId();
        case RPSRPTRID:
            return getRpsRptrId();
        case RPSCOMPEDYN:
            return getRpsCompedYn();
        case RPSREPEATSOURCEYN:
            return getRpsRepeatSourceYn();
        case RPSDELETEYN:
            return getRpsDeleteYn();
        case BaWaWEBSOURCEANSWERS:
            return getOtlSourceAnswers();
        case BaWaWEBSOURCESORTINGCRITERIA:
            return getOtlSourceSortingCriteria();
        case BaWaWEBSOURCES:
            return getOtlSources();
        case RPRTREPORTS:
            return getRprtReports();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value, 
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case RPSID:
            setRpsId((Number)value);
            return;
        case RPSSRCID:
            setRpsSrcId((Number)value);
            return;
        case RPSRPRTID:
            setRpsRprtId((Number)value);
            return;
        case RPSRPTRID:
            setRpsRptrId((Number)value);
            return;
        case RPSCOMPEDYN:
            setRpsCompedYn((String)value);
            return;
        case RPSREPEATSOURCEYN:
            setRpsRepeatSourceYn((String)value);
            return;
        case RPSDELETEYN:
            setRpsDeleteYn((String)value);
            return;
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }

    /**Gets the associated entity OtlSourcesImpl
     */
    public OtlSourcesImpl getOtlSources() {
        return (OtlSourcesImpl)getAttributeInternal(BaWaWEBSOURCES);
    }

    /**Sets <code>value</code> as the associated entity OtlSourcesImpl
     */
    public void setOtlSources(OtlSourcesImpl value) {
        setAttributeInternal(BaWaWEBSOURCES, value);
    }

    /**Gets the associated entity oracle.jbo.RowIterator
     */
    public RowIterator getOtlSourceAnswers() {
        return (RowIterator)getAttributeInternal(BaWaWEBSOURCEANSWERS);
    }

    /**Gets the associated entity oracle.jbo.RowIterator
     */
    public RowIterator getOtlSourceSortingCriteria() {
        return (RowIterator)getAttributeInternal(BaWaWEBSOURCESORTINGCRITERIA);
    }

    /**Gets the associated entity RprtReportsImpl
     */
    public RprtReportsImpl getRprtReports() {
        return (RprtReportsImpl)getAttributeInternal(RPRTREPORTS);
    }

    /**Sets <code>value</code> as the associated entity RprtReportsImpl
     */
    public void setRprtReports(RprtReportsImpl value) {
        setAttributeInternal(RPRTREPORTS, value);
    }

    /**Creates a Key object based on given key constituents
     */
    public static Key createPrimaryKey(Number rpsId) {
        return new Key(new Object[]{rpsId});
    }
}