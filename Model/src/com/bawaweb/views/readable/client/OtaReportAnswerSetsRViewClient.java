package com.bawaweb.views.readable.client;

import com.bawaweb.views.readable.common.OtlReportAnswerSetsRView;

import oracle.jbo.client.remote.ViewUsageImpl;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class OtlReportAnswerSetsRViewClient extends ViewUsageImpl implements OtlReportAnswerSetsRView {
    /**This is the default constructor (do not remove)
     */
    public OtlReportAnswerSetsRViewClient() {
    }


    public long getEstimatedRowCount() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"getEstimatedRowCount",null,null);
        return ((Long)_ret).longValue();
    }

    public Number getras_id() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"getras_id",null,null);
        return (Number)_ret;
    }

    public void setras_id(Number value) {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"setras_id",new String [] {"oracle.jbo.domain.Number"},new Object[] {value});
        return;
    }
}
