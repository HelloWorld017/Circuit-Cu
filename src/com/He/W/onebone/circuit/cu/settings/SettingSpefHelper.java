package com.He.W.onebone.circuit.cu.settings;

import java.util.HashMap;

import android.content.Context;
import android.util.Log;

import com.He.W.onebone.circuit.cu.R;

public class SettingSpefHelper {
	public HashMap<EnumSettings, int[]> spec;
	public HashMap<EnumSettings, String> tips;
	public HashMap<EnumSettings, String[]> pnns;
	public HashMap<EnumSettings, String[]> values;
	
	public SettingSpefHelper(Context ctxt){
		spec = new HashMap<EnumSettings, int[]>();
		tips = new HashMap<EnumSettings, String>();
		pnns = new HashMap<EnumSettings, String[]>();
		values = new HashMap<EnumSettings, String[]>();
		EnumSettings[] sets = EnumSettings.values();
		for(int a = 0; a < sets.length;a++){
			switch(sets[a]){
			case fonttype:
				spec.put(EnumSettings.fonttype, ctxt.getResources().getIntArray(R.array.fonttype));
				tips.put(EnumSettings.fonttype, ctxt.getString(R.string.fonttype));
				pnns.put(EnumSettings.fonttype, ctxt.getResources().getStringArray(R.array.fonttype_str));
				values.put(EnumSettings.fonttype, ctxt.getResources().getStringArray(R.array.fonttype_values));
				break;
			case resistor_always_same:
				spec.put(EnumSettings.resistor_always_same, ctxt.getResources().getIntArray(R.array.resistor_always_same));
				tips.put(EnumSettings.resistor_always_same, ctxt.getString(R.string.resistor_always_same));
				pnns.put(EnumSettings.resistor_always_same, ctxt.getResources().getStringArray(R.array.resistor_always_same_str));
				values.put(EnumSettings.resistor_always_same, ctxt.getResources().getStringArray(R.array.resistor_always_same_values));
				break;
			}
		}
	}
	
	public int getValue(EnumSettings es){
		return Setting.readSettings(es);
	}
	
	public EnumSettingParents getParent(EnumSettings es){
		if("Look & Feel".equals(pnns.get(es)[0])){
			return EnumSettingParents.LooknFeel;
		}else{
			try{
			return EnumSettingParents.valueOf(pnns.get(es)[0]);
			}catch(IllegalArgumentException e){
				Log.d("IAEFixing", "data : " + es + ", " + pnns.get(es)[0]);
				return EnumSettingParents.LooknFeel;
			}
		}
	}
	public String getValueAvailable(EnumSettings es, int index){
		//fonttype에서의 인덱스 : 1,2,3 될수 있음
		if(index==0){
			return "예";
		}
		return values.get(es)[index];
		//INDEX-LIBRORUM-PROHIBITORUM
	}
	public int getValueAmount(EnumSettings es){
		return Integer.parseInt(values.get(es)[0]);
	}
	
	public String getName(EnumSettings es){
		return pnns.get(es)[1];
	}
	
	public String getSettingTips(EnumSettings es){
		return tips.get(es);
	}
	public boolean isVisible(EnumSettings es){
		int[] specs = spec.get(es);
		switch(specs[2]){
		case 0:return false;
		case 1:return true;
		default:return true;
		}
	}
	
	public int getSettingId(EnumSettings es){
		return spec.get(es)[0];
	}
	
	public boolean isNeededRestart(EnumSettings es){
		int[] specs = spec.get(es);
		switch(specs[1]){
		case 0:return false;
		case 1:return true;
		default:return true;
		}
	}
}
