package com.bawaweb.views.updatable;

import com.bawaweb.model.OtlRolesImpl;

import com.bawaweb.views.updatable.common.OtlRolesUViewRow;

import oracle.jbo.RowIterator;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class OtlRolesUViewRowImpl extends ViewRowImpl implements OtlRolesUViewRow {
    public static final int ROLID = 0;
    public static final int ROLNAME = 1;
    public static final int ROLSRCINDYN = 2;
    public static final int ROLRPRTINDYN = 3;
    public static final int ROLSRCRPRTYN = 4;
    public static final int ROLDISPLAYORDER = 5;
    public static final int BaWaWEBEMPLROLESUVIEW = 6;

    /**This is the default constructor (do not remove)
     */
    public OtlRolesUViewRowImpl() {
    }

    /**Gets OtlRoles entity object.
     */
    public OtlRolesImpl getOtlRoles() {
        return (OtlRolesImpl)getEntity(0);
    }

    /**Gets the attribute value for ROL_ID using the alias name RolId
     */
    public Number getRolId() {
        return (Number) getAttributeInternal(ROLID);
    }

    /**Sets <code>value</code> as attribute value for ROL_ID using the alias name RolId
     */
    public void setRolId(Number value) {
        setAttributeInternal(ROLID, value);
    }

    /**Gets the attribute value for ROL_NAME using the alias name RolName
     */
    public String getRolName() {
        return (String) getAttributeInternal(ROLNAME);
    }

    /**Sets <code>value</code> as attribute value for ROL_NAME using the alias name RolName
     */
    public void setRolName(String value) {
        setAttributeInternal(ROLNAME, value);
    }

    /**Gets the attribute value for ROL_SRC_IND_YN using the alias name RolSrcIndYn
     */
    public String getRolSrcIndYn() {
        return (String) getAttributeInternal(ROLSRCINDYN);
    }

    /**Sets <code>value</code> as attribute value for ROL_SRC_IND_YN using the alias name RolSrcIndYn
     */
    public void setRolSrcIndYn(String value) {
        setAttributeInternal(ROLSRCINDYN, value);
    }

    /**Gets the attribute value for ROL_RPRT_IND_YN using the alias name RolRprtIndYn
     */
    public String getRolRprtIndYn() {
        return (String) getAttributeInternal(ROLRPRTINDYN);
    }

    /**Sets <code>value</code> as attribute value for ROL_RPRT_IND_YN using the alias name RolRprtIndYn
     */
    public void setRolRprtIndYn(String value) {
        setAttributeInternal(ROLRPRTINDYN, value);
    }

    /**Gets the attribute value for ROL_SRC_RPRT_YN using the alias name RolSrcRprtYn
     */
    public String getRolSrcRprtYn() {
        return (String) getAttributeInternal(ROLSRCRPRTYN);
    }

    /**Sets <code>value</code> as attribute value for ROL_SRC_RPRT_YN using the alias name RolSrcRprtYn
     */
    public void setRolSrcRprtYn(String value) {
        setAttributeInternal(ROLSRCRPRTYN, value);
    }

    /**Gets the attribute value for ROL_DISPLAY_ORDER using the alias name RolDisplayOrder
     */
    public Number getRolDisplayOrder() {
        return (Number) getAttributeInternal(ROLDISPLAYORDER);
    }

    /**Sets <code>value</code> as attribute value for ROL_DISPLAY_ORDER using the alias name RolDisplayOrder
     */
    public void setRolDisplayOrder(Number value) {
        setAttributeInternal(ROLDISPLAYORDER, value);
    }

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case ROLID:
            return getRolId();
        case ROLNAME:
            return getRolName();
        case ROLSRCINDYN:
            return getRolSrcIndYn();
        case ROLRPRTINDYN:
            return getRolRprtIndYn();
        case ROLSRCRPRTYN:
            return getRolSrcRprtYn();
        case ROLDISPLAYORDER:
            return getRolDisplayOrder();
        case BaWaWEBEMPLROLESUVIEW:
            return getOtlEmplRolesUView();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value, 
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case ROLID:
            setRolId((Number)value);
            return;
        case ROLNAME:
            setRolName((String)value);
            return;
        case ROLSRCINDYN:
            setRolSrcIndYn((String)value);
            return;
        case ROLRPRTINDYN:
            setRolRprtIndYn((String)value);
            return;
        case ROLSRCRPRTYN:
            setRolSrcRprtYn((String)value);
            return;
        case ROLDISPLAYORDER:
            setRolDisplayOrder((Number)value);
            return;
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }

    /**Gets the associated <code>RowIterator</code> using master-detail link OtlEmplRolesUView
     */
    public RowIterator getOtlEmplRolesUView() {
        return (RowIterator)getAttributeInternal(BaWaWEBEMPLROLESUVIEW);
    }
}
