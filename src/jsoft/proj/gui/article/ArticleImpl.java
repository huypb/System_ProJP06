package jsoft.proj.gui.article;

import java.sql.*;

import jsoft.proj.gui.basic.*;

import jsoft.proj.objects.*;
import jsoft.proj.*;
import jsoft.proj.library.*;

public class ArticleImpl extends BasicImpl implements Article {
  public ArticleImpl(ConnectionPool cp) {
    super(cp, "Article-GUI");
  }

  /**
   * getArticle
   *
   * @param similar ArticleItem
   * @param at int
   * @param total byte
   * @return ResultSet
   * @todo Implement this jsoft.proj.gui.article.Article method
   */
  @Override
public ResultSet getArticles(ArticleItem similar, int at, byte total) {
    String condition = Utilities_DB.createConditions(similar);

    String sql = "SELECT * FROM tblarticle ";
    sql += "LEFT JOIN tblcategory ON article_category_id=category_id ";
    sql += "LEFT JOIN tblsection ON category_section_id=section_id ";
    if (!condition.equalsIgnoreCase("")) {
      sql += "WHERE " + condition + " ";
    }

    sql += "ORDER BY article_id DESC ";
    sql += "LIMIT " + at + ", " + total;
    return this.get(sql);
  }

  /**
   * getArticle
   *
   * @param id int
   * @return ResultSet
   * @todo Implement this jsoft.proj.gui.article.Article method
   */
  @Override
public ResultSet getArticle(int id) {
    String sql = "SELECT * FROM tblarticle ";
    sql += "LEFT JOIN tblcategory ON article_category_id=category_id ";
    sql += "LEFT JOIN tblsection ON category_section_id=section_id ";
    sql += "WHERE article_id= ?";

    return this.get(sql, id);
  }

  @Override
public ResultSet getCategories(ArticleItem similar, byte total) {
    String sql = "SELECT * FROM tblcategory ";
    sql += "WHERE category_section_id = ? ";
    sql += "ORDER BY category_name ASC ";
    sql += "LIMIT " + total;
    return this.get(sql, similar.getArticle_section_id());
  }
}
