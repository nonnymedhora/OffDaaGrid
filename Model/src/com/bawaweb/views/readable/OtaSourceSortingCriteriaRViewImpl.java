package com.bawaweb.views.readable;

import com.bawaweb.views.readable.common.OtlSourceSortingCriteriaRView;

import java.sql.ResultSet;

import oracle.jbo.domain.Number;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class OtlSourceSortingCriteriaRViewImpl extends ViewObjectImpl implements OtlSourceSortingCriteriaRView {
    /**This is the default constructor (do not remove)
     */
    public OtlSourceSortingCriteriaRViewImpl() {
    }

    /**Gets the bind variable value for ssc_rps_id
     */
    public Number getssc_rps_id() {
        return (Number)getNamedWhereClauseParam("ssc_rps_id");
    }

    /**Sets <code>value</code> for bind variable ssc_rps_id
     */
    public void setssc_rps_id(Number value) {
        setNamedWhereClauseParam("ssc_rps_id", value);
    }

    /**executeQueryForCollection - overridden for custom java data source support.
     */
    protected void executeQueryForCollection(Object qc, Object params[], int noUserParams) {super.executeQueryForCollection(qc, params, noUserParams);
    }

    /**hasNextForCollection - overridden for custom java data source support.
     */
    protected boolean hasNextForCollection(Object qc) {
        boolean bRet = super.hasNextForCollection(qc);
        return bRet;
    }

    /**createRowFromResultSet - overridden for custom java data source support.
     */
    protected ViewRowImpl createRowFromResultSet(Object qc, 
                                                 ResultSet resultSet) {
        ViewRowImpl value = super.createRowFromResultSet(qc, resultSet);
        return value;
    }

    /**getEstimatedRowCount - overridden for custom java data source support.
     */
    public long getEstimatedRowCount() {
        long value = super.getEstimatedRowCount();
        return value;
    }
}