package com.bawaweb.testing;

import com.bawaweb.grid.templates.data.tables.ReportSourcesDataSet;
import com.bawaweb.grid.templates.data.tables.ReportSourcesDataSetInfo;
import com.bawaweb.grid.templates.data.tables.ReporterSourcesDataSet;
import com.bawaweb.grid.templates.data.tables.ReporterSourcesDataSetInfo;
import com.bawaweb.grid.templates.data.tables.SourceDataSet;
import com.bawaweb.grid.templates.data.tables.SourceDataSetInfo;
import com.bawaweb.services.PlatformAppModuleService;
import com.bawaweb.services.PlatformAppModuleServiceImpl;

public class TestCreateNewSource {
    
    
    
    public TestCreateNewSource() {
    
    }

    public static void main(String[] args) {
        PlatformAppModuleService platform = PlatformAppModuleServiceImpl.getInstance();
        TestCreateNewSource testCreateNewSource = new TestCreateNewSource();
        int reportId = 77507;
        int reporterId = 2045;
        SourceDataSetInfo s = testCreateNewSource.createSource(reportId, reporterId);
        s = platform.create ( s );
        
        try {
           platform.commitAll();
        } catch ( Exception e) {
            platform.rollbackAll();
            System.out.println("Error in updating ANSWER VALUES........... exiting!!!");
            System.exit(4);
        }
           
        
        System.out.println( s );
        
    }

    private SourceDataSetInfo createSource(int reportId, int reporterId) {
        TestCreateNewSource testCreateNewSource; // TODO type initialisation here
        SourceDataSetInfo s = new SourceDataSet();
        
        s.setSrc_courtesy_title( "Mme" );
        s.setSrc_first_name( "silvia" );
        s.setSrc_last_name( "saint" );
        s.setSrc_city( "prague");
        
        String ctryName = "Czech Republic";
        s.setSrc_country_name( ctryName );
        
        int src_ctry_id = PlatformAppModuleServiceImpl.getInstance().getCountriesListings().get( ctryName );
        s.setSrc_ctry_id(src_ctry_id);
        
        s.setSrc_status( "ACTIVE" );
        
        s.setSrc_cell_phone( this.removeSpecialChars( "65456445265" ) );
        s.setSrc_phone( this.removeSpecialChars( "123 456 4555" ) );
        s.setSrc_company( "saint company" );
        s.setSrc_job_title( "saint" );
        s.setSrc_distribution_preference( "BOTH" );
        s.setSrc_email( "ss@asint.com" );
        s.setSrc_address1( "123 astreet" );
        s.setSrc_company_type( "small" );
        s.setSrc_company_size( "45" );
        s.setSrc_industry_view( "National" );
        s.setSrc_distribution_notes( "saint saint saint" );
        
        s.setSrc_rprt_id( reportId );
        s.setRps_rptr_id( reporterId );
        s.setRps_comped_yn("N");
        s.setRps_delete_yn("N");
        s.setRps_repeat_source_yn("N");
        
        ReportSourcesDataSetInfo rps = new ReportSourcesDataSet(reportId, reporterId, "N", "N", "N" );
        s.setReportSourceInfo( rps ); 
        
        ReporterSourcesDataSetInfo rptr = new ReporterSourcesDataSet();
        rptr.setRsc_delete_yn( "N" );
        rptr.setRsc_empl_id( reporterId );
        
        s.setReporterSourceInfo( rptr );
        
        
        s.setSrc_exclusive_source_yn( "N" );
        s.setSrc_dont_contact_yn( "N" );
        s.setSrc_modified_by( String.valueOf(reporterId) );
System.out.println("SRC CREATED AND RETURNED \n" + s);        
        return s;
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
