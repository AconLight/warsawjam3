package com.redartedgames.ball.managers_his;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;
import com.redartedgames.ball.myobjects_his.Card;

public class CardsManager {
	
	private ArrayList<Card> cards;
	private ArrayList<Vector2> positions;
	
	public CardsManager() {
		cards = new ArrayList<Card>();
		cards.add(new Card(300, 300, 1, null));
	}
	
	private void generateCardsPosition(int cardsQuantity) {
		
	}
	
	public ArrayList<Card> getCards(){
		return cards;
	}
}
