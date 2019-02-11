/**
 * @author Nonny Medhora
 */
package com.bawaweb.lifecycle;

import com.bawaweb.grid.templates.data.cursors.SourceAnswersDataSet;
import com.bawaweb.grid.templates.data.cursors.SourceAnswersDataSetInfo;
import com.bawaweb.services.PlatformAppModuleServiceImpl;
import com.bawaweb.views.gridcursors.common.SourceMultiAnswerSetsRow;
import com.bawaweb.views.gridcursors.common.SourcesAnswerSets;

import com.bawaweb.views.gridcursors.common.SourcesAnswerSetsRow;

import com.bawaweb.views.gridcursors.common.SourcesSortingCriteriaSetsRow;

import com.bawaweb.views.gridcursors.views.common.SourcesAnswerSetsView;
import com.bawaweb.views.gridcursors.views.common.SourcesAnswerSetsViewRow;

import java.sql.SQLException;

import oracle.jbo.ApplicationModule;
import oracle.jbo.domain.Number;
import oracle.jbo.domain.Sequence;

/**
 * Lifecycle Object for com.bawaweb.views.gridcursors.common.SourcesAnswerSets, com.bawaweb.views.gridcursors.common.SourceMultiAnswerSetsRow
 * 
 * 
 * 
 * 
 */
public class SourcesAnswerInfoVO {
    public SourcesAnswerInfoVO() {
    }
    // bawaweb_source_answers
    /**
     * NUMBER	SRA_ID
NUMBER	SRA_QST_ID
NUMBER	SRA_RPS_ID
VARCHAR2	SRA_ANSWER
VARCHAR2	SRA_ANSWER_TEXT
NUMBER	SRA_ASV_ID
VARCHAR2	SRA_EXCLUDE_YN
NUMBER	SRA_WEIGHT_MULTIPLIER
NUMBER	SRA_RAV_ID
VARCHAR2	SRA_COLOR
VARCHAR2	SRA_COMMENT

     */
    private Number sraId;       // xtra for bawaweb_source_answers sra
    private String answer;          // for sra_answer
    private String sraAnswerText;
    private String sraColor;
    private String sraComment;
    private Number sraRpsId;
    private Number sraQstId;
    private String sraExcludeYN;
    public Number sraWeightMultiplier;
    private Number asvId;
    
    private Number ravId;       // xtra for bawaweb_report_answer_set_values rav 
    
    
    private Number qstId;
    private String qmqNumber;      // for multi if it exists
    private Number qmqQstId;       // ""
    private String qstType;          // for q_type
    private String scvName;
    private String qmqQstType;
    private Number qmqId;
    private Number srcId;             // bawaweb_sources
    
    private Number smaSraId;         // xtra for bawaweb_source_multi_answers???
    private Number scvId;             // extra for sourcesortingcriteriasets
    private Number emplId;
    public Number rprtId;
    public Number ravDisplaySeq;
    public String ravDeleteYN;
    
    public Object getAttribute(String attribute) {
        if ( attribute.equalsIgnoreCase( "answer") ) return answer;
        if ( attribute.equalsIgnoreCase( "sraAnswerText") ) return sraAnswerText;
        if ( attribute.equalsIgnoreCase( "sraColor") ) return sraColor;
        if ( attribute.equalsIgnoreCase( "sraComment") ) return sraComment;
        if ( attribute.equalsIgnoreCase( "sraRpsId") ) return sraRpsId;
        if ( attribute.equalsIgnoreCase( "sraQstId") ) return sraQstId;
        if ( attribute.equalsIgnoreCase( "ravId") ) return ravId;
        if ( attribute.equalsIgnoreCase( "sraId") ) return sraId;
        if ( attribute.equalsIgnoreCase( "qmqNumber") ) return qmqNumber;
        if ( attribute.equalsIgnoreCase( "qstType") ) return qstType;
        if ( attribute.equalsIgnoreCase( "scvName") ) return scvName;
        if ( attribute.equalsIgnoreCase( "qmqQstType") ) return qmqQstType;
        if ( attribute.equalsIgnoreCase( "smaSraId") ) return smaSraId;
        if ( attribute.equalsIgnoreCase( "scvId") ) return scvId;
        if ( attribute.equalsIgnoreCase( "srcId") ) return srcId;
        if ( attribute.equalsIgnoreCase( "qmqId") ) return qmqId;
        if ( attribute.equalsIgnoreCase( "qstId") ) return qstId;
        if ( attribute.equalsIgnoreCase( "asvId") ) return asvId;
        if ( attribute.equalsIgnoreCase( "ravDisplaySeq") ) return ravDisplaySeq;
        if ( attribute.equalsIgnoreCase( "ravDeleteYN") ) return ravDeleteYN;
        if ( attribute.equalsIgnoreCase( "sraExcludeYN") ) return sraExcludeYN;
        if ( attribute.equalsIgnoreCase( "sraWeightMultiplier") ) return sraWeightMultiplier;
        if ( attribute.equalsIgnoreCase( "emplId") ) return emplId;
        if ( attribute.equalsIgnoreCase("rprtId") ) return rprtId; 
        
        return null;
    }
    
    public SourcesAnswerInfoVO transform(SourcesAnswerSetsViewRow row) {
        SourcesAnswerInfoVO srcAns = new SourcesAnswerInfoVO();
        
        if ( row.getSraRpsId() != null )    srcAns.setSraRpsId( row.getSraRpsId() );
        if ( row.getSraQstId() != null )    srcAns.setSraQstId( row.getSraQstId() );
        srcAns.setAnswer( row.getAnswer() );
        srcAns.setSraAnswerText( row.getSraAnswerText() );
        srcAns.setSraColor( row.getSraColor() );
        srcAns.setSraComment( row.getSraComment() );
        srcAns.setQstType( row.getQstType());
        if ( row.getRavId() != null)        srcAns.setRavId( row.getRavId() );
        if ( row.getSraId() != null )       srcAns.setSraId( row.getSraId() );
        if ( row.getRavAsvId() != null )    srcAns.setAsvId( row.getRavAsvId() );
        if ( row.getRavDisplaySeq() != null ) srcAns.setRavDisplaySeq( row.getRavDisplaySeq() );
        if ( row.getRavDeleteYn() != null ) srcAns.setRavDeleteYN( row.getRavDeleteYn() );
        srcAns.setSraExcludeYN( row.getSraExcludeYn());
        srcAns.setSraWeightMultiplier( row.getSraWeightMultiplier() );
        return srcAns;
    }
    
    
    public SourcesAnswerInfoVO transform(SourcesAnswerSetsRow row) {
        SourcesAnswerInfoVO srcAns = new SourcesAnswerInfoVO();
        
        if ( row.getSraRpsId() != null )    srcAns.setSraRpsId( row.getSraRpsId() );
        if ( row.getSraQstId() != null )    srcAns.setSraQstId( row.getSraQstId() );
        srcAns.setAnswer( row.getAnswer() );
        srcAns.setSraAnswerText( row.getSraAnswerText() );
        srcAns.setSraColor( row.getSraColor() );
        srcAns.setSraComment( row.getSraComment() );
        srcAns.setQstType( row.getQstType());
        if ( row.getRavId() != null)        srcAns.setRavId( row.getRavId() );
        if ( row.getSraId() != null )       srcAns.setSraId( row.getSraId() );
        if ( row.getRavAsvId() != null )    srcAns.setAsvId( row.getRavAsvId() );
        if ( row.getRavDisplaySeq() != null ) srcAns.setRavDisplaySeq( row.getRavDisplaySeq() );
        if ( row.getRavDeleteYn() != null ) srcAns.setRavDeleteYN( row.getRavDeleteYn() );
        srcAns.setSraExcludeYN( row.getSraExcludeYn());
        srcAns.setSraWeightMultiplier( row.getSraWeightMultiplier() );
        return srcAns;
    }
    /*
    public SourcesAnswerInfo transform(SourceMultiAnswerSetsRow row) {
        SourcesAnswerInfo srcAns = new SourcesAnswerInfo();
        
        if ( row.getSraRpsId() != null )    srcAns.setSraRpsId( row.getSraRpsId() );
        if ( row.getQmqId() != null )    srcAns.setSraQstId( row.getQmqId() );
        srcAns.setAnswer( row.getAnswer() );
        srcAns.setSraAnswerText( row.getSraAnswerText() );
        srcAns.setSraColor( row.getSraColor() );
        srcAns.setSraComment( row.getSraComment() );
        
        return srcAns;
    }*/
    
    
    public SourceAnswersDataSetInfo transform(SourcesSortingCriteriaSetsRow row ) {
        SourceAnswersDataSetInfo srcAnsInfo = new SourceAnswersDataSet();
        srcAnsInfo.setQst_id( row.getQstId().intValue()   );
        if ( row.getScvId() != null )               srcAnsInfo.setScv_Id(row.getScvId().intValue());
        if ( row.getSscRpsId() != null )            srcAnsInfo.setRps_id(row.getSscRpsId().intValue());
        srcAnsInfo.setScv_name( row.getScvName() );
        srcAnsInfo.setQst_type("SORT");
System.out.println("transform sort \n" + srcAnsInfo);        
        return srcAnsInfo;
    }
    
    public SourcesAnswerSetsViewRow transform(SourcesAnswerSetsView view, SourcesAnswerInfoVO srcAns, ApplicationModule appModule) {
        if ( srcAns == null ) { System.out.println( "srcAns is null"); return null; }
        
        SourcesAnswerSetsViewRow row = (SourcesAnswerSetsViewRow) view.createRow();
        System.out.println( "srcAns.getSraRpsId() is " +  srcAns.getSraRpsId()  );
        System.out.println( "srcAns.getRavId() is " +  srcAns.getRavId()  );
        if ( srcAns.getRavId() != null  && srcAns.getRavId().intValue() != 0 ) {
            
        System.out.println( " in if --- srcAns.getRavId() is " +  srcAns.getRavId()  );
            row.setRavId( srcAns.getRavId() );
        } else {
        System.out.println( " in else --- srcAns.getRavId() is " +  srcAns.getRavId()  );
            Sequence ravSeq = new Sequence("BAwaWEb_RAV_SEQ", appModule);
        System.out.println( " ravSeq.getValue() " + ravSeq.getValue());
            System.out.println( " ravSeq.getData() " + ravSeq.getData());
            try {
                row.setRavId(  new Number( ravSeq.getData().toString() )  );
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if ( srcAns.getSraId() != null  && srcAns.getSraId().intValue() != 0  ) {
            row.setSraId( srcAns.getSraId() );
        } else {
            Sequence sraSeq = new Sequence("BAwaWEb_SRA_SEQ", appModule);
            
            try {
                row.setSraId( new Number( sraSeq.getData().toString()));                
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
         
        if ( srcAns.getSraRpsId() != null )    row.setSraRpsId( srcAns.getSraRpsId() );
        if ( srcAns.getSraQstId() != null )    row.setSraQstId( srcAns.getSraQstId() );
        row.setAnswer( srcAns.getAnswer() );
        row.setSraAnswerText( srcAns.getSraAnswerText() );
        row.setSraColor( srcAns.getSraColor() );
        row.setSraComment( srcAns.getSraComment() ); 
        
        if ( srcAns.getAsvId() != null && srcAns.getAsvId().intValue() != 0 ) {
            row.setRavAsvId( srcAns.getAsvId() );
        }
        
        row.setSraExcludeYn( srcAns.getSraExcludeYN() );
        row.setRavDeleteYn( srcAns.getRavDeleteYN() );
        row.setRavDisplaySeq( srcAns.getRavDisplaySeq() );
        System.out.println("row.getRavId() is " + row.getRavId());
        row.setSraWeightMultiplier( srcAns.getSraWeightMultiplier() );
        return row;
    }
    
    
    public SourcesAnswerSetsRow transform(SourcesAnswerSets view, SourcesAnswerInfoVO srcAns, ApplicationModule appModule) {
        if ( srcAns == null ) { System.out.println( "srcAns is null"); return null; }
        
        SourcesAnswerSetsRow row = (SourcesAnswerSetsRow) view.createRow();
System.out.println( "srcAns.getSraRpsId() is " +  srcAns.getSraRpsId()  );        
System.out.println( "srcAns.getRavId() is " +  srcAns.getRavId()  );                 
        if ( srcAns.getRavId() != null  && srcAns.getRavId().intValue() != 0 ) {
            
System.out.println( " in if --- srcAns.getRavId() is " +  srcAns.getRavId()  );        
            row.setRavId( srcAns.getRavId() );
        } else {
System.out.println( " in else --- srcAns.getRavId() is " +  srcAns.getRavId()  );        
            Sequence ravSeq = new Sequence("BAwaWEb_RAV_SEQ", appModule);
System.out.println( " ravSeq.getValue() " + ravSeq.getValue());
            System.out.println( " ravSeq.getData() " + ravSeq.getData());
            try {
                row.setRavId(  new Number( ravSeq.getData().toString() )  );
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if ( srcAns.getSraId() != null  && srcAns.getSraId().intValue() != 0  ) {
            row.setSraId( srcAns.getSraId() );
        } else {
            Sequence sraSeq = new Sequence("BAwaWEb_SRA_SEQ", appModule);
            
            try {
                row.setSraId( new Number( sraSeq.getData().toString()));                
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
         
        if ( srcAns.getSraRpsId() != null )    row.setSraRpsId( srcAns.getSraRpsId() );
        if ( srcAns.getSraQstId() != null )    row.setSraQstId( srcAns.getSraQstId() );
        row.setAnswer( srcAns.getAnswer() );
        row.setSraAnswerText( srcAns.getSraAnswerText() );
        row.setSraColor( srcAns.getSraColor() );
        row.setSraComment( srcAns.getSraComment() ); 
        
        if ( srcAns.getAsvId() != null && srcAns.getAsvId().intValue() != 0 ) {
            row.setRavAsvId( srcAns.getAsvId() );
        }
        
        row.setSraExcludeYn( srcAns.getSraExcludeYN() );
        row.setRavDeleteYn( srcAns.getRavDeleteYN() );
        row.setRavDisplaySeq( srcAns.getRavDisplaySeq() );
System.out.println("row.getRavId() is " + row.getRavId());
        row.setSraWeightMultiplier( srcAns.getSraWeightMultiplier() );
        return row;
    }
    
    
    public SourceAnswersDataSetInfo transform(SourcesAnswerInfoVO srcAns) {
        SourceAnswersDataSetInfo srcAnsInfo = new SourceAnswersDataSet();
        
        if ( srcAns.getSraRpsId() != null )    srcAnsInfo.setRps_id( srcAns.getSraRpsId().intValue() );
        if ( srcAns.getSraQstId() != null )    srcAnsInfo.setQst_id( srcAns.getSraQstId().intValue() );
        srcAnsInfo.setQst_type( srcAns.getQstType() ); 
        srcAnsInfo.setAnswer( srcAns.getAnswer() );
        srcAnsInfo.setSra_answer_text( srcAns.getSraAnswerText() );
        srcAnsInfo.setSra_color( srcAns.getSraColor() );
        srcAnsInfo.setSra_comment( srcAns.getSraComment() );
        srcAnsInfo.setQmq_Qst_Type( srcAns.getQmqQstType() );
        srcAnsInfo.setQmq_number( srcAns.getQmqNumber() );
        if ( srcAns.getRavId() != null )        srcAnsInfo.setRav_Id( srcAns.getRavId().intValue() );
        if ( srcAns.getSraId() != null )        srcAnsInfo.setSra_Id( srcAns.getSraId().intValue() );
        if ( srcAns.getSraWeightMultiplier() != null ) srcAnsInfo.setSraWeightMultiplier( srcAns.getSraWeightMultiplier().doubleValue());
        return srcAnsInfo;
    }
    
    public SourceAnswersDataSetInfo transform(SourceMultiAnswerSetsRow srcAns) {
        SourceAnswersDataSetInfo srcAnsInfo = new SourceAnswersDataSet();
        
        if ( srcAns.getSraRpsId() != null )                         srcAnsInfo.setRps_id( srcAns.getSraRpsId().intValue() );
        if ( srcAns.getQmqId() != null )                            srcAnsInfo.setQmq_id( srcAns.getQmqId().intValue());
        if ( srcAns.getQmqQstId() != null )                         srcAnsInfo.setQmq_Qst_Id( srcAns.getQmqQstId().intValue());
        if ( srcAns.getQmqQstId() != null )                         srcAnsInfo.setQst_id( srcAns.getQmqQstId().intValue());
        srcAnsInfo.setQmq_number( srcAns.getQmqNumber() );
        srcAnsInfo.setAnswer( srcAns.getAnswer() );
        srcAnsInfo.setSra_answer_text( srcAns.getSraAnswerText() );
        srcAnsInfo.setSra_color( srcAns.getSraColor() );
        srcAnsInfo.setSra_comment( srcAns.getSraComment() );
System.out.println("srcAns.getQmqType() " + srcAns.getQmqType());
        srcAnsInfo.setQmq_Qst_Type( srcAns.getQmqType() );
System.out.println("srcAns.getQstType() " + srcAns.getQstType());        
        srcAnsInfo.setQst_type( srcAns.getQstType() );        
        if ( srcAns.getRavId() != null )        srcAnsInfo.setRav_Id( srcAns.getRavId().intValue() );
        if ( srcAns.getSmaSraId() != null )        srcAnsInfo.setSma_sra_id( srcAns.getSmaSraId().intValue() );
        if ( srcAns.getSraId() != null )        srcAnsInfo.setSra_Id( srcAns.getSraId().intValue() );
       
        return srcAnsInfo;
    }
    
    
    public SourcesAnswerInfoVO transform(SourceAnswersDataSetInfo srcAns ) { //, ApplicationModule appModule) {
        SourcesAnswerInfoVO srcAnsInfo = new SourcesAnswerInfoVO();
        
        if ( srcAns.getRps_id() != 0 ) srcAnsInfo.setSraRpsId( new Number( srcAns.getRps_id() ) );
        srcAnsInfo.setQstType( srcAns.getQst_type() ); 
        if ( srcAns.getQst_id() != 0 ) srcAnsInfo.setSraQstId( new Number( srcAns.getQst_id() ) );
        srcAnsInfo.setAnswer( srcAns.getAnswer() );
        srcAnsInfo.setSraAnswerText( srcAns.getSra_Answer_text() );
        srcAnsInfo.setSraColor( srcAns.getSra_color() );
        srcAnsInfo.setSraComment( srcAns.getSra_comment() );
        
        
        if ( srcAns.getRav_Id() != 0 ) srcAnsInfo.setRavId( new Number( srcAns.getRav_Id() ) );
        else {
            Sequence ravSeq = new Sequence("BAwaWEb_RAV_SEQ", PlatformAppModuleServiceImpl.getInstance().getPlatform());
            try {
                srcAnsInfo.setRavId( new Number( ravSeq.getData().toString() ) );
            } catch ( SQLException q) {
                q.printStackTrace();
            }
        }
        if ( srcAns.getSra_Id() != 0 ) srcAnsInfo.setSraId( new Number( srcAns.getSra_Id() ) );
        else {
            Sequence sraSeq = new Sequence( "BAwaWEb_SRA_SEQ", PlatformAppModuleServiceImpl.getInstance().getPlatform());
            try {
                srcAnsInfo.setSraId( new Number( sraSeq.getData().toString() ) ); 
            } catch ( SQLException q) {
                q.printStackTrace();
            }
        }
        
        if ( srcAns.getQmq_Qst_Type() != null ) srcAnsInfo.setQmqQstType( srcAns.getQmq_Qst_Type() );
        if ( srcAns.getQmq_id() != 0 ) srcAnsInfo.setQmqId( new Number( srcAns.getQmq_id() ) );
        if ( srcAns.getQmq_number() != null ) srcAnsInfo.setQmqNumber( srcAns.getQmq_number() );
        if ( srcAns.getQmq_Qst_Id() != 0 ) srcAnsInfo.setQmqQstId( new Number( srcAns.getQmq_Qst_Id() ) );
        if ( srcAns.getSma_sra_id() != 0 ) srcAnsInfo.setSmaSraId( new Number( srcAns.getSma_sra_id() ) );
        
        if ( srcAns.getScv_name() != null ) srcAnsInfo.setScvName( srcAns.getScv_name() );
        if ( srcAns.getScv_Id() != 0 ) srcAnsInfo.setScvId( new Number( srcAns.getScv_Id() ) );
        else {
            Sequence scvSeq = new Sequence( "BAwaWEb_SCV_SEQ", PlatformAppModuleServiceImpl.getInstance().getPlatform());
            try {
                srcAnsInfo.setScvId( new Number( scvSeq.getData().toString() ) ); 
            } catch ( SQLException q) {
                q.printStackTrace();
            }
        }
        if ( srcAns.getSrc_id() != 0 ) srcAnsInfo.setSrcId( new Number( srcAns.getSrc_id() ));
        if ( srcAnsInfo.getEmplId() != null )   srcAnsInfo.setEmplId( new Number( srcAns.getEmpl_Id() ));
        
        
        return srcAnsInfo;
    }

    public static void main(String[] args) {
        SourcesAnswerInfoVO sourceAnswerInfo = new SourcesAnswerInfoVO();
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

    public void setSraRpsId(Number sraRpsId) {
        this.sraRpsId = sraRpsId;
    }

    public Number getSraRpsId() {
        return sraRpsId;
    }

    public void setSraQstId(Number sraQstId) {
        this.sraQstId = sraQstId;
    }

    public Number getSraQstId() {
        return sraQstId;
    }
/*
    public void setQmq_number(String qmq_number) {
        this.qmq_number = qmq_number;
    }

    public String getQmq_number() {
        return qmq_number;
    }

    public void setQst_type(String qst_type) {
        this.qst_type = qst_type;
    }

    public String getQst_type() {
        return qst_type;
    }

    public void setScv_name(String scv_name) {
        this.scv_name = scv_name;
    }

    public String getScv_name() {
        return scv_name;
    }

    public void setQmq_qst_type(String qmq_qst_type) {
        this.qmq_qst_type = qmq_qst_type;
    }

    public String getQmq_qst_type() {
        return qmq_qst_type;
    }*/

    public void setRavId(Number ravId) {
        this.ravId = ravId;
    }

    public Number getRavId() {
        return ravId;
    }

    public void setSraId(Number sraId) {
        this.sraId = sraId;
    }

    public Number getSraId() {
        return sraId;
    }
    
    
    public String toString() {
        StringBuffer buff = new StringBuffer(this.getClass().getName()+ "\n");
        java.lang.reflect.Field[] fields = this.getClass().getDeclaredFields();
        for ( int i = 0; i < fields.length ; i++) {
            buff.append(fields[i].getName() + " =---=> " + this.getAttribute(fields[i].getName()) + "\n");
        }
        
        return buff.toString();
    }

    public void setQmqNumber(String qmqNumber) {
        this.qmqNumber = qmqNumber;
    }

    public String getQmqNumber() {
        return qmqNumber;
    }

    public void setQstType(String qstType) {
        this.qstType = qstType;
    }

    public String getQstType() {
        return this.qstType;
    }

    public void setScvName(String scvName) {
        this.scvName = scvName;
    }

    public String getScvName() {
        return this.scvName;
    }

    public void setQmqQstType(String qmqQstType) {
        this.qmqQstType = qmqQstType;
    }

    public String getQmqQstType() {
        return this.qmqQstType;
    }
    
    public void setQmqQstId(Number qmqQmqQstId) {
        this.qmqQstId = qmqQmqQstId;
    }

    public Number getQmqQmqQstId() {
        return this.qmqQstId;
    }

    public void setSrcId(Number srcId) {
        this.srcId = srcId;
    }

    public Number getSrcId() {
        return srcId;
    }

    public void setSmaSraId(Number smaSraId) {
        this.smaSraId = smaSraId;
    }

    public Number getSmaSraId() {
        return smaSraId;
    }

    public void setScvId(Number scvId) {
        this.scvId = scvId;
    }

    public Number getScvId() {
        return scvId;
    }

    public void setQmqId(Number qmqId) {
        this.qmqId = qmqId;
    }

    public Number getQmqId() {
        return qmqId;
    }

    public void setQstId(Number qstId) {
        this.qstId = qstId;
    }

    public Number getQstId() {
        return qstId;
    }


    public void setEmplId(Number emplId) {
        this.emplId = emplId;
    }

    public Number getEmplId() {
        return emplId;
    }

    public void setAsvId(Number asvId) {
        this.asvId = asvId;
    }

    public Number getAsvId() {
        return asvId;
    }

    public Number getRavDisplaySeq() {
        return ravDisplaySeq;
    }
    public void setRavDisplaySeq(Number displaySeq) {
        ravDisplaySeq = displaySeq;
    }

    public void setRavDeleteYN(String ravDeleteYN) {
        this.ravDeleteYN = ravDeleteYN;
    }

    public String getRavDeleteYN() {
        return ravDeleteYN;
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

    public void setRprtId(Number rprtId) {
        this.rprtId = rprtId;
    }

    public Number getRprtId() {
        return rprtId;
    }
}
