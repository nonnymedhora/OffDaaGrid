package com.bawaweb.views.readable.client;

import oracle.jbo.client.remote.RowImpl;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class OtlFunctionsRViewRowClient extends RowImpl {
    /**This is the default constructor (do not remove)
     */
    public OtlFunctionsRViewRowClient() {
    }


    public String getFncCallMenu() {
        return (String)getAttribute("FncCallMenu");
    }

    public String getFncIcon1() {
        return (String)getAttribute("FncIcon1");
    }

    public Number getFncId() {
        return (Number)getAttribute("FncId");
    }

    public Number getFncLink1() {
        return (Number)getAttribute("FncLink1");
    }

    public String getFncMenu() {
        return (String)getAttribute("FncMenu");
    }

    public Number getFncMenuSeq() {
        return (Number)getAttribute("FncMenuSeq");
    }

    public String getFncName() {
        return (String)getAttribute("FncName");
    }

    public String getFncPage() {
        return (String)getAttribute("FncPage");
    }

    public String getFncPageNewVersion() {
        return (String)getAttribute("FncPageNewVersion");
    }

    public void setFncCallMenu(String value) {
        setAttribute("FncCallMenu", value);
    }

    public void setFncIcon1(String value) {
        setAttribute("FncIcon1", value);
    }

    public void setFncId(Number value) {
        setAttribute("FncId", value);
    }

    public void setFncLink1(Number value) {
        setAttribute("FncLink1", value);
    }

    public void setFncMenu(String value) {
        setAttribute("FncMenu", value);
    }

    public void setFncMenuSeq(Number value) {
        setAttribute("FncMenuSeq", value);
    }

    public void setFncName(String value) {
        setAttribute("FncName", value);
    }

    public void setFncPage(String value) {
        setAttribute("FncPage", value);
    }

    public void setFncPageNewVersion(String value) {
        setAttribute("FncPageNewVersion", value);
    }
}
