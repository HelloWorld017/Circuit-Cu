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
		//TODO ���࿡ �ʿ��� ������ �ٴ� ������ (0~��ü - 1)���� ������ ���� ����, �� ������ �ֽ� �׸��� ������ ó�� �����̿�����
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
