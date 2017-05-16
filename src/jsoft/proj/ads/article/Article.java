package jsoft.proj.ads.article;

import jsoft.proj.objects.*;
import jsoft.proj.*;
import java.sql.*;
public interface Article extends ShareControl{

  public boolean addArticle(ArticleItem item);
  public boolean editArticle(ArticleItem item);
  public boolean delArticle(ArticleItem item);

  public ResultSet getArticle(int id);
  public ResultSet getArticles(ArticleItem similar, int at, byte total);
}
