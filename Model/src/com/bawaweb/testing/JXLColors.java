package com.bawaweb.testing;
import jxl.*;
import jxl.write.*;
import jxl.format.*;

import java.io.*;
import java.util.*;

public class JXLColors {
	public static void main (String args[] ) {
		new JXLColors();
	}
        
        public JXLColors(String fileName) {
            try {
                String basePath = "/WEB-INF/fridFiles/";
                    File f = new File(basePath + fileName);
                    createColorsSheet(f);
            } catch (Exception e) { e.printStackTrace(); }
        }

	public JXLColors() {
		try {
		    String basePath = "/WEB-INF/fridFiles/";
			File f = new File(basePath + "/JXLColors.xls");
			createColorsSheet(f);
		} catch (Exception e) { e.printStackTrace(); }

	}

	private void createColorsSheet(File f) {
		if ( f.getAbsolutePath() == null ) 
			throw new IllegalArgumentException("Invalid File");
		try {
			WritableWorkbook book = Workbook.createWorkbook(new FileOutputStream(f));

			WritableSheet s = book.createSheet("JXL Colors", 0);
			jxl.format.Colour[] colours = jxl.format.Colour.getAllColours();
	
			int col = 0;
			int row = 2;

			s.addCell(new Label(col+2, row, "Colour"));
			s.addCell(new Label(col+4, row, "Value"));
			s.addCell(new Label(col+6, row, "Red"));
			s.addCell(new Label(col+7, row, "Blue"));
			s.addCell(new Label(col+8, row, "Green"));

			row += 2;
	
			for ( int i = 0; i < colours.length; i++ ) {
				System.out.println(i + " " + colours[i].getValue());

				row++;

				int val = colours[i].getValue();
				RGB rgb = colours[i].getDefaultRGB();
				
				int daBlue = rgb.getBlue();
				int daGreen = rgb.getGreen();
				int daRed = rgb.getRed();

				String thecolor = colours[i].getDescription();

			
				Label colLab = new Label(col, row, "");//null);

				WritableCellFormat wcf = new WritableCellFormat();
				wcf.setBackground(colours[i]);

				colLab.setCellFormat(wcf);

				s.addCell(colLab);

				s.addCell(new Label(col+2, row, thecolor, new WritableCellFormat(NumberFormats.INTEGER)));
				s.addCell(new Label(col+4, row, String.valueOf(val), new WritableCellFormat(NumberFormats.INTEGER)));

				s.addCell(new Label(col+6, row, String.valueOf(daRed), new WritableCellFormat(NumberFormats.INTEGER)));
				s.addCell(new Label(col+7, row, String.valueOf(daBlue), new WritableCellFormat(NumberFormats.INTEGER)));
				s.addCell(new Label(col+8, row, String.valueOf(daGreen), new WritableCellFormat(NumberFormats.INTEGER)));
			}
			book.write();
			book.close();
		} catch (Exception e) { e.printStackTrace(); }
	}
}