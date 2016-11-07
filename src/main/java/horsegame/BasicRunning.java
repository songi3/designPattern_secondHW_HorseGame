package horsegame;

public class BasicRunning implements RunningStrategy {

	public void run(Horse horse) {
		horse.setLocation(horse.getX() + 7, horse.getY());
	}
}
