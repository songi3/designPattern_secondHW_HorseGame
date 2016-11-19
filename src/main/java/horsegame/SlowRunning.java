package horsegame;

public class SlowRunning extends RunningStrategy {
	
	public SlowRunning(Horse horse) {
		super(horse);
	}

	public void run() {
		horse.setLocation(horse.getX() + 6, horse.getY());
	}

	public String getName() {
		return "SlowRunning";
	}

	public void downEnergy() {
		horse.setEnergy(horse.getEnergy()-3);
	}
	
	@Override
	public void changeHeartBeat() {
		horse.setHeartBeat(60);
	}
	
}
