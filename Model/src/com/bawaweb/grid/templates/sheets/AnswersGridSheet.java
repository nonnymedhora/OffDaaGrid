/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.sheets;

import java.text.DecimalFormat;

import java.util.Locale;

import org.apache.log4j.Logger;
import com.bawaweb.grid.templates.AnswersGridTemplate;
import com.bawaweb.grid.templates.AnswersGridTemplateRangeConstants;
import com.bawaweb.grid.templates.data.ReportTemplateInfo;

import com.bawaweb.grid.templates.data.cursors.MultiQuestionDataSetInfo;
import com.bawaweb.grid.templates.data.cursors.QuestionDataSetInfo;
import com.bawaweb.grid.templates.data.cursors.SourceAnswersDataSetInfo;
import com.bawaweb.grid.templates.data.tables.AnswerSetValuesDataSetInfo;
import com.bawaweb.grid.templates.data.tables.ReportAnswerSetValuesDataSetInfo;
import com.bawaweb.grid.templates.data.tables.SortingCriteriaValuesDataSetInfo;
import com.bawaweb.grid.templates.data.tables.SourceDataSetInfo;
import com.bawaweb.grid.templates.data.tables.TallyRangeLimitsValuesDataSetInfo;
import com.bawaweb.services.PlatformAppModuleService;
import com.bawaweb.utils.Pair;
import com.bawaweb.utils.SourcesComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import java.util.Map;

import java.util.Set;

import jxl.CellReferenceHelper;
import jxl.CellView;

import jxl.Range;

import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;

import jxl.write.Blank;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.NumberFormat;
import jxl.write.NumberFormats;
import jxl.write.WritableCell;
import jxl.write.WritableCellFeatures;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableHyperlink;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * This class generates the Answers Grid and displays the tallies for the
 * answers grid as well
 * 
 */
public class AnswersGridSheet {
	private static final Logger LOG = Logger.getLogger(AnswersGridSheet.class);

	private Pair pr_lastCellFilledInfo;

	private int lastTallyInfoColumnFilled;
	private int lastTallyInfoBottomRowFilled;
	private int lastTallyInfoTopRowFilled;
	private WritableCell lastTallyInfoCellFilled;

	private WritableWorkbook ansGridWorkbook;
	private WritableSheet ss;
	private ReportTemplateInfo reportTemplateInfoDataSet;

	private static final int NUM_EXTRA_SOURCES = AnswersGridTemplateRangeConstants.NUM_EXTRA_SOURCES;
	private static final int NUM_EXTRA_ANSWERS = AnswersGridTemplateRangeConstants.NUM_EXTRA_ANSWERS;
	private static final String EXTRA_SRC_LABEL = AnswersGridTemplateRangeConstants.EXTRA_SRC_LABEL;
	private static final String XTRA_SRC_SHEET_FORMULA_NAME = AnswersGridTemplateRangeConstants.XTRA_SRC_SHEET_FORMULA_NAME;
	private static final String XTRA_QSTNANS_SHEET_FORMULA_NAME = AnswersGridTemplateRangeConstants.XTRA_QSTNANS_SHEET_FORMULA_NAME;

	private Map<Integer, String> mp_R1C1Map;

	private Locale currentLocale;
	private boolean isCommaDecLocale;

	public AnswersGridSheet(Locale loc, WritableWorkbook ansBook, WritableSheet s, ReportTemplateInfo ris) {
		this.currentLocale = loc;
		this.isCommaDecLocale = getIsCommaDecLocale(this.currentLocale);
		printLocaleInfo();
		this.ansGridWorkbook = ansBook;
		this.ss = s;
		this.reportTemplateInfoDataSet = ris;
		this.mp_R1C1Map = buildMp_R1C1Map();
	}

	public void printList(List alist) {
		if (alist == null) {
			System.out.println("alist is null");
			return;
		}
		Iterator it = alist.iterator();
		while (it.hasNext())
			System.out.println("|" + it.next() + "|");
	}

	/**
	 * Builds the map connections the RC [row-column] information for a cell in
	 * Excel to the letter-number format A1, E3 etc
	 * 
	 * @return Map connecting the column number in the spreadsheet to its RC
	 *         equivalent
	 */
	public final Map<Integer, String> buildMp_R1C1Map() {
		Map<Integer, String> mp = new HashMap<Integer, String>();

		final int last = 255;
		final int chCount = 25;
		final int startChA = 65;
		final int endChZ = 90;

		int thecol = 0;

		while (thecol <= last) {
			int times = thecol / chCount;

			if (times > 0) {
				int pref = startChA + times - 1;

				for (int count = 0; count <= chCount; count++) {
					mp.put(thecol, String.valueOf((char) (pref)) + "" + String.valueOf((char) (count + startChA)));
					thecol++;
				}

			} else {
				for (int count = 0; count <= chCount; count++) {
					mp.put(thecol, String.valueOf((char) (count + startChA)));
					thecol++;
				}
			}

		}
		thecol++;

		return this.mp_R1C1Map = mp;
	}

	/**
	 * Utility method used to format the columns based on predetermined widths.
	 * <p>
	 * 5, 15 and 30;
	 */
	private void formatColumns() {
		Set<Integer> cols = this.hsh_maxColumnWidth.keySet();
		System.out.println("hash size " + this.hsh_maxColumnWidth.size());
		for (Iterator<Integer> it = cols.iterator(); it.hasNext();) {
			int thecol = it.next();
			int maxLength = this.hsh_maxColumnWidth.get(thecol);
			int width = 0;
			if (maxLength != 0) {
				if (maxLength <= 10)
					width = 5;
				else if (maxLength > 10 && maxLength <= 50)
					width = 15;
				else if (maxLength > 50 && maxLength <= 300)
					width = 30;
				else if (maxLength > 300)
					width = 45;
			}
			System.out.println("setting col " + thecol + " with " + width);
			this.ss.setColumnView(thecol, width);
		}
	}

	/**
	 * Validates whether an answer provided by a source exists in the set of
	 * tally options for that answer
	 * 
	 * @param tallyOptions
	 *            -- The array of options for an answer
	 * @param theAnswer
	 *            -- the answer provided by the source
	 * @return isFound -- true if the answer provided does exist within the
	 *         array of choices
	 */
	private boolean checkNumericAnswer(String[] tallyOptions, String theAnswer) {
		System.out.println("in checkNumericAnswer theanswer is -->" + theAnswer + "<--");
		boolean isFound = false;
		if (theAnswer == "" || theAnswer.equals(""))
			return isFound;

		for (int i = 0; i < tallyOptions.length; i++) {
			if (tallyOptions[i].equals(theAnswer) || tallyOptions[i] == theAnswer) {
				return isFound = true;
			}
		}
		return isFound;
	}

	/**
	 * Generates and prepends the question numbering information for the
	 * particular question
	 * 
	 * @param qis
	 *            -- The composite QuestionDataSetInfo object for the said
	 *            question
	 * @return a String combining the numeric and alpha portions is applicable
	 */
	private String processTheQuestion(QuestionDataSetInfo qis) {
		int qNum = qis.getQst_numeric();
		if (qNum == 0) {
			return qis.getQst_question();
		}
		String qAlpha = qis.getQst_alpha();
		String qstn = qis.getQst_question();
		try {
			if (qAlpha != null) {
				Integer.parseInt(qAlpha);
				return qNum + ". " + qis.getQst_question();
			}
		} catch (NumberFormatException e) {
			/* swallow it - do nothing */
			LOG.error("err numberformatexception in generating qstn label info", e);
		}

		return qNum + qAlpha + ". " + qis.getQst_question();

	}

	public ReportTemplateInfo getRis() {
		return this.reportTemplateInfoDataSet;
	}

	public void setReportTemplateInfoDataSet(ReportTemplateInfo ris) {
		this.reportTemplateInfoDataSet = ris;
	}

	private int getNumQuestions() {
		return getRis().getListOfQuestions().size();
	}

	private int getNumSources() {
		return getRis().getListOfSources().size();
	}

	/**
	 * The method used to generate the entire answers grid
	 * 
	 * @param xtraSrcsSheet
	 *            -- the extra sources worksheet containing info on extra
	 *            sources
	 * @param xtraQnsAnsSetsSheet
	 *            -- the extra answers sets worksheet containing extra answer
	 *            sets info
	 * @return the worksheet with the contents of the answers grid and its tally
	 *         information
	 */
	public WritableSheet createAnswersGridSheet(ExtraSourcesSheet xtraSrcsSheet,
			QuestionAnswerSetsDataSheet xtraQnsAnsSetsSheet) {

		// Sources contains seq,srcdisplayname, rprtr initials and repeat info
		fillSourcesData(this.ss, AnswersGridTemplateRangeConstants.RANGE_SOURCES_TOP_COL,
				AnswersGridTemplateRangeConstants.RANGE_SOURCES_TOP_ROW,
				AnswersGridTemplateRangeConstants.RANGE_SOURCES_BOT_COL, // AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_COL
																			// +
																			// getNumQuestions(),
				AnswersGridTemplateRangeConstants.RANGE_SOURCES_TOP_ROW + getNumSources());

		fillAdditionalSources(this.ss, AnswersGridTemplateRangeConstants.RANGE_SOURCES_TOP_COL,
				AnswersGridTemplateRangeConstants.RANGE_SOURCES_TOP_ROW + getNumSources());
		// questions contain the source answer data sets
		fillQuestionsData(this.ss, xtraQnsAnsSetsSheet, AnswersGridTemplateRangeConstants.RANGE_QUESTIONS_TOP_COL + 1,
				AnswersGridTemplateRangeConstants.RANGE_QUESTIONS_TOP_ROW,
				AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_COL + 1 + getNumQuestions(),
				AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW + getNumSources());

		this.ss.getSettings().setHorizontalFreeze(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_COL);
		this.ss.getSettings().setVerticalFreeze(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW);

		formatColumns();

		this.ss.getSettings().setProtected(false);
		this.ss.getSettings().setZoomFactor(75);
		return this.ss;
	}

	private WritableCellFormat _normRed() {
		WritableCellFormat normRed = null;
		try {
			WritableFont normRedFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD);
			normRedFont.setColour(AnswersGridTemplateRangeConstants.RED_COLOR);
			normRed = new WritableCellFormat(normRedFont);
			normRed.setBorder(Border.TOP, BorderLineStyle.THIN);
			normRed.setBorder(Border.BOTTOM, BorderLineStyle.THIN);
			normRed.setBorder(Border.RIGHT, BorderLineStyle.THIN);
			// normRed.setBackground(AnswersGridTemplateRangeConstants.YELLOW_COLOR);
			// nm1 normRed.setBorder(Border.RIGHT, BorderLineStyle.THICK);
			normRed.setWrap(true);
			;
			normRed.setShrinkToFit(true);
			normRed.setLocked(false);
		} catch (WriteException e) {
			e.printStackTrace();
			LOG.error("error in creating _normRed");
		}
		return normRed;
	}

	public final WritableCellFormat FRMT_NORM_RED = _normRed();

	private WritableCellFormat _commented() {
		WritableCellFormat norm = null;
		try {
			WritableFont normFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD);
			norm = new WritableCellFormat(normFont);
			norm.setBackground(AnswersGridTemplateRangeConstants.COMMENT_COLOR);
			norm.setBorder(Border.TOP, BorderLineStyle.THIN);
			norm.setBorder(Border.BOTTOM, BorderLineStyle.THIN);
			norm.setBorder(Border.LEFT, BorderLineStyle.THIN);
			norm.setBorder(Border.RIGHT, BorderLineStyle.THICK);
			/*
			 * nm1 norm.setBorder(Border.LEFT, BorderLineStyle.THICK);
			 */
			norm.setAlignment(Alignment.LEFT);
			norm.setVerticalAlignment(VerticalAlignment.TOP);
			norm.setWrap(true);
			;
			norm.setShrinkToFit(true);
			norm.setLocked(false);
		} catch (WriteException e) {
			e.printStackTrace();
			LOG.error("error in creating _commented");
		}
		return norm;
	}

	public final WritableCellFormat FRMT_COMMENT = _commented();

	private WritableCellFormat _boldRedInYellow() {
		WritableCellFormat boldRed = null;
		try {
			WritableFont boldRedFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
			boldRedFont.setColour(AnswersGridTemplateRangeConstants.RED_COLOR);
			boldRed = new WritableCellFormat(boldRedFont);
			boldRed.setBorder(Border.TOP, BorderLineStyle.THIN);
			boldRed.setBorder(Border.BOTTOM, BorderLineStyle.THIN);
			boldRed.setBackground(AnswersGridTemplateRangeConstants.YELLOW_COLOR);
			boldRed.setLocked(false);
		} catch (WriteException e) {
			e.printStackTrace();
			LOG.error("error in creating _boldRedInYellow");
		}
		return boldRed;
	}

	public final WritableCellFormat FRMT_BOLD_RED_IN_YELLOW = _boldRedInYellow();

	private WritableCellFormat _boldBlueInWhite() {
		WritableCellFormat boldBlue = null;
		try {
			WritableFont boldBlueFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
			boldBlueFont.setColour(AnswersGridTemplateRangeConstants.BLUE_COLOR);
			boldBlue = new WritableCellFormat(boldBlueFont);
			boldBlue.setBackground(AnswersGridTemplateRangeConstants.WHITE_COLOR);
			boldBlue.setLocked(false);
		} catch (WriteException e) {
			e.printStackTrace();
			LOG.error("error in creating _boldBlueInWhite");
		}
		return boldBlue;
	}

	public final WritableCellFormat FRMT_BOLD_BLUE_IN_YELLOW = _boldBlueInWhite();

	private WritableCellFormat _srcInfoDataCellFormat() {
		WritableCellFormat boldBlack = null;
		try {
			WritableFont boldBlackFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
			boldBlackFont.setColour(AnswersGridTemplateRangeConstants.BLACK_COLOR);
			boldBlack = new WritableCellFormat(boldBlackFont);
			boldBlack.setBackground(AnswersGridTemplateRangeConstants.WHITE_COLOR);
			boldBlack.setBorder(Border.TOP, BorderLineStyle.THIN);
			boldBlack.setBorder(Border.BOTTOM, BorderLineStyle.THIN);
			boldBlack.setBorder(Border.RIGHT, BorderLineStyle.THIN);
			/*
			 * nm1 boldBlack.setBorder(Border.RIGHT, BorderLineStyle.THICK);
			 */
			boldBlack.setWrap(true);
			boldBlack.setAlignment(Alignment.LEFT);
			boldBlack.setVerticalAlignment(VerticalAlignment.CENTRE); // JUSTIFY);
			boldBlack.setLocked(true);
			boldBlack.setShrinkToFit(true);
		} catch (WriteException e) {
			e.printStackTrace();
			LOG.error("error in creating _srcInfoDataCellFormat");
		}
		return boldBlack;
	}

	public final WritableCellFormat FRMT_SRC_INFO_DATA_CELL = _srcInfoDataCellFormat();

	private WritableCellFormat _repSrcInfoDataCellFormat() {
		WritableCellFormat justBlack = null;
		try {
			WritableFont blackFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD);
			blackFont.setColour(AnswersGridTemplateRangeConstants.REPEAT_COLOR);
			justBlack = new WritableCellFormat(blackFont);
			justBlack.setBorder(Border.TOP, BorderLineStyle.THIN);
			justBlack.setBorder(Border.BOTTOM, BorderLineStyle.THIN);
			justBlack.setBorder(Border.RIGHT, BorderLineStyle.THICK);
			justBlack.setWrap(true);
			justBlack.setAlignment(Alignment.LEFT);
			justBlack.setVerticalAlignment(VerticalAlignment.CENTRE); // JUSTIFY);
			justBlack.setLocked(true);
			justBlack.setShrinkToFit(true);
		} catch (WriteException e) {
			e.printStackTrace();
			LOG.error("error in creating _repSrcInfoDataCellFormat");
		}
		return justBlack;
	}

	public final WritableCellFormat FRMT_REP_SRC_ANS_CELL = _repSrcInfoDataCellFormat();

	private WritableCellFormat _numericAnswerFormat() {
		WritableCellFormat decimalFormat = null;
		try {
			WritableFont normalFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD);
			decimalFormat = new WritableCellFormat(NumberFormats.DEFAULT);// FLOAT
			decimalFormat.setBackground(AnswersGridTemplateRangeConstants.NUMERIC_COLOR);
			decimalFormat.setFont(normalFont);

			/* decimalFormat.setBorder(Border.LEFT, BorderLineStyle.THIN); */
			decimalFormat.setBorder(Border.TOP, BorderLineStyle.THIN);
			decimalFormat.setBorder(Border.BOTTOM, BorderLineStyle.THIN);
			decimalFormat.setBorder(Border.RIGHT, BorderLineStyle.THIN);
			decimalFormat.setWrap(true);
			decimalFormat.setAlignment(Alignment.CENTRE);
			decimalFormat.setVerticalAlignment(VerticalAlignment.TOP);
		} catch (WriteException e) {
			e.printStackTrace();
			LOG.error("error in creating _numericAnswerFormat");
		}
		return decimalFormat;
	}

	public final WritableCellFormat FRMT_NUMERIC_CELL = _numericAnswerFormat();

	private WritableCellFormat _wrapNormalAnswerFormat() {
		WritableCellFormat wrapNormalAnswerFormat = null;
		try {
			WritableFont normalFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD);
			wrapNormalAnswerFormat = new WritableCellFormat(normalFont);
			wrapNormalAnswerFormat.setBorder(Border.TOP, BorderLineStyle.THIN);
			wrapNormalAnswerFormat.setBorder(Border.BOTTOM, BorderLineStyle.THIN);
			wrapNormalAnswerFormat.setBorder(Border.LEFT, BorderLineStyle.THIN);
			wrapNormalAnswerFormat.setBorder(Border.RIGHT, BorderLineStyle.THIN);
			/*
			 * nm1 wrapNormalAnswerFormat.setBorder(Border.RIGHT,
			 * BorderLineStyle.THICK);
			 * wrapNormalAnswerFormat.setBorder(Border.LEFT,
			 * BorderLineStyle.THICK);
			 */
			wrapNormalAnswerFormat.setWrap(true);
			wrapNormalAnswerFormat.setAlignment(Alignment.CENTRE);
			wrapNormalAnswerFormat.setVerticalAlignment(VerticalAlignment.TOP);
			wrapNormalAnswerFormat.setLocked(true);
			wrapNormalAnswerFormat.setShrinkToFit(true);
		} catch (WriteException e) {
			e.printStackTrace();
			LOG.error("error in creating _wrapNormalAnswerFormat");
		}
		return wrapNormalAnswerFormat;
	}

	public final WritableCellFormat FRMT_WRAP_NORMAL_ANS_CELL = _wrapNormalAnswerFormat();

	private WritableCellFormat _wrapNormalAnswerTextHintFormat() {
		WritableCellFormat wrapNormalAnswerFormat = null;
		try {
			WritableFont normalFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD);
			wrapNormalAnswerFormat = new WritableCellFormat(normalFont);
			wrapNormalAnswerFormat.setBorder(Border.TOP, BorderLineStyle.THIN);
			wrapNormalAnswerFormat.setBorder(Border.BOTTOM, BorderLineStyle.THIN);
			wrapNormalAnswerFormat.setBorder(Border.RIGHT, BorderLineStyle.THICK);
			wrapNormalAnswerFormat.setBorder(Border.LEFT, BorderLineStyle.THIN);
			/*
			 * nm1
			 * 
			 * wrapNormalAnswerFormat.setBorder(Border.LEFT,
			 * BorderLineStyle.THICK);
			 */
			wrapNormalAnswerFormat.setWrap(true);
			wrapNormalAnswerFormat.setAlignment(Alignment.CENTRE);
			wrapNormalAnswerFormat.setVerticalAlignment(VerticalAlignment.TOP);
			wrapNormalAnswerFormat.setLocked(true);
			wrapNormalAnswerFormat.setShrinkToFit(true);
		} catch (WriteException e) {
			e.printStackTrace();
			LOG.error("error in creating _wrapNormalAnswerTextHintFormat");
		}
		return wrapNormalAnswerFormat;
	}

	public WritableCellFormat FRMT_WRAP_NORMAL_ANS_HINT_CELL = _wrapNormalAnswerTextHintFormat();

	private WritableCellFormat _wrapNumAnswerTextFormat() {
		WritableCellFormat wrapNormalAnswerFormat = null;
		try {
			WritableFont normalFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD);
			wrapNormalAnswerFormat = new WritableCellFormat(normalFont);
			wrapNormalAnswerFormat.setBorder(Border.TOP, BorderLineStyle.THIN);
			wrapNormalAnswerFormat.setBorder(Border.BOTTOM, BorderLineStyle.THIN);
			wrapNormalAnswerFormat.setBorder(Border.RIGHT, BorderLineStyle.THICK);
			wrapNormalAnswerFormat.setBorder(Border.LEFT, BorderLineStyle.THIN);
			// wrapNormalAnswerFormat.setBackground(AnswersGridTemplateRangeConstants.NUMERIC_ANSTEXT_COLOR);
			/*
			 * nm1
			 * 
			 * wrapNormalAnswerFormat.setBorder(Border.LEFT,
			 * BorderLineStyle.THICK);
			 */
			wrapNormalAnswerFormat.setWrap(true);
			wrapNormalAnswerFormat.setAlignment(Alignment.CENTRE);
			wrapNormalAnswerFormat.setVerticalAlignment(VerticalAlignment.TOP);
			wrapNormalAnswerFormat.setLocked(true);
			wrapNormalAnswerFormat.setShrinkToFit(true);
		} catch (WriteException e) {
			e.printStackTrace();
			LOG.error("error in creating _wrapNumAnswerTextFormat");
		}
		return wrapNormalAnswerFormat;
	}

	public final WritableCellFormat FRMT_WRAP_NUM_ANS_TEXT_CELL = _wrapNumAnswerTextFormat();

	private WritableCellFormat _qstnInfoDataCellFormat() {
		WritableCellFormat boldBlack = null;
		try {
			WritableFont boldBlackFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD);
			boldBlackFont.setColour(AnswersGridTemplateRangeConstants.BLACK_COLOR);
			boldBlack = new WritableCellFormat(boldBlackFont);
			// boldBlack.setBackground(AnswersGridTemplateRangeConstants.GENERIC_QSTNS_COLOR);
			boldBlack.setBorder(Border.ALL, BorderLineStyle.THIN);
			boldBlack.setWrap(true);
			boldBlack.setAlignment(Alignment.CENTRE);
			boldBlack.setVerticalAlignment(VerticalAlignment.TOP); // JUSTIFY);
			boldBlack.setLocked(true);
			boldBlack.setShrinkToFit(true);
		} catch (WriteException e) {
			e.printStackTrace();
			LOG.error("error in creating _qstnInfoDataCellFormat");
		}
		return boldBlack;
	}

	public final WritableCellFormat FRMT_QSTN_INFO_DATA_CELL = _qstnInfoDataCellFormat();

	private WritableCellFormat _qstnHintInfoDataCellFormat() {
		WritableCellFormat boldBlack = null;
		try {
			WritableFont boldBlackFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD);
			boldBlackFont.setColour(AnswersGridTemplateRangeConstants.BLACK_COLOR);
			boldBlack = new WritableCellFormat(boldBlackFont);
			boldBlack.setBackground(AnswersGridTemplateRangeConstants.QSTNS_COLOR);
			boldBlack.setBorder(Border.RIGHT, BorderLineStyle.THICK);
			boldBlack.setWrap(true);
			boldBlack.setAlignment(Alignment.LEFT);
			boldBlack.setVerticalAlignment(VerticalAlignment.CENTRE); // JUSTIFY);
			boldBlack.setLocked(true);
			boldBlack.setShrinkToFit(true);
		} catch (WriteException e) {
			e.printStackTrace();
			LOG.error("error in creating _qstnHintInfoDataCellFormat");
		}
		return boldBlack;
	}

	public final WritableCellFormat FRMT_QSTN_HINT_INFO_DATA_CELL = _qstnHintInfoDataCellFormat();

	private WritableCellFormat _wghtdQstnInfoDataCellFormat() {
		WritableCellFormat boldBlack = null;
		try {
			WritableFont boldBlackFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD);
			boldBlackFont.setColour(AnswersGridTemplateRangeConstants.BLACK_COLOR);
			boldBlack = new WritableCellFormat(boldBlackFont, NumberFormats.DEFAULT);// FLOAT
			boldBlack.setBackground(AnswersGridTemplateRangeConstants.WGHTD_COLOR);
			boldBlack.setBorder(Border.TOP, BorderLineStyle.THIN);
			boldBlack.setBorder(Border.BOTTOM, BorderLineStyle.THIN);
			boldBlack.setBorder(Border.RIGHT, BorderLineStyle.THIN);
			boldBlack.setWrap(true);
			boldBlack.setAlignment(Alignment.CENTRE);
			boldBlack.setVerticalAlignment(VerticalAlignment.TOP); // JUSTIFY);
			boldBlack.setLocked(true);
			boldBlack.setShrinkToFit(true);
		} catch (WriteException e) {
			e.printStackTrace();
			LOG.error("error in creating _wghtdQstnInfoDataCellFormat");
		}
		return boldBlack;
	}

	public final WritableCellFormat FRMT_WGTD_QSTN_INFO_DATA_CELL = _wghtdQstnInfoDataCellFormat();

	private WritableCellFormat _wghtdQstnHintInfoDataCellFormat() {
		WritableCellFormat boldBlack = null;
		try {
			WritableFont boldBlackFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD);
			boldBlackFont.setColour(AnswersGridTemplateRangeConstants.RED_COLOR);
			boldBlack = new WritableCellFormat(boldBlackFont, NumberFormats.FLOAT);
			boldBlack.setBackground(AnswersGridTemplateRangeConstants.WGHTD_COLOR);
			boldBlack.setBorder(Border.RIGHT, BorderLineStyle.THICK);
			boldBlack.setWrap(true);
			boldBlack.setAlignment(Alignment.CENTRE);
			boldBlack.setVerticalAlignment(VerticalAlignment.TOP); // JUSTIFY);
			boldBlack.setLocked(true);
			boldBlack.setShrinkToFit(true);
		} catch (WriteException e) {
			e.printStackTrace();
			LOG.error("error in creating _wghtdQstnHintInfoDataCellFormat");
		}
		return boldBlack;
	}

	public final WritableCellFormat FRMT_WGTD_QSTN_HINT_INFO_DATA_CELL = _wghtdQstnHintInfoDataCellFormat();

	private WritableCellFormat _singleAnsDataCellFormat() {
		WritableCellFormat singleAnsCellFormat = null;
		try {
			WritableFont singleAnsFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD);
			singleAnsFont.setColour(AnswersGridTemplateRangeConstants.BLACK_COLOR);
			singleAnsCellFormat = new WritableCellFormat(singleAnsFont);
			singleAnsCellFormat.setBackground(AnswersGridTemplateRangeConstants.SINGLE_COLOR);
			singleAnsCellFormat.setWrap(true);
			singleAnsCellFormat.setBorder(Border.TOP, BorderLineStyle.THIN);
			singleAnsCellFormat.setBorder(Border.BOTTOM, BorderLineStyle.THIN);
			singleAnsCellFormat.setBorder(Border.RIGHT, BorderLineStyle.THIN);
			singleAnsCellFormat.setAlignment(Alignment.CENTRE);
			singleAnsCellFormat.setVerticalAlignment(VerticalAlignment.TOP); // JUSTIFY);
			singleAnsCellFormat.setLocked(true);
			singleAnsCellFormat.setShrinkToFit(true);
		} catch (WriteException e) {
			e.printStackTrace();
			LOG.error("error in creating _singleAnsDataCellFormat");
		}
		return singleAnsCellFormat;
	}

	public final WritableCellFormat FRMT_SINGLE_ANS_DATA_CELL = _singleAnsDataCellFormat();

	private WritableCellFormat _sortedQstnInfoDataCellFormat() {
		WritableCellFormat boldBlack = null;
		try {
			WritableFont boldBlackFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD);
			boldBlackFont.setColour(AnswersGridTemplateRangeConstants.BLACK_COLOR);
			boldBlack = new WritableCellFormat(boldBlackFont);
			boldBlack.setBackground(AnswersGridTemplateRangeConstants.SORT_COLOR);
			boldBlack.setBorder(Border.TOP, BorderLineStyle.THIN);
			boldBlack.setBorder(Border.BOTTOM, BorderLineStyle.THIN);
			boldBlack.setBorder(Border.RIGHT, BorderLineStyle.THIN);
			boldBlack.setWrap(true);
			boldBlack.setAlignment(Alignment.JUSTIFY);// CENTRE);
			boldBlack.setVerticalAlignment(VerticalAlignment.TOP); // JUSTIFY);
			boldBlack.setLocked(true);
			boldBlack.setShrinkToFit(true);
		} catch (WriteException e) {
			e.printStackTrace();
			LOG.error("error in creating _sortedQstnInfoDataCellFormat");
		}
		return boldBlack;
	}

	public final WritableCellFormat FRMT_SORT_QSTN_INFO_DATA_CELL = _sortedQstnInfoDataCellFormat();

	private WritableCellFormat _sortedQstnHintInfoDataCellFormat() {
		WritableCellFormat boldBlack = null;
		try {
			WritableFont boldBlackFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD);
			boldBlackFont.setColour(AnswersGridTemplateRangeConstants.BLUE_COLOR);
			boldBlack = new WritableCellFormat(boldBlackFont);
			boldBlack.setBackground(AnswersGridTemplateRangeConstants.SORT_COLOR);
			boldBlack.setBorder(Border.TOP, BorderLineStyle.THIN);
			boldBlack.setBorder(Border.BOTTOM, BorderLineStyle.THIN);
			boldBlack.setBorder(Border.RIGHT, BorderLineStyle.THICK);
			boldBlack.setWrap(true);
			boldBlack.setAlignment(Alignment.JUSTIFY);// CENTRE);
			boldBlack.setVerticalAlignment(VerticalAlignment.TOP); // JUSTIFY);
			boldBlack.setLocked(true);
			boldBlack.setShrinkToFit(true);
		} catch (WriteException e) {
			e.printStackTrace();
			LOG.error("error in creating _sortedQstnHintInfoDataCellFormat");
		}
		return boldBlack;
	}

	public final WritableCellFormat FRMT_SORT_QSTN_HINT_INFO_DATA_CELL = _sortedQstnHintInfoDataCellFormat();

	private WritableCellFormat _sortedQstnAnsInfoDataCellFormat() {
		WritableCellFormat boldBlue = null;
		try {
			WritableFont boldBlueFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD);
			boldBlueFont.setColour(AnswersGridTemplateRangeConstants.BLUE_COLOR);
			boldBlue = new WritableCellFormat(boldBlueFont);
			boldBlue.setBackground(AnswersGridTemplateRangeConstants.SORT_COLOR);
			boldBlue.setBorder(Border.TOP, BorderLineStyle.THIN);
			boldBlue.setBorder(Border.BOTTOM, BorderLineStyle.THIN);
			boldBlue.setBorder(Border.RIGHT, BorderLineStyle.THIN);
			boldBlue.setWrap(true);
			boldBlue.setAlignment(Alignment.CENTRE);
			boldBlue.setVerticalAlignment(VerticalAlignment.TOP); // JUSTIFY);
			boldBlue.setLocked(true);
			boldBlue.setShrinkToFit(true);
		} catch (WriteException e) {
			e.printStackTrace();
			LOG.error("error in creating _sortedQstnAnsInfoDataCellFormat");
		}
		return boldBlue;
	}

	public final WritableCellFormat FRMT_SORT_QSTN_ANSINFO_DATA_CELL = _sortedQstnAnsInfoDataCellFormat();

	private WritableCellFormat _multiQstnInfoDataCellFormat() {
		WritableCellFormat boldBlack = null;
		try {
			WritableFont boldBlackFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD);
			boldBlackFont.setColour(AnswersGridTemplateRangeConstants.BLACK_COLOR);
			boldBlack = new WritableCellFormat(boldBlackFont);
			boldBlack.setBackground(AnswersGridTemplateRangeConstants.MULTI_COLOR);
			boldBlack.setBorder(Border.TOP, BorderLineStyle.THIN);
			boldBlack.setBorder(Border.BOTTOM, BorderLineStyle.THIN);
			boldBlack.setBorder(Border.RIGHT, BorderLineStyle.THIN);
			boldBlack.setWrap(true);
			boldBlack.setAlignment(Alignment.CENTRE);
			boldBlack.setVerticalAlignment(VerticalAlignment.TOP); // JUSTIFY);
			boldBlack.setLocked(true);
			boldBlack.setShrinkToFit(true);
		} catch (WriteException e) {
			e.printStackTrace();
			LOG.error("error in creating _multiQstnInfoDataCellFormat");
		}
		return boldBlack;
	}

	public final WritableCellFormat FRMT_MULTI_QSTN_INFO_DATA_CELL = _multiQstnInfoDataCellFormat();

	/**
	 * Map to determine the maximum widths for a column maps column to the
	 * max-length
	 */
	private Map<Integer, Integer> hsh_maxColumnWidth = new Hashtable<Integer, Integer>();

	private String processStingForWrap_0(String text, int limit) {
		if (text.length() < limit)
			return text;
		else {
			String retVal = "";// = text.substring(0,limit);
			String bal = text;// text.substring(limit);
			int total = text.length();
			int times = total / limit; // System.out.println("times is " +
										// times); // row height
			for (int i = 0; i <= times; i++) {
				if (bal.length() > limit) {
					retVal += bal.substring(0, limit) + "\n";
					bal = bal.substring(limit);
				} else {
					retVal += bal;
				}
			}
			return retVal;
		}
	}

	/**
	 *
	 * sets the max length of the string in a col to the colwidth hash
	 * hsh_maxColumnWidth and then returns the string. the
	 * createAnswersGridSheet will call the formatColumns method which will use
	 * the values off the hsh_maxColumnWidth to set the column's width
	 * 
	 * @param text
	 *            -- the textual string contents for the cell
	 * @param col
	 *            -- the column info
	 * @return text -- the same textual string contents is returned and will
	 *         occupy the cells contents --- in future this method may be a
	 *         place for adding a filter - say to prevent funny-characters, or
	 *         semi-colons for sql injections via the Excel file
	 */
	private String processStringForWrap(String text, int col) {
		if (text == null)
			System.out.println("processStringForWrap --- text is null for col " + col);
		int existingMax = this.hsh_maxColumnWidth.get(col) != null ? this.hsh_maxColumnWidth.get(col) : 0;
		if (text != null) {
			if (text.length() > existingMax) {
				this.hsh_maxColumnWidth.put(col, text.length());
			}
		}
		return text != null ? text : "";
	}

	/**
	 * Fills in the row for additional sources
	 * 
	 * @param s
	 *            -- the sheet to write the info to
	 * @param top_col
	 *            -- start column
	 * @param top_row
	 *            -- start row
	 * @see AnswersGridTemplateRangeConstants
	 */
	private void fillAdditionalSources(WritableSheet s, int top_col, int top_row) {
		// add space fpr 20 additional sources
		int col = top_col;
		int row = top_row;
		int srcSeq = getNumSources() + 1;

		String style = this.reportTemplateInfoDataSet.getSourceDisplayNameStyle();

		String[] ynv = new String[] { "Yes", "No" };
		List<String> ynList = Arrays.asList(ynv);

		String rprtrinit = this.reportTemplateInfoDataSet.getReportGeneralInfo().getReporterGeneralInfo().getFname()
				.substring(0, 1).toUpperCase()
				+ this.reportTemplateInfoDataSet.getReportGeneralInfo().getReporterGeneralInfo().getLname()
						.substring(0, 1).toUpperCase();

		final int xtraSheetStartRow = AnswersGridTemplateRangeConstants.RANGE_EXTRA_SOURCEFIELDS_TOP_ROW + 1;

		String displayNameStyle = this.reportTemplateInfoDataSet.getSourceDisplayNameStyle();
		displayNameStyle = displayNameStyle != null ? displayNameStyle : "NORMAL";
		System.out.println("displayNameStyle  is " + displayNameStyle);

		String formula = "";
		final String xtraSrcsSheet = XTRA_SRC_SHEET_FORMULA_NAME;

		for (int i = 1; i < (NUM_EXTRA_SOURCES + 1); i++, srcSeq++, row++) {
			col = top_col;

			// col = top_col + 1; // nothing in hidden colum
			int xtraRow = (xtraSheetStartRow + i);
			try {
				Label xtraSrcLabel = new Label(col, row, EXTRA_SRC_LABEL + "_" + i);
				CellView hideView = new CellView();
				hideView.setHidden(true);
				s.setColumnView(col, hideView);
				s.addCell(xtraSrcLabel);
				col++;

				Label srcSeqLabel = new Label(col, row, String.valueOf(srcSeq));

				s.addCell(srcSeqLabel);

				col++;
				// displayname
				if (displayNameStyle.equalsIgnoreCase("NAME") || displayNameStyle.equalsIgnoreCase("NORMAL")) {
					formula = "CONCATENATE(" + xtraSrcsSheet + "C" + xtraRow + ", \" \", " + xtraSrcsSheet + "D"
							+ xtraRow + ", \" \", " + xtraSrcsSheet + "E" + xtraRow + ")";
				} else if (displayNameStyle.equalsIgnoreCase("JOB TITLE")) {
					formula = xtraSrcsSheet + "J" + xtraRow;
				} else if (displayNameStyle.equalsIgnoreCase("COMPANY")) {
					formula = xtraSrcsSheet + "I" + xtraRow;
				} else if (displayNameStyle.equalsIgnoreCase("CITY")) {
					formula = xtraSrcsSheet + "S" + xtraRow;
				} else if (displayNameStyle.equalsIgnoreCase("CO,NAME")) {
					formula = "CONCATENATE(" + xtraSrcsSheet + "I" + xtraRow + ", \" \", " + xtraSrcsSheet + "C"
							+ xtraRow + ", \" \", " + xtraSrcsSheet + "D" + xtraRow + ", \" \", " + xtraSrcsSheet + "E"
							+ xtraRow + ")";
				} else if (displayNameStyle.equalsIgnoreCase("CO,JOB")) {
					formula = "CONCATENATE(" + xtraSrcsSheet + "I" + xtraRow + ", \" \", " + xtraSrcsSheet + "J"
							+ xtraRow + ")";
				} else if (displayNameStyle.equalsIgnoreCase("NAME,JOB")) {
					formula = "CONCATENATE(" + xtraSrcsSheet + "C" + xtraRow + ", \" \", " + xtraSrcsSheet + "D"
							+ xtraRow + ", \" \", " + xtraSrcsSheet + "E" + xtraRow + ", \" \", " + xtraSrcsSheet + "J"
							+ xtraRow + ")";
				} else if (displayNameStyle.equalsIgnoreCase("CO,JOB,N")) {
					formula = "CONCATENATE(" + xtraSrcsSheet + "I" + xtraRow + ", \" \", " + xtraSrcsSheet + "J"
							+ xtraRow + ", \" \", " + xtraSrcsSheet + "C" + xtraRow + ", \" \", " + xtraSrcsSheet + "D"
							+ xtraRow + ", \" \", " + xtraSrcsSheet + "E" + xtraRow + ")";
				} else if (displayNameStyle.equalsIgnoreCase("CO,JOB,C,S")) {
					formula = "CONCATENATE(" + xtraSrcsSheet + "I" + xtraRow + ", \" \", " + xtraSrcsSheet + "J"
							+ xtraRow + ", \" \", " + xtraSrcsSheet + "S" + xtraRow + ", \" \", " + xtraSrcsSheet + "T"
							+ xtraRow + ")";
				} else if (displayNameStyle.equalsIgnoreCase("CO,C,S")) {
					formula = "CONCATENATE(" + xtraSrcsSheet + "I" + xtraRow + ", \" \", " + xtraSrcsSheet + "S"
							+ xtraRow + ", \" \", " + xtraSrcsSheet + "T" + xtraRow + ")";
				} else if (displayNameStyle.equalsIgnoreCase("CO,C,S,N")) {
					formula = "CONCATENATE(" + xtraSrcsSheet + "I" + xtraRow + ", \" \", " + xtraSrcsSheet + "S"
							+ xtraRow + ", \" \", " + xtraSrcsSheet + "T" + xtraRow + ", \" \", " + xtraSrcsSheet + "C"
							+ xtraRow + ", \" \", " + xtraSrcsSheet + "D" + xtraRow + ", \" \", " + xtraSrcsSheet + "E"
							+ xtraRow + ")";
				} else if (displayNameStyle.equalsIgnoreCase("CO,C,S,J,N")) {
					formula = "CONCATENATE(" + xtraSrcsSheet + "I" + xtraRow + ", \" \", " + xtraSrcsSheet + "S"
							+ xtraRow + ", \" \", " + xtraSrcsSheet + "T" + xtraRow + ", \" \", " + xtraSrcsSheet + "J"
							+ xtraRow + ", \" \", " + xtraSrcsSheet + "C" + xtraRow + ", \" \", " + xtraSrcsSheet + "D"
							+ xtraRow + ", \" \", " + xtraSrcsSheet + "E" + xtraRow + ")";
				} else if (displayNameStyle.equalsIgnoreCase("IS,CO,N")) {
					formula = "CONCATENATE(" + xtraSrcsSheet + "AA" + xtraRow + ", \" \", " + xtraSrcsSheet + "I"
							+ xtraRow + ", \" \", " + xtraSrcsSheet + "C" + xtraRow + ", \" \", " + xtraSrcsSheet + "D"
							+ xtraRow + ", \" \", " + xtraSrcsSheet + "E" + xtraRow + ")";
				} else if (displayNameStyle.equalsIgnoreCase("IS,CO,J,N")) {
					formula = "CONCATENATE(" + xtraSrcsSheet + "I" + xtraRow + ", \" \", " + xtraSrcsSheet + "S"
							+ xtraRow + ", \" \", " + xtraSrcsSheet + "J" + xtraRow + ", \" \", " + xtraSrcsSheet + "T"
							+ xtraRow + ", \" \", " + xtraSrcsSheet + "J" + xtraRow + ", \" \", " + xtraSrcsSheet + "C"
							+ xtraRow + ", \" \", " + xtraSrcsSheet + "D" + xtraRow + ", \" \", " + xtraSrcsSheet + "E"
							+ xtraRow + ")";
				} else if (displayNameStyle.equalsIgnoreCase("N,JOB,IS")) {
					formula = "CONCATENATE(" + xtraSrcsSheet + "C" + xtraRow + ", \" \", " + xtraSrcsSheet + "D"
							+ xtraRow + ", \" \", " + xtraSrcsSheet + "E" + xtraRow + ", \" \", " + xtraSrcsSheet + "J"
							+ xtraRow + ", \" \", " + xtraSrcsSheet + "AA" + xtraRow + ")";
				}

				Formula fmSdn = new Formula(col, row, formula);
				s.addCell(fmSdn);

				col++;
				// rprts
				Label rprtrLabel = new Label(col, row, rprtrinit);
				s.addCell(rprtrLabel);

				col++;
				// repeat
				Label repLabel = new Label(col, row, "No");
				WritableCellFeatures addedfeatures = new WritableCellFeatures();
				addedfeatures.setDataValidationList(ynList);

				repLabel.setCellFeatures(addedfeatures);

				s.addCell(repLabel);

			} catch (RowsExceededException e) {
				e.printStackTrace();
			} catch (WriteException e) {
				e.printStackTrace();
			}
			col++;

		}
	}

	/**
	 * Fills in the source information data
	 * 
	 * @param s
	 * @param top_col
	 * @param top_row
	 * @param bot_col
	 * @param bot_row
	 */
	private void fillSourcesData(WritableSheet s, int top_col, int top_row, int bot_col, int bot_row) {
		try {
			s.addCell(new Label(0, 0, AnswersGridTemplateRangeConstants.PLS_DONT_CHANGE_ROW_COL));
		} catch (WriteException e) {
			e.printStackTrace();
			LOG.error("Error in adding cell at 0,0");
		}

		int col = top_col;
		int row = top_row;
		int srcSeq = 1;

		List<SourceDataSetInfo> sources = this.reportTemplateInfoDataSet.getListOfSources();

		Collections.sort(sources, new SourcesComparator());

		try {
			s.addCell(new Label(top_col + 1, top_row - 1, processStringForWrap("Seq.", top_col + 1),
					FRMT_WRAP_NORMAL_ANS_CELL));
			s.addCell(new Label(top_col + 2, top_row - 1, "SourceName", FRMT_WRAP_NORMAL_ANS_CELL));
			s.addCell(new Label(top_col + 3, top_row - 1, processStringForWrap("Rptr", top_col + 3),
					FRMT_WRAP_NORMAL_ANS_CELL)); // Reporter
			Label repSrcsLabl = new Label(top_col + 4, top_row - 1, processStringForWrap("Repeat", top_col + 4),
					FRMT_REP_SRC_ANS_CELL);// Sources\

			s.addCell(repSrcsLabl);

			s.addCell(new Label(top_col + 4, 0, "Repeat"));// Sources
		} catch (WriteException e) {
			e.printStackTrace();
			LOG.error("error in adding source header cells");
		}

		String[] ynv = new String[] { "Yes", "No" };
		List<String> ynList = Arrays.asList(ynv);

		// position
		Label yesLabel = new Label(top_col + 4, top_row + this.getNumSources() + NUM_EXTRA_SOURCES + 10, "Yes");
		Label noLabel = new Label(top_col + 4, top_row + this.getNumSources() + NUM_EXTRA_SOURCES + 11, "No");
		try {
			s.addCell(yesLabel);
			s.addCell(noLabel);
		} catch (RowsExceededException e) {
			e.printStackTrace();
			LOG.error("rows exceeded");
		} catch (WriteException e) {
			e.printStackTrace();
			LOG.error("write exception");
		}

		for (Iterator it = sources.iterator(); it.hasNext(); srcSeq++, row++) { // for
																				// each
																				// src

			col = top_col; // reset to first col
			SourceDataSetInfo sis = (SourceDataSetInfo) it.next();
			boolean found = false;
			try {
				jxl.write.Number srcIdCell = new jxl.write.Number(col, row, sis.getRps_id());
				CellView hideView = new CellView();
				hideView.setHidden(true);
				s.addCell(srcIdCell);
				s.setColumnView(col, hideView);
				col++;

				Label srcSeqLabel = new Label(col, row, String.valueOf(srcSeq));

				WritableHyperlink whl = new WritableHyperlink(col, row,
						sis.getSrc_display_name().replaceAll("null", ""), (WritableSheet) AnswersGridTemplate
								.getSheetMap().get(AnswersGridTemplateRangeConstants.SOURCE_DETAILS_SHEET_NAME),
						0, row + 2);
				s.addHyperlink(whl);
				s.addCell(srcSeqLabel);
				col++;

				String srcDisplay = sis.getSrc_display_name();
				Label srcLabel = new Label(col, row, processStringForWrap(srcDisplay.replaceAll("null", ""), col));
				srcLabel.setCellFormat(FRMT_SRC_INFO_DATA_CELL);
				s.addCell(srcLabel);

				// reporter initials
				col++;
				Label reporterInitLabel = new Label(col, row, sis.getEmp_init());
				s.addCell(reporterInitLabel);

				// repeat info
				col++;
				String isRepeat = sis.getRps_repeat_source_yn().equalsIgnoreCase("Y") ? "Yes" : "No";
				Label repSrcLabel = new Label(col, row, isRepeat);
				repSrcLabel.setCellFormat(FRMT_REP_SRC_ANS_CELL);

				WritableCellFeatures addedfeatures = new WritableCellFeatures();
				addedfeatures.setDataValidationList(ynList);

				repSrcLabel.setCellFeatures(addedfeatures);

				s.addCell(repSrcLabel);

			} catch (RowsExceededException e) {
				e.printStackTrace();
			} catch (WriteException e) {
				e.printStackTrace();
			}

			col = top_col;
		} // ends for
	}

	/**
	 * fills question info data into the sheet
	 * 
	 * @param s
	 * @param xtraQnsAnsSetsSheet
	 * @param top_col
	 * @param top_row
	 * @param bot_col
	 * @param bot_row
	 */
	private void fillQuestionsData(WritableSheet s, QuestionAnswerSetsDataSheet xtraQnsAnsSetsSheet, int top_col,
			int top_row, int bot_col, int bot_row) {
		// just defaulting it
		this.lastTallyInfoBottomRowFilled = 0;
		this.lastTallyInfoColumnFilled = 0;
		this.lastTallyInfoTopRowFilled = 0;

		int col = top_col;
		int row = top_row;

		for (Iterator<QuestionDataSetInfo> it = this.reportTemplateInfoDataSet.getListOfQuestions().iterator(); it
				.hasNext(); col++) {
			row = top_row;
			QuestionDataSetInfo qis = it.next();

			String qstnType = qis.getQst_type();
			boolean qstnTxtHintColRqd = qis.getQst_text_required_yn().equalsIgnoreCase("Y") ? true : false;

			LinkedHashMap<Integer, SourceAnswersDataSetInfo> sadMap = qis.getSourceAnswersDataSets();

			if (sadMap == null) {
				System.err.println("Uh-oh");
				return;
			}
			if (col == 256) {
				System.out.println("[256] qis  qid" + qis.getQst_id());
				break;
			}
			try {
				if (qstnType == "WEIGHT" || qstnType.equals("WEIGHT")) {
					fillWeightedQuestionsData(qis, sadMap, s, col, row);
					if (qstnTxtHintColRqd) {
						s.mergeCells(col, 1, col + 1, 1);

						col = col + 1; // for qstntxt and hint
					}
				} else if (qstnType == "MULTI" || qstnType.equals("MULTI")) {
					fillMultiQuestionsData(qis, sadMap, s, xtraQnsAnsSetsSheet, col, row);
					int qNums = qis.getQst_multi_answers();
					// to find data type multi questions -- we need 2 cols - one
					// for value and one for drop down
					int singqstns = 0;
					List<MultiQuestionDataSetInfo> mqinfo = qis.getMultiQuestionInfo();
					for (Iterator<MultiQuestionDataSetInfo> mt = mqinfo.iterator(); mt.hasNext();) {
						MultiQuestionDataSetInfo minf = mt.next();
						if (minf.getQmq_type() == "DATA" || minf.getQmq_type().equals("DATA")) {
							singqstns += 1;
						}
					}

					if (qstnTxtHintColRqd) {
						s.mergeCells(col, 1, col + qNums + singqstns/* + 1 */, 1);
						col = col + qNums + singqstns/* + 1 */;
					} else {
						s.mergeCells(col, 1, col + qNums + singqstns, 1);
						col = col + qNums + singqstns;
					}
				} else if (qstnType == "SINGLE" || qstnType.equals("SINGLE")) {
					fillSingleQuestionData(qis, sadMap, s, xtraQnsAnsSetsSheet, col, row);
					if (qstnTxtHintColRqd) {
						s.mergeCells(col, 1, col + 1, 1);
						col = col + 1; // for qstntxt and hint
					}
				} else if (qstnType == "RATING" || qstnType.equals("RATING")) {
					fillGenericQuestionData(qis, sadMap, s, col, row);
					if (qstnTxtHintColRqd) {
						s.mergeCells(col, 1, col + 1, 1);
						col = col + 1; // for qstntxt and hint
					}
				} else if (qstnType == "DATA" || qstnType.equals("DATA")) {
					fillNumericQuestionData(qis, sadMap, s, col, row);
					if (qstnTxtHintColRqd) {
						s.mergeCells(col, 1, col + 2, 1);
						col = col + 2;// for qstntxt, qstnum and hint
					} else {
						s.mergeCells(col, 1, col + 1, 1);
						col = col + 1;
					}
				} else if (qstnType == "TEXT" || qstnType.equals("TEXT")) {
					fillGenericQuestionData(qis, sadMap, s, col, row);
					if (qstnTxtHintColRqd) {
						s.mergeCells(col, 1, col + 1, 1);
						col = col + 1; // for qstntxt and hint
					}
				} else if (qstnType == "SORT" || qstnType.equals("SORT")) {
					fillSortQuestionData(qis, sadMap, s, col, row);
				} else if (qstnType == "REPEAT" || qstnType.equals("REPEAT")) {
					// no increase here since its already filled in via sources
					continue;
				} else {
					// text
					fillGenericQuestionData(qis, sadMap, s, col, row);
					if (qstnTxtHintColRqd) {
						s.mergeCells(col, 1, col + 1, 1);
						col = col + 1;
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	// qst_type == DATA
	/**
	 * fills info for numeric questions into the sheet
	 * 
	 * @param qis
	 * @param sadMap
	 * @param s
	 * @param col
	 * @param row
	 */
	private void fillNumericQuestionData(QuestionDataSetInfo qis,
			LinkedHashMap<Integer, SourceAnswersDataSetInfo> sadMap, WritableSheet s, int col, int row) {
		try {

			boolean isLastTallyOk = true;
			if (this.lastTallyInfoColumnFilled >= col) {
				isLastTallyOk = false;

				// find gap

				System.out.println("Last col is graeter col is " + col + " and this.lastTallyInfoColumnFilled is "
						+ this.lastTallyInfoColumnFilled);
			} else {
				System.out.println("Last col is NOT GREATER for DATA col is " + col
						+ " and this.lastTallyInfoColumnFilled is " + this.lastTallyInfoColumnFilled);
			}

			if (this.lastTallyInfoBottomRowFilled > row) {
				System.out.println("Last row is graeter");
			} else {
				System.out.println("Last row is NOT GREATER for DATA");
			}
			if (this.lastTallyInfoCellFilled != null) {
				if (this.lastTallyInfoCellFilled.getColumn() > col) {
					System.out.println("Last col is graeter for DATA via cellinfo");
				} else {
					System.out.println("Last col is NOT GREATER for DATA via cellinfo");
				}
			} else {
				System.out.println("this.lastTallyInfoCellFilled.getColumn() WAS NULL");
			}
			String[] tallyOptions = qis.getDataTallyOptions();

			int qstId = qis.getQst_id();

			int start_col = col;
			int start_row = row;
			int dataAsvValuesCount = 0;
			int dataTallyStartCol = start_col;
			int dataTallyStartRow = isLastTallyOk
					? start_row + this.getNumSources() + NUM_EXTRA_SOURCES + 10 + dataAsvValuesCount
					: this.lastTallyInfoBottomRowFilled + 5 + NUM_EXTRA_SOURCES;
			int dataTallyEndCol = dataTallyStartCol;
			int dataDropDownCol = dataTallyStartCol + 1;
			int dataTallyEndRow = 0;
			for (int dto = 0; dto < tallyOptions.length; dto++) {
				s.addCell(new Label(dataDropDownCol, (start_row + this.getNumSources() + 10 + NUM_EXTRA_SOURCES + dto),
						tallyOptions[dto]));
				dataTallyEndRow = dataTallyStartRow + dto;
			}

			// start for calc and formula
			int startCalcRow = dataTallyEndRow + 15;
			int startCalcCol = dataDropDownCol - 1;
			int theCalcRow = startCalcRow;
			Map<String, Pair> tallyMap = new HashMap<String, Pair>();
			List<TallyRangeLimitsValuesDataSetInfo> tlyInfo = qis.getTallyRangeLimitsValuesDataSetInfo();
			// labels for tallys
			for (Iterator<TallyRangeLimitsValuesDataSetInfo> tt = tlyInfo.iterator(); tt.hasNext(); theCalcRow++) {
				TallyRangeLimitsValuesDataSetInfo tInf = tt.next();
				String tallyFrom = tInf.getTrl_from();

				try {
					String start = Double.parseDouble(tallyFrom) > 0.0 ? "Up " : "Down ";
					if (tallyFrom.equalsIgnoreCase("0") && tInf.getTrl_to().equalsIgnoreCase("0")) {
						start = "";
					}

					String suffix = tInf.getTly_suffix();
					final String dash = " - ";
					String tallyTo = tInf.getTrl_to();

					if (tallyFrom == null) {
						theCalcRow = theCalcRow - 1;
						continue;
					}
					if (tallyTo == null) {
						theCalcRow = theCalcRow - 1;
						continue;
					}
					String talLabInfo;
					if (start.equalsIgnoreCase("Down ") || start == "Down ") {
						talLabInfo = start + tallyFrom.substring(1) + suffix + dash + tallyTo.substring(1) + suffix;
					} else {
						talLabInfo = start + tallyFrom + suffix + dash + tallyTo + suffix;
					}

					if (tallyFrom != null && tallyTo != null) {
						tallyMap.put(talLabInfo, new Pair<Integer, Integer>((int) Double.parseDouble(tallyFrom),
								(int) Double.parseDouble(tallyTo)));
						Label tallyLabel = new Label(startCalcCol, theCalcRow, talLabInfo);
						tallyLabel.setCellFormat(FRMT_NUMERIC_CELL);
						s.addCell(tallyLabel);

						String formula = "";
						String tallyFromVal = this.getLocaleDecimalValue(this.currentLocale, tallyFrom);
						String tallyToVal = this.getLocaleDecimalValue(this.currentLocale, tallyTo);

						if (Double.parseDouble(tallyFrom) < 0.0) {
							formula = "COUNTIF(" + (this.mp_R1C1Map.get(start_col))
									+ String.valueOf(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW + 1) + ":"
									+ (this.mp_R1C1Map.get(start_col))
									+ String.valueOf(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW
											+ this.getNumSources() + NUM_EXTRA_SOURCES)
									+ ", \"<=" + tallyFromVal + "\") " + " - " + "COUNTIF("
									+ (this.mp_R1C1Map.get(start_col))
									+ String.valueOf(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW + 1) + ":"
									+ (this.mp_R1C1Map.get(start_col))
									+ String.valueOf(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW
											+ this.getNumSources() + NUM_EXTRA_SOURCES)
									+ ", \"<" + tallyToVal + "\")";
							System.out.println("FORMULA__DATATED is " + formula);
						} else if (Double.parseDouble(tallyFrom) > 0.0) {
							formula = "COUNTIF(" + (this.mp_R1C1Map.get(start_col))
									+ String.valueOf(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW + 1) + ":"
									+ (this.mp_R1C1Map.get(start_col))
									+ String.valueOf(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW
											+ this.getNumSources() + NUM_EXTRA_SOURCES)
									+ ", \"<=" + tallyToVal + "\")" + " - " + "COUNTIF("
									+ (this.mp_R1C1Map.get(start_col))
									+ String.valueOf(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW + 1) + ":"
									+ (this.mp_R1C1Map.get(start_col))
									+ String.valueOf(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW
											+ this.getNumSources() + NUM_EXTRA_SOURCES)
									+ ", \"<" + tallyFromVal + "\") ";
						} else if (Double.parseDouble(tallyFrom) == 0.0) {
							formula = "COUNTIF(" + (this.mp_R1C1Map.get(start_col))
									+ String.valueOf(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW + 1) + ":"
									+ (this.mp_R1C1Map.get(start_col))
									+ String.valueOf(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW
											+ this.getNumSources() + NUM_EXTRA_SOURCES)
									+ ", 0 )";
						}

						Formula tallyFormulaLabel = new Formula(startCalcCol + 1, theCalcRow, formula);
						tallyFormulaLabel.setCellFormat(FRMT_NUMERIC_CELL);
						s.addCell(tallyFormulaLabel);
					} else {
						theCalcRow = theCalcRow - 1;
						continue;
					}
				} catch (NumberFormatException nfe) {
					if (tallyFrom == "" || tallyFrom.equalsIgnoreCase("")) {
						theCalcRow = theCalcRow - 1;
						continue;
					}

					if (Arrays.asList(qis.getDataTallyOptions()).contains(tallyFrom) && tallyFrom != "") {
						tallyMap.put(tallyFrom, null);
						Label tallyLabel = new Label(startCalcCol, theCalcRow, tallyFrom);
						tallyLabel.setCellFormat(FRMT_NUMERIC_CELL);
						s.addCell(tallyLabel);

						String formula = "COUNTIF(" + (this.mp_R1C1Map.get(dataDropDownCol))
								+ String.valueOf(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW + 1) + ":"
								+ (this.mp_R1C1Map.get(dataDropDownCol))
								+ String.valueOf(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW
										+ this.getNumSources() + NUM_EXTRA_SOURCES)
								+ ", " + (this.mp_R1C1Map.get(col)) + (theCalcRow + 1) + ") ";

						Formula tallyFormulaLabel = new Formula(dataDropDownCol, theCalcRow, formula);
						tallyFormulaLabel.setCellFormat(FRMT_NUMERIC_CELL);
						s.addCell(tallyFormulaLabel);
						continue;
					} else {
						nfe.printStackTrace();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			s.addCell(new Label(startCalcCol, (theCalcRow + 1), "Total:", FRMT_NUMERIC_CELL));
			String sumForm = "SUM(" + (this.mp_R1C1Map.get(startCalcCol + 1)) + (startCalcRow + 2) + ":"
					+ (this.mp_R1C1Map.get(startCalcCol + 1) + theCalcRow) + ")";
			Formula formulaSum = new Formula((startCalcCol + 1), (theCalcRow + 1), sumForm);
			formulaSum.setCellFormat(FRMT_NUMERIC_CELL);
			s.addCell(formulaSum);
			this.lastTallyInfoCellFilled = formulaSum;
			this.lastTallyInfoColumnFilled = startCalcCol + 1;
			this.lastTallyInfoBottomRowFilled = theCalcRow + 1;

			// has qst hint ( 2 cols -- numeric and drop) and qst text hint
			// header
			System.out.println("col in NUMERIC -- type is " + qis.getQst_type() + ", col is " + col);
			int numericCol = col;
			int dropDownCol = col + 1;
			int txtHintCol = col + 2;

			// qstnid label
			CellView hideView = new CellView();
			hideView.setHidden(true);
			s.addCell(new jxl.write.Number(start_col, row, qstId));
			s.addCell(new Label(start_col + 1, 0, qstId + "_D")); // for
																	// drop-down
			s.setRowView(row, hideView);

			row = row + 1;

			// qstn label
			String theQnInfo = processTheQuestion(qis);// .getQst_numeric() != 0
														// ?
														// qis.getQst_numeric()
														// +
														// (qis.getQst_alpha()!=
														// null ?
														// qis.getQst_alpha() :
														// "") + ". " +
														// qis.getQst_question()
														// :
														// qis.getQst_question();
			Label qstLabel = new Label(start_col, row, processStringForWrap(theQnInfo, start_col));
			qstLabel.setCellFormat(FRMT_NUMERIC_CELL);

			s.addCell(qstLabel);

			// qstn hint -- we need two cols for qstn (numeric and drop)
			row = row + 1;
			Label qstHintLabel = new Label(start_col, row, processStringForWrap(qis.getQst_question_hint(), start_col));
			qstHintLabel.setCellFormat(FRMT_NUMERIC_CELL);
			s.addCell(qstHintLabel);

			// drop down blank cell
			Blank emptyQstnCell = new Blank(dropDownCol, row, FRMT_NUMERIC_CELL);
			s.addCell(emptyQstnCell);

			// qstn text hint
			if (qis.getQst_text_required_yn().equalsIgnoreCase("Y")) {
				s.addCell(new Label(txtHintCol, 0, String.valueOf(qstId + "_H")));
				Label qstTextHintLabel = new Label(txtHintCol, row,
						processStringForWrap(qis.getQst_text_hint(), txtHintCol));
				qstTextHintLabel.setCellFormat(FRMT_NORM_RED);
				s.addCell(qstTextHintLabel);
			}
			// for width of ans text
			int maxLength = identifyMaxLength(sadMap);

			// src data
			for (int i = 0; i < this.getNumSources(); i++) {
				row = row + 1;
				int srcRepId = Integer.parseInt(s.getCell(0, row).getContents());
				if (sadMap.get(srcRepId) != null) {
					// ans
					if (sadMap.get(srcRepId).getAnswer() != null) {
						String theAnswer = sadMap.get(srcRepId).getAnswer().trim();
						System.out.println("numeric theanswer is -->" + theAnswer + "<--");
						boolean istextAnswer = false;
						try {
							if (checkNumericAnswer(tallyOptions, theAnswer) && !theAnswer.equals("")) {
								istextAnswer = true;
								System.out.println("is text answer is " + istextAnswer);
								// no numeric value - so blank cell
								Blank emptyCell = new Blank(start_col, row, FRMT_NUMERIC_CELL);
								WritableCellFeatures numFeatures = new WritableCellFeatures();
								numFeatures.setNumberValidation(-10000, WritableCellFeatures.GREATER_THAN);
								emptyCell.setCellFeatures(numFeatures);
								s.addCell(emptyCell);

								// txt ans has drop down
								Label ansLabel = new Label(dataDropDownCol, row,
										processStringForWrap(theAnswer, dataDropDownCol));
								ansLabel.setCellFormat(FRMT_NUMERIC_CELL);
								// for drop-down
								WritableCellFeatures addedfeatures = new WritableCellFeatures();
								addedfeatures.setDataValidationRange(dataDropDownCol, dataTallyStartRow,
										dataDropDownCol, dataTallyEndRow);// addedfeatures.setDataValidationList(asvValues);
								ansLabel.setCellFeatures(addedfeatures);
								s.addCell(ansLabel);

							} else {
								System.out.println("is text answer is " + istextAnswer);
								Double numAnswer = Double.parseDouble(theAnswer);
								Number nm = new Number(start_col, row, numAnswer);
								// processStringForWrap(theAnswer, numericCol);
								nm.setCellFormat(FRMT_NUMERIC_CELL);
								WritableCellFeatures numFeatures = new WritableCellFeatures();
								numFeatures.setNumberValidation(-10000, WritableCellFeatures.GREATER_THAN);
								nm.setCellFeatures(numFeatures);
								s.addCell(nm);

								Blank emptyCell = new Blank(dataDropDownCol, row);
								emptyCell.setCellFormat(FRMT_NUMERIC_CELL);

								WritableCellFeatures addedfeatures = new WritableCellFeatures();
								addedfeatures.setDataValidationRange(dataDropDownCol, dataTallyStartRow,
										dataDropDownCol, dataTallyEndRow);// addedfeatures.setDataValidationList(asvValues);

								emptyCell.setCellFeatures(addedfeatures);
								s.addCell(emptyCell);
							}
						} catch (Exception e) {
							System.out.println("Is unknown answer for DATA");
						}

						// ans text
						if (qis.getQst_text_required_yn().equalsIgnoreCase("Y")) {
							if (sadMap.get(srcRepId).getSra_Answer_text() != null) {
								Label ansTextLabel = null;
								String theAnswerText = sadMap.get(srcRepId).getSra_Answer_text().trim();
								ansTextLabel = new Label(txtHintCol, row,
										processStringForWrap(theAnswerText, txtHintCol));
								ansTextLabel.setCellFormat(FRMT_WRAP_NORMAL_ANS_HINT_CELL);

								if (sadMap.get(srcRepId).getSra_comment() != null) {
									System.out.println("NUMERIC_COMMENT IS " + sadMap.get(srcRepId).getSra_comment()
											+ " qid " + qis.getQst_id());
									WritableCellFeatures wcf = new WritableCellFeatures();
									wcf.setComment(sadMap.get(srcRepId).getSra_comment());
									ansTextLabel.setCellFeatures(wcf);
								}

								if (sadMap.get(srcRepId).getSra_color() != null) {
									// Colour colr =
									// resolveRGBColor(sadMap.get(srcRepId).getSra_color());
									ansTextLabel.setCellFormat(FRMT_COMMENT);
								}

								s.addCell(ansTextLabel);

							} else {
								// add empty cell

								Blank emptyCell = new Blank(txtHintCol, row);
								emptyCell.setCellFormat(FRMT_WRAP_NUM_ANS_TEXT_CELL);
								s.addCell(emptyCell);
							}
						}
					} else {
						// add blanks
						// no numeric value - so blank cell
						Blank emptyCell = new Blank(start_col, row, FRMT_NUMERIC_CELL);
						WritableCellFeatures numFeatures = new WritableCellFeatures();
						numFeatures.setNumberValidation(-10000, WritableCellFeatures.GREATER_THAN);
						emptyCell.setCellFeatures(numFeatures);
						s.addCell(emptyCell);

						emptyCell = new Blank(dataDropDownCol, row);
						emptyCell.setCellFormat(FRMT_NUMERIC_CELL);

						WritableCellFeatures addedfeatures = new WritableCellFeatures();
						addedfeatures.setDataValidationRange(dataDropDownCol, dataTallyStartRow, dataDropDownCol,
								dataTallyEndRow);// addedfeatures.setDataValidationList(asvValues);

						emptyCell.setCellFeatures(addedfeatures);
						s.addCell(emptyCell);

						// ans text
						if (qis.getQst_text_required_yn().equalsIgnoreCase("Y")) {
							if (sadMap.get(srcRepId).getSra_Answer_text() != null) {
								Label ansTextLabel = null;
								String theAnswerText = sadMap.get(srcRepId).getSra_Answer_text().trim();
								ansTextLabel = new Label(txtHintCol, row,
										processStringForWrap(theAnswerText, txtHintCol));
								ansTextLabel.setCellFormat(FRMT_WRAP_NORMAL_ANS_HINT_CELL);

								if (sadMap.get(srcRepId).getSra_comment() != null) {
									System.out.println("NUMERIC_COMMENT IS " + sadMap.get(srcRepId).getSra_comment()
											+ " qid " + qis.getQst_id());
									WritableCellFeatures wcf = new WritableCellFeatures();
									wcf.setComment(sadMap.get(srcRepId).getSra_comment());
									ansTextLabel.setCellFeatures(wcf);
								}

								if (sadMap.get(srcRepId).getSra_color() != null) {
									// Colour colr =
									// resolveRGBColor(sadMap.get(srcRepId).getSra_color());
									ansTextLabel.setCellFormat(FRMT_COMMENT);
								}

								s.addCell(ansTextLabel);

							} else {
								// add empty cell

								Blank ansTextCell = new Blank(txtHintCol, row);
								ansTextCell.setCellFormat(FRMT_WRAP_NUM_ANS_TEXT_CELL);
								s.addCell(ansTextCell);
							}
						}
					}
				} else {
					// blank ans
					// add blanks
					// no numeric value - so blank cell
					Blank emptyCell = new Blank(start_col, row, FRMT_NUMERIC_CELL);
					WritableCellFeatures numFeatures = new WritableCellFeatures();
					numFeatures.setNumberValidation(-10000, WritableCellFeatures.GREATER_THAN);
					emptyCell.setCellFeatures(numFeatures);
					s.addCell(emptyCell);

					emptyCell = new Blank(dataDropDownCol, row);
					emptyCell.setCellFormat(FRMT_NUMERIC_CELL);

					WritableCellFeatures addedfeatures = new WritableCellFeatures();
					addedfeatures.setDataValidationRange(dataDropDownCol, dataTallyStartRow, dataDropDownCol,
							dataTallyEndRow);// addedfeatures.setDataValidationList(asvValues);

					emptyCell.setCellFeatures(addedfeatures);
					s.addCell(emptyCell);

					// ans text
					if (qis.getQst_text_required_yn().equalsIgnoreCase("Y")) {
						// add empty cell

						Blank ansTextCell = new Blank(txtHintCol, row);
						ansTextCell.setCellFormat(FRMT_WRAP_NUM_ANS_TEXT_CELL);
						s.addCell(ansTextCell);

					}
				}

			} // ends for existing srcs

			row++;
			// add blanks for extra_sources
			for (int es = 0; es < NUM_EXTRA_SOURCES; es++, row++) {
				// blank ans
				// add blanks
				// no numeric value - so blank cell
				Blank emptyCell = new Blank(start_col, row, FRMT_NUMERIC_CELL);
				WritableCellFeatures numFeatures = new WritableCellFeatures();
				numFeatures.setNumberValidation(-10000, WritableCellFeatures.GREATER_THAN);
				emptyCell.setCellFeatures(numFeatures);
				s.addCell(emptyCell);

				emptyCell = new Blank(dataDropDownCol, row);
				emptyCell.setCellFormat(FRMT_NUMERIC_CELL);

				WritableCellFeatures addedfeatures = new WritableCellFeatures();
				addedfeatures.setDataValidationRange(dataDropDownCol, dataTallyStartRow, dataDropDownCol,
						dataTallyEndRow);// addedfeatures.setDataValidationList(asvValues);

				emptyCell.setCellFeatures(addedfeatures);
				s.addCell(emptyCell);

				// ans text
				if (qis.getQst_text_required_yn().equalsIgnoreCase("Y")) {
					// add empty cell

					Blank ansTextCell = new Blank(txtHintCol, row);
					ansTextCell.setCellFormat(FRMT_WRAP_NUM_ANS_TEXT_CELL);
					s.addCell(ansTextCell);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private int identifyMaxLength(LinkedHashMap<Integer, SourceAnswersDataSetInfo> sadMap) {
		Set<Integer> theKeys = sadMap.keySet();
		int max = 0;
		for (Iterator<Integer> it = theKeys.iterator(); it.hasNext();) {
			String ans = sadMap.get(it.next()).getSra_Answer_text();
			if (ans != null) {
				if (ans.length() > max)
					max = ans.length();
			}
		}
		// System.out.println(" identifyMaxLength " + max);
		return max;
	}

	private void fillSortQuestionData(QuestionDataSetInfo qis, LinkedHashMap<Integer, SourceAnswersDataSetInfo> sadMap,
			WritableSheet s, int col, int row) {
		try { // sort dont have qst text hint
			int qstnId = qis.getQst_id();
			int start_col = col;
			int start_row = row;
			List<SortingCriteriaValuesDataSetInfo> sortCriteriaDataSetInfo = qis.getSortCriteriaDataSetInfo();
			System.out.println("sortCriteriaDataSetInfo size is " + sortCriteriaDataSetInfo.size());
			List<String> sortCrtiteriasList = new ArrayList<String>();
			// sortCrtiteriasList.add(" ");
			int sortCriteriaCount = 0;

			int tallyStartCol = start_col;
			int tallyEndCol = start_col;
			int tallyStartRow = row + this.getNumSources() + NUM_EXTRA_SOURCES + 10 + sortCriteriaCount;
			// int tallyStart

			// add one for blanknesss
			final String blankSpace = " ";
			// sortCrtiteriasList.add(blankSpace);
			for (Iterator<SortingCriteriaValuesDataSetInfo> st = sortCriteriaDataSetInfo.iterator(); st
					.hasNext(); sortCriteriaCount++) {
				String sortCriteriaName = st.next().getSvc_name();
				sortCrtiteriasList.add(sortCriteriaName);
				s.addCell(new Label(start_col, row + this.getNumSources() + NUM_EXTRA_SOURCES + 10 + sortCriteriaCount,
						sortCriteriaName));
			}
			s.addCell(new Label(start_col, row + this.getNumSources() + NUM_EXTRA_SOURCES + 10 + sortCriteriaCount,
					blankSpace));
			int tallyEndRow = start_row + this.getNumSources() + NUM_EXTRA_SOURCES + 10 + sortCriteriaCount;

			// header

			// qstnid label
			CellView hideView = new CellView();
			hideView.setHidden(true);
			s.addCell(new jxl.write.Number(col, row, qstnId));
			s.setRowView(row, hideView);

			row = row + 1;

			// qstn label
			Label qstLabel = new Label(col, row, processStringForWrap(qis.getQst_question(), col));
			qstLabel.setCellFormat(FRMT_SORT_QSTN_INFO_DATA_CELL);

			s.addCell(qstLabel);

			row = row + 1;
			// qstn hint label
			Label qstHintLabel = new Label(col, row, processStringForWrap(qis.getQst_question_hint(), col));
			qstHintLabel.setCellFormat(FRMT_SORT_QSTN_HINT_INFO_DATA_CELL);
			s.addCell(qstHintLabel);

			// for width of ans text
			int maxLength = identifyMaxLength(sadMap);

			// src data
			for (int i = 0; i < this.getNumSources(); i++) {
				row = row + 1;
				int srcRepId = Integer.parseInt(s.getCell(0, row).getContents());
				if (sadMap.get(srcRepId) != null) {
					if (sadMap.get(srcRepId).getScv_name() != null) {
						String theAnswer = sadMap.get(srcRepId).getScv_name().trim();
						Label ansLabel = new Label(col, row, processStringForWrap(theAnswer, col));
						ansLabel.setCellFormat(FRMT_SORT_QSTN_ANSINFO_DATA_CELL);

						WritableCellFeatures addedfeatures = new WritableCellFeatures();

						// here we are setting the drop-down feature
						addedfeatures.setDataValidationRange(tallyStartCol, tallyStartRow, tallyEndCol, tallyEndRow);
						// addedfeatures.setDataValidationList(sortCrtiteriasList);
						ansLabel.setCellFeatures(addedfeatures);

						s.addCell(ansLabel);
					} else {
						// add blank
						Blank emptyCell = new Blank(col, row, FRMT_SORT_QSTN_ANSINFO_DATA_CELL);
						WritableCellFeatures addedfeatures = new WritableCellFeatures();
						// here we are setting the drop-down feature
						addedfeatures.setDataValidationRange(tallyStartCol, tallyStartRow, tallyEndCol, tallyEndRow);
						// addedfeatures.setDataValidationList(sortCrtiteriasList);
						emptyCell.setCellFeatures(addedfeatures);

						s.addCell(emptyCell);
					}
				} else {
					// add blank
					Blank emptyCell = new Blank(col, row, FRMT_SORT_QSTN_ANSINFO_DATA_CELL);
					WritableCellFeatures addedfeatures = new WritableCellFeatures();
					// here we are setting the drop-down feature
					addedfeatures.setDataValidationRange(tallyStartCol, tallyStartRow, tallyEndCol, tallyEndRow);
					// addedfeatures.setDataValidationList(sortCrtiteriasList);
					emptyCell.setCellFeatures(addedfeatures);
					s.addCell(emptyCell);
				}

			} // ends for

			row++;
			for (int es = 0; es < NUM_EXTRA_SOURCES; es++, row++) {
				// add blank
				Blank emptyCell = new Blank(col, row, FRMT_SORT_QSTN_ANSINFO_DATA_CELL);
				WritableCellFeatures addedfeatures = new WritableCellFeatures();
				// here we are setting the drop-down feature
				addedfeatures.setDataValidationRange(tallyStartCol, tallyStartRow, tallyEndCol, tallyEndRow);
				// addedfeatures.setDataValidationList(sortCrtiteriasList);
				emptyCell.setCellFeatures(addedfeatures);
				s.addCell(emptyCell);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// fillGenericQuestionData(qis, sadMap, s, col, row);
	private void fillGenericQuestionData(QuestionDataSetInfo qis,
			LinkedHashMap<Integer, SourceAnswersDataSetInfo> sadMap, WritableSheet s, int col, int row) {
		try { // has qst hint and qst text hint
				// header
			if (this.lastTallyInfoColumnFilled > col) {
				System.out.println("Last col is graeter for Generic and col is " + col
						+ " and this.lastTallyInfoColumnFilled is " + this.lastTallyInfoColumnFilled);
			} else {
				System.out.println("Last col is NOT GREATER for Generic and col is " + col
						+ " and this.lastTallyInfoColumnFilled is " + this.lastTallyInfoColumnFilled);
			}

			if (this.lastTallyInfoBottomRowFilled > row) {
				System.out.println("Last row is graeter for Generic");
			} else {
				System.out.println("Last row is NOT GREATER for Generic");
			}
			if (this.lastTallyInfoCellFilled != null) {
				if (this.lastTallyInfoCellFilled.getColumn() > col) {
					System.out.println("Last col is graeter via cellinfo for Generic");
				} else {
					System.out.println("Last col is NOT GREATER for Generic via cellinfo");
				}
			} else {
				System.out.println("this.lastTallyInfoCellFilled.getColumn() Generic WAS NULL");
			}

			System.out.println("col in generic -- type is " + qis.getQst_type() + ", col is " + col);
			int txtHintCol = col + 1;

			int qstId = qis.getQst_id();
			// qstnid label
			CellView hideView = new CellView();
			hideView.setHidden(true);
			s.addCell(new jxl.write.Number(col, row, qstId));
			s.setRowView(row, hideView);

			row = row + 1;

			// qstn label
			String theQnInfo = processTheQuestion(qis);// qis.getQst_numeric()
														// != 0 ?
														// qis.getQst_numeric()
														// + ". " +
														// qis.getQst_question()
														// :
														// qis.getQst_question();
			Label qstLabel = new Label(col, row, processStringForWrap(theQnInfo, col));
			qstLabel.setCellFormat(FRMT_QSTN_INFO_DATA_CELL);

			s.addCell(qstLabel);

			// qstn hint
			row = row + 1;
			Label qstHintLabel = new Label(col, row, processStringForWrap(qis.getQst_question_hint(), col));
			qstHintLabel.setCellFormat(FRMT_NORM_RED);// (FRMT_QSTN_HINT_INFO_DATA_CELL);
			s.addCell(qstHintLabel);

			if (qis.getQst_text_required_yn().equalsIgnoreCase("Y")) {

				s.addCell(new Label(txtHintCol, 0, String.valueOf(qstId + "_H")));
				// qstn text hint
				Label qstTextHintLabel = new Label(txtHintCol, row,
						processStringForWrap(qis.getQst_text_hint(), txtHintCol));
				qstTextHintLabel.setCellFormat(FRMT_NORM_RED);
				s.addCell(qstTextHintLabel);
			}
			// for width of ans text
			int maxLength = identifyMaxLength(sadMap);

			// src data
			for (int i = 0; i < this.getNumSources(); i++) {
				row = row + 1;
				int srcRepId = Integer.parseInt(s.getCell(0, row).getContents());
				SourceAnswersDataSetInfo sad = sadMap.get(srcRepId);
				if (sad != null) {
					// ans
					if (sad.getAnswer() != null) {
						String theAnswer = sad.getAnswer().trim();
						Label ansLabel = new Label(col, row, processStringForWrap(theAnswer, col));
						ansLabel.setCellFormat(FRMT_WRAP_NORMAL_ANS_CELL);

						s.addCell(ansLabel);
					} else {
						Blank emptyCell = new Blank(col, row);
						emptyCell.setCellFormat(FRMT_WRAP_NORMAL_ANS_CELL);
						s.addCell(emptyCell);
					}

					if (qis.getQst_text_required_yn().equalsIgnoreCase("Y")) {
						// ans text
						if (sad.getSra_Answer_text() != null) {
							Label ansTextLabel = null;
							String theAnswerText = sad.getSra_Answer_text().trim();
							ansTextLabel = new Label(txtHintCol, row, processStringForWrap(theAnswerText, txtHintCol));

							if (sad.getSra_comment() != null) {
								System.out.println("COMMENT IS " + sad.getSra_comment() + " qid " + qis.getQst_id());
								ansTextLabel.getCellFeatures().setComment(sad.getSra_comment());
							}

							if (sad.getSra_color() != null) {
								// Colour colr =
								// resolveRGBColor(sad.getSra_color());
								ansTextLabel.setCellFormat(FRMT_COMMENT);
							} else
								System.out.println("ANSTEXT_GENERIC__COMMENT IS NULL, col is " + txtHintCol);

							s.addCell(ansTextLabel);
						} else {
							Blank emptyCell = new Blank(txtHintCol, row);
							emptyCell.setCellFormat(FRMT_WRAP_NORMAL_ANS_CELL);
							s.addCell(emptyCell);
						}
					}
				} else {
					Blank emptyCell = new Blank(col, row);
					emptyCell.setCellFormat(FRMT_WRAP_NORMAL_ANS_CELL);
					s.addCell(emptyCell);

					if (qis.getQst_text_required_yn().equalsIgnoreCase("Y")) {
						Blank ansTextCell = new Blank(txtHintCol, row);
						ansTextCell.setCellFormat(FRMT_WRAP_NORMAL_ANS_CELL);
						s.addCell(ansTextCell);
					}

				}

			} // ends for existing

			// add blanks for additional sources
			row++;
			for (int es = 0; es < NUM_EXTRA_SOURCES; es++, row++) {
				Blank emptyCell = new Blank(col, row);
				emptyCell.setCellFormat(FRMT_WRAP_NORMAL_ANS_CELL);
				s.addCell(emptyCell);

				if (qis.getQst_text_required_yn().equalsIgnoreCase("Y")) {
					Blank ansTextCell = new Blank(txtHintCol, row);
					ansTextCell.setCellFormat(FRMT_WRAP_NORMAL_ANS_CELL);
					s.addCell(ansTextCell);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void fillSingleQuestionData(QuestionDataSetInfo qis,
			LinkedHashMap<Integer, SourceAnswersDataSetInfo> sadMap, WritableSheet s,
			QuestionAnswerSetsDataSheet xtraQnsAnsSetsSheet, int col, int row) {
		try { // has qst hint and qst text hint
				// header
			boolean isLastTallyOK = true;
			boolean canAddAnswers = this.reportTemplateInfoDataSet.getListOfQuestionsForAdditionalAnswers()
					.contains(qis);

			Map<Integer, Integer> mp_QuestionIdsForAdditionalAnswersCols = null;

			if (canAddAnswers) {
				mp_QuestionIdsForAdditionalAnswersCols = xtraQnsAnsSetsSheet
						.getMp_QuestionIdsForAdditionalAnswersCols();
			}

			final String xtraQnsAnsSheet = XTRA_QSTNANS_SHEET_FORMULA_NAME;

			if (this.lastTallyInfoColumnFilled >= col) {
				isLastTallyOK = false;
				System.out.println("Last col is graeter for single and col is " + col
						+ " and this.lastTallyInfoColumnFilled is " + this.lastTallyInfoColumnFilled);
			} else {
				System.out.println("Last col is NOT GREATER for SINGLE and col is " + col
						+ " and this.lastTallyInfoColumnFilled is " + this.lastTallyInfoColumnFilled);
			}

			if (this.lastTallyInfoBottomRowFilled > row) {
				System.out.println("Last row is graeter for single");
			} else {
				System.out.println("Last row is NOT GREATER for SINGLE");
			}
			if (this.lastTallyInfoCellFilled != null) {
				if (this.lastTallyInfoCellFilled.getColumn() > col) {
					System.out.println("Last col is graeter via cellinfo for single");
				} else {
					System.out.println("Last col is NOT GREATER for SINGLE via cellinfo");
				}
			} else {
				System.out.println("this.lastTallyInfoCellFilled.getColumn() WAS NULL");
			}
			final int start_col = col;
			final int start_row = row; // here start_row = 0
			System.out.println("col in single -- type is " + qis.getQst_type() + ", col is " + col + " qstId is "
					+ s.getWritableCell(col, 0).getContents() + " and start_row is " + start_row);
			List<ReportAnswerSetValuesDataSetInfo> singleAnswerSetsInfo = qis.getSingleAnswerSetsInfo();
			List<String> asvValues = new ArrayList<String>(); // to set the
																// validation
																// list for the
																// answer

			int asvValuesCount = 0;

			final int tallyStartCol = start_col;
			final int tallyStartRow = isLastTallyOK
					? start_row + this.getNumSources() + NUM_EXTRA_SOURCES + 10 + asvValuesCount
					: this.lastTallyInfoBottomRowFilled + 5 + NUM_EXTRA_SOURCES;
			final int tallyEndCol = start_col;

			for (Iterator<ReportAnswerSetValuesDataSetInfo> it = singleAnswerSetsInfo.iterator(); it
					.hasNext(); asvValuesCount++) {
				String theAnswer = it.next().getRav_answer();
				asvValues.add(theAnswer);
			}

			int tallyEndRow;
			if (canAddAnswers) {
				tallyEndRow = start_row + this.getNumSources() + 10 + NUM_EXTRA_SOURCES + NUM_EXTRA_ANSWERS
						+ asvValuesCount;
			} else {
				tallyEndRow = start_row + this.getNumSources() + 10 + NUM_EXTRA_SOURCES + asvValuesCount;
			}

			System.out.println("tallyStartCol, " + tallyStartCol);
			System.out.println("tallyStartRow, " + tallyStartRow);
			System.out.println("tallyEndCol, " + tallyEndCol);
			System.out.println("tallyEndRow " + tallyEndRow);

			asvValuesCount = 0;
			for (Iterator<String> it = asvValues.iterator(); it.hasNext(); asvValuesCount++) {
				String theAnswer = it.next();
				if (theAnswer != "") {
					Label ansTallyLabel = new Label(col,
							(row + this.getNumSources() + NUM_EXTRA_SOURCES + 10 + asvValuesCount), theAnswer);
					ansTallyLabel.setCellFormat(FRMT_SINGLE_ANS_DATA_CELL);
					// add validation list
					s.addCell(ansTallyLabel);
					System.out.println("in sing ---- col is " + col + " row is "
							+ (row + this.getNumSources() + NUM_EXTRA_SOURCES + 10 + asvValuesCount)
							+ " and mapped col is " + this.mp_R1C1Map.get(col));
					System.out.println("start_row is " + start_row + " and start_col is " + start_col
							+ " asvValuesCount is " + asvValuesCount + " col is " + col + " and row is " + row);

					// String formula = "=COUNTIF(" +
					// (this.mp_R1C1Map.get(start_col)) +
					// String.valueOf(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW
					// + 1) + ":" + (this.mp_R1C1Map.get(start_col)) +
					// String.valueOf(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW
					// + this.getNumSources()) + ", " +
					// (this.mp_R1C1Map.get(col)) +
					// String.valueOf(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW
					// + this.getNumSources() + 10 + asvValuesCount) +
					// ")";//s.getCell(col, row).getContents()
					String formula = "COUNTIF(" + (this.mp_R1C1Map.get(start_col))
							+ String.valueOf(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW + 1) + ":"
							+ (this.mp_R1C1Map.get(start_col))
							+ String.valueOf(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW
									+ this.getNumSources() + NUM_EXTRA_SOURCES)
							+ ", " + (this.mp_R1C1Map.get(col))
							+ String.valueOf(row + this.getNumSources() + NUM_EXTRA_SOURCES + 10 + asvValuesCount + 1)
							+ ")";// s.getCell(col, row).getContents()
					// if ( this.isCommaDecLocale ) {
					// formula = formula.replace('.', ',');
					//
					// }

					System.out.println("Formula is (col, row)   [" + col + ", "
							+ (row + this.getNumSources() + NUM_EXTRA_SOURCES + 10 + asvValuesCount) + "]    "
							+ formula);
					Formula formulaLabel = new Formula(col + 1,
							(row + this.getNumSources() + NUM_EXTRA_SOURCES + 10 + asvValuesCount), formula);
					formulaLabel.setCellFormat(FRMT_SINGLE_ANS_DATA_CELL);
					s.addCell(formulaLabel);
				}
			}

			int xtraQnsTallyRow = (row + this.getNumSources() + NUM_EXTRA_SOURCES + 10 + asvValuesCount);

			if (canAddAnswers) {
				int numAnsValues = qis.getSingleAnswerSetsInfo().size();
				int qnAnsSetCol = mp_QuestionIdsForAdditionalAnswersCols.get(qis.getQst_id()) + 1;
				int startQnSetAnsRow = AnswersGridTemplateRangeConstants.RANGE_QUESTIONS_TOP_ROW + numAnsValues + 5;

				for (int i = 0; i < AnswersGridTemplateRangeConstants.NUM_EXTRA_ANSWERS; i++, startQnSetAnsRow++, xtraQnsTallyRow++) {
					String fmXtraQnsAnsV = xtraQnsAnsSheet + xtraQnsAnsSetsSheet.getMp_R1C1Map().get(qnAnsSetCol)
							+ startQnSetAnsRow;
					System.out.println("fmXtraQnsAnsV is " + fmXtraQnsAnsV + " for qstid " + qis.getQst_id()
							+ " col is " + col + " xtraQnsTallyRow is " + (xtraQnsTallyRow + i));
					Formula fmXtraQnsAnsVCell = new Formula(col, xtraQnsTallyRow, fmXtraQnsAnsV);
					fmXtraQnsAnsVCell.setCellFormat(FRMT_SINGLE_ANS_DATA_CELL);
					s.addCell(fmXtraQnsAnsVCell);

					String formula = "COUNTIF(" + (this.mp_R1C1Map.get(start_col))
							+ String.valueOf(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW + 1) + ":"
							+ (this.mp_R1C1Map.get(start_col))
							+ String.valueOf(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW
									+ this.getNumSources() + NUM_EXTRA_SOURCES)
							+ ", " + (this.mp_R1C1Map.get(col)) + (xtraQnsTallyRow + 1) + ")";// s.getCell(col,
																								// row).getContents()
					// if ( this.isCommaDecLocale ) {
					// formula = formula.replace('.', ',');
					//
					// }

					Formula formulaLabel = new Formula(col + 1, xtraQnsTallyRow, formula);
					formulaLabel.setCellFormat(FRMT_SINGLE_ANS_DATA_CELL);
					s.addCell(formulaLabel);
				}

			}

			s.addCell(new Label(col, (xtraQnsTallyRow + 1), "Total:", FRMT_SINGLE_ANS_DATA_CELL));

			String sumForm = "SUM(" + (this.mp_R1C1Map.get(col + 1))
					+ (row + this.getNumSources() + NUM_EXTRA_SOURCES + 10 + 1) + ":"
					+ (this.mp_R1C1Map.get(col + 1) + (xtraQnsTallyRow)) + ")";
			Formula sumFormCell = new Formula((col + 1), (xtraQnsTallyRow + 1), sumForm, FRMT_SINGLE_ANS_DATA_CELL);
			s.addCell(sumFormCell);

			this.lastTallyInfoCellFilled = sumFormCell;
			this.lastTallyInfoColumnFilled = col + 1;
			this.lastTallyInfoBottomRowFilled = (xtraQnsTallyRow + 1);

			int qstId = qis.getQst_id();
			int txtHintCol = col + 1;

			// qstnid label
			CellView hideView = new CellView();
			hideView.setHidden(true);
			s.addCell(new jxl.write.Number(col, row, qstId));
			s.setRowView(row, hideView);

			row = row + 1;

			// qstn label
			String theQnInfo = processTheQuestion(qis);// qis.getQst_numeric()
														// != 0 ?
														// qis.getQst_numeric()
														// +
														// (qis.getQst_alpha()!=
														// null ?
														// qis.getQst_alpha() :
														// "") + ". " +
														// qis.getQst_question()
														// :
														// qis.getQst_question();
			Label qstLabel = new Label(col, row, processStringForWrap(theQnInfo, col));
			qstLabel.setCellFormat(FRMT_SINGLE_ANS_DATA_CELL);

			s.addCell(qstLabel);

			// qstn hint
			row = row + 1;
			Label qstHintLabel = new Label(col, row, processStringForWrap(qis.getQst_question_hint(), col));
			qstHintLabel.setCellFormat(FRMT_SINGLE_ANS_DATA_CELL);
			s.addCell(qstHintLabel);

			// qstn text hint
			if (qis.getQst_text_required_yn().equalsIgnoreCase("Y")) {
				s.addCell(new Label(txtHintCol, 0, String.valueOf(qstId + "_H")));
				;
				Label qstTextHintLabel = new Label(txtHintCol, row,
						processStringForWrap(qis.getQst_text_hint(), txtHintCol));
				qstTextHintLabel.setCellFormat(FRMT_NORM_RED);
				s.addCell(qstTextHintLabel);
			}

			// src data
			for (int i = 0; i < this.getNumSources(); i++) {
				row = row + 1;
				int srcRepId = Integer.parseInt(s.getCell(0, row).getContents());
				SourceAnswersDataSetInfo sad = sadMap.get(srcRepId);
				if (sad != null) {
					// ans
					System.out.println("sad.getAnswer() is >" + sad.getAnswer() + "< fr srcRepId " + srcRepId);
					if (sad.getAnswer() != null) {
						String theAnswer = sad.getAnswer().trim();
						Label ansLabel = new Label(col, row, processStringForWrap(theAnswer, col));
						ansLabel.setCellFormat(FRMT_SINGLE_ANS_DATA_CELL);

						WritableCellFeatures addedfeatures = new WritableCellFeatures();
						addedfeatures.setDataValidationRange(tallyStartCol, tallyStartRow, tallyEndCol, tallyEndRow);
						ansLabel.setCellFeatures(addedfeatures);
						s.addCell(ansLabel);
					} else {
						// add empty cell and validation range
						System.out.println("creating blank for col " + col + " row " + row + " for src " + srcRepId);
						Blank emptyCell = new Blank(col, row);
						emptyCell.setCellFormat(FRMT_SINGLE_ANS_DATA_CELL);

						WritableCellFeatures addedfeatures = new WritableCellFeatures();
						addedfeatures.setDataValidationRange(tallyStartCol, tallyStartRow, tallyEndCol, tallyEndRow);
						emptyCell.setCellFeatures(addedfeatures);
						System.out.println("SINGLE_tsc " + tallyStartCol + " tsr " + tallyStartRow + " tec "
								+ tallyEndCol + " ter " + tallyEndRow);
						s.addCell(emptyCell);
					}
					if (qis.getQst_text_required_yn().equalsIgnoreCase("Y")) {
						// ans text
						if (sad.getSra_Answer_text() != null) {
							String theAnswerText = sad.getSra_Answer_text().trim();
							Label ansTextLabel = new Label(txtHintCol, row,
									processStringForWrap(theAnswerText, txtHintCol));
							// ansTextLabel.setCellFormat(FRMT_WRAP_NORMAL_ANS_CELL);

							if (sad.getSra_comment() != null) {
								System.out.println(
										"SINGLE__COMMENT IS " + sad.getSra_comment() + " qid " + qis.getQst_id());
								WritableCellFeatures addedAnsTextfeatures = new WritableCellFeatures();
								addedAnsTextfeatures.setComment(sad.getSra_comment());
								ansTextLabel.setCellFeatures(addedAnsTextfeatures);

								if (sad.getSra_color() != null) {
									System.out.println("single sadMap.get(theKey).getSra_color() != null");
									ansTextLabel.setCellFormat(FRMT_COMMENT);
								} else {
									ansTextLabel.setCellFormat(FRMT_WRAP_NORMAL_ANS_HINT_CELL);
								}
							} else {
								System.out.println("SINGLE__COMMENT IS NULL, col is " + txtHintCol);
								ansTextLabel.setCellFormat(FRMT_WRAP_NORMAL_ANS_HINT_CELL);
							}
							s.addCell(ansTextLabel);
						} else {
							Blank ansTextCell = new Blank(txtHintCol, row, FRMT_WRAP_NORMAL_ANS_HINT_CELL);
							s.addCell(ansTextCell);
						}
					}

				} else {
					// add empty cell and validation range
					System.out.println("creating blank for col " + col + " row " + row + " for src " + srcRepId);
					Blank emptyCell = new Blank(col, row);
					emptyCell.setCellFormat(FRMT_SINGLE_ANS_DATA_CELL);

					WritableCellFeatures addedfeatures = new WritableCellFeatures();
					addedfeatures.setDataValidationRange(tallyStartCol, tallyStartRow, tallyEndCol, tallyEndRow);
					emptyCell.setCellFeatures(addedfeatures);
					System.out.println("SINGLE_tsc " + tallyStartCol + " tsr " + tallyStartRow + " tec " + tallyEndCol
							+ " ter " + tallyEndRow);
					s.addCell(emptyCell);

					// add empty txt hint cell
					if (qis.getQst_text_required_yn().equalsIgnoreCase("Y")) {
						Blank ansTextCell = new Blank(txtHintCol, row, FRMT_WRAP_NORMAL_ANS_HINT_CELL);
						s.addCell(ansTextCell);
					}

				}
			} // ends for existing

			row++;

			// blanks for additional sources
			for (int es = 0; es < NUM_EXTRA_SOURCES; es++, row++) {
				// add empty cell and validation range
				Blank emptyCell = new Blank(col, row);
				emptyCell.setCellFormat(FRMT_SINGLE_ANS_DATA_CELL);

				WritableCellFeatures addedfeatures = new WritableCellFeatures();
				addedfeatures.setDataValidationRange(tallyStartCol, tallyStartRow, tallyEndCol, tallyEndRow);
				emptyCell.setCellFeatures(addedfeatures);
				System.out.println("SINGLE_tsc " + tallyStartCol + " tsr " + tallyStartRow + " tec " + tallyEndCol
						+ " ter " + tallyEndRow);
				s.addCell(emptyCell);

				// add empty txt hint cell
				if (qis.getQst_text_required_yn().equalsIgnoreCase("Y")) {
					Blank ansTextCell = new Blank(txtHintCol, row, FRMT_WRAP_NORMAL_ANS_HINT_CELL);
					s.addCell(ansTextCell);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// multi can either have data ( numeric requires 2 columns) or single (one
	// column) or text ( one column )
	private void fillMultiQuestionsData(QuestionDataSetInfo qis,
			LinkedHashMap<Integer, SourceAnswersDataSetInfo> sadMap, WritableSheet s,
			QuestionAnswerSetsDataSheet xtraQnsAnsSetsSheet, int col, int row) {
		System.out.println("col in multi " + col);

		try {
			boolean canAddAnswers = this.reportTemplateInfoDataSet.getListOfQuestionsForAdditionalAnswers()
					.contains(qis);

			Map<Integer, Integer> mp_QuestionIdsForAdditionalAnswersCols = null;

			if (canAddAnswers) {
				mp_QuestionIdsForAdditionalAnswersCols = xtraQnsAnsSetsSheet
						.getMp_QuestionIdsForAdditionalAnswersCols();
			}

			final String xtraQnsAnsSheet = XTRA_QSTNANS_SHEET_FORMULA_NAME;

			final int start_col = col;
			final int start_row = row;
			int qstId = qis.getQst_id();
			// qstnid label
			List<MultiQuestionDataSetInfo> mqLabInfo = qis.getMultiQuestionInfo();
			int start_lab_col = col;
			int start_lab_row = 0;// row;
			for (Iterator<MultiQuestionDataSetInfo> mq = mqLabInfo.iterator(); mq.hasNext(); start_lab_col++) {
				MultiQuestionDataSetInfo mqdsi = mq.next();
				String qmqNu = mqdsi.getQmq_number();
				String qmqTyp = mqdsi.getQmq_type();
				if (qmqTyp.equalsIgnoreCase("SINGLE")) {
					CellView hideView = new CellView();
					hideView.setHidden(true);
					String labInf = qstId + "_M_" + qmqNu + "_S";
					s.addCell(new Label(start_lab_col, start_lab_row, labInf));
					s.setRowView(start_lab_row, hideView);

				} else if (qmqTyp.equalsIgnoreCase("DATA")) {
					CellView hideView = new CellView();
					hideView.setHidden(true);
					String labInf = qstId + "_M_" + qmqNu + "_N";
					s.addCell(new Label(start_lab_col, start_lab_row, labInf));
					labInf = qstId + "_M_" + qmqNu + "_D";
					start_lab_col += 1;
					s.addCell(new Label(start_lab_col, start_lab_row, labInf));

					s.setRowView(start_lab_row, hideView);

				} else if (qmqTyp.equalsIgnoreCase("TEXT")) {
					// jxl is not allowing the cell to have the
					// contents set to QSTID_M_QMQNUMBER_T
					// probably because it has 'MT' in it :))
					// so i have removed the 'M' portion
					// now the tag will be QSTID_QMQNUMBER_T
					String labInf = qstId + "_M_" + qmqNu + "_T";// qstId +
																	// "_M_" +
																	// qmqNu +
																	// "_T";
					s.addCell(new Label(start_lab_col, start_lab_row, labInf));
					CellView hideView = new CellView();
					hideView.setHidden(true);
					s.setRowView(start_lab_row, hideView);
				}
				System.out.println("cell contents in col " + start_lab_col + " row " + start_lab_row + " is "
						+ s.getCell(start_lab_col, start_lab_row).getContents());
			}

			if (qis.getQst_text_required_yn().equalsIgnoreCase("Y")) {
				CellView hideView = new CellView();
				hideView.setHidden(true);
				String labInf = qstId + "_H";
				s.addCell(new Label(start_lab_col, start_lab_row, labInf));
				s.setRowView(start_lab_row, hideView);
			}

			// qstn label
			row = row + 1;
			int qNums = qis.getQst_multi_answers();

			String theQuestion = processTheQuestion(qis);// .getQst_numeric() !=
															// 0 ?
															// qis.getQst_numeric()
															// +
															// (qis.getQst_alpha()!=
															// null ?
															// qis.getQst_alpha()
															// : "") + ". " +
															// qis.getQst_question()
															// :
															// qis.getQst_question();
			Label qstLabel = new Label(start_col, row, processStringForWrap(theQuestion, start_col));

			qstLabel.setCellFormat(FRMT_MULTI_QSTN_INFO_DATA_CELL);

			s.addCell(qstLabel);

			// qstn hint label
			row = row + 1;
			// if numeric will require 2 columns -- 1 for number, 1 for
			// dropdown,
			// if single will require one column
			// if text will require one column
			// then comes in the txt hint

			List<String> singleAsvValues = new ArrayList<String>();
			List<String> dataAsvValues = new ArrayList<String>();

			Map<Integer, List<String>> qmAnsOptionsMap = new HashMap<Integer, List<String>>();

			boolean added = false; // for multi-single only one row

			int singleAsvValuesCount = 0;
			int dataAsvValuesCount = 0;

			int singleTallyStartCol = 0;
			int dataTallyStartCol = 0;

			int singleTallyStartRow = 0;
			int dataTallyStartRow = 0;

			int singleTallyEndCol = 0;
			int dataTallyEndCol = 0;
			int dataDropDownCol = 0;

			int dataTallyEndRow = 0;

			final String[] tallyOptions = PlatformAppModuleService.DATA_TALLY_OPTIONS;// new
																						// String[]
																						// {"",
																						// "Up",
																						// "Down",
																						// "No
																						// response",
																						// "Not
																						// applicable",
																						// "Don't
																						// know",
																						// "Other"};

			Map<String, String> multiQstnTypeInfo = new HashMap<String, String>();

			boolean isLastTallyOK = true;

			System.out.println("QnId is " + qis.getQst_id());
			System.out.println("Qn is " + qis.getQst_question());
			System.out.println("sadmap size is " + sadMap.size());

			int theQstnId = qis.getQst_id();

			// tally & calc formulas -- single
			Map<String, Integer> map_QmqNumber_ASVID = new HashMap<String, Integer>();
			Map<Integer, ArrayList<Integer>> map_ASVID_QListQMQNumbers = new HashMap<Integer, ArrayList<Integer>>();
			Map<Integer, ArrayList<String>> map_ASVID_ListSingleColumns = new HashMap<Integer, ArrayList<String>>();
			Map<Integer, List<ReportAnswerSetValuesDataSetInfo>> map_ASVID_AnswerSetValuesInfo = new HashMap<Integer, List<ReportAnswerSetValuesDataSetInfo>>();
			Map<Integer, HashMap<String, Integer>> map_ASVID_TallyRangeMap = new HashMap<Integer, HashMap<String, Integer>>();

			List<MultiQuestionDataSetInfo> mqInfo = qis.getMultiQuestionInfo();
			for (Iterator<MultiQuestionDataSetInfo> mq = mqInfo.iterator(); mq.hasNext();) {
				MultiQuestionDataSetInfo mqds = mq.next();
				String qmqType = mqds.getQmq_type();
				String qmqNumber = mqds.getQmq_number();

				multiQstnTypeInfo.put(mqds.getQmq_number(), mqds.getQmq_type());

				if (qmqType.equalsIgnoreCase("SINGLE")) {
					List<ReportAnswerSetValuesDataSetInfo> mqAnsInfo = mqds.getSingleAnswerSetsInfo();
					ReportAnswerSetValuesDataSetInfo asvSetInfo = mqAnsInfo.get(0);

					int ravAsvId = asvSetInfo.getRav_asv_id();

					if (map_ASVID_QListQMQNumbers.get(ravAsvId) != null
							&& map_ASVID_ListSingleColumns.get(ravAsvId) != null) {
						map_QmqNumber_ASVID.put(qmqNumber, ravAsvId);
						// add to existing arry list
						ArrayList<Integer> theAnsSets = map_ASVID_QListQMQNumbers.get(ravAsvId);

						theAnsSets.add(Integer.parseInt(qmqNumber));

						map_ASVID_QListQMQNumbers.put(ravAsvId, theAnsSets);
						map_ASVID_AnswerSetValuesInfo.put(ravAsvId, mqAnsInfo);

						ArrayList<String> theAnsSetColums = map_ASVID_ListSingleColumns.get(ravAsvId);
						theAnsSetColums.add(theQstnId + "_M_" + qmqNumber + "_" + "S");
						map_ASVID_ListSingleColumns.put(ravAsvId, theAnsSetColums);

					} else {
						map_QmqNumber_ASVID.put(qmqNumber, ravAsvId);
						// create one and add to the map
						ArrayList<Integer> theAnsSets = new ArrayList<Integer>();

						theAnsSets.add(Integer.parseInt(qmqNumber));

						map_ASVID_QListQMQNumbers.put(ravAsvId, theAnsSets);
						map_ASVID_AnswerSetValuesInfo.put(ravAsvId, mqAnsInfo);

						ArrayList<String> theAnsSetColums = new ArrayList<String>();
						theAnsSetColums.add(theQstnId + "_M_" + qmqNumber + "_" + "S");
						map_ASVID_ListSingleColumns.put(ravAsvId, theAnsSetColums);

					}

				}
			} // ends for tally-calc column info determination for single

			// label tally-form for single

			if (this.lastTallyInfoColumnFilled >= col) {
				isLastTallyOK = false;
				System.out.println("Last col is graeter for multi col is " + col
						+ " and this.lastTallyInfoColumnFilled is " + this.lastTallyInfoColumnFilled);
			} else {
				System.out.println("Last col is NOT GREATER for multi -- col is " + col
						+ " and this.lastTallyInfoColumnFilled is " + this.lastTallyInfoColumnFilled);
			}

			if (this.lastTallyInfoBottomRowFilled > row) {
				System.out.println("Last row is graeter for multi");
			} else {
				System.out.println("Last row is NOT GREATER for multi");
			}
			if (this.lastTallyInfoCellFilled != null) {
				if (this.lastTallyInfoCellFilled.getColumn() > col) {
					System.out.println("Last col is graeter via cellinfo for multi");
				} else {
					System.out.println("Last col is NOT GREATER for multi via cellinfo");
				}
			} else {
				System.out.println("this.lastTallyInfoCellFilled.getColumn() WAS NULL");
			}

			singleAsvValuesCount = 0;
			singleTallyStartCol = start_col;// start_col;//added ? col :
											// singleTallyStartCol;
			singleTallyStartRow = isLastTallyOK ? start_row + this.getNumSources() + NUM_EXTRA_SOURCES + 10
					+ singleAsvValuesCount + NUM_EXTRA_SOURCES
					: this.lastTallyInfoBottomRowFilled + 5 + NUM_EXTRA_SOURCES;
			singleTallyEndCol = singleTallyStartCol;

			Set<Integer> qmqSingleAns = map_ASVID_AnswerSetValuesInfo.keySet();

			for (Iterator<Integer> singAnsSets = qmqSingleAns.iterator(); singAnsSets
					.hasNext(); singleTallyStartCol += 2) {
				isLastTallyOK = this.lastTallyInfoColumnFilled >= singleTallyStartCol ? false : true;
				singleTallyStartRow = isLastTallyOK ? start_row + this.getNumSources() + NUM_EXTRA_SOURCES + 10
						+ singleAsvValuesCount + NUM_EXTRA_SOURCES
						: this.lastTallyInfoBottomRowFilled + 5 + NUM_EXTRA_SOURCES;

				final int startSingleTallyStartRow = singleTallyStartRow;

				singleTallyEndCol = singleTallyStartCol;

				int theASVAnsId = singAnsSets.next();
				List<ReportAnswerSetValuesDataSetInfo> theASVLabelInfo = map_ASVID_AnswerSetValuesInfo.get(theASVAnsId);
				for (Iterator<ReportAnswerSetValuesDataSetInfo> att = theASVLabelInfo.iterator(); att
						.hasNext(); singleAsvValuesCount++) {
					ReportAnswerSetValuesDataSetInfo theRAVInfo = att.next();

					String theMAnswerOption = theRAVInfo.getRav_answer();
					// tally label
					Label tallyLabel = new Label(singleTallyStartCol, singleTallyStartRow + singleAsvValuesCount,
							processStringForWrap(theMAnswerOption, singleTallyStartCol));
					tallyLabel.setCellFormat(FRMT_MULTI_QSTN_INFO_DATA_CELL);
					System.out.println("Added MULTI_SINGLE tally label at col, " + singleTallyStartCol + " and row "
							+ (singleTallyStartRow + singleAsvValuesCount));
					s.addCell(tallyLabel);

					// tally formula
					ArrayList<String> theCols = map_ASVID_ListSingleColumns.get(theASVAnsId);
					System.out.println("MULTI___SINGLE cols is ");
					printList(theCols);
					String formula = "";
					for (int colCount = 0; colCount < theCols.size(); colCount++) {
						String theSingleColumnn = theCols.get(colCount);
						int theSingleRefColum = s.findCell(theSingleColumnn).getColumn();// CellReferenceHelper.getColumn(
																							// theSingleColumnn
																							// );
						System.out.println("theSingleRefColum is " + theSingleRefColum + " for theSingleColumnn "
								+ theSingleColumnn);
						if (colCount > 0) {
							formula += " + ";
						}
						formula += " COUNTIF(" + (this.mp_R1C1Map.get(theSingleRefColum))
								+ String.valueOf(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW + 1) + ":"
								+ (this.mp_R1C1Map.get(theSingleRefColum))
								+ String.valueOf(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW
										+ this.getNumSources() + NUM_EXTRA_SOURCES)
								+ ", " + (this.mp_R1C1Map.get(singleTallyStartCol))
								+ String.valueOf(singleTallyStartRow + singleAsvValuesCount + 1) + ") ";
						// if ( this.isCommaDecLocale ) {
						// formula = formula.replace('.', ',');
						//
						// }

						System.out.println("MULTI___SINGLE FORMULA IS " + formula);
						Formula formulaLabel = new Formula(singleTallyStartCol + 1,
								(singleTallyStartRow + singleAsvValuesCount), formula);
						formulaLabel.setCellFormat(FRMT_MULTI_QSTN_INFO_DATA_CELL);
						s.addCell(formulaLabel);
					}
				}

				System.out.println("row is " + row);
				System.out.println("singleTallyStartRow is " + singleTallyStartRow);
				int xtraQnsTallyRow = (singleTallyStartRow
						/* + this.getNumSources() + NUM_EXTRA_SOURCES + 10 */ + singleAsvValuesCount);

				if (canAddAnswers) {
					int numAnsValues = qis.getSingleAnswerSetsInfo().size();
					int qnAnsSetCol = mp_QuestionIdsForAdditionalAnswersCols.get(qis.getQst_id()) + 1;
					int startQnSetAnsRow = AnswersGridTemplateRangeConstants.RANGE_QUESTIONS_TOP_ROW + numAnsValues + 5;

					for (int i = 0; i < AnswersGridTemplateRangeConstants.NUM_EXTRA_ANSWERS; i++, startQnSetAnsRow++, xtraQnsTallyRow++) {
						String fmXtraQnsAnsV = xtraQnsAnsSheet + xtraQnsAnsSetsSheet.getMp_R1C1Map().get(qnAnsSetCol)
								+ startQnSetAnsRow;
						System.out.println("fmXtraQnsAnsV is " + fmXtraQnsAnsV + " for qstid " + qis.getQst_id()
								+ " col is " + col + " xtraQnsTallyRow is " + (xtraQnsTallyRow));
						Formula fmXtraQnsAnsVCell = new Formula(col, xtraQnsTallyRow, fmXtraQnsAnsV);
						fmXtraQnsAnsVCell.setCellFormat(FRMT_MULTI_QSTN_INFO_DATA_CELL);
						s.addCell(fmXtraQnsAnsVCell);
						/**
						 * String formula = "COUNTIF(" +
						 * (this.mp_R1C1Map.get(start_col)) +
						 * String.valueOf(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW
						 * + 1) + ":" + (this.mp_R1C1Map.get(start_col)) +
						 * String.valueOf(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW
						 * + this.getNumSources() + NUM_EXTRA_SOURCES ) + ", " +
						 * (this.mp_R1C1Map.get(col)) + (xtraQnsTallyRow+1) +
						 * ")";//s.getCell(col, row).getContents() Formula
						 * formulaLabel = new Formula(col+1, xtraQnsTallyRow,
						 * formula);
						 * formulaLabel.setCellFormat(FRMT_MULTI_QSTN_INFO_DATA_CELL);
						 * s.addCell(formulaLabel);
						 **/

						// tally formula
						ArrayList<String> theCols = map_ASVID_ListSingleColumns.get(theASVAnsId);
						System.out.println("MULTI___SINGLE (xtra) cols is ");
						printList(theCols);
						String formula = "";
						for (int colCount = 0; colCount < theCols.size(); colCount++) {
							String theSingleColumnn = theCols.get(colCount);
							int theSingleRefColum = s.findCell(theSingleColumnn).getColumn();// CellReferenceHelper.getColumn(
																								// theSingleColumnn
																								// );
							System.out.println("theSingleRefColum (xtra)  is " + theSingleRefColum
									+ " for theSingleColumnn " + theSingleColumnn);
							if (colCount > 0) {
								formula += " + ";
							}
							formula += " COUNTIF(" + (this.mp_R1C1Map.get(theSingleRefColum))
									+ String.valueOf(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW + 1) + ":"
									+ (this.mp_R1C1Map.get(theSingleRefColum))
									+ String.valueOf(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW
											+ this.getNumSources() + NUM_EXTRA_SOURCES)
									+ ", " + (this.mp_R1C1Map.get(singleTallyStartCol))
									+ String.valueOf(xtraQnsTallyRow + 1) + ") ";

							// if ( this.isCommaDecLocale ) {
							// formula = formula.replace('.', ',');
							//
							// }
							//

							System.out.println("MULTI___SINGLE FORMULA (xtra)  IS " + formula + " col is "
									+ (singleTallyStartCol + 1) + " xtraQnsTallyRow is " + xtraQnsTallyRow);
							Formula formulaLabel = new Formula(singleTallyStartCol + 1, xtraQnsTallyRow, formula);
							formulaLabel.setCellFormat(FRMT_MULTI_QSTN_INFO_DATA_CELL);
							s.addCell(formulaLabel);
						}
					}

				}

				HashMap<String, Integer> theSingleTallyRangeMap = new HashMap<String, Integer>();
				theSingleTallyRangeMap.put("StartCol", singleTallyStartCol);
				theSingleTallyRangeMap.put("StartRow", singleTallyStartRow);
				theSingleTallyRangeMap.put("EndCol", singleTallyStartCol);
				theSingleTallyRangeMap.put("EndRow", xtraQnsTallyRow);

				map_ASVID_TallyRangeMap.put(theASVAnsId, theSingleTallyRangeMap);

				s.addCell(new Label(singleTallyStartCol, (xtraQnsTallyRow + 1), "Total:",
						FRMT_MULTI_QSTN_INFO_DATA_CELL));
				String sumForm = "SUM(" + (this.mp_R1C1Map.get(singleTallyStartCol + 1)) + (singleTallyStartRow + 1)
						+ ":" + (this.mp_R1C1Map.get(singleTallyStartCol + 1) + (xtraQnsTallyRow)) + ")";
				Formula sumFormCell = new Formula((singleTallyStartCol + 1), (xtraQnsTallyRow + 1), sumForm,
						FRMT_MULTI_QSTN_INFO_DATA_CELL);
				s.addCell(sumFormCell);

				this.lastTallyInfoCellFilled = sumFormCell;
				this.lastTallyInfoColumnFilled = singleTallyStartCol + 1;
				this.lastTallyInfoBottomRowFilled = (singleTallyStartRow + singleAsvValuesCount + 1);
				singleAsvValuesCount++;

				singleTallyStartRow = startSingleTallyStartRow;

			}

			// ends label--tally--form

			for (Iterator<MultiQuestionDataSetInfo> mq = mqInfo.iterator(); mq.hasNext(); col++) {
				MultiQuestionDataSetInfo mqds = mq.next();
				String qmqNumbr = mqds.getQmq_number();

				multiQstnTypeInfo.put(mqds.getQmq_number(), mqds.getQmq_type());

				if (mqds.getQmq_hint() != null) {
					Label qstHintLabel = new Label(col, row, processStringForWrap(mqds.getQmq_hint(), col));
					qstHintLabel.setCellFormat(FRMT_NORM_RED);
					s.addCell(qstHintLabel);
				}

				if (mqds.getQmq_type().equals("DATA")) {
					if (this.lastTallyInfoColumnFilled >= col) {
						isLastTallyOK = false;
						System.out.println("Last col is graeter for multi col is " + col
								+ " and this.lastTallyInfoColumnFilled is " + this.lastTallyInfoColumnFilled);
					} else {
						System.out.println("Last col is NOT GREATER for multi -- col is " + col
								+ " and this.lastTallyInfoColumnFilled is " + this.lastTallyInfoColumnFilled);
					}

					if (this.lastTallyInfoBottomRowFilled > row) {
						System.out.println("Last row is graeter for multi");
					} else {
						System.out.println("Last row is NOT GREATER for multi");
					}
					if (this.lastTallyInfoCellFilled != null) {
						if (this.lastTallyInfoCellFilled.getColumn() > col) {
							System.out.println("Last col is graeter via cellinfo for multi");
						} else {
							System.out.println("Last col is NOT GREATER for multi via cellinfo");
						}
					} else {
						System.out.println("this.lastTallyInfoCellFilled.getColumn() WAS NULL");
					}

					dataAsvValuesCount = 0;
					dataTallyStartCol = isLastTallyOK ? col : col + 2;
					dataTallyStartRow = isLastTallyOK
							? start_row + this.getNumSources() + 10 + dataAsvValuesCount + NUM_EXTRA_SOURCES
							: this.lastTallyInfoBottomRowFilled + 5 + NUM_EXTRA_SOURCES;
					dataTallyEndCol = dataTallyStartCol;
					dataDropDownCol = dataTallyStartCol + 1;
					for (int dto = 0; dto < tallyOptions.length; dto++) {
						System.out.println("in for -- getDataTallyOptions tallyOptions[dto] " + tallyOptions[dto]
								+ " for dto " + dto);
						s.addCell(new Label(dataDropDownCol,
								(start_row + this.getNumSources() + NUM_EXTRA_SOURCES + 10 + dto), tallyOptions[dto]));
						dataTallyEndRow = dataTallyStartRow + dto;
					}

					// start for calc and formula
					int startCalcRow = dataTallyEndRow + 15;
					int startCalcCol = dataDropDownCol - 1;
					int theCalcRow = startCalcRow;
					Map<String, Pair> tallyMap = new HashMap<String, Pair>();
					List<TallyRangeLimitsValuesDataSetInfo> tlyInfo = mqds.getTallyRangeLimitsValuesDataSetInfo();
					// labels for tallys
					for (Iterator<TallyRangeLimitsValuesDataSetInfo> tt = tlyInfo.iterator(); tt
							.hasNext(); theCalcRow++) {
						TallyRangeLimitsValuesDataSetInfo tInf = tt.next();
						String tallyFrom = tInf.getTrl_from();
						System.out.println("tallyFrom is " + tallyFrom);
						try {
							String start = Double.parseDouble(tallyFrom) > 0.0 ? "Up " : "Down ";
							if (tallyFrom.equalsIgnoreCase("0") && tInf.getTrl_to().equalsIgnoreCase("0")) {
								start = "";
							}
							System.out.println("start is " + start);
							String suffix = tInf.getTly_suffix();
							final String dash = " - ";
							String tallyTo = tInf.getTrl_to();

							if (tallyFrom == null) {
								theCalcRow = theCalcRow - 1;
								continue;
							}
							if (tallyTo == null) {
								theCalcRow = theCalcRow - 1;
								continue;
							}
							// remove minus sign for down
							String talLabInfo;
							if (start.equalsIgnoreCase("Down ") || start == "Down ") {
								talLabInfo = start + tallyFrom.substring(1) + suffix + dash + tallyTo.substring(1)
										+ suffix;
							} else {
								talLabInfo = start + tallyFrom + suffix + dash + tallyTo + suffix;
							}

							System.out.println("talLabInfo is " + talLabInfo);
							if (tallyFrom != null && tallyTo != null) {
								tallyMap.put(talLabInfo, new Pair<Integer, Integer>((int) Double.parseDouble(tallyFrom),
										(int) Double.parseDouble(tallyTo)));
								Label tallyLabel = new Label(startCalcCol, theCalcRow, talLabInfo);
								tallyLabel.setCellFormat(FRMT_MULTI_QSTN_INFO_DATA_CELL);
								s.addCell(tallyLabel);

								// =COUNTIF($Q$4:$Q$59,"<41")-COUNTIF($Q$4:$Q$59,"<=30")
								String formula = "";
								if (Double.parseDouble(tallyFrom) < 0.0) {
									formula = "COUNTIF(" + (this.mp_R1C1Map.get(start_col))
											+ String.valueOf(
													AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW + 1)
											+ ":" + (this.mp_R1C1Map.get(start_col))
											+ String.valueOf(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW
													+ this.getNumSources() + NUM_EXTRA_SOURCES)
											+ ", \"<=" + new Double(tallyFrom) + "\") " + " - " + "COUNTIF("
											+ (this.mp_R1C1Map.get(start_col))
											+ String.valueOf(
													AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW + 1)
											+ ":" + (this.mp_R1C1Map.get(start_col))
											+ String.valueOf(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW
													+ this.getNumSources() + NUM_EXTRA_SOURCES)
											+ ", \"<" + new Double(tallyTo) + "\")";
									System.out.println("FORMULA__DATATED is " + formula);
								} else if (Double.parseDouble(tallyFrom) > 0.0) {
									formula = "COUNTIF(" + (this.mp_R1C1Map.get(start_col))
											+ String.valueOf(
													AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW + 1)
											+ ":" + (this.mp_R1C1Map.get(start_col))
											+ String.valueOf(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW
													+ this.getNumSources() + NUM_EXTRA_SOURCES)
											+ ", \"<=" + new Double(tallyTo) + "\")" + " - " + "COUNTIF("
											+ (this.mp_R1C1Map.get(start_col))
											+ String.valueOf(
													AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW + 1)
											+ ":" + (this.mp_R1C1Map.get(start_col))
											+ String.valueOf(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW
													+ this.getNumSources() + NUM_EXTRA_SOURCES)
											+ ", \"<" + new Double(tallyFrom) + "\") ";
									System.out.println("FORMULA__DATATED is " + formula);
								} else if (Double.parseDouble(tallyFrom) == 0.0) {
									formula = "COUNTIF(" + (this.mp_R1C1Map.get(start_col))
											+ String.valueOf(
													AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW + 1)
											+ ":" + (this.mp_R1C1Map.get(start_col))
											+ String.valueOf(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW
													+ this.getNumSources() + NUM_EXTRA_SOURCES)
											+ ", 0 )";
								}

								// if ( this.isCommaDecLocale ) {
								// formula = formula.replace('.', ',');
								//
								// }

								Formula tallyFormulaLabel = new Formula(startCalcCol + 1, theCalcRow, formula);
								tallyFormulaLabel.setCellFormat(FRMT_MULTI_QSTN_INFO_DATA_CELL);
								s.addCell(tallyFormulaLabel);
							} else {
								theCalcRow = theCalcRow - 1;
								continue;
							}
						} catch (NumberFormatException nfe) {
							if (tallyFrom == "" || tallyFrom.equalsIgnoreCase("")) {
								theCalcRow = theCalcRow - 1;
								continue;
							}
							if (Arrays.asList(mqds.getDataTallyOptions()).contains(tallyFrom) && tallyFrom != "") {
								tallyMap.put(tallyFrom, null);
								Label tallyLabel = new Label(startCalcCol, theCalcRow, tallyFrom);
								tallyLabel.setCellFormat(FRMT_MULTI_QSTN_INFO_DATA_CELL);
								s.addCell(tallyLabel);

								String formula = "COUNTIF(" + (this.mp_R1C1Map.get(start_col + 1))
										+ String.valueOf(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW + 1)
										+ ":" + (this.mp_R1C1Map.get(start_col + 1))
										+ String.valueOf(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW
												+ this.getNumSources() + NUM_EXTRA_SOURCES)
										+ ", " + (this.mp_R1C1Map.get(startCalcCol)) + (theCalcRow + 1) + ") ";

								// if ( this.isCommaDecLocale ) {
								// formula = formula.replace('.', ',');
								//
								// }

								System.out.println("FORMULA__NORM is " + formula);
								Formula tallyFormulaLabel = new Formula(dataDropDownCol, theCalcRow, formula);
								tallyFormulaLabel.setCellFormat(FRMT_MULTI_QSTN_INFO_DATA_CELL);
								s.addCell(tallyFormulaLabel);
								continue;
							} else {
								nfe.printStackTrace();
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

					s.addCell(new Label(startCalcCol, (theCalcRow + 1), "Total:", FRMT_MULTI_QSTN_INFO_DATA_CELL));
					String sumForm = "SUM(" + (this.mp_R1C1Map.get(startCalcCol + 1)) + (startCalcRow + 2) + ":"
							+ (this.mp_R1C1Map.get(startCalcCol + 1) + theCalcRow) + ")";
					Formula formulaSum = new Formula((startCalcCol + 1), (theCalcRow + 1), sumForm);
					formulaSum.setCellFormat(FRMT_MULTI_QSTN_INFO_DATA_CELL);
					s.addCell(formulaSum);
					this.lastTallyInfoCellFilled = formulaSum;
					this.lastTallyInfoColumnFilled = startCalcCol + 1;
					this.lastTallyInfoBottomRowFilled = theCalcRow + 1;

					col = col + 1;
				} // ends data
				else if (mqds.getQmq_type().equals("TEXT")) {
					s.addCell(new Label(col, 0, String.valueOf(qstId + "_M_" + qmqNumbr + "_T")));
				}
			} // ends for

			// qstn txt hint
			if (qis.getQst_text_required_yn().equalsIgnoreCase("Y")) {
				Label qstTextHintLabel = new Label(col, row, processStringForWrap(qis.getQst_text_hint(), col));
				qstTextHintLabel.setCellFormat(FRMT_NORM_RED);
				s.addCell(qstTextHintLabel);
			}

			// answers
			// lookup on src id for each source
			for (int i = 0; i < this.getNumSources(); i++) {

				col = start_col;
				row = row + 1;
				int srcRepId = Integer.parseInt(s.getCell(0, row).getContents());
				String key = "";// = srcRepId + "00";
				for (int qmq = 1; qmq <= qNums; qmq++) {
					key = srcRepId + "00" + qmq;
					System.out.println("[this.getNumSources() ]In multi-src-ans key is " + key);
					int numericCol = col;// +1;
					int dropDownCol = numericCol + 1;// 2;
					if (sadMap.get(Integer.parseInt(key)) != null) {
						System.out.println("sadMap.get(Integer.parseInt(key)) != null for key " + key + "\n sad is \n "
								+ sadMap.get(Integer.parseInt(key)));
						SourceAnswersDataSetInfo sad = sadMap.get(Integer.parseInt(key));
						if (sad.getAnswer() != null) {
							String theAnswer = sad.getAnswer().trim();
							String qmqQstType = sad.getQmq_Qst_Type();// getQst_type();
							String qmqNumber = sad.getQmq_number();
							if (qmqQstType.equals("DATA")) {
								System.out.println("MULTI_DATA_ANS");
								boolean isTextAnswer = false;
								try {
									if (checkNumericAnswer(tallyOptions, theAnswer) && !theAnswer.equals("")) {
										isTextAnswer = true;
										System.out.println("MULTI_DATA_TXT_ANS theAnswer is " + theAnswer
												+ " lab at dropDownCol " + dropDownCol);

										// blank numeric cell

										// no numeric value - so blank cell
										Blank emptyCell = new Blank(numericCol, row, FRMT_MULTI_QSTN_INFO_DATA_CELL);
										WritableCellFeatures numFeatures = new WritableCellFeatures();
										numFeatures.setNumberValidation(-10000, WritableCellFeatures.GREATER_THAN);
										emptyCell.setCellFeatures(numFeatures);
										s.addCell(emptyCell);

										// txt ans has drop down
										Label ansLabel = new Label(dropDownCol, row,
												processStringForWrap(theAnswer, dropDownCol));
										ansLabel.setCellFormat(FRMT_MULTI_QSTN_INFO_DATA_CELL);

										WritableCellFeatures addedfeatures = new WritableCellFeatures();
										addedfeatures.setDataValidationRange(dataDropDownCol,
												(start_row + this.getNumSources() + 10), dataDropDownCol,
												(start_row + this.getNumSources() + 10 + tallyOptions.length - 1));// addedfeatures.setDataValidationList(asvValues);
										ansLabel.setCellFeatures(addedfeatures);
										s.addCell(ansLabel);
									} else {
										Double numAnswer = Double.parseDouble(theAnswer);
										Number nm = new Number(numericCol, row, numAnswer);
										System.out.println("MULTI_DATA_NUM_ANS theAnswer is " + theAnswer
												+ " lab at numericCol " + numericCol);
										processStringForWrap(theAnswer, numericCol);
										nm.setCellFormat(FRMT_MULTI_QSTN_INFO_DATA_CELL);
										WritableCellFeatures numFeatures = new WritableCellFeatures();
										numFeatures.setNumberValidation(-10000, WritableCellFeatures.GREATER_THAN);
										nm.setCellFeatures(numFeatures);
										s.addCell(nm);

										Blank emptyCell = new Blank(dropDownCol, row);
										emptyCell.setCellFormat(FRMT_MULTI_QSTN_INFO_DATA_CELL);
										// for drop-down
										WritableCellFeatures addedfeatures = new WritableCellFeatures();
										addedfeatures.setDataValidationRange(dataDropDownCol,
												(start_row + this.getNumSources() + 10), dataDropDownCol,
												(start_row + this.getNumSources() + 10 + tallyOptions.length - 1));
										emptyCell.setCellFeatures(addedfeatures);
										s.addCell(emptyCell);
									}

									col = dropDownCol;
								} catch (Exception e) {
									e.printStackTrace();
									System.out.println("Is unknown answer for DATA");
								}
							} else if (qmqQstType.equals("SINGLE")) { // qst_type=
																		// single

								Label ansLabel = new Label(col, row, processStringForWrap(theAnswer, col));
								ansLabel.setCellFormat(FRMT_MULTI_QSTN_INFO_DATA_CELL);
								WritableCellFeatures addedfeatures = new WritableCellFeatures();

								int asvANSID = map_QmqNumber_ASVID.get(qmqNumber);
								HashMap<String, Integer> asvTallyLabelMap = map_ASVID_TallyRangeMap.get(asvANSID);

								if (asvTallyLabelMap != null) {
									addedfeatures.setDataValidationRange(asvTallyLabelMap.get("StartCol"),
											asvTallyLabelMap.get("StartRow"), asvTallyLabelMap.get("EndCol"),
											asvTallyLabelMap.get("EndRow"));
									ansLabel.setCellFeatures(addedfeatures);
								}

								s.addCell(ansLabel);
							} else if (qmqQstType.equals("TEXT")) {
								Label ansLabel = new Label(col, row, processStringForWrap(theAnswer, col));
								ansLabel.setCellFormat(FRMT_MULTI_QSTN_INFO_DATA_CELL);
								s.addCell(ansLabel);
							}

						} else { // ans was null -- sad.getAnswer() was null --
									// add blanks
							// add blanks
							System.out.println("ans was null for key  " + key);
							String qmqqstType = sad.getQmq_Qst_Type();// sad.getQst_type();
							if (qmqqstType.equals("DATA")) { // 2 cols
								Blank emptyCell = new Blank(numericCol, row, FRMT_MULTI_QSTN_INFO_DATA_CELL);
								WritableCellFeatures numFeatures = new WritableCellFeatures();
								numFeatures.setNumberValidation(-10000, WritableCellFeatures.GREATER_THAN);
								emptyCell.setCellFeatures(numFeatures);
								s.addCell(emptyCell);

								emptyCell = new Blank(dropDownCol, row);
								emptyCell.setCellFormat(FRMT_MULTI_QSTN_INFO_DATA_CELL);
								// for drop-down data
								WritableCellFeatures addedfeatures = new WritableCellFeatures();
								addedfeatures.setDataValidationRange(dataDropDownCol,
										(start_row + this.getNumSources() + 10), dataDropDownCol,
										(start_row + this.getNumSources() + 10 + tallyOptions.length - 1));
								emptyCell.setCellFeatures(addedfeatures);
								s.addCell(emptyCell);

								col = dropDownCol;
							} else if (qmqqstType.equals("SINGLE")) {
								System.out.println("Entering an empty cell for multi-single " + qis.getQst_numeric()
										+ " key " + key + " in col " + col + " and row " + row + " and qmq is " + qmq);
								Blank emptyCell = new Blank(col, row);
								emptyCell.setCellFormat(FRMT_MULTI_QSTN_INFO_DATA_CELL);
								// for drop-down single
								WritableCellFeatures addedfeatures = new WritableCellFeatures();

								int asvANSID = map_QmqNumber_ASVID.get(String.valueOf(qmq));
								HashMap<String, Integer> asvTallyLabelMap = map_ASVID_TallyRangeMap.get(asvANSID);

								if (asvTallyLabelMap != null) {
									addedfeatures.setDataValidationRange(asvTallyLabelMap.get("StartCol"),
											asvTallyLabelMap.get("StartRow"), asvTallyLabelMap.get("EndCol"),
											asvTallyLabelMap.get("EndRow"));
									emptyCell.setCellFeatures(addedfeatures);
								}

								s.addCell(emptyCell);
							} else if (qmqqstType.equals("TEXT")) {
								Blank emptyCell = new Blank(col, row);
								emptyCell.setCellFormat(FRMT_MULTI_QSTN_INFO_DATA_CELL);
								s.addCell(emptyCell);
							}
						}
					} else { // ans was null --
								// sadMap.get(Integer.parseInt(key)) was null --
								// add blanks
						System.out.println("sadMap.get(Integer.parseInt(key) null for key " + key);

						// add blanks
						String multiQstnType = multiQstnTypeInfo.get(String.valueOf(qmq));// qis.getQst_type();//sad.getQst_type();
						if (multiQstnType.equals("DATA")) { // 2 cols
							Blank emptyCell = new Blank(numericCol, row, FRMT_MULTI_QSTN_INFO_DATA_CELL);
							WritableCellFeatures numFeatures = new WritableCellFeatures();
							numFeatures.setNumberValidation(-10000, WritableCellFeatures.GREATER_THAN);
							emptyCell.setCellFeatures(numFeatures);
							System.out.println("Entering blank in multi-data numericcol " + numericCol + " row " + row);
							s.addCell(emptyCell);// err

							emptyCell = new Blank(numericCol + 1, row);
							emptyCell.setCellFormat(FRMT_MULTI_QSTN_INFO_DATA_CELL);
							// for drop-down data
							WritableCellFeatures addedfeatures = new WritableCellFeatures();
							addedfeatures.setDataValidationRange(dataDropDownCol,
									(start_row + this.getNumSources() + 10), dataDropDownCol,
									(start_row + this.getNumSources() + 10 + tallyOptions.length - 1));
							emptyCell.setCellFeatures(addedfeatures);
							s.addCell(emptyCell);

							col = dropDownCol;
						} else if (multiQstnType.equals("SINGLE")) {
							System.out.println("Entering 1 empty cell for multi-single " + qis.getQst_numeric()
									+ " key " + key + " col is " + col + " and row is " + row + " and qstud is "
									+ qis.getQst_id());
							Blank emptyCell = new Blank(col, row);
							emptyCell.setCellFormat(FRMT_MULTI_QSTN_INFO_DATA_CELL);
							// for drop-down single
							WritableCellFeatures addedfeatures = new WritableCellFeatures();

							int asvANSID = map_QmqNumber_ASVID.get(String.valueOf(qmq));
							HashMap<String, Integer> asvTallyLabelMap = map_ASVID_TallyRangeMap.get(asvANSID);

							if (asvTallyLabelMap != null) {
								addedfeatures.setDataValidationRange(asvTallyLabelMap.get("StartCol"),
										asvTallyLabelMap.get("StartRow"), asvTallyLabelMap.get("EndCol"),
										asvTallyLabelMap.get("EndRow"));
								emptyCell.setCellFeatures(addedfeatures);
							}

							System.out.println("Entering blank in multi-single col " + col + " row " + row);
							s.addCell(emptyCell); // err
						} else if (multiQstnType.equals("TEXT")) {
							Blank emptyCell = new Blank(col, row);
							emptyCell.setCellFormat(FRMT_MULTI_QSTN_INFO_DATA_CELL);
							s.addCell(emptyCell);
						}
					}
					col++;
				}

				// all answer texts are the same so we just take for last one
				// only
				int theKey = Integer.parseInt(key);
				if (sadMap.get(theKey) != null) {
					SourceAnswersDataSetInfo sad = sadMap.get(theKey);
					if (sad.getSra_Answer_text() != null) {
						String theAnswerText = sad.getSra_Answer_text().trim();
						// bnn String qmqQstType = sad.getQmq_Qst_Type();
						// bnn if (qmqQstType.equals("DATA")) {

						Label ansTextLabel = new Label(col, row, processStringForWrap(theAnswerText, col));
						ansTextLabel.setCellFormat(FRMT_WRAP_NORMAL_ANS_HINT_CELL);
						s.addCell(ansTextLabel);

						if (sad.getSra_color() != null) {
							System.out.println("sad.getSra_color() != null");
							ansTextLabel.setCellFormat(FRMT_COMMENT);
						}

						if (sad.getSra_comment() != null) {
							String theComment = sad.getSra_comment();
							System.out.println("MULTIQn -- COMMENT IS " + theComment + " qid " + qis.getQst_id());

							WritableCell addedAnsText = s.getWritableCell(col, row);
							WritableCellFeatures addedAnsTextfeatures = new WritableCellFeatures();
							addedAnsTextfeatures.setComment(theComment);
							addedAnsText.setCellFeatures(addedAnsTextfeatures);

						} else {
							System.out.println("ANSTEXT_MULTI__COMMENT IS NULL, col is " + col);
						}

						/*
						 * bnn} else { // ok for both single and text Label
						 * ansTextLabel = new Label(col, row,
						 * processStringForWrap(theAnswerText, col));
						 * ansTextLabel.setCellFormat(
						 * FRMT_WRAP_NORMAL_ANS_HINT_CELL);
						 * s.addCell(ansTextLabel);
						 * 
						 * if ( sad.getSra_color() != null ) {
						 * System.out.println("sad.getSra_color() != null");
						 * ansTextLabel.setCellFormat(FRMT_COMMENT); }
						 * 
						 * if ( sad.getSra_comment() != null ) { String
						 * theComment = sad.getSra_comment();
						 * System.out.println("MULTIQn -- COMMENT IS " +
						 * theComment + " qid " + qis.getQst_id());
						 * 
						 * WritableCell addedAnsText =
						 * s.getWritableCell(col,row); WritableCellFeatures
						 * addedAnsTextfeatures = new WritableCellFeatures();
						 * addedAnsTextfeatures.setComment(theComment);
						 * addedAnsText.setCellFeatures(addedAnsTextfeatures);
						 * 
						 * } else { System.out.
						 * println("ANSTEXT_MULTI__COMMENT IS NULL, col is " +
						 * col); } }bnn
						 */
					} else {
						// // add blanks for ans text
						Blank emptyCell = new Blank(col, row, FRMT_WRAP_NORMAL_ANS_HINT_CELL);
						if (sad.getSra_color() != null) {
							System.out.println("sad.getSra_color() != null");
							emptyCell.setCellFormat(FRMT_COMMENT);
						}
						if (sad.getSra_comment() != null) {
							String theComment = sad.getSra_comment();
							System.out.println("MULTIQn -- COMMENT IS " + theComment + " qid " + qis.getQst_id());

							WritableCell addedAnsText = s.getWritableCell(col, row);
							WritableCellFeatures addedAnsTextfeatures = new WritableCellFeatures();
							addedAnsTextfeatures.setComment(theComment);
							addedAnsText.setCellFeatures(addedAnsTextfeatures);

						} else {
							System.out.println("ANSTEXT_MULTI__COMMENT IS NULL, col is " + col);
						}
						s.addCell(emptyCell);
					}
				} else {// -------------------------------------------
					Blank emptyCell = new Blank(col, row, FRMT_WRAP_NORMAL_ANS_HINT_CELL);
					s.addCell(emptyCell);
				}

			} // ends for existing src answers

			row++;
			// add blanks for extra sources
			Map<String, String> mpQnNmbr_QmqType = qis.getMpQmqNo_QmqType();

			for (int es = 0; es < NUM_EXTRA_SOURCES; es++, row++) {

				col = start_col;
				// add blanks
				for (int qmq = 1; qmq <= qNums; qmq++, col++) {
					int numericCol = col;
					int dropDownCol = numericCol + 1;

					String qmqqstType = mpQnNmbr_QmqType.get(String.valueOf(qmq));

					if (qmqqstType.equals("DATA")) { // 2 cols
						Blank emptyCell = new Blank(numericCol, row, FRMT_MULTI_QSTN_INFO_DATA_CELL);
						WritableCellFeatures numFeatures = new WritableCellFeatures();
						numFeatures.setNumberValidation(-10000, WritableCellFeatures.GREATER_THAN);
						emptyCell.setCellFeatures(numFeatures);
						s.addCell(emptyCell);

						emptyCell = new Blank(dropDownCol, row);
						emptyCell.setCellFormat(FRMT_MULTI_QSTN_INFO_DATA_CELL);
						// for drop-down data
						WritableCellFeatures addedfeatures = new WritableCellFeatures();
						addedfeatures.setDataValidationRange(dataDropDownCol, (start_row + this.getNumSources() + 10),
								dataDropDownCol, (start_row + this.getNumSources() + 10 + tallyOptions.length - 1));
						emptyCell.setCellFeatures(addedfeatures);
						s.addCell(emptyCell);

						col = dropDownCol;
					} else if (qmqqstType.equals("SINGLE")) {
						Blank emptyCell = new Blank(col, row);
						emptyCell.setCellFormat(FRMT_MULTI_QSTN_INFO_DATA_CELL);
						// for drop-down single
						WritableCellFeatures addedfeatures = new WritableCellFeatures();

						int asvANSID = map_QmqNumber_ASVID.get(String.valueOf(qmq));
						HashMap<String, Integer> asvTallyLabelMap = map_ASVID_TallyRangeMap.get(asvANSID);

						if (asvTallyLabelMap != null) {
							addedfeatures.setDataValidationRange(asvTallyLabelMap.get("StartCol"),
									asvTallyLabelMap.get("StartRow"), asvTallyLabelMap.get("EndCol"),
									asvTallyLabelMap.get("EndRow"));
							emptyCell.setCellFeatures(addedfeatures);
						}

						s.addCell(emptyCell);
					} else if (qmqqstType.equals("TEXT")) {
						Blank emptyCell = new Blank(col, row);
						emptyCell.setCellFormat(FRMT_MULTI_QSTN_INFO_DATA_CELL);
						s.addCell(emptyCell);
					}
				}

				col++;
				// txt hint
				Blank emptyCell = new Blank(col, row, FRMT_WRAP_NORMAL_ANS_HINT_CELL);
				s.addCell(emptyCell);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void fillWeightedQuestionsData(QuestionDataSetInfo qis,
			LinkedHashMap<Integer, SourceAnswersDataSetInfo> sadMap, WritableSheet s, int col, int row) {
		try {
			// header
			boolean isLastTallyOK = true;
			System.out.println("col in weight is " + col);
			if (this.lastTallyInfoColumnFilled >= col) {
				isLastTallyOK = false;
				System.out.println("Last col is graeter col is " + col + " and this.lastTallyInfoColumnFilled is "
						+ this.lastTallyInfoColumnFilled);
			} else {
				System.out.println("Last col is NOT GREATER col is " + col + " and this.lastTallyInfoColumnFilled is "
						+ this.lastTallyInfoColumnFilled);
			}

			if (this.lastTallyInfoBottomRowFilled > row) {
				System.out.println("Last row is graeter");
			} else {
				System.out.println("Last row is NOT GREATER");
			}

			int start_col = col;
			int start_row = row;
			int dataAsvValuesCount = 0;
			int dataTallyStartCol = isLastTallyOK ? start_col : this.lastTallyInfoBottomRowFilled + 5;
			// int dataTallyStartRow = start_row + this.getNumSources() + 10 +
			// dataAsvValuesCount;
			// int dataTallyEndCol = dataTallyStartCol;
			int dataDropDownColCol = dataTallyStartCol + 1;
			int dataTallyEndRow = start_row + this.getNumSources() + 10 + NUM_EXTRA_SOURCES + dataAsvValuesCount;

			// start for calc and formula
			int startCalcRow = dataTallyEndRow + 15;
			int startCalcCol = dataDropDownColCol - 1;
			int theCalcRow = startCalcRow;
			Map<String, Pair> tallyMap = new HashMap<String, Pair>();
			List<TallyRangeLimitsValuesDataSetInfo> tlyInfo = qis.getTallyRangeLimitsValuesDataSetInfo();
			// labels for tallys
			for (Iterator<TallyRangeLimitsValuesDataSetInfo> tt = tlyInfo.iterator(); tt.hasNext(); theCalcRow++) {
				TallyRangeLimitsValuesDataSetInfo tInf = tt.next();
				String tallyFrom = tInf.getTrl_from();
				System.out.println("tallyFrom is " + tallyFrom);
				try {
					String start = (tallyFrom != null ? (Double.parseDouble(tallyFrom) >= 0.0 ? "Up " : "Down ") : "");
					// System.out.println("start is " + start);
					String suffix = (tInf.getTly_suffix() != null ? tInf.getTly_suffix() : "");
					final String dash = " - ";
					String tallyTo = tInf.getTrl_to();
					String talLabInfo = start + tallyFrom + suffix + dash + tallyTo + suffix;
					System.out.println("talLabInfo is " + talLabInfo);
					if (tallyFrom != null && tallyTo != null) {
						tallyMap.put(talLabInfo, new Pair<Integer, Integer>((int) Double.parseDouble(tallyFrom),
								(int) Double.parseDouble(tallyTo)));
						Label tallyLabel = new Label(startCalcCol, theCalcRow, talLabInfo);
						tallyLabel.setCellFormat(FRMT_WGTD_QSTN_INFO_DATA_CELL);
						s.addCell(tallyLabel);

						// =COUNTIF($Q$4:$Q$59,"<41")-COUNTIF($Q$4:$Q$59,"<=30")
						/*
						 * String formula = ""; if ( Double.parseDouble(
						 * tallyFrom ) < 0.0 ) { formula = "COUNTIF(" +
						 * (this.mp_R1C1Map.get(start_col)) +
						 * String.valueOf(AnswersGridTemplateRangeConstants.
						 * RANGE_ANSWERS_TOP_ROW + 1) + ":" +
						 * (this.mp_R1C1Map.get(start_col)) +
						 * String.valueOf(AnswersGridTemplateRangeConstants.
						 * RANGE_ANSWERS_TOP_ROW + this.getNumSources()) +
						 * ", \"<=" + tallyFrom + "\") " + " - " + "COUNTIF(" +
						 * (this.mp_R1C1Map.get(start_col)) +
						 * String.valueOf(AnswersGridTemplateRangeConstants.
						 * RANGE_ANSWERS_TOP_ROW + 1) + ":" +
						 * (this.mp_R1C1Map.get(start_col)) +
						 * String.valueOf(AnswersGridTemplateRangeConstants.
						 * RANGE_ANSWERS_TOP_ROW + this.getNumSources()) +
						 * ", \"<" + tallyTo + "\")" ;
						 * System.out.println("FORMULA__DATATED is " + formula);
						 * } else if ( Double.parseDouble( tallyFrom ) > 0.0 ){
						 * formula = "COUNTIF(" +
						 * (this.mp_R1C1Map.get(start_col)) +
						 * String.valueOf(AnswersGridTemplateRangeConstants.
						 * RANGE_ANSWERS_TOP_ROW + 1) + ":" +
						 * (this.mp_R1C1Map.get(start_col)) +
						 * String.valueOf(AnswersGridTemplateRangeConstants.
						 * RANGE_ANSWERS_TOP_ROW + this.getNumSources()) +
						 * ", \"<=" + tallyTo + "\")" + " - " + "COUNTIF(" +
						 * (this.mp_R1C1Map.get(start_col)) +
						 * String.valueOf(AnswersGridTemplateRangeConstants.
						 * RANGE_ANSWERS_TOP_ROW + 1) + ":" +
						 * (this.mp_R1C1Map.get(start_col)) +
						 * String.valueOf(AnswersGridTemplateRangeConstants.
						 * RANGE_ANSWERS_TOP_ROW + this.getNumSources()) +
						 * ", \"<" + tallyFrom + "\") " ;
						 * System.out.println("FORMULA__DATATED is " + formula);
						 * } else if ( Double.parseDouble( tallyFrom ) == 0.0 )
						 * { formula = "COUNTIF(" +
						 * (this.mp_R1C1Map.get(start_col)) +
						 * String.valueOf(AnswersGridTemplateRangeConstants.
						 * RANGE_ANSWERS_TOP_ROW + 1) + ":" +
						 * (this.mp_R1C1Map.get(start_col)) +
						 * String.valueOf(AnswersGridTemplateRangeConstants.
						 * RANGE_ANSWERS_TOP_ROW + this.getNumSources()) +
						 * ", 0 )"; }
						 */

						String tallyFromVal = this.getLocaleDecimalValue(this.currentLocale, tallyFrom);
						String tallyToVal = this.getLocaleDecimalValue(this.currentLocale, tallyTo);

						String formula = "COUNTIF(" + (this.mp_R1C1Map.get(start_col))
								+ String.valueOf(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW + 1) + ":"
								+ (this.mp_R1C1Map.get(start_col))
								+ String.valueOf(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW
										+ this.getNumSources() + NUM_EXTRA_SOURCES)
								+ ", \"<=" + tallyToVal + "\")" + " - " + "COUNTIF(" + (this.mp_R1C1Map.get(start_col))
								+ String.valueOf(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW + 1) + ":"
								+ (this.mp_R1C1Map.get(start_col))
								+ String.valueOf(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW
										+ this.getNumSources() + NUM_EXTRA_SOURCES)
								+ ", \"<=" + tallyFromVal + "\") ";

						// if ( this.isCommaDecLocale ) {
						// formula = formula.replace('.', ',');
						//
						// }

						System.out.println("FORMULA__DATATED is " + formula);
						Formula tallyFormulaLabel = new Formula(startCalcCol + 1, theCalcRow, formula);
						tallyFormulaLabel.setCellFormat(FRMT_WGTD_QSTN_INFO_DATA_CELL);
						s.addCell(tallyFormulaLabel);
					}
				} catch (NumberFormatException nfe) {
					if (Arrays.asList(qis.getDataTallyOptions()).contains(tallyFrom)) {
						tallyMap.put(tallyFrom, null);
						Label tallyLabel = new Label(startCalcCol, theCalcRow, tallyFrom);
						tallyLabel.setCellFormat(FRMT_WGTD_QSTN_INFO_DATA_CELL);
						s.addCell(tallyLabel);

						String formula = "COUNTIF(" + (this.mp_R1C1Map.get(start_col))
								+ String.valueOf(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW + 1) + ":"
								+ (this.mp_R1C1Map.get(start_col))
								+ String.valueOf(AnswersGridTemplateRangeConstants.RANGE_ANSWERS_TOP_ROW
										+ this.getNumSources() + NUM_EXTRA_SOURCES)
								+ ", " + (this.mp_R1C1Map.get(col)) + (theCalcRow + 1) + ") ";

						// if ( this.isCommaDecLocale ) {
						// formula = formula.replace('.', ',');
						//
						// }

						System.out.println("FORMULA__NORM is " + formula);
						Formula tallyFormulaLabel = new Formula(startCalcCol + 1, theCalcRow, formula);
						tallyFormulaLabel.setCellFormat(FRMT_WGTD_QSTN_INFO_DATA_CELL);
						s.addCell(tallyFormulaLabel);
						continue;
					} else {
						nfe.printStackTrace();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			s.addCell(new Label(startCalcCol, (theCalcRow + 1), "Total:", FRMT_WGTD_QSTN_INFO_DATA_CELL));
			String sumForm = "SUM(" + (this.mp_R1C1Map.get(startCalcCol + 1)) + (startCalcRow + 1) + ":"
					+ (this.mp_R1C1Map.get(startCalcCol + 1) + theCalcRow) + ")";
			Formula formulaSum = new Formula((startCalcCol + 1), (theCalcRow + 1), sumForm);
			formulaSum.setCellFormat(FRMT_WGTD_QSTN_INFO_DATA_CELL);
			s.addCell(formulaSum);

			this.lastTallyInfoCellFilled = formulaSum;
			this.lastTallyInfoColumnFilled = startCalcCol + 1;
			this.lastTallyInfoBottomRowFilled = theCalcRow + 1;

			/////////////////////////////////
			int txtHintCol = col + 1;
			int qstId = qis.getQst_id();
			// qstnid label
			CellView hideView = new CellView();
			hideView.setHidden(true);
			s.addCell(new jxl.write.Number(col, row, qstId));
			s.setRowView(row, hideView);

			row = row + 1;

			// qstn label
			Label qstLabel = new Label(col, row, processStringForWrap(qis.getQst_question(), col));// processStingForWrap(qis.getQst_question(),
																									// 45));
			qstLabel.setCellFormat(FRMT_WGTD_QSTN_INFO_DATA_CELL);

			s.addCell(qstLabel);

			row = row + 1;
			Blank emptyWgtWnCell = new Blank(col, row, FRMT_WGTD_QSTN_INFO_DATA_CELL);
			s.addCell(emptyWgtWnCell);

			if (qis.getQst_text_required_yn().equalsIgnoreCase("Y")) {
				s.addCell(new Label(txtHintCol, 0, String.valueOf(qstId + "_H")));
				Label qstTextHintLabel = new Label(txtHintCol, row,
						processStringForWrap(qis.getQst_text_hint(), txtHintCol));
				qstTextHintLabel.setCellFormat(FRMT_WGTD_QSTN_HINT_INFO_DATA_CELL);// fn(FRMT_NORM_RED);
				s.addCell(qstTextHintLabel);

				System.out.println("WGHT_____col, txtHintCol, row " + col + ", " + txtHintCol + " " + row);
			}
			// for width of ans text
			int maxLength = identifyMaxLength(sadMap);

			// src data
			for (int i = 0; i < this.getNumSources(); i++) {
				row = row + 1;
				int srcRepId = Integer.parseInt(s.getCell(0, row).getContents());
				if (sadMap.get(srcRepId) != null) {
					// ans
					if (sadMap.get(srcRepId).getAnswer() != null) {
						String theAnswer = sadMap.get(srcRepId).getAnswer().trim();
						jxl.write.Number ansLabel = new jxl.write.Number(col, row, Double.parseDouble(theAnswer));
						ansLabel.setCellFormat(FRMT_WGTD_QSTN_INFO_DATA_CELL);
						processStringForWrap(theAnswer, col);
						WritableCellFeatures numFeatures = new WritableCellFeatures();
						numFeatures.setNumberValidation(-10000, 10000, WritableCellFeatures.BETWEEN);
						ansLabel.setCellFeatures(numFeatures);
						s.addCell(ansLabel);
					} else {
						// blank ans
						Blank emptyCell = new Blank(col, row, FRMT_WGTD_QSTN_INFO_DATA_CELL);
						WritableCellFeatures numFeatures = new WritableCellFeatures();
						numFeatures.setNumberValidation(-10000, 10000, WritableCellFeatures.BETWEEN);
						emptyCell.setCellFeatures(numFeatures);
						s.addCell(emptyCell);
					}

					if (qis.getQst_text_required_yn().equalsIgnoreCase("Y")) {
						// ans text
						if (sadMap.get(srcRepId).getSra_Answer_text() != null) {
							String theAnswerText = sadMap.get(srcRepId).getSra_Answer_text().trim();
							Label ansTextLabel = new Label(txtHintCol, row,
									processStringForWrap(theAnswerText, txtHintCol)); // 25);
																						// 25));
							// ansTextLabel.setCellFormat(FRMT_WRAP_NORMAL_ANS_CELL);
							// CellView ansTextView = new CellView();
							// view.setSize(25*256);//((maxLength/45)*(256));

							if (sadMap.get(srcRepId).getSra_comment() != null) {
								System.out.println("WEIGHT__COMMENT IS " + sadMap.get(srcRepId).getSra_comment()
										+ " qid " + qis.getQst_id());
								WritableCellFeatures wcf = new WritableCellFeatures();
								wcf.setComment(sadMap.get(srcRepId).getSra_comment());
								ansTextLabel.setCellFeatures(wcf);
							}

							if (sadMap.get(srcRepId).getSra_color() != null) {
								// Colour colr =
								// resolveRGBColor(sadMap.get(srcRepId).getSra_color());
								ansTextLabel.setCellFormat(FRMT_COMMENT);
							} else {
								ansTextLabel.setCellFormat(FRMT_WRAP_NORMAL_ANS_HINT_CELL);
							}
							s.addCell(ansTextLabel);
							// s.setColumnView(col, ansTextView);
							// s.setRowView(row, 12);//(maxLength/25)*(1/20));
						} else {
							// blank ans text
							Blank emptyCell = new Blank(txtHintCol, row, FRMT_WRAP_NORMAL_ANS_HINT_CELL);
							s.addCell(emptyCell);
						}
					}

					/*
					 * } else { // blank ans Blank emptyCell = new Blank(col,
					 * row, FRMT_WGTD_QSTN_INFO_DATA_CELL); WritableCellFeatures
					 * numFeatures = new WritableCellFeatures();
					 * numFeatures.setNumberValidation(-100, 100,
					 * WritableCellFeatures.BETWEEN);
					 * emptyCell.setCellFeatures(numFeatures);
					 * s.addCell(emptyCell); // blank ans text emptyCell = new
					 * Blank(txtHintCol, row, FRMT_WRAP_NORMAL_ANS_HINT_CELL);
					 * s.addCell(emptyCell); }
					 */
				} else {
					// blank ans
					Blank emptyCell = new Blank(col, row, FRMT_WGTD_QSTN_INFO_DATA_CELL);
					WritableCellFeatures numFeatures = new WritableCellFeatures();
					numFeatures.setNumberValidation(-10000, 10000, WritableCellFeatures.BETWEEN);
					emptyCell.setCellFeatures(numFeatures);
					s.addCell(emptyCell);

					if (qis.getQst_text_required_yn().equalsIgnoreCase("Y")) {
						// blank ans text
						emptyCell = new Blank(txtHintCol, row, FRMT_WRAP_NORMAL_ANS_HINT_CELL);
						s.addCell(emptyCell);
					}
				}
			} // ends for existing sources
			// System.out.println("col is " + col + " txthintcol is " +
			// txtHintCol + "row is " + row);
			// col = txtHintCol + 2;

			row++;
			// fill empty spaces / blank cells for the additional source answers
			for (int es = 0; es < NUM_EXTRA_SOURCES; es++, row++) {
				// blank ans
				Blank emptyCell = new Blank(startCalcCol, row, FRMT_WGTD_QSTN_INFO_DATA_CELL);
				WritableCellFeatures numFeatures = new WritableCellFeatures();
				numFeatures.setNumberValidation(-10000, 10000, WritableCellFeatures.BETWEEN);
				emptyCell.setCellFeatures(numFeatures);
				s.addCell(emptyCell);

				if (qis.getQst_text_required_yn().equalsIgnoreCase("Y")) {

					// blank ans text
					emptyCell = new Blank(txtHintCol, row, FRMT_WRAP_NORMAL_ANS_HINT_CELL);
					s.addCell(emptyCell);

				}
			}

			// this.lastTallyInfoColumnFilled = col;
			// this.lastTallyInfoRowFilled = row;

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// private void fillQuestionsData00(WritableSheet s, int top_col, int
	// top_row, int bot_col, int bot_row) {
	// int col = top_col;
	// int row = top_row;
	// System.out.println("Entering fillQuestionsData -- numSources " +
	// getNumSources() + " numQuestions " + getNumQuestions()) ;
	//
	// System.out.println("fillQuestionsData topcol " + top_col + " top_row " +
	// top_row + " bot_col " + bot_col + " bot_row " + bot_row);
	// System.out.println("size Qns is " +
	// this.reportTemplateInfoDataSet.getListOfQuestions().size());
	//
	// col = top_col;
	// row = top_row;
	//
	//
	// for (Iterator<QuestionDataSetInfo> it =
	// this.reportTemplateInfoDataSet.getListOfQuestions().iterator();
	// it.hasNext(); col++) {
	//
	// row = top_row;
	// QuestionDataSetInfo qis = it.next();
	// LinkedHashMap<Integer, SourceAnswersDataSetInfo> sadMap =
	// qis.getSourceAnswersDataSets();
	//
	// if ( sadMap == null ) { System.err.println("Uh-oh"); return;
	// }//System.exit(1); }
	// if ( col == 256 ) { System.out.println("[256] qis qid" +
	// qis.getQst_id()); break; }
	// try {
	// // qstnid label
	// jxl.write.Number qstIdCell = new jxl.write.Number(col, row,
	// qis.getQst_id());
	// CellView hideView = new CellView();
	// hideView.setHidden(true);
	// s.addCell( qstIdCell );
	// s.setRowView(row, hideView);
	//
	// row = row+1;//row++;
	//
	// // qstn label
	// if ( qis.getQst_type() == "WEIGHT" || qis.getQst_type().equals("WEIGHT"))
	// {// || qis.getQst_type() == "MULTI" ) {
	// System.out.println("merging col, row, col+1, row " + col + ", " + row +
	// ", " + col+1 + ", " + row);
	// s.mergeCells(col, row, col+1, row);
	// } else if ( qis.getQst_type() == "MULTI" ||
	// qis.getQst_type().equals("MULTI")) {
	// // MultiQuestionDataSetInfo mqds = qis.get
	// int qNums = ( sadMap.size() /
	// this.reportTemplateInfoDataSet.getListOfSources().size()
	// );//qis.getMultiQuestionInfo().size();
	// System.out.println("qNums is " + qNums);
	// System.out.println("merging col, row, col+qNums, row " + col + ", " + row
	// + ", " + col+qNums + ", " + row);
	// s.mergeCells(col, row, col+qNums, row);
	// }
	// String theQuestion = qis.getQst_numeric() != 0 ? qis.getQst_numeric() +
	// ". " + qis.getQst_question() : qis.getQst_question();
	// Label qstLabel = new Label(col, row, theQuestion);
	// System.out.println("qnCol is " + col + " and row is " + row);
	/// **
	// WritableFont boldBlackFont = new WritableFont(WritableFont.ARIAL, 10,
	// WritableFont.BOLD);
	// boldBlackFont.setColour(Colour.BLACK);
	// WritableCellFormat boldBlack = new WritableCellFormat(boldBlackFont);
	// boldBlack.setWrap(true);
	// boldBlack.setAlignment(Alignment.LEFT);
	// boldBlack.setVerticalAlignment(VerticalAlignment.TOP);
	// boldBlack.setBorder(Border.ALL, BorderLineStyle.THICK);
	// boldBlack.setBackground(AnswersGridTemplateRangeConstants.QSTNS_COLOR);
	// boldBlack.setLocked(true);
	// **/
	// qstLabel.setCellFormat(FRMT_QSTN_INFO_DATA_CELL );//(boldBlack);
	// CellView view = new CellView();
	// view.setSize(45*256);
	// s.addCell( qstLabel );
	//// s.setColumnView(col, view);
	//
	// row = row+1;//row++;
	//
	// /*if ( !qis.getQst_question().equalsIgnoreCase("Repeat Sources") )
	// s.mergeCells(col, row, col+1, row);
	// */
	// // qstnhint part label
	// Label qstTextHintLabel = new Label(col, row, qis.getQst_text_hint());
	//// WritableFont boldRedFont = new WritableFont(WritableFont.ARIAL, 10,
	// WritableFont.BOLD);
	//// boldRedFont.setColour(Colour.RED);
	//// WritableCellFormat boldRed = new WritableCellFormat(boldRedFont);
	//// boldRed.setBackground(AnswersGridTemplateRangeConstants.QSTNS_COLOR);
	//// boldRed.setLocked(true);
	//// qstTextHintLabel.setCellFormat(boldRed);
	// s.addCell( qstTextHintLabel );
	//
	// Label qstHintLabel = new Label(col+1, row, qis.getQst_question_hint());
	//// WritableFont redFont = new WritableFont(WritableFont.ARIAL, 10,
	// WritableFont.NO_BOLD);
	//// redFont.setColour(Colour.RED);
	//// WritableCellFormat justRed = new WritableCellFormat(redFont);
	//// justRed.setBackground(AnswersGridTemplateRangeConstants.QSTNS_COLOR);
	//// justRed.setLocked(true);
	//// qstHintLabel.setCellFormat(justRed);
	// s.addCell( qstHintLabel );
	//
	//
	// //lookup on src id for each source
	// for ( int i = 0; i < getNumSources(); i++ ) {
	// // start populating sad map.
	// row = row+1;//row++;
	//
	// System.out.println("for ans in cell col " + col + " and row " + row + "
	// and 0thcol cell contents is (0," + row + ") ---> " +
	// s.getCell(0,row).getContents());
	// // answer
	// int srcRepId =
	// Integer.parseInt(s.getCell(0,row).getContents());//(int)((Number)s.getCell(0,row)).getValue();//.getContents();//long
	// srcId = Long.parseLong(s.getCell(0,row).getContents());
	// System.out.println("found src_id " + srcRepId);
	// if ( qis.getQst_type() == "MULTI" || qis.getQst_type().equals("MULTI")) {
	// int qNums = ( sadMap.size() /
	// this.reportTemplateInfoDataSet.getListOfSources().size() );//int qNums =
	// qis.getMultiQuestionInfo().size();
	// String key = srcRepId + "00";
	// for ( int qmq = 1; qmq <=qNums; qmq++ ) {
	// //String key = srcRepId + "00" +
	// key += qmq; // key == rps_id + 00 + numofmultiqn --- so for 3 parts 17774
	// becomes 17774001, 17774002, 17774003
	// System.out.println("for qmq srcid conv is " + key);
	// if ( sadMap.get(Integer.parseInt(key)) != null) {
	// if (sadMap.get(Integer.parseInt(key)).getAnswer() != null ) {
	// System.out.println("key is " + key + "TheANSWER is\n\n---------->" +
	// sadMap.get(Integer.parseInt(key)).getAnswer()+ "<-------------\n");
	// String theAnswer = sadMap.get(Integer.parseInt(key)).getAnswer().trim();
	// Label ansLabel = new Label(col, row, processStringForWrap(theAnswer,
	// col)); //25); 45));
	//// ansLabel.setCellFormat(FRMT_MULTI_QSTN_INFO_DATA_CELL);
	// s.addCell( ansLabel );
	// col++;
	// }
	// }
	// }
	// col++;
	//
	// // all answer texts are the same so we just take for last one only
	// int theKey = Integer.parseInt( key );
	// System.out.println("theKey is --> " + theKey + "<--");
	// if ( sadMap.get(theKey) != null) {
	// if ( sadMap.get(theKey).getSra_Answer_text() != null ) {
	// String theAnswerText = sadMap.get(theKey).getSra_Answer_text().trim();
	// Label ansTextLabel = new Label(col, row,
	// processStringForWrap(theAnswerText, col)); //25); 45));
	// ansTextLabel.setCellFormat(FRMT_WRAP_NORMAL_ANS_CELL);
	// CellView ansTextView = new CellView();
	// view.setSize((theAnswerText.length()/45)*(1/20));
	// s.addCell( ansTextLabel );
	// }
	// }
	// } else {
	// if ( sadMap.get(srcRepId) != null) {
	// System.out.println("COOOOOOL Map is NOT NULL for qid " +
	// qis.getQst_id());
	// if ( sadMap.get(srcRepId).getAnswer() != null ) {
	// System.out.println("For rpsid " + srcRepId + " ans is " +
	// sadMap.get(srcRepId).getAnswer() + "\n adding it to cell col-row [" + col
	// + ", " + row + "]");
	// String theAnswer = sadMap.get(srcRepId).getAnswer().trim();
	// Label ansLabel = new Label(col, row, processStringForWrap(theAnswer,
	// col)); //25); 45));
	//
	// if ( qis.getQst_type() == "WEIGHT" || qis.getQst_type().equals("WEIGHT"))
	// {
	// System.out.println("WEIGHT col,row " + col + ", " + row);
	// ansLabel.setCellFormat(FRMT_WGTD_QSTN_INFO_DATA_CELL);//wrapNormalAnswerFormat.setBackground(AnswersGridTemplateRangeConstants.WGHTD_COLOR);
	// } else if ( qis.getQst_type() == "SORT" ||
	// qis.getQst_type().equals("SORT")) {
	// System.out.println("SORT col,row " + col + ", " + row);
	// ansLabel.setCellFormat(FRMT_SORT_QSTN_INFO_DATA_CELL);//.setBackground(AnswersGridTemplateRangeConstants.SORT_COLOR);
	//
	// } else {
	//
	// ansLabel.setCellFormat(FRMT_WRAP_NORMAL_ANS_CELL);
	// }
	// // CellView ansView = new CellView();
	// // view.setSize((theAnswer.length()/45)*(1/20));
	// s.addCell( ansLabel );
	// // s.setRowView(row, ansView);
	//
	// System.out.println("For rpsid " + srcRepId + " anstxt is " +
	// sadMap.get(srcRepId).getSra_Answer_text() + "\n adding it to cell col-row
	// [" + (col+1) + ", " + row + "]");
	// String theAnswerText = sadMap.get(srcRepId).getAnswer().trim();
	// Label ansTextLabel = new Label(col+1, row,
	// processStringForWrap(theAnswerText, col)); //25); 45));
	// ansTextLabel.setCellFormat(FRMT_WRAP_NORMAL_ANS_CELL);
	// CellView ansTextView = new CellView();
	// view.setSize((theAnswerText.length()/45)*(1/20));
	//
	// if ( sadMap.get(srcRepId).getSra_comment() != null ) {
	// System.out.println("COMMENT IS " + sadMap.get(srcRepId).getSra_comment()
	// + " qid " + qis.getQst_id());
	// WritableCellFeatures wcf = new WritableCellFeatures();
	// wcf.setComment(sadMap.get(srcRepId).getSra_comment());
	// ansTextLabel.setCellFeatures(wcf);
	// }
	//
	// if ( sadMap.get(srcRepId).getSra_color() != null ) {
	// // Colour colr = resolveRGBColor(sadMap.get(srcRepId).getSra_color());
	// ansTextLabel.setCellFormat(FRMT_COMMENT);
	// }
	//
	// s.addCell( ansTextLabel );
	// // s.setRowView(row, ansTextView);
	// } else {
	//
	// }
	// } else {
	// System.out.println("ARGHHHH Map is NULL for qid " + qis.getQst_id() + "
	// and src");
	// }
	// }
	// }
	//
	// //if ( qis.getQst_type() == "WEIGHT" || qis.getQst_type() == "MULTI" ) {
	// row++;
	// Label mqWq = new Label(col, row, qis.getQst_type());
	// s.addCell(mqWq);
	// col = col+1;
	// //}
	//
	// row = top_row;
	//
	// } catch (RowsExceededException e) {
	// e.printStackTrace();
	// } catch (WriteException e) {
	// e.printStackTrace();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// }

	private void mergeQuestionLabelCells(WritableSheet s, int top_col, int top_row, int bot_col, int bot_row) {
		int col = 5;//
		System.out.println("top_col " + top_col);
		System.out.println("top_row " + top_row + " setting to 1");
		top_row = 1;
		int row = 1;// top_row+1; // top_row holds ids, row+1 holds labels

		for (Iterator<QuestionDataSetInfo> it = this.reportTemplateInfoDataSet.getListOfQuestions().iterator(); it
				.hasNext(); col++) {
			row = top_row;
			QuestionDataSetInfo qis = it.next();
			String qType = qis.getQst_type();
			if (qType != null) {
				if (qType.equals("REPEAT") || qType.equals("SORT"))
					continue; // no merging required
				if (qType.equals("WEIGHT") || qType.equals("SINGLE") || qType.equals("DATA") || qType.equals("TEXT")
						|| qType.equals("RATING")) {
					try {
						s.mergeCells(col, row, col + 1, row);
						// col = col+1;
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else if (qType.equals("MULTI")) {
					List<MultiQuestionDataSetInfo> mqInfo = qis.getMultiQuestionInfo();
					int qNums = mqInfo.size();
					try {
						s.mergeCells(col, row, col + qNums + 1, row);
						col = col + qNums + 1;
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}
		}

	}

	private Colour resolveRGBColor(String color) {
		System.out.println(" in resolveRGBColor string is " + color);
		if (color != null) {
			if (color.length() == 6) { // if ( color.startsWith("#") &&
										// color.length() == 7 ) {
				// color = color.substring(1); // remove the # color.length = 6

				String r = color.substring(0, 2);
				String g = color.substring(2, 4);
				String b = color.substring(4, 6);

				int theR = Integer.parseInt(r, 16);
				int theG = Integer.parseInt(g, 16);
				int theB = Integer.parseInt(b, 16);
				System.out.println("RGB r " + theR + " g " + theG + " b " + theB);

				return getClosestIndexColor(theR, theG, theB) != null ? getClosestIndexColor(theR, theG, theB)
						: Colour.DEFAULT_BACKGROUND;
				// RGB theRGB = new RGB(theR, theG, theB);
				// int

			}
		}
		return Colour.DEFAULT_BACKGROUND;
	}

	private Colour getClosestIndexColor(int r, int g, int b) {
		Colour[] indexColors = Colour.getAllColours();
		int sDiff = Integer.MAX_VALUE;
		Colour selected = null;
		boolean found = false;
		int val;
		for (int i = 0; i < indexColors.length; i++) {
			int cDiff = Math.abs(indexColors[i].getDefaultRGB().getRed() - r)
					+ Math.abs(indexColors[i].getDefaultRGB().getGreen() - g)
					+ Math.abs(indexColors[i].getDefaultRGB().getBlue() - b);
			if (cDiff < sDiff) {
				sDiff = cDiff;
				selected = indexColors[i];
				found = true;
			}
		}
		val = (selected != null) ? selected.getValue() : 9999;
		System.out.println("getClosestIndexColor found " + found + " color value " + val);
		return selected;
	}

	public void setSs(WritableSheet ss) {
		this.ss = ss;
	}

	public WritableSheet getSs() {
		return ss;
	}

	public ReportTemplateInfo getReportTemplateInfoDataSet() {
		return reportTemplateInfoDataSet;
	}

	public void setHsh_maxColumnWidth(Map<Integer, Integer> hsh_maxColumnWidth) {
		this.hsh_maxColumnWidth = hsh_maxColumnWidth;
	}

	public Map<Integer, Integer> getHsh_maxColumnWidth() {
		return hsh_maxColumnWidth;
	}

	public void setAnsGridWorkbook(WritableWorkbook ansGridWorkbook) {
		this.ansGridWorkbook = ansGridWorkbook;
	}

	public WritableWorkbook getAnsGridWorkbook() {
		return ansGridWorkbook;
	}

	public void setCurrentLocale(Locale currentLocale) {
		this.currentLocale = currentLocale;
	}

	public Locale getCurrentLocale() {
		return currentLocale;
	}

	private boolean getIsCommaDecLocale(Locale aLocale) {
		final List<String> commaLocs = Arrays.asList(new String[] { "Albania", "Andorra", "Argentina", "Armenia",
				"Austria", "Azerbaijan", "Belarus", "Belgium", "Bolivia", "Bosnia", "Brazil", "Bulgaria", "Cameroon",
				"Canada", "Costa Rica", "Croatia", "Chile", "Colombia", "Cuba", "Cyprus", "Czech Republic", "Denmark",
				"Dominican Republic", "Ecuador", "El Salvador", "Estonia", "Faroes", "Finland", "France", "Germany",
				"Greece", "Greenland", "Guatemala", "Honduras", "Hungary", "Indonesia", "Iceland", "Italy",
				"Kazakhstan", "Latvia", "Lithuania", "Luxembourg", "Macau", "Macedonia", "Moldova", "Netherlands",
				"Norway", "Nicaragua", "Panama", "Paraguay", "Poland", "Portugal", "Romania", "Russia", "Serbia",
				"Slovakia", "South Africa", "Slovenia", "Spain", "Sweden", "Turkey", "Ukraine", "Uruguay", "Venezuela",
				"Vietnam" });
		String displayCountry = aLocale.getDisplayCountry();

		if (commaLocs.contains(displayCountry)) {
			return true;
		}

		return false;
	}

	private void printLocaleInfo() {
		System.out.println("\n___\nLOCALE IS\n");

		Locale locale = this.currentLocale;
		// Get the 2-letter language code
		String language = locale.getLanguage();
		String displayLanguage = locale.getDisplayLanguage();

		// Get the 2-letter country code; may be equal to ""
		String country = locale.getCountry();
		String displayCountry = locale.getDisplayCountry();

		// Get localized name suitable for display to the user
		String locName = locale.getDisplayName();

		System.out.println("DEFAULT language " + language);
		System.out.println("DEFAULT displayLanguage " + displayLanguage);
		System.out.println("DEFAULT country " + country);
		System.out.println("DEFAULT displayCountry " + displayCountry);
		System.out.println("DEFAULT locname " + locName);
	}

	private String getLocaleDecimalValue(Locale loc, String aString) {
		java.text.NumberFormat nf = java.text.NumberFormat.getNumberInstance(loc);
		DecimalFormat df = (DecimalFormat) nf;
		return df.format(Double.parseDouble(aString));

	}

	// private void formatColumns(WritableSheet s, int top_col) { //, int i1) {
	// int maxLength = this.hsh_maxColumnWidth.get(top_col);
	// int width = 0;
	// if ( maxLength != 0 ) {
	// if ( maxLength < 50 ) width = 25;
	// else if ( maxLength > 50 && maxLength < 300 ) width = 45;
	// else if ( maxLength > 300 ) width = 65;
	// }
	// s.setColumnView(top_col, width);
	// }

	// to get height and width for the answer cell
	final class GridCellDimension {
		int colwidth;
		int rowheight;

		public GridCellDimension() {
		}

		public GridCellDimension(int w, int h) {
			this.colwidth = w;
			this.rowheight = h;
		}

		public int getColwidth() {
			return this.colwidth;
		}

		public void setColwidth(int w) {
			this.colwidth = w;
		}

		public int getRowheight() {
			return this.rowheight;
		}

		public void setRowheight(int h) {
			this.rowheight = h;
		}

	}

	public Map<Integer, String> getMp_R1C1Map() {
		return this.mp_R1C1Map;
	}

	private static String localizedFormat(String pattern, double value, Locale loc) {
		java.text.NumberFormat nf = java.text.NumberFormat.getNumberInstance(loc);
		DecimalFormat df = (DecimalFormat) nf;
		df.applyPattern(pattern);
		String output = df.format(value);
		System.out.println(pattern + " " + output + " " + loc.toString());
		return output;
	}

}