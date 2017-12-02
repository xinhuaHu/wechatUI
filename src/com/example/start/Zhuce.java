package com.example.start;

import com.example.wechat.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Zhuce extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zhuce);
	}

	public void zhuce(View view) {
		Intent intent = new Intent(this, DengLu.class);
		Toast.makeText(this, "×¢²á³É¹¦!", Toast.LENGTH_SHORT).show();
		startActivity(intent);
		finish();
	}
}
