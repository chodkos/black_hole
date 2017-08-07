package com.nowytutorial.mygame;

import com.nowytutorial.gfx.GameCamera;
import com.nowytutorial.input.KeyManager;
import com.nowytutorial.input.MouseManager;
import com.nowytutorial.worlds.World;

public class Handler {

	private Game game;
	private World world;
	
	public Handler(Game game){
		this.game = game;
	}
	
	public GameCamera getGameCamera(){
		return game.getGameCamera();
	}
	
	public KeyManager getKeyManager(){
		return game.getKeyManager();
	}
	
	public MouseManager getMouseManager(){
		return game.getMouseManager();
	}
	
	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public int getWidth(){
		return game.getWidth();
	}
	
	public int getHeight(){
		return game.getHeight();
	}
	
	public Game getGame(){
		return game;
	}
}
