package jsoft.j2se;

import java.io.*;

import javax.servlet.*;

public class MyServlet1 implements Servlet {
  public MyServlet1() {
  }

  /**
   * destroy
   *
   * @todo Implement this javax.servlet.Servlet method
   */
  @Override
public void destroy() {
  }

  /**
   * getServletConfig
   *
   * @return ServletConfig
   * @todo Implement this javax.servlet.Servlet method
   */
  @Override
public ServletConfig getServletConfig() {
    return null;
  }

  /**
   * getServletInfo
   *
   * @return String
   * @todo Implement this javax.servlet.Servlet method
   */
  @Override
public String getServletInfo() {
    return "";
  }

  /**
   * init
   *
   * @param servletConfig ServletConfig
   * @throws ServletException
   * @todo Implement this javax.servlet.Servlet method
   */
  @Override
public void init(ServletConfig servletConfig) throws ServletException {
  }

  /**
   * service
   *
   * @param servletRequest ServletRequest
   * @param servletResponse ServletResponse
   * @throws ServletException
   * @throws IOException
   * @todo Implement this javax.servlet.Servlet method
   */
  @Override
public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

  }

  public static void main(String[] args) {
  }
}
