package com.bawaweb.model;

import oracle.jbo.Key;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class OtlFunctionsImpl extends EntityImpl {
    public static final int FNCID = 0;
    public static final int FNCNAME = 1;
    public static final int FNCMENU = 2;
    public static final int FNCCALLMENU = 3;
    public static final int FNCPAGE = 4;
    public static final int FNCMENUSEQ = 5;
    public static final int FNCICON1 = 6;
    public static final int FNCLINK1 = 7;
    public static final int FNCPAGENEWVERSION = 8;
    private static OtlFunctionsDefImpl mDefinitionObject;

    /**This is the default constructor (do not remove)
     */
    public OtlFunctionsImpl() {
    }


    /**Retrieves the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = (OtlFunctionsDefImpl)EntityDefImpl.findDefObject("com.bawaweb.model.OtlFunctions");
        }
        return mDefinitionObject;
    }

    /**Gets the attribute value for FncId, using the alias name FncId
     */
    public Number getFncId() {
        return (Number)getAttributeInternal(FNCID);
    }

    /**Sets <code>value</code> as the attribute value for FncId
     */
    public void setFncId(Number value) {
        setAttributeInternal(FNCID, value);
    }

    /**Gets the attribute value for FncName, using the alias name FncName
     */
    public String getFncName() {
        return (String)getAttributeInternal(FNCNAME);
    }

    /**Sets <code>value</code> as the attribute value for FncName
     */
    public void setFncName(String value) {
        setAttributeInternal(FNCNAME, value);
    }

    /**Gets the attribute value for FncMenu, using the alias name FncMenu
     */
    public String getFncMenu() {
        return (String)getAttributeInternal(FNCMENU);
    }

    /**Sets <code>value</code> as the attribute value for FncMenu
     */
    public void setFncMenu(String value) {
        setAttributeInternal(FNCMENU, value);
    }

    /**Gets the attribute value for FncCallMenu, using the alias name FncCallMenu
     */
    public String getFncCallMenu() {
        return (String)getAttributeInternal(FNCCALLMENU);
    }

    /**Sets <code>value</code> as the attribute value for FncCallMenu
     */
    public void setFncCallMenu(String value) {
        setAttributeInternal(FNCCALLMENU, value);
    }

    /**Gets the attribute value for FncPage, using the alias name FncPage
     */
    public String getFncPage() {
        return (String)getAttributeInternal(FNCPAGE);
    }

    /**Sets <code>value</code> as the attribute value for FncPage
     */
    public void setFncPage(String value) {
        setAttributeInternal(FNCPAGE, value);
    }

    /**Gets the attribute value for FncMenuSeq, using the alias name FncMenuSeq
     */
    public Number getFncMenuSeq() {
        return (Number)getAttributeInternal(FNCMENUSEQ);
    }

    /**Sets <code>value</code> as the attribute value for FncMenuSeq
     */
    public void setFncMenuSeq(Number value) {
        setAttributeInternal(FNCMENUSEQ, value);
    }

    /**Gets the attribute value for FncIcon1, using the alias name FncIcon1
     */
    public String getFncIcon1() {
        return (String)getAttributeInternal(FNCICON1);
    }

    /**Sets <code>value</code> as the attribute value for FncIcon1
     */
    public void setFncIcon1(String value) {
        setAttributeInternal(FNCICON1, value);
    }

    /**Gets the attribute value for FncLink1, using the alias name FncLink1
     */
    public Number getFncLink1() {
        return (Number)getAttributeInternal(FNCLINK1);
    }

    /**Sets <code>value</code> as the attribute value for FncLink1
     */
    public void setFncLink1(Number value) {
        setAttributeInternal(FNCLINK1, value);
    }

    /**Gets the attribute value for FncPageNewVersion, using the alias name FncPageNewVersion
     */
    public String getFncPageNewVersion() {
        return (String)getAttributeInternal(FNCPAGENEWVERSION);
    }

    /**Sets <code>value</code> as the attribute value for FncPageNewVersion
     */
    public void setFncPageNewVersion(String value) {
        setAttributeInternal(FNCPAGENEWVERSION, value);
    }

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case FNCID:
            return getFncId();
        case FNCNAME:
            return getFncName();
        case FNCMENU:
            return getFncMenu();
        case FNCCALLMENU:
            return getFncCallMenu();
        case FNCPAGE:
            return getFncPage();
        case FNCMENUSEQ:
            return getFncMenuSeq();
        case FNCICON1:
            return getFncIcon1();
        case FNCLINK1:
            return getFncLink1();
        case FNCPAGENEWVERSION:
            return getFncPageNewVersion();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value, 
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case FNCID:
            setFncId((Number)value);
            return;
        case FNCNAME:
            setFncName((String)value);
            return;
        case FNCMENU:
            setFncMenu((String)value);
            return;
        case FNCCALLMENU:
            setFncCallMenu((String)value);
            return;
        case FNCPAGE:
            setFncPage((String)value);
            return;
        case FNCMENUSEQ:
            setFncMenuSeq((Number)value);
            return;
        case FNCICON1:
            setFncIcon1((String)value);
            return;
        case FNCLINK1:
            setFncLink1((Number)value);
            return;
        case FNCPAGENEWVERSION:
            setFncPageNewVersion((String)value);
            return;
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }

    /**Creates a Key object based on given key constituents
     */
    public static Key createPrimaryKey(Number fncId) {
        return new Key(new Object[]{fncId});
    }
}