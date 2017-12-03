package com.redartedgames.ball.managers_his;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.math.Vector2;
import com.redartedgames.ball.game_his.GameWorld_his;
import com.redartedgames.ball.myobjects_his.Card;

public class CardsManager {
	
	private int moveCounter = 0, speed = 0;
	private int allCards = 16;
	public int money = 3000;
	private int iter = 0;
	private ArrayList<Card> cards;
	private int cardsQuantity = 9;
	private ArrayList<Vector2> positions;
	private boolean isMoving = false;
	private boolean isVisible = true;
	private boolean isUp = true;
	private boolean isCasted = false;
	private Random rand;
	
	public CardsManager() {
		rand = new Random();
		cards = new ArrayList<Card>();
		positions = new ArrayList<Vector2>();
		for(int i = 0; i<cardsQuantity; i++)
			cards.add(new Card(0, 0, rand.nextInt(allCards)+1, null, 0.75f));
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
				v.y = positionFunction((((counter)/cardsQuantity)*(float)Math.PI-1/2*(float)Math.PI))*50+200;
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
	
	public void moveRight() {
		if(isVisible && !isMoving) {	
			cards.get(cardsQuantity/2).setScale(0.75f);
			cards.get(cardsQuantity/2-1).setScale(0.75f);
			Card pom = cards.get(0);
			cards.remove(0);
			cards.add(pom);		
			generateCardsPosition();
		}
	}
	
	public void moveLeft() {
		if(isVisible && !isMoving) {
			cards.get(cardsQuantity/2).setScale(0.75f);
			cards.get(cardsQuantity/2-1).setScale(1);
			Card pom = cards.get(cards.size()-1);
			cards.remove(cards.size()-1);
			cards.add(0, pom);		
			generateCardsPosition();
		}
	}
	
	public void moveBack() {
		if(isUp && !isMoving) {
		isMoving = true;
		for(Card c : cards) {
			moveCounter = 20;
			speed = moveCounter;
			c.desiredY = -400;
			c.desiredX = 0;
		}
		isVisible = false;
		isUp = false;
		}
	}
	
	public void moveForward() {
		if(!isUp && !isMoving) {
		isMoving = true;
		moveCounter = 10;
		speed = moveCounter;
		for(Card c : cards) {			
			c.desiredY = 388;
			c.desiredX = 0;
		}
		isVisible = true;
		isUp = true;
		}
	}
	
	public void cast() {
		if(isUp && !isMoving && money>=cards.get(cardsQuantity/2).cost) {
			cards.get(cardsQuantity/2).use();
			money -= cards.get(cardsQuantity/2).cost;
			isMoving = true;
			isCasted = true;
			moveCounter = 40;
			speed = moveCounter;
			for(Card c : cards) {			
				c.desiredY = 1200;
				c.desiredX = 0;
				c.desiredScale = 1.5f;
			}			
		}
	}
	
	public ArrayList<Card> getCards(){
		return cards;
	}
	
	public void update(float delta) {
		if(isMoving) {
			iter = 0;
			for(Card c : cards) {
				if(!isCasted)c.setPosition(c.getX()+c.desiredX*(1/speed), c.getY()+(int)(c.desiredY*(1.f/speed)));
				if(isCasted && iter==cardsQuantity/2) {
					c.setPosition(c.getX()+c.desiredX*(1/speed), c.getY()+(int)(c.desiredY*(1.f/speed)));
					c.setScale(c.getScale()+(c.desiredScale-1.f)/speed);
				}
				if(moveCounter==1) {
					if(isCasted) {
						if(iter==(cardsQuantity/2)) {
							setRotation();
							c.setPosition((int)positions.get(iter).x, (int)positions.get(iter).y);
							cards.set(cardsQuantity/2, new Card((int)positions.get(iter).x, (int)positions.get(iter).y, rand.nextInt(allCards)+1, null, 1.f));
							c.setScale(1f);
						}
						if(iter==(cardsQuantity-1)) isCasted = false;
						isMoving = false;
					}
					if(iter==cardsQuantity-1) moveCounter = 1;
				}
				if(moveCounter==0)isMoving = false;
				iter++;
			}
			moveCounter--;
		}
	}
}
