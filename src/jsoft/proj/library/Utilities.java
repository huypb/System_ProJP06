package jsoft.proj.library;

import javax.servlet.ServletRequest;

import net.htmlparser.jericho.CharacterReference;

public class Utilities {
	public Utilities() {
	}

	public static String encode(String uniStr) {
		return CharacterReference.encode(uniStr);
	}

	public static String decode(String htmlStr) {
		return CharacterReference.decode(htmlStr);
	}

	public static byte getByteParam(ServletRequest request, String name) {
		byte value = 0;
		String strValue = request.getParameter(name);
		if (strValue != null && !strValue.equalsIgnoreCase("")) {
			value = Byte.parseByte(strValue);
		}

		return value;
	}

	public static short getShortParam(ServletRequest request, String name) {
		short value = 0;
		String strValue = request.getParameter(name);
		if (strValue != null && !strValue.equalsIgnoreCase("")) {
			value = Short.parseShort(strValue);
		}

		return value;
	}

	public static int getIntParam(ServletRequest request, String name) {
		int value = 0;
		String strValue = request.getParameter(name);
		if (strValue != null && !strValue.equalsIgnoreCase("")) {
			value = Integer.parseInt(strValue);
		}

		return value;
	}

}
