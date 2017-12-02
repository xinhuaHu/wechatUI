package com.example.wechat;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.ActionBar.LayoutParams;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.adapter.MyFragmentPageAadpter;
import com.example.context.Context_Collect;
import com.example.context.Context_Money;
import com.example.context.Context_Setting;
import com.example.context.Context_biaoq;
import com.example.context.Context_kabao;
import com.example.context.Context_penyouquan;
import com.example.context.Context_xiance;
import com.example.sildingmenu.Sd_Menu;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class MainActivity extends FragmentActivity {

	// 定义四个Fragment
	private Fragment_WeiXin fWeiXin;
	private Fragment_TongXunLu fTongXunLu;
	private Fragment_FaXian fFaXian;
	private Fragment_Me fMe;

	// 定义一个ViewPager容器
	private ViewPager mPager;

	private ArrayList<Fragment> fragmentsList;
	private MyFragmentPageAadpter mAdapter;

	// 下面每个Layout对象
	private RelativeLayout weixin_layout, tongxunlu_layout, faxian_layout,
			me_layout;
	// 依次获得ImageView与TextView

	private ImageView weixin_img, tongxunlu_img, faxian_img, me_img;
	private TextView weixin_txt, tongxunlu_txt, faxian_txt, me_txt;

	// 定义颜色值
	private int Gray = 0xFF999999;
	private int Green = 0xFF45C01A;

	// 定义FragmentManager对象
	public FragmentManager fManager;

	// 定义一个Onclick全局对象
	public MyOnClick myclick;
	public MyPageChangeListener myPageChange;

	private PopupWindow mPopupwinow = null;// 加号
	private View view_pop;
	public ImageView img_tab_search, img_tab_add;

	private SlidingMenu slidingMenu;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getActionBar().hide();
		fManager = getSupportFragmentManager();
		initViewPager();
		initViews();
		initState();
		initMenuClick();
		initSliding();
	}

	private void initSliding() {
		slidingMenu = new SlidingMenu(this);
		slidingMenu.setMenu(R.layout.activity_silding_menuframe);
		FragmentManager fManager = getSupportFragmentManager();
		fManager.beginTransaction().replace(R.id.menuframe, new Sd_Menu()).commit();
		slidingMenu.setMode(SlidingMenu.LEFT);
		slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
		slidingMenu.setBehindWidthRes(R.dimen.slidingmenu_offset);
		slidingMenu.setFadeDegree(0.35f);
		slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
//		ActionBar aBar = this.getActionBar();
//		aBar.setDisplayHomeAsUpEnabled(true);

	}

	private void initViews() {
		myclick = new MyOnClick();
		myPageChange = new MyPageChangeListener();
		mPager = (ViewPager) findViewById(R.id.vPager);

		weixin_layout = (RelativeLayout) findViewById(R.id.weixin_layout);
		tongxunlu_layout = (RelativeLayout) findViewById(R.id.tongxunlu_layout);
		faxian_layout = (RelativeLayout) findViewById(R.id.faxian_layout);
		me_layout = (RelativeLayout) findViewById(R.id.me_layout);

		weixin_img = (ImageView) findViewById(R.id.weixin_img);
		tongxunlu_img = (ImageView) findViewById(R.id.tongxunlu_img);
		faxian_img = (ImageView) findViewById(R.id.faxian_img);
		me_img = (ImageView) findViewById(R.id.me_img);

		weixin_txt = (TextView) findViewById(R.id.weixin_txt);
		tongxunlu_txt = (TextView) findViewById(R.id.tongxunlu_txt);
		faxian_txt = (TextView) findViewById(R.id.faxian_txt);
		me_txt = (TextView) findViewById(R.id.me_txt);

		img_tab_add = (ImageView) findViewById(R.id.img_tab_add);
		img_tab_search = (ImageView) findViewById(R.id.img_tab_search);
		view_pop = LayoutInflater.from(MainActivity.this).inflate(
				R.layout.popwindow, null);

		mPager.setAdapter(mAdapter);
		mPager.setOnPageChangeListener(myPageChange);
		weixin_layout.setOnClickListener(myclick);
		tongxunlu_layout.setOnClickListener(myclick);
		faxian_layout.setOnClickListener(myclick);
		me_layout.setOnClickListener(myclick);
	}

	private void initMenuClick() {
		img_tab_search.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, Search.class);
				startActivity(intent);
			}
		});
		img_tab_add.setOnClickListener(new OnClickListener() {
			@Override
            public void onClick(View v) {
                AddPopWindow addPopWindow = new AddPopWindow(MainActivity.this);
                addPopWindow.showPopupWindow(img_tab_add);
            }
		});
	}
	
	private void initViewPager() {
		fragmentsList = new ArrayList<Fragment>();
		fWeiXin = new Fragment_WeiXin();
		fTongXunLu = new Fragment_TongXunLu();
		fFaXian = new Fragment_FaXian();
		fMe = new Fragment_Me();
		fragmentsList.add(fWeiXin);
		fragmentsList.add(fTongXunLu);
		fragmentsList.add(fFaXian);
		fragmentsList.add(fMe);
		mAdapter = new MyFragmentPageAadpter(fManager, fragmentsList);
	}

	// 定义一个设置初始状态的方法
	private void initState() {
		weixin_img.setImageResource(R.drawable.weixins);
		weixin_txt.setTextColor(Green);
		mPager.setCurrentItem(0);
	}

	public class MyOnClick implements OnClickListener {
		@Override
		public void onClick(View view) {
			clearChioce();
			iconChange(view.getId());
		}
	}

	public class MyPageChangeListener implements OnPageChangeListener {

		@Override
		public void onPageScrollStateChanged(int arg0) {
			if (arg0 == 2) {
				int i = mPager.getCurrentItem();
				clearChioce();
				iconChange(i);
			}
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

		@Override
		public void onPageSelected(int index) {
		
		}

	}

	// 建立一个清空选中状态的方法
	public void clearChioce() {
		weixin_img.setImageResource(R.drawable.weixinm);
		weixin_txt.setTextColor(Gray);
		tongxunlu_img.setImageResource(R.drawable.tongxunlum);
		tongxunlu_txt.setTextColor(Gray);
		faxian_img.setImageResource(R.drawable.faxianm);
		faxian_txt.setTextColor(Gray);
		me_img.setImageResource(R.drawable.mem);
		me_txt.setTextColor(Gray);
	}

	// 定义一个底部导航栏图标变化的方法
	public void iconChange(int num) {
		switch (num) {
		case R.id.weixin_layout:
		case 0:
			weixin_img.setImageResource(R.drawable.weixins);
			weixin_txt.setTextColor(Green);
			mPager.setCurrentItem(0);
			break;
		case R.id.tongxunlu_layout:
		case 1:
			tongxunlu_img.setImageResource(R.drawable.tongxunlus);
			tongxunlu_txt.setTextColor(Green);
			mPager.setCurrentItem(1);
			break;
		case R.id.faxian_layout:
		case 2:
			faxian_img.setImageResource(R.drawable.faxians);
			faxian_txt.setTextColor(Green);
			mPager.setCurrentItem(2);
			break;
		case R.id.me_layout:
		case 3:
			me_img.setImageResource(R.drawable.mes);
			me_txt.setTextColor(Green);
			mPager.setCurrentItem(3);
			break;
		}

	}
	
	
//************************************
	public void setting(View view) {
		Intent intent = new Intent(this, Context_Setting.class);
		startActivity(intent);
	}
	
	public void w_money(View view){
		Intent intent = new Intent(this, Context_Money.class);
		startActivity(intent);
	}
	
	public void w_collect(View view){
		Intent intent = new Intent(this, Context_Collect.class);
		startActivity(intent);
	}
	
	public void w_photo(View view){
		Intent intent = new Intent(this, Context_xiance.class);
		startActivity(intent);
	}
	
	public void f_penyou(View view){
		Intent intent = new Intent(this, Context_penyouquan.class);
		startActivity(intent);
	}
	
	public void w_card(View view) {
		Intent intent = new Intent(this, Context_kabao.class);
		startActivity(intent);
	}
	public void w_small(View view) {
		Intent intent = new Intent(this, Context_biaoq.class);
		startActivity(intent);
	}
	
//************************************
}
