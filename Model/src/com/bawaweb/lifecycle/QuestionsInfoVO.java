/**
 * @author Nonny Medhora
 */
package com.bawaweb.lifecycle;


import com.bawaweb.grid.templates.data.cursors.QuestionDataSet;
import com.bawaweb.grid.templates.data.cursors.QuestionDataSetInfo;

import com.bawaweb.views.gridcursors.common.QuestionsList;
import com.bawaweb.views.gridcursors.common.QuestionsListRow;

import com.bawaweb.views.gridcursors.views.common.QuestionsListView;
import com.bawaweb.views.gridcursors.views.common.QuestionsListViewRow;

import oracle.jbo.domain.Number;


public class QuestionsInfoVO {

    private Number qstId;
    private String qstNumber;
    private Number orderBy1;
    private Number numericPart;
    private String alphaPart;
    private String qstQuestion;
    private String qstType;
    private Number qstMultiAnswers;
    private String qstQuestionHint;
    private String qstTextRequiredYn;
    private String qstTextHint;
    private Number qstRasId;
    private Number rasFridId;
    private Number qstTlyId;
    private Number numCols;
    private Number qstAnsId;
    
    
    public QuestionsInfoVO() {
    }
    
    public Object getAttribute(String attribute) {
        if ( attribute.equalsIgnoreCase("qstId")) return qstId;
        if ( attribute.equalsIgnoreCase("qstNumber")) return qstNumber;
        if ( attribute.equalsIgnoreCase("orderBy1")) return orderBy1;
        if ( attribute.equalsIgnoreCase("numericPart")) return numericPart;
        if ( attribute.equalsIgnoreCase("alphaPart")) return alphaPart;
        if ( attribute.equalsIgnoreCase("qstQuestion")) return qstQuestion;
        if ( attribute.equalsIgnoreCase("qstType")) return qstType;
        if ( attribute.equalsIgnoreCase("qstMultiAnswers")) return qstMultiAnswers;
        if ( attribute.equalsIgnoreCase("qstQuestionHint")) return qstQuestionHint;
        if ( attribute.equalsIgnoreCase("qstTextRequiredYn")) return qstTextRequiredYn;
        if ( attribute.equalsIgnoreCase("qstTextHint")) return qstTextHint;
        if ( attribute.equalsIgnoreCase("qstRasId")) return qstRasId;
        if ( attribute.equalsIgnoreCase("rasFridId")) return rasFridId;
        if ( attribute.equalsIgnoreCase("qstTlyId")) return qstTlyId;
        if ( attribute.equalsIgnoreCase("numCols")) return numCols;
        if ( attribute.equalsIgnoreCase("qstAnsId")) return qstAnsId;
        
        return null;
    }
    
    
    public QuestionDataSetInfo transform(QuestionsInfoVO info) {
        QuestionDataSetInfo questInfo = new QuestionDataSet();
        
        if ( info.getQstId() != null ) questInfo.setQst_id( info.getQstId().intValue() );
//        questInfo.setQstNumber( info.getQstNumber() );
        if ( info.getOrderBy1() != null ) questInfo.setOrder_by( info.getOrderBy1().toString() );
        if ( info.getNumericPart() != null ) questInfo.setQst_numeric( info.getNumericPart().intValue() );
        questInfo.setQst_alpha( info.getAlphaPart() );
        questInfo.setQst_question( info.getQstQuestion() );
        questInfo.setQst_type( info.getQstType() );
        if ( info.getQstMultiAnswers() != null ) questInfo.setQst_multi_answers( info.getQstMultiAnswers().intValue() );
        questInfo.setQst_question_hint( info.getQstQuestionHint() );
        questInfo.setQst_text_required_yn( info.getQstTextRequiredYn() );
        questInfo.setQst_text_hint( info.getQstTextHint() );
        if ( info.getQstRasId() != null ) questInfo.setQst_ras_id( info.getQstRasId().intValue() );
        if ( info.getRasFridId() != null ) questInfo.setRas_frid_id( info.getRasFridId().intValue() );
        if ( info.getQstTlyId() != null ) questInfo.setQst_tly_id( info.getQstTlyId().intValue() );
        if ( info.getNumCols() != null ) questInfo.setNum_cols( info.getNumCols().intValue() );        
        if ( info.getQstAnsId() != null ) questInfo.setQst_ans_id( info.getQstAnsId().intValue() );
        return questInfo;     
    }
    
    
    
    public QuestionsInfoVO transform(QuestionsListViewRow row) {
        QuestionsInfoVO quest = new QuestionsInfoVO();
        
        quest.setQstId( row.getQstId() );
        quest.setQstNumber( row.getQstNumber() );
        quest.setOrderBy1( row.getOrderBy1() );
        quest.setNumericPart( row.getNumericPart() );
        quest.setAlphaPart( row.getAlphaPart() );
        quest.setQstQuestion( row.getQstQuestion() );
        quest.setQstType( row.getQstType() );
        quest.setQstMultiAnswers( row.getQstMultiAnswers() );
        quest.setQstQuestionHint( row.getQstQuestionHint() );
        quest.setQstTextRequiredYn( row.getQstTextRequiredYn() );
        quest.setQstTextHint( row.getQstTextHint() );
        quest.setQstRasId( row.getQstRasId() );
        quest.setRasFridId( row.getRasFridId() );
        quest.setQstTlyId( row.getQstTlyId() );
        quest.setNumCols( row.getNumCols() );        
        quest.setQstAnsId( row.getQstAnsId() );
        return quest;        
        
        
    }
    
    public QuestionsInfoVO transform(QuestionsListRow row) {
        QuestionsInfoVO quest = new QuestionsInfoVO();
        
        quest.setQstId( row.getQstId() );
        quest.setQstNumber( row.getQstNumber() );
        quest.setOrderBy1( row.getOrderBy1() );
        quest.setNumericPart( row.getNumericPart() );
        quest.setAlphaPart( row.getAlphaPart() );
        quest.setQstQuestion( row.getQstQuestion() );
        quest.setQstType( row.getQstType() );
        quest.setQstMultiAnswers( row.getQstMultiAnswers() );
        quest.setQstQuestionHint( row.getQstQuestionHint() );
        quest.setQstTextRequiredYn( row.getQstTextRequiredYn() );
        quest.setQstTextHint( row.getQstTextHint() );
        quest.setQstRasId( row.getQstRasId() );
        quest.setRasFridId( row.getRasFridId() );
        quest.setQstTlyId( row.getQstTlyId() );
        quest.setNumCols( row.getNumCols() );        
        quest.setQstAnsId( row.getQstAnsId() );
        return quest;        
        
    }
    
    public QuestionsListViewRow transform(QuestionsListView view, QuestionsInfoVO quest) {
        QuestionsListViewRow row = (QuestionsListViewRow) view.createRow();
        
        row.setQstId( quest.getQstId() );
        
        
        row.setQstId( quest.getQstId() );
        row.setQstNumber( quest.getQstNumber() );
        row.setOrderBy1( quest.getOrderBy1() );
        row.setNumericPart( quest.getNumericPart() );
        row.setAlphaPart( quest.getAlphaPart() );
        row.setQstQuestion( quest.getQstQuestion() );
        row.setQstType( quest.getQstType() );
        row.setQstMultiAnswers( quest.getQstMultiAnswers() );
        row.setQstQuestionHint( quest.getQstQuestionHint() );
        row.setQstTextRequiredYn( quest.getQstTextRequiredYn() );
        row.setQstTextHint( quest.getQstTextHint() );
        row.setQstRasId( quest.getQstRasId() );
        row.setRasFridId( quest.getRasFridId() );
        row.setQstTlyId( quest.getQstTlyId() );
        row.setNumCols( quest.getNumCols() );        
        row.setQstAnsId( quest.getQstAnsId() );
        return row;        
        
    }
    
    
    public QuestionsListRow transform(QuestionsList view, QuestionsInfoVO quest) {
        QuestionsListRow row = (QuestionsListRow) view.createRow();
        
        row.setQstId( quest.getQstId() );
        
        
        row.setQstId( quest.getQstId() );
        row.setQstNumber( quest.getQstNumber() );
        row.setOrderBy1( quest.getOrderBy1() );
        row.setNumericPart( quest.getNumericPart() );
        row.setAlphaPart( quest.getAlphaPart() );
        row.setQstQuestion( quest.getQstQuestion() );
        row.setQstType( quest.getQstType() );
        row.setQstMultiAnswers( quest.getQstMultiAnswers() );
        row.setQstQuestionHint( quest.getQstQuestionHint() );
        row.setQstTextRequiredYn( quest.getQstTextRequiredYn() );
        row.setQstTextHint( quest.getQstTextHint() );
        row.setQstRasId( quest.getQstRasId() );
        row.setRasFridId( quest.getRasFridId() );
        row.setQstTlyId( quest.getQstTlyId() );
        row.setNumCols( quest.getNumCols() );        
        row.setQstAnsId( quest.getQstAnsId() );
        return row;        
        
    }

    public static void main(String[] args) {
        QuestionsInfoVO questionsInfo = new QuestionsInfoVO();
    }

    public void setQstId(Number qstId) {
        this.qstId = qstId;
    }

    public Number getQstId() {
        return qstId;
    }

    public void setQstNumber(String qstNumber) {
        this.qstNumber = qstNumber;
    }

    public String getQstNumber() {
        return qstNumber;
    }

    public void setOrderBy1(Number orderBy1) {
        this.orderBy1 = orderBy1;
    }

    public Number getOrderBy1() {
        return orderBy1;
    }

    public void setNumericPart(Number numericPart) {
        this.numericPart = numericPart;
    }

    public Number getNumericPart() {
        return numericPart;
    }

    public void setAlphaPart(String alphaPart) {
        this.alphaPart = alphaPart;
    }

    public String getAlphaPart() {
        return alphaPart;
    }

    public void setQstQuestion(String qstQuestion) {
        this.qstQuestion = qstQuestion;
    }

    public String getQstQuestion() {
        return qstQuestion;
    }

    public void setQstType(String qstType) {
        this.qstType = qstType;
    }

    public String getQstType() {
        return qstType;
    }

    public void setQstMultiAnswers(Number qstMultiAnswers) {
        this.qstMultiAnswers = qstMultiAnswers;
    }

    public Number getQstMultiAnswers() {
        return qstMultiAnswers;
    }

    public void setQstQuestionHint(String qstQuestionHint) {
        this.qstQuestionHint = qstQuestionHint;
    }

    public String getQstQuestionHint() {
        return qstQuestionHint;
    }

    public void setQstTextRequiredYn(String qstTextRequiredYn) {
        this.qstTextRequiredYn = qstTextRequiredYn;
    }

    public String getQstTextRequiredYn() {
        return qstTextRequiredYn;
    }

    public void setQstTextHint(String qstTextHint) {
        this.qstTextHint = qstTextHint;
    }

    public String getQstTextHint() {
        return qstTextHint;
    }

    public void setQstRasId(Number qstRasId) {
        this.qstRasId = qstRasId;
    }

    public Number getQstRasId() {
        return qstRasId;
    }

    public void setRasFridId(Number rasFridId) {
        this.rasFridId = rasFridId;
    }

    public Number getRasFridId() {
        return rasFridId;
    }

    public void setQstTlyId(Number qstTlyId) {
        this.qstTlyId = qstTlyId;
    }

    public Number getQstTlyId() {
        return qstTlyId;
    }

    public void setNumCols(Number numCols) {
        this.numCols = numCols;
    }

    public Number getNumCols() {
        return numCols;
    }

    public void setQstAnsId(Number qstAnsId) {
        this.qstAnsId = qstAnsId;
    }

    public Number getQstAnsId() {
        return qstAnsId;
    }
}
