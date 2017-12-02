package com.redartedgames.ball.myobjects_his;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.redartedgames.ball.objects.GameObject;

public class Card extends GameObject{
	
	private int x;
	private int y;
	
	public Card(int x, int y, int id, GameObject parent) {
		super(x, y, id, parent);
		this.x = x;
		this.y = y;
		addSprite(new CardSprite(x, y, this, 0, 1));
	}
	
	public int getX() {
		return x;
	}
	
	public int geyY() {
		return y;
	}
	
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
		gameObjects.get(0).setPosition(new Vector2(x,y));
	}
}
