package jsoft.proj.gui.article;

import java.sql.*;
import java.util.*;

import jsoft.proj.*;
import jsoft.proj.objects.*;

@SuppressWarnings("rawtypes")
public class ArticleModel {
	private Article a;

	public ArticleModel(ConnectionPool cp) {
		this.a = new ArticleImpl(cp);
	}

	@Override
	protected void finalize() throws Throwable {
		this.a = null;
		super.finalize();
	}

	public ConnectionPool getConnectionPool() {
		return this.a.getConnectionPool();
	}

	public void releaseConnection() {
		this.a.releaseConnection();
	}

	public ArticleItem getArticleItem(int id) {
		ArticleItem item = null;
		ResultSet rs = this.a.getArticle(id);
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new ArticleItem();

					item.setArticle_id(rs.getInt("article_id"));
					item.setArticle_title(rs.getString("article_title"));
					item.setArticle_summary(rs.getString("article_summary"));
					item.setArticle_content(rs.getString("article_content"));
					item.setArticle_created_date(rs.getString("article_created_date"));
					item.setArticle_image(rs.getString("article_image"));

				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

		return item;
	}

	@SuppressWarnings("unchecked")
	public ArrayList getArticleItems(ArticleItem similar, int page, byte total) {

		ArrayList items = new ArrayList();
		ArticleItem item = null;

		int at = (page - 1) * total;
		ResultSet rs = this.a.getArticles(similar, at, total);
		if (rs != null) {
			try {
				while (rs.next()) {
					item = new ArticleItem();

					item.setArticle_id(rs.getInt("article_id"));
					item.setArticle_title(rs.getString("article_title"));
					item.setArticle_summary(rs.getString("article_summary"));
					item.setArticle_content(rs.getString("article_content"));
					item.setArticle_created_date(rs.getString("article_created_date"));
					item.setArticle_image(rs.getString("article_image"));

					item.setCategory_name(rs.getString("category_name"));
					item.setSection_name(rs.getString("section_name"));

					items.add(item);
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

		return items;
	}

	@SuppressWarnings("unchecked")
	public ArrayList getCategories(ArticleItem similar, byte total) {
		ArrayList cates = new ArrayList();
		CategoryItem cate;

		ResultSet rs = this.a.getCategories(similar, total);
		if (rs != null) {
			try {
				while (rs.next()) {
					cate = new CategoryItem();

					cate.setCategory_id(rs.getShort("category_id"));
					// cate.setCategory_section_id(rs.getShort("category_section_id"));
					cate.setCategory_section_id(similar.getArticle_section_id());
					cate.setCategory_name(rs.getString("category_name"));

					cates.add(cate);
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		// sap xep lai danh sach the loai
		for (int i = 0; i < cates.size(); i++) {
			cate = (CategoryItem) cates.get(i);
			if (cate.getCategory_id() == similar.getArticle_category_id()) {
				// xoa doi tuong o vi tri i (vi tri cu)
				cates.remove(i);

				// dua len dau danh sach
				cates.add(0, cate);
			}
		}

		return cates;
	}

	public static void main(String[] args) {
		ArticleModel articleModel = new ArticleModel(new ConnectionPoolImpl());
		System.out.println(articleModel.getArticleItem(10));
	}
}
