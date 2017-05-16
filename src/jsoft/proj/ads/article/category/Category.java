package jsoft.proj.ads.article.category;

import jsoft.proj.objects.*;
import java.sql.*;
import jsoft.proj.*;

public interface Category extends ShareControl{

  public boolean addCategory(CategoryItem item);
  public boolean editCategory(CategoryItem item);
  public boolean delCategory(CategoryItem item);

  public ResultSet getCategory(short id);
  public ResultSet getCategories(CategoryItem similar, int at, byte total);
}
