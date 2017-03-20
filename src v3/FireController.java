import java.util.ArrayList;

public class FireController extends Thread {
	ArrayList<Fire> fire = new ArrayList<>(); 
	Position position;
	private int whichPlayer;
	public boolean fireInput = false;
	public int fireCount=0;
	
	public FireController(Position position, int whichPlayer){
		this.whichPlayer = whichPlayer;
		this.position = position;
	}
	
	@Override
	public void run() {
		while(true){
			if(fireInput==true ){
				fire.add(new Fire(position, this.whichPlayer));
				fireCount++;
				fireInput = false;
			}
			fireLoop(fire);
			pauser();
		}
	}
	
	private void fireLoop(ArrayList<Fire> fire) {
		for(int i=0;i<fireCount;i++){
			fire.get(i).pullTheTriger();
		}
	}
	
	private void pauser() {
		try {
			sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
}
