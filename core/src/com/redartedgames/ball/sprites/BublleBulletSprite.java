package com.redartedgames.ball.sprites;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.redartedgames.ball.myobjects.Bullet;
import com.redartedgames.ball.myobjects.Player;
import com.redartedgames.ball.objects.ColSpriteObject;
import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.Hitbox;
import com.redartedgames.ball.objects.Hitbox.BehaviorMode;
import com.redartedgames.ball.objects.ParticleObject;
import com.redartedgames.ball.settings.GameVars;

public class BublleBulletSprite extends ColSpriteObject{

	public ParticleObject konfetti;
	private boolean isUsed;
	public BublleBulletSprite(float x, float y, GameObject parent, int id) {
		super(x, y, parent, id);
		addTexture("data/bubbles/bubble_player.png");
		setHitbox(new Hitbox(positionX, positionY, 10, BehaviorMode.dynamic));
		konfetti = new ParticleObject(getMovement().getPosition().x, getMovement().getPosition().y, 0, this);
		getGameObjects().add(konfetti);
		//getMovement().setG(new Vector2(0, GameVars.g/5));
		isUsed = false;
	}
	
	public void collide(GameObject obj) {
		super.collide(obj);
		if (c.isTrue && !isUsed) {
			getGameObjects().remove(konfetti);
			konfetti = new ParticleObject(getMovement().getPosition().x, getMovement().getPosition().y, 0, this);
			getGameObjects().add(konfetti);
			konfetti.explode(getMovement().getVelocity().x/150, getMovement().getVelocity().y/150);
			isUsed = true;
			isVisible = false;
			((Bullet) parent).explode();
		}
	}
	
	public void render(SpriteBatch batch, int priority, float dx, float dy) {
		super.render(batch, priority, dx, dy);
		konfetti.render(batch, priority, dx, dy);
	}

}
