import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

	public class KeyboardListener extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			    switch(e.getKeyCode()){
			    //Player 1
		    	case KeyEvent.VK_RIGHT:	 
		    				ThreadController.movementInput = 1;
		    			  	break;
		    			  	
		    	case KeyEvent.VK_UP:
		    				ThreadController.movementInput = 3;
		    				break;
		    				
		    	case KeyEvent.VK_LEFT: 
		    				ThreadController.movementInput = 2;
		    				break;
		    	
		    	case KeyEvent.VK_DOWN:
		    				ThreadController.movementInput = 4;
    						break;
		    	case KeyEvent.VK_NUMPAD3:
    						ThreadController.movementInput = 5;
    						break;			
    			//Player 2
				case KeyEvent.VK_W:
							ThreadController.movementInput2 = 3;
							break;
				case KeyEvent.VK_A:	 
							ThreadController.movementInput2 = 2;
				  			break;
				case KeyEvent.VK_D:
							ThreadController.movementInput2 = 1;
							break;
				case KeyEvent.VK_S: 
							ThreadController.movementInput2 = 4;
							break;
				case KeyEvent.VK_V: 
					ThreadController.movementInput2 = 5;
					break;			
		    	default: 	break;
			    }
			}
}
