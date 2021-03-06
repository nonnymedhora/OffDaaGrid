package com.bawaweb.views.updatable;

import com.bawaweb.model.OtlSortingCriteriaValuesImpl;

import com.bawaweb.views.updatable.common.OtlSortingCriteriaValuesUViewRow;

import oracle.jbo.Row;
import oracle.jbo.RowIterator;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class OtlSortingCriteriaValuesUViewRowImpl extends ViewRowImpl implements OtlSortingCriteriaValuesUViewRow {
    public static final int SCVID = 0;
    public static final int SCVSRTID = 1;
    public static final int SCVSCVID = 2;
    public static final int SCVDISPLAYSEQ = 3;
    public static final int SCVNAME = 4;
    public static final int SCVDATALEVELYN = 5;
    public static final int SCVDELETEYN = 6;
    public static final int BaWaWEBSORTINGCRITERIAVALUESUVIEW = 7;
    public static final int BaWaWEBSOURCESORTINGCRITERIAUVIEW = 8;

    /**This is the default constructor (do not remove)
     */
    public OtlSortingCriteriaValuesUViewRowImpl() {
    }

    /**Gets OtlSortingCriteriaValues entity object.
     */
    public OtlSortingCriteriaValuesImpl getOtlSortingCriteriaValues() {
        return (OtlSortingCriteriaValuesImpl)getEntity(0);
    }

    /**Gets the attribute value for SCV_ID using the alias name ScvId
     */
    public Number getScvId() {
        return (Number) getAttributeInternal(SCVID);
    }

    /**Sets <code>value</code> as attribute value for SCV_ID using the alias name ScvId
     */
    public void setScvId(Number value) {
        setAttributeInternal(SCVID, value);
    }

    /**Gets the attribute value for SCV_SRT_ID using the alias name ScvSrtId
     */
    public Number getScvSrtId() {
        return (Number) getAttributeInternal(SCVSRTID);
    }

    /**Sets <code>value</code> as attribute value for SCV_SRT_ID using the alias name ScvSrtId
     */
    public void setScvSrtId(Number value) {
        setAttributeInternal(SCVSRTID, value);
    }

    /**Gets the attribute value for SCV_SCV_ID using the alias name ScvScvId
     */
    public Number getScvScvId() {
        return (Number) getAttributeInternal(SCVSCVID);
    }

    /**Sets <code>value</code> as attribute value for SCV_SCV_ID using the alias name ScvScvId
     */
    public void setScvScvId(Number value) {
        setAttributeInternal(SCVSCVID, value);
    }

    /**Gets the attribute value for SCV_DISPLAY_SEQ using the alias name ScvDisplaySeq
     */
    public Number getScvDisplaySeq() {
        return (Number) getAttributeInternal(SCVDISPLAYSEQ);
    }

    /**Sets <code>value</code> as attribute value for SCV_DISPLAY_SEQ using the alias name ScvDisplaySeq
     */
    public void setScvDisplaySeq(Number value) {
        setAttributeInternal(SCVDISPLAYSEQ, value);
    }

    /**Gets the attribute value for SCV_NAME using the alias name ScvName
     */
    public String getScvName() {
        return (String) getAttributeInternal(SCVNAME);
    }

    /**Sets <code>value</code> as attribute value for SCV_NAME using the alias name ScvName
     */
    public void setScvName(String value) {
        setAttributeInternal(SCVNAME, value);
    }

    /**Gets the attribute value for SCV_DATA_LEVEL_YN using the alias name ScvDataLevelYn
     */
    public String getScvDataLevelYn() {
        return (String) getAttributeInternal(SCVDATALEVELYN);
    }

    /**Sets <code>value</code> as attribute value for SCV_DATA_LEVEL_YN using the alias name ScvDataLevelYn
     */
    public void setScvDataLevelYn(String value) {
        setAttributeInternal(SCVDATALEVELYN, value);
    }

    /**Gets the attribute value for SCV_DELETE_YN using the alias name ScvDeleteYn
     */
    public String getScvDeleteYn() {
        return (String) getAttributeInternal(SCVDELETEYN);
    }

    /**Sets <code>value</code> as attribute value for SCV_DELETE_YN using the alias name ScvDeleteYn
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
        case BaWaWEBSORTINGCRITERIAVALUESUVIEW:
            return getOtlSortingCriteriaValuesUView();
        case BaWaWEBSOURCESORTINGCRITERIAUVIEW:
            return getOtlSourceSortingCriteriaUView();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value, 
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case SCVID:
            setScvId((Number)value);
            return;
        case SCVSRTID:
            setScvSrtId((Number)value);
            return;
        case SCVSCVID:
            setScvScvId((Number)value);
            return;
        case SCVDISPLAYSEQ:
            setScvDisplaySeq((Number)value);
            return;
        case SCVNAME:
            setScvName((String)value);
            return;
        case SCVDATALEVELYN:
            setScvDataLevelYn((String)value);
            return;
        case SCVDELETEYN:
            setScvDeleteYn((String)value);
            return;
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }

    /**Gets the associated <code>Row</code> using master-detail link OtlSortingCriteriaValuesUView
     */
    public Row getOtlSortingCriteriaValuesUView() {
        return (Row)getAttributeInternal(BaWaWEBSORTINGCRITERIAVALUESUVIEW);
    }

    /**Gets the associated <code>RowIterator</code> using master-detail link OtlSourceSortingCriteriaUView
     */
    public RowIterator getOtlSourceSortingCriteriaUView() {
        return (RowIterator)getAttributeInternal(BaWaWEBSOURCESORTINGCRITERIAUVIEW);
    }
}
