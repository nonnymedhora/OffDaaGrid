/**
 * @author Nonny Medhora
 */
package com.bawaweb.lifecycle;

import com.bawaweb.grid.templates.data.tables.SortingCriteriaValuesDataSet;
import com.bawaweb.grid.templates.data.tables.SortingCriteriaValuesDataSetInfo;
import com.bawaweb.views.gridcursors.common.SortCriteriaSets;
import com.bawaweb.views.gridcursors.common.SortCriteriaSetsRow;

import oracle.jbo.domain.Number;

public class SortCriteriaInfoVO {

    private Number scvId;
    private Number scvSrtId;
    private Number scvScvId;
    private Number scvDisplaySeq;
    private String scvName;
    private String scvDataLevelYn;
    private String scvDeleteYn;
    
    
    
    
    public SortCriteriaInfoVO() {
    }
    
    
    
    public Object getAttribute(String attribute) {
        if ( attribute.equalsIgnoreCase( "scvId" ))             return scvId;
        if ( attribute.equalsIgnoreCase( "scvSrtId" ))          return scvSrtId;
        if ( attribute.equalsIgnoreCase( "scvScvId" ))          return scvScvId;
        if ( attribute.equalsIgnoreCase( "scvDisplaySeq" ))     return scvDisplaySeq;
        if ( attribute.equalsIgnoreCase( "scvName" ))           return scvName;
        if ( attribute.equalsIgnoreCase( "scvDataLevelYn" ))    return scvDataLevelYn;
        if ( attribute.equalsIgnoreCase( "scvDeleteYn" ))       return scvDeleteYn;
        
        return null;
                
    }
    
    
    public SortCriteriaInfoVO transform(SortCriteriaSetsRow row) {
        SortCriteriaInfoVO srtInfo = new SortCriteriaInfoVO();
        
        srtInfo.setScvId( row.getScvId() );
        srtInfo.setScvSrtId( row.getScvSrtId() );
        srtInfo.setScvScvId( row.getScvScvId() );
        srtInfo.setScvDisplaySeq( row.getScvDisplaySeq() );
        srtInfo.setScvName( row.getScvName() );
        srtInfo.setScvDataLevelYn( row.getScvDataLevelYn() );
        srtInfo.setScvDeleteYn( row.getScvDeleteYn() );
        
        return srtInfo;
    }
    
    
    public SortCriteriaSetsRow transform(SortCriteriaSets view, SortCriteriaInfoVO srtInfo) {
        SortCriteriaSetsRow row = (SortCriteriaSetsRow) view.createRow();
        
        row.setScvId( srtInfo.getScvId() );
        row.setScvSrtId( srtInfo.getScvSrtId() );
        row.setScvScvId( srtInfo.getScvScvId() );
        row.setScvDisplaySeq( srtInfo.getScvDisplaySeq() );
        row.setScvName( srtInfo.getScvName() );
        row.setScvDataLevelYn( srtInfo.getScvDataLevelYn() );
        row.setScvDeleteYn( srtInfo.getScvDeleteYn() );
        
        return row;
    }
    
    
    public SortingCriteriaValuesDataSetInfo transform(SortCriteriaInfoVO srtInfo) {
        SortingCriteriaValuesDataSetInfo info = new SortingCriteriaValuesDataSet();
        
        if ( srtInfo.getScvId() != null )           info.setScv_id( srtInfo.getScvId().intValue() );
        if ( srtInfo.getScvSrtId() != null )        info.setScv_srt_id( srtInfo.getScvSrtId().intValue() );
        if ( srtInfo.getScvScvId() != null )           info.setScv_scv_id( srtInfo.getScvScvId().intValue() );
        if ( srtInfo.getScvDisplaySeq() != null )   info.setScv_display_seq( srtInfo.getScvDisplaySeq().intValue() );
        info.setSvc_name( srtInfo.getScvName() );
        info.setScv_data_level_yn( srtInfo.getScvDataLevelYn() );
        info.setScv_delete_yn( srtInfo.getScvDeleteYn() );
        
        
        return info;
        
    }

    public static void main(String[] args) {
        SortCriteriaInfoVO sortCriteriaInfo = new SortCriteriaInfoVO();
    }

    public void setScvId(Number scvId) {
        this.scvId = scvId;
    }

    public Number getScvId() {
        return scvId;
    }

    public void setScvSrtId(Number scvSrtId) {
        this.scvSrtId = scvSrtId;
    }

    public Number getScvSrtId() {
        return scvSrtId;
    }

    public void setScvScvId(Number scvScvId) {
        this.scvScvId = scvScvId;
    }

    public Number getScvScvId() {
        return scvScvId;
    }

    public void setScvDisplaySeq(Number scvDisplaySeq) {
        this.scvDisplaySeq = scvDisplaySeq;
    }

    public Number getScvDisplaySeq() {
        return scvDisplaySeq;
    }

    public void setScvName(String scvName) {
        this.scvName = scvName;
    }

    public String getScvName() {
        return scvName;
    }

    public void setScvDataLevelYn(String scvDataLevelYn) {
        this.scvDataLevelYn = scvDataLevelYn;
    }

    public String getScvDataLevelYn() {
        return scvDataLevelYn;
    }

    public void setScvDeleteYn(String scvDeleteYn) {
        this.scvDeleteYn = scvDeleteYn;
    }

    public String getScvDeleteYn() {
        return scvDeleteYn;
    }
}
