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
public class OtlQuestionsImpl extends EntityImpl {
    public static final int QSTID = 0;
    public static final int QSTRPRTID = 1;
    public static final int QSTDISPLAYSEQ = 2;
    public static final int QSTUNIQUEID = 3;
    public static final int QSTNUMBER = 4;
    public static final int QSTTYPE = 5;
    public static final int QSTQUESTION = 6;
    public static final int QSTQUESTIONHINT = 7;
    public static final int QSTTEXTREQUIREDYN = 8;
    public static final int QSTTEXTHINT = 9;
    public static final int QSTANSID = 10;
    public static final int QSTCOMMENT = 11;
    public static final int QSTMULTIANSWERS = 12;
    public static final int QSTTLYID = 13;
    public static final int QSTDELETEYN = 14;
    public static final int QSTPOINTSPREAD = 15;
    public static final int QSTRASID = 16;
    public static final int QSTANALYSISSHOWYN = 17;
    public static final int BaWaWEBSOURCEANSWERS = 18;
    public static final int RPRTREPORTS = 19;
    private static OtlQuestionsDefImpl mDefinitionObject;

    /**This is the default constructor (do not remove)
     */
    public OtlQuestionsImpl() {
    }


    /**Retrieves the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = (OtlQuestionsDefImpl)EntityDefImpl.findDefObject("com.bawaweb.model.OtlQuestions");
        }
        return mDefinitionObject;
    }

    /**Gets the attribute value for QstId, using the alias name QstId
     */
    public Number getQstId() {
        return (Number)getAttributeInternal(QSTID);
    }

    /**Sets <code>value</code> as the attribute value for QstId
     */
    public void setQstId(Number value) {
        setAttributeInternal(QSTID, value);
    }

    /**Gets the attribute value for QstRprtId, using the alias name QstRprtId
     */
    public Number getQstRprtId() {
        return (Number)getAttributeInternal(QSTRPRTID);
    }

    /**Sets <code>value</code> as the attribute value for QstRprtId
     */
    public void setQstRprtId(Number value) {
        setAttributeInternal(QSTRPRTID, value);
    }

    /**Gets the attribute value for QstDisplaySeq, using the alias name QstDisplaySeq
     */
    public Number getQstDisplaySeq() {
        return (Number)getAttributeInternal(QSTDISPLAYSEQ);
    }

    /**Sets <code>value</code> as the attribute value for QstDisplaySeq
     */
    public void setQstDisplaySeq(Number value) {
        setAttributeInternal(QSTDISPLAYSEQ, value);
    }

    /**Gets the attribute value for QstUniqueId, using the alias name QstUniqueId
     */
    public Number getQstUniqueId() {
        return (Number)getAttributeInternal(QSTUNIQUEID);
    }

    /**Sets <code>value</code> as the attribute value for QstUniqueId
     */
    public void setQstUniqueId(Number value) {
        setAttributeInternal(QSTUNIQUEID, value);
    }

    /**Gets the attribute value for QstNumber, using the alias name QstNumber
     */
    public String getQstNumber() {
        return (String)getAttributeInternal(QSTNUMBER);
    }

    /**Sets <code>value</code> as the attribute value for QstNumber
     */
    public void setQstNumber(String value) {
        setAttributeInternal(QSTNUMBER, value);
    }

    /**Gets the attribute value for QstType, using the alias name QstType
     */
    public String getQstType() {
        return (String)getAttributeInternal(QSTTYPE);
    }

    /**Sets <code>value</code> as the attribute value for QstType
     */
    public void setQstType(String value) {
        setAttributeInternal(QSTTYPE, value);
    }

    /**Gets the attribute value for QstQuestion, using the alias name QstQuestion
     */
    public String getQstQuestion() {
        return (String)getAttributeInternal(QSTQUESTION);
    }

    /**Sets <code>value</code> as the attribute value for QstQuestion
     */
    public void setQstQuestion(String value) {
        setAttributeInternal(QSTQUESTION, value);
    }

    /**Gets the attribute value for QstQuestionHint, using the alias name QstQuestionHint
     */
    public String getQstQuestionHint() {
        return (String)getAttributeInternal(QSTQUESTIONHINT);
    }

    /**Sets <code>value</code> as the attribute value for QstQuestionHint
     */
    public void setQstQuestionHint(String value) {
        setAttributeInternal(QSTQUESTIONHINT, value);
    }

    /**Gets the attribute value for QstTextRequiredYn, using the alias name QstTextRequiredYn
     */
    public String getQstTextRequiredYn() {
        return (String)getAttributeInternal(QSTTEXTREQUIREDYN);
    }

    /**Sets <code>value</code> as the attribute value for QstTextRequiredYn
     */
    public void setQstTextRequiredYn(String value) {
        setAttributeInternal(QSTTEXTREQUIREDYN, value);
    }

    /**Gets the attribute value for QstTextHint, using the alias name QstTextHint
     */
    public String getQstTextHint() {
        return (String)getAttributeInternal(QSTTEXTHINT);
    }

    /**Sets <code>value</code> as the attribute value for QstTextHint
     */
    public void setQstTextHint(String value) {
        setAttributeInternal(QSTTEXTHINT, value);
    }

    /**Gets the attribute value for QstAnsId, using the alias name QstAnsId
     */
    public Number getQstAnsId() {
        return (Number)getAttributeInternal(QSTANSID);
    }

    /**Sets <code>value</code> as the attribute value for QstAnsId
     */
    public void setQstAnsId(Number value) {
        setAttributeInternal(QSTANSID, value);
    }

    /**Gets the attribute value for QstComment, using the alias name QstComment
     */
    public String getQstComment() {
        return (String)getAttributeInternal(QSTCOMMENT);
    }

    /**Sets <code>value</code> as the attribute value for QstComment
     */
    public void setQstComment(String value) {
        setAttributeInternal(QSTCOMMENT, value);
    }

    /**Gets the attribute value for QstMultiAnswers, using the alias name QstMultiAnswers
     */
    public Number getQstMultiAnswers() {
        return (Number)getAttributeInternal(QSTMULTIANSWERS);
    }

    /**Sets <code>value</code> as the attribute value for QstMultiAnswers
     */
    public void setQstMultiAnswers(Number value) {
        setAttributeInternal(QSTMULTIANSWERS, value);
    }

    /**Gets the attribute value for QstTlyId, using the alias name QstTlyId
     */
    public Number getQstTlyId() {
        return (Number)getAttributeInternal(QSTTLYID);
    }

    /**Sets <code>value</code> as the attribute value for QstTlyId
     */
    public void setQstTlyId(Number value) {
        setAttributeInternal(QSTTLYID, value);
    }

    /**Gets the attribute value for QstDeleteYn, using the alias name QstDeleteYn
     */
    public String getQstDeleteYn() {
        return (String)getAttributeInternal(QSTDELETEYN);
    }

    /**Sets <code>value</code> as the attribute value for QstDeleteYn
     */
    public void setQstDeleteYn(String value) {
        setAttributeInternal(QSTDELETEYN, value);
    }

    /**Gets the attribute value for QstPointSpread, using the alias name QstPointSpread
     */
    public Number getQstPointSpread() {
        return (Number)getAttributeInternal(QSTPOINTSPREAD);
    }

    /**Sets <code>value</code> as the attribute value for QstPointSpread
     */
    public void setQstPointSpread(Number value) {
        setAttributeInternal(QSTPOINTSPREAD, value);
    }

    /**Gets the attribute value for QstRasId, using the alias name QstRasId
     */
    public Number getQstRasId() {
        return (Number)getAttributeInternal(QSTRASID);
    }

    /**Sets <code>value</code> as the attribute value for QstRasId
     */
    public void setQstRasId(Number value) {
        setAttributeInternal(QSTRASID, value);
    }

    /**Gets the attribute value for QstAnalysisShowYn, using the alias name QstAnalysisShowYn
     */
    public String getQstAnalysisShowYn() {
        return (String)getAttributeInternal(QSTANALYSISSHOWYN);
    }

    /**Sets <code>value</code> as the attribute value for QstAnalysisShowYn
     */
    public void setQstAnalysisShowYn(String value) {
        setAttributeInternal(QSTANALYSISSHOWYN, value);
    }

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case QSTID:
            return getQstId();
        case QSTRPRTID:
            return getQstRprtId();
        case QSTDISPLAYSEQ:
            return getQstDisplaySeq();
        case QSTUNIQUEID:
            return getQstUniqueId();
        case QSTNUMBER:
            return getQstNumber();
        case QSTTYPE:
            return getQstType();
        case QSTQUESTION:
            return getQstQuestion();
        case QSTQUESTIONHINT:
            return getQstQuestionHint();
        case QSTTEXTREQUIREDYN:
            return getQstTextRequiredYn();
        case QSTTEXTHINT:
            return getQstTextHint();
        case QSTANSID:
            return getQstAnsId();
        case QSTCOMMENT:
            return getQstComment();
        case QSTMULTIANSWERS:
            return getQstMultiAnswers();
        case QSTTLYID:
            return getQstTlyId();
        case QSTDELETEYN:
            return getQstDeleteYn();
        case QSTPOINTSPREAD:
            return getQstPointSpread();
        case QSTRASID:
            return getQstRasId();
        case QSTANALYSISSHOWYN:
            return getQstAnalysisShowYn();
        case BaWaWEBSOURCEANSWERS:
            return getOtlSourceAnswers();
        case RPRTREPORTS:
            return getRprtReports();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value, 
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case QSTID:
            setQstId((Number)value);
            return;
        case QSTRPRTID:
            setQstRprtId((Number)value);
            return;
        case QSTDISPLAYSEQ:
            setQstDisplaySeq((Number)value);
            return;
        case QSTUNIQUEID:
            setQstUniqueId((Number)value);
            return;
        case QSTNUMBER:
            setQstNumber((String)value);
            return;
        case QSTTYPE:
            setQstType((String)value);
            return;
        case QSTQUESTION:
            setQstQuestion((String)value);
            return;
        case QSTQUESTIONHINT:
            setQstQuestionHint((String)value);
            return;
        case QSTTEXTREQUIREDYN:
            setQstTextRequiredYn((String)value);
            return;
        case QSTTEXTHINT:
            setQstTextHint((String)value);
            return;
        case QSTANSID:
            setQstAnsId((Number)value);
            return;
        case QSTCOMMENT:
            setQstComment((String)value);
            return;
        case QSTMULTIANSWERS:
            setQstMultiAnswers((Number)value);
            return;
        case QSTTLYID:
            setQstTlyId((Number)value);
            return;
        case QSTDELETEYN:
            setQstDeleteYn((String)value);
            return;
        case QSTPOINTSPREAD:
            setQstPointSpread((Number)value);
            return;
        case QSTRASID:
            setQstRasId((Number)value);
            return;
        case QSTANALYSISSHOWYN:
            setQstAnalysisShowYn((String)value);
            return;
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }

    /**Gets the associated entity oracle.jbo.RowIterator
     */
    public RowIterator getOtlSourceAnswers() {
        return (RowIterator)getAttributeInternal(BaWaWEBSOURCEANSWERS);
    }

    /**Gets the associated entity RprtReportsImpl
     */
    public RprtReportsImpl getRprtReports() {
        return (RprtReportsImpl)getAttributeInternal(RPRTREPORTS);
    }

    /**Sets <code>value</code> as the associated entity RprtReportsImpl
     */
    public void setRprtReports(RprtReportsImpl value) {
        setAttributeInternal(RPRTREPORTS, value);
    }

    /**Creates a Key object based on given key constituents
     */
    public static Key createPrimaryKey(Number qstId) {
        return new Key(new Object[]{qstId});
    }
}
