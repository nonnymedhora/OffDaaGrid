package com.bawaweb.views.utils.client;

import oracle.jbo.client.remote.RowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CourtesyTitlesRowClient extends RowImpl {
    /**This is the default constructor (do not remove)
     */
    public CourtesyTitlesRowClient() {
    }


    public String getCtlCode() {
        return (String)getAttribute("CtlCode");
    }

    public void setCtlCode(String value) {
        setAttribute("CtlCode", value);
    }

    public String getCtlDesc() {
        return (String)getAttribute("CtlDesc");
    }

    public void setCtlDesc(String value) {
        setAttribute("CtlDesc", value);
    }

    public String getCtlCourtesyTitle() {
        return (String)getAttribute("CtlCourtesyTitle");
    }

    public void setCtlCourtesyTitle(String value) {
        setAttribute("CtlCourtesyTitle", value);
    }

    public String getCtlDeleteYn() {
        return (String)getAttribute("CtlDeleteYn");
    }

    public void setCtlDeleteYn(String value) {
        setAttribute("CtlDeleteYn", value);
    }
}