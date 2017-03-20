import java.awt.Color;

import javax.swing.JFrame;

public class MainClass {
	
	private static int WindowHeight=1000;
	private static int WindowWidth=1200;
	public static Window w1;
	
	public static void main(String[] args){

		w1 = new Window();
    	w1.setTitle("1V1 Multiplayer Game");
    	w1.setSize(WindowWidth, WindowHeight);
    	/*w1.setExtendedState(JFrame.MAXIMIZED_BOTH); 
    	w1.setUndecorated(true);*/
    	w1.setResizable(false);
    	w1.setFocusable(true);
		w1.panel1.setBounds(150, 15, 600, 930);
		w1.panel2.setBackground(Color.BLACK);
		w1.setLocationRelativeTo(null);
		w1.setVisible(true);
		w1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
