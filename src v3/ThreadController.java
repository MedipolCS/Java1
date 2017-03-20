import java.util.ArrayList;

public class ThreadController extends Thread {
	
	public ArrayList<ArrayList<DataOfSquare>> square;
	Position position;
	private int gameSpeed = 50;
	public int movementInput=0; //1-rigth 2-left 3-up 4-down
	public int score;
	public int live;	
	public boolean gameLoop;
	
	
	public ThreadController(Position position){
		this.gameLoop=true;
		this.live=3;
		this.score=0;
		square = Window.panel;
		this.position = position;
		square.get(position.y).get(position.x).ligthUp(1);
	}
	
	@Override
	public void run() {
		while(gameLoop){
			movePlayer(position);
			pauser();
			if(live==0){
				gameFinished();
				Window.t1.gameLoop=false;
				Window.t2.gameLoop=false;
			}
		}
	}
	
	private void pauser() {
		try {
			sleep(gameSpeed);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//fire.get .....
	private void movePlayer(Position position){
		if(collisionDetection(position)){
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
	
	private void gameFinished(){
		for(int i=0;i<Window.width;i++){
			for(int j=0;j<Window.height;j++){
				if(j!=(Window.height-1)/2) this.square.get(j).get(i).ligthUp(0);
			}
		}
		Window.t1.gameLoop=false;
		Window.t2.gameLoop=false;
		Window.ai.aiLoop=false;
		Window.startButton1v1.setVisible(true);
		Window.startButton1vAI.setVisible(true);
		Window.settings.setVisible(true);
	}
}
