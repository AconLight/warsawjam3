package com.redartedgames.ball.game_his;

import com.redartedgames.ball.screen.MyScreen;
import com.redartedgames.ball.screen.ScreenRenderer;

public class GameScreen_his extends MyScreen{

	public GameScreen_his(int width, int height) {
		super(width, height);
		world = new GameWorld_his(camera);
		screenRenderer = new ScreenRenderer(world, camera);
	}

}
