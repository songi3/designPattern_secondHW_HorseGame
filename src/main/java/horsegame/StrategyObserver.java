package horsegame;

import java.util.Observable;
import java.util.Observer;

public class StrategyObserver implements horsegame.Observer {

	private Horse horse;

	public StrategyObserver(Horse horse) {
		this.horse = horse;
		System.out.println("observer create");
	}

	public void displayStrategy() {
		System.out.println(horse.getName() + " Strategy : " + horse.getRunningStrategy().getName());
	}

	@Override
	public void update() {
		displayStrategy();
	}

}
