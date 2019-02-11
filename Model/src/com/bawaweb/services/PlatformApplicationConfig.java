/**
 * @author Nonny Medhora
 */
package com.bawaweb.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * This utility class is to be used for centralizing configuration information.
 * It references <b>platform.properties</b> for setting up the properties
 */
public class PlatformApplicationConfig {
    private static Properties properties;
    private static PlatformApplicationConfig config;

    static {
        config = new PlatformApplicationConfig();
    }

    private PlatformApplicationConfig() {
        try {
            InputStream in =  this.getClass().getClassLoader().getResourceAsStream("./platform.properties");
            properties = new Properties();
            properties.load(in);
        } catch (IOException ex) {
            Logger.getLogger(PlatformApplicationConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static PlatformApplicationConfig getApplicationConfig () {
        return config;
    }

    public String getProperty (String propName) {
        return properties.getProperty(propName, "Null");
    }   

    public static void main(String[] args) {
        PlatformApplicationConfig applicationConfig = PlatformApplicationConfig.getApplicationConfig();
        System.out.println( applicationConfig.getProperty("syncsend.log.location") );
    }
}
