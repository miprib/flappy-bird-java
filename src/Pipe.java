import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import enum_package.ID;
import enum_package.STATE;


public class Pipe extends GameObject{
	
	public Random rand = new Random();
	private Handler handler;
	
	int height = 100 + rand.nextInt(200);
	int width = 60;
	int space = 125;
	
	
	public Pipe(int x, int y, ID id, Handler handler){
		super(x, y, id);
	
		setVelX(6);
		
		this.handler = handler;
	}
	
	public Pipe(ID id){
		this.id = id;
	}
	
	public Rectangle getBoundsN(){
		return new Rectangle(x, y, width, height);
	}
	
	public Rectangle getBoundsS(){
		return new Rectangle(x, y + height + space, width, height + space*2);
	}
	
	
	public void tick() {
		
		x-= velX;
		
		if((x == 10) && (Game.gameState == STATE.Game)){
			handler.removeObject(this);
			
			Game.score++;
			
			handler.addObject(new Pipe(Game.WIDTH , 0, ID.Enemy, handler));
		}
		
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, width, height);
		g.fillRect(x, y + height + space, width, height + space*2);
	}
	
	public String toString(){
		return y + " ";
	}
	
	
}
