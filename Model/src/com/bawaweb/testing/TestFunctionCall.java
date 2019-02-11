package com.bawaweb.testing;

import com.bawaweb.services.PlatformAppModuleService;
import com.bawaweb.services.PlatformAppModuleServiceImpl;

import java.util.Iterator;
import java.util.List;

public class TestFunctionCall {
    public TestFunctionCall() {
    }

    public static void main(String[] args) {
        TestFunctionCall testFunctionCall = new TestFunctionCall();
        PlatformAppModuleService platform = PlatformAppModuleServiceImpl.getInstance();
        
        /*
         * getSimilarSources(String fName, 
                                          String lName, 
                                          String city,
                                          int ctryId,
                                          String company,
                                          String phone) {   //6 params
         */
         String fName = "Julie";
         String lName = "Harness";
         String city = "palatine";
         int ctryId = 1;
         String company = "Toll Brothers";
         String phone = "8479344800";
        
         List<String> srcs = platform.getSimilarSources(fName, lName, city, ctryId, company, phone);
         
         testFunctionCall.printList(srcs);
         
         
         int[] theSources = new int[srcs.size()];
         int i = 0;
         for(String s : srcs ) {
            theSources[i] = Integer.parseInt(s);
            i++;    
         }
         
         int righto = platform.getBestSourceId(theSources, 0);
System.out.println("righto is " + righto);         
        
    }
    
    
    public void printList(List alist) {
         if ( alist == null ) { System.out.println("alist is null"); return; }
         Iterator it = alist.iterator();
         while ( it.hasNext() ) 
             System.out.println("|"+ it.next()+"|" );
     }
}
