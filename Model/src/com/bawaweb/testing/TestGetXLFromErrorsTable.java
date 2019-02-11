package com.bawaweb.testing;

import com.bawaweb.grid.templates.sheets.AnswersGridSheetReader;
import com.bawaweb.grid.templates.sheets.AnswersGridSheetReaderImpl;
import com.bawaweb.services.PlatformAppModuleService;
import com.bawaweb.services.PlatformAppModuleServiceImpl;

import java.io.File;

import jxl.Workbook;
// gets the xl file located in bawaweb_answer_grid_error_files
public class TestGetXLFromErrorsTable {
    public TestGetXLFromErrorsTable() {
    }
     public final static String EXCEL_FILE = "\\\\san-filer1\\nmedhora$\\my documents\\jxlTesting\\test_latest.xls";

    public static void main(String[] args) {
        TestGetXLFromErrorsTable testGetXLFromErrorsTable = new TestGetXLFromErrorsTable();
        PlatformAppModuleService platform = PlatformAppModuleServiceImpl.getInstance();
        AnswersGridSheetReader reader = AnswersGridSheetReaderImpl.getInstance();        
        File theFile = new File(EXCEL_FILE);
        
        reader.setTheFile(theFile);
        
        Workbook w = reader.extractWorkbook(new File(EXCEL_FILE));
        int reportId = reader.getReportId(w);        
        int reporterId = reader.getReporterId(w);
        
        
        // upload the file to the error tables
        oracle.jbo.domain.Number agefId = platform.uploadAnswerGridErrorFile(w, reportId, reporterId);
        platform.commitAll();
        System.out.println("agefId is " + agefId);        
        
        int agef_id = agefId.intValue();//1134;//1132;
        platform.getErrorXLFile(agef_id);
    }
}
