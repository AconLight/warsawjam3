package com.redartedgames.ball.game_his;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.redartedgames.ball.game_his.renderers.*;
import java.util.*;

public class GameRenderer_his {
	private ArrayList<RenderManager> everything;
	public GameRenderer_his(GameWorld_his gameworld) {
		everything = new ArrayList<RenderManager>();
		everything.add(new GUIRenderer(gameworld));
	}
	public void render() {
		for(RenderManager b : everything) {
			b.render();
		}
	}
}
