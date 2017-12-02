package com.redartedgames.ball.imgsequence;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.SpriteObject;

public class ImgSequence extends GameObject{
		
	
	private Texture texture;
	private SpriteObject seq;
	private SpriteBatch batch;
	String path, folder, name, type;
	int n; 
	float x, y;
	
	public ImgSequence(float x, float y, int id, GameObject parent) {
		super(x, y, id, parent);
		this.x = x;
		this.y = y;
		
		// TODO Auto-generated constructor stub
	}
	
	
	 public void beginn(String folder, String name, int n, String type){
		this.folder = folder; 
		this.name = name;
		this.n = n;
		this.type = type;
		batch = new SpriteBatch();
		seq = new SpriteObject(x, y, null, 1);
		addSprite(seq);
		seq.isVisible = true;
		seq.setFrameTime(0.04f);
		for(int i = 0; i < n; i++) {
			path = folder + "/" + name + i + "." + type;
			System.out.println(path);
			seq.addTexture(path);
			
		}
			
		
	}
	
	 public void start() {
		 seq.frameNum = 0;
		 seq.isVisible = true;
		 seq.isStopped = false;
	 }
	 
	 public void stop() {
		 seq.isVisible = false;
		 seq.isStopped = true;
	 }
	 
	 public void render() {
		 batch.begin();
		 seq.render(batch, 1, 0, 0);
		 batch.end();
	 }
	 
	 public void update (float delta) {
		 seq.updateFrames(delta);
	 }
	 
	 
		

}
