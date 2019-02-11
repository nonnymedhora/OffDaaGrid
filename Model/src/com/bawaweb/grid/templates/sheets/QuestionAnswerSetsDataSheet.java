/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.sheets;

import com.bawaweb.grid.templates.AnswersGridTemplateRangeConstants;
import com.bawaweb.grid.templates.data.ReportTemplateInfo;

import com.bawaweb.grid.templates.data.cursors.MultiQuestionDataSetInfo;
import com.bawaweb.grid.templates.data.cursors.QuestionDataSetInfo;

import com.bawaweb.grid.templates.data.tables.AnswerSetsDataSetInfo;
import com.bawaweb.grid.templates.data.tables.ReportAnswerSetValuesDataSetInfo;

import java.util.Iterator;

import java.util.List;

import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import com.bawaweb.services.PlatformAppModuleService;
import com.bawaweb.services.PlatformAppModuleServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import java.util.Set;

import jxl.CellView;

import jxl.format.Alignment;

import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;

import jxl.write.Blank;
import jxl.write.Number;
import jxl.write.NumberFormats;
import jxl.write.WritableCellFormat;

import jxl.write.WritableFont;

import org.apache.log4j.Logger;
/**
* this worksheet display the questions which have answer-sets
* to which additonal answer-set-values may be added
*/
public class QuestionAnswerSetsDataSheet {	
        private static final Logger LOG = Logger.getLogger(QuestionAnswerSetsDataSheet.class);
    
        private WritableSheet ss;
	private ReportTemplateInfo reportTemplateInfoDataSet;
        
        private Map<Integer, String> mp_R1C1Map;
        
        private Map<Integer, Integer> mp_QuestionIdsForAdditionalAnswersCols = new HashMap<Integer, Integer>();
        private Map<Integer, Integer> hsh_maxColumnWidth = new Hashtable<Integer, Integer>();
        
        private Map<Integer, List<Integer>> mp_rasId_qstIds = new HashMap<Integer, List<Integer>>();
        private Map<Integer, Integer> mp_firstRasId_col = new HashMap<Integer, Integer>();
        private Map<Integer, Integer> mp_firstRasId_row = new HashMap<Integer, Integer>();
        

        public static final Colour DUP_ANSID_QSTN_LBL = AnswersGridTemplateRangeConstants.DUP_ANSID_QSTN_LBL;
        public static final Colour DUP_ANSID_ANSVALUE_LBL = AnswersGridTemplateRangeConstants.DUP_ANSID_ANSVALUE_LBL;
        public static final Colour DUP_ANSID_EXTRAANSVALUE_LBL = AnswersGridTemplateRangeConstants.DUP_ANSID_EXTRAANSVALUE_LBL;
//     /*   
//    private /*static*/ WritableCellFormat _wghtdQstnHintInfoDataCellFormat() {
//        WritableCellFormat boldBlack = null;
//        try {
//            WritableFont boldBlackFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD);       
//            boldBlackFont.setColour(AnswersGridTemplateRangeConstants.RED_COLOR);
//            boldBlack = new WritableCellFormat(boldBlackFont, NumberFormats.FLOAT);
//            boldBlack.setBackground(AnswersGridTemplateRangeConstants.WGHTD_COLOR);            
//            boldBlack.setBorder(Border.RIGHT, BorderLineStyle.THICK);
//            boldBlack.setWrap(true);
//            boldBlack.setAlignment(Alignment.CENTRE);
//            boldBlack.setVerticalAlignment(VerticalAlignment.TOP);       //JUSTIFY);
//            boldBlack.setLocked(true);
//            boldBlack.setShrinkToFit(true);
//        } catch (WriteException e) { e.printStackTrace(); LOG.error("error in creating _wghtdQstnHintInfoDataCellFormat"); }
//        return boldBlack;
//    }
//    */
//    public /*static*/ final WritableCellFormat FRMT_WGTD_QSTN_HINT_INFO_DATA_CELL = _wghtdQstnHintInfoDataCellFormat();

    public QuestionAnswerSetsDataSheet (WritableSheet s, ReportTemplateInfo ris) {
        this.ss = s;
        this.reportTemplateInfoDataSet = ris;
        this.mp_rasId_qstIds = buildRasIdQstIdMap( this.reportTemplateInfoDataSet );
        this.mp_R1C1Map = buildMp_R1C1Map();
    }
        

    public WritableSheet createExtraQuestionAnswerSetsDataSheet() {
        this.ss.getSettings().setProtected( true );
        this.fillQuestionsData(this.ss, AnswersGridTemplateRangeConstants.RANGE_QUESTIONS_TOP_COL, AnswersGridTemplateRangeConstants.RANGE_QUESTIONS_TOP_ROW );

        this.formatColumns();
        this.ss.getSettings().setZoomFactor(75);
        
//        this.ss.getSettings().setProtected( false );
        return this.ss;
    }

    private void fillQuestionsData(WritableSheet s, final int top_col, final int top_row) {
        int col = top_col;
        int row = top_row;
        
        Label infoLabel;// = new Label(0, 1, "Questions");


        //LOG.info("this.reportTemplateInfoDataSet.getListOfQuestionsForAdditionalAnswers() size is " + this.reportTemplateInfoDataSet.getListOfQuestionsForAdditionalAnswers().size());        
        
        try {
            infoLabel = new Label( 0, 1, processStringForWrap("Questions", 0) );
            infoLabel.setCellFormat(getNormalFormat());
            s.addCell( infoLabel);
            
            infoLabel = new Label( 0, 2, processStringForWrap("Answer Set Name", 1));
            infoLabel.setCellFormat(getNormalFormat());
            s.addCell( infoLabel);
            
            infoLabel = new Label( 0, 3, processStringForWrap("Answer Set Values", 3));
            infoLabel.setCellFormat(getNormalFormat());
            s.addCell( infoLabel );
            
        } catch (RowsExceededException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        }
        
        
        
        for (Iterator<QuestionDataSetInfo> qt = this.reportTemplateInfoDataSet.getListOfQuestionsForAdditionalAnswers().iterator(); qt.hasNext(); col+=2) {
            row = top_row;
            
            boolean isDuplicatedRas = false;        // start base = false
            
            QuestionDataSetInfo qis = qt.next();
            int qstId = qis.getQst_id();
LOG.info("xtraQ qstId is " + qstId);
System.out.println("xtraQ qstId is " + qstId);

            if ( qstId <= 0 ) continue;
            
            int rasId = qis.getQst_ras_id();
            if ( this.mp_firstRasId_col.get( rasId ) == null ) {
                this.mp_firstRasId_col.put( rasId, col );// tired of doing pair
System.out.println("Enetered col " + col + " into mpFirstRAS__COL for rasid " + rasId );
LOG.info("Enetered col " + col + " into mpFirstRAS__COL for rasid " + rasId );
            } else {
                isDuplicatedRas = true;
            }
LOG.info("for rasid " + rasId + " isDuplicatedRas is ==> " + isDuplicatedRas );             
System.out.println("for rasid " + rasId + " isDuplicatedRas is ==> " + isDuplicatedRas );            
            String theQuestion = processTheQuestion( qis );
            
            // top zero row for id
            jxl.write.Number qstIdLabel = new jxl.write.Number( col, row, qstId );


            try {
                CellView hideView = new CellView();
                hideView.setHidden(true);                
                s.addCell( qstIdLabel );                
                s.setRowView(row, hideView);
                
//            } catch (RowsExceededException e) {
//                e.printStackTrace();
//            } catch (WriteException e) {
//                e.printStackTrace();
//            }
            
            mp_QuestionIdsForAdditionalAnswersCols.put( qstId, col );
            
            row++;
            Label qstLabel = new Label( col, row, processStringForWrap(theQuestion, col) );
            if ( !isDuplicatedRas ) {
                qstLabel.setCellFormat(getNormalFormat());
            } else {
                qstLabel.setCellFormat(getDupQstLablFormat());
            }
            
//            try {
                s.addCell( qstLabel );
//            } catch (RowsExceededException e) {
//                e.printStackTrace();
//            } catch (WriteException e) {
//                e.printStackTrace();
//            }
            
            
            row++;

//            AnswerSetsDataSetInfo ansInf = qis.getAnswerSetInfo();
//            if ( ansInf == null ) {
//            LOG.info("xTraQ ansInf is null");
            int ans_id = qis.getSingleAnswerSetsInfo().get(0).getAns_id();
LOG.info("ans_id is " + ans_id + " for qstid   " + qstId );            
            PlatformAppModuleService service = PlatformAppModuleServiceImpl.getInstance();
            String ansName = service.getAnswerSetName( ans_id );
LOG.info("ans-name is " + ansName );           
            if ( ansName == null ) {
                continue;
            } else {
                infoLabel = new Label(col, row, processStringForWrap(ansName, col));
            }
//            } else {
//            
//                infoLabel = new Label(col, row, processStringForWrap(qis.getAnswerSetInfo().getAns_name(), col));
//            }
            infoLabel.setCellFormat(getNormalFormat());
            s.addCell( infoLabel );
            
            row++;
//            try {
                infoLabel = new Label( col, row, processStringForWrap("Display Sequence", col));
                infoLabel.setCellFormat(getNormalFormat());
                s.addCell( infoLabel );
                
                infoLabel = new Label( col+1, row, processStringForWrap("Answer Set Value", col));
                infoLabel.setCellFormat(getNormalFormat());
                s.addCell( infoLabel );
            } catch (RowsExceededException e) {
                e.printStackTrace();
            } catch (WriteException e) {
                e.printStackTrace();
            }

            //            
//            row = row + 1;
//            Label ansNameLabel = new Label(col, row, qis.getSingleAnswerSetsInfo().get(0).get);


            row = row + 1;
            
            List<ReportAnswerSetValuesDataSetInfo> qn_rasvListInfo = qis.getSingleAnswerSetsInfo();
            if ( qn_rasvListInfo != null ) {
                try {
                    int displaySeq = 0;
                    for ( Iterator<ReportAnswerSetValuesDataSetInfo> rt = qn_rasvListInfo.iterator(); rt.hasNext(); row++) {
                        ReportAnswerSetValuesDataSetInfo ravInfo = rt.next();
                        String answer = ravInfo.getRav_answer();
                        displaySeq = ravInfo.getRav_display_seq();
                        Number seqNmbr = new Number( col, row, displaySeq);
                        s.addCell( seqNmbr );
                        
                        Label ansLabel = new Label( col + 1, row, processStringForWrap(answer, col) );
                        if (!isDuplicatedRas) {
                            ansLabel.setCellFormat(getNormalFormat());
                        } else {
                            ansLabel.setCellFormat(getDupAnsValueLablFormat());
                        }
                        s.addCell( ansLabel );
                            
                            
                                        
                    }   // ends for in if
//                    row++;
                    
                    for ( int i = 1; i < AnswersGridTemplateRangeConstants.NUM_EXTRA_ANSWERS+1; i++, row++) {
                        Number extraSeq = new Number( col, row, displaySeq+i);
                        s.addCell( extraSeq );
                        
                        if ( !isDuplicatedRas ) {
System.out.println("for rasid " + rasId + " isDuplicatedRas is ==> " + isDuplicatedRas + " putting ROW " + row + " into mpFR");
LOG.info("for rasid " + rasId + " isDuplicatedRas is ==> " + isDuplicatedRas + " putting ROW " + row + " into mpFR");
                            if (mp_firstRasId_row.get( rasId ) == null ) {  // ensueres only does it for the first one
                                mp_firstRasId_row.put( rasId, row );
                            }
                            Blank aBlank = new Blank( col+1, row );
                            aBlank.setCellFormat( UNLOCKED_CELL_FORMAT );
                            s.addCell( aBlank );
                        } else {
System.out.println("for rasid " + rasId + " isDuplicatedRas is ==> " + isDuplicatedRas);
LOG.info("for rasid " + rasId + " isDuplicatedRas is ==> " + isDuplicatedRas);

                            String theFormula = "";
                            int /*String*/ firstCol = /*String.valueOf( */mp_firstRasId_col.get( rasId ) /*)*/ + 1; // 1st col is seq added 1
                            int /*String*/ firstRow = /*String.valueOf( */mp_firstRasId_row.get( rasId ) /*)*/ + 1; // row is zero based added 1
                            String fstColVal = mp_R1C1Map.get(firstCol);
                            theFormula = fstColVal + (firstRow + i - 1);
System.out.println("theformula is " + theFormula + " entered in col " + (col+1) + " and row " + row + " for qstid " + qstId);                            
                            Formula fm = new Formula( col+1, row, theFormula );
                            fm.setCellFormat( getDupExtraAnsValueLablFormat() );
                            s.addCell( fm );
                        }
                    }                    
                } catch (RowsExceededException e) {
                    e.printStackTrace();
                } catch (WriteException e) {
                    e.printStackTrace();
                }
            } else {
                LOG.info("qn_rasvListInfo is null for " + qis.getQst_id() + " which is of type --> " + qis.getQst_type());
            }
            
            
        } // ends outer for
    }

/*****************************************
    private void fillQuestionsData(WritableSheet s, final int top_col, final int top_row) {
        PlatformAppModuleService platform = PlatformAppModuleServiceImpl.getInstance();
        int col = top_col;
        int row = top_row;
        
        for (Iterator<QuestionDataSetInfo> it = this.reportTemplateInfoDataSet.getListOfQuestions().iterator(); it.hasNext(); col++) {
            row = top_row;
            QuestionDataSetInfo qis = it.next();
            int qstId = qis.getQst_id();
            if (qstId <= 0 ) continue;
            int qNums = qis.getQst_multi_answers();
            String qType = qis.getQst_type();
            
            if ( qType.equalsIgnoreCase("SINGLE") || qType.equalsIgnoreCase("MULTI")) {
                
                if (/\*qType.equalsIgnoreCase("SINGLE") && *\/platform.canAddAnswerSetsToQuestion(new Number(qstId)) ) {
                    
                    // qstn label
                    String theQuestion = processTheQuestion(qis);
                    Label qstLabel = new Label( col, row, theQuestion);
                    
        //            qstLabel.setCellFormat(FRMT_MULTI_QSTN_INFO_DATA_CELL );
        
        
                    //
                    try {
                        s.addCell( qstLabel );
                    } catch (RowsExceededException e) {
                        e.printStackTrace();
                    } catch (WriteException e) {
                        e.printStackTrace();
                    }
                    
                    row = row + 1;
                    
                    List<ReportAnswerSetValuesDataSetInfo> qn_rasvListInfo = qis.getSingleAnswerSetsInfo();
                    if ( qn_rasvListInfo != null ) {
                        for ( Iterator<ReportAnswerSetValuesDataSetInfo> rt = qn_rasvListInfo.iterator(); rt.hasNext(); row++) {
                            ReportAnswerSetValuesDataSetInfo ravInfo = rt.next();
                            String answer = ravInfo.getRav_answer();
                            
                            Label ansLabel = new Label( col, row, answer );
            
                            try {
                                s.addCell( ansLabel );
                            } catch (RowsExceededException e) {
                                e.printStackTrace();
                            } catch (WriteException e) {
                                e.printStackTrace();
                            }                
                        }
                    } else {
                        LOG.info("qn_rasvListInfo is null for " + qis.getQst_id() + " which is of type --> " + qis.getQst_type());
                    }
                }
/\**                
//                else {
//                    // here qtype is multi
//                     List<MultiQuestionDataSetInfo> mqinfo = qis.getMultiQuestionInfo();
//                     for (Iterator<MultiQuestionDataSetInfo> mt = mqinfo.iterator(); mt.hasNext(); ) {
//                         MultiQuestionDataSetInfo minf = mt.next();
//                         if ( minf.getQmq_type() == "SINGLE" || minf.getQmq_type().equals("SINGLE")) {
////                             singqstns += 1; 
//                         }
//                     }
//                }
**\/
            }
                
        }
    }
    
    **********************************************/

    private String processTheQuestion(QuestionDataSetInfo qis) {
        int qNum = qis.getQst_numeric();
        if ( qNum == 0 ) {
            return qis.getQst_question();
        }
        String qAlpha = qis.getQst_alpha();
        String qstn = qis.getQst_question();
        try {
            if ( qAlpha != null ) {
                Integer.parseInt(qAlpha);
                return  qNum + ". " + qis.getQst_question(); 
            }
        } catch (NumberFormatException e) { /*swallow it - do nothing */ }
        
        return qNum + qAlpha + ". " + qis.getQst_question(); 
         /*String theQnInfo = qis.getQst_numeric() != 0 ? 
                        qis.getQst_numeric()  + (qis.getQst_alpha()!= null ? qis.getQst_alpha() : "") +  ". " + qis.getQst_question() 
                        : 
                        qis.getQst_question();*/
         
        
    }

    public void setSs(WritableSheet ss) {
        this.ss = ss;
    }

    public WritableSheet getSs() {
        return ss;
    }

    public void setReportTemplateInfoDataSet(ReportTemplateInfo reportTemplateInfoDataSet) {
        this.reportTemplateInfoDataSet = reportTemplateInfoDataSet;
    }

    public ReportTemplateInfo getReportTemplateInfoDataSet() {
        return reportTemplateInfoDataSet;
    }

    public void setMp_QuestionIdsForAdditionalAnswersCols(Map<Integer, Integer> mp_QuestionsForAdditionalAnswersCols) {
        this.mp_QuestionIdsForAdditionalAnswersCols = mp_QuestionsForAdditionalAnswersCols;
    }

    public Map<Integer, Integer> getMp_QuestionIdsForAdditionalAnswersCols() {
        return mp_QuestionIdsForAdditionalAnswersCols;
    }
    
    private WritableCellFormat getNormalFormat() {
        WritableCellFormat ff = new WritableCellFormat();

        try {
            ff.setAlignment(Alignment.CENTRE);
            ff.setLocked( true );
            ff.setWrap( true );
        } catch (WriteException e) {
            e.printStackTrace();
        }
        
        return ff;
    }
    
    


    private WritableCellFormat getDupQstLablFormat() {        
        WritableCellFormat ff = new WritableCellFormat();

        try {
            ff.setAlignment(Alignment.CENTRE);
            ff.setLocked( true );
            ff.setWrap( true );
            ff.setBackground(DUP_ANSID_QSTN_LBL);
        } catch (WriteException e) {
            e.printStackTrace();
        }
        
        return ff;
    }
    
    
    private WritableCellFormat getDupAnsValueLablFormat() {        
        WritableCellFormat ff = new WritableCellFormat();

        try {
            ff.setAlignment(Alignment.CENTRE);
            ff.setLocked( true );
            ff.setWrap( true );
            ff.setBackground(DUP_ANSID_ANSVALUE_LBL);
        } catch (WriteException e) {
            e.printStackTrace();
        }
        
        return ff;
    }
    
    
    private WritableCellFormat getDupExtraAnsValueLablFormat() {        
        WritableCellFormat ff = new WritableCellFormat();

        try {
            ff.setAlignment(Alignment.CENTRE);
            ff.setLocked( true );
            ff.setWrap( true );
            ff.setBackground(DUP_ANSID_EXTRAANSVALUE_LBL);
        } catch (WriteException e) {
            e.printStackTrace();
        }
        
        return ff;
    }
    public final Map<Integer, String> buildMp_R1C1Map() {
        Map<Integer, String> mp = new HashMap<Integer, String>();
        
        final int last = 255;
        final int chCount = 25;
        final int startChA = 65;
        final int endChZ = 90;
        
        int thecol = 0;
        
        while ( thecol <= last ) {
            int times = thecol / chCount;
            
            if ( times > 0 ) {
                int pref = startChA + times - 1;
                
                for ( int count = 0; count <= chCount; count++) {
                    mp.put(thecol, String.valueOf((char)(pref)) + "" + String.valueOf((char)(count+startChA)));
                    thecol++;// += count;
                }
                
            } else {
                for ( int count = 0; count <= chCount; count++) {
                    mp.put(thecol, String.valueOf((char)(count+startChA)));
                    thecol++;
                }
            }
            
            
        }
            thecol++;
        
        
        
        return this.mp_R1C1Map = mp;
    }
    
    public void setMp_R1C1Map(Map<Integer, String> mp_R1C1Map) {
        this.mp_R1C1Map = mp_R1C1Map;
    }

    public Map<Integer, String> getMp_R1C1Map() {
        return mp_R1C1Map;
    }
    
    // sets the max length of the string in a col to the colwidth hash hsh_maxColumnWidth
    // and then returns the string.
    // the createAnswersGridSheet will call the formatColumns method which will
    // use the values off the hsh_maxColumnWidth to set the column's width
    private String processStringForWrap(String text, int col) {
    if ( text == null ) LOG.info("processStringForWrap --- text is null for col " + col);
        int existingMax = this.hsh_maxColumnWidth.get(col) != null ? this.hsh_maxColumnWidth.get(col) : 0;
        if ( text != null ) {
            if ( text.length() > existingMax ) {
                this.hsh_maxColumnWidth.put(col, text.length());
            }
        }
        return text != null ? text : "";
    }
    
    
    private void formatColumns() {
        Set<Integer> cols = this.hsh_maxColumnWidth.keySet();
    LOG.info("xtraQ  hash size " + this.hsh_maxColumnWidth.size());
        for( Iterator<Integer> it = cols.iterator(); it.hasNext(); ) {
            int thecol = it.next();
            int maxLength = this.hsh_maxColumnWidth.get(thecol);
            int width = 0;
            if ( maxLength != 0 ) {
                if ( maxLength <= 10 ) width = 10;
                else if ( maxLength > 10 && maxLength <= 50 ) width = 20;
                else if ( maxLength > 50 && maxLength <= 150 ) width = 30;
                else if ( maxLength > 150 ) width = 45;
            }
    LOG.info("xtraQ   setting col " + thecol + " with " + width);
            this.ss.setColumnView(thecol, width);
        }
    }

    public void setHsh_maxColumnWidth(Map<Integer, Integer> hsh_maxColumnWidth) {
        this.hsh_maxColumnWidth = hsh_maxColumnWidth;
    }

    public Map<Integer, Integer> getHsh_maxColumnWidth() {
        return hsh_maxColumnWidth;
    }

    private WritableCellFormat _unlockedCellFormat() {
        try {
            WritableCellFormat fmt = new WritableCellFormat();
            fmt.setLocked( false );
            return fmt;
        } catch (WriteException e) {
           e.printStackTrace();
           LOG.error( "Couldnt unlock cell", e );
        }
        return null;
    }
    
    public final WritableCellFormat UNLOCKED_CELL_FORMAT  = _unlockedCellFormat();

    public void setMp_rasId_qstIds(Map<Integer, List<Integer>> map) {
        this.mp_rasId_qstIds = map;
    }

    public Map<Integer, List<Integer>> getMp_rasId_qstIds() {
        return this.mp_rasId_qstIds;
    }

    private Map<Integer, List<Integer>> buildRasIdQstIdMap(ReportTemplateInfo reportTemplateInfo) {
        Map<Integer, List<Integer>> mpRasQst = null;//new HashMap<Integer, List<Integer>>();
        
        List<Integer> theQstIds = null;// = new ArrayList<Integer>();
        
        if ( this.reportTemplateInfoDataSet.getListOfQuestionsForAdditionalAnswers().size() > 0 ) {
            mpRasQst = new HashMap<Integer, List<Integer>>();
            
            for (Iterator<QuestionDataSetInfo> qt = this.reportTemplateInfoDataSet.getListOfQuestionsForAdditionalAnswers().iterator(); qt.hasNext();  ) {
                QuestionDataSetInfo qis = qt.next();
                int qstId = qis.getQst_id();
                int rasId = qis.getQst_ras_id();
                
                if ( mpRasQst.get( rasId ) == null ) {
                    theQstIds = new ArrayList<Integer>();
                } else {
                    theQstIds = mpRasQst.get( rasId );
                }
                
                theQstIds.add( qstId );
                
                mpRasQst.put( rasId, theQstIds );
            }
        }
        
        return mpRasQst;
        
    }

    public Map<Integer, List<Integer>> get_mp_rasId_qstIds() {
        return mp_rasId_qstIds;
    }

    public void setMp_firstRasId_col(Map<Integer, Integer> mp_rasId_col) {
        this.mp_firstRasId_col = mp_rasId_col;
    }

    public Map<Integer, Integer> getMp_firstRasId_col() {
        return mp_firstRasId_col;
    }

    public void setMp_firstRasId_row(Map<Integer, Integer> mp_firstRasId_row) {
        this.mp_firstRasId_row = mp_firstRasId_row;
    }

    public Map<Integer, Integer> getMp_firstRasId_row() {
        return mp_firstRasId_row;
    }
}
