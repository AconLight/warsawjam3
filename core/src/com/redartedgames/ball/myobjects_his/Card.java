package com.redartedgames.ball.myobjects_his;

import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.math.Vector2;
import com.redartedgames.ball.game_his.GameWorld_his;
import com.redartedgames.ball.objects.GameObject;

import com.redartedgames.ball.objects.SpriteObject;


public class Card extends GameObject{
	
	private int x;
	private int y;
	public int id;
	public int desiredX;
	public int desiredY;
	public float desiredScale;
	private float scale;
	public int cost;
	private GameWorld_his gameworld;
	
	public Card(int x, int y, int id, GameObject parent, float scale, GameWorld_his gameworld) {
		super(x, y, id, parent);
		this.x = x;
		this.y = y;
		this.id = id;
		this.scale = scale;
		this.gameworld = gameworld;
		addSprite(new CardSprite(x, y, this, 0, id));
		setCost();
		setScale(scale); 
	}
	
	public void setCost() {
		switch(id) {
			default:
			case 1:
				cost = 11;
				break;
			case 2:
				cost = 14;
				break;
			case 3:
				cost = 11;
				break;
			case 4:
				cost = 7;
				break;
			case 5:
				cost = 17;
				break;
			case 6:
				cost = 16;
				break;
			case 7:
				cost = 9;
				break;
			case 8:
				cost = 11;
				break;
			case 9:
				cost = 10;
				break;
			case 10:
				cost = 10;
				break;
			case 11:
				cost = 8;
				break;
			case 12:
				cost = 13;
				break;
			case 13:
				cost = 10;
				break;
			case 14:
				cost = 13;
				break;
			case 15:
				cost = 6;
				break;
			case 16:
				cost = 15;
				break;
			case 17:
				cost = 7;
				break;
		}
	}
	
	public void use() {
		switch(id) {
			default:
			case 1:
				//gameworld.fieldManager.currentField;
				
				break;
			case 2:
				cost = 14;
				break;
			case 3:
				cost = 11;
				break;
			case 4:
				cost = 7;
				break;
			case 5:
				cost = 17;
				break;
			case 6:
				cost = 16;
				break;
			case 7:
				cost = 9;
				break;
			case 8:
				cost = 11;
				break;
			case 9:
				cost = 10;
				break;
			case 10:
				cost = 10;
				break;
			case 11:
				cost = 8;
				break;
			case 12:
				cost = 13;
				break;
			case 13:
				cost = 10;
				break;
			case 14:
				cost = 13;
				break;
			case 15:
				cost = 6;
				break;
			case 16:
				cost = 15;
				break;
			case 17:
				cost = 7;
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
