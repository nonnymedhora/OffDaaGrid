package com.bawaweb.views.updatable.client;

import com.bawaweb.views.updatable.common.OtlSourceMultiAnswersUView;

import oracle.jbo.client.remote.ViewUsageImpl;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class OtlSourceMultiAnswersUViewClient extends ViewUsageImpl implements OtlSourceMultiAnswersUView {
    /**This is the default constructor (do not remove)
     */
    public OtlSourceMultiAnswersUViewClient() {
    }

    public long getEstimatedRowCount() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"getEstimatedRowCount",null,null);
        return ((Long)_ret).longValue();
    }

    public Number getsma_sra_id() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"getsma_sra_id",null,null);
        return (Number)_ret;
    }

    public void setsma_sra_id(Number value) {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"setsma_sra_id",new String [] {"oracle.jbo.domain.Number"},new Object[] {value});
        return;
    }
}
