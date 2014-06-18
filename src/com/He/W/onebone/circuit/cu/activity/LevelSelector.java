package com.He.W.onebone.circuit.cu.activity;

import java.util.ArrayList;
import java.util.Iterator;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
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
import com.He.W.onebone.circuit.cu.settings.Setting;

public class LevelSelector extends android.app.Activity{
	public Context ctxt = this;
	@Override
	public void onCreate(android.os.Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.level_selector);
		final Typeface tf = (Typeface)Setting.getPrefix(0);
		final TextView name = (TextView)findViewById(R.id.tvMapName);
		final TextView author = (TextView)findViewById(R.id.tvAuthor);
		final ListView timeRecord = (ListView)findViewById(R.id.rankingList);
		Button MainMenu = (Button)findViewById(R.id.btnMainMenu);
		Button Play = (Button)findViewById(R.id.btnPlay);
		Button GetM = (Button)findViewById(R.id.btnGetMap);
		MainMenu.setTypeface(tf);
		Play.setTypeface(tf);
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
				Level lv = null;
				try{
				lv = 	LevelParser.parseLevel(Environment.getExternalStorageDirectory().getAbsolutePath() + "/CircuitCu/" + LevelParser.readAllLevels().get(arg2) + ".cc");
				}catch(LevelParseException e){
					Log.d("error", StackTraceToString.convert(e));
				}
				name.setText(lv.getName());
				author.setText(lv.getAuthor());
				ArrayList<String> al = new ArrayList<String>();
				ArrayList<Object[]> rankingr =RankingHelper.getRankingList(lv.getFile());
				if(rankingr != null){
				Iterator<Object[]> i = rankingr.iterator();
				while(i.hasNext()){
					al.add((String) i.next()[0]);
				}
				}else{
					al.add("No record :(");
				}
				timeRecord.setAdapter(new ArrayAdapterWithTypeface<String>(ctxt,al,tf));
				ImageView iv;
				switch(lv.getDifficulty()){
				case 10:iv =(ImageView) findViewById(R.id.star10);iv.setVisibility(View.VISIBLE);
				case 9:iv =(ImageView) findViewById(R.id.star9);iv.setVisibility(View.VISIBLE);
				case 8:iv =(ImageView) findViewById(R.id.star8);iv.setVisibility(View.VISIBLE);
				case 7:iv =(ImageView) findViewById(R.id.star7);iv.setVisibility(View.VISIBLE);
				case 6:iv =(ImageView) findViewById(R.id.star6);iv.setVisibility(View.VISIBLE);
				case 5:iv =(ImageView) findViewById(R.id.star5);iv.setVisibility(View.VISIBLE);
				case 4:iv =(ImageView) findViewById(R.id.star4);iv.setVisibility(View.VISIBLE);
				case 3:iv =(ImageView) findViewById(R.id.star3);iv.setVisibility(View.VISIBLE);
				case 2:iv =(ImageView) findViewById(R.id.star2);iv.setVisibility(View.VISIBLE);
				case 1:iv =(ImageView) findViewById(R.id.star1);iv.setVisibility(View.VISIBLE);
				default:break;
				}
			}
			
		});
		MainMenu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				AudioHelper.playEffect(LevelSelector.this, 0);
				Intent it = new Intent(LevelSelector.this, MainActivity.class);
				it.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
				it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(it);
			}
		});
		Play.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

				AudioHelper.playEffect(LevelSelector.this, 0);
				// TODO Auto-generated method stub
				
			}
		});
		GetM.setTypeface(tf);
		GetM.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Uri uri = Uri.parse("https://www.dropbox.com/sh/d3ztdcecscm23oo/AABXwfKXH3XU-RBQH02vbB_za");
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(uri);
				startActivity(intent);
			}
		});
		
	}
}
