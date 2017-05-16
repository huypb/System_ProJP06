package jsoft.proj.gui.basic;

import java.sql.*;

import jsoft.proj.*;

public interface Basic extends ShareControl {

	public ResultSet get(String sql);

	public ResultSet get(String sql, int value);

	public ResultSet get(String sql, String username, String userpass);

	public ResultSet[] gets(String[] sqls);
}
