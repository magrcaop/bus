package com.wyl.bus.common;

import android.app.Application;

public class MyCount extends Application{
	/**
	 * 选择城市
	 */
	private String city = "hzs";
	/**
	 * 选择上下行：上行1，下行2
	 */
	private String state = "1";

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
