package com.He.W.onebone.circuit.cu.android;

import java.util.ArrayList;

import com.He.W.onebone.circuit.cu.R;
import com.He.W.onebone.circuit.cu.gamebase.AudioHelper;
import com.He.W.onebone.circuit.cu.settings.EnumSettingParents;
import com.He.W.onebone.circuit.cu.settings.EnumSettings;
import com.He.W.onebone.circuit.cu.settings.Setting;
import com.He.W.onebone.circuit.cu.settings.SettingSpefHelper;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
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
	private Context ctxt;
	
	public SettingAdapter(Context ctx){
		li = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		Log.d("PrL1bug", "adapter constructor");
		ctxt = ctx;
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
		 * 8 = is Parent
		 */
		ArrayList<EnumSettingParents> esp = new ArrayList<EnumSettingParents>();
		for(int a = 0; a < es.length; a++){
			Object[] obj = new Object[9];
			EnumSettings esa = es[a];
			obj[0] = esa;
			obj[1] = ssh.getSettingId(esa);
			obj[2] = ssh.getSettingTips(esa);
			obj[3] = ssh.getValue(esa);
			obj[4] = ssh.isVisible(esa);
			obj[5] = ssh.isNeededRestart(esa);
			obj[6] = ssh.getParent(esa);
			obj[7] = ssh.getName(esa);
			obj[8] = false;
			if(!(esp.contains((EnumSettingParents)obj[6]))){
				Object[] parent  = new Object[9];
				parent[0] = obj[6];
				parent[8] = true;
				database.add(parent);
				esp.add((EnumSettingParents) obj[6]);
			}
			database.add(obj);
		}
		Log.d("PrL1bug", "data : " + database.size());
	}
	
	
	// When you make a listview, use overscrollmode OVER_SCROLL_IF_CONTENT_SCROLLS
	@Override
	public int getCount() {
		Log.d("PrL1bug", "getCount ");
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
	public View getView(final int arg0, View arg1, ViewGroup arg2) {
		Log.d("PrL1bug", "getView");
		if(arg1 == null){
			arg1 = li.inflate(R.layout.custom_setting_list_view, arg2, false);
		}
		
		
		TextView settingName = (TextView) arg1.findViewById(R.id.lblSettingName);
		TextView settingDesc = (TextView) arg1.findViewById(R.id.lblSettingDesc);
		Button modify = (Button) arg1.findViewById(R.id.btnModify);
		if(((Boolean)database.get(arg0)[8]).booleanValue()){
			settingDesc.setVisibility(View.GONE);
			modify.setVisibility(View.GONE);
			String s = "";
			switch((EnumSettingParents)database.get(arg0)[0]){
			case LooknFeel:s = "Look & Feel";break;
			default:s = ((EnumSettingParents)database.get(arg0)[0]).name();break;
			}
			settingName.setText(s);
			Typeface tf = (Typeface) Setting.getPrefix(0);
			settingName.setTypeface(tf);
			settingName.setTextSize(50);
			return arg1;
		}	
		settingName.setText(String.valueOf(database.get(arg0)[7]));
		settingDesc.setText(String.valueOf(database.get(arg0)[2]));
		modify.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent me) {
				if(me.getAction() == MotionEvent.ACTION_UP){
					AudioHelper.playEffect(ctxt, 0);
					SettingDialog sd = new SettingDialog(ctxt,(EnumSettings)database.get(arg0)[0]);
					sd.setTitle(R.string.layout_modify_value);
					sd.show();
				}
				return false;
			}
		});
		Typeface tf = (Typeface) Setting.getPrefix(0);
		settingName.setTypeface(tf);
		settingDesc.setTypeface(tf);
		modify.setTypeface(tf);
		return arg1;
	}

}
