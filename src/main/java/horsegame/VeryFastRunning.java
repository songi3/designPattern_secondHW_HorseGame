package horsegame;

import javax.swing.JLabel;

public class VeryFastRunning extends RunningStrategy {

	public VeryFastRunning(Horse horse) {
		super(horse);
	}

	public void run() {
		horse.setLocation(horse.getX() + 15, horse.getY());
	}
	
	public String getName() {
		return "VeryFast";
	}

	@Override
	public void downEnergy() {
		horse.setEnergy(horse.getEnergy()-20);
	}
	
	@Override
	public void changeHeartBeat() {
		horse.setHeartBeat(130);
	}
	
}
