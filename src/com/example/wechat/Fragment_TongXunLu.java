package com.example.wechat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.widget.PersonBean;
import com.example.widget.PinyinComparator;
import com.example.widget.PinyinUtils;
import com.example.widget.SideBar;
import com.example.widget.SideBar.OnTouchingLetterChangedListener;
import com.example.widget.SortAdapter;

public class Fragment_TongXunLu extends Fragment {

	private ListView listView;
	private SortAdapter sortadapter;
	private List<PersonBean> data;
	private SideBar sidebar;
	private TextView dialog;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_tongxunlu, container,
				false);
		
		sidebar = (SideBar) view.findViewById(R.id.sidebar);
		listView = (ListView) view.findViewById(R.id.listview);
		dialog = (TextView)view. findViewById(R.id.dialog);
		sidebar.setTextView(dialog);
		// 设置字母导航触摸监听
		sidebar.setOnTouchingLetterChangedListener(new OnTouchingLetterChangedListener() {

			@Override
			public void onTouchingLetterChanged(String s) {
				// TODO Auto-generated method stub
				// 该字母首次出现的位置
				int position = sortadapter.getPositionForSelection(s.charAt(0));

				if (position != -1) {
					listView.setSelection(position);
				}
			}
		});
		
		data = getData(getResources().getStringArray(R.array.listpersons));
		// 数据在放在adapter之前需要排序
		Collections.sort(data, new PinyinComparator());
		sortadapter = new SortAdapter(getActivity(), data);
		listView.setAdapter(sortadapter);
		
		return view;
	}

	private List<PersonBean> getData(String[] data) {
		List<PersonBean> listarray = new ArrayList<PersonBean>();
		for (int i = 0; i < data.length; i++) {
			String pinyin = PinyinUtils.getPingYin(data[i]);
			String Fpinyin = pinyin.substring(0, 1).toUpperCase();

			PersonBean person = new PersonBean();
			person.setName(data[i]);
			person.setPinYin(pinyin);
			// 正则表达式，判断首字母是否是英文字母
			if (Fpinyin.matches("[A-Z]")) {
				person.setFirstPinYin(Fpinyin);
			} else {
				person.setFirstPinYin("#");
			}

			listarray.add(person);
		}
		return listarray;

	}
    
}
