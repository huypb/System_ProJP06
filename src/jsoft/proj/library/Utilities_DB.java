package jsoft.proj.library;

import jsoft.proj.objects.*;

public class Utilities_DB {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Utilities_DB utilities_db = new Utilities_DB();
	}

	public static String createConditions(ArticleItem similar) {
		String tmp = "";
		if (similar != null) {
			if (similar.getArticle_section_id() > 0) {
				tmp = "(article_section_id=" + similar.getArticle_section_id() + ")";
			}

			if (similar.getArticle_category_id() > 0) {
				if (!tmp.equalsIgnoreCase("")) {
					tmp += " AND (article_category_id=" + similar.getArticle_category_id() + ")";
				} else {
					tmp = "(article_category_id=" + similar.getArticle_category_id() + ")";
				}
			}

			if (similar.isArticle_focus()) {
				if (!tmp.equalsIgnoreCase("")) {
					tmp += " AND (article_focus=1)";
				} else {
					tmp = "(article_focus=1)";
				}
			}
		}

		return tmp;
	}
}
