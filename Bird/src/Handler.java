import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {	//Tvarkosi su sukurtais objektais

	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick(){
		for(int i = 0; i < object.size(); i++){	//Loopina pro visus zaidimo objektus
			GameObject tempObject = object.get(i);	//Gauna dabartini objekta
			
			tempObject.tick();
		}
	}

	public void render(Graphics g){
		for(int i = 0; i < object.size(); i++){	//Loopina pro visus zaidimo objektus
			GameObject tempObject = object.get(i);	//Gauna dabartinio objekto id
			
			tempObject.render(g);
		}
	}
	
	public void addObject(GameObject object){
		this.object.add(object);
	}
	
	public void removeObject(GameObject object){
		this.object.remove(object);
	}
}

