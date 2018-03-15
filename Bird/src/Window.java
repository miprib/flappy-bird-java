import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Window extends Canvas{

	private static final long serialVersionUID = 1L;

	public Window(int width, int height, String title, Game game){
		JFrame frame = new JFrame(title);	//Sukuria nauja langa
		
		frame.setPreferredSize(new Dimension(width, height));	//Nustato lango dydi
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Kaip X virsuj
		frame.setResizable(false);	//Negalima keisti dydzio
		frame.setLocationRelativeTo(null);	//Langas atsiranda ekrano vidury
		frame.add(game);	//Ideda Game class i langa
		frame.setVisible(true);	//Padaro, kad matytusi langas
		game.start();	//Paleidzia start metoda
	}

}
