/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.tables;

import java.util.Comparator;

public class ReportAnswerSetValuesDataSetComparator implements Comparator {
    public ReportAnswerSetValuesDataSetComparator() {
    }

    public static void main(String[] args) {
        ReportAnswerSetValuesDataSetComparator reportAnswerSetValuesDataSetComparator = new ReportAnswerSetValuesDataSetComparator();
    }
    
    
    public int compare(Object o1, Object o2) {
        ReportAnswerSetValuesDataSet rav1 = (ReportAnswerSetValuesDataSet) o1;
        ReportAnswerSetValuesDataSet rav2 = (ReportAnswerSetValuesDataSet) o2;
        Integer rav1Disp = rav1.getRav_display_seq();
        Integer rav2Disp = rav2.getRav_display_seq();
        return rav2Disp.compareTo( rav1Disp );
    }
}
