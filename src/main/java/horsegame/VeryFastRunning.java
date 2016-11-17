package horsegame;

import javax.swing.JLabel;

public class VeryFastRunning implements RunningStrategy {

	public void run(Horse horse) {
		horse.setLocation(horse.getX() + 11, horse.getY());
	}
	
	public String getName() {
		return "VeryFastRunning";
	}
}
