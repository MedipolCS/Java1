import java.awt.GridLayout;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;

public class Window extends JFrame{
	
	private static final long serialVersionUID = 1L;
	public static ArrayList<ArrayList<DataOfSquare>> panel = new ArrayList<ArrayList<DataOfSquare>>();;
	public static ThreadController t1;
	public static ThreadController t2;
	public static AI ai;
	public static int height = 31; //always have to be odd number.
	public static int width = 20;  //always have to be even number.
	Random random = new Random();
	// Default constructor.
	public Window(){ 
		
		for(int i=0;i<height;i++){
			ArrayList<DataOfSquare>data = new ArrayList<>();
			for(int j=0;j<width;j++){
				if(i==(height-1)/2) data.add(new DataOfSquare(3));
				else data.add(new DataOfSquare(0));
			}
			panel.add(data);
		}
		
		getContentPane().setLayout(new GridLayout(height,width,0,0));
		
		for(int i=0;i<height;i++){
			for(int j=0;j<width;j++){
				getContentPane().add(panel.get(i).get(j).data);
			}
		}
		
		
		t1 = new ThreadController(new Position(random.nextInt(width),random.nextInt((height-1)/2)));
		t2 = new ThreadController(new Position(random.nextInt(width),random.nextInt((height-1)/2)+((height-1)/2)+1 ));
		ai = new AI();
		t1.start();
		t2.start();
		ai.start();
		this.addKeyListener((KeyListener) new KeyboardListener());
	}
}
