
<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!--ghep header vao index-->
<jsp:include flush="true" page="../header.jsp"></jsp:include>
<!--form nội dung-->
<div class="content">
  <div class="view">
  <%
     int aid = jsoft.proj.library.Utilities.getIntParam(request,"aid");
     if(aid>0){
       String view = (String)session.getAttribute("viewDetail");
       out.print(view);
     }else{
       String newsList = (String)session.getAttribute("newsList");
       out.print(newsList);
     }
  %>
  </div>
  <jsp:include flush="true" page="../rview.jsp"></jsp:include>
  <jsp:include flush="true" page="../links.jsp"></jsp:include>
</div>
<jsp:include flush="true" page="../rcontent.jsp"></jsp:include>
<jsp:include flush="true" page="../footer.jsp"></jsp:include>
