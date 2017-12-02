package com.redartedgames.ball.imgsequence;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.SpriteObject;

public class ImgSequencePlayer extends GameObject{
	
	private SpriteObject seq;
	//private ImgSequenceLoader loader;
	private float x, y;
	private SpriteBatch batch;
	int n;
	
	ArrayList<Texture> list = new ArrayList<Texture>();
	
	ImgSequencePlayer(int n, float x, float y){
		super(x,y, 1, null);
		//this.list = list;
		this.n = n;
		this.x = x;
		this.y = y;
		
		seq = new SpriteObject(x, y, null, 0);
		addSprite(seq);
		seq.setFrameTime(0.04f);
	}
	
	void play(){
		
		seq.isStopped = false;
		seq.isVisible = true;
		seq.setFrameTime(0);
		
	}
	
	void stop(){
		seq.isStopped = true;
		seq.isVisible = false;
	}
	
	void addTexture( String path){
		System.out.println(path);
		seq.addTexture(path);
		
	}
	
	void setPossision(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	void setVisible(boolean visible){
		seq.isVisible = visible;
	}
	
	void setPong(boolean ispong){
		seq.setIsPingpong(ispong);
	}
	
	void update(){
		super.updateAfter(Gdx.graphics.getDeltaTime(), 0, 0);
		
	}
	
	void render(float delta){
		batch.begin();
		seq.updateFrames(delta);
		seq.render(batch, 1, 0, 0);
		batch.end();
	}
	
}
