package com.bawaweb.testing;

import java.io.*;
import jxl.*;
import jxl.write.*;

import jxl.read.biff.BiffException;

public class TestJXLStream {
    public TestJXLStream() {
    }
    public static final  String EXCEL_FILE = "C:\\jdevstudio10132\\jdev\\mywork\\PlatformBAwaWEb\\Model\\dist\\1v2test_all.xls"; 
    
    public Workbook extractWorkbook(File aFile) {
        Workbook wbook = null;
        try {
            wbook = Workbook.getWorkbook(new FileInputStream(aFile));
        } catch (BiffException e) {
            System.err.println("Error in getting workbook");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("IO Error in getting workbook");
            e.printStackTrace();
        }
        
        return wbook;
    }
    
    public static void main(String[] args) {
        TestJXLStream testJXLStream = new TestJXLStream();
        File theFile = new File(EXCEL_FILE);
        System.out.println("the file size [theFile.length()] is " + theFile.length());
        
        Workbook w = null;
        try {
            w = testJXLStream.extractWorkbook(theFile);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            WritableWorkbook ww;
            try {
                ww = Workbook.createWorkbook( baos, w );
                w.close();
                ww.close();
                
            System.out.println("writableworkbook [numsheets] is " + ww.getNumberOfSheets());
            for ( int i = 0 ; i <  ww.getNumberOfSheets(); i++ ) {
                System.out.println("Sheet[" + i + "] --> " + ww.getSheet(i).getName());
                Sheet sh = ww.getSheet(i);
                System.out.println("0 row 0 col contents --> " + sh.getCell(0,0).getContents() );
            }
            

            } catch (IOException e) {
                e.printStackTrace();
            } catch (WriteException e) {
                e.printStackTrace();
            }

            System.out.println("the file size [theFile.length()] is " + theFile.length());
            byte[] buff = baos.toByteArray();
            System.out.println("buff size is " + buff.length);

        } catch ( Exception e) { e.printStackTrace(); }
        
        
    }
}
