package jsoft.proj.ads.user;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import jsoft.proj.*;
import jsoft.proj.objects.*;

@SuppressWarnings("serial")
public class UserLogin extends HttpServlet {
	// Khai bao hang kieu noi dung xuat ve phia trinh duyet
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";

	// Initialize global variables
	@Override
	public void init() throws ServletException {
	}

	// Process the HTTP Get request
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// xac dinh kieu noi dung cho trinh duyet hien thi
		response.setContentType(CONTENT_TYPE);

		// Tao doi tuong thuc thi xuat noi dung ve trinh duyet
		PrintWriter out = response.getWriter();

		out.print("<html>");
		out.print("<head>");
		out.print("<title>\u0110\u0103ng nh\u1EADp</title>");
		out.print("<link href=\"/adv/adcss/login.css\" rel=\"stylesheet\" type=\"text/css\" />");
		out.print("<script language=\"JavaScript\" src=\"/adv/adjs/login.js\" ></script>");
		out.print("</head>");
		out.print("");
		out.print("<body>");
		out.print("<div class=\"loginView\">");
		out.print("<form name=\"frmLogin\" action=\"\" method=\"POST\">");
		out.print("<table cellspacing=\"0\">");
		out.print("<tr>");
		out.print("<th colspan=2>\u0110\u0103ng nh\u1EADp</th>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td class=\"lc\">T�n \u0111\u0103ng nh\u1EADp</td>");
		out.print("<td><input type=\"text\" size=\"25\" name=\"txtUserName\" /></td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td class=\"lc\">M\u1EADt kh\u1EA9u</td>");
		out.print("<td><input type=\"password\" size=\"25\" name=\"txtUserPass\" /></td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td colspan=2 align=\"center\">");
		out.print("<input type=\"button\" value=\"\u0110\u0103ng nh\u1EADp\" onClick=\"login(this.form)\" />");
		out.print("</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td class=\"lc\">");
		out.print("<input type=\"checkbox\" id=\"chkSave\" />");
		out.print("</td>");
		out.print("<td>");
		out.print("<label for=\"chkSave\">");
		out.print("L\u01B0u th�ng tin \u0111\u0103ng nh\u1EADp tr�n m�y n�y?");
		out.print("</label>");
		out.print("</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td colspan=2 align=\"right\">");
		out.print("<a href=\"#\">English</a>");
		out.print("</td>");
		out.print("</tr>");
		out.print("</table>");
		out.print("</form>");
		out.print("</div>");
		out.print("</body>");
		out.print("");
		out.print("</html>");

		// dong luong xuat lai
		out.close();
	}

	// Process the HTTP Post request
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// xu ly du lieu dang nhap

		// lay du lieu
		String username = request.getParameter("txtUserName");
		String userpass = request.getParameter("txtUserPass");

		if (username != null && userpass != null) {
			username = username.trim();
			userpass = userpass.trim();

			if (!username.equalsIgnoreCase("") && !userpass.equalsIgnoreCase("")) {

				// tham chieu ngu canh van hanh cua he thong
				ServletContext application = getServletConfig().getServletContext();

				// thong qua do tim bo quan ly ket noi
				ConnectionPool cp = (ConnectionPool) application.getAttribute("c_pool");

				// Tao doi tuong thuc thi chuc nang
				UserControl uc = new UserControl(cp);

				// thiet lap bo quan ly cho ung dung
				if (cp == null) {
					application.setAttribute("c_pool", uc.getConnectionPool());
				}

				// thuc hien dang nhap
				UserItem user = uc.getUserItem(username, userpass);

				// tra ve ket noi
				uc.releaseConnection();

				// kiem tra thanh cong hay k
				if (user != null) {
					// tao phien lam viec moi
					HttpSession session = request.getSession(true);

					// dua thong tin dang nhap vao phien lam viec
					session.setAttribute("userLogined", user);

					// chuyen ve giao dien chinh
					response.sendRedirect("/adv/view");

				} else {
					response.sendRedirect("/adv/user/login?err=notok&at=user&act=login");
				}

			} else {
				response.sendRedirect("/adv/user/login?err=mis&at=user&act=login");
			}

		} else {
			// doGet(request, response); ----> khong dung
			response.sendRedirect("/adv/user/login?err=incor&at=user&act=login");
		}

	}

	// Clean up resources
	@Override
	public void destroy() {
	}
}
