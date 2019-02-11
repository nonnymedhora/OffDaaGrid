package com.bawaweb.views.updatable.common;

import oracle.jbo.Row;
import oracle.jbo.RowIterator;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---------------------------------------------------------------------
public interface RtypReportTypesUViewRow extends Row {
    RowIterator getRprtReportsUView();

    String getRtypDesc();

    Number getRtypDisplaySeq();

    Number getRtypId();

    Number getRtypInterviewDays();

    String getRtypLimitNumber();

    Number getRtypTallyDays();

    void setRtypDesc(String value);

    void setRtypDisplaySeq(Number value);

    void setRtypId(Number value);

    void setRtypInterviewDays(Number value);

    void setRtypLimitNumber(String value);

    void setRtypTallyDays(Number value);
}