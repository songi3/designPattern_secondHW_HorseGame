package horsegame;

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
					winnerPaenl = new WinnerPanel(Winner);
					horsePanel.centerPanel.remove();
					horsePanel.centerPanel.setPanel(winnerPaenl);
					this.interrupt();
				}
			}
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				for (int i = 0; i < horsePanel.getHorseNumber(); i++) {
					System.out.println(horses.get(i).getName() + " : stop " + "----------------");
					horses.get(i).stop();
				}

				return;
			}

		}

	}
}
