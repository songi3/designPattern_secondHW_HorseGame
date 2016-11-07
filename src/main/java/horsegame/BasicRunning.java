package horsegame;

public class BasicRunning extends RunningStrategy {

	public BasicRunning(Horse horse) {
		super(horse);
	}

	public void init() {
		this.interval = 7;
	}

}
