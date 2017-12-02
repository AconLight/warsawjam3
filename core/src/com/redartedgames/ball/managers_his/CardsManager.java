package com.redartedgames.ball.managers_his;

import java.util.ArrayList;
import com.redartedgames.ball.myobjects_his.Card;

public class CardsManager {
	
	private ArrayList<Card> cards;
	
	public CardsManager() {
		cards = new ArrayList<Card>();
		cards.add(new Card(300, 300, 0, null));
	}
	
	public ArrayList<Card> getCards(){
		return cards;
	}
}
