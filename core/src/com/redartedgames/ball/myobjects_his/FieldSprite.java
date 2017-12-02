package com.redartedgames.ball.myobjects_his;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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

		addSprite(new LittleField(x, y, this, id, statistic, -1, -1));
		addSprite(new LittleField(x, y, this, id, statistic, -1, 0));
		addSprite(new LittleField(x, y, this, id, statistic, -1, 1));
		addSprite(new LittleField(x, y, this, id, statistic, 0, -1));
		addSprite(new LittleField(x, y, this, id, statistic, 0, 1));
		addSprite(new LittleField(x, y, this, id, statistic, 1, 1));
		addSprite(new LittleField(x, y, this, id, statistic, 1, 0));
		addSprite(new LittleField(x, y, this, id, statistic, 1, -1));
		
		
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
		for (GameObject obj : getGameObjects()) {
			((LittleField)obj).updateAfter2(delta, 0, 0);
		}
	}
public void render(SpriteBatch batch, int priority, float dx, float dy) {
		
		
		//batch.draw(regionList.get(frameNum), position.x - regionList.get(frameNum).getRegionWidth()/2,
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
		for (GameObject obj : getGameObjects()) {

			batch.draw(((LittleField)obj).regionList.get(frameNum), ((LittleField)obj).pos2x + position.x + dx - ((LittleField)obj).regionList.get(frameNum).getRegionWidth()/2,
					
					((LittleField)obj).pos2y + position.y + dy - ((LittleField)obj).regionList.get(frameNum).getRegionHeight()/2,
					((LittleField)obj).regionList.get(frameNum).getRegionWidth()/2, ((LittleField)obj).regionList.get(frameNum).getRegionHeight()/2,
					((LittleField)obj).regionList.get(frameNum).getRegionWidth(), ((LittleField)obj).regionList.get(frameNum).getRegionHeight(),
					sclX/10, sclY/10, alfa);
		}
	}
}
