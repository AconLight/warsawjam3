package com.redartedgames.ball.myobjects;

import java.lang.Object;
import java.time.Clock;
import java.util.Random;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.SpriteObject;

public class TimeBar extends SpriteObject{
	private float timeLeft = 600;
	private float x;
	private float y;
	
	public TimeBar(float x, float y, GameObject parent, int id) {
		super(x, y, parent, id);
		this.x = x;
		this.y = y;
		
	}
	
	public void render(ShapeRenderer batch, int priority, float dx, float dy) {
		batch.rect(x, y, timeLeft, 20, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE);
	}
	
	public void updateLast(float delta, float vx, float vy) {
		if(timeLeft > 0) timeLeft -= delta*10;
	}
}
