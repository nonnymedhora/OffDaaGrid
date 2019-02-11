package com.bawaweb.views.gridcursors;

import com.bawaweb.model.OtlAnswerSetsImpl;

import com.bawaweb.model.OtlQuestionsImpl;
import com.bawaweb.views.gridcursors.common.AnswerSetsInfoRow;

import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class AnswerSetsInfoRowImpl extends ViewRowImpl implements AnswerSetsInfoRow {
    public static final int ANSID = 0;
    public static final int ANSNAME = 1;
    public static final int ANSFRIDID = 2;
    public static final int ANSORDERBYNAMEYN = 3;
    public static final int ANSADDANSWERYN = 4;
    public static final int ANSDELETEYN = 5;

    /**This is the default constructor (do not remove)
     */
    public AnswerSetsInfoRowImpl() {
    }

    /**Gets OtlAnswerSets entity object.
     */
    public OtlAnswerSetsImpl getOtlAnswerSets() {
        return (OtlAnswerSetsImpl)getEntity(0);
    }

    /**Gets the attribute value for ANS_ID using the alias name AnsId
     */
    public Number getAnsId() {
        return (Number) getAttributeInternal(ANSID);
    }

    /**Sets <code>value</code> as attribute value for ANS_ID using the alias name AnsId
     */
    public void setAnsId(Number value) {
        setAttributeInternal(ANSID, value);
    }

    /**Gets the attribute value for ANS_NAME using the alias name AnsName
     */
    public String getAnsName() {
        return (String) getAttributeInternal(ANSNAME);
    }

    /**Sets <code>value</code> as attribute value for ANS_NAME using the alias name AnsName
     */
    public void setAnsName(String value) {
        setAttributeInternal(ANSNAME, value);
    }

    /**Gets the attribute value for ANS_FRID_ID using the alias name AnsFridId
     */
    public Number getAnsFridId() {
        return (Number) getAttributeInternal(ANSFRIDID);
    }

    /**Sets <code>value</code> as attribute value for ANS_FRID_ID using the alias name AnsFridId
     */
    public void setAnsFridId(Number value) {
        setAttributeInternal(ANSFRIDID, value);
    }

    /**Gets the attribute value for ANS_ORDER_BY_NAME_YN using the alias name AnsOrderByNameYn
     */
    public String getAnsOrderByNameYn() {
        return (String) getAttributeInternal(ANSORDERBYNAMEYN);
    }

    /**Sets <code>value</code> as attribute value for ANS_ORDER_BY_NAME_YN using the alias name AnsOrderByNameYn
     */
    public void setAnsOrderByNameYn(String value) {
        setAttributeInternal(ANSORDERBYNAMEYN, value);
    }

    /**Gets the attribute value for ANS_ADD_ANSWER_YN using the alias name AnsAddAnswerYn
     */
    public String getAnsAddAnswerYn() {
        return (String) getAttributeInternal(ANSADDANSWERYN);
    }

    /**Sets <code>value</code> as attribute value for ANS_ADD_ANSWER_YN using the alias name AnsAddAnswerYn
     */
    public void setAnsAddAnswerYn(String value) {
        setAttributeInternal(ANSADDANSWERYN, value);
    }

    /**Gets the attribute value for ANS_DELETE_YN using the alias name AnsDeleteYn
     */
    public String getAnsDeleteYn() {
        return (String) getAttributeInternal(ANSDELETEYN);
    }

    /**Sets <code>value</code> as attribute value for ANS_DELETE_YN using the alias name AnsDeleteYn
     */
    public void setAnsDeleteYn(String value) {
        setAttributeInternal(ANSDELETEYN, value);
    }

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case ANSID:
            return getAnsId();
        case ANSNAME:
            return getAnsName();
        case ANSFRIDID:
            return getAnsFridId();
        case ANSORDERBYNAMEYN:
            return getAnsOrderByNameYn();
        case ANSADDANSWERYN:
            return getAnsAddAnswerYn();
        case ANSDELETEYN:
            return getAnsDeleteYn();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value, 
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case ANSID:
            setAnsId((Number)value);
            return;
        case ANSNAME:
            setAnsName((String)value);
            return;
        case ANSFRIDID:
            setAnsFridId((Number)value);
            return;
        case ANSORDERBYNAMEYN:
            setAnsOrderByNameYn((String)value);
            return;
        case ANSADDANSWERYN:
            setAnsAddAnswerYn((String)value);
            return;
        case ANSDELETEYN:
            setAnsDeleteYn((String)value);
            return;
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }

    /**Gets OtlQuestions entity object.
     */
    public OtlQuestionsImpl getOtlQuestions() {
        return (OtlQuestionsImpl)getEntity(1);
    }
}
