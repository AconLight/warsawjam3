package com.redartedgames.ball.myobjects;

import java.util.ArrayList;

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
	
	public void setAnimatoin (int type) {
		switch (type) {
		case 0:
			regionList.clear();
			addTexture("data/player/bieg/bieg1p");
			addTexture("data/player/bieg/bieg2p");
			addTexture("data/player/bieg/bieg3p");
			addTexture("data/player/bieg/bieg4p");
			addTexture("data/player/bieg/bieg5p");
			addTexture("data/player/bieg/bieg6p");
			addTexture("data/player/bieg/bieg7p");
			addTexture("data/player/bieg/bieg8p");
			//w prawo
			break;
		case 1:
			regionList.clear();
			addTexture("data/player/bieg/bieg1l");
			addTexture("data/player/bieg/bieg2l");
			addTexture("data/player/bieg/bieg3l");
			addTexture("data/player/bieg/bieg4l");
			addTexture("data/player/bieg/bieg5l");
			addTexture("data/player/bieg/bieg6l");
			addTexture("data/player/bieg/bieg7l");
			addTexture("data/player/bieg/bieg8l");
			//w lewo
			break;
		case 2:
			regionList.clear();
			//skok do góry prawy
			break;
		case 3:
			regionList.clear();
			//skok do góry lewy
			break;
		case 4:
			regionList.clear();
			addTexture("data/player/opadanie/opadanie1p");
			addTexture("data/player/opadanie/opadanie2p");
			addTexture("data/player/opadanie/opadanie3p");
			addTexture("data/player/opadanie/opadanie4p");
			addTexture("data/player/opadanie/opadanie5p");
			//opadanie prawe
			break;
		case 5:
			regionList.clear();
			addTexture("data/player/opadanie/opadanie1l");
			addTexture("data/player/opadanie/opadanie2l");
			addTexture("data/player/opadanie/opadanie3l");
			addTexture("data/player/opadanie/opadanie4l");
			addTexture("data/player/opadanie/opadanie5l");
			//opadanie lewe
			break;
		case 6:
			regionList.clear();
			addTexture("data/player/idle/idle1p");
			addTexture("data/player/idle/idle2p");
			addTexture("data/player/idle/idle3p");
			addTexture("data/player/idle/idle4p");
			//idle w prawo
			break;
		case 7:
			regionList.clear();
			addTexture("data/player/idle/idle12");
			addTexture("data/player/idle/idle2l");
			addTexture("data/player/idle/idle3l");
			addTexture("data/player/idle/idle4l");
			//idle w lewo
			break;
			
		default:
			break;
		}
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
			if(getMovement().getVelocity().y < -400) {
				getGameObjects().remove(konfetti);
				konfetti = new ParticleObject(getMovement().getPosition().x, getMovement().getPosition().y - 50, 0, this);
				getGameObjects().add(konfetti);
				konfetti.explode(getMovement().getVelocity().x/120, getMovement().getVelocity().y/120);
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
