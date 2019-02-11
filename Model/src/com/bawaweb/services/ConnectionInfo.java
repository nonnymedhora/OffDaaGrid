/**
 * @author Nonny Medhora
 */
package com.bawaweb.services;

//http://sikkim.sik.nic.in/doc/rt/oracle/jbo/html/jsp/ConnectionInfo.txt

// Copyright (c) 1999, 2000 Oracle Corporation
//package oracle.jbo.html.jsp;

import java.util.Hashtable;
import oracle.jdeveloper.cm.ConnectionManager;
import oracle.jdeveloper.cm.ConnectionDescriptor;
import oracle.jbo.*;
import oracle.jbo.common.PropertyMetadata;

import oracle.jbo.JboContext;
import oracle.jbo.html.jsp.Res;


/**
 ** Represents the connection information used by the ApplicationPool class in order
 ** to instantiate an ApplicationModule.
 **
 ** <a HREF="ConnectionInfo.txt">View implementation of ConnectionInfo</a>
 ** <P>
 ** @author Juan Oropeza
 **/
public class ConnectionInfo extends Object
{
  public static final String O8I_CONNECT_STRING = "jdbc:oracle:kprb:";
  public static final String SET_CONNECT_MODE = "ConnectMode";
  public static final String SET_CONNECTION_NAME = "ConnectionName";
  public static final String SET_PASSWORD = "Password";
  public static final String SET_USERNAME = "UserName";
  public static final String SET_JNDI_PATH = "JndiPath";
  public static final String SET_APP_MODULE = "ApplicationModuleName";
  public static final String SET_POOL_CLASS = "PoolClassName";
  public static final String SET_APP_PATH = "ApplicationPath";
  public static final String SET_HOST_NAME = "HostName";
  public static final String SET_DAD_NAME = "DatabaseAccessDescriptor";
  
  public static final String SET_CONNECT_TYPE_LOCAL = "LOCAL";
  public static final String SET_CONNECT_TYPE_8I_CORBA = "8i";
  public static final String SET_CONNECT_TYPE_8I_EJB = "EJB";
  public static final String SET_CONNECT_TYPE_VB_NAMING = "VB_NAMING";
  public static final String SET_CONNECT_TYPE_VB_BINDING = "VB_BINDING";
  public static final String SET_CONNECT_TYPE_VB_COLOCATE = "VB_COLOCATE";
  public static final String SET_CONNECT_TYPE_OAS_EJB = "OAS_EJB";

  static private ConnectionManager cm = ConnectionManager.getInstance();
  String sAppModuleClass;
  String sConnectType;
  String sConnectionName;
  String sPassword;
  String sUserName;
  String sJndiPath;
  String sApplicationPath;
  String sConnectUrl;
  Hashtable connectSettings = new Hashtable (10);
  String  sPoolClass = "oracle.jbo.common.ampool.ApplicationPoolImpl";
  String  sHostName;
  String  sDad;
  
  /**
   * Constructor
   */
  public ConnectionInfo() {
  }

  public String getUserName()
  {
   return this.sUserName;
  }

  /**
  **  <pre>
  **  This constructor provides a convenient way to initialize the ConnectionInfo's variables by
  **  providing a Hashtable with the values for the various properties. The expected name/value pairs
  **  are:
  **
  **    ConnectionInfo.SET_CONNECT_MODE  - This can be Local, 8i or EJB
  **    ConnectionInfo.SET_CONNECTION_NAME - The named connection to be used for getting the
  **                                         connection information.
  **    ConnectionInfo.SET_PASSWORD         - The password to be used in the connection URL
  **    ConnectionInfo.SET_USERNAME         - The user name to be used in the connection URL
  **    ConnectionInfo.SET_JNDI_PATH        - The JndiPath to be used (If applicable to the connection type)
  **    ConnectionInfo.SET_APP_MODULE       - The Class name for the application module to be instantiated
  **    ConnectionInfo.SET_POOL_CLASS       - The Class name of the class to use instead of the default
  **                                         ApplicationPool implementation class.
  **    ConnectionInfo.SET_APP_PATH         - application path ( maps to JboContext.APPLICATION_PATH)
  **
  **   Here is a sample initialization of some of the parameters:
  **
  **    Hashtable ht = new Hashtable(10);
  **
  **    ht.put(ConnectionInfo.SET_CONNECT_MODE , ConnectionInfo.SET_CONNECT_TYPE_LOCAL);
  **    ht.put(ConnectionInfo.SET_CONNECTION_NAME, "Connection1");
  **    ht.put(ConnectionInfo.SET_APP_MODULE , "package1.Package1Module");
  **
  **
  **  </pre>
  **/
  public ConnectionInfo(Hashtable props)
  {
    sConnectType = (String)props.get(SET_CONNECT_MODE);
    sConnectionName = (String)props.get(SET_CONNECTION_NAME);
    sPassword = (String)props.get(SET_PASSWORD);
    sJndiPath = (String)props.get(SET_JNDI_PATH);
    sAppModuleClass = (String)props.get(SET_APP_MODULE);
    sApplicationPath = (String)props.get(SET_APP_PATH);
    sHostName = (String)props.get(this.SET_HOST_NAME);
	 sDad = (String)props.get(this.SET_DAD_NAME);  
			  
    if(props.get(SET_POOL_CLASS) != null)
    {
      sPoolClass = (String)props.get(SET_POOL_CLASS);
    }

    if(props.get(SET_USERNAME) != null)
    {
      sUserName = (String)props.get(this.SET_USERNAME);
    }
    else
    {
      sUserName = null;
    }
    
    initializeConnectionSettings();
  }

  /**
  **  This function should be called after setting values for the ConnectionName,ConnectionType and Password
  **  properties. It parses the connection information and generates the connection URL. If you
  **  are setting the connection URL directly, don't call this function or it will erase your current setting.
  **/
  public void initializeConnectionSettings()
  {
    if(sConnectType.equalsIgnoreCase(SET_CONNECT_TYPE_LOCAL))
     {
        initializeFromConnectionName(sConnectionName);

        // default to default value (local mode)
  		  connectSettings.put(PropertyMetadata.INITIAL_CONTEXT_FACTORY.getName(), PropertyMetadata.INITIAL_CONTEXT_FACTORY.getDefault());
	  	  connectSettings.put(PropertyMetadata.DEPLOY_PLATFORM.getName(), PropertyMetadata.DEPLOY_PLATFORM.getDefault());
     }
     else if (sConnectType.equalsIgnoreCase(SET_CONNECT_TYPE_8I_CORBA))
     {
        populateHashTableWithRemoteConnectionInfo(connectSettings , sConnectionName, sPassword, sJndiPath);
        // adjust connetion url to use 8i jdbc connection
        sConnectUrl = O8I_CONNECT_STRING;
     }
	  else if (sConnectType.equalsIgnoreCase(this.SET_CONNECT_TYPE_8I_EJB))
	  {
          // it's ejb
          populateHashTableWithRemoteConnectionInfo(connectSettings , sConnectionName, sPassword, sJndiPath);

			 connectSettings.put(JboContext.DEPLOY_PLATFORM, JboContext.PLATFORM_EJB);

          // adjust connection url to use 8i jdbc connection
          sConnectUrl = O8I_CONNECT_STRING;
	  }
	  else if (sConnectType.equalsIgnoreCase(this.SET_CONNECT_TYPE_OAS_EJB))
	  {
          // it's OAS ejb
          populateHashTableWithOasRemoteConnectionInfo(connectSettings , sConnectionName, sPassword, sJndiPath);

			 sConnectUrl = "jdbc:oracle:jts8:@";

			 if(sDad == null)
          {
            throw new RuntimeException(Res.getString(Res.MSG_DAD_MISSING));
			 }
			 sConnectUrl += sDad;

          if(sApplicationPath == null)
          {
            throw new RuntimeException(Res.getString(Res.MSG_APP_PATH_MISSING));
          }

          connectSettings.put(JboContext.APPLICATION_PATH, sApplicationPath);
	  }
     else if (sConnectType.equalsIgnoreCase(this.SET_CONNECT_TYPE_VB_NAMING))
	  {
          initializeFromConnectionName(sConnectionName);

          connectSettings.put(PropertyMetadata.INITIAL_CONTEXT_FACTORY.getName(), PropertyMetadata.INITIAL_CONTEXT_FACTORY.getDefault());
			 connectSettings.put(JboContext.DEPLOY_PLATFORM, JboContext.PLATFORM_VB);
          connectSettings.put(JboContext.CONNECTION_MODE, new Integer(ConnectionModeConstants.REMOTE));

          if(sApplicationPath == null)
          {
            throw new RuntimeException(Res.getString(Res.MSG_APP_PATH_MISSING));
          }

          connectSettings.put(JboContext.APPLICATION_PATH, sApplicationPath);

     }
     else if (sConnectType.equalsIgnoreCase(this.SET_CONNECT_TYPE_VB_BINDING))
	  {
          initializeFromConnectionName(sConnectionName);

          connectSettings.put(PropertyMetadata.INITIAL_CONTEXT_FACTORY.getName(), PropertyMetadata.INITIAL_CONTEXT_FACTORY.getDefault());
			 connectSettings.put(JboContext.DEPLOY_PLATFORM, JboContext.PLATFORM_VB);
          connectSettings.put(JboContext.CONNECTION_MODE, new Integer(ConnectionModeConstants.USE_BIND));

          if(sHostName != null)
          {
            connectSettings.put(JboContext.HOST_NAME, sHostName);
          }


	  }
     else if (sConnectType.equalsIgnoreCase(this.SET_CONNECT_TYPE_VB_COLOCATE))
	  {
        initializeFromConnectionName(sConnectionName);

  		  connectSettings.put(PropertyMetadata.INITIAL_CONTEXT_FACTORY.getName(), PropertyMetadata.INITIAL_CONTEXT_FACTORY.getDefault());
		  connectSettings.put(JboContext.DEPLOY_PLATFORM, JboContext.PLATFORM_VB);
        connectSettings.put(JboContext.CONNECTION_MODE, new Integer(ConnectionModeConstants.COLOCATE));
	  }
     else
     {
        String sError = Res.getString(Res.MSG_UNKNOWN_CONNECT_TYPE);

        sError += SET_CONNECT_TYPE_LOCAL
               +  "," + SET_CONNECT_TYPE_8I_CORBA
               +  "," + SET_CONNECT_TYPE_8I_EJB
               +  "," + SET_CONNECT_TYPE_VB_NAMING
               +  "," + SET_CONNECT_TYPE_VB_BINDING
               +  "," + SET_CONNECT_TYPE_VB_COLOCATE ;

        throw new RuntimeException(sError);
     }
  }

  /**
  **  Provides the Class name for the Class that implements the  ApplicationPool interface. If you application
  **  requires a specialization of the ApplicationPool interface, derive your class from the ApplicationPoolImpl
  **  class or implement the ApplicationPool interface in your new class. You can then assing you class name to
  **  the connectinfo prior to creating the named pool. 
  **/
  public void setPoolClass(String sClass)
  {
    sPoolClass = sClass;
  }

  /**
  **  Returns the Class name used for the ApplicationPool
  **/
  public String getPoolClass()
  {
    return sPoolClass;
  }

  /**
  **  Sets up the connection type. It should be one of the folowing settings:
  **
  ** <pre>
  **  ConnectionInfo.SET_CONNECT_TYPE_LOCAL
  **  ConnectionInfo.SET_CONNECT_TYPE_8I_CORBA
  **  ConnectionInfo.SET_CONNECT_TYPE_8I_EJB
  **  </pre>
  **/
  public void setConnectionType(String sType)
  {
    this.sConnectType = sType;
  }

  /**
  **  Returns the current value of connection type.
  **/
  public String getConnectionType()
  {
    return this.sConnectType;
  }

  /**
  **  Assigns the connection name. The name must refer to a connection defined in the connections.properties
  **  file. You must make sure you deploy the connections.properties file as part of your application's classes.
  **/
  public void setConnectionName(String sName)
  {
    this.sConnectionName = sName;
  }

  /**
  **  Returns the connection name
  **/
  public String getConnectionName()
  {
    return this.sConnectionName;
  }

  /**
  **  Retrieves the Hashtable that contains all the connection parameters being used to instanciate an
  **  application module.
  **/
  public Hashtable getConnectionSettings()
  {
    return connectSettings;
  }

  /**
  **  Sets the connection settings to be used for instanciating and Application Module. Please look at the implementation
  **  of the initializeConnectionSettings() method for a sample usage.
  **/
  public void setConnectionSettings(Hashtable settings)
  {
    this.connectSettings = settings;
  }

  /**
  **  Returns the Class name of the Application Module represented by the ConnectionInfo class.
  **/
  public String getAppModuleClass()
  {
    return this.sAppModuleClass;
  }

  /**
  **  Provides the Class name of the Application Module to be connected to. 
  **/
  public void setAppModuleClass(String sClass)
  {
    this.sAppModuleClass = sClass;
  }

  /**
  **  Returns the connection URL
  **/
  public String getConnectionUrl()
  {
    return this.sConnectUrl;
  }

  /**
  **  Sets the connection URL to be used by the Application Module. This URL is passed the the ApplicationModule.connect()
  **  call.
  **/
  public void setConnectionUrl(String sUrl)
  {
    this.sConnectUrl = sUrl;
  }
  
  /**
  **  Provides the password. If you provided a connection URL, it must contain the password as part of it. This
  **  function should only be used if you are using the ConnectionName approach for initializing the connection string.
  **/
  public void setPassword(String sPassword)
  {
    this.sPassword = sPassword;
  }

  /**
  **  Returns the current password.
  **/
  public String getPassword()
  {
    return this.sPassword;
  }

  /**
  **  Provides the Jndi Path required when connecting to an ApplicationModule deployed to Oracle 8i as an EJB or Corba
  **  object.
  **/
  public void setJndiPath(String sPath)
  {
    this.sJndiPath = sPath;
  }

  /**
  **  Returns the Jndi path
  **/
  public String getJndiPath()
  {
    return this.sJndiPath;
  }

  public void initializeFromConnectionName(String sConnectionName)
  {
      String connectStr = null;

		try
		{
			  ConnectionDescriptor cd = cm.getConnectionDescriptor(sConnectionName);

           if(cd == null)
           {
            throw new RuntimeException("Could not find connection: " + sConnectionName);
           }

			  String password = cd.getPassword();

			  if (sPassword == null)
			  {
				  sPassword = password;
			  }

			  if(sPassword == null)
			  {
				throw new RuntimeException("Password is missing from ConnectionInfo.");
			  }

			  this.sConnectUrl = cd.getURL();
           sUserName = cd.getUsername();
		}
		catch(Exception ex)
		{
			  throw new RuntimeException(ex.getMessage());
		}

  }
  
 /**
  **  This is an internal function that populates a Hashtable with the HTTP connection information.
  **/
  static public void populateHashTableWithOasRemoteConnectionInfo(Hashtable env , String sRemoteConnectionName, String sPassword, String sJndiPath)
 	{
		String connectStr = null;

		try
		{
      ConnectionDescriptor cd = cm.getConnectionDescriptor(sRemoteConnectionName);

      if(cd == null)
      {
        throw new RuntimeException("Could not find remote connection: " + sRemoteConnectionName);
      }

      String password = cd.getPassword();

		if (password == null)
		{
			password = sPassword;
		}

      
      env.put(PropertyMetadata.INITIAL_CONTEXT_FACTORY.getName(), PropertyMetadata.INITIAL_CONTEXT_FACTORY.getDefault());
      env.put(JboContext.DEPLOY_PLATFORM, JboContext.PLATFORM_EJB_IAS);     // tried OAS didn't work

      String url = cd.getURL();

      int bIndex = url.indexOf(":") + 1;

      String hostName = url.substring(0, bIndex - 1);
      String port = url.substring(bIndex);

      env.put(JboContext.HOST_NAME, hostName);
      env.put(JboContext.CONNECTION_PORT, port);

		}
		catch(Exception ex)
		{
			throw new RuntimeException(ex.getMessage());
		}
	}

   static public void populateHashTableWithRemoteConnectionInfo(Hashtable env , String sRemoteConnectionName, String sPassword, String sJndiPath)
 	{
		String connectStr = null;

		try
		{
      ConnectionDescriptor cd = cm.getConnectionDescriptor(sRemoteConnectionName);

      if(cd == null)
      {
        throw new RuntimeException("Could not find remote connection: " + sRemoteConnectionName);
      }

      String password = cd.getPassword();

		if (password == null)
		{
			password = sPassword;
		}

      
      env.put(PropertyMetadata.INITIAL_CONTEXT_FACTORY.getName(), PropertyMetadata.INITIAL_CONTEXT_FACTORY.getDefault());
      env.put(JboContext.DEPLOY_PLATFORM, JboContext.PLATFORM_ORACLE8I);

      String url = cd.getURL();
      int bIndex = url.indexOf("://") + 3;
      int eIndex = url.indexOf(':', bIndex);

      String hostName = url.substring(bIndex, eIndex);
      bIndex = eIndex + 1;
      eIndex = url.indexOf(':', bIndex);
      String port = url.substring(bIndex, eIndex);
      String sid = url.substring(eIndex + 1);

      env.put(JboContext.HOST_NAME, hostName);
      env.put(JboContext.CONNECTION_PORT, port);
      env.put(PropertyMetadata.SECURITY_PRINCIPAL.getName(), cd.getUsername());
      env.put(PropertyMetadata.SECURITY_CREDENTIALS.getName(), password);
      env.put(JboContext.APPLICATION_PATH, sJndiPath);
      env.put(JboContext.ORACLE_SID, sid);

		}
		catch(Exception ex)
		{
			throw new RuntimeException(ex.getMessage());
		}
	}
}


