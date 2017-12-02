package com.example.sildingmenu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.wechat.R;

public class Sd_Menu extends Fragment{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_slidingmenu, container,false);
		
		String[] mystrings=new
				 String[]{"���","�ղ�","Ǯ��","����","����","����","����","��Ϸ","�˳�"};
				 ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,mystrings);
				 ListView listView = (ListView) view.findViewById(R.id.l_sliding);
				 listView.setAdapter(myAdapter);
				 return view;

	}
}
