import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import enum_package.ID;


public class Ground extends Pipe{
	
	int height = 20;
	int width = 640;
	
	public Ground(ID id){
		super(id);
	}
	
	public Rectangle getBoundsN(){
		return new Rectangle(0, Game.HEIGHT - 50, width, height);
	}
	
	public Rectangle getBoundsS(){
		return new Rectangle(0, Game.HEIGHT - 50, width, height);
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, Game.HEIGHT - 50, width, height);
	}
}
