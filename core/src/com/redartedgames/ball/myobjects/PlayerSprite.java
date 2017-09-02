package com.redartedgames.ball.myobjects;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
	private int animType;
	public boolean isVoulnerable;
	
	public PlayerSprite(float x, float y, GameObject parent, int id) {
		super(x, y, parent, id);
		canJump = false;
		canJumpTimer = 0;
		xAxis = 0;
		setHitbox(new Hitbox(positionX, positionY, 70, BehaviorMode.dynamic));
		getMovement().setG(new Vector2(0, GameVars.g));
		addTexture("badlogic.jpg");
		konfetti = new ParticleObject(getMovement().getPosition().x, getMovement().getPosition().y, 0, this);
		getGameObjects().add(konfetti);
		setFrameTime(0.05f);
		isVoulnerable = false;
		
	}
	
	public void setAnimation (int type) {
		animType = type;
		switch (type) {
		case -2:
			frameNum = 0;
			setFrameTime(0.15f);
			regionList.clear();
			addTexture("data/player/idle/idle1l.png");
			addTexture("data/player/idle/idle2l.png");
			addTexture("data/player/idle/idle3l.png");
			addTexture("data/player/idle/idle4l.png");
			//w prawo
			break;
			
		case -1:
			frameNum = 0;
			setFrameTime(0.15f);
			regionList.clear();
			addTexture("data/player/idle/idle1p.png");
			addTexture("data/player/idle/idle2p.png");
			addTexture("data/player/idle/idle3p.png");
			addTexture("data/player/idle/idle4p.png");
			//w prawo
			break;
		case 0:
			frameNum = 0;
			setFrameTime(0.05f);
			regionList.clear();
			addTexture("data/player/bieg/bieg3p.png");
			addTexture("data/player/bieg/bieg4p.png");
			addTexture("data/player/bieg/bieg5p.png");
			addTexture("data/player/bieg/bieg6p.png");
			addTexture("data/player/bieg/bieg7p.png");
			addTexture("data/player/bieg/bieg8p.png");
			addTexture("data/player/bieg/bieg1p.png");
			addTexture("data/player/bieg/bieg2p.png");
			//w prawo
			break;
		case 1:
			regionList.clear();
			setFrameTime(0.05f);
			frameNum = 0;
			addTexture("data/player/bieg/bieg3l.png");
			addTexture("data/player/bieg/bieg4l.png");
			addTexture("data/player/bieg/bieg5l.png");
			addTexture("data/player/bieg/bieg6l.png");
			addTexture("data/player/bieg/bieg7l.png");
			addTexture("data/player/bieg/bieg8l.png");
			addTexture("data/player/bieg/bieg1l.png");
			addTexture("data/player/bieg/bieg2l.png");
			//w lewo
			break;
		case 2:
			regionList.clear();
			addTexture("data/player/skok/skok1p.png");
			addTexture("data/player/skok/skok2p.png");
			addTexture("data/player/skok/skok3p.png");
			addTexture("data/player/skok/skok4p.png");
			addTexture("data/player/skok/skok5p.png");
			addTexture("data/player/skok/skok6p.png");
			addTexture("data/player/skok/skok7p.png");
			addTexture("data/player/skok/skok8p.png");
			//skok do góry prawy
			break;
		case 3:
			regionList.clear();
			addTexture("data/player/skok/skok1l.png");
			addTexture("data/player/skok/skok2l.png");
			addTexture("data/player/skok/skok3l.png");
			addTexture("data/player/skok/skok4l.png");
			addTexture("data/player/skok/skok5l.png");
			addTexture("data/player/skok/skok6l.png");
			addTexture("data/player/skok/skok7l.png");
			addTexture("data/player/skok/skok8l.png");
			//skok do góry lewy
			break;
		case 4:
			regionList.clear();
			frameNum = 0;
			addTexture("data/player/opadanie/opadanie1p.png");
			addTexture("data/player/opadanie/opadanie2p.png");
			addTexture("data/player/opadanie/opadanie3p.png");
			addTexture("data/player/opadanie/opadanie4p.png");
			addTexture("data/player/opadanie/opadanie5p.png");
			//opadanie prawe
			break;
		case 5:
			regionList.clear();
			frameNum = 0;
			addTexture("data/player/opadanie/opadanie1l.png");
			addTexture("data/player/opadanie/opadanie2l.png");
			addTexture("data/player/opadanie/opadanie3l.png");
			addTexture("data/player/opadanie/opadanie4l.png");
			addTexture("data/player/opadanie/opadanie5l.png");
			//opadanie lewe
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
		getMovement().setVelocity(new Vector2(getMovement().getVelocity().x*(1f-delta*5), getMovement().getVelocity().y*(1f-delta*5)));
		canJumpTimer -= delta;
		
		if (getMovement().getVelocity().y < 60 && getMovement().getVelocity().y > -60) {
			if (getMovement().getVelocity().x > 10) {
				if (animType != 0 ) setAnimation(0);
				setFrameTime(Math.abs(0.05f*200/getMovement().getVelocity().x));
			}
			else if (getMovement().getVelocity().x < -10) {
				if (animType != 1 ) setAnimation(1);
				setFrameTime(Math.abs(0.05f*200/getMovement().getVelocity().x));
			}
			else if (getMovement().getVelocity().x < -1) {
				if (animType != -2 ) setAnimation(-2);
			}
			else if (getMovement().getVelocity().x > -1) {
				if (animType != -1 ) setAnimation(-1);
			}
		}
		else if (getMovement().getVelocity().y >= 60){
			if (getMovement().getVelocity().x >= 0) {
				if (animType != 2 ) setAnimation(2);
			}
			else if (getMovement().getVelocity().x < 0) {
				if (animType != 3 ) setAnimation(3);
			}
		}
		
		else if (getMovement().getVelocity().y <= -60){
			if (getMovement().getVelocity().x >= 0) {
				if (animType != 4 ) setAnimation(4);
			}
			else if (getMovement().getVelocity().x < 0) {
				if (animType != 5 ) setAnimation(5);
			}
		}
		
		if (animType == 2 || animType == 3) {
			if (frameNum == 7) setStoped(true);
		}
		
		else if (animType == 4 || animType == 5) {
			if (frameNum == 4) setStoped(true);
		}
		else {
			setStoped(false);
		}
		
	}
	
	public void collide(GameObject obj) {
		super.collide(obj);
		//Gdx.app.log("ColSpriteObject", "collide - col: " + collisionAccY );
		
		if (c.disY.floatValue() > 0) {
			if(getMovement().getVelocity().y < -250) {
				getGameObjects().remove(konfetti);
				konfetti = new ParticleObject(getMovement().getPosition().x, getMovement().getPosition().y - 50, 0, this);
				getGameObjects().add(konfetti);
				konfetti.explode(getMovement().getVelocity().x/220, getMovement().getVelocity().y/880);
			}
			if (canJumpTimer <= 0)
			canJump = true;
			
			getMovement().setVelocity(new Vector2(getMovement().getVelocity().x, getMovement().getVelocity().y* 0.9f));
			
			
			
			
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
	public void render(SpriteBatch batch, int priority, float dx, float dy) {
		super.render(batch, priority, dx, dy);
		konfetti.render(batch, priority, dx, dy);
	}
}
