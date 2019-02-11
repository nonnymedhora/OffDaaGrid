package com.bawaweb.views.updatable;

import com.bawaweb.views.updatable.common.OtlSortingCriteriaUView;

import java.sql.ResultSet;

import oracle.jbo.domain.Number;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class OtlSortingCriteriaUViewImpl extends ViewObjectImpl implements OtlSortingCriteriaUView {
    /**This is the default constructor (do not remove)
     */
    public OtlSortingCriteriaUViewImpl() {
    }

    /**Gets the bind variable value for srt_id
     */
    public Number getsrt_id() {
        return (Number)getNamedWhereClauseParam("srt_id");
    }

    /**Sets <code>value</code> for bind variable srt_id
     */
    public void setsrt_id(Number value) {
        setNamedWhereClauseParam("srt_id", value);
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