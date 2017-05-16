package jsoft.proj.ads.article.section;

import java.sql.*;

import jsoft.proj.*;
import jsoft.proj.ads.basic.*;
import jsoft.proj.objects.*;

public class SectionImpl extends BasicImpl implements Section {
  public SectionImpl(ConnectionPool cp, String objectName) {
    super(cp, objectName);
  }


  @Override
public boolean addSection(SectionItem item) {
    String sql = "INSERT INTO tblsection( section_name,section_notes,section_created_date, ";
    sql += "section_manager_id,section_enable,section_delete, ";
    sql += "section_last_modified,section_created_author_id,section_created_author_id, ";
    sql += "section_language  ";
    sql += "VALUES(?,?,?,?,?,?,?,?,?,?)";

    try {
      PreparedStatement pre = this.con.prepareStatement(sql);
      pre.setString(1, item.getSection_name());
      pre.setString(2, item.getSection_notes());
      pre.setString(3, item.getSection_created_date());
      pre.setInt(4, item.getSection_manager_id());
      pre.setBoolean(5, item.isSection_enable());
      pre.setBoolean(6, item.isSection_delete());
      pre.setString(7, item.getSection_last_modified());
      pre.setInt(8, item.getSection_created_author_id());
      pre.setString(9, item.getSection_name_en());
      pre.setByte(10, item.getSection_language());

      return this.add(pre);
    } catch (SQLException ex) {
      ex.printStackTrace();
    }

    return false;
  }


  @Override
public boolean delSection(SectionItem item) {

    // neu co bai viet trong chuyen muc thi k dc xoa
    if (!this.isEmpty(item)) {
      return false;
    }

    String sql = "DELETE FROM tblsection WHERE section_id = ?";

    try {
      PreparedStatement pre = this.con.prepareStatement(sql);
      pre.setShort(1, item.getSection_id());

      return this.del(pre);

    } catch (SQLException ex) {
      ex.printStackTrace();
    }

    return false;
  }

// ktra xem bai chuyen de co dang chua bai viet hay k
  private boolean isEmpty(SectionItem item) {
    boolean flag = true;

    String sql = "SELECT category_id FROM tblcategory ";
    sql += "WHERE category_section_id ='" + item.getSection_id() + "'";
    ResultSet rs = this.get(sql);
    if (rs != null) {
      try {
        if (rs.next()) {
          flag = false;
        }
      } catch (SQLException ex) {
        ex.printStackTrace();
      }
    }
    return flag;
  }


  @Override
public boolean editSection(SectionItem item) {
    String sql = "UPDATE tblsection SET section_name =?,section_notes =?,section_created_date =?, ";
    sql += "section_manager_id =?,section_enable =?,section_delete =?, ";
    sql += "section_last_modified =?,section_created_author_id =?,section_created_author_id =?, ";
    sql += "section_language =?  ";
    sql += "WHERE section_id =?";

    try {
      PreparedStatement pre = this.con.prepareStatement(sql);
      pre.setString(1, item.getSection_name());
      pre.setString(2, item.getSection_notes());
      pre.setString(3, item.getSection_created_date());
      pre.setInt(4, item.getSection_manager_id());
      pre.setBoolean(5, item.isSection_enable());
      pre.setBoolean(6, item.isSection_delete());
      pre.setString(7, item.getSection_last_modified());
      pre.setInt(8, item.getSection_created_author_id());
      pre.setString(9, item.getSection_name_en());
      pre.setByte(10, item.getSection_language());

      pre.setShort(11, item.getSection_id()); //menh de where

      return this.edit(pre);
    } catch (SQLException ex) {
      ex.printStackTrace();
    }

    return false;
  }


  @Override
public ResultSet getSection(short id) {
    String sql = "SELECT * FROM tblsection WHERE section_id =?";
    return this.get(sql, id);
  }

  @Override
public ResultSet getSections(SectionItem similar, int at, byte total) {
    String sql = "SELECT * FROM tblsection ";
    sql += "";
    sql += "ORDER BY section_name ASC ";
    sql += "LIMIT " + at + "," + total;
    return this.get(sql);
  }

  public static void main(String[] args) {
    ConnectionPool cp = new ConnectionPoolImpl();

    Section s = new SectionImpl(cp, "Section");

    //lay du lieu
    ResultSet rs = s.getSections(null, 0, (byte) 20);

    //hien thi
    if (rs != null) {
      try {
        while (rs.next()) {
          System.out.print(rs.getShort("section_id") + "\t");
          System.out.print(rs.getString("section_name") + "\t");
          System.out.println(rs.getString("section_notes"));
        }
      } catch (SQLException ex) {
        ex.printStackTrace();
      }
    }
  }


}
