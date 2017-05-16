package jsoft.proj.ads.article.category;

import java.util.*;

import jsoft.proj.objects.*;

public class CategoryLibrary {
	public CategoryLibrary() {
	}

	@SuppressWarnings("rawtypes")
	public static String viewCategories(ArrayList items) {
		String tmp = "";
		if (items.size() > 0) {
			CategoryItem item;

			for (int i = 0; i < items.size(); i++) {
				item = (CategoryItem) items.get(i);
				tmp += (i % 2 == 0) ? "<tr>" : "<tr class =\"even\">";
				tmp += "<td class=\"NO\"  >" + (i + 1) + "</td>";
				tmp += "<td class=\"cname\" >" + item.getCategory_name() + "</td>";
				tmp += "<td>" + item.getCategory_notes() + "</td>";
				tmp += "<td>" + item.getSection_name() + "</td>";
				tmp += "<td class=\"ed\"><a href=\"#\">S\u1EEDa</a></td>";
				tmp += "<td class=\"ed\"><a href=\"#\">Xóa</a></td>";
				tmp += "</tr>";
				tmp += "\n"; // sau nay bo di
			}
		}
		return tmp;
	}

}
