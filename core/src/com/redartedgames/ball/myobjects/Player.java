package com.redartedgames.ball.myobjects;

import java.util.ArrayList;

import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.ParticleObject;
import com.redartedgames.ball.objects.TimeObject;
import com.redartedgames.ball.sprites.BublleBulletSprite;

public class Player extends TimeObject{

	private ArrayList<GameObject> bulletObstacles;
	public PlayerSprite playerSprite;
	public ArrayList<Bullet> bullets;
	ArrayList<Bubble> bubbles;
	
	
	public Player(float x, float y, int id, GameObject parent, ArrayList<GameObject> bulletObstacles, ArrayList<Bubble> bubbles) {
		super(x, y, id, parent);
		this.bubbles = bubbles;
		playerSprite = new PlayerSprite(x, y, parent, id);
		addSprite(playerSprite);
		this.bulletObstacles = bulletObstacles;
		bullets = new ArrayList<Bullet>();
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
			if (bullet.isExploded) {
				bubbles.add(new Bubble(bullet.getMovement().getPosition().x, bullet.getMovement().getPosition().y, 0, this));
			}
		}
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
		bullets.add(new Bullet(playerSprite.getMovement().getPosition().x, playerSprite.getMovement().getPosition().y , 0, this));
		bullets.get(bullets.size()-1).shoot(playerSprite.getMovement().getPosition().x, playerSprite.getMovement().getPosition().y, 300, 0);
		getGameObjects().removeAll(bullets);
		getGameObjects().addAll(bullets);
		//updateBulletCollidable();
	}
	


}
