/**
 * @author Nonny Medhora
 */
package com.bawaweb.lifecycle.model;

import com.bawaweb.grid.templates.data.tables.AnswerSetsDataSet;
import com.bawaweb.grid.templates.data.tables.AnswerSetsDataSetInfo;
import com.bawaweb.views.gridcursors.common.AnswerSetsInfo;
import com.bawaweb.views.gridcursors.common.AnswerSetsInfoRow;

import oracle.jbo.domain.Number;
// lifecycle for bawaweb_answer_sets

public class AnswerSetsVO {
    private Number ansId;
    private String ansName;
    private Number ansFridId;
    private String ansOrderByNameYn;
    private String ansAddAnswerYn;
    private String ansDeleteYn;
    
    public AnswerSetsVO() {
    }
    
    public Object getAttribute(String attribute) {
        if ( attribute.equalsIgnoreCase( "ansId" ))         return ansId;
        if ( attribute.equalsIgnoreCase( "ansName" ))      return ansName;
        if ( attribute.equalsIgnoreCase( "ansFridId" ))      return ansFridId;
        if ( attribute.equalsIgnoreCase( "ansOrderByNameYn" ))     return ansOrderByNameYn;
        if ( attribute.equalsIgnoreCase( "ansAddAnswerYn" )) return ansAddAnswerYn;
        if ( attribute.equalsIgnoreCase( "ansDeleteYn" ))   return ansDeleteYn;
        
        return null;        
    }
    
    public AnswerSetsVO transform(AnswerSetsInfoRow row) {
        AnswerSetsVO ansSet = new AnswerSetsVO();
        
        ansSet.setAnsId( row.getAnsId() );
        ansSet.setAnsName( row.getAnsName() );
        ansSet.setAnsFridId( row.getAnsFridId() );
        ansSet.setAnsOrderByNameYn( row.getAnsOrderByNameYn() );
        ansSet.setAnsAddAnswerYn( row.getAnsAddAnswerYn() );
        ansSet.setAnsDeleteYn( row.getAnsDeleteYn() );
        
        return ansSet;
    }
    
    public AnswerSetsInfoRow transform(AnswerSetsInfo view, AnswerSetsVO ansSet) {
        AnswerSetsInfoRow row = (AnswerSetsInfoRow) view.createRow();
        
        row.setAnsId( ansSet.getAnsId() );
        row.setAnsName( ansSet.getAnsName() );
        row.setAnsFridId( ansSet.getAnsFridId() );
        row.setAnsOrderByNameYn( ansSet.getAnsOrderByNameYn() );
        row.setAnsAddAnswerYn( ansSet.getAnsAddAnswerYn() );
        row.setAnsDeleteYn( ansSet.getAnsDeleteYn() );
        
        return row;
    }
    
    public AnswerSetsDataSetInfo transform(AnswerSetsVO ansSet) {
        AnswerSetsDataSetInfo info = new AnswerSetsDataSet();
        
        if ( ansSet.getAnsId() != null ) info.setAns_id( ansSet.getAnsId().intValue() );
        info.setAns_name( ansSet.getAnsName() );
        if( ansSet.getAnsFridId() != null ) info.setAns_frid_id( ansSet.getAnsFridId().intValue() );
        info.setAns_order_by_name_yn( ansSet.getAnsOrderByNameYn() );
        info.setAns_add_answer_yn( ansSet.getAnsAddAnswerYn() );
        info.setAns_delete_yn( ansSet.getAnsDeleteYn() );
        
        return info;
    }

    public void setAnsId(Number ansId) {
        this.ansId = ansId;
    }

    public Number getAnsId() {
        return ansId;
    }

    public void setAnsName(String ansName) {
        this.ansName = ansName;
    }

    public String getAnsName() {
        return ansName;
    }

    public void setAnsFridId(Number ansFridId) {
        this.ansFridId = ansFridId;
    }

    public Number getAnsFridId() {
        return ansFridId;
    }

    public void setAnsOrderByNameYn(String ansOrderByNameYn) {
        this.ansOrderByNameYn = ansOrderByNameYn;
    }

    public String getAnsOrderByNameYn() {
        return ansOrderByNameYn;
    }

    public void setAnsAddAnswerYn(String ansAddAnswerYn) {
        this.ansAddAnswerYn = ansAddAnswerYn;
    }

    public String getAnsAddAnswerYn() {
        return ansAddAnswerYn;
    }

    public void setAnsDeleteYn(String ansDeleteYn) {
        this.ansDeleteYn = ansDeleteYn;
    }

    public String getAnsDeleteYn() {
        return ansDeleteYn;
    }
}
