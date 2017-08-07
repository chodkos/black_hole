package com.nowytutorial.entities.statics;

import java.awt.Graphics;

import com.nowytutorial.gfx.Assets;
import com.nowytutorial.mygame.Handler;
import com.nowytutorial.tiles.Tile;

public class Tree extends StaticEntity {

	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH * 2, Tile.TILEHEIGHT * 2);
		
		bounds.x = 32;
		bounds.y = 32;
		bounds.width = 64;
		bounds.height = 64;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.drzewo,(int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
	}

}
