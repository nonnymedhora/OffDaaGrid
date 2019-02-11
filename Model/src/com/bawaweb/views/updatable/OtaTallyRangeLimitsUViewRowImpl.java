package com.bawaweb.views.updatable;

import com.bawaweb.model.OtlTallyRangeLimitsImpl;

import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class OtlTallyRangeLimitsUViewRowImpl extends ViewRowImpl {
    public static final int TRLID = 0;
    public static final int TRLTLYID = 1;
    public static final int TRLFROM = 2;
    public static final int TRLTO = 3;
    public static final int TRLDISPLAYSEQ = 4;
    public static final int TRLTYPE = 5;
    public static final int TRLDELETEYN = 6;

    /**This is the default constructor (do not remove)
     */
    public OtlTallyRangeLimitsUViewRowImpl() {
    }

    /**Gets OtlTallyRangeLimits entity object.
     */
    public OtlTallyRangeLimitsImpl getOtlTallyRangeLimits() {
        return (OtlTallyRangeLimitsImpl)getEntity(0);
    }

    /**Gets the attribute value for TRL_ID using the alias name TrlId
     */
    public Number getTrlId() {
        return (Number) getAttributeInternal(TRLID);
    }

    /**Sets <code>value</code> as attribute value for TRL_ID using the alias name TrlId
     */
    public void setTrlId(Number value) {
        setAttributeInternal(TRLID, value);
    }

    /**Gets the attribute value for TRL_TLY_ID using the alias name TrlTlyId
     */
    public Number getTrlTlyId() {
        return (Number) getAttributeInternal(TRLTLYID);
    }

    /**Sets <code>value</code> as attribute value for TRL_TLY_ID using the alias name TrlTlyId
     */
    public void setTrlTlyId(Number value) {
        setAttributeInternal(TRLTLYID, value);
    }

    /**Gets the attribute value for TRL_FROM using the alias name TrlFrom
     */
    public String getTrlFrom() {
        return (String) getAttributeInternal(TRLFROM);
    }

    /**Sets <code>value</code> as attribute value for TRL_FROM using the alias name TrlFrom
     */
    public void setTrlFrom(String value) {
        setAttributeInternal(TRLFROM, value);
    }

    /**Gets the attribute value for TRL_TO using the alias name TrlTo
     */
    public String getTrlTo() {
        return (String) getAttributeInternal(TRLTO);
    }

    /**Sets <code>value</code> as attribute value for TRL_TO using the alias name TrlTo
     */
    public void setTrlTo(String value) {
        setAttributeInternal(TRLTO, value);
    }

    /**Gets the attribute value for TRL_DISPLAY_SEQ using the alias name TrlDisplaySeq
     */
    public Number getTrlDisplaySeq() {
        return (Number) getAttributeInternal(TRLDISPLAYSEQ);
    }

    /**Sets <code>value</code> as attribute value for TRL_DISPLAY_SEQ using the alias name TrlDisplaySeq
     */
    public void setTrlDisplaySeq(Number value) {
        setAttributeInternal(TRLDISPLAYSEQ, value);
    }

    /**Gets the attribute value for TRL_TYPE using the alias name TrlType
     */
    public String getTrlType() {
        return (String) getAttributeInternal(TRLTYPE);
    }

    /**Sets <code>value</code> as attribute value for TRL_TYPE using the alias name TrlType
     */
    public void setTrlType(String value) {
        setAttributeInternal(TRLTYPE, value);
    }

    /**Gets the attribute value for TRL_DELETE_YN using the alias name TrlDeleteYn
     */
    public String getTrlDeleteYn() {
        return (String) getAttributeInternal(TRLDELETEYN);
    }

    /**Sets <code>value</code> as attribute value for TRL_DELETE_YN using the alias name TrlDeleteYn
     */
    public void setTrlDeleteYn(String value) {
        setAttributeInternal(TRLDELETEYN, value);
    }

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case TRLID:
            return getTrlId();
        case TRLTLYID:
            return getTrlTlyId();
        case TRLFROM:
            return getTrlFrom();
        case TRLTO:
            return getTrlTo();
        case TRLDISPLAYSEQ:
            return getTrlDisplaySeq();
        case TRLTYPE:
            return getTrlType();
        case TRLDELETEYN:
            return getTrlDeleteYn();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value, 
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case TRLID:
            setTrlId((Number)value);
            return;
        case TRLTLYID:
            setTrlTlyId((Number)value);
            return;
        case TRLFROM:
            setTrlFrom((String)value);
            return;
        case TRLTO:
            setTrlTo((String)value);
            return;
        case TRLDISPLAYSEQ:
            setTrlDisplaySeq((Number)value);
            return;
        case TRLTYPE:
            setTrlType((String)value);
            return;
        case TRLDELETEYN:
            setTrlDeleteYn((String)value);
            return;
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }
}
