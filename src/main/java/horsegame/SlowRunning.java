package horsegame;

public class SlowRunning extends RunningStrategy {

	@Override
	public void run(Horse horse) {
		
		setPos(horse.getX(),horse.getY());
		horse.setLocation(xPos+3, yPos);

	}

}
