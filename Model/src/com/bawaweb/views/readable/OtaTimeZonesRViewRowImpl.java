package com.bawaweb.views.readable;

import com.bawaweb.model.OtlTimeZonesImpl;

import com.bawaweb.views.readable.common.OtlTimeZonesRViewRow;

import oracle.jbo.RowIterator;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class OtlTimeZonesRViewRowImpl extends ViewRowImpl implements OtlTimeZonesRViewRow {
    public static final int TMZID = 0;
    public static final int TMZNAME = 1;
    public static final int TMZDESCRIPTION = 2;
    public static final int TMZGMTADJUSTMENTHRS = 3;
    public static final int TMZGMTADJUSTMENTMIN = 4;
    public static final int TMZDELETEYN = 5;
    public static final int BaWaWEBSOURCESRVIEW = 6;

    /**This is the default constructor (do not remove)
     */
    public OtlTimeZonesRViewRowImpl() {
    }

    /**Gets the attribute value for the calculated attribute TmzId
     */
    public Number getTmzId() {
        return (Number) getAttributeInternal(TMZID);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute TmzId
     */
    public void setTmzId(Number value) {
        setAttributeInternal(TMZID, value);
    }

    /**Gets the attribute value for the calculated attribute TmzName
     */
    public String getTmzName() {
        return (String) getAttributeInternal(TMZNAME);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute TmzName
     */
    public void setTmzName(String value) {
        setAttributeInternal(TMZNAME, value);
    }

    /**Gets the attribute value for the calculated attribute TmzDescription
     */
    public String getTmzDescription() {
        return (String) getAttributeInternal(TMZDESCRIPTION);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute TmzDescription
     */
    public void setTmzDescription(String value) {
        setAttributeInternal(TMZDESCRIPTION, value);
    }

    /**Gets the attribute value for the calculated attribute TmzGmtAdjustmentHrs
     */
    public Number getTmzGmtAdjustmentHrs() {
        return (Number) getAttributeInternal(TMZGMTADJUSTMENTHRS);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute TmzGmtAdjustmentHrs
     */
    public void setTmzGmtAdjustmentHrs(Number value) {
        setAttributeInternal(TMZGMTADJUSTMENTHRS, value);
    }

    /**Gets the attribute value for the calculated attribute TmzGmtAdjustmentMin
     */
    public Number getTmzGmtAdjustmentMin() {
        return (Number) getAttributeInternal(TMZGMTADJUSTMENTMIN);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute TmzGmtAdjustmentMin
     */
    public void setTmzGmtAdjustmentMin(Number value) {
        setAttributeInternal(TMZGMTADJUSTMENTMIN, value);
    }

    /**Gets the attribute value for the calculated attribute TmzDeleteYn
     */
    public String getTmzDeleteYn() {
        return (String) getAttributeInternal(TMZDELETEYN);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute TmzDeleteYn
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
        case BaWaWEBSOURCESRVIEW:
            return getOtlSourcesRView();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value, 
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }

    /**Gets the associated <code>RowIterator</code> using master-detail link OtlSourcesRView
     */
    public RowIterator getOtlSourcesRView() {
        return (RowIterator)getAttributeInternal(BaWaWEBSOURCESRVIEW);
    }

    /**Gets OtlTimeZones entity object.
     */
    public OtlTimeZonesImpl getOtlTimeZones() {
        return (OtlTimeZonesImpl)getEntity(0);
    }
}
