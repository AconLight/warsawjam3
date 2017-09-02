package com.redartedgames.ball.myobjects;

import com.redartedgames.ball.objects.ColSpriteObject;
import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.Hitbox;
import com.redartedgames.ball.objects.Hitbox.BehaviorMode;

public class GroundSprite extends ColSpriteObject{

	private float width = 0;
	private float height = 0;
	
	public GroundSprite(float x, float y, int type, GameObject parent, int id) {
		super(x, y, parent, id);
		setGround(type);
		if(type==8);//setHitbox(new Hitbox(positionX, positionY, width, height, BehaviorMode.none));
		else setHitbox(new Hitbox(positionX, positionY, width, height, BehaviorMode.kinematic));
	}	
	
	public void setGround(int groundType) {
		switch (groundType){
			default:
			case 1:
				addTexture("data/ground/ziemia_bok_przod.png");
				width = regionList.get(regionList.size()-1).getRegionWidth();
				height = regionList.get(regionList.size()-1).getRegionHeight();
				break;
			case 2:
				addTexture("data/ground/ziemia_srodek1.png");
				width = regionList.get(regionList.size()-1).getRegionWidth();
				height = regionList.get(regionList.size()-1).getRegionHeight();
				break;
			case 3:
				addTexture("data/ground/ziemia_srodek2.png");
				width = regionList.get(regionList.size()-1).getRegionWidth();
				height = regionList.get(regionList.size()-1).getRegionHeight();
				break;
			case 4:
				addTexture("data/ground/ziemia_srodek3.png");
				width = regionList.get(regionList.size()-1).getRegionWidth();
				height = regionList.get(regionList.size()-1).getRegionHeight();
				break;
			case 5:
				addTexture("data/ground/ziemia_srodek4.png");
				width = regionList.get(regionList.size()-1).getRegionWidth();
				height = regionList.get(regionList.size()-1).getRegionHeight();
				break;
			case 6:
				addTexture("data/ground/ziemia_bok_tyl.png");
				width = regionList.get(regionList.size()-1).getRegionWidth();
				height = regionList.get(regionList.size()-1).getRegionHeight();
				break;
			case 7:
				addTexture("data/ground/ziemia_pod_wode.png");
				width = regionList.get(regionList.size()-1).getRegionWidth();
				height = regionList.get(regionList.size()-1).getRegionHeight();
				break;
			case 8:
				addTexture("data/ground/woda.png");
				width = regionList.get(regionList.size()-1).getRegionWidth();
				height = regionList.get(regionList.size()-1).getRegionHeight();
				break;
		}
	}	
}
