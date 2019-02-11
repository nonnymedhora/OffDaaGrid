package com.bawaweb.testing;

import com.bawaweb.services.PlatformAppModuleService;
import com.bawaweb.services.PlatformAppModuleServiceImpl;
import com.bawaweb.views.readable.common.OtlAnswerSetValuesRView;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;

import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class TestASValues {
    public TestASValues() {
    }

    public static void main(String[] args) {
        try {
            TestASValues testASValues = new TestASValues();
            
            PlatformAppModuleService platform = PlatformAppModuleServiceImpl.getInstance();
            
            File f = new File("\\\\san-sv-filer\\nmedhora$\\my documents\\jxlTesting\\testASVValues.xls");
            
            List<String> theASVValues = platform.getAllASVValues();
            
            testASValues.createASVSheet(f, theASVValues);
            
            List<String> xlValues = testASValues.getASVValues(f);
            
            testASValues.compareLists( theASVValues, xlValues );
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    private void createASVSheet(File f, List<String> values) {
        try {
                WritableWorkbook book = Workbook.createWorkbook(new FileOutputStream(f));
                WritableSheet ss = book.createSheet("ASV Values", 0);
                int col = 0;
                int row = 0;
                
//                for ( String s : values ) {
//                    Label asvLab = new Label(col, row, s);
//                    ss.addCell( asvLab);
//                    row++;
//                }
                
                System.out.println("start");
                for ( Iterator<String> sd = values.iterator(); sd.hasNext(); row++) {
                    String s = sd.next();
                    Label asvLab = new Label(col, row, s);
                    ss.addCell( asvLab);
                }
            System.out.println("end");
                book.write();
                book.close();
System.out.println("File " + f.getAbsolutePath() + " created");
        }catch (Exception e) { e.printStackTrace(); }
    }

    private  List<String> getASVValues(File f) {
        List<String> asvValues = new ArrayList<String>();
        try {
            Workbook wbook = Workbook.getWorkbook(new FileInputStream(f));
            Sheet sheet = wbook.getSheet(0);
            
            Cell[] col0 = sheet.getColumn(0);
            for ( int i = 0; i < col0.length; i++ ) {
                Cell aCell = col0[i];
                if ( ! aCell.getType().equals(CellType.EMPTY) ) {
                    asvValues.add( aCell.getContents() );
                }
            }
        } catch ( Exception e) {
            e.printStackTrace();
        }
        
        return asvValues;
    }

    private void compareLists(List<String> theASVValues,  List<String> xlValues) {
        for ( int i = 0; i < theASVValues.size(); i++ ) {
            if ( !theASVValues.get(i).equals(xlValues.get(i))) {
                System.out.println("i is " + i + " asvVal is |" + theASVValues.get(i) + "|      and xlVal is |" + xlValues.get(i) + "|");
            }
        }
    }
}
