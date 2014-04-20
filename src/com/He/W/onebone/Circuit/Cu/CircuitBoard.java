package com.He.W.onebone.circuit.cu;

import java.util.TreeMap;

import android.content.res.Resources;
import android.widget.ImageView;

public class CircuitBoard{
	private ImageView boardImg = null;
	private Resources resource;
	private TreeMap<Integer, Integer> location; // Locations and rotations
	
	public CircuitBoard(MainActivity activity){
		resource = activity.getResources();
		this.boardImg = resource.getDrawable(R.drawable.board_img); // TODO Insert image!!!!
		this.location = new TreeMap<Integer, Integer>();
	}
	
	public boolean putComponent(ImageView img, int locationId){
		if(boardImg == null){
			return false;
		}
		if(!location.containsKey(locationId)){
			return false;
		}
		
		return true;
	}
}
