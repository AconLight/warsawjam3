package com.redartedgames.ball.imgsequence;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ImgSequence {
		
	private Texture texture;
	
	String path, name, type;
	int n;
	float x, y;
	
	
	public ImgSequence(String name, int n, String type){
		this.name = name;
		this.n = n;
		this.type = type;
		
		//create();
	}
	
	public ImgSequence(String folder, String name, int n, String type){
		this.name = folder + "/" + name;
		this.n = n;
		this.type = type;
		
		//imgList();
		//create();
	}
	

	
	
	void imgList(){
		int i = 0;
		
		for(i = 0; i < n; i++){
			path = name + i + "." + type;
			System.out.println(path);
			
		}
	}
	

	
	
	/*@Override
	public void create () {
		imgList();
		
	}
	
	
	@Override
	public void render () {
		
		
	}
		*/

}
