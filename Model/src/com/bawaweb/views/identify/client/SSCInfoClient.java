package com.bawaweb.views.identify.client;

import com.bawaweb.views.identify.common.SSCInfo;

import oracle.jbo.client.remote.ViewUsageImpl;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SSCInfoClient extends ViewUsageImpl implements SSCInfo {
    /**This is the default constructor (do not remove)
     */
    public SSCInfoClient() {
    }


    public long getEstimatedRowCount() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"getEstimatedRowCount",null,null);
        return ((Long)_ret).longValue();
    }

    public String getanswer() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"getanswer",null,null);
        return (String)_ret;
    }

    public Number getqst_id() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"getqst_id",null,null);
        return (Number)_ret;
    }

    public void setanswer(String value) {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"setanswer",new String [] {"java.lang.String"},new Object[] {value});
        return;
    }

    public void setqst_id(Number value) {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"setqst_id",new String [] {"oracle.jbo.domain.Number"},new Object[] {value});
        return;
    }
}
