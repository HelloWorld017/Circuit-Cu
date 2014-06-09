package com.He.W.onebone.circuit.cu.map;

//About Constructor
import android.content.Context;

//About Files
import android.os.Environment;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
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
	public static ArrayList<String>  readAllLevels(){
		File ccpfolder = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "CircuitCu/");
		File[] fs = ccpfolder.listFiles(new FilenameFilter(){

			@Override
			public boolean accept(File arg0, String arg1) {
				return arg1.endsWith(".cc");
			}
			
		});
		ArrayList<String> maps = new ArrayList<String>();
		for(int a = 0; a < fs.length;a++){
			maps.add(fs[a].getName().replace(".cc", ""));
		}
		return maps;
	}
	
	public static Level readLevels(String mapFileName){
		return decode(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "CircuitCu/" + mapFileName + ".cc"));
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
				//INDEX LIBRORUM PROHIBITORUM
				ArrayList<String> al_mapdata = new ArrayList<String>();
				/*					al_mapdata index
				*					0 = MapName
				*					1 = Author
				*					2 = Start Voltage or RPM
				*					3 = End Voltage or RPM
				*					4 = MapType (Wire or Cogs or Mixed) 
				*					5 = Difficulty(0 - 10)
				*/
				//Refresh
				al_mapdata.add(0, "");
				al_mapdata.add(1, "");
				al_mapdata.add(2, "110");
				al_mapdata.add(3, "220");
				al_mapdata.add(4, "Mixed");
				ArrayList<Integer> al_itemdata = new ArrayList<Integer>();
				/*					al_itemdata index
				 * 					0 = CopperWire
				 * 					1 = Electricity Blocker
				 * 					2 = Resister
				 * 					3 = Transistor
				 * 					4 = WireToCog
				 * 					5 = CogToWire
				 * 					6 = Cog
				 * 					7 = GoldWire
				 * 					8 = Swift
				 * 					9 = UnswiftableObstacle
				 */
				//Refresh
				al_itemdata.add(0, 0);
				al_itemdata.add(1, 0);
				al_itemdata.add(2, 0);
				al_itemdata.add(3, 0);
				al_itemdata.add(4, 0);
				al_itemdata.add(5, 0);
				al_itemdata.add(6, 0);
				al_itemdata.add(7, 0);
				al_itemdata.add(8, 0);
				al_itemdata.add(9, 0);
				ArrayList<int[]> al_componentdata = new ArrayList<int[]>();
				/*					al_componentdata argument(int[]) index
				 * 					arg[0] = Type : 
				 * 									0 = wire, 1 = Electricity Blocker, 2 = Resister
				 * 									3 = Transistor, 4 = WireToCog, 5 = CogToWire, 6 = Cog
				 * 					arg[1] = X coordinate
				 * 					arg[2] = Y coordinate
				 */
				int it_successdata = -1;
				ArrayList<String> Fullmap = new ArrayList<String>();
				int msl = -1; //Mapdata Start Line
				int mel = -1; //Mapdata End Line
				int isl = -1; //Itemdata Start Line
				int iel = -1; //Itemdata End Line
				int csl = -1; //Componentdata Start Line
				int cel = -1; //Componentdata End Line
				int ssl = -1; //Successdata Start Line
				int sel = -1; //Successdata End Line
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
					}else if(s == "[SuccessData]"){
						ssl = i;
					}else if(s == "[/SuccessData]"){
						sel = i;
					}

					Fullmap.add(i,s);
					
				}
					if(msl == -1 || mel == -1 || isl == -1 || iel == -1 || csl == -1 || cel == -1 ){
						Toast.makeText(ctxt, "Broken Level!", Toast.LENGTH_LONG).show();
						br.close();
						isr.close();
						fis.close();
						return null;
					}else{
						for(int a = 0; a < Fullmap.size() - 1; a++){
							//map data
							if(msl < a && a < mel){
								al_mapdata.set(a - msl - 1, Fullmap.get(a));
							}
							
							//item data
							if(isl < a && a < iel){
								String[] set = Fullmap.get(a).split(",");
								
								
								//error check
								try{
									Integer.parseInt(set[1]);
								}catch(NumberFormatException e){
									Toast.makeText(ctxt, "Broken Level : item amount is not number", Toast.LENGTH_LONG).show();
									br.close();
									isr.close();
									fis.close();
									return null;
								}
								
								//Cannot use switch because set[0] is String
								
								//item data add
								if(set[0].equals("CopperWire")){
									
									al_itemdata.set(0,Integer.parseInt(set[1]));
									
								}else if(set[0].equals("ElectricityBlocker")){
									
									//this item is not useless because player(s) must use all items.
									al_itemdata.set(1,Integer.parseInt(set[1]));
									
								}else if(set[0].equals("Resister")){
									
									al_itemdata.set(2,Integer.parseInt(set[1]));
									
								}else if(set[0].equals("Transistor")){
									
									al_itemdata.set(3,Integer.parseInt(set[1]));
									
								}else if(set[0].equals("WiretoCog")){
									
									al_itemdata.set(4,Integer.parseInt(set[1]));
									
								}else if(set[0].equals("CogtoWire")){
									
									al_itemdata.set(5,Integer.parseInt(set[1]));
									
								}else if(set[0].equals("Cog")){
									
									al_itemdata.set(6,Integer.parseInt(set[1]));
									
								}else if(set[0].equals("GoldWire")){
									
									al_itemdata.set(7,Integer.parseInt(set[1]));
									
								}else if(set[0].equals("Swift")){
									
									al_itemdata.set(8, Integer.parseInt(set[1]));
									
								}else if(set[0].equals("UnswiftableObstacle")){

									al_itemdata.set(9, Integer.parseInt(set[1]));
									
								}else{
								
									
									Toast.makeText(ctxt, "Broken Level : unknown item : " + set[0], Toast.LENGTH_LONG).show();
									br.close();
									isr.close();
									fis.close();
									return null;
								}
							}
							
							//component data
							if(csl < a && a < cel){
								String[] set3 = Fullmap.get(a).split(",");
								int[] Argset = new int[2];
								try{
									
									String arg1 = set3[0].replace("CopperWire", "0").replace("ElectricityBlocker", "1").replace("Resister", "2").replace("Transistor", "3").replace("WiretoCog", "4").replace("CogtoWire", "5").replace("Cog","6").replace("GoldWire","7").replace("Swift", "8").replace("UnswiftableObstacle", "9");
									Argset[0] = Integer.parseInt(arg1);
									Argset[1] = Integer.parseInt(set3[1]);
									Argset[2] = Integer.parseInt(set3[2]);
									
								}catch(NumberFormatException e){
									
									Toast.makeText(ctxt, "Broken Level : Component's coord is not Integer", Toast.LENGTH_LONG).show();
									br.close();
									isr.close();
									fis.close();
									return null;
								}
								al_componentdata.add(a - csl - 1, Argset);
								
							}
							if(ssl != -1 && sel != -1){
								if(ssl < a && sel < a){
									try{
										it_successdata = Integer.parseInt(Fullmap.get(a));
									}catch(NumberFormatException e){
										Toast.makeText(ctxt, "Broken Level : SuccessData is not Integer", Toast.LENGTH_LONG).show();
										br.close();
										isr.close();
										fis.close();
										return null;
									}
								}
							}
							
						}
						br.close();
						isr.close();
						fis.close();
						return new Level(al_mapdata, al_itemdata, al_componentdata, it_successdata);
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
	
	public static boolean writeSuccessData(int time, String MapFileName){
		BufferedWriter bw = null;
			try {
					FileWriter fw = new FileWriter(Environment.getExternalStorageDirectory().getAbsoluteFile()+ "CircuitCu/" + MapFileName + ".cc", true );
					bw = new BufferedWriter(fw);
					bw.append("[SuccessData]" + "\n" + String.valueOf(time) + "\n" + "[/SucceessData]");
					bw.flush();
					bw.close();
					fw.close();
				return true;
			} catch (FileNotFoundException e) {
				// TODO If map file only has Success Data, check this part. Append can delete things, I think.
				Toast.makeText(ctxt, "Cannot Find File!", Toast.LENGTH_LONG).show();
				return false;
			} catch (IOException e) {
				Toast.makeText(ctxt, e.getStackTrace().toString(), Toast.LENGTH_LONG).show();
				return false;
			}
	}
}
