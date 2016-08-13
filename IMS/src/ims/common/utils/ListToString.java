package com.bmpl.ims.common.utils;

import java.util.List;

public class ListToString {
	public static String listToString(List<?> list) {
		String result = "";
		for (int i = 0; i < list.size(); i++) {
			result += " " + list.get(i) + "\n";
		}
		return result;
	}

}
