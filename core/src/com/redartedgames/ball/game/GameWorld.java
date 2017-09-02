package com.redartedgames.ball.game;

import com.redartedgames.ball.myobjects.Player;
import com.redartedgames.ball.screen.MyWorld;

public class GameWorld extends MyWorld{
	
	Player player;
	
	public GameWorld() {
		super();
		player = new Player(200, 200, 0, null);
		addGameObject(player);
				
		
	}
	
	@Override
	public void update(float delta) {
		super.update(delta);		
	}
	
}
