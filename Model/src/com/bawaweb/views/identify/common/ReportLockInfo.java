package com.bawaweb.views.identify.common;

import oracle.jbo.ViewObject;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---------------------------------------------------------------------
public interface ReportLockInfo extends ViewObject {
    long getEstimatedRowCount();

    Number gettab_id();

    String gettab_name();

    void settab_id(Number value);

    void settab_name(String value);
}