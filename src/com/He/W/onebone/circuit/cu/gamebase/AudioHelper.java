package com.He.W.onebone.circuit.cu.gamebase;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import android.content.Context;
import android.media.MediaPlayer;
import android.widget.Toast;

public class AudioHelper {
	
	public static void playBGM(Context ctxt, String bgm){
		if(!(new File(bgm).exists())){
			Toast.makeText(ctxt, "File not exists!", Toast.LENGTH_LONG).show();
			return;
		}else{
			MediaPlayer mp = new MediaPlayer();
			try {
				mp.setDataSource(bgm);
				mp.prepare();
				mp.start();
			} catch (Exception e) {
				Toast.makeText(ctxt, e.getStackTrace().toString(), Toast.LENGTH_LONG).show();
			}
		}
	}
	
	public static void playBGM(Context ctxt, File f){
		if(!f.exists()){
			Toast.makeText(ctxt, "File not exists!", Toast.LENGTH_LONG).show();
		}else{
			MediaPlayer mp = new MediaPlayer();
			try{
				mp.setDataSource(f.getAbsolutePath());
				mp.prepare();
				mp.start();
			}catch(Exception e){
				Toast.makeText(ctxt, e.getStackTrace().toString(), Toast.LENGTH_LONG).show();
			}
		}
	}
	
	public static void playBGM(Context ctxt, int resid){
		
	}
	
	public static void playEffect(String Effect){
		
	}
	
	public static void playEffect(File f){
		
	}
}
