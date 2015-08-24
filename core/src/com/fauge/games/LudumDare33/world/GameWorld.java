package com.fauge.games.LudumDare33.world;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.fauge.game.LudumDare33.Screens.GameScreen;
import com.fauge.games.LudumDare33.Characters.Enemy;
import com.fauge.games.LudumDare33.Characters.Friendly;
import com.fauge.games.LudumDare33.Characters.Player;
import com.fauge.games.LudumDare33.Entities.Bullet;
import com.fauge.games.LudumDare33.Entities.Entity;

public class GameWorld {

	ArrayList<Entity> entitylist;
	public static ArrayList<Entity> CharacterList;
	public static ArrayList<Bullet> BulletList;
	public static ArrayList<Rectangle> RectList;
	int seed;
	Generator gen;
	Loader load;
	int[][] worldid;
	static Player player;
	Friendly fnd;
	Friendly fnd2;
	Friendly fnd3;
	Enemy enmy;
	ShapeRenderer rend;
	public GameWorld(int seed) {
		// TODO Auto-generated constructor stub
		this.seed = seed;
	}
	public void InitializeWorld() {
		// TODO Auto-generated method stub
		rend = new ShapeRenderer();
		entitylist = new ArrayList<Entity>();
		CharacterList = new ArrayList<Entity>();
		BulletList = new ArrayList<Bullet>();
		RectList = new ArrayList<Rectangle>();
		if(seed < 0){
			gen = null;
			load = new Loader();
			worldid = Loader.worldid;
		}
		else{
			gen = new Generator(seed);
			load = null;
			worldid = Generator.worldid;
		}
		//iterate through the world and make all the rectangles
		for (int x = 0; x < worldid.length; x++) {
			for (int y = 0; y < worldid[x].length; y++) {
				if(worldid[x][y] == 1){
					RectList.add(new Rectangle(x*32, y*32, 32, 32));
				}
				entitylist.add(new Entity(worldid[x][y],x*32,y*32));
			}
		}
		
		fnd = new Friendly(4, MathUtils.random(1, 14)*32, MathUtils.random(1, 14)*32);
		fnd2 = new Friendly(4, MathUtils.random(1, 14)*32, MathUtils.random(1, 14)*32);
		fnd3 = new Friendly(4, MathUtils.random(1, 14)*32, MathUtils.random(1, 14)*32);
		player = new Player(5, 2*32, 2*32);
		enmy = new Enemy(6, 8*32, 8*32);
		
		CharacterList.add(player);
		CharacterList.add(enmy);
		CharacterList.add(fnd);
		CharacterList.add(fnd2);
		CharacterList.add(fnd3);
	}

	public void render(SpriteBatch batch) {
		// TODO Auto-generated method stub
		batch.setProjectionMatrix(GameScreen.view.getCamera().combined);
		
		for(Entity e : entitylist){
			e.render(batch);
		}
		
		for(Entity e : CharacterList){
			if(!e.shouldRemove)
				e.render(batch);
		}
		for (Bullet b : BulletList) {
			if(!b.shouldRemove){
				b.update();
				b.render(batch);
			}
		}
		for (Iterator<Bullet> iter = BulletList.iterator(); iter.hasNext();) {
			Bullet bullet = (Bullet) iter.next();
			if(bullet.shouldRemove){
				iter.remove();
			}
		}
		for (Iterator<Entity> iter = CharacterList.iterator(); iter.hasNext();) {
			Entity ent = (Entity) iter.next();
			if(ent.shouldRemove){
				iter.remove();
			}
		}
//		rend.begin(ShapeType.Filled);
//		rend.setColor(Color.BLACK);
//		for(Rectangle r : RectList){
//			rend.rect(r.x, r.y, r.width, r.height);
//		}
//		rend.end();
	}

	public void printWorld(){
		for (int x = 0; x < worldid.length; x++) {
			for (int y = 0; y < worldid[x].length; y++) {
				System.out.print(worldid[x][y] + " ");
			}
			System.out.println("");
		}
	}
}
