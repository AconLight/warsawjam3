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
				addTexture("data_his/cards/apoteoza.png");
				break;
			case 2:
				addTexture("data_his/cards/dzieci.png");
				break;
			case 3:
				addTexture("data_his/cards/handel.png");
				break;
			case 4:
				addTexture("data_his/cards/higiena.png");
				break;
			case 5:
				addTexture("data_his/cards/knajpa.png");
				break;
			case 6:
				addTexture("data_his/cards/medycyna.png");
				break;
			case 7:
				addTexture("data_his/cards/opera.png");
				break;
			case 8:
				addTexture("data_his/cards/przemysl.png");
				break;
			case 9:
				addTexture("data_his/cards/przygoda.png");
				break;
			case 10:
				addTexture("data_his/cards/przygoda2.png");
				break;
			case 11:
				addTexture("data_his/cards/radosc.png");
				break;
			case 12:
				addTexture("data_his/cards/rande.png");
				break;
			case 13:
				addTexture("data_his/cards/religia.png");
				break;
			case 14:
				addTexture("data_his/cards/romans.png");
				break;
			case 15:
				addTexture("data_his/cards/teatr.png");
				break;
			case 16:
				addTexture("data_his/cards/ulan.png");
				break;
			case 17:
				addTexture("data_his/cards/widowisko.png");
				break;
		}
	}		
}
