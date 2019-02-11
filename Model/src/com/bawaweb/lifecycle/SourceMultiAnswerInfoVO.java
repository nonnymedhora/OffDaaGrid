/**
 * @author Nonny Medhora
 */
package com.bawaweb.lifecycle;

import com.bawaweb.grid.templates.data.cursors.SourceAnswersDataSet;
import com.bawaweb.grid.templates.data.cursors.SourceAnswersDataSetInfo;
import com.bawaweb.grid.templates.data.cursors.SourceMultiAnswersDataSet;
import com.bawaweb.grid.templates.data.cursors.SourceMultiAnswersDataSetInfo;
import com.bawaweb.views.gridcursors.common.SourceMultiAnswerSets;
import com.bawaweb.views.gridcursors.common.SourceMultiAnswerSetsRow;

import java.sql.SQLException;

import oracle.jbo.ApplicationModule;
import oracle.jbo.domain.Number;
import oracle.jbo.domain.Sequence;

public class SourceMultiAnswerInfoVO {

    private Number sraRpsId;
    private Number qmqId;
    private String qmqNumber;
    private String qmqType;
    private Number qmqQstId;
    private String answer;
    private String sraAnswerText;
    private String sraColor;
    private String sraComment;
    private String qstType;    
    private Number ravId;             // xtra for bawaweb_report_answer_set_values rav
    private Number sraId;              // xtra for bawaweb_source_answers sra
    private Number smaSraId;         // xtra for bawaweb_source_multi_answers???
    
    
    
    public SourceMultiAnswerInfoVO() {
    }


    public Object getAttribute(String attribute) {
        if (attribute.equalsIgnoreCase("sraRpsId")) {
            return this.sraRpsId;
        }
        if (attribute.equalsIgnoreCase("qmqId")) {
            return this.qmqId;
        }
        if (attribute.equalsIgnoreCase("qmqNumber")) {
            return this.qmqNumber;
        }
        if (attribute.equalsIgnoreCase("qmqType")) {
            return this.qmqType;
        }
        if (attribute.equalsIgnoreCase("sraAnswerText")) {
            return this.sraAnswerText;
        }
        if (attribute.equalsIgnoreCase("answer")) {
            return this.answer;
        }
        if (attribute.equalsIgnoreCase("sraColor")) {
            return this.sraColor;
        }
        if (attribute.equalsIgnoreCase("sraComment")) {
            return this.sraComment;
        }
        if (attribute.equalsIgnoreCase("qstType")) {
            return this.qstType;
        }
        if (attribute.equalsIgnoreCase("ravId")) {
            return this.ravId;
        }
        if (attribute.equalsIgnoreCase("sraId")) {
            return this.sraId;
        }
        if (attribute.equalsIgnoreCase("smaSraId")) {
            return this.smaSraId;
        }
        if (attribute.equalsIgnoreCase("qmqQstId")) {
            return this.qmqQstId;
        }
        return null;
    }
    
    
    public SourceMultiAnswerInfoVO transform(SourceMultiAnswerSetsRow row) {
        SourceMultiAnswerInfoVO ans = new SourceMultiAnswerInfoVO();
        
        ans.setSraRpsId( row.getSraRpsId() );
        ans.setQmqId( row.getQmqId() );
        ans.setQmqNumber( row.getQmqNumber() );
        ans.setQmqType( row.getQmqType() );
        ans.setAnswer( row.getAnswer() );
        ans.setSraAnswerText( row.getSraAnswerText() );
        ans.setSraColor( row.getSraColor() );
        ans.setSraComment( row.getSraComment() );
        ans.setQstType( row.getQstType());
        ans.setQmqQstId( row.getQmqQstId() );
        ans.setRavId( row.getRavId() );
        ans.setSmaSraId( row.getSmaSraId() );
        ans.setSraId( row.getSraId() );
        return ans;
    }
    
    
    public SourceMultiAnswerSetsRow transform(SourceMultiAnswerSets view, SourceMultiAnswerInfoVO ans, ApplicationModule am) {
        SourceMultiAnswerSetsRow row = (SourceMultiAnswerSetsRow) view.createRow();
        
        row.setSraRpsId( ans.getSraRpsId() );
        row.setQmqId( ans.getQmqId() );
        row.setQmqNumber( ans.getQmqNumber() );
        row.setQmqType( ans.getQmqType() );
        row.setAnswer( ans.getAnswer() );
        row.setSraAnswerText( ans.getSraAnswerText() );
        row.setSraColor( ans.getSraColor() );
        row.setSraComment( ans.getSraComment() );
        row.setQstType( ans.getQstType() );
        row.setQmqQstId( ans.getQmqQstId() );
        
        if ( ans.getRavId() != null ) {
            row.setRavId( ans.getRavId() );
        } else {
            Sequence ravSeq = new Sequence("BAwaWEb_RAV_SEQ", am);            
            try {
                row.setRavId( new Number( ravSeq.getData().toString()));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
        }
        
        if ( ans.getSmaSraId() != null ) {
            row.setSmaSraId( ans.getSmaSraId() );
        } else {
            // no seq for sma sra ???
            Sequence smaSraSeq = new Sequence("BAwaWEb_SEQ", am);
            try {
                row.setRavId( new Number( smaSraSeq.getData().toString()));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        if ( ans.getSraId() != null ) {
            row.setSraId( ans.getSraId() );
        } else {
            Sequence sraSeq = new Sequence("BAwaWEb_SRA_SEQ", am);
            
            try {
                row.setSraId( new Number( sraSeq.getData().toString()));                
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return row;
    }
    
    
    public SourceAnswersDataSetInfo transform(SourceMultiAnswerInfoVO ans) {
        SourceAnswersDataSetInfo srcAns = new SourceAnswersDataSet();
        
        if (ans.getSraRpsId() != null ) srcAns.setRps_id( ans.getSraRpsId().intValue());
        
        if ( ans.getQmqId() != null )                   srcAns.setQmq_id( ans.getQmqId().intValue() );  //srcAns.setQst_id( ans.getQmqId().intValue() );
        srcAns.setQmq_number( ans.getQmqNumber() );
        srcAns.setAnswer( ans.getAnswer() );
        srcAns.setSra_answer_text( ans.getSraAnswerText() );
        srcAns.setSra_color( ans.getSraColor() );
        srcAns.setSra_comment( ans.getSraComment() );
        srcAns.setQst_type( ans.getQstType() );//( "MULTI" );
        srcAns.setQmq_Qst_Type( ans.getQmqType() );
        srcAns.setQmq_Qst_Id( ans.getQmqQstId().intValue() );
        
        if ( ans.getRavId() != null ) srcAns.setRav_Id( ans.getRavId().intValue() );
        if ( ans.getSraId() != null ) srcAns.setSra_Id( ans.getSraId().intValue() );
        if ( ans.getSmaSraId() != null )  srcAns.setSma_sra_id( ans.getSmaSraId().intValue() );
        return srcAns;
    }
  /*  
    public SourceMultiAnswersDataSetInfo transform(SourceMultiAnswerInfo ans) {
        SourceMultiAnswersDataSetInfo srcMAns = new SourceMultiAnswersDataSet();
        if ( ans.getSraRpsId() != null )                srcMAns.setSra_rps_id(ans.getSraRpsId().intValue());
        if ( ans.getQmqId() != null )                   srcMAns.setQmq_id( ans.getQmqId().intValue() );
        srcMAns.setQmq_number( ans.getQmqNumber() );
        srcMAns.setAnswer( ans.getAnswer() );
        srcMAns.setSra_answer_text( ans.getSraAnswerText() );
        srcMAns.setSra_color( ans.getSraColor() );
        srcMAns.setSra_comment( ans.getSraComment() );
        srcMAns.setQmq_type( ans.getQmqType() );
        return srcMAns;
    }
*/

    public static void main(String[] args) {
        SourceMultiAnswerInfoVO sourceMultiAnswerInfo = new SourceMultiAnswerInfoVO();
    }
    
    public Number getRavId () {
        return this.ravId;
    }
    
    public void setRavId(Number id) {
        this.ravId = id;
    }
    public Number getSraId () {
        return this.sraId;
    }
    
    public void setSraId(Number id) {
        this.sraId = id;
    }
    

    
    public Number getSmaSraId() {
        return this.smaSraId;
    }
    
    public void setSmaSraId(Number id) {
        this.smaSraId = id;
    }
    


    public void setSraRpsId(Number sraRpsId) {
        this.sraRpsId = sraRpsId;
    }

    public Number getSraRpsId() {
        return sraRpsId;
    }

    public void setQmqId(Number qmqId) {
        this.qmqId = qmqId;
    }

    public Number getQmqId() {
        return qmqId;
    }

    public void setQmqNumber(String qmqNumber) {
        this.qmqNumber = qmqNumber;
    }

    public String getQmqNumber() {
        return qmqNumber;
    }

    public void setQmqType(String qmqType) {
        this.qmqType = qmqType;
    }

    public String getQmqType() {
        return qmqType;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setSraAnswerText(String sraAnswerText) {
        this.sraAnswerText = sraAnswerText;
    }

    public String getSraAnswerText() {
        return sraAnswerText;
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

    public void setQstType(String qstType) {
        this.qstType = qstType;
    }

    public String getQstType() {
        return qstType;
    }

    public void setQmqQstId(Number qmqQstId) {
        this.qmqQstId = qmqQstId;
    }

    public Number getQmqQstId() {
        return qmqQstId;
    }
}
