package com.wyl.bus.activity;

import java.util.Properties;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.wyl.bus.R;
import com.wyl.bus.util.PropertiesUtil;

public class CityActivity extends Activity {
	TextView city_text;
	Button btn_to_way;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_city);
		
//		city_text = (TextView) findViewById(R.id.city_text);
		btn_to_way = (Button) findViewById(R.id.btn_to_way);
		
//		Properties pro = PropertiesUtil.getProperties(getApplicationContext(), "bus.properties");
//		String s = (String) pro.get("way");
//		
//		city_text.setText(s);
		
		btn_to_way.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(CityActivity.this, WayActivity.class));
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.city, menu);
		return true;
	}
	
	public boolean onKeyDown(int keyCode, KeyEvent event){
		if(keyCode == KeyEvent.KEYCODE_BACK){
			System.exit(0);
		}
		return true;
	}

}
