import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class AI extends Thread{
	public boolean aiLoop;
	Robot robot;
	Random random;
	int key;
	ArrayList<Integer> keyBindings = new ArrayList<>();
	private int gameSpeed = 100;
	
	public AI(){
		this.aiLoop=true;
		random = new Random();
		keyBindings.add(KeyEvent.VK_UP);
		keyBindings.add(KeyEvent.VK_LEFT);
		keyBindings.add(KeyEvent.VK_RIGHT);
		keyBindings.add(KeyEvent.VK_DOWN);
		keyBindings.add(KeyEvent.VK_NUMPAD3);
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void run() {
		while(aiLoop){
			int keyEvent = keyBindings.get(random.nextInt(5));
			robot.keyPress(keyEvent);
			robot.keyRelease(keyEvent);
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
