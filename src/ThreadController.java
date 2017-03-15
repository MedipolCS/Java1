import java.util.ArrayList;

public class ThreadController extends Thread {
	
	public ArrayList<ArrayList<DataOfSquare>> square;
	ArrayList<Fire> fire = new ArrayList<>(); 
	Position positionP1;
	Position positionP2;
	int gameSpeed = 50;
	public static int movementInput=0;
	public static int movementInput2=0;	//1-rigth 2-left 3-up 4-down
	public static int fireCount=0;
	
	public ThreadController(Position positionP1, Position positionP2){
		square = Window.panel;
		this.positionP1 = positionP1;
		this.positionP2 = positionP2;
		spawnPoint(positionP1);
		spawnPoint(positionP2);
	}
	
	@Override
	public void run() {
		while(true){
			movePlayer1(positionP1, movementInput);
			movePlayer2(positionP2, movementInput2);
			moveFire(fire);
			pauser();
			System.out.println("Player 1 - > x: " + positionP1.x + " y: " + positionP1.y);
		    System.out.println("Player 2 - > x: " + positionP2.x + " y: " + positionP2.y);
		}
	
	}
	
	private void moveFire(ArrayList<Fire> fire2) {
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
	
	private void movePlayer1(Position position, int input){
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
	
	private void movePlayer2(Position position, int input){
		if(collisionDetection(position)){
			//For Player 2
			if(movementInput2==1 ){
				square.get(position.y).get(position.x).ligthUp(0);
				position.x+=1;
				System.out.println(position.x);
				square.get(position.y).get(position.x).ligthUp(1);
			}
			else if(movementInput2==2 ){
				square.get(position.y).get(position.x).ligthUp(0);
				position.x-=1;
				square.get(position.y).get(position.x).ligthUp(1);
			}
			else if( movementInput2==3 ){
				square.get(position.y).get(position.x).ligthUp(0);
				position.y-=1;
				square.get(position.y).get(position.x).ligthUp(1);
			}
			else if(movementInput2==4 ){
				square.get(position.y).get(position.x).ligthUp(0);
				position.y+=1;
				square.get(position.y).get(position.x).ligthUp(1);
			}
			else if(movementInput2==5 ){
				movementInput2=0;
				fire.add(new Fire(position));			
				fireCount++;
			}
		}
	}
	
	private boolean collisionDetection(Position position){
		if(position.y == 0 && (movementInput==3 || movementInput2==3)) return false;
		else if(position.y == (Window.height-1) && (movementInput==4 || movementInput2==4)) return false;
		else if(position.x == 0 && (movementInput==2 || movementInput2==2)) return false;
		else if(position.x == (Window.width-1) && (movementInput==1 || movementInput2==1)) return false;
		else if((position.y == ((Window.height-3)/2) && (movementInput==4 || movementInput2==4)) 
				|| (position.y == ((Window.height+1)/2) && (movementInput==3 || movementInput2==3))) return false;
		else return true;
	}
	
	public void spawnPoint(Position position){
		square.get(position.y).get(position.x).ligthUp(1);
	}
	
}
