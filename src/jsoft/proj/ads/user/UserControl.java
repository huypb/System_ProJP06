package jsoft.proj.ads.user;

import java.util.*;
import jsoft.proj.*;
import jsoft.proj.objects.*;

public class UserControl {
	private UserModel um;

	public UserControl(ConnectionPool cp) {
		this.um = new UserModel(cp);
	}

	@Override
	protected void finalize() throws Throwable {
		this.um = null;
		super.finalize();
	}

	public ConnectionPool getConnectionPool() {
		return this.um.getConnectionPoll();
	}

	public void releaseConnection() {
		this.um.releaseConnection();
	}
	// ******************************************

	public boolean addUser(UserItem item) {
		return this.um.addUser(item);
	}

	public boolean editUser(UserItem item) {
		return this.um.editUser(item);
	}

	public boolean delUser(UserItem item) {
		return this.um.delUser(item);
	}

	// ******************************************

	public UserItem getUserItem(int id) {
		return this.um.getUserItem(id);
	}

	public UserItem getUserItem(String username, String userpass) {
		return this.um.getUserItem(username, userpass);
	}

	// ******************************************

	@SuppressWarnings("rawtypes")
	public String viewUser(UserItem similar, UserItem userLogined, int at, byte total) {
		ArrayList items = this.um.getUserItems(similar, at, total);
		return UserLibrary.viewUsers(items, userLogined);
	}
	/*
	 * public static void main(String[] args){ //Bo quan ly ket noi
	 * ConnectionPool cp = new ConnectionPoolImpl();
	 * 
	 * //Tao doi tuong thuc thi chuc nang UserControl uc= new UserControl(cp);
	 * 
	 * //lay du lieu String viewUsers = uc.viewUser(null, 1, (byte)20);
	 * 
	 * //tra ve ket noi System.out.print(viewUsers); }
	 * 
	 */
}
