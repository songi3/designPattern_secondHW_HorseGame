package horsegame;

import javax.swing.JLabel;

public abstract class RunningStrategy {

	protected Horse horse;
	protected int interval;
	
	public RunningStrategy(Horse horse) {
		super();
		this.horse = horse;
	}

	public abstract void init();
	public void run(){
		init();
		horse.setLocation(horse.getX() + interval, horse.getY());
	}

}
