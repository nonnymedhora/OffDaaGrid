package com.bawaweb.views.readable;

import com.bawaweb.model.OtrTabLocksImpl;
import com.bawaweb.views.readable.common.OtrTabLocksRViewRow;

import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class OtrTabLocksRViewRowImpl extends ViewRowImpl implements OtrTabLocksRViewRow {
    public static final int OTLID = 0;
    public static final int OTLTABNAME = 1;
    public static final int OTLTABID = 2;
    public static final int OTLEMPLID = 3;
    public static final int OTLCREATEDDT = 4;

    /**This is the default constructor (do not remove)
     */
    public OtrTabLocksRViewRowImpl() {
    }

    /**Gets the attribute value for the calculated attribute OtlId
     */
    public Number getOtlId() {
        return (Number) getAttributeInternal(OTLID);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute OtlId
     */
    public void setOtlId(Number value) {
        setAttributeInternal(OTLID, value);
    }

    /**Gets the attribute value for the calculated attribute OtlTabName
     */
    public String getOtlTabName() {
        return (String) getAttributeInternal(OTLTABNAME);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute OtlTabName
     */
    public void setOtlTabName(String value) {
        setAttributeInternal(OTLTABNAME, value);
    }

    /**Gets the attribute value for the calculated attribute OtlTabId
     */
    public Number getOtlTabId() {
        return (Number) getAttributeInternal(OTLTABID);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute OtlTabId
     */
    public void setOtlTabId(Number value) {
        setAttributeInternal(OTLTABID, value);
    }

    /**Gets the attribute value for the calculated attribute OtlEmplId
     */
    public String getOtlEmplId() {
        return (String) getAttributeInternal(OTLEMPLID);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute OtlEmplId
     */
    public void setOtlEmplId(String value) {
        setAttributeInternal(OTLEMPLID, value);
    }

    /**Gets the attribute value for the calculated attribute OtlCreatedDt
     */
    public Date getOtlCreatedDt() {
        return (Date) getAttributeInternal(OTLCREATEDDT);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute OtlCreatedDt
     */
    public void setOtlCreatedDt(Date value) {
        setAttributeInternal(OTLCREATEDDT, value);
    }

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case OTLID:
            return getOtlId();
        case OTLTABNAME:
            return getOtlTabName();
        case OTLTABID:
            return getOtlTabId();
        case OTLEMPLID:
            return getOtlEmplId();
        case OTLCREATEDDT:
            return getOtlCreatedDt();
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

    /**Gets OtrTabLocks entity object.
     */
    public OtrTabLocksImpl getOtrTabLocks() {
        return (OtrTabLocksImpl)getEntity(0);
    }
}
