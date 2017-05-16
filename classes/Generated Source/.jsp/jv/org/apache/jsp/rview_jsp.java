package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class rview_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n<div class=\"rview\">\r\n  <div class=\"title1\" >\r\n    <a href=\"#\"><h3>Tin mới nhất</h3></a>\r\n  </div>\r\n\r\n  ");

      String newest = (String)session.getAttribute("viewnewest");
      out.print(newest);

  
      out.write("\r\n\r\n  <!--form slide show-->\r\n  <div id=\"slider-marquee\" >\r\n    <!--hiệu ứng chạy từ dưới lên, delay 50s, chạy 2px/lần , di chuột vào thì dừng, bỏ chuột ra thì chạy-->\r\n    <marquee direction=\"up\" scrolldelay=\"50\" scrollamount=\"2\" onMouseOver=\"stop()\" onMouseOut=\"start()\">\r\n      ");

      String marquee = (String)session.getAttribute("marquee");
      out.print(marquee);
      
      out.write("\r\n    </marquee>\r\n  </div>\r\n</div>\r\n");
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
