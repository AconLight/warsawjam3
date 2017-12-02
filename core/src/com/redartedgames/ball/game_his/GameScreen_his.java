package com.redartedgames.ball.game_his;

import com.redartedgames.ball.screen.MyScreen;
import com.redartedgames.ball.screen.ScreenRenderer;

public class GameScreen_his extends MyScreen{
	
	private GameRenderer_his gamerenderer;

	public GameScreen_his(int width, int height) {
		super(width, height);
		world = new GameWorld_his(camera);
		screenRenderer = new ScreenRenderer(world, camera);
		gamerenderer = new GameRenderer_his((GameWorld_his) world);
	}
	
	@Override
	public void update(float delta) {
		super.update(delta);
		gamerenderer.render();
	}

}
