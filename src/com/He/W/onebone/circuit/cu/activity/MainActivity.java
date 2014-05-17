package com.He.W.onebone.circuit.cu.activity;

import java.util.Random;

import com.He.W.onebone.circuit.cu.R;
import com.He.W.onebone.circuit.cu.map.Level;

import de.keyboardsurfer.android.widget.crouton.Configuration;
import de.keyboardsurfer.android.widget.crouton.Configuration.Builder;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

public class MainActivity extends android.app.Activity {
	private static MainActivity obj;
	
	
	@Override @Deprecated
	protected void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		obj = this;
		Random r = new Random();
		int ri  = r.nextInt(10);
		String s = null;
		switch(ri){
		case 0:s = this.getString(R.string.a);break;
		case 1:s = this.getString(R.string.b);break;
		case 2:s = this.getString(R.string.c);break;
		case 3:s = this.getString(R.string.d);break;
		case 4:s = this.getString(R.string.e);break;
		case 5:s = this.getString(R.string.f);break;
		case 6:s = this.getString(R.string.g);break;
		case 7:s = this.getString(R.string.h);break;
		case 8:s = this.getString(R.string.i);break;
		case 9:s = this.getString(R.string.ba);break;
		case 10:s = this.getString(R.string.bb);break;
		}
		
		
		Crouton.makeText(this, s, Style.INFO).setConfiguration(new Builder().setDuration(Configuration.DURATION_SHORT).build()).show();
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