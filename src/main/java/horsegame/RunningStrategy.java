package horsegame;

public abstract class RunningStrategy {

	protected Horse horse;

	public RunningStrategy(Horse horse) {
		super();
		this.horse = horse;
	}

	public abstract String getName();

	public abstract void run();

	public abstract void downEnergy();
	
	public abstract void changeHeartBeat();
}
