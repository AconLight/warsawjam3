package com.redartedgames.ball.game_his.renderers;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.redartedgames.ball.game_his.GameWorld_his;
import com.redartedgames.ball.game_his.RenderManager;
import com.redartedgames.ball.managers_his.FieldManager;
import com.redartedgames.ball.myobjects_his.Card;
import com.redartedgames.ball.myobjects_his.Field;

public class FieldRenderer extends RenderManager {
	private float i = 0;
	private SpriteBatch batch;
	private GameWorld_his world;
	Texture bg;
	TextureRegion bgr;
	public FieldRenderer(GameWorld_his gameworld) {
		super(gameworld);
		bg = new Texture(Gdx.files.internal("data_his/backgroud_map.png"));
		bgr = new TextureRegion(bg); 
		this.world = gameworld;
		batch = new SpriteBatch();
	}

	public void render() {
		//System.out.println("cam2: " + world.fieldManager.cam);
		batch.begin();
		batch.draw(bgr, -world.fieldManager.cam.x - 1450, -world.fieldManager.cam.y-1450);
		for(Field f : world.fieldManager.getFields()) {

			f.render(batch, 1, world.fieldManager.cam.x, world.fieldManager.cam.y);

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
