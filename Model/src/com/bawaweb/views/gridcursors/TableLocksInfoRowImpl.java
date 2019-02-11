package com.bawaweb.views.gridcursors;

import com.bawaweb.model.OtrTabLocksImpl;

import com.bawaweb.views.gridcursors.common.TableLocksInfoRow;

import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class TableLocksInfoRowImpl extends ViewRowImpl implements TableLocksInfoRow {
    public static final int OTLID = 0;
    public static final int OTLTABNAME = 1;
    public static final int OTLTABID = 2;
    public static final int OTLEMPLID = 3;
    public static final int OTLCREATEDDT = 4;
    public static final int OTLSTATUS = 5;

    /**This is the default constructor (do not remove)
     */
    public TableLocksInfoRowImpl() {
    }

    /**Gets OtrTabLocks entity object.
     */
    public OtrTabLocksImpl getOtrTabLocks() {
        return (OtrTabLocksImpl)getEntity(0);
    }

    /**Gets the attribute value for OTL_ID using the alias name OtlId
     */
    public Number getOtlId() {
        return (Number) getAttributeInternal(OTLID);
    }

    /**Sets <code>value</code> as attribute value for OTL_ID using the alias name OtlId
     */
    public void setOtlId(Number value) {
        setAttributeInternal(OTLID, value);
    }

    /**Gets the attribute value for OTL_TAB_NAME using the alias name OtlTabName
     */
    public String getOtlTabName() {
        return (String) getAttributeInternal(OTLTABNAME);
    }

    /**Sets <code>value</code> as attribute value for OTL_TAB_NAME using the alias name OtlTabName
     */
    public void setOtlTabName(String value) {
        setAttributeInternal(OTLTABNAME, value);
    }

    /**Gets the attribute value for OTL_TAB_ID using the alias name OtlTabId
     */
    public Number getOtlTabId() {
        return (Number) getAttributeInternal(OTLTABID);
    }

    /**Sets <code>value</code> as attribute value for OTL_TAB_ID using the alias name OtlTabId
     */
    public void setOtlTabId(Number value) {
        setAttributeInternal(OTLTABID, value);
    }

    /**Gets the attribute value for OTL_EMPL_ID using the alias name OtlEmplId
     */
    public String getOtlEmplId() {
        return (String) getAttributeInternal(OTLEMPLID);
    }

    /**Sets <code>value</code> as attribute value for OTL_EMPL_ID using the alias name OtlEmplId
     */
    public void setOtlEmplId(String value) {
        setAttributeInternal(OTLEMPLID, value);
    }

    /**Gets the attribute value for OTL_CREATED_DT using the alias name OtlCreatedDt
     */
    public Date getOtlCreatedDt() {
        return (Date) getAttributeInternal(OTLCREATEDDT);
    }

    /**Sets <code>value</code> as attribute value for OTL_CREATED_DT using the alias name OtlCreatedDt
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
        case OTLSTATUS:
            return getOtlStatus();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value, 
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case OTLID:
            setOtlId((Number)value);
            return;
        case OTLTABNAME:
            setOtlTabName((String)value);
            return;
        case OTLTABID:
            setOtlTabId((Number)value);
            return;
        case OTLEMPLID:
            setOtlEmplId((String)value);
            return;
        case OTLCREATEDDT:
            setOtlCreatedDt((Date)value);
            return;
        case OTLSTATUS:
            setOtlStatus((String)value);
            return;
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }

    /**Gets the attribute value for the calculated attribute OtlStatus
     */
    public String getOtlStatus() {
        return (String) getAttributeInternal(OTLSTATUS);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute OtlStatus
     */
    public void setOtlStatus(String value) {
        setAttributeInternal(OTLSTATUS, value);
    }
}
