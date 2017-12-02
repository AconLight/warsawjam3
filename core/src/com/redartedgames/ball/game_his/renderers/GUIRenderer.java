package com.redartedgames.ball.game_his.renderers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.redartedgames.ball.game_his.GameWorld_his;
import com.redartedgames.ball.game_his.RenderManager;

public class GUIRenderer extends RenderManager {
	Texture borders;
	TextureRegion b;
	SpriteBatch batch;
	
	public GUIRenderer(GameWorld_his gameworld) {
		super(gameworld);
		batch = new SpriteBatch();
		borders = new Texture(Gdx.files.internal("data_his/gui/guiborders.png"));
		b = new TextureRegion(borders);
	}
	public void render() {
		batch.begin();
		batch.draw(b, 0, 0);
		batch.end();
	}
}
