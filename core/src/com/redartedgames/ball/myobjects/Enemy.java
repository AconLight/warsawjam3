package com.redartedgames.ball.myobjects;

import java.util.ArrayList;

import com.redartedgames.ball.objects.ColSpriteObject;
import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.TimeObject;

public class Enemy extends TimeObject{

	public ArrayList<Bullet> bullets;
	private int type;
	public ColSpriteObject enemySprite;
	private float timer=0;
	private float shootTime=80;
	
	public Enemy(float x, float y, int id, GameObject parent, int type) {
		super(x, y, id, parent);
		this.type = type;
		setEnemyType(type, x, y, id, parent);
		//enemySprite = new EnemyRobakSprite(x, y, parent, id);
		//addSprite(enemySprite);
		bullets = new ArrayList<Bullet>();
		// TODO Auto-generated constructor stub
	}
	
	public void setEnemyType(int type, float x, float y, int id, GameObject parent) {
		switch (type) {
		case 0:
			enemySprite = new EnemyRobakSprite(x, y, parent, id);
			addSprite(enemySprite);
			break;
		case 1:
			enemySprite = new EnemyMeduzaSprite(x, y, parent, id);
			addSprite(enemySprite);
		default:
			break;
		}
	}
	
	public void updateLast(float delta, float vx, float vy) {
		super.updateLast(delta, vx, vy);
		switch (type) {
		case 0:
			timer += delta;
			if (timer > shootTime) {
				shoot();
				timer=0;
			}
			timer++;
			break;
		case 1:
			timer += delta;
			if (timer > (shootTime+25)) {
				shoot();
				timer=0;
			}
			timer++;
			break;
		default:
			break;
		}
		
	}
	
	public void shoot(){
		bullets.add(new Bullet(enemySprite.getPosition().x, enemySprite.getPosition().y, 0, this));
		bullets.get(bullets.size()-1).setAsEnemyBullet();
		switch (type) {
		case 0:
			bullets.get(bullets.size()-1).shoot(((enemySprite.getPosition().x)-50), ((enemySprite.getPosition().y)-50), -300, 0);
			break;
		case 1:
			bullets.get(bullets.size()-1).shoot(((enemySprite.getPosition().x)-50), ((enemySprite.getPosition().y)+40), -300, 0);
			break;
		default:
			break;
		}		
		getGameObjects().removeAll(bullets);
		getGameObjects().addAll(bullets);
		
	}
}
