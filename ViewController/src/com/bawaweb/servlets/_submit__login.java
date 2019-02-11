package com.bawaweb.servlets;

//import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.*;
import java.lang.reflect.*;
import java.beans.*;
import java.util.*;
import oracle.jbo.*;
import oracle.jbo.common.ampool.*;
import javax.naming.*;
import oracle.jdeveloper.html.*;
import oracle.jbo.html.databeans.*;

import oracle.jbo.pool.ResourcePoolManager;

import oracle.jsp.runtime.OracleJspRuntime;


public class _submit__login extends HttpServlet {// extends  oracle.jsp.runtimev2.Ht{//                       oracle.jsp.runtime.HttpJsp {

  public final String _globalsClassName = null;

  // ** Begin Declarations


  // ** End Declarations

  public void _jspService(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    response.setContentType( "text/html;charset=WINDOWS-1252");
    /* set up the intrinsic variables using the pageContext goober:
    ** session = HttpSession
    ** application = ServletContext
    ** out = JspWriter
    ** page = this
    ** config = ServletConfig
    ** all session/app beans declared in globals.jsa
    */
    JspFactory factory = JspFactory.getDefaultFactory();
    PageContext pageContext = factory.getPageContext( this, request, response, "errorpage.jsp", true, JspWriter.DEFAULT_BUFFER, true);
    // Note: this is not emitted if the session directive == false
    HttpSession session = pageContext.getSession();
    if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) {
      pageContext.setAttribute(OracleJspRuntime.JSP_PAGE_DONTNOTIFY, "true", PageContext.PAGE_SCOPE);
      factory.releasePageContext(pageContext);
      return;
}
    ServletContext application = pageContext.getServletContext();
    JspWriter out = pageContext.getOut();
    _submit__login page = this;
    ServletConfig config = pageContext.getServletConfig();

    try {
      // global beans
      // end global beans


      out.print(__jsp_StaticText.text[0]);
      
          if(ResourcePoolManager.getManagerInstance().getResourcePool("OnlineOrders_OnlineOrdersModule") == null)

          {

            Hashtable info = new Hashtable();

            String sConnect = "jdbc:oracle:thin:";

      

            sConnect += request.getParameter("username") + "/";

            sConnect += request.getParameter("password");

            sConnect += request.getParameter("ConnectionUrl");

      

            info.put(JboContext.INITIAL_CONTEXT_FACTORY, JboContext.JBO_CONTEXT_FACTORY);

            info.put(JboContext.DEPLOY_PLATFORM, "LOCAL");

            info.put("IsStateLessRuntime", "false");

            info.put("CSSURL", "/webapp/cabo/images/cabo_styles.css");

            info.put("ImageBase", "/webapp/jsimages");

      

            PoolMgr.getInstance().createPool("OnlineOrders_OnlineOrdersModule", "OnlineOrders.OnlineOrdersModule" , sConnect, info);

      

            ApplicationPool pool = (ApplicationPool) ResourcePoolManager.getManagerInstance().getResourcePool("OnlineOrders_OnlineOrdersModule");

            

            pool.setUserData(info);

          }

          session.setAttribute("CSSURL", "/webapp/cabo/images/cabo_styles.css");

          session.setAttribute("ImageBase", "/webapp/jsimages");

      
      out.print(__jsp_StaticText.text[1]);

      out.flush();

    }
    catch( Exception e) {
      try {
        if (out != null) out.clear();
      }
      catch( Exception clearException) {
      }
      pageContext.handlePageException( e);
    }
    finally {
      if (out != null) out.close();
      factory.releasePageContext(pageContext);
    }

  }
  private static class __jsp_StaticText {
    private static final char text[][]=new char[2][];
    static {
      text[0] = 
      "\r\n<HTML>\r\n<HEAD>\r\n<META NAME=\"GENERATOR\" CONTENT=\"Oracle JDeveloper\">\r\n<title>Business Components JSP Application</title>\r\n</HEAD>\r\n".toCharArray();
      text[1] = 
      "\r\n<FRAMESET ROWS=\"90,*\" FRAMESPACING=\"0\" FRAMEBORDER=\"0\" border=\"false\" >\r\n   <FRAME SRC=\"title.html\" NAME=\"titleFrame\"  FRAMEBORDER=\"0\" MARGINHEIGHT=1 MARGINWIDTH=1 FRAMEBORDER=\"0\" FRAMESPACING=\"0\" SCROLLING=\"No\">\r\n   <FRAME SRC=\"contents.jsp\" name=\"navFrame\">\r\n</FRAMESET> \r\n</HTML>\r\n ".toCharArray();
    }
  }
}
