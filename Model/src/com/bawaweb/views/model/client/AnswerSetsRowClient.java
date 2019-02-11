package com.bawaweb.views.model.client;

import oracle.jbo.client.remote.RowImpl;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class AnswerSetsRowClient extends RowImpl {
    /**This is the default constructor (do not remove)
     */
    public AnswerSetsRowClient() {
    }


    public String getAnsAddAnswerYn() {
        return (String)getAttribute("AnsAddAnswerYn");
    }

    public String getAnsDeleteYn() {
        return (String)getAttribute("AnsDeleteYn");
    }

    public Number getAnsFridId() {
        return (Number)getAttribute("AnsFridId");
    }

    public Number getAnsId() {
        return (Number)getAttribute("AnsId");
    }

    public String getAnsName() {
        return (String)getAttribute("AnsName");
    }

    public String getAnsOrderByNameYn() {
        return (String)getAttribute("AnsOrderByNameYn");
    }

    public void setAnsAddAnswerYn(String value) {
        setAttribute("AnsAddAnswerYn", value);
    }

    public void setAnsDeleteYn(String value) {
        setAttribute("AnsDeleteYn", value);
    }

    public void setAnsFridId(Number value) {
        setAttribute("AnsFridId", value);
    }

    public void setAnsId(Number value) {
        setAttribute("AnsId", value);
    }

    public void setAnsName(String value) {
        setAttribute("AnsName", value);
    }

    public void setAnsOrderByNameYn(String value) {
        setAttribute("AnsOrderByNameYn", value);
    }
}