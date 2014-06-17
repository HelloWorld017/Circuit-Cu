package com.He.W.onebone.circuit.cu.map;

import java.io.File;
import java.util.ArrayList;
import java.util.TreeMap;

import android.util.Log;


public class Level{
	private ArrayList<TreeMap<String, Object>> itemData;
	private String author, name;
	private int difficulty, startX, endX, startY, endY, divideX, divideY;
	private String filePath;
	
	public static final int MAX_DIFFICULTY = 10;
	
	//Needs ArrayList[<int[]> componentData and Object[] successTime. successTime is at RankingHelper
	public Level(TreeMap<String, String> mapData, ArrayList<TreeMap<String, Object>> itemData){
		try{
			author = mapData.get("author");
			name = mapData.get("name");
			
			startX = Integer.parseInt(mapData.get("startX"));
			startY = Integer.parseInt(mapData.get("startY"));
			endX = Integer.parseInt(mapData.get("endX"));
			endY = Integer.parseInt(mapData.get("endY"));
			divideX = Integer.parseInt(mapData.get("divideX"));
			divideY = Integer.parseInt(mapData.get("divideY"));
			difficulty = Integer.parseInt(mapData.get("difficulty")) & MAX_DIFFICULTY;
		}catch(Exception e){
			Log.d("Level", e.getMessage());
		}
		this.itemData = itemData;
	}
	
	public String getName(){
		return name;
	}
	
	public ArrayList<TreeMap<String, Object>> getItemData(){
		return itemData;
	}
	
	public String getAuthor(){
		return author;
	}
	
	public int getDifficulty(){
		return difficulty;
	}
	
	public int getStartX(){
		return startX;
	}
	
	public int getStartY(){
		return startY;
	}
	
	public int getEndX(){
		return endX;
	}
	
	public int getEndY(){
		return endY;
	}
	
	public int getDivideX(){
		return divideX;
	}
	
	public int getDivideY(){
		return divideY;
	}
	
	/*public int getStart(){
		return start;
	}*/
	
	public File getFile(){
		return new File(filePath);
	}
	
	/*public int getEnd(){
=======
	public File getFile(){
		return new File(filePath);
	}
	public int getEnd(){
>>>>>>> 94087fb0626561fda559dc7c15be78f7ddfdb306
		return end;
	}*/
	
	/*ArrayList<String> al_mapdata;
	ArrayList<Integer> al_itemdata;
	ArrayList<int[]> al_componentdata;
	int it_successtime;
	
	//Constructor
	public Level(ArrayList<String> mapData, ArrayList<Integer> itemData, ArrayList<int[]> componentData, int successTime){
		al_mapdata = mapData;	al_itemdata = itemData; al_componentdata = componentData; it_successtime = successTime;
	}
	
	public String getMapName(){
		return al_mapdata.get(0);
	}
	
	public String getAuthor(){
		return al_mapdata.get(1);
	}
	
	public int getDifficulty(){
		return Integer.parseInt(al_mapdata.get(5));
	}
	
	public int getStart(){
		return Integer.parseInt(al_mapdata.get(2));
	}
	
	public int getEnd(){
		return Integer.parseInt(al_mapdata.get(3));
	}
	
	public EnumMapType getMapType(){
		//Cannot use switch with String variable(s) under 1.7
		if(al_mapdata.get(4).equals("Wire")){
			return EnumMapType.Wire;
		}else if(al_mapdata.get(4).equals("Cogs")){
			return EnumMapType.Cogs;
		}else{
			return EnumMapType.Mixed;
		}
	}
	
	public int getItemAmount(EnumComponentType e){
		switch(e){
		case COMPONENT_WIRE:return al_itemdata.get(0);
		case COMPONENT_ELECTRICITYBLOCKER:return al_itemdata.get(1);
		case COMPONENT_RESISTOR:return al_itemdata.get(2);
		case COMPONENT_TRANSISTOR:return al_itemdata.get(3);
		case COMPONENT_WIRETOCOG:return al_itemdata.get(4);
		case COMPONENT_COGTOWIRE:return al_itemdata.get(5);
		case COMPONENT_COG:return al_itemdata.get(6);
		case COMPONENT_GOLD_WIRE:return al_itemdata.get(7);
		case COMPONENT_SWIFT:return al_itemdata.get(8);
		case COMPONENT_UNSWIFTABLEOBSTACLE:return al_itemdata.get(9);
		default: return -1;
		}
	}
	
	@Deprecated
	public float getXCoord(int index){
		//TODO Write Script
		return 0F;
	}
	
	@Deprecated
	public float getYCoord(int index){
		return 0F;
	}
	
	public List<Integer> getAllIndexByComponentType(EnumComponentType CT){
		ArrayList<Integer> ret = new ArrayList<Integer>();
		for(int i = 0; i < al_itemdata.size(); i++){
			if(CT.ordinal() == al_itemdata.get(i)){
				ret.add(i);
			}
		}
		return ret;
	}*/
}