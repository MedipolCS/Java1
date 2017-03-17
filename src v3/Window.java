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
	public static int height = 31; //always have to be odd number.
	public static int width = 20;  //always have to be even number.
	Random random = new Random();
	public static JButton startButton1v1;
	public static JButton startButton1vAI;
	
	// Default constructor.
	public Window(){ 
		
		panel1.setLayout(new GridLayout(height,width,0,0));
		for(int i=0;i<height;i++){
			ArrayList<DataOfSquare>data = new ArrayList<>();
			for(int j=0;j<width*2;j++){
				if(i==(height-1)/2) data.add(new DataOfSquare(3));
				else if(i<height) data.add(new DataOfSquare(0));
			}
			panel.add(data);
		}	
		
		for(int i=0;i<height;i++){
			for(int j=0;j<width;j++){
				panel1.add(panel.get(i).get(j).data);
			}
		}
		panel2.setLayout(null);
		add(panel1);
		
		
		startButton1v1 = new JButton("Start The Game 1v1");
		startButton1vAI = new JButton("Start The Game 1vAI");
		startButton1v1.setBounds(950, 300, 220, 30);
		startButton1vAI.setBounds(950, 350, 220, 30);
		panel2.add(startButton1v1);
		panel2.add(startButton1vAI);
		add(panel2);
		startButton1v1.addActionListener(new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	t1 = new ThreadController(new Position(random.nextInt(width),random.nextInt((height-1)/2)), 1);
		    	t2 = new ThreadController(new Position(random.nextInt(width),random.nextInt((height-1)/2)+((height-1)/2)+1 ), 2);
		    	ai = new AI();
		    	Window.t1.start();
		    	Window.t2.start();
		    	startButton1vAI.setVisible(false);
		    	startButton1v1.setVisible(false);
		    	panel1.setFocusable(true);
		    }
		});
		startButton1vAI.addActionListener(new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	t1 = new ThreadController(new Position(random.nextInt(width),random.nextInt((height-1)/2)), 1);
		    	t2 = new ThreadController(new Position(random.nextInt(width),random.nextInt((height-1)/2)+((height-1)/2)+1 ), 2);
		    	ai = new AI();
		    	Window.t1.start();
		    	Window.t2.start();
		    	ai.start();
		    	startButton1vAI.setVisible(false);
		    	startButton1v1.setVisible(false);
		    	panel1.setFocusable(true);
		    }
		});
		
		
		
		this.addKeyListener((KeyListener) new KeyboardListener());
	}
}
