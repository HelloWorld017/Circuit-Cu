package com.He.W.onebone.circuit.cu;

//import android.content.res.Resources;
import android.widget.ImageView;

public class Resister extends ElectricityBlockable{
	public Resister(ImageView img, int x, int y, int locationId, int blockRate, int errorRange) {
		super(img, x, y, locationId, blockRate, errorRange);
	}
	
	/*public Resister(MainActivity activity){
		resource = activity.getResources();
		img = resource.getDrawable(R.drawable.resister); // TODO Insert image!!
	}
	
	*/
}