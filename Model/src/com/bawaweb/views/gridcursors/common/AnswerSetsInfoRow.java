package com.bawaweb.views.gridcursors.common;

import oracle.jbo.Row;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---------------------------------------------------------------------
public interface AnswerSetsInfoRow extends Row {
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
