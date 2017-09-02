package com.redartedgames.ball.game;

import java.util.ArrayList;

import com.redartedgames.ball.myobjects.Bubble;
import com.redartedgames.ball.myobjects.Platform;
import com.redartedgames.ball.myobjects.Player;
import com.redartedgames.ball.objects.GameObject;
import com.badlogic.gdx.Gdx;
import com.redartedgames.ball.myobjects.Platform;
import com.redartedgames.ball.objects.ParticleObject;

import com.redartedgames.ball.screen.MyWorld;
import com.redartedgames.ball.sprites.BubbleSprite;

public class GameWorld extends MyWorld{
	
	Player player;
	ArrayList<GameObject> platforms;
	ArrayList<Bubble> bubbles;
	
	public GameWorld() {
		super();
		bubbles = new ArrayList<Bubble>();
		platform = new Platform(200, 100, 6, null, 0);
		addGameObject(platform);
		p2 = new Platform(600, 300, 3, null, 0);
		addGameObject(p2);
		platforms = new ArrayList<GameObject>();
		platforms.addAll(platform.plist);
		platforms.addAll(p2.plist);
		player = new Player(200, 200, 0, null, platforms, bubbles);
		addGameObject(player);
		
		player.playerSprite.collidableObjects.addAll(platform.plist);
		player.playerSprite.collidableObjects.addAll(p2.plist);

	}
	
	
	@Override
	public void update(float delta) {
		super.update(delta);		
		gameObjects.removeAll(bubbles);
		gameObjects.addAll(bubbles);
		
	}	
}
