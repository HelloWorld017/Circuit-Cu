package com.He.W.onebone.circuit.cu;

//About Files
import android.content.Context;
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
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class LevelHelper{
	public HashMap<String, Level> levels = new HashMap<String, Level>();
	private static Context ctxt = null;
	public LevelHelper(Context c){
		ctxt = c;
	}
	public static void readAllLevels(){
		
	}
	
	public static Level readLevels(String mapFileName){
		//TODO:return Level
		decode(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + mapFileName + ".cc"));
		return null;
	}
	
	public static Level decode(File f){
		//null return : decoded
		if(f.exists()){
			BufferedReader br;
			InputStreamReader isr;
			FileInputStream fis;
			try {
				fis = new FileInputStream(f);
				isr = new InputStreamReader(fis, "UTF-8");
				br = new BufferedReader(isr);
				String s;
				// Generic is not allowed under java version 1.7
				ArrayList<String> al_mapdata = new ArrayList<String>();
				/*					al_mapdata index
									0 = MapName
									1 = Author
									2 = Start Voltage or RPM
									3 = End Voltage or RPM
									4 = MapType (Wire or Cogs) */
				ArrayList<String> Fullmap = new ArrayList<String>();
				int msl = -1; //Mapdata Start Line
				int mel = -1; //Mapdata End Line
				int isl = -1; //Itemdata Start Line
				int iel = -1; //Itemdata End Line
				int csl = -1; //Componentdata Start Line
				int cel = -1; //Componentdata End Line
				for(int i = 1;(s = br.readLine())!= null;i++){
					
					//Setting variables
					if(s == "[Map]"){
						msl = i;
					}else if(s == "[/Map]"){
						mel = i;
					}else if(s == "[Item]"){
						isl = i;
					}else if(s == "[/Item]"){
						iel = i;
					}else if(s == "[Component]"){
						csl = i;
					}else if(s == "[/Component]"){
						cel = i;
					}

					Fullmap.add(i,s);
					
				}
					if(mel + msl + isl + iel + csl + cel < 0 ){
						Toast.makeText(ctxt, "Broken Level!", Toast.LENGTH_LONG).show();
						return null;
					}else{
						//TODO: WRITE SCRIPT
						return null;
					}
				
			//Error Handling
			} catch (FileNotFoundException e) {
				Toast.makeText(ctxt, "AN ERROR OCCURRED DURING READING LEVEL.", Toast.LENGTH_LONG).show();
				Log.d("Error",e.getStackTrace().toString());
				return null;
			} catch (UnsupportedEncodingException e) {
				Toast.makeText(ctxt, "AN ERROR OCCURRED DURING READING LEVEL.", Toast.LENGTH_LONG).show();
				Log.d("Error",e.getStackTrace().toString());
				return null;
			} catch (IOException e) {
				Toast.makeText(ctxt, "AN ERROR OCCURRED DURING READING LEVEL.", Toast.LENGTH_LONG).show();
				Log.d("Error",e.getStackTrace().toString());
				return null;
				
			}
		}else{
			Log.d("Error","Catched not existing file :" + f.getAbsolutePath());
			return null;
		}
		
	}
	
	public static void writeSuccessData(int time, String levelName){
		
	}
}