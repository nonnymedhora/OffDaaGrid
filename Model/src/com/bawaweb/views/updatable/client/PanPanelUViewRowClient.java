package com.bawaweb.views.updatable.client;

import com.bawaweb.views.updatable.common.PanPanelUViewRow;

import oracle.jbo.RowIterator;
import oracle.jbo.client.remote.RowImpl;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PanPanelUViewRowClient extends RowImpl implements PanPanelUViewRow {
    /**This is the default constructor (do not remove)
     */
    public PanPanelUViewRowClient() {
    }

    public RowIterator getRprtReportsUView() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"getRprtReportsUView",null,null);
        return (RowIterator)_ret;
    }

    public Number getFridId() {
        return (Number)getAttribute("FridId");
    }

    public String getPanDesc() {
        return (String)getAttribute("PanDesc");
    }

    public String getPanEnhancedYn() {
        return (String)getAttribute("PanEnhancedYn");
    }

    public String getPanEuropeanYn() {
        return (String)getAttribute("PanEuropeanYn");
    }

    public Number getPanId() {
        return (Number)getAttribute("PanId");
    }

    public String getPanIsProprietaryYn() {
        return (String)getAttribute("PanIsProprietaryYn");
    }

    public String getPanMultiNationalYn() {
        return (String)getAttribute("PanMultiNationalYn");
    }

    public Number getPanSrReporter() {
        return (Number)getAttribute("PanSrReporter");
    }

    public Number getPanStatus() {
        return (Number)getAttribute("PanStatus");
    }

    public void setFridId(Number value) {
        setAttribute("FridId", value);
    }

    public void setPanDesc(String value) {
        setAttribute("PanDesc", value);
    }

    public void setPanEnhancedYn(String value) {
        setAttribute("PanEnhancedYn", value);
    }

    public void setPanEuropeanYn(String value) {
        setAttribute("PanEuropeanYn", value);
    }

    public void setPanId(Number value) {
        setAttribute("PanId", value);
    }

    public void setPanIsProprietaryYn(String value) {
        setAttribute("PanIsProprietaryYn", value);
    }

    public void setPanMultiNationalYn(String value) {
        setAttribute("PanMultiNationalYn", value);
    }

    public void setPanSrReporter(Number value) {
        setAttribute("PanSrReporter", value);
    }

    public void setPanStatus(Number value) {
        setAttribute("PanStatus", value);
    }
}
