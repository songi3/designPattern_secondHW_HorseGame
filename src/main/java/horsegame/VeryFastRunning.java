package horsegame;

import javax.swing.JLabel;

public class VeryFastRunning extends RunningStrategy {

	public VeryFastRunning(Horse horse) {
		super(horse);
	}

	public void run() {
		horse.setLocation(horse.getX() + 11, horse.getY());
	}
	
	public String getName() {
		return "VeryFastRunning";
	}

	@Override
	public void downEnergy() {
		horse.setEnergy(horse.getEnergy()-20);
	}
}
