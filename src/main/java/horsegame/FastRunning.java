package horsegame;

public class FastRunning implements RunningStrategy  {

	public void run(Horse horse) {
		horse.setLocation(horse.getX() + 9, horse.getY());
	}
	
	public String getName() {
		return "FastRunning";
	}
}
