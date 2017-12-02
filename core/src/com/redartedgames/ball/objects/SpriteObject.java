package com.redartedgames.ball.objects;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class SpriteObject extends TimeObject {
	
	public ArrayList<TextureRegion> regionList;
	protected int frameNum;
	private float frameTime;
	private float frameDt;
	private boolean isPingPong;
	private boolean isLeft;
	protected float alfa;
	public boolean isVisible;
	private boolean isStoped;
	private int animatoinCounter;
	private float sclX = 1, sclY = 1;
	
	public void setStoped(boolean isStoped) {
		this.isStoped = isStoped;
	}

	public GameObject parent;
	
	public SpriteObject(float x, float y, GameObject parent, int id){
		super(x, y, id, parent);
		isVisible = true;
		alfa = 0;
		regionList = new ArrayList<TextureRegion>();
		frameNum=0;
		frameTime=1f;
		isPingPong=false;
		isStoped=false;
		animatoinCounter=0;
		this.parent = parent;
	}	
	
	public SpriteObject addTexture(String path){
		FileHandle file = Gdx.files.internal(path);
		Texture tex = new Texture(file);
		regionList.add(new TextureRegion(tex));
		return this;
	}
	
	public SpriteObject addTexture(Texture tex){
		regionList.add(new TextureRegion(tex));
		return this;
	}
	
	@Override
	public void updateLast(float delta, float vx, float vy) { 
		super.updateLast(delta, vx, vy);
		updateFrames(delta);
	}
	
	public void updateFrames(float delta) { 
		frameDt+=delta;
		if(!isStoped && frameDt>frameTime){
			if(isPingPong==true)
			{
				if(isLeft == false )
				{
					frameNum++;
					if(frameNum == regionList.size()-1)
						isLeft = true;
				}
				else
				{
					frameNum--;
					if(frameNum==0)
						isLeft = false;
				}
					
				
			}
			else
			{
				animatoinCounter++;
				if(frameNum<regionList.size()-1)
					frameNum++;
				else
					frameNum = 0;
			}
			
			frameDt -=frameTime;
			
		}
		
	}
	
	public SpriteObject setIsPingpong(boolean e) {
		isPingPong = e;
		return this;
	}
	
	public SpriteObject setFrameTime(float time) {
		frameTime = time;
		return this;
	}
	
	public void render(SpriteBatch batch, int priority, float dx, float dy) {
		
		
		//batch.draw(regionList.get(frameNum), position.x - regionList.get(frameNum).getRegionWidth()/2,
				//position.y - regionList.get(frameNum).getRegionHeight()/2);
		if (isVisible && regionList.size() != 0) {
			if (renderIsNormal) {
				dx = 0;
				dy = 0;
			}
			batch.draw(regionList.get(frameNum), position.x + dx - regionList.get(frameNum).getRegionWidth()/2,
		
				position.y + dy - regionList.get(frameNum).getRegionHeight()/2,
				regionList.get(frameNum).getRegionWidth()/2, regionList.get(frameNum).getRegionHeight()/2,
				regionList.get(frameNum).getRegionWidth(), regionList.get(frameNum).getRegionHeight(),
				sclX, sclY, alfa);
			//Gdx.app.log("rendered", "spriteobject");
		}
		for (GameObject obj : getGameObjects()) {
			obj.render(batch, priority, dx, dy);
		}
	}
	
	@Override
	public void collide(GameObject obj) {
		super.collide(obj);
	}
	
	public void dispose() {

		super.dispose();
		for(int i=0; i<regionList.size();i++)
			regionList.get(i).getTexture().dispose();

	}

}
