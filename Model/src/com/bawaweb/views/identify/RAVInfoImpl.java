package com.bawaweb.views.identify;

import com.bawaweb.views.identify.common.RAVInfo;

import java.sql.ResultSet;

import oracle.jbo.domain.Number;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class RAVInfoImpl extends ViewObjectImpl implements RAVInfo {
    /**This is the default constructor (do not remove)
     */
    public RAVInfoImpl() {
    }

    /**Gets the bind variable value for ras_id
     */
    public Number getras_id() {
        return (Number)getNamedWhereClauseParam("ras_id");
    }

    /**Sets <code>value</code> for bind variable ras_id
     */
    public void setras_id(Number value) {
        setNamedWhereClauseParam("ras_id", value);
    }

    /**Gets the bind variable value for answer
     */
    public String getanswer() {
        return (String)getNamedWhereClauseParam("answer");
    }

    /**Sets <code>value</code> for bind variable answer
     */
    public void setanswer(String value) {
        setNamedWhereClauseParam("answer", value);
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
