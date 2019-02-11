/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.sheets;

import com.bawaweb.grid.templates.AnswersGridTemplateRangeConstants;
import com.bawaweb.grid.templates.data.tables.ReportSourcesDataSet;
import com.bawaweb.grid.templates.data.tables.ReportSourcesDataSetInfo;
import com.bawaweb.grid.templates.data.tables.ReporterSourcesDataSet;
import com.bawaweb.grid.templates.data.tables.ReporterSourcesDataSetInfo;
import com.bawaweb.grid.templates.data.tables.SourceDataSet;
import com.bawaweb.grid.templates.data.tables.SourceDataSetInfo;

import com.bawaweb.services.PlatformAppModuleService;
import com.bawaweb.services.PlatformAppModuleServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import java.util.Set;

import jxl.Cell;
import jxl.Range;
import jxl.Sheet;

import jxl.biff.SheetRangeImpl;

import org.apache.log4j.Logger;
/**
 * This class reads in the 'Extra Sources' worksheet.
 * 
 */

public class ExtraSourceSheetReaderImpl implements ExtraSourceSheetReader {

    private static final Logger LOG = Logger.getLogger(ExtraSourceSheetReaderImpl.class);
    private PlatformAppModuleService platform = PlatformAppModuleServiceImpl.getInstance();
    private int reportId;
    private int reporterId;
    
    /** maps row# to source **/
    private Map<Integer, SourceDataSetInfo> mp_row_src;
    
    /** maps src to row# **/
     private Map<SourceDataSetInfo, Integer> mp_src_row = new HashMap<SourceDataSetInfo, Integer>();
     
    /** maps internal id to source **/
    private Map<Integer, SourceDataSetInfo> mp_internalsrcid_src;

    /** maps source to internal id  **/    
    private Map<SourceDataSetInfo, Integer> mp_src_interalsrcid;

    private List<Integer>                   li_invalidSrcRows;
    private List<SourceDataSetInfo>         li_invalidSrcs;
    private List<SourceDataSetInfo>         li_newRepSrcs;
    private List<SourceDataSetInfo>         li_newSrcs;
    
    private List<SourceDataSetInfo>         extraSources;
    private List<String>                    identifiedSrcs;
    
    /** the extra sources sheet **/
    private Sheet extraSourcesSheet;
    
    
    
    /** list of warning messages    **/
    private List<String> li_warnings;
    
    /** list of error messages  **/
    private List<String> li_errors;
    
    /** maps rpsid and srcid    **/
    private Map<Integer, Integer> mp_extraRepSrcIdSrcId;
    
    
    /**
     * Constructore -- reads in the Extra Sources Sheet given the particular, the report id and the reporter id
     * @param xtraSourcesSheet  -- the 'Extra Sources' Sheet to be processed
     * @param rprtId    -- the report id
     * @param rprtrId   -- the reporter id
     */
    public ExtraSourceSheetReaderImpl(Sheet xtraSourcesSheet, int rprtId, int rprtrId ) {
    
        this.reportId = rprtId;
        this.reporterId = rprtrId;
        
        this.li_errors = new ArrayList<String>();
        this.li_warnings = new ArrayList<String>();
        
        this.mp_row_src = new HashMap<Integer, SourceDataSetInfo>();
        this.mp_src_row = new HashMap<SourceDataSetInfo, Integer>();
        
        this.mp_src_interalsrcid = new HashMap<SourceDataSetInfo, Integer>();
        this.mp_internalsrcid_src = new HashMap<Integer, SourceDataSetInfo>();
        
        this.li_invalidSrcRows = new ArrayList<Integer>();
        this.li_invalidSrcs = new ArrayList<SourceDataSetInfo>();
        this.li_newRepSrcs = new ArrayList<SourceDataSetInfo>();
        this.li_newSrcs = new ArrayList<SourceDataSetInfo>();
        
        this.extraSourcesSheet = xtraSourcesSheet;
        this.mp_extraRepSrcIdSrcId = new HashMap<Integer, Integer>();
    }

  

    public void setMp_row_src(Map<Integer, SourceDataSetInfo> mp_row_src) {
        this.mp_row_src = mp_row_src;
    }

    public Map<Integer, SourceDataSetInfo> getMp_row_src() {
        return mp_row_src;
    }

    public void setMp_src_row(Map<SourceDataSetInfo, Integer> mp_src_row) {
        this.mp_src_row = mp_src_row;
    }

    public Map<SourceDataSetInfo, Integer> getMp_src_row() {
        return mp_src_row;
    }

    public void setMp_internalsrcid_src(Map<Integer, SourceDataSetInfo> mp_internalsrcid_src) {
        this.mp_internalsrcid_src = mp_internalsrcid_src;
    }

    public Map<Integer, SourceDataSetInfo> getMp_internalsrcid_src() {
        return mp_internalsrcid_src;
    }

    public void setMp_src_interalsrcid(Map<SourceDataSetInfo, Integer> mp_src_interalsrcid) {
        this.mp_src_interalsrcid = mp_src_interalsrcid;
    }

    public Map<SourceDataSetInfo, Integer> getMp_src_interalsrcid() {
        return mp_src_interalsrcid;
    }

    public void setLi_invalidSrcRows(List<Integer> li_invalidSrcRows) {
        this.li_invalidSrcRows = li_invalidSrcRows;
    }

    public List<Integer> getLi_invalidSrcRows() {
        return li_invalidSrcRows;
    }

    public void setLi_invalidSrcs(List<SourceDataSetInfo> li_invalidSrcs) {
        this.li_invalidSrcs = li_invalidSrcs;
    }

    public List<SourceDataSetInfo> getLi_invalidSrcs() {
        return li_invalidSrcs;
    }

    public void setLi_newRepSrcs(List<SourceDataSetInfo> li_newRepSrcs) {
        this.li_newRepSrcs = li_newRepSrcs;
    }

    public List<SourceDataSetInfo> getLi_newRepSrcs() {
        return li_newRepSrcs;
    }

    public void setLi_newSrcs(List<SourceDataSetInfo> li_newSrcs) {
        this.li_newSrcs = li_newSrcs;
    }

    public List<SourceDataSetInfo> getLi_newSrcs() {
        return li_newSrcs;
    }
    
    /**
     * Retrieves the list of SourceDataSetInfo objects which comprise valid 'extra sources'
     * for this report given the 'Extra Sources' sheet
     * @param extraSourcesSheet -- the 'Extra Sources' sheet to be processed
     * @return theSrcs -- a List of SourceDataSetInfo objects 
     */
    public List<SourceDataSetInfo> getExtraSources(Sheet extraSourcesSheet) {

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
                // check if all cells in the range were not null
                if( !aSrc.isNullSrc() ) {
                    this.li_warnings.add("<font color='red'>Information invalid for source at row " + (row+1) + " in sheet " + extraSourcesSheet.getName() + "</font>");
                    this.li_invalidSrcRows.add( row );
                }
                
            }
        }
        
        return theSrcs;
    }
    
    
    public void printList(List alist) {
        if ( alist == null ) { LOG.info("alist is null"); return; }
        Iterator it = alist.iterator();
        while ( it.hasNext() ) 
            LOG.info("|"+ it.next()+"|" );
    }    
    
    public void printMap(Map aMap) {
        if ( aMap == null ) { LOG.info("amap is null"); return; }
        Set aSet = aMap.keySet();
        for ( Iterator it = aSet.iterator(); it.hasNext(); ) {
            Object key = it.next();
            LOG.info(key + " ==> " + aMap.get(key));
        }
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

    public void setExtraSources(List<SourceDataSetInfo> extraSources) {
        this.extraSources = extraSources;
    }

    public List<SourceDataSetInfo> get_extraSources() {
        return extraSources;
    }

    public void setExtraSourcesSheet(Sheet extraSourcesSheet) {
        this.extraSourcesSheet = extraSourcesSheet;
    }

    public Sheet getExtraSourcesSheet() {
        return extraSourcesSheet;
    }

    public void setIdentifiedSrcs(List<String> identifiedSrcs) {
        this.identifiedSrcs = identifiedSrcs;
    }

    public List<String> getIdentifiedSrcs() {
        return identifiedSrcs;
    }
    
    public Map<Integer, Integer> getMp_extraRepSrcIdSrcId() {
        return this.mp_extraRepSrcIdSrcId;
    }
    
    public void setMp_extraRepSrcIdSrcId(Map<Integer, Integer> amap) {
        this.mp_extraRepSrcIdSrcId = amap;
    }

    /**
     * Goes through the list of SourceData objects previously retrieved via getExtraSources.
     * Returns a list of 'unique' souce objects eliminating duplicates, if they are found via the database
     * then that that source is used
     * @param extraSources
     */
    public void processExtraSources(List<SourceDataSetInfo> extraSources) {
        int ii = 0;        
        for(SourceDataSetInfo s : extraSources ) {
        ii++;
        
            if ( s.isValid() ) {
                 
                String fName = s.getSrc_first_name();
                String lName = s.getSrc_last_name();
                String city = s.getSrc_city();
                int ctryId = s.getSrc_ctry_id();
                String company = s.getSrc_company();
                String phone = this.removeSpecialChars( s.getSrc_phone() );
                
                List<String> s_srcs = this.platform.getSimilarSources(fName, lName, city, ctryId, company, phone);
                
                s.setSrc_rprt_id( this.reportId );
                s.setRps_rptr_id( this.reporterId );
                s.setRps_comped_yn( "N" );
                s.setRps_delete_yn( "N" );
                s.setRps_repeat_source_yn( "N" );
                
                ReportSourcesDataSetInfo rps = new ReportSourcesDataSet(reportId, reporterId, "N", "N", "N" );

                s.setReportSourceInfo( rps ); 
                
                
                ReporterSourcesDataSetInfo rptr = new ReporterSourcesDataSet();
                rptr.setRsc_delete_yn( "N" );
                rptr.setRsc_empl_id( reporterId );
                
                s.setReporterSourceInfo( rptr );
                
                s.setSrc_modified_by( String.valueOf(reporterId) );
                
                if ( s_srcs.size() > 0 && !s_srcs.get(0).equalsIgnoreCase("Error Source not found") ) {
                    int[] theSources = new int[s_srcs.size()];
                    int i = 0;
                    for(String sid : s_srcs ) {
                       theSources[i] = Integer.parseInt(sid);
                       i++;    
                    }
                    
                    int bestSrcId = platform.getBestSourceId(theSources, 0);
                     
                    if (bestSrcId >= 0) {
                        rps.setRps_src_id( bestSrcId );                        
                        s.setSrc_id( bestSrcId );
                        s.setReportSourceInfo( rps );
                        
                        this.li_newRepSrcs.add( s );
                        
                    }
                    
                } else if (s_srcs.size() == 1 && s_srcs.get(0).equalsIgnoreCase("Error Source not found") ) {    
                // num of getsimilarsources size = 0 so its a newsource
                    this.li_newSrcs.add( s );

                }
                
                
            } else {
                this.li_invalidSrcs.add( s );
            }
            
        }   // ends for
        

        if (this.li_newSrcs != null) {
            for ( SourceDataSetInfo s : this.li_newSrcs) {
                this.mp_extraRepSrcIdSrcId.put( s.getRps_id(), s.getSrc_id() );
            }
            
        }
        
        if (this.li_newRepSrcs != null) {
            for ( SourceDataSetInfo s : this.li_newRepSrcs) {
                this.mp_extraRepSrcIdSrcId.put( s.getRps_id(), s.getSrc_id() );
            }
            
        }
        
    }

    public PlatformAppModuleService getPlatform() {
        return platform;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReporterId(int reporterId) {
        this.reporterId = reporterId;
    }

    public int getReporterId() {
        return reporterId;
    }
    
   
    
    public void setLi_warnings(List<String> li_warnings) {
        this.li_warnings = li_warnings;
    }

    public List<String> getLi_warnings() {
        return this.li_warnings;
    }

    public void setLi_errors(List<String> li_errors) {
        this.li_errors = li_errors;
    }

    public List<String> getLi_errors() {
        return this.li_errors;
    }
    
    public List<String> getAll_errors() {
        return this.li_errors;
    }
    
    public void flushErrors() {
        this.li_errors  = new ArrayList<String>();
        this.li_warnings = new ArrayList<String>();
    }
    

    /**
     * Retrieves a map connecting the report-source-id to the source data object
     * @param xtraNewSrcs   -- list of source data objects - new sources to the database
     * @param xtraRepSrcs   -- list of source data objects, existing in the database but new to the report
     * @return aMap -- the map of report-source-id connected to its source data object
     */
    public Map<Integer, SourceDataSetInfo> getRpsSourceDataMap(List<SourceDataSetInfo> xtraNewSrcs, 
                                                               List<SourceDataSetInfo> xtraRepSrcs) {
        if ( xtraNewSrcs == null  && xtraRepSrcs == null ) return null;
        boolean isNewOk = ( xtraNewSrcs != null && xtraNewSrcs.size() > 0 ) ? true : false;
        boolean isRepOk = ( xtraRepSrcs != null && xtraRepSrcs.size() > 0 ) ? true : false;
        
        Map<Integer, SourceDataSetInfo> aMap = new HashMap<Integer, SourceDataSetInfo>();
        if ( isNewOk ) {
            for ( SourceDataSetInfo s : xtraNewSrcs ) {
                aMap.put( s.getRps_id(), s );
            }
        }
        if ( isRepOk ) {
            for ( SourceDataSetInfo s : xtraRepSrcs ) {
                aMap.put( s.getRps_id(), s );
            }
        }
        return aMap;
                                                                   
    }
}
