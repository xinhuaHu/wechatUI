package com.example.adapter;

import java.util.List;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/**
 * PagerAdapter������
 * */
public class MyPageAdapter extends PagerAdapter {

	private Context context;
	private List<View> mViews;

	public MyPageAdapter(List<View> mViews) {
		this.mViews = mViews;
	}

	/**
	 * ��д�ĸ����� boolean isViewFromObject(View arg0, Object arg1) int getCount()
	 * void destroyItem(ViewGroup container, int position,Object object) Object
	 * instantiateItem(ViewGroup container, int position)
	 */
	// �ӵ�ǰcontainer��ɾ��ָ��λ�õ�view
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(mViews.get(position));
	}

	// ��ʼ��View
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

	// ����Ҫ������view����
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

}
