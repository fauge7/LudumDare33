package com.fauge.games.LudumDare33.Entities;

public class Grenade extends Entity{

	static float speed;
	float fireAngle;
	float dx,dy;
	public Grenade(int id,float startX, float startY,float angle) {
		super(id,startX,startY);
		// TODO Auto-generated constructor stub
		this.ID = id;
		this.x = startX;
		this.y = startY;
		
		
		
	}
	public void update(){
		
	}

}
