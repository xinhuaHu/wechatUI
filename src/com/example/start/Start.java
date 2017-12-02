package com.example.start;

import com.example.wechat.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class Start extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_start);
	}

	public void startdelu(View view) {
		Intent intent = new Intent(this, DengLu.class);
		startActivity(intent);
		finish();
	}

	public void startzhuce(View view) {
		Intent intent = new Intent(this, Zhuce.class);
		startActivity(intent);
		finish();
	}
}
