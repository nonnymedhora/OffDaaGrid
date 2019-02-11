/**
 * @author Nonny Medhora
 */
package com.bawaweb.lifecycle.model;


import com.bawaweb.views.model.common.OtlReportAnswerSetValues;
import com.bawaweb.views.model.common.OtlReportAnswerSetValuesRow;
import com.bawaweb.views.model.common.ReportAnswerSetValues;
import com.bawaweb.views.model.common.ReportAnswerSetValuesRow;

import java.sql.SQLException;

import oracle.jbo.ApplicationModule;
import oracle.jbo.domain.Number;
import oracle.jbo.domain.Sequence;
// lifecycle for OtlReportAnswerSetValues table
public class OtlReportAnswerSetValuesVO {

    private Number ravId;
    private Number ravRasId;
    private String ravAnswer;
    private Number ravDisplaySeq;
    private Number ravAsvId;
    private String ravDeleteYN;
    
    
    private Number ansId;   // added v2
    
    
    public OtlReportAnswerSetValuesVO() {
    }
    
    
    
    public String toString() {
        StringBuffer buff = new StringBuffer();
        
        buff.append(" ravId --> " + this.ravId );
        buff.append(" ravRasId --> " + this.ravRasId );
        buff.append(" ravAnswer --> " + this.ravAnswer );
        buff.append(" ravDisplaySeq --> " + this.ravDisplaySeq );
        buff.append(" ravAsvId --> " + this.ravAsvId );
        buff.append(" ravDeleteYN --> " + this.ravDeleteYN );
        buff.append(" ansId --> " + this.ansId );
        return buff.toString();
    }
    
    
    public Object getAttribute(String attribute) {
        if ( attribute.equalsIgnoreCase("ravId") )          return ravId;
        if ( attribute.equalsIgnoreCase("ravRasId") )       return ravRasId;
        if ( attribute.equalsIgnoreCase("ravAnswer") )      return ravAnswer;
        if ( attribute.equalsIgnoreCase("ravDisplaySeq") )  return ravDisplaySeq;
        if ( attribute.equalsIgnoreCase("ravAsvId") )       return ravAsvId;
        if ( attribute.equalsIgnoreCase("ravDeleteYN") )    return ravDeleteYN;
        if ( attribute.equalsIgnoreCase("ansId") )    return ansId;
        
        return null;
    }
    
    public OtlReportAnswerSetValuesVO transform(ReportAnswerSetValuesRow row ) {
        OtlReportAnswerSetValuesVO rasv = new OtlReportAnswerSetValuesVO();
        
        if ( row.getRavId() != null && row.getRavId().intValue() != 0 ) rasv.setRavId( row.getRavId() );
        
        rasv.setRavRasId( row.getRavRasId() );
        rasv.setRavAnswer( row.getRavAnswer().trim() );
        rasv.setRavDisplaySeq( row.getRavDisplaySeq() );
        rasv.setRavAsvId( row.getRavAsvId() );
        rasv.setRavDeleteYN( row.getRavDeleteYn() );
        
        rasv.setAnsId( row.getAnsId() );
        return rasv;
    }
    
    public ReportAnswerSetValuesRow transform(ReportAnswerSetValues view, OtlReportAnswerSetValuesVO rasv, ApplicationModule module) {
        ReportAnswerSetValuesRow row = (ReportAnswerSetValuesRow) view.createRow();
        
        if ( rasv.getRavId() != null && rasv.getRavId().intValue() != 0) {
            row.setRavId( rasv.getRavId() );
        } else {
            Sequence ravSeq = new Sequence( "BAwaWEb_RAV_SEQ", module);
            
            try {
                row.setRavId( new Number( ravSeq.getData().toString() ));
            } catch ( SQLException e) {
                e.printStackTrace();
            }
        }
        
        if ( rasv.getRavRasId() != null && rasv.getRavRasId().intValue() != 0) {
            row.setRavRasId( rasv.getRavRasId() );
        } else {
            Sequence rasSeq = new Sequence( "BAwaWEb_RAS_SEQ", module);
            
            try {
                row.setRavRasId( new Number( rasSeq.getData().toString() ));
            } catch ( SQLException e) {
                e.printStackTrace();
            }
        }
         
        row.setRavAnswer( rasv.getRavAnswer() );
        
        if ( rasv.getRavAsvId() != null && rasv.getRavAsvId().intValue() != 0) {
            row.setRavAsvId( rasv.getRavAsvId() );
        } else {
            Sequence asvSeq = new Sequence( "BAwaWEb_ASV_SEQ", module);
            
            try {
                row.setRavAsvId( new Number( asvSeq.getData().toString() ));
            } catch ( SQLException e) {
                e.printStackTrace();
            }
        }
        
        row.setRavDisplaySeq( rasv.getRavDisplaySeq() );
        row.setRavDeleteYn( rasv.getRavDeleteYN() );
        
        row.setAnsId( rasv.getAnsId() ); 
        return row;
    }
    
    public OtlReportAnswerSetValuesVO transform(OtlReportAnswerSetValuesRow row ) {
        OtlReportAnswerSetValuesVO rasv = new OtlReportAnswerSetValuesVO();
        
        if ( row.getRavId() != null && row.getRavId().intValue() != 0 ) rasv.setRavId( row.getRavId() );
        
        rasv.setRavRasId( row.getRavRasId() );
        rasv.setRavAnswer( row.getRavAnswer().trim() );
        rasv.setRavDisplaySeq( row.getRavDisplaySeq() );
        rasv.setRavAsvId( row.getRavAsvId() );
        rasv.setRavDeleteYN( row.getRavDeleteYn() );
        return rasv;
    }
    
    
    public OtlReportAnswerSetValuesRow transform(OtlReportAnswerSetValues view, OtlReportAnswerSetValuesVO rasv) {
        OtlReportAnswerSetValuesRow row = (OtlReportAnswerSetValuesRow) view.createRow();
        
        row.setRavId( rasv.getRavId() );
        row.setRavRasId( rasv.getRavRasId() );
        row.setRavAnswer( rasv.getRavAnswer().trim() );
        row.setRavAsvId( rasv.getRavAsvId() );
        row.setRavDisplaySeq( rasv.getRavDisplaySeq() );
        row.setRavDeleteYn( rasv.getRavDeleteYN() );
        
         
        return row;
    }

    public static void main(String[] args) {
        OtlReportAnswerSetValuesVO otaReportAnswerSetValues = new OtlReportAnswerSetValuesVO();
    }

    public void setRavId(Number ravId) {
        this.ravId = ravId;
    }

    public Number getRavId() {
        return ravId;
    }

    public void setRavRasId(Number ravRasId) {
        this.ravRasId = ravRasId;
    }

    public Number getRavRasId() {
        return ravRasId;
    }

    public void setRavAnswer(String ravAnswer) {
        this.ravAnswer = ravAnswer;
    }

    public String getRavAnswer() {
        return ravAnswer;
    }

    public void setRavDisplaySeq(Number ravDisplaySeq) {
        this.ravDisplaySeq = ravDisplaySeq;
    }

    public Number getRavDisplaySeq() {
        return ravDisplaySeq;
    }

    public void setRavAsvId(Number ravAsvId) {
        this.ravAsvId = ravAsvId;
    }

    public Number getRavAsvId() {
        return ravAsvId;
    }

    public void setRavDeleteYN(String ravDeleteYN) {
        this.ravDeleteYN = ravDeleteYN;
    }

    public String getRavDeleteYN() {
        return ravDeleteYN;
    }

    public void setAnsId(Number ansId) {
        this.ansId = ansId;
    }

    public Number getAnsId() {
        return ansId;
    }
}
