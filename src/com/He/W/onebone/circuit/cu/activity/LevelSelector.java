package com.He.W.onebone.circuit.cu.activity;

import java.util.ArrayList;
import java.util.Iterator;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.He.W.onebone.circuit.cu.R;
import com.He.W.onebone.circuit.cu.android.ArrayAdapterWithTypeface;
import com.He.W.onebone.circuit.cu.android.ComponentAdapter;
import com.He.W.onebone.circuit.cu.component.EnumComponentType;
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
		
		name.setTypeface(tf);
		author.setTypeface(tf);
		ListView levelList = (ListView)findViewById(R.id.levelList);
		//ComponentAdapter adapter = new ComponentAdapter(this, new ArrayList<EnumComponentType>(), ); 
		//THIS IS NOT A COMPONENT LISTVIEW!!!
		ArrayAdapterWithTypeface<String> adapter = new ArrayAdapterWithTypeface<String>(this,LevelParser.readAllLevels(), tf);
		
		levelList.setAdapter(adapter);
		levelList.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Level lv = 	LevelParser.parseLevel(Environment.getExternalStorageDirectory().getAbsolutePath() + "/CircuitCu/" + LevelParser.readAllLevels().get(arg2) + ".cc");
				name.setText(lv.getName());
				author.setText(lv.getAuthor());
				ArrayList<String> al = new ArrayList<String>();
				Iterator<Object[]> i = RankingHelper.getRankingList(lv.getFile()).iterator();
				while(i.hasNext()){
					al.add((String) i.next()[0]);
				}
				timeRecord.setAdapter(new ArrayAdapterWithTypeface<String>(ctxt,al,tf));
			}
			
		});
	}
}
