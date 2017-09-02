package com.redartedgames.ball.myobjects;

import com.badlogic.gdx.math.Vector2;
import com.redartedgames.ball.objects.ColSpriteObject;
import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.settings.GameVars;

public class PlayerSprite extends ColSpriteObject{
	
	public boolean canJump;
	private float canJumpTimer;
	private float xAxis;
	
	public PlayerSprite(float x, float y, GameObject parent, int id) {
		super(x, y, parent, id);
		canJump = false;
		canJumpTimer = 0;
		xAxis = 0;
		
		addTexture("badlogic.jpg");
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
		canJumpTimer -= delta;
	}
	
	public void collide(GameObject obj) {
		super.collide(obj);
		if (c.disY.floatValue() > 0) {
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
