/**
 * @author Nonny Medhora
 */
package com.bawaweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;

public class TestDBServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, 
                      HttpServletResponse response) throws ServletException, IOException {response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>TestDBServlet</title></head>");
        out.println("<body>");
        out.println("<p>The servlet has received a GET. This is the reply.</p>");
        
        String sName = request.getParameter("sName");
        String pNumber = request.getParameter("pNumber");
        String sId = request.getParameter("sId");
        String uName = request.getParameter("uName");
        String psswd = request.getParameter("psswd");
        //http://otrias4.ox.com:7777/platform/servlet/testdbservlet?sName=san-wk-aweinste.ox.com&pNumber=1522&sId=xe&uName=SALES&psswd=salesxe
        out.println( getConnectionInfo( sName,  pNumber,  sId,  uName,  psswd));
        out.println("</body></html>");
        out.close();
    }
    
    public String getConnectionInfo(String sName, String pNumber, String sId, String uName, String psswd) {
    Connection connection = null;
    String url = "";
        try {
            // Load the JDBC driver
            String driverName = "oracle.jdbc.driver.OracleDriver";
            Class.forName(driverName);
        
            // Create a connection to the database
            String serverName = sName;//"san-wk-aweinste.ox.com";
            String portNumber = pNumber;//"1522";
            String sid = sId;//"mydatabase";
            url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":" + sid;
            String username = uName;//"username";
            String password = psswd;//"password";
            connection = DriverManager.getConnection(url, username, password);
            if ( connection != null ) return "Connection established successfully to: url" + url;
        } catch (ClassNotFoundException e) {
            return "Could not find the database driver for url: " + url;
        } catch (SQLException e) {        
            return "Could not connect to the database for url: " + url;
        }
        return "Couldnt connect to database for url: " + url;
    }

}
