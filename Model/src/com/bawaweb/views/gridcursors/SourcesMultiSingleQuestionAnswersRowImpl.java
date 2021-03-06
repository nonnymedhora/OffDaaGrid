package com.bawaweb.views.gridcursors;

import com.bawaweb.model.OtlReportAnswerSetValuesImpl;
import com.bawaweb.model.OtlSourceAnswersImpl;
import com.bawaweb.model.OtlSourceMultiAnswersImpl;

import com.bawaweb.views.gridcursors.common.SourcesMultiSingleQuestionAnswersRow;

import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SourcesMultiSingleQuestionAnswersRowImpl extends ViewRowImpl implements SourcesMultiSingleQuestionAnswersRow {
    public static final int SMASRAID = 0;
    public static final int SMAANSWER = 1;
    public static final int SMAASVID = 2;
    public static final int SMAQMQID = 3;
    public static final int SMAEXCLUDEYN = 4;
    public static final int SMAWEIGHTMULTIPLIER = 5;
    public static final int SMARAVID = 6;
    public static final int RAVID = 7;
    public static final int RAVRASID = 8;
    public static final int RAVANSWER = 9;
    public static final int RAVDISPLAYSEQ = 10;
    public static final int RAVASVID = 11;
    public static final int RAVDELETEYN = 12;
    public static final int SRAID = 13;
    public static final int SRAQSTID = 14;
    public static final int SRARPSID = 15;
    public static final int SRAANSWER = 16;
    public static final int SRAANSWERTEXT = 17;
    public static final int SRAASVID = 18;
    public static final int SRAEXCLUDEYN = 19;
    public static final int SRAWEIGHTMULTIPLIER = 20;
    public static final int SRARAVID = 21;
    public static final int SRACOLOR = 22;
    public static final int SRACOMMENT = 23;

    /**This is the default constructor (do not remove)
     */
    public SourcesMultiSingleQuestionAnswersRowImpl() {
    }

    /**Gets OtlSourceMultiAnswers entity object.
     */
    public OtlSourceMultiAnswersImpl getOtlSourceMultiAnswers() {
        return (OtlSourceMultiAnswersImpl)getEntity(0);
    }

    /**Gets OtlReportAnswerSetValues entity object.
     */
    public OtlReportAnswerSetValuesImpl getOtlReportAnswerSetValues() {
        return (OtlReportAnswerSetValuesImpl)getEntity(1);
    }

    /**Gets OtlSourceAnswers entity object.
     */
    public OtlSourceAnswersImpl getOtlSourceAnswers() {
        return (OtlSourceAnswersImpl)getEntity(2);
    }

    /**Gets the attribute value for SMA_SRA_ID using the alias name SmaSraId
     */
    public Number getSmaSraId() {
        return (Number) getAttributeInternal(SMASRAID);
    }

    /**Sets <code>value</code> as attribute value for SMA_SRA_ID using the alias name SmaSraId
     */
    public void setSmaSraId(Number value) {
        setAttributeInternal(SMASRAID, value);
    }

    /**Gets the attribute value for SMA_ANSWER using the alias name SmaAnswer
     */
    public String getSmaAnswer() {
        return (String) getAttributeInternal(SMAANSWER);
    }

    /**Sets <code>value</code> as attribute value for SMA_ANSWER using the alias name SmaAnswer
     */
    public void setSmaAnswer(String value) {
        setAttributeInternal(SMAANSWER, value);
    }

    /**Gets the attribute value for SMA_ASV_ID using the alias name SmaAsvId
     */
    public Number getSmaAsvId() {
        return (Number) getAttributeInternal(SMAASVID);
    }

    /**Sets <code>value</code> as attribute value for SMA_ASV_ID using the alias name SmaAsvId
     */
    public void setSmaAsvId(Number value) {
        setAttributeInternal(SMAASVID, value);
    }

    /**Gets the attribute value for SMA_QMQ_ID using the alias name SmaQmqId
     */
    public Number getSmaQmqId() {
        return (Number) getAttributeInternal(SMAQMQID);
    }

    /**Sets <code>value</code> as attribute value for SMA_QMQ_ID using the alias name SmaQmqId
     */
    public void setSmaQmqId(Number value) {
        setAttributeInternal(SMAQMQID, value);
    }

    /**Gets the attribute value for SMA_EXCLUDE_YN using the alias name SmaExcludeYn
     */
    public String getSmaExcludeYn() {
        return (String) getAttributeInternal(SMAEXCLUDEYN);
    }

    /**Sets <code>value</code> as attribute value for SMA_EXCLUDE_YN using the alias name SmaExcludeYn
     */
    public void setSmaExcludeYn(String value) {
        setAttributeInternal(SMAEXCLUDEYN, value);
    }

    /**Gets the attribute value for SMA_WEIGHT_MULTIPLIER using the alias name SmaWeightMultiplier
     */
    public Number getSmaWeightMultiplier() {
        return (Number) getAttributeInternal(SMAWEIGHTMULTIPLIER);
    }

    /**Sets <code>value</code> as attribute value for SMA_WEIGHT_MULTIPLIER using the alias name SmaWeightMultiplier
     */
    public void setSmaWeightMultiplier(Number value) {
        setAttributeInternal(SMAWEIGHTMULTIPLIER, value);
    }

    /**Gets the attribute value for SMA_RAV_ID using the alias name SmaRavId
     */
    public Number getSmaRavId() {
        return (Number) getAttributeInternal(SMARAVID);
    }

    /**Sets <code>value</code> as attribute value for SMA_RAV_ID using the alias name SmaRavId
     */
    public void setSmaRavId(Number value) {
        setAttributeInternal(SMARAVID, value);
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
        case SMASRAID:
            return getSmaSraId();
        case SMAANSWER:
            return getSmaAnswer();
        case SMAASVID:
            return getSmaAsvId();
        case SMAQMQID:
            return getSmaQmqId();
        case SMAEXCLUDEYN:
            return getSmaExcludeYn();
        case SMAWEIGHTMULTIPLIER:
            return getSmaWeightMultiplier();
        case SMARAVID:
            return getSmaRavId();
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
        case SMASRAID:
            setSmaSraId((Number)value);
            return;
        case SMAANSWER:
            setSmaAnswer((String)value);
            return;
        case SMAASVID:
            setSmaAsvId((Number)value);
            return;
        case SMAQMQID:
            setSmaQmqId((Number)value);
            return;
        case SMAEXCLUDEYN:
            setSmaExcludeYn((String)value);
            return;
        case SMAWEIGHTMULTIPLIER:
            setSmaWeightMultiplier((Number)value);
            return;
        case SMARAVID:
            setSmaRavId((Number)value);
            return;
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
