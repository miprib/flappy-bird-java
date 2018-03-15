import java.awt.Graphics;
import java.awt.Rectangle;

import enum_package.ID;


public abstract class GameObject{	//Visi objektai bus GameObject

	protected int x, y;	//Gali buti pasiekiamas tik to objekto kuris paveldes GameObject
	protected ID id;
	protected int velX, velY;	//Greitis
	
	public GameObject(int x, int y, ID id){
		setX(x);
		this.y = y;
		this.id = id;
	}
	
	public GameObject(){
		
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBoundsN();
	public abstract Rectangle getBoundsS();
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setVelX(int velX){
		this.velX = velX;
	}
	
	public void setVelY(int velY){
		this.velY = velY;
	}
	
	public int getVelX(){
		return velX;
	}
	
	public int getVelY(){
		return velY;
	}
	
	public void setID(ID id){
		this.id = id;
	}
	
	public ID getID(){
		return id;
	}
}

