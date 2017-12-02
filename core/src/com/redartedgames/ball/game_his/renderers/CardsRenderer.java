package com.redartedgames.ball.game_his.renderers;

import java.util.ArrayList;

import com.redartedgames.ball.game_his.GameWorld_his;
import com.redartedgames.ball.game_his.RenderManager;
import com.redartedgames.ball.managers_his.CardsManager;
import com.redartedgames.ball.myobjects_his.Card;

public class CardsRenderer extends RenderManager {

	private ArrayList<Card> cards;
	
	public CardsRenderer(GameWorld_his gameworld) {
		super(gameworld);
		cards =gameworld.cards.getCards();
	}
	
	public void render() {
		//for(Card c : cards)
			//c.card.render();
	}
}
