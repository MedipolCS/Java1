import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class AI extends Thread{
	Robot robot;
	Random random;
	int key;
	ArrayList<Integer> keyBindings = new ArrayList<>();
	private int gameSpeed = 100;
	
	public AI(){
		random = new Random();
		keyBindings.add(KeyEvent.VK_UP);
		keyBindings.add(KeyEvent.VK_LEFT);
		keyBindings.add(KeyEvent.VK_RIGHT);
		keyBindings.add(KeyEvent.VK_DOWN);
		keyBindings.add(KeyEvent.VK_NUMPAD3);
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void run() {
		while(true){
			int keyEvent = keyBindings.get(random.nextInt(5));
			robot.keyPress(keyEvent);
			pause();
		}
	}

	private void pause() {
		try {
			sleep(gameSpeed);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
