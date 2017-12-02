package com.example.wechat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.context.ChatRoom;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts.Data;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment_WeiXin extends Fragment {

	private ListView listview_w;
	private List<Map<String, Object>> mList;

//	private TextView l_tvname;

	// private View view;

	// private SimpleAdapter mAdapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater
				.inflate(R.layout.fragment_weixin, container, false);
		listview_w = (ListView) view.findViewById(R.id.listview_w);
//		l_tvname = (TextView) view.findViewById(R.id.l_tvname);
		mList = getData();
		// mList = new ArrayList<Map<String, Object>>();
		// mAdapter = new SimpleAdapter(getActivity(), getData(),
		// R.layout.list_item, new String[] { "l_head", "l_tvname",
		// "l_tvmsg" }, new int[] { R.id.l_head, R.id.l_tvname,
		// R.id.l_tvmsg });
		ListAdapter mAdapter = new ListAdapter(getActivity());
		listview_w.setAdapter(mAdapter);

		listview_w.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent(getActivity(), ChatRoom.class);
				startActivity(intent);
			}
		});
		return view;
	}

	static class ViewHolder {
		public ImageView l_head;
		public TextView l_tvname;
		public TextView l_tvmsg;
	}

	class ListAdapter extends BaseAdapter {

		private LayoutInflater mInflater = null;

		private ListAdapter(Context context) {
			this.mInflater = LayoutInflater.from(context);
		}

		@Override
		public int getCount() {
			return mList.size();
		}

		@Override
		public Object getItem(int position) {
			return mList.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder = null;
			if (convertView == null) {
				holder = new ViewHolder();
				// 根据自定义的Item布局加载布局
				convertView = mInflater.inflate(R.layout.list_item, null);
				holder.l_head = (ImageView) convertView.findViewById(R.id.l_head);
				holder.l_tvname = (TextView) convertView.findViewById(R.id.l_tvname);
				holder.l_tvmsg = (TextView) convertView.findViewById(R.id.l_tvmsg);
				convertView.setTag(holder);
			} else 
				holder = (ViewHolder) convertView.getTag();
			holder.l_head.setImageResource((Integer) mList.get(position).get("l_head"));
			holder.l_tvname.setText((String) mList.get(position).get("l_tvname"));
			holder.l_tvmsg.setText((String) mList.get(position).get("l_tvmsg"));
			return convertView;
		}

	}

	public List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < 20; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("l_head", R.drawable.head);
			map.put("l_tvname", "软件152");
			map.put("l_tvmsg", "有时候你不努力一下,都不知道什么叫做绝望");
			list.add(map);
		}
		return list;
	}

}
