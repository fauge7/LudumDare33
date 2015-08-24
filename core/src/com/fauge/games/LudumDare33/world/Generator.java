package com.fauge.games.LudumDare33.world;

import com.badlogic.gdx.math.MathUtils;

public class Generator {

	public static int[][] worldid = new int[16][16];
	
	public Generator(int seed) {
		// TODO Auto-generated constructor stub
		if(seed == 0){
			for (int y = 0; y < worldid.length; y++) {
				for (int x = 0; x < worldid[0].length; x++) {
					if(x == 6 && y >= 3){
						if(x == 6 &&  y <13){
						worldid[x][y] = 1;
						}
						else{
						worldid[x][y] = worldid[x][y] = MathUtils.random(2, 3);
						}
					}
					else{
						worldid[x][y] = MathUtils.random(2, 3);
						if(worldid[x][y] == 2){
							if(MathUtils.randomBoolean()){
								worldid[x][y] = 0;
							}
						}
					}
				}
			}
		}
	}
}
