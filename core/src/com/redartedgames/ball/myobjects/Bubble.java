package com.redartedgames.ball.myobjects;

import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.TimeObject;
import com.redartedgames.ball.sprites.BubbleSprite;

public class Bubble extends TimeObject{

	public float maxRadius;
	public float radius;
	boolean isGrowing;
	float growVel;
	public boolean isDone;
	public BubbleSprite bubbleSprite;
	
	
	public Bubble(float x, float y, int id, GameObject parent) {
		super(x, y, id, parent);
		radius = 0;
		maxRadius = 200;
		growVel = 60;
		isGrowing = false;
		bubbleSprite = new BubbleSprite(x, y, this, 0);
		addSprite(bubbleSprite);
		activate();
		isDone = false;
	}
	
	public void activate() {
		isGrowing = true;
	}
	
	public void updateLast(float delta, float vx, float vy) {
		super.updateLast(delta, vx, vy);
		bubbleSprite.setRadius(radius);
		if (isGrowing) {
			growVel = 50 + (maxRadius-radius)*(maxRadius-radius)/100;
			radius += delta*growVel;
			if (radius > maxRadius) {
				isGrowing = false;
				radius = maxRadius;
			}
		}
		else {
			growVel = -5;
			radius += delta*growVel;
			if (radius < 0)  { 
				radius = 0;
				((Player) parent).bubbles.remove(this);
			}
		}
		
		
	}

}
