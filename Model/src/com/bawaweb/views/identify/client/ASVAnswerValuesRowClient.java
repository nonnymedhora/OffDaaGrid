package com.bawaweb.views.identify.client;

import oracle.jbo.client.remote.RowImpl;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ASVAnswerValuesRowClient extends RowImpl {
    /**This is the default constructor (do not remove)
     */
    public ASVAnswerValuesRowClient() {
    }


    public String getAsvAnswer() {
        return (String)getAttribute("AsvAnswer");
    }

    public void setAsvAnswer(String value) {
        setAttribute("AsvAnswer", value);
    }

    public Number getAsvId() {
        return (Number)getAttribute("AsvId");
    }

    public void setAsvId(Number value) {
        setAttribute("AsvId", value);
    }
}
