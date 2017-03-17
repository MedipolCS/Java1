import javax.swing.JFrame;

public class MainClass {
	public static void main(String[] args){
		
		Window w1 = new Window();
		
		// Setting window properties.
		w1.setTitle("Tetris Game");
		w1.setSize(600, 800);
		w1.setVisible(true);
		w1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
