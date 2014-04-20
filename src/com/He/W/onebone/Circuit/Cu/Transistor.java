package com.He.W.onebone.circuit.cu;

import android.content.res.Resources;
import android.widget.ImageView;

public class Transistor extends Focusable implements Component{
	private Resources resource;
	private ImageView img;
	
	public Transistor(MainActivity activity){
		resource = activity.getResources();
		img = resource.getDrawable(R.drawable.transistor); // TODO Insert image!!
	}
	
	public void moveTo(int x, int y, int z){
		
	}
}