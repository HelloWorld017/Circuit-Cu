package com.He.W.onebone.circuit.cu.android;

import java.util.ArrayList;

import com.He.W.onebone.circuit.cu.R;
import com.He.W.onebone.circuit.cu.component.EnumComponentType;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ComponentAdapter extends BaseAdapter {
	private LayoutInflater li;
	private ArrayList<EnumComponentType> al_items;
	private int[] counts;
	private Drawable[] drawables;
	private Context ctxt;

	
	public ComponentAdapter(Context ctxt_actv, ArrayList<EnumComponentType> al_data,int[] ari_cts, Drawable[] ard_dbs){
		ctxt = ctxt_actv;
		al_items = al_data;
		counts = ari_cts;
		drawables = ard_dbs;
	}
	//Wen you use this, please use overscrollmode OVER_SCROLL_IF_CONTENT_SCROLLS
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return al_items.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return al_items.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		if(arg1 == null){
			arg1 = li.inflate(R.layout.custom_list_view, arg2, false);
		}
		
		TextView t = (TextView) arg1.findViewById(R.id.textView1);
		TextView t2 = (TextView) arg1.findViewById(R.id.textView2);
		t.setCompoundDrawables(drawables[arg0], null, null, null);
		t2.setText(counts[arg0]);
		switch(al_items.get(arg0)){
		case COMPONENT_RESISTER:t.setText("Resister");break;
		case COMPONENT_ELECTRICITYBLOCKER:t.setText("Electricity Blocker");break;
		case COMPONENT_TRANSISTOR:t.setText("Transistor");break;
		case COMPONENT_WIRETOCOG:t.setText("Wire to Cog");break;
		case COMPONENT_COGTOWIRE:t.setText("Cog to Wire");break;
		case COMPONENT_COG:t.setText("Cog");break;
		case COMPONENT_WIRE:t.setText("Wire");break;
		default:t.setText("UNKNOWN COMPONENT");break;
		}

		
		return arg1;
	}

}
