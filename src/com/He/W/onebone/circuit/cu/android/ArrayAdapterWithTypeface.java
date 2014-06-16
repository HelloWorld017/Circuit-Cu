package com.He.W.onebone.circuit.cu.android;

import java.util.List;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.He.W.onebone.circuit.cu.R;

public class ArrayAdapterWithTypeface<T> extends BaseAdapter{
		private LayoutInflater li;
		private List<T> lista;
		private Typeface tf;

		
		public ArrayAdapterWithTypeface(Context ctx, List<T> list, Typeface t){
			lista = list;
			li = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			tf = t;
		}
		
		@Override
		public int getCount() {
			return lista.size();
		}

		@Override
		public Object getItem(int arg0) {
			return lista.get(arg0);
		}

		@Override
		public long getItemId(int arg0) {
			return arg0;
		}
		
	

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			if(arg1 == null){
				arg1 = li.inflate(R.layout.simple_text, arg2, false);
			}
			
			TextView t = (TextView) arg1.findViewById(R.id.textView1);
			t.setTypeface(tf);
			t.setText(lista.get(arg0).toString());
			return arg1;
		}


}
