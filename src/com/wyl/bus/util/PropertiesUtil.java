package com.wyl.bus.util;

import java.io.InputStream;
import java.util.Properties;

import android.content.Context;

public class PropertiesUtil {
	
	private static Properties urlProps;
	
	public static Properties getProperties(Context c){
		Properties props = new Properties();
		try {
			//方法一：通过activity中的context攻取setting.properties的FileInputStream
//			InputStream in = c.getAssets().open("config.properties");
			//方法二：通过class获取setting.properties的FileInputStream
			InputStream in = PropertiesUtil.class.getResourceAsStream("/assets/config.properties "); 
			props.load(in);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		urlProps = props;
		//测试是否能获得setting.properties中url的值
		System.out.println(urlProps.getProperty("test"));
		return urlProps;
	}
}