/**
 * @author Nonny Medhora
 */
package com.bawaweb.lifecycle;

import com.bawaweb.views.gridcursors.common.SourcesMultiSingleQuestionAnswers;
import com.bawaweb.views.gridcursors.common.SourcesMultiSingleQuestionAnswersRow;

import java.sql.SQLException;

import oracle.jbo.ApplicationModule;
import oracle.jbo.domain.Number;
import oracle.jbo.domain.Sequence;

public class SourcesMultiSingleQuestionAnswersVO {
    // bawaweb_source_answers
    private Number  sraId;      // pk
    private Number  sraQstId;
    private Number  sraRpsId;
    private String  sraAnswer;
    private String  sraAnswerText;
    private Number  sraAsvId;
    private String  sraExcludeYN;
    private Number  sraWeightMultiplier;
    private Number  sraRavId;      // fk all null for multi
    private String  sraColor;
    private String  sraComment;
    
    // bawaweb_report_answer_values
    private Number ravId;      // pk
    private Number ravRasId;
    private Number ravDisplaySeq;
    private Number ravAsvId;
    private String ravDeleteYN;
    
    // bawaweb_source_mutli_answers
    private Number  smaSraId;      // pk1
    private String  smaAnswer;
    private Number  smaAsvId;
    private Number  smaQmqId;      // pk2
    private String  smaExcludeYN;
    private Number  smaWeightMultiplier;
    private Number  smaRavId;      // fk
    
    public Object getAttribute(String attribute) {
        if ( attribute.equalsIgnoreCase("sraId")) return sraId;
        if ( attribute.equalsIgnoreCase("sraQstId")) return sraQstId;
        if ( attribute.equalsIgnoreCase("sraRpsId")) return sraRpsId;
        if ( attribute.equalsIgnoreCase("sraAnswer")) return sraAnswer;
        if ( attribute.equalsIgnoreCase("sraAnswerText")) return sraAnswerText;
        if ( attribute.equalsIgnoreCase("sraAsvId")) return sraAsvId;
        if ( attribute.equalsIgnoreCase("sraExcludeYN")) return sraExcludeYN;
        if ( attribute.equalsIgnoreCase("sraWeightMultiplier")) return sraWeightMultiplier;
        if ( attribute.equalsIgnoreCase("sraRavId")) return sraRavId;
        if ( attribute.equalsIgnoreCase("sraColor")) return sraColor;
        if ( attribute.equalsIgnoreCase("sraComment")) return sraComment;
        if ( attribute.equalsIgnoreCase("ravId")) return ravId;
        if ( attribute.equalsIgnoreCase("ravRasId")) return ravRasId;
        if ( attribute.equalsIgnoreCase("ravDisplaySeq")) return ravDisplaySeq;
        if ( attribute.equalsIgnoreCase("ravAsvId")) return ravAsvId;
        if ( attribute.equalsIgnoreCase("ravDeleteYN")) return ravDeleteYN;
        if ( attribute.equalsIgnoreCase("smaSraId")) return smaSraId;
        if ( attribute.equalsIgnoreCase("smaAnswer")) return smaAnswer;
        if ( attribute.equalsIgnoreCase("smaAsvd")) return smaAsvId;
        if ( attribute.equalsIgnoreCase("smaQmqId")) return smaQmqId;
        if ( attribute.equalsIgnoreCase("smaExcludeYN")) return smaExcludeYN;
        if ( attribute.equalsIgnoreCase("smaWeightMultiplier")) return smaWeightMultiplier;
        if ( attribute.equalsIgnoreCase("smaRavId")) return smaRavId;
        
        return null;
    }

    public SourcesMultiSingleQuestionAnswersVO transform(SourcesMultiSingleQuestionAnswersRow row) {
        SourcesMultiSingleQuestionAnswersVO smsAns = new SourcesMultiSingleQuestionAnswersVO();
        
        if (  row.getSraId()  != null &&  row.getSraId().intValue() != 0 )  smsAns.setSraId( row.getSraId() );
        smsAns.setSraQstId( row.getSraQstId() );
        smsAns.setSraRpsId( row.getSraRpsId() );
        smsAns.setSraAnswer( row.getSraAnswer() );
        smsAns.setSraAnswerText( row.getSraAnswerText() );
        smsAns.setSraAsvId( row.getSraAsvId() );
        smsAns.setSraExcludeYN( row.getSraExcludeYn() );
        smsAns.setSraWeightMultiplier( row.getSraWeightMultiplier() );
        if ( row.getSraRavId() != null && row.getSraRavId().intValue() != 0 ) smsAns.setSraRavId( row.getSraRavId() );
        smsAns.setSraColor( row.getSraColor() );
        smsAns.setSraComment( row.getSraComment() );
        
        if ( row.getRavId() != null && row.getRavId().intValue() != 0) smsAns.setRavId( row.getRavId() );
        smsAns.setRavRasId( row.getRavRasId() );
        smsAns.setRavDisplaySeq( row.getRavDisplaySeq() );
        smsAns.setRavAsvId( row.getRavAsvId() );
        smsAns.setRavDeleteYN( row.getRavDeleteYn() );
        
        if (  row.getSmaSraId()  != null &&  row.getSmaSraId().intValue() != 0 )  smsAns.setSmaSraId( row.getSmaSraId() );
        smsAns.setSmaAnswer( row.getSmaAnswer() );
        smsAns.setSmaAsvId( row.getSmaAsvId() );
        smsAns.setSmaExcludeYN( row.getSmaExcludeYn() );
        smsAns.setSmaWeightMultiplier( row.getSmaWeightMultiplier() );
        if ( row.getSmaRavId() != null && row.getSmaRavId().intValue() != 0 ) smsAns.setSmaRavId( row.getSmaRavId() );
        smsAns.setSmaQmqId( row.getSmaQmqId() );
        
        return smsAns;
    }
    
    public SourcesMultiSingleQuestionAnswersRow transform(SourcesMultiSingleQuestionAnswers view, SourcesMultiSingleQuestionAnswersVO smsInfo, ApplicationModule module) {
        SourcesMultiSingleQuestionAnswersRow row = (SourcesMultiSingleQuestionAnswersRow) view.createRow();
        Number theSraId = null;
        Number theRavId;
        if ( smsInfo.getSraId() != null && smsInfo.getSraId().intValue() != 0 ) {
            row.setSraId(smsInfo.getSraId());
            theSraId = smsInfo.getSraId();
        } else {
            try {
                Sequence sraSeq = new Sequence( "BAwaWEb_SRA_SEQ", module);
                Number nxt = new Number( sraSeq.getData().toString() );
                row.setSraId( nxt );
                theSraId = nxt;
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        row.setSraQstId( smsInfo.getSraQstId() );
        row.setSraRpsId( smsInfo.getSraRpsId() );
        row.setSraAnswer( smsInfo.getSraAnswer() );
        row.setSraAnswerText( smsInfo.getSraAnswerText() );
        row.setSraAsvId( smsInfo.getSraAsvId() );
        row.setSraExcludeYn( "N");      //smsInfo.getSraExcludeYN() 
        row.setSraWeightMultiplier( smsInfo.getSraWeightMultiplier() );
//        row.setSraRavId( smsInfo.getSraRavId() );       //all null for multi
        row.setSraColor( smsInfo.getSraColor() );
        row.setSraComment( smsInfo.getSraComment() );
        
        if (smsInfo.getRavId() != null && smsInfo.getRavId().intValue() != 0 ) row.setRavId( smsInfo.getRavId() );
        else {
            try {
                Sequence ravSeq = new Sequence( "BAwaWEb_RAV_SEQ", module);
                row.setSraId( new Number( ravSeq.getData().toString() ));
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        row.setSraRpsId( smsInfo.getSraRpsId() );
        row.setRavRasId( smsInfo.getRavRasId() );
        row.setRavDisplaySeq( smsInfo.getRavDisplaySeq() );
        row.setRavAsvId( smsInfo.getRavAsvId() );
        row.setRavDeleteYn( smsInfo.getRavDeleteYN() );
        
        if (  smsInfo.getSmaSraId() != null &&  smsInfo.getSmaSraId().intValue() != 0 ) row.setSmaSraId( smsInfo.getSmaSraId() );
        else {
            if ( theSraId != null ) row.setSmaSraId( theSraId );
        }
        if (  smsInfo.getSmaQmqId() != null &&  smsInfo.getSmaQmqId().intValue() != 0 ) row.setSmaQmqId( smsInfo.getSmaQmqId() );
        else {
            Sequence qmqSeq = new Sequence( "BAwaWEb_QMQ_SEQ", module);

            try {
                row.setSmaQmqId( new Number( qmqSeq.getData().toString() ) );
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        row.setSmaAnswer( smsInfo.getSmaAnswer() );
        row.setSmaAsvId( smsInfo.getSmaAsvId() );
        row.setSmaExcludeYn( smsInfo.getSmaExcludeYN() );
        row.setSmaWeightMultiplier( smsInfo.getSmaWeightMultiplier() );
        row.setSmaRavId( smsInfo.getSmaRavId() );
        return row;
    }
    
    public SourcesMultiSingleQuestionAnswersVO() {
    }

    public static void main(String[] args) {
        SourcesMultiSingleQuestionAnswersVO sourcesMultiSingleQuestionAnswersVO = new SourcesMultiSingleQuestionAnswersVO();
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

    public void setSmaSraId(Number smaSraId) {
        this.smaSraId = smaSraId;
    }

    public Number getSmaSraId() {
        return smaSraId;
    }

    public void setSmaAnswer(String smaAnswer) {
        this.smaAnswer = smaAnswer;
    }

    public String getSmaAnswer() {
        return smaAnswer;
    }

    public void setSmaAsvId(Number smaAsvd) {
        this.smaAsvId = smaAsvd;
    }

    public Number getSmaAsvId() {
        return smaAsvId;
    }

    public void setSmaQmqId(Number smaQmqId) {
        this.smaQmqId = smaQmqId;
    }

    public Number getSmaQmqId() {
        return smaQmqId;
    }

    public void setSmaExcludeYN(String smaExcludeYN) {
        this.smaExcludeYN = smaExcludeYN;
    }

    public String getSmaExcludeYN() {
        return smaExcludeYN;
    }

    public void setSmaWeightMultiplier(Number smaWeightMultiplier) {
        this.smaWeightMultiplier = smaWeightMultiplier;
    }

    public Number getSmaWeightMultiplier() {
        return smaWeightMultiplier;
    }

    public void setSmaRavId(Number smaRavId) {
        this.smaRavId = smaRavId;
    }

    public Number getSmaRavId() {
        return smaRavId;
    }
}
