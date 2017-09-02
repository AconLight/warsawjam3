package com.redartedgames.ball;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.redartedgames.ball.game.GameScreen;
import com.redartedgames.ball.game.GameWorld;
import com.redartedgames.ball.game.InputHandler;
import com.redartedgames.ball.screen.Consts;


public class Wgj3Game extends Game{
	
	private GameScreen gameScreen;
	
	@Override
	public void create () {
		gameScreen = new GameScreen(Consts.screenWidth, Consts.screenHeight);
		Gdx.input.setInputProcessor(new InputHandler((GameWorld)gameScreen.getWorld()));
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
