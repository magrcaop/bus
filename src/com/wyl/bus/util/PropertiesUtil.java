package com.wyl.bus.util;

import java.io.InputStream;
import java.util.Properties;

import android.content.Context;

public class PropertiesUtil {
	
	private static Properties urlProps;
	/**
	 * 
	 * @param c getApplicationContext()
	 * @param filePath 如果放在assets下则为：config.properties
	 * @return
	 */
	public static Properties getProperties(Context c, String filePath){
		Properties props = new Properties();
		try {
			//方法一：通过activity中的context攻取setting.properties的FileInputStream
			InputStream in = c.getAssets().open(filePath);
			//方法二：通过class获取setting.properties的FileInputStream
//			InputStream in = PropertiesUtil.class.getResourceAsStream("/assets/config.properties "); 
			props.load(in);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		urlProps = props;
		return urlProps;
	}
}