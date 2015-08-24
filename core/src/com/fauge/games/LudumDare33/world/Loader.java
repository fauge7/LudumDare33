package com.fauge.games.LudumDare33.world;

import java.io.BufferedReader;
import java.util.Scanner;

import com.badlogic.gdx.files.FileHandle;

public class Loader {
	
	public static int[][] worldid = new int[16][16];
	String[] map = new String[16];
	BufferedReader reader;
	public Loader() {
		// TODO Auto-generated constructor stub
		// TODO Auto-generated constructor stub
			FileHandle file = new FileHandle("map.txt");
			String text = file.readString();
			Scanner scan = new Scanner(text);
			System.out.println(text);
				for(int x = 0; x < 16; x++){
					for(int y = 0; y < 16; y++){
						worldid[x][y] = scan.nextInt();
					}
				}
				scan.close();
			}
			
//			for(int i = 0; i < 16; i++){
//				map[i] =
//			}
//			for (int x = 0; x < worldid.length; x++) {
//				for (int y = 0; y < worldid[x].length; y++) {
//					worldid[x][y] = map[x].charAt(y);
//				}
//			}
	
}
