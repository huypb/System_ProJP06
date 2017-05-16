package jsoft.proj.ads.main;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

@SuppressWarnings("serial")
public class menu extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";

	// Initialize global variables
	@Override
	public void init() throws ServletException {
	}

	// Process the HTTP Get request
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		out.print("<div class=\"menu\">");
		out.print("<a href=\"/adv/view\"><h3>Th\u1ED1ng kê</h3></a>");
		out.print("<a href=\"/adv/user/view\"><h3>Qu\u1EA3n lý Ng\u01B0\u1EDDi s\u1EED d\u1EE5ng</h3></a>");
		out.print("<a href=\"/adv/section/view\"><h3>Qu\u1EA3n lý Chuyên m\u1EE5c</h3></a>");
		out.print("<a href=\"/adv/category/view\"><h3>Qu\u1EA3n lý Th\u1EC3 lo\u1EA1i</h3></a>");
		out.print("<a href=\"/adv/article/view\"><h3>Qu\u1EA3n lý Tin bài</h3></a>");
		out.print("<a href=\"#\"><h3>Qu\u1EA3n lý H\u1EC7 s\u1EA3n ph\u1EA9m</h3></a>");
		out.print("<a href=\"#\"><h3>Qu\u1EA3n lý Nhóm s\u1EA3n ph\u1EA9m</h3></a>");
		out.print("<a href=\"#\"><h3>Qu\u1EA3n lý Lo\u1EA1i s\u1EA3n ph\u1EA9m</h3></a>");
		out.print("<a href=\"#\"><h3>Qu\u1EA3n lý S\u1EA3n ph\u1EA9m</h3></a>");
		out.print("<a href=\"#\"><h3>Qu\u1EA3n lý Hóa \u0111\u01A1n</h3></a>");
		out.print("<a href=\"#\"><h3>Qu\u1EA3n lý Khách hàng</h3></a>");
		out.print("<a href=\"#\"><h3>Qu\u1EA3n lý ...</h3></a>");
		out.print("</div><!--end menu-->");

	}

	// Clean up resources
	@Override
	public void destroy() {
	}
}
