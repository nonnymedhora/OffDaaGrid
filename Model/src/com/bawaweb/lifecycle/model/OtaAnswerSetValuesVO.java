/**
 * @author Nonny Medhora
 */
package com.bawaweb.lifecycle.model;

// lifecycle for ota-answer_set_values


 import com.bawaweb.views.model.common.AnswerSetValues;
 import com.bawaweb.views.model.common.AnswerSetValuesRow;

import com.bawaweb.views.model.common.OtlAnswerSetValues;

import com.bawaweb.views.model.common.OtlAnswerSetValuesRow;

import java.sql.SQLException;

 import oracle.jbo.ApplicationModule;
 import oracle.jbo.domain.Number;
 import oracle.jbo.domain.Sequence;
 
public class OtlAnswerSetValuesVO {


    private Number asvId;
    private Number asvAnsId;
    private String asvAnswer;
    private Number asvDisplaySeq;
    private String asvDeleteYN;
    
    public OtlAnswerSetValuesVO() {
    }
    
    
    public String toString() {
        StringBuffer buff = new StringBuffer("\n**\nOtlAnswerSetValuesVO\n");
        
        buff.append(" asvId --> " + this.asvId );
        buff.append(" asvAnsId --> " + this.asvAnsId );
        buff.append(" asvAnswer --> " + this.asvAnswer );
        buff.append(" asvDisplaySeq --> " + this.asvDisplaySeq );
        buff.append(" asvDeleteYN --> " + this.asvDeleteYN );
        
        return buff.toString();
    }
    

    public Object getAttribute(String attribute) {
        if ( attribute.equalsIgnoreCase("asvId") )          return asvId;
        if ( attribute.equalsIgnoreCase("asvAnsId") )       return asvAnsId;
        if ( attribute.equalsIgnoreCase("asvAnswer") )      return asvAnswer;
        if ( attribute.equalsIgnoreCase("asvDisplaySeq") )  return asvDisplaySeq;
        if ( attribute.equalsIgnoreCase("asvDeleteYN") )    return asvDeleteYN;
        
        return null;
    }
    
    
    public OtlAnswerSetValuesVO transform(AnswerSetValuesRow row) {
        OtlAnswerSetValuesVO asv = new OtlAnswerSetValuesVO();
        
        if ( row.getAsvId() != null && row.getAsvId().intValue() != 0 ) asv.setAsvId( row.getAsvId() );
        
        asv.setAsvAnsId( row.getAsvAnsId() );
        asv.setAsvAnswer( row.getAsvAnswer().trim() );
        asv.setAsvDisplaySeq( row.getAsvDisplaySeq() );
        asv.setAsvDeleteYN( row.getAsvDeleteYn() );
        return asv;
    }
    
    public AnswerSetValuesRow transform(AnswerSetValues view, OtlAnswerSetValuesVO asv, ApplicationModule module) {
        AnswerSetValuesRow row = (AnswerSetValuesRow) view.createRow();
        
        if ( asv.getAsvId() != null && asv.getAsvId().intValue() != 0) {
            row.setAsvId( asv.getAsvId() );
        } else {
            Sequence ravSeq = new Sequence( "BAwaWEb_ASV_SEQ", module);
            
            try {
                row.setAsvId( new Number( ravSeq.getData().toString() ));
            } catch ( SQLException e) {
                e.printStackTrace();
            }
        }
        
        if ( asv.getAsvAnsId() != null && asv.getAsvAnsId().intValue() != 0) {
            row.setAsvAnsId( asv.getAsvAnsId() );
        } else {
            Sequence ansSeq = new Sequence( "BAwaWEb_ANS_SEQ", module);
            
            try {
                row.setAsvAnsId( new Number( ansSeq.getData().toString() ));
            } catch ( SQLException e) {
                e.printStackTrace();
            }
        }
         
        row.setAsvAnswer( asv.getAsvAnswer().trim() );
        
        row.setAsvDisplaySeq( asv.getAsvDisplaySeq() );
        row.setAsvDeleteYn( asv.getAsvDeleteYN() );
        
         
        return row;
    }
    
    public OtlAnswerSetValuesVO transform(OtlAnswerSetValuesRow row) {
        OtlAnswerSetValuesVO asv = new OtlAnswerSetValuesVO();
        
        if ( row.getAsvId() != null && row.getAsvId().intValue() != 0 ) asv.setAsvId( row.getAsvId() );
        
        asv.setAsvAnsId( row.getAsvAnsId() );
        asv.setAsvAnswer( row.getAsvAnswer().trim() );
        asv.setAsvDisplaySeq( row.getAsvDisplaySeq() );
        asv.setAsvDeleteYN( row.getAsvDeleteYn() );
        
        return asv;
    }
    
    
    public OtlAnswerSetValuesRow transform(OtlAnswerSetValues view, OtlAnswerSetValuesVO asv) {
        OtlAnswerSetValuesRow row = (OtlAnswerSetValuesRow) view.createRow();
        
        row.setAsvId( asv.getAsvId() );
        row.setAsvAnsId( asv.getAsvAnsId() );
        row.setAsvAnswer( asv.getAsvAnswer().trim() );
        row.setAsvDisplaySeq( asv.getAsvDisplaySeq() );
        row.setAsvDeleteYn( asv.getAsvDeleteYN() );
        
         
        return row;
    }

    

    public void setAsvId(Number asvId) {
        this.asvId = asvId;
    }

    public Number getAsvId() {
        return asvId;
    }

    public void setAsvAnsId(Number asvAnsId) {
        this.asvAnsId = asvAnsId;
    }

    public Number getAsvAnsId() {
        return asvAnsId;
    }

    public void setAsvAnswer(String asvAnswer) {
        this.asvAnswer = asvAnswer;
    }

    public String getAsvAnswer() {
        return asvAnswer;
    }

    public void setAsvDisplaySeq(Number asvDisplaySeq) {
        this.asvDisplaySeq = asvDisplaySeq;
    }

    public Number getAsvDisplaySeq() {
        return asvDisplaySeq;
    }

    public void setAsvDeleteYN(String asvDeleteYN) {
        this.asvDeleteYN = asvDeleteYN;
    }

    public String getAsvDeleteYN() {
        return asvDeleteYN;
    }
}
