package com.redartedgames.ball.game;

import java.util.ArrayList;

import com.redartedgames.ball.myobjects.Platform;
import com.redartedgames.ball.myobjects.Player;
import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.screen.MyWorld;

public class GameWorld extends MyWorld{
	
	Player player;
	Platform platform, p2;
	ArrayList<GameObject> platforms;
	
	public GameWorld() {
		super();
		platform = new Platform(400, 100, 600, 100, null, 0);
		addGameObject(platform);
		p2 = new Platform(600, 300, 100, 300, null, 0);
		addGameObject(p2);
		platforms = new ArrayList<GameObject>();
		platforms.add(platform.platformSprite);
		platforms.add(p2.platformSprite);
		player = new Player(200, 200, 0, null, platforms);
		addGameObject(player);
		
		player.playerSprite.collidableObjects.add(platform.platformSprite);
	}
	
	@Override
	public void update(float delta) {
		super.update(delta);		
	}
	
}
