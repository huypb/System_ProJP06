package jsoft.proj.ads.user;

import java.sql.*;
import java.util.*;

import jsoft.proj.*;
import jsoft.proj.objects.*;

public class UserModel {

	private User u;

	public UserModel(ConnectionPool cp) {
		this.u = new UserImpl(cp);
	}

	@Override
	protected void finalize() throws Throwable {
		this.u = null;
	}

	// chia se ket noi
	public ConnectionPool getConnectionPoll() {
		return this.u.getConnectionPool();
	}

	// yeu cau tra ve ket noi
	public void releaseConnection() {
		this.u.releaseConnection();
	}

	// ****************************************************

	public boolean addUser(UserItem item) {
		return this.u.addUser(item);
	}

	public boolean editUser(UserItem item) {
		return this.u.editUser(item);
	}

	public boolean delUser(UserItem item) {
		return this.u.delUser(item);
	}

	// ****************************************************

	public UserItem getUserItem(int id) {
		UserItem item = null;

		ResultSet rs = this.u.getUser(id);
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new UserItem();
					item.setUser_id(rs.getInt("user_id"));
					item.setUser_name(rs.getString("user_name"));
					item.setUser_pass(rs.getString("user_pass"));
					item.setUser_fullname(rs.getString("user_fullname"));
					item.setUser_email(rs.getString("user_email"));
					item.setUser_address(rs.getString("user_address"));

				}
				rs.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

		return item;
	}

	public UserItem getUserItem(String username, String userpass) {
		UserItem item = null;

		ResultSet rs = this.u.getUser(username, userpass);
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new UserItem();
					item.setUser_id(rs.getInt("user_id"));
					item.setUser_name(rs.getString("user_name"));
					item.setUser_pass(rs.getString("user_pass"));
					item.setUser_fullname(rs.getString("user_fullname"));
					item.setUser_email(rs.getString("user_email"));
					item.setUser_address(rs.getString("user_address"));

				}
				rs.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

		return item;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList getUserItems(UserItem similar, int page, byte total) {
		ArrayList items = new ArrayList();
		UserItem item = null;
		int at = (page - 1) * total;
		ResultSet rs = this.u.getUsers(similar, at, total);
		if (rs != null) {
			try {
				while (rs.next()) {
					item = new UserItem();
					item.setUser_id(rs.getInt("user_id"));
					item.setUser_name(rs.getString("user_name"));
					item.setUser_pass(rs.getString("user_pass"));
					item.setUser_fullname(rs.getString("user_fullname"));
					item.setUser_email(rs.getString("user_email"));
					item.setUser_address(rs.getString("user_address"));

					items.add(item);

				}
				rs.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

		return items;
	}

}
