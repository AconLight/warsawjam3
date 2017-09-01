package com.redartedgames.ball.screen;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.joints.DistanceJointDef;
import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.PhysicSpriteObject;
import com.redartedgames.ball.settings.GameVars;

public class MyWorld {

	protected ArrayList<GameObject> gameObjects;
	private World physicWorld;
	
	public MyWorld() {
		gameObjects = new ArrayList<GameObject>();
		physicWorld = new World(new Vector2(0, 0), true); 
	}
	
	public void update(float delta) {
		for (int i = 0; i < gameObjects.size(); i++) {
			gameObjects.get(i).updateBefore(delta, 0, 0);
		}
		physicWorld.step(delta, 1, 1);
		for (int i = 0; i < gameObjects.size(); i++) {
			gameObjects.get(i).applyPhysicsToAcceleration();
		}
		for (int i = 0; i < gameObjects.size(); i++) {
			gameObjects.get(i).updateAfter(delta, 0, 0);
		}
		for (int i = 0; i < gameObjects.size(); i++) {
			gameObjects.get(i).updateLast(delta, 0, 0);
		}
	}
	
	
	
	public void addDistanceJoint(DistanceJointDef jointDef, Body bodyA, Body bodyB) {
		DistanceJointDef defJoint = new DistanceJointDef ();
		defJoint.length = (float) Math.sqrt((bodyA.getPosition().x - bodyB.getPosition().x)*(bodyA.getPosition().x - bodyB.getPosition().x) + 
				(bodyA.getPosition().y - bodyB.getPosition().y)*(bodyA.getPosition().y - bodyB.getPosition().y));
		defJoint.bodyA = bodyA;
		defJoint.bodyB = bodyB;
		physicWorld.createJoint(defJoint);
	}
	
	public ArrayList<GameObject> getGameObjects() {
		return gameObjects;
	}
	
	protected void addGameObject(GameObject obj) {
		gameObjects.add(obj);

	}
	
	
	
	
	protected void addPhysicGameObject(GameObject obj) {
		gameObjects.add(obj);
		
	}
	
	
}
