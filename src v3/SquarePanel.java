import java.awt.Color;

import javax.swing.JPanel;

public class SquarePanel extends JPanel{
	
	private static final long serialVersionUID = 1L;

	public SquarePanel(Color color){
		//Setting background from the information coming from the DataOfSquare object.
		this.setBackground(color);
	}
	
	//Changing  the color as you guess :)
	public void ChangeColor(Color color) {
		this.setBackground(color);
		this.repaint();
	}
}
