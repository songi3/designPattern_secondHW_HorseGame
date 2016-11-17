package horsegame;

public class FastRunning extends RunningStrategy  {
	
	public FastRunning(Horse horse) {
		super(horse);
	}

	public void run() {
		horse.setLocation(horse.getX() + 9, horse.getY());
	}
	
	public String getName() {
		return "FastRunning";
	}

	@Override
	public void downEnergy() {
		horse.setEnergy(horse.getEnergy()-10);
	}

}
