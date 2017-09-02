package com.redartedgames.ball.game;

import com.redartedgames.ball.myobjects.Player;
import com.badlogic.gdx.Gdx;
import com.redartedgames.ball.objects.ParticleObject;
import com.redartedgames.ball.screen.MyWorld;

public class GameWorld extends MyWorld{
	
	ParticleObject o = new ParticleObject(300, 300, 1, null);
	
	public GameWorld() {
		super();		
		addGameObject(o);
		o.explode(0, -10);
	}
	
	@Override
	public void update(float delta) {
		super.update(delta);		
	}	
}
