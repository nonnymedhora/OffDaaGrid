/**
 * @author Nonny Medhora
 */
package com.bawaweb.lifecycle;


import com.bawaweb.grid.templates.data.tables.AnswerSetValuesDataSet;
import com.bawaweb.grid.templates.data.tables.AnswerSetValuesDataSetInfo;
import com.bawaweb.grid.templates.data.tables.ReportAnswerSetValuesDataSet;
import com.bawaweb.grid.templates.data.tables.ReportAnswerSetValuesDataSetInfo;
import com.bawaweb.views.gridcursors.common.MultiAnswerSetsRow;
import com.bawaweb.views.gridcursors.common.SingleAnswerSets;
import com.bawaweb.views.gridcursors.common.SingleAnswerSetsRow;

import oracle.jbo.domain.Number;


public class SingleAnswerSetInfoVO {

    private Number ravId;
    private Number ravRasId;
    private Number ravAsvId;
    private String ravAnswer;
    private Number ravDisplaySeq;
    private String ravDeleteYn;
    
    private Number ansId;

    public SingleAnswerSetInfoVO() {
    }
    
    public Object getAttribute(String attribute) {
        if ( attribute.equalsIgnoreCase( "ravId" ))         return ravId;
        if ( attribute.equalsIgnoreCase( "ravRasId" ))      return ravRasId;
        if ( attribute.equalsIgnoreCase( "ravAsvId" ))      return ravAsvId;
        if ( attribute.equalsIgnoreCase( "ravAnswer" ))     return ravAnswer;
        if ( attribute.equalsIgnoreCase( "ravDisplaySeq" )) return ravDisplaySeq;
        if ( attribute.equalsIgnoreCase( "ravDeleteYn" ))   return ravDeleteYn;
        if ( attribute.equalsIgnoreCase( "ansId" ))   return ansId;
        
        return null;        
    }
    
    public SingleAnswerSetInfoVO transform(SingleAnswerSetsRow row) {
        SingleAnswerSetInfoVO ans = new SingleAnswerSetInfoVO();
        
        ans.setRavId( row.getRavId() );
        ans.setRavAsvId( row.getRavAsvId());
        ans.setRavAnswer( row.getRavAnswer() );
        ans.setRavDisplaySeq( row.getRavDisplaySeq() );
        ans.setRavDeleteYn( row.getRavDeleteYn() );
        ans.setRavRasId( row.getRavRasId() );
        ans.setAnsId( row.getAnsId() );
        
        return ans;
    }
    
    public SingleAnswerSetInfoVO transform(MultiAnswerSetsRow row) {
        SingleAnswerSetInfoVO ans = new SingleAnswerSetInfoVO();
        
        ans.setRavId( row.getRavId() );
        ans.setRavAsvId( row.getRavAsvId() );
        ans.setRavAnswer( row.getRavAnswer() );
        ans.setRavDisplaySeq( row.getRavDisplaySeq() );
        ans.setRavDeleteYn( row.getRavDeleteYn() );
        ans.setRavRasId( row.getRavRasId() );
        ans.setAnsId( row.getAnsId() );
        
        return ans;
    }
    
    public SingleAnswerSetsRow transform(SingleAnswerSets view, SingleAnswerSetInfoVO ans) {
        SingleAnswerSetsRow row = (SingleAnswerSetsRow) view.createRow();
        
        row.setRavId( ans.getRavId() );
        row.setRavAsvId( ans.getRavAsvId() );
        row.setRavAnswer( ans.getRavAnswer() );
        row.setRavDisplaySeq( ans.getRavDisplaySeq() );
        row.setRavDeleteYn( ans.getRavDeleteYn() );
        row.setRavRasId( ans.getRavRasId() );
        row.setAnsId( ans.getAnsId() );
        
        return row;
    }
    
    public ReportAnswerSetValuesDataSetInfo transform(SingleAnswerSetInfoVO info) {
        ReportAnswerSetValuesDataSetInfo ans = new ReportAnswerSetValuesDataSet();
        
        if ( info.getRavId() != null )                   ans.setRav_id( info.getRavId().intValue() );
        if ( info.getRavAsvId() != null )                ans.setRav_asv_id( info.getRavAsvId().intValue() );
        ans.setRav_answer( info.getRavAnswer() );
        if ( info.getRavDisplaySeq() != null )           ans.setRav_display_seq( info.getRavDisplaySeq().intValue() );
        ans.setRav_delete_yn( info.getRavDeleteYn() );
        if ( info.getRavRasId() != null )                ans.setRav_ras_id( info.getRavRasId().intValue() );
        
        if ( info.getAnsId() != null )                ans.setAns_id( info.getAnsId().intValue() );
        return ans;
    }
    

    public static void main(String[] args) {
        SingleAnswerSetInfoVO singleAnswersInfo = new SingleAnswerSetInfoVO();
    }

    public void setRavId(Number asvId) {
        this.ravId = asvId;
    }

    public Number getRavId() {
        return ravId;
    }

    public void setRavAsvId(Number asvAnsId) {
        this.ravAsvId = asvAnsId;
    }

    public Number getRavAsvId() {
        return ravAsvId;
    }

    public void setRavAnswer(String asvAnswer) {
        this.ravAnswer = asvAnswer;
    }

    public String getRavAnswer() {
        return ravAnswer;
    }

    public void setRavDisplaySeq(Number asvDisplaySeq) {
        this.ravDisplaySeq = asvDisplaySeq;
    }

    public Number getRavDisplaySeq() {
        return ravDisplaySeq;
    }

    public void setRavDeleteYn(String asvDeleteYn) {
        this.ravDeleteYn = asvDeleteYn;
    }

    public String getRavDeleteYn() {
        return ravDeleteYn;
    }

    public void setRavRasId(Number ravRasId) {
        this.ravRasId = ravRasId;
    }

    public Number getRavRasId() {
        return ravRasId;
    }

    public void setAnsId(Number ansId) {
        this.ansId = ansId;
    }

    public Number getAnsId() {
        return ansId;
    }
}
