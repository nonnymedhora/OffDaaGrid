package com.bawaweb.views.readable.client;

import com.bawaweb.views.readable.common.OtlReportSourcesRViewRow;

import oracle.jbo.RowIterator;
import oracle.jbo.client.remote.RowImpl;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class OtlReportSourcesRViewRowClient extends RowImpl implements OtlReportSourcesRViewRow {
    /**This is the default constructor (do not remove)
     */
    public OtlReportSourcesRViewRowClient() {
    }

    public RowIterator getOtlSourceAnswersRView() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"getOtlSourceAnswersRView",null,null);
        return (RowIterator)_ret;
    }

    public RowIterator getOtlSourceSortingCriteriaRView() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"getOtlSourceSortingCriteriaRView",null,null);
        return (RowIterator)_ret;
    }

    public String getRpsCompedYn() {
        return (String)getAttribute("RpsCompedYn");
    }

    public String getRpsDeleteYn() {
        return (String)getAttribute("RpsDeleteYn");
    }

    public Number getRpsId() {
        return (Number)getAttribute("RpsId");
    }

    public String getRpsRepeatSourceYn() {
        return (String)getAttribute("RpsRepeatSourceYn");
    }

    public Number getRpsRprtId() {
        return (Number)getAttribute("RpsRprtId");
    }

    public Number getRpsRptrId() {
        return (Number)getAttribute("RpsRptrId");
    }

    public Number getRpsSrcId() {
        return (Number)getAttribute("RpsSrcId");
    }

    public void setRpsCompedYn(String value) {
        setAttribute("RpsCompedYn", value);
    }

    public void setRpsDeleteYn(String value) {
        setAttribute("RpsDeleteYn", value);
    }

    public void setRpsId(Number value) {
        setAttribute("RpsId", value);
    }

    public void setRpsRepeatSourceYn(String value) {
        setAttribute("RpsRepeatSourceYn", value);
    }

    public void setRpsRprtId(Number value) {
        setAttribute("RpsRprtId", value);
    }

    public void setRpsRptrId(Number value) {
        setAttribute("RpsRptrId", value);
    }

    public void setRpsSrcId(Number value) {
        setAttribute("RpsSrcId", value);
    }
}
