/**
 * @author Nonny Medhora
 */
package com.bawaweb.lifecycle;

import com.bawaweb.grid.templates.data.cursors.SourceAnswersDataSet;
import com.bawaweb.grid.templates.data.cursors.SourceAnswersDataSetInfo;
import com.bawaweb.views.gridcursors.common.SourcesSortingCriteriaSets;
import com.bawaweb.views.gridcursors.common.SourcesSortingCriteriaSetsRow;

import com.bawaweb.views.model.common.SourceSortingCriteria;
import com.bawaweb.views.model.common.SourceSortingCriteriaRow;

import java.sql.SQLException;

import oracle.jbo.ApplicationModule;
import oracle.jbo.domain.Number;
import oracle.jbo.domain.Sequence;

public class SourcesSortingCriteriaSetInfoVO {

    private Number scvId;
    private Number sscRpsId;
    private String scvName;
    private Number qstId;
    
    public SourcesSortingCriteriaSetInfoVO() {
    }
    
    
    public Object getAttribute(String attribute) {        
        if ( attribute.equalsIgnoreCase( "sscRpsId") ) return sscRpsId;
        if ( attribute.equalsIgnoreCase( "scvName") ) return scvName;
        if ( attribute.equalsIgnoreCase( "scvId") ) return scvId;
        if ( attribute.equalsIgnoreCase( "qstId") ) return qstId;  
        return null;        
    }
    
    public SourcesSortingCriteriaSetInfoVO transform(SourcesSortingCriteriaSetsRow row) {
        SourcesSortingCriteriaSetInfoVO sscinfo = new SourcesSortingCriteriaSetInfoVO();
        sscinfo.setScvId( row.getScvId() );
        sscinfo.setSscRpsId( row.getSscRpsId() );
        sscinfo.setScvName( row.getScvName() );
        sscinfo.setQstId( row.getQstId() );
        return sscinfo;
    }
    
    public SourcesSortingCriteriaSetInfoVO transform(SourceSortingCriteriaRow row) {
        SourcesSortingCriteriaSetInfoVO sscinfo = new SourcesSortingCriteriaSetInfoVO();
        sscinfo.setScvId( row.getSscScvId() );
        sscinfo.setSscRpsId( row.getSscRpsId() );
        return sscinfo;
    }
    
    public SourcesSortingCriteriaSetsRow transform(SourcesSortingCriteriaSets view, SourcesSortingCriteriaSetInfoVO sscInfo, ApplicationModule appModule) {
        if ( sscInfo == null )  { System.out.println("sscInfo is null");   return null; }
        SourcesSortingCriteriaSetsRow row = (SourcesSortingCriteriaSetsRow) view.createRow();
        if ( sscInfo.getScvId() != null && sscInfo.getScvId().intValue() != 0 ) {
            row.setScvId( sscInfo.getScvId() );
        } else {
            Sequence sscSeq = new Sequence("BAwaWEb_SCV_SEQ", appModule);
            try {
                row.setScvId( new Number( sscSeq.getData().toString() ) );
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        row.setSscRpsId( sscInfo.getSscRpsId() );
        row.setScvName( sscInfo.getScvName() );
        row.setQstId( sscInfo.getQstId() );
        
        return row;
    }
    
    public SourceSortingCriteriaRow transform(SourceSortingCriteria view, SourcesSortingCriteriaSetInfoVO sscInfo, ApplicationModule appModule) {
        if ( sscInfo == null )  { System.out.println("sscInfo is null");   return null; }
        SourceSortingCriteriaRow row =  (SourceSortingCriteriaRow) view.createRow();
        if ( sscInfo.getScvId() != null && sscInfo.getScvId().intValue() != 0 ) {
            row.setSscScvId( sscInfo.getScvId() );
        } else {
            Sequence sscSeq = new Sequence("BAwaWEb_SCV_SEQ", appModule);
            try {
                row.setSscScvId( new Number( sscSeq.getData().toString() ) );
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        row.setSscRpsId( sscInfo.getSscRpsId() );
        return row;
    }
    
    public SourceAnswersDataSetInfo transform(SourcesSortingCriteriaSetInfoVO sscInfo) {
        SourceAnswersDataSetInfo sAns = new SourceAnswersDataSet();   
        sAns.setScv_Id( sscInfo.getScvId().intValue() );
        if ( sscInfo.getSscRpsId() != null ) sAns.setRps_id( sscInfo.getSscRpsId().intValue() );
        sAns.setScv_name( sscInfo.getScvName() );        
        return sAns;
    }
    
    public SourcesSortingCriteriaSetInfoVO transform(SourceAnswersDataSetInfo sAns) {
        SourcesSortingCriteriaSetInfoVO sscInfo = new SourcesSortingCriteriaSetInfoVO();
        sscInfo.setScvId( new Number ( sAns.getScv_Id() ));
        sscInfo.setSscRpsId( new Number( sAns.getRps_id() ) );
        sscInfo.setScvName( sAns.getScv_name() );
        
        return sscInfo;
    }

    public static void main(String[] args) {
        SourcesSortingCriteriaSetInfoVO sourcesSortingCriteriaSetInfo = new SourcesSortingCriteriaSetInfoVO();
    }

    public void setSscRpsId(Number sscRpsId) {
        this.sscRpsId = sscRpsId;
    }

    public Number getSscRpsId() {
        return sscRpsId;
    }

    public void setScvName(String scvName) {
        this.scvName = scvName;
    }

    public String getScvName() {
        return scvName;
    }

    public void setScvId(Number scvId) {
        this.scvId = scvId;
    }

    public Number getScvId() {
        return scvId;
    }

    public void setQstId(Number qstId) {
        this.qstId = qstId;
    }

    public Number getQstId() {
        return qstId;
    }
}
