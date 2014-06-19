package com.He.W.onebone.circuit.cu.activity;

import com.He.W.onebone.circuit.cu.R;
import com.He.W.onebone.circuit.cu.android.SettingAdapter;
import com.He.W.onebone.circuit.cu.gamebase.AudioHelper;
import com.He.W.onebone.circuit.cu.settings.EnumSettings;
import com.He.W.onebone.circuit.cu.settings.Setting;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class PreferenceActivity extends Activity {
	public boolean isgaw = false;
	public boolean isgau = false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_preference);
		Button mm = (Button)findViewById(R.id.btnSettingToMainMenu);
		mm.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-gene7rated method stub
				isgau = true;
				AudioHelper.playEffect(PreferenceActivity.this, 0);
				MainActivity.isGGAW = true;
				Intent intent = new Intent(PreferenceActivity.this, MainActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}
		});
		Log.d("PrL1bug", "PrefActivity onCreate");
		mm.setTypeface((Typeface)Setting.getPrefix(0));
		ListView lv = (ListView)findViewById(R.id.lstSettings);
		Log.d("PrL1bug", "ListView Declare");
		lv.setAdapter(new SettingAdapter(this));
	}
	@Override
	protected void onDestroy(){
		super.onDestroy();
		Setting.destroyHelper();
	}
	@Override
	protected void onPause(){
		super.onPause();
		isgaw = true;
		if(!isgau){
			Log.d("PmLbug1","Gotcha! " + isgau );
			AudioHelper.stopMusic();
		}
		
	}
	@Override
	protected void onResume(){
		super.onResume();
		if(isgaw && Setting.readSettings(EnumSettings.play_bgm) == 0){
			AudioHelper.playBGM(this, R.raw.portal2_12_the_friendly_faith_plate, true);
			isgaw = false;
		}
	}
	public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) { 
        	AudioHelper.playEffect(this, 0);
			isgau = true;
			MainActivity.isGGAW = true;
			Intent it = new Intent(this, MainActivity.class);
			it.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
			it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(it);
    		return false;

        }
        return true;
    }
	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_preference, menu);
		return true;
	}*/

}
