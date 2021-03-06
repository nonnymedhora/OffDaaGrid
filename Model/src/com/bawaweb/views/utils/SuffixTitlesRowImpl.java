package com.bawaweb.views.utils;

import com.bawaweb.model.OtlSuffixTitlesImpl;

import com.bawaweb.views.utils.common.SuffixTitlesRow;

import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SuffixTitlesRowImpl extends ViewRowImpl implements SuffixTitlesRow {
    public static final int CTLCODE = 0;
    public static final int CTLDESC = 1;
    public static final int STLSUFFIXTITLE = 2;
    public static final int STLDELETEYN = 3;

    /**This is the default constructor (do not remove)
     */
    public SuffixTitlesRowImpl() {
    }

    /**Gets OtlSuffixTitles entity object.
     */
    public OtlSuffixTitlesImpl getOtlSuffixTitles() {
        return (OtlSuffixTitlesImpl)getEntity(0);
    }

    /**Gets the attribute value for the calculated attribute CtlCode
     */
    public String getCtlCode() {
        return (String) getAttributeInternal(CTLCODE);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute CtlCode
     */
    public void setCtlCode(String value) {
        setAttributeInternal(CTLCODE, value);
    }

    /**Gets the attribute value for the calculated attribute CtlDesc
     */
    public String getCtlDesc() {
        return (String) getAttributeInternal(CTLDESC);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute CtlDesc
     */
    public void setCtlDesc(String value) {
        setAttributeInternal(CTLDESC, value);
    }

    /**Gets the attribute value for the calculated attribute StlSuffixTitle
     */
    public String getStlSuffixTitle() {
        return (String) getAttributeInternal(STLSUFFIXTITLE);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute StlSuffixTitle
     */
    public void setStlSuffixTitle(String value) {
        setAttributeInternal(STLSUFFIXTITLE, value);
    }

    /**Gets the attribute value for the calculated attribute StlDeleteYn
     */
    public String getStlDeleteYn() {
        return (String) getAttributeInternal(STLDELETEYN);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute StlDeleteYn
     */
    public void setStlDeleteYn(String value) {
        setAttributeInternal(STLDELETEYN, value);
    }

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case CTLCODE:
            return getCtlCode();
        case CTLDESC:
            return getCtlDesc();
        case STLSUFFIXTITLE:
            return getStlSuffixTitle();
        case STLDELETEYN:
            return getStlDeleteYn();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value, 
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case CTLCODE:
            setCtlCode((String)value);
            return;
        case CTLDESC:
            setCtlDesc((String)value);
            return;
        case STLSUFFIXTITLE:
            setStlSuffixTitle((String)value);
            return;
        case STLDELETEYN:
            setStlDeleteYn((String)value);
            return;
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }
}
