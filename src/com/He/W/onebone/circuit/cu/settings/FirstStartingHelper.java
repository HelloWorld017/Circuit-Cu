package com.He.W.onebone.circuit.cu.settings;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.He.W.onebone.circuit.cu.StackTraceToString;

import android.os.Environment;
import android.util.Log;

public class FirstStartingHelper {
	public static String settingPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/CircuitCu/Settings.cc";
	public static boolean isFirstStart(){
		//TODO 실행에 필요한 파일이 다는 없지만 (0~전체 - 1)개만 있으면 파일 생성, 다 있으면 팻스 그리고 리턴은 처음 시작이였는지
		String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/CircuitCu/";
		Log.d("FsRTerror", path);
		File CCdir = new File(path);
		if(!CCdir.exists()){
			CCdir.mkdir();
		}
		path = settingPath;
		File setting = new File(path);
		if(!setting.exists()){
			writeScript(EnumScript.setting, path);
		}
		return false;
	}
	
	public static void writeScript(EnumScript es, String path){
		switch(es){
		case ranking:break;

		case setting:SettingScripting(path);break;
			
		}
	}
	
	public static void SettingScripting(String path){

		File f = new File(path);
		try {
			f.createNewFile();
			FileOutputStream fos = new FileOutputStream(f);
			String content = "";
			content = "fonttype,0" + "\n" + "resistor_always_same,0";
			fos.write(content.getBytes());
			fos.flush();
			fos.close();
		} catch (IOException e) {
			Log.d("err", StackTraceToString.convert(e));
		}
	}
}
