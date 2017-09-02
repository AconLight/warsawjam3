package com.redartedgames.ball.settings;

import com.badlogic.gdx.math.Vector2;

public class GameVars {

	public static final float jumpBlockTime = 0.1f;
	public static final float jumpVel = 1500f;
	public static final float g = -1500;
	public static final float MOVE_X = 1500;
	public static final float playerDrag = 0.92f;
	public static final float box2dScale = 100;
	public static final float particleScale = 10;
	public static final float particleSpeed = 500;
	public static final float particleRange = 50000; //to jest kwadrat prawdziwego zasi�gu
	public static final Vector2 particleGravity = new Vector2(0,-1000);
}