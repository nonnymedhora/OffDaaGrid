package com.bawaweb.views.utils.client;

import oracle.jbo.client.remote.RowImpl;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class IndustryViewsRowClient extends RowImpl {
    /**This is the default constructor (do not remove)
     */
    public IndustryViewsRowClient() {
    }


    public String getLkdLktCode() {
        return (String)getAttribute("LkdLktCode");
    }

    public void setLkdLktCode(String value) {
        setAttribute("LkdLktCode", value);
    }

    public String getLkdCode() {
        return (String)getAttribute("LkdCode");
    }

    public void setLkdCode(String value) {
        setAttribute("LkdCode", value);
    }

    public String getLkdDescription() {
        return (String)getAttribute("LkdDescription");
    }

    public void setLkdDescription(String value) {
        setAttribute("LkdDescription", value);
    }

    public Number getLkdDisplaySeq() {
        return (Number)getAttribute("LkdDisplaySeq");
    }

    public void setLkdDisplaySeq(Number value) {
        setAttribute("LkdDisplaySeq", value);
    }
}
