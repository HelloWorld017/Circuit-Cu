package com.He.W.onebone.circuit.cu.android;

import java.util.ArrayList;

import com.He.W.onebone.circuit.cu.R;
import com.He.W.onebone.circuit.cu.settings.EnumSettings;
import com.He.W.onebone.circuit.cu.settings.SettingSpefHelper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class SettingAdapter extends BaseAdapter {
	ArrayList<Object[]> database;
	private LayoutInflater li;
	
	public SettingAdapter(Context ctx){
		database = new ArrayList<Object[]>();
		EnumSettings[] es = EnumSettings.values();
		SettingSpefHelper ssh = new SettingSpefHelper(ctx);
		//obj index
		/*
		 * 0 = Setting enum value
		 * 1 = Setting id
		 * 2 = Setting tips
		 * 3 = Setting value
		 * 4 = Setting visibility
		 * 5 = does setting needs restart
		 * 6 = parent of setting
		 * 7 = name of setting
		 */

		for(int a = 0; a < es.length; a++){
			Object[] obj = new Object[es.length];
			obj[0] = es[a];
			obj[1] = ssh.getSettingId(es[a]);
			obj[2] = ssh.getSettingTips(es[a]);
			obj[3] = ssh.getValue(es[a]);
			obj[4] = ssh.isVisible(es[a]);
			obj[5] = ssh.isNeededRestart(es[a]);
			obj[6] = ssh.getParent(es[a]);
			obj[7] = ssh.getName(es[a]);
		}
	}
	
	
	// When you make a listview, use overscrollmode OVER_SCROLL_IF_CONTENT_SCROLLS
	@Override
	public int getCount() {
		return database.size();
	}

	@Override
	public Object getItem(int arg0) {
		return database.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}


	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		if(arg1 == null){
			arg1 = li.inflate(R.layout.custom_list_view, arg2, false);
		}
		TextView SettingName = (TextView) arg1.findViewById(R.id.lblSettingName);
		TextView SettingDesc = (TextView) arg1.findViewById(R.id.lblSettingDesc);
		Button Modify = (Button) arg1.findViewById(R.id.btnModify);
		SettingName.setText(String.valueOf(database.get(arg0)[7]));
		SettingDesc.setText(String.valueOf(database.get(arg0)[3]));
		Modify.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				return false;
			}
		});
		return arg1;
	}

}
