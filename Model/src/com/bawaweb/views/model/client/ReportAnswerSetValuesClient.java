package com.bawaweb.views.model.client;

import com.bawaweb.views.model.common.ReportAnswerSetValues;

import oracle.jbo.client.remote.ViewUsageImpl;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ReportAnswerSetValuesClient extends ViewUsageImpl implements ReportAnswerSetValues {
    /**This is the default constructor (do not remove)
     */
    public ReportAnswerSetValuesClient() {
    }


    public long getEstimatedRowCount() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"getEstimatedRowCount",null,null);
        return ((Long)_ret).longValue();
    }

    public Number getrav_id() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"getrav_id",null,null);
        return (Number)_ret;
    }

    public void setrav_id(Number value) {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"setrav_id",new String [] {"oracle.jbo.domain.Number"},new Object[] {value});
        return;
    }
}
