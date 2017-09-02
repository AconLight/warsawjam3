package com.redartedgames.ball.myobjects;

import com.redartedgames.ball.objects.ColSpriteObject;
import com.redartedgames.ball.objects.GameObject;

public class PlatformSprite extends ColSpriteObject{

	public PlatformSprite (float x, float y, int id, GameObject parent){
		super(x,y,parent,id);
		//addTexture("bug.png");
	}
}
