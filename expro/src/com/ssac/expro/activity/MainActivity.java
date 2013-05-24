package com.ssac.expro.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

import com.ssac.expro.BaseActivity;
import com.ssac.expro.R;
import com.ssac.expro.service.MainService;

public class MainActivity extends BaseActivity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main);
		
		// 验证 成功 启动服务
		if (!MainService.isrun) {
			Intent it = new Intent(this,MainService.class);
			this.startService(it);
		} else {
			Intent it = new Intent("com.ssac.expro.service.MainService");
			this.stopService(it);
			
			Intent it2 = new Intent(this,MainService.class);
			
			this.startService(it2);
			
		}
		
		init();
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void refresh(Object... param) {
		// TODO Auto-generated method stub

	}
	
}
