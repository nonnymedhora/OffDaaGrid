package com.bawaweb.views.identify;

import com.bawaweb.model.OtlReportAnswerSetValuesImpl;

import com.bawaweb.views.identify.common.RAVInfoRow;

import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class RAVInfoRowImpl extends ViewRowImpl implements RAVInfoRow {
    public static final int RAVID = 0;
    public static final int RAVRASID = 1;
    public static final int RAVANSWER = 2;
    public static final int RAVDISPLAYSEQ = 3;
    public static final int RAVASVID = 4;
    public static final int RAVDELETEYN = 5;

    /**This is the default constructor (do not remove)
     */
    public RAVInfoRowImpl() {
    }

    /**Gets OtlReportAnswerSetValues entity object.
     */
    public OtlReportAnswerSetValuesImpl getOtlReportAnswerSetValues() {
        return (OtlReportAnswerSetValuesImpl)getEntity(0);
    }

    /**Gets the attribute value for RAV_ID using the alias name RavId
     */
    public Number getRavId() {
        return (Number) getAttributeInternal(RAVID);
    }

    /**Sets <code>value</code> as attribute value for RAV_ID using the alias name RavId
     */
    public void setRavId(Number value) {
        setAttributeInternal(RAVID, value);
    }

    /**Gets the attribute value for RAV_RAS_ID using the alias name RavRasId
     */
    public Number getRavRasId() {
        return (Number) getAttributeInternal(RAVRASID);
    }

    /**Sets <code>value</code> as attribute value for RAV_RAS_ID using the alias name RavRasId
     */
    public void setRavRasId(Number value) {
        setAttributeInternal(RAVRASID, value);
    }

    /**Gets the attribute value for RAV_ANSWER using the alias name RavAnswer
     */
    public String getRavAnswer() {
        return (String) getAttributeInternal(RAVANSWER);
    }

    /**Sets <code>value</code> as attribute value for RAV_ANSWER using the alias name RavAnswer
     */
    public void setRavAnswer(String value) {
        setAttributeInternal(RAVANSWER, value);
    }

    /**Gets the attribute value for RAV_DISPLAY_SEQ using the alias name RavDisplaySeq
     */
    public Number getRavDisplaySeq() {
        return (Number) getAttributeInternal(RAVDISPLAYSEQ);
    }

    /**Sets <code>value</code> as attribute value for RAV_DISPLAY_SEQ using the alias name RavDisplaySeq
     */
    public void setRavDisplaySeq(Number value) {
        setAttributeInternal(RAVDISPLAYSEQ, value);
    }

    /**Gets the attribute value for RAV_ASV_ID using the alias name RavAsvId
     */
    public Number getRavAsvId() {
        return (Number) getAttributeInternal(RAVASVID);
    }

    /**Sets <code>value</code> as attribute value for RAV_ASV_ID using the alias name RavAsvId
     */
    public void setRavAsvId(Number value) {
        setAttributeInternal(RAVASVID, value);
    }

    /**Gets the attribute value for RAV_DELETE_YN using the alias name RavDeleteYn
     */
    public String getRavDeleteYn() {
        return (String) getAttributeInternal(RAVDELETEYN);
    }

    /**Sets <code>value</code> as attribute value for RAV_DELETE_YN using the alias name RavDeleteYn
     */
    public void setRavDeleteYn(String value) {
        setAttributeInternal(RAVDELETEYN, value);
    }

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case RAVID:
            return getRavId();
        case RAVRASID:
            return getRavRasId();
        case RAVANSWER:
            return getRavAnswer();
        case RAVDISPLAYSEQ:
            return getRavDisplaySeq();
        case RAVASVID:
            return getRavAsvId();
        case RAVDELETEYN:
            return getRavDeleteYn();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value, 
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case RAVID:
            setRavId((Number)value);
            return;
        case RAVRASID:
            setRavRasId((Number)value);
            return;
        case RAVANSWER:
            setRavAnswer((String)value);
            return;
        case RAVDISPLAYSEQ:
            setRavDisplaySeq((Number)value);
            return;
        case RAVASVID:
            setRavAsvId((Number)value);
            return;
        case RAVDELETEYN:
            setRavDeleteYn((String)value);
            return;
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }
}
