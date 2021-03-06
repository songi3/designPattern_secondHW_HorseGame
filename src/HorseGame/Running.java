package HorseGame;

import javax.swing.ImageIcon;

public class Running extends Thread {
	Horse horse;

	public Running(Horse horse) {
		this.horse = horse;
	}

	public void run() {

		while (!Thread.currentThread().isInterrupted()) {

			horse.getRunningStrategy().run();

			try {
				Thread.sleep(150);
			}

			catch (InterruptedException e) {
				horse.getEnergyLabel().setVisible(false);
				horse.getHorseLabel().setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/" + horse.getName() + "_ready.gif")));
				return;
			}
		}

	}
}
