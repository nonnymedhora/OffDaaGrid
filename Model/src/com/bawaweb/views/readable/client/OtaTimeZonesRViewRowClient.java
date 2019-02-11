package com.bawaweb.views.readable.client;

import com.bawaweb.views.readable.common.OtlTimeZonesRViewRow;

import oracle.jbo.RowIterator;
import oracle.jbo.client.remote.RowImpl;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class OtlTimeZonesRViewRowClient extends RowImpl implements OtlTimeZonesRViewRow {
    /**This is the default constructor (do not remove)
     */
    public OtlTimeZonesRViewRowClient() {
    }

    public RowIterator getOtlSourcesRView() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"getOtlSourcesRView",null,null);
        return (RowIterator)_ret;
    }

    public String getTmzDeleteYn() {
        return (String)getAttribute("TmzDeleteYn");
    }

    public String getTmzDescription() {
        return (String)getAttribute("TmzDescription");
    }

    public Number getTmzGmtAdjustmentHrs() {
        return (Number)getAttribute("TmzGmtAdjustmentHrs");
    }

    public Number getTmzGmtAdjustmentMin() {
        return (Number)getAttribute("TmzGmtAdjustmentMin");
    }

    public Number getTmzId() {
        return (Number)getAttribute("TmzId");
    }

    public String getTmzName() {
        return (String)getAttribute("TmzName");
    }

    public void setTmzDeleteYn(String value) {
        setAttribute("TmzDeleteYn", value);
    }

    public void setTmzDescription(String value) {
        setAttribute("TmzDescription", value);
    }

    public void setTmzGmtAdjustmentHrs(Number value) {
        setAttribute("TmzGmtAdjustmentHrs", value);
    }

    public void setTmzGmtAdjustmentMin(Number value) {
        setAttribute("TmzGmtAdjustmentMin", value);
    }

    public void setTmzId(Number value) {
        setAttribute("TmzId", value);
    }

    public void setTmzName(String value) {
        setAttribute("TmzName", value);
    }
}
