package com.example.context;

import com.example.wechat.R;
import com.example.wechat.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

public class Context_penyouquan extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.contet_penyouquan);
	}
	
	public  void img_friend_back(View view) {
		finish();
	}
}
