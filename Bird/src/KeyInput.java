import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import enum_package.ID;


public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	
	public KeyInput(Handler handler){
		this.handler = handler;
	
	}

	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.Player){
				//Viskas Bird
				if(key == KeyEvent.VK_SPACE) {
					tempObject.setVelY(-12);
				}
			}
		}
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.Player){
				//Viskas Bird
				if(key == KeyEvent.VK_SPACE){
					tempObject.setVelY(5);
				}
			}
		}
	}
}
