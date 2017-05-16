package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "data.jsp", out, true);
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title> Bản thiểt kế cho CDHlogistics</title>\r\n");
      out.write("<link href=\"/jv/css/layout.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<script language=\"JavaScript\" src=\"/jv/js/gui.js\"  type=\"\"></script>\r\n");
      out.write("<script language=\"JavaScript\" src=\"/jv/js/tooltip.js\"  type=\"\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body onLoad=\"setFirstTime(document.frmsearch)\"> <!--gọi javascript vào đúng form -->\r\n");
      out.write("<div class=\"mainview\">\r\n");
      out.write("  <!--form tìm kiếm-->\r\n");
      out.write("  <div id=\"search\">\r\n");
      out.write("    <form name=\"frmsearch\" action=\"\" method=\"POST\">\r\n");
      out.write("    <b>Tìm kiếm</b>                                 <!-- bắt sự kiện click chuột-->\r\n");
      out.write("    <input type=\"text\" size=\"20\" name=\"txtKeyword\" onClick=\"setKeyword(this.form, true)\" onBlur=\"setKeyword(this.form, false)\" />\r\n");
      out.write("    <input type=\"button\" value=\">>\" onClick=\"checkKeyword(this.form)\"/>\r\n");
      out.write("    </form>\r\n");
      out.write("  </div>\r\n");
      out.write("  <!-- form đăng nhập-->\r\n");
      out.write("  <div id=\"acc\" >\r\n");
      out.write("    <a href=\"#\">Đăng nhập</a>&nbsp;&nbsp;|&nbsp;&nbsp;\r\n");
      out.write("    <a href=\"#\">Đăng ký</a>\r\n");
      out.write("  </div>\r\n");
      out.write("\r\n");
      out.write("  <!--xóa lên trên và sang trái-->\r\n");
      out.write("  <div class=\"clr\"></div>\r\n");
      out.write("\r\n");
      out.write("  <div class=\"header\"></div>\r\n");
      out.write("\r\n");
      out.write("  <!--form menu-->\r\n");
      out.write("  <div class=\"menu\">\r\n");
      out.write("    <a href=\"/jv/\"><h3>Trang chủ</h3></a>\r\n");
      out.write("    <a href=\"/jv/Gioi-thieu/\"><h3>Giới thiệu</h3></a>\r\n");
      out.write("    <a href=\"/jv/San-pham/\"><h3>Sản phẩm</h3></a>\r\n");
      out.write("    <a href=\"/jv/Khach-hang/\"><h3>Khách hàng</h3></a>\r\n");
      out.write("    <a href=\"/jv/Tin-tuc/\"><h3>Tin tức</h3></a>\r\n");
      out.write("    <a href=\"/jv/Ho-tro/\"><h3>Hỗ trợ</h3></a>\r\n");
      out.write("    <a href=\"/jv/Dich-vu/\"><h3>Dịch vụ</h3></a>\r\n");
      out.write("    <a href=\"/jv/Lien-he/\"><h3>Liên hệ</h3></a>\r\n");
      out.write("  </div>\r\n");
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
