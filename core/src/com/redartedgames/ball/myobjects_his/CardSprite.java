package com.redartedgames.ball.myobjects_his;

import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.SpriteObject;

public class CardSprite extends SpriteObject{
	
	private float width;
	private float height;

	public CardSprite(float x, float y, GameObject parent, int id) {
		super(x, y, parent, id);
		width = 100;
		height = 200;
	}
	
	public void setCard(int cardId) {
		switch(cardId){
			default:
			case 1:
				addTexture("data/ground/ziemia_bok_przod.png");
				break;
			case 2:
				addTexture("data/ground/ziemia_bok_przod.png");
				break;
			
		}
	}
}
