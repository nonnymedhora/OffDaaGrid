package com.bawaweb.views.updatable.client;

import com.bawaweb.views.updatable.common.OtlSortingCriteriaUView;

import oracle.jbo.client.remote.ViewUsageImpl;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class OtlSortingCriteriaUViewClient extends ViewUsageImpl implements OtlSortingCriteriaUView {
    /**This is the default constructor (do not remove)
     */
    public OtlSortingCriteriaUViewClient() {
    }

    public long getEstimatedRowCount() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"getEstimatedRowCount",null,null);
        return ((Long)_ret).longValue();
    }

    public Number getsrt_id() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"getsrt_id",null,null);
        return (Number)_ret;
    }

    public void setsrt_id(Number value) {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"setsrt_id",new String [] {"oracle.jbo.domain.Number"},new Object[] {value});
        return;
    }
}
