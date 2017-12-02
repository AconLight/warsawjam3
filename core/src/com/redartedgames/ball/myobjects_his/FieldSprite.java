package com.redartedgames.ball.myobjects_his;

import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.SpriteObject;

public class FieldSprite extends SpriteObject{

	FieldStatistic statistic;
	float mainScl, scl, sclVel, sclAcc, sclK;
	public FieldSprite(float x, float y, GameObject parent, int id, FieldStatistic statistic) {
		super(x, y, parent, id);
		this.statistic = statistic;
		scl = 0.95f;
		mainScl = 1;
		sclK = 20;
		////////
		//grafika Field
		addTexture("data_his/fieldsprite.png");
		
		
		
		////////
		renderIsNormal = true;
		
	}
	
	public void updateBefore(float delta, float vx, float vy) { 
		this.position.set(parent.getPosition());
		//mainScl = (float) ((Math.PI + Math.atan(statistic.population/100.0 - 10))/Math.PI/4 + 0.5f);
		mainScl = (float) (Math.sqrt(statistic.population/100)+ 0.1f);
		sclAcc = ((mainScl) - scl)*sclK;
		sclVel += sclAcc*delta;
		scl += sclVel*delta;
		//scl -= delta;
		sclX = mainScl;
		sclY = mainScl;
	}
}
