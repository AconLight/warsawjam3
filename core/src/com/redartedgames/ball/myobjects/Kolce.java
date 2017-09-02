package com.redartedgames.ball.myobjects;

import com.redartedgames.ball.objects.ColSpriteObject;
import com.redartedgames.ball.objects.GameObject;

public class Kolce extends ColSpriteObject{
	
	public KolceSprite kolce;
	
	public Kolce (float x, float y, GameObject parent, int id, int type, Player player){
		super(x,y, parent, id);
		kolce = new KolceSprite(x,y,parent,id,type,player);
		addSprite(kolce);
	}

}
