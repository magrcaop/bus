package com.wyl.bus.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.wyl.bus.R;
import com.wyl.bus.common.MyCount;
import com.wyl.bus.util.PropertiesUtil;
import com.wyl.bus.util.StringUtil;

public class DetailActivity extends Activity {
	private List<Map<String, Object>> mList;//用来存放要显示的数据
	private ListView mListView;
	/**
	 * SimpleAdapter是ListView 数据的一个容器， 
	 * 用来存放显示在ListView上的数据。
	 * 对 SimpleAdapter 的数据操作会直接影响到ListView的显示。
	 */
	private SimpleAdapter mListAdapter;
	
	private TextView way;
	private TextView time;
	/**
	 * 上行1，下行2
	 */
	private String state;
	/**
	 * 城市
	 */
	private String city;
	/**
	 * 传来的第几路
	 */
	private String wayNum;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);

		MyCount myCount = (MyCount) getApplication();
		state = myCount.getState();
		city = myCount.getCity();
		
		mListView = (ListView) findViewById(R.id.list_detail);
		way = (TextView) findViewById(R.id.list_detail_title);
		time = (TextView) findViewById(R.id.list_detail_time);
		
		Intent getIntent = getIntent();
		
		wayNum = (String) getIntent.getSerializableExtra("wayNum");

		way.setText(wayNum.replace("night", "夜班车")+"路");
		Properties p = PropertiesUtil.getProperties(getApplicationContext(), city+"_bus.properties");
		time.setText((String) p.get(wayNum+"_time_"+state));
		
		mList = new ArrayList<Map<String,Object>>();
		Properties pro = PropertiesUtil.getProperties(getApplicationContext(), city+"_detail.properties");

		String detail = StringUtil.iso2Utf8((String) pro.get(wayNum+"_"+state));
		String[] details = detail.split(",");
		for (int i=0; i<details.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("num", i+1);
			map.put("detail", details[i]);
			
			mList.add(map);
		}
		
		mListAdapter = null;
		mListAdapter = new SimpleAdapter(this, mList, R.layout.detail_list, 
				new String[]{"num", "detail"},
				new int[]{R.id.detail_list_num, R.id.detail_list_name});
		mListView.setAdapter(mListAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detail, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item){
		switch (item.getItemId()) {
			case R.id.action_settings:
				MyCount myCount = (MyCount) getApplication();
				String state = myCount.getState();
				if("1".equals(state)){
					myCount.setState("2");
				}else {
					myCount.setState("1");
				}
				startActivity(new Intent(DetailActivity.this, DetailActivity.class).putExtra("wayNum", wayNum));
				finish();
				break;
			default:
				return super.onOptionsItemSelected(item);
		}
		return true;
	}

}
