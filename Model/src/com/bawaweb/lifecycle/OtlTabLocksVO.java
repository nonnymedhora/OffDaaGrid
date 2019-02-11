/**
 * @author Nonny Medhora
 */
package com.bawaweb.lifecycle;

import com.bawaweb.views.gridcursors.common.TableLocksInfo;
import com.bawaweb.views.gridcursors.common.TableLocksInfoRow;

import java.sql.SQLException;

import oracle.jbo.domain.Number;
import oracle.jbo.domain.Date;
import java.sql.Timestamp;

import oracle.jbo.ApplicationModule;
import oracle.jbo.domain.Sequence;

public class OtlTabLocksVO {

    private Number otlId;
    private String otlTabName;
    private Number otlTabId;
    private String otlEmplId;
    private Date otlCreatedDt;
    private String otlStatus;


    public OtlTabLocksVO() {
    }
    
    public Object getAttribute(String attribute) {
        if ( attribute.equalsIgnoreCase("otlId") ) return otlId;
        if ( attribute.equalsIgnoreCase("otlTabName") ) return otlTabName;
        if ( attribute.equalsIgnoreCase("otlTabId") ) return otlTabId;
        if ( attribute.equalsIgnoreCase("otlEmplId") ) return otlEmplId;
        if ( attribute.equalsIgnoreCase("otlCreatedDt") ) return otlCreatedDt;
        if ( attribute.equalsIgnoreCase("otlStatus") ) return otlStatus;
        
        return null;
    }
    
    public OtlTabLocksVO transform(TableLocksInfoRow row) {
        OtlTabLocksVO lockInfo = new OtlTabLocksVO();
        if ( row.getOtlId() != null ) lockInfo.setOtlId( row.getOtlId() );
        lockInfo.setOtlTabName( row.getOtlTabName() );
        lockInfo.setOtlTabId( row.getOtlTabId() );
        lockInfo.setOtlEmplId( row.getOtlEmplId() );
        lockInfo.setOtlCreatedDt( row.getOtlCreatedDt() );
        lockInfo.setOtlStatus( row.getOtlStatus() );
        return lockInfo;
    }
    
    public TableLocksInfoRow transform(TableLocksInfo view, OtlTabLocksVO lockInfo, ApplicationModule module) {
        TableLocksInfoRow row = (TableLocksInfoRow) view.createRow();
//System.out.println("lockInfo.getOtlId() is " + lockInfo.getOtlId());        
        if ( lockInfo.getOtlId() != null ) {
            row.setOtlId( lockInfo.getOtlId() );
        } else {
            Sequence seq = new Sequence("BAwaWEb_SEQ", module);
            try {          
                row.setOtlId( new Number( seq.getData().toString() ) );
            } catch (SQLException e) {
               e.printStackTrace();
            }
        }
        
        row.setOtlTabName( lockInfo.getOtlTabName() );
        row.setOtlTabId( lockInfo.getOtlTabId() );
        row.setOtlEmplId( lockInfo.getOtlEmplId() );
        row.setOtlCreatedDt( lockInfo.getOtlCreatedDt() );
        row.setOtlStatus( lockInfo.getOtlStatus() );
        return row;
    }

    public static void main(String[] args) {
        OtlTabLocksVO otrTabLocksVO = new OtlTabLocksVO();
    }

    public void setOtlId(Number otlId) {
        this.otlId = otlId;
    }

    public Number getOtlId() {
        return otlId;
    }

    public void setOtlTabName(String otlTabName) {
        this.otlTabName = otlTabName;
    }

    public String getOtlTabName() {
        return otlTabName;
    }

    public void setOtlTabId(Number otlTabId) {
        this.otlTabId = otlTabId;
    }

    public Number getOtlTabId() {
        return otlTabId;
    }

    public void setOtlEmplId(String otlEmplId) {
        this.otlEmplId = otlEmplId;
    }

    public String getOtlEmplId() {
        return otlEmplId;
    }

    public void setOtlCreatedDt(Date otlCreatedDt) {
        this.otlCreatedDt = otlCreatedDt;
    }

    public Date getOtlCreatedDt() {
        return otlCreatedDt;
    }

    public void setOtlStatus(String otlStatus) {
        this.otlStatus = otlStatus;
    }

    public String getOtlStatus() {
        return otlStatus;
    }
    
    public String toString() {
        StringBuffer buff = new StringBuffer();
        buff.append("otlId -> " + this.otlId + "\n");
        buff.append("otlTabName -> " + this.otlTabName + "\n");
        buff.append("otlTabId -> " + this.otlTabId + "\n");
        buff.append("otlEmplId -> " + this.otlEmplId + "\n");
        buff.append("otlCreatedDt -> " + this.otlCreatedDt + "\n");
        buff.append("otlStatus -> " + this.otlStatus + "\n");
        return buff.toString();
    }
}
