package com.redartedgames.ball.objects;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.joints.DistanceJoint;
import com.badlogic.gdx.physics.box2d.joints.DistanceJointDef;

public class PhysicObject extends GameObject{
	
	private World world;
	public ArrayList<DistanceJoint> joints;
	public PhysicObject(World world, float x, float y, GameObject parent) {
		super(x, y, 0, parent);
		this.world = world;
		joints = new ArrayList<DistanceJoint>();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public PhysicSpriteObject addSprite(PhysicSpriteObject e) {
		getGameObjects().add(e);
		return (PhysicSpriteObject) getGameObjects().get(getGameObjects().size()-1);
	}
	
	public PhysicSpriteObject addSprite() {
		getGameObjects().add(new PhysicSpriteObject(world, this, 0, 0));
		return (PhysicSpriteObject) getGameObjects().get(getGameObjects().size()-1);
	}
	
	
	public void addDistanceJoint(Body bodyA, Body bodyB) {
		DistanceJointDef defJoint = new DistanceJointDef ();
		defJoint.length = (float) Math.sqrt((bodyA.getPosition().x - bodyB.getPosition().x)*(bodyA.getPosition().x - bodyB.getPosition().x) + 
				(bodyA.getPosition().y - bodyB.getPosition().y)*(bodyA.getPosition().y - bodyB.getPosition().y));
		defJoint.bodyA = bodyA;
		defJoint.bodyB = bodyB;
		joints.add((DistanceJoint) world.createJoint(defJoint));
	}
	
	
	
	public void applyForce(float vx, float vy) {
		for(int i = 0; i < getGameObjects().size(); i++) {
			if (((PhysicSpriteObject)getGameObjects().get(i)).body != null ) {
				((PhysicSpriteObject)getGameObjects().get(i)).body.applyForceToCenter(vx, vy, true);
			}
		}
	}
	

}
