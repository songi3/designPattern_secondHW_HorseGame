package horsegame;

import javax.swing.JLabel;


public class VeryFastRunning extends RunningStrategy {

	public VeryFastRunning(Horse horse) {
		super(horse);
	}

	public void init(){
		this.interval = 20;
	}
	

}
