/**
 * @author Nonny Medhora
 */
package com.bawaweb.lifecycle.model;

import com.bawaweb.grid.templates.data.tables.ReporterSourcesDataSet;
import com.bawaweb.grid.templates.data.tables.ReporterSourcesDataSetInfo;
import com.bawaweb.views.model.common.ReporterSources;
import com.bawaweb.views.model.common.ReporterSourcesRow;

import oracle.jbo.domain.Number;

public class ReporterSourcesVO {
    private Number rscSrcId;
    private Number rscEmplId;
    private String rscDeleteYn;
    
    
    public ReporterSourcesVO() {
    }
    
    public Object getAttribute(String attribute) {
        if ( attribute.equalsIgnoreCase("rscSrcId")) return rscSrcId;
        if ( attribute.equalsIgnoreCase("rscRmplId")) return rscEmplId;
        if ( attribute.equalsIgnoreCase("rscDeleteYn")) return rscDeleteYn;
        
        return null;
    }
    
    public ReporterSourcesVO transform(ReporterSourcesDataSetInfo rpsInfo) {
        ReporterSourcesVO rps = new ReporterSourcesVO();
        rps.setRscSrcId( new Number( rpsInfo.getRsc_src_id() ) );
        rps.setRscEmplId( new Number( rpsInfo.getRsc_empl_id() ) );
        rps.setRscDeleteYn( rpsInfo.getRsc_delete_yn() );
        return rps;
    }
    
    public ReporterSourcesDataSetInfo transform(ReporterSourcesVO inf) {
        ReporterSourcesDataSetInfo rps = new ReporterSourcesDataSet();
        if ( inf.getRscSrcId() != null ) rps.setRsc_src_id( inf.getRscSrcId().intValue() );
        if ( inf.getRscEmplId() != null ) rps.setRsc_empl_id( inf.getRscEmplId().intValue() );
        rps.setRsc_delete_yn( inf.getRscDeleteYn() );
        return rps;
    }
    
    public ReporterSourcesVO transform(ReporterSourcesRow row) {
        ReporterSourcesVO rps = new ReporterSourcesVO();
        rps.setRscSrcId( row.getRscSrcId() );
        rps.setRscEmplId( row.getRscEmplId() );
        rps.setRscDeleteYn( row.getRscDeleteYn() );
        return rps;
    }
    
    public ReporterSourcesRow transform( ReporterSources view, ReporterSourcesVO rps) {
        ReporterSourcesRow row = (ReporterSourcesRow) view.createRow();
System.out.println(" rps.getRscEmplId()  is " +  rps.getRscEmplId() + " and rps.getRscSrcId() is " + rps.getRscSrcId() + " and rps.getRscDeleteYn() is " + rps.getRscDeleteYn() );        
        if ( rps.getRscSrcId() != null ) row.setRscSrcId( rps.getRscSrcId() );
        if ( rps.getRscEmplId() != null ) row.setRscEmplId( rps.getRscEmplId() );
        if ( rps.getRscDeleteYn() != null ) row.setRscDeleteYn( rps.getRscDeleteYn() );
        
        return row;
    }

    public static void main(String[] args) {
        ReporterSourcesVO ReporterSourcesVO = new ReporterSourcesVO();
    }

    public void setRscSrcId(Number rscSrcId) {
        this.rscSrcId = rscSrcId;
    }

    public Number getRscSrcId() {
        return rscSrcId;
    }

    public void setRscEmplId(Number rscRmplId) {
        this.rscEmplId = rscRmplId;
    }

    public Number getRscEmplId() {
        return rscEmplId;
    }

    public void setRscDeleteYn(String rscDeleteYn) {
        this.rscDeleteYn = rscDeleteYn;
    }

    public String getRscDeleteYn() {
        return rscDeleteYn;
    }
    
    public String toString() {
        StringBuffer buff = new StringBuffer("\nReporterSourcesVO\n");
        buff.append( "rscSrcId |" + rscSrcId + "|\n");
        buff.append( "rscEmplId |" + rscEmplId + "|\n");
        buff.append( "rscDeleteYn |" + rscDeleteYn + "|\n");
        return buff.toString();
    }
}
