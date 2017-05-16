package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class links_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<div class=\"links\">\n");
      out.write("\n");
      out.write("  <div class=\"slider-wrapper theme-default\">\n");
      out.write("    <div id=\"slider1\" class=\"nivoSlider\">\n");
      out.write("      <a href=\"#\"><img src=\"/jv/pictures/intro10.jpg\" alt=\"\" title=\"Ốp bếp với sản phẩm gạch viền, gạch điểm thân quen và độc đáo.\" /></a>\n");
      out.write("      <a href=\"#\"><img src=\"/jv/pictures/intro9.jpg\" alt=\"\" title=\"Lát nền cho những không gian phòng chờ lớn\" /></a>\n");
      out.write("      <a href=\"#\"><img src=\"/jv/pictures/intro8.jpg\" alt=\"\" title=\"Phòng khách sang trọng, thoáng đãng\" /></a>\n");
      out.write("      <a href=\"#\"><img src=\"/jv/pictures/intro7.jpg\" alt=\"\" title=\"Ốp lát tạo sự sang trọng cho phòng tắm của bạn\" /></a>\n");
      out.write("      <a href=\"#\"><img src=\"/jv/pictures/intro6.jpg\" alt=\"\" title=\"Lát nền sân vườn, nơi bạn tận hưởng cảm giác thiên nhiên thực sự\" /></a>\n");
      out.write("      <a href=\"#\"><img src=\"/jv/pictures/intro5.jpg\" alt=\"\" title=\"Lát nền cho những không gian ngoài trời\" /></a>\n");
      out.write("      <a href=\"#\"><img src=\"/jv/pictures/intro4.jpg\" alt=\"\" title=\"Lát nền có gam màu đi cùng với nội thất\" /></a>\n");
      out.write("      <a href=\"#\"><img src=\"/jv/pictures/intro3.jpg\" alt=\"\" title=\"Lát nền phòng ngủ với những sắc màu ấm cúng\"   data-transition=\"slideInLeft\"/></a>\n");
      out.write("      <a href=\"#\"><img src=\"/jv/pictures/intro2.jpg\" alt=\"\" title=\"Lát nền cho những không gian phòng chờ lớn\" /></a>\n");
      out.write("    </div>\n");
      out.write("  </div><!--End .slider-wrapper-->\n");
      out.write("\n");
      out.write("  <script language=\"javascript\" type=\"text/javascript\" src=\"js/jquery-1.7.1.min.js\"></script>\n");
      out.write("  <script language=\"javascript\" type=\"text/javascript\" src=\"js/jquery.nivo.slider.pack.js\"></script>\n");
      out.write("  <script type=\"text/javascript\">\n");
      out.write("  $(window).load(function() {\n");
      out.write("    $('#slider1').nivoSlider();\n");
      out.write("  });\n");
      out.write("  </script>\n");
      out.write("  </div>\n");
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
