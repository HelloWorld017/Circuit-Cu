package com.He.W.onebone.circuit.cu.map;

import java.util.ArrayList;

import com.He.W.onebone.circuit.cu.component.*;

public class Level{
	ArrayList<String> al_mapdata;
	ArrayList<Integer> al_itemdata;
	ArrayList<int[]> al_componentdata;
	int it_successtime;
	
	//Constructor
	public Level(ArrayList<String> MapData, ArrayList<Integer> ItemData, ArrayList<int[]> ComponentData, int SuccessTime){
		al_mapdata = MapData;	al_itemdata = ItemData; al_componentdata = ComponentData; it_successtime = SuccessTime;
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
		}else if(al_mapdata.get(4).equals("Mixed")){
			return EnumMapType.Mixed;
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
	public float getXCoord(int Index){
		//TODO Write Script
		return 0F;
		
	}
	@Deprecated
	public float getYCoord(int Index){
		return 0F;
	}
	public Integer[] getAllIndexWithComponentType(EnumComponentType CT){
		return null;
	}
}