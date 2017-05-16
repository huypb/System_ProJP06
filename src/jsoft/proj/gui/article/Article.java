package jsoft.proj.gui.article;

import java.sql.*;
import jsoft.proj.gui.basic.*;
import jsoft.proj.objects.*;

public interface Article extends Basic {

  public ResultSet getArticle(int id);

  public ResultSet getArticles(ArticleItem similar, int at, byte total);

  public ResultSet getCategories(ArticleItem similar, byte total);
}
