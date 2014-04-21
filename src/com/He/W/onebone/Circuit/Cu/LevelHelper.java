package com.He.W.onebone.Circuit.Cu;

//About Files
import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

//About Array
import java.util.HashMap;
import java.util.ArrayList;

//About Debugging
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class LevelHelper{
	public HashMap<String,Level> levels = new HashMap<String,Level>();
	
	public static void readAllLevels(){
		
	}
	
	public static Level readLevels(String MapFileName){
		//TODO:return Level
		decode(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + MapFileName + ".cc"));
		return null;
	}
	
	public static void decode(File f){
		if(f.exists()){
			BufferedReader br;
			InputStreamReader isr;
			FileInputStream fis;
			try {
				fis = new FileInputStream(f);
				isr = new InputStreamReader(fis, "UTF-8");
				br = new BufferedReader(isr);
				String s;
				//<> is not allowed under java version 1.7
				ArrayList<String> al = new ArrayList<String>();
					for(;(s = br.readLine())!= null;){
						if(s == "[Map]"){
							
						}
						
					}
					
				
			//Error Handling
			} catch (FileNotFoundException e) {
				
				Log.d("Error",e.getStackTrace().toString());
				
			} catch (UnsupportedEncodingException e) {
				
				Log.d("Error",e.getStackTrace().toString());
				
			} catch (IOException e) {
				
				Log.d("Error",e.getStackTrace().toString());
				
			}
		}else{
			Log.d("Error","Catched not existing file :" + f.getAbsolutePath());
		}
	}
	
	public static void writeSuccessData(int time,String LevelName){
		
	}
}