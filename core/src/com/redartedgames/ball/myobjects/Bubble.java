package com.redartedgames.ball.myobjects;

import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.TimeObject;

public class Bubble extends TimeObject{

	float maxRadius;
	float radius;
	boolean isGrowing;
	float growVel;
	
	
	
	public Bubble(float x, float y, int id, GameObject parent) {
		super(x, y, id, parent);
		radius = 0;
		maxRadius = 150;
		growVel = 60;
		isGrowing = false;
	}
	
	public void activate() {
		isGrowing = true;
	}
	
	public void updateLast(float delta, float vx, float vy) {
		super.updateLast(delta, vx, vy);
		
		if (isGrowing) {
			growVel = 10 + (maxRadius-radius)/3;
			radius -= delta*growVel;
			if (radius > maxRadius) {
				isGrowing = false;
				radius = maxRadius;
			}
		}
		
	}

}
