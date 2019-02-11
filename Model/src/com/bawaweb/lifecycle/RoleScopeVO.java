/**
 * @author Nonny Medhora
 */
package com.bawaweb.lifecycle;

import com.bawaweb.views.gridcursors.common.RoleScope;
import com.bawaweb.views.gridcursors.common.RoleScopeRow;

import oracle.jbo.domain.Number;

public class RoleScopeVO {

    private int emplId;

    public RoleScopeVO() {
    }
    
    public Object getAttribute(String attribute) { 
        if ( attribute.equalsIgnoreCase("emplId")) return emplId;        
        return null;
    }
    
    
    
    public RoleScopeVO transform(RoleScopeRow row) {
        RoleScopeVO roleInfo = new RoleScopeVO();
        roleInfo.setEmplId( row.getEmrEmplId().intValue());
        return roleInfo;
    }
    
    public RoleScopeRow transform(RoleScope view, RoleScopeVO roleInfo) {
        RoleScopeRow row = (RoleScopeRow) view.createRow();
        row.setEmrEmplId( new Number(roleInfo.getEmplId()));
        
        return row;
    }

    public void setEmplId(int emplId) {
        this.emplId = emplId;
    }

    public int getEmplId() {
        return emplId;
    }
}
