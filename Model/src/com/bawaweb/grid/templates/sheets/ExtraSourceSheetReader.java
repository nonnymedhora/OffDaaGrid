/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.sheets;

import com.bawaweb.grid.templates.data.tables.SourceDataSetInfo;
import com.bawaweb.services.PlatformAppModuleService;

import java.util.List;
import java.util.Map;

import jxl.Sheet;

public interface ExtraSourceSheetReader {

    public void setMp_row_src(Map<Integer, SourceDataSetInfo> mp_row_src);

    public Map<Integer, SourceDataSetInfo> getMp_row_src();

    public void setMp_src_row(Map<SourceDataSetInfo, Integer> mp_src_row);

    public Map<SourceDataSetInfo, Integer> getMp_src_row();

    public void setMp_internalsrcid_src(Map<Integer, SourceDataSetInfo> mp_internalsrcid_src);

    public Map<Integer, SourceDataSetInfo> getMp_internalsrcid_src();

    public void setMp_src_interalsrcid(Map<SourceDataSetInfo, Integer> mp_src_interalsrcid);

    public Map<SourceDataSetInfo, Integer> getMp_src_interalsrcid();

    public void setLi_invalidSrcRows(List<Integer> li_invalidSrcRows);

    public List<Integer> getLi_invalidSrcRows();

    public void setLi_invalidSrcs(List<SourceDataSetInfo> li_invalidSrcs);

    public List<SourceDataSetInfo> getLi_invalidSrcs();

    public void setLi_newRepSrcs(List<SourceDataSetInfo> li_newRepSrcs);

    public List<SourceDataSetInfo> getLi_newRepSrcs();

    public void setLi_newSrcs(List<SourceDataSetInfo> li_newSrcs);

    public List<SourceDataSetInfo> getLi_newSrcs();

    public void printList(List alist);

    public void printMap(Map aMap);

    public void setExtraSources(List<SourceDataSetInfo> extraSources);

    public List<SourceDataSetInfo> get_extraSources();

    public void setExtraSourcesSheet(Sheet extraSourcesSheet);

    public Sheet getExtraSourcesSheet();

    public void setIdentifiedSrcs(List<String> identifiedSrcs);

    public List<String> getIdentifiedSrcs();

    public PlatformAppModuleService getPlatform();

    public void setReportId(int reportId);

    public int getReportId();

    public void setReporterId(int reporterId);

    public int getReporterId();
    
    public List<SourceDataSetInfo> getExtraSources(Sheet extraSourcesSheet);
    
    public void processExtraSources(List<SourceDataSetInfo> extraSources);
    
    public void setLi_warnings(List<String> li_warnings);

    public List<String> getLi_warnings();

    public void setLi_errors(List<String> li_errors);

    public List<String> getLi_errors();
    
    public List<String> getAll_errors();
    
    public void flushErrors();
    public Map<Integer, Integer> getMp_extraRepSrcIdSrcId();
    
    public void setMp_extraRepSrcIdSrcId(Map<Integer, Integer> amap);

    public Map<Integer, SourceDataSetInfo> getRpsSourceDataMap(List<SourceDataSetInfo> xtraNewSrcs, 
                                                               List<SourceDataSetInfo> xtraRepSrcs);
}
