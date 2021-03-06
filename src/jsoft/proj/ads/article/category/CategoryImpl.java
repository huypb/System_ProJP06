package jsoft.proj.ads.article.category;

import java.sql.*;

import jsoft.proj.*;
import jsoft.proj.ads.article.section.*;
import jsoft.proj.objects.*;

public class CategoryImpl extends SectionImpl implements Category {
  public CategoryImpl(ConnectionPool cp, String objectName) {
    super(cp, objectName);
  }


  @Override
public boolean addCategory(CategoryItem item) {
    String sql = "INSERT INTO tblcategory(category_name,category_section_id, ";
    sql += "category_notes,category_created_date,category_created_author_id, ";
    sql += "category_last_modified,category_manager_id,category_enable, ";
    sql += "category_delete,category_image,category_name_en,category_language) ";
    sql += "VALUES(?,?,?,?,?,?,?,?,?,?,?,?) ";

    try {
      PreparedStatement pre = this.con.prepareStatement(sql);
      pre.setString(1, item.getCategory_name());
      pre.setShort(2, item.getCategory_section_id());
      pre.setString(3, item.getCategory_notes());
      pre.setString(4, item.getCategory_created_date());
      pre.setInt(5, item.getCategory_created_author_id());
      pre.setString(6, item.getCategory_last_modified());
      pre.setInt(7, item.getCategory_manager_id());
      pre.setBoolean(8, item.isCategory_enable());
      pre.setBoolean(9, item.isCategory_delete());
      pre.setString(10, item.getCategory_image());
      pre.setString(11, item.getCategory_name_en());
      pre.setByte(12, item.getCategory_language());

      return this.add(pre);
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return false;
  }


  @Override
public boolean delCategory(CategoryItem item) {
    //neu the loai bai viet con chua bai viet thi k cho xoa
    if (!this.isEmpty(item)) {
      return false;
    }

    String sql = "DELETE FROM tblcategory WHERE category_id =?";
    try {
      PreparedStatement pre = this.con.prepareStatement(sql);
      pre.setInt(1, item.getCategory_id());

      return this.del(pre);
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return false;
  }

  //ktra xem the loai bai viet co trong hay k
  private boolean isEmpty(CategoryItem item) {
    boolean flag = true;
    String sql = "SELECT article_id FROM tblarticle ";
    sql += "WHERE article_category_id ='" + item.getCategory_id() + "' ";
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
public boolean editCategory(CategoryItem item) {
    String sql = "UPDATE tblcategory SET category_name =?,category_section_id =?, ";
    sql += "category_notes =?,category_created_date =?,category_created_author_id =?, ";
    sql += "category_last_modified =?,category_manager_id =?,category_enable =?, ";
    sql += "category_delete =?,category_image =?,category_name_en =?,category_language =?) ";
    sql += "WHERE cateory_id =? ";

    try {
      PreparedStatement pre = this.con.prepareStatement(sql);
      pre.setString(1, item.getCategory_name());
      pre.setShort(2, item.getCategory_section_id());
      pre.setString(3, item.getCategory_notes());
      pre.setString(4, item.getCategory_created_date());
      pre.setInt(5, item.getCategory_created_author_id());
      pre.setString(6, item.getCategory_last_modified());
      pre.setInt(7, item.getCategory_manager_id());
      pre.setBoolean(8, item.isCategory_enable());
      pre.setBoolean(9, item.isCategory_delete());
      pre.setString(10, item.getCategory_image());
      pre.setString(11, item.getCategory_name_en());
      pre.setByte(12, item.getCategory_language());

      pre.setShort(13, item.getCategory_id()); //trong menh de where

      return this.edit(pre);
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return false;
  }

  @Override
public ResultSet getCategories(CategoryItem similar, int at, byte total) {
    String sql = "SELECT * FROM tblcategory ";
    sql += "LEFT JOIN tblsection ON category_section_id=section_id ";
    sql += "ORDER BY category_name ASC ";
    sql += "LIMIT " + at + ", " + total;
    return this.get(sql);
  }


  @Override
public ResultSet getCategory(short id) {
    String sql = "SELECT * FROM tblcategory  ";
    sql += "LEFT JOIN tblsection ON category_section_id=section_id ";
    sql += "WHERE category_id = ?";
    return this.get(sql, id);
  }

  public static void main(String[] args) {

    ConnectionPool cp = new ConnectionPoolImpl();

    Category c = new CategoryImpl(cp, "Category");

    ResultSet rs = c.getCategories(null, 0, (byte) 20);
    if (rs != null) {
      try {
        while (rs.next()) {
          System.out.print(rs.getShort("category_id") + "\t");
          System.out.print(rs.getString("category_name") + "\t");
          System.out.println(rs.getString("category_notes")+"\t");
          System.out.println(rs.getString("section_name"));
        }
      } catch (SQLException ex) {
        ex.printStackTrace();
      }
    }

  }
}
