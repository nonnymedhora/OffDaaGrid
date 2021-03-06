package com.bawaweb.views.gridcursors.common;

import oracle.jbo.Row;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---------------------------------------------------------------------
public interface SourcesAnswerSetsRow extends Row {
    String getAnswer();

    String getQstType();

    Number getRavId();

    String getSraAnswerText();

    String getSraColor();

    String getSraComment();

    Number getSraId();

    Number getSraQstId();

    Number getSraRpsId();

    void setAnswer(String value);

    void setQstType(String value);

    void setRavId(Number value);

    void setSraAnswerText(String value);

    void setSraColor(String value);

    void setSraComment(String value);

    void setSraId(Number value);

    void setSraQstId(Number value);

    void setSraRpsId(Number value);

    Number getRavAsvId();

    void setRavAsvId(Number value);

    String getRavDeleteYn();

    Number getRavDisplaySeq();

    String getSraExcludeYn();

    void setRavDeleteYn(String value);

    void setRavDisplaySeq(Number value);

    void setSraExcludeYn(String value);

    Number getSraWeightMultiplier();

    void setSraWeightMultiplier(Number value);
}
