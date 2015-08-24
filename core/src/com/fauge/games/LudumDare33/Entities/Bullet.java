package com.fauge.games.LudumDare33.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.fauge.games.LudumDare33.world.GameWorld;


public class Bullet extends Entity{

	static float speed = 900;
	public float fireAngle;
	public float dx,dy;
	float startTime = 0;
	static float endTime = .75f;
	public Bullet(int id,float startX, float startY,float angle) {
		super(id,startX,startY);
		// TODO Auto-generated constructor stub
		this.ID = id;
		this.x = startX;
		this.y = startY;
		this.fireAngle = angle;
		this.health = 1;
		spr.setRotation(90+fireAngle);
		dx = Gdx.graphics.getDeltaTime() * speed * MathUtils.cosDeg(fireAngle);
		dy = Gdx.graphics.getDeltaTime() * speed * MathUtils.sinDeg(fireAngle);
	}
	public void update(){
		dx = Gdx.graphics.getDeltaTime() * speed * MathUtils.cosDeg(fireAngle);
		dy = Gdx.graphics.getDeltaTime() * speed * MathUtils.sinDeg(fireAngle);
		startTime += Gdx.graphics.getDeltaTime();
		if(startTime > endTime){
			shouldRemove = true;
		}
		for(Entity e : GameWorld.CharacterList){
			if(e.ID == 5)
				continue;
			if(spr.getBoundingRectangle().overlaps(e.getBoundingRectangle()) && !e.shouldRemove){
				e.health-=5;
				if(e.health < 5)
					e.shouldRemove = true;
				shouldRemove = true;
			}
		}
		for(Rectangle r : GameWorld.RectList){
			if(spr.getBoundingRectangle().overlaps(r)){
				shouldRemove = true;
			}
		}
		if(!shouldRemove){
			x += dx;
			y += dy;
		}
	}

}
