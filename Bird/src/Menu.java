import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import enum_package.ID;
import enum_package.STATE;


public class Menu extends MouseAdapter{
	
	private Game game;
	private Handler handler;
	
	public Menu(Game game, Handler handler){
		this.game = game;
		this.handler = handler;
	}
	
	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		
		if((mouseOver(mx, my, 170, 150, 300, 64)) && (game.gameState == STATE.Menu)){
			game.gameState = STATE.Game;
			
			//handler.addObject(new Ground(ID.Enemy));
			
			Bird B = new Bird(100, 200, ID.Player, handler);
			handler.addObject(B);
			
			System.out.println(B.toString());
			
			//handler.addObject(new Bird(100, 200, ID.Player, handler));
			
			//handler.addObject(new Pipe(Game.WIDTH , 0, ID.Enemy, handler));
			Pipe P = new Pipe(Game.WIDTH , 0, ID.Enemy, handler);
			handler.addObject(P);
			handler.addObject(new BirdTail(100, 200, ID.Prop, handler));
			
			System.out.println(P.toString());
			
			
		}
		
		if((mouseOver(mx, my, 170, 250, 300, 64)) && (game.gameState == STATE.Menu)){
			System.exit(1);
		}
		
		if((mouseOver(mx, my, 180, 340, 300, 64)) && (game.gameState == STATE.End)){
			Game.score = 0;
			game.gameState = STATE.Game;
			
			handler.addObject(new Bird(100, 200, ID.Player, handler));
			handler.addObject(new BirdTail(100, 200, ID.Prop, handler));
			
			handler.addObject(new Pipe(Game.WIDTH , 0, ID.Enemy, handler));
			//handler.addObject(new PipeS(Game.WIDTH , 0, ID.Enemy, handler));
		}
		
	}
	
	public void mouseReleased(MouseEvent e){
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
		if(mx > x && my < x + width){
			if(my > y && my < y + height){
				return true;
			}else return false;
		}else return false;
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g){
		if(game.gameState == STATE.Menu){
			Font font = new Font("arial", 1, 50);
			Font font2 = new Font("arial", 1, 30);
		
			g.setFont(font);
			g.setColor(Color.white);
			g.drawString("Menu", 260, 100);
		
			g.setFont(font2);
			g.setColor(Color.white);
			g.drawString("Play", 290, 195);
		
			g.setColor(Color.white);
			g.drawString("Quit", 290, 295);
		
		
			g.setColor(Color.white);	//Play
			g.drawRect(170, 150, 300, 64);
		
			g.setColor(Color.white);	//Quit
			g.drawRect(170, 250, 300, 64);
			
		}else if(game.gameState == STATE.End){
			Font font = new Font("arial", 1, 50);
			Font font2 = new Font("arial", 1, 30);
			
			g.setFont(font);
			g.setColor(Color.white);
			g.drawString("Game over!", 200, 100);
			
			g.setFont(font2);
			g.setColor(Color.white);
			g.drawString("You lost with a score of", 170, 195);
			
			g.setColor(Color.white);
			g.drawString("Try again?", 260, 380); 
			
			if(Game.score == 0){
				g.setColor(Color.red);
				g.drawString("" + Game.score, 320, 295);
			}else{
				g.setColor(Color.green);
				g.drawString("" + Game.score, 320, 295);
			}
			
			
			g.setColor(Color.white);	//Try again
			g.drawRect(180, 340, 300, 64);
		}
	}

}
