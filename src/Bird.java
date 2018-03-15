import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import enum_package.ID;
import enum_package.STATE;


public class Bird extends GameObject{
	
	private Handler handler;
	private Pipe pipe;
	
	public Bird(int x, int y, ID id, Handler handler){
		super(x, y, id);	//super();
		super.setVelY(5);	//Super metodas
		
		this.handler = handler;
	}
	
	public Bird(int x, int y, ID id){
		super(x, y, id);	
	}
	
	public Rectangle getBoundsN(){
		return new Rectangle(x, y, 32, 32);
	}
	
	public Rectangle getBoundsS(){
		return new Rectangle(x, y, 32, 32);
	}
	
	//public Bird(){
	//	this(0, 0);
	//}
	

	public void tick() {
		y+= velY;
		
		/*if( (x > Game.WIDTH -32) || (x < 0) ){
			velX = 0; 
		}*/
		
		if(y > Game.HEIGHT - 70){
			y = Game.HEIGHT - 70;
			Game.gameState = STATE.End;
			
			Pipe P = new Pipe(100 , y, ID.Enemy, handler);
			handler.addObject(P);
		}
		
		if(y < 0){
			y = 0;
		}
		
		//println(x, y);
		
		//println(x);
		
		collision();
	}
	
	private void collision(){
		
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject= handler.object.get(i);
			 
			if(tempObject.getID() == ID.Enemy){
				if((getBoundsN().intersects(tempObject.getBoundsN())) || (getBoundsN().intersects(tempObject.getBoundsS()))){
					//Kolizija
					
					handler.removeObject(this);
					
					for(int j = 0; j < handler.object.size(); j++){
						GameObject tempObject2 = handler.object.get(j);
				
						if(tempObject2.getID() == ID.Prop){
							//handler.removeObject(tempObject2);
							tempObject2.setX(-100);
						}
						
						if(tempObject2.getID() == ID.Enemy){
							tempObject2.setX(-100);
						}
					}
					
					try {
					    Thread.sleep(500);
					} catch(InterruptedException ex) {
					    Thread.currentThread().interrupt();
					}
					
					Game.gameState = STATE.End; 
				}
			}
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
	}
	
	private void println(int x, int y){
		System.out.println("x=" + x + " ");
		System.out.println("y=" + y + "\n");
		
	}
	
	private void println(int x){
		System.out.println("x=" + x + "\n");
	}
	
	public String toString(){
		return this.x + " ";
	}
}
