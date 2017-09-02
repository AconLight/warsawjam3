package com.redartedgames.ball.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.SpriteObject;

public class BubbleSprite extends SpriteObject{

	private float scaleX = 0;
	private float scaleY = 0;
	
	public BubbleSprite(float x, float y, GameObject parent, int id) {
		super(x, y, parent, id);
		addTexture("data/bubbles/bubble1.png");
		// TODO Auto-generated constructor stub
	}
	
	public void setRadius(float radius) {
		scaleX = 1/(regionList.get(0).getRegionWidth()/(2*radius));
		scaleY = 1/(regionList.get(0).getRegionHeight()/(2*radius));
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
				scaleX, scaleY, alfa);
			//Gdx.app.log("rendered", "spriteobject");
		}
	}
}
