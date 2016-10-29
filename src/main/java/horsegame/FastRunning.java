package horsegame;

import javax.swing.JLabel;


public class FastRunning extends RunningStrategy {

	public void run(Horse horse) {
		int x;
		int y;
		
		x= horse.getX();
		y= horse.getY();
		
		horse.setLocation(x+5, y);
		
		

	}

}
