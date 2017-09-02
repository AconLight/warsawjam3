package com.redartedgames.ball.objects;

import java.util.ArrayList;
import java.util.Random;
import com.badlogic.gdx.math.Vector2;
import com.redartedgames.ball.settings.GameVars;

public class ParticleObject extends TimeObject {
	public ArrayList<ParticleSprite> plist;
	public ArrayList<GameObject> obstacles;
	public boolean isDone = false;
	private int arraySize = 0;
	private int arrayCounter = 0;
	private float x;
	private float y;
	private float hitX = 1;
	private float hitY = 1;
	private Random rand = new Random();
	
	public ParticleObject(float x, float y, int id, GameObject parent) {
		super(x, y, id, parent);
		plist = new ArrayList<ParticleSprite>();
		this.x = x;
		this.y = y;
	}
	
	public void explode(float colissionVelocityX, float colissionVelocityY, float positionX, float positionY) {
		x = positionX;
		y = positionY;
		hitX = colissionVelocityX;
		hitY = colissionVelocityY;
		addParticles((int)(Math.sqrt(Math.abs(colissionVelocityX)+Math.abs(colissionVelocityY))*GameVars.particleScale));
	}
	
	public void explode(float colissionVelocityX, float colissionVelocityY) {
		hitX = colissionVelocityX;
		hitY = colissionVelocityY;
		addParticles((int)(Math.sqrt(Math.abs(colissionVelocityX)+Math.abs(colissionVelocityY))*GameVars.particleScale));
	}
	
	private void addParticles(int quantity) {
		for (int i = 0; i < quantity; i++) {
			plist.add(random());
			addSprite(plist.get(i));
		}
		arraySize = plist.size();
	}
	
	public void updateLast(float delta, float vx, float vy) {
		super.updateLast(delta, vx, vy);		
		for (ParticleSprite o : plist) {
			if (o.fadeTimer <= 0) {
				getGameObjects().remove(o);
				if (++arrayCounter == arraySize) isDone = true;
			}
		}
	}
	
	private ParticleSprite random() {
		ParticleSprite p = new ParticleSprite(x,y,this,1);
		float f1 = rand.nextFloat();
		float f2 = rand.nextFloat();
		float velocityx = -hitX + rand.nextFloat()*hitX-1/2*hitX + (-hitY/2 + rand.nextFloat()*hitY)/2;
		float velocityy = -hitY + rand.nextFloat()*hitY-1/2*hitY + (-hitX/2 + rand.nextFloat()*hitX)/2;
		p.getMovement().setPosition(new Vector2(x,y));
		p.getMovement().setVelocity(new Vector2(velocityx*GameVars.particleSpeed,velocityy*GameVars.particleSpeed));
		p.addParticleTexture("data/particles/zielony3x3.png");
		return p;		
	}
}
