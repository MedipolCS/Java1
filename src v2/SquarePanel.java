import java.awt.Color;

import javax.swing.JPanel;

public class SquarePanel extends JPanel{
	private static final long serialVersionUID = 1L;

	public SquarePanel(Color color){
		this.setBackground(color);
	}

	public void ChangeColor(Color color) {
		this.setBackground(color);
		this.repaint();
		
	}
}
