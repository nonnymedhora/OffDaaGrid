package com.bawaweb.views.gridcursors.client;

import oracle.jbo.client.remote.RowImpl;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class LeadReporterInfoRowClient extends RowImpl {
    /**This is the default constructor (do not remove)
     */
    public LeadReporterInfoRowClient() {
    }


    public String getDistributionNotes() {
        return (String)getAttribute("DistributionNotes");
    }

    public String getEmplFname() {
        return (String)getAttribute("EmplFname");
    }

    public Number getEmplId() {
        return (Number)getAttribute("EmplId");
    }

    public String getEmplLname() {
        return (String)getAttribute("EmplLname");
    }

    public String getRptyDesc() {
        return (String)getAttribute("RptyDesc");
    }

    public Number getRptyId() {
        return (Number)getAttribute("RptyId");
    }

    public void setDistributionNotes(String value) {
        setAttribute("DistributionNotes", value);
    }

    public void setEmplFname(String value) {
        setAttribute("EmplFname", value);
    }

    public void setEmplId(Number value) {
        setAttribute("EmplId", value);
    }

    public void setEmplLname(String value) {
        setAttribute("EmplLname", value);
    }

    public void setRptyDesc(String value) {
        setAttribute("RptyDesc", value);
    }

    public void setRptyId(Number value) {
        setAttribute("RptyId", value);
    }

    public Number getRprtId() {
        return (Number)getAttribute("RprtId");
    }

    public void setRprtId(Number value) {
        setAttribute("RprtId", value);
    }
}
