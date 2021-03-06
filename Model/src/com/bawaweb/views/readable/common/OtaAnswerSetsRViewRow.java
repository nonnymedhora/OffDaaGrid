package com.bawaweb.views.readable.common;

import oracle.jbo.Row;
import oracle.jbo.RowIterator;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---------------------------------------------------------------------
public interface OtlAnswerSetsRViewRow extends Row {
    RowIterator getOtlAnswerSetValuesRView();

    RowIterator getOtlReportAnswerSetsRView();

    String getAnsAddAnswerYn();

    String getAnsDeleteYn();

    Number getAnsFridId();

    Number getAnsId();

    String getAnsName();

    String getAnsOrderByNameYn();

    void setAnsAddAnswerYn(String value);

    void setAnsDeleteYn(String value);

    void setAnsFridId(Number value);

    void setAnsId(Number value);

    void setAnsName(String value);

    void setAnsOrderByNameYn(String value);
}
