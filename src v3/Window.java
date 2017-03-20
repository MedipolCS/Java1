import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame{
	
	private static final long serialVersionUID = 1L;
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	public static ArrayList<ArrayList<DataOfSquare>> panel = new ArrayList<ArrayList<DataOfSquare>>();;
	public static ThreadController t1;
	public static ThreadController t2;
	public static AI ai;
	public static FireController f1;
	public static FireController f2;
	public static int height = 31; //always have to be odd number.
	public static int width = 20;  //always have to be even number.
	Random random = new Random();
	
	
	public static JButton startButton1v1;
	public static JButton startButton1vAI;
	public static JButton settings;
	
	// Default constructor.
	public Window(){ 
		
		//setting panel1's layout to grind layout to set the game.
		panel1.setLayout(new GridLayout(height,width,0,0));
		
		//Adding object to 1D arrayList and putting them into 2D array.
		for(int i=0;i<height;i++){
			ArrayList<DataOfSquare>data = new ArrayList<>();
			for(int j=0;j<width*2;j++){
				if(i==(height-1)/2) data.add(new DataOfSquare(3));
				else if(i<height) data.add(new DataOfSquare(0));
			}
			panel.add(data);
		}	
		
		// Putting the 2D into the panel1.
		for(int i=0;i<height;i++){
			for(int j=0;j<width;j++){
				panel1.add(panel.get(i).get(j).data);
			}
		}
		
		//setting panel2's layout to absolute layout to design the GUI.
		panel2.setLayout(null);
		
		//Adding panel1 to the contentPane to show on the screen.
		add(panel1);
		
		//Creating buttons from JButton class.
		startButton1v1 = new JButton("Start The Game 1v1");
		startButton1vAI = new JButton("Start The Game 1vAI");
		settings = new JButton("Settings");
		
		//Setting buttons specialities.
		startButton1v1.setBounds(950, 435, 185, 30);
		startButton1vAI.setBounds(950,490, 185, 30);
		settings.setBounds(1000, 545, 85, 30);
		
		//Adding the buttons to the panel2.
		panel2.add(startButton1v1);
		panel2.add(startButton1vAI);
		panel2.add(settings);
		
		//Adding panel2 to the contentPane to show on the screen.
		add(panel2);
		
		//Starting 1v1 game.
		startButton1v1.addActionListener(new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	startOperations();
		    }
		});
		
		//Starting 1vAI game.
		startButton1vAI.addActionListener(new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	startOperations();
		    	ai = new AI();
		    	ai.start();
		    	
		    }
		});
		
		settings.addActionListener(new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	SettingsWindow.showSettings();
		    }
		});
		//Creating the keyListener object.
		this.addKeyListener((KeyListener) new KeyboardListener());
	}
	
	private void startOperations(){
		int randomX1 = random.nextInt(width);
    	int randomX2 = random.nextInt(width);
    	int randomY1 = random.nextInt((height-1)/2);
    	int randomY2 = random.nextInt((height-1)/2)+((height-1)/2)+1;
    	Position position1 = new Position(randomX1, randomY1);
    	Position position2 = new Position(randomX2, randomY2);
    	t1 = new ThreadController(position1);
    	t2 = new ThreadController(position2);
    	f1 = new FireController(position1, 1);
    	f2 = new FireController(position2, 2);
    	Window.t1.start();
    	Window.t2.start();
    	f1.start();
    	f2.start();
    	startButton1vAI.setVisible(false);
    	startButton1v1.setVisible(false);
    	settings.setVisible(false);
    	panel1.setFocusable(true);
	}
}
