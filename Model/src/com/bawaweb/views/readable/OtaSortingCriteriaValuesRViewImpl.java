package com.bawaweb.views.readable;

import com.bawaweb.views.readable.common.OtlSortingCriteriaValuesRView;

import java.sql.ResultSet;

import oracle.jbo.domain.Number;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class OtlSortingCriteriaValuesRViewImpl extends ViewObjectImpl implements OtlSortingCriteriaValuesRView {
    /**This is the default constructor (do not remove)
     */
    public OtlSortingCriteriaValuesRViewImpl() {
    }

    /**Gets the bind variable value for scv_id
     */
    public Number getscv_id() {
        return (Number)getNamedWhereClauseParam("scv_id");
    }

    /**Sets <code>value</code> for bind variable scv_id
     */
    public void setscv_id(Number value) {
        setNamedWhereClauseParam("scv_id", value);
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
