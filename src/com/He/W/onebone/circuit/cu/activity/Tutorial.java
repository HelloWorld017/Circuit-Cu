package com.He.W.onebone.circuit.cu.activity;

import com.He.W.onebone.circuit.cu.R;
import com.He.W.onebone.circuit.cu.R.layout;
import com.He.W.onebone.circuit.cu.R.menu;
import com.He.W.onebone.circuit.cu.settings.Setting;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Tutorial extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tutorial);
		Button mainmenu = (Button)findViewById(R.id.GearButtonMainMenu);
		TextView tutorial1 = (TextView)findViewById(R.id.tutorial1);
		TextView tutorial2 = (TextView)findViewById(R.id.tutorial2);
		TextView tutorial3 = (TextView)findViewById(R.id.tutorial3);
		TextView tutorial4 = (TextView)findViewById(R.id.tutorial4);
		TextView tutorial5 = (TextView)findViewById(R.id.tutorial5);
		TextView tutorial6 = (TextView)findViewById(R.id.tutorial6);
		TextView tutorial7 = (TextView)findViewById(R.id.tutorial7);
		TextView tutorial8 = (TextView)findViewById(R.id.tutorial8);
		Typeface tf = (Typeface)Setting.getPrefix(0);
		mainmenu.setTypeface(tf);
		tutorial1.setTypeface(tf);
		tutorial2.setTypeface(tf);
		tutorial3.setTypeface(tf);
		tutorial4.setTypeface(tf);
		tutorial5.setTypeface(tf);
		tutorial6.setTypeface(tf);
		tutorial7.setTypeface(tf);
		tutorial8.setTypeface(tf);
		mainmenu.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it = new Intent(Tutorial.this, MainActivity.class);
				it.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
				it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(it);
				
			}
		});
		
	}

/*	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_tutorial, menu);
		return true;
	}*/

}
