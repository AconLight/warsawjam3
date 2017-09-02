package com.redartedgames.ball.myobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.redartedgames.ball.objects.ColSpriteObject;
import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.Hitbox;
import com.redartedgames.ball.objects.TimeObject;
import com.redartedgames.ball.sprites.BublleBulletSprite;
import com.redartedgames.ball.sprites.EnemyBulletSprite;

public class Bullet extends TimeObject{
	
	public ColSpriteObject sprite;
	public boolean isExploded;
	public boolean isUsed;
	Player player;
	
	public Bullet(float x, float y, int id, GameObject parent, Player player) {
		super(x, y, id, parent);
		setAsBubbleBullet();
		this.player = player;
	}
	
	public void setAsBubbleBullet() {
		type =  ObjectType.BUBBLE_BULLET;
		sprite = new BublleBulletSprite(-1000, 0, this, 0);
	}
	
	public void setAsEnemyBullet() {
		type =  ObjectType.ENEMY_BULLET;
		sprite = new EnemyBulletSprite(-1000, 0, this, 0, player);
	}
	
	
	public void explode() {
		isExploded = true;
	}
	
	public void shoot(float x, float y, float vx, float vy) {
		sprite.getMovement().setPosition(new Vector2(x, y));
		sprite.getMovement().setVelocity(new Vector2(vx, vy));
		addSprite(sprite);
	}
	
	public void collide(GameObject obj) {
		super.collide(obj);
		sprite.collide(obj);
		Gdx.app.log("bullet", "asd");
	}

}
