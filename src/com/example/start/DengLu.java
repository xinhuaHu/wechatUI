package com.example.start;

import com.example.wechat.MainActivity;
import com.example.wechat.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class DengLu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_denglu);
	}

	public void denglu(View view) {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
}
