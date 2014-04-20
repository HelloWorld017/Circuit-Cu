package com.He.W.onebone.circuit.cu;

import java.util.TreeMap;

import android.content.Context;
import android.widget.ImageView;

public class CircuitBoard extends ImageView{
	private static CircuitBoard obj;
	private BoardComponentManager manager;
	
	public CircuitBoard(Context context) {
		super(context);
		obj = this;
		manager = new BoardComponentManager();
		this.setImageResource(R.drawable.circuit_board); // TODO Insert image!!
	}
	
	public static CircuitBoard getInstance(){
		return obj;
	}
	
	public BoardComponentManager getManager(){
		return manager;
	}
	
	public void putComponent(Component component){
		manager.addComponent(component);
	}
}

/*public class CircuitBoard{
	private ImageView boardImg = null;
	private Resources resource;
	private BoardComponentManager manager;
	private static CircuitBoard obj;
	
	public CircuitBoard(MainActivity activity){
		resource = activity.getResources();
		Drawable drawable = resource.getDrawable(R.drawable.ic_launcher);
		
		this.boardImg = resource.getDrawable(R.drawable.ic_launcher);
		manager = new BoardComponentManager();
		obj = this;
	}
	
	public static CircuitBoard getInstance(){
		return obj;
	}
	
	/*public int getIdByLocation(int x, int y){
		
	}*
	
	public boolean putComponent(Component component){
		/*if(boardImg == null){
			return false;
		}
		if(!location.containsKey(locationId)){
			return false;
		}
		
		return true;*
		manager.addComponent(component);
		return true;
	}
}*/