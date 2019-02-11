/**
 * @author Nonny Medhora
 */
package com.bawaweb.lifecycle.model;

import com.bawaweb.views.model.common.SourceAnswers;

import com.bawaweb.views.model.common.SourceAnswersRow;

import java.sql.SQLException;

import oracle.jbo.ApplicationModule;
import oracle.jbo.domain.Number;
import oracle.jbo.domain.Sequence;

public class OtlSourceAnswersVO {

    private Number  sraId;
    private Number  sraQstId;
    private Number  sraRpsId;
    private String  sraAnswer;
    private String  sraAnswerText;
    private Number  sraAsvId;
    private String  sraExcludeYN;
    private Number  sraWeightMultiplier;
    private Number  sraRavId;
    private String  sraColor;
    private String  sraComment;

    

    public OtlSourceAnswersVO() {
    }
    
    public Object getAttribute(String attribute) {
        if ( attribute.equalsIgnoreCase("sraId") )          return sraId;
        if ( attribute.equalsIgnoreCase("sraQstId") )          return sraQstId;
        if ( attribute.equalsIgnoreCase("sraRpsId") )          return sraRpsId;
        if ( attribute.equalsIgnoreCase("sraAnswer") )          return sraAnswer;
        if ( attribute.equalsIgnoreCase("sraAnswerText") )          return sraAnswerText;
        if ( attribute.equalsIgnoreCase("sraAsvId") )          return sraAsvId;
        if ( attribute.equalsIgnoreCase("sraExcludeYN") )          return sraExcludeYN;
        if ( attribute.equalsIgnoreCase("sraWeightMultiplier") )          return sraWeightMultiplier;
        if ( attribute.equalsIgnoreCase("sraRavId") )          return sraRavId;
        if ( attribute.equalsIgnoreCase("sraColor") )          return sraColor;
        if ( attribute.equalsIgnoreCase("sraComment") )          return sraComment;
        return null;
    }
    
    public OtlSourceAnswersVO transform(SourceAnswersRow row) {
        OtlSourceAnswersVO srcAns = new OtlSourceAnswersVO();
        
        srcAns.setSraId( row.getSraId() );
        srcAns.setSraQstId( row.getSraQstId() );
        srcAns.setSraRpsId( row.getSraRpsId() );
        srcAns.setSraAnswer( row.getSraAnswer() );
        srcAns.setSraAnswerText( row.getSraAnswerText() );
        srcAns.setSraAsvId( row.getSraAsvId() );
        srcAns.setSraExcludeYN( row.getSraExcludeYn() );
        srcAns.setSraWeightMultiplier( row.getSraWeightMultiplier() );
        srcAns.setSraRavId( row.getSraRavId() );
        srcAns.setSraColor( row.getSraColor() );
        srcAns.setSraComment( row.getSraComment() );
        return srcAns;
    }
    
    
    public SourceAnswersRow transform( SourceAnswers view, OtlSourceAnswersVO srcAns, ApplicationModule module) {
        SourceAnswersRow row = (SourceAnswersRow) view.createRow();
        
        if ( srcAns.getSraId() != null && srcAns.getSraId().intValue() != 0 ) {
            row.setSraId( srcAns.getSraId() );
        } else {
            Sequence sraSeq = new Sequence( "BAwaWEb_SRA_SEQ", module);
            try {
               row.setSraId( new Number ( sraSeq.getData().toString())); 
            } catch ( SQLException e) {
                e.printStackTrace();
            }
        }
        
        row.setSraQstId( srcAns.getSraQstId() );
        row.setSraRpsId( srcAns.getSraRpsId() );
        row.setSraAnswer( srcAns.getSraAnswer() );
        row.setSraAnswerText( srcAns.getSraAnswerText() );
        row.setSraAsvId( srcAns.getSraAsvId() );
        row.setSraExcludeYn( srcAns.getSraExcludeYN() );
        row.setSraWeightMultiplier( srcAns.getSraWeightMultiplier() );
        if (srcAns.getSraRavId() != null && srcAns.getSraRavId().intValue() != 0 ) {
            row.setSraRavId( srcAns.getSraRavId() );
        } else {
            Sequence ravSeq = new Sequence( "BAwaWEb_RAV_SEQ", module);
            try {
               row.setSraRavId( new Number ( ravSeq.getData().toString())); 
            } catch ( SQLException e) {
                e.printStackTrace();
            }
        }
        row.setSraColor( srcAns.getSraColor() );
        row.setSraComment( srcAns.getSraComment() );
        
        return row;
    }
    

    public static void main(String[] args) {
        OtlSourceAnswersVO otaSourceAnswers = new OtlSourceAnswersVO();
    }

    public void setSraId(Number sraId) {
        this.sraId = sraId;
    }

    public Number getSraId() {
        return sraId;
    }

    public void setSraQstId(Number sraQstId) {
        this.sraQstId = sraQstId;
    }

    public Number getSraQstId() {
        return sraQstId;
    }

    public void setSraRpsId(Number sraRpsId) {
        this.sraRpsId = sraRpsId;
    }

    public Number getSraRpsId() {
        return sraRpsId;
    }

    public void setSraAnswer(String sraAnswer) {
        this.sraAnswer = sraAnswer;
    }

    public String getSraAnswer() {
        return sraAnswer;
    }

    public void setSraAnswerText(String sraAnswerText) {
        this.sraAnswerText = sraAnswerText;
    }

    public String getSraAnswerText() {
        return sraAnswerText;
    }

    public void setSraAsvId(Number sraAsvId) {
        this.sraAsvId = sraAsvId;
    }

    public Number getSraAsvId() {
        return sraAsvId;
    }

    public void setSraExcludeYN(String sraExcludeYN) {
        this.sraExcludeYN = sraExcludeYN;
    }

    public String getSraExcludeYN() {
        return sraExcludeYN;
    }

    public void setSraWeightMultiplier(Number sraWeightMultiplier) {
        this.sraWeightMultiplier = sraWeightMultiplier;
    }

    public Number getSraWeightMultiplier() {
        return sraWeightMultiplier;
    }

    public void setSraRavId(Number sraRavId) {
        this.sraRavId = sraRavId;
    }

    public Number getSraRavId() {
        return sraRavId;
    }

    public void setSraColor(String sraColor) {
        this.sraColor = sraColor;
    }

    public String getSraColor() {
        return sraColor;
    }

    public void setSraComment(String sraComment) {
        this.sraComment = sraComment;
    }

    public String getSraComment() {
        return sraComment;
    }
}
