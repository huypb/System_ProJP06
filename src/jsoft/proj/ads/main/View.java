package jsoft.proj.ads.main;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import jsoft.proj.objects.*;

@SuppressWarnings("serial")
public class View extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";

	// Initialize global variables
	@Override
	public void init() throws ServletException {
	}

	// Process the HTTP Get request
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// tham chieu phien lam viec
		HttpSession session = request.getSession();

		// kiem tra thong tin dang nhap
		UserItem user = (UserItem) session.getAttribute("userLogined");

		if (user != null) {
			view(request, response);
		} else {
			response.sendRedirect("/adv/user/login");
		}

	}

	private void view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();

		// ghep header vao view
		RequestDispatcher h = request.getRequestDispatcher("/header");
		if (h != null) {
			h.include(request, response);
		}

		out.print("<div class=\"view\">");
		out.print("<!--Noi dung thay doi-->");
		out.print("</div><!--end view-->");

		// ghep footer vao view
		RequestDispatcher f = request.getRequestDispatcher("/footer");
		if (f != null) {
			f.include(request, response);
		}

	}

	// Process the HTTP Post request
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	// Clean up resources
	@Override
	public void destroy() {
	}
}
