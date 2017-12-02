package com.redartedgames.ball.myobjects_his;

import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.SpriteObject;

public class CardSprite extends SpriteObject{

	public CardSprite(float x, float y, GameObject parent, int id, int cardId) {
		super(x, y, parent, id);
		setCard(cardId);  
	}
	
	public void setCard(int cardId) {
		switch(cardId){
			default:
			case 1:
				addTexture("data_his/cards/dupa.png");
				break;
			case 2:
				addTexture("data_his/cards/card2.png");
				break;
			case 3:
				addTexture("data_his/cards/card3.png");
				break;
			case 4:
				addTexture("data_his/cards/card1.png");
				break;
			case 5:
				addTexture("data_his/cards/card2.png");
				break;
			case 6:
				addTexture("data_his/cards/card3.png");
				break;
			case 7:
				addTexture("data_his/cards/card1.png");
				break;
			case 8:
				addTexture("data_his/cards/card2.png");
				break;
			case 9:
				addTexture("data_his/cards/card3.png");
				break;
		}
	}		
}
