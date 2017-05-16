package jsoft.proj.ads.article.category;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import jsoft.proj.objects.*;
import jsoft.proj.*;

@SuppressWarnings("serial")
public class CategoryView extends HttpServlet {
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

		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("c_pool");
		CategoryControl cc = new CategoryControl(cp);
		if (cp == null) {
			getServletContext().setAttribute("c_pool", cc.getConnectionPool());
		}

		// lay du lieu
		String viewCategories = cc.viewCategorys(null, 1, (byte) 20);

		// tra ve du lieu ket noi
		cc.releaseConnection();

		out.print("<div class=\"view\">");
		out.print("<table cellspacing =0>");
		out.print("<tr>");
		out.print("<th>STT</th>");
		out.print("<th>Tên th\u1EC3 lo\u1EA1i</th>");
		out.print("<th>Ghi chú</th>");
		out.print("<th>Tên chuyên m\u1EE5c</th>");

		out.print("<th colspan = 2>Th\u1EF1c hi\u1EC7n</th>");
		out.print("</tr>");

		out.print(viewCategories);
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
