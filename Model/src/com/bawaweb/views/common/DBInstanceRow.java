package com.bawaweb.views.common;

import oracle.jbo.Row;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---------------------------------------------------------------------
public interface DBInstanceRow extends Row {
    Number getInstanceNumber();

    void setInstanceNumber(Number value);

    String getInstanceName();

    void setInstanceName(String value);

    String getHostName();

    void setHostName(String value);

    String getVersion();

    void setVersion(String value);

    Date getStartupTime();

    void setStartupTime(Date value);

    String getStatus();

    void setStatus(String value);

    String getParallel();

    void setParallel(String value);

    Number getThread();

    void setThread(Number value);

    String getArchiver();

    void setArchiver(String value);

    String getLogSwitchWait();

    void setLogSwitchWait(String value);

    String getLogins();

    void setLogins(String value);

    String getShutdownPending();

    void setShutdownPending(String value);

    String getDatabaseStatus();

    void setDatabaseStatus(String value);

    String getInstanceRole();

    void setInstanceRole(String value);

    String getActiveState();

    void setActiveState(String value);

    String getBlocked();

    void setBlocked(String value);


}
