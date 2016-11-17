package horsegame;

public class SlowRunning implements RunningStrategy {

	public void run(Horse horse) {
		horse.setLocation(horse.getX() + 6, horse.getY());
	}

	public String getName() {
		return "SlowRunning";
	}
}
