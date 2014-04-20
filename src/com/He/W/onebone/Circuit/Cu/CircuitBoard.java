package com.He.W.onebone.circuit.cu;

import java.util.TreeMap;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;

public class CircuitBoard{
	private ImageView boardImg = null;
	private Resources resource;
	private BoardComponentManager manager;
	private static CircuitBoard obj;
	
	public CircuitBoard(MainActivity activity){
		resource = activity.getResources();
		this.boardImg = resource.getDrawable(R.drawable.board_img); // TODO Insert image!!!!
		manager = new BoardComponentManager();
		obj = this;
	}
	
	public static CircuitBoard getInstance(){
		return obj;
	}
	
	/*public int getIdByLocation(int x, int y){
		
	}*/
	
	public boolean putComponent(Component component){
		/*if(boardImg == null){
			return false;
		}
		if(!location.containsKey(locationId)){
			return false;
		}
		
		return true;*/
		manager.addComponent(component);
		return true;
	}
}