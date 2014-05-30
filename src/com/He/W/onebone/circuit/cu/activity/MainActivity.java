package com.He.W.onebone.circuit.cu.activity;

import java.util.Random;

import android.graphics.Typeface;
import android.widget.Button;
import android.widget.TextView;

import com.He.W.onebone.circuit.cu.R;
import com.He.W.onebone.circuit.cu.gamebase.AudioHelper;
import com.He.W.onebone.circuit.cu.settings.EnumSettings;
import com.He.W.onebone.circuit.cu.settings.Setting;

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
		Setting.initSettings(this);
		TextView tv = (TextView) findViewById(R.id.textCircuitCU);
		Button b = (Button)findViewById(R.id.GeerButtonStart);
		/*
		 * 폰트 설정표
		 * 안드 2.2 이하 한글 아님 ubuntu
		 * 안드 2.2 이하 한글 Segoe UI(= Tahoma, 맑은 고딕)
		 * 안드 2.2 이상 HMNUS......
		 * 였으나 API 14 이상이므로 사용할 필요 없음.
		 * 그냥 설정에서 변경하는것으로 결.정
		 */
		Typeface f = Typeface.createFromAsset(getAssets(), "font/HMNUS.ttf");
		switch(Setting.readSettings(EnumSettings.fonttype)){
		case 1: f = Typeface.createFromAsset(getAssets(), "font/Ubuntu.ttf");
		case 2: f = Typeface.createFromAsset(getAssets(), "font/SegoeUI.ttf");
		}
		b.setTypeface(f);
		tv.setTypeface(f);
		
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
		AudioHelper.stopMusic();
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
