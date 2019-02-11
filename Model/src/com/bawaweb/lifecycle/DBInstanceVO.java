/**
 * @author Nonny Medhora
 */
package com.bawaweb.lifecycle;

import com.bawaweb.views.DBInstanceImpl;
import com.bawaweb.views.common.DBInstanceRow;

import oracle.jbo.domain.Number;

import oracle.jbo.domain.Date;
public class DBInstanceVO {

    private Number instanceNumber;
    private String instanceName;
    private String hostName;
    private String version;
    private Date startupTime;
    private String status;
    private String parallel;
    private Number threadNumber;
    private String archiver;
    private String logSwitchWait;
    private String logins;
    private String shutdownPending;
    private String databaseStatus;
    private String instanceRole;
    private String activeState;
    private String blocked;
//    private String edition;
    
    
    public DBInstanceVO() {
    }
    
    public DBInstanceVO transform(DBInstanceRow row) {
        DBInstanceVO db = new DBInstanceVO();
        db.setInstanceNumber( row.getInstanceNumber() );
        db.setInstanceName( row.getInstanceName() );
        db.setHostName( row.getHostName() );
        db.setVersion( row.getVersion() );
        db.setStartupTime( row.getStartupTime() );
        db.setStatus( row.getStatus() );
        db.setParallel( row.getParallel() );
        db.setThreadNumber( row.getThread() );
        db.setArchiver( row.getArchiver() );
        db.setLogSwitchWait( row.getLogSwitchWait() );
        db.setLogins( row.getLogins() );
        db.setShutdownPending( row.getShutdownPending() );
        db.setDatabaseStatus( row.getDatabaseStatus() );
        db.setInstanceRole( row.getInstanceRole() );
        db.setActiveState( row.getActiveState() );
        db.setBlocked( row.getBlocked() );
//        db.setEdition( row.getEdition() );
        
        return db;
        
    }
    
    
    public DBInstanceRow transform(DBInstanceImpl view, DBInstanceVO db) {
        DBInstanceRow row = (DBInstanceRow) view.createRow();
        row.setInstanceNumber( db.getInstanceNumber() );
        row.setInstanceName( db.getInstanceName() );
        row.setHostName( db.getHostName() );
        row.setVersion( db.getVersion() );
        row.setStartupTime( db.getStartupTime() );
        row.setStatus( db.getStatus() );
        row.setParallel( db.getParallel() );
        row.setThread( db.getThreadNumber() );
        row.setArchiver( db.getArchiver() );
        row.setLogSwitchWait( db.getLogSwitchWait() );
        row.setLogins( db.getLogins() );
        row.setShutdownPending( db.getShutdownPending() );
        row.setDatabaseStatus( db.getDatabaseStatus() );
        row.setInstanceRole( db.getInstanceRole() );
        row.setActiveState( db.getActiveState() );
        row.setBlocked( db.getBlocked() );
//        row.setEdition( db.getEdition() );
        
        return row;
    }
    
    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append("instanceNumber --> " + this.instanceNumber + "\n");
        buf.append("instanceName --> " + this.instanceName + "\n");
        buf.append("hostName --> " + this.hostName + "\n");
        buf.append("version --> " + this.version + "\n");
        buf.append("startupTime --> " + this.startupTime + "\n");
        buf.append("status --> " + this.status + "\n");
        buf.append("parallel --> " + this.parallel + "\n");
        buf.append("threadNumber --> " + this.threadNumber + "\n");
        buf.append("logswitchWait --> " + this.logSwitchWait + "\n");
        buf.append("archiver --> " + this.archiver + "\n");
        buf.append("logins --> " + this.logins + "\n");
        buf.append("shutdownPending --> " + this.shutdownPending + "\n");
        buf.append("databaseStatus --> " + this.databaseStatus + "\n");
        buf.append("instanceRole --> " + this.instanceRole + "\n");
        buf.append("activeState --> " + this.activeState + "\n");
        buf.append("blocked --> " + this.blocked + "\n");
//        buf.append("edition --> " + this.edition + "\n");
        return buf.toString();
    }

    
    public Object getAttribute(String attribute) {
        if ( attribute.equalsIgnoreCase("instanceNumber") ) return instanceNumber;
        if ( attribute.equalsIgnoreCase("instanceName") ) return instanceName;
        if ( attribute.equalsIgnoreCase("hostName") ) return hostName;
        if ( attribute.equalsIgnoreCase("version") ) return version;
        if ( attribute.equalsIgnoreCase("startupTime") ) return startupTime;
        if ( attribute.equalsIgnoreCase("status") ) return status;
        if ( attribute.equalsIgnoreCase("parallel") ) return parallel;
        if ( attribute.equalsIgnoreCase("threadNumber") ) return threadNumber;
        if ( attribute.equalsIgnoreCase("logswitchWait") ) return logSwitchWait;
        if ( attribute.equalsIgnoreCase("archiver") ) return archiver;
        if ( attribute.equalsIgnoreCase("logins") ) return logins;
        if ( attribute.equalsIgnoreCase("shutdownPending") ) return shutdownPending;
        if ( attribute.equalsIgnoreCase("databaseStatus") ) return databaseStatus;
        if ( attribute.equalsIgnoreCase("instanceRole") ) return instanceRole;
        if ( attribute.equalsIgnoreCase("activeState") ) return activeState;
        if ( attribute.equalsIgnoreCase("blocked") ) return blocked;
//        if ( attribute.equalsIgnoreCase("edition") ) return edition;
        return null;
    }

    public void setInstanceNumber(Number instanceNumber) {
        this.instanceNumber = instanceNumber;
    }

    public Number getInstanceNumber() {
        return instanceNumber;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getHostName() {
        return hostName;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setStartupTime(Date startupTime) {
        this.startupTime = startupTime;
    }

    public Date getStartupTime() {
        return startupTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setParallel(String parallel) {
        this.parallel = parallel;
    }

    public String getParallel() {
        return parallel;
    }

    public void setThreadNumber(Number thread) {
        this.threadNumber = thread;
    }

    public Number getThreadNumber() {
        return threadNumber;
    }

    public void setArchiver(String archiver) {
        this.archiver = archiver;
    }

    public String getArchiver() {
        return archiver;
    }

    public void setLogSwitchWait(String logswitchWait) {
        this.logSwitchWait = logswitchWait;
    }

    public String getLogSwitchWait() {
        return logSwitchWait;
    }

    public void setLogins(String logins) {
        this.logins = logins;
    }

    public String getLogins() {
        return logins;
    }

    public void setShutdownPending(String shutdownPending) {
        this.shutdownPending = shutdownPending;
    }

    public String getShutdownPending() {
        return shutdownPending;
    }

    public void setDatabaseStatus(String databaseStatus) {
        this.databaseStatus = databaseStatus;
    }

    public String getDatabaseStatus() {
        return databaseStatus;
    }

    public void setInstanceRole(String instanceRole) {
        this.instanceRole = instanceRole;
    }

    public String getInstanceRole() {
        return instanceRole;
    }

    public void setActiveState(String activeState) {
        this.activeState = activeState;
    }

    public String getActiveState() {
        return activeState;
    }

    public void setBlocked(String blocked) {
        this.blocked = blocked;
    }

    public String getBlocked() {
        return blocked;
    }

//    public void setEdition(String edition) {
//        this.edition = edition;
//    }
//
//    public String getEdition() {
//        return edition;
//    }
}
