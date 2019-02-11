package com.bawaweb.views.updatable.client;

import com.bawaweb.views.updatable.common.OtlReportAnswerSetValuesUViewRow;

import oracle.jbo.RowIterator;
import oracle.jbo.client.remote.RowImpl;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class OtlReportAnswerSetValuesUViewRowClient extends RowImpl implements OtlReportAnswerSetValuesUViewRow {
    /**This is the default constructor (do not remove)
     */
    public OtlReportAnswerSetValuesUViewRowClient() {
    }


    public RowIterator getOtlSourceAnswersUView() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"getOtlSourceAnswersUView",null,null);
        return (RowIterator)_ret;
    }

    public RowIterator getOtlSourceMultiAnswersUView() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"getOtlSourceMultiAnswersUView",null,null);
        return (RowIterator)_ret;
    }

    public String getRavAnswer() {
        return (String)getAttribute("RavAnswer");
    }

    public Number getRavAsvId() {
        return (Number)getAttribute("RavAsvId");
    }

    public String getRavDeleteYn() {
        return (String)getAttribute("RavDeleteYn");
    }

    public Number getRavDisplaySeq() {
        return (Number)getAttribute("RavDisplaySeq");
    }

    public Number getRavId() {
        return (Number)getAttribute("RavId");
    }

    public Number getRavRasId() {
        return (Number)getAttribute("RavRasId");
    }

    public void setRavAnswer(String value) {
        setAttribute("RavAnswer", value);
    }

    public void setRavAsvId(Number value) {
        setAttribute("RavAsvId", value);
    }

    public void setRavDeleteYn(String value) {
        setAttribute("RavDeleteYn", value);
    }

    public void setRavDisplaySeq(Number value) {
        setAttribute("RavDisplaySeq", value);
    }

    public void setRavId(Number value) {
        setAttribute("RavId", value);
    }

    public void setRavRasId(Number value) {
        setAttribute("RavRasId", value);
    }
}
