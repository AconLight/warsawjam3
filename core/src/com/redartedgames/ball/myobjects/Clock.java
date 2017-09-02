package com.redartedgames.ball.myobjects;

import com.redartedgames.ball.objects.ColSpriteObject;
import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.TimeObject;

public class Clock extends TimeObject{

	public ClockSprite clock;
	
	public Clock(float x, float y, GameObject parent, int id, int type, Player player) {
		super(x, y, id, parent);
		clock = new ClockSprite(x, y, parent, id, type, player);
		addSprite(clock);
		
	}
	
	public void generate() {
		
	}
	

}
