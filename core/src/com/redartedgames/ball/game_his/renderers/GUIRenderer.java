package com.redartedgames.ball.game_his.renderers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.redartedgames.ball.game_his.GameWorld_his;
import com.redartedgames.ball.game_his.RenderManager;

public class GUIRenderer extends RenderManager {
	Texture borders, statsback, nameback;
	TextureRegion b1, b2, b3;
	SpriteBatch batch;
	
	public GUIRenderer(GameWorld_his gameworld) {
		super(gameworld);
		batch = new SpriteBatch();
		borders = new Texture(Gdx.files.internal("data_his/gui/guiborders.png"));
		statsback = new Texture(Gdx.files.internal("data_his/gui/statsback.png"));
		nameback = new Texture(Gdx.files.internal("data_his/gui/nameback.png"));
		b1 = new TextureRegion(borders);
		b2 = new TextureRegion(statsback);
		b3 = new TextureRegion(nameback);
		
	}
	
	public void update(float delta) {
		super.update(delta);
		if (gameworld.fieldManager.currentField != null) {
			 switch(1){
			 	default:
			 	case 1:
			 		break;
			 	case 2:
			 		break;
			 	
			 
			 }
		}
	}
	
	public void render() {
		batch.begin();
		batch.draw(b2, 1420,30);
		batch.draw(b3, 1420,430);
		batch.draw(b1, 0, 0);
		batch.end();
	}
}
