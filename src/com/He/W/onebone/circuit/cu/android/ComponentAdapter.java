package com.He.W.onebone.circuit.cu.android;

import java.util.HashMap;

import com.He.W.onebone.circuit.cu.R;
import com.He.W.onebone.circuit.cu.component.EnumComponentType;
import com.He.W.onebone.circuit.cu.settings.Setting;


import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

//This code is concise. Not a spaghetti.
//140617 17:35 He.W Code cleared.

public class ComponentAdapter extends BaseAdapter {
	private LayoutInflater li;
	private HashMap<EnumComponentType, Drawable> drawable_record = new HashMap<EnumComponentType, Drawable>(); 
	private HashMap<EnumComponentType, Integer> hm;
	
	public ComponentAdapter(Context ctx, HashMap<EnumComponentType, Integer> hm){
		li = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		drawable_record.put(EnumComponentType.COMPONENT_COPPER_WIRE, ctx.getResources().getDrawable(R.drawable.copper_wire));
		drawable_record.put(EnumComponentType.COMPONENT_GOLD_WIRE, ctx.getResources().getDrawable(R.drawable.gold_wire));
		drawable_record.put(EnumComponentType.COMPONENT_RESISTOR, ctx.getResources().getDrawable(R.drawable.resistor));
		drawable_record.put(EnumComponentType.COMPONENT_TRANSISTOR, ctx.getResources().getDrawable(R.drawable.transistor));
		
		this.hm = hm;
	}
	
	// When you make a listview, use overscrollmode OVER_SCROLL_IF_CONTENT_SCROLLS
	@Override
	public int getCount() {
		return hm.size();
	}

	@Override
	public Object getItem(int arg0) {
		//if arg0 is 0 : goldwire 1 : copperwire 2: resistor 3: transistor
		switch(arg0){
		case 0:return EnumComponentType.COMPONENT_GOLD_WIRE;
		case 1:return EnumComponentType.COMPONENT_COPPER_WIRE;
		case 2:return EnumComponentType.COMPONENT_RESISTOR;
		case 3:return EnumComponentType.COMPONENT_TRANSISTOR;
		default:return null;
		}
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	public void addItemToInventory(EnumComponentType AddingItem, int AddingCount){
		Integer item = hm.get(AddingItem);
		if(item == null){
			hm.put(AddingItem, AddingCount);
		}else{
			hm.remove(AddingItem);
			hm.put(AddingItem, item + AddingCount);
		}
		this.notifyDataSetChanged();
	}
	
	
	public void useItem(EnumComponentType usingItem, int usingCount){
		Integer item = hm.get(usingItem);
		if(item != null && !(item <= 0)){
			hm.remove(usingItem);
			hm.put(usingItem, item + usingCount);
			adjust();
			this.notifyDataSetChanged();
		}
	}
	public void adjust(){
		EnumComponentType[] values = EnumComponentType.values();
		for(int a = 0;a < values.length;a++){
			if((hm.get(values[a]) != null) && !(hm.get(values[a]) <= 0)){
				hm.remove(values[a]);
			}
		}
		this.notifyDataSetChanged();
	}
	
	//TODO if bug occures
	// I don't know if this works correctly. If Stackoverflow Exception occurs, check this part. OR this may be useless.
	/*public void update(){
		this.notifyDataSetChanged();
	}*/ // Adapter.notifyDataSetChanged() is public method, this method is useless
	
	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2){
		if(arg1 == null){
			arg1 = li.inflate(R.layout.custom_list_view, arg2, false);
		}
		EnumComponentType ect = null;
		TextView t = (TextView) arg1.findViewById(R.id.textView1);
		TextView t2 = (TextView) arg1.findViewById(R.id.textView2);
		switch(arg0){
		case 0:ect = EnumComponentType.COMPONENT_GOLD_WIRE;
		case 1:ect = EnumComponentType.COMPONENT_COPPER_WIRE;
		case 2:ect = EnumComponentType.COMPONENT_RESISTOR;
		case 3:ect = EnumComponentType.COMPONENT_TRANSISTOR;
		}
		switch(ect){
		case COMPONENT_RESISTOR:t.setText(R.string.component_resistor);break;
		case COMPONENT_TRANSISTOR:t.setText(R.string.component_transistor);break;
		case COMPONENT_COPPER_WIRE:t.setText(R.string.component_copper_wire);break;
		case COMPONENT_GOLD_WIRE:t.setText(R.string.component_gold_wire);break;
		default:t.setText(R.string.component_unknown);break;
		}
		
		Typeface tf = (Typeface)Setting.getPrefix(0);
		t.setTypeface(tf);
		t2.setTypeface(tf);
		t.setCompoundDrawables(drawable_record.get(ect), null, null, null);
		t2.setText(hm.get(ect));

		return arg1;
		
	}

}
