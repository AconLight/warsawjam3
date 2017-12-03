package com.redartedgames.ball.myobjects_his;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
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
	public Sound sound;
	private GameWorld_his gameworld;
	float population, migration, affliction, kurwtura;
	
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
				population = -5;
				migration = 0;
				affliction = 9;
				kurwtura = 0;
				sound = Gdx.audio.newSound(Gdx.files.internal("data_his/audio/voice/apoteoza.mp3"));
				break;
			case 2:
				cost = 14;
				population = 7;
				migration = -5;
				affliction = 3;
				kurwtura = 0;
				sound = Gdx.audio.newSound(Gdx.files.internal("data_his/audio/voice/dzieci.mp3"));
				break;
			case 3:
				cost = 11;
				population = 2;
				migration = 0;
				affliction = 4;
				kurwtura = -4;
				sound = Gdx.audio.newSound(Gdx.files.internal("data_his/audio/voice/handel.mp3"));
				break;
			case 4:
				cost = 7;
				population = 9;
				migration = 0;
				affliction = 0;
				kurwtura = 0;
				sound = Gdx.audio.newSound(Gdx.files.internal("data_his/audio/voice/higiena.mp3"));
				break;
			case 5:
				cost = 17;
				population = -3;
				migration = -3;
				affliction = 5;
				kurwtura = 3;
				sound = Gdx.audio.newSound(Gdx.files.internal("data_his/audio/voice/knajpa.mp3"));
				break;
			case 6:
				cost = 16;
				population = 9;
				migration = 8;
				affliction = 0;
				kurwtura = -2;
				sound = Gdx.audio.newSound(Gdx.files.internal("data_his/audio/voice/medycyna.mp3"));
				break;
			case 7:
				cost = 9;
				population = 0;
				migration = 0;
				affliction = 5;
				kurwtura = 9;
				sound = Gdx.audio.newSound(Gdx.files.internal("data_his/audio/voice/opera.mp3"));
				break;
			case 8:
				cost = 11;
				population = 0;
				migration = -3;
				affliction = 7;
				kurwtura = -4;
				sound = Gdx.audio.newSound(Gdx.files.internal("data_his/audio/voice/przemysl.mp3"));
				break;
			case 9:
				cost = 10;
				population = 9;
				migration = 0;
				affliction = 0;
				kurwtura = -9;
				sound = Gdx.audio.newSound(Gdx.files.internal("data_his/audio/voice/przygoda.mp3"));
				break;
			case 10:
				cost = 10;
				population = -9;
				migration = 0;
				affliction = 0;
				kurwtura = 9;
				sound = Gdx.audio.newSound(Gdx.files.internal("data_his/audio/voice/przygoda2.mp3"));
				break;
			case 11:
				cost = 8;
				population = 5;
				migration = 0;
				affliction = 5;
				kurwtura = 1;
				sound = Gdx.audio.newSound(Gdx.files.internal("data_his/audio/voice/radosc.mp3"));
				break;
			case 12:
				cost = 13;
				population = 7;
				migration = 3;
				affliction = 9;
				kurwtura = 4;
				sound = Gdx.audio.newSound(Gdx.files.internal("data_his/audio/voice/rande.mp3"));
				break;
			case 13:
				cost = 10;
				population = 0;
				migration = -3;
				affliction = 5;
				kurwtura = 1;
				sound = Gdx.audio.newSound(Gdx.files.internal("data_his/audio/voice/religia.mp3"));
				break;
			case 14:
				cost = 13;
				population = 9;
				migration = 9;
				affliction = 0;
				kurwtura = 0;
				sound = Gdx.audio.newSound(Gdx.files.internal("data_his/audio/voice/romans.mp3"));
			case 15:
				cost = 6;
				population = 0;
				migration = 0;
				affliction = 1;
				kurwtura = 9;
				sound = Gdx.audio.newSound(Gdx.files.internal("data_his/audio/voice/teatr.mp3"));
				break;
			case 16:
				cost = 15;
				population = 0;
				migration = 5;
				affliction = 7;
				kurwtura = 0;
				sound = Gdx.audio.newSound(Gdx.files.internal("data_his/audio/voice/ulan.mp3"));
				break;
			case 17:
				cost = 7;
				population = 0;
				migration = 0;
				affliction = 7;
				kurwtura = 1;
				sound = Gdx.audio.newSound(Gdx.files.internal("data_his/audio/voice/widowisko.mp3"));
				break;
		}
	}
	
	public void use() {
		if (gameworld.fieldManager.currentField != null) {
			gameworld.fieldManager.currentField.statistic.population += (gameworld.fieldManager.currentField.statistic.population*population/10)*
					gameworld.fieldManager.currentField.statistic.affiliation/100.0f;
			gameworld.fieldManager.currentField.statistic.base_mig_mult += (gameworld.fieldManager.currentField.statistic.base_mig_mult*migration/10)*
					gameworld.fieldManager.currentField.statistic.affiliation/100.0f;
			gameworld.fieldManager.currentField.statistic.affiliation += (gameworld.fieldManager.currentField.statistic.affiliation*affliction/10 + affliction*10)*
					gameworld.fieldManager.currentField.statistic.affiliation/100.0f;
			gameworld.fieldManager.currentField.statistic.base_cult_mult += (gameworld.fieldManager.currentField.statistic.base_cult_mult*kurwtura/10)*
					gameworld.fieldManager.currentField.statistic.affiliation/100.0f;
			//sound.play(1.0f);
			
		}
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
