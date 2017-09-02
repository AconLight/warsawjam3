package com.redartedgames.ball.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.redartedgames.ball.myobjects.Player;
import com.redartedgames.ball.objects.ColSpriteObject;
import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.Hitbox;
import com.redartedgames.ball.objects.Hitbox.BehaviorMode;

public class EnemyBulletSprite extends ColSpriteObject{
	Player player;
	public EnemyBulletSprite(float x, float y, GameObject parent, int id, Player player) {
		super(x, y, parent, id);
		addTexture("data/bubbles/bubble_enemy.png");
		collidableObjects.add(player.playerSprite);
		setHitbox(new Hitbox(positionX, positionY, 30, BehaviorMode.kinematic));
		this.player = player;
	}
	
	public void updateLast(float delta, float vx, float vy) {
		super.updateLast(delta, vx, vy);
		collide(player);
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
			player.tb.timeLeft -= 100;
			player.playerSprite.getMovement().setVelocity(new Vector2(player.playerSprite.getMovement().getVelocity().x - 700, player.playerSprite.getMovement().getVelocity().y));
		}
	}

}
