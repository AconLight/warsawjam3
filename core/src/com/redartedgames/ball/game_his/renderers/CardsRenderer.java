package com.redartedgames.ball.game_his.renderers;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.redartedgames.ball.game_his.GameWorld_his;
import com.redartedgames.ball.game_his.RenderManager;
import com.redartedgames.ball.managers_his.CardsManager;
import com.redartedgames.ball.myobjects_his.Card;

public class CardsRenderer extends RenderManager {

	private ArrayList<Card> cards;
	private SpriteBatch batch;
	
	public CardsRenderer(GameWorld_his gameworld) {
		super(gameworld);
		batch = new SpriteBatch();
		cards = gameworld.cardsManager.getCards();
	}
	
	public void render() {
		batch.begin();
		for(Card c : cards)
			c.render(batch, 1, 200, 200);
		batch.end();
	}
}
