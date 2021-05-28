package com.wyl.bus.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.wyl.bus.R;

public class CityActivity extends Activity {
	TextView city_text;
	Button btn_to_way;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_city);
		
//		city_text = (TextView) findViewById(R.id.city_text);
		btn_to_way = (Button) findViewById(R.id.btn_to_way);
		
		
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
//		getMenuInflater().inflate(R.menu.city, menu);
		return true;
	}
	
//	public boolean onOptionsItemSelected(MenuItem item){
//		System.out.println(item.getItemId());
//		switch (item.getItemId()) {
//			case R.id.action_settings:
//				MyCount myCount = (MyCount) getApplication();
//				String state = myCount.getState();
//				if("1".equals(state)){
//					myCount.setState("2");
//				}else {
//					myCount.setState("1");
//				}
//				startActivity(new Intent(CityActivity.this, CityActivity.class));
//				finish();
//				break;
//			default:
//				return super.onOptionsItemSelected(item);
//		}
//		return true;
//	}
}
