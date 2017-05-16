package jsoft.proj.ads.main;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import jsoft.proj.objects.*;

@SuppressWarnings("serial")
public class header extends HttpServlet {
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

		UserItem user = (UserItem) request.getSession().getAttribute("userLogined");

		out.print("<html>");
		out.print("<head>");
		out.print("<title>Qu\u1EA3n tr\u1ECB h\u1EC7 th\u1ED1ng</title>");
		out.print("<link href=\"/adv/adcss/layout.css\" rel=\"stylesheet\" type=\"text/css\"  />");
		out.print("<script language=\"JavaScript\" src=\"/adv/adjs/user.js\" ></script>");
		out.print("</head>");

		out.print("<body>");
		out.print("<div id=\"main\">");
		out.print("<div id=\"logo\"></div>");

		out.print("<div id=\"acc\">");
		out.print("<h3>Quy\u1EC1n qu\u1EA3n tr\u1ECB</h3>");
		out.print("T�n \u0111\u0103ng nh\u1EADp: " + user.getUser_name() + " (" + user.getUser_fullname()
				+ ") &nbsp;&nbsp;|&nbsp;&nbsp;");
		out.print("<a href=\"/adv/user/logout\">Tho�t</a>");
		out.print("</div>");

		out.print("<div class=\"clr\"></div>");

		// ghep menu vao header
		RequestDispatcher m = request.getRequestDispatcher("/menu");
		if (m != null) {
			m.include(request, response);
		}
	}

	// Clean up resources
	@Override
	public void destroy() {
	}
}