package com.redartedgames.ball.myobjects;

import java.util.ArrayList;

import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.ParticleObject;
import com.redartedgames.ball.objects.SpriteObject;
import com.redartedgames.ball.objects.TimeObject;
import com.redartedgames.ball.sprites.BublleBulletSprite;

public class Player extends TimeObject{

	public ArrayList<GameObject> bulletObstacles;
	public PlayerSprite playerSprite;
	public ArrayList<Bullet> bullets;
	ArrayList<Bubble> bubbles;
	public TimeBar tb;
	public SpriteObject cel;
	public Player(float x, float y, int id, GameObject parent, ArrayList<GameObject> bulletObstacles, ArrayList<Bubble> bubbles, TimeBar tb, SpriteObject cel) {
		super(x, y, id, parent);
		this.cel = cel;
		this.tb = tb;
		this.bubbles = bubbles;
		playerSprite = new PlayerSprite(x, y, parent, id);
		addSprite(playerSprite);
		this.bulletObstacles = bulletObstacles;
		bullets = new ArrayList<Bullet>();
		setAnimation(-1);
		setTimeIsNormal(true);
	}
	
	public void addXAxis(float x) {
		playerSprite.addXAxis(x);
	}
	
	public void tryJump() {
		if (playerSprite.tryJump()) {
			jump();
		}
	}
	
	public void updateLast(float delta, float vx, float vy) {
		super.updateLast(delta, vx, vy);
		updateBulletCollidable();
		for(Bullet bullet : bullets) {
			if (((BublleBulletSprite)bullet.sprite).konfetti.isDone) {
				getGameObjects().remove(bullet);
			}
			if (bullet.isExploded && !bullet.isUsed) {
				bubbles.add(new Bubble(bullet.sprite.getMovement().getPosition().x, bullet.sprite.getMovement().getPosition().y, 0, this));
				bullet.isUsed = true;
			}
		}
		HelpGod.playerX = playerSprite.getMovement().getPosition().x;
	}
	
	public void updateBulletCollidable() {
		for(Bullet bullet : bullets) {
			bullet.sprite.collidableObjects = new ArrayList<GameObject>();
			bullet.sprite.collidableObjects.addAll(bulletObstacles);
		}
	}
	
	public void jump() {
		
	}
	
	public void tryShoot() {
		shoot();
	}
	
	public void shoot() {
		float dx, dy, dr;
		dx = playerSprite.getMovement().getPosition().x - cel.getPosition().x;
		dy = playerSprite.getMovement().getPosition().y - cel.getPosition().y;
		
		dr = (float) Math.sqrt(dx*dx + dy*dy);
		bullets.add(new Bullet(playerSprite.getMovement().getPosition().x, playerSprite.getMovement().getPosition().y , 0, this, this));
		float x = 0;
		if (playerSprite.getMovement().getVelocity().x >= -1) x = 300;
		else x = -300;
			
		bullets.get(bullets.size()-1).shoot(playerSprite.getMovement().getPosition().x, playerSprite.getMovement().getPosition().y+70,
				-900*dx/dr, -900*dy/dr);
		getGameObjects().removeAll(bullets);
		getGameObjects().addAll(bullets);
		//updateBulletCollidable();
	}
	
	public void setAnimation(int type) {
		playerSprite.setAnimation(type);
	}

}
