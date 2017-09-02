package com.redartedgames.ball.objects;

import java.math.BigDecimal;

public class TimeObject extends GameObject{
	
	public int type;
	private boolean timeIsNormal;
	public float timeScale;
	
	public TimeObject(float x, float y, int id, GameObject parent) {
		super(x, y, id, parent);
		timeScale = 1;
		timeIsNormal = false;
	}
	
	public void updateBefore(float delta, float vx, float vy) {
		if (!timeIsNormal) delta *= timeScale;
		super.updateBefore(delta, vx, vy);
	}
	

	public void updateAfter(float delta, float vx, float vy) {
		if (!timeIsNormal) delta *= timeScale;
		super.updateAfter(delta, vx, vy);
	}
	
	public void updateLast(float delta, float vx, float vy) {
		if (!timeIsNormal) delta *= timeScale;
		super.updateLast(delta, vx, vy);
	}
	
	public void setTimeIsNormal(boolean q) {
		timeIsNormal = q;
	}
	

}
