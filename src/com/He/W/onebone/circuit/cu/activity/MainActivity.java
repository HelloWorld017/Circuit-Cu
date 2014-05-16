package com.He.W.onebone.circuit.cu.activity;

import com.He.W.onebone.circuit.cu.R;
import com.He.W.onebone.circuit.cu.map.Level;

public class MainActivity extends android.app.Activity {
	private static MainActivity obj;
	
	
	@Override @Deprecated
	protected void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		obj = this;
	}
	
	@Override
	protected void onDestroy(){
		
	}
	
	public static MainActivity getInstance(){
		return obj;
	}
	
	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}*/

}