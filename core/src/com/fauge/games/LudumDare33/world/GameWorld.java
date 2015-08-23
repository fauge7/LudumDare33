package com.fauge.games.LudumDare33.world;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.fauge.games.LudumDare33.Characters.Enemy;
import com.fauge.games.LudumDare33.Characters.Friendly;
import com.fauge.games.LudumDare33.Characters.Player;
import com.fauge.games.LudumDare33.Entities.Entity;

public class GameWorld {

	World world;
	ArrayList<Entity> entitylist;
	public static ArrayList<Entity> CharacterList;
	int seed;
	Generator gen;
	Loader load;
	int[][] worldid;
	static Player player;
	Friendly fnd;
	Enemy enmy;
	public GameWorld(int seed) {
		// TODO Auto-generated constructor stub
		this.seed = seed;
	}
	public void InitializeWorld() {
		// TODO Auto-generated method stub
		world = new World(new Vector2(0, 0), false);
		world.setContactListener(new GameContactListener());
		entitylist = new ArrayList<Entity>();
		CharacterList = new ArrayList<Entity>();
		if(seed < 0){
			gen = null;
			load = new Loader();
			worldid = Loader.worldid;
		}
		else{
//			System.out.println("generating new world with seed: " + seed);
			gen = new Generator(seed);
			load = null;
			worldid = Generator.worldid;
		}
		BodyDef bdef = new BodyDef();
		//iterate through the world and make all the box2d bodies
		for (int x = 0; x < worldid.length; x++) {
			for (int y = 0; y < worldid[x].length; y++) {
				if(worldid[x][y] == 1){
					bdef.position.set(x*8, y*8);
					FixtureDef fix = new FixtureDef();
					PolygonShape shape = new PolygonShape();
					shape.setAsBox(4, 4);
					fix.shape = shape;
					bdef.type = BodyType.StaticBody;
					world.createBody(bdef);
				}
				entitylist.add(new Entity(worldid[x][y],x*32,y*32));
			}
		}
		player = new Player(5, 2*32, 2*32);
		enmy = new Enemy(6, 8*32, 8*32);
		fnd = new Friendly(4, 4*32, 8*32);
		CharacterList.add(player);
		CharacterList.add(enmy);
		CharacterList.add(fnd);
	}

	public void render(SpriteBatch batch) {
		// TODO Auto-generated method stub
		for(Entity e : entitylist){
			e.render(batch);
		}
		player.render(batch);
		enmy.render(batch);
		fnd.render(batch);
		if(Gdx.input.justTouched()){
			worldid = Generator.getNewWorld();
			entitylist.clear();
			for (int x = 0; x < worldid.length; x++) {
				for (int y = 0; y < worldid[x].length; y++) {
					entitylist.add(new Entity(worldid[x][y],x*32,y*32));
				}
			}
		}
	}

	public void step() {
		// TODO Auto-generated method stub
		world.step(1/40f, 10, 5);
		
	}
	public void printWorld(){
		/*for (int x = 0; x < worldid.length; x++) {
			for (int y = 0; y < worldid[x].length; y++) {
				System.out.print(worldid[x][y] + " ");
			}
			System.out.println("");
		}*/
	}
}
