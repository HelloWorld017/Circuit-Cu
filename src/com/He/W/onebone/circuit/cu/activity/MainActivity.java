package com.He.W.onebone.circuit.cu.activity;

import java.util.Random;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.He.W.onebone.circuit.cu.R;
import com.He.W.onebone.circuit.cu.gamebase.AudioHelper;
import com.He.W.onebone.circuit.cu.settings.EnumSettings;
import com.He.W.onebone.circuit.cu.settings.Setting;

import de.keyboardsurfer.android.widget.crouton.*;

public class MainActivity extends android.app.Activity {
	private static MainActivity obj;
	
	@Override @Deprecated
	protected void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Setting.initSettings(this);
		
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
		
		TextView tv = (TextView) findViewById(R.id.textCircuitCU);
		Button startBtn = (Button)findViewById(R.id.GeerButtonStart);
	
		Button editBtn = (Button)findViewById(R.id.GeerButtonEdit);
		Button htpBtn = (Button)findViewById(R.id.GeerButtonHTP);
		startBtn.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				Intent intent = new Intent(MainActivity.this, LevelSelector.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
				startActivity(intent);
			}
		});
		htpBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, Tutorial.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
				startActivity(intent);
			}
		});
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
		startBtn.setTypeface(f);
		editBtn.setTypeface(f);
		htpBtn.setTypeface(f);
		tv.setTypeface(f);
		
		obj = this;
		String[] strArr = getResources().getStringArray(R.array.messages);
		Random r = new Random();
		String str = strArr[r.nextInt(strArr.length - 1)];
		final Crouton crt =  Crouton.makeText(this, str, Style.INFO).setConfiguration(new Configuration.Builder().setDuration(Configuration.DURATION_SHORT).build());
		crt.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				crt.hide();
				
			}
			
		});
		crt.show();
		((TextView)findViewById(R.id.message_textview)).setText(str);
		Setting.setPrefix(0,f);
	}
	
	@Override
	protected void onDestroy(){
		super.onDestroy();
		AudioHelper.stopMusic();
		Crouton.cancelAllCroutons();
		Crouton.clearCroutonsForActivity(this);
	}
	
	@Override
	public void onPause(){
		super.onPause();
		AudioHelper.stopMusic();
	}
	
	public static MainActivity getInstance(){
		return obj;
	}
}
