package com.redartedgames.ball.game;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.redartedgames.ball.consts.PlayerConsts;
import com.redartedgames.ball.myobjects.HelpGod;
import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.Hitbox.BehaviorMode;
import com.redartedgames.ball.objects.Movement;
import com.redartedgames.ball.objects.ReversableMovement;
import com.redartedgames.ball.objects.ReversableObject;
import com.redartedgames.ball.screen.Consts;
import com.redartedgames.ball.screen.MyWorld;
import com.redartedgames.ball.settings.GameVars;

public class InputHandler implements InputProcessor{

	private GameWorld world;
	public InputHandler(GameWorld world) {
		this.world = world;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		
		switch(keycode) {
		
		case Keys.A: {
			world.player.addXAxis(-GameVars.MOVE_X);
			break;
		}
		case Keys.D: {
			world.player.addXAxis(GameVars.MOVE_X);
			break;
		}
		case Keys.W: {
			world.player.tryJump();
			break;
		}
		case Keys.ENTER: {
			
			world.restart();
			break;
		}
		case Keys.F: {
			//world.rect.move();
			break;
		}
		case Keys.Q: {
			//world.enemy.shoot();
			break;
		}
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {

		switch(keycode) {
		case Keys.A: {
			world.player.addXAxis(GameVars.MOVE_X);
			break;
		}
		case Keys.D: {
			world.player.addXAxis(-GameVars.MOVE_X);
			break;
		}
		case Keys.W: {
			//world.player.setIsJumping(false);
			break;
		}
		case Keys.SPACE: {
			//world.setIsForward(true);
			//world.impsCollection.activate();
			break;
		}
		case Keys.Q: {
			//
			break;
		}
		} 
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		world.player.tryShoot();
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		
		world.player.bullets.get(world.player.bullets.size()-1).explode();
		world.player.bullets.get(world.player.bullets.size()-1).sprite.isVisible = false;
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		world.celownik.getMovement().setPosition(new Vector2(world.cam123.position.x + screenX-360 - 280, world.cam123.position.y - 280 - screenY+640));
		HelpGod.screenX = screenX;
		HelpGod.screenY = screenY;
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
