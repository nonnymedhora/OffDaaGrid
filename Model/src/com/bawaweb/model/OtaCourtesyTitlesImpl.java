package com.bawaweb.model;

import oracle.jbo.Key;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class OtlCourtesyTitlesImpl extends EntityImpl {
    public static final int CTLCOURTESYTITLE = 0;
    public static final int CTLDELETEYN = 1;
    private static OtlCourtesyTitlesDefImpl mDefinitionObject;

    /**This is the default constructor (do not remove)
     */
    public OtlCourtesyTitlesImpl() {
    }

    /**Retrieves the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = (OtlCourtesyTitlesDefImpl)EntityDefImpl.findDefObject("com.bawaweb.model.OtlCourtesyTitles");
        }
        return mDefinitionObject;
    }

    /**Gets the attribute value for CtlCourtesyTitle, using the alias name CtlCourtesyTitle
     */
    public String getCtlCourtesyTitle() {
        return (String)getAttributeInternal(CTLCOURTESYTITLE);
    }

    /**Sets <code>value</code> as the attribute value for CtlCourtesyTitle
     */
    public void setCtlCourtesyTitle(String value) {
        setAttributeInternal(CTLCOURTESYTITLE, value);
    }

    /**Gets the attribute value for CtlDeleteYn, using the alias name CtlDeleteYn
     */
    public String getCtlDeleteYn() {
        return (String)getAttributeInternal(CTLDELETEYN);
    }

    /**Sets <code>value</code> as the attribute value for CtlDeleteYn
     */
    public void setCtlDeleteYn(String value) {
        setAttributeInternal(CTLDELETEYN, value);
    }

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case CTLCOURTESYTITLE:
            return getCtlCourtesyTitle();
        case CTLDELETEYN:
            return getCtlDeleteYn();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value, 
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case CTLCOURTESYTITLE:
            setCtlCourtesyTitle((String)value);
            return;
        case CTLDELETEYN:
            setCtlDeleteYn((String)value);
            return;
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }

    /**Creates a Key object based on given key constituents
     */
    public static Key createPrimaryKey(String ctlCourtesyTitle) {
        return new Key(new Object[]{ctlCourtesyTitle});
    }
}
