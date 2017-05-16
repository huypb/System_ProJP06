package jsoft.proj.ads.article;

import java.util.*;

import jsoft.proj.objects.*;

public class ArticleLibrary {
	public ArticleLibrary() {
	}

	@SuppressWarnings("rawtypes")
	public static String viewArticles(ArrayList items) {
		String tmp = "";
		ArticleItem item;

		for (int i = 0; i < items.size(); i++) {
			item = (ArticleItem) items.get(i);
			tmp += (i % 2 == 0) ? "<tr>" : "<tr class =\"even\">";
			tmp += "<td class=\"NO\" >" + (i + 1) + "</td>";
			tmp += "<td class=\"cname\">" + item.getArticle_title() + "</td>";
			tmp += "<td>" + item.getSection_name() + "</td>";
			tmp += "<td>" + item.getCategory_name() + "</td>";
			tmp += "<td class=\"ed\"><a href=\"#\">S\u1EEDa</a></td>";
			tmp += "<td class=\"ed\"><a href=\"#\">Xóa</a></td>";
			tmp += "</tr>";
			tmp += "\n"; // sau nay bo di
		}

		return tmp;
	}

}
