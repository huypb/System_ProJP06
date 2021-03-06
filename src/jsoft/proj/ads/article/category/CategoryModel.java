package jsoft.proj.ads.article.category;

import java.sql.*;
import java.util.*;

import jsoft.proj.*;
import jsoft.proj.objects.*;

public class CategoryModel {

	private Category c;

	public CategoryModel(ConnectionPool cp) {
		this.c = new CategoryImpl(cp, "Category");
	}

	@Override
	public void finalize() {
		this.c = null;
	}

	// chia se ket noi
	public ConnectionPool getConnectionPool() {
		return this.c.getConnectionPool();
	}

	// yeu cau tra lai ket noi
	public void releaseConnection() {
		this.c.releaseConnection();
	}

	// **********************************************

	public boolean addCategory(CategoryItem item) {
		return this.c.addCategory(item);
	}

	public boolean editCategory(CategoryItem item) {
		return this.c.editCategory(item);
	}

	public boolean delCategory(CategoryItem item) {
		return this.c.delCategory(item);
	}

	// ***********************************************

	public CategoryItem getCategoryItem(short id) {
		CategoryItem item = null;
		ResultSet rs = this.c.getCategory(id);
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new CategoryItem();
					item.setCategory_id(rs.getShort("category_id"));
					item.setCategory_name(rs.getString("category_name"));
					item.setCategory_notes(rs.getString("category_notes"));

					item.setSection_name(rs.getString("section_name"));
				}
				rs.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

		return item;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList getCategoryItems(CategoryItem similar, int page, byte total) {

		ArrayList items = new ArrayList();
		CategoryItem item = null;
		int at = (page - 1) * total;

		ResultSet rs = this.c.getCategories(null, at, total);
		if (rs != null) {
			try {
				while (rs.next()) {
					item = new CategoryItem();
					item.setCategory_id(rs.getShort("category_id"));
					item.setCategory_name(rs.getString("category_name"));
					item.setCategory_notes(rs.getString("category_notes"));

					item.setSection_name(rs.getString("section_name"));

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
