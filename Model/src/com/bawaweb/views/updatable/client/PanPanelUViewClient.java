package com.bawaweb.views.updatable.client;

import com.bawaweb.views.updatable.common.PanPanelUView;

import oracle.jbo.client.remote.ViewUsageImpl;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PanPanelUViewClient extends ViewUsageImpl implements PanPanelUView {
    /**This is the default constructor (do not remove)
     */
    public PanPanelUViewClient() {
    }

    public long getEstimatedRowCount() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"getEstimatedRowCount",null,null);
        return ((Long)_ret).longValue();
    }

    public Number getpan_id() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"getpan_id",null,null);
        return (Number)_ret;
    }

    public void setpan_id(Number value) {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"setpan_id",new String [] {"oracle.jbo.domain.Number"},new Object[] {value});
        return;
    }
}
