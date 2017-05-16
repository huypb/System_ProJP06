package jsoft.proj.gui.article;

import jsoft.proj.objects.*;
import java.util.*;
import jsoft.proj.library.*;

public class ArticleLibrary {
	public ArticleLibrary() {
	}

	// tin moi nhat
	@SuppressWarnings("rawtypes")
	public static String viewNewest(ArrayList items) {
		String tmp = "<div class=\"news\">";

		ArticleItem item;

		String path;
		for (int i = 0; i < items.size(); i++) {
			item = (ArticleItem) items.get(i);

			path = "/jv/Tin-tuc/?aid=" + item.getArticle_id();

			tmp += "<a href=\"" + path + "\"><h3>";
			tmp += item.getArticle_title();
			tmp += "</h3></a>";

		}

		tmp += "</div>";

		return tmp;
	}

	@SuppressWarnings("rawtypes")
	public static String viewFocus(ArrayList items) {
		String tmp = "<div class=\"focus\"> ";
		ArticleItem item;

		String path;
		for (int i = 0; i < items.size(); i++) {

			if (i >= 3) {
				break;
			}

			item = (ArticleItem) items.get(i);

			path = "/jv/Tin-tuc/?aid=" + item.getArticle_id();
			if (i == 1) {
				tmp += "<div class=\"f3\" style=\"margin: 0 11px;\" >";
			} else {
				tmp += "<div class=\"f3\"  >";
			}
			tmp += "<img src=\"" + item.getArticle_image() + "\" >";
			tmp += "<br />";
			tmp += "<a href=\"" + path + "\"><h3>" + item.getArticle_title() + "</h3></a>";
			tmp += "</div>";

		}
		tmp += "<div class=\"clr\"></div>";

		tmp += "</div>";

		return tmp;
	}

	@SuppressWarnings("rawtypes")
	public static String viewSections(ArrayList items, ArrayList cates, String sec_name) {
		String tmp = "<div class=\"sections\">";

		// trinh bay title

		String path;

		CategoryItem cate = null;
		if (cates.size() > 0) {
			cate = (CategoryItem) cates.get(0);
		}

		String current_title = (cate != null) ? cate.getCategory_name() : "No title";

		path = "/jv/" + sec_name + "/?cid=" + cate.getCategory_id();

		tmp += "<div class=\"title\">";
		tmp += "<div class=\"lcurr_title\"></div>";
		tmp += "<div class=\"curr_title\"><a href=\"" + path + "\" ><h3>" + current_title + "</h3></a></div>";
		tmp += "<div class=\"rcurr_title\"></div>";

		tmp += "<div class=\"links_title\">";
		for (int i = 1; i < cates.size(); i++) {
			cate = (CategoryItem) cates.get(i);

			path = "/jv/" + sec_name + "/?cid=" + cate.getCategory_id();

			tmp += "<a href=\"" + path + "\">";
			tmp += cate.getCategory_name();
			tmp += "</a>&nbsp;|&nbsp;";
		}

		tmp += "</div>";
		tmp += "<div class=\"clr\"> </div>";
		tmp += "</div>"; // dong title

		// trinh bay phan content

		ArticleItem item = null;
		tmp += "<div class=\"sections_content\">";

		if (items.size() > 0) {
			item = (ArticleItem) items.get(0);
			tmp += "<div class=\"sections_content_left\">";
			tmp += "<img src=\"" + item.getArticle_image() + "\" />";

			path = "/jv/" + sec_name + "/?aid=" + item.getArticle_id();

			tmp += "<a href=\"" + path + "\" >" + item.getArticle_title() + "</a>";
			tmp += "<p>" + item.getArticle_summary() + "</p>";
			tmp += "</div>";

			tmp += "<div class=\"sections_content_right\"><ul>";
			for (int i = 1; i < items.size(); i++) {
				item = (ArticleItem) items.get(i);

				path = "/jv/" + sec_name + "/?aid=" + item.getArticle_id();
				tmp += "<li><a href=\"" + path + "\">";
				tmp += item.getArticle_title();
				tmp += "</a></li>";
			}
			tmp += "</ul></div>";

		}

		tmp += "<div class=\"clr\"> </div>";
		tmp += "</div>"; // dong content

		tmp += "</div>"; // dong section

		return tmp;
	}

	@SuppressWarnings("rawtypes")
	public static String viewOfSection(ArrayList items, String sec_name) {
		String tmp = "";
		ArticleItem item;
		String path;
		for (int i = 0; i < items.size(); i++) {
			item = (ArticleItem) items.get(i);

			path = "/jv/" + sec_name + "/?aid=" + item.getArticle_id();
			tmp += "<div class=\"asummary\" >";
			tmp += "<img src=\"" + item.getArticle_image() + "\"  />";
			tmp += "<a href=\"" + path + "\" ><h3>" + item.getArticle_title() + "</h3></a>";
			tmp += "<p>" + item.getArticle_summary() + "</p>";
			tmp += "<a href=\"" + path + "\" class=\"readmore\" >Xem ti\u1EBFp...</a>";

			tmp += "<div class =\"clr\" ></div>";
			tmp += "</div>";

		}
		return tmp;
	}

	// xem chi tiet
	public static String viewDetail(ArticleItem item) {
		String tmp = "";
		if (item != null) {

			tmp += "<script language=\"JavaScript\" >";
			tmp += "document.title='" + Utilities.decode(item.getArticle_title()) + "'";
			tmp += "</script>";

			tmp += "<div class=\"vtitle\">" + Utilities.decode(item.getArticle_title()) + "</div>";
			tmp += "<div class=\"vsummary\">" + Utilities.decode(item.getArticle_summary()) + "</div>";
			tmp += "<div class=\"vcontent\">" + Utilities.decode(item.getArticle_content()) + "</div>";

		}

		return tmp;
	}

	@SuppressWarnings("rawtypes")
	public static String viewMarquee(ArrayList items, String sec_name) {
		String tmp = "";
		ArticleItem item;
		String path;
		for (int i = 0; i < items.size(); i++) {
			item = (ArticleItem) items.get(i);

			path = "/jv/" + sec_name + "/?aid=" + item.getArticle_id();
			tmp += "<a href=\"" + path + "\" ><h3>";
			tmp += "<img src=\"" + item.getArticle_image() + "\">";
			tmp += item.getArticle_title();
			tmp += "</h3></a>";

		}

		return tmp;
	}

}
