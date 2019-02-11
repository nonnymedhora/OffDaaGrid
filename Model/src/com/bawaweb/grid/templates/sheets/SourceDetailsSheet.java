/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.sheets;

import java.util.Iterator;

import com.bawaweb.grid.templates.AnswersGridTemplate;
import com.bawaweb.grid.templates.AnswersGridTemplateRangeConstants;
import com.bawaweb.grid.templates.data.ReportTemplateInfo;
import com.bawaweb.grid.templates.data.tables.SourceDataSetInfo;

import com.bawaweb.utils.SourcesComparator;

import java.util.Collections;
import java.util.List;

import jxl.write.Label;
import jxl.write.WritableCellFeatures;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableHyperlink;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
/**
 * generates the source details sheet for existing sources
 */
public class SourceDetailsSheet {
	
	private WritableSheet ss;
	private ReportTemplateInfo reportTemplateInfoDataSet;
	public SourceDetailsSheet (WritableSheet s, ReportTemplateInfo ris) {
		this.ss = s;
		this.reportTemplateInfoDataSet = ris;
	}
	
	private WritableCellFormat boldRedInYellow() throws WriteException {
		WritableFont boldRedFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD); 	
		boldRedFont.setColour(AnswersGridTemplateRangeConstants.RED_COLOR);
		WritableCellFormat boldRed = new WritableCellFormat(boldRedFont);
		boldRed.setBackground(AnswersGridTemplateRangeConstants.YELLOW_COLOR);
		boldRed.setLocked(false);
		return boldRed;
	}
	
	private WritableCellFormat boldBlackInWhite() throws WriteException {
		WritableFont boldRedFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD); 	
		boldRedFont.setColour(AnswersGridTemplateRangeConstants.BLACK_COLOR);
		WritableCellFormat boldRed = new WritableCellFormat(boldRedFont);
		boldRed.setBackground(AnswersGridTemplateRangeConstants.WHITE_COLOR);
		boldRed.setLocked(false);
		return boldRed;
	}
	
	
	private WritableCellFormat boldBlueInWhite() throws WriteException {
		WritableFont boldRedFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD); 	
		boldRedFont.setColour(AnswersGridTemplateRangeConstants.BLUE_COLOR);
		WritableCellFormat boldRed = new WritableCellFormat(boldRedFont);
		boldRed.setBackground(AnswersGridTemplateRangeConstants.WHITE_COLOR);
		boldRed.setLocked(false);
		return boldRed;
	}
	

	public WritableSheet createSourceDetailsSheet() {
		int col = 0;
		int row = 1;
		
		
		try {
			
			
			
			WritableCellFormat boldRed = boldRedInYellow();
			WritableCellFormat boldBlue = boldBlueInWhite();
			WritableCellFormat boldBlack = boldBlackInWhite();			
			
			col = AnswersGridTemplateRangeConstants.RANGE_EXTRA_SOURCEFIELDS_TOP_COL;
			row = AnswersGridTemplateRangeConstants.RANGE_EXTRA_SOURCEFIELDS_TOP_ROW;

			Label lbl = new Label(col, row, "Seq");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldBlack);
						
			col++;
			
			lbl = new Label(col, row, "Display");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldBlack);
			
			col++;
			lbl = new Label(col, row, "Courtesy Title");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldBlack);
			
			col++;
			lbl = new Label(col, row, "Courtesy Title Text");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldBlack);
			
			col++;
			lbl = new Label(col, row, "First Name");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldBlack);
			
			col++;
			lbl = new Label(col, row, "Last Name");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldBlack);
			
			col++;
			lbl = new Label(col, row, "Suffix");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldBlack);
			
			col++;
			lbl = new Label(col, row, "Suffix Text");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldBlack);
			
			col++;
			lbl = new Label(col, row, "Phone*");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldBlack);
			
			col++;
			lbl = new Label(col, row, "Extension");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldBlack);
			
			col++;
			lbl = new Label(col, row, "Status*");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldBlack);
			
			col++;
			lbl = new Label(col, row, "Company*");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldBlack);
			
			col++;
			lbl = new Label(col, row, "Job Title");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldBlack);
			
			col++;
			lbl = new Label(col, row, "Job Description");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldBlack);
			
			col++;
			lbl = new Label(col, row, "Company Type");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldBlack);
			
			col++;
			lbl = new Label(col, row, "Company Size");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldBlack);
			
			col++;
			lbl = new Label(col, row, "Industry View");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldBlack);
			
			col++;
			lbl = new Label(col, row, "Industry Sector");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldBlack);
			
			col++;
			lbl = new Label(col, row, "Quality Rating");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldBlack);
			
			col++;
			lbl = new Label(col, row, "Email");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldBlack);
			
			col++;
			lbl = new Label(col, row, "CellPhone");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldBlack);
			
			col++;
			lbl = new Label(col, row, "Fax");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldBlack);
			
			col++;
			lbl = new Label(col, row, "Address");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldBlack);
			
			col++;
			lbl = new Label(col, row, "Address 2");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldBlack);
			
			col++;
			lbl = new Label(col, row, "Address 3");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldBlack);
			
			col++;
			lbl = new Label(col, row, "Country");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldBlack);
			
			col++;
			lbl = new Label(col, row, "City*");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldBlack);
			
			col++;
			lbl = new Label(col, row, "State");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldBlack);
			
			col++;
			lbl = new Label(col, row, "Zip");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldBlack);
			
			col++;
			lbl = new Label(col, row, "Timezone");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldBlack);
			
			col++;
			lbl = new Label(col, row, "Exclusive Source");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldBlack);
			
			col++;
			lbl = new Label(col, row, "Don't Contact");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldBlack);
			
			col++;
			lbl = new Label(col, row, "Distribution Preference");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldBlack);
			
			col++;
			lbl = new Label(col, row, "Reporters");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldBlack);
			
			col++;
			lbl = new Label(col, row, "Industries");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldBlack);
			
			col++;
			lbl = new Label(col, row, "Area of Expertise");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldBlack);
			
			col++;
			lbl = new Label(col, row, "Vendors");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldBlack);
			
			col++;
			lbl = new Label(col, row, "Notes");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldBlack);
			
			col++;
			lbl = new Label(col, row, "Special Requests");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldBlack);
			
			col++;
			lbl = new Label(col, row, "Distribution Notes");
			this.ss.addCell(lbl);			
			lbl.setCellFormat(boldBlack);
			
			
			col = 0;
			row++;
			int srcSeq = 1;
                        
                        List<SourceDataSetInfo> sources = this.reportTemplateInfoDataSet.getListOfSources();
		        Collections.sort( sources, new SourcesComparator() );
                        
			for ( Iterator it = sources.iterator(); it.hasNext(); srcSeq++) {
				col = 0;
				SourceDataSetInfo sis = (SourceDataSetInfo) it.next();
				try {
					Label srcSeqLabel = new Label(col, row, String.valueOf(srcSeq));
					this.ss.addCell( srcSeqLabel );
					col++;
					
					Label srcLabel = new Label(col, row,  sis.getSrc_display_name().replaceAll("null", ""));
					this.ss.addCell( srcLabel );
					WritableHyperlink whl = new WritableHyperlink(col, row, sis.getSrc_display_name().replaceAll("null", ""), (WritableSheet) AnswersGridTemplate.getSheetMap().get(AnswersGridTemplateRangeConstants.ANSWERS_GRID_SHEET_NAME), 2, row-2);//AnswersGridTemplateRangeConstants.RANGE_EXTRA_SOURCEFIELDS_BOT_ROW+1);
	                this.ss.addHyperlink(whl);
					col++;
					
					
					/*
					WritableHyperlink whl = new WritableHyperlink(col, row, sis.getSrc_display_name().replaceAll("null", ""), (WritableSheet) sheetMap.get(AnswersGridTemplateRangeConstants.SOURCE_DETAILS_SHEET_NAME), 0, row);//AnswersGridTemplateRangeConstants.RANGE_EXTRA_SOURCEFIELDS_BOT_ROW+1);
	                ss.addHyperlink(whl);*/
					
					srcLabel = sis.getSrc_courtesy_title() != null ? 
							new Label(col, row, sis.getSrc_courtesy_title().replaceAll("null", "")) :
							new Label(col, row, "")	;
					this.ss.addCell( srcLabel );
					col++;
	                
					
					col++; // courtesytitletext ???
					srcLabel = sis.getSrc_first_name() != null ?
							new Label(col, row, sis.getSrc_first_name().replaceAll("null", "")) :
							new Label(col, row, "")	;
					this.ss.addCell( srcLabel );
					col++;

					srcLabel = sis.getSrc_last_name() != null ?
							new Label(col, row, sis.getSrc_last_name().replaceAll("null", "")) :
							new Label(col, row, "");
					this.ss.addCell( srcLabel );
					col++;

					srcLabel = sis.getSrc_suffix_title()  != null ?
							new Label(col, row, sis.getSrc_suffix_title().replaceAll("null", "")) :
							new Label(col, row, "");
					this.ss.addCell( srcLabel );
					col++;
					
					col++; // suffix title text ??
					srcLabel = sis.getSrc_phone() != null ?
							new Label(col, row, sis.getSrc_phone().replaceAll("null", "")) :
							new Label(col, row, "");
					this.ss.addCell( srcLabel );
					col++;

					srcLabel = sis.getSrc_phone_ext() != null ?
							new Label(col, row, sis.getSrc_phone_ext().replaceAll("null", "")) :
							new Label(col, row, "");
					this.ss.addCell( srcLabel );
					col++;

					srcLabel = sis.getSrc_status() != null ?
							new Label(col, row, sis.getSrc_status().replaceAll("null", "")) :
							new Label(col, row, "");
					this.ss.addCell( srcLabel );
					col++;

					srcLabel = sis.getSrc_company() != null ?
							new Label(col, row, sis.getSrc_company().replaceAll("null", "")) :
							new Label(col, row, "");
					this.ss.addCell( srcLabel );
					col++;

					srcLabel = sis.getSrc_job_title() != null ?
							new Label(col, row, sis.getSrc_job_title().replaceAll("null", "")) :
							new Label(col, row, "");
					this.ss.addCell( srcLabel );
					col++;

					srcLabel = sis.getSrc_job_description() != null ?
							new Label(col, row, sis.getSrc_job_description().replaceAll("null", "")) :
							new Label(col, row, "");
					this.ss.addCell( srcLabel );
					col++;

					srcLabel = sis.getSrc_company_type() != null ?
							new Label(col, row, sis.getSrc_company_type().replaceAll("null", "")) :
							new Label(col, row, "");
					this.ss.addCell( srcLabel );
					col++;

					srcLabel = sis.getSrc_company_size() != null ?
							new Label(col, row, sis.getSrc_company_size().replaceAll("null", "")) :
							new Label(col, row, "");
					this.ss.addCell( srcLabel );
					col++;

					srcLabel = sis.getSrc_industry_view() != null ?
							new Label(col, row, sis.getSrc_industry_view().replaceAll("null", "")) :
							new Label(col, row, "");
					this.ss.addCell( srcLabel );
					col++;

					srcLabel = sis.getSrc_industry_sector() != null ?
							new Label(col, row, sis.getSrc_industry_sector().replaceAll("null", "")) :
							new Label(col, row, "");
					this.ss.addCell( srcLabel );
					col++;

					srcLabel = sis.getSrc_quality_rating() != null ?
							new Label(col, row, sis.getSrc_quality_rating().replaceAll("null", "")) :
							new Label(col, row, "");
					this.ss.addCell( srcLabel );
					col++;

					srcLabel = sis.getSrc_email() != null ?
							new Label(col, row, sis.getSrc_email().replaceAll("null", "")) :
							new Label(col, row, "");
					this.ss.addCell( srcLabel );
					col++;

					srcLabel = sis.getSrc_cell_phone() != null ?
							new Label(col, row, sis.getSrc_cell_phone().replaceAll("null", "")) :
							new Label(col, row, "");
					this.ss.addCell( srcLabel );
					col++;

					srcLabel =  sis.getSrc_fax() != null ?
							new Label(col, row, sis.getSrc_fax().replaceAll("null", "")) :
							new Label(col, row, "");
					this.ss.addCell( srcLabel );
					col++;

					srcLabel = sis.getSrc_address1() != null ?
							new Label(col, row, sis.getSrc_address1().replaceAll("null", "")) :
							new Label(col, row, "");
					this.ss.addCell( srcLabel );
					col++;

					srcLabel = sis.getSrc_address2() != null ?
							new Label(col, row, sis.getSrc_address2().replaceAll("null", "")) :
							new Label(col, row, "");
					this.ss.addCell( srcLabel );
					col++;

					srcLabel = sis.getSrc_address3() != null ?
							new Label(col, row, sis.getSrc_address3().replaceAll("null", "")) :
							new Label(col, row, "");
					this.ss.addCell( srcLabel );
					col++;
					
					srcLabel = new Label(col, row, String.valueOf(sis.getSrc_ctry_id()));//.replaceAll("null", ""));
					this.ss.addCell( srcLabel );
					col++;
					
					srcLabel = sis.getSrc_city() != null ?
							new Label(col, row, sis.getSrc_city().replaceAll("null", "")) :
							new Label(col, row, "");
					this.ss.addCell( srcLabel );
					col++;
					
					srcLabel = sis.getSrc_state() != null ?
							new Label(col, row, sis.getSrc_state().replaceAll("null", "")) :
							new Label(col, row, "");
					this.ss.addCell( srcLabel );
					col++;
					
					srcLabel = sis.getSrc_zip() != null ?
							new Label(col, row, sis.getSrc_zip().replaceAll("null", "")) :
							new Label(col, row, "");
					this.ss.addCell( srcLabel );
					col++;
					
					srcLabel = new Label(col, row, String.valueOf(sis.getSrc_tmz_id()));//.replaceAll("null", ""));
					this.ss.addCell( srcLabel );
					col++;
					
					srcLabel = sis.getSrc_exclusive_source_yn() != null ?
							new Label(col, row, sis.getSrc_exclusive_source_yn().replaceAll("null", "")) :
							new Label(col, row, "");
					this.ss.addCell( srcLabel );
					col++;
					
					srcLabel = sis.getSrc_dont_contact_yn() != null ?
							new Label(col, row, sis.getSrc_dont_contact_yn().replaceAll("null", "")) :
							new Label(col, row, "");
					this.ss.addCell( srcLabel );
					col++;
					
					srcLabel = sis.getSrc_distribution_preference()!= null ?
							new Label(col, row, sis.getSrc_distribution_preference().replaceAll("null", "")) :
							new Label(col, row, "");
					this.ss.addCell( srcLabel );
					col++;
/*
					srcLabel = new Label(col, row, sis.getSrc_reporters_notes().replaceAll("null", ""));
					this.ss.addCell( srcLabel );
					col++;

					srcLabel = new Label(col, row, sis.getSrc_in.replaceAll("null", ""));
					this.ss.addCell( srcLabel );
					col++;

					srcLabel = new Label(col, row, sis.getSrc_distribution_preference().replaceAll("null", ""));
					this.ss.addCell( srcLabel );
					col++;

					srcLabel = new Label(col, row, sis.getSrc_distribution_preference().replaceAll("null", ""));
					this.ss.addCell( srcLabel );
					col++;

					srcLabel = new Label(col, row, sis.getSrc_distribution_preference().replaceAll("null", ""));
					this.ss.addCell( srcLabel );
					col++;*/
					row++;
				} catch (RowsExceededException e) {
					e.printStackTrace();
				} catch (WriteException e) {
					e.printStackTrace();
				}
			}
			
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}	
                
//                this.ss.getSettings().setProtected( true );
		
		return this.ss;
	}
	
	
	


}
