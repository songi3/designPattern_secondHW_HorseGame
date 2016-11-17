package horsegame;

public class BasicRunning extends RunningStrategy {

	public BasicRunning(Horse horse) {
		super(horse);
	}

	public void run() {
		horse.setLocation(horse.getX() + 7, horse.getY());
	}
	
	public String getName() {
		return "BasicRunning";
	}

	@Override
	public void downEnergy() {
		horse.setEnergy(horse.getEnergy()-5);
	}
}
