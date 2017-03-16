import java.util.ArrayList;

public class Fire {
	public ArrayList<ArrayList<DataOfSquare>> square = new ArrayList<>();
	public int x;
	public int y;
	private int start; //It will be zero when the fire goes out of the window.
	Position position;
	
	public Fire(Position position){ 
		this.start=1;
		
		this.square = Window.panel; //Pointer
		//Giving positions to bullets for different situations.
		if(position.y > (Window.height-1)/2) this.y = position.y-1;
		else if(position.y < (Window.height-1)/2 ) this.y = position.y+1;
		this.x = position.x;
		this.square.get(this.y).get(this.x).ligthUp(2);
		this.position = position;
	}
	
	public void pullTheTriger(){		
		if(start==1){
			// When bullet goes to end of the limit of the window. 
			/*if( (y<=0) || (y>=Window.height-1)){
				this.square.get(this.y).get(this.x).ligthUp(0);
				this.start=0;
			}
			//Else if would be change. 
			else if((y==(((Window.height-1)/2)) && this.position.y<((Window.height-1)/2))
					|| (y==(((Window.height-1)/2)+1) && this.position.y>((Window.height-1)/2))){
				this.square.get(this.y).get(this.x).ligthUp(3);
				if(this.position.y<((Window.height-1)/2)) this.y++;
				else if(this.position.y>0) this.y--;
				this.square.get(this.y).get(this.x).ligthUp(2);
				if(this.position.y<((Window.height-1)/2)) this.y++;
				else if(this.position.y>0) this.y--;
			}
			else {
				this.square.get(this.y).get(this.x).ligthUp(0);
				if(this.position.y<((Window.height-1)/2)) this.y++;
				else if(this.position.y>0) this.y--;
				this.square.get(this.y).get(this.x).ligthUp(2);
			}*/
			// When bullet goes to end of the limit of the window. 
			if( (y<=0) || (y>=Window.height-1)){
				this.square.get(this.y).get(this.x).ligthUp(0);
				this.start=0;
			}
			else if( (y==(Window.height-1)/2) && (this.position.y < (Window.height-1)/2) ){
				this.square.get(this.y).get(this.x).ligthUp(3);
				this.y++;
				this.square.get(this.y).get(this.x).ligthUp(2);
			}
			else if( (y==(Window.height-1)/2) && (this.position.y > (Window.height-1)/2) ){
				this.square.get(this.y).get(this.x).ligthUp(3);
				this.y--;
				this.square.get(this.y).get(this.x).ligthUp(2);
			}
			else if( (y==((Window.height-1)/2)-1) && (this.position.y < (Window.height-1)/2) ){
				this.square.get(this.y).get(this.x).ligthUp(0);
				this.y++;
			}
			else if( (y==((Window.height-1)/2)+1) && (this.position.y > (Window.height-1)/2) ){
				this.square.get(this.y).get(this.x).ligthUp(0);
				this.y--;
			}
			else{
				this.square.get(this.y).get(this.x).ligthUp(0);
				if(this.position.y<((Window.height-1)/2)) this.y++;
				else if(this.position.y>0) this.y--;
				this.square.get(this.y).get(this.x).ligthUp(2);
			}
		}
	}
	
}
