package com.nowytutorial.states;

import java.awt.Graphics;

import com.nowytutorial.gfx.Assets;
import com.nowytutorial.mygame.Game;
import com.nowytutorial.mygame.Handler;
import com.nowytutorial.ui.ClickListener;
import com.nowytutorial.ui.UIImageButton;
import com.nowytutorial.ui.UIManager;

public class MenuState extends State {
	
	private UIManager uiManager;
	
	public MenuState(Handler handler){
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		uiManager.addObject(new UIImageButton(200,200, 195, 76, Assets.buttonStart, new ClickListener(){

			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
				
			}}));
	}

	@Override
	public void tick() {
		//System.out.println(handler.getMouseManager().getMouseX() + "  " + handler.getMouseManager().getMouseY());
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		//g.fillRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 10, 10);
		//g.drawImage(Assets.menu, 100, 100, 195, 76, null);
		uiManager.render(g);
	}

}
