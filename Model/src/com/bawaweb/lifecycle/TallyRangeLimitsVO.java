/**
 * @author Nonny Medhora
 */
package com.bawaweb.lifecycle;

import com.bawaweb.grid.templates.data.tables.TallyRangeLimitsValuesDataSet;
import com.bawaweb.grid.templates.data.tables.TallyRangeLimitsValuesDataSetInfo;
import com.bawaweb.views.gridcursors.TallyRangeSetsImpl;
import com.bawaweb.views.gridcursors.common.TallyRangeSets;
import com.bawaweb.views.gridcursors.common.TallyRangeSetsRow;

import oracle.jbo.domain.Number;

public class TallyRangeLimitsVO {
    private Number tly_id;
    private String tly_name;
    private String tly_prefix;
    private String tly_suffix;
    private String tly_delete_yn;
    
    private Number trl_id;
    private Number trl_tly_id;
    private String trl_from;
    private String trl_to;
    private Number trl_display_seq;
    private String trl_type;
    private String trl_delete_yn;
    
    
    public TallyRangeLimitsVO() {
    }
    
    
    public TallyRangeLimitsValuesDataSetInfo transform(TallyRangeLimitsVO tVO) {
        TallyRangeLimitsValuesDataSetInfo tInfo = new TallyRangeLimitsValuesDataSet();
//        
//        if ( tVO.getTly_id().intValue() == tVO.getTrl_tly_id().intValue() ) {
//            System.out.println("tlyid == trl-tlyid --> " + (tVO.getTly_id().intValue() == tVO.getTrl_tly_id().intValue() ) ); 
//        }
        tInfo.setTly_id( tVO.getTly_id().intValue() );
        tInfo.setTly_name( tVO.getTly_name() );
        tInfo.setTly_prefix( tVO.getTly_prefix() );
        tInfo.setTly_suffix( tVO.getTly_suffix() );
        tInfo.setTly_delete_yn( tVO.getTly_delete_yn() );
        
        tInfo.setTrl_id( tVO.getTrl_id().intValue() );
        tInfo.setTrl_tly_id( tVO.getTrl_tly_id().intValue() );
        tInfo.setTrl_from( tVO.getTrl_from() );
        tInfo.setTrl_to( tVO.getTrl_to() );
        tInfo.setTrl_display_seq( tVO.getTrl_display_seq().intValue() );
        tInfo.setTrl_type( tVO.getTrl_type() );
        tInfo.setTrl_delete_yn( tVO.getTrl_delete_yn() );
        
        return tInfo;
    }
    public TallyRangeLimitsVO transform(TallyRangeSetsRow row) {
        TallyRangeLimitsVO tInfo = new TallyRangeLimitsVO();
//        if ( row.getTlyId().intValue() == row.getTrlTlyId().intValue() ) {
//            System.out.println("tlyid == trl-tlyid --> " + (row.getTlyId().intValue() == row.getTrlTlyId().intValue()) ); 
//        }
        tInfo.setTly_id( row.getTlyId() );
        tInfo.setTly_name( row.getTlyName() );
        tInfo.setTly_prefix( row.getTlyPrefix() );
        tInfo.setTly_suffix( row.getTlySuffix() );
        tInfo.setTly_delete_yn( row.getTlyDeleteYn() );
        
        tInfo.setTrl_id( row.getTrlId() );
        tInfo.setTrl_tly_id( row.getTrlTlyId() );
        tInfo.setTrl_from( row.getTrlFrom() );
        tInfo.setTrl_to( row.getTrlTo() );
        tInfo.setTrl_display_seq( row.getTrlDisplaySeq() );
        tInfo.setTrl_type( row.getTrlType() );
        tInfo.setTrl_delete_yn( row.getTrlDeleteYn() );
        
        return tInfo;
        
    }
    
    public TallyRangeSetsRow transform( TallyRangeSets view, TallyRangeLimitsVO tInfo) {
        TallyRangeSetsRow row = (TallyRangeSetsRow) view.createRow();
        
        row.setTlyId( tInfo.getTly_id() );
        row.setTlyName( tInfo.getTly_name() );
        row.setTlyPrefix( tInfo.getTly_prefix() );
        row.setTlySuffix( tInfo.getTly_suffix() );
        row.setTlyDeleteYn( tInfo.getTly_delete_yn() );
        
        row.setTrlId( tInfo.getTrl_id() );
        row.setTrlTlyId( tInfo.getTrl_tly_id() );
        row.setTrlFrom( tInfo.getTrl_from() );
        row.setTrlTo( tInfo.getTrl_to() );
        row.setTrlDisplaySeq( tInfo.getTrl_display_seq() );
        row.setTrlType( tInfo.getTrl_type() );
        row.setTrlDeleteYn( tInfo.getTrl_delete_yn() );
        
        return row;
    }
    
    public Object getAttribute(String attribute) {
        if ( attribute.equalsIgnoreCase("tly_id") ) return tly_id;
        if ( attribute.equalsIgnoreCase("tly_name") ) return tly_name;
        if ( attribute.equalsIgnoreCase("tly_prefix") ) return tly_prefix;
        if ( attribute.equalsIgnoreCase("tly_suffix") ) return tly_suffix;
        if ( attribute.equalsIgnoreCase("tly_delete_yn") ) return tly_delete_yn;
        if ( attribute.equalsIgnoreCase("trl_id") ) return trl_id;
        if ( attribute.equalsIgnoreCase("trl_tly_id") ) return trl_tly_id;
        if ( attribute.equalsIgnoreCase("trl_from") ) return trl_from;
        if ( attribute.equalsIgnoreCase("trl_to") ) return trl_to;
        if ( attribute.equalsIgnoreCase("trl_display_seq") ) return trl_display_seq;
        if ( attribute.equalsIgnoreCase("trl_type") ) return trl_type;
        if ( attribute.equalsIgnoreCase("trl_delete_yn") ) return        trl_delete_yn;
        return null;
    }

    public void setTly_id(Number tly_id) {
        this.tly_id = tly_id;
    }

    public Number getTly_id() {
        return tly_id;
    }

    public void setTly_name(String tly_name) {
        this.tly_name = tly_name;
    }

    public String getTly_name() {
        return tly_name;
    }

    public void setTly_prefix(String tly_prefix) {
        this.tly_prefix = tly_prefix;
    }

    public String getTly_prefix() {
        return tly_prefix;
    }

    public void setTly_suffix(String tly_suffix) {
        this.tly_suffix = tly_suffix;
    }

    public String getTly_suffix() {
        return tly_suffix;
    }

    public void setTly_delete_yn(String tly_delete_yn) {
        this.tly_delete_yn = tly_delete_yn;
    }

    public String getTly_delete_yn() {
        return tly_delete_yn;
    }

    public void setTrl_id(Number trl_id) {
        this.trl_id = trl_id;
    }

    public Number getTrl_id() {
        return trl_id;
    }

    public void setTrl_tly_id(Number trl_tly_id) {
        this.trl_tly_id = trl_tly_id;
    }

    public Number getTrl_tly_id() {
        return trl_tly_id;
    }

    public void setTrl_from(String trl_from) {
        this.trl_from = trl_from;
    }

    public String getTrl_from() {
        return trl_from;
    }

    public void setTrl_to(String trl_to) {
        this.trl_to = trl_to;
    }

    public String getTrl_to() {
        return trl_to;
    }

    public void setTrl_display_seq(Number trl_display_seq) {
        this.trl_display_seq = trl_display_seq;
    }

    public Number getTrl_display_seq() {
        return trl_display_seq;
    }

    public void setTrl_type(String trl_type) {
        this.trl_type = trl_type;
    }

    public String getTrl_type() {
        return trl_type;
    }

    public void setTrl_delete_yn(String trl_delete_yn) {
        this.trl_delete_yn = trl_delete_yn;
    }

    public String getTrl_delete_yn() {
        return trl_delete_yn;
    }
}
