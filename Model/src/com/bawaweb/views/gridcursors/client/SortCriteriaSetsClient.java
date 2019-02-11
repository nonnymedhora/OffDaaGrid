package com.bawaweb.views.gridcursors.client;

import com.bawaweb.views.gridcursors.common.SortCriteriaSets;

import oracle.jbo.client.remote.ViewUsageImpl;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SortCriteriaSetsClient extends ViewUsageImpl implements SortCriteriaSets {
    /**This is the default constructor (do not remove)
     */
    public SortCriteriaSetsClient() {
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

    public Number getrprt_id() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"getrprt_id",null,null);
        return (Number)_ret;
    }

    public void setqst_id(Number value) {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"setqst_id",new String [] {"oracle.jbo.domain.Number"},new Object[] {value});
        return;
    }

    public void setrprt_id(Number value) {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"setrprt_id",new String [] {"oracle.jbo.domain.Number"},new Object[] {value});
        return;
    }
}