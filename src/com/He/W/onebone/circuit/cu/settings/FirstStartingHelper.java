package com.He.W.onebone.circuit.cu.settings;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import android.os.Environment;
import android.util.Log;

public class FirstStartingHelper {
	public static boolean isFirstStart(){
		//TODO 실행에 필요한 파일이 다는 없지만 (0~전체 - 1)개만 있으면 파일 생성, 다 있으면 팻스 그리고 리턴은 처음 시작이였는지
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
