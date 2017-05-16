package jsoft.proj.ads.user;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import jsoft.proj.*;
import jsoft.proj.objects.*;
import jsoft.proj.library.*;

@SuppressWarnings("serial")
public class UserDel extends HttpServlet {
	@SuppressWarnings("unused")
	private static final String CONTENT_TYPE = "text/html";

	// Initialize global variables
	@Override
	public void init() throws ServletException {
	}

	// Process the HTTP Get request
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserItem user = (UserItem) request.getSession().getAttribute("userLogined");

		// Lay id
		int id = Utilities.getIntParam(request, "id");
		if (id > 0 && id != user.getUser_id()) {
			ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("c_pool");

			UserControl uc = new UserControl(cp);
			if (cp == null) {
				getServletContext().setAttribute("c_pool", uc.getConnectionPool());
			}

			UserItem dItem = new UserItem();
			dItem.setUser_id(id);

			boolean result = uc.delUser(dItem);

			uc.releaseConnection();

			if (result) {
				response.sendRedirect("/adv/user/view");
			} else {
				response.sendRedirect("/adv/user/view?err=notok");
			}

		} else {
			response.sendRedirect("/adv/user/view");
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
