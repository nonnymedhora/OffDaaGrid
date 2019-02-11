package com.bawaweb.views.updatable.common;

import oracle.jbo.Row;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---------------------------------------------------------------------
public interface OtlSourceMultiAnswersUViewRow extends Row {
    String getSmaAnswer();

    Number getSmaAsvId();

    String getSmaExcludeYn();

    Number getSmaQmqId();

    Number getSmaRavId();

    Number getSmaSraId();

    Number getSmaWeightMultiplier();

    void setSmaAnswer(String value);

    void setSmaAsvId(Number value);

    void setSmaExcludeYn(String value);

    void setSmaQmqId(Number value);

    void setSmaRavId(Number value);

    void setSmaSraId(Number value);

    void setSmaWeightMultiplier(Number value);
}
