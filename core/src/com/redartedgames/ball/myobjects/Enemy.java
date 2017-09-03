package com.redartedgames.ball.myobjects;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.redartedgames.ball.objects.ColSpriteObject;
import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.TimeObject;

public class Enemy extends TimeObject{

	public ArrayList<Bullet> bullets;
	private int type;
	public ColSpriteObject enemySprite;
	private float shootTimer=0;
	private float shootTimeMax=30;
	private Player player;
	
	
	public Enemy(float x, float y, int id, GameObject parent, int type, Player player) {
		super(x, y, id, parent);
		this.type = type;
		setEnemyType(type, x, y, id, parent);
		this.player = player;
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
			((EnemyMeduzaSprite) enemySprite).mov(-100,0);
			break;
		case 2:
			enemySprite = new EnemyCebulaSprite(x, y, parent, id);
			addSprite(enemySprite);
			break;
			
		default:
			break;
		}
	}
	
	public void updateLast(float delta, float vx, float vy) {
		super.updateLast(delta, vx, vy);
			if (enemySprite.getMovement().getPosition().x - HelpGod.playerX < -1000) {
				isDone = true;
			}
		
		switch (type) {
		case 0:
			shootTimer += delta;
			if (shootTimer > shootTimeMax+35) {
				shoot();
				shootTimer=0;
			}
			shootTimer++;
			break;
		case 1:
			shootTimer += delta;
			if (shootTimer > (shootTimeMax+30)) {
				shoot();
				shootTimer=0;
			}
			shootTimer++;
			break;
		case 2:
			shootTimer += delta;
			if (shootTimer > shootTimeMax+20) {
				shoot();
				shootTimer=0;
			}
			shootTimer++;
			break;
		default:
			break;
		}
		
	}
	
	public void shoot(){
		float dx, dy, dr;
		dx = player.playerSprite.getMovement().getPosition().x - enemySprite.getPosition().x;
		dy = player.playerSprite.getMovement().getPosition().y - enemySprite.getPosition().y;
		Random rnd = new Random();
		dr = (float) Math.sqrt(dx*dx + dy*dy);
		
		
		bullets.add(new Bullet(enemySprite.getPosition().x, enemySprite.getPosition().y, 0, this, player));
		bullets.get(bullets.size()-1).setAsEnemyBullet();
		switch (type) {
		case 0:
			bullets.get(bullets.size()-1).shoot(((enemySprite.getPosition().x)-50), ((enemySprite.getPosition().y)-50), 600*dx/dr, 600*dy/dr);
			break;
		case 1:
			bullets.get(bullets.size()-1).shoot(((enemySprite.getPosition().x)-50), ((enemySprite.getPosition().y)+40), 600*dx/dr, 600*dy/dr);
			break;
		case 2:
			bullets.get(bullets.size()-1).shoot(((enemySprite.getPosition().x)), ((enemySprite.getPosition().y)+20), rnd.nextInt(200)-100, 600);
			break;
		default:
			break;
		}		
		getGameObjects().removeAll(bullets);
		getGameObjects().addAll(bullets);
		
	}
	
	public void collide(GameObject obj) {
		super.collide(obj);
		for (Bullet b : bullets) {
			b.collide(obj);
		}
		Gdx.app.log("enemy", "asd!1");
	}
	
	
}
