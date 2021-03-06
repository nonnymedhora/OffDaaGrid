package com.bawaweb.views.updatable.client;

import com.bawaweb.views.updatable.common.OtlSourceSortingCriteriaUView;

import oracle.jbo.client.remote.ViewUsageImpl;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class OtlSourceSortingCriteriaUViewClient extends ViewUsageImpl implements OtlSourceSortingCriteriaUView {
    /**This is the default constructor (do not remove)
     */
    public OtlSourceSortingCriteriaUViewClient() {
    }

    public long getEstimatedRowCount() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"getEstimatedRowCount",null,null);
        return ((Long)_ret).longValue();
    }

    public Number getssc_rps_id() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"getssc_rps_id",null,null);
        return (Number)_ret;
    }

    public void setssc_rps_id(Number value) {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"setssc_rps_id",new String [] {"oracle.jbo.domain.Number"},new Object[] {value});
        return;
    }
}
