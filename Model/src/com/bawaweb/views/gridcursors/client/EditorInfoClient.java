package com.bawaweb.views.gridcursors.client;

import com.bawaweb.views.gridcursors.common.EditorInfo;

import oracle.jbo.client.remote.ViewUsageImpl;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class EditorInfoClient extends ViewUsageImpl implements EditorInfo {
    /**This is the default constructor (do not remove)
     */
    public EditorInfoClient() {
    }


    public long getEstimatedRowCount() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"getEstimatedRowCount",null,null);
        return ((Long)_ret).longValue();
    }

    public Number getrprtId() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"getrprtId",null,null);
        return (Number)_ret;
    }

    public void setrprtId(Number value) {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"setrprtId",new String [] {"oracle.jbo.domain.Number"},new Object[] {value});
        return;
    }
}
