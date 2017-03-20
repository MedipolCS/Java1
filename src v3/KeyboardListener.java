import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

	public class KeyboardListener implements KeyListener{
		private boolean WASD_Fire=false;
		private boolean Arrow_Fire=false;
		
		@Override
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
			    			Arrow_Fire=true;
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
							WASD_Fire=true;
							break;	
							
		    	default: 	break;
		    }
		}

		@Override
		public void keyTyped(KeyEvent e) {
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			    switch(e.getKeyCode()){
				    //Player 1
			    	case KeyEvent.VK_NUMPAD3:
			    				if(Arrow_Fire==true){
			    					Window.f1.fireInput = true;
			    					Arrow_Fire=false;
			    				}
			    				break;		
			    				
					//Player 2
					case KeyEvent.VK_V: 
								if(WASD_Fire==true){
									Window.f2.fireInput = true;
									WASD_Fire=false;
								}
								break;	
			    	default: 	break;  
			    }
		}
}
