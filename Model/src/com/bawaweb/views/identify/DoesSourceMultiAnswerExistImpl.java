package com.bawaweb.views.identify;

import com.bawaweb.views.identify.common.DoesSourceMultiAnswerExist;

import java.sql.ResultSet;

import oracle.jbo.domain.Number;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class DoesSourceMultiAnswerExistImpl extends ViewObjectImpl implements DoesSourceMultiAnswerExist {
    /**This is the default constructor (do not remove)
     */
    public DoesSourceMultiAnswerExistImpl() {
    }

    /**Gets the bind variable value for sma_sra_id
     */
    public Number getsma_sra_id() {
        return (Number)getNamedWhereClauseParam("sma_sra_id");
    }

    /**Sets <code>value</code> for bind variable sma_sra_id
     */
    public void setsma_sra_id(Number value) {
        setNamedWhereClauseParam("sma_sra_id", value);
    }

    /**Gets the bind variable value for qmq_id
     */
    public Number getqmq_id() {
        return (Number)getNamedWhereClauseParam("qmq_id");
    }

    /**Sets <code>value</code> for bind variable qmq_id
     */
    public void setqmq_id(Number value) {
        setNamedWhereClauseParam("qmq_id", value);
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
