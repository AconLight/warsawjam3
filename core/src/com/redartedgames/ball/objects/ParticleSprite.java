package com.redartedgames.ball.objects;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.redartedgames.ball.settings.GameVars;

public class ParticleSprite extends SpriteObject{
	
	public float fadeTimer;
	private float x;
	private float y;
	private float R;
	private float G;
	private float B;
	private Random rand = new Random();
	private float bubbleSize;

	public void addParticleTexture(String path) {
		addTexture(path);
	}
	
	public ParticleSprite(float x, float y, GameObject parent, int id) {
		super(x, y, parent, id);
		this.x = x;
		this.y = y;
		getMovement().setG(GameVars.particleGravity);
		fadeTimer = rand.nextFloat(); 
		addTexture("data/particles/bubble.png");
		bubbleSize = rand.nextFloat()*16;
		// TODO Auto-generated constructor stub
	}
	
	public void updateLast(float delta, float vx, float vy) {
		fadeTimer -= delta;
		getMovement().setVelocity(new Vector2(getMovement().getVelocity().x*.97f,getMovement().getVelocity().y*.97f));
		if((Math.pow(getMovement().getPosition().x-x, 2) + Math.abs(getMovement().getPosition().y-y)*(getMovement().getPosition().y-y)) > GameVars.particleRange) fadeTimer = 0;
		if(Math.abs(getMovement().getPosition().x - x) >= Math.sqrt(GameVars.particleRange)) fadeTimer = 0;
	}
		
	public void render(SpriteBatch batch, int priority, float dx, float dy) {
		batch.draw(regionList.get(0), getMovement().getPosition().x, getMovement().getPosition().y, bubbleSize, bubbleSize);
	}
	
	public void render(ShapeRenderer batch, int priority, float dx, float dy) {
		//addTexture("data/particles/bubble.png");
		//batch.scale((rand.nextFloat()+1)/2, (rand.nextFloat()+1)/2, 1);
		//batch.setColor(rand.nextFloat(), rand.nextFloat(), rand.nextFloat(), 0);
		//batch.rect(getMovement().getPosition().x, getMovement().getPosition().y, rand.nextInt(10)+5, rand.nextInt(10)+5);
	}

}
