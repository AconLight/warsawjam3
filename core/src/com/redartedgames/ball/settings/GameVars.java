package com.redartedgames.ball.settings;

import com.badlogic.gdx.math.Vector2;

public class GameVars {

	public static final float jumpBlockTime = 0.1f;
	public static final float jumpVel = 2500f;
	public static final float g = -2500;
	public static final float MOVE_X = 2500;
	public static final float playerDrag = 0.9f;
	public static final float box2dScale = 100;
	public static final float particleScale = 15;
	public static final float particleSpeed = 400;
	public static final float particleRange = 30000; //to jest kwadrat prawdziwego zasiêgu
	public static final Vector2 particleGravity = new Vector2(0,-1000);
}