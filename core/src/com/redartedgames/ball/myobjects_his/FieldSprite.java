package com.redartedgames.ball.myobjects_his;

import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.SpriteObject;

public class FieldSprite extends SpriteObject{

	FieldStatistic statistic;
	
	public FieldSprite(float x, float y, GameObject parent, int id, FieldStatistic statistic) {
		super(x, y, parent, id);
		this.statistic = statistic;
		////////
		//grafika Field
		addTexture("data_his/fieldsprite.png");
		
		
		
		////////
		renderIsNormal = true;
	}
	
	public void updateBefore(float delta, float vx, float vy) { 
		this.position.set(parent.getPosition());
	}
}
