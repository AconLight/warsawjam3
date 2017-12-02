package com.redartedgames.ball.myobjects_his;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.SpriteObject;

public class Text extends SpriteObject{
	
	private BitmapFont font;
	private String txt;
	private float x_position;
	private float y_position;
	
	//size 0 - small, 1 - medium, 2 - big
	public Text(float x, float y, GameObject parent, int id, int size, String txt) { 
		super(x, y, parent, id);
		this.txt = txt;
		this.x_position = x;
		this.y_position = y;
		switch(size) {
		case 0:
			font = new BitmapFont(Gdx.files.internal("data_his/fonts/font_small.fnt"),false);
			break;
		case 1:
			font = new BitmapFont(Gdx.files.internal("data_his/fonts/font_medium.fnt"),false);
			break;
		case 2:
			font = new BitmapFont(Gdx.files.internal("data_his/fonts/font_big.fnt"),false);
			break;
		default:
			break;
		}
	}

public void render(SpriteBatch batch, int priority, float dx, float yy) {	
	//font.setColor(Color.RED);
	font.draw(batch, txt, x_position, y_position);
	
	}
}

