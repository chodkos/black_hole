package com.nowytutorial.entities.creatures;

import java.awt.Graphics;

import com.nowytutorial.gfx.Assets;
import com.nowytutorial.mygame.Game;
import com.nowytutorial.mygame.Handler;

public class Player extends Creature {
	
	

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		bounds.y = 20;
		bounds.x = 20;
		bounds.width = 15;
		bounds.height = 15;
	}

	@Override
	public void tick() {
		getInput();
		move();
		handler.getGameCamera().centreOnEntity(this);
	}
	
		private void getInput(){
			xMove = 0;
			yMove = 0;
			
			if(handler.getKeyManager().up)
				yMove = -speed;
			if(handler.getKeyManager().down)
				yMove = speed;
			if(handler.getKeyManager().left)
				xMove = - speed;
			if(handler.getKeyManager().right)
				xMove = speed;
		}
		
		
		
		
	/*	
		if(game.getKeyManager().up)
			y -= 3;
		if(game.getKeyManager().down)
			y += 3;
		if(game.getKeyManager().left)
			x -= 3;
		if(game.getKeyManager().right)
			x += 3;
	*/
	

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.yplayer,(int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), 
					(int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
		
	}
	
	

}
