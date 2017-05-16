package jsoft.proj.ads.article.section;

import java.util.*;

import jsoft.proj.objects.*;

public class SectionLibrary {
	public SectionLibrary() {
	}

	@SuppressWarnings("rawtypes")
	public static String viewSections(ArrayList items) {
		String tmp = "";
		SectionItem item;

		for (int i = 0; i < items.size(); i++) {
			item = (SectionItem) items.get(i);

			tmp += (i % 2 == 0) ? "<tr>" : "<tr class =\"even\">";

			tmp += "<td class=\"NO\"  >" + (i + 1) + "</td>";
			tmp += "<td class=\"cname\" >" + item.getSection_name() + "</td>";
			tmp += "<td>" + item.getSection_notes() + "</td>";
			tmp += "<td class=\"ed\" ><a href=\"#\">S\u1EEDa</a></td>";
			tmp += "<td class=\"ed\" ><a href=\"#\">Xóa</a></td>";
			tmp += "</tr>";

		}

		return tmp;
	}

}
