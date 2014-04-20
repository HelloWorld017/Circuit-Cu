package com.He.W.onebone.circuit.cu;

//import android.content.res.Resources;
import android.widget.ImageView;

public class Resister extends ElectricityBlocker{
	public Resister(ImageView img, int x, int y, int locationId, int blockRate) {
		super(img, x, y, locationId, blockRate);
		CircuitBoard.getInstance().getManager().addComponent(this);
	}
	
	/*public Resister(MainActivity activity){
		resource = activity.getResources();
		img = resource.getDrawable(R.drawable.resister); // TODO Insert image!!
	}
	
	*/
}