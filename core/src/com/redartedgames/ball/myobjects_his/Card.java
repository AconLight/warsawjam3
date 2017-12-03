package com.redartedgames.ball.myobjects_his;

import com.badlogic.gdx.graphics.Texture.TextureFilter;
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
	public int cost;
	
	public Card(int x, int y, int id, GameObject parent, float scale) {
		super(x, y, id, parent);
		this.x = x;
		this.y = y;
		this.id = id;
		this.scale = scale;
		addSprite(new CardSprite(x, y, this, 0, id));
		setCost();
		setScale(scale); 
	}
	
	public void setCost() {
		switch(id) {
			default:
			case 1:
				cost = 10;
				break;
			case 2:
				cost = 8;
				break;
			case 3:
				cost = 6;
				break;
			case 4:
				cost = 8;
				break;
			case 5:
				cost = 4;
				break;
			case 6:
				cost = 8;
				break;
			case 7:
				cost = 12;
				break;
			case 8:
				cost = 6;
				break;
			case 9:
				cost = 8;
				break;
		}
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
