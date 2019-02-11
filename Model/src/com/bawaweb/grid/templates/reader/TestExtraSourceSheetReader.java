package com.bawaweb.grid.templates.reader;

import com.bawaweb.grid.templates.AnswersGridTemplateRangeConstants;
import com.bawaweb.grid.templates.data.tables.ReportSourcesDataSet;
import com.bawaweb.grid.templates.data.tables.ReportSourcesDataSetInfo;
import com.bawaweb.grid.templates.data.tables.ReporterSourcesDataSet;
import com.bawaweb.grid.templates.data.tables.ReporterSourcesDataSetInfo;
import com.bawaweb.grid.templates.data.tables.SourceDataSet;
import com.bawaweb.grid.templates.data.tables.SourceDataSetInfo;
import com.bawaweb.grid.templates.sheets.AnswersGridSheetReader;
import com.bawaweb.grid.templates.sheets.AnswersGridSheetReaderImpl;
import com.bawaweb.lifecycle.model.ReportSourcesVO;
import com.bawaweb.services.PlatformAppModuleService;
import com.bawaweb.services.PlatformAppModuleServiceImpl;

import java.io.File;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import java.util.Map;

import java.util.Set;

import jxl.Range;
import jxl.Sheet;
import jxl.Workbook;

import jxl.biff.SheetRangeImpl;

import org.apache.log4j.Logger;


public class TestExtraSourceSheetReader {
    private static final Logger LOG = Logger.getLogger(TestExtraSourceSheetReader.class);

    public final static int REPORTER_ID = 54054;
    public final static String EXCEL_FILE = "\\\\san-sv-filer\\nmedhora$\\my documents\\jxlTesting\\test_latest_extra_sources.xls";//test_latest_extra_sources_all_new1.xls";
    
    public TestExtraSourceSheetReader() {}
    
    // maps row# to source
    private Map<Integer, SourceDataSetInfo> mp_row_src = new HashMap<Integer, SourceDataSetInfo>();
    
    // maps src to row#
     private Map<SourceDataSetInfo, Integer> mp_src_row = new HashMap<SourceDataSetInfo, Integer>();
     
    // maps internal id to source
    private Map<Integer, SourceDataSetInfo> mp_internalsrcid_src = new HashMap<Integer, SourceDataSetInfo>();

    // maps source to internal id    
    private Map<SourceDataSetInfo, Integer> mp_src_interalsrcid = new HashMap<SourceDataSetInfo, Integer>();
    
    public static void main(String[] args) throws Exception {
        TestExtraSourceSheetReader xtraSrcReader = new TestExtraSourceSheetReader();
        
        PlatformAppModuleService platform = PlatformAppModuleServiceImpl.getInstance();
        
        AnswersGridSheetReader reader = AnswersGridSheetReaderImpl.getInstance();
        File theFile = new File(EXCEL_FILE);
        reader.setTheFile(theFile);
System.out.println("Reading file " + EXCEL_FILE);        
        
        Workbook w = reader.extractWorkbook(new File(EXCEL_FILE));
        int reportId = reader.getReportId(w);
        
        if ( reportId == 0 ) {
            throw new Exception("Invalid report id - 0" );
        //            System.exit(100);
        }
        
        int reporterId = reader.getReporterId(w);        
        if ( reporterId == 0 ) {
            throw new Exception("Invalid reporter id - 0" );
        //            System.exit(100);
        }
        
        Sheet extraSourcesSheet = reader.extractExtraSourcesSheet(w);
        
        List<SourceDataSetInfo> extraSources = xtraSrcReader.getExtraSources(extraSourcesSheet);
        //xtraSrcReader.printList(extraSources);
        
        /**
        for (Iterator<SourceDataSetInfo> it = extraSources.iterator(); it.hasNext(); ) {
            System.out.println("*********************SRC*******************");
            SourceDataSetInfo src = it.next();
            System.out.println(src);
            System.out.println("*********************ENDS SRC*******************");
        }
        **/
System.out.println("There are " + extraSources.size() + " extra sources");
//        
//        System.out.println("\n***MAP1 - row - source**\n");
//        xtraSrcReader.printMap( xtraSrcReader.getMp_row_src());
//        
//        System.out.println("\n***MAPINTERNAL - internalid - source**\n");
//        xtraSrcReader.printMap( xtraSrcReader.getMp_internalsrcid_src());
//        
//        System.out.println("\n***MAP2 - source - row**\n");
//        xtraSrcReader.printMap( xtraSrcReader.getMp_src_row());
//        
//        System.out.println("\n***REVMAPINTERNAL - source - internalid**\n");
//        xtraSrcReader.printMap( xtraSrcReader.getMp_src_interalsrcid());
//        
        List<String> identifiedSrcs = new ArrayList<String>();
        int ii = 0;
        for(SourceDataSetInfo s : extraSources ) {
        ii++;
        
            if ( s.isValid() ) {
                 
                String fName = s.getSrc_first_name();
                String lName = s.getSrc_last_name();
                String city = s.getSrc_city();
                int ctryId = s.getSrc_ctry_id();
                String company = s.getSrc_company();
                String phone = xtraSrcReader.removeSpecialChars( s.getSrc_phone() );
                
                List<String> s_srcs = platform.getSimilarSources(fName, lName, city, ctryId, company, phone);
System.out.println("______\ngetSimilarSources is \n |" + s_srcs + "| for " + fName + " " + lName + "\n___________________\n");                
                s.setSrc_rprt_id( reportId );
                s.setRps_rptr_id( reporterId );
                s.setRps_comped_yn("N");
                s.setRps_delete_yn("N");
                s.setRps_repeat_source_yn("N");
                
                ReportSourcesDataSetInfo rps = new ReportSourcesDataSet(reportId, reporterId, "N", "N", "N" );
                
//                rps.setRps_rprt_id( reportId );
//                rps.setRps_rptr_id( reporterId );
//                rps.setRps_comped_yn( "N ");
//                rps.setRps_delete_yn( "N");
//                rps.setRps_repeat_source_yn( "N" );

                s.setReportSourceInfo( rps ); 
                
                
                ReporterSourcesDataSetInfo rptr = new ReporterSourcesDataSet();
                rptr.setRsc_delete_yn( "N" );
                rptr.setRsc_empl_id( reporterId );
                
                s.setReporterSourceInfo( rptr );
                
                
                s.setSrc_exclusive_source_yn( "N" );
                s.setSrc_dont_contact_yn( "N" );
                s.setSrc_modified_by( String.valueOf(reporterId) );
                
                if ( s_srcs.size() > 0 && !s_srcs.get(0).equalsIgnoreCase("Error Source not found") ) {
                    int[] theSources = new int[s_srcs.size()];
                    int i = 0;
                    for(String sid : s_srcs ) {
//    System.out.println("sid is " + sid);                
                       theSources[i] = Integer.parseInt(sid);
                       i++;    
                    }
                    
                    int righto = platform.getBestSourceId(theSources, 0);
                    System.out.println("righto is " + righto);
                    
                     
                    if (righto >= 0) {
                        rps.setRps_src_id( righto );                        
                        s.setSrc_id( righto );
                        s.setReportSourceInfo( rps );
                        
System.out.println("ADDING NEW REPORT SOURCE " + ii + " for " + s.getSrc_first_name() + " " + s.getSrc_last_name() );  
                        xtraSrcReader.li_newRepSrcs.add( s );
                        
//                        ReportSourcesVO rpsVo = platform.createNewReportSource( s );
//                        
//                        platform.commitAll();
//                        
//                        s.setReportSourceInfo( rpsVo.transform( rpsVo ) );
                        
                        
                    }
                    
                } else {    // num of getsimilarsources size = 0
System.out.println("ADDING NEW SOURCE " + ii + " for " + s.getSrc_first_name() + " " + s.getSrc_last_name() );   
                    xtraSrcReader.li_newSrcs.add( s );

//                    platform.createNewSource( s );
//                    platform.commitAll();
                }
                
//                platform.commitAll();
            } else {
                xtraSrcReader.li_invalidSrcs.add( s );
            }
        }   // ends for
        
        
        xtraSrcReader.mp_internalsrcid_src = platform.addExtraSources( xtraSrcReader.li_newSrcs, xtraSrcReader.li_newRepSrcs, xtraSrcReader.mp_internalsrcid_src );
        
        try {
           platform.commitAll();
        } catch ( Exception e) {
            platform.rollbackAll();
            System.out.println("Error in updating / adding SOURCES........... exiting!!!");
            System.exit(4);
        }
xtraSrcReader.printMap( xtraSrcReader.mp_internalsrcid_src);        
        
    }// ends main
    
    private List<Integer> li_invalidSrcRows = new ArrayList<Integer>();
    private List<SourceDataSetInfo> li_invalidSrcs = new ArrayList<SourceDataSetInfo>();
    private List<SourceDataSetInfo> li_newRepSrcs = new ArrayList<SourceDataSetInfo>();
    private List<SourceDataSetInfo> li_newSrcs = new ArrayList<SourceDataSetInfo>();


    private List<SourceDataSetInfo> getExtraSources(Sheet extraSourcesSheet) {

        List<SourceDataSetInfo> theSrcs = new ArrayList<SourceDataSetInfo>();

        int top_col = AnswersGridTemplateRangeConstants.RANGE_EXTRA_SOURCEFIELDS_TOP_COL;
        int top_row = AnswersGridTemplateRangeConstants.RANGE_EXTRA_SOURCEFIELDS_TOP_ROW + 1;
        int bot_col = top_col + AnswersGridTemplateRangeConstants.NUM_EXTRA_SOURCEFIELDS;
        int bot_row = AnswersGridTemplateRangeConstants.RANGE_EXTRA_SOURCEFIELDS_TOP_ROW;
        
        
        int row = top_row;
        int internalId = 0;
        
        for ( int i = 0; i < AnswersGridTemplateRangeConstants.NUM_EXTRA_SOURCES; i++, row++) {
            Range sRange = new SheetRangeImpl(extraSourcesSheet, top_col+1, row, bot_col, row);
            SourceDataSetInfo aSrc = new SourceDataSet(extraSourcesSheet, sRange, "horizontal");
            if ( aSrc.isValid() ) {
            
                theSrcs.add( aSrc );
                
                this.mp_row_src.put( row, aSrc );
                this.mp_src_row.put( aSrc, row );
                
                String xtraContents = extraSourcesSheet.getCell( 0, row).getContents();
                
                internalId = Integer.parseInt( xtraContents.substring( xtraContents.indexOf('_') + 1) );
                
                aSrc.setXlInternalId( internalId );
                
                this.mp_internalsrcid_src.put( internalId, aSrc );
                this.mp_src_interalsrcid.put( aSrc, internalId );
            } else {
                this.li_invalidSrcRows.add( row );
            }
        }
        
        return theSrcs;
    }
    
    
    public void printList(List alist) {
        if ( alist == null ) { System.out.println("alist is null"); return; }
        Iterator it = alist.iterator();
        while ( it.hasNext() ) 
            System.out.println("|"+ it.next()+"|" );
    }    
    
    public void printMap(Map aMap) {
        if ( aMap == null ) { System.out.println("amap is null"); return; }
        Set aSet = aMap.keySet();
        for ( Iterator it = aSet.iterator(); it.hasNext(); ) {
            Object key = it.next();
            System.out.println(key + " ==> " + aMap.get(key));
        }
    }

    public void setMp_row_src(Map<Integer, SourceDataSetInfo> mp_row_src) {
        this.mp_row_src = mp_row_src;
    }

    public Map<Integer, SourceDataSetInfo> getMp_row_src() {
        return mp_row_src;
    }

    public void setMp_internalsrcid_src(Map<Integer, SourceDataSetInfo> mp_internalsrcid_src) {
        this.mp_internalsrcid_src = mp_internalsrcid_src;
    }

    public Map<Integer, SourceDataSetInfo> getMp_internalsrcid_src() {
        return mp_internalsrcid_src;
    }

    public void setMp_src_row(Map<SourceDataSetInfo, Integer> mp_src_row) {
        this.mp_src_row = mp_src_row;
    }

    public Map<SourceDataSetInfo, Integer> getMp_src_row() {
        return mp_src_row;
    }

    public void setMp_src_interalsrcid(Map<SourceDataSetInfo, Integer> mp_src_interalsrcid) {
        this.mp_src_interalsrcid = mp_src_interalsrcid;
    }

    public Map<SourceDataSetInfo, Integer> getMp_src_interalsrcid() {
        return mp_src_interalsrcid;
    }

    // for phone will remove all special characters
    private String removeSpecialChars(String string) {
        String s = null;
        s = string.replace( "-", "" );
        s = s.replace( "*", "" );
        s = s.replace( " ", "" );
        s = s.replace( "(", "" );
        s = s.replace( ")", "" );
        s = s.replace( ".", "" );
        return s;
    }
}


