package com.He.W.onebone.circuit.cu;

import android.content.res.Resources;
import android.widget.ImageView;

public class Resister implements ElectricityBlocker{
	private ImageView img;
	private Resources resource;
	
	public Resister(MainActivity activity){
		resource = activity.getResources();
		img = resource.getDrawable(R.drawable.resister); // TODO Insert image!!
	}
	
	
}
