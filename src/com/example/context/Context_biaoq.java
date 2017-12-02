package com.example.context;

import com.example.wechat.R;
import com.example.wechat.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

public class Context_biaoq extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.context_biaoq);
	}
	
	public void img_biaoq_back(View view) {
		finish();
	}
}
