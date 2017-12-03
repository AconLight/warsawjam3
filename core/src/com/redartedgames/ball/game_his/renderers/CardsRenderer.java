package com.redartedgames.ball.game_his.renderers;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.redartedgames.ball.game_his.GameWorld_his;
import com.redartedgames.ball.game_his.RenderManager;
import com.redartedgames.ball.myobjects_his.Card;
import com.redartedgames.ball.objects.SpriteObject;

public class CardsRenderer extends RenderManager {

	private ArrayList<Card> cards;
	private SpriteBatch batch;
	
	public CardsRenderer(GameWorld_his gameworld) {
		super(gameworld);
		batch = new SpriteBatch();
		cards = gameworld.cardsManager.getCards();
	}
	
	public void update(float delta) {
		super.update(delta);
		gameworld.cardsManager.update(delta);
	}
	
	public void render() {
		batch.begin();
		for(Card c : cards) {
			c.render(batch, 1, 0, 0);
			if(c.cost>gameworld.cardsManager.money) {
				batch.setColor(1, 0, 0, 0.6f);
				c.render(batch, 1, 0, 0);
				batch.setColor(1, 1, 1, 1);
			}
		}	
		batch.end();
	}
}
