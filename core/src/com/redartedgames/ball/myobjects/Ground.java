package com.redartedgames.ball.myobjects;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.TimeObject;

public class Ground extends TimeObject {
	public ArrayList<GroundSprite> plist;
	private boolean isWater;
	private int arrCounter = 0;
	private float x;
	private float y;
	private int blockSize;
	public float changeX;
	
	public Ground(float x, float y, int blockSize, boolean isWater, GameObject parent, int id) {
		super(x, y, id, parent);
		this.x = x;
		this.y = y;
		this.isWater = isWater;
		this.blockSize = blockSize;
		plist = new ArrayList<GroundSprite>();
		generate();
	}
	
	public void updateLast(float delta, float vx, float vy) {
		if(plist.size() > 0) {
			if (plist.get(0).getMovement().getPosition().x - HelpGod.playerX < -1000) {
				isDone = true;
			}
		}
	}
	
	private void generate() {
		if(isWater) {
			x+=82;
			y-=100;
			for(int i = 0; i < blockSize; i++) {
				plist.add(new GroundSprite(x, y, 7, null, 1));
				addSprite(plist.get(arrCounter));
				arrCounter++;
				plist.add(new GroundSprite(x, y+207, 8, null, 1));
				x += plist.get(arrCounter).regionList.get(plist.get(arrCounter).regionList.size()-1).getRegionWidth();
				addSprite(plist.get(arrCounter));
				arrCounter++;
			}
			x -= (plist.get(arrCounter-1).regionList.get(plist.get(arrCounter-1).regionList.size()-1).getRegionWidth())/2;
			x+=22;
		}
		else {
			x+=20;
			plist.add(new GroundSprite(x, y, 1, null, 1));
			addSprite(plist.get(arrCounter));
			x += plist.get(arrCounter).regionList.get(plist.get(arrCounter).regionList.size()-1).getRegionWidth();
			arrCounter++;
			for(int i = 2; i<blockSize; i++) {
				plist.add(new GroundSprite(x, y, new Random().nextInt(4)+2, null, 1));
				addSprite(plist.get(arrCounter));
				x += plist.get(arrCounter).regionList.get(plist.get(arrCounter).regionList.size()-1).getRegionWidth();
				arrCounter++;
			}
			x -=37;
			plist.add(new GroundSprite(x, y, 6, null, 1));
			addSprite(plist.get(arrCounter));
			x += plist.get(arrCounter).regionList.get(plist.get(arrCounter).regionList.size()-1).getRegionWidth();
			arrCounter++;
		}
		changeX = x-22;
	}
}
