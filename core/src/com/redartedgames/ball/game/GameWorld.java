package com.redartedgames.ball.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.SpriteObject;
import com.redartedgames.ball.screen.MyWorld;

public class GameWorld extends MyWorld{
	
	GameObject obj;
	SpriteObject sp;
	public GameWorld() {
		super();
		
		obj = new GameObject(200, 200, 0, null);
		
		sp = new SpriteObject(300, 100, null, 1);
		sp.addTexture("badlogic.jpg");
		sp.setRenderIsNormal(true);
		obj.addSprite(sp);
		addGameObject(sp);
		sp.getMovement().setVelocity(new Vector2(100, 10));
		Gdx.app.log("gameworld", "" + sp.getMovement().getVelocity());
	}
	
	@Override
	public void update(float delta) {
		super.update(delta);		
		//Gdx.app.log("gameworld", "" + sp.getMovement().getPosition());
		
	}

}
