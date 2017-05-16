package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class footer_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("<div class=\"clr\"></div>\n");
      out.write("\n");
      out.write("<div class=\"footer\">\n");
      out.write("  <div id=\"menu-bottom\" >\n");
      out.write("    <a href=\"#\">Trang chủ</a>&nbsp;|&nbsp;\n");
      out.write("    <a href=\"#\">Giới thiệu</a>&nbsp;|&nbsp;\n");
      out.write("    <a href=\"#\">Tin tức</a>&nbsp;|&nbsp;\n");
      out.write("    <a href=\"#\">sản phẩm</a>&nbsp;|&nbsp;\n");
      out.write("    <a href=\"#\">Hỗ trợ</a>&nbsp;|&nbsp;\n");
      out.write("    <a href=\"#\">Liên hệ</a>\n");
      out.write("  </div>\n");
      out.write("  This website is built by JP06 group.<br />\n");
      out.write("  Develop on J2EE technology.<br />\n");
      out.write("  copyright @2012.\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
