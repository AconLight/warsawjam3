package com.redartedgames.ball.objects;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;
import com.badlogic.gdx.math.Vector2;

public class ParticleObject extends TimeObject {
	private ArrayList<ParticleSprite> plist;
	private float x;
	private float y;
	private float hitX;
	private float hitY;
	protected Random rand = new Random();
	
	public ParticleObject(float x, float y, int id, GameObject parent) {
		super(x, y, id, parent);
		plist = new ArrayList<ParticleSprite>();
		this.x = x;
		this.y = y;
	}
	
	public void explode(float PositionX, float PositionY, float colissionVelocityX, float colissionVelocityY) {
		hitX = colissionVelocityX;
		hitY = colissionVelocityY;
		addParticles((int)(colissionVelocityX+colissionVelocityY));
	}
	
	private void addParticles(int quantity) {
		for (int i = 0; i < quantity; i++) {
			plist.add(random());
			addSprite(plist.get(i));
		}
	}
	
	private ParticleSprite random() {
		ParticleSprite p = new ParticleSprite(1f,1f,this,1);
		float vx = -hitX + rand.nextFloat()*hitX-1/2*hitX;
		float vy = -hitY + rand.nextFloat()*hitY-1/2*hitY;
		p.getMovement().setPosition(new Vector2(x,y));
		p.getMovement().setVelocity(new Vector2(vx,vy));
		return p;
	}
}
