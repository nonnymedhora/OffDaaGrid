package com.bawaweb.views.readable.client;

import com.bawaweb.views.readable.common.OtlQuestionsRView;

import oracle.jbo.client.remote.ViewUsageImpl;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class OtlQuestionsRViewClient extends ViewUsageImpl implements OtlQuestionsRView {
    /**This is the default constructor (do not remove)
     */
    public OtlQuestionsRViewClient() {
    }


    public long getEstimatedRowCount() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"getEstimatedRowCount",null,null);
        return ((Long)_ret).longValue();
    }

    public Number getqst_id() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"getqst_id",null,null);
        return (Number)_ret;
    }

    public void setqst_id(Number value) {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"setqst_id",new String [] {"oracle.jbo.domain.Number"},new Object[] {value});
        return;
    }
}
