package com.He.W.onebone.circuit.cu.settings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Locale;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

public class Setting {
	private Object[] prefix;
	private HashMap<EnumSettings, Integer> flags = new HashMap<EnumSettings, Integer>();
	/*
	 * 프리픽스는 일종의 저장공간 같은 곳
	 * prefix id
	 * 0 : Typeface
	 */
	public Setting(Context ctxt){
		readAllSettings(ctxt);
	}
	public void writeSettings(EnumSettings es, int value){
	}
	public int readSettings(EnumSettings es){
		
		return flags.get(es);
	}
	public boolean readAllSettings(Context ctxt){
		BufferedReader br;
		InputStreamReader isr;
		FileInputStream fis;
		String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "CircuitCu/Settings.cc";
		File f = new File(path);
		String s = "";
		try {
			fis = new FileInputStream(f);
			isr = new InputStreamReader(fis, "UTF-8");
			br = new BufferedReader(isr);
			for(int i = 1;(s = br.readLine())!= null;i++){
				String[] settinglist = s.split(",");
				try{
				EnumSettings es = EnumSettings.valueOf(settinglist[0].toLowerCase(Locale.ENGLISH));
				flags.put(es, Integer.valueOf(settinglist[1]));
				}catch(Exception e){
					Toast.makeText(ctxt, "There is error on Settings.cc. Please delete Settings.cc to write new Settings.", Toast.LENGTH_LONG).show();
					br.close();
					isr.close();
					fis.close();
					return false;
				}
			}
			br.readLine();
		}catch(Exception e){

		}
		return true;
	}
	public Object getPrefix(int id) {
		return prefix[id];
	}
	public void setPrefix(int id, Object obj) {
		this.prefix[id] = obj;
	}
	
	
}