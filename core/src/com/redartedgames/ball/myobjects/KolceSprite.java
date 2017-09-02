package com.redartedgames.ball.myobjects;

import com.badlogic.gdx.math.Vector2;
import com.redartedgames.ball.objects.ColSpriteObject;
import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.Hitbox;
import com.redartedgames.ball.objects.Hitbox.BehaviorMode;

public class KolceSprite extends ColSpriteObject{
	
	public KolceSprite(float x, float y, GameObject parent, int id, int type, Player player) {
		super(x,y,parent,id);
		collidableObjects.add(player.playerSprite);
		switch (type) {
		case 0:
			regionList.clear();
			addTexture("data/kolce/kolce_duze.png");
			setHitbox(new Hitbox(positionX, positionY, 103, 180, BehaviorMode.kinematic));
			break;
		case 1:
			regionList.clear();
			addTexture("data/kolce/kolce_male.png");
			setHitbox(new Hitbox(positionX, positionY, 75, 116, BehaviorMode.kinematic));
			break;
			
		default:
			break;
		}

	}
	
	
}
