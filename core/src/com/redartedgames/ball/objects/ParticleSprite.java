package com.redartedgames.ball.objects;

public class ParticleSprite extends SpriteObject{

	public void addParticleTexture(String path) {
		addTexture(path);
	}
	
	public ParticleSprite(float x, float y, GameObject parent, int id) {
		super(x, y, parent, id);
		// TODO Auto-generated constructor stub
	}

}
