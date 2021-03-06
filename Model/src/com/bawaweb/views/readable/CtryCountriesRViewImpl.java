package com.bawaweb.views.readable;

import com.bawaweb.views.readable.common.CtryCountriesRView;

import java.sql.ResultSet;

import oracle.jbo.domain.Number;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CtryCountriesRViewImpl extends ViewObjectImpl implements CtryCountriesRView {
    /**This is the default constructor (do not remove)
     */
    public CtryCountriesRViewImpl() {
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

    /**Gets the bind variable value for ctry_id
     */
    public Number getctry_id() {
        return (Number)getNamedWhereClauseParam("ctry_id");
    }

    /**Sets <code>value</code> for bind variable ctry_id
     */
    public void setctry_id(Number value) {
        setNamedWhereClauseParam("ctry_id", value);
    }
}
