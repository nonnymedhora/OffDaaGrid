/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data;

import com.bawaweb.grid.templates.data.tables.SourceDataSetInfo;

import java.util.HashMap;
import java.util.Map;

import com.bawaweb.grid.templates.data.tables.SourceDataSetInfo;

public class SourceDisplayMap extends HashMap {

	public SourceDisplayMap(SourceDataSetInfo s) {	
		this.put("NAME", s.getSrcName());
		this.put("JOB TITLE", s.getSrc_job_title());
		this.put("COMPANY", s.getSrc_company());
		this.put("CITY", s.getSrc_city() + ", " + s.getSrc_state());
		this.put("CO,NAME", s.getSrc_company() + ", " + s.getSrcName());
		this.put("CO,JOB", s.getSrc_company() + ", " + s.getSrc_job_title());
		this.put("NAME,JOB", s.getSrcName() + ", " + s.getSrc_job_title());
		this.put("CO,JOB,N", s.getSrc_company() + ", " + s.getSrc_job_title() + ", " + s.getSrcName());
		this.put("CO,JOB,C,S", s.getSrc_company() + ", " + s.getSrc_job_title() + ", " + s.getSrc_city() + ", " + s.getSrc_state());
		this.put("CO,C,S", s.getSrc_company() + ", " + s.getSrc_city() + ", " + s.getSrc_state());
		this.put("CO,C,S,N", s.getSrc_company() + ", " + s.getSrc_city() + ", " + s.getSrc_state() + ", " + s.getSrcName());
		this.put("CO,C,S,J,N", s.getSrc_company() + ", " + s.getSrc_city() + ", " + s.getSrc_state() + ", " + s.getSrc_job_title()  + ", " + s.getSrcName());
		this.put("IS,CO,N", s.getSrc_industry_sector() + ", " + s.getSrc_company() + ", " + s.getSrcName());
		this.put("IS,CO,J,N", s.getSrc_industry_sector() + ", " + s.getSrc_company() + ", " + s.getSrc_job_title() + ", " + s.getSrcName());
		this.put("N,JOB,IS", s.getSrcName() + ", " + s.getSrc_job_title() + ", " + s.getSrc_industry_sector());
		
	}
}
