package com.redartedgames.ball.myobjects;

import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.Hitbox;
import com.redartedgames.ball.objects.TimeObject;
import com.redartedgames.ball.objects.Hitbox.BehaviorMode;

public class Bubble extends TimeObject{

	
	float radius;
	
	public Bubble(float x, float y, int id, GameObject parent) {
		super(x, y, id, parent);
		radius = 0;
		setHitbox(new Hitbox(positionX, positionY, radius, BehaviorMode.dynamic));
	}
	
	

}
