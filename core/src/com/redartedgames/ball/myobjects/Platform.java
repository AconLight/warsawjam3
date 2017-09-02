package com.redartedgames.ball.myobjects;

import java.util.ArrayList;
import java.util.Random;

import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.TimeObject;

public class Platform extends TimeObject{
	
	public ArrayList<PlatformSprite> plist;
	private int arrCounter = 0;
	private float x;
	private float y;
	private int blockSize;
	
	public Platform(float x, float y, int blockSize, GameObject parent, int id) {
		super(x, y, id, parent);
		this.x = x;
		this.y = y;
		this.blockSize = blockSize;
		plist = new ArrayList<PlatformSprite>();
		generate();
	}
	
	private void generate() {
		plist.add(new PlatformSprite(x, y, 1, 1, null));
		addSprite(plist.get(arrCounter));
		x += plist.get(arrCounter).regionList.get(plist.get(arrCounter).regionList.size()-1).getRegionWidth();
		arrCounter++;
		for(int i = 2; i<blockSize; i++) {
			plist.add(new PlatformSprite(x, y, new Random().nextInt(4)+2, 1, null));
			addSprite(plist.get(arrCounter));
			x += plist.get(arrCounter).regionList.get(plist.get(arrCounter).regionList.size()-1).getRegionWidth();
			arrCounter++;
		}
		plist.add(new PlatformSprite(x, y, 6, 1, null));
		addSprite(plist.get(arrCounter));
		x += plist.get(arrCounter).regionList.get(plist.get(arrCounter).regionList.size()-1).getRegionWidth();
		arrCounter++;
	}
}
