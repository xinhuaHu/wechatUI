package com.example.context;

import com.example.wechat.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class Context_Money extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.context_money);
	}

	public void img_money_back(View view) {
		finish();
	}
}
