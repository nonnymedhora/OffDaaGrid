package com.bawaweb.views.gridcursors;

import com.bawaweb.views.gridcursors.common.TableLocksInfo;

import java.sql.ResultSet;

import oracle.jbo.domain.Number;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class TableLocksInfoImpl extends ViewObjectImpl implements TableLocksInfo {
    /**This is the default constructor (do not remove)
     */
    public TableLocksInfoImpl() {
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

    /**Gets the bind variable value for otl_id
     */
    public Number getotl_id() {
        return (Number)getNamedWhereClauseParam("otl_id");
    }

    /**Sets <code>value</code> for bind variable otl_id
     */
    public void setotl_id(Number value) {
        setNamedWhereClauseParam("otl_id", value);
    }

    /**Gets the bind variable value for emp_id
     */
    public String getemp_id() {
        return (String)getNamedWhereClauseParam("emp_id");
    }

    /**Sets <code>value</code> for bind variable emp_id
     */
    public void setemp_id(String value) {
        setNamedWhereClauseParam("emp_id", value);
    }

    /**Gets the bind variable value for tab_name
     */
    public String gettab_name() {
        return (String)getNamedWhereClauseParam("tab_name");
    }

    /**Sets <code>value</code> for bind variable tab_name
     */
    public void settab_name(String value) {
        setNamedWhereClauseParam("tab_name", value);
    }

    /**Gets the bind variable value for tab_id
     */
    public Number gettab_id() {
        return (Number)getNamedWhereClauseParam("tab_id");
    }

    /**Sets <code>value</code> for bind variable tab_id
     */
    public void settab_id(Number value) {
        setNamedWhereClauseParam("tab_id", value);
    }
}
