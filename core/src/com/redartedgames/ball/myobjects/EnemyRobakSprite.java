package com.redartedgames.ball.myobjects;

import com.redartedgames.ball.objects.ColSpriteObject;
import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.Hitbox;
import com.redartedgames.ball.objects.Hitbox.BehaviorMode;

public class EnemyRobakSprite extends ColSpriteObject{
		
	public EnemyRobakSprite(float x, float y, GameObject parent, int id){
		super(x,y,parent,id);
		setHitbox(new Hitbox(positionX, positionY, 50, BehaviorMode.kinematic));
		setFrameTime(0.1f);
		setIsPingpong(true);
		addTexture("data/enemy/robak/robak1.png");
		addTexture("data/enemy/robak/robak2.png");
		addTexture("data/enemy/robak/robak3.png");
		addTexture("data/enemy/robak/robak4.png");
		addTexture("data/enemy/robak/robak5.png");
		
	}
	
	
	
}
