package com.bawaweb.views.model;

import com.bawaweb.model.OtlSourceAnswersImpl;

import com.bawaweb.views.model.common.SourceAnswersRow;

import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SourceAnswersRowImpl extends ViewRowImpl implements SourceAnswersRow {
    public static final int SRAID = 0;
    public static final int SRAQSTID = 1;
    public static final int SRARPSID = 2;
    public static final int SRAANSWER = 3;
    public static final int SRAANSWERTEXT = 4;
    public static final int SRAASVID = 5;
    public static final int SRAEXCLUDEYN = 6;
    public static final int SRAWEIGHTMULTIPLIER = 7;
    public static final int SRARAVID = 8;
    public static final int SRACOLOR = 9;
    public static final int SRACOMMENT = 10;

    /**This is the default constructor (do not remove)
     */
    public SourceAnswersRowImpl() {
    }

    /**Gets OtlSourceAnswers entity object.
     */
    public OtlSourceAnswersImpl getOtlSourceAnswers() {
        return (OtlSourceAnswersImpl)getEntity(0);
    }

    /**Gets the attribute value for SRA_ID using the alias name SraId
     */
    public Number getSraId() {
        return (Number) getAttributeInternal(SRAID);
    }

    /**Sets <code>value</code> as attribute value for SRA_ID using the alias name SraId
     */
    public void setSraId(Number value) {
        setAttributeInternal(SRAID, value);
    }

    /**Gets the attribute value for SRA_QST_ID using the alias name SraQstId
     */
    public Number getSraQstId() {
        return (Number) getAttributeInternal(SRAQSTID);
    }

    /**Sets <code>value</code> as attribute value for SRA_QST_ID using the alias name SraQstId
     */
    public void setSraQstId(Number value) {
        setAttributeInternal(SRAQSTID, value);
    }

    /**Gets the attribute value for SRA_RPS_ID using the alias name SraRpsId
     */
    public Number getSraRpsId() {
        return (Number) getAttributeInternal(SRARPSID);
    }

    /**Sets <code>value</code> as attribute value for SRA_RPS_ID using the alias name SraRpsId
     */
    public void setSraRpsId(Number value) {
        setAttributeInternal(SRARPSID, value);
    }

    /**Gets the attribute value for SRA_ANSWER using the alias name SraAnswer
     */
    public String getSraAnswer() {
        return (String) getAttributeInternal(SRAANSWER);
    }

    /**Sets <code>value</code> as attribute value for SRA_ANSWER using the alias name SraAnswer
     */
    public void setSraAnswer(String value) {
        setAttributeInternal(SRAANSWER, value);
    }

    /**Gets the attribute value for SRA_ANSWER_TEXT using the alias name SraAnswerText
     */
    public String getSraAnswerText() {
        return (String) getAttributeInternal(SRAANSWERTEXT);
    }

    /**Sets <code>value</code> as attribute value for SRA_ANSWER_TEXT using the alias name SraAnswerText
     */
    public void setSraAnswerText(String value) {
        setAttributeInternal(SRAANSWERTEXT, value);
    }

    /**Gets the attribute value for SRA_ASV_ID using the alias name SraAsvId
     */
    public Number getSraAsvId() {
        return (Number) getAttributeInternal(SRAASVID);
    }

    /**Sets <code>value</code> as attribute value for SRA_ASV_ID using the alias name SraAsvId
     */
    public void setSraAsvId(Number value) {
        setAttributeInternal(SRAASVID, value);
    }

    /**Gets the attribute value for SRA_EXCLUDE_YN using the alias name SraExcludeYn
     */
    public String getSraExcludeYn() {
        return (String) getAttributeInternal(SRAEXCLUDEYN);
    }

    /**Sets <code>value</code> as attribute value for SRA_EXCLUDE_YN using the alias name SraExcludeYn
     */
    public void setSraExcludeYn(String value) {
        setAttributeInternal(SRAEXCLUDEYN, value);
    }

    /**Gets the attribute value for SRA_WEIGHT_MULTIPLIER using the alias name SraWeightMultiplier
     */
    public Number getSraWeightMultiplier() {
        return (Number) getAttributeInternal(SRAWEIGHTMULTIPLIER);
    }

    /**Sets <code>value</code> as attribute value for SRA_WEIGHT_MULTIPLIER using the alias name SraWeightMultiplier
     */
    public void setSraWeightMultiplier(Number value) {
        setAttributeInternal(SRAWEIGHTMULTIPLIER, value);
    }

    /**Gets the attribute value for SRA_RAV_ID using the alias name SraRavId
     */
    public Number getSraRavId() {
        return (Number) getAttributeInternal(SRARAVID);
    }

    /**Sets <code>value</code> as attribute value for SRA_RAV_ID using the alias name SraRavId
     */
    public void setSraRavId(Number value) {
        setAttributeInternal(SRARAVID, value);
    }

    /**Gets the attribute value for SRA_COLOR using the alias name SraColor
     */
    public String getSraColor() {
        return (String) getAttributeInternal(SRACOLOR);
    }

    /**Sets <code>value</code> as attribute value for SRA_COLOR using the alias name SraColor
     */
    public void setSraColor(String value) {
        setAttributeInternal(SRACOLOR, value);
    }

    /**Gets the attribute value for SRA_COMMENT using the alias name SraComment
     */
    public String getSraComment() {
        return (String) getAttributeInternal(SRACOMMENT);
    }

    /**Sets <code>value</code> as attribute value for SRA_COMMENT using the alias name SraComment
     */
    public void setSraComment(String value) {
        setAttributeInternal(SRACOMMENT, value);
    }

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case SRAID:
            return getSraId();
        case SRAQSTID:
            return getSraQstId();
        case SRARPSID:
            return getSraRpsId();
        case SRAANSWER:
            return getSraAnswer();
        case SRAANSWERTEXT:
            return getSraAnswerText();
        case SRAASVID:
            return getSraAsvId();
        case SRAEXCLUDEYN:
            return getSraExcludeYn();
        case SRAWEIGHTMULTIPLIER:
            return getSraWeightMultiplier();
        case SRARAVID:
            return getSraRavId();
        case SRACOLOR:
            return getSraColor();
        case SRACOMMENT:
            return getSraComment();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value, 
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case SRAID:
            setSraId((Number)value);
            return;
        case SRAQSTID:
            setSraQstId((Number)value);
            return;
        case SRARPSID:
            setSraRpsId((Number)value);
            return;
        case SRAANSWER:
            setSraAnswer((String)value);
            return;
        case SRAANSWERTEXT:
            setSraAnswerText((String)value);
            return;
        case SRAASVID:
            setSraAsvId((Number)value);
            return;
        case SRAEXCLUDEYN:
            setSraExcludeYn((String)value);
            return;
        case SRAWEIGHTMULTIPLIER:
            setSraWeightMultiplier((Number)value);
            return;
        case SRARAVID:
            setSraRavId((Number)value);
            return;
        case SRACOLOR:
            setSraColor((String)value);
            return;
        case SRACOMMENT:
            setSraComment((String)value);
            return;
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }
}
