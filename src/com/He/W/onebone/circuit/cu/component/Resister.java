package com.He.W.onebone.circuit.cu.component;
		
import com.He.W.onebone.circuit.cu.*;

//import android.content.res.Resources;
import android.widget.ImageView;

public class Resister extends ElectricityBlockable{
	public Resister(ImageView img, float x, float y, int locationId, int blockRate, int errorRange) {
		super(img, x, y, locationId, blockRate, errorRange);
	}
	
	public void addLine(int color, int lineId){ // TODO Inserting line which identifies the information of resister
		
	}

	@Override
	public void electricityReleased() {
		
	}
	
	/*public Resister(MainActivity activity){
		resource = activity.getResources();
		img = resource.getDrawable(R.drawable.resister); // TODO Insert image!!
	}
	
	*/
}