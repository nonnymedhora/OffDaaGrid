package com.bawaweb.views.gridcursors;

import com.bawaweb.views.gridcursors.common.TallyRangeSets;

import java.sql.ResultSet;

import oracle.jbo.domain.Number;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class TallyRangeSetsImpl extends ViewObjectImpl implements TallyRangeSets {
    /**This is the default constructor (do not remove)
     */
    public TallyRangeSetsImpl() {
    }

    /**Gets the bind variable value for tly_id
     */
    public Number gettly_id() {
        return (Number)getNamedWhereClauseParam("tly_id");
    }

    /**Sets <code>value</code> for bind variable tly_id
     */
    public void settly_id(Number value) {
        setNamedWhereClauseParam("tly_id", value);
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