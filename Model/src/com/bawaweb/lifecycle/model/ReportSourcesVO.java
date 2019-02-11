/**
 * @author Nonny Medhora
 */
package com.bawaweb.lifecycle.model;

import com.bawaweb.grid.templates.data.tables.ReportSourcesDataSet;
import com.bawaweb.grid.templates.data.tables.ReportSourcesDataSetInfo;
import com.bawaweb.views.model.common.ReportSources;
import com.bawaweb.views.model.common.ReportSourcesRow;

import oracle.jbo.domain.Number;

public class ReportSourcesVO {
    private Number rpsId;
    private Number rpsSrcId;
    private Number rpsRprtId;
    private Number rpsRprtrId;
    private String rpsCompedYn;
    private String rpsRepeatSourceYn;
    private String rpsDeleteYn;
    
    
    public ReportSourcesVO() {
    }
    
    public Object getAttribute(String attribute) {
        if ( attribute.equalsIgnoreCase("rpsId")) return rpsId;
        if ( attribute.equalsIgnoreCase("rpsSrcId")) return rpsSrcId;
        if ( attribute.equalsIgnoreCase("rpsRprtId")) return rpsRprtId;
        if ( attribute.equalsIgnoreCase("rpsRprtrId")) return rpsRprtrId;
        if ( attribute.equalsIgnoreCase("rpsCompedYn")) return rpsCompedYn;
        if ( attribute.equalsIgnoreCase("rpsRepeatSourceYn")) return rpsRepeatSourceYn;
        if ( attribute.equalsIgnoreCase("rpsDeleteYn")) return rpsDeleteYn;
        
        return null;
    }
    
    public ReportSourcesVO transform(ReportSourcesDataSetInfo rpsInfo) {
        ReportSourcesVO rps = new ReportSourcesVO();
        rps.setRpsId( new Number( rpsInfo.getRps_id() ) );
        rps.setRpsSrcId( new Number( rpsInfo.getRps_src_id() ) );
        rps.setRpsRprtId( new Number( rpsInfo.getRps_rprt_id() ) );
        rps.setRpsRprtrId( new Number( rpsInfo.getRps_rptr_id() ) );
        rps.setRpsCompedYn( rpsInfo.getRps_comped_yn() );
        rps.setRpsRepeatSourceYn( rpsInfo.getRps_repeat_source_yn() );
        rps.setRpsDeleteYn( rpsInfo.getRps_delete_yn() );
        return rps;
    }
    
    public ReportSourcesDataSetInfo transform(ReportSourcesVO inf) {
        ReportSourcesDataSetInfo rps = new ReportSourcesDataSet();
        if ( inf.getRpsId() != null ) rps.setRps_id( inf.getRpsId().intValue() );
        if ( inf.getRpsSrcId() != null ) rps.setRps_src_id( inf.getRpsSrcId().intValue() );
        if ( inf.getRpsRprtId() != null ) rps.setRps_rprt_id( inf.getRpsRprtId().intValue() );
        if ( inf.getRpsRprtrId() != null ) rps.setRps_rptr_id( inf.getRpsRprtrId().intValue() );
        rps.setRps_comped_yn( inf.getRpsCompedYn() );
        rps.setRps_repeat_source_yn( inf.getRpsRepeatSourceYn() );
        rps.setRps_delete_yn( inf.getRpsDeleteYn() );
        return rps;
    }
    
    public ReportSourcesVO transform(ReportSourcesRow row) {
        ReportSourcesVO rps = new ReportSourcesVO();
        rps.setRpsId( row.getRpsId() );
        rps.setRpsSrcId( row.getRpsSrcId() );
        rps.setRpsRprtId( row.getRpsRprtId() );
        rps.setRpsRprtrId( row.getRpsRptrId() );
        rps.setRpsCompedYn( row.getRpsCompedYn() );
        rps.setRpsRepeatSourceYn( row.getRpsRepeatSourceYn() );
        rps.setRpsDeleteYn( row.getRpsDeleteYn() );
        return rps;
    }
    
    public ReportSourcesRow transform( ReportSources view, ReportSourcesVO rps) {
        ReportSourcesRow row = (ReportSourcesRow) view.createRow();
System.out.println("getRpsId " + rps.getRpsId() );
        if ( rps.getRpsId() != null ) row.setRpsId( rps.getRpsId() );
System.out.println("getRpsSrcId " + rps.getRpsSrcId() );        
        if ( rps.getRpsSrcId() != null ) row.setRpsSrcId( rps.getRpsSrcId() );
System.out.println("getRpsRprtId " + rps.getRpsRprtId() );        
        if ( rps.getRpsRprtId() != null ) row.setRpsRprtId( rps.getRpsRprtId() );
System.out.println("getRpsRprtrId " + rps.getRpsRprtrId() );        
        if ( rps.getRpsRprtrId() != null ) row.setRpsRptrId( rps.getRpsRprtrId() );
System.out.println("getRpsCompedYn " + rps.getRpsCompedYn() );        
        row.setRpsCompedYn( rps.getRpsCompedYn() );
System.out.println("getRpsRepeatSourceYn " + rps.getRpsRepeatSourceYn() );        
        row.setRpsRepeatSourceYn( rps.getRpsRepeatSourceYn() );
System.out.println("getRpsDeleteYn " + rps.getRpsDeleteYn() );        
        row.setRpsDeleteYn( rps.getRpsDeleteYn() );
        
        return row;
    }

    public static void main(String[] args) {
        ReportSourcesVO reportSourcesVO = new ReportSourcesVO();
    }

    public void setRpsId(Number rpsId) {
        this.rpsId = rpsId;
    }

    public Number getRpsId() {
        return rpsId;
    }

    public void setRpsSrcId(Number rpsSrcId) {
        this.rpsSrcId = rpsSrcId;
    }

    public Number getRpsSrcId() {
        return rpsSrcId;
    }

    public void setRpsRprtId(Number rpsRprtId) {
        this.rpsRprtId = rpsRprtId;
    }

    public Number getRpsRprtId() {
        return rpsRprtId;
    }

    public void setRpsRprtrId(Number rprRprtrId) {
        this.rpsRprtrId = rprRprtrId;
    }

    public Number getRpsRprtrId() {
        return rpsRprtrId;
    }

    public void setRpsCompedYn(String rprCompedYn) {
        this.rpsCompedYn = rprCompedYn;
    }

    public String getRpsCompedYn() {
        return rpsCompedYn;
    }

    public void setRpsRepeatSourceYn(String rpsRepeatSourceYn) {
        this.rpsRepeatSourceYn = rpsRepeatSourceYn;
    }

    public String getRpsRepeatSourceYn() {
        return rpsRepeatSourceYn;
    }

    public void setRpsDeleteYn(String rpsDeleteYn) {
        this.rpsDeleteYn = rpsDeleteYn;
    }

    public String getRpsDeleteYn() {
        return rpsDeleteYn;
    }
}
