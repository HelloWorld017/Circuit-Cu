package com.He.W.onebone.circuit.cu.settings;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Locale;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

public class Setting {
	private static Object[] prefix;
	private static Context ctxt;
	private static HashMap<EnumSettings, Integer> flags;
	private static boolean isSettingChanged;
	/*
	 * 프리픽스는 일종의 저장공간 같은 곳
	 * prefix id
	 * 0 : Typeface
	 */
	/*public Setting(Context ctxt){
		readAllSettings(ctxt);
		flags = new HashMap<EnumSettings, Integer>();
	}*/
	
	public static void initSettings(Context ctx){
		ctxt = ctx;
		if(!readAllSettings(ctx)){
			FirstStartingHelper.writeScript(EnumScript.setting, FirstStartingHelper.SettingPath);
		}
		prefix = new Object[1];
		flags = new HashMap<EnumSettings, Integer>();
	}
	
	public static void writeSettings(EnumSettings es, int value){
		flags.remove(es);
		flags.put(es, value);
		setChanged();
	}
	
	public static void setChanged(){
		isSettingChanged = true;
	}
	
	public static void destroyHelper(){
		if(isSettingChanged){
			try{
			writeAllSettings();
			}catch(Exception e){
				Log.d("Bug on Setting", e.getStackTrace().toString());
			}
		}
	}
	
	public static void writeAllSettings() throws IOException{
		//Declaration part
		EnumSettings[] eslist;
		String T2W;
		BufferedWriter bw;
		OutputStreamWriter osw;
		FileOutputStream fos;
		File f;
		String path;
		path = FirstStartingHelper.SettingPath;
		f = new File(path);
		fos = new FileOutputStream(f);
		osw = new OutputStreamWriter(fos, "UTF-8");
		bw = new BufferedWriter(osw);
		eslist = EnumSettings.values();
		
		//Writing part
			for(int a = 0; a < flags.size();a++){
				T2W = eslist[a] + "," + flags.get(eslist[a]);
				bw.write(T2W);
			}
			
		//End part
			bw.flush();
			bw.close();
			osw.close();
			fos.close();
		
	}
	
	public static Context getContext(){
		return ctxt;
	}
	public static int readSettings(EnumSettings es){
		if(flags.containsKey(es)){
			return flags.get(es);
		}
		return 0;
	}
	
	public static boolean readAllSettings(Context ctxt){
		BufferedReader br;
		InputStreamReader isr;
		FileInputStream fis;
		String path = FirstStartingHelper.SettingPath;
		File f = new File(path);
		if(!f.exists()){
			Toast.makeText(ctxt, "Error occurred during starting Circuit CU! : Setting not exists", Toast.LENGTH_LONG);
			System.exit(0);
			return false;
		}
		String s = "";
		try {
			fis = new FileInputStream(f);
			isr = new InputStreamReader(fis, "UTF-8");
			br = new BufferedReader(isr);
			for(;(s = br.readLine())!= null;){
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
			br.close();
			isr.close();
			fis.close();
		}catch(Exception e){
			
		}
		return true;
	}
	
	public static Object getPrefix(int id) {
		return prefix[id];
	}
	
	public static void setPrefix(int id, Object obj) {
		prefix[id] = obj;
	}
	
	
}
