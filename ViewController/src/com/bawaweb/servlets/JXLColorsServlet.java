/**
 * @author Nonny Medhora
 */
package com.bawaweb.servlets;

import com.bawaweb.testing.JXLColors;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

import jxl.Workbook;

import jxl.format.Colour;
import jxl.format.RGB;

import jxl.write.Label;
import jxl.write.NumberFormats;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class JXLColorsServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "application/vnd.ms-excel";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, 
                      HttpServletResponse response) throws ServletException, IOException {response.setContentType(CONTENT_TYPE);
        
        OutputStream out = null;
        try {
            String fileName = null;
            
            fileName = "JXLColors_" + System.currentTimeMillis() + ".xls";
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", 
                               "attachment; filename=" + fileName);
    
            WritableWorkbook  book = Workbook.createWorkbook(response.getOutputStream());
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
//            JXLColors colors = new JXLColors(fileName);
                               
            
            out = response.getOutputStream();
            
            out.close();
        } catch (Exception e) {
            throw new ServletException("Exception in Excel Sample Servlet", e);
        } finally {
            if (out != null)
                out.close();
        }
    }
}
