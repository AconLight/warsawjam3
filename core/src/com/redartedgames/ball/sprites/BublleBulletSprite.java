package com.redartedgames.ball.sprites;

import com.redartedgames.ball.objects.ColSpriteObject;
import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.Hitbox;
import com.redartedgames.ball.objects.Hitbox.BehaviorMode;

public class BublleBulletSprite extends ColSpriteObject{

	public BublleBulletSprite(float x, float y, GameObject parent, int id) {
		super(x, y, parent, id);
		addTexture("bug.png");
		setHitbox(new Hitbox(positionX, positionY, 10, BehaviorMode.dynamic));
	}

}
