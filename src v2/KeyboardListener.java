import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

	public class KeyboardListener extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			    switch(e.getKeyCode()){
			    //Player 1
		    	case KeyEvent.VK_RIGHT:	 
		    				Window.t1.movementInput = 1;
		    			  	break;
		    			  	
		    	case KeyEvent.VK_LEFT: 
    						Window.t1.movementInput = 2;
    						break;
    				
		    	case KeyEvent.VK_UP:
		    				Window.t1.movementInput = 3;
		    				break;
		    				
		    	case KeyEvent.VK_DOWN:
		    				Window.t1.movementInput = 4;
    						break;
    						
		    	case KeyEvent.VK_NUMPAD3:
		    				Window.t1.movementInput = 5;
    						break;		
    						
    			//Player 2
		    	case KeyEvent.VK_D:
							Window.t2.movementInput = 1;
							break;
							
		    	case KeyEvent.VK_A:	 
							Window.t2.movementInput = 2;
				  			break;	
				  			
				case KeyEvent.VK_W:
							Window.t2.movementInput = 3;
							break;
							
				case KeyEvent.VK_S: 
							Window.t2.movementInput = 4;
							break;
							
				case KeyEvent.VK_V: 
							Window.t2.movementInput = 5;
							break;	
							
		    	default: 	break;
			    }
			}
}
