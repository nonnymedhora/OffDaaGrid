package com.bawaweb.views.gridcursors;

import com.bawaweb.model.EmplOtlEmployeesImpl;
import com.bawaweb.model.OtlQuestionsImpl;
import com.bawaweb.model.OtlReportAnswerSetValuesImpl;
import com.bawaweb.model.OtlReportSourcesImpl;
import com.bawaweb.model.OtlSourceAnswersImpl;
import com.bawaweb.model.OtlSourcesImpl;
import com.bawaweb.model.OtrTabLocksImpl;
import com.bawaweb.model.RprtReportsImpl;
import com.bawaweb.views.gridcursors.common.SourcesAnswerSetsRow;

import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SourcesAnswerSetsRowImpl extends ViewRowImpl implements SourcesAnswerSetsRow {
    public static final int RAVID = 0;
    public static final int SRAID = 1;
    public static final int QSTTYPE = 2;
    public static final int ANSWER = 3;
    public static final int SRAANSWERTEXT = 4;
    public static final int SRACOLOR = 5;
    public static final int SRACOMMENT = 6;
    public static final int SRARPSID = 7;
    public static final int SRAQSTID = 8;
    public static final int RAVASVID = 9;
    public static final int SRAEXCLUDEYN = 10;
    public static final int RAVDISPLAYSEQ = 11;
    public static final int RAVDELETEYN = 12;
    public static final int SRAWEIGHTMULTIPLIER = 13;

    //    private static final int SRCID = 6;
//    private static final int RPSID = 7;
//    private static final int QSTID = 8;
//    private static final int QMQNUMBER = 9;
//    private static final int QSTTYPE = 10;
//    private static final int SCVNAME = 11;
//    private static final int QMQQSTTYPE = 12;

    /**This is the default constructor (do not remove)
     */
    public SourcesAnswerSetsRowImpl() {
    }

    /**Gets the attribute value for the calculated attribute Answer
     */
    public String getAnswer() {
        return (String) getAttributeInternal(ANSWER);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute Answer
     */
    public void setAnswer(String value) {
        setAttributeInternal(ANSWER, value);
    }

    /**Gets the attribute value for the calculated attribute SraAnswerText
     */
    public String getSraAnswerText() {
        return (String) getAttributeInternal(SRAANSWERTEXT);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute SraAnswerText
     */
    public void setSraAnswerText(String value) {
        setAttributeInternal(SRAANSWERTEXT, value);
    }

    /**Gets the attribute value for the calculated attribute SraColor
     */
    public String getSraColor() {
        return (String) getAttributeInternal(SRACOLOR);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute SraColor
     */
    public void setSraColor(String value) {
        setAttributeInternal(SRACOLOR, value);
    }

    /**Gets the attribute value for the calculated attribute SraComment
     */
    public String getSraComment() {
        return (String) getAttributeInternal(SRACOMMENT);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute SraComment
     */
    public void setSraComment(String value) {
        setAttributeInternal(SRACOMMENT, value);
    }

    /**Gets the attribute value for the calculated attribute SraRpsId
     */
    public Number getSraRpsId() {
        return (Number) getAttributeInternal(SRARPSID);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute SraRpsId
     */
    public void setSraRpsId(Number value) {
        setAttributeInternal(SRARPSID, value);
    }

    /**Gets the attribute value for the calculated attribute SraQstId
     */
    public Number getSraQstId() {
        return (Number) getAttributeInternal(SRAQSTID);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute SraQstId
     */
    public void setSraQstId(Number value) {
        setAttributeInternal(SRAQSTID, value);
    }
    /*
    public Number getSrcId() {
        setAttribute()
    }
    
    public void setSrcId(Number value) {
        setAttributeInternal(SRCID, value);
    }
    
    public void setRpsId(Number value) {
        setAttributeInternal(RPSID, value);
    }
    
    public void setQstId(Number value) {
        setAttributeInternal(QSTID, value);
    }
    
    public void setQmqNumber(Number value) {
        setAttributeInternal(QMQNUMBER, value);
    }
    
    public void setQstType(Number value) {
        setAttributeInternal(QSTTYPE, value);
    }
    
    public void setScvName(Number value) {
        setAttributeInternal(SCVNAME, value);
    }
    
    public void setQmqQstType(Number value) {
        setAttributeInternal(QMQQSTTYPE, value);
    }
   */ 

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case RAVID:
            return getRavId();
        case SRAID:
            return getSraId();
        case QSTTYPE:
            return getQstType();
        case ANSWER:
            return getAnswer();
        case SRAANSWERTEXT:
            return getSraAnswerText();
        case SRACOLOR:
            return getSraColor();
        case SRACOMMENT:
            return getSraComment();
        case SRARPSID:
            return getSraRpsId();
        case SRAQSTID:
            return getSraQstId();
        case RAVASVID:
            return getRavAsvId();
        case SRAEXCLUDEYN:
            return getSraExcludeYn();
        case RAVDISPLAYSEQ:
            return getRavDisplaySeq();
        case RAVDELETEYN:
            return getRavDeleteYn();
        case SRAWEIGHTMULTIPLIER:
            return getSraWeightMultiplier();
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
        case SRAID:
            setSraId((Number)value);
            return;
        case QSTTYPE:
            setQstType((String)value);
            return;
        case ANSWER:
            setAnswer((String)value);
            return;
        case SRAANSWERTEXT:
            setSraAnswerText((String)value);
            return;
        case SRACOLOR:
            setSraColor((String)value);
            return;
        case SRACOMMENT:
            setSraComment((String)value);
            return;
        case SRARPSID:
            setSraRpsId((Number)value);
            return;
        case SRAQSTID:
            setSraQstId((Number)value);
            return;
        case RAVASVID:
            setRavAsvId((Number)value);
            return;
        case SRAEXCLUDEYN:
            setSraExcludeYn((String)value);
            return;
        case RAVDISPLAYSEQ:
            setRavDisplaySeq((Number)value);
            return;
        case RAVDELETEYN:
            setRavDeleteYn((String)value);
            return;
        case SRAWEIGHTMULTIPLIER:
            setSraWeightMultiplier((Number)value);
            return;
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }

    /**Gets OtlReportAnswerSetValues entity object.
     */
    public OtlReportAnswerSetValuesImpl getOtlReportAnswerSetValues() {
        return (OtlReportAnswerSetValuesImpl)getEntity(0);
    }

    /**Gets OtlSourceAnswers entity object.
     */
    public OtlSourceAnswersImpl getOtlSourceAnswers() {
        return (OtlSourceAnswersImpl)getEntity(1);
    }

    /**Gets RprtReports entity object.
     */
    public RprtReportsImpl getRprtReports() {
        return (RprtReportsImpl)getEntity(2);
    }

    /**Gets OtlSources entity object.
     */
    public OtlSourcesImpl getOtlSources() {
        return (OtlSourcesImpl)getEntity(3);
    }

    /**Gets EmplOtlEmployees entity object.
     */
    public EmplOtlEmployeesImpl getEmplOtlEmployees() {
        return (EmplOtlEmployeesImpl)getEntity(4);
    }

    /**Gets OtlReportSources entity object.
     */
    public OtlReportSourcesImpl getOtlReportSources() {
        return (OtlReportSourcesImpl)getEntity(5);
    }


    /**Gets the attribute value for the calculated attribute RavId
     */
    public Number getRavId() {
        return (Number) getAttributeInternal(RAVID);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute RavId
     */
    public void setRavId(Number value) {
        setAttributeInternal(RAVID, value);
    }

    /**Gets the attribute value for the calculated attribute SraId
     */
    public Number getSraId() {
        return (Number) getAttributeInternal(SRAID);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute SraId
     */
    public void setSraId(Number value) {
        setAttributeInternal(SRAID, value);
    }

    /**Gets the attribute value for the calculated attribute QstType
     */
    public String getQstType() {
        return (String) getAttributeInternal(QSTTYPE);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute QstType
     */
    public void setQstType(String value) {
        setAttributeInternal(QSTTYPE, value);
    }

    /**Gets OtlQuestions entity object.
     */
    public OtlQuestionsImpl getOtlQuestions() {
        return (OtlQuestionsImpl)getEntity(6);
    }

    /**Gets the attribute value for the calculated attribute RavAsvId
     */
    public Number getRavAsvId() {
        return (Number) getAttributeInternal(RAVASVID);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute RavAsvId
     */
    public void setRavAsvId(Number value) {
        setAttributeInternal(RAVASVID, value);
    }

    /**Gets the attribute value for the calculated attribute SraExcludeYn
     */
    public String getSraExcludeYn() {
        return (String) getAttributeInternal(SRAEXCLUDEYN);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute SraExcludeYn
     */
    public void setSraExcludeYn(String value) {
        setAttributeInternal(SRAEXCLUDEYN, value);
    }

    /**Gets the attribute value for the calculated attribute RavDisplaySeq
     */
    public Number getRavDisplaySeq() {
        return (Number) getAttributeInternal(RAVDISPLAYSEQ);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute RavDisplaySeq
     */
    public void setRavDisplaySeq(Number value) {
        setAttributeInternal(RAVDISPLAYSEQ, value);
    }

    /**Gets the attribute value for the calculated attribute RavDeleteYn
     */
    public String getRavDeleteYn() {
        return (String) getAttributeInternal(RAVDELETEYN);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute RavDeleteYn
     */
    public void setRavDeleteYn(String value) {
        setAttributeInternal(RAVDELETEYN, value);
    }

    /**Gets the attribute value for the calculated attribute SraWeightMultiplier
     */
    public Number getSraWeightMultiplier() {
        return (Number) getAttributeInternal(SRAWEIGHTMULTIPLIER);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute SraWeightMultiplier
     */
    public void setSraWeightMultiplier(Number value) {
        setAttributeInternal(SRAWEIGHTMULTIPLIER, value);
    }
}