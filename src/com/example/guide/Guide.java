package com.example.guide;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.adapter.MyPageAdapter;
import com.example.start.Start;
import com.example.wechat.R;

public class Guide extends Activity {
	private ViewPager gViewPager;
	private List<View> mViews = new ArrayList<View>();
	private MyPageAdapter mAdapter = new MyPageAdapter(mViews);

	private LinearLayout ll;
	private ImageView img_dot1, img_dot2, img_dot3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.guide);
		initView();
		initEvent();

	}

	private void initView() {
		gViewPager = (ViewPager) findViewById(R.id.guideviewpager);

		ll = (LinearLayout) findViewById(R.id.ll);

		img_dot1 = (ImageView) findViewById(R.id.img_dot1);
		img_dot2 = (ImageView) findViewById(R.id.img_dot2);
		img_dot3 = (ImageView) findViewById(R.id.img_dot3);

		LayoutInflater mInflater = LayoutInflater.from(this);
		View guide1 = mInflater.inflate(R.layout.guide1, null);
		View guide2 = mInflater.inflate(R.layout.guide2, null);
		View guide3 = mInflater.inflate(R.layout.guide3, null);

		mViews.add(guide1);
		mViews.add(guide2);
		mViews.add(guide3);

		gViewPager.setAdapter(mAdapter);
	}

	private void initEvent() {
		gViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(int arg0) {
				resetImg();
				int currentItem = gViewPager.getCurrentItem();
				switch (currentItem) {
				case 0:
					img_dot1.setImageResource(R.drawable.pointselect);
					break;
				case 1:
					img_dot2.setImageResource(R.drawable.pointselect);
					break;
				case 2:
					img_dot3.setImageResource(R.drawable.pointselect);
					break;
				default:
					break;
				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
	}

	private void resetImg() {
		img_dot1.setImageResource(R.drawable.pointnormal);
		img_dot2.setImageResource(R.drawable.pointnormal);
		img_dot3.setImageResource(R.drawable.pointnormal);
	}

	public void towechat(View view) {
		Intent intent = new Intent(Guide.this, Start.class);
		startActivity(intent);
		finish();
	}
}
