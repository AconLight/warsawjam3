package com.redartedgames.ball.myobjects;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.SpriteObject;

public class Score extends SpriteObject{
	
	private BitmapFont font;
	public float x;
	public float y;
	public int wynik = 0;
	public int wynikMax = 0;

	public Score(float x, float y, GameObject parent, int id) {
		super(x, y, parent, id);
		font = new BitmapFont();
		// TODO Auto-generated constructor stub
	}

public void render(SpriteBatch batch, int priority, float dx, float yy) {	
	font.setColor(1.0f, 1.0f, 1.0f, 1.0f);
	font.getData().setScale(2,2);
	font.draw(batch, "SCORE: "+wynik, x, y, 400, 10, true);
	}
}
