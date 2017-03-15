import java.awt.Color;
import java.util.ArrayList;

public class DataOfSquare {
	ArrayList<Color> C = new ArrayList<>();
	int color;
	SquarePanel data;
	
	public DataOfSquare(int color){
		C.add(Color.WHITE); // 0-threads
		C.add(Color.BLUE);
		C.add(Color.RED);
		C.add(Color.BLACK);
		this.color = color;
		data = new SquarePanel(C.get(color));
	}
	
	public void ligthUp(int c){
		data.ChangeColor(C.get(c));
	}
}
