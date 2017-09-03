package com.redartedgames.ball.myobjects;

import com.redartedgames.ball.objects.ColSpriteObject;
import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.Hitbox;
import com.redartedgames.ball.objects.Hitbox.BehaviorMode;

public class PlatformSprite extends ColSpriteObject{
	
	private int width;
	private int height;

	public PlatformSprite (float x, float y, int type, int id, GameObject parent){
		super(x,y,parent,id);
		setPlatform(type);
		setHitbox(new Hitbox(positionX, positionY, width, height, BehaviorMode.kinematic));
	}
	public void updateLast(float delta, float vx, float vy) {
		if (getMovement().getPosition().x - HelpGod.playerX < -100) {
			isDone = true;
		}
	}
	
	public void setPlatform(int platformType) {
		switch (platformType){
			default:
			case 1:
				addTexture("data/platforms/platforma_bok_przod.png");
				width = regionList.get(regionList.size()-1).getRegionWidth();
				height = regionList.get(regionList.size()-1).getRegionHeight();
				break;
			case 2:
				addTexture("data/platforms/platforma_srodek1.png");
				width = regionList.get(regionList.size()-1).getRegionWidth();
				height = regionList.get(regionList.size()-1).getRegionHeight();
				break;
			case 3:
				addTexture("data/platforms/platforma_srodek2.png");
				width = regionList.get(regionList.size()-1).getRegionWidth();
				height = regionList.get(regionList.size()-1).getRegionHeight();
				break;
			case 4:
				addTexture("data/platforms/platforma_srodek3.png");
				width = regionList.get(regionList.size()-1).getRegionWidth();
				height = regionList.get(regionList.size()-1).getRegionHeight();
				break;
			case 5:
				addTexture("data/platforms/platforma_srodek4.png");
				width = regionList.get(regionList.size()-1).getRegionWidth();
				height = regionList.get(regionList.size()-1).getRegionHeight();
				break;
			case 6:
				addTexture("data/platforms/platforma_bok_tyl.png");
				width = regionList.get(regionList.size()-1).getRegionWidth();
				height = regionList.get(regionList.size()-1).getRegionHeight();
				break;
		}
	}
}
