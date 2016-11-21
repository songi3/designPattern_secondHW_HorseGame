package HorseGame;

public class FastRunning extends RunningStrategy  {
	
	public FastRunning(Horse horse) {
		super(horse);
	}

	public void run() {
		horse.setLocation(horse.getX() + 12, horse.getY());
	}
	
	public String getName() {
		return "Fast";
	}

	@Override
	public void downEnergy() {
		horse.setEnergy(horse.getEnergy()-10);
	}

	@Override
	public void changeHeartBeat() {
		horse.setHeartBeat(100);
	}
	
	

}
