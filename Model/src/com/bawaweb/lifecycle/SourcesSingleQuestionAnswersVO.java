/**
 * @author Nonny Medhora
 */
package com.bawaweb.lifecycle;

import com.bawaweb.views.gridcursors.common.SourcesSingleQuestionAnswers;
import com.bawaweb.views.gridcursors.common.SourcesSingleQuestionAnswersRow;

import java.sql.SQLException;

import oracle.jbo.ApplicationModule;
import oracle.jbo.domain.Number;
import oracle.jbo.domain.Sequence;

public class SourcesSingleQuestionAnswersVO {

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
    private Number ravId;
    private Number ravRasId;
    private String ravAnswer;
    private Number ravDisplaySeq;
    private Number ravAsvId;
    private String ravDeleteYN;
    
    
    public SourcesSingleQuestionAnswersVO() {
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
        if ( attribute.equalsIgnoreCase("ravId") )          return ravId;
        if ( attribute.equalsIgnoreCase("ravRasId") )       return ravRasId;
        if ( attribute.equalsIgnoreCase("ravAnswer") )      return ravAnswer;
        if ( attribute.equalsIgnoreCase("ravDisplaySeq") )  return ravDisplaySeq;
        if ( attribute.equalsIgnoreCase("ravAsvId") )       return ravAsvId;
        if ( attribute.equalsIgnoreCase("ravDeleteYN") )    return ravDeleteYN;
        
        return null;
        
    }
    
    public SourcesSingleQuestionAnswersVO transform(SourcesSingleQuestionAnswersRow row) {
        SourcesSingleQuestionAnswersVO srcAns = new SourcesSingleQuestionAnswersVO();
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
        srcAns.setRavId( row.getRavId() );
                
        srcAns.setRavRasId( row.getRavRasId() );
        srcAns.setRavAnswer( row.getRavAnswer() );
        srcAns.setRavDisplaySeq( row.getRavDisplaySeq() );
        srcAns.setRavAsvId( row.getRavAsvId() );
        srcAns.setRavDeleteYN( row.getRavDeleteYn() );
        
        return srcAns;
    }
    
    
    public SourcesSingleQuestionAnswersRow transform(SourcesSingleQuestionAnswers view, SourcesAnswerInfoVO sanInfo, ApplicationModule module ) {
        SourcesSingleQuestionAnswersRow row = (SourcesSingleQuestionAnswersRow) view.createRow();
        
        if ( sanInfo.getSraId() != null && sanInfo.getSraId().intValue() != 0 ) {
            row.setSraId( sanInfo.getSraId() );
        } else {
            Sequence sraSeq = new Sequence( "BAwaWEb_SRA_SEQ", module);
            try {
               row.setSraId( new Number ( sraSeq.getData().toString())); 
            } catch ( SQLException e) {
                e.printStackTrace();
            }
        }
        
        row.setSraQstId( sanInfo.getSraQstId() );
        row.setSraRpsId( sanInfo.getSraRpsId() );
        row.setSraAnswer( sanInfo.getAnswer() );
        row.setSraAnswerText( sanInfo.getSraAnswerText() );
//        row.setSraAsvId( sanInfo.getSraAsvId() );
        row.setSraExcludeYn( "N" );
//        row.setSraWeightMultiplier( sanInfo.getSraWeightMultiplier() );
        if (//sanInfo.getSraRavId() != null && sanInfo.getSraRavId().intValue() != 0  &&
            sanInfo.getRavId() != null && sanInfo.getRavId().intValue() != 0 
        ) {
            row.setSraRavId( sanInfo.getRavId() );  //getSraRavId()
            row.setRavId( sanInfo.getRavId() );
        } else {
            Sequence ravSeq = new Sequence( "BAwaWEb_RAV_SEQ", module);
            try {
                Number nxtRavVal = new Number ( ravSeq.getData().toString());
                row.setSraRavId( nxtRavVal ); 
                row.setRavId( nxtRavVal );
            } catch ( SQLException e) {
                e.printStackTrace();
            }
        }
        row.setSraColor( sanInfo.getSraColor() );
        row.setSraComment( sanInfo.getSraComment() );
        
//        if ( sanInfo.getRavRasId() != null && sanInfo.getRavRasId().intValue() != 0) {
//            row.setRavRasId( sanInfo.getRavRasId() );
//        } else {
//            Sequence rasSeq = new Sequence( "BAwaWEb_RAS_SEQ", module);
//            
//            try {
//                row.setRavRasId( new Number( rasSeq.getData().toString() ));
//            } catch ( SQLException e) {
//                e.printStackTrace();
//            }
//        }
         
        row.setRavAnswer( sanInfo.getAnswer() );
        
        if ( sanInfo.getAsvId() != null && sanInfo.getAsvId().intValue() != 0) {
            row.setRavAsvId( sanInfo.getAsvId() );
        } else {
            Sequence asvSeq = new Sequence( "BAwaWEb_ASV_SEQ", module);
            
            try {
                row.setRavAsvId( new Number( asvSeq.getData().toString() ));
            } catch ( SQLException e) {
                e.printStackTrace();
            }
        }
        
        row.setRavDisplaySeq( sanInfo.getRavDisplaySeq() );
        row.setRavDeleteYn( sanInfo.getRavDeleteYN() );
        
        return row;
    }
    
    
    public SourcesSingleQuestionAnswersRow transform(SourcesSingleQuestionAnswers view, SourcesSingleQuestionAnswersVO srcAns, ApplicationModule module ) {
        SourcesSingleQuestionAnswersRow row = (SourcesSingleQuestionAnswersRow) view.createRow();
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
        if (srcAns.getSraRavId() != null && srcAns.getSraRavId().intValue() != 0  &&
            srcAns.getRavId() != null && srcAns.getRavId().intValue() != 0 
        ) {
            row.setSraRavId( srcAns.getSraRavId() );
            row.setRavId( srcAns.getRavId() );
        } else {
            Sequence ravSeq = new Sequence( "BAwaWEb_RAV_SEQ", module);
            try {
                Number nxtRavVal = new Number ( ravSeq.getData().toString());
                row.setSraRavId( nxtRavVal ); 
                row.setRavId( nxtRavVal );
            } catch ( SQLException e) {
                e.printStackTrace();
            }
        }
        row.setSraColor( srcAns.getSraColor() );
        row.setSraComment( srcAns.getSraComment() );
        
        if ( srcAns.getRavRasId() != null && srcAns.getRavRasId().intValue() != 0) {
            row.setRavRasId( srcAns.getRavRasId() );
        } else {
            Sequence rasSeq = new Sequence( "BAwaWEb_RAS_SEQ", module);
            
            try {
                row.setRavRasId( new Number( rasSeq.getData().toString() ));
            } catch ( SQLException e) {
                e.printStackTrace();
            }
        }
         
        row.setRavAnswer( srcAns.getRavAnswer() );
        
        if ( srcAns.getRavAsvId() != null && srcAns.getRavAsvId().intValue() != 0) {
            row.setRavAsvId( srcAns.getRavAsvId() );
        } else {
            Sequence asvSeq = new Sequence( "BAwaWEb_ASV_SEQ", module);
            
            try {
                row.setRavAsvId( new Number( asvSeq.getData().toString() ));
            } catch ( SQLException e) {
                e.printStackTrace();
            }
        }
        
        row.setRavDisplaySeq( srcAns.getRavDisplaySeq() );
        row.setRavDeleteYn( srcAns.getRavDeleteYN() );
        return row;
    }

    public static void main(String[] args) {
        SourcesSingleQuestionAnswersVO sourcesSingleQuestionAnswersVO = new SourcesSingleQuestionAnswersVO();
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
}
