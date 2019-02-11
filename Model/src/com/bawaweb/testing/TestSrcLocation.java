package com.bawaweb.testing;

import com.bawaweb.services.PlatformAppModuleService;
import com.bawaweb.services.PlatformAppModuleServiceImpl;

public class TestSrcLocation {
    public TestSrcLocation(int srcid) {
        PlatformAppModuleService platform = PlatformAppModuleServiceImpl.getInstance();
        System.out.println( platform.checkSourceLocation(srcid));
    }

    public static void main(String[] args) {
        TestSrcLocation testSrcLocation = new TestSrcLocation(50516);
    }
}
