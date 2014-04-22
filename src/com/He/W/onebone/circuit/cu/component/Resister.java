package com.He.W.onebone.circuit.cu.component;
		
import com.He.W.onebone.circuit.cu.*;

//import android.content.res.Resources;
import android.widget.ImageView;

public class Resister extends ElectricityBlockable{
	private int errorRange;
	
	public Resister(ImageView img, float x, float y, int locationId, int blockage, int errorRange) {
		super(img, x, y, locationId, blockage);
		this.errorRange = errorRange;
	}
	
	public void addLine(int color, int lineId){ // TODO Inserting line which identifies the information of resister
		
	}
	
	public int getErrorRange(){
		return errorRange;
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