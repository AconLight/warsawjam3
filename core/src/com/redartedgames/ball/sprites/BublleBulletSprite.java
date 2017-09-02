package com.redartedgames.ball.sprites;

import com.redartedgames.ball.myobjects.Bullet;
import com.redartedgames.ball.myobjects.Player;
import com.redartedgames.ball.objects.ColSpriteObject;
import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.Hitbox;
import com.redartedgames.ball.objects.Hitbox.BehaviorMode;
import com.redartedgames.ball.objects.ParticleObject;

public class BublleBulletSprite extends ColSpriteObject{

	public ParticleObject konfetti;
	private boolean isUsed;
	public BublleBulletSprite(float x, float y, GameObject parent, int id) {
		super(x, y, parent, id);
		addTexture("bug.png");
		setHitbox(new Hitbox(positionX, positionY, 10, BehaviorMode.dynamic));
		konfetti = new ParticleObject(getMovement().getPosition().x, getMovement().getPosition().y, 0, this);
		getGameObjects().add(konfetti);
		isUsed = false;
	}
	
	public void collide(GameObject obj) {
		super.collide(obj);
		if (c.isTrue && !isUsed) {
			getGameObjects().remove(konfetti);
			konfetti = new ParticleObject(getMovement().getPosition().x, getMovement().getPosition().y, 0, this);
			getGameObjects().add(konfetti);
			konfetti.explode(getMovement().getVelocity().x/100, getMovement().getVelocity().y/100);
			isUsed = true;
			isVisible = false;
			((Bullet) parent).explode();
		}
	}

}
