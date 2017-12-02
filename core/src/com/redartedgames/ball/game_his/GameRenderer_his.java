package com.redartedgames.ball.game_his;

import com.redartedgames.ball.game_his.renderers.*;
import java.util.*;

public class GameRenderer_his {
	private ArrayList<RenderManager> everything;
	public GameRenderer_his(GameWorld_his gameworld) {
		everything = new ArrayList<RenderManager>();
		everything.add(new FieldRenderer(gameworld));
		everything.add(new StatRenderer(gameworld));
		everything.add(new CardsRenderer(gameworld));
		everything.add(new GUIRenderer(gameworld)); //Dodajemy w kolejnoœci wyœwietlania na pocz¹tku najdalsze
	}
	public void render() {
		for(RenderManager b : everything) {
			b.render();
		}
	}
	public void update(float delta) {
		for(RenderManager b : everything) {
			b.update(delta);
		}
	}
}
