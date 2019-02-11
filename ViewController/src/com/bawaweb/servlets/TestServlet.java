/**
 * @author Nonny Medhora
 */
package com.bawaweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import java.lang.reflect.Field;

import javax.servlet.*;
import javax.servlet.http.*;

import oracle.jbo.client.Configuration;

public class TestServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, 
                      HttpServletResponse response) throws ServletException, 
                                                           IOException {
        int rprtId = Integer.parseInt(request.getParameter("rprtId"));
        int rprtrId = Integer.parseInt(request.getParameter("rprtrId"));
        
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>TestServlet</title></head>");
        out.println("<body>");
        out.println("<p>The servlet has received a GET. This is the reply.</p>");
//        out.println("<p>rprtId " + rprtId + "</p>");
//        out.println("<p>rprtrId " + rprtrId + "</p>");
        out.println("<p><hr/>Configuration info</p>");
        
        getConfigurationInfo(out);
        out.println("</body></html>");
        out.close();
    }

    public void doPost(HttpServletRequest request, 
                       HttpServletResponse response) throws ServletException, 
                                                            IOException {
        int rprtId = Integer.parseInt(request.getParameter("rprtId"));
        int rprtrId = Integer.parseInt(request.getParameter("rprtrId"));
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>TestServlet</title></head>");
        out.println("<body>");
        out.println("<p>The servlet has received a POST. This is the reply.</p>");
        out.println("<p>rprtId " + rprtId + "</p>");
        out.println("<p>rprtrId " + rprtrId + "</p>");
        out.println("<p><hr/>Configuration info</p>");
        
        getConfigurationInfo(out);
        
        out.println("</body></html>");
        out.close();
    }

    private void getConfigurationInfo(PrintWriter out) {
        Configuration conInfo = new Configuration();
        Class cClass = conInfo.getClass();
        Field[] fields = cClass.getDeclaredFields();
        for ( int i = 0; i < fields.length; i++) {
            try {
                out.println(fields[i].getName() + " ==> " + fields[i].get(conInfo) + "</p>");
            } catch (IllegalAccessException e) {
                out.println( e.getMessage());
            }
        }
        String[] nameConfigs = conInfo.getConfigurationNameList();
        for (int i = 0; i < nameConfigs.length; i++) {
            out.println("<p>namedConfig["+i+"] " + nameConfigs[i]);
        }
    }
}
