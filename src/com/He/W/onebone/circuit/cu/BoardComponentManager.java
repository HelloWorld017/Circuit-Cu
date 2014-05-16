package com.He.W.onebone.circuit.cu;

import com.He.W.onebone.circuit.cu.component.*;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class BoardComponentManager {
	private TreeMap<Integer, Component> componentList; // <component_id, object>
	private CircuitBoard board;
	private int id = 0;
	
	public BoardComponentManager(CircuitBoard board){
		this.board = board;
		componentList = new TreeMap<Integer, Component>();
	}
	
	public int addComponent(Component component){
		componentList.put(id, component);
		return id++;
	}
	
	public Component getComponentById(int id){
		return componentList.get(id);
	}
	
	public BoardComponentManager moveComponent(int id, float x, float y){
		componentList.get(id).moveTo(x, y);
		return this;
	}
	
	public Component findComponentByLocation(float x, float y){
		Set<Integer> key = componentList.descendingKeySet();
		Iterator<Integer> iterator = key.iterator();
		while(iterator.hasNext()){
			Component c = componentList.get(iterator.next());
			if(c.getX() == x && c.getY() == y){
				return c;
			}
		}
		return null;
	}
	
	public Component findComponentByLocation(float x, float y, int errorRange){
		Set<Integer> key = componentList.descendingKeySet();
		Iterator<Integer> iterator = key.iterator();
		while(iterator.hasNext()){
			Component c = componentList.get(iterator.next());
			float targetX = c.getX();
			float targetY = c.getY();
			if(targetX - errorRange > x && targetX + errorRange < x){
				if(targetY - errorRange > y && targetY + errorRange < y){
					return c;
				}
			}
		}
		return null;
	}
	
	public boolean removeComponent(Component component){
		Set<Integer> key = componentList.descendingKeySet();
		Iterator<Integer> iterator = key.iterator();
		while(iterator.hasNext()){
			int next = iterator.next();
			Component c = componentList.get(next);
			if(c.equals(component)){
				componentList.remove(next);
				return true;
			}
		}
		return false;
	}
	
	public boolean removeComponent(int id){
		if(componentList.containsKey(id)){
			componentList.remove(id);
		}
		return false;
	}
	
	public CircuitBoard getBoard(){
		return board;
	}
	
	public TreeMap<Integer, Component> getAll(){
		return componentList;
	}
	
	/*public void addComponent(Component component, ImageView img, int x, int y, float rotation, int locationId){
		componentList.add(new Object[]{
		/*	component, // [0] : Component instance (Component)
			x, y, // [1] : x (int), [2] : y (int)
			img, // [3] : ImageView instance (ImageView)
			rotation, // [4] : Rotation (float)
			locationId // [5] : locationId (int)*
				component,
				x, y,
				rotation,
				locationId
		});
	}
	
	public void moveComponent(Component component, int x, int y){
		for(Object[] obj : componentList){
			if(obj[0].equals(component)){
				ImageView img = (ImageView)obj[3];
				img.setX(x);
				img.setY(y);
				
				obj[1] = x;
				obj[2] = y;
				return;
			}
		}
	}
	
	public Component findComponentByLocation(int x, int y){
		int size = componentList.size();
		for(int o = 0; o < size; o++){
			Object[] obj = componentList.get(o);
			if(obj[1].equals(x) && obj[2].equals(y)){
				return (Component)obj[0];
			}
		}
		return null;
	}
	
	public Component findComponentByLocation(int x, int y, int errorRange){
		int size = componentList.size();
		for(int o = 0; o < size; o++){
			Object[] obj = componentList.get(o);
			int targetX = (Integer)obj[1];
			int targetY = (Integer)obj[2];
			if(targetX - errorRange > x && targetX + errorRange < x){
				if(targetY - errorRange > y && targetY + errorRange < y){
					return (Component)obj[0];
				}
			}
		}
		return null;
	}
	
	public void removeComponent(Component component){
		int size = componentList.size();
		for(int o = 0; o < size; o++){
			Object[] obj = componentList.get(o);
			if(obj[0].equals(component)){
				ImageView img = (ImageView)obj[3];
				img.setVisibility(View.INVISIBLE);
				componentList.remove(o);
				return;
			}
		}
	}
	
	public ImageView getImageView(Component component){
		for(Object[] obj : componentList){
			if(obj[0].equals(component)){
				return (ImageView)obj[3];
			}
		}
		return null;
	}*/
}