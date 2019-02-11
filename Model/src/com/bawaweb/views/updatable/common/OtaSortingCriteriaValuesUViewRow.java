package com.bawaweb.views.updatable.common;

import oracle.jbo.Row;
import oracle.jbo.RowIterator;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---------------------------------------------------------------------
public interface OtlSortingCriteriaValuesUViewRow extends Row {
    Row getOtlSortingCriteriaValuesUView();

    RowIterator getOtlSourceSortingCriteriaUView();

    String getScvDataLevelYn();

    String getScvDeleteYn();

    Number getScvDisplaySeq();

    Number getScvId();

    String getScvName();

    Number getScvScvId();

    Number getScvSrtId();

    void setScvDataLevelYn(String value);

    void setScvDeleteYn(String value);

    void setScvDisplaySeq(Number value);

    void setScvId(Number value);

    void setScvName(String value);

    void setScvScvId(Number value);

    void setScvSrtId(Number value);
}