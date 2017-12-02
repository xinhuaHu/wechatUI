package com.example.context;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;

import com.example.wechat.MainActivity;
import com.example.wechat.R;

public class ChatRoom extends Activity implements OnClickListener{

	private ImageView img_chat_back,img_single;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_chat);
		img_chat_back = (ImageView) findViewById(R.id.img_chat_back);
		img_single = (ImageView) findViewById(R.id.img_single);
		
		img_single.setOnClickListener(this);
		img_chat_back.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.img_chat_back:
			Intent intent = new Intent(this,MainActivity.class);
			startActivity(intent);
			finish();
			break;
		case R.id.img_single:
			Intent intent2 = new Intent(this,ChatMessage.class);
			startActivity(intent2);
			break;
		default:
			break;
		}
	}

}
