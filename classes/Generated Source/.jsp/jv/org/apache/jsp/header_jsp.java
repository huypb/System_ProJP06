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

      out.write("\r\n\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "data.jsp", out, true);
      out.write("\r\n\r\n<html>\r\n<head>\r\n<title> Bản thiểt kế cho CDHlogistics</title>\r\n<link href=\"/jv/css/layout.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n<script language=\"JavaScript\" src=\"/jv/js/gui.js\"  type=\"\"></script>\r\n<script language=\"JavaScript\" src=\"/jv/js/tooltip.js\"  type=\"\"></script>\r\n</head>\r\n\r\n<body onLoad=\"setFirstTime(document.frmsearch)\"> <!--gọi javascript vào đúng form -->\r\n<div class=\"mainview\">\r\n  <!--form tìm kiếm-->\r\n  <div id=\"search\">\r\n    <form name=\"frmsearch\" action=\"\" method=\"POST\">\r\n    <b>Tìm kiếm</b>                                 <!-- bắt sự kiện click chuột-->\r\n    <input type=\"text\" size=\"20\" name=\"txtKeyword\" onClick=\"setKeyword(this.form, true)\" onBlur=\"setKeyword(this.form, false)\" />\r\n    <input type=\"button\" value=\">>\" onClick=\"checkKeyword(this.form)\"/>\r\n    </form>\r\n  </div>\r\n  <!-- form đăng nhập-->\r\n  <div id=\"acc\" >\r\n    <a href=\"#\">Đăng nhập</a>&nbsp;&nbsp;|&nbsp;&nbsp;\r\n    <a href=\"#\">Đăng ký</a>\r\n  </div>\r\n\r\n  <!--xóa lên trên và sang trái-->\r\n  <div class=\"clr\"></div>\r\n\r\n  <div class=\"header\"></div>\r\n");
      out.write("\r\n  <!--form menu-->\r\n  <div class=\"menu\">\r\n    <a href=\"/jv/\"><h3>Trang chủ</h3></a>\r\n    <a href=\"/jv/Gioi-thieu/\"><h3>Giới thiệu</h3></a>\r\n    <a href=\"/jv/San-pham/\"><h3>Sản phẩm</h3></a>\r\n    <a href=\"/jv/Khach-hang/\"><h3>Khách hàng</h3></a>\r\n    <a href=\"/jv/Tin-tuc/\"><h3>Tin tức</h3></a>\r\n    <a href=\"/jv/Ho-tro/\"><h3>Hỗ trợ</h3></a>\r\n    <a href=\"/jv/Dich-vu/\"><h3>Dịch vụ</h3></a>\r\n    <a href=\"/jv/Lien-he/\"><h3>Liên hệ</h3></a>\r\n  </div>\r\n");
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
