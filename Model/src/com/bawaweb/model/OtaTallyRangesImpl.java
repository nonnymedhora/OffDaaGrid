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
public class OtlTallyRangesImpl extends EntityImpl {
    public static final int TLYID = 0;
    public static final int TLYNAME = 1;
    public static final int TLYPREFIX = 2;
    public static final int TLYSUFFIX = 3;
    public static final int TLYDELETEYN = 4;
    public static final int BaWaWEBTALLYRANGELIMITS = 5;
    private static OtlTallyRangesDefImpl mDefinitionObject;

    /**This is the default constructor (do not remove)
     */
    public OtlTallyRangesImpl() {
    }


    /**Retrieves the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = (OtlTallyRangesDefImpl)EntityDefImpl.findDefObject("com.bawaweb.model.OtlTallyRanges");
        }
        return mDefinitionObject;
    }

    /**Gets the attribute value for TlyId, using the alias name TlyId
     */
    public Number getTlyId() {
        return (Number)getAttributeInternal(TLYID);
    }

    /**Sets <code>value</code> as the attribute value for TlyId
     */
    public void setTlyId(Number value) {
        setAttributeInternal(TLYID, value);
    }

    /**Gets the attribute value for TlyName, using the alias name TlyName
     */
    public String getTlyName() {
        return (String)getAttributeInternal(TLYNAME);
    }

    /**Sets <code>value</code> as the attribute value for TlyName
     */
    public void setTlyName(String value) {
        setAttributeInternal(TLYNAME, value);
    }

    /**Gets the attribute value for TlyPrefix, using the alias name TlyPrefix
     */
    public String getTlyPrefix() {
        return (String)getAttributeInternal(TLYPREFIX);
    }

    /**Sets <code>value</code> as the attribute value for TlyPrefix
     */
    public void setTlyPrefix(String value) {
        setAttributeInternal(TLYPREFIX, value);
    }

    /**Gets the attribute value for TlySuffix, using the alias name TlySuffix
     */
    public String getTlySuffix() {
        return (String)getAttributeInternal(TLYSUFFIX);
    }

    /**Sets <code>value</code> as the attribute value for TlySuffix
     */
    public void setTlySuffix(String value) {
        setAttributeInternal(TLYSUFFIX, value);
    }

    /**Gets the attribute value for TlyDeleteYn, using the alias name TlyDeleteYn
     */
    public String getTlyDeleteYn() {
        return (String)getAttributeInternal(TLYDELETEYN);
    }

    /**Sets <code>value</code> as the attribute value for TlyDeleteYn
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
        case BaWaWEBTALLYRANGELIMITS:
            return getOtlTallyRangeLimits();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value, 
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case TLYID:
            setTlyId((Number)value);
            return;
        case TLYNAME:
            setTlyName((String)value);
            return;
        case TLYPREFIX:
            setTlyPrefix((String)value);
            return;
        case TLYSUFFIX:
            setTlySuffix((String)value);
            return;
        case TLYDELETEYN:
            setTlyDeleteYn((String)value);
            return;
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }

    /**Gets the associated entity oracle.jbo.RowIterator
     */
    public RowIterator getOtlTallyRangeLimits() {
        return (RowIterator)getAttributeInternal(BaWaWEBTALLYRANGELIMITS);
    }

    /**Creates a Key object based on given key constituents
     */
    public static Key createPrimaryKey(Number tlyId) {
        return new Key(new Object[]{tlyId});
    }
}
