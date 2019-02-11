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
public class OtlSourceAnswersImpl extends EntityImpl {
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
    public static final int BaWaWEBANSWERSETVALUES = 11;
    public static final int BaWaWEBQUESTIONS = 12;
    public static final int BaWaWEBREPORTANSWERSETVALUES = 13;
    public static final int BaWaWEBREPORTSOURCES = 14;
    public static final int BaWaWEBSOURCEMULTIANSWERS = 15;
    private static OtlSourceAnswersDefImpl mDefinitionObject;

    /**This is the default constructor (do not remove)
     */
    public OtlSourceAnswersImpl() {
    }


    /**Retrieves the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = (OtlSourceAnswersDefImpl)EntityDefImpl.findDefObject("com.bawaweb.model.OtlSourceAnswers");
        }
        return mDefinitionObject;
    }

    /**Gets the attribute value for SraId, using the alias name SraId
     */
    public Number getSraId() {
        return (Number)getAttributeInternal(SRAID);
    }

    /**Sets <code>value</code> as the attribute value for SraId
     */
    public void setSraId(Number value) {
        setAttributeInternal(SRAID, value);
    }

    /**Gets the attribute value for SraQstId, using the alias name SraQstId
     */
    public Number getSraQstId() {
        return (Number)getAttributeInternal(SRAQSTID);
    }

    /**Sets <code>value</code> as the attribute value for SraQstId
     */
    public void setSraQstId(Number value) {
        setAttributeInternal(SRAQSTID, value);
    }

    /**Gets the attribute value for SraRpsId, using the alias name SraRpsId
     */
    public Number getSraRpsId() {
        return (Number)getAttributeInternal(SRARPSID);
    }

    /**Sets <code>value</code> as the attribute value for SraRpsId
     */
    public void setSraRpsId(Number value) {
        setAttributeInternal(SRARPSID, value);
    }

    /**Gets the attribute value for SraAnswer, using the alias name SraAnswer
     */
    public String getSraAnswer() {
        return (String)getAttributeInternal(SRAANSWER);
    }

    /**Sets <code>value</code> as the attribute value for SraAnswer
     */
    public void setSraAnswer(String value) {
        setAttributeInternal(SRAANSWER, value);
    }

    /**Gets the attribute value for SraAnswerText, using the alias name SraAnswerText
     */
    public String getSraAnswerText() {
        return (String)getAttributeInternal(SRAANSWERTEXT);
    }

    /**Sets <code>value</code> as the attribute value for SraAnswerText
     */
    public void setSraAnswerText(String value) {
        setAttributeInternal(SRAANSWERTEXT, value);
    }

    /**Gets the attribute value for SraAsvId, using the alias name SraAsvId
     */
    public Number getSraAsvId() {
        return (Number)getAttributeInternal(SRAASVID);
    }

    /**Sets <code>value</code> as the attribute value for SraAsvId
     */
    public void setSraAsvId(Number value) {
        setAttributeInternal(SRAASVID, value);
    }

    /**Gets the attribute value for SraExcludeYn, using the alias name SraExcludeYn
     */
    public String getSraExcludeYn() {
        return (String)getAttributeInternal(SRAEXCLUDEYN);
    }

    /**Sets <code>value</code> as the attribute value for SraExcludeYn
     */
    public void setSraExcludeYn(String value) {
        setAttributeInternal(SRAEXCLUDEYN, value);
    }

    /**Gets the attribute value for SraWeightMultiplier, using the alias name SraWeightMultiplier
     */
    public Number getSraWeightMultiplier() {
        return (Number)getAttributeInternal(SRAWEIGHTMULTIPLIER);
    }

    /**Sets <code>value</code> as the attribute value for SraWeightMultiplier
     */
    public void setSraWeightMultiplier(Number value) {
        setAttributeInternal(SRAWEIGHTMULTIPLIER, value);
    }

    /**Gets the attribute value for SraRavId, using the alias name SraRavId
     */
    public Number getSraRavId() {
        return (Number)getAttributeInternal(SRARAVID);
    }

    /**Sets <code>value</code> as the attribute value for SraRavId
     */
    public void setSraRavId(Number value) {
        setAttributeInternal(SRARAVID, value);
    }

    /**Gets the attribute value for SraColor, using the alias name SraColor
     */
    public String getSraColor() {
        return (String)getAttributeInternal(SRACOLOR);
    }

    /**Sets <code>value</code> as the attribute value for SraColor
     */
    public void setSraColor(String value) {
        setAttributeInternal(SRACOLOR, value);
    }

    /**Gets the attribute value for SraComment, using the alias name SraComment
     */
    public String getSraComment() {
        return (String)getAttributeInternal(SRACOMMENT);
    }

    /**Sets <code>value</code> as the attribute value for SraComment
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
        case BaWaWEBSOURCEMULTIANSWERS:
            return getOtlSourceMultiAnswers();
        case BaWaWEBANSWERSETVALUES:
            return getOtlAnswerSetValues();
        case BaWaWEBQUESTIONS:
            return getOtlQuestions();
        case BaWaWEBREPORTANSWERSETVALUES:
            return getOtlReportAnswerSetValues();
        case BaWaWEBREPORTSOURCES:
            return getOtlReportSources();
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

    /**Gets the associated entity OtlAnswerSetValuesImpl
     */
    public OtlAnswerSetValuesImpl getOtlAnswerSetValues() {
        return (OtlAnswerSetValuesImpl)getAttributeInternal(BaWaWEBANSWERSETVALUES);
    }

    /**Sets <code>value</code> as the associated entity OtlAnswerSetValuesImpl
     */
    public void setOtlAnswerSetValues(OtlAnswerSetValuesImpl value) {
        setAttributeInternal(BaWaWEBANSWERSETVALUES, value);
    }

    /**Gets the associated entity OtlQuestionsImpl
     */
    public OtlQuestionsImpl getOtlQuestions() {
        return (OtlQuestionsImpl)getAttributeInternal(BaWaWEBQUESTIONS);
    }

    /**Sets <code>value</code> as the associated entity OtlQuestionsImpl
     */
    public void setOtlQuestions(OtlQuestionsImpl value) {
        setAttributeInternal(BaWaWEBQUESTIONS, value);
    }

    /**Gets the associated entity OtlReportAnswerSetValuesImpl
     */
    public OtlReportAnswerSetValuesImpl getOtlReportAnswerSetValues() {
        return (OtlReportAnswerSetValuesImpl)getAttributeInternal(BaWaWEBREPORTANSWERSETVALUES);
    }

    /**Sets <code>value</code> as the associated entity OtlReportAnswerSetValuesImpl
     */
    public void setOtlReportAnswerSetValues(OtlReportAnswerSetValuesImpl value) {
        setAttributeInternal(BaWaWEBREPORTANSWERSETVALUES, value);
    }

    /**Gets the associated entity OtlReportSourcesImpl
     */
    public OtlReportSourcesImpl getOtlReportSources() {
        return (OtlReportSourcesImpl)getAttributeInternal(BaWaWEBREPORTSOURCES);
    }

    /**Sets <code>value</code> as the associated entity OtlReportSourcesImpl
     */
    public void setOtlReportSources(OtlReportSourcesImpl value) {
        setAttributeInternal(BaWaWEBREPORTSOURCES, value);
    }

    /**Gets the associated entity oracle.jbo.RowIterator
     */
    public RowIterator getOtlSourceMultiAnswers() {
        return (RowIterator)getAttributeInternal(BaWaWEBSOURCEMULTIANSWERS);
    }

    /**Creates a Key object based on given key constituents
     */
    public static Key createPrimaryKey(Number sraId) {
        return new Key(new Object[]{sraId});
    }
}