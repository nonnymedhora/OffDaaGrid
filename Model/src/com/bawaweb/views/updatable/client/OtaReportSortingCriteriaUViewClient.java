package com.bawaweb.views.updatable.client;

import com.bawaweb.views.updatable.common.OtlReportSortingCriteriaUView;

import oracle.jbo.client.remote.ViewUsageImpl;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class OtlReportSortingCriteriaUViewClient extends ViewUsageImpl implements OtlReportSortingCriteriaUView {
    /**This is the default constructor (do not remove)
     */
    public OtlReportSortingCriteriaUViewClient() {
    }

    public long getEstimatedRowCount() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"getEstimatedRowCount",null,null);
        return ((Long)_ret).longValue();
    }

    public Number getrso_rprt_id() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"getrso_rprt_id",null,null);
        return (Number)_ret;
    }

    public void setrso_rprt_id(Number value) {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"setrso_rprt_id",new String [] {"oracle.jbo.domain.Number"},new Object[] {value});
        return;
    }
}