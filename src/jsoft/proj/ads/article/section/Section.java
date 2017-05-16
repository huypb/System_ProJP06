package jsoft.proj.ads.article.section;

import java.sql.*;

import jsoft.proj.*;
import jsoft.proj.objects.*;
public interface Section extends ShareControl {

  public boolean addSection(SectionItem item);
  public boolean editSection(SectionItem item);
  public boolean delSection(SectionItem item);

  public ResultSet getSection(short id);
  public ResultSet getSections(SectionItem similar, int at, byte total);
}
