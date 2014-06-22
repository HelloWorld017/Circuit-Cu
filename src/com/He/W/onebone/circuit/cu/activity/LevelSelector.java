package com.He.W.onebone.circuit.cu.activity;

import java.util.ArrayList;
import java.util.Iterator;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ImageView;

import com.He.W.onebone.circuit.cu.R;
import com.He.W.onebone.circuit.cu.StackTraceToString;
import com.He.W.onebone.circuit.cu.android.ArrayAdapterWithTypeface;
import com.He.W.onebone.circuit.cu.exception.LevelParseException;
import com.He.W.onebone.circuit.cu.gamebase.AudioHelper;
import com.He.W.onebone.circuit.cu.map.Level;
import com.He.W.onebone.circuit.cu.map.LevelParser;
import com.He.W.onebone.circuit.cu.map.RankingHelper;
import com.He.W.onebone.circuit.cu.settings.EnumSettings;
import com.He.W.onebone.circuit.cu.settings.Setting;

public class LevelSelector extends android.app.Activity{
	public Context ctxt = this;
	private MediaPlayer prMP = null;
	private boolean playMusic = (Setting.readSettings(EnumSettings.play_bgm) == 0);
	private Level selectedLevel = null;
	
	@Override
	public void onCreate(android.os.Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.level_selector);
		if(playMusic){
			prMP = MediaPlayer.create(this,R.raw.portal2_09_the_future_starts_with_you);
			prMP.setLooping(true);
			prMP.start();
		}
	
		final Typeface tf = (Typeface)Setting.getPrefix(0);
		final TextView name = (TextView)findViewById(R.id.tvMapName);
		final TextView author = (TextView)findViewById(R.id.tvAuthor);
		final ListView timeRecord = (ListView)findViewById(R.id.rankingList);
		Button mainMenu = (Button)findViewById(R.id.btnMainMenu);
		Button play = (Button)findViewById(R.id.btnPlay);
		Button getM = (Button)findViewById(R.id.btnGetMap);
		mainMenu.setTypeface(tf);
		play.setTypeface(tf);
		name.setTypeface(tf);
		author.setTypeface(tf);
		
		
		ListView levelList = (ListView)findViewById(R.id.levelList);
		//ComponentAdapter adapter = new ComponentAdapter(this, new ArrayList<EnumComponentType>(), ); 
		//THIS IS NOT A COMPONENT LISTVIEW!!!
		ArrayAdapterWithTypeface<String> adapter = new ArrayAdapterWithTypeface<String>(this,LevelParser.readAllLevels(), tf);
		
		levelList.setAdapter(adapter);
		levelList.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				
				AudioHelper.playEffect(LevelSelector.this, 0);
				//Level lv = null;
				try{
					selectedLevel = LevelParser.parseLevel(Environment.getExternalStorageDirectory().getAbsolutePath() + "/CircuitCu/" + LevelParser.readAllLevels().get(arg2));
				}catch(LevelParseException e){
					Log.d("error", StackTraceToString.convert(e));
					name.setText("WRONG MAP FILE");
					author.setText("WRONG MAP FILE");
					return;
				}
				name.setText(selectedLevel.getName());
				author.setText(selectedLevel.getAuthor());
				ArrayList<String> al = new ArrayList<String>();
				ArrayList<Object[]> rankingr =RankingHelper.getRankingList(selectedLevel.getFile());
				if(rankingr != null){
				Iterator<Object[]> i = rankingr.iterator();
				while(i.hasNext()){
					al.add((String) i.next()[0]);
				}
				}else{
					al.add("No record :(");
				}
				timeRecord.setAdapter(new ArrayAdapterWithTypeface<String>(ctxt,al,tf));
				switch(selectedLevel.getDifficulty()){
				case 10:((ImageView) findViewById(R.id.star10)).setVisibility(View.VISIBLE);
				case 9:((ImageView) findViewById(R.id.star9)).setVisibility(View.VISIBLE);
				case 8:((ImageView) findViewById(R.id.star8)).setVisibility(View.VISIBLE);
				case 7:((ImageView) findViewById(R.id.star7)).setVisibility(View.VISIBLE);
				case 6:((ImageView) findViewById(R.id.star6)).setVisibility(View.VISIBLE);
				case 5:((ImageView) findViewById(R.id.star5)).setVisibility(View.VISIBLE);
				case 4:((ImageView) findViewById(R.id.star4)).setVisibility(View.VISIBLE);
				case 3:((ImageView) findViewById(R.id.star3)).setVisibility(View.VISIBLE);
				case 2:((ImageView) findViewById(R.id.star2)).setVisibility(View.VISIBLE);
				case 1:((ImageView) findViewById(R.id.star1)).setVisibility(View.VISIBLE);
				default:break;
				}
			}
			
		});
		mainMenu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				AudioHelper.playEffect(LevelSelector.this, 0);
				Intent it = new Intent(LevelSelector.this, MainActivity.class);
				it.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
				it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(it);
			}
		});
		play.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

				AudioHelper.playEffect(LevelSelector.this, 0);
				if(selectedLevel == null) return;
				GameActivity activity = new GameActivity(selectedLevel);
				Intent intent = new Intent(LevelSelector.this, activity.getClass());
				startActivity(intent);
			}
		});
		getM.setTypeface(tf);
		getM.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Uri uri = Uri.parse("https://www.dropbox.com/sh/d3ztdcecscm23oo/AABXwfKXH3XU-RBQH02vbB_za");
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(uri);
				startActivity(intent);
			}
		});
		
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
		if(prMP != null){
			prMP.stop();
			prMP.reset();
			prMP = null;
		}
		
	}
	@Override
	protected void onResume(){
		super.onResume();
		if(prMP == null && playMusic){
			prMP = MediaPlayer.create(this,R.raw.portal2_18_adrenal_vapor);
			prMP.setLooping(true);
			prMP.start();
		}
	}
	@Override
	protected void onDestroy(){
		super.onDestroy();
		if(prMP != null){
			prMP.stop();
			prMP.reset();
			prMP = null;
		}
		
	}
}
