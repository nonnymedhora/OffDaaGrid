package com.bawaweb.views.updatable.common;

import oracle.jbo.Row;
import oracle.jbo.RowIterator;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---------------------------------------------------------------------
public interface OtlReportAnswerSetValuesUViewRow extends Row {
    RowIterator getOtlSourceAnswersUView();

    RowIterator getOtlSourceMultiAnswersUView();

    String getRavAnswer();

    Number getRavAsvId();

    String getRavDeleteYn();

    Number getRavDisplaySeq();

    Number getRavId();

    Number getRavRasId();

    void setRavAnswer(String value);

    void setRavAsvId(Number value);

    void setRavDeleteYn(String value);

    void setRavDisplaySeq(Number value);

    void setRavId(Number value);

    void setRavRasId(Number value);
}