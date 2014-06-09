package com.He.W.onebone.circuit.cu.activity;

import com.He.W.onebone.circuit.cu.R;
import com.He.W.onebone.circuit.cu.android.SettingAdapter;
import com.He.W.onebone.circuit.cu.settings.Setting;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class PreferenceActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_preference);
		Button mm = (Button)findViewById(R.id.btnSettingToMainMenu);
		mm.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
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

	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_preference, menu);
		return true;
	}*/

}
