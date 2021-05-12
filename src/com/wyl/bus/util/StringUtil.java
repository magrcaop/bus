package com.wyl.bus.util;

import java.io.UnsupportedEncodingException;

public class StringUtil {
	public static String iso2Utf8(String str){
		String resultStr = "";
		try {
			resultStr = new String(str.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return resultStr;
	}
}
