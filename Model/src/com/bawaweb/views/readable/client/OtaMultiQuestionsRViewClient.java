package com.bawaweb.views.readable.client;

import com.bawaweb.views.readable.common.OtlMultiQuestionsRView;

import oracle.jbo.client.remote.ViewUsageImpl;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class OtlMultiQuestionsRViewClient extends ViewUsageImpl implements OtlMultiQuestionsRView {
    /**This is the default constructor (do not remove)
     */
    public OtlMultiQuestionsRViewClient() {
    }


    public long getEstimatedRowCount() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"getEstimatedRowCount",null,null);
        return ((Long)_ret).longValue();
    }

    public Number getqmq_id() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"getqmq_id",null,null);
        return (Number)_ret;
    }

    public void setqmq_id(Number value) {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"setqmq_id",new String [] {"oracle.jbo.domain.Number"},new Object[] {value});
        return;
    }
}
