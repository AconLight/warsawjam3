package com.redartedgames.ball.myobjects_his;

import java.math.BigDecimal;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.SpriteObject;

public class LittleField extends SpriteObject{

	FieldStatistic statistic;
	float mainScl, scl, sclVel, sclAcc, sclK;
	int xi, yi;
	float posX, posY, pos2x, pos2y;
	public LittleField(float x, float y, GameObject parent, int id, FieldStatistic statistic, int xi, int yi) {
		super(x, y, parent, id);
		this.statistic = statistic;
		scl = 0.95f;
		mainScl = 1;
		sclK = 20;
		posX = x;
		posY = y;
		pos2x = 0;
		pos2y = 0;
		this.xi = xi;
		this.yi = yi;
				
		////////
		//grafika Field
		addTexture("data_his/fieldsprite.png");
		
		
		
		////////
		renderIsNormal = false;
		
	}
	
	public void updateBefore(float delta, float vx, float vy) { 
		
		super.updateBefore(delta, vx, vy);
	}
	public void updateAfter2(float delta, float vx, float vy) { 
		super.updateAfter(delta, vx, vy);
		System.out.println("xi " + xi + ", yi " + yi);
		this.position.set(parent.getPosition());
		mainScl = (float) ((Math.PI + Math.atan(statistic.population/100.0 - 10))/Math.PI/4 + 0.5f);
		velocity.x = xi*50;//statistic.migration/statistic.population*100*xi;
		velocity.y = yi*50;//statistic.migration/statistic.population*100*yi;
		velocityX = new BigDecimal("20");
		pos2x += velocity.x*delta;
		pos2y += velocity.y*delta;
		float k = 200;
		if (pos2x > posX + k) pos2x = posX;
		if (pos2x < posX - k) pos2x = posX;
		if (pos2y > posY + k) pos2y = posY;
		if (pos2y < posY - k) pos2y = posY;
		//scl -= delta;
		sclX = mainScl/10;
		sclY = mainScl/10;
	}
	public void render(SpriteBatch batch, int priority, float dx, float dy) {
		
	}
}
