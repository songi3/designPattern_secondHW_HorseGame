package horsegame;

public class FastRunning extends RunningStrategy {

	public FastRunning(Horse horse) {
		super(horse);
	}

	public void init(){
		this.interval = 10;
	}

}
