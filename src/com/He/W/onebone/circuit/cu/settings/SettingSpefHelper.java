package com.He.W.onebone.circuit.cu.settings;

import java.util.HashMap;

import android.content.Context;

import com.He.W.onebone.circuit.cu.R;




public class SettingSpefHelper {
	public HashMap<EnumSettings, int[]> spec;
	public HashMap<EnumSettings, String> tips;
	public HashMap<EnumSettings, String[]> pnns;
	
	public SettingSpefHelper(Context ctxt){
		spec = new HashMap<EnumSettings, int[]>();
		tips = new HashMap<EnumSettings, String>();
		EnumSettings[] sets = EnumSettings.values();
		for(int a = 0; a < sets.length;a++){
			switch(sets[a]){
			case fonttype:
				spec.put(EnumSettings.fonttype, ctxt.getResources().getIntArray(R.array.fonttype));
				tips.put(EnumSettings.fonttype, ctxt.getString(R.string.fonttype));
				pnns.put(EnumSettings.fonttype, ctxt.getResources().getStringArray(R.array.fonttype_str));
				break;
			case resistor_always_same:
				spec.put(EnumSettings.resistor_always_same, ctxt.getResources().getIntArray(R.array.resistor_always_same));
				tips.put(EnumSettings.resistor_always_same, ctxt.getString(R.string.resistor_always_same));
				pnns.put(EnumSettings.resistor_always_same, ctxt.getResources().getStringArray(R.array.resistor_always_same_str));
				break;
			}
		}
	}
	
	public int getValue(EnumSettings es){
		return Setting.readSettings(es);
	}
	
	public EnumSettingParents getParent(EnumSettings es){
		if(pnns.get(es)[0] == "Look & Feel"){
			return EnumSettingParents.LooknFeel;
		}else{
			return EnumSettingParents.valueOf(pnns.get(es)[0]);
		}
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
