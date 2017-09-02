package com.redartedgames.ball.myobjects;

import java.util.ArrayList;
import java.util.Random;

import com.redartedgames.ball.objects.GameObject;

public class ObjectRandomizer {

	private int type;
	private float chuj;
	private ArrayList<GameObject> meduza;
	Enemy enemy;
		
	
	public ObjectRandomizer(int type, ArrayList<GameObject> meduza, float delta){
	this.type = type;
	this.meduza = meduza;
	//HujKurwaLosuj(type);
	//meduza.add(null);
	
	}
	
	/*public float HujKurwaLosuj (int type) {
		
			if (type == 1) {
			Random huj = new Random();
			chuj = (400+(huj.nextInt(1000)));
		}
			
		return chuj;		
	}*/
	
	
	
	
}
