package jsoft.proj.ads.user;

import java.sql.*;

import jsoft.proj.*;
import jsoft.proj.objects.*;

public interface User extends ShareControl {
  public boolean addUser(UserItem item);
  public boolean editUser(UserItem item);
  public boolean delUser(UserItem item);

  public ResultSet getUser(int id);
  public ResultSet getUser(String username, String userpass);
  public ResultSet getUsers(UserItem similar, int at, byte total);

}
