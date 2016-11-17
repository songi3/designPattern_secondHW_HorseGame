package horsegame;

public class EnergyObserver implements Observer {

	private Horse horse;

	public EnergyObserver(Horse horse) {
		this.horse = horse;
		System.out.println("observer create");
	}

	public void displayStrategy() {
		System.out.println(horse.getName() + " Energy : " + horse.getEnergy());
	}
	
	@Override
	public void update() {
		horse.getRunningStrategy().downEnergy();
		displayStrategy();

	}

}
