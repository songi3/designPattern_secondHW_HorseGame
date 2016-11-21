package HorseGame;

import java.util.ArrayList;

import javax.swing.JPanel;

public class StopLogic extends Thread {
	ArrayList<Horse> horses;
	HorsePanel horsePanel;
	Horse Winner;
	WinnerPanel winnerPaenl;
	final int endLine = 795;

	public StopLogic(HorsePanel horsePanel) {
		this.horsePanel = horsePanel;
		horses = horsePanel.getHorses();
	}

	public void run() {
		while (true) {
			for (int i = 0; i < horsePanel.getHorseNumber(); i++) {
				if (horses.get(i).getX() >= endLine) {
					Winner = horses.get(i);
					winnerPaenl = new WinnerPanel(Winner, horsePanel);
					this.interrupt();
				}
			}
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				for (int i = 0; i < horsePanel.getHorseNumber(); i++) {
					horses.get(i).stop();
				}

				return;
			}
		}
	}
}
