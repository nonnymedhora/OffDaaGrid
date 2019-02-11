/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data.tables;

import java.util.Comparator;

public class AnswerSetValuesDataSetComparator implements Comparator {
    public AnswerSetValuesDataSetComparator() {
    }

    public static void main(String[] args) {
        AnswerSetValuesDataSetComparator answerSetValuesDataSetComparator = new AnswerSetValuesDataSetComparator();
    }
    
    
    public int compare(Object o1, Object o2) {
        AnswerSetValuesDataSet asv1 = (AnswerSetValuesDataSet) o1;
        AnswerSetValuesDataSet asv2 = (AnswerSetValuesDataSet) o2;
        Integer asv1Disp = asv1.getAsv_display_seq();
        Integer asv2Disp = asv2.getAsv_display_seq();
        return asv2Disp.compareTo( asv1Disp );
    }
}
