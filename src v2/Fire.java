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
		if(position.y > (Window.height-1)/2) this.y = position.y;
		else if(position.y < (Window.height-1)/2 ) this.y = position.y;
		this.x = position.x;
		this.position = position;
	}
	
	public void pullTheTriger(){		
		if(start==1){
			// When bullet goes to end of the limit of the window. 
			if( ( y<=0) && (this.position.y!=0) ){
				
				this.square.get(this.y).get(this.x).ligthUp(0);
				this.start=0;
				
			}
			else if( (y>=Window.height-1) && (this.position.y!=Window.height-1) ){
				
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
				
				if(this.position.y != y)
					this.square.get(this.y).get(this.x).ligthUp(0);
				this.y++;
				
			}
			else if( (y==((Window.height-1)/2)+1) && (this.position.y > (Window.height-1)/2) ){
				
				if(this.position.y != y)
					this.square.get(this.y).get(this.x).ligthUp(0);
				this.y--;
			}
			else{
				
				if(this.position.y != y)
					this.square.get(this.y).get(this.x).ligthUp(0);
				if(this.position.y<((Window.height-1)/2)) this.y++;
				else if(this.position.y>0) this.y--;
				this.square.get(this.y).get(this.x).ligthUp(2);
				
				if ((Window.t2.position.y ==y || Window.t2.position.y == y-1) && Window.t2.position.x == x){
					Window.t1.score++;
					System.out.println("player1:\t" +
							Window.t1.score + "\nplayer2:\t" + Window.t2.score);
				}
				else if ((Window.t1.position.y ==y || Window.t1.position.y == y+1) && Window.t1.position.x == x){
					Window.t2.score++;
					System.out.println("player1:\t" +
							Window.t1.score + "\nplayer2:\t" + Window.t2.score);
				}
			}
		}
	}
	
}
