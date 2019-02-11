package com.bawaweb.views.gridcursors;

import com.bawaweb.grid.templates.data.tables.AnswerSetValuesDataSetInfo;
import com.bawaweb.grid.templates.data.tables.ReportAnswerSetValuesDataSetInfo;
import com.bawaweb.grid.templates.data.tables.TallyRangeLimitsValuesDataSetInfo;
import com.bawaweb.lifecycle.SingleAnswerSetInfoVO;
import com.bawaweb.model.OtlMultiQuestionsImpl;
import com.bawaweb.model.OtlReportAnswerSetsImpl;
import com.bawaweb.views.gridcursors.common.MultiQuestionsListRow;

import java.util.List;

import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class MultiQuestionsListRowImpl extends ViewRowImpl implements MultiQuestionsListRow {
    public static final int QMQID = 0;
    public static final int QMQQSTID = 1;
    public static final int QMQNUMBER = 2;
    public static final int QMQTYPE = 3;
    public static final int QMQHINT = 4;
    public static final int QMQRASID = 5;
    public static final int QMQTLYID = 6;
    public static final int RASFRIDID = 7;

    /**This is the default constructor (do not remove)
     */
    public MultiQuestionsListRowImpl() {
    }

    /**Gets the attribute value for the calculated attribute QmqId
     */
    public Number getQmqId() {
        return (Number) getAttributeInternal(QMQID);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute QmqId
     */
    public void setQmqId(Number value) {
        setAttributeInternal(QMQID, value);
    }

    /**Gets the attribute value for the calculated attribute QmqQstId
     */
    public Number getQmqQstId() {
        return (Number) getAttributeInternal(QMQQSTID);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute QmqQstId
     */
    public void setQmqQstId(Number value) {
        setAttributeInternal(QMQQSTID, value);
    }

    /**Gets the attribute value for the calculated attribute QmqNumber
     */
    public String getQmqNumber() {
        return (String) getAttributeInternal(QMQNUMBER);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute QmqNumber
     */
    public void setQmqNumber(String value) {
        setAttributeInternal(QMQNUMBER, value);
    }

    /**Gets the attribute value for the calculated attribute QmqType
     */
    public String getQmqType() {
        return (String) getAttributeInternal(QMQTYPE);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute QmqType
     */
    public void setQmqType(String value) {
        setAttributeInternal(QMQTYPE, value);
    }

    /**Gets the attribute value for the calculated attribute QmqHint
     */
    public String getQmqHint() {
        return (String) getAttributeInternal(QMQHINT);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute QmqHint
     */
    public void setQmqHint(String value) {
        setAttributeInternal(QMQHINT, value);
    }

    /**Gets the attribute value for the calculated attribute QmqRasId
     */
    public Number getQmqRasId() {
        return (Number) getAttributeInternal(QMQRASID);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute QmqRasId
     */
    public void setQmqRasId(Number value) {
        setAttributeInternal(QMQRASID, value);
    }

    /**Gets the attribute value for the calculated attribute QmqTlyId
     */
    public Number getQmqTlyId() {
        return (Number) getAttributeInternal(QMQTLYID);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute QmqTlyId
     */
    public void setQmqTlyId(Number value) {
        setAttributeInternal(QMQTLYID, value);
    }

    /**Gets the attribute value for the calculated attribute RasFridId
     */
    public Number getRasFridId() {
        return (Number) getAttributeInternal(RASFRIDID);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute RasFridId
     */
    public void setRasFridId(Number value) {
        setAttributeInternal(RASFRIDID, value);
    }

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case QMQID:
            return getQmqId();
        case QMQQSTID:
            return getQmqQstId();
        case QMQNUMBER:
            return getQmqNumber();
        case QMQTYPE:
            return getQmqType();
        case QMQHINT:
            return getQmqHint();
        case QMQRASID:
            return getQmqRasId();
        case QMQTLYID:
            return getQmqTlyId();
        case RASFRIDID:
            return getRasFridId();
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

    /**Gets OtlMultiQuestions entity object.
     */
    public OtlMultiQuestionsImpl getOtlMultiQuestions() {
        return (OtlMultiQuestionsImpl)getEntity(0);
    }

    /**Gets OtlReportAnswerSets entity object.
     */
    public OtlReportAnswerSetsImpl getOtlReportAnswerSets() {
        return (OtlReportAnswerSetsImpl)getEntity(1);
    }
    
    private List<ReportAnswerSetValuesDataSetInfo> singleAnswerSetsInfo;
    public void setSingleAnswerSetsInfo(List<ReportAnswerSetValuesDataSetInfo> info) {
        this.singleAnswerSetsInfo = info;
    }
    
    public List<ReportAnswerSetValuesDataSetInfo> getSingleAnswerSetsInfo() {
        return this.singleAnswerSetsInfo;
    }
    
    private String[]        dataTallyOptions;
    public void setDataTallyOptions(String[] options) {
        this.dataTallyOptions = options;
    }
    
    
    public String[] getDataTallyOptions() {
        return this.dataTallyOptions;
    }
    
    private List<TallyRangeLimitsValuesDataSetInfo> tallyRangeLimitsValuesDataSetInfo;
    public List<TallyRangeLimitsValuesDataSetInfo> getTallyRangeLimitsValuesDataSetInfo() {
        return this.tallyRangeLimitsValuesDataSetInfo;
    }
    
    public void setTallyRangeLimitsValuesDataSetInfo(List<TallyRangeLimitsValuesDataSetInfo> tallys) {
        this.tallyRangeLimitsValuesDataSetInfo = tallys;
    }
}