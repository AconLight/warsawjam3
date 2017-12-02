package com.redartedgames.ball.imgsequence;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ImgSequence {
		
	private Texture texture;
	private ImgSequencePlayer player;
	//ArrayList<Texture> list;
	String path, name, type;
	int n;
	float x, y;
	
	
	public ImgSequence(String name, int n, String type){
		this.name = name;
		this.n = n;
		this.type = type;
		x = 0; y = 0; 
		
		create();
	}
	
	public ImgSequence(String folder, String name, int n, String type){
		this.name = folder + "/" + name;
		System.out.println(this.name);
		this.n = n;
		this.type = type;
		x = 0; y = 0; 
		
		create();
	}
	
	
	
	void play(){
		player.play();
	}
	void setPossision(float x, float y){
		this.x = x;
		this.y = y;
		player.setPossision(x, y);
	}
	
	void setVisibility(boolean visible){
		player.setVisible(visible);
	}
	
	void setPong(boolean ispong){
		player.setPong(ispong); 
	}
	
	void loadTexture(){
		
		//for(int i=0; i<n; i++){
			//path = name + i + "." + type;
			player.addTexture("film1/test0.png");
		//}

	}
	/*
	 
	ArrayList<Texture> getSequence(){
		return list;
	}
	
	Texture getSequenceFrame(int n ){
		return list.get(n);
	}
	
	void imgList(){
		
		player.
		
		int i = 0;
		
		//or(i = 0; i < n; i++){
			path = name + i + "." + type;
			System.out.println(path);
			list.add(texture = new Texture(path) );
		//}
	}*/
	
	
	public void create () {
		//list = new ArrayList<Texture>();
		//imgList();
		player = new ImgSequencePlayer( n, x, y);
		loadTexture();
	}
	
	
	
	public void render () {
		
		player.render(Gdx.graphics.getDeltaTime());
		
	}
		

}
