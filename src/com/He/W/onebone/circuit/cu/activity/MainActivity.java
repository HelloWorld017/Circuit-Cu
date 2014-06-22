package com.He.W.onebone.circuit.cu.activity;

import java.util.Random;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.He.W.onebone.circuit.cu.R;
import com.He.W.onebone.circuit.cu.gamebase.AudioHelper;
import com.He.W.onebone.circuit.cu.settings.EnumSettings;
import com.He.W.onebone.circuit.cu.settings.FirstStartingHelper;
import com.He.W.onebone.circuit.cu.settings.Setting;

import de.keyboardsurfer.android.widget.crouton.*;

public class MainActivity extends android.app.Activity {
	private static MainActivity obj;
	
	@Override @Deprecated
	protected void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		FirstStartingHelper.isFirstStart();
		Setting.initSettings(this);
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
		int bgm = Setting.readSettings(EnumSettings.play_bgm);
		Log.d("AhLbug2", "Data : " + bgm);
		if(0 == bgm){
			AudioHelper.playBGM(this, R.raw.portal2_09_the_future_starts_with_you, true);
		}
		AudioHelper.addEffect(MainActivity.this, R.raw.button_click, 0);
		
		
		TextView tv = (TextView) findViewById(R.id.textCircuitCU);
		TextView tv2 = (TextView)findViewById(R.id.message_textview);
		TextView tv3 = (TextView)findViewById(R.id.txtVersion);
		Button startBtn = (Button)findViewById(R.id.GeerButtonStart);
		
		Button htpBtn = (Button)findViewById(R.id.GeerButtonHTP);
		Button prefBtn = (Button)findViewById(R.id.BtnPref);
		prefBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AudioHelper.playEffect(MainActivity.this, 0);
				Intent intent = new Intent(MainActivity.this, PreferenceActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
				startActivity(intent);
			}
		});
		startBtn.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				AudioHelper.playEffect(MainActivity.this, 0);
				Intent intent = new Intent(MainActivity.this, LevelSelector.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
				startActivity(intent);
			}
		});
		htpBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				AudioHelper.playEffect(MainActivity.this, 0);
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
		case 1: f = Typeface.createFromAsset(getAssets(), "font/Ubuntu.ttf");break;
		case 2: f = Typeface.createFromAsset(getAssets(), "font/SegoeUI.ttf");break;
		}
		
		startBtn.setTypeface(f);
		htpBtn.setTypeface(f);
		tv.setTypeface(f);
		tv2.setTypeface(f);
		tv2.setTextColor(Color.CYAN);
		tv3.setTypeface(f);
		tv3.setTextColor(Color.CYAN);
		
		obj = this;
		String[] strArr = getResources().getStringArray(R.array.messages);
		Random r = new Random();
		String str = strArr[r.nextInt(strArr.length - 1)];
		final Crouton crt =  Crouton.makeText(this, str, Style.INFO).setConfiguration(new Configuration.Builder().setDuration(Configuration.DURATION_SHORT).build());
		crt.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AudioHelper.playEffect(MainActivity.this, 0);
				crt.hide();
				
			}
			
		});
		crt.show();
		tv2.setText(str);
		Setting.setPrefix(0,f);
		Log.i("TEST","startBtn, X : " + startBtn.getWidth() + ", Y : " + startBtn.getHeight());
		Log.i("TEST","htpBtn, X : " + htpBtn.getWidth() + ", Y : " + htpBtn.getHeight());
		Log.i("TEST","prefBtn, X : " + prefBtn.getWidth() + ", Y : " + prefBtn.getHeight());
	}
	
	@Override
	protected void onDestroy(){
		super.onDestroy();
		Log.d("PmLbug1","onMainDestroy");
			if(AudioHelper.mp != null){
				AudioHelper.mp.reset();
				AudioHelper.mp = null;
			}
		Crouton.cancelAllCroutons();
		Crouton.clearCroutonsForActivity(this);
	}
	
	@Override
	public void onPause(){
		super.onPause();
			Log.d("PmLbug1","onMainPause");
			if(AudioHelper.mp != null){
				AudioHelper.mp.pause();
			}
			
	}
	@Override
	public void onResume(){
		super.onResume();
		if(Setting.readSettings(EnumSettings.play_bgm) == 0 && AudioHelper.mp != null){
			AudioHelper.mp.start();
		}
		
	}
	@Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) { 
        	final Crouton crt =  Crouton.makeText(this, "Do you want to exit game? Click here to exit.", Style.ALERT).setConfiguration(new Configuration.Builder().setDuration(Configuration.DURATION_LONG).build());
    		crt.setOnClickListener(new View.OnClickListener(){

    			@Override
    			public void onClick(View v) {
    				// TODO Auto-generated method stub
    				crt.hide();
       				System.exit(0);
    			}
    			
    		});
    		crt.show();
    		return false;

        }
        return true;
    }
	public static MainActivity getInstance(){
		return obj;
	}
}
