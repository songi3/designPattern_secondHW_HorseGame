package horsegame;

import javax.swing.JLabel;


public class FastRunning extends RunningStrategy {

	public void run(Horse horse) {
		
		setPos(horse.getX(),horse.getY());
		horse.setLocation(xPos+5, yPos);

	}

}
