package com.He.W.onebone.circuit.cu.achievement;

abstract public class BaseAchievement {
	private int achievementId;
	private String message, title;
	private boolean success;
	
	public BaseAchievement(int achievementId, String title, String message){
		int result = AchievementManager.addAchievement(achievementId, this);
		if(result == 1){
			this.achievementId = achievementId;
			this.message = message;
			this.title = title;
			success = true;
			return;
		}
		success = false;
	}
	
	public final String getTitle(){
		return title;
	}
	
	public final String getMessage(){
		return message;
	}
	
	public final int getAchievementId(){
		return achievementId;
	}
	
	public final boolean isSuccessfullyCreated(){
		return success;
	}
}