/**
 * @author Nonny Medhora
 */
package com.bawaweb.lifecycle.model;

import com.bawaweb.grid.templates.data.tables.SourceIndustriesDataSet;
import com.bawaweb.grid.templates.data.tables.SourceIndustriesDataSetInfo;

import com.bawaweb.views.model.common.SourceIndustries;
import com.bawaweb.views.model.common.SourceIndustriesRow;

import oracle.jbo.domain.Number;

public class SourceIndustriesVO {

    private Number sciSrcId;
    private Number sciFridId;
    private String sciDeleteYn;
    
    

    public SourceIndustriesVO() {
    }
    
    
    public Object getAttribute(String attribute) {
        if ( attribute.equalsIgnoreCase("sciSrcId") ) return sciSrcId;
        if ( attribute.equalsIgnoreCase("sciFridId") ) return sciFridId;
        if ( attribute.equalsIgnoreCase("sciDeleteYn") ) return sciDeleteYn;
        return null;
    }
    
    
    public SourceIndustriesVO transform(SourceIndustriesDataSetInfo src) {
        SourceIndustriesVO srcVo = new SourceIndustriesVO();
        if ( src.getSci_src_id()  != 0 ) srcVo.setSciSrcId( new Number( src.getSci_src_id() ) );
        if ( src.getSci_frid_id()  != 0 ) srcVo.setSciFridId( new Number( src.getSci_frid_id() ) );
        srcVo.setSciDeleteYn( src.getSci_delete_yn() );
        return srcVo;
    }
    
    public SourceIndustriesDataSetInfo transform(SourceIndustriesVO asrc) {
        SourceIndustriesDataSetInfo s = new SourceIndustriesDataSet();
        s.setSci_src_id( asrc.getSciSrcId().intValue() );
        s.setSci_frid_id( asrc.getSciFridId().intValue() );
        s.setSci_delete_yn( asrc.getSciDeleteYn() );
        
        return s;
    }
    
    public SourceIndustriesVO transform(SourceIndustriesRow row) {
        SourceIndustriesVO srcVo = new SourceIndustriesVO();
        srcVo.setSciSrcId( row.getSciSrcId() );
        srcVo.setSciFridId( row.getSciFridId() );
        srcVo.setSciDeleteYn( row.getSciDeleteYn() );
        return srcVo;
    }
    
    public SourceIndustriesRow transform( SourceIndustries view, SourceIndustriesVO src) {
        SourceIndustriesRow row = (SourceIndustriesRow) view.createRow();
        if (src.getSciSrcId() != null ) row.setSciSrcId( src.getSciSrcId() );
        if (src.getSciFridId() != null ) row.setSciFridId( src.getSciFridId() );
        row.setSciDeleteYn( src.getSciDeleteYn() );
        return row;
    }
    

    public static void main(String[] args) {
        SourceIndustriesVO sourceIndustriesVO = new SourceIndustriesVO();
    }
    

    public void setSciSrcId(Number sciSrcId) {
        this.sciSrcId = sciSrcId;
    }

    public Number getSciSrcId() {
        return sciSrcId;
    }

    public void setSciFridId(Number sciFridid) {
        this.sciFridId = sciFridid;
    }

    public Number getSciFridId() {
        return sciFridId;
    }

    public void setSciDeleteYn(String sciDeleteYn) {
        this.sciDeleteYn = sciDeleteYn;
    }

    public String getSciDeleteYn() {
        return sciDeleteYn;
    }
}
