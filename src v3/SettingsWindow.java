import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SettingsWindow extends JPanel
					implements ActionListener{
	
	public SettingsWindow(){
		super(new BorderLayout());
		String[] resolutionArray = {"1000x1200", "700x840"};
		
		JComboBox<String> ResoulutionChoicer = new JComboBox<>(resolutionArray);
		ResoulutionChoicer.setSelectedIndex(0);
		ResoulutionChoicer.addActionListener(this);
		ResoulutionChoicer.setPreferredSize(new Dimension(10,60));
		ResoulutionChoicer.setBorder(BorderFactory.createTitledBorder("Resolution"));
		//ResoulutionChoicer.setMaximumSize(new Dimension(150,50));
		JLabel banner = new JLabel("secenek1");
		banner.setForeground(Color.black);
		banner.setOpaque(true);
		banner.setFont(new Font("SansSerif", Font.BOLD, 30));

		JLabel banner2 = new JLabel("secenek2");
		banner2.setForeground(Color.black);
		banner2.setOpaque(true);
		banner2.setFont(new Font("SansSerif", Font.BOLD, 30));
		/*JPanel panel1 = new JPanel(new BorderLayout());
		panel1.add(ResoulutionChoicer, BorderLayout.NORTH);
		panel1.setBorder(BorderFactory.createTitledBorder("Banner"));
		panel1.setPreferredSize(new Dimension(110,60));
		add(panel1);
		*/
		add(ResoulutionChoicer, BorderLayout.NORTH);
		
		add(banner, BorderLayout.CENTER);
		add(banner2, BorderLayout.SOUTH);
		/*JPanel bannerPanel1 = new JPanel(new BorderLayout());
		bannerPanel1.add(ResoulutionChoicer, BorderLayout.CENTER);*/
		
		setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
	}
	
	
	
	
	private static void createAndShowGUI(){
		JFrame frame = new JFrame("Settings");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JComponent newContentPane = new SettingsWindow();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
        
        frame.setLocationRelativeTo(null);       
		frame.pack();
		frame.setSize(300,300);
		frame.setVisible(true);
	}
	
	public static void showSettings(){
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox<String> cb = (JComboBox<String>)e.getSource();
		String selectedResolution = (String)cb.getSelectedItem();
		updateResolution(selectedResolution);
	}

	private void updateResolution(String selectedResolution) { 
        String[] resolution = selectedResolution.split("x");
        int height = Integer.parseInt(resolution[0]);
        int width =  Integer.parseInt(resolution[1]); 
        System.out.println("Resolution change to "+" w: " + width + " h: " + height);
        MainClass.w1.setSize(width, height);
        if(width==840){
        	MainClass.w1.panel1.setBounds((150/10)*7, (15/10)*7, (600/10)*7, (930/10)*7);
        	Window.startButton1v1.setBounds((950/10)*7, (435/10)*7, (185/10)*7, (30/10)*7);
        	Window.startButton1vAI.setBounds((950/10)*7, (490/10)*7, (185/10)*7, (30/10)*7);
        	Window.settings.setBounds((1000/10)*7, (545/10)*7, (85/10)*7, (30/10)*7);
        }
	}
}
