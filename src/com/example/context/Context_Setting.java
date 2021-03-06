package com.example.context;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.start.DengLu;
import com.example.start.Start;
import com.example.wechat.Fragment_Me;
import com.example.wechat.MainActivity;
import com.example.wechat.R;

public class Context_Setting extends Activity {

	private TextView tuichu;
	private ImageView img_set_back;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.context_setting);
		img_set_back = (ImageView) findViewById(R.id.img_set_back);
		img_set_back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}

	public void tuichu(View view) {
		Intent intent = new Intent(this, Start.class);
		startActivity(intent);
		finish();
	}
}
