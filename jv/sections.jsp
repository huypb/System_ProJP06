<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
  String section_news = (String) session.getAttribute("section_news");
  out.print(section_news);

  String section_services = (String) session.getAttribute("section_services");
  out.print(section_services);

  String section_hotels = (String) session.getAttribute("section_hotels");
  out.print(section_hotels);
%>
