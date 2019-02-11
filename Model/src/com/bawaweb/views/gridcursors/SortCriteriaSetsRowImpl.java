package com.bawaweb.views.gridcursors;

import com.bawaweb.model.OtlReportSortingCriteriaImpl;
import com.bawaweb.model.OtlSortingCriteriaValuesImpl;
import com.bawaweb.views.gridcursors.common.SortCriteriaSetsRow;

import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SortCriteriaSetsRowImpl extends ViewRowImpl implements SortCriteriaSetsRow {
    public static final int SCVID = 0;
    public static final int SCVSRTID = 1;
    public static final int SCVSCVID = 2;
    public static final int SCVDISPLAYSEQ = 3;
    public static final int SCVNAME = 4;
    public static final int SCVDATALEVELYN = 5;
    public static final int SCVDELETEYN = 6;

    /**This is the default constructor (do not remove)
     */
    public SortCriteriaSetsRowImpl() {
    }

    /**Gets the attribute value for the calculated attribute ScvId
     */
    public Number getScvId() {
        return (Number) getAttributeInternal(SCVID);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute ScvId
     */
    public void setScvId(Number value) {
        setAttributeInternal(SCVID, value);
    }

    /**Gets the attribute value for the calculated attribute ScvSrtId
     */
    public Number getScvSrtId() {
        return (Number) getAttributeInternal(SCVSRTID);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute ScvSrtId
     */
    public void setScvSrtId(Number value) {
        setAttributeInternal(SCVSRTID, value);
    }

    /**Gets the attribute value for the calculated attribute ScvScvId
     */
    public Number getScvScvId() {
        return (Number) getAttributeInternal(SCVSCVID);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute ScvScvId
     */
    public void setScvScvId(Number value) {
        setAttributeInternal(SCVSCVID, value);
    }

    /**Gets the attribute value for the calculated attribute ScvDisplaySeq
     */
    public Number getScvDisplaySeq() {
        return (Number) getAttributeInternal(SCVDISPLAYSEQ);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute ScvDisplaySeq
     */
    public void setScvDisplaySeq(Number value) {
        setAttributeInternal(SCVDISPLAYSEQ, value);
    }

    /**Gets the attribute value for the calculated attribute ScvName
     */
    public String getScvName() {
        return (String) getAttributeInternal(SCVNAME);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute ScvName
     */
    public void setScvName(String value) {
        setAttributeInternal(SCVNAME, value);
    }

    /**Gets the attribute value for the calculated attribute ScvDataLevelYn
     */
    public String getScvDataLevelYn() {
        return (String) getAttributeInternal(SCVDATALEVELYN);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute ScvDataLevelYn
     */
    public void setScvDataLevelYn(String value) {
        setAttributeInternal(SCVDATALEVELYN, value);
    }

    /**Gets the attribute value for the calculated attribute ScvDeleteYn
     */
    public String getScvDeleteYn() {
        return (String) getAttributeInternal(SCVDELETEYN);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute ScvDeleteYn
     */
    public void setScvDeleteYn(String value) {
        setAttributeInternal(SCVDELETEYN, value);
    }

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case SCVID:
            return getScvId();
        case SCVSRTID:
            return getScvSrtId();
        case SCVSCVID:
            return getScvScvId();
        case SCVDISPLAYSEQ:
            return getScvDisplaySeq();
        case SCVNAME:
            return getScvName();
        case SCVDATALEVELYN:
            return getScvDataLevelYn();
        case SCVDELETEYN:
            return getScvDeleteYn();
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

    /**Gets OtlSortingCriteriaValues entity object.
     */
    public OtlSortingCriteriaValuesImpl getOtlSortingCriteriaValues() {
        return (OtlSortingCriteriaValuesImpl)getEntity(0);
    }

    /**Gets OtlReportSortingCriteria entity object.
     */
    public OtlReportSortingCriteriaImpl getOtlReportSortingCriteria() {
        return (OtlReportSortingCriteriaImpl)getEntity(1);
    }
}
