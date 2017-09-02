package com.redartedgames.ball.myobjects;

import com.redartedgames.ball.objects.ColSpriteObject;
import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.Hitbox;
import com.redartedgames.ball.objects.Hitbox.BehaviorMode;

public class EnemySprite extends ColSpriteObject{
	
	
	
	public EnemySprite(float x, float y, GameObject parent, int id){
		super(x,y,parent,id);
		setHitbox(new Hitbox(positionX, positionY, 50, BehaviorMode.kinematic));
		addTexture("bug2.png");
		
	}
	
	
	
}
