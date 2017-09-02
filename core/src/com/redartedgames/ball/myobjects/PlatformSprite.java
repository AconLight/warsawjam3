package com.redartedgames.ball.myobjects;

import com.redartedgames.ball.objects.ColSpriteObject;
import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.Hitbox;
import com.redartedgames.ball.objects.Hitbox.BehaviorMode;

public class PlatformSprite extends ColSpriteObject{

	public PlatformSprite (float x, float y, float width, float height, int id, GameObject parent){
		super(x,y,parent,id);
		setHitbox(new Hitbox(positionX, positionY, width, height, BehaviorMode.kinematic));
		//addTexture("badlogic.jpg");
	}
}
