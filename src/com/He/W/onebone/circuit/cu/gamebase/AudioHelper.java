package com.He.W.onebone.circuit.cu.gamebase;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.widget.Toast;

public class AudioHelper {
	private static MediaPlayer mp = null;
	private static SoundPool sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
	private static int effect_0 = 0;
	private static int effect_1 = 0;
	private static int effect_2 = 0;
	private static int effect_3 = 0;
	private static int effect_4 = 0;
	
	public static void stopMusic(){
		
		mp.stop();
		mp.release();
		mp.reset();
		
	}
	public static void playBGM(Context ctxt, String bgm,boolean isRepeating){
		if(!(new File(bgm).exists())){
			Toast.makeText(ctxt, "File not exists!", Toast.LENGTH_LONG).show();
			return;
		}else{
			if(mp != null){
				stopMusic();
			}else{
				mp = new MediaPlayer();
			}

			try {
				mp.setDataSource(bgm);
				mp.setLooping(isRepeating);
				mp.prepare();
				mp.start();
			} catch (Exception e) {
				Toast.makeText(ctxt, e.getStackTrace().toString(), Toast.LENGTH_LONG).show();
			}
		}
	}
	
	public static void playBGM(Context ctxt, File f,Boolean b){
		if(!f.exists()){
			Toast.makeText(ctxt, "File not exists!", Toast.LENGTH_LONG).show();
		}else{
			if(mp != null){
				stopMusic();
			}else{
				mp = new MediaPlayer();	
			}
			try{
				mp.setDataSource(f.getAbsolutePath());
				mp.setLooping(b);
				mp.prepare();
				mp.start();
			}catch(Exception e){
				Toast.makeText(ctxt, e.getStackTrace().toString(), Toast.LENGTH_LONG).show();
			}
		}
	}
	
	public static void playBGM(Context ctxt, int resid,boolean b){
		if(mp != null){
			stopMusic();
		}
		mp = MediaPlayer.create(ctxt, resid);
		mp.setLooping(b);
		try {
			mp.prepare();
		} catch (Exception e) {
			Toast.makeText(ctxt, e.getStackTrace().toString(), Toast.LENGTH_LONG).show();
		}
		mp.start();
	}
	//for future compatibility, priority value should be 1
	public static void addEffect(Context ctxt, int resid, int i){
		switch(i){
		case 0:effect_0 = sp.load(ctxt, resid, 1);break;
		case 1:effect_1 = sp.load(ctxt, resid, 1);break;
		case 2:effect_2 = sp.load(ctxt, resid, 1);break;
		case 3:effect_3 = sp.load(ctxt, resid, 1);break;
		case 4:effect_4 = sp.load(ctxt, resid, 1);break;
		}
	}
	
	public static void addEffect(File f, int i){
		switch(i){
		case 0:effect_0 = sp.load(f.getAbsolutePath(), 1);break;
		case 1:effect_1 = sp.load(f.getAbsolutePath(), 1);break;
		case 2:effect_2 = sp.load(f.getAbsolutePath(), 1);break;
		case 3:effect_3 = sp.load(f.getAbsolutePath(), 1);break;
		case 4:effect_4 = sp.load(f.getAbsolutePath(), 1);break;
		}
		
	}
	public static void playEffect(Context ctxt, int it){
		AudioManager am = (AudioManager) ctxt.getSystemService (Context.AUDIO_SERVICE);
	    int mv = am.getStreamVolume(AudioManager.STREAM_MUSIC);
		switch(it){
		case 0:if(effect_0 != 0){sp.play(effect_0, mv, mv, 1, 0, 1f);}break;
		case 1:if(effect_1 != 0){sp.play(effect_1, mv, mv, 1, 0, 1f);}break;
		case 2:if(effect_2 != 0){sp.play(effect_2, mv, mv, 1, 0, 1f);}break;
		case 3:if(effect_3 != 0){sp.play(effect_3, mv, mv, 1, 0, 1f);}break;
		case 4:if(effect_4 != 0){sp.play(effect_4, mv, mv, 1, 0, 1f);}break;
		}
	}
}
