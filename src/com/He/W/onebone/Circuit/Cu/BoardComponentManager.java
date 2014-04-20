package com.He.W.onebone.circuit.cu;

import java.util.LinkedList;

import android.view.View;

public class BoardComponentManager {
	private LinkedList<Component> componentList;
	
	public BoardComponentManager(){
		componentList = new LinkedList<Component>();
	}
	
	public void addComponent(Component component){
		componentList.add(component);
	}
	
	public void moveComponent(Component component, float x, float y){
		component.moveTo(x, y);
	}
	
	public Component findComponentByLocation(float x, float y){
		for(Component c : componentList){
			if(c.getX() == x && c.getY() == y){
				return c;
			}
		}
		return null;
	}
	
	public Component findComponentByLocation(float x, float y, int errorRange){
		for(Component c : componentList){
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
	
	public void removeComponent(Component component){
		for(int o = 0; o < componentList.size(); o++){
			Component c = componentList.get(o);
			if(c.equals(component)){
				component.getComponentImage().setVisibility(View.INVISIBLE);
				componentList.remove(o);
				return;
			}
		}
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