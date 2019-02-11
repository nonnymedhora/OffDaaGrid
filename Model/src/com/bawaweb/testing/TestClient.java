package com.bawaweb.testing;


import com.bawaweb.appmodule.PlatformAppModuleImpl;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import oracle.jbo.ApplicationModule;
import oracle.jbo.client.remote.ejb.ApplicationModuleProxy;



public class TestClient {
    private static final String EJB_BEAN_NAME = "PlatformAppModuleLocal";

//    public static ApplicationModule getAppModule() {
//        try {
//            Context ctx = getContext();
//            PlatformAppModuleImpl  home = (PlatformAppModuleImpl )ctx.lookup(EJB_BEAN_NAME);
//            ApplicationModule am = 
//                /* or some client props */ApplicationModuleProxy.create(home, 
//                                                                        null);
//            am.getTransaction().connectToDataSource(null, "jdbc/shuttleDS", 
//                                                    false);
//            return am;
//        } catch (NamingException nex) {
//            return null;
//        }
//    }

    private static InitialContext getContext() {
        try {
            Hashtable env = new Hashtable();
            env.put(Context.INITIAL_CONTEXT_FACTORY, 
                    "com.evermind.server.rmi.RMIInitialContextFactory");
            env.put(Context.SECURITY_PRINCIPAL, "admin");
            env.put(Context.SECURITY_CREDENTIALS, "welcome");
            /*
* PUT YOUR CUSTOM lookup: URL HERE
*/
            env.put(Context.PROVIDER_URL, "ormi://localhost/Project1EJB");
            return new InitialContext(env);
        } catch (NamingException e) {
            return null;
        }
    }
}


