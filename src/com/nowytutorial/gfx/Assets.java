package com.nowytutorial.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage up, left, right, down, grass, rock, kamien, drzewo, menu, yplayer;
	public static BufferedImage [] buttonStart;
	
	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/newSprite.png"));
		
		buttonStart = new BufferedImage[2];
		buttonStart[0] = sheet.crop(0, 100, 195, 76);
		buttonStart[1] = sheet.crop(0, 179, 195, 76);
		up = sheet.crop(0, height, width, height);
		left = sheet.crop(2 * width, 0, width, height);
		right = sheet.crop(2 * width, 0, width, height);
		down = sheet.crop(0, height, width, height);
		grass = sheet.crop(0, 0, width, height);
		rock = sheet.crop(width, 0, width, height);
		kamien = sheet.crop(width, 0, width, height);
		drzewo = sheet.crop(width, height, width * 2, height * 2);
		menu = sheet.crop(0, 100, 195, 76);
		yplayer = sheet.crop(width * 4, 0, width, height);
	}

}
