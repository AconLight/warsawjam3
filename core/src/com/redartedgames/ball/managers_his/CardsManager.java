package com.redartedgames.ball.managers_his;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;
import com.redartedgames.ball.myobjects_his.Card;

public class CardsManager {
	
	private int moveCounter = 0;
	private int speed = 0;
	private boolean isMoving = false;
	private ArrayList<Card> cards;
	private int cardsQuantity = 9;
	private ArrayList<Vector2> positions;
	private boolean isVisible = true;
	private boolean isUp = true;
	private boolean isCasted = false;
	private boolean isCasted2 = false;
	
	public CardsManager() {
		cards = new ArrayList<Card>();
		positions = new ArrayList<Vector2>();
		for(int i = 0; i<cardsQuantity; i++)
			cards.add(new Card(0, 0, i, null, 0.75f));
		for(int i = 0; i<cardsQuantity; i++)
			positions.add(new Vector2());
		generateCardsPosition();
	}
	
	private float positionFunction(float f) {
		return (float)(Math.sin(f-1/2*(float)Math.PI));
	}
	
	private void setRotation() {
		float counter = 0.f;
		float x = 30.f+75;
		int iter = 0;		
		for(Vector2 v : positions) {			
			x+=Math.abs(positionFunction((((counter)/cardsQuantity)*(float)Math.PI)))*1930/cardsQuantity;
			v.x = x;
			if(iter==cardsQuantity/2) {
				v.y = positionFunction((((counter)/cardsQuantity)*(float)Math.PI-1/2*(float)Math.PI))*50+150;
				cards.get(cardsQuantity/2).setScale(1);
			}
			else 
				v.y = positionFunction((((counter)/cardsQuantity)*(float)Math.PI-1/2*(float)Math.PI))*50+50;
			counter++;
			iter++;
		}
	}
	
	private void generateCardsPosition() {	
		if(!isMoving && isVisible) {
			setRotation();
			for(int i = 0; i<cards.size(); i++)
				cards.get(i).setPosition((int)positions.get(i).x,(int)positions.get(i).y);
		}
	}
	
	public void moveLeft() {
		if(isVisible) {	
			cards.get(cardsQuantity/2).setScale(0.75f);
			cards.get(cardsQuantity/2-1).setScale(0.75f);
			Card pom = cards.get(0);
			cards.remove(0);
			cards.add(pom);		
			generateCardsPosition();
		}
	}
	
	public void moveRight() {
		if(isVisible) {
			cards.get(cardsQuantity/2).setScale(0.75f);
			cards.get(cardsQuantity/2-1).setScale(1);
			Card pom = cards.get(cards.size()-1);
			cards.remove(cards.size()-1);
			cards.add(0, pom);		
			generateCardsPosition();
		}
	}
	
	public void moveBack() {
		if(isUp) {
		isMoving = true;
		for(Card c : cards) {
			moveCounter = 50;
			speed = moveCounter;
			c.desiredY = -4000;
			c.desiredX = 0;
		}
		isVisible = false;
		isUp = false;
		}
	}
	
	public void moveForward() {
		if(!isUp) {
		isMoving = true;
		moveCounter = 50;
		speed = moveCounter;
		for(Card c : cards) {			
			c.desiredY = 4000;
			c.desiredX = 0;
		}
		isVisible = true;
		isUp = true;
		}
	}
	
	public void cast() {
		if(isUp) {
			isMoving = true;
			isCasted = true;
			moveCounter = 50;
			speed = moveCounter;
			for(Card c : cards) {			
				c.desiredY = 4000;
				c.desiredX = 0;
				c.desiredScale = 2;
			}			
		}
	}
	
	public ArrayList<Card> getCards(){
		return cards;
	}
	
	public void update(float delta) {
		if(isMoving) {
			int iter = 0;
			for(Card c : cards) {
				c.setPosition(c.getX()+c.desiredX*(1/speed), c.getY()+(int)(c.desiredY*(1.f/speed)));
				moveCounter--;
				if(isCasted) {
					c.setScale(c.getScale()+(c.desiredScale-1.f)/speed);
				}
				if(moveCounter==1) {
					if(isCasted) {
						isCasted = false;
						c.setPosition((int)positions.get(iter).x, (int)positions.get(iter).y);
					}
					moveCounter = 0;
					isMoving = false;
				}
				iter++;
			}
		}
	}
}
