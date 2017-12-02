package com.redartedgames.ball;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.redartedgames.ball.game_his.GameScreen_his;
import com.redartedgames.ball.game_his.GameWorld_his;
import com.redartedgames.ball.game_his.InputHandler_his;
import com.redartedgames.ball.myobjects_his.Field;
import com.redartedgames.ball.screen.Consts;

public class HisGame extends Game{
	
	private GameScreen_his gameScreen;
	
	@Override
	public void create () {
		gameScreen = new GameScreen_his(Consts.screenWidth, Consts.screenHeight);
		Gdx.input.setInputProcessor(new InputHandler_his((GameWorld_his)gameScreen.getWorld()));
		Gdx.gl.glClearColor(24f/256, 24f/256, 24f/256, 1);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gameScreen.update(Gdx.graphics.getDeltaTime());
		gameScreen.render();
	}
	
	@Override
	public void dispose () {

	}

}