package com.bawaweb.views.readable.client;

import com.bawaweb.views.readable.common.OtrTabLocksRView;

import oracle.jbo.client.remote.ViewUsageImpl;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class OtrTabLocksRViewClient extends ViewUsageImpl implements OtrTabLocksRView {
    /**This is the default constructor (do not remove)
     */
    public OtrTabLocksRViewClient() {
    }

    public long getEstimatedRowCount() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"getEstimatedRowCount",null,null);
        return ((Long)_ret).longValue();
    }

    public Number getotl_id() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"getotl_id",null,null);
        return (Number)_ret;
    }
}
