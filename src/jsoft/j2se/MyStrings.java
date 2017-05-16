package jsoft.j2se;

import java.util.*;

/**
 * <p>
 * Title: JP project
 * </p>
 *
 * <p>
 * Description:
 * </p>
 *
 * <p>
 * Copyright: Copyright (c) 2012
 * </p>
 *
 * <p>
 * Company:
 * </p>
 *
 * @author Huy
 * @version 1.0
 */
public class MyStrings {

	// dem so ky tu co trong chuoi
	public static int countChar(String str, char ch, boolean ignoreCase) {
		if (ignoreCase) {
			str = str.toLowerCase();
			ch = Character.toLowerCase(ch);
		}

		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ch) {
				count++;
			}
		}
		return count;
	}

	// dem so tu trong chuoi
	public static int countWord(String str) {
		// xoa dau cach o dau va cuoi cua chuoi
		String tmp = str.trim();
		// chuan hoa
		while (tmp.indexOf("  ") != -1) {
			tmp = tmp.replace("  ", " "); // thay 2 dau cach bang 1 dau cach
		}
		return MyStrings.countChar(tmp, ' ', false) + 1; // so tu bang so dau
															// cach + 1

	}

	// dem tan suat xuat hien cua cac ky tu trong chuoi
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static ArrayList frequencyChar(String str, boolean ignoreCase) {
		ArrayList result = new ArrayList();

		String chs = "";
		char ch;

		String temp = str.trim();
		if (ignoreCase) {
			temp = temp.toLowerCase();
		}
		// lay ra cac ky tu khac nhau
		for (int i = 0; i < temp.length(); i++) {
			ch = temp.charAt(i);

			if (ch != ' ') {
				chs += ch;
				temp = temp.replace(ch, ' ');
			}
		}
		// dem tan suat xuat hien
		int count;
		for (int i = 0; i < chs.length(); i++) {
			count = MyStrings.countChar(str, chs.charAt(i), ignoreCase);
			result.add("[" + chs.charAt(i) + "," + count + "]");
		}

		return result;
	}

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {

		String str = "         Hello     Everybody         ";
		int count = MyStrings.countChar(str, 'e', false);
		System.out.println("co tat ca " + count + " ky tu e");

		int count1 = MyStrings.countWord(str);
		System.out.println(" co " + count1 + " tu");

		ArrayList result = MyStrings.frequencyChar(str, true);
		for (int i = 0; i < result.size(); i++) {
			System.out.print((String) result.get(i) + " ");
		}
	}
}
