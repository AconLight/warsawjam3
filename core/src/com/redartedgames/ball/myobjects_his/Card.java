package com.redartedgames.ball.myobjects_his;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.redartedgames.ball.objects.GameObject;

import com.redartedgames.ball.objects.SpriteObject;


public class Card extends GameObject{
	
	private int x;
	private int y;
	private int id;
	public int desiredX;
	public int desiredY;
	public float desiredScale;
	private float scale;
	
	public Card(int x, int y, int id, GameObject parent, float scale) {
		super(x, y, id, parent);
		this.x = x;
		this.y = y;
		this.id = id;
		this.scale = scale;
		addSprite(new CardSprite(x, y, this, 0, id%3+1));
		setScale(scale); 
	}
		
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
		gameObjects.get(0).setPosition(new Vector2(x,y));
	}
	
	public void setScale(float scale) { 
		this.scale = scale;
		((SpriteObject)gameObjects.get(0)).sclX = scale;
		((SpriteObject)gameObjects.get(0)).sclY = scale;
	}
	
	public float getScale() { return scale; }
	
	public int getX() { return x; }
	
	public int getY() { return y; }
}
