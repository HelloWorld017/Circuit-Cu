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
									4 = MapType (Wire or Cogs or Mixed) */
				ArrayList<Integer> al_itemdata = new ArrayList<Integer>();
				/*					al_itemdata index
				 * 					0 = wire
				 * 					1 = Electricity Blocker
				 * 					2 = Resister
				 * 					3 = Transistor
				 * 					4 = WireToCog
				 * 					5 = CogToWire
				 * 					6 = Cog*/
				ArrayList<Integer> al_componentdata = new ArrayList<Integer>();
				/*					al_componentdata index
				 * 					0 = wire(cog)
				 * 					1 = Electricity Blocker
				 * 					2 = Resister
				 * 					3 = Transistor
				 * 					4 = WireToCog
				 * 					5 = CogToWire
				 *					6 = Cog*/
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
						for(int a = 0; a < Fullmap.size() - 1; a++){
							//map data
							if(msl < a && a < mel){
								al_mapdata.add(a - msl, Fullmap.get(a));
							}
							
							//item data
							if(isl < a && a < iel){
								String[] set = Fullmap.get(a).split(",");
								
								
								//error check
								try{
									int test = Integer.valueOf(set[1]);
								}catch(NumberFormatException e){
									Toast.makeText(ctxt, "Broken Level : item amount is not number", Toast.LENGTH_LONG).show();
									return null;
								}
								
								//Cannot use switch because set[0] is String
								
								//item data add
								if(set[0].equals("Wire")){
									
									al_itemdata.add(0,Integer.valueOf(set[1]));
									
								}else if(set[0].equals("ElectricityBlocker")){
									
									al_itemdata.add(1,Integer.valueOf(set[1]));
									
								}else if(set[0].equals("Resister")){
									
									al_itemdata.add(2,Integer.valueOf(set[1]));
									
								}else if(set[0].equals("Transistor")){
									
									al_itemdata.add(3,Integer.valueOf(set[1]));
									
								}else if(set[0].equals("Wiretocog")){
									
									al_itemdata.add(4,Integer.valueOf(set[1]));
									
								}else if(set[0].equals("Cogtowire")){
									
									al_itemdata.add(5,Integer.valueOf(set[1]));
									
								}else if(set[0].equals("Cog")){
									
									al_itemdata.add(6,Integer.valueOf(set[1]));
									
								}else{
								
									
									Toast.makeText(ctxt, "Broken Level : unknown item : " + set[0], Toast.LENGTH_LONG).show();
									
								}
							}
							
							//component data
							if(csl < a && a < cel){
								String[] set2 = Fullmap.get(a).split(",");
								
								
								//error check
								try{
									int test = Integer.valueOf(set2[1]);
								}catch(NumberFormatException e){
									Toast.makeText(ctxt, "Broken Level : item amount is not number", Toast.LENGTH_LONG).show();
									return null;
								}
								
								//Cannot use switch because set[0] is String
								
								//item data add
								if(set2[0].equals("Wire")){
									
									al_componentdata.add(0,Integer.valueOf(set2[1]));
									
								}else if(set2[0].equals("ElectricityBlocker")){
									
									al_componentdata.add(1,Integer.valueOf(set2[1]));
									
								}else if(set2[0].equals("Resister")){
									
									al_componentdata.add(2,Integer.valueOf(set2[1]));
									
								}else if(set2[0].equals("Transistor")){
									
									al_componentdata.add(3,Integer.valueOf(set2[1]));
									
								}else if(set2[0].equals("Wiretocog")){
									
									al_componentdata.add(4,Integer.valueOf(set2[1]));
									
								}else if(set2[0].equals("Cogtowire")){
									
									al_componentdata.add(5,Integer.valueOf(set2[1]));
									
								}else if(set2[0].equals("Cog")){
									
									al_componentdata.add(6,Integer.valueOf(set2[1]));
									
								}else{
									
									Toast.makeText(ctxt, "Broken Level : unknown component : " + set2[0], Toast.LENGTH_LONG).show();
									
								}
							}
							
						}
						//TODO: Make null to new level
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