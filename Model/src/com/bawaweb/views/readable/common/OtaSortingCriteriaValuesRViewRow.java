package com.bawaweb.views.readable.common;

import oracle.jbo.Row;
import oracle.jbo.RowIterator;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---------------------------------------------------------------------
public interface OtlSortingCriteriaValuesRViewRow extends Row {
    RowIterator getOtlSourceSortingCriteriaRView();

    RowIterator getScvIdOtlSortingCriteriaValuesRView();

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
