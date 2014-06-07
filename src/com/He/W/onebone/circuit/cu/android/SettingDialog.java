package com.He.W.onebone.circuit.cu.android;

import java.util.ArrayList;

import com.He.W.onebone.circuit.cu.R;
import com.He.W.onebone.circuit.cu.settings.EnumSettings;
import com.He.W.onebone.circuit.cu.settings.Setting;
import com.He.W.onebone.circuit.cu.settings.SettingSpefHelper;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class SettingDialog extends Dialog{
	private EnumSettings namae;
	private Context ctxt;
	private int value;
	public SettingDialog(Context context) {
		super(context);
		ctxt = context;
		// TODO Auto-generated constructor stub
	}
	public SettingDialog(Context context, EnumSettings es){
		super(context);
		ctxt = context;
		namae = es;
	}
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.custom_setting_dialog);
		Spinner sp;
		sp = (Spinner)findViewById(R.id.lstSettingList);
		ArrayList<String> values = new ArrayList<String>();
		SettingSpefHelper ssh = new SettingSpefHelper(ctxt);
		int a;
		if(namae != null){
			a = ssh.getValueAmount(namae);
			Log.d("PrL2bug", "namae is not null data : " + a + ", " +namae.name());
		}else{
			Log.d("PrL2bug", "namae is null");
			a = 0;
		}
		for(int b = 1; b < a + 1;b++){
			values.add(ssh.getValueAvailable(namae, b));
		}
		ArrayAdapter<String> sa = new ArrayAdapter<String>(ctxt, android.R.layout.simple_spinner_item, values );
		sa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp.setAdapter(sa);
		
		sp.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				value = position;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				value = Setting.readSettings(namae);
			}
			
		});
		Button ok;
		Button cancel;
		ok = (Button)findViewById(R.id.btnOK);
		cancel = (Button)findViewById(R.id.btnCancel);
		ok.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Setting.writeSettings(namae, value);
				dismiss();
			}
		});
		cancel.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dismiss();
			}
		});
		
		
	}
	public void setSettingNamae(EnumSettings es){
			namae = es;
	}
}
