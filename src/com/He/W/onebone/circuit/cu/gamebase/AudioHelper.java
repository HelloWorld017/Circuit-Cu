package com.He.W.onebone.circuit.cu.gamebase;

import java.io.File;
import java.util.ArrayList;

import com.He.W.onebone.circuit.cu.StackTraceToString;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.util.Log;
import android.widget.Toast;

public class AudioHelper {
	public static MediaPlayer mp = null;
	public static SoundPool sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
	public static ArrayList<Integer> effects = new ArrayList<Integer>();
	
	public static void stopMusic(){
		if(mp!=null){
			/*mp.stop();
			mp.release();*/
			//mp.reset();
			mp.release();
			mp = null;
		}
		
		
	}
	public static void playBGM(Context ctxt, String bgm,boolean isRepeating){
		if(!(new File(bgm).exists())){
			Toast.makeText(ctxt, "File not exists!", Toast.LENGTH_LONG).show();
			return;
		}else{
			if(mp != null){
				stopMusic();
			}
				mp = new MediaPlayer();
			

			try {
				mp.setDataSource(bgm);
				
				mp.prepare();
				mp.setLooping(isRepeating);
				mp.start();
			} catch (Exception e) {
				Log.d("AhLerror1", StackTraceToString.convert(e));
			}
		}
	}
	
	public static void playBGM(Context ctxt, File f,Boolean b){
		if(!f.exists()){
			Toast.makeText(ctxt, "File not exists!", Toast.LENGTH_LONG).show();
		}else{
			if(mp != null){
				stopMusic();
			}
				mp = new MediaPlayer();	
			
			try{
				mp.setDataSource(f.getAbsolutePath());
				mp.prepare();
				mp.setLooping(b);
				mp.start();
			}catch(Exception e){
				Log.d("AhLerror1", StackTraceToString.convert(e));
			}
		}
	}
	
	public static void playBGM(Context ctxt, int resid,boolean b){
		if(mp != null){
			stopMusic();
		}
		mp = MediaPlayer.create(ctxt, resid);
		
		try {
			mp.setLooping(b);
		} catch (Exception e) {
			Log.d("AhLerror1", StackTraceToString.convert(e));
		}
		mp.start();
	}
	//for future compatibility, priority value should be 1
	public static void addEffect(Context ctxt, int resid, int i){
		effects.add(i, sp.load(ctxt, resid,1));
	}
	
	public static void addEffect(File f, int i){
		effects.add(i, sp.load(f.getAbsolutePath(), 1));
		
	}
	public static void playEffect(Context ctxt, int it){
		AudioManager am = (AudioManager) ctxt.getSystemService (Context.AUDIO_SERVICE);
	    int mv = am.getStreamVolume(AudioManager.STREAM_MUSIC);
	    sp.play(effects.get(it), mv, mv, 1, 0, 1f);
	}
}
