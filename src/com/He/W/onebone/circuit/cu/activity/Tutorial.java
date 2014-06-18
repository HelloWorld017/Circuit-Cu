package com.He.W.onebone.circuit.cu.activity;

import com.He.W.onebone.circuit.cu.R;
import com.He.W.onebone.circuit.cu.gamebase.AudioHelper;
import com.He.W.onebone.circuit.cu.settings.Setting;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Tutorial extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tutorial);
		Button mainmenu = (Button)findViewById(R.id.GearButtonMainMenu);
		Typeface tf = (Typeface)Setting.getPrefix(0);
		mainmenu.setTypeface(tf);
		int[] ids = new int[]{
			R.id.tutorial1, R.id.tutorial2, R.id.tutorial3, R.id.tutorial4, R.id.tutorial5, R.id.tutorial6, R.id.tutorial7, R.id.tutorial8
		};
		for(int id : ids){
			TextView tv = (TextView)findViewById(id);
			tv.setTypeface(tf);
		}
		mainmenu.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AudioHelper.playEffect(Tutorial.this, 0);
				Intent it = new Intent(Tutorial.this, MainActivity.class);
				it.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
				it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(it);
				
			}
		});
		Button credit = (Button)findViewById(R.id.btnCredit);
		credit.setTypeface(tf);
		credit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				TextView tv = (TextView)findViewById(R.id.tutorial1);
				tv.setText("");
				tv = (TextView)findViewById(R.id.tutorial2);
				tv.setText("");
				tv = (TextView)findViewById(R.id.tutorial3);
				tv.setText("Developer : onebone & He.W");
				tv = (TextView)findViewById(R.id.tutorial4);
				tv.setText("Image by ciker.com, Lorc, simpleicon.com, walsave.com");
				tv = (TextView)findViewById(R.id.tutorial5);
				tv.setText("Font by Microsoft, Sandoll, Ubuntu, diezil tweeks");
				tv = (TextView)findViewById(R.id.tutorial6);
				tv.setText("Music by Portal 2");
				tv = (TextView)findViewById(R.id.tutorial7);
				tv.setText("Thank you for playing this game!");
				tv = (TextView)findViewById(R.id.tutorial8);
				tv.setText("https://github.com/HelloWorld017/Circuit-Cu");
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
