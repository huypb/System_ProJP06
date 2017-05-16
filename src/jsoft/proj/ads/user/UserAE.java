package jsoft.proj.ads.user;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import jsoft.proj.objects.*;
import jsoft.proj.*;

import jsoft.proj.library.*;

@SuppressWarnings("serial")
public class UserAE extends HttpServlet {
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

		int id = Utilities.getIntParam(request, "id");
		UserItem mItem = null;

		if (id > 0) {

			ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("c_pool");
			UserControl uc = new UserControl(cp);
			if (cp == null) {
				getServletContext().setAttribute("c_pool", uc.getConnectionPool());
			}

			// lay du lieu
			mItem = uc.getUserItem(id);

			// tra ve du lieu ket noi
			uc.releaseConnection();

		}

		String username = "", useremail = "";
		String fullname = "", alias = "", birthday = "", address = "";
		String dis = "";

		if (mItem != null) {
			username = mItem.getUser_name();
			useremail = mItem.getUser_email();

			fullname = mItem.getUser_fullname();
			birthday = mItem.getUser_birthday();
			alias = mItem.getUser_alias();
			address = mItem.getUser_address();

			dis = "readonly style=\"background: #eee;\" ";
		}

		out.print("<div class=\"view\">");

		out.print("<form name=\"frmUser\" action=\"\" method=\"POST\">");
		out.print("<table cellspacing=\"0\">");
		out.print("<tr>");
		out.print("<th colspan=\"2\">Qu\u1EA3n lý Ng\u01B0\u1EDDi s\u1EED d\u1EE5ng</th>");
		out.print("</tr>");

		out.print("<tr>");
		out.print("<td class=\"lc\">Tên \u0111\u0103ng nh\u1EADp</td>");
		out.print("<td><input type=\"text\" size=\"25\" name=\"txtUserName\" value=\"" + username + "\" " + dis
				+ " /></td>");
		out.print("</tr>");

		out.print("<tr>");
		out.print("<td class=\"lc\">M\u1EADt kh\u1EA9u</td>");
		out.print("<td><input type=\"password\" size=\"25\" name=\"txtUserPass\"/></td>");
		out.print("</tr>");

		out.print("<tr>");
		out.print("<td class=\"lc\">H\u1ED9p th\u01B0</td>");
		out.print("<td><input type=\"text\" size=\"25\" name=\"txtUserEmail\" value=\"" + useremail + "\"/></td>");
		out.print("</tr>");

		out.print("<tr>");
		out.print("<td class=\"lc\">Quy\u1EC1n th\u1EF1c thi</td>");
		out.print("<td>");
		out.print("<script language=\"JavaScript\">");
		out.print("generatePermission();");
		out.print("</script>");
		out.print("</td>");
		out.print("</tr>");

		out.print("<tr>");
		out.print("<td class=\"lc\">Vai trò Quy\u1EC1n tác gi\u1EA3</td>");
		out.print("<td>");
		out.print("<table cellspacing=\"0\">");
		out.print("<script language=\"JavaScript\">");
		out.print("generateRoles();	");
		out.print("</script>");
		out.print("</table>							");
		out.print("</td>");
		out.print("</tr>");

		out.print("<tr>");
		out.print("<th colspan=\"2\">Thông tin chi ti\u1EBFt</th>");
		out.print("</tr>");
		out.print("					");
		out.print("<tr>");
		out.print("<td class=\"lc\">Tên \u0111\u1EA7y \u0111\u1EE7</td>");
		out.print("<td><input type=\"text\" size=\"25\" name=\"txtFullName\" value=\"" + fullname + "\" /></td>");
		out.print("</tr>");

		out.print("<tr>");
		out.print("<td class=\"lc\">Bí danh</td>");
		out.print("<td><input type=\"text\" size=\"25\" name=\"txtAlias\" value=\"" + alias + "\" /></td>");
		out.print("</tr>");

		out.print("<tr>");
		out.print("<td class=\"lc\">Ngày sinh</td>");
		out.print("<td><input type=\"text\" size=\"25\" name=\"txtBirthday\" value=\"" + birthday + "\" /></td>");
		out.print("</tr>");

		out.print("<tr>");
		out.print("<td class=\"lc\">\u0110\u1ECBa ch\u1EC9</td>");
		out.print("<td><input type=\"text\" size=\"50\" name=\"txtAddress\" value=\"" + address + "\" /></td>");
		out.print("</tr>");

		out.print("<tr>");
		out.print("<td class=\"lc\">.....</td>");
		out.print("<td>....</td>");
		out.print("</tr>");

		out.print("<tr>");
		out.print("<td class=\"lc\">Ghi chú</td>");
		out.print("<td>");
		out.print("<textarea rows=\"15\" cols=\"80\"></textarea>");
		out.print("</td>");
		out.print("</tr>");

		out.print("<tr>");
		out.print("<td colspan=\"2\" align=\"center\">");
		out.print("<input type=\"button\" value=\"L\u01B0u\" onClick=\"saveUser(this.form)\"/>");
		out.print("<input type=\"reset\" value=\"nh\u1EADp l\u1EA1i\" onClick=\"resetForm(this.form)\" />");
		out.print("</td>");
		out.print("</tr>");
		out.print("</table>");

		if (id > 0) {
			// Truyen id cho doPost de xu ly
			out.print("<input type=\"hidden\" name=\"id\" value=\"" + id + "\" />");
		}

		out.print("</form>");

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
		// Thiet lap che do lay ky tu
		request.setCharacterEncoding("UTF-8");

		// Lay du lieu
		int id = Utilities.getIntParam(request, "id"); // Lay id tu doGet

		String username = request.getParameter("txtUserName");
		String userpass = request.getParameter("txtUserPass");
		String useremail = request.getParameter("txtUserEmail");

		if (username != null && userpass != null && useremail != null) {
			username = username.trim();
			userpass = userpass.trim();
			useremail = useremail.trim();

			if (!username.equalsIgnoreCase("") && !userpass.equalsIgnoreCase("") && !useremail.equalsIgnoreCase("")) {

				// Lay tiep thong tin chi tiet
				String fullname = request.getParameter("txtFullName");
				String alias = request.getParameter("txtAlias");
				String birthday = request.getParameter("txtBirthday");
				String address = request.getParameter("txtAddress");

				ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("c_pool");
				UserControl uc = new UserControl(cp);
				if (cp == null) {
					getServletContext().setAttribute("c_pool", uc.getConnectionPool());
				}
				// Tao doi tuong de them
				UserItem nItem = new UserItem();
				nItem.setUser_name(username);
				nItem.setUser_pass(userpass);
				nItem.setUser_email(useremail);

				nItem.setUser_fullname(Utilities.encode(fullname));
				nItem.setUser_alias(alias);
				nItem.setUser_birthday(birthday);
				nItem.setUser_address(Utilities.encode(address));

				boolean result;

				if (id > 0) {
					// Thuc hien sua
					nItem.setUser_id(id);
					result = uc.editUser(nItem);
				} else {
					// Thuc hien them moi
					result = uc.addUser(nItem);
				}

				uc.releaseConnection();

				if (result) {
					response.sendRedirect("/adv/user/view");
				} else {
					response.sendRedirect("/adv/user/ae?err=notok");
				}

			} else {
				response.sendRedirect("/adv/user/ae?err=mis");
			}

		} else {
			response.sendRedirect("/adv/user.ae?err=incor");
		}
	}

	// Clean up resources
	@Override
	public void destroy() {
	}
}
