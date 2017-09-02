package com.redartedgames.ball.myobjects;

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
	
	public Ground(float x, float y, int blockSize, boolean isWater, GameObject parent, int id) {
		super(x, y, id, parent);
		this.x = x;
		this.y = y;
		this.isWater = isWater;
		this.blockSize = blockSize;
		plist = new ArrayList<GroundSprite>();
		generate();
	}
	
	private void generate() {
		if(isWater) {
			for(int i = 0; i < blockSize; i++) {
				plist.add(new GroundSprite(x, y, 7, null, 1));
				addSprite(plist.get(arrCounter));
				arrCounter++;
				plist.add(new GroundSprite(x, y+207, 8, null, 1));
				x += plist.get(arrCounter).regionList.get(plist.get(arrCounter).regionList.size()-1).getRegionWidth();
				addSprite(plist.get(arrCounter));
				arrCounter++;
			}
		}
		else {
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
	}
}
