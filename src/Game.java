import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import enum_package.STATE;


public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 640, HEIGHT = WIDTH/ 12*9; //Cia mazdaug 16:9 rezoliucija
	public static int score = 0;
	
	private Thread thread; //Zaidimas bus single thread;
	public static boolean running = false;
	
	private Handler handler;
	private Menu menu;

	public static STATE gameState = STATE.Menu;
	
	public Game(){
		handler = new Handler();
		menu = new Menu(this, handler);
		
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(menu);
		
		new Window (WIDTH, HEIGHT, "The bird is the word", this);
	}
	
	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop(){
		try{
			thread.join();	//Sustabdo thread
			running = false;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void run(){
		long lastTime = System.nanoTime();
		double ns = 1000000000 / 60;	//60- FPS
		double delta = 0;
		long now;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			while(delta >= 1){
				tick();
				delta--;
			}
			
			if(running){ 
				render();
			}
		}
		stop();
	}
	
	private void tick(){
		handler.tick();
		
		if(gameState == STATE.Game){
			//TODO score update HUD
		}else if((gameState == STATE.Menu) || (gameState == STATE.End)){
			menu.tick();
		}

	}
	
	private void render(){	//Isveda objekto turini
		BufferStrategy bs = this.getBufferStrategy();	//Sukuria off-screen image, kuri veliau galima ideti i langa
		
		if(bs == null){
			this.createBufferStrategy(3);	//Smoothness
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		
		g.setColor(Color.black);	//Uzpildo ekrana juodai
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		g.setColor(Color.white);	//Ground
		g.fillRect(0, HEIGHT - 50, 640, 20);
		
		handler.render(g);
		
		if(gameState == STATE.Game){
			Font font = new Font("arial", 1, 50);
			
			g.setFont(font);
			if(score == 0){
				g.setColor(Color.red);
				g.drawString("" + score, 25, 50);
			}else{
				g.setColor(Color.green);
				g.drawString("" + score, 25, 50);
			}
		}else if((gameState == STATE.Menu) || (gameState == STATE.End)){
			menu.render(g);
		}
		
		g.dispose();
		bs.show();	
	}
	
	public static void main(String args[]){
		new Game();
	}
}
