package com.example.guide;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;

import com.example.wechat.MainActivity;
import com.example.wechat.R;

public class Welcome extends Activity {

	private boolean isFristOpen = false;

	private static final int TIME = 1000;
	private static final int TO_MAIN = 100001;
	private static final int TO_GUIDE = 100002;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.welcome);
		isFristOpen();
	}

	Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case TO_MAIN:
				Intent intent = new Intent(Welcome.this, MainActivity.class);
				startActivity(intent);
				finish();
				break;
			case TO_GUIDE:
				Intent intent2 = new Intent(Welcome.this, Guide.class);
				startActivity(intent2);
				finish();
				break;
			default:
				break;
			}
		}
	};

	private void isFristOpen() {
		SharedPreferences preferences = getSharedPreferences("firsr",
				MODE_PRIVATE);
		isFristOpen = preferences.getBoolean("isFristOpen", true);
		if (!isFristOpen) {
			mHandler.sendEmptyMessageDelayed(TO_MAIN, TIME);
		} else {
			mHandler.sendEmptyMessageDelayed(TO_GUIDE, TIME);
			Editor editor = preferences.edit();
			editor.putBoolean("isFristOpen", false);
			editor.commit();
		}
	}
}
