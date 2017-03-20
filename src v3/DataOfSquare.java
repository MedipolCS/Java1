import java.awt.Color;
import java.util.ArrayList;

public class DataOfSquare {
	ArrayList<Color> C = new ArrayList<>();
	int color;
	SquarePanel data;
	
	public DataOfSquare(int color){
		C.add(Color.WHITE); // 0 - Background.
		C.add(Color.BLUE);	// 1 - Players.
		C.add(Color.RED);	// 2 - Fire's color.
		C.add(Color.BLACK); // 3 - Middle stick's color.
		this.color = color; 
		
		//Sending the arrayList's element to the SquarePanel's constructor.
		data = new SquarePanel(C.get(color)); 
	}
	
	//We're using this method to change a block's color.
	public void ligthUp(int c){
		data.ChangeColor(C.get(c));
	}
}
