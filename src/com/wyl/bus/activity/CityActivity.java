package com.wyl.bus.activity;

import java.util.Properties;

import com.wyl.bus.R;
import com.wyl.bus.R.id;
import com.wyl.bus.R.layout;
import com.wyl.bus.R.menu;
import com.wyl.bus.util.PropertiesUtil;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class CityActivity extends Activity {
	TextView city_text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_city);
		
		city_text = (TextView) findViewById(R.id.city_text);
		Properties properties = PropertiesUtil.getProperties(getApplicationContext());
		
		String str = (String) properties.get("test");
		city_text.setText(str);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.city, menu);
		return true;
	}

}
