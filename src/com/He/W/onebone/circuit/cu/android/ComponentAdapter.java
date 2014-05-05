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
	private Integer[] counts;
	private Drawable[] drawables;
	private Context ctxt;


	public ComponentAdapter(Context ctxt_actv, ArrayList<EnumComponentType> al_data,Integer[] ari_cts, Drawable[] ard_dbs){
		ctxt = ctxt_actv;
		al_items = al_data;
		counts = ari_cts;
		drawables = ard_dbs;
	}
	
	@SuppressWarnings("unchecked")
	public ComponentAdapter(Context ctxt_actv, ArrayList<Integer> al_itemdt){
		ctxt = ctxt_actv;
		ArrayList<EnumComponentType> alect = new ArrayList<EnumComponentType>();
		alect.add(0, EnumComponentType.COMPONENT_WIRE);
		alect.add(1, EnumComponentType.COMPONENT_ELECTRICITYBLOCKER);
		alect.add(2, EnumComponentType.COMPONENT_RESISTER);
		alect.add(3, EnumComponentType.COMPONENT_TRANSISTOR);
		alect.add(4, EnumComponentType.COMPONENT_WIRETOCOG);
		alect.add(5, EnumComponentType.COMPONENT_COGTOWIRE);
		alect.add(6, EnumComponentType.COMPONENT_COG);
		Object[] object = adjust((Integer[]) al_itemdt.toArray(), alect);
		al_items = (ArrayList<EnumComponentType>)object[1];
		counts = (Integer[])((ArrayList<Integer>)object[0]).toArray();
		Drawable[] draw = new Drawable[al_items.size()];
		for(int a = 0; a < al_items.size();a++){
			switch(al_items.get(a)){
			//TODO Insert Image!
			case COMPONENT_WIRE:draw[0] = draw[a] = ctxt.getResources().getDrawable(R.drawable.wire);break;
			case COMPONENT_ELECTRICITYBLOCKER:draw[0] = draw[a] = ctxt.getResources().getDrawable(R.drawable.electricityblocker);break;
			case COMPONENT_RESISTER:draw[0] = draw[a] = ctxt.getResources().getDrawable(R.drawable.resister);break;
			case COMPONENT_TRANSISTOR:draw[0] = draw[a] = ctxt.getResources().getDrawable(R.drawable.transistor);break;
			case COMPONENT_WIRETOCOG:draw[0] = draw[a] = ctxt.getResources().getDrawable(R.drawable.wiretocog);break;
			case COMPONENT_COGTOWIRE:draw[0] = draw[a] = ctxt.getResources().getDrawable(R.drawable.cogtowire);break;
			case COMPONENT_COG:draw[0] = draw[a] = ctxt.getResources().getDrawable(R.drawable.cog);break;
			}
		}
		drawables = draw;
		
		
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
	
	
	public Object[] adjust(Integer[] ct, ArrayList<EnumComponentType> alect){
		int a = 0;
		ArrayList<Integer> temp = new ArrayList<Integer>();
		ArrayList<EnumComponentType> alect_temp = new ArrayList<EnumComponentType>();
		int ar = 0;
		while(true){
			
			if(ct[a] != 0){
				temp.add(ar, ct[a]);
				alect_temp.add(ar, alect.get(a));
				ar++;
			}
			
			a++;
			if(ct.length - 1 <= a){
				break;
			}
		}
		Object[] obj = new Object[2];
		obj[0] = temp;
		obj[1] = alect_temp;
		return obj;
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
