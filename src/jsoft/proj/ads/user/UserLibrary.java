package jsoft.proj.ads.user;

import java.util.*;
import jsoft.proj.objects.*;

public class UserLibrary {

	public UserLibrary() {
	}

	@SuppressWarnings("rawtypes")
	public static String viewUsers(ArrayList items, UserItem userLogined) {
		String tmp = "";
		UserItem item;
		for (int i = 0; i < items.size(); i++) {
			item = (UserItem) items.get(i);
			tmp += (i % 2 == 0) ? "<tr>" : "<tr class =\"even\">";
			tmp += "<td class=\"NO\" >" + (i + 1) + "</td>";
			tmp += "<td class=\"cname\" >" + item.getUser_name() + "</td>";
			tmp += "<td>" + item.getUser_fullname() + "</td>";
			tmp += "<td>" + item.getUser_address() + "</td>";
			tmp += "<td>" + item.getUser_email() + "</td>";
			tmp += "<td>" + item.getUser_birthday() + "</td>";
			tmp += "<td>" + item.getUser_homephone() + "</td>";
			tmp += "<td class=\"ed\" ><a href=\"/adv/user/ae?id=" + item.getUser_id() + "\">S\u1EEDa</a></td>";

			if (userLogined.getUser_id() != item.getUser_id()) {
				tmp += "<td class=\"ed\" ><a href=\"javascript:confirmDel('/adv/user/del?id=" + item.getUser_id()
						+ "'); void(0);\">Xóa</a></td>";

			} else {
				tmp += "<td class=\"ed\" >---</td>";
			}
			tmp += "</tr>";
		}

		return tmp;
	}

}
