package com.redartedgames.ball.game_his;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.redartedgames.ball.managers_his.CardsManager;
import com.redartedgames.ball.screen.MyWorld;

public class GameWorld_his extends MyWorld{
	
	public CardsManager cards;
	
	public GameWorld_his(OrthographicCamera cam) {
		super(cam);
		cards = new CardsManager();
	}
	
	public void update(float delta) {
		
	}
}
