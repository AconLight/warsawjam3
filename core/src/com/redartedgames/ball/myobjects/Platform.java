package com.redartedgames.ball.myobjects;

import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.TimeObject;

public class Platform extends TimeObject{
	
	private PlatformSprite platformSprite;

	public Platform(float x, float y, int id, GameObject parent) {
		super(x, y, id, parent);
		platformSprite = new PlatformSprite(x, y, id, parent);
		addSprite(platformSprite);
		
		// TODO Auto-generated constructor stub
	}
	

	
}
