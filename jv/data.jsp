<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="jsoft.proj.objects.*, jsoft.proj.*"%>
<%@page import="jsoft.proj.gui.article.*"%>
<%
  //Lay ve duong dan
  String uri = request.getRequestURI().substring(4);

  //tim "/"
  int at = uri.indexOf("/");

  // tim bo quan ly ket noi
  ConnectionPool cp = (ConnectionPool) application.getAttribute("c_pool");

  //Tao doi tuong thuc thi chuc nang
  ArticleControl ac = new ArticleControl(cp);
  if (cp == null) {
    application.setAttribute("c_pool", ac.getConnectionPool());
  }
  ArticleItem similar = new ArticleItem();

  //lay tin tuc cho Marquee
  similar.setArticle_section_id((short) 8);
  String marquee = ac.viewMarquee(similar, (byte)10, "Dich-vu");
  //truyen toi vi tri hien thi ben rview.jsp
  session.setAttribute("marquee", marquee);

  //lay tin moi nhat
  similar.setArticle_section_id((short) 2);
  String newest = ac.viewNewest(similar, (byte) 8);
  //truyen toi vi tri hien thi ben rview.jsp
  session.setAttribute("viewnewest", newest);



  //ktra co phai trang chu hay k
  if (at == -1) {
    //lay tin tuc noi bat
    similar.setArticle_focus(true);
    String focus = ac.viewFocus(similar, (byte) 3);
    session.setAttribute("focus", focus);

    //Huy cac thong tin thiet lap doi tuong
    similar.setArticle_focus(false);

    //lay thong tin cho tung chuyen muc
    //TIN TUC
    similar.setArticle_category_id((short) 23);
    String section_news = ac.viewSections(similar, (byte) 6, (byte) 4, "Tin-tuc");
    session.setAttribute("section_news", section_news);

    //DICH VU
    similar.setArticle_section_id((short) 8);
    similar.setArticle_category_id((short) 28);
    String section_services = ac.viewSections(similar, (byte) 6, (byte) 4, "Dich-vu");
    session.setAttribute("section_services", section_services);

    //THONG TIN KHACH SAN
    similar.setArticle_section_id((short) 12);
    similar.setArticle_category_id((short) 48);
    String section_hotels = ac.viewSections(similar, (byte) 6, (byte) 4, "Tin-tuc");
    session.setAttribute("section_hotels", section_hotels);
  }
  else {
    //chen truc tiep duong dan tu thu vien
    int aid = jsoft.proj.library.Utilities.getIntParam(request, "aid");
    if(aid>0){
        String viewDetail = ac.viewDetail(aid);
        session.setAttribute("viewDetail",viewDetail);
      }else{
        //trang con
        similar = new ArticleItem();
        String section = uri.substring(0, at);

        //trang con gioi thieu
        if (section.equalsIgnoreCase("Gioi-thieu")) {
          similar.setArticle_section_id((short) 3);
          String introsList = ac.viewOfSection(similar, (byte) 10, section);
          session.setAttribute("introsList", introsList);
        }

        //trang con tin tuc
        else if (section.equalsIgnoreCase("Tin-tuc")) {
            similar.setArticle_section_id((short) 2);
            String newsList = ac.viewOfSection(similar, (byte) 10, section);
            session.setAttribute("newsList", newsList);
        }else if(section.equalsIgnoreCase("Dich-vu")){
          similar.setArticle_section_id((short) 8);
          String serviceList = ac.viewOfSection(similar, (byte) 10, section);
          session.setAttribute("serviceList", serviceList);
        }
      }
  }

  //tra ve ket noi
  ac.releaseConnection();
%>
