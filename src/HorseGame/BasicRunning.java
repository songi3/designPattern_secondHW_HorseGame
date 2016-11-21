package HorseGame;

public class BasicRunning extends RunningStrategy {

	public BasicRunning(Horse horse) {
		super(horse);
	}

	public void run() {
		horse.setLocation(horse.getX() + 10, horse.getY());
	}
	
	public String getName() {
		return "Basic";
	}

	@Override
	public void downEnergy() {
		horse.setEnergy(horse.getEnergy()-5);
	}

	@Override
	public void changeHeartBeat() {
		horse.setHeartBeat(80);
	}
}
