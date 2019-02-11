package com.bawaweb.views.identify;

import com.bawaweb.views.identify.common.SrcAnsUniqueInfo;

import java.sql.ResultSet;

import oracle.jbo.domain.Number;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SrcAnsUniqueInfoImpl extends ViewObjectImpl implements SrcAnsUniqueInfo {
    /**This is the default constructor (do not remove)
     */
    public SrcAnsUniqueInfoImpl() {
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

    /**Gets the bind variable value for rps_id
     */
    public Number getrps_id() {
        return (Number)getNamedWhereClauseParam("rps_id");
    }

    /**Sets <code>value</code> for bind variable rps_id
     */
    public void setrps_id(Number value) {
        setNamedWhereClauseParam("rps_id", value);
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
