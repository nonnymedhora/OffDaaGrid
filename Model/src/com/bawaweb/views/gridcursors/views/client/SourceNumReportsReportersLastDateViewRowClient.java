package com.bawaweb.views.gridcursors.views.client;

import oracle.jbo.client.remote.RowImpl;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SourceNumReportsReportersLastDateViewRowClient extends RowImpl {
    /**This is the default constructor (do not remove)
     */
    public SourceNumReportsReportersLastDateViewRowClient() {
    }


    public Date getLastduedate() {
        return (Date)getAttribute("Lastduedate");
    }

    public Number getReporters() {
        return (Number)getAttribute("Reporters");
    }

    public Number getReports() {
        return (Number)getAttribute("Reports");
    }

    public Number getSrcId() {
        return (Number)getAttribute("SrcId");
    }

    public void setLastduedate(Date value) {
        setAttribute("Lastduedate", value);
    }

    public void setReporters(Number value) {
        setAttribute("Reporters", value);
    }

    public void setReports(Number value) {
        setAttribute("Reports", value);
    }

    public void setSrcId(Number value) {
        setAttribute("SrcId", value);
    }
}
