package com.redartedgames.ball.myobjects;

import com.badlogic.gdx.math.Vector2;
import com.redartedgames.ball.objects.ColSpriteObject;
import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.Hitbox;
import com.redartedgames.ball.objects.ParticleObject;
import com.redartedgames.ball.objects.Hitbox.BehaviorMode;
import com.redartedgames.ball.settings.GameVars;

public class PlayerSprite extends ColSpriteObject{
	
	public boolean canJump;
	private float canJumpTimer;
	private float xAxis;
	private ParticleObject konfetti;
	
	public PlayerSprite(float x, float y, GameObject parent, int id) {
		super(x, y, parent, id);
		canJump = false;
		canJumpTimer = 0;
		xAxis = 0;
		setHitbox(new Hitbox(positionX, positionY, 50, BehaviorMode.dynamic));
		getMovement().setG(new Vector2(0, GameVars.g));
		addTexture("badlogic.jpg");
		konfetti = new ParticleObject(getMovement().getPosition().x, getMovement().getPosition().y, 0, this);
		getGameObjects().add(konfetti);
	}
	
	public void addXAxis(float x) {
		xAxis += x;
	}
	
	public void applyPhysicsToAcceleration() {
		getMovement().addCollisionAcc(new Vector2(xAxis, 0));
		super.applyPhysicsToAcceleration();
		
	}
	
	public void updateLast(float delta, float vx, float vy) {
		super.updateLast(delta, vx, vy);
		getMovement().setVelocity(new Vector2(getMovement().getVelocity().x*GameVars.playerDrag, getMovement().getVelocity().y*GameVars.playerDrag));
		canJumpTimer -= delta;
	}
	
	public void collide(GameObject obj) {
		super.collide(obj);
		if (c.disY.floatValue() > 0) {
			if(getMovement().getVelocity().y < -200) {
				getGameObjects().remove(konfetti);
				konfetti = new ParticleObject(getMovement().getPosition().x, getMovement().getPosition().y - 50, 0, this);
				getGameObjects().add(konfetti);
				konfetti.explode(getMovement().getVelocity().x/80, getMovement().getVelocity().y/80);
			}
			canJump = true;
		}
	}
	
	public boolean tryJump() {
		if (canJump && canJumpTimer <= 0) {
			canJump = false;
			canJumpTimer = GameVars.jumpBlockTime;
			jump();
			return true;
		}
		return false;
	}

	private void jump() {
		getMovement().setVelocity(new Vector2(getMovement().getVelocity().x, getMovement().getVelocity().y + GameVars.jumpVel));
	}
}
