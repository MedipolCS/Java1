import java.util.ArrayList;

public class ThreadController extends Thread {
	
	public ArrayList<ArrayList<DataOfSquare>> square;
	ArrayList<Fire> fire = new ArrayList<>(); 
	Position position;
	private int gameSpeed = 50;
	public int movementInput=0; //1-rigth 2-left 3-up 4-down
	private int fireCount=0;
	
	public ThreadController(Position position){
		square = Window.panel;
		this.position = position;
		spawnPoint(position);
	}
	
	@Override
	public void run() {
		while(true){
			movePlayer(position);
			moveFire(fire);
			pauser();
			//System.out.println("Player - > x: " + position.x + " y: " + position.y);
		}
	}
	
	private void moveFire(ArrayList<Fire> fire) {
		for(int i=0;i<fireCount;i++){
			fire.get(i).pullTheTriger();
		}
	}

	private void pauser() {
		try {
			sleep(gameSpeed);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void movePlayer(Position position){
		if(collisionDetection(position)){
			//For Player 1
			if(movementInput==1 ){
				square.get(position.y).get(position.x).ligthUp(0);
				position.x+=1;
				square.get(position.y).get(position.x).ligthUp(1);
			}
			else if(movementInput==2 ){
				square.get(position.y).get(position.x).ligthUp(0);
				position.x-=1;
				square.get(position.y).get(position.x).ligthUp(1);
			}
			else if(movementInput==3 ){
				square.get(position.y).get(position.x).ligthUp(0);
				position.y-=1;
				square.get(position.y).get(position.x).ligthUp(1);
			}
			else if(movementInput==4 ){
				square.get(position.y).get(position.x).ligthUp(0);
				position.y+=1;
				square.get(position.y).get(position.x).ligthUp(1);
			}
			else if(movementInput==5 ){
				movementInput=0;
				fire.add(new Fire(position));
				fireCount++;
			}
		}
	}
	
	private boolean collisionDetection(Position position){
		if(position.y == 0 && movementInput==3) return false;
		else if(position.y == (Window.height-1) && movementInput==4) return false;
		else if(position.x == 0 && movementInput==2) return false;
		else if(position.x == (Window.width-1) && movementInput==1) return false;
		else if((position.y == ((Window.height-3)/2) && movementInput==4) 
				|| (position.y == ((Window.height+1)/2) && movementInput==3)) return false;
		else return true;
	}
	
	public void spawnPoint(Position position){
		square.get(position.y).get(position.x).ligthUp(1);
	}	
}
