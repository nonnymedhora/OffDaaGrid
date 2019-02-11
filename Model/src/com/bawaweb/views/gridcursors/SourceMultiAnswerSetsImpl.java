package com.bawaweb.views.gridcursors;

import com.bawaweb.views.gridcursors.common.SourceMultiAnswerSets;

import java.sql.ResultSet;

import oracle.jbo.domain.Number;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SourceMultiAnswerSetsImpl extends ViewObjectImpl implements SourceMultiAnswerSets {
    /**This is the default constructor (do not remove)
     */
    public SourceMultiAnswerSetsImpl() {
    }

    /**Gets the bind variable value for qst_id
     */
    public Number getqst_id() {
        return (Number)getNamedWhereClauseParam("qst_id");
    }

    /**Sets <code>value</code> for bind variable qst_id
     */
    public void setqst_id(Number value) {
        setNamedWhereClauseParam("qst_id", value);
    }

    /**Gets the bind variable value for rprt_id
     */
    public Number getrprt_id() {
        return (Number)getNamedWhereClauseParam("rprt_id");
    }

    /**Sets <code>value</code> for bind variable rprt_id
     */
    public void setrprt_id(Number value) {
        setNamedWhereClauseParam("rprt_id", value);
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
