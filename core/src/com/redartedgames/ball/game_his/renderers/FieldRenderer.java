package com.redartedgames.ball.game_his.renderers;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.redartedgames.ball.game_his.GameWorld_his;
import com.redartedgames.ball.game_his.RenderManager;
import com.redartedgames.ball.myobjects_his.Field;

public class FieldRenderer extends RenderManager {
	
	private SpriteBatch batch;
	private ArrayList<Field> fields;

	public FieldRenderer(GameWorld_his gameworld) {
		super(gameworld);
		batch = new SpriteBatch();
		fields = gameworld.fieldManager.getFields();
	}

}
