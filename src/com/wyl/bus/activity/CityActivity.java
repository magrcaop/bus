package com.wyl.bus.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.wyl.bus.R;
import com.wyl.bus.common.MyCount;

public class CityActivity extends Activity {
	private TextView city_text;
	private Button btn_to_way;
	private TextView hello_text;
	private String helloWorld;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_city);
		
//		city_text = (TextView) findViewById(R.id.city_text);
		hello_text = (TextView) findViewById(R.id.hello_world);
		btn_to_way = (Button) findViewById(R.id.btn_to_way);
		
		MyCount myCount = (MyCount) getApplication();
		helloWorld = myCount.getHelloWorld();
		hello_text.setText(helloWorld);
		
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
	
	public boolean onOptionsItemSelected(MenuItem item){
		System.out.println(item.getItemId());
		switch (item.getItemId()) {
			case R.id.action_settings:
				MyCount myCount = (MyCount) getApplication();
				String city = myCount.getCity();
				if("hzs".equals(city)){
					myCount.setCity("yqs");
					myCount.setHelloWorld("欢迎使用“乐清公交 一览”，点击下面的按钮查看公交列表");
				}else {
					myCount.setCity("hzs");
					myCount.setHelloWorld("欢迎使用“杭州公交 一览”，点击下面的按钮查看公交列表");
				}
				startActivity(new Intent(CityActivity.this, CityActivity.class));
				finish();
				break;
			default:
				return super.onOptionsItemSelected(item);
		}
		return true;
	}
}
