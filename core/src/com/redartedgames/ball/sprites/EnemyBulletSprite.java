package com.redartedgames.ball.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.redartedgames.ball.myobjects.Player;
import com.redartedgames.ball.objects.ColSpriteObject;
import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.Hitbox;
import com.redartedgames.ball.objects.Hitbox.BehaviorMode;
import com.redartedgames.ball.objects.ParticleObject;

public class EnemyBulletSprite extends ColSpriteObject{
	Player player;
	ParticleObject konfetti;
	public EnemyBulletSprite(float x, float y, GameObject parent, int id, Player player) {
		super(x, y, parent, id);
		addTexture("data/bubbles/bubble_enemy.png");
		collidableObjects.add(player.playerSprite);
		collidableObjects.addAll(player.playerSprite.collidableObjects);
		setHitbox(new Hitbox(positionX, positionY, 30, BehaviorMode.kinematic));
		this.player = player;
		konfetti = new ParticleObject(x, y, id, parent);
	}
	
	public void updateLast(float delta, float vx, float vy) {
		super.updateLast(delta, vx, vy);
		applyPhysicsToAcceleration();
		Gdx.app.log("EnemyBulletSprite", "collide - col: " );
	}
	
	@Override
	public void collide(GameObject obj) {
		c = hitbox.checkCol(obj.getHitbox());
		collisionAccX = collisionAccX.add(c.disX);
		collisionAccY = collisionAccY.add(c.disY);
		//Gdx.app.log("ColSpriteObject", "collide - col: " + collisionAccY );
		if (getHitbox().bMode == BehaviorMode.dynamic)
			movement.addCollisionAcc(new Vector2(c.disX.floatValue(), c.disY.floatValue()));
		
		if (c.isTrue && isVisible) {
			isVisible = false;
			getGameObjects().remove(konfetti);
			konfetti = new ParticleObject(getMovement().getPosition().x, getMovement().getPosition().y, 0, this);
			getGameObjects().add(konfetti);
			konfetti.explode(getMovement().getVelocity().x/150, getMovement().getVelocity().y/150);
			if (obj == player.playerSprite) {
				player.tb.timeLeft -= 100;
				player.playerSprite.getMovement().setVelocity(new Vector2(player.playerSprite.getMovement().getVelocity().x - 700, player.playerSprite.getMovement().getVelocity().y));
			}
		}
	}

}
