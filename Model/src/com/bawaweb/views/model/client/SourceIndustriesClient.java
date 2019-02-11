package com.bawaweb.views.model.client;

import com.bawaweb.views.model.common.SourceIndustries;

import oracle.jbo.client.remote.ViewUsageImpl;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SourceIndustriesClient extends ViewUsageImpl implements SourceIndustries {
    /**This is the default constructor (do not remove)
     */
    public SourceIndustriesClient() {
    }


    public long getEstimatedRowCount() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"getEstimatedRowCount",null,null);
        return ((Long)_ret).longValue();
    }

    public Number getsrc_id() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"getsrc_id",null,null);
        return (Number)_ret;
    }

    public void setsrc_id(Number value) {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"setsrc_id",new String [] {"oracle.jbo.domain.Number"},new Object[] {value});
        return;
    }
}
