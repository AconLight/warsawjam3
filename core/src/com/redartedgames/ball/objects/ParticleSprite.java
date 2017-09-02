package com.redartedgames.ball.objects;

import java.util.Random;

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

	public void addParticleTexture(String path) {
		addTexture(path);
	}
	
	public ParticleSprite(float x, float y, GameObject parent, int id) {
		super(x, y, parent, id);
		this.x = x;
		this.y = y;
		getMovement().setG(GameVars.particleGravity);
		fadeTimer = rand.nextFloat(); 
		// TODO Auto-generated constructor stub
	}
	
	public void updateLast(float delta, float vx, float vy) {
		fadeTimer -= delta;
		getMovement().setVelocity(new Vector2(getMovement().getVelocity().x*.97f,getMovement().getVelocity().y*.97f));
	}
	
	
	
	
	
	public void render(SpriteBatch batch, int priority, float dx, float dy) {
		
	}
	
	public void render(ShapeRenderer batch, int priority, float dx, float dy) {
		batch.setColor(rand.nextFloat(), rand.nextFloat(), rand.nextFloat(), 0);
		batch.rect(getMovement().getPosition().x, getMovement().getPosition().y, rand.nextInt(3)+1, rand.nextInt(3)+1);
	}

}
