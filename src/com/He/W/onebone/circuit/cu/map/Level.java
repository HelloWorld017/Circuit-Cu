package com.He.W.onebone.circuit.cu.map;

import java.util.ArrayList;
import java.util.List;

import com.He.W.onebone.circuit.cu.component.*;

public class Level{
	private ArrayList<Integer> itemData;
	private String author, name;
	private int difficulty, start, end;
	
	public Level(ArrayList<String> mapData, ArrayList<Integer> itemData){
		author = mapData.get(0);
	}
	
	public String getName(){
		return name;
	}
	
	public String getAuthor(){
		return author;
	}
	
	public int getDifficulty(){
		return difficulty;
	}
	
	public int getStart(){
		return start;
	}
	
	public int getEnd(){
		return end;
	}
	
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