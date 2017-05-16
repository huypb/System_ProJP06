package jsoft.proj.ads.user;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

@SuppressWarnings("serial")
public class UserLogout extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html";

	// Initialize global variables
	@Override
	public void init() throws ServletException {
	}

	// Process the HTTP Get request
	@SuppressWarnings("unused")
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		// tham chieu phien lam viec
		HttpSession session = request.getSession();

		// huy du lieu dang nhap
		session.setAttribute("userLogined", null);

		// huy du lieu lien quan toi phien lam viec
		session.removeAttribute("userlogined");

		// tro ve giao dien dang nhap
		response.sendRedirect("/adv/user/login");
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