package com.redartedgames.ball.myobjects;

import com.badlogic.gdx.math.Vector2;
import com.redartedgames.ball.objects.ColSpriteObject;
import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.Hitbox;
import com.redartedgames.ball.objects.Hitbox.BehaviorMode;

public class ClockSprite extends ColSpriteObject{
	
	public ClockSprite(float x, float y, GameObject parent, int id, int type, Player player) {
		super(x, y, parent, id);
		collidableObjects.add(player.playerSprite);
		switch (type) {
		case 0:
			//duzy
			regionList.clear();
			addTexture("data/zegary/zegar_duzy.png");
			setHitbox(new Hitbox(positionX, positionY, 50, BehaviorMode.kinematic));
			break;
		case 1:
			//sredni
			regionList.clear();
			addTexture("data/zegary/zegar_sredni.png");
			setHitbox(new Hitbox(positionX, positionY, 40, BehaviorMode.kinematic));
			break;
		case 2:
			//maly
			regionList.clear();
			addTexture("data/zegary/zegar_maly.png");
			setHitbox(new Hitbox(positionX, positionY, 30, BehaviorMode.kinematic));
			break;
			
		default:
			break;
		}
	}
	
	@Override
	public void collide(GameObject obj) {
		super.collide(obj);
		c = hitbox.checkCol(obj.getHitbox());
		collisionAccX = collisionAccX.add(c.disX);
		collisionAccY = collisionAccY.add(c.disY);
		//Gdx.app.log("ColSpriteObject", "collide - col: " + collisionAccY );
		if (getHitbox().bMode == BehaviorMode.dynamic)
			movement.addCollisionAcc(new Vector2(c.disX.floatValue(), c.disY.floatValue()));
		if (c.isTrue) isVisible=false;
	}
	
}
