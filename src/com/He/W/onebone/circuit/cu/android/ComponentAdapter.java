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
	private Context ctx;


	public ComponentAdapter(Context ctx, ArrayList<EnumComponentType> al_data,Integer[] ari_cts, Drawable[] ard_dbs){
		this.ctx = ctx;
		al_items = al_data;
		counts = ari_cts;
		drawables = ard_dbs;
	}
	
	@SuppressWarnings("unchecked")
	public ComponentAdapter(Context ctx, ArrayList<Integer> al_itemdt){
		this.ctx = ctx;
		ArrayList<EnumComponentType> alect = new ArrayList<EnumComponentType>();
		alect.add(0, EnumComponentType.COMPONENT_COPPER_WIRE);
		alect.add(1, EnumComponentType.COMPONENT_ELECTRICITYBLOCKER);
		alect.add(2, EnumComponentType.COMPONENT_RESISTOR);
		alect.add(3, EnumComponentType.COMPONENT_TRANSISTOR);
		alect.add(4, EnumComponentType.COMPONENT_WIRETOCOG);
		alect.add(5, EnumComponentType.COMPONENT_COGTOWIRE);
		alect.add(6, EnumComponentType.COMPONENT_COG);
		alect.add(7, EnumComponentType.COMPONENT_GOLD_WIRE);
		Object[] object = adjust((Integer[]) al_itemdt.toArray(), alect);
		al_items = (ArrayList<EnumComponentType>)object[1];
		counts = (Integer[])((ArrayList<Integer>)object[0]).toArray();
		Drawable[] draw = new Drawable[al_items.size()];
		for(int a = 0; a < al_items.size();a++){
			switch(al_items.get(a)){
			//TODO Insert Image!
			case COMPONENT_GOLD_WIRE:draw[0] = draw[a] = ctx.getResources().getDrawable(R.drawable.gold_wire);break;
			case COMPONENT_ELECTRICITYBLOCKER:draw[0] = draw[a] = ctx.getResources().getDrawable(R.drawable.electricityblocker);break;
			case COMPONENT_RESISTOR:draw[0] = draw[a] = ctx.getResources().getDrawable(R.drawable.resister);break;
			case COMPONENT_TRANSISTOR:draw[0] = draw[a] = ctx.getResources().getDrawable(R.drawable.transistor);break;
			case COMPONENT_WIRETOCOG:draw[0] = draw[a] = ctx.getResources().getDrawable(R.drawable.wiretocog);break;
			case COMPONENT_COGTOWIRE:draw[0] = draw[a] = ctx.getResources().getDrawable(R.drawable.cogtowire);break;
			case COMPONENT_COG:draw[0] = draw[a] = ctx.getResources().getDrawable(R.drawable.cog);break;
			case COMPONENT_COPPER_WIRE:draw[0] = draw[a] = ctx.getResources().getDrawable(R.drawable.copper_wire);break;
			default:break;
			break;
			}
		}
		drawables = draw;
		
		
	}
	// When you use this, use overscrollmode OVER_SCROLL_IF_CONTENT_SCROLLS
	@Override
	public int getCount() {
		return al_items.size();
	}

	@Override
	public Object getItem(int arg0) {
		return al_items.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
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
		if(arg1 == null){
			arg1 = li.inflate(R.layout.custom_list_view, arg2, false);
		}
		
		TextView t = (TextView) arg1.findViewById(R.id.textView1);
		TextView t2 = (TextView) arg1.findViewById(R.id.textView2);
		t.setCompoundDrawables(drawables[arg0], null, null, null);
		t2.setText(counts[arg0]);
		switch(al_items.get(arg0)){
		case COMPONENT_RESISTOR:t.setText(ctx.getString(R.string.component_resistor));break;
	//	case COMPONENT_ELECTRICITYBLOCKER:t.setText("Electricity Blocker");break; This is not component!!
		case COMPONENT_TRANSISTOR:t.setText(ctx.getString(R.string.component_transistor));break;
		case COMPONENT_WIRETOCOG:t.setText(ctx.getString(R.string.component_wire_to_cog));break;
		case COMPONENT_COGTOWIRE:t.setText(ctx.getString(R.string.component_cog_to_wire));break;
		case COMPONENT_COG:t.setText(ctx.getString(R.string.component_cog));break;
		case COMPONENT_COPPER_WIRE:t.setText(ctx.getString(R.string.component_copper_wire));break;
		case COMPONENT_GOLD_WIRE:t.setText(ctx.getString(R.string.component_gold_wire));break;
		default:t.setText(ctx.getString(R.string.component_unknown));break;
		}

		
		return arg1;
	}

}
