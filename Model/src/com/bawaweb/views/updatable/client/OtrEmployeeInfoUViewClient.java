package com.bawaweb.views.updatable.client;

import com.bawaweb.views.updatable.common.OtrEmployeeInfoUView;

import oracle.jbo.client.remote.ViewUsageImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class OtrEmployeeInfoUViewClient extends ViewUsageImpl implements OtrEmployeeInfoUView {
    /**This is the default constructor (do not remove)
     */
    public OtrEmployeeInfoUViewClient() {
    }

    public long getEstimatedRowCount() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"getEstimatedRowCount",null,null);
        return ((Long)_ret).longValue();
    }
}
