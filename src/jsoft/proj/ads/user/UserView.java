package jsoft.proj.ads.user;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import jsoft.proj.objects.*;
import jsoft.proj.*;

@SuppressWarnings("serial")
public class UserView extends HttpServlet {
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
			view(request, response, user);
		} else {
			response.sendRedirect("/adv/user/login");
		}

	}

	private void view(HttpServletRequest request, HttpServletResponse response, UserItem userLogined)
			throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();

		// ghep header vao view
		RequestDispatcher h = request.getRequestDispatcher("/header");
		if (h != null) {
			h.include(request, response);
		}

		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("c_pool");
		UserControl uc = new UserControl(cp);
		if (cp == null) {
			getServletContext().setAttribute("c_pool", uc.getConnectionPool());
		}

		// lay du lieu
		String viewUsers = uc.viewUser(null, userLogined, 1, (byte) 20);

		// tra ve du lieu ket noi
		uc.releaseConnection();

		out.print("<div class=\"view\">");
		out.print("<table cellspacing =0>");

		out.print("<tr><td colspan=9 class=\"action-row\" >");
		out.print("<a href=\"/adv/user/ae\" ><h3>Th�m m\u1EDBi </h3></a>");
		out.print("</td></tr>");

		out.print("<tr>");
		out.print("<th>STT</th>");
		out.print("<th>T�n \u0111\u0103ng nh\u1EADp</th>");
		out.print("<th>T�n \u0111\u1EA7y \u0111\u1EE7</th>");
		out.print("<th>\u0110\u1ECBa ch\u1EC9</th>");
		out.print("<th>H\u1ED9p th\u01B0</th>");
		out.print("<th>Ng�y sinh</th>");
		out.print("<th>\u0110i\u1EC7n tho\u1EA1i</th>");
		out.print("<th colspan = 2>Th\u1EF1c hi\u1EC7n</th>");
		out.print("</tr>");

		out.print(viewUsers);
		out.print("</table>");
		out.print("</div>");

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
