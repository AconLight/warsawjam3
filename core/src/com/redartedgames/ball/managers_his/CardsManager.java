package com.redartedgames.ball.managers_his;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;
import com.redartedgames.ball.myobjects_his.Card;

public class CardsManager {
	
	private ArrayList<Card> cards;
	private ArrayList<Vector2> positions;
	
	public CardsManager() {
		cards = new ArrayList<Card>();
		positions = new ArrayList<Vector2>();
		cards.add(new Card(300, 300, 1, null));
		cards.add(new Card(300, 300, 2, null));
		cards.add(new Card(300, 300, 3, null));
		cards.add(new Card(300, 300, 4, null));
		cards.add(new Card(300, 300, 5, null));
		cards.add(new Card(300, 300, 6, null));
		cards.add(new Card(300, 300, 7, null));
		cards.add(new Card(300, 300, 8, null));
		cards.add(new Card(300, 300, 1, null));
		cards.add(new Card(300, 300, 2, null));
		cards.add(new Card(300, 300, 3, null));
		cards.add(new Card(300, 300, 4, null));
		cards.add(new Card(300, 300, 5, null));
		cards.add(new Card(300, 300, 6, null));
		cards.add(new Card(300, 300, 7, null));
		cards.add(new Card(300, 300, 8, null));
		generateCardsPosition();
	}
	
	private float positionFunction(float f) {
		return (float)Math.abs(Math.sin(f-1/2*(float)Math.PI));
	}
	
	private void generateCardsPosition() {
		int cardsQuantity = cards.size();
		for(int i = 0; i<cardsQuantity; i++)
			positions.add(new Vector2());
		float counter = 0.f;
		float x = 30.f;
		float y = 100.f;
		for(Vector2 v : positions) {
			v.x = 30+1200.f*positionFunction((((counter)/cardsQuantity)/2*(float)Math.PI))+110;
			v.y = 200*positionFunction((((counter)/cardsQuantity)/2*(float)Math.PI));
			counter++;
		}
		for(int i = 0; i<cards.size(); i++) {
			cards.get(i).setPosition((int)positions.get(i).x,(int)positions.get(i).y);
			//System.out.println(positions.get(i).x);
			//System.out.println(positions.get(i).y);
		}
	}
	
	public ArrayList<Card> getCards(){
		return cards;
	}
}
