import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import enum_package.ID;
import enum_package.STATE;


public class BirdTail extends Bird{
	
	private Handler handler;
	private GameObject bird;

	
	public BirdTail(int x, int y, ID id, Handler handler){
		super(x, y, id);
		
		this.handler = handler;
		
		for(int i = 0; i < handler.object.size(); i++){
			if(handler.object.get(i).getID() == ID.Player){
				bird = handler.object.get(i);
			}
		}
	}
	
	public Rectangle getBoundsN(){
		return new Rectangle(x - 16 , y + 9, 16, 16);
	}
	
	public Rectangle getBoundsS(){
		return new Rectangle(x - 16 , y + 9, 16, 16);
	}
	
	
	
	public void tick() {
		y+= velY;
		
		int diffY = y - bird.getY();
			
		if (diffY >= 23){	//UP
			velY = bird.getVelY() * -1 / 2;
			y = bird.getY() + 23 ;
		}
			
		if( (diffY <= -25) && (diffY < 8) ){	//DOWN
			velY = bird.getVelY() * -1 / 2;
			y = bird.getY() - 25;
		}
		
		//System.out.println(diffY);
	}


	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x - 16 , y + 9, 16, 16);
	}
	
}
