package com.wyl.bus.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;


public class PropertiesUrlUtil {

	private static Properties urlProps;
	private static final String path = "/data/data/com.jansun.activity/setting.properties";
	//private FileUtils fu = new FileUtils();
	public static Properties getProperties(){
		Properties props = new Properties();
		try {
			InputStream in = new FileInputStream(getSettingFile());
			props.load(in);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		urlProps = props;
		return urlProps;
	}

	public static void setProperties( String param, String value ){
		Properties props = new Properties();
		try {
			props.load(new FileInputStream( getSettingFile() ));

//			OutputStream out = new FileOutputStream(FileUtils.setting);
			Enumeration<?> e = props.propertyNames();
			if(e.hasMoreElements()){
				while(e.hasMoreElements()){
					String s = (String)e.nextElement();
					if(!s.equals(param))
						props.setProperty(s, props.getProperty(s));
				}
			}
			props.setProperty(param, value);
//			props.store(out, null);
			//测试是否能够打印出最新的，刚刚修改的url的值
			//System.out.println("setProperty success: " + props.getProperty(param));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static File getSettingFile(){
		File setting = new File(path);
		if(!setting.exists())
			try {
				setting.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		return setting;
	}
}