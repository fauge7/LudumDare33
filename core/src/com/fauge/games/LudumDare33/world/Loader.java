package com.fauge.games.LudumDare33.world;

public class Loader {
	
	public static int[][] worldid = new int[16][16];
	public Loader() {
		// TODO Auto-generated constructor stub
		// TODO Auto-generated constructor stub
			for (int x = 0; x < worldid.length; x++) {
				for (int y = 0; y < worldid[x].length; y++) {
					if((x == 6 && y >=4) || (x == 6 && y <=13)){
						worldid[x][y] = 1;
					}
					else{
						worldid[x][y] = 0;
					}
				}
			}
		
		
	}
}
