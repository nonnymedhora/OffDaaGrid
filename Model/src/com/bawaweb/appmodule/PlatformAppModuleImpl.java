package com.bawaweb.appmodule;

import com.bawaweb.views.DBInstanceImpl;
import com.bawaweb.views.gridcursors.AnsGridErrFileInfoImpl;
import com.bawaweb.views.gridcursors.AnswerSetsInfoImpl;
import com.bawaweb.views.gridcursors.EditorInfoImpl;
import com.bawaweb.views.gridcursors.EmployeeInfoImpl;
import com.bawaweb.views.gridcursors.LeadReporterInfoImpl;
import com.bawaweb.views.gridcursors.MultiAnswerSetsImpl;
import com.bawaweb.views.gridcursors.MultiQuestionsListImpl;
import com.bawaweb.views.gridcursors.QuestionsListImpl;
import com.bawaweb.views.gridcursors.ReportGeneralInfoImpl;
import com.bawaweb.views.gridcursors.RoleScopeImpl;
import com.bawaweb.views.gridcursors.SingleAnswerSetsImpl;
import com.bawaweb.views.gridcursors.SortCriteriaSetsImpl;
import com.bawaweb.views.gridcursors.SourceMultiAnswerSetsImpl;
import com.bawaweb.views.gridcursors.SourcesListImpl;
import com.bawaweb.views.gridcursors.SourcesMultiSingleQuestionAnswersImpl;
import com.bawaweb.views.gridcursors.SourcesSingleQuestionAnswersImpl;
import com.bawaweb.views.gridcursors.SourcesSortingCriteriaSetsImpl;
import com.bawaweb.views.gridcursors.TableLocksInfoImpl;
import com.bawaweb.views.gridcursors.TallyRangeSetsImpl;
import com.bawaweb.views.gridcursors.views.AllSourcesListViewImpl;
import com.bawaweb.views.gridcursors.views.QuestionsListViewImpl;
import com.bawaweb.views.gridcursors.views.SourceNumReportsReportersLastDateViewImpl;
import com.bawaweb.views.gridcursors.views.SourcesAnswerSetsViewImpl;
import com.bawaweb.views.gridcursors.views.SourcesListViewImpl;
import com.bawaweb.views.identify.ASVAnswerValuesImpl;
import com.bawaweb.views.identify.AddAnswerSetForQstnImpl;
import com.bawaweb.views.identify.DoesSourceAnswerExistImpl;
import com.bawaweb.views.identify.DoesSourceMultiAnswerExistImpl;
import com.bawaweb.views.identify.ExtraQstnsAnswerSetValuesImpl;
import com.bawaweb.views.identify.ExtraQstnsReportAnswerSetValuesImpl;
import com.bawaweb.views.identify.GetBestSourceIdImpl;
import com.bawaweb.views.identify.GetErrXLFileInfoImpl;
import com.bawaweb.views.identify.MaxAsvIdImpl;
import com.bawaweb.views.identify.MaxRavIdImpl;
import com.bawaweb.views.identify.MaxRpsIdImpl;
import com.bawaweb.views.identify.RAVInfoImpl;
import com.bawaweb.views.identify.ReportLockInfoImpl;
import com.bawaweb.views.identify.SSCInfoImpl;
import com.bawaweb.views.identify.SrcAnsUniqueInfoImpl;
import com.bawaweb.views.model.AnswerSetValuesImpl;
import com.bawaweb.views.model.AnswerSetsImpl;
import com.bawaweb.views.model.CountriesListImpl;
import com.bawaweb.views.model.OtlAnswerSetValuesImpl;
import com.bawaweb.views.model.OtlReportAnswerSetValuesImpl;
import com.bawaweb.views.model.QuestionsImpl;
import com.bawaweb.views.model.ReportAnswerSetValuesImpl;
import com.bawaweb.views.model.ReportSourcesImpl;
import com.bawaweb.views.model.ReporterSourcesImpl;
import com.bawaweb.views.model.SourceAnswersImpl;
import com.bawaweb.views.model.SourceIndustriesImpl;
import com.bawaweb.views.model.SourceMultiAnswersImpl;
import com.bawaweb.views.model.SourceSortingCriteriaImpl;
import com.bawaweb.views.model.SourcesImpl;
import com.bawaweb.views.readable.CtryCountriesRViewImpl;
import com.bawaweb.views.readable.EmplOtlEmployeesRViewImpl;
import com.bawaweb.views.readable.FridFirmIndustriesRViewImpl;
import com.bawaweb.views.readable.OtlAnswerSetValuesRViewImpl;
import com.bawaweb.views.readable.OtlAnswerSetsRViewImpl;
import com.bawaweb.views.readable.OtlEmplRolesRViewImpl;
import com.bawaweb.views.readable.OtlFunctionsRViewImpl;
import com.bawaweb.views.readable.OtlMultiQuestionsRViewImpl;
import com.bawaweb.views.readable.OtlQuestionsRViewImpl;
import com.bawaweb.views.readable.OtlReportAnswerSetValuesRViewImpl;
import com.bawaweb.views.readable.OtlReportAnswerSetsRViewImpl;
import com.bawaweb.views.readable.OtlReportSortingCriteriaRViewImpl;
import com.bawaweb.views.readable.OtlReportSourcesRViewImpl;
import com.bawaweb.views.readable.OtlRolesRViewImpl;
import com.bawaweb.views.readable.OtlSortingCriteriaRViewImpl;
import com.bawaweb.views.readable.OtlSortingCriteriaValuesRViewImpl;
import com.bawaweb.views.readable.OtlSourceAnswersRViewImpl;
import com.bawaweb.views.readable.OtlSourceMultiAnswersRViewImpl;
import com.bawaweb.views.readable.OtlSourceSortingCriteriaRViewImpl;
import com.bawaweb.views.readable.OtlSourcesRViewImpl;
import com.bawaweb.views.readable.OtlTallyRangeLimitsRViewImpl;
import com.bawaweb.views.readable.OtlTallyRangesRViewImpl;
import com.bawaweb.views.readable.OtlTimeZonesRViewImpl;
import com.bawaweb.views.readable.OtrEmployeeInfoRViewImpl;
import com.bawaweb.views.readable.PanPanelRViewImpl;
import com.bawaweb.views.readable.RprtReportReporterXrefRViewImpl;
import com.bawaweb.views.readable.RprtReportsRViewImpl;
import com.bawaweb.views.readable.RptyReporterTypesRViewImpl;
import com.bawaweb.views.readable.RtypReportTypesRViewImpl;
import com.bawaweb.views.updatable.CtryCountriesUViewImpl;
import com.bawaweb.views.updatable.EmplOtlEmployeesUViewImpl;
import com.bawaweb.views.updatable.FridFirmIndustriesUViewImpl;
import com.bawaweb.views.updatable.OtlAnswerSetValuesUViewImpl;
import com.bawaweb.views.updatable.OtlAnswerSetsUViewImpl;
import com.bawaweb.views.updatable.OtlEmplRolesUViewImpl;
import com.bawaweb.views.updatable.OtlFunctionsUViewImpl;
import com.bawaweb.views.updatable.OtlMultiQuestionsUViewImpl;
import com.bawaweb.views.updatable.OtlQuestionsUViewImpl;
import com.bawaweb.views.updatable.OtlReportAnswerSetValuesUViewImpl;
import com.bawaweb.views.updatable.OtlReportAnswerSetsUViewImpl;
import com.bawaweb.views.updatable.OtlReportSortingCriteriaUViewImpl;
import com.bawaweb.views.updatable.OtlReportSourcesUViewImpl;
import com.bawaweb.views.updatable.OtlRolesUViewImpl;
import com.bawaweb.views.updatable.OtlSortingCriteriaUViewImpl;
import com.bawaweb.views.updatable.OtlSortingCriteriaValuesUViewImpl;
import com.bawaweb.views.updatable.OtlSourceAnswersUViewImpl;
import com.bawaweb.views.updatable.OtlSourceMultiAnswersUViewImpl;
import com.bawaweb.views.updatable.OtlSourceSortingCriteriaUViewImpl;
import com.bawaweb.views.updatable.OtlSourcesUViewImpl;
import com.bawaweb.views.updatable.OtlTallyRangeLimitsUViewImpl;
import com.bawaweb.views.updatable.OtlTallyRangesUViewImpl;
import com.bawaweb.views.updatable.OtlTimeZonesUViewImpl;
import com.bawaweb.views.updatable.OtrEmployeeInfoUViewImpl;
import com.bawaweb.views.updatable.PanPanelUViewImpl;
import com.bawaweb.views.updatable.RprtReportReporterXrefUViewImpl;
import com.bawaweb.views.updatable.RprtReportsUViewImpl;
import com.bawaweb.views.updatable.RptyReporterTypesUViewImpl;
import com.bawaweb.views.updatable.RtypReportTypesUViewImpl;

import com.bawaweb.views.utils.CourtesyTitlesImpl;
import com.bawaweb.views.utils.IndustryViewsImpl;
import com.bawaweb.views.utils.QualityRatingsImpl;
import com.bawaweb.views.utils.SourceDistributionPreferencesImpl;
import com.bawaweb.views.utils.SuffixTitlesImpl;

import com.bawaweb.views.utils.TimeZonesImpl;

import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.ViewLinkImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PlatformAppModuleImpl extends ApplicationModuleImpl {
    /**This is the default constructor (do not remove)
     */
    public PlatformAppModuleImpl() {
    }

    /**Container's getter for CtryCountriesUView1
     */
    public CtryCountriesUViewImpl getCtryCountriesUView1() {
        return (CtryCountriesUViewImpl)findViewObject("CtryCountriesUView1");
    }

    /**Container's getter for EmplOtlEmployeesUView1
     */
    public EmplOtlEmployeesUViewImpl getEmplOtlEmployeesUView1() {
        return (EmplOtlEmployeesUViewImpl)findViewObject("EmplOtlEmployeesUView1");
    }

    /**Container's getter for FridFirmIndustriesUView1
     */
    public FridFirmIndustriesUViewImpl getFridFirmIndustriesUView1() {
        return (FridFirmIndustriesUViewImpl)findViewObject("FridFirmIndustriesUView1");
    }

    /**Container's getter for OtlAnswerSetValuesUView1
     */
    public OtlAnswerSetValuesUViewImpl getOtlAnswerSetValuesUView1() {
        return (OtlAnswerSetValuesUViewImpl)findViewObject("OtlAnswerSetValuesUView1");
    }

    /**Container's getter for OtlAnswerSetsUView1
     */
    public OtlAnswerSetsUViewImpl getOtlAnswerSetsUView1() {
        return (OtlAnswerSetsUViewImpl)findViewObject("OtlAnswerSetsUView1");
    }

    /**Container's getter for OtlEmplRolesUView1
     */
    public OtlEmplRolesUViewImpl getOtlEmplRolesUView1() {
        return (OtlEmplRolesUViewImpl)findViewObject("OtlEmplRolesUView1");
    }

    /**Container's getter for OtlFunctionsUView1
     */
    public OtlFunctionsUViewImpl getOtlFunctionsUView1() {
        return (OtlFunctionsUViewImpl)findViewObject("OtlFunctionsUView1");
    }

    /**Container's getter for OtlMultiQuestionsUView1
     */
    public OtlMultiQuestionsUViewImpl getOtlMultiQuestionsUView1() {
        return (OtlMultiQuestionsUViewImpl)findViewObject("OtlMultiQuestionsUView1");
    }

    /**Container's getter for OtlQuestionsUView1
     */
    public OtlQuestionsUViewImpl getOtlQuestionsUView1() {
        return (OtlQuestionsUViewImpl)findViewObject("OtlQuestionsUView1");
    }

    /**Container's getter for OtlReportAnswerSetValuesUView1
     */
    public OtlReportAnswerSetValuesUViewImpl getOtlReportAnswerSetValuesUView1() {
        return (OtlReportAnswerSetValuesUViewImpl)findViewObject("OtlReportAnswerSetValuesUView1");
    }

    /**Container's getter for OtlReportAnswerSetsUView1
     */
    public OtlReportAnswerSetsUViewImpl getOtlReportAnswerSetsUView1() {
        return (OtlReportAnswerSetsUViewImpl)findViewObject("OtlReportAnswerSetsUView1");
    }

    /**Container's getter for OtlReportSortingCriteriaUView1
     */
    public OtlReportSortingCriteriaUViewImpl getOtlReportSortingCriteriaUView1() {
        return (OtlReportSortingCriteriaUViewImpl)findViewObject("OtlReportSortingCriteriaUView1");
    }

    /**Container's getter for OtlReportSourcesUView1
     */
    public OtlReportSourcesUViewImpl getOtlReportSourcesUView1() {
        return (OtlReportSourcesUViewImpl)findViewObject("OtlReportSourcesUView1");
    }

    /**Container's getter for OtlRolesUView1
     */
    public OtlRolesUViewImpl getOtlRolesUView1() {
        return (OtlRolesUViewImpl)findViewObject("OtlRolesUView1");
    }

    /**Container's getter for OtlSortingCriteriaValuesUView1
     */
    public OtlSortingCriteriaValuesUViewImpl getOtlSortingCriteriaValuesUView1() {
        return (OtlSortingCriteriaValuesUViewImpl)findViewObject("OtlSortingCriteriaValuesUView1");
    }

    /**Container's getter for OtlSortingCriteriaUView1
     */
    public OtlSortingCriteriaUViewImpl getOtlSortingCriteriaUView1() {
        return (OtlSortingCriteriaUViewImpl)findViewObject("OtlSortingCriteriaUView1");
    }

    /**Container's getter for OtlSourceAnswersUView1
     */
    public OtlSourceAnswersUViewImpl getOtlSourceAnswersUView1() {
        return (OtlSourceAnswersUViewImpl)findViewObject("OtlSourceAnswersUView1");
    }

    /**Container's getter for OtlSourceMultiAnswersUView1
     */
    public OtlSourceMultiAnswersUViewImpl getOtlSourceMultiAnswersUView1() {
        return (OtlSourceMultiAnswersUViewImpl)findViewObject("OtlSourceMultiAnswersUView1");
    }

    /**Container's getter for OtlSourceSortingCriteriaUView1
     */
    public OtlSourceSortingCriteriaUViewImpl getOtlSourceSortingCriteriaUView1() {
        return (OtlSourceSortingCriteriaUViewImpl)findViewObject("OtlSourceSortingCriteriaUView1");
    }

    /**Container's getter for OtlSourcesUView1
     */
    public OtlSourcesUViewImpl getOtlSourcesUView1() {
        return (OtlSourcesUViewImpl)findViewObject("OtlSourcesUView1");
    }

    /**Container's getter for OtlTallyRangesUView1
     */
    public OtlTallyRangesUViewImpl getOtlTallyRangesUView1() {
        return (OtlTallyRangesUViewImpl)findViewObject("OtlTallyRangesUView1");
    }

    /**Container's getter for OtlTimeZonesUView1
     */
    public OtlTimeZonesUViewImpl getOtlTimeZonesUView1() {
        return (OtlTimeZonesUViewImpl)findViewObject("OtlTimeZonesUView1");
    }

    /**Container's getter for OtrEmployeeInfoUView1
     */
    public OtrEmployeeInfoUViewImpl getOtrEmployeeInfoUView1() {
        return (OtrEmployeeInfoUViewImpl)findViewObject("OtrEmployeeInfoUView1");
    }

    /**Container's getter for PanPanelUView1
     */
    public PanPanelUViewImpl getPanPanelUView1() {
        return (PanPanelUViewImpl)findViewObject("PanPanelUView1");
    }

    /**Container's getter for RprtReportReporterXrefUView1
     */
    public RprtReportReporterXrefUViewImpl getRprtReportReporterXrefUView1() {
        return (RprtReportReporterXrefUViewImpl)findViewObject("RprtReportReporterXrefUView1");
    }

    /**Container's getter for RprtReportsUView1
     */
    public RprtReportsUViewImpl getRprtReportsUView1() {
        return (RprtReportsUViewImpl)findViewObject("RprtReportsUView1");
    }

    /**Container's getter for RptyReporterTypesUView1
     */
    public RptyReporterTypesUViewImpl getRptyReporterTypesUView1() {
        return (RptyReporterTypesUViewImpl)findViewObject("RptyReporterTypesUView1");
    }

    /**Container's getter for RtypReportTypesUView1
     */
    public RtypReportTypesUViewImpl getRtypReportTypesUView1() {
        return (RtypReportTypesUViewImpl)findViewObject("RtypReportTypesUView1");
    }

    /**Container's getter for CtryCountriesRView1
     */
    public CtryCountriesRViewImpl getCtryCountriesRView1() {
        return (CtryCountriesRViewImpl)findViewObject("CtryCountriesRView1");
    }

    /**Container's getter for EmplOtlEmployeesRView1
     */
    public EmplOtlEmployeesRViewImpl getEmplOtlEmployeesRView1() {
        return (EmplOtlEmployeesRViewImpl)findViewObject("EmplOtlEmployeesRView1");
    }

    /**Container's getter for FridFirmIndustriesRView1
     */
    public FridFirmIndustriesRViewImpl getFridFirmIndustriesRView1() {
        return (FridFirmIndustriesRViewImpl)findViewObject("FridFirmIndustriesRView1");
    }

    /**Container's getter for OtlAnswerSetsRView1
     */
    public OtlAnswerSetsRViewImpl getOtlAnswerSetsRView1() {
        return (OtlAnswerSetsRViewImpl)findViewObject("OtlAnswerSetsRView1");
    }

    /**Container's getter for OtlAnswerSetValuesRView1
     */
    public OtlAnswerSetValuesRViewImpl getOtlAnswerSetValuesRView1() {
        return (OtlAnswerSetValuesRViewImpl)findViewObject("OtlAnswerSetValuesRView1");
    }

    /**Container's getter for OtlEmplRolesRView1
     */
    public OtlEmplRolesRViewImpl getOtlEmplRolesRView1() {
        return (OtlEmplRolesRViewImpl)findViewObject("OtlEmplRolesRView1");
    }

    /**Container's getter for OtlFunctionsRView1
     */
    public OtlFunctionsRViewImpl getOtlFunctionsRView1() {
        return (OtlFunctionsRViewImpl)findViewObject("OtlFunctionsRView1");
    }

    /**Container's getter for OtlMultiQuestionsRView1
     */
    public OtlMultiQuestionsRViewImpl getOtlMultiQuestionsRView1() {
        return (OtlMultiQuestionsRViewImpl)findViewObject("OtlMultiQuestionsRView1");
    }

    /**Container's getter for OtlQuestionsRView1
     */
    public OtlQuestionsRViewImpl getOtlQuestionsRView1() {
        return (OtlQuestionsRViewImpl)findViewObject("OtlQuestionsRView1");
    }

    /**Container's getter for OtlReportAnswerSetsRView1
     */
    public OtlReportAnswerSetsRViewImpl getOtlReportAnswerSetsRView1() {
        return (OtlReportAnswerSetsRViewImpl)findViewObject("OtlReportAnswerSetsRView1");
    }

    /**Container's getter for OtlReportAnswerSetValuesRView1
     */
    public OtlReportAnswerSetValuesRViewImpl getOtlReportAnswerSetValuesRView1() {
        return (OtlReportAnswerSetValuesRViewImpl)findViewObject("OtlReportAnswerSetValuesRView1");
    }

    /**Container's getter for OtlReportSortingCriteriaRView1
     */
    public OtlReportSortingCriteriaRViewImpl getOtlReportSortingCriteriaRView1() {
        return (OtlReportSortingCriteriaRViewImpl)findViewObject("OtlReportSortingCriteriaRView1");
    }

    /**Container's getter for OtlReportSourcesRView1
     */
    public OtlReportSourcesRViewImpl getOtlReportSourcesRView1() {
        return (OtlReportSourcesRViewImpl)findViewObject("OtlReportSourcesRView1");
    }

    /**Container's getter for OtlRolesRView1
     */
    public OtlRolesRViewImpl getOtlRolesRView1() {
        return (OtlRolesRViewImpl)findViewObject("OtlRolesRView1");
    }

    /**Container's getter for OtlSortingCriteriaRView1
     */
    public OtlSortingCriteriaRViewImpl getOtlSortingCriteriaRView1() {
        return (OtlSortingCriteriaRViewImpl)findViewObject("OtlSortingCriteriaRView1");
    }

    /**Container's getter for OtlSortingCriteriaValuesRView1
     */
    public OtlSortingCriteriaValuesRViewImpl getOtlSortingCriteriaValuesRView1() {
        return (OtlSortingCriteriaValuesRViewImpl)findViewObject("OtlSortingCriteriaValuesRView1");
    }

    /**Container's getter for OtlSourcesRView1
     */
    public OtlSourcesRViewImpl getOtlSourcesRView1() {
        return (OtlSourcesRViewImpl)findViewObject("OtlSourcesRView1");
    }

    /**Container's getter for OtlSourceAnswersRView1
     */
    public OtlSourceAnswersRViewImpl getOtlSourceAnswersRView1() {
        return (OtlSourceAnswersRViewImpl)findViewObject("OtlSourceAnswersRView1");
    }

    /**Container's getter for OtlSourceMultiAnswersRView1
     */
    public OtlSourceMultiAnswersRViewImpl getOtlSourceMultiAnswersRView1() {
        return (OtlSourceMultiAnswersRViewImpl)findViewObject("OtlSourceMultiAnswersRView1");
    }

    /**Container's getter for OtlSourceSortingCriteriaRView1
     */
    public OtlSourceSortingCriteriaRViewImpl getOtlSourceSortingCriteriaRView1() {
        return (OtlSourceSortingCriteriaRViewImpl)findViewObject("OtlSourceSortingCriteriaRView1");
    }

    /**Container's getter for OtlTallyRangesRView1
     */
    public OtlTallyRangesRViewImpl getOtlTallyRangesRView1() {
        return (OtlTallyRangesRViewImpl)findViewObject("OtlTallyRangesRView1");
    }

    /**Container's getter for OtlTimeZonesRView1
     */
    public OtlTimeZonesRViewImpl getOtlTimeZonesRView1() {
        return (OtlTimeZonesRViewImpl)findViewObject("OtlTimeZonesRView1");
    }

    /**Container's getter for OtrEmployeeInfoRView1
     */
    public OtrEmployeeInfoRViewImpl getOtrEmployeeInfoRView1() {
        return (OtrEmployeeInfoRViewImpl)findViewObject("OtrEmployeeInfoRView1");
    }

    /**Container's getter for PanPanelRView1
     */
    public PanPanelRViewImpl getPanPanelRView1() {
        return (PanPanelRViewImpl)findViewObject("PanPanelRView1");
    }

    /**Container's getter for RprtReportsRView1
     */
    public RprtReportsRViewImpl getRprtReportsRView1() {
        return (RprtReportsRViewImpl)findViewObject("RprtReportsRView1");
    }

    /**Container's getter for RprtReportReporterXrefRView1
     */
    public RprtReportReporterXrefRViewImpl getRprtReportReporterXrefRView1() {
        return (RprtReportReporterXrefRViewImpl)findViewObject("RprtReportReporterXrefRView1");
    }

    /**Container's getter for RptyReporterTypesRView1
     */
    public RptyReporterTypesRViewImpl getRptyReporterTypesRView1() {
        return (RptyReporterTypesRViewImpl)findViewObject("RptyReporterTypesRView1");
    }

    /**Container's getter for RtypReportTypesRView1
     */
    public RtypReportTypesRViewImpl getRtypReportTypesRView1() {
        return (RtypReportTypesRViewImpl)findViewObject("RtypReportTypesRView1");
    }

    /**Container's getter for OtlAnswerSetsUView2
     */
    public OtlAnswerSetsUViewImpl getOtlAnswerSetsUView2() {
        return (OtlAnswerSetsUViewImpl)findViewObject("OtlAnswerSetsUView2");
    }

    /**Container's getter for OtlAnswerSetValuesUView2
     */
    public OtlAnswerSetValuesUViewImpl getOtlAnswerSetValuesUView2() {
        return (OtlAnswerSetValuesUViewImpl)findViewObject("OtlAnswerSetValuesUView2");
    }

    /**Container's getter for OtlEmplRolesUView2
     */
    public OtlEmplRolesUViewImpl getOtlEmplRolesUView2() {
        return (OtlEmplRolesUViewImpl)findViewObject("OtlEmplRolesUView2");
    }

    /**Container's getter for OtlReportAnswerSetsUView2
     */
    public OtlReportAnswerSetsUViewImpl getOtlReportAnswerSetsUView2() {
        return (OtlReportAnswerSetsUViewImpl)findViewObject("OtlReportAnswerSetsUView2");
    }

    /**Container's getter for OtlReportAnswerSetsUView3
     */
    public OtlReportAnswerSetsUViewImpl getOtlReportAnswerSetsUView3() {
        return (OtlReportAnswerSetsUViewImpl)findViewObject("OtlReportAnswerSetsUView3");
    }

    /**Container's getter for OtlReportAnswerSetValuesUView2
     */
    public OtlReportAnswerSetValuesUViewImpl getOtlReportAnswerSetValuesUView2() {
        return (OtlReportAnswerSetValuesUViewImpl)findViewObject("OtlReportAnswerSetValuesUView2");
    }

    /**Container's getter for OtlReportAnswerSetValuesUView3
     */
    public OtlReportAnswerSetValuesUViewImpl getOtlReportAnswerSetValuesUView3() {
        return (OtlReportAnswerSetValuesUViewImpl)findViewObject("OtlReportAnswerSetValuesUView3");
    }

    /**Container's getter for OtlEmplRolesUView3
     */
    public OtlEmplRolesUViewImpl getOtlEmplRolesUView3() {
        return (OtlEmplRolesUViewImpl)findViewObject("OtlEmplRolesUView3");
    }

    /**Container's getter for OtlReportSortingCriteriaUView2
     */
    public OtlReportSortingCriteriaUViewImpl getOtlReportSortingCriteriaUView2() {
        return (OtlReportSortingCriteriaUViewImpl)findViewObject("OtlReportSortingCriteriaUView2");
    }

    /**Container's getter for OtlSortingCriteriaUView2
     */
    public OtlSortingCriteriaUViewImpl getOtlSortingCriteriaUView2() {
        return (OtlSortingCriteriaUViewImpl)findViewObject("OtlSortingCriteriaUView2");
    }

    /**Container's getter for OtlSortingCriteriaValuesUView2
     */
    public OtlSortingCriteriaValuesUViewImpl getOtlSortingCriteriaValuesUView2() {
        return (OtlSortingCriteriaValuesUViewImpl)findViewObject("OtlSortingCriteriaValuesUView2");
    }

    /**Container's getter for OtlSortingCriteriaValuesUView3
     */
    public OtlSortingCriteriaValuesUViewImpl getOtlSortingCriteriaValuesUView3() {
        return (OtlSortingCriteriaValuesUViewImpl)findViewObject("OtlSortingCriteriaValuesUView3");
    }

    /**Container's getter for OtlReportSourcesUView2
     */
    public OtlReportSourcesUViewImpl getOtlReportSourcesUView2() {
        return (OtlReportSourcesUViewImpl)findViewObject("OtlReportSourcesUView2");
    }

    /**Container's getter for OtlSourcesUView2
     */
    public OtlSourcesUViewImpl getOtlSourcesUView2() {
        return (OtlSourcesUViewImpl)findViewObject("OtlSourcesUView2");
    }

    /**Container's getter for OtlSourceAnswersUView2
     */
    public OtlSourceAnswersUViewImpl getOtlSourceAnswersUView2() {
        return (OtlSourceAnswersUViewImpl)findViewObject("OtlSourceAnswersUView2");
    }

    /**Container's getter for OtlSourceAnswersUView3
     */
    public OtlSourceAnswersUViewImpl getOtlSourceAnswersUView3() {
        return (OtlSourceAnswersUViewImpl)findViewObject("OtlSourceAnswersUView3");
    }

    /**Container's getter for OtlSourceAnswersUView4
     */
    public OtlSourceAnswersUViewImpl getOtlSourceAnswersUView4() {
        return (OtlSourceAnswersUViewImpl)findViewObject("OtlSourceAnswersUView4");
    }

    /**Container's getter for OtlSourceAnswersUView5
     */
    public OtlSourceAnswersUViewImpl getOtlSourceAnswersUView5() {
        return (OtlSourceAnswersUViewImpl)findViewObject("OtlSourceAnswersUView5");
    }

    /**Container's getter for OtlSourceMultiAnswersUView2
     */
    public OtlSourceMultiAnswersUViewImpl getOtlSourceMultiAnswersUView2() {
        return (OtlSourceMultiAnswersUViewImpl)findViewObject("OtlSourceMultiAnswersUView2");
    }

    /**Container's getter for OtlSourceMultiAnswersUView3
     */
    public OtlSourceMultiAnswersUViewImpl getOtlSourceMultiAnswersUView3() {
        return (OtlSourceMultiAnswersUViewImpl)findViewObject("OtlSourceMultiAnswersUView3");
    }

    /**Container's getter for OtlSourceMultiAnswersUView4
     */
    public OtlSourceMultiAnswersUViewImpl getOtlSourceMultiAnswersUView4() {
        return (OtlSourceMultiAnswersUViewImpl)findViewObject("OtlSourceMultiAnswersUView4");
    }

    /**Container's getter for OtlSourceSortingCriteriaUView2
     */
    public OtlSourceSortingCriteriaUViewImpl getOtlSourceSortingCriteriaUView2() {
        return (OtlSourceSortingCriteriaUViewImpl)findViewObject("OtlSourceSortingCriteriaUView2");
    }

    /**Container's getter for OtlSourceSortingCriteriaUView3
     */
    public OtlSourceSortingCriteriaUViewImpl getOtlSourceSortingCriteriaUView3() {
        return (OtlSourceSortingCriteriaUViewImpl)findViewObject("OtlSourceSortingCriteriaUView3");
    }

    /**Container's getter for OtlSourcesUView3
     */
    public OtlSourcesUViewImpl getOtlSourcesUView3() {
        return (OtlSourcesUViewImpl)findViewObject("OtlSourcesUView3");
    }

    /**Container's getter for PanPanelUView2
     */
    public PanPanelUViewImpl getPanPanelUView2() {
        return (PanPanelUViewImpl)findViewObject("PanPanelUView2");
    }

    /**Container's getter for PanPanelUView3
     */
    public PanPanelUViewImpl getPanPanelUView3() {
        return (PanPanelUViewImpl)findViewObject("PanPanelUView3");
    }

    /**Container's getter for OtlReportSortingCriteriaUView3
     */
    public OtlReportSortingCriteriaUViewImpl getOtlReportSortingCriteriaUView3() {
        return (OtlReportSortingCriteriaUViewImpl)findViewObject("OtlReportSortingCriteriaUView3");
    }

    /**Container's getter for OtlReportSourcesUView3
     */
    public OtlReportSourcesUViewImpl getOtlReportSourcesUView3() {
        return (OtlReportSourcesUViewImpl)findViewObject("OtlReportSourcesUView3");
    }

    /**Container's getter for OtlQuestionsUView2
     */
    public OtlQuestionsUViewImpl getOtlQuestionsUView2() {
        return (OtlQuestionsUViewImpl)findViewObject("OtlQuestionsUView2");
    }

    /**Container's getter for OtlReportAnswerSetsUView4
     */
    public OtlReportAnswerSetsUViewImpl getOtlReportAnswerSetsUView4() {
        return (OtlReportAnswerSetsUViewImpl)findViewObject("OtlReportAnswerSetsUView4");
    }

    /**Container's getter for RprtReportsUView2
     */
    public RprtReportsUViewImpl getRprtReportsUView2() {
        return (RprtReportsUViewImpl)findViewObject("RprtReportsUView2");
    }

    /**Container's getter for RprtReportsUView3
     */
    public RprtReportsUViewImpl getRprtReportsUView3() {
        return (RprtReportsUViewImpl)findViewObject("RprtReportsUView3");
    }

    /**Container's getter for RprtReportsUView4
     */
    public RprtReportsUViewImpl getRprtReportsUView4() {
        return (RprtReportsUViewImpl)findViewObject("RprtReportsUView4");
    }

    /**Container's getter for RprtReportsUView5
     */
    public RprtReportsUViewImpl getRprtReportsUView5() {
        return (RprtReportsUViewImpl)findViewObject("RprtReportsUView5");
    }

    /**Container's getter for RprtReportsUView6
     */
    public RprtReportsUViewImpl getRprtReportsUView6() {
        return (RprtReportsUViewImpl)findViewObject("RprtReportsUView6");
    }

    /**Container's getter for OtlSourcesRView2
     */
    public OtlSourcesRViewImpl getOtlSourcesRView2() {
        return (OtlSourcesRViewImpl)findViewObject("OtlSourcesRView2");
    }

    /**Container's getter for OtlEmplRolesRView2
     */
    public OtlEmplRolesRViewImpl getOtlEmplRolesRView2() {
        return (OtlEmplRolesRViewImpl)findViewObject("OtlEmplRolesRView2");
    }

    /**Container's getter for PanPanelRView2
     */
    public PanPanelRViewImpl getPanPanelRView2() {
        return (PanPanelRViewImpl)findViewObject("PanPanelRView2");
    }

    /**Container's getter for RprtReportsRView2
     */
    public RprtReportsRViewImpl getRprtReportsRView2() {
        return (RprtReportsRViewImpl)findViewObject("RprtReportsRView2");
    }

    /**Container's getter for RprtReportsRView3
     */
    public RprtReportsRViewImpl getRprtReportsRView3() {
        return (RprtReportsRViewImpl)findViewObject("RprtReportsRView3");
    }

    /**Container's getter for OtlAnswerSetsRView2
     */
    public OtlAnswerSetsRViewImpl getOtlAnswerSetsRView2() {
        return (OtlAnswerSetsRViewImpl)findViewObject("OtlAnswerSetsRView2");
    }

    /**Container's getter for OtlReportAnswerSetsRView2
     */
    public OtlReportAnswerSetsRViewImpl getOtlReportAnswerSetsRView2() {
        return (OtlReportAnswerSetsRViewImpl)findViewObject("OtlReportAnswerSetsRView2");
    }

    /**Container's getter for OtlSortingCriteriaRView2
     */
    public OtlSortingCriteriaRViewImpl getOtlSortingCriteriaRView2() {
        return (OtlSortingCriteriaRViewImpl)findViewObject("OtlSortingCriteriaRView2");
    }

    /**Container's getter for PanPanelRView3
     */
    public PanPanelRViewImpl getPanPanelRView3() {
        return (PanPanelRViewImpl)findViewObject("PanPanelRView3");
    }

    /**Container's getter for RprtReportsRView4
     */
    public RprtReportsRViewImpl getRprtReportsRView4() {
        return (RprtReportsRViewImpl)findViewObject("RprtReportsRView4");
    }

    /**Container's getter for OtlAnswerSetValuesRView2
     */
    public OtlAnswerSetValuesRViewImpl getOtlAnswerSetValuesRView2() {
        return (OtlAnswerSetValuesRViewImpl)findViewObject("OtlAnswerSetValuesRView2");
    }

    /**Container's getter for OtlReportAnswerSetsRView3
     */
    public OtlReportAnswerSetsRViewImpl getOtlReportAnswerSetsRView3() {
        return (OtlReportAnswerSetsRViewImpl)findViewObject("OtlReportAnswerSetsRView3");
    }

    /**Container's getter for OtlReportAnswerSetValuesRView2
     */
    public OtlReportAnswerSetValuesRViewImpl getOtlReportAnswerSetValuesRView2() {
        return (OtlReportAnswerSetValuesRViewImpl)findViewObject("OtlReportAnswerSetValuesRView2");
    }

    /**Container's getter for OtlSourceAnswersRView2
     */
    public OtlSourceAnswersRViewImpl getOtlSourceAnswersRView2() {
        return (OtlSourceAnswersRViewImpl)findViewObject("OtlSourceAnswersRView2");
    }

    /**Container's getter for OtlSourceMultiAnswersRView2
     */
    public OtlSourceMultiAnswersRViewImpl getOtlSourceMultiAnswersRView2() {
        return (OtlSourceMultiAnswersRViewImpl)findViewObject("OtlSourceMultiAnswersRView2");
    }

    /**Container's getter for OtlSourceAnswersRView3
     */
    public OtlSourceAnswersRViewImpl getOtlSourceAnswersRView3() {
        return (OtlSourceAnswersRViewImpl)findViewObject("OtlSourceAnswersRView3");
    }

    /**Container's getter for OtlReportAnswerSetValuesRView3
     */
    public OtlReportAnswerSetValuesRViewImpl getOtlReportAnswerSetValuesRView3() {
        return (OtlReportAnswerSetValuesRViewImpl)findViewObject("OtlReportAnswerSetValuesRView3");
    }

    /**Container's getter for OtlSourceAnswersRView4
     */
    public OtlSourceAnswersRViewImpl getOtlSourceAnswersRView4() {
        return (OtlSourceAnswersRViewImpl)findViewObject("OtlSourceAnswersRView4");
    }

    /**Container's getter for OtlSourceMultiAnswersRView3
     */
    public OtlSourceMultiAnswersRViewImpl getOtlSourceMultiAnswersRView3() {
        return (OtlSourceMultiAnswersRViewImpl)findViewObject("OtlSourceMultiAnswersRView3");
    }

    /**Container's getter for OtlSourceAnswersRView5
     */
    public OtlSourceAnswersRViewImpl getOtlSourceAnswersRView5() {
        return (OtlSourceAnswersRViewImpl)findViewObject("OtlSourceAnswersRView5");
    }

    /**Container's getter for OtlSourceSortingCriteriaRView2
     */
    public OtlSourceSortingCriteriaRViewImpl getOtlSourceSortingCriteriaRView2() {
        return (OtlSourceSortingCriteriaRViewImpl)findViewObject("OtlSourceSortingCriteriaRView2");
    }

    /**Container's getter for OtlEmplRolesRView3
     */
    public OtlEmplRolesRViewImpl getOtlEmplRolesRView3() {
        return (OtlEmplRolesRViewImpl)findViewObject("OtlEmplRolesRView3");
    }

    /**Container's getter for OtlReportSortingCriteriaRView2
     */
    public OtlReportSortingCriteriaRViewImpl getOtlReportSortingCriteriaRView2() {
        return (OtlReportSortingCriteriaRViewImpl)findViewObject("OtlReportSortingCriteriaRView2");
    }

    /**Container's getter for OtlSortingCriteriaValuesRView2
     */
    public OtlSortingCriteriaValuesRViewImpl getOtlSortingCriteriaValuesRView2() {
        return (OtlSortingCriteriaValuesRViewImpl)findViewObject("OtlSortingCriteriaValuesRView2");
    }

    /**Container's getter for OtlSortingCriteriaValuesRView3
     */
    public OtlSortingCriteriaValuesRViewImpl getOtlSortingCriteriaValuesRView3() {
        return (OtlSortingCriteriaValuesRViewImpl)findViewObject("OtlSortingCriteriaValuesRView3");
    }

    /**Container's getter for OtlSourceSortingCriteriaRView3
     */
    public OtlSourceSortingCriteriaRViewImpl getOtlSourceSortingCriteriaRView3() {
        return (OtlSourceSortingCriteriaRViewImpl)findViewObject("OtlSourceSortingCriteriaRView3");
    }

    /**Container's getter for OtlReportSourcesRView2
     */
    public OtlReportSourcesRViewImpl getOtlReportSourcesRView2() {
        return (OtlReportSourcesRViewImpl)findViewObject("OtlReportSourcesRView2");
    }

    /**Container's getter for OtlSourceMultiAnswersRView4
     */
    public OtlSourceMultiAnswersRViewImpl getOtlSourceMultiAnswersRView4() {
        return (OtlSourceMultiAnswersRViewImpl)findViewObject("OtlSourceMultiAnswersRView4");
    }

    /**Container's getter for OtlSourcesRView3
     */
    public OtlSourcesRViewImpl getOtlSourcesRView3() {
        return (OtlSourcesRViewImpl)findViewObject("OtlSourcesRView3");
    }

    /**Container's getter for RprtReportsRView5
     */
    public RprtReportsRViewImpl getRprtReportsRView5() {
        return (RprtReportsRViewImpl)findViewObject("RprtReportsRView5");
    }

    /**Container's getter for OtlQuestionsRView2
     */
    public OtlQuestionsRViewImpl getOtlQuestionsRView2() {
        return (OtlQuestionsRViewImpl)findViewObject("OtlQuestionsRView2");
    }

    /**Container's getter for OtlReportAnswerSetsRView4
     */
    public OtlReportAnswerSetsRViewImpl getOtlReportAnswerSetsRView4() {
        return (OtlReportAnswerSetsRViewImpl)findViewObject("OtlReportAnswerSetsRView4");
    }

    /**Container's getter for OtlReportSortingCriteriaRView3
     */
    public OtlReportSortingCriteriaRViewImpl getOtlReportSortingCriteriaRView3() {
        return (OtlReportSortingCriteriaRViewImpl)findViewObject("OtlReportSortingCriteriaRView3");
    }

    /**Container's getter for OtlReportSourcesRView3
     */
    public OtlReportSourcesRViewImpl getOtlReportSourcesRView3() {
        return (OtlReportSourcesRViewImpl)findViewObject("OtlReportSourcesRView3");
    }

    /**Container's getter for RprtReportsRView6
     */
    public RprtReportsRViewImpl getRprtReportsRView6() {
        return (RprtReportsRViewImpl)findViewObject("RprtReportsRView6");
    }

    /**Container's getter for AnsFridFkLink1
     */
    public ViewLinkImpl getAnsFridFkLink1() {
        return (ViewLinkImpl)findViewLink("AnsFridFkLink1");
    }

    /**Container's getter for AsvAnsFkLink1
     */
    public ViewLinkImpl getAsvAnsFkLink1() {
        return (ViewLinkImpl)findViewLink("AsvAnsFkLink1");
    }

    /**Container's getter for OtlEmrEmplFkLink1
     */
    public ViewLinkImpl getOtlEmrEmplFkLink1() {
        return (ViewLinkImpl)findViewLink("OtlEmrEmplFkLink1");
    }

    /**Container's getter for OtlRasFridFkLink1
     */
    public ViewLinkImpl getOtlRasFridFkLink1() {
        return (ViewLinkImpl)findViewLink("OtlRasFridFkLink1");
    }

    /**Container's getter for RasAnsFkLink1
     */
    public ViewLinkImpl getRasAnsFkLink1() {
        return (ViewLinkImpl)findViewLink("RasAnsFkLink1");
    }

    /**Container's getter for RavAsvFkLink1
     */
    public ViewLinkImpl getRavAsvFkLink1() {
        return (ViewLinkImpl)findViewLink("RavAsvFkLink1");
    }

    /**Container's getter for RavRasFkLink1
     */
    public ViewLinkImpl getRavRasFkLink1() {
        return (ViewLinkImpl)findViewLink("RavRasFkLink1");
    }

    /**Container's getter for OtlEmrRolFkLink1
     */
    public ViewLinkImpl getOtlEmrRolFkLink1() {
        return (ViewLinkImpl)findViewLink("OtlEmrRolFkLink1");
    }

    /**Container's getter for OtlRsoSrtFkLink1
     */
    public ViewLinkImpl getOtlRsoSrtFkLink1() {
        return (ViewLinkImpl)findViewLink("OtlRsoSrtFkLink1");
    }

    /**Container's getter for OtlSrtFridFkLink1
     */
    public ViewLinkImpl getOtlSrtFridFkLink1() {
        return (ViewLinkImpl)findViewLink("OtlSrtFridFkLink1");
    }

    /**Container's getter for OtlScvScvFkLink1
     */
    public ViewLinkImpl getOtlScvScvFkLink1() {
        return (ViewLinkImpl)findViewLink("OtlScvScvFkLink1");
    }

    /**Container's getter for OtlScvSrtFkLink1
     */
    public ViewLinkImpl getOtlScvSrtFkLink1() {
        return (ViewLinkImpl)findViewLink("OtlScvSrtFkLink1");
    }

    /**Container's getter for RpsSrcFkLink1
     */
    public ViewLinkImpl getRpsSrcFkLink1() {
        return (ViewLinkImpl)findViewLink("RpsSrcFkLink1");
    }

    /**Container's getter for OtlSrcCtryFkLink1
     */
    public ViewLinkImpl getOtlSrcCtryFkLink1() {
        return (ViewLinkImpl)findViewLink("OtlSrcCtryFkLink1");
    }

    /**Container's getter for SraAsvFkLink1
     */
    public ViewLinkImpl getSraAsvFkLink1() {
        return (ViewLinkImpl)findViewLink("SraAsvFkLink1");
    }

    /**Container's getter for SraQstFkLink1
     */
    public ViewLinkImpl getSraQstFkLink1() {
        return (ViewLinkImpl)findViewLink("SraQstFkLink1");
    }

    /**Container's getter for SraRavFkLink1
     */
    public ViewLinkImpl getSraRavFkLink1() {
        return (ViewLinkImpl)findViewLink("SraRavFkLink1");
    }

    /**Container's getter for SraRpsFkLink1
     */
    public ViewLinkImpl getSraRpsFkLink1() {
        return (ViewLinkImpl)findViewLink("SraRpsFkLink1");
    }

    /**Container's getter for OtlSmaAsvFkLink1
     */
    public ViewLinkImpl getOtlSmaAsvFkLink1() {
        return (ViewLinkImpl)findViewLink("OtlSmaAsvFkLink1");
    }

    /**Container's getter for OtlSmaRavFkLink1
     */
    public ViewLinkImpl getOtlSmaRavFkLink1() {
        return (ViewLinkImpl)findViewLink("OtlSmaRavFkLink1");
    }

    /**Container's getter for OtlSmaSraFkLink1
     */
    public ViewLinkImpl getOtlSmaSraFkLink1() {
        return (ViewLinkImpl)findViewLink("OtlSmaSraFkLink1");
    }

    /**Container's getter for OtlSscRpsFkLink1
     */
    public ViewLinkImpl getOtlSscRpsFkLink1() {
        return (ViewLinkImpl)findViewLink("OtlSscRpsFkLink1");
    }

    /**Container's getter for OtlSscScvFkLink1
     */
    public ViewLinkImpl getOtlSscScvFkLink1() {
        return (ViewLinkImpl)findViewLink("OtlSscScvFkLink1");
    }

    /**Container's getter for OtlSrcTmzFkLink1
     */
    public ViewLinkImpl getOtlSrcTmzFkLink1() {
        return (ViewLinkImpl)findViewLink("OtlSrcTmzFkLink1");
    }

    /**Container's getter for PanEmplFkLink1
     */
    public ViewLinkImpl getPanEmplFkLink1() {
        return (ViewLinkImpl)findViewLink("PanEmplFkLink1");
    }

    /**Container's getter for PanFridFkLink1
     */
    public ViewLinkImpl getPanFridFkLink1() {
        return (ViewLinkImpl)findViewLink("PanFridFkLink1");
    }

    /**Container's getter for OtlRsoRprtFkLink1
     */
    public ViewLinkImpl getOtlRsoRprtFkLink1() {
        return (ViewLinkImpl)findViewLink("OtlRsoRprtFkLink1");
    }

    /**Container's getter for RpsRprtFkLink1
     */
    public ViewLinkImpl getRpsRprtFkLink1() {
        return (ViewLinkImpl)findViewLink("RpsRprtFkLink1");
    }

    /**Container's getter for OtlqRprtFkLink1
     */
    public ViewLinkImpl getOtlqRprtFkLink1() {
        return (ViewLinkImpl)findViewLink("OtlqRprtFkLink1");
    }

    /**Container's getter for OtlRasRprtFkLink1
     */
    public ViewLinkImpl getOtlRasRprtFkLink1() {
        return (ViewLinkImpl)findViewLink("OtlRasRprtFkLink1");
    }

    /**Container's getter for RprtEmplEdtrFkLink1
     */
    public ViewLinkImpl getRprtEmplEdtrFkLink1() {
        return (ViewLinkImpl)findViewLink("RprtEmplEdtrFkLink1");
    }

    /**Container's getter for RprtEmplRptrFkLink1
     */
    public ViewLinkImpl getRprtEmplRptrFkLink1() {
        return (ViewLinkImpl)findViewLink("RprtEmplRptrFkLink1");
    }

    /**Container's getter for RprtFridFiFkLink1
     */
    public ViewLinkImpl getRprtFridFiFkLink1() {
        return (ViewLinkImpl)findViewLink("RprtFridFiFkLink1");
    }

    /**Container's getter for RprtPanFkLink1
     */
    public ViewLinkImpl getRprtPanFkLink1() {
        return (ViewLinkImpl)findViewLink("RprtPanFkLink1");
    }

    /**Container's getter for RprtRtypFkLink1
     */
    public ViewLinkImpl getRprtRtypFkLink1() {
        return (ViewLinkImpl)findViewLink("RprtRtypFkLink1");
    }

    /**Container's getter for OtlSrcCtryFkLink2
     */
    public ViewLinkImpl getOtlSrcCtryFkLink2() {
        return (ViewLinkImpl)findViewLink("OtlSrcCtryFkLink2");
    }

    /**Container's getter for OtlEmrEmplFkLink2
     */
    public ViewLinkImpl getOtlEmrEmplFkLink2() {
        return (ViewLinkImpl)findViewLink("OtlEmrEmplFkLink2");
    }

    /**Container's getter for PanEmplFkLink2
     */
    public ViewLinkImpl getPanEmplFkLink2() {
        return (ViewLinkImpl)findViewLink("PanEmplFkLink2");
    }

    /**Container's getter for RprtEmplEdtrFkLink2
     */
    public ViewLinkImpl getRprtEmplEdtrFkLink2() {
        return (ViewLinkImpl)findViewLink("RprtEmplEdtrFkLink2");
    }

    /**Container's getter for RprtEmplRptrFkLink2
     */
    public ViewLinkImpl getRprtEmplRptrFkLink2() {
        return (ViewLinkImpl)findViewLink("RprtEmplRptrFkLink2");
    }

    /**Container's getter for AnsFridFkLink2
     */
    public ViewLinkImpl getAnsFridFkLink2() {
        return (ViewLinkImpl)findViewLink("AnsFridFkLink2");
    }

    /**Container's getter for OtlRasFridFkLink2
     */
    public ViewLinkImpl getOtlRasFridFkLink2() {
        return (ViewLinkImpl)findViewLink("OtlRasFridFkLink2");
    }

    /**Container's getter for OtlSrtFridFkLink2
     */
    public ViewLinkImpl getOtlSrtFridFkLink2() {
        return (ViewLinkImpl)findViewLink("OtlSrtFridFkLink2");
    }

    /**Container's getter for PanFridFkLink2
     */
    public ViewLinkImpl getPanFridFkLink2() {
        return (ViewLinkImpl)findViewLink("PanFridFkLink2");
    }

    /**Container's getter for RprtFridFiFkLink2
     */
    public ViewLinkImpl getRprtFridFiFkLink2() {
        return (ViewLinkImpl)findViewLink("RprtFridFiFkLink2");
    }

    /**Container's getter for AsvAnsFkLink2
     */
    public ViewLinkImpl getAsvAnsFkLink2() {
        return (ViewLinkImpl)findViewLink("AsvAnsFkLink2");
    }

    /**Container's getter for RasAnsFkLink2
     */
    public ViewLinkImpl getRasAnsFkLink2() {
        return (ViewLinkImpl)findViewLink("RasAnsFkLink2");
    }

    /**Container's getter for RavAsvFkLink2
     */
    public ViewLinkImpl getRavAsvFkLink2() {
        return (ViewLinkImpl)findViewLink("RavAsvFkLink2");
    }

    /**Container's getter for SraAsvFkLink2
     */
    public ViewLinkImpl getSraAsvFkLink2() {
        return (ViewLinkImpl)findViewLink("SraAsvFkLink2");
    }

    /**Container's getter for OtlSmaAsvFkLink2
     */
    public ViewLinkImpl getOtlSmaAsvFkLink2() {
        return (ViewLinkImpl)findViewLink("OtlSmaAsvFkLink2");
    }

    /**Container's getter for SraQstFkLink2
     */
    public ViewLinkImpl getSraQstFkLink2() {
        return (ViewLinkImpl)findViewLink("SraQstFkLink2");
    }

    /**Container's getter for RavRasFkLink2
     */
    public ViewLinkImpl getRavRasFkLink2() {
        return (ViewLinkImpl)findViewLink("RavRasFkLink2");
    }

    /**Container's getter for SraRavFkLink2
     */
    public ViewLinkImpl getSraRavFkLink2() {
        return (ViewLinkImpl)findViewLink("SraRavFkLink2");
    }

    /**Container's getter for OtlSmaRavFkLink2
     */
    public ViewLinkImpl getOtlSmaRavFkLink2() {
        return (ViewLinkImpl)findViewLink("OtlSmaRavFkLink2");
    }

    /**Container's getter for SraRpsFkLink2
     */
    public ViewLinkImpl getSraRpsFkLink2() {
        return (ViewLinkImpl)findViewLink("SraRpsFkLink2");
    }

    /**Container's getter for OtlSscRpsFkLink2
     */
    public ViewLinkImpl getOtlSscRpsFkLink2() {
        return (ViewLinkImpl)findViewLink("OtlSscRpsFkLink2");
    }

    /**Container's getter for OtlEmrRolFkLink2
     */
    public ViewLinkImpl getOtlEmrRolFkLink2() {
        return (ViewLinkImpl)findViewLink("OtlEmrRolFkLink2");
    }

    /**Container's getter for OtlRsoSrtFkLink2
     */
    public ViewLinkImpl getOtlRsoSrtFkLink2() {
        return (ViewLinkImpl)findViewLink("OtlRsoSrtFkLink2");
    }

    /**Container's getter for OtlScvSrtFkLink2
     */
    public ViewLinkImpl getOtlScvSrtFkLink2() {
        return (ViewLinkImpl)findViewLink("OtlScvSrtFkLink2");
    }

    /**Container's getter for OtlScvScvFkLink2
     */
    public ViewLinkImpl getOtlScvScvFkLink2() {
        return (ViewLinkImpl)findViewLink("OtlScvScvFkLink2");
    }

    /**Container's getter for OtlSscScvFkLink2
     */
    public ViewLinkImpl getOtlSscScvFkLink2() {
        return (ViewLinkImpl)findViewLink("OtlSscScvFkLink2");
    }

    /**Container's getter for RpsSrcFkLink2
     */
    public ViewLinkImpl getRpsSrcFkLink2() {
        return (ViewLinkImpl)findViewLink("RpsSrcFkLink2");
    }

    /**Container's getter for OtlSmaSraFkLink2
     */
    public ViewLinkImpl getOtlSmaSraFkLink2() {
        return (ViewLinkImpl)findViewLink("OtlSmaSraFkLink2");
    }

    /**Container's getter for OtlSrcTmzFkLink2
     */
    public ViewLinkImpl getOtlSrcTmzFkLink2() {
        return (ViewLinkImpl)findViewLink("OtlSrcTmzFkLink2");
    }

    /**Container's getter for RprtPanFkLink2
     */
    public ViewLinkImpl getRprtPanFkLink2() {
        return (ViewLinkImpl)findViewLink("RprtPanFkLink2");
    }

    /**Container's getter for OtlqRprtFkLink2
     */
    public ViewLinkImpl getOtlqRprtFkLink2() {
        return (ViewLinkImpl)findViewLink("OtlqRprtFkLink2");
    }

    /**Container's getter for OtlRasRprtFkLink2
     */
    public ViewLinkImpl getOtlRasRprtFkLink2() {
        return (ViewLinkImpl)findViewLink("OtlRasRprtFkLink2");
    }

    /**Container's getter for OtlRsoRprtFkLink2
     */
    public ViewLinkImpl getOtlRsoRprtFkLink2() {
        return (ViewLinkImpl)findViewLink("OtlRsoRprtFkLink2");
    }

    /**Container's getter for RpsRprtFkLink2
     */
    public ViewLinkImpl getRpsRprtFkLink2() {
        return (ViewLinkImpl)findViewLink("RpsRprtFkLink2");
    }

    /**Container's getter for RprtRtypFkLink2
     */
    public ViewLinkImpl getRprtRtypFkLink2() {
        return (ViewLinkImpl)findViewLink("RprtRtypFkLink2");
    }

    /**Sample main for debugging Business Components code using the tester.
     */
    public static void main(String[] args) {
        launchTester("com.bawaweb.appmodule", /* package name */
      "PlatformAppModuleLocal" /* Configuration Name */);
    }


    /**Container's getter for EmployeeInfoView
     */
    public EmployeeInfoImpl getEmployeeInfoView() {
        return (EmployeeInfoImpl)findViewObject("EmployeeInfoView");
    }

    /**Container's getter for MultiAnswerSetsView
     */
    public MultiAnswerSetsImpl getMultiAnswerSetsView() {
        return (MultiAnswerSetsImpl)findViewObject("MultiAnswerSetsView");
    }

    /**Container's getter for MultiQuestionsListView
     */
    public MultiQuestionsListImpl getMultiQuestionsListView() {
        return (MultiQuestionsListImpl)findViewObject("MultiQuestionsListView");
    }


    /**Container's getter for SingleAnswerSetsView
     */
    public SingleAnswerSetsImpl getSingleAnswerSetsView() {
        return (SingleAnswerSetsImpl)findViewObject("SingleAnswerSetsView");
    }

    /**Container's getter for SortCriteriaSetsView
     */
    public SortCriteriaSetsImpl getSortCriteriaSetsView() {
        return (SortCriteriaSetsImpl)findViewObject("SortCriteriaSetsView");
    }


    /**Container's getter for SourceMultiAnswerSetsView
     */
    public SourceMultiAnswerSetsImpl getSourceMultiAnswerSetsView() {
        return (SourceMultiAnswerSetsImpl)findViewObject("SourceMultiAnswerSetsView");
    }

    /**Container's getter for SourcesSortingCriteriaSetsView
     */
    public SourcesSortingCriteriaSetsImpl getSourcesSortingCriteriaSetsView() {
        return (SourcesSortingCriteriaSetsImpl)findViewObject("SourcesSortingCriteriaSetsView");
    }

    /**Container's getter for RoleScopeView
     */
    public RoleScopeImpl getRoleScopeView() {
        return (RoleScopeImpl)findViewObject("RoleScopeView");
    }

    /**Container's getter for TableLocksInfo
     */
    public TableLocksInfoImpl getTableLocksInfo() {
        return (TableLocksInfoImpl)findViewObject("TableLocksInfo");
    }

    /**Container's getter for DBInstance
     */
    public DBInstanceImpl getDBInstance() {
        return (DBInstanceImpl)findViewObject("DBInstance");
    }

    /**Container's getter for SourceMultiAnswerSets
     */
    public SourceMultiAnswerSetsImpl getSourceMultiAnswerSets() {
        return (SourceMultiAnswerSetsImpl)findViewObject("SourceMultiAnswerSets");
    }


    /**Container's getter for OtlTallyRangeLimitsUView1
     */
    public OtlTallyRangeLimitsUViewImpl getOtlTallyRangeLimitsUView1() {
        return (OtlTallyRangeLimitsUViewImpl)findViewObject("OtlTallyRangeLimitsUView1");
    }

    /**Container's getter for OtlTallyRangeLimitsRView1
     */
    public OtlTallyRangeLimitsRViewImpl getOtlTallyRangeLimitsRView1() {
        return (OtlTallyRangeLimitsRViewImpl)findViewObject("OtlTallyRangeLimitsRView1");
    }

    /**Container's getter for TallyRangeSets
     */
    public TallyRangeSetsImpl getTallyRangeSets() {
        return (TallyRangeSetsImpl)findViewObject("TallyRangeSets");
    }

    /**Container's getter for SourceAnswers
     */
    public SourceAnswersImpl getSourceAnswers() {
        return (SourceAnswersImpl)findViewObject("SourceAnswers");
    }

    /**Container's getter for ReportAnswerSetValues
     */
    public ReportAnswerSetValuesImpl getReportAnswerSetValues() {
        return (ReportAnswerSetValuesImpl)findViewObject("ReportAnswerSetValues");
    }

    /**Container's getter for SourcesSingleQuestionAnswers
     */
    public SourcesSingleQuestionAnswersImpl getSourcesSingleQuestionAnswers() {
        return (SourcesSingleQuestionAnswersImpl)findViewObject("SourcesSingleQuestionAnswers");
    }

    /**Container's getter for SourceSortingCriteria
     */
    public SourceSortingCriteriaImpl getSourceSortingCriteria() {
        return (SourceSortingCriteriaImpl)findViewObject("SourceSortingCriteria");
    }

    /**Container's getter for SourcesMultiSingleQuestionAnswers
     */
    public SourcesMultiSingleQuestionAnswersImpl getSourcesMultiSingleQuestionAnswers() {
        return (SourcesMultiSingleQuestionAnswersImpl)findViewObject("SourcesMultiSingleQuestionAnswers");
    }

    /**Container's getter for SourceMultiAnswers
     */
    public SourceMultiAnswersImpl getSourceMultiAnswers() {
        return (SourceMultiAnswersImpl)findViewObject("SourceMultiAnswers");
    }

    /**Container's getter for RAVInfo
     */
    public RAVInfoImpl getRAVInfo() {
        return (RAVInfoImpl)findViewObject("RAVInfo");
    }

    /**Container's getter for SSCInfo
     */
    public SSCInfoImpl getSSCInfo() {
        return (SSCInfoImpl)findViewObject("SSCInfo");
    }

    /**Container's getter for Questions
     */
    public QuestionsImpl getQuestions() {
        return (QuestionsImpl)findViewObject("Questions");
    }

    /**Container's getter for ReportSources
     */
    public ReportSourcesImpl getReportSources() {
        return (ReportSourcesImpl)findViewObject("ReportSources");
    }

    /**Container's getter for ReportLockInfo
     */
    public ReportLockInfoImpl getReportLockInfo() {
        return (ReportLockInfoImpl)findViewObject("ReportLockInfo");
    }

    /**Container's getter for SrcAnsUniqueInfo
     */
    public SrcAnsUniqueInfoImpl getSrcAnsUniqueInfo() {
        return (SrcAnsUniqueInfoImpl)findViewObject("SrcAnsUniqueInfo");
    }

    /**Container's getter for AnsGridErrFileInfo
     */
    public AnsGridErrFileInfoImpl getAnsGridErrFileInfo() {
        return (AnsGridErrFileInfoImpl)findViewObject("AnsGridErrFileInfo");
    }

    /**Container's getter for GetErrXLFile
     */
    public GetErrXLFileInfoImpl getGetErrXLFile() {
        return (GetErrXLFileInfoImpl)findViewObject("GetErrXLFile");
    }

    /**Container's getter for AnswerSets
     */
    public AnswerSetsImpl getAnswerSets() {
        return (AnswerSetsImpl)findViewObject("AnswerSets");
    }

    /**Container's getter for AddAnswerSetForQstn
     */
    public AddAnswerSetForQstnImpl getAddAnswerSetForQstn() {
        return (AddAnswerSetForQstnImpl)findViewObject("AddAnswerSetForQstn");
    }


    /**Container's getter for EditorInfo
     */
    public EditorInfoImpl getEditorInfo() {
        return (EditorInfoImpl)findViewObject("EditorInfo");
    }

    /**Container's getter for LeadReporterInfo
     */
    public LeadReporterInfoImpl getLeadReporterInfo() {
        return (LeadReporterInfoImpl)findViewObject("LeadReporterInfo");
    }

    /**Container's getter for CourtesyTitles
     */
    public CourtesyTitlesImpl getCourtesyTitles() {
        return (CourtesyTitlesImpl)findViewObject("CourtesyTitles");
    }

    /**Container's getter for SuffixTitles
     */
    public SuffixTitlesImpl getSuffixTitles() {
        return (SuffixTitlesImpl)findViewObject("SuffixTitles");
    }

    /**Container's getter for CountriesList
     */
    public CountriesListImpl getCountriesList() {
        return (CountriesListImpl)findViewObject("CountriesList");
    }

    /**Container's getter for TimeZones
     */
    public TimeZonesImpl getTimeZones() {
        return (TimeZonesImpl)findViewObject("TimeZones");
    }

    /**Container's getter for IndustryViews
     */
    public IndustryViewsImpl getIndustryViews() {
        return (IndustryViewsImpl)findViewObject("IndustryViews");
    }

    /**Container's getter for QualityRatings
     */
    public QualityRatingsImpl getQualityRatings() {
        return (QualityRatingsImpl)findViewObject("QualityRatings");
    }

    /**Container's getter for SourceDistributionPreferences
     */
    public SourceDistributionPreferencesImpl getSourceDistributionPreferences() {
        return (SourceDistributionPreferencesImpl)findViewObject("SourceDistributionPreferences");
    }

    /**Container's getter for AnswerSetsInfo
     */
    public AnswerSetsInfoImpl getAnswerSetsInfo() {
        return (AnswerSetsInfoImpl)findViewObject("AnswerSetsInfo");
    }

    /**Container's getter for ReportGeneralInfo
     */
    public ReportGeneralInfoImpl getReportGeneralInfo() {
        return (ReportGeneralInfoImpl)findViewObject("ReportGeneralInfo");
    }

    /**Container's getter for QuestionsListView
     */
    public QuestionsListViewImpl getQuestionsListView() {
        return (QuestionsListViewImpl)findViewObject("QuestionsListView");
    }

    /**Container's getter for QuestionsList
     */
    public QuestionsListImpl getQuestionsList() {
        return (QuestionsListImpl)findViewObject("QuestionsList");
    }

    /**Container's getter for SourceNumReportsReportersLastDateView
     */
    public SourceNumReportsReportersLastDateViewImpl getSourceNumReportsReportersLastDateView() {
        return (SourceNumReportsReportersLastDateViewImpl)findViewObject("SourceNumReportsReportersLastDateView");
    }

    /**Container's getter for SourcesListView
     */
    public SourcesListViewImpl getSourcesListView() {
        return (SourcesListViewImpl)findViewObject("SourcesListView");
    }

    /**Container's getter for SourcesList
     */
    public SourcesListImpl getSourcesList() {
        return (SourcesListImpl)findViewObject("SourcesList");
    }

    /**Container's getter for ASVAnswerValues
     */
    public ASVAnswerValuesImpl getASVAnswerValues() {
        return (ASVAnswerValuesImpl)findViewObject("ASVAnswerValues");
    }

    /**Container's getter for SourcesAnswerSetsView
     */
    public SourcesAnswerSetsViewImpl getSourcesAnswerSetsView() {
        return (SourcesAnswerSetsViewImpl)findViewObject("SourcesAnswerSetsView");
    }

    /**Container's getter for ExtraQstnsReportAnswerSetValues
     */
    public ExtraQstnsReportAnswerSetValuesImpl getExtraQstnsReportAnswerSetValues() {
        return (ExtraQstnsReportAnswerSetValuesImpl)findViewObject("ExtraQstnsReportAnswerSetValues");
    }

    /**Container's getter for AnswerSetValues
     */
    public AnswerSetValuesImpl getAnswerSetValues() {
        return (AnswerSetValuesImpl)findViewObject("AnswerSetValues");
    }

    /**Container's getter for DoesSourceAnswerExist
     */
    public DoesSourceAnswerExistImpl getDoesSourceAnswerExist() {
        return (DoesSourceAnswerExistImpl)findViewObject("DoesSourceAnswerExist");
    }

    /**Container's getter for ExtraQstnsAnswerSetValues
     */
    public ExtraQstnsAnswerSetValuesImpl getExtraQstnsAnswerSetValues() {
        return (ExtraQstnsAnswerSetValuesImpl)findViewObject("ExtraQstnsAnswerSetValues");
    }

    /**Container's getter for OtlAnswerSetValues
     */
    public OtlAnswerSetValuesImpl getOtlAnswerSetValues() {
        return (OtlAnswerSetValuesImpl)findViewObject("OtlAnswerSetValues");
    }

    /**Container's getter for OtlReportAnswerSetValues
     */
    public OtlReportAnswerSetValuesImpl getOtlReportAnswerSetValues() {
        return (OtlReportAnswerSetValuesImpl)findViewObject("OtlReportAnswerSetValues");
    }

    /**Container's getter for MaxAsvId
     */
    public MaxAsvIdImpl getMaxAsvId() {
        return (MaxAsvIdImpl)findViewObject("MaxAsvId");
    }

    /**Container's getter for MaxRavId
     */
    public MaxRavIdImpl getMaxRavId() {
        return (MaxRavIdImpl)findViewObject("MaxRavId");
    }

    /**Container's getter for GetBestSourceId
     */
    public GetBestSourceIdImpl getGetBestSourceId() {
        return (GetBestSourceIdImpl)findViewObject("GetBestSourceId");
    }

    /**Container's getter for Sources
     */
    public SourcesImpl getSources() {
        return (SourcesImpl)findViewObject("Sources");
    }

    /**Container's getter for SourceIndustries
     */
    public SourceIndustriesImpl getSourceIndustries() {
        return (SourceIndustriesImpl)findViewObject("SourceIndustries");
    }

    /**Container's getter for ReporterSources
     */
    public ReporterSourcesImpl getReporterSources() {
        return (ReporterSourcesImpl)findViewObject("ReporterSources");
    }

    /**Container's getter for GetNxtRpsId
     */
    public MaxRpsIdImpl getGetNxtRpsId() {
        return (MaxRpsIdImpl)findViewObject("GetNxtRpsId");
    }

    /**Container's getter for AllSourcesListView
     */
    public AllSourcesListViewImpl getAllSourcesListView() {
        return (AllSourcesListViewImpl)findViewObject("AllSourcesListView");
    }

    /**Container's getter for DoesSourceMultiAnswerExist
     */
    public DoesSourceMultiAnswerExistImpl getDoesSourceMultiAnswerExist() {
        return (DoesSourceMultiAnswerExistImpl)findViewObject("DoesSourceMultiAnswerExist");
    }
}
