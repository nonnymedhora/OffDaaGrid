package com.bawaweb.views.model.client;

import com.bawaweb.views.model.common.SourceSortingCriteria;

import oracle.jbo.client.remote.ViewUsageImpl;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SourceSortingCriteriaClient extends ViewUsageImpl implements SourceSortingCriteria {
    /**This is the default constructor (do not remove)
     */
    public SourceSortingCriteriaClient() {
    }

    public long getEstimatedRowCount() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"getEstimatedRowCount",null,null);
        return ((Long)_ret).longValue();
    }

    public Number getrps_id() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"getrps_id",null,null);
        return (Number)_ret;
    }

    public Number getscv_id() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"getscv_id",null,null);
        return (Number)_ret;
    }

    public void setrps_id(Number value) {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"setrps_id",new String [] {"oracle.jbo.domain.Number"},new Object[] {value});
        return;
    }

    public void setscv_id(Number value) {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"setscv_id",new String [] {"oracle.jbo.domain.Number"},new Object[] {value});
        return;
    }
}
