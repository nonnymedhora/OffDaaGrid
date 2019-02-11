package com.bawaweb.views.readable.common;

import oracle.jbo.Row;
import oracle.jbo.RowIterator;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---------------------------------------------------------------------
public interface FridFirmIndustriesRViewRow extends Row {
    RowIterator getOtlAnswerSetsRView();

    RowIterator getOtlReportAnswerSetsRView();

    RowIterator getOtlSortingCriteriaRView();

    RowIterator getPanPanelRView();

    RowIterator getRprtReportsRView();

    String getFridDescription();

    Number getFridId();

    String getFridPropCapacity();

    void setFridDescription(String value);

    void setFridId(Number value);

    void setFridPropCapacity(String value);
}
