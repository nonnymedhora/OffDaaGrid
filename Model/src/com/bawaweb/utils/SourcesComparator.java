/**
 * @author Nonny Medhora
 */
package com.bawaweb.utils;

import com.bawaweb.grid.templates.data.tables.SourceDataSetInfo;

import java.util.Comparator;

public class SourcesComparator implements Comparator {
    public int compare(Object o1, Object o2) {
        SourceDataSetInfo s1 = (SourceDataSetInfo)o1;
        SourceDataSetInfo s2 = (SourceDataSetInfo)o2;
        
        return s1.compareTo(s2);
    }
    
    public int compare(SourceDataSetInfo o1, SourceDataSetInfo o2) {
        return o2.compareTo(o1);
    }
}
