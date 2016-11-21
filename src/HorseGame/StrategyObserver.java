package HorseGame;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

public class StrategyObserver implements HorseGame.Observer {

	private Horse horse;
	private HorsePanel horsePanel;
	
	public StrategyObserver(Horse horse,HorsePanel horsePanel) {
		this.horse = horse;
		this.horsePanel = horsePanel;
	}

	public void displayStrategy() {
		
		JLabel [] strategyLabel = horsePanel.getStrategyLabel();
		
		if(horse.getName().equals("horse0"))
			strategyLabel[0].setText(horse.getRunningStrategy().getName());		
		else if(horse.getName().equals("horse1"))
			strategyLabel[1].setText(horse.getRunningStrategy().getName());
		else if(horse.getName().equals("horse2"))
			strategyLabel[2].setText(horse.getRunningStrategy().getName());
		
		horsePanel.setStrategyLabel(strategyLabel);
		
	}

	@Override
	public void update() {
		displayStrategy();
	}

}
