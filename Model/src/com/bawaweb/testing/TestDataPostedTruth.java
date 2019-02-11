package com.bawaweb.testing;

public class TestDataPostedTruth {
    public TestDataPostedTruth() {
    }

    public static void main(String[] args) {
        TestDataPostedTruth testDataPostedTruth = new TestDataPostedTruth();
        boolean isAllDataPosted = false; System.out.println("isAllDataPosted " + isAllDataPosted );
        boolean isDataUnitPosted = false; System.out.println("isDataUnitPosted " + isDataUnitPosted );
        /*
        isAllDataPosted = isAllDataPosted || isDataUnitPosted;
        System.out.println("isAllDataPosted " + isAllDataPosted );
        isDataUnitPosted = true; System.out.println("isDataUnitPosted " + isDataUnitPosted );
        isAllDataPosted = isAllDataPosted || isDataUnitPosted;
        System.out.println("isAllDataPosted " + isAllDataPosted );
        */
        
        isAllDataPosted = false;
        isDataUnitPosted = true;
        System.out.println("1 isAllDataPosted = " + isAllDataPosted + " and isDataUnitPosted = " + isDataUnitPosted);
        isAllDataPosted = isDataUnitPosted && ( isAllDataPosted || isDataUnitPosted);
        System.out.println("isAllDataPosted " + isAllDataPosted);
        
        
        isAllDataPosted = true;
        isDataUnitPosted = true;
        System.out.println("2 isAllDataPosted = " + isAllDataPosted + " and isDataUnitPosted = " + isDataUnitPosted);
        isAllDataPosted = isDataUnitPosted && ( isAllDataPosted || isDataUnitPosted);
        System.out.println("isAllDataPosted " + isAllDataPosted);
        
        isAllDataPosted = false;
        isDataUnitPosted = false;
        System.out.println("3 isAllDataPosted = " + isAllDataPosted + " and isDataUnitPosted = " + isDataUnitPosted);
        isAllDataPosted = isDataUnitPosted && ( isAllDataPosted || isDataUnitPosted);
        System.out.println("isAllDataPosted " + isAllDataPosted);
        
        isAllDataPosted = true;
        isDataUnitPosted = false;
        System.out.println("4 isAllDataPosted = " + isAllDataPosted + " and isDataUnitPosted = " + isDataUnitPosted);
        isAllDataPosted = isDataUnitPosted && ( isAllDataPosted || isDataUnitPosted);
        System.out.println("isAllDataPosted " + isAllDataPosted);
        
        
        
        
        
        
    }
}
