package horsegame;

import javax.swing.JLabel;


public class BestFastRunning extends RunningStrategy {

	public BestFastRunning(Horse horse) {
		super(horse);
	}

	public void init(){
		this.interval = 20;
	}
	

}
