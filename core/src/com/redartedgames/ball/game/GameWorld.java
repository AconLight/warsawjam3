package com.redartedgames.ball.game;

import com.redartedgames.ball.myobjects.BugAlive;
import com.redartedgames.ball.screen.MyWorld;

public class GameWorld extends MyWorld{
	
	
	public GameWorld() {
		super();
		BugAlive bug1 = new BugAlive(600,450,0); //x-> 0-1280; y-> 0-720
		addGameObject(bug1);
		
				
		
	}
	
	@Override
	public void update(float delta) {
		super.update(delta);		
	}
	
}
