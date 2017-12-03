package com.redartedgames.ball.game_his;

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

public class InputHandler_his implements InputProcessor{

	private GameWorld_his world;
	public InputHandler_his(GameWorld_his world) {
		this.world = world;
	}
	@Override
	public boolean keyDown(int keycode) {
		switch(keycode) {
		case Keys.A: {
			world.cardsManager.moveLeft();
			break;
		}
		case Keys.D: {
			world.cardsManager.moveRight();
			break;
		}		
		case Keys.W: {
			world.cardsManager.moveForward();
			break;
		}
		case Keys.S: {
			world.cardsManager.moveBack();
			break;
		}
		case Keys.SPACE:
			world.cardsManager.cast();
			break;
		case Keys.ENTER:
			//world.isRestart = true;
			break;
	
		}
		
		
		return false;
	}
	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		world.fieldManager.checkMouse(screenX, screenY);
		world.fieldManager.setCamVel(screenX - 1280/2, screenY - 1080/2);
		//System.out.println("" + screenX + ", " + screenY);
		return false;
	}
	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
