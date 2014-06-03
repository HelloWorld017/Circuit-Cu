package com.He.W.onebone.circuit.cu.settings;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import android.os.Environment;
import android.util.Log;

public class FirstStartingHelper {
	public static boolean isFirstStart(){
		//TODO ���࿡ �ʿ��� ������ �ٴ� ������ (0~��ü - 1)���� ������ ���� ����, �� ������ �ֽ� �׸��� ������ ó�� �����̿�����
		return false;
	}
	
	public static void writeScript(EnumScript es){
		switch(es){
		case ranking:break;

		case setting:SettingScripting();break;
			
		}
	}
	
	public static void SettingScripting(){
		String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "CircuitCu/Settings.cc";
		File f = new File(path);
		try {
			f.createNewFile();
			FileOutputStream fos = new FileOutputStream(f);
			String content = "";
			content += "fonttype,0"+"\n";
			content +="resistor_always_same,0" + "\n";
			fos.write(content.getBytes());
			fos.close();
		} catch (IOException e) {
			Log.d("err", e.getStackTrace().toString());
		}
	}
}
