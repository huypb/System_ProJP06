package jsoft.proj;

import java.sql.*;

public interface ConnectionPool {
	// cung cap ket noi cho cac doi tuong
	public Connection getConnection(String objectName) throws SQLException;

	// lay lai ket noi
	public void releaseConnection(Connection con, String objectName) throws SQLException;

}
