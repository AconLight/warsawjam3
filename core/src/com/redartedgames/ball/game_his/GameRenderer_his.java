package com.redartedgames.ball.game_his;

import com.redartedgames.ball.game_his.renderers.*;
import java.util.*;

public class GameRenderer_his {
	private ArrayList<RenderManager> everything;
	public GameRenderer_his(GameWorld_his gameworld) {
		everything = new ArrayList<RenderManager>();
		everything.add(new GUIRenderer(gameworld)); //Dodajemy w kolejności wyświetlania na początku najdalsze
	}
	public void render() {
		for(RenderManager b : everything) {
			b.render();
		}
	}
}
