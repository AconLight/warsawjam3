package com.redartedgames.ball.game_his.renderers;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.redartedgames.ball.game_his.GameWorld_his;
import com.redartedgames.ball.game_his.RenderManager;
import com.redartedgames.ball.managers_his.FieldManager;
import com.redartedgames.ball.myobjects_his.Card;
import com.redartedgames.ball.myobjects_his.Field;

public class FieldRenderer extends RenderManager {
	
	private SpriteBatch batch;
	private FieldManager fieldManager;

	public FieldRenderer(GameWorld_his gameworld) {
		super(gameworld);
		fieldManager = new FieldManager();
		batch = new SpriteBatch();
	}

	public void render() {
		batch.setProjectionMatrix(fieldManager.cam.combined);
		batch.begin();
		for(Field f : fieldManager.getFields())
			f.render(batch, 1, 0, 0);
		batch.end();
	}
	
	public void update(float delta) {
		for(Field f : fieldManager.getFields()) {
			f.updateBefore(delta,0,0);
			f.updateAfter(delta,0,0);
		}
	}
}
