package com.bawaweb.views.readable.client;

import com.bawaweb.views.readable.common.OtlSortingCriteriaRViewRow;

import oracle.jbo.RowIterator;
import oracle.jbo.client.remote.RowImpl;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class OtlSortingCriteriaRViewRowClient extends RowImpl implements OtlSortingCriteriaRViewRow {
    /**This is the default constructor (do not remove)
     */
    public OtlSortingCriteriaRViewRowClient() {
    }


    public RowIterator getOtlReportSortingCriteriaRView() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"getOtlReportSortingCriteriaRView",null,null);
        return (RowIterator)_ret;
    }

    public RowIterator getOtlSortingCriteriaValuesRView() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"getOtlSortingCriteriaValuesRView",null,null);
        return (RowIterator)_ret;
    }

    public String getSrtDeleteYn() {
        return (String)getAttribute("SrtDeleteYn");
    }

    public Number getSrtFridId() {
        return (Number)getAttribute("SrtFridId");
    }

    public Number getSrtId() {
        return (Number)getAttribute("SrtId");
    }

    public String getSrtName() {
        return (String)getAttribute("SrtName");
    }

    public void setSrtDeleteYn(String value) {
        setAttribute("SrtDeleteYn", value);
    }

    public void setSrtFridId(Number value) {
        setAttribute("SrtFridId", value);
    }

    public void setSrtId(Number value) {
        setAttribute("SrtId", value);
    }

    public void setSrtName(String value) {
        setAttribute("SrtName", value);
    }
}