package jsoft.proj.ads.article;

import java.sql.*;
import java.util.*;

import jsoft.proj.*;
import jsoft.proj.objects.*;

public class ArticleModel {

	private Article a;

	public ArticleModel(ConnectionPool cp) {
		this.a = new ArticleImpl(cp, "Article");
	}

	@Override
	public void finalize() {
		this.a = null;
	}

	// chia se ket noi
	public ConnectionPool getConnectionPool() {
		return this.a.getConnectionPool();
	}

	// yeu cau tra lai ket noi
	public void releaseConnection() {
		this.a.releaseConnection();
	}

	// **************************************************

	public boolean addArticle(ArticleItem item) {
		return this.a.addArticle(item);
	}

	public boolean editArticle(ArticleItem item) {
		return this.a.editArticle(item);
	}

	public boolean delArticle(ArticleItem item) {
		return this.a.delArticle(item);
	}

	// ****************************************************

	public ArticleItem getArticleItem(int id) {

		ArticleItem item = null;

		ResultSet rs = this.a.getArticle(id);
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new ArticleItem();
					item.setArticle_id(rs.getInt("article_id"));
					item.setArticle_title(rs.getString("article_title"));
					item.setArticle_content(rs.getString("article_content"));

					item.setSection_name(rs.getString("section_name"));
					item.setCategory_name(rs.getString("category_name"));
				}
				rs.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return item;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList getArticleItems(ArticleItem similar, int page, byte total) {
		ArrayList items = new ArrayList();
		ArticleItem item = null;
		int at = (page - 1) * total;

		ResultSet rs = this.a.getArticles(null, at, total);
		if (rs != null) {
			try {
				while (rs.next()) {
					item = new ArticleItem();
					item.setArticle_id(rs.getInt("article_id"));
					item.setArticle_title(rs.getString("article_title"));
					item.setArticle_content(rs.getString("article_content"));

					item.setSection_name(rs.getString("section_name"));
					item.setCategory_name(rs.getString("category_name"));

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
