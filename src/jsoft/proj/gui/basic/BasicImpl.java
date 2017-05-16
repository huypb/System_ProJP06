package jsoft.proj.gui.basic;

import java.sql.*;
import jsoft.proj.*;

public class BasicImpl implements Basic {
	// bo quan ly ket noi cua rieng Basic
	private ConnectionPool cp;

	// ket noi de Basic lam viec voi DB
	public Connection con;

	// ten doi tuong lam viec voi Basic
	private String objectName;

	public BasicImpl(ConnectionPool cp, String objectName) {
		// xac dinh cp cho Basic
		if (cp == null) {
			this.cp = new ConnectionPoolImpl();
		} else {
			this.cp = cp;
		}

		// xac dinh ten doi tuong lam viec
		this.objectName = objectName;

		// xin 1 ket noi
		try {
			this.con = this.cp.getConnection(this.objectName);
			if (this.con.getAutoCommit()) {
				this.con.setAutoCommit(false);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public ResultSet get(String sql, int value) {
		try {
			PreparedStatement preGet = this.con.prepareStatement(sql);
			if (value > 0) {
				preGet.setInt(1, value);
			}

			return preGet.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException ex1) {
				ex1.printStackTrace();
			}
		}

		return null;
	}

	@Override
	public ResultSet get(String sql, String username, String userpass) {

		try {
			PreparedStatement preGet = this.con.prepareStatement(sql);
			preGet.setString(1, username);
			preGet.setString(2, userpass);

			return preGet.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException ex1) {
				ex1.printStackTrace();
			}
		}

		return null;
	}

	@Override
	public ResultSet get(String sql) {

		return this.get(sql, 0);
	}

	@Override
	public ConnectionPool getConnectionPool() {
		return this.cp;
	}

	@Override
	public ResultSet[] gets(String[] sqls) {
		ResultSet[] tmp = new ResultSet[sqls.length];
		for (int i = 0; i < sqls.length; i++) {
			tmp[i] = this.get(sqls[i]);
		}
		return tmp;
	}

	// tra lai phuong thuc ket noi
	@Override
	public void releaseConnection() {
		try {
			this.cp.releaseConnection(this.con, this.objectName);
		} catch (SQLException ex) {
			ex.printStackTrace();

		}
	}
}
