package com.redartedgames.ball.game_his.renderers;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.redartedgames.ball.game_his.GameWorld_his;
import com.redartedgames.ball.game_his.RenderManager;
import com.redartedgames.ball.myobjects_his.Text;

public class StatRenderer extends RenderManager {
	
	private ArrayList<Text> stats;
	private SpriteBatch batch;
		
	public StatRenderer(GameWorld_his gameworld) {
		super(gameworld);
		stats = new ArrayList<Text>();
		batch = new SpriteBatch();
	}

	public void render() {
		batch.begin();
		for(Text t : stats)
			t.render(batch, 1, 0, 0);
		batch.end();
	}

}
