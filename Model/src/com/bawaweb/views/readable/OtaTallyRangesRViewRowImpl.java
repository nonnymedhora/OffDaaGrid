package com.bawaweb.views.readable;

import com.bawaweb.model.OtlTallyRangesImpl;

import com.bawaweb.views.readable.common.OtlTallyRangesRViewRow;

import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class OtlTallyRangesRViewRowImpl extends ViewRowImpl implements OtlTallyRangesRViewRow {
    public static final int TLYID = 0;
    public static final int TLYNAME = 1;
    public static final int TLYPREFIX = 2;
    public static final int TLYSUFFIX = 3;
    public static final int TLYDELETEYN = 4;

    /**This is the default constructor (do not remove)
     */
    public OtlTallyRangesRViewRowImpl() {
    }

    /**Gets the attribute value for the calculated attribute TlyId
     */
    public Number getTlyId() {
        return (Number) getAttributeInternal(TLYID);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute TlyId
     */
    public void setTlyId(Number value) {
        setAttributeInternal(TLYID, value);
    }

    /**Gets the attribute value for the calculated attribute TlyName
     */
    public String getTlyName() {
        return (String) getAttributeInternal(TLYNAME);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute TlyName
     */
    public void setTlyName(String value) {
        setAttributeInternal(TLYNAME, value);
    }

    /**Gets the attribute value for the calculated attribute TlyPrefix
     */
    public String getTlyPrefix() {
        return (String) getAttributeInternal(TLYPREFIX);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute TlyPrefix
     */
    public void setTlyPrefix(String value) {
        setAttributeInternal(TLYPREFIX, value);
    }

    /**Gets the attribute value for the calculated attribute TlySuffix
     */
    public String getTlySuffix() {
        return (String) getAttributeInternal(TLYSUFFIX);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute TlySuffix
     */
    public void setTlySuffix(String value) {
        setAttributeInternal(TLYSUFFIX, value);
    }

    /**Gets the attribute value for the calculated attribute TlyDeleteYn
     */
    public String getTlyDeleteYn() {
        return (String) getAttributeInternal(TLYDELETEYN);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute TlyDeleteYn
     */
    public void setTlyDeleteYn(String value) {
        setAttributeInternal(TLYDELETEYN, value);
    }

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case TLYID:
            return getTlyId();
        case TLYNAME:
            return getTlyName();
        case TLYPREFIX:
            return getTlyPrefix();
        case TLYSUFFIX:
            return getTlySuffix();
        case TLYDELETEYN:
            return getTlyDeleteYn();
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

    /**Gets OtlTallyRanges entity object.
     */
    public OtlTallyRangesImpl getOtlTallyRanges() {
        return (OtlTallyRangesImpl)getEntity(0);
    }
}
