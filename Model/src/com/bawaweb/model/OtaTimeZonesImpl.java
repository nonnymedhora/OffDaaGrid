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
public class OtlTimeZonesImpl extends EntityImpl {
    public static final int TMZID = 0;
    public static final int TMZNAME = 1;
    public static final int TMZDESCRIPTION = 2;
    public static final int TMZGMTADJUSTMENTHRS = 3;
    public static final int TMZGMTADJUSTMENTMIN = 4;
    public static final int TMZDELETEYN = 5;
    public static final int BaWaWEBSOURCES = 6;
    private static OtlTimeZonesDefImpl mDefinitionObject;

    /**This is the default constructor (do not remove)
     */
    public OtlTimeZonesImpl() {
    }


    /**Retrieves the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = (OtlTimeZonesDefImpl)EntityDefImpl.findDefObject("com.bawaweb.model.OtlTimeZones");
        }
        return mDefinitionObject;
    }

    /**Gets the attribute value for TmzId, using the alias name TmzId
     */
    public Number getTmzId() {
        return (Number)getAttributeInternal(TMZID);
    }

    /**Sets <code>value</code> as the attribute value for TmzId
     */
    public void setTmzId(Number value) {
        setAttributeInternal(TMZID, value);
    }

    /**Gets the attribute value for TmzName, using the alias name TmzName
     */
    public String getTmzName() {
        return (String)getAttributeInternal(TMZNAME);
    }

    /**Sets <code>value</code> as the attribute value for TmzName
     */
    public void setTmzName(String value) {
        setAttributeInternal(TMZNAME, value);
    }

    /**Gets the attribute value for TmzDescription, using the alias name TmzDescription
     */
    public String getTmzDescription() {
        return (String)getAttributeInternal(TMZDESCRIPTION);
    }

    /**Sets <code>value</code> as the attribute value for TmzDescription
     */
    public void setTmzDescription(String value) {
        setAttributeInternal(TMZDESCRIPTION, value);
    }

    /**Gets the attribute value for TmzGmtAdjustmentHrs, using the alias name TmzGmtAdjustmentHrs
     */
    public Number getTmzGmtAdjustmentHrs() {
        return (Number)getAttributeInternal(TMZGMTADJUSTMENTHRS);
    }

    /**Sets <code>value</code> as the attribute value for TmzGmtAdjustmentHrs
     */
    public void setTmzGmtAdjustmentHrs(Number value) {
        setAttributeInternal(TMZGMTADJUSTMENTHRS, value);
    }

    /**Gets the attribute value for TmzGmtAdjustmentMin, using the alias name TmzGmtAdjustmentMin
     */
    public Number getTmzGmtAdjustmentMin() {
        return (Number)getAttributeInternal(TMZGMTADJUSTMENTMIN);
    }

    /**Sets <code>value</code> as the attribute value for TmzGmtAdjustmentMin
     */
    public void setTmzGmtAdjustmentMin(Number value) {
        setAttributeInternal(TMZGMTADJUSTMENTMIN, value);
    }

    /**Gets the attribute value for TmzDeleteYn, using the alias name TmzDeleteYn
     */
    public String getTmzDeleteYn() {
        return (String)getAttributeInternal(TMZDELETEYN);
    }

    /**Sets <code>value</code> as the attribute value for TmzDeleteYn
     */
    public void setTmzDeleteYn(String value) {
        setAttributeInternal(TMZDELETEYN, value);
    }

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case TMZID:
            return getTmzId();
        case TMZNAME:
            return getTmzName();
        case TMZDESCRIPTION:
            return getTmzDescription();
        case TMZGMTADJUSTMENTHRS:
            return getTmzGmtAdjustmentHrs();
        case TMZGMTADJUSTMENTMIN:
            return getTmzGmtAdjustmentMin();
        case TMZDELETEYN:
            return getTmzDeleteYn();
        case BaWaWEBSOURCES:
            return getOtlSources();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value, 
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case TMZID:
            setTmzId((Number)value);
            return;
        case TMZNAME:
            setTmzName((String)value);
            return;
        case TMZDESCRIPTION:
            setTmzDescription((String)value);
            return;
        case TMZGMTADJUSTMENTHRS:
            setTmzGmtAdjustmentHrs((Number)value);
            return;
        case TMZGMTADJUSTMENTMIN:
            setTmzGmtAdjustmentMin((Number)value);
            return;
        case TMZDELETEYN:
            setTmzDeleteYn((String)value);
            return;
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }

    /**Gets the associated entity oracle.jbo.RowIterator
     */
    public RowIterator getOtlSources() {
        return (RowIterator)getAttributeInternal(BaWaWEBSOURCES);
    }

    /**Creates a Key object based on given key constituents
     */
    public static Key createPrimaryKey(Number tmzId) {
        return new Key(new Object[]{tmzId});
    }
}