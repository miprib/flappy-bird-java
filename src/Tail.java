import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import enum_package.ID;
import enum_package.STATE;


public class Tail extends GameObject{
	
	public Random rand = new Random();
	private Handler handler;
	private GameObject bird;
	
	int height = 100 + rand.nextInt(200);
	int width = 30;
	int space = 125;
	
	
	public Tail(int x, int y, ID id, Handler handler){
		super(x, y, id);
		this.handler = handler;
		
		for(int i = 0; i < handler.object.size(); i++){
			if(handler.object.get(i).getID() == ID.Player){
				bird = handler.object.get(i);
			}
		}
		
		
	}


	public Rectangle getBoundsN(){
		return new Rectangle(x, y, width, height);
	}
	
	public Rectangle getBoundsS(){
		return new Rectangle(x, y + height + space, width, height + space*2);
	}
	
	
	public void tick() {
		
		x += velX;
		y += velY;
		
		float diffX = x - bird.getX() - 8;
		float diffY = y - bird.getY() - 8;
		//float distance = Math.sqrt((x - bird.getX()) * (x - bird.getX()) + (y - bird.getY()) * (y - bird.getY()));
		
		//velX = (int)((-1.0 / distance) * diffX);
		//velY = (int)((-1.0 / distance) * diffY);
		
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
	
	
}
