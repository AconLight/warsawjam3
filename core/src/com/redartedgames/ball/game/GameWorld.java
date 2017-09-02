package com.redartedgames.ball.game;

import java.util.ArrayList;

import com.redartedgames.ball.myobjects.Bubble;
import com.redartedgames.ball.myobjects.Ground;
import com.redartedgames.ball.myobjects.GroundSprite;
import com.redartedgames.ball.myobjects.Platform;
import com.redartedgames.ball.myobjects.Player;
import com.redartedgames.ball.myobjects.TimeBar;
import com.redartedgames.ball.objects.GameObject;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEmitter.Particle;
import com.redartedgames.ball.myobjects.Platform;
import com.redartedgames.ball.objects.ParticleObject;
import com.redartedgames.ball.objects.TimeObject;
import com.redartedgames.ball.screen.MyWorld;
import com.redartedgames.ball.sprites.BubbleSprite;

public class GameWorld extends MyWorld{
	
	Player player;
	ArrayList<GameObject> platforms;
	Platform platform, p2;
	ArrayList<Bubble> bubbles;
	ParticleObject pa = new ParticleObject(600, 600, 1, null);
	TimeBar tb = new TimeBar(40, 660, null, 1);
	public GameWorld() {
		super();
		bubbles = new ArrayList<Bubble>();
		platforms = new ArrayList<GameObject>();
		platform = new Platform(200, 100, 6, null, 0);
		p2 = new Platform(600, 300, 3, null, 0);
		addGameObject(platform);		
		addGameObject(p2);
		
		
		
		player = new Player(50, 300, 0, null, platforms, bubbles);		
		Ground g1 = new Ground(0, 0, 3, false, null, 1);
		Ground g2 = new Ground(g1.changeX, 0, 2, true, null, 1);
		Ground g3 = new Ground(g2.changeX, 0, 3, false, null, 1);
		Ground g4 = new Ground(g3.changeX, 0, 2, true, null, 1);
		addGameObject(g1);
		addGameObject(g2);
		addGameObject(g3);
		addGameObject(g4);
		
		addGameObject(player);
		
		player.playerSprite.collidableObjects.addAll(platform.plist);
		player.playerSprite.collidableObjects.addAll(p2.plist);
		player.playerSprite.collidableObjects.addAll(g1.plist);
		player.playerSprite.collidableObjects.addAll(g2.plist);
		player.playerSprite.collidableObjects.addAll(g3.plist);
		player.playerSprite.collidableObjects.addAll(g4.plist);
		addGameObject(tb);
	}
	
	
	@Override
	public void update(float delta) {
		super.update(delta);		
		gameObjects.removeAll(bubbles);
		gameObjects.addAll(bubbles);
		
		
		
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
