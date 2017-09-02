package com.redartedgames.ball.myobjects;

import com.redartedgames.ball.objects.ColSpriteObject;
import com.redartedgames.ball.objects.GameObject;

public class EnemyCebulaSprite extends ColSpriteObject{

	public EnemyCebulaSprite (float x, float y, GameObject parent, int id) {
		super(x,y,parent,id);
		setFrameTime(0.2f);
		regionList.clear();
		addTexture("data/enemy/cebula/cebula1.png");
		addTexture("data/enemy/cebula/cebula2.png");
		addTexture("data/enemy/cebula/cebula3.png");
		addTexture("data/enemy/cebula/cebula4.png");
	}
}
