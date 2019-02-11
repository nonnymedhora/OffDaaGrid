package com.bawaweb.testing;

import com.bawaweb.services.PlatformAppModuleService;
import com.bawaweb.services.PlatformAppModuleServiceImpl;

public class TestDoesAnswerExist {
    public TestDoesAnswerExist() {
    }

    public static void main(String[] args) {
        TestDoesAnswerExist testDoesAnswerExist = new TestDoesAnswerExist();
        
        
        PlatformAppModuleService platform = PlatformAppModuleServiceImpl.getInstance();
        
        int qstId = 337;
        int repSrcId = 22731;
        
        boolean doesSrcAnswerExist = platform.doesSourceAnswerExist( qstId, repSrcId );
        System.out.println("doesSrcAnswerExist is " + doesSrcAnswerExist + " for qstid " + qstId + " reportSrcId " + repSrcId);
    }
}
