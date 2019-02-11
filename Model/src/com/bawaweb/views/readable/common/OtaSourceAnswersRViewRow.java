package com.bawaweb.views.readable.common;

import oracle.jbo.Row;
import oracle.jbo.RowIterator;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---------------------------------------------------------------------
public interface OtlSourceAnswersRViewRow extends Row {
    RowIterator getOtlSourceMultiAnswersRView();

    String getSraAnswer();

    String getSraAnswerText();

    Number getSraAsvId();

    String getSraColor();

    String getSraComment();

    String getSraExcludeYn();

    Number getSraId();

    Number getSraQstId();

    Number getSraRavId();

    Number getSraRpsId();

    Number getSraWeightMultiplier();

    void setSraAnswer(String value);

    void setSraAnswerText(String value);

    void setSraAsvId(Number value);

    void setSraColor(String value);

    void setSraComment(String value);

    void setSraExcludeYn(String value);

    void setSraId(Number value);

    void setSraQstId(Number value);

    void setSraRavId(Number value);

    void setSraRpsId(Number value);

    void setSraWeightMultiplier(Number value);
}
