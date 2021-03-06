package HorseGame;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class EnergyObserver implements Observer {

	private Horse horse;
	private HorsePanel horsePanel;

	public EnergyObserver(Horse horse,HorsePanel horsePanel) {
		this.horse = horse;
		this.horsePanel = horsePanel;
	}

	public void displayStrategy() {
	
		JLabel[] energyLabel = horsePanel.getEnergyBar();
		JLabel energy = null;

		int number = -1;

		for (int i = 0; i < horsePanel.getHorseNumber(); i++) {
			if (horse.getName().equals("horse" + i)) {
				energy = energyLabel[i];
				number = i;
			}
		}

		if (horse.getEnergy() >= 80)
			energy.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/energy_high.png")));
		else if (horse.getEnergy() >= 60)
			energy.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/energy_middle.png")));
		else if (horse.getEnergy() >= 30)
			energy.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/energy_low.png")));

		energyLabel[number] = energy;
		horsePanel.setEnergyBar(energyLabel);
	}

	@Override
	public void update() {
		horse.getRunningStrategy().downEnergy();
		displayStrategy();

	}

}
