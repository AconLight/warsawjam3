package com.redartedgames.ball.game;

import java.util.ArrayList;

import com.redartedgames.ball.myobjects.Bubble;
import com.redartedgames.ball.myobjects.Platform;
import com.redartedgames.ball.myobjects.Player;
import com.redartedgames.ball.objects.GameObject;
import com.badlogic.gdx.Gdx;
import com.redartedgames.ball.myobjects.Platform;
import com.redartedgames.ball.objects.ParticleObject;
import com.redartedgames.ball.objects.TimeObject;
import com.redartedgames.ball.screen.MyWorld;
import com.redartedgames.ball.sprites.BubbleSprite;

public class GameWorld extends MyWorld{
	
	Player player;
	ArrayList<GameObject> platforms;
	ArrayList<Bubble> bubbles;
	Platform platform, p2;
	ParticleObject p;
	public GameWorld() {
		super();
		bubbles = new ArrayList<Bubble>();
		platform = new Platform(200, 100, 6, null, 0);
		addGameObject(platform);
		p2 = new Platform(600, 300, 3, null, 0);
		addGameObject(p2);
		platforms = new ArrayList<GameObject>();
		platforms.addAll(platform.plist);
		platforms.addAll(p2.plist);
		player = new Player(200, 200, 0, null, platforms, bubbles);
		addGameObject(player);
		
		player.playerSprite.collidableObjects.addAll(platform.plist);
		player.playerSprite.collidableObjects.addAll(p2.plist);

		p = new ParticleObject(200, 600, 0, null);
		addGameObject(p);
		p.explode(1, -1);
	}
	
	
	@Override
	public void update(float delta) {
		super.update(delta);		
		gameObjects.removeAll(bubbles);
		gameObjects.addAll(bubbles);
		goItr(getGameObjects());
		Gdx.app.log("gameWorld", "" + bubbles.size());
		
	}	
	
	public void calcTime(TimeObject obj) {
		obj.timeScale = 1;
		float scl = 1, scl2 = 1;
		float dx, dy, dr, d;
		for(Bubble bub : bubbles) {
			dx = bub.bubbleSprite.getMovement().getPosition().x - obj.getMovement().getPosition().x;
			dy = bub.bubbleSprite.getMovement().getPosition().y - obj.getMovement().getPosition().y;
			dr = (float) Math.sqrt(dx*dx + dy*dy);
			d =  bub.radius - dr;
			if (d < 0) d = 0;
			scl = 1 - (d)/(bub.maxRadius + 30);
			scl*=scl;
			scl2 *= scl;
		}
		obj.timeScale = scl2;
	}
	
	public void goItr(ArrayList<GameObject> objs) {
		for(GameObject obj : objs) {
			calcTime((TimeObject) obj);
			goItr(obj.getGameObjects());
		}
	}
}
