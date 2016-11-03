package horsegame;

public class SlowRunning extends RunningStrategy {

	public SlowRunning(Horse horse) {
		super(horse);
	}

	public void init(){
		this.interval = 3;
	}



}
