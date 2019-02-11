package com.bawaweb.views.gridcursors.common;

import oracle.jbo.Row;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---------------------------------------------------------------------
public interface ReportGeneralInfoRow extends Row {
    Number getEdtrId();

    String getRprtDesc();

    Date getRprtDuedate();

    Number getRprtId();

    String getRprtSourceDisplayField();

    String getRtypDesc();

    Number getRtypId();

    void setEdtrId(Number value);

    void setRprtDesc(String value);

    void setRprtDuedate(Date value);

    void setRprtId(Number value);

    void setRprtSourceDisplayField(String value);

    void setRtypDesc(String value);

    void setRtypId(Number value);
}
