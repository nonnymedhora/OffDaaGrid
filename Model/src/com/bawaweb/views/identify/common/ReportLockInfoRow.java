package com.bawaweb.views.identify.common;

import oracle.jbo.Row;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---------------------------------------------------------------------
public interface ReportLockInfoRow extends Row {
    Number getOtlId();

    void setOtlId(Number value);

    String getOtlTabName();

    void setOtlTabName(String value);

    Number getOtlTabId();

    void setOtlTabId(Number value);

    String getOtlEmplId();

    void setOtlEmplId(String value);

    Date getOtlCreatedDt();

    void setOtlCreatedDt(Date value);

    String getOtlStatus();

    void setOtlStatus(String value);
}
