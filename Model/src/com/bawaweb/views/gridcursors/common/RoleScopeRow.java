package com.bawaweb.views.gridcursors.common;

import oracle.jbo.Row;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---------------------------------------------------------------------
public interface RoleScopeRow extends Row {
    String getY();

    void setY(String value);

    Number getEmrEmplId();

    Number getEmrRolId();

    Number getRolDisplayOrder();

    Number getRolId();

    String getRolName();

    String getRolRprtIndYn();

    String getRolSrcIndYn();

    String getRolSrcRprtYn();

    void setEmrEmplId(Number value);

    void setEmrRolId(Number value);

    void setRolDisplayOrder(Number value);

    void setRolId(Number value);

    void setRolName(String value);

    void setRolRprtIndYn(String value);

    void setRolSrcIndYn(String value);

    void setRolSrcRprtYn(String value);
}