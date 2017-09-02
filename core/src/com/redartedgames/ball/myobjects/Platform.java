package com.redartedgames.ball.myobjects;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.Hitbox;
import com.redartedgames.ball.objects.Hitbox.BehaviorMode;
import com.redartedgames.ball.objects.TimeObject;

public class Platform extends TimeObject{
	
	public PlatformSprite platformSprite;

	protected float width;
	protected float height;
	
	public Platform(float x, float y, float width, float height, GameObject parent, int id) {
		super(x, y, id, parent);
		this.width = width;
		this.height = height;
		platformSprite = new PlatformSprite(x, y, width, height, id, this);
		addSprite(platformSprite);
	}
	
	
	public void render(ShapeRenderer sr, int priority, float dx, float dy) {
		sr.setColor(100/256f, 100/256f, 100/256f, 1f);
		sr.rect((position.x - width/2+0.5f), position.y - height/2+0.5f, width+0.5f, height+0.5f);
		
	}
	

	
}
