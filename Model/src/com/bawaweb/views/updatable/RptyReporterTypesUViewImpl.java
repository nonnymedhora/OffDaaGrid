package com.bawaweb.views.updatable;

import com.bawaweb.views.updatable.common.RptyReporterTypesUView;

import java.sql.ResultSet;

import oracle.jbo.domain.Number;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class RptyReporterTypesUViewImpl extends ViewObjectImpl implements RptyReporterTypesUView {
    /**This is the default constructor (do not remove)
     */
    public RptyReporterTypesUViewImpl() {
    }

    /**Gets the bind variable value for rpty_id
     */
    public Number getrpty_id() {
        return (Number)getNamedWhereClauseParam("rpty_id");
    }

    /**Sets <code>value</code> for bind variable rpty_id
     */
    public void setrpty_id(Number value) {
        setNamedWhereClauseParam("rpty_id", value);
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
