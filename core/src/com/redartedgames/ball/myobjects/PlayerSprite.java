package com.redartedgames.ball.myobjects;

import com.redartedgames.ball.objects.ColSpriteObject;
import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.settings.GameVars;

public class PlayerSprite extends ColSpriteObject{
	
	public boolean canJump;
	private float canJumpTimer;
	
	public PlayerSprite(float x, float y, GameObject parent, int id) {
		super(x, y, parent, id);
		canJump = false;
		canJumpTimer = 0;
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
		
	}
}
