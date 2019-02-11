package com.bawaweb.views.readable;

import com.bawaweb.model.CtryCountriesImpl;

import com.bawaweb.views.readable.common.CtryCountriesRViewRow;

import oracle.jbo.RowIterator;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CtryCountriesRViewRowImpl extends ViewRowImpl implements CtryCountriesRViewRow {
    public static final int CTRYID = 0;
    public static final int CTRYSHORTNAME = 1;
    public static final int CTRYNAME = 2;
    public static final int RERGID = 3;
    public static final int CTRYISOCNTRYCODE = 4;
    public static final int BaWaWEBSOURCESRVIEW = 5;

    /**This is the default constructor (do not remove)
     */
    public CtryCountriesRViewRowImpl() {
    }

    /**Gets the attribute value for the calculated attribute CtryId
     */
    public Number getCtryId() {
        return (Number) getAttributeInternal(CTRYID);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute CtryId
     */
    public void setCtryId(Number value) {
        setAttributeInternal(CTRYID, value);
    }

    /**Gets the attribute value for the calculated attribute CtryShortname
     */
    public String getCtryShortname() {
        return (String) getAttributeInternal(CTRYSHORTNAME);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute CtryShortname
     */
    public void setCtryShortname(String value) {
        setAttributeInternal(CTRYSHORTNAME, value);
    }

    /**Gets the attribute value for the calculated attribute CtryName
     */
    public String getCtryName() {
        return (String) getAttributeInternal(CTRYNAME);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute CtryName
     */
    public void setCtryName(String value) {
        setAttributeInternal(CTRYNAME, value);
    }

    /**Gets the attribute value for the calculated attribute RergId
     */
    public Number getRergId() {
        return (Number) getAttributeInternal(RERGID);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute RergId
     */
    public void setRergId(Number value) {
        setAttributeInternal(RERGID, value);
    }

    /**Gets the attribute value for the calculated attribute CtryIsoCntryCode
     */
    public String getCtryIsoCntryCode() {
        return (String) getAttributeInternal(CTRYISOCNTRYCODE);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute CtryIsoCntryCode
     */
    public void setCtryIsoCntryCode(String value) {
        setAttributeInternal(CTRYISOCNTRYCODE, value);
    }

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case CTRYID:
            return getCtryId();
        case CTRYSHORTNAME:
            return getCtryShortname();
        case CTRYNAME:
            return getCtryName();
        case RERGID:
            return getRergId();
        case CTRYISOCNTRYCODE:
            return getCtryIsoCntryCode();
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

    /**Gets CtryCountries entity object.
     */
    public CtryCountriesImpl getCtryCountries() {
        return (CtryCountriesImpl)getEntity(0);
    }
}