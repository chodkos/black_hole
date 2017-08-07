package com.nowytutorial.states;

import java.awt.Graphics;

import com.nowytutorial.entities.creatures.Player;
import com.nowytutorial.entities.statics.Tree;
import com.nowytutorial.mygame.Game;
import com.nowytutorial.mygame.Handler;
import com.nowytutorial.tiles.Tile;
import com.nowytutorial.worlds.World;

public class GameState extends State {
	
	
	private World world;
	
	
	public GameState(Handler handler){
		super(handler);
		
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
		
		
		
		
		handler.getGameCamera().move(0, 0);
	}
	
	public void tick() {
		world.tick();
		
		
		
	}

	
	public void render(Graphics g) {
		world.render(g);
		
		
		//Tile.tiles[2].render(g, 0, 0);
		
	}

}
