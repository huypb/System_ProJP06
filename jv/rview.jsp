<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<div class="rview">
  <div class="title1" >
    <a href="#"><h3>Tin mới nhất</h3></a>
  </div>

  <%
      String newest = (String)session.getAttribute("viewnewest");
      out.print(newest);

  %>

  <!--form slide show-->
  <div id="slider-marquee" >
    <!--hiệu ứng chạy từ dưới lên, delay 50s, chạy 2px/lần , di chuột vào thì dừng, bỏ chuột ra thì chạy-->
    <marquee direction="up" scrolldelay="50" scrollamount="2" onMouseOver="stop()" onMouseOut="start()">
      <%
      String marquee = (String)session.getAttribute("marquee");
      out.print(marquee);
      %>
    </marquee>
  </div>
</div>
