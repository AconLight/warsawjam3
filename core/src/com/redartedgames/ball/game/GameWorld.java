package com.redartedgames.ball.game;

import java.util.ArrayList;

import com.redartedgames.ball.myobjects.Platform;
import com.redartedgames.ball.myobjects.Player;
import com.redartedgames.ball.objects.GameObject;
import com.badlogic.gdx.Gdx;
import com.redartedgames.ball.myobjects.Platform;
import com.redartedgames.ball.objects.ParticleObject;

import com.redartedgames.ball.screen.MyWorld;
import com.redartedgames.ball.sprites.BubbleSprite;

public class GameWorld extends MyWorld{
	
	Player player;
	ArrayList<GameObject> platforms;
	BubbleSprite b = new BubbleSprite(500, 200, null, 1);
	Platform p1 = new Platform(400, 400, 3, null, 1);
	Platform p2 = new Platform(400, 600, 10, null, 1);
	
	public GameWorld() {
		super();
		addGameObject(p1);
		addGameObject(p2);
		addGameObject(b);
		b.setRadius(100);
	}
	
	
	@Override
	public void update(float delta) {
		super.update(delta);
		
	}	
}
