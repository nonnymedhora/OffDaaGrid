package com.bawaweb.views.updatable.common;

import oracle.jbo.Row;
import oracle.jbo.domain.Number;
import oracle.jbo.domain.RowID;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---------------------------------------------------------------------
public interface RprtReportReporterXrefUViewRow extends Row {
    String getDistributionNotes();

    RowID getRowID();

    Number getRprtId();

    Number getRptrId();

    Number getRptyId();

    void setDistributionNotes(String value);

    void setRprtId(Number value);

    void setRptrId(Number value);

    void setRptyId(Number value);
}