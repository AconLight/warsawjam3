package com.redartedgames.ball.myobjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.SpriteObject;

public class TimeBar extends SpriteObject{
	public float timeLeft = 600;
	private float x;
	private float y;
	
	public TimeBar(float x, float y, GameObject parent, int id) {
		super(x, y, parent, id);
		this.x = x;
		this.y = y;		
	}
	
	public void render(ShapeRenderer batch, int priority, float dx, float dy) {
		batch.rect(x-2, y-2, 604, 24, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK);
		batch.rect(x, y, 600, 20, Color.RED, Color.GREEN, Color.GREEN, Color.RED);
		batch.rect(x+600, y, -600+timeLeft, 20, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK);
	}
	
	public void updateLast(float delta, float vx, float vy) {
		if(timeLeft > 0 && timeLeft <= 600) timeLeft -= delta*10;
		else if(timeLeft > 600) timeLeft = 600;
		else timeLeft = 0;
	}
}
