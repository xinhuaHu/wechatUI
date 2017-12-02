package com.example.adapter;

import java.util.List;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/**
 * PagerAdapter适配器
 * */
public class MyPageAdapter extends PagerAdapter {

	private Context context;
	private List<View> mViews;

	public MyPageAdapter(List<View> mViews) {
		this.mViews = mViews;
	}

	/**
	 * 重写四个方法 boolean isViewFromObject(View arg0, Object arg1) int getCount()
	 * void destroyItem(ViewGroup container, int position,Object object) Object
	 * instantiateItem(ViewGroup container, int position)
	 */
	// 从当前container中删除指定位置的view
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(mViews.get(position));
	}

	// 初始化View
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		View view = mViews.get(position);
		container.addView(view);
		return view;
	}

	@Override
	public int getCount() {
		return mViews.size();
	}

	// 返回要滑动的view个数
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

}
