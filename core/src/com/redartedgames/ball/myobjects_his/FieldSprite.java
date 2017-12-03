package com.redartedgames.ball.myobjects_his;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.SpriteObject;

public class FieldSprite extends SpriteObject{

	FieldStatistic statistic;
	float mainScl, scl, sclVel, sclAcc, sclK;
	float posX, posY, pos2x, pos2y;
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
		float v = 50;
		System.out.println(v);
		if (v > 100) v = 100;
		pos2x += v*delta;
		pos2y += v*delta;
		float k = 200;
		if (pos2x > posX + k) pos2x = posX;
		if (pos2x < posX - k) pos2x = posX;
		if (pos2y > posY + k) pos2y = posY;
		if (pos2y < posY - k) pos2y = posY;
		
		for (GameObject obj : getGameObjects()) {
			((LittleField)obj).updateAfter2(delta, 0, 0);
		}
	}
public void render(SpriteBatch batch, int priority, float dx, float dy) {
		
		
		//batch.draw(regionList.get(frameNum), position.x - regionList.get(frameNum).getRegionWidth()/2,
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (!(i==1 && j==1))
			batch.draw(regionList.get(frameNum), pos2x*(i-1) + position.x + dx - regionList.get(frameNum).getRegionWidth()/2,
					
					pos2x*(j-1) + position.y + dy - regionList.get(frameNum).getRegionHeight()/2,
					regionList.get(frameNum).getRegionWidth()/2, regionList.get(frameNum).getRegionHeight()/2,
					regionList.get(frameNum).getRegionWidth(), regionList.get(frameNum).getRegionHeight(),
					sclX/10, sclY/10, alfa);
			}
		}
		
		//position.y - regionList.get(frameNum).getRegionHeight()/2);
		if (isVisible && regionList.size() != 0) {
			if (renderIsNormal) {
				dx = 0;
				dy = 0;
			}
			batch.draw(regionList.get(frameNum), position.x + dx - regionList.get(frameNum).getRegionWidth()/2,
		
				position.y + dy - regionList.get(frameNum).getRegionHeight()/2,
				regionList.get(frameNum).getRegionWidth()/2, regionList.get(frameNum).getRegionHeight()/2,
				regionList.get(frameNum).getRegionWidth(), regionList.get(frameNum).getRegionHeight(),
				sclX + 0.1f, sclY + 0.1f, alfa);
			//Gdx.app.log("rendered", "spriteobject");
		}
	}
}
