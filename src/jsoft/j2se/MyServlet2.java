package jsoft.j2se;

import java.io.*;

import javax.servlet.*;

@SuppressWarnings("serial")
public class MyServlet2 extends GenericServlet {
	public MyServlet2() {
	}

	/**
	 * service
	 *
	 * @param servletRequest
	 *            ServletRequest
	 * @param servletResponse
	 *            ServletResponse
	 * @throws ServletException
	 * @throws IOException
	 * @todo Implement this javax.servlet.Servlet method
	 */
	@Override
	public void service(ServletRequest servletRequest, ServletResponse servletResponse)
			throws ServletException, IOException {
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		MyServlet2 myservlet2 = new MyServlet2();
	}
}
