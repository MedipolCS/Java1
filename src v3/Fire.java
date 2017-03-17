import java.util.ArrayList;

public class Fire {
	public ArrayList<ArrayList<DataOfSquare>> square = new ArrayList<>();
	public int x;
	public int y;
	private int start; //It will be zero when the fire goes out of the window.
	Position position;
	private int whichPlayer;
	
	public Fire(Position position, int whichPlayer){ 
		this.start=1;	
		this.whichPlayer = whichPlayer;
		this.square = Window.panel; //Pointer
		//Giving positions to bullets for different situations.
		if(position.y > (Window.height-1)/2) this.y = position.y;
		else if(position.y < (Window.height-1)/2 ) this.y = position.y;
		this.x = position.x;
		this.position = position;
	}
	
	public void pullTheTriger(){		
		if(start==1){
			// When bullet goes to end of the limit of the window. (up)
			if( ( y<=0) && (this.position.y!=0) ){			
				this.square.get(this.y).get(this.x).ligthUp(0);
				this.start=0;
				
			}
			// When bullet goes to end of the limit of the window. (down)
			else if( (y>=Window.height-1) && (this.position.y!=Window.height-1) ){
				this.square.get(this.y).get(this.x).ligthUp(0);
				this.start=0;	
			}
			// Situation that bullet goes to north direction. 
			else if( (y==(Window.height-1)/2) && (this.position.y < (Window.height-1)/2) ){
				// EXCEPTION! When bullet hits the player2 while player2 behind the middle stick.
				if((Window.t2.position.y-1==(Window.height-1)/2 ) && (Window.t2.position.x == x) ){
					this.square.get(this.y).get(this.x).ligthUp(3);
					this.start=0;
				}
				else{
					this.square.get(this.y).get(this.x).ligthUp(3);
					this.y++;
					this.square.get(this.y).get(this.x).ligthUp(2);
				}
			}
			// Situation that bullet goes to west direction. 
			else if( (y==(Window.height-1)/2) && (this.position.y > (Window.height-1)/2) ){
				// EXCEPTION! When bullet hits the player1 while player1 behind the middle stick.
				if((Window.t1.position.y+1==(Window.height-1)/2 ) && (Window.t1.position.x == x) ){
					this.square.get(this.y).get(this.x).ligthUp(3);
					this.start=0;
				}
				else{
					this.square.get(this.y).get(this.x).ligthUp(3);
					this.y--;
					this.square.get(this.y).get(this.x).ligthUp(2);
				}
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
				
				if ((Window.t2.position.y ==y) && Window.t2.position.x == x && whichPlayer==1 ){
					Window.t1.score++;
					System.out.println("player1:\t" +
							Window.t1.score + "\nplayer2:\t" + Window.t2.score);
					Window.t2.live--;
					this.square.get(this.y-1).get(this.x).ligthUp(0);
					this.square.get(this.y).get(this.x).ligthUp(1);
					this.start=0;
					if (Window.t2.live <= 0) System.out.println("GG");
				}
				else if ((Window.t1.position.y ==y) && Window.t1.position.x == x && whichPlayer==2){
					Window.t2.score++;
					System.out.println("player1:\t" +
							Window.t1.score + "\nplayer2:\t" + Window.t2.score);
					Window.t1.live--;
					this.square.get(this.y+1).get(this.x).ligthUp(0);
					this.square.get(this.y).get(this.x).ligthUp(1);
					this.start=0;
					if (Window.t1.live <= 0) System.out.println("GG");					
				}
				
				/*if ((Window.t2.position.y ==y-1) && Window.t2.position.x == x){
					Window.t2.square.get(Window.t2.position.y).get(Window.t2.position.x).ligthUp(1);
				}
				else if ((Window.t1.position.y ==y+1) && Window.t1.position.x == x){
					Window.t1.square.get(Window.t1.position.y).get(Window.t1.position.x).ligthUp(1);				
				}*/
			}
		}
	}	
	
	
}