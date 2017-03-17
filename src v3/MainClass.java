import java.awt.Color;

import javax.swing.JFrame;

public class MainClass {
	public static void main(String[] args){
		
		// Setting window properties.
		/*MainMenu mainMenu = new MainMenu();
		
		mainMenu.setTitle("1V1 Multiplayer Game");
		mainMenu.setSize(400, 400);
		mainMenu.setLocationRelativeTo(null);
		mainMenu.setVisible(true);
		mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		*/
		
		Window w1 = new Window();
    	w1.setTitle("1V1 Multiplayer Game");
    	w1.setSize(1200, 1000);
    	w1.setFocusable(true);
		w1.panel1.setBounds(300, 15, 600, 930);
		w1.panel2.setSize(300,800);
		w1.panel2.setBackground(Color.BLACK);
		w1.setLocationRelativeTo(null);
		w1.setVisible(true);
		w1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
