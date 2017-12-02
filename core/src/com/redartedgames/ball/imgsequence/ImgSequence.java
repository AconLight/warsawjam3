package com.redartedgames.ball.imgsequence;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ImgSequence extends ApplicationAdapter{
		
	private Texture texture;
	private ImgSequencePlayer player;
	ArrayList<Texture> list = new ArrayList<Texture>();
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
	
	public ImgSequence(String folder1, String name, int n, String type){
		this.name = folder1 + "/" + name;
		this.n = n;
		this.type = type;
		x = 0; y = 0; 
		
		create();
	}
	
	public ImgSequence(String folder1, String folder2, String name, int n, String type){
		this.name = folder1 + "/" + folder2 + "/" + name;
		this.n = n;
		this.type = type;
		x = 0; y = 0; 
		
		create();
	}
	
	public ImgSequence(String folder1, String folder2, String folder3, String name, int n, String type){
		this.name = folder1 + "/" + folder2 + "/" + folder3 + "/" + name;
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
		player.addTexture(list);
	}
	
	ArrayList<Texture> getSequence(){
		return list;
	}
	
	Texture getSequenceFrame(int n ){
		return list.get(n);
	}
	
	void imgList(){
		int i = 0;
		
		for(i = 0; i < n; i++){
			path = name + i + "." + type;
			list.add( texture = new Texture(path) );
		}
	}
	
	@Override
	public void create () {
		imgList();
		player = new ImgSequencePlayer(list, n, x, y);
	}
	
	
	@Override
	public void render () {
		
		
	}
		

}
