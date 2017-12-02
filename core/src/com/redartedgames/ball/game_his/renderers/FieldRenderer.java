package com.redartedgames.ball.game_his.renderers;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.redartedgames.ball.game_his.GameWorld_his;
import com.redartedgames.ball.game_his.RenderManager;
import com.redartedgames.ball.managers_his.FieldManager;
import com.redartedgames.ball.myobjects_his.Card;
import com.redartedgames.ball.myobjects_his.Field;

public class FieldRenderer extends RenderManager {
	private float i = 0;
	private SpriteBatch batch;
	private GameWorld_his world;
	public FieldRenderer(GameWorld_his gameworld) {
		super(gameworld);
		this.world = gameworld;
		batch = new SpriteBatch();
	}

	public void render() {
		//System.out.println("cam2: " + world.fieldManager.cam);
		batch.begin();
		for(Field f : world.fieldManager.getFields()) {
			f.getGameObjects().get(0).getPosition().set(
					f.getGameObjects().get(0).getPosition().x - world.fieldManager.cam.x, 
					f.getGameObjects().get(0).getPosition().y - world.fieldManager.cam.y);
			f.render(batch, 1, 0, 0);
			f.getGameObjects().get(0).getPosition().set(
					f.getGameObjects().get(0).getPosition().x + world.fieldManager.cam.x, 
					f.getGameObjects().get(0).getPosition().y + world.fieldManager.cam.y);
		}
		batch.end();
	}
	
	public void update(float delta) {
		world.fieldManager.update(delta);
		for(Field f : world.fieldManager.getFields()) {
			f.updateBefore(delta,0,0);
			f.updateAfter(delta,0,0);
		}
	}
}
