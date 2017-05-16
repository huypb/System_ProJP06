<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<%
   String viewfocus = (String)session.getAttribute("focus");
   out.print(viewfocus);

%>
