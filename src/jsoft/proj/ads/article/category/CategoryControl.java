package jsoft.proj.ads.article.category;

import java.util.*;

import jsoft.proj.*;
import jsoft.proj.objects.*;

public class CategoryControl {

	private CategoryModel cm;

	public CategoryControl(ConnectionPool cp) {
		this.cm = new CategoryModel(cp);
	}

	@Override
	protected void finalize() throws Throwable {
		this.cm = null;
		super.finalize();
	}

	public ConnectionPool getConnectionPool() {
		return this.cm.getConnectionPool();
	}

	public void releaseConnection() {
		this.cm.releaseConnection();
	}

	// ******************************************

	public CategoryItem getCategoryItem(short id) {
		return this.cm.getCategoryItem(id);
	}
	// ****************************************

	public boolean addCategory(CategoryItem item) {
		return this.cm.addCategory(item);
	}

	public boolean editCategory(CategoryItem item) {
		return this.cm.editCategory(item);
	}

	public boolean delCategory(CategoryItem item) {
		return this.cm.delCategory(item);
	}

	// *****************************************
	@SuppressWarnings("rawtypes")
	public String viewCategorys(CategoryItem similar, int at, byte total) {
		ArrayList items = this.cm.getCategoryItems(similar, at, total);
		return CategoryLibrary.viewCategories(items);
	}

	public static void main(String[] args) {
		// bo quan ly ket noi
		ConnectionPool cp = new ConnectionPoolImpl();

		// doi truong thuc thi
		CategoryControl cc = new CategoryControl(cp);

		// lay ve du lieu
		String viewCategorys = cc.viewCategorys(null, 1, (byte) 20);

		// hien thi
		System.out.print(viewCategorys);
	}

}
