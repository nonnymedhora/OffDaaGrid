package com.bawaweb.views.readable.client;

import com.bawaweb.views.readable.common.OtlSortingCriteriaValuesRViewRow;

import oracle.jbo.RowIterator;
import oracle.jbo.client.remote.RowImpl;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class OtlSortingCriteriaValuesRViewRowClient extends RowImpl implements OtlSortingCriteriaValuesRViewRow {
    /**This is the default constructor (do not remove)
     */
    public OtlSortingCriteriaValuesRViewRowClient() {
    }

    public RowIterator getOtlSourceSortingCriteriaRView() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"getOtlSourceSortingCriteriaRView",null,null);
        return (RowIterator)_ret;
    }

    public RowIterator getScvIdOtlSortingCriteriaValuesRView() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"getScvIdOtlSortingCriteriaValuesRView",null,null);
        return (RowIterator)_ret;
    }

    public String getScvDataLevelYn() {
        return (String)getAttribute("ScvDataLevelYn");
    }

    public String getScvDeleteYn() {
        return (String)getAttribute("ScvDeleteYn");
    }

    public Number getScvDisplaySeq() {
        return (Number)getAttribute("ScvDisplaySeq");
    }

    public Number getScvId() {
        return (Number)getAttribute("ScvId");
    }

    public String getScvName() {
        return (String)getAttribute("ScvName");
    }

    public Number getScvScvId() {
        return (Number)getAttribute("ScvScvId");
    }

    public Number getScvSrtId() {
        return (Number)getAttribute("ScvSrtId");
    }

    public void setScvDataLevelYn(String value) {
        setAttribute("ScvDataLevelYn", value);
    }

    public void setScvDeleteYn(String value) {
        setAttribute("ScvDeleteYn", value);
    }

    public void setScvDisplaySeq(Number value) {
        setAttribute("ScvDisplaySeq", value);
    }

    public void setScvId(Number value) {
        setAttribute("ScvId", value);
    }

    public void setScvName(String value) {
        setAttribute("ScvName", value);
    }

    public void setScvScvId(Number value) {
        setAttribute("ScvScvId", value);
    }

    public void setScvSrtId(Number value) {
        setAttribute("ScvSrtId", value);
    }
}
