package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class rcontent_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n\r\n<div class=\"rcontent\">\r\n  <div id=\"video\"> <!--chèn video từ youtube-->\r\n    <iframe width=\"250\" height=\"250\" src=\"http://www.youtube.com/embed/cxiDmCr3h7Q?modestbranding=1\"\r\n    frameborder=\"0\" allowfullscreen >\r\n    </iframe>\r\n  </div>\r\n\r\n  <div class=\"title1\">\r\n    <a href=\"#\"><h3>Hỗ trợ trực tuyến</h3></a>\r\n  </div>\r\n\r\n  <div id=\"support\">\r\n    <div class=\"sitem\"> <!-- hỗ trợ từ yahoo-->\r\n      <a class=\"yahoo\" href=\"ymsgr:sendIM?love.exe_9x\">\r\n        <img src=\"http://opi.yahoo.com/online?u=love.exe_9x&m=g&t=14\" alt=\"\"/>\r\n      </a>\r\n\r\n      <a class=\"yahoo\" href=\"ymsgr:sendIM?love.exe_9x\">\r\n      Hỗ trợ kỹ thuật\r\n      </a>\r\n      0123456789 <br />\r\n      huy1992.tb@gmail.com\r\n    </div>\r\n\r\n    <div class=\"sitem\"> <!-- hỗ trợ từ yahoo-->\r\n      <a class=\"yahoo\" href=\"ymsgr:sendIM?love.exe_9x\">\r\n        <img src=\"http://opi.yahoo.com/online?u=love.exe_9x&m=g&t=14\" alt=\"\"/>\r\n      </a>\r\n\r\n      <a class=\"yahoo\" href=\"ymsgr:sendIM?love.exe_9x\">\r\n      Hỗ trợ kỹ thuật\r\n      </a>\r\n      0123456789 <br />\r\n");
      out.write("      huy1992.tb@gmail.com\r\n    </div>\r\n\r\n    <div class=\"sitem\"> <!-- hỗ trợ từ yahoo-->\r\n      <a class=\"yahoo\" href=\"ymsgr:sendIM?boy_thai_ninh_9x\">\r\n        <img src=\"http://opi.yahoo.com/online?u=boy_thai_ninh_9x&m=g&t=14\" alt=\"\"/>\r\n      </a>\r\n\r\n      <a class=\"yahoo\" href=\"ymsgr:sendIM?boy_thai_ninh_9x\">\r\n      Hỗ trợ kỹ thuật\r\n      </a>\r\n      0123456789 <br />\r\n      huy1992.tb@gmail.com\r\n    </div>\r\n  </div>\r\n\r\n  <div class=\"title1\" >\r\n    <a href=\"#\">\r\n      <h3>Quảng cáo</h3>\r\n    </a>\r\n  </div>\r\n\r\n  <div id=\"rcontent_advs\">\r\n\r\n  </div>\r\n</div>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
