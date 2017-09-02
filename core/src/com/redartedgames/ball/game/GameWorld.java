package com.redartedgames.ball.game;

import java.util.ArrayList;
import com.redartedgames.ball.myobjects.Bubble;
import com.redartedgames.ball.myobjects.Ground;
import com.redartedgames.ball.myobjects.GroundSprite;
import com.redartedgames.ball.myobjects.ObjectRandomizer;
import com.redartedgames.ball.myobjects.Platform;
import com.redartedgames.ball.myobjects.Player;
import com.redartedgames.ball.myobjects.TimeBar;
import com.redartedgames.ball.objects.GameObject;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.ParticleEmitter.Particle;
import com.badlogic.gdx.math.Vector2;
import com.redartedgames.ball.myobjects.Platform;
import com.redartedgames.ball.objects.ParticleObject;
import com.redartedgames.ball.objects.SpriteObject;
import com.redartedgames.ball.objects.TimeObject;
import com.redartedgames.ball.screen.MyWorld;
import com.redartedgames.ball.sprites.BubbleSprite;

public class GameWorld extends MyWorld{
	public SpriteObject celownik;
	int i = 0;
	Player player;
	ArrayList<GameObject> platforms;
	Platform platform, p2;
	ArrayList<Bubble> bubbles;
	ParticleObject pa = new ParticleObject(600, 600, 1, null);
	TimeBar tb = new TimeBar(40, 660, null, 1);
	ObjectRandomizer or;
	//private OrthographicCamera cam;
	public GameWorld(OrthographicCamera cam) {
		super(cam);
		celownik = new SpriteObject(0, 0, null, 0);
		celownik.addTexture("data/bubbles/bubble_player.png");
		gameObjects.add(celownik);
		//cam123.translate(new Vector2(0, 300));
		//cam123.update();
		bubbles = new ArrayList<Bubble>();
		platforms = new ArrayList<GameObject>();
		player = new Player(50, 300, 0, null, platforms, bubbles, tb, celownik);		
		
		or = new ObjectRandomizer(gameObjects, player,tb);
		//tb = new TimeBar(500, 1000, null, 0);
		addGameObject(player);	
		addGameObject(tb);	
	}
	
	@Override
	public void update(float delta) {
		celownik.getMovement().setVelocity(player.playerSprite.getMovement().getVelocity());
		super.update(delta);		
		gameObjects.removeAll(bubbles);
		gameObjects.addAll(bubbles);
		float cx = cam123.position.x;
		float cy = cam123.position.y;
		cam123.translate(new Vector2(player.playerSprite.getMovement().getPosition().x - cam123.position.x + 200, 
			(player.playerSprite.getMovement().getPosition().y/3 - cam123.position.y+50)));
		//cam123.translate(new Vector2(0, 200));
		//celownik.getMovement().setPosition(new Vector2(celownik.getMovement().getPosition().x + player.playerSprite.getMovement().getPosition().x - cam123.position.x + 200,
				//celownik.getMovement().getPosition().y + (player.playerSprite.getMovement().getPosition().y/3 - cam123.position.y+50)));
		//celownik.setPosition(celownik.getMovement().getPosition());
		
		
		cam123.update();
		goItr(gameObjects);
		
		if (player.playerSprite.getMovement().getPosition().x > or.x - 1220) {
			i++;
			or.randomize();
		}
		
		//Gdx.app.log("gameWorld", "" + player.playerSprite.isVoulnerable);	
		if (player.playerSprite.isVoulnerable) {
			tb.timeLeft -= delta*30;
			player.playerSprite.isVoulnerable = false;
		}
		
		
		gameObjects.remove(celownik);
		
		gameObjects.add(celownik);
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
