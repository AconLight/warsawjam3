package com.redartedgames.ball.game;

import java.util.ArrayList;
import com.redartedgames.ball.myobjects.Bubble;
import com.redartedgames.ball.myobjects.Ground;
import com.redartedgames.ball.myobjects.GroundSprite;
import com.redartedgames.ball.myobjects.HelpGod;
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
	private SpriteObject bckg1;
	private SpriteObject bckg2;
	private SpriteObject bckg3;
	private int bckgX1 = 0;
	private int bckgX2 = 0;
	private int bckgX3 = 0;
	private int bckgY = 580;
	public GameWorld(OrthographicCamera cam) {
		super(cam);
		celownik = new SpriteObject(0, 0, null, 0);
		celownik.addTexture("data/bubbles/bubble_player.png");
		gameObjects.add(celownik);	
		bckg1 = new SpriteObject(bckgX1, bckgY, null, 0);
		bckg1.addTexture("data/background/background1.png");
		//addGameObject(bckg1);
		gameObjects.add(0, bckg1);
		bckgX1+=3000;
		bckgX2+=3000;
		bckgX3+=3000;
		bckg2 = new SpriteObject(bckgX2, bckgY, null, 0);
		bckg2.addTexture("data/background/background2.png");
		gameObjects.add(0, bckg2);
		bckgX2+=2960;
		bckgX3+=2960;
		bckg3 = new SpriteObject(bckgX3, bckgY, null, 0);
		bckg3.addTexture("data/background/background3.png");
		gameObjects.add(0, bckg3);
		bckgX3+=2921;

		//cam123.translate(new Vector2(0, 300));
		//cam123.update();
		bubbles = new ArrayList<Bubble>();
		platforms = new ArrayList<GameObject>();
		player = new Player(500, 300, 0, null, platforms, bubbles, tb, celownik);		
		
		or = new ObjectRandomizer(gameObjects, player,tb);
		//tb = new TimeBar(500, 1000, null, 0);
		addGameObject(player);	
		addGameObject(tb);	
	}
	
	@Override
	public void update(float delta) {
		if (player.playerSprite.getMovement().getPosition().x > bckgX1) {
			bckg1.getMovement().getPosition().x +=8921;
			bckgX1+=8921;
		}
		if (player.playerSprite.getMovement().getPosition().x > bckgX2) {
			bckg2.getMovement().getPosition().x +=8921;
			bckgX2+=8921;
		}
		if (player.playerSprite.getMovement().getPosition().x > bckgX3) {
			bckg3.getMovement().getPosition().x +=8921;
			bckgX3+=8921;
		}
		super.update(delta);		
		gameObjects.removeAll(bubbles);
		gameObjects.addAll(bubbles);
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
		
		celownik.getMovement().setPosition(new Vector2(cam123.position.x + HelpGod.screenX-360 - 280, cam123.position.y - 280 - HelpGod.screenY+640 + 200));
		
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
