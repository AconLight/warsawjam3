package com.redartedgames.ball.myobjects_his;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.redartedgames.ball.objects.GameObject;

import com.redartedgames.ball.objects.SpriteObject;


public class Card extends GameObject{
	
	private int x;
	private int y;
	public int moveCounter = 0;
	public int desiredX;
	public int desiredY;
	public int speed = 0;
	
	public Card(int x, int y, int id, GameObject parent) {
		super(x, y, id, parent);
		this.x = x;
		this.y = y;
		addSprite(new CardSprite(x, y, this, 0, id%3+1));
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
		gameObjects.get(0).setPosition(new Vector2(x,y));
	}
	
	public void enlarge() {
		((SpriteObject)gameObjects.get(0)).sclX = 2f;
		((SpriteObject)gameObjects.get(0)).sclY = 2f;
	}
	
	public void normalSize() {
		((SpriteObject)gameObjects.get(0)).sclX = 1.5f;
		((SpriteObject)gameObjects.get(0)).sclY = 1.5f;
	}
}
