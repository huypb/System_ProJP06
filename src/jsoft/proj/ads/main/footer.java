package jsoft.proj.ads.main;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

@SuppressWarnings("serial")
public class footer extends HttpServlet {
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

		out.print("<div class=\"clr\"></div>	");

		out.print("<div id=\"footer\">");
		out.print("This CMS is build by JP06 group.<br />");
		out.print("Develop on J2EE technology . @2013");
		out.print("</div>");
		out.print("</div>");
		out.print("</body>");
		out.print("</html>");

		out.close();

	}

	// Clean up resources
	@Override
	public void destroy() {
	}
}
