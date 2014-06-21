package com.He.W.onebone.circuit.cu.activity;

import com.He.W.onebone.circuit.cu.R;
import com.He.W.onebone.circuit.cu.android.SettingAdapter;
import com.He.W.onebone.circuit.cu.gamebase.AudioHelper;
import com.He.W.onebone.circuit.cu.settings.Setting;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Typeface;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class PreferenceActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_preference);
		AudioHelper.playBGM(this,R.raw.portal2_18_adrenal_vapor, true);
		Button mm = (Button)findViewById(R.id.btnSettingToMainMenu);
		mm.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-gene7rated method stub
				AudioHelper.playEffect(PreferenceActivity.this, 0);
				finish();
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


	public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) { 
        	AudioHelper.playEffect(this, 0);
        }
        return true;
    }
	@Override
	protected void onPause(){
		super.onPause();
		AudioHelper.mp.stop();
	}
	@Override
	protected void onResume(){
		super.onResume();
		AudioHelper.mp.start();
	}
	@Override
	protected void onStop(){
		super.onStop();
		AudioHelper.stopMusic();
	}
	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_preference, menu);
		return true;
	}*/

}
