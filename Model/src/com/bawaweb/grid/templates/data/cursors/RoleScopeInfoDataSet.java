/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.cursors;

public class RoleScopeInfoDataSet implements RoleScopeInfo {
    public RoleScopeInfoDataSet() {
    }
    
    private int emplId;
    
    
    public int getEmplId() {
        return this.emplId;
    }
    
    public void setEmplId(int id) {
        this.emplId = id;
    }
    
    public boolean getIsInRole(int id) {
        return false;    
    }
    
}
