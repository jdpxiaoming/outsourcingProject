package com.ssac.expro.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

import com.ssac.expro.BaseActivity;
import com.ssac.expro.R;

public class Activity_Map extends BaseActivity implements OnClickListener{

	private LinearLayout lin_home,lin_art,lin_vip,lin_map,lin_more;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.layout_home);
		
		
		init();
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		lin_home=	(LinearLayout) findViewById(R.id.linearHOme);
		lin_art	= 	(LinearLayout) findViewById(R.id.linearNews);
		lin_vip	=	(LinearLayout) findViewById(R.id.linearVip);
		lin_map	=	(LinearLayout) findViewById(R.id.linearMap);
		lin_more=	(LinearLayout) findViewById(R.id.linearMore);
		
		lin_home.setOnClickListener(this);
		lin_art.setOnClickListener(this);
		lin_vip.setOnClickListener(this);
		lin_map.setOnClickListener(this);
		lin_more.setOnClickListener(this);
	}

	@Override
	public void refresh(Object... param) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		switch (v.getId()) {
		case R.id.linearHOme:
			intent.setFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
			intent.setClass(this, Activity_Home.class);
			startActivity(intent);
			break;
		case R.id.linearNews:
			intent.setFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
			intent.setClass(this, Activity_Art.class);
			startActivity(intent);
			break;
		case R.id.linearVip:
			intent.setFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
			intent.setClass(this, Activity_VIP.class);
			startActivity(intent);
			break;
		case R.id.linearMap:
//			intent.setFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
//			intent.setClass(this, Activity_Map.class);
//			startActivity(intent);
			break;
		case R.id.linearMore:
			intent.setFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
			intent.setClass(this, Activity_More.class);
			startActivity(intent);
			break;

		default:
			break;
		}
		overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left); 
	}
	
}
