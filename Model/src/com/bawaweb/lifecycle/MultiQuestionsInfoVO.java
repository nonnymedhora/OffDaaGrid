/**
 * @author Nonny Medhora
 */
package com.bawaweb.lifecycle;

import com.bawaweb.grid.templates.data.cursors.MultiQuestionDataSet;
import com.bawaweb.grid.templates.data.cursors.MultiQuestionDataSetInfo;
import com.bawaweb.grid.templates.data.tables.AnswerSetValuesDataSetInfo;
import com.bawaweb.grid.templates.data.tables.ReportAnswerSetValuesDataSetInfo;
import com.bawaweb.grid.templates.data.tables.TallyRangeLimitsValuesDataSetInfo;
import com.bawaweb.views.gridcursors.common.MultiQuestionsList;
import com.bawaweb.views.gridcursors.common.MultiQuestionsListRow;

import java.util.List;

import oracle.jbo.domain.Number;
public class MultiQuestionsInfoVO {


    private Number qmqId;
    private String qmqNumber;
    private String qmqType;
    private String qmqHint;
    private Number qmqRasId;
    private Number qmqTlyId;
    private Number rasFridId;
    
    
    private String[]                                    dataTallyOptions;
    private List<ReportAnswerSetValuesDataSetInfo>      singleAnswerSetsInfo;
    private List<TallyRangeLimitsValuesDataSetInfo>     tallyRangeLimitsValuesDataSetInfo;
    



    public MultiQuestionsInfoVO() {
    }

    public static void main(String[] args) {
        MultiQuestionsInfoVO multiQuestionsInfo = new MultiQuestionsInfoVO();
    }
    
    
    public Object getAttribute(String attribute) {
        if ( attribute.equalsIgnoreCase( "qmqId" ) ) return qmqId;
        if ( attribute.equalsIgnoreCase( "qmqNumber" ) ) return qmqNumber;
        if ( attribute.equalsIgnoreCase( "qmqType" ) ) return qmqType;
        if ( attribute.equalsIgnoreCase( "qmqHint" ) ) return qmqHint;
        if ( attribute.equalsIgnoreCase( "qmqRasId" ) ) return qmqRasId;
        if ( attribute.equalsIgnoreCase( "qmqTlyId" ) ) return qmqTlyId;
        if ( attribute.equalsIgnoreCase( "rasFridId" ) ) return rasFridId;
        if ( attribute.equalsIgnoreCase( "dataTallyOptions" ) ) return dataTallyOptions;
        if ( attribute.equalsIgnoreCase( "singleAnswerSetsInfo" ) ) return singleAnswerSetsInfo;
        if ( attribute.equalsIgnoreCase( "tallyRangeLimitsValuesDataSetInfo" ) ) return tallyRangeLimitsValuesDataSetInfo;
        
        return null;
        
    }
    
    
    public MultiQuestionsInfoVO transform(MultiQuestionsListRow row) {
        MultiQuestionsInfoVO mqInfo = new MultiQuestionsInfoVO();
        if (row.getQmqId() != null )  mqInfo.setQmqId( row.getQmqId() );
        mqInfo.setQmqNumber( row.getQmqNumber() );
        mqInfo.setQmqType( row.getQmqType() );
        mqInfo.setQmqHint( row.getQmqHint() ); 
        if ( row.getQmqRasId() != null ) mqInfo.setQmqRasId( row.getQmqRasId() );
        if ( row.getQmqTlyId() != null ) mqInfo.setQmqTlyId( row.getQmqTlyId() );
        if ( row.getRasFridId() != null ) mqInfo.setRasFridId( row.getRasFridId() );
        
        if ( row.getSingleAnswerSetsInfo() != null )     mqInfo.setSingleAnswerSetsInfo( row.getSingleAnswerSetsInfo() );
        if ( row.getTallyRangeLimitsValuesDataSetInfo() != null )    mqInfo.setTallyRangeLimitsValuesDataSetInfo( row.getTallyRangeLimitsValuesDataSetInfo() );
        if ( row.getDataTallyOptions() != null )         mqInfo.setDataTallyOptions( row.getDataTallyOptions() );
        
        return mqInfo;
    }
    
    
    public MultiQuestionsListRow transform(MultiQuestionsList view, MultiQuestionsInfoVO mqInfo) {
        MultiQuestionsListRow row = (MultiQuestionsListRow) view.createRow();
        if (mqInfo.getQmqId() != null )  row.setQmqId( mqInfo.getQmqId() );
        row.setQmqNumber( mqInfo.getQmqNumber() );
        row.setQmqType( mqInfo.getQmqType() );
        row.setQmqHint( mqInfo.getQmqHint() ); 
        if ( mqInfo.getQmqRasId() != null ) row.setQmqRasId( mqInfo.getQmqRasId() );
        if ( mqInfo.getQmqTlyId() != null ) row.setQmqTlyId( mqInfo.getQmqTlyId() );
        if ( mqInfo.getRasFridId() != null ) row.setRasFridId( mqInfo.getRasFridId() );
        
        if ( mqInfo.getSingleAnswerSetsInfo() != null )     row.setSingleAnswerSetsInfo( mqInfo.getSingleAnswerSetsInfo() );
        if ( mqInfo.getTallyRangeLimitsValuesDataSetInfo() != null )    row.setTallyRangeLimitsValuesDataSetInfo( mqInfo.getTallyRangeLimitsValuesDataSetInfo() );
        if ( mqInfo.getDataTallyOptions() != null )         row.setDataTallyOptions( mqInfo.getDataTallyOptions() );
        return row;
    }
    
    
    public MultiQuestionDataSetInfo transform(MultiQuestionsInfoVO mqInfo) {
        MultiQuestionDataSetInfo qmq = new MultiQuestionDataSet();
        if (mqInfo.getQmqId() != null )         qmq.setQmq_id( mqInfo.getQmqId().intValue() );
        qmq.setQmq_number( mqInfo.getQmqNumber() );
        qmq.setQmq_type( mqInfo.getQmqType() );
        qmq.setQmq_hint( mqInfo.getQmqHint() ); 
        if ( mqInfo.getQmqRasId() != null )     qmq.setQmq_ras_id( mqInfo.getQmqRasId().intValue() );
        if ( mqInfo.getQmqTlyId() != null )     qmq.setQmq_tly_id( mqInfo.getQmqTlyId().intValue() );
        if ( mqInfo.getRasFridId() != null )    qmq.setRas_frid_id( mqInfo.getRasFridId().intValue() );
        
        if ( mqInfo.getSingleAnswerSetsInfo() != null )     qmq.setSingleAnswerSetsInfo( mqInfo.getSingleAnswerSetsInfo() );
        if ( mqInfo.getTallyRangeLimitsValuesDataSetInfo() != null )    qmq.setTallyRangeLimitsValuesDataSetInfo( mqInfo.getTallyRangeLimitsValuesDataSetInfo() );
        if ( mqInfo.getDataTallyOptions() != null )         qmq.setDataTallyOptions( mqInfo.getDataTallyOptions() );
        return qmq;
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

    public void setQmqHint(String qmqHint) {
        this.qmqHint = qmqHint;
    }

    public String getQmqHint() {
        return qmqHint;
    }

    public void setQmqRasId(Number qmqRasId) {
        this.qmqRasId = qmqRasId;
    }

    public Number getQmqRasId() {
        return qmqRasId;
    }

    public void setQmqTlyId(Number qmqTlyId) {
        this.qmqTlyId = qmqTlyId;
    }

    public Number getQmqTlyId() {
        return qmqTlyId;
    }

    public void setRasFridId(Number rasFridId) {
        this.rasFridId = rasFridId;
    }

    public Number getRasFridId() {
        return rasFridId;
    }

    public void setDataTallyOptions(String[] dataTallyOptions) {
        this.dataTallyOptions = dataTallyOptions;
    }

    public String[] getDataTallyOptions() {
        return dataTallyOptions;
    }

    public void setSingleAnswerSetsInfo(List<ReportAnswerSetValuesDataSetInfo> singleAnswerSetsInfo) {
        this.singleAnswerSetsInfo = singleAnswerSetsInfo;
    }

    public List<ReportAnswerSetValuesDataSetInfo> getSingleAnswerSetsInfo() {
        return singleAnswerSetsInfo;
    }

    public void setTallyRangeLimitsValuesDataSetInfo(List<TallyRangeLimitsValuesDataSetInfo> tallyRangeLimitsValuesDataSetInfo) {
        this.tallyRangeLimitsValuesDataSetInfo = tallyRangeLimitsValuesDataSetInfo;
    }

    public List<TallyRangeLimitsValuesDataSetInfo> getTallyRangeLimitsValuesDataSetInfo() {
        return tallyRangeLimitsValuesDataSetInfo;
    }
}
