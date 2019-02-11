package com.bawaweb.views.gridcursors.client;

import oracle.jbo.client.remote.RowImpl;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SourcesAnswerSetsRowClient extends RowImpl {
    /**This is the default constructor (do not remove)
     */
    public SourcesAnswerSetsRowClient() {
    }


    public String getAnswer() {
        return (String)getAttribute("Answer");
    }

    public String getQstType() {
        return (String)getAttribute("QstType");
    }

    public Number getRavAsvId() {
        return (Number)getAttribute("RavAsvId");
    }

    public String getRavDeleteYn() {
        return (String)getAttribute("RavDeleteYn");
    }

    public Number getRavDisplaySeq() {
        return (Number)getAttribute("RavDisplaySeq");
    }

    public Number getRavId() {
        return (Number)getAttribute("RavId");
    }

    public String getSraAnswerText() {
        return (String)getAttribute("SraAnswerText");
    }

    public String getSraColor() {
        return (String)getAttribute("SraColor");
    }

    public String getSraComment() {
        return (String)getAttribute("SraComment");
    }

    public String getSraExcludeYn() {
        return (String)getAttribute("SraExcludeYn");
    }

    public Number getSraId() {
        return (Number)getAttribute("SraId");
    }

    public Number getSraQstId() {
        return (Number)getAttribute("SraQstId");
    }

    public Number getSraRpsId() {
        return (Number)getAttribute("SraRpsId");
    }

    public Number getSraWeightMultiplier() {
        return (Number)getAttribute("SraWeightMultiplier");
    }

    public void setAnswer(String value) {
        setAttribute("Answer", value);
    }

    public void setQstType(String value) {
        setAttribute("QstType", value);
    }

    public void setRavAsvId(Number value) {
        setAttribute("RavAsvId", value);
    }

    public void setRavDeleteYn(String value) {
        setAttribute("RavDeleteYn", value);
    }

    public void setRavDisplaySeq(Number value) {
        setAttribute("RavDisplaySeq", value);
    }

    public void setRavId(Number value) {
        setAttribute("RavId", value);
    }

    public void setSraAnswerText(String value) {
        setAttribute("SraAnswerText", value);
    }

    public void setSraColor(String value) {
        setAttribute("SraColor", value);
    }

    public void setSraComment(String value) {
        setAttribute("SraComment", value);
    }

    public void setSraExcludeYn(String value) {
        setAttribute("SraExcludeYn", value);
    }

    public void setSraId(Number value) {
        setAttribute("SraId", value);
    }

    public void setSraQstId(Number value) {
        setAttribute("SraQstId", value);
    }

    public void setSraRpsId(Number value) {
        setAttribute("SraRpsId", value);
    }

    public void setSraWeightMultiplier(Number value) {
        setAttribute("SraWeightMultiplier", value);
    }
}