package com.redartedgames.ball.game_his.renderers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.redartedgames.ball.game_his.GameWorld_his;
import com.redartedgames.ball.game_his.RenderManager;

public class GUIRenderer extends RenderManager {
	Texture borders, statsback, nameback, city, village, hill, mountain, meadown, icon;
	TextureRegion b1, b2, b3, b41, b42, b43, b44, b45, b46, b4;
	SpriteBatch batch;
	
	public GUIRenderer(GameWorld_his gameworld) {
		super(gameworld);
		batch = new SpriteBatch();
		borders = new Texture(Gdx.files.internal("data_his/gui/guiborders.png"));
		statsback = new Texture(Gdx.files.internal("data_his/gui/statsback.png"));
		nameback = new Texture(Gdx.files.internal("data_his/gui/nameback.png"));
		city = new Texture(Gdx.files.internal("data_his/gui/city.png"));
		village = new Texture(Gdx.files.internal("data_his/gui/nameback.png"));
		hill = new Texture(Gdx.files.internal("data_his/gui/nameback.png"));
		mountain = new Texture(Gdx.files.internal("data_his/gui/nameback.png"));
		meadown = new Texture(Gdx.files.internal("data_his/gui/nameback.png"));
		icon = new Texture(Gdx.files.internal("data_his/gui/iconback.png"));
		b1 = new TextureRegion(borders);
		b2 = new TextureRegion(statsback);
		b3 = new TextureRegion(nameback);
		b41 = new TextureRegion(city);
		b42 = new TextureRegion();
		b43 = new TextureRegion();
		b44 = new TextureRegion();
		b45 = new TextureRegion();
		b46 = new TextureRegion(icon);
	}
	
	public void update(float delta) {
		super.update(delta);
		if (gameworld.fieldManager.currentField != null) {
			 switch(gameworld.fieldManager.currentField.fieldType){
			 	default:
			 	case city:
			 		b4=b41;
			 		break;
			 	case village:
			 		b4=b42;
			 		break;
			 	case hill:
			 		b4=b43;
			 		break;
			 	case mountain:
			 		b4=b44;
			 		break;
			 	case meadow:
			 		b4=b45;
			 		break;			 
			 }
		}
		
		else {
			b4=b46;
		}
	}
	
	public void render() {
		batch.begin();
		batch.draw(b2, 1420,30);
		batch.draw(b3, 1420,430);
		batch.draw(b4, 1420, 580);
		batch.draw(b1, 0, 0);
		batch.end();
	}
}
