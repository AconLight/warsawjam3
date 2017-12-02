package com.redartedgames.ball.imgsequence;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.SpriteObject;

public class ImgSequencePlayer extends GameObject{
	
	private SpriteObject seq;
	//private ImgSequenceLoader loader;
	private float x, y, delta;
	int n;
	
	ArrayList<Texture> list = new ArrayList<Texture>();
	
	ImgSequencePlayer(	ArrayList<Texture> list, int n, float x, float y){
		super(x,y, 1, null);
		this.list = list;
		this.n = n;
		this.x = x;
		this.y = y;
		
		seq = new SpriteObject(x, y, null, 0);
	}
	
	void play(){
		
				
	}
	
	void addTexture( ArrayList<Texture> list){
		int i;
		for(i = 0; i < n; i++){
			addSprite(seq);
			seq.addTexture(list.get(i));
		}
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
	
	void render(){
		seq.updateFrames(delta);
	}
	
}
