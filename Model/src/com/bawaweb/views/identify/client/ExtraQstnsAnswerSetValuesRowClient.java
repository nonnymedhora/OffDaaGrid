package com.bawaweb.views.identify.client;

import oracle.jbo.client.remote.RowImpl;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ExtraQstnsAnswerSetValuesRowClient extends RowImpl {
    /**This is the default constructor (do not remove)
     */
    public ExtraQstnsAnswerSetValuesRowClient() {
    }


    public Number getAnsId() {
        return (Number)getAttribute("AnsId");
    }

    public Number getAsvAnsId() {
        return (Number)getAttribute("AsvAnsId");
    }

    public String getAsvAnswer() {
        return (String)getAttribute("AsvAnswer");
    }

    public String getAsvDeleteYn() {
        return (String)getAttribute("AsvDeleteYn");
    }

    public Number getAsvDisplaySeq() {
        return (Number)getAttribute("AsvDisplaySeq");
    }

    public Number getAsvId() {
        return (Number)getAttribute("AsvId");
    }

    public Number getQstAnsId() {
        return (Number)getAttribute("QstAnsId");
    }

    public Number getQstId() {
        return (Number)getAttribute("QstId");
    }

    public Number getQstRasId() {
        return (Number)getAttribute("QstRasId");
    }

    public void setAnsId(Number value) {
        setAttribute("AnsId", value);
    }

    public void setAsvAnsId(Number value) {
        setAttribute("AsvAnsId", value);
    }

    public void setAsvAnswer(String value) {
        setAttribute("AsvAnswer", value);
    }

    public void setAsvDeleteYn(String value) {
        setAttribute("AsvDeleteYn", value);
    }

    public void setAsvDisplaySeq(Number value) {
        setAttribute("AsvDisplaySeq", value);
    }

    public void setAsvId(Number value) {
        setAttribute("AsvId", value);
    }

    public void setQstAnsId(Number value) {
        setAttribute("QstAnsId", value);
    }

    public void setQstId(Number value) {
        setAttribute("QstId", value);
    }

    public void setQstRasId(Number value) {
        setAttribute("QstRasId", value);
    }
}