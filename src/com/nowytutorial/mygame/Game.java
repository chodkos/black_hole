package com.nowytutorial.mygame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import com.nowytutorial.display.Display;
import com.nowytutorial.gfx.Assets;
import com.nowytutorial.gfx.GameCamera;
import com.nowytutorial.gfx.ImageLoader;
import com.nowytutorial.gfx.SpriteSheet;
import com.nowytutorial.input.KeyManager;
import com.nowytutorial.input.MouseManager;
import com.nowytutorial.states.GameState;
import com.nowytutorial.states.MenuState;
import com.nowytutorial.states.State;
import com.nowytutorial.tiles.Tile;

public class Game implements Runnable {
	
//	private int fit = 52;
	
	private Display display;
	
	private Thread thread;
	private BufferStrategy bs;
	private Graphics g;
	
	public State gameState;
	public State menuState;
	
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
	private GameCamera gameCamera;
	
	private Handler handler;
	
	private int width, height;
	public String title;
	private boolean running = false;
	
	private BufferedImage testImage;
	private BufferedImage testsprit;
	
	private SpriteSheet sheet;
	
	private void init(){
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
	//	testImage = ImageLoader.loadImage("/textures/player.jpg");
		Assets.init();
		
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0,0);	
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		State.setState(menuState);
		
	}
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
		
		
		
	}
	
	private void tick(){
		keyManager.tick();
		if(State.getState() != null)
			State.getState().tick();
		
	}
	
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
			if(bs == null)
				{
					display.getCanvas().createBufferStrategy(3);
					return;
				}
			g = bs.getDrawGraphics();
			g.clearRect(0, 0, width, height);
			
			if(State.getState() != null)
				State.getState().render(g);
			
			
		/*
			g.drawImage(Assets.up, 0, 100, null);
			g.drawImage(Assets.up, fit, 100, null);
			g.drawImage(Assets.up, fit * 2, 100, null);
			g.drawImage(Assets.up, fit * 3, 100, null);
			g.drawImage(Assets.up, fit * 4, 100, null);
			
			g.drawImage(Assets.left, 0, 100 + fit, null);
			g.drawImage(Assets.left, 0, 100 + 2*fit, null);
			g.drawImage(Assets.left, 0, 100 + 3 * fit, null);
	*/
			
		//	testowe obrazki
		//	g.drawImage(testImage, 100, 90, null);	
		//	g.drawImage(testsprit, 300, 300, null);
			
			
		
			bs.show();
			g.dispose();
	}
	
	
	
	public void run(){
		
		int fps = 60;
		double timePerTick = 1000000000 / 60;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		init();
		
		while(running)
		{
			now = System.nanoTime();
			delta += (now-lastTime)/timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1)
			{
				
			
			tick();
			render();
			ticks ++;
			delta --;
			}
			
			if(timer >= 1000000000)
			{
				System.out.println("FPS: " + ticks);
				ticks = 0;
				timer = 0;
			}
			
		}
		stop();
		
	}
	public KeyManager getKeyManager(){
		return keyManager;
	}
	
	public MouseManager getMouseManager(){
		return mouseManager;
	}
	
	public GameCamera getGameCamera(){
		return gameCamera;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	
	public synchronized void stop(){
		if(!running)
			return;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
